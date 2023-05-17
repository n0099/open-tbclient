package com.kwad.sdk.api.model;

import androidx.annotation.Keep;
@Keep
/* loaded from: classes9.dex */
public class SplashAdExtraData {
    public boolean isDisableRotate;
    public boolean isDisableShake;
    public boolean isDisableSlide;

    public boolean getDisableRotateStatus() {
        return this.isDisableRotate;
    }

    public boolean getDisableShakeStatus() {
        return this.isDisableShake;
    }

    public boolean getDisableSlideStatus() {
        return this.isDisableSlide;
    }

    public void setDisableRotateStatus(boolean z) {
        this.isDisableRotate = z;
    }

    public void setDisableShakeStatus(boolean z) {
        this.isDisableShake = z;
    }

    public void setDisableSlideStatus(boolean z) {
        this.isDisableSlide = z;
    }
}
