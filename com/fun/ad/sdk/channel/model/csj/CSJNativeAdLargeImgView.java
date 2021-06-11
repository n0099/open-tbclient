package com.fun.ad.sdk.channel.model.csj;

import a.a.a.a.u.b.a.b;
import a.a.a.a.y.d;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.R;
import java.util.List;
/* loaded from: classes6.dex */
public final class CSJNativeAdLargeImgView extends b {

    /* renamed from: f  reason: collision with root package name */
    public ImageView f30725f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f30726g;

    /* renamed from: h  reason: collision with root package name */
    public float f30727h;

    /* loaded from: classes6.dex */
    public class a extends DrawableImageViewTarget {
        public a(ImageView imageView) {
            super(imageView);
        }

        @Override // com.bumptech.glide.request.target.ImageViewTarget, com.bumptech.glide.request.target.ViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
        public void onLoadCleared(@Nullable Drawable drawable) {
            super.onLoadCleared(drawable);
            ((ImageView) this.view).setBackground(null);
        }

        @Override // com.bumptech.glide.request.target.ImageViewTarget, com.bumptech.glide.request.target.ViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
        public void onLoadStarted(@Nullable Drawable drawable) {
            super.onLoadStarted(drawable);
            CSJNativeAdLargeImgView.this.f30726g = true;
            ((ImageView) this.view).setBackgroundResource(R.drawable.fun_ad_def_img_tieba);
        }

        @Override // com.bumptech.glide.request.target.ImageViewTarget, com.bumptech.glide.request.target.Target
        public void onResourceReady(@NonNull Object obj, @Nullable Transition transition) {
            Drawable drawable = (Drawable) obj;
            super.onResourceReady(drawable, transition);
            CSJNativeAdLargeImgView.this.f30726g = true;
            ((ImageView) this.view).setBackground(drawable);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.request.target.DrawableImageViewTarget
        public void setResource(@Nullable Drawable drawable) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.bumptech.glide.request.target.DrawableImageViewTarget, com.bumptech.glide.request.target.ImageViewTarget
        public void setResource(@Nullable Drawable drawable) {
        }
    }

    public CSJNativeAdLargeImgView(Context context) {
        super(context);
        this.f30726g = false;
        this.f30727h = 1.78f;
    }

    public CSJNativeAdLargeImgView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f30726g = false;
        this.f30727h = 1.78f;
    }

    public CSJNativeAdLargeImgView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f30726g = false;
        this.f30727h = 1.78f;
    }

    @Override // a.a.a.a.u.b.a.b
    public void a(Activity activity, TTNativeAd tTNativeAd, TTNativeAd.AdInteractionListener adInteractionListener) {
        TTImage tTImage;
        super.a(activity, tTNativeAd, adInteractionListener);
        List<TTImage> imageList = tTNativeAd.getImageList();
        if (imageList == null || imageList.isEmpty() || (tTImage = imageList.get(0)) == null || !tTImage.isValid()) {
            return;
        }
        this.f30727h = (tTImage.getWidth() * 1.0f) / (tTImage.getHeight() * 1.0f);
        Glide.with(activity).load(tTImage.getImageUrl()).into((RequestBuilder<Drawable>) new a(this.f30725f));
    }

    @Override // a.a.a.a.u.b.a.b, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f30725f = (ImageView) findViewById(R.id.ad_img);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        d.a("CSJNativeAdView onLayout width: " + this.f30725f.getWidth() + ", height: " + this.f30725f.getHeight(), new Object[0]);
        if (this.f30726g) {
            this.f30726g = false;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f30725f.getLayoutParams();
            int width = (getWidth() - layoutParams.leftMargin) - layoutParams.rightMargin;
            layoutParams.width = width;
            layoutParams.height = (int) (width / this.f30727h);
            this.f30725f.setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }
}
