package com.example.ui.profile;

/* JADX INFO: loaded from: classes11.dex */
public class PhotoPickedCallback implements kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> {
    @Override // kotlin.jvm.functions.Function1
    public kotlin.Unit invoke(java.lang.Object obj) {
        if (obj instanceof android.net.Uri) {
            com.example.ui.profile.UserProfileManager.onPhotoSelected((android.net.Uri) obj);
        }
        return kotlin.Unit.INSTANCE;
    }
}
