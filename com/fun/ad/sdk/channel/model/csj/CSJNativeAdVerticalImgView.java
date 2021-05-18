package com.fun.ad.sdk.channel.model.csj;

import a.a.a.a.t.b.a.b;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
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
public final class CSJNativeAdVerticalImgView extends b {

    /* renamed from: f  reason: collision with root package name */
    public ImageView f30712f;

    /* loaded from: classes6.dex */
    public class a extends DrawableImageViewTarget {
        public a(CSJNativeAdVerticalImgView cSJNativeAdVerticalImgView, ImageView imageView) {
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

    public CSJNativeAdVerticalImgView(Context context) {
        super(context);
    }

    public CSJNativeAdVerticalImgView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CSJNativeAdVerticalImgView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // a.a.a.a.t.b.a.b
    public void a(Activity activity, TTNativeAd tTNativeAd, TTNativeAd.AdInteractionListener adInteractionListener) {
        TTImage tTImage;
        super.a(activity, tTNativeAd, adInteractionListener);
        List<TTImage> imageList = tTNativeAd.getImageList();
        if (imageList == null || imageList.isEmpty() || (tTImage = imageList.get(0)) == null || !tTImage.isValid()) {
            return;
        }
        Glide.with(activity).load(tTImage.getImageUrl()).into((RequestBuilder<Drawable>) new a(this, this.f30712f));
    }

    @Override // a.a.a.a.t.b.a.b, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f30712f = (ImageView) findViewById(R.id.ad_img);
    }
}
