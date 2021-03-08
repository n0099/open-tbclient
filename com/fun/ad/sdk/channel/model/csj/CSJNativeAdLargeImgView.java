package com.fun.ad.sdk.channel.model.csj;

import a.a.a.a.r.b.b.b;
import a.a.a.a.v.d;
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
/* loaded from: classes4.dex */
public final class CSJNativeAdLargeImgView extends b {
    public ImageView f;
    public float g;

    /* loaded from: classes4.dex */
    public class a extends DrawableImageViewTarget {
        public a(CSJNativeAdLargeImgView cSJNativeAdLargeImgView, ImageView imageView) {
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
            ((ImageView) this.view).setBackgroundResource(R.drawable.fun_ad_def_img_tieba);
        }

        @Override // com.bumptech.glide.request.target.ImageViewTarget, com.bumptech.glide.request.target.Target
        public void onResourceReady(@NonNull Object obj, @Nullable Transition transition) {
            Drawable drawable = (Drawable) obj;
            super.onResourceReady(drawable, transition);
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
        this.g = 1.78f;
    }

    public CSJNativeAdLargeImgView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = 1.78f;
    }

    public CSJNativeAdLargeImgView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = 1.78f;
    }

    @Override // a.a.a.a.r.b.b.b
    public void a(Activity activity, TTNativeAd tTNativeAd, TTNativeAd.AdInteractionListener adInteractionListener) {
        TTImage tTImage;
        super.a(activity, tTNativeAd, adInteractionListener);
        List<TTImage> imageList = tTNativeAd.getImageList();
        if (imageList == null || imageList.isEmpty() || (tTImage = imageList.get(0)) == null || !tTImage.isValid()) {
            return;
        }
        d.a("CSJNativeAdView ttImage width: " + tTImage.getWidth() + ", height: " + tTImage.getHeight(), new Object[0]);
        this.g = (tTImage.getWidth() * 1.0f) / (tTImage.getHeight() * 1.0f);
        Glide.with(activity).load(tTImage.getImageUrl()).into((RequestBuilder<Drawable>) new a(this, this.f));
    }

    @Override // a.a.a.a.r.b.b.b, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f = (ImageView) findViewById(R.id.ad_img);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f.getLayoutParams();
        int i5 = (i - layoutParams.leftMargin) - layoutParams.rightMargin;
        layoutParams.width = i5;
        layoutParams.height = (int) (i5 / this.g);
        this.f.setLayoutParams(layoutParams);
    }
}
