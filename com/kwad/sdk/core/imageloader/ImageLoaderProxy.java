package com.kwad.sdk.core.imageloader;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
/* loaded from: classes7.dex */
public enum ImageLoaderProxy implements IImageLoader {
    INSTANCE;
    
    public IImageLoader mDelegate = null;

    ImageLoaderProxy() {
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void clearMemory(Context context) {
        IImageLoader iImageLoader = this.mDelegate;
        if (iImageLoader != null) {
            iImageLoader.clearMemory(context);
        }
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void init(Context context) {
    }

    public void init(Context context, IImageLoader iImageLoader) {
        iImageLoader.init(context);
        this.mDelegate = iImageLoader;
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public boolean isInited() {
        IImageLoader iImageLoader = this.mDelegate;
        if (iImageLoader != null) {
            return iImageLoader.isInited();
        }
        return false;
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void load(@NonNull Context context, ImageView imageView, Object obj, int i2, int i3) {
        IImageLoader iImageLoader = this.mDelegate;
        if (iImageLoader != null) {
            iImageLoader.load(context, imageView, obj, i2, i3);
        }
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void load(@NonNull Context context, String str, ImageView imageView, DisplayImageOptionsCompat displayImageOptionsCompat, ImageLoadingListener imageLoadingListener) {
        IImageLoader iImageLoader = this.mDelegate;
        if (iImageLoader != null) {
            iImageLoader.load(context, str, imageView, displayImageOptionsCompat, imageLoadingListener);
        }
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void load(Context context, String str, DisplayImageOptionsCompat displayImageOptionsCompat, ImageLoadingListener imageLoadingListener) {
        IImageLoader iImageLoader = this.mDelegate;
        if (iImageLoader != null) {
            iImageLoader.load(context, str, displayImageOptionsCompat, imageLoadingListener);
        }
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void load(ImageView imageView, Object obj) {
        IImageLoader iImageLoader = this.mDelegate;
        if (iImageLoader != null) {
            iImageLoader.load(imageView, obj);
        }
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void load(KsFragment ksFragment, @NonNull Context context, String str, DisplayImageOptionsCompat displayImageOptionsCompat, ImageLoadingListener imageLoadingListener) {
        IImageLoader iImageLoader = this.mDelegate;
        if (iImageLoader != null) {
            iImageLoader.load(ksFragment, context, str, displayImageOptionsCompat, imageLoadingListener);
        }
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void load(@NonNull KsFragment ksFragment, @NonNull String str, @NonNull ImageView imageView, @NonNull Drawable drawable, @NonNull Drawable drawable2) {
        IImageLoader iImageLoader = this.mDelegate;
        if (iImageLoader != null) {
            iImageLoader.load(ksFragment, str, imageView, drawable, drawable2);
        }
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void load(@NonNull KsFragment ksFragment, @NonNull String str, @NonNull ImageView imageView, @NonNull Drawable drawable, @NonNull Drawable drawable2, float f2) {
        IImageLoader iImageLoader = this.mDelegate;
        if (iImageLoader != null) {
            iImageLoader.load(ksFragment, str, imageView, drawable, drawable2, f2);
        }
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void pause() {
        IImageLoader iImageLoader = this.mDelegate;
        if (iImageLoader != null) {
            iImageLoader.pause();
        }
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void resume() {
        IImageLoader iImageLoader = this.mDelegate;
        if (iImageLoader != null) {
            iImageLoader.resume();
        }
    }
}
