package com.example;

import android.app.Application;
import android.util.Log;
import com.example.health.AppHealthManager;
import com.example.reminder.ReminderNotificationHelper;
import com.example.reminder.VoiceAlertManager;
import com.example.ui.profile.UserProfileManager;
import java.lang.Thread;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DailyLifeApplication.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/example/DailyLifeApplication;", "Landroid/app/Application;", "<init>", "()V", "onCreate", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes11.dex */
public final class DailyLifeApplication extends Application {
    public static final int $stable = 8;

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        UserProfileManager.init(this);
        try {
            ReminderNotificationHelper.INSTANCE.createNotificationChannel(this);
            VoiceAlertManager.INSTANCE.getInstance(this);
        } catch (Exception e) {
            Log.e("DailyLifeApplication", "Notification channel or VoiceAlertManager creation error: " + e.getMessage());
        }
        final Thread.UncaughtExceptionHandler defaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.example.DailyLifeApplication$$ExternalSyntheticLambda0
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(Thread thread, Throwable th) {
                DailyLifeApplication.onCreate$lambda$0(DailyLifeApplication.this, defaultHandler, thread, th);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void onCreate$lambda$0(DailyLifeApplication this$0, Thread.UncaughtExceptionHandler $defaultHandler, Thread thread, Throwable throwable) {
        Log.e("DailyLifeApplication", "Global uncaught exception on thread " + thread.getName() + ": " + throwable.getMessage(), throwable);
        try {
            AppHealthManager healthManager = AppHealthManager.INSTANCE.getInstance(this$0);
            String simpleName = throwable.getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
            healthManager.recordDiagnosticLog("System Crash Protection", simpleName, "Thread: " + thread.getName(), "Captured exception safely to prevent silent crash", "Logged diagnostics safely", true);
        } catch (Exception e) {
            Log.e("DailyLifeApplication", "Failed to record crash in health manager: " + e.getMessage());
        }
        if ($defaultHandler != null) {
            $defaultHandler.uncaughtException(thread, throwable);
        }
    }
}
