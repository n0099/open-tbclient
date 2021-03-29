package com.kwad.sdk.lib.desigin;

import androidx.annotation.FloatRange;
import androidx.annotation.Keep;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Keep
/* loaded from: classes6.dex */
public interface CustomReboundOffsetCallback {
    public static final int REBOUND_TYPE_FLING = 2;
    public static final int REBOUND_TYPE_TOUCH = 1;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface ReboundType {
    }

    void rebound(int i, @FloatRange(from = 0.0d, to = 1.0d) float f2, int i2);
}
