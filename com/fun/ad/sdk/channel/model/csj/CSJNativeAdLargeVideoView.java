package com.fun.ad.sdk.channel.model.csj;

import a.a.a.a.r.b.b.b;
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
/* loaded from: classes4.dex */
public final class CSJNativeAdLargeVideoView extends b {
    public FrameLayout f;

    public CSJNativeAdLargeVideoView(Context context) {
        super(context);
    }

    public CSJNativeAdLargeVideoView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CSJNativeAdLargeVideoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // a.a.a.a.r.b.b.b
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
                ViewGroup.LayoutParams layoutParams = this.f.getLayoutParams();
                layoutParams.width = adViewWidth;
                layoutParams.height = adViewHeight;
                this.f.setLayoutParams(layoutParams);
                this.f.requestLayout();
            }
            this.f.removeAllViews();
            this.f.addView(adView);
        }
    }

    @Override // a.a.a.a.r.b.b.b, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f = (FrameLayout) findViewById(R.id.ad_video);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f.getLayoutParams();
        int i5 = (i - layoutParams.leftMargin) - layoutParams.rightMargin;
        layoutParams.width = i5;
        layoutParams.height = (int) (i5 / 1.78f);
        this.f.setLayoutParams(layoutParams);
    }
}
