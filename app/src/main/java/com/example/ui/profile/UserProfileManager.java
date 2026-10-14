package com.example.ui.profile;

/* JADX INFO: loaded from: classes11.dex */
public class UserProfileManager {
    private static final java.lang.String ALT_KEY_PHOTO_PATH = "profile_photo_path";
    private static final java.lang.String ALT_KEY_USER_EMAIL = "profile_user_email";
    private static final java.lang.String ALT_KEY_USER_NAME = "profile_user_name";
    public static final java.lang.String DEFAULT_EMAIL = "hafizsabir1226@gmail.com";
    public static final java.lang.String DEFAULT_NAME = "Hafiz Sabir (حافظ صابر)";
    public static final java.lang.String KEY_PHOTO_PATH = "key_profile_photo_path";
    public static final java.lang.String KEY_USER_EMAIL = "key_user_email";
    public static final java.lang.String KEY_USER_NAME = "key_user_name";
    private static final java.lang.String PHOTO_FILE_NAME = "user_profile_photo.jpg";
    public static final java.lang.String PREF_NAME = "user_profile_prefs";
    private static final java.lang.String TAG = "UserProfileManager";
    private static java.lang.String sUserName = null;
    private static java.lang.String sUserEmail = null;
    private static java.lang.String sPhotoPath = null;
    private static android.graphics.Bitmap sCachedBitmap = null;
    private static java.lang.Object sPhotoLauncher = null;
    private static java.lang.Object sProfileVersionState = null;
    private static java.lang.Object sViewModel = null;
    private static android.content.Context sAppContext = null;
    private static android.content.Context sActivityContext = null;
    private static java.lang.ref.WeakReference<android.app.Activity> sActivityRef = null;
    private static boolean sInitialized = false;
    private static boolean sLifecycleRegistered = false;
    private static java.lang.reflect.Method sClickableDefaultMethod = null;

