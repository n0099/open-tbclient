package com.kwad.sdk.core.imageloader.core;

import com.kwad.sdk.core.imageloader.core.assist.LoadedFrom;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.display.BitmapDisplayer;
import com.kwad.sdk.core.imageloader.core.imageaware.ImageAware;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.L;
/* loaded from: classes5.dex */
public final class DisplayBitmapTask implements Runnable {
    public static final String LOG_DISPLAY_IMAGE_IN_IMAGEAWARE = "Display image in ImageAware (loaded from %1$s) [%2$s]";
    public static final String LOG_TASK_CANCELLED_IMAGEAWARE_COLLECTED = "ImageAware was collected by GC. Task is cancelled. [%s]";
    public static final String LOG_TASK_CANCELLED_IMAGEAWARE_REUSED = "ImageAware is reused for another image. Task is cancelled. [%s]";
    public final DecodedResult decodedResult;
    public final BitmapDisplayer displayer;
    public final ImageLoaderEngine engine;
    public final ImageAware imageAware;
    public final String imageUri;
    public final ImageLoadingListener listener;
    public final LoadedFrom loadedFrom;
    public final String memoryCacheKey;

    public DisplayBitmapTask(DecodedResult decodedResult, ImageLoadingInfo imageLoadingInfo, ImageLoaderEngine imageLoaderEngine, LoadedFrom loadedFrom) {
        this.decodedResult = decodedResult;
        this.imageUri = imageLoadingInfo.uri;
        this.imageAware = imageLoadingInfo.imageAware;
        this.memoryCacheKey = imageLoadingInfo.memoryCacheKey;
        this.displayer = imageLoadingInfo.options.getDisplayer();
        this.listener = imageLoadingInfo.listener;
        this.engine = imageLoaderEngine;
        this.loadedFrom = loadedFrom;
    }

    private boolean isViewWasReused() {
        return !this.memoryCacheKey.equals(this.engine.getLoadingUriForView(this.imageAware));
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.imageAware.isCollected()) {
            L.d("ImageAware was collected by GC. Task is cancelled. [%s]", this.memoryCacheKey);
        } else if (!isViewWasReused()) {
            L.d(LOG_DISPLAY_IMAGE_IN_IMAGEAWARE, this.loadedFrom, this.memoryCacheKey);
            this.displayer.display(this.decodedResult, this.imageAware, this.loadedFrom);
            this.engine.cancelDisplayTaskFor(this.imageAware);
            this.listener.onLoadingComplete(this.imageUri, this.imageAware.getWrappedView(), this.decodedResult);
            return;
        } else {
            L.d("ImageAware is reused for another image. Task is cancelled. [%s]", this.memoryCacheKey);
        }
        this.listener.onLoadingCancelled(this.imageUri, this.imageAware.getWrappedView());
    }
}
