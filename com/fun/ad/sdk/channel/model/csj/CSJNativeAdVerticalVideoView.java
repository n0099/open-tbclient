package com.fun.ad.sdk.channel.model.csj;

import a.a.a.a.r.b.a.b;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.R;
/* loaded from: classes6.dex */
public final class CSJNativeAdVerticalVideoView extends b {

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f30535f;

    public CSJNativeAdVerticalVideoView(Context context) {
        super(context);
    }

    public CSJNativeAdVerticalVideoView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CSJNativeAdVerticalVideoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // a.a.a.a.r.b.a.b
    public void a(Activity activity, TTNativeAd tTNativeAd, TTNativeAd.AdInteractionListener adInteractionListener) {
        super.a(activity, tTNativeAd, adInteractionListener);
        View adView = tTNativeAd.getAdView();
        if (adView != null && adView.getParent() != null) {
            ((ViewGroup) adView.getParent()).removeView(adView);
        }
        if (adView != null) {
            this.f30535f.removeAllViews();
            this.f30535f.addView(adView);
        }
    }

    @Override // a.a.a.a.r.b.a.b, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f30535f = (FrameLayout) findViewById(R.id.ad_video);
    }
}
