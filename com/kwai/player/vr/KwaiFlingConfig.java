package com.kwai.player.vr;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
/* loaded from: classes6.dex */
public class KwaiFlingConfig {
    public TimeInterpolator mInterpolator = new DecelerateInterpolator();
    public long mDuring = 400;
    public float mSensitivity = 1.0f;

    public long getDuring() {
        return this.mDuring;
    }

    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    public float getSensitivity() {
        return this.mSensitivity;
    }

    public KwaiFlingConfig setDuring(long j) {
        this.mDuring = j;
        return this;
    }

    public KwaiFlingConfig setInterpolator(TimeInterpolator timeInterpolator) {
        this.mInterpolator = timeInterpolator;
        return this;
    }

    public KwaiFlingConfig setSensitivity(float f2) {
        this.mSensitivity = f2;
        return this;
    }
}
