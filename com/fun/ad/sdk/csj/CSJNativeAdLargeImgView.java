package com.fun.ad.sdk.csj;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.ap;
import com.fun.ad.f0;
import com.fun.ad.m;
import com.fun.ad.sdk.R;
import java.util.List;
/* loaded from: classes15.dex */
public final class CSJNativeAdLargeImgView extends f0 {
    public ImageView g;
    public float h;

    public CSJNativeAdLargeImgView(Context context) {
        super(context);
        this.h = 1.78f;
    }

    public CSJNativeAdLargeImgView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = 1.78f;
    }

    public CSJNativeAdLargeImgView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = 1.78f;
    }

    @Override // com.fun.ad.f0
    public void a(Activity activity, TTNativeAd tTNativeAd, TTNativeAd.AdInteractionListener adInteractionListener) {
        TTImage tTImage;
        super.a(activity, tTNativeAd, adInteractionListener);
        List<TTImage> imageList = tTNativeAd.getImageList();
        if (imageList == null || imageList.isEmpty() || (tTImage = imageList.get(0)) == null || !tTImage.isValid()) {
            return;
        }
        this.g.setLayoutParams(new LinearLayout.LayoutParams(this.f, (this.f * tTImage.getHeight()) / tTImage.getWidth()));
        m.a("CSJNativeAdView ttImage width: " + tTImage.getWidth() + ", height: " + tTImage.getHeight());
        this.h = (tTImage.getWidth() * 1.0f) / (tTImage.getHeight() * 1.0f);
        ap.a.pJL.a(getContext(), tTImage.getImageUrl(), this.g);
        m.a("CSJNativeAdView ttImage url: " + tTImage.getImageUrl());
    }

    @Override // com.fun.ad.f0, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.g = (ImageView) findViewById(R.id.ad_img);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.g.getLayoutParams();
        int i5 = (i - layoutParams.leftMargin) - layoutParams.rightMargin;
        layoutParams.width = i5;
        layoutParams.height = (int) (i5 / this.h);
        this.g.setLayoutParams(layoutParams);
    }

    @Override // com.fun.ad.f0
    public /* bridge */ /* synthetic */ void setAdViewWidth(int i) {
        super.setAdViewWidth(i);
    }
}
