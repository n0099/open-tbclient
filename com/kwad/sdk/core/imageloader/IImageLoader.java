package com.kwad.sdk.core.imageloader;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptions;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
/* loaded from: classes2.dex */
public interface IImageLoader {
    void clearMemory(Context context);

    void init(Context context);

    boolean isInited();

    void load(@NonNull Context context, ImageView imageView, Object obj, @DrawableRes int i2, @DrawableRes int i3);

    void load(@NonNull Context context, String str, ImageView imageView, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener);

    void load(Context context, String str, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener);

    void load(ImageView imageView, Object obj);

    void load(KsFragment ksFragment, Context context, String str, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener);

    void load(@NonNull KsFragment ksFragment, @NonNull String str, @NonNull ImageView imageView, @NonNull Drawable drawable, @NonNull Drawable drawable2);

    void load(@NonNull KsFragment ksFragment, @NonNull String str, @NonNull ImageView imageView, @NonNull Drawable drawable, @NonNull Drawable drawable2, float f2);

    void pause();

    void resume();
}
