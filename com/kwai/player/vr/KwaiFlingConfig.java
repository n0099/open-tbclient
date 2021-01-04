package com.kwai.player.vr;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
/* loaded from: classes5.dex */
public class KwaiFlingConfig {
    private TimeInterpolator mInterpolator = new DecelerateInterpolator();
    private long mDuring = 400;
    private float mSensitivity = 1.0f;

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

    public KwaiFlingConfig setSensitivity(float f) {
        this.mSensitivity = f;
        return this;
    }
}
