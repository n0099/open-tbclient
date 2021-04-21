package com.fun.ad.sdk.channel.model.csj;

import a.a.a.a.r.b.a.b;
import a.a.a.a.v.d;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.bumptech.glide.Glide;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.R;
import java.util.List;
/* loaded from: classes6.dex */
public final class CSJNativeAdSmallImgView extends b {

    /* renamed from: f  reason: collision with root package name */
    public ImageView f30532f;

    /* renamed from: g  reason: collision with root package name */
    public float f30533g;

    public CSJNativeAdSmallImgView(Context context) {
        super(context);
        this.f30533g = 1.78f;
    }

    public CSJNativeAdSmallImgView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f30533g = 1.78f;
    }

    public CSJNativeAdSmallImgView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f30533g = 1.78f;
    }

    @Override // a.a.a.a.r.b.a.b
    public void a(Activity activity, TTNativeAd tTNativeAd, TTNativeAd.AdInteractionListener adInteractionListener) {
        TTImage tTImage;
        super.a(activity, tTNativeAd, adInteractionListener);
        List<TTImage> imageList = tTNativeAd.getImageList();
        if (imageList == null || imageList.isEmpty() || (tTImage = imageList.get(0)) == null || !tTImage.isValid()) {
            return;
        }
        d.b("CSJNativeAdView ttImage width: " + tTImage.getWidth() + ", height: " + tTImage.getHeight(), new Object[0]);
        this.f30533g = (((float) tTImage.getWidth()) * 1.0f) / (((float) tTImage.getHeight()) * 1.0f);
        Context context = getContext();
        String imageUrl = tTImage.getImageUrl();
        ImageView imageView = this.f30532f;
        if (context == null) {
            d.b("GlideHelper: context is null when load: " + imageUrl, new Object[0]);
        } else if (context instanceof Activity) {
            Activity activity2 = (Activity) context;
            if (activity2.isFinishing() || (Build.VERSION.SDK_INT > 17 && activity2.isDestroyed())) {
                d.b("GlideHelper: activity is destroyed when load: " + imageUrl, new Object[0]);
            } else {
                Glide.with(activity2).load(imageUrl).into(imageView);
            }
        } else {
            Glide.with(context).load(imageUrl).into(imageView);
        }
        d.b("CSJNativeAdView ttImage url: " + tTImage.getImageUrl(), new Object[0]);
    }

    @Override // a.a.a.a.r.b.a.b, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f30532f = (ImageView) findViewById(R.id.ad_img);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f30532f.getLayoutParams();
        int i5 = (i - layoutParams.leftMargin) - layoutParams.rightMargin;
        layoutParams.width = i5;
        layoutParams.height = (int) (i5 / this.f30533g);
        this.f30532f.setLayoutParams(layoutParams);
    }
}
