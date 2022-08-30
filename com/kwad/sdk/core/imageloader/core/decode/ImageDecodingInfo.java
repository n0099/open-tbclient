package com.kwad.sdk.core.imageloader.core.decode;

import android.annotation.TargetApi;
import android.graphics.BitmapFactory;
import android.os.Build;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptions;
import com.kwad.sdk.core.imageloader.core.assist.ImageScaleType;
import com.kwad.sdk.core.imageloader.core.assist.ImageSize;
import com.kwad.sdk.core.imageloader.core.assist.ViewScaleType;
import com.kwad.sdk.core.imageloader.core.download.ImageDownloader;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
/* loaded from: classes7.dex */
public class ImageDecodingInfo {
    public final boolean considerExifParams;
    public final BitmapFactory.Options decodingOptions = new BitmapFactory.Options();
    public final ImageDownloader downloader;
    public final Object extraForDownloader;
    public final String imageKey;
    public final ImageScaleType imageScaleType;
    public final String imageUri;
    public final ImageLoadingListener listener;
    public final String originalImageUri;
    public final ImageSize targetSize;
    public final ViewScaleType viewScaleType;

    public ImageDecodingInfo(String str, String str2, String str3, ImageSize imageSize, ViewScaleType viewScaleType, ImageDownloader imageDownloader, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener) {
        this.imageKey = str;
        this.imageUri = str2;
        this.originalImageUri = str3;
        this.targetSize = imageSize;
        this.imageScaleType = displayImageOptions.getImageScaleType();
        this.viewScaleType = viewScaleType;
        this.downloader = imageDownloader;
        this.extraForDownloader = displayImageOptions.getExtraForDownloader();
        this.considerExifParams = displayImageOptions.isConsiderExifParams();
        this.listener = imageLoadingListener;
        copyOptions(displayImageOptions.getDecodingOptions(), this.decodingOptions);
    }

    private void copyOptions(BitmapFactory.Options options, BitmapFactory.Options options2) {
        options2.inDensity = options.inDensity;
        options2.inDither = options.inDither;
        options2.inInputShareable = options.inInputShareable;
        options2.inJustDecodeBounds = options.inJustDecodeBounds;
        options2.inPreferredConfig = options.inPreferredConfig;
        options2.inPurgeable = options.inPurgeable;
        options2.inSampleSize = options.inSampleSize;
        options2.inScaled = options.inScaled;
        options2.inScreenDensity = options.inScreenDensity;
        options2.inTargetDensity = options.inTargetDensity;
        options2.inTempStorage = options.inTempStorage;
        if (Build.VERSION.SDK_INT >= 10) {
            copyOptions10(options, options2);
        }
        if (Build.VERSION.SDK_INT >= 11) {
            copyOptions11(options, options2);
        }
    }

    @TargetApi(10)
    private void copyOptions10(BitmapFactory.Options options, BitmapFactory.Options options2) {
        options2.inPreferQualityOverSpeed = options.inPreferQualityOverSpeed;
    }

    @TargetApi(11)
    private void copyOptions11(BitmapFactory.Options options, BitmapFactory.Options options2) {
        options2.inBitmap = options.inBitmap;
        options2.inMutable = options.inMutable;
    }

    public BitmapFactory.Options getDecodingOptions() {
        return this.decodingOptions;
    }

    public ImageDownloader getDownloader() {
        return this.downloader;
    }

    public Object getExtraForDownloader() {
        return this.extraForDownloader;
    }

    public String getImageKey() {
        return this.imageKey;
    }

    public ImageScaleType getImageScaleType() {
        return this.imageScaleType;
    }

    public String getImageUri() {
        return this.imageUri;
    }

    public ImageLoadingListener getLoadListener() {
        return this.listener;
    }

    public String getOriginalImageUri() {
        return this.originalImageUri;
    }

    public ImageSize getTargetSize() {
        return this.targetSize;
    }

    public ViewScaleType getViewScaleType() {
        return this.viewScaleType;
    }

    public boolean shouldConsiderExifParams() {
        return this.considerExifParams;
    }
}
