package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public interface ControllerListener {
    void onFailure(String str, Throwable th);

    void onFinalImageSet(String str, @Nullable Object obj, @Nullable Animatable animatable);

    void onIntermediateImageFailed(String str, Throwable th);

    void onIntermediateImageSet(String str, @Nullable Object obj);

    void onRelease(String str);

    void onSubmit(String str, Object obj);
}
