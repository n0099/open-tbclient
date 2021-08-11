package com.kwad.sdk.core.imageloader.core;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.core.assist.LoadedFrom;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.display.BitmapDisplayer;
import com.kwad.sdk.core.imageloader.core.imageaware.ImageAware;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.L;
/* loaded from: classes10.dex */
public final class DisplayBitmapTask implements Runnable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LOG_DISPLAY_IMAGE_IN_IMAGEAWARE = "Display image in ImageAware (loaded from %1$s) [%2$s]";
    public static final String LOG_TASK_CANCELLED_IMAGEAWARE_COLLECTED = "ImageAware was collected by GC. Task is cancelled. [%s]";
    public static final String LOG_TASK_CANCELLED_IMAGEAWARE_REUSED = "ImageAware is reused for another image. Task is cancelled. [%s]";
    public transient /* synthetic */ FieldHolder $fh;
    public final DecodedResult decodedResult;
    public final BitmapDisplayer displayer;
    public final ImageLoaderEngine engine;
    public final ImageAware imageAware;
    public final String imageUri;
    public final ImageLoadingListener listener;
    public final LoadedFrom loadedFrom;
    public final String memoryCacheKey;

    public DisplayBitmapTask(DecodedResult decodedResult, ImageLoadingInfo imageLoadingInfo, ImageLoaderEngine imageLoaderEngine, LoadedFrom loadedFrom) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {decodedResult, imageLoadingInfo, imageLoaderEngine, loadedFrom};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? !this.memoryCacheKey.equals(this.engine.getLoadingUriForView(this.imageAware)) : invokeV.booleanValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
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
}
