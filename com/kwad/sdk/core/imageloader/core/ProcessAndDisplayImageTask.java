package com.kwad.sdk.core.imageloader.core;

import android.os.Handler;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.core.assist.LoadedFrom;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.process.BitmapProcessor;
import com.kwad.sdk.core.imageloader.utils.L;
/* loaded from: classes7.dex */
public final class ProcessAndDisplayImageTask implements Runnable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LOG_POSTPROCESS_IMAGE = "PostProcess image before displaying [%s]";
    public transient /* synthetic */ FieldHolder $fh;
    public final DecodedResult decodedResult;
    public final ImageLoaderEngine engine;
    public final Handler handler;
    public final ImageLoadingInfo imageLoadingInfo;

    public ProcessAndDisplayImageTask(ImageLoaderEngine imageLoaderEngine, DecodedResult decodedResult, ImageLoadingInfo imageLoadingInfo, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageLoaderEngine, decodedResult, imageLoadingInfo, handler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.engine = imageLoaderEngine;
        this.imageLoadingInfo = imageLoadingInfo;
        this.handler = handler;
        this.decodedResult = decodedResult;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            L.d("PostProcess image before displaying [%s]", this.imageLoadingInfo.memoryCacheKey);
            BitmapProcessor postProcessor = this.imageLoadingInfo.options.getPostProcessor();
            DecodedResult decodedResult = this.decodedResult;
            decodedResult.mBitmap = postProcessor.process(decodedResult.mBitmap);
            LoadAndDisplayImageTask.runTask(new DisplayBitmapTask(this.decodedResult, this.imageLoadingInfo, this.engine, LoadedFrom.MEMORY_CACHE), this.imageLoadingInfo.options.isSyncLoading(), this.handler, this.engine);
        }
    }
}
