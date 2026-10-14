package com.example.ui.profile;

/* JADX INFO: loaded from: classes11.dex */
public class EditProfileClickCallback implements kotlin.jvm.functions.Function0<kotlin.Unit> {
    private final android.content.Context context;

    public EditProfileClickCallback(android.content.Context context) {
        this.context = context;
    }

    @Override // kotlin.jvm.functions.Function0
    public kotlin.Unit invoke() {
        com.example.ui.profile.UserProfileManager.onEditProfileClicked(this.context);
        return kotlin.Unit.INSTANCE;
    }
}
