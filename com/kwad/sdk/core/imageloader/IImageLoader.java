package com.kwad.sdk.core.imageloader;

import android.content.Context;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.service.kwai.g;
/* loaded from: classes5.dex */
public interface IImageLoader extends g {
    void clearMemory(Context context);

    void init(Context context);

    boolean isInited();

    void load(@NonNull Context context, String str, ImageView imageView, DisplayImageOptionsCompat displayImageOptionsCompat, ImageLoadingListener imageLoadingListener);

    void load(Context context, String str, DisplayImageOptionsCompat displayImageOptionsCompat, ImageLoadingListener imageLoadingListener);

    void load(ImageView imageView, Object obj, ImageLoadingListener imageLoadingListener);

    void load(KsFragment ksFragment, Context context, String str, DisplayImageOptionsCompat displayImageOptionsCompat, ImageLoadingListener imageLoadingListener);

    void pause();

    void resume();
}
