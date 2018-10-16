package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b<INFO> implements c<INFO> {
    private static final c<Object> NO_OP_LISTENER = new b();

    public static <INFO> c<INFO> getNoOpListener() {
        return (c<INFO>) NO_OP_LISTENER;
    }

    @Override // com.facebook.drawee.controller.c
    public void onSubmit(String str, Object obj) {
    }

    @Override // com.facebook.drawee.controller.c
    public void onFinalImageSet(String str, @Nullable INFO info, @Nullable Animatable animatable) {
    }

    @Override // com.facebook.drawee.controller.c
    public void onIntermediateImageSet(String str, @Nullable INFO info) {
    }

    @Override // com.facebook.drawee.controller.c
    public void onIntermediateImageFailed(String str, Throwable th) {
    }

    @Override // com.facebook.drawee.controller.c
    public void onFailure(String str, Throwable th) {
    }

    @Override // com.facebook.drawee.controller.c
    public void onRelease(String str) {
    }
}
