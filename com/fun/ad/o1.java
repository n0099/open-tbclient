package com.fun.ad;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsNativeAd;
/* loaded from: classes14.dex */
public abstract class o1 extends LinearLayout {
    public o1(Context context) {
        this(context, null);
    }

    public o1(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public o1(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public abstract void a(Activity activity, String str, String str2, KsNativeAd ksNativeAd, KsNativeAd.AdInteractionListener adInteractionListener);
}
