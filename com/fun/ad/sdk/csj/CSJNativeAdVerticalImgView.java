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
/* loaded from: classes14.dex */
public final class CSJNativeAdVerticalImgView extends f0 {
    public ImageView g;

    public CSJNativeAdVerticalImgView(Context context) {
        super(context);
    }

    public CSJNativeAdVerticalImgView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CSJNativeAdVerticalImgView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
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
        ap.a.pFk.a(getContext(), tTImage.getImageUrl(), this.g);
    }

    @Override // com.fun.ad.f0, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.g = (ImageView) findViewById(R.id.ad_img);
    }

    @Override // com.fun.ad.f0
    public /* bridge */ /* synthetic */ void setAdViewWidth(int i) {
        super.setAdViewWidth(i);
    }
}