    private static java.lang.reflect.Method getClickableDefaultMethod() {
        if (sClickableDefaultMethod != null) {
            return sClickableDefaultMethod;
        }
        try {
            for (java.lang.reflect.Method method : java.lang.Class.forName("androidx.compose.foundation.ClickableKt").getMethods()) {
                if (method.getName().startsWith("clickable") && method.getName().endsWith("$default")) {
                    java.lang.Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length == 7 && parameterTypes[0] == androidx.compose.ui.Modifier.class && parameterTypes[4] == kotlin.jvm.functions.Function0.class) {
                        sClickableDefaultMethod = method;
                        return method;
                    }
                }
            }
            return null;
        } catch (java.lang.Throwable th) {
            android.util.Log.e(TAG, "Error resolving ClickableKt.clickable$default", th);
            return null;
        }
    }

    public static void setActivity(android.app.Activity activity) {
        if (activity != null) {
            sActivityRef = new java.lang.ref.WeakReference<>(activity);
            sActivityContext = activity;
            android.content.Context applicationContext = activity.getApplicationContext();
            if (applicationContext != null) {
                sAppContext = applicationContext;
                registerLifecycleCallbacksIfNeeded(applicationContext);
            }
        }
    }

    private static android.app.Activity unwrapActivity(android.content.Context context) {
        android.content.Context baseContext;
        int i = 0;
        while (context != null && i < 15) {
            if (context instanceof android.app.Activity) {
                return (android.app.Activity) context;
            }
            if ((context instanceof android.content.ContextWrapper) && (baseContext = ((android.content.ContextWrapper) context).getBaseContext()) != context) {
                i++;
                context = baseContext;
            } else {
                return null;
            }
        }
        return null;
    }

    private static synchronized void registerLifecycleCallbacksIfNeeded(android.content.Context context) {
        if (!sLifecycleRegistered && context != null) {
            android.content.Context applicationContext = context.getApplicationContext();
            if (applicationContext instanceof android.app.Application) {
                context = applicationContext;
            } else if (!(context instanceof android.app.Application)) {
                return;
            }
            try {
                ((android.app.Application) context).registerActivityLifecycleCallbacks(new android.app.Application.ActivityLifecycleCallbacks() { // from class: com.example.ui.profile.UserProfileManager.1
                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
                        com.example.ui.profile.UserProfileManager.setActivity(activity);
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStarted(android.app.Activity activity) {
                        com.example.ui.profile.UserProfileManager.setActivity(activity);
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityResumed(android.app.Activity activity) {
                        com.example.ui.profile.UserProfileManager.setActivity(activity);
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPaused(android.app.Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStopped(android.app.Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityDestroyed(android.app.Activity activity) {
                    }
                });
                sLifecycleRegistered = true;
            } catch (java.lang.Throwable th) {
                android.util.Log.e(TAG, "Failed to register lifecycle callbacks", th);
            }
        }
    }

    public static void setAppContext(android.content.Context context) {
        if (context != null) {
            android.app.Activity activityUnwrapActivity = unwrapActivity(context);
            if (activityUnwrapActivity != null) {
                setActivity(activityUnwrapActivity);
                return;
            }
            android.content.Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            sAppContext = context;
            registerLifecycleCallbacksIfNeeded(sAppContext);
        }
    }

    public static android.content.Context getAppContext() {
        if (sAppContext != null) {
            return sAppContext;
        }
        android.app.Activity activityFindActivity = findActivity(null);
        if (activityFindActivity != null) {
            return activityFindActivity.getApplicationContext();
        }
        if (sActivityContext != null) {
            return sActivityContext.getApplicationContext();
        }
        return null;
    }

    public static android.content.Context getActivityContext() {
        android.app.Activity activityFindActivity = findActivity(null);
        if (activityFindActivity != null) {
            return activityFindActivity;
        }
        return sActivityContext != null ? sActivityContext : sAppContext;
    }

    public static android.app.Activity findActivity(android.content.Context context) {
        android.app.Activity activity;
        android.app.Activity activityUnwrapActivity = unwrapActivity(context);
        if (activityUnwrapActivity != null && !activityUnwrapActivity.isFinishing() && !activityUnwrapActivity.isDestroyed()) {
            return activityUnwrapActivity;
        }
        if (sActivityRef != null && (activity = sActivityRef.get()) != null && !activity.isFinishing() && !activity.isDestroyed()) {
            return activity;
        }
        android.app.Activity activityUnwrapActivity2 = unwrapActivity(sActivityContext);
        if (activityUnwrapActivity2 != null && !activityUnwrapActivity2.isFinishing() && !activityUnwrapActivity2.isDestroyed()) {
            return activityUnwrapActivity2;
        }
        android.app.Activity activityFromActivityThread = getActivityFromActivityThread();
        if (activityFromActivityThread != null && !activityFromActivityThread.isFinishing() && !activityFromActivityThread.isDestroyed()) {
            setActivity(activityFromActivityThread);
            return activityFromActivityThread;
        }
        return null;
    }

    private static android.app.Activity getActivityFromActivityThread() {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.app.ActivityThread");
            java.lang.Object objInvoke = cls.getMethod("currentActivityThread", new java.lang.Class[0]).invoke(null, new java.lang.Object[0]);
            java.lang.reflect.Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            java.util.Map map = (java.util.Map) declaredField.get(objInvoke);
            if (map == null) {
                return null;
            }
            android.app.Activity activity = null;
            for (java.lang.Object obj : map.values()) {
                if (obj != null) {
                    java.lang.Class<?> cls2 = obj.getClass();
                    java.lang.reflect.Field declaredField2 = cls2.getDeclaredField("activity");
                    declaredField2.setAccessible(true);
                    android.app.Activity activity2 = (android.app.Activity) declaredField2.get(obj);
                    if (activity2 != null && !activity2.isFinishing() && !activity2.isDestroyed()) {
                        java.lang.reflect.Field declaredField3 = cls2.getDeclaredField("paused");
                        declaredField3.setAccessible(true);
                        if (!declaredField3.getBoolean(obj)) {
                            return activity2;
                        }
                        activity = activity2;
                    }
                }
            }
            return activity;
        } catch (java.lang.Throwable th) {
            return null;
        }
    }

    public static void setViewModel(java.lang.Object obj) {
        sViewModel = obj;
        if (obj != null && sInitialized) {
            notifyProfileChanged();
        }
    }

    public static void setPhotoLauncher(java.lang.Object obj) {
        sPhotoLauncher = obj;
    }

    public static void setProfileVersionState(java.lang.Object obj) {
        sProfileVersionState = obj;
    }

    public static java.lang.Object getOrCreateProfileVersion() {
        if (sProfileVersionState == null) {
            try {
                java.lang.Class<?> cls = java.lang.Class.forName("androidx.compose.runtime.SnapshotStateKt");
                for (java.lang.reflect.Method method : cls.getMethods()) {
                    if (method.getName().equals("mutableStateOf$default") && method.getParameterTypes().length == 4) {
                        sProfileVersionState = method.invoke(null, 0L, null, 2, null);
                        break;
                    }
                }
                if (sProfileVersionState == null) {
                    for (java.lang.reflect.Method method2 : cls.getMethods()) {
                        if (method2.getName().equals("mutableStateOf") && method2.getParameterTypes().length == 2) {
                            sProfileVersionState = method2.invoke(null, 0L, cls.getMethod("structuralEqualityPolicy", new java.lang.Class[0]).invoke(null, new java.lang.Object[0]));
                            break;
                        }
                    }
                }
            } catch (java.lang.Throwable th) {
                android.util.Log.e(TAG, "Error creating profileVersionState", th);
            }
        }
        return sProfileVersionState;
    }

    public static synchronized void init(android.content.Context context) {
        if (context != null) {
            try {
                setAppContext(context);
            } catch (java.lang.Throwable th) { android.util.Log.e(TAG, "Error", th); }
        }
        android.content.Context appContext = getAppContext();
        if (appContext != null) {
            context = appContext;
        }
        if (context == null) {
            return;
        }
        try {
            android.content.SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, 0);
            java.lang.String string = sharedPreferences.getString(KEY_USER_NAME, null);
            if (string == null || string.trim().isEmpty()) {
                string = sharedPreferences.getString(ALT_KEY_USER_NAME, DEFAULT_NAME);
            }
            sUserName = (string == null || string.trim().isEmpty()) ? DEFAULT_NAME : string.trim();
            java.lang.String string2 = sharedPreferences.getString(KEY_USER_EMAIL, null);
            if (string2 == null || string2.trim().isEmpty()) {
                string2 = sharedPreferences.getString(ALT_KEY_USER_EMAIL, DEFAULT_EMAIL);
            }
            sUserEmail = (string2 == null || string2.trim().isEmpty()) ? DEFAULT_EMAIL : string2.trim();
            java.lang.String string3 = sharedPreferences.getString(KEY_PHOTO_PATH, null);
            if (string3 == null || string3.trim().isEmpty()) {
                string3 = sharedPreferences.getString(ALT_KEY_PHOTO_PATH, null);
            }
            if (string3 != null && new java.io.File(string3).exists()) {
                sPhotoPath = string3;
            } else {
                java.io.File file = new java.io.File(context.getFilesDir(), PHOTO_FILE_NAME);
                sPhotoPath = file.exists() ? file.getAbsolutePath() : null;
            }
            sInitialized = true;
        } catch (java.lang.Throwable th2) {
            android.util.Log.e(TAG, "Error initializing UserProfileManager", th2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0010 A[Catch: all -> 0x0026, TryCatch #0 {, blocks: (B:5:0x0005, B:6:0x0008, B:8:0x000c, B:11:0x0013, B:13:0x0017, B:15:0x001f, B:10:0x0010), top: B:22:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:16:0x0022  */
    public static synchronized java.lang.String getUserName(android.content.Context context) {
        java.lang.String str;
        if (context != null) {
            setAppContext(context);
            if (sInitialized || sUserName == null) {
                init(context);
            }
            if (sUserName != null || sUserName.isEmpty()) {
                str = DEFAULT_NAME;
            } else {
                str = sUserName;
            }
        } else {
            if (sInitialized) {
                init(context);
            } else {
                init(context);
            }
            if (sUserName != null) {
                str = DEFAULT_NAME;
            } else {
                str = DEFAULT_NAME;
            }
        }
        return str;
    }

    public static synchronized void setUserName(android.content.Context context, java.lang.String str) {
        if (context != null) {
            try {
                setAppContext(context);
            } catch (java.lang.Throwable th) { android.util.Log.e(TAG, "Error", th); }
        }
        if (str == null || str.trim().isEmpty()) {
            str = DEFAULT_NAME;
        }
        sUserName = str.trim();
        android.content.Context appContext = getAppContext();
        if (appContext != null) {
            try {
                appContext.getSharedPreferences(PREF_NAME, 0).edit().putString(KEY_USER_NAME, sUserName).putString(ALT_KEY_USER_NAME, sUserName).commit();
            } catch (java.lang.Throwable th2) {
                android.util.Log.e(TAG, "Error saving user name", th2);
            }
        }
        notifyProfileChanged();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0010 A[Catch: all -> 0x0026, TryCatch #0 {, blocks: (B:5:0x0005, B:6:0x0008, B:8:0x000c, B:11:0x0013, B:13:0x0017, B:15:0x001f, B:10:0x0010), top: B:22:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:16:0x0022  */
    public static synchronized java.lang.String getUserEmail(android.content.Context context) {
        java.lang.String str;
        if (context != null) {
            setAppContext(context);
            if (sInitialized || sUserEmail == null) {
                init(context);
            }
            if (sUserEmail != null || sUserEmail.isEmpty()) {
                str = DEFAULT_EMAIL;
            } else {
                str = sUserEmail;
            }
        } else {
            if (sInitialized) {
                init(context);
            } else {
                init(context);
            }
            if (sUserEmail != null) {
                str = DEFAULT_EMAIL;
            } else {
                str = DEFAULT_EMAIL;
            }
        }
        return str;
    }

    public static synchronized void setUserEmail(android.content.Context context, java.lang.String str) {
        if (context != null) {
            try {
                setAppContext(context);
            } catch (java.lang.Throwable th) { android.util.Log.e(TAG, "Error", th); }
        }
        if (str == null || str.trim().isEmpty()) {
            str = DEFAULT_EMAIL;
        }
        sUserEmail = str.trim();
        android.content.Context appContext = getAppContext();
        if (appContext != null) {
            try {
                appContext.getSharedPreferences(PREF_NAME, 0).edit().putString(KEY_USER_EMAIL, sUserEmail).putString(ALT_KEY_USER_EMAIL, sUserEmail).commit();
            } catch (java.lang.Throwable th2) {
                android.util.Log.e(TAG, "Error saving user email", th2);
            }
        }
        notifyProfileChanged();
    }

    /* JADX WARN: Code duplicated, block: B:8:0x000c A[Catch: all -> 0x0027, TryCatch #0 {, blocks: (B:5:0x0005, B:6:0x0008, B:8:0x000c, B:9:0x000f, B:11:0x0013, B:13:0x0020), top: B:22:0x0005 }] */
    public static synchronized java.lang.String getProfilePhotoPath(android.content.Context context) {
        if (context != null) {
            setAppContext(context);
            if (!sInitialized) {
                init(context);
            }
            if (sPhotoPath != null || !new java.io.File(sPhotoPath).exists()) {
                return null;
            }
            return sPhotoPath;
        }
        if (!sInitialized) {
            init(context);
        }
        if (sPhotoPath != null) {
        }
        return null;
        // throw th removed
    }

    /* JADX WARN: Code duplicated, block: B:9:0x000f  */
    public static synchronized java.lang.String saveProfilePhoto(android.content.Context context, android.net.Uri uri) {
        android.content.Context appContext;
        java.io.InputStream inputStreamOpenInputStream;
        java.io.FileOutputStream fileOutputStream;
        if (context == null) {
            appContext = getAppContext();
            if (appContext != null) {
                context = appContext;
            }
            if (context != null) {
            }
            return null;
        }
        setAppContext(context);
        appContext = getAppContext();
        if (appContext != null) {
            context = appContext;
        }
        if (context != null || uri == null) {
            return null;
        }
        try {
            java.io.File file = new java.io.File(context.getFilesDir(), PHOTO_FILE_NAME);
            inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream == null) {
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (java.lang.Exception e) {
                    }
                }
                return null;
            }
            try {
                fileOutputStream = new java.io.FileOutputStream(file);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i = inputStreamOpenInputStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, i);
                    }
                    fileOutputStream.flush();
                    sPhotoPath = file.getAbsolutePath();
                    sCachedBitmap = null;
                    context.getSharedPreferences(PREF_NAME, 0).edit().putString(KEY_PHOTO_PATH, sPhotoPath).putString(ALT_KEY_PHOTO_PATH, sPhotoPath).commit();
                    notifyProfileChanged();
                    java.lang.String str = sPhotoPath;
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (java.lang.Exception e2) {
                        }
                    }
                    try {
                        fileOutputStream.close();
                    } catch (java.lang.Exception e3) {
                    }
                    return str;
                } catch (java.lang.Throwable th) {
                    // th assigned
                    try {
                        android.util.Log.e(TAG, "Error saving profile photo from uri", th);
                        if (inputStreamOpenInputStream != null) {
                            try {
                                inputStreamOpenInputStream.close();
                            } catch (java.lang.Exception e4) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (java.lang.Exception e5) {
                            }
                        }
                        return null;
                    } catch (java.lang.Throwable th2) {
                        if (inputStreamOpenInputStream != null) {
                            try {
                                inputStreamOpenInputStream.close();
                            } catch (java.lang.Exception e6) {
                            }
                        }
                        if (fileOutputStream == null) {
                            throw th2;
                        }
                        try {
                            fileOutputStream.close();
                            throw th2;
                        } catch (java.lang.Exception e7) {
                            throw th2;
                        }
                    }
                }
            } catch (java.lang.Throwable th3) {
                // th assigned
                fileOutputStream = null;
            }
        } catch (java.lang.Throwable th4) {
            // th assigned
            inputStreamOpenInputStream = null;
            fileOutputStream = null;
        }
        return sPhotoPath;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0024 A[Catch: all -> 0x0042, TryCatch #1 {all -> 0x0042, blocks: (B:8:0x0013, B:10:0x0024, B:11:0x0027), top: B:24:0x0013, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x0013 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static synchronized boolean removeProfilePhoto(android.content.Context context) {
        android.content.Context appContext;
        java.io.File file;
        if (context != null) {
            setAppContext(context);
            sPhotoPath = null;
            sCachedBitmap = null;
            appContext = getAppContext();
            if (appContext != null) {
                try {
                    file = new java.io.File(appContext.getFilesDir(), PHOTO_FILE_NAME);
                    if (file.exists()) {
                        file.delete();
                    }
                    appContext.getSharedPreferences(PREF_NAME, 0).edit().remove(KEY_PHOTO_PATH).remove(ALT_KEY_PHOTO_PATH).commit();
                } catch (java.lang.Throwable th) {
                    android.util.Log.e(TAG, "Error removing profile photo", th);
                }
            }
            notifyProfileChanged();
        } else {
            sPhotoPath = null;
            sCachedBitmap = null;
            appContext = getAppContext();
            if (appContext != null) {
                file = new java.io.File(appContext.getFilesDir(), PHOTO_FILE_NAME);
                if (file.exists()) {
                    file.delete();
                }
                appContext.getSharedPreferences(PREF_NAME, 0).edit().remove(KEY_PHOTO_PATH).remove(ALT_KEY_PHOTO_PATH).commit();
            }
            notifyProfileChanged();
        }
        return true;
    }

    public static synchronized android.graphics.Bitmap loadProfileBitmap(android.content.Context context) {
        if (sCachedBitmap != null && !sCachedBitmap.isRecycled()) {
            return sCachedBitmap;
        }
        java.lang.String profilePhotoPath = getProfilePhotoPath(context);
        if (profilePhotoPath != null) {
            try {
                android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                android.graphics.BitmapFactory.decodeFile(profilePhotoPath, options);
                int i = 1;
                while (java.lang.Math.max(options.outWidth, options.outHeight) / i > 512) {
                    i *= 2;
                }
                int i2 = 0;
                options.inJustDecodeBounds = false;
                options.inSampleSize = i;
                options.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
                android.graphics.Bitmap bitmapDecodeFile = android.graphics.BitmapFactory.decodeFile(profilePhotoPath, options);
                if (bitmapDecodeFile != null) {
                    try {
                        int attributeInt = new android.media.ExifInterface(profilePhotoPath).getAttributeInt("Orientation", 1);
                        if (attributeInt == 6) {
                            i2 = 90;
                        } else if (attributeInt == 3) {
                            i2 = 180;
                        } else if (attributeInt == 8) {
                            i2 = 270;
                        }
                        if (i2 != 0) {
                            android.graphics.Matrix matrix = new android.graphics.Matrix();
                            matrix.postRotate(i2);
                            bitmapDecodeFile = android.graphics.Bitmap.createBitmap(bitmapDecodeFile, 0, 0, bitmapDecodeFile.getWidth(), bitmapDecodeFile.getHeight(), matrix, true);
                        }
                    } catch (java.lang.Throwable th) {
                    }
                    sCachedBitmap = bitmapDecodeFile;
                }
                return sCachedBitmap;
            } catch (java.lang.Throwable th2) {
                android.util.Log.e(TAG, "Error decoding profile bitmap", th2);
            }
        }
        return null;
    }

    public static boolean isUrduLanguage(android.content.Context context) {
        java.lang.Object objInvoke;
        if (sViewModel != null) {
            try {
                java.lang.Object objInvoke2 = sViewModel.getClass().getMethod("getCurrentLanguage", new java.lang.Class[0]).invoke(sViewModel, new java.lang.Object[0]);
                if (objInvoke2 != null && (objInvoke = objInvoke2.getClass().getMethod("getValue", new java.lang.Class[0]).invoke(objInvoke2, new java.lang.Object[0])) != null) {
                    return !"ENGLISH".equalsIgnoreCase(objInvoke.toString());
                }
            } catch (java.lang.Throwable th) {
            }
        }
        if (context == null) {
            context = getAppContext();
        }
        if (context != null) {
            java.lang.String string = context.getSharedPreferences("reminder_prefs", 0).getString("app_language", null);
            if (string != null) {
                return !string.equalsIgnoreCase("ENGLISH");
            }
            try {
                if ("ur".equalsIgnoreCase(context.getResources().getConfiguration().getLocales().get(0).getLanguage())) {
                    return true;
                }
            } catch (java.lang.Throwable th2) {
            }
        }
        return true;
    }

    public static void notifyProfileChanged() {
        java.lang.Runnable runnable = new java.lang.Runnable() { // from class: com.example.ui.profile.UserProfileManager.2
            @Override // java.lang.Runnable
            public void run() {
                if (com.example.ui.profile.UserProfileManager.sProfileVersionState != null) {
                    try {
                        java.lang.Object objInvoke = com.example.ui.profile.UserProfileManager.sProfileVersionState.getClass().getMethod("getValue", new java.lang.Class[0]).invoke(com.example.ui.profile.UserProfileManager.sProfileVersionState, new java.lang.Object[0]);
                        com.example.ui.profile.UserProfileManager.sProfileVersionState.getClass().getMethod("setValue", java.lang.Object.class).invoke(com.example.ui.profile.UserProfileManager.sProfileVersionState, java.lang.Long.valueOf(objInvoke instanceof java.lang.Long ? 1 + ((java.lang.Long) objInvoke).longValue() : 1L));
                    } catch (java.lang.Throwable th) {
                        android.util.Log.e(com.example.ui.profile.UserProfileManager.TAG, "Error updating profileVersionState", th);
                    }
                }
                if (com.example.ui.profile.UserProfileManager.sViewModel != null) {
                    com.example.ui.profile.UserProfileManager.updateStateFlow(com.example.ui.profile.UserProfileManager.sViewModel, "getUserName", "userName", com.example.ui.profile.UserProfileManager.sUserName != null ? com.example.ui.profile.UserProfileManager.sUserName : com.example.ui.profile.UserProfileManager.DEFAULT_NAME);
                    com.example.ui.profile.UserProfileManager.updateStateFlow(com.example.ui.profile.UserProfileManager.sViewModel, "getUserEmail", "userEmail", com.example.ui.profile.UserProfileManager.sUserEmail != null ? com.example.ui.profile.UserProfileManager.sUserEmail : com.example.ui.profile.UserProfileManager.DEFAULT_EMAIL);
                    com.example.ui.profile.UserProfileManager.updateStateFlow(com.example.ui.profile.UserProfileManager.sViewModel, "getProfilePhotoPath", "profilePhotoPath", com.example.ui.profile.UserProfileManager.sPhotoPath);
                }
            }
        };
        if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            runnable.run();
        } else {
            new android.os.Handler(android.os.Looper.getMainLooper()).post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateStateFlow(java.lang.Object obj, java.lang.String str, java.lang.String str2, java.lang.Object obj2) {
        java.lang.Object objInvoke;
        if (obj == null) {
            return;
        }
        try {
            objInvoke = obj.getClass().getMethod(str, new java.lang.Class[0]).invoke(obj, new java.lang.Object[0]);
        } catch (java.lang.Throwable th) {
            try {
                java.lang.reflect.Field declaredField = obj.getClass().getDeclaredField(str2);
                declaredField.setAccessible(true);
                objInvoke = declaredField.get(obj);
            } catch (java.lang.Throwable th2) {
                objInvoke = null;
            }
        }
        if (objInvoke != null) {
            try {
                objInvoke.getClass().getMethod("setValue", java.lang.Object.class).invoke(objInvoke, obj2);
            } catch (java.lang.Throwable th3) {
                try {
                    objInvoke.getClass().getMethod("tryEmit", java.lang.Object.class).invoke(objInvoke, obj2);
                } catch (java.lang.Throwable th4) {
                    android.util.Log.e(TAG, "Error updating StateFlow for " + str2, th4);
                }
            }
        }
    }

    public static void launchPhotoPicker(android.content.Context context) {
        if (sPhotoLauncher != null) {
            try {
                java.lang.Class<?> cls = java.lang.Class.forName("androidx.activity.result.PickVisualMediaRequest$Builder");
                java.lang.Object objNewInstance = cls.getDeclaredConstructor(new java.lang.Class[0]).newInstance(new java.lang.Object[0]);
                cls.getMethod("setMediaType", java.lang.Class.forName("androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia$VisualMediaType")).invoke(objNewInstance, java.lang.Class.forName("androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia$ImageOnly").getField("INSTANCE").get(null));
                sPhotoLauncher.getClass().getMethod("launch", java.lang.Object.class).invoke(sPhotoLauncher, cls.getMethod("build", new java.lang.Class[0]).invoke(objNewInstance, new java.lang.Object[0]));
                return;
            } catch (java.lang.Throwable th) {
                android.util.Log.e(TAG, "Error launching photo picker via launcher", th);
            }
        }
        android.app.Activity activityFindActivity = findActivity(context);
        if (activityFindActivity != null) {
            try {
                android.content.Intent intent = new android.content.Intent("android.intent.action.PICK");
                intent.setDataAndType(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                activityFindActivity.startActivityForResult(intent, 9021);
            } catch (java.lang.Throwable th2) {
                try {
                    android.content.Intent intent2 = new android.content.Intent("android.intent.action.GET_CONTENT");
                    intent2.setType("image/*");
                    activityFindActivity.startActivityForResult(intent2, 9021);
                } catch (java.lang.Throwable th3) {
                    android.util.Log.e(TAG, "Error launching photo picker intent", th3);
                }
            }
        }
    }

    public static void onPhotoSelected(android.net.Uri uri) {
        if (uri == null) {
            return;
        }
        android.content.Context appContext = getAppContext();
        if (appContext == null) {
            appContext = getActivityContext();
        }
        if (appContext != null) {
            saveProfilePhoto(appContext, uri);
        }
    }

    public static void showEditProfileDialog(android.content.Context context, final boolean z) {
        if (context != null) {
            setAppContext(context);
        }
        final android.app.Activity activityFindActivity = findActivity(context);
        if (activityFindActivity == null || activityFindActivity.isFinishing() || activityFindActivity.isDestroyed()) {
            android.util.Log.e(TAG, "showEditProfileDialog: No valid Activity found");
        } else {
            activityFindActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.example.ui.profile.UserProfileManager.3
                @Override // java.lang.Runnable
                public void run() {
                    boolean z2;
                    if (activityFindActivity.isFinishing() || activityFindActivity.isDestroyed()) {
                        return;
                    }
                    try {
                        float f = activityFindActivity.getResources().getDisplayMetrics().density;
                        int i = (int) (18.0f * f);
                        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activityFindActivity);
                        builder.setTitle(z ? "پروفائل میں ترمیم کریں" : "Edit Profile");
                        android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(activityFindActivity);
                        linearLayout.setOrientation(1);
                        linearLayout.setPadding(i, i, i, i);
                        if (z) {
                            linearLayout.setLayoutDirection(1);
                        }
                        android.widget.LinearLayout linearLayout2 = new android.widget.LinearLayout(activityFindActivity);
                        linearLayout2.setOrientation(0);
                        linearLayout2.setGravity(16);
                        linearLayout2.setPadding(0, 0, 0, (int) (16.0f * f));
                        final android.widget.ImageView imageView = new android.widget.ImageView(activityFindActivity);
                        int i2 = (int) (52.0f * f);
                        imageView.setLayoutParams(new android.widget.LinearLayout.LayoutParams(i2, i2));
                        android.graphics.Bitmap bitmapLoadProfileBitmap = com.example.ui.profile.UserProfileManager.loadProfileBitmap(activityFindActivity);
                        if (bitmapLoadProfileBitmap != null) {
                            imageView.setImageBitmap(com.example.ui.profile.UserProfileManager.getCircularBitmap(bitmapLoadProfileBitmap));
                        } else {
                            imageView.setImageResource(android.R.drawable.ic_menu_camera);
                            imageView.setColorFilter(-14326805);
                        }
                        linearLayout2.addView(imageView);
                        android.widget.LinearLayout linearLayout3 = new android.widget.LinearLayout(activityFindActivity);
                        linearLayout3.setOrientation(1);
                        int i3 = (int) (f * 12.0f);
                        linearLayout3.setPadding(i3, 0, i3, 0);
                        android.widget.Button button = new android.widget.Button(activityFindActivity, null, android.R.attr.borderlessButtonStyle);
                        button.setText(z ? "تصویر تبدیل کریں (گیلری)" : "Choose Photo (Gallery)");
                        button.setTextColor(-14326805);
                        button.setTextSize(13.0f);
                        button.setAllCaps(false);
                        button.setPadding(0, 0, 0, 0);
                        button.setGravity(z ? 21 : 19);
                        linearLayout3.addView(button);
                        if (com.example.ui.profile.UserProfileManager.getProfilePhotoPath(activityFindActivity) != null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        final android.widget.Button button2 = new android.widget.Button(activityFindActivity, null, android.R.attr.borderlessButtonStyle);
                        if (z2) {
                            button2.setText(z ? "تصویر ہٹائیں" : "Remove Photo");
                            button2.setTextColor(-2349530);
                            button2.setTextSize(13.0f);
                            button2.setAllCaps(false);
                            button2.setPadding(0, 0, 0, 0);
                            button2.setGravity(z ? 21 : 19);
                            linearLayout3.addView(button2);
                        }
                        linearLayout2.addView(linearLayout3);
                        linearLayout.addView(linearLayout2);
                        android.widget.TextView textView = new android.widget.TextView(activityFindActivity);
                        textView.setText(z ? "نام:" : "Name:");
                        textView.setTextSize(14.0f);
                        textView.setTextColor(-13418155);
                        if (z) {
                            textView.setTextDirection(4);
                        }
                        linearLayout.addView(textView);
                        final android.widget.EditText editText = new android.widget.EditText(activityFindActivity);
                        editText.setText(com.example.ui.profile.UserProfileManager.getUserName(activityFindActivity));
                        editText.setSingleLine(true);
                        editText.setHint(z ? "اپنا نام درج کریں" : "Enter your name");
                        editText.setTextColor(-15788246);
                        if (z) {
                            editText.setTextDirection(4);
                        }
                        linearLayout.addView(editText);
                        android.widget.TextView textView2 = new android.widget.TextView(activityFindActivity);
                        textView2.setText(z ? "ای میل (Gmail):" : "Email (Gmail):");
                        textView2.setTextSize(14.0f);
                        textView2.setTextColor(-13418155);
                        textView2.setPadding(0, i3, 0, 0);
                        if (z) {
                            textView2.setTextDirection(4);
                        }
                        linearLayout.addView(textView2);
                        final android.widget.EditText editText2 = new android.widget.EditText(activityFindActivity);
                        editText2.setText(com.example.ui.profile.UserProfileManager.getUserEmail(activityFindActivity));
                        editText2.setSingleLine(true);
                        editText2.setHint("example@gmail.com");
                        editText2.setInputType(33);
                        editText2.setTextColor(-15788246);
                        editText2.setTextDirection(3);
                        linearLayout.addView(editText2);
                        builder.setView(linearLayout);
                        builder.setPositiveButton(z ? "محفوظ کریں" : "Save", new android.content.DialogInterface.OnClickListener() { // from class: com.example.ui.profile.UserProfileManager.3.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(android.content.DialogInterface dialogInterface, int i4) {
                                java.lang.String strTrim = editText.getText().toString().trim();
                                java.lang.String strTrim2 = editText2.getText().toString().trim();
                                if (strTrim.isEmpty()) {
                                    strTrim = com.example.ui.profile.UserProfileManager.getUserName(activityFindActivity);
                                }
                                if (strTrim2.isEmpty()) {
                                    strTrim2 = com.example.ui.profile.UserProfileManager.getUserEmail(activityFindActivity);
                                }
                                com.example.ui.profile.UserProfileManager.setUserName(activityFindActivity, strTrim);
                                com.example.ui.profile.UserProfileManager.setUserEmail(activityFindActivity, strTrim2);
                                android.widget.Toast.makeText(activityFindActivity, z ? "پروفائل کامیابی سے محفوظ ہوگئی" : "Profile saved successfully", 0).show();
                            }
                        });
                        builder.setNegativeButton(z ? "منسوخ" : "Cancel", new android.content.DialogInterface.OnClickListener() { // from class: com.example.ui.profile.UserProfileManager.3.2
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(android.content.DialogInterface dialogInterface, int i4) {
                                dialogInterface.dismiss();
                            }
                        });
                        final android.app.AlertDialog alertDialogCreate = builder.create();
                        button.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.example.ui.profile.UserProfileManager.3.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(android.view.View view) {
                                alertDialogCreate.dismiss();
                                com.example.ui.profile.UserProfileManager.launchPhotoPicker(activityFindActivity);
                            }
                        });
                        button2.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.example.ui.profile.UserProfileManager.3.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(android.view.View view) {
                                com.example.ui.profile.UserProfileManager.removeProfilePhoto(activityFindActivity);
                                imageView.setImageResource(android.R.drawable.ic_menu_camera);
                                imageView.setColorFilter(-14326805);
                                button2.setVisibility(8);
                                android.widget.Toast.makeText(activityFindActivity, z ? "تصویر ہٹا دی گئی ہے" : "Photo removed", 0).show();
                            }
                        });
                        alertDialogCreate.show();
                    } catch (java.lang.Throwable th) {
                        android.util.Log.e(com.example.ui.profile.UserProfileManager.TAG, "Error showing edit profile dialog", th);
                    }
                }
            });
        }
    }

    public static void showPhotoOptionsDialog(android.content.Context context, final boolean z) {
        if (context != null) {
            setAppContext(context);
        }
        final android.app.Activity activityFindActivity = findActivity(context);
        if (activityFindActivity == null || activityFindActivity.isFinishing() || activityFindActivity.isDestroyed()) {
            android.util.Log.e(TAG, "showPhotoOptionsDialog: No valid Activity found");
        } else {
            activityFindActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.example.ui.profile.UserProfileManager.4
                @Override // java.lang.Runnable
                public void run() {
                    if (activityFindActivity.isFinishing() || activityFindActivity.isDestroyed()) {
                        return;
                    }
                    try {
                        boolean z2 = com.example.ui.profile.UserProfileManager.getProfilePhotoPath(activityFindActivity) != null;
                        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activityFindActivity);
                        builder.setTitle(z ? "پروفائل تصویر" : "Profile Photo");
                        java.util.ArrayList arrayList = new java.util.ArrayList();
                        arrayList.add(z ? "گیلری سے تصویر منتخب کریں" : "Choose from Gallery");
                        if (z2) {
                            arrayList.add(z ? "تصویر ہٹائیں" : "Remove Photo");
                        }
                        arrayList.add(z ? "پروفائل میں ترمیم کریں (نام اور ای میل)" : "Edit Profile (Name & Email)");
                        arrayList.add(z ? "منسوخ" : "Cancel");
                        final java.lang.String[] strArr = (java.lang.String[]) arrayList.toArray(new java.lang.String[0]);
                        builder.setItems(strArr, new android.content.DialogInterface.OnClickListener() { // from class: com.example.ui.profile.UserProfileManager.4.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(android.content.DialogInterface dialogInterface, int i) {
                                java.lang.String str = strArr[i];
                                if (str.equals(z ? "گیلری سے تصویر منتخب کریں" : "Choose from Gallery")) {
                                    com.example.ui.profile.UserProfileManager.launchPhotoPicker(activityFindActivity);
                                    return;
                                }
                                if (str.equals(z ? "تصویر ہٹائیں" : "Remove Photo")) {
                                    com.example.ui.profile.UserProfileManager.removeProfilePhoto(activityFindActivity);
                                    android.widget.Toast.makeText(activityFindActivity, z ? "تصویر ہٹا دی گئی ہے" : "Photo removed", 0).show();
                                } else {
                                    if (str.equals(z ? "پروفائل میں ترمیم کریں (نام اور ای میل)" : "Edit Profile (Name & Email)")) {
                                        com.example.ui.profile.UserProfileManager.showEditProfileDialog(activityFindActivity, z);
                                    } else {
                                        dialogInterface.dismiss();
                                    }
                                }
                            }
                        });
                        builder.show();
                    } catch (java.lang.Throwable th) {
                        android.util.Log.e(com.example.ui.profile.UserProfileManager.TAG, "Error showing photo options dialog", th);
                    }
                }
            });
        }
    }

    public static void onAvatarClicked(android.content.Context context) {
        android.content.Context contextFindActivity = findActivity(context);
        if (contextFindActivity == null) {
            contextFindActivity = getActivityContext();
        }
        if (contextFindActivity != null) {
            showPhotoOptionsDialog(contextFindActivity, isUrduLanguage(contextFindActivity));
        }
    }

    public static void onEditProfileClicked(android.content.Context context) {
        android.content.Context contextFindActivity = findActivity(context);
        if (contextFindActivity == null) {
            contextFindActivity = getActivityContext();
        }
        if (contextFindActivity != null) {
            showEditProfileDialog(contextFindActivity, isUrduLanguage(contextFindActivity));
        }
    }

    public static androidx.compose.ui.Modifier attachAvatarClick(androidx.compose.ui.Modifier modifier) {
        androidx.compose.ui.Modifier modifier2 = modifier;
        if (modifier == null) {
            return null;
        }
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("androidx.compose.foundation.ClickableKt");
            com.example.ui.profile.AvatarClickCallback avatarClickCallback = new com.example.ui.profile.AvatarClickCallback(getActivityContext());
            java.lang.reflect.Method[] methods = cls.getMethods();
            int length = methods.length;
            int i = 0;
            while (i < length) {
                java.lang.reflect.Method method = methods[i];
                if (method.getName().startsWith("clickable") && method.getName().endsWith("$default")) {
                    java.lang.Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length == 7 && parameterTypes[0] == androidx.compose.ui.Modifier.class && parameterTypes[4] == kotlin.jvm.functions.Function0.class) {
                        androidx.compose.ui.Modifier modifier3 = modifier;
                        try {
                            modifier2 = modifier3;
                            try {
                                return (androidx.compose.ui.Modifier) method.invoke(null, modifier3, true, null, null, avatarClickCallback, 7, null);
                            } catch (java.lang.Throwable th) {
                                // th assigned
                            }
                        } catch (java.lang.Throwable th2) {
                            // th assigned
                            modifier2 = modifier3;
                        }
                    }
                    android.util.Log.e(TAG, "Error attaching avatar click");
                    return modifier2;
                }
                i++;
                modifier = modifier;
            }
            return modifier;
        } catch (java.lang.Throwable th3) {
            // th assigned
            modifier2 = modifier;
        }
        return modifier2;
    }

    public static java.lang.Object attachAvatarClick(java.lang.Object obj) {
        if (obj instanceof androidx.compose.ui.Modifier) {
            return attachAvatarClick((androidx.compose.ui.Modifier) obj);
        }
        return obj;
    }

    public static androidx.compose.ui.Modifier attachEditProfileClick(androidx.compose.ui.Modifier modifier) {
        androidx.compose.ui.Modifier modifier2 = modifier;
        if (modifier == null) {
            return null;
        }
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("androidx.compose.foundation.ClickableKt");
            com.example.ui.profile.EditProfileClickCallback editProfileClickCallback = new com.example.ui.profile.EditProfileClickCallback(getActivityContext());
            java.lang.reflect.Method[] methods = cls.getMethods();
            int length = methods.length;
            int i = 0;
            while (i < length) {
                java.lang.reflect.Method method = methods[i];
                if (method.getName().startsWith("clickable") && method.getName().endsWith("$default")) {
                    java.lang.Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length == 7 && parameterTypes[0] == androidx.compose.ui.Modifier.class && parameterTypes[4] == kotlin.jvm.functions.Function0.class) {
                        androidx.compose.ui.Modifier modifier3 = modifier;
                        try {
                            modifier2 = modifier3;
                            try {
                                return (androidx.compose.ui.Modifier) method.invoke(null, modifier3, true, null, null, editProfileClickCallback, 7, null);
                            } catch (java.lang.Throwable th) {
                                // th assigned
                            }
                        } catch (java.lang.Throwable th2) {
                            // th assigned
                            modifier2 = modifier3;
                        }
                    }
                    android.util.Log.e(TAG, "Error attaching edit profile click");
                    return modifier2;
                }
                i++;
                modifier = modifier;
            }
            return modifier;
        } catch (java.lang.Throwable th3) {
            // th assigned
            modifier2 = modifier;
        }
        return modifier2;
    }

    public static java.lang.Object attachEditProfileClick(java.lang.Object obj) {
        if (obj instanceof androidx.compose.ui.Modifier) {
            return attachEditProfileClick((androidx.compose.ui.Modifier) obj);
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static android.graphics.Bitmap getCircularBitmap(android.graphics.Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int iMin = java.lang.Math.min(bitmap.getWidth(), bitmap.getHeight());
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(iMin, iMin, android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateBitmap);
        android.graphics.Paint paint = new android.graphics.Paint();
        android.graphics.Rect rect = new android.graphics.Rect((bitmap.getWidth() - iMin) / 2, (bitmap.getHeight() - iMin) / 2, (bitmap.getWidth() + iMin) / 2, (bitmap.getHeight() + iMin) / 2);
        android.graphics.Rect rect2 = new android.graphics.Rect(0, 0, iMin, iMin);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        float f = iMin / 2.0f;
        canvas.drawCircle(f, f, f, paint);
        paint.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect2, paint);
        return bitmapCreateBitmap;
    }
}
