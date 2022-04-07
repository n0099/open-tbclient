package com.kwad.sdk.core.imageloader;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.a.kwai.a;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.core.i.b;
import com.kwad.sdk.core.imageloader.cache.disc.naming.Md5FileNameGenerator;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptions;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.ImageLoader;
import com.kwad.sdk.core.imageloader.core.ImageLoaderConfiguration;
import com.kwad.sdk.core.imageloader.core.assist.QueueProcessingType;
import com.kwad.sdk.core.imageloader.core.display.BitmapDisplayer;
import com.kwad.sdk.core.imageloader.core.display.CircleBitmapDisplayer;
import com.kwad.sdk.core.imageloader.core.display.RoundedBitmapDisplayer;
import com.kwad.sdk.core.imageloader.core.download.BaseImageDownloader;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.network.k;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.utils.aq;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes5.dex */
public class ImageLoadImpl implements IImageLoader {
    private DisplayImageOptions adapter(DisplayImageOptionsCompat displayImageOptionsCompat) {
        BitmapDisplayer roundedBitmapDisplayer;
        Context context = KsAdSDKImpl.get().getContext();
        Resources resources = KsAdSDKImpl.get().getContext().getResources();
        DisplayImageOptions.Builder bitmapConfig = new DisplayImageOptions.Builder().showImageOnLoading(displayImageOptionsCompat.getImageOnLoading(resources)).showImageForEmptyUri(displayImageOptionsCompat.getImageForEmptyUri(resources)).showImageOnFail(displayImageOptionsCompat.getImageOnFail(resources)).cacheInMemory(true).cacheOnDisc(true).bitmapConfig(Bitmap.Config.RGB_565);
        if (displayImageOptionsCompat.getStrokeWidth() <= 0.0f) {
            if (displayImageOptionsCompat.isCircle()) {
                bitmapConfig.displayer(new CircleBitmapDisplayer());
            } else if (displayImageOptionsCompat.getCornerRound() > 0) {
                roundedBitmapDisplayer = new RoundedBitmapDisplayer(a.a(context, displayImageOptionsCompat.getCornerRound()));
            }
            return bitmapConfig.build();
        }
        roundedBitmapDisplayer = new CircleBitmapDisplayer(Integer.valueOf(displayImageOptionsCompat.getStrokeColor()), a.a(context, displayImageOptionsCompat.getStrokeWidth()));
        bitmapConfig.displayer(roundedBitmapDisplayer);
        return bitmapConfig.build();
    }

    private String parseModel(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        throw new IllegalArgumentException("unsupport object except String!");
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void clearMemory(Context context) {
        ImageLoader.getInstance().clearMemoryCache();
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void init(Context context) {
        ImageLoaderConfiguration.Builder builder = new ImageLoaderConfiguration.Builder(context.getApplicationContext());
        builder.taskExecutor(b.c());
        builder.taskExecutorForCachedImages(b.d());
        builder.setTaskDistributor(b.e());
        builder.denyCacheImageMultipleSizesInMemory();
        builder.diskCacheFileNameGenerator(new Md5FileNameGenerator());
        builder.diskCacheSize(20971520);
        builder.tasksProcessingOrder(QueueProcessingType.LIFO);
        builder.cacheParentDir(aq.b(context).getPath());
        builder.imageDownloader(new BaseImageDownloader(context) { // from class: com.kwad.sdk.core.imageloader.ImageLoadImpl.1
            @Override // com.kwad.sdk.core.imageloader.core.download.BaseImageDownloader
            public HttpURLConnection createConnection(String str, Object obj) {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(Uri.encode(str, BaseImageDownloader.ALLOWED_URI_CHARS)).openConnection();
                m.a(httpURLConnection);
                httpURLConnection.setRequestProperty("User-Agent", k.c());
                httpURLConnection.setRequestProperty("BrowserUa", k.d());
                httpURLConnection.setRequestProperty("SystemUa", k.a());
                httpURLConnection.setConnectTimeout(this.connectTimeout);
                httpURLConnection.setReadTimeout(this.readTimeout);
                return httpURLConnection;
            }
        });
        ImageLoader.getInstance().init(builder.build());
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public boolean isInited() {
        return ImageLoader.getInstance().isInited();
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void load(@NonNull Context context, ImageView imageView, Object obj, int i, int i2) {
        ImageLoader.getInstance().displayImage(parseModel(obj), imageView, new DisplayImageOptions.Builder().bitmapConfig(Bitmap.Config.ARGB_8888).cacheOnDisk(true).cacheInMemory(true).showImageOnLoading(i2).showImageForEmptyUri(i).showImageOnFail(i).build());
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void load(@NonNull Context context, String str, ImageView imageView, DisplayImageOptionsCompat displayImageOptionsCompat, ImageLoadingListener imageLoadingListener) {
        ImageLoader.getInstance().displayImage(str, imageView, adapter(displayImageOptionsCompat), imageLoadingListener);
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void load(Context context, String str, DisplayImageOptionsCompat displayImageOptionsCompat, ImageLoadingListener imageLoadingListener) {
        ImageLoader.getInstance().loadImage(str, adapter(displayImageOptionsCompat), imageLoadingListener);
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void load(ImageView imageView, Object obj) {
        ImageLoader.getInstance().displayImage(parseModel(obj), imageView);
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void load(KsFragment ksFragment, @NonNull Context context, String str, DisplayImageOptionsCompat displayImageOptionsCompat, ImageLoadingListener imageLoadingListener) {
        ImageLoader.getInstance().loadImage(str, adapter(displayImageOptionsCompat), imageLoadingListener);
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void load(@NonNull KsFragment ksFragment, @NonNull String str, @NonNull ImageView imageView, @NonNull Drawable drawable, @NonNull Drawable drawable2) {
        ImageLoader.getInstance().displayImage(str, imageView, new DisplayImageOptions.Builder().bitmapConfig(Bitmap.Config.ARGB_8888).cacheOnDisk(true).cacheInMemory(true).showImageOnLoading(drawable).showImageOnFail(drawable2).build());
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void load(@NonNull KsFragment ksFragment, @NonNull String str, @NonNull ImageView imageView, @NonNull Drawable drawable, @NonNull Drawable drawable2, float f) {
        ImageLoader.getInstance().displayImage(str, imageView, new DisplayImageOptions.Builder().bitmapConfig(Bitmap.Config.ARGB_8888).cacheOnDisk(true).cacheInMemory(true).showImageOnLoading(drawable).showImageOnFail(drawable2).displayer(new RoundedBitmapDisplayer(a.a(imageView.getContext(), f))).build());
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void pause() {
        ImageLoader.getInstance().pause();
    }

    @Override // com.kwad.sdk.core.imageloader.IImageLoader
    public void resume() {
        ImageLoader.getInstance().resume();
    }
}
