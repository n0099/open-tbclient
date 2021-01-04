package com.fun.ad.sdk.csj;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.f0;
import com.fun.ad.m;
import com.fun.ad.sdk.R;
/* loaded from: classes15.dex */
public final class CSJNativeAdLargeVideoView extends f0 {
    public FrameLayout g;
    public ImageView h;

    /* loaded from: classes15.dex */
    public class a implements TTFeedAd.VideoAdListener {
        public a() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onProgressUpdate(long j, long j2) {
            m.a("CSJFeedAd onProgressUpdate current: " + j + ", duration: " + j2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoAdComplete(TTFeedAd tTFeedAd) {
            m.a("CSJFeedAd onVideoAdComplete");
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoAdContinuePlay(TTFeedAd tTFeedAd) {
            m.a("CSJFeedAd onVideoAdContinuePlay");
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoAdPaused(TTFeedAd tTFeedAd) {
            m.a("CSJFeedAd onVideoAdPaused");
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoAdStartPlay(TTFeedAd tTFeedAd) {
            ImageView imageView = CSJNativeAdLargeVideoView.this.h;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            m.a("CSJFeedAd onVideoAdStartPlay");
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoError(int i, int i2) {
            m.a("CSJFeedAd onVideoError errorCode: " + i + ", extraCode: " + i2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoLoad(TTFeedAd tTFeedAd) {
            m.a("CSJFeedAd onVideoLoad");
        }
    }

    public CSJNativeAdLargeVideoView(Context context) {
        super(context);
    }

    public CSJNativeAdLargeVideoView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CSJNativeAdLargeVideoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.fun.ad.f0
    public void a(Activity activity, TTFeedAd tTFeedAd, TTNativeAd.AdInteractionListener adInteractionListener) {
        a(activity, (TTNativeAd) tTFeedAd, adInteractionListener);
        tTFeedAd.setVideoAdListener(new a());
        this.g.removeAllViews();
        TTImage videoCoverImage = tTFeedAd.getVideoCoverImage();
        if (videoCoverImage != null) {
            this.h = new ImageView(activity);
            this.g.addView(this.h, new FrameLayout.LayoutParams(this.f, (this.f * videoCoverImage.getHeight()) / videoCoverImage.getWidth()));
        }
        View adView = tTFeedAd.getAdView();
        if (adView != null && adView.getParent() != null) {
            ((ViewGroup) adView.getParent()).removeView(adView);
        }
        if (adView != null) {
            this.g.addView(adView);
        }
    }

    @Override // com.fun.ad.f0, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.g = (FrameLayout) findViewById(R.id.ad_video);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.g.getLayoutParams();
        int i5 = (i - layoutParams.leftMargin) - layoutParams.rightMargin;
        layoutParams.width = i5;
        layoutParams.height = (int) (i5 / 1.78f);
        this.g.setLayoutParams(layoutParams);
    }

    @Override // com.fun.ad.f0
    public /* bridge */ /* synthetic */ void setAdViewWidth(int i) {
        super.setAdViewWidth(i);
    }
}
