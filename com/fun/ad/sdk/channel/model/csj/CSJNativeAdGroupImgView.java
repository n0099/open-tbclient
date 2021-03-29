package com.fun.ad.sdk.channel.model.csj;

import a.a.a.a.r.b.b.b;
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
public final class CSJNativeAdGroupImgView extends b {

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f30756f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f30757g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f30758h;
    public ImageView i;

    public CSJNativeAdGroupImgView(Context context) {
        super(context);
    }

    public CSJNativeAdGroupImgView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CSJNativeAdGroupImgView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // a.a.a.a.r.b.b.b
    public void a(Activity activity, TTNativeAd tTNativeAd, TTNativeAd.AdInteractionListener adInteractionListener) {
        super.a(activity, tTNativeAd, adInteractionListener);
        List<TTImage> imageList = tTNativeAd.getImageList();
        if (imageList == null || imageList.size() < 3) {
            return;
        }
        TTImage tTImage = imageList.get(0);
        if (tTImage != null && tTImage.isValid()) {
            Context context = getContext();
            String imageUrl = tTImage.getImageUrl();
            ImageView imageView = this.f30757g;
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
        }
        TTImage tTImage2 = imageList.get(1);
        if (tTImage2 != null && tTImage2.isValid()) {
            Context context2 = getContext();
            String imageUrl2 = tTImage2.getImageUrl();
            ImageView imageView2 = this.f30758h;
            if (context2 == null) {
                d.b("GlideHelper: context is null when load: " + imageUrl2, new Object[0]);
            } else if (context2 instanceof Activity) {
                Activity activity3 = (Activity) context2;
                if (activity3.isFinishing() || (Build.VERSION.SDK_INT > 17 && activity3.isDestroyed())) {
                    d.b("GlideHelper: activity is destroyed when load: " + imageUrl2, new Object[0]);
                } else {
                    Glide.with(activity3).load(imageUrl2).into(imageView2);
                }
            } else {
                Glide.with(context2).load(imageUrl2).into(imageView2);
            }
        }
        TTImage tTImage3 = imageList.get(2);
        if (tTImage3 == null || !tTImage3.isValid()) {
            return;
        }
        Context context3 = getContext();
        String imageUrl3 = tTImage3.getImageUrl();
        ImageView imageView3 = this.i;
        if (context3 == null) {
            d.b("GlideHelper: context is null when load: " + imageUrl3, new Object[0]);
        } else if (context3 instanceof Activity) {
            Activity activity4 = (Activity) context3;
            if (!activity4.isFinishing() && (Build.VERSION.SDK_INT <= 17 || !activity4.isDestroyed())) {
                Glide.with(activity4).load(imageUrl3).into(imageView3);
                return;
            }
            d.b("GlideHelper: activity is destroyed when load: " + imageUrl3, new Object[0]);
        } else {
            Glide.with(context3).load(imageUrl3).into(imageView3);
        }
    }

    @Override // a.a.a.a.r.b.b.b, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f30756f = (LinearLayout) findViewById(R.id.ad_img_container);
        this.f30757g = (ImageView) findViewById(R.id.ad_img_1);
        this.f30758h = (ImageView) findViewById(R.id.ad_img_2);
        this.i = (ImageView) findViewById(R.id.ad_img_3);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f30756f.getLayoutParams();
        int i5 = (i - layoutParams.leftMargin) - layoutParams.rightMargin;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f30757g.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.f30758h.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.i.getLayoutParams();
        layoutParams.width = i5;
        layoutParams.height = (int) (((((((i5 - layoutParams2.leftMargin) - layoutParams2.rightMargin) - layoutParams3.leftMargin) - layoutParams3.rightMargin) - layoutParams4.leftMargin) - layoutParams4.rightMargin) / 1.52f);
        this.f30756f.setLayoutParams(layoutParams);
    }
}
