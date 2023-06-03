package com.kwad.sdk.core.imageloader;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public enum ImageLoaderProxy implements IImageLoader {
    INSTANCE;
    
    public final IImageLoader mDelegate = ImageLoadFactory.create();

    ImageLoaderProxy() {
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public final void clearMemory(Context context) {
        this.mDelegate.clearMemory(context);
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public final void init(Context context) {
        this.mDelegate.init(context);
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public final boolean isInited() {
        return this.mDelegate.isInited();
    }

    @Override // com.kwad.sdk.service.kwai.g
    public final void load(@NonNull Context context, ImageView imageView, Object obj, int i, int i2) {
        this.mDelegate.load(context, imageView, obj, i, i2);
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public final void load(@NonNull Context context, String str, ImageView imageView, DisplayImageOptionsCompat displayImageOptionsCompat, ImageLoadingListener imageLoadingListener) {
        this.mDelegate.load(context, str, imageView, displayImageOptionsCompat, imageLoadingListener);
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public final void load(Context context, String str, DisplayImageOptionsCompat displayImageOptionsCompat, ImageLoadingListener imageLoadingListener) {
        this.mDelegate.load(context, str, displayImageOptionsCompat, imageLoadingListener);
    }

    @Override // com.kwad.sdk.service.kwai.g
    public final void load(ImageView imageView, Object obj) {
        this.mDelegate.load(imageView, obj);
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public final void load(ImageView imageView, Object obj, ImageLoadingListener imageLoadingListener) {
        this.mDelegate.load(imageView, obj, imageLoadingListener);
    }

    @Override // com.kwad.sdk.service.kwai.g
    public final void load(ImageView imageView, Object obj, AdTemplate adTemplate) {
        this.mDelegate.load(imageView, obj, adTemplate);
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public final void load(KsFragment ksFragment, @NonNull Context context, String str, DisplayImageOptionsCompat displayImageOptionsCompat, ImageLoadingListener imageLoadingListener) {
        this.mDelegate.load(ksFragment, context, str, displayImageOptionsCompat, imageLoadingListener);
    }

    @Override // com.kwad.sdk.service.kwai.g
    public final void load(@NonNull KsFragment ksFragment, @NonNull String str, @NonNull ImageView imageView, @NonNull Drawable drawable, @NonNull Drawable drawable2) {
        this.mDelegate.load(ksFragment, str, imageView, drawable, drawable2);
    }

    @Override // com.kwad.sdk.service.kwai.g
    public final void load(@NonNull KsFragment ksFragment, @NonNull String str, @NonNull ImageView imageView, @NonNull Drawable drawable, @NonNull Drawable drawable2, float f) {
        this.mDelegate.load(ksFragment, str, imageView, drawable, drawable2, f);
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public final void pause() {
        this.mDelegate.pause();
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public final void resume() {
        this.mDelegate.resume();
    }
}
