package com.fun.ad.sdk.channel.model.csj;

import a.a.a.a.t.b.a.b;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.R;
/* loaded from: classes6.dex */
public final class CSJNativeAdLargeVideoView extends b {

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f30638f;

    public CSJNativeAdLargeVideoView(Context context) {
        super(context);
    }

    public CSJNativeAdLargeVideoView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CSJNativeAdLargeVideoView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // a.a.a.a.t.b.a.b
    public void a(Activity activity, TTNativeAd tTNativeAd, TTNativeAd.AdInteractionListener adInteractionListener) {
        super.a(activity, tTNativeAd, adInteractionListener);
        View adView = tTNativeAd.getAdView();
        if (adView != null && adView.getParent() != null) {
            ((ViewGroup) adView.getParent()).removeView(adView);
        }
        if (adView != null) {
            if (tTNativeAd instanceof TTFeedAd) {
                TTFeedAd tTFeedAd = (TTFeedAd) tTNativeAd;
                int adViewHeight = tTFeedAd.getAdViewHeight();
                int adViewWidth = tTFeedAd.getAdViewWidth();
                ViewGroup.LayoutParams layoutParams = this.f30638f.getLayoutParams();
                layoutParams.width = adViewWidth;
                layoutParams.height = adViewHeight;
                this.f30638f.setLayoutParams(layoutParams);
                this.f30638f.requestLayout();
            }
            this.f30638f.removeAllViews();
            this.f30638f.addView(adView);
        }
    }

    @Override // a.a.a.a.t.b.a.b, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f30638f = (FrameLayout) findViewById(R.id.ad_video);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f30638f.getLayoutParams();
        int i6 = (i2 - layoutParams.leftMargin) - layoutParams.rightMargin;
        layoutParams.width = i6;
        layoutParams.height = (int) (i6 / 1.78f);
        this.f30638f.setLayoutParams(layoutParams);
    }
}
