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
import com.fun.ad.sdk.R;
import java.util.List;
/* loaded from: classes6.dex */
public final class CSJNativeAdGroupImgView extends f0 {
    public LinearLayout g;
    public ImageView h;
    public ImageView i;
    public ImageView j;

    public CSJNativeAdGroupImgView(Context context) {
        super(context);
    }

    public CSJNativeAdGroupImgView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CSJNativeAdGroupImgView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.fun.ad.f0
    public void a(Activity activity, TTNativeAd tTNativeAd, TTNativeAd.AdInteractionListener adInteractionListener) {
        super.a(activity, tTNativeAd, adInteractionListener);
        List<TTImage> imageList = tTNativeAd.getImageList();
        if (imageList == null || imageList.size() < 3) {
            return;
        }
        TTImage tTImage = imageList.get(0);
        if (tTImage != null && tTImage.isValid()) {
            ap.a.pPq.a(getContext(), tTImage.getImageUrl(), this.h);
        }
        TTImage tTImage2 = imageList.get(1);
        if (tTImage2 != null && tTImage2.isValid()) {
            ap.a.pPq.a(getContext(), tTImage2.getImageUrl(), this.i);
        }
        TTImage tTImage3 = imageList.get(2);
        if (tTImage3 == null || !tTImage3.isValid()) {
            return;
        }
        ap.a.pPq.a(getContext(), tTImage3.getImageUrl(), this.j);
    }

    @Override // com.fun.ad.f0, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.g = (LinearLayout) findViewById(R.id.ad_img_container);
        this.h = (ImageView) findViewById(R.id.ad_img_1);
        this.i = (ImageView) findViewById(R.id.ad_img_2);
        this.j = (ImageView) findViewById(R.id.ad_img_3);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.g.getLayoutParams();
        int i5 = (i - layoutParams.leftMargin) - layoutParams.rightMargin;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.h.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.i.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.j.getLayoutParams();
        layoutParams.width = i5;
        layoutParams.height = (int) (((((((i5 - layoutParams2.leftMargin) - layoutParams2.rightMargin) - layoutParams3.leftMargin) - layoutParams3.rightMargin) - layoutParams4.leftMargin) - layoutParams4.rightMargin) / 1.52f);
        this.g.setLayoutParams(layoutParams);
    }

    @Override // com.fun.ad.f0
    public /* bridge */ /* synthetic */ void setAdViewWidth(int i) {
        super.setAdViewWidth(i);
    }
}
