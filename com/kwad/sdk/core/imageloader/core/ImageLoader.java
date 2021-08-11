package com.kwad.sdk.core.imageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.cache.disc.DiskCache;
import com.kwad.sdk.core.imageloader.cache.memory.MemoryCache;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptions;
import com.kwad.sdk.core.imageloader.core.assist.ImageSize;
import com.kwad.sdk.core.imageloader.core.assist.LoadedFrom;
import com.kwad.sdk.core.imageloader.core.assist.ViewScaleType;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.imageaware.ImageAware;
import com.kwad.sdk.core.imageloader.core.imageaware.ImageViewAware;
import com.kwad.sdk.core.imageloader.core.imageaware.NonViewAware;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingProgressListener;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.ImageSizeUtils;
import com.kwad.sdk.core.imageloader.utils.L;
import com.kwad.sdk.core.imageloader.utils.MemoryCacheUtils;
/* loaded from: classes10.dex */
public class ImageLoader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ERROR_INIT_CONFIG_WITH_NULL = "ImageLoader configuration can not be initialized with null";
    public static final String ERROR_NOT_INIT = "ImageLoader must be init with configuration before using";
    public static final String ERROR_WRONG_ARGUMENTS = "Wrong arguments were passed to displayImage() method (ImageView reference must not be null)";
    public static final String LOG_DESTROY = "Destroy ImageLoader";
    public static final String LOG_INIT_CONFIG = "Initialize ImageLoader with configuration";
    public static final String LOG_LOAD_IMAGE_FROM_MEMORY_CACHE = "Load image from memory cache [%s]";
    public static final String TAG = "ImageLoader";
    public static final String WARNING_RE_INIT_CONFIG = "Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.";
    public static volatile ImageLoader instance;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile ImageLoaderConfiguration configuration;
    public ImageLoadingListener defaultListener;
    public ImageLoaderEngine engine;

    /* renamed from: com.kwad.sdk.core.imageloader.core.ImageLoader$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public static class SyncImageLoadingListener extends SimpleImageLoadingListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Bitmap loadedImage;

        public SyncImageLoadingListener() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ SyncImageLoadingListener(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Bitmap getLoadedBitmap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.loadedImage : (Bitmap) invokeV.objValue;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view, decodedResult) == null) {
                this.loadedImage = decodedResult.mBitmap;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-443400121, "Lcom/kwad/sdk/core/imageloader/core/ImageLoader;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-443400121, "Lcom/kwad/sdk/core/imageloader/core/ImageLoader;");
        }
    }

    public ImageLoader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.defaultListener = new SimpleImageLoadingListener();
    }

    private void checkConfiguration() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && this.configuration == null) {
            throw new IllegalStateException(ERROR_NOT_INIT);
        }
    }

    public static Handler defineHandler(DisplayImageOptions displayImageOptions) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, displayImageOptions)) == null) {
            Handler handler = displayImageOptions.getHandler();
            if (displayImageOptions.isSyncLoading()) {
                return null;
            }
            return (handler == null && Looper.myLooper() == Looper.getMainLooper()) ? new Handler() : handler;
        }
        return (Handler) invokeL.objValue;
    }

    public static ImageLoader getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (instance == null) {
                synchronized (ImageLoader.class) {
                    if (instance == null) {
                        instance = new ImageLoader();
                    }
                }
            }
            return instance;
        }
        return (ImageLoader) invokeV.objValue;
    }

    public void cancelDisplayTask(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, imageView) == null) {
            this.engine.cancelDisplayTaskFor(new ImageViewAware(imageView));
        }
    }

    public void cancelDisplayTask(ImageAware imageAware) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageAware) == null) {
            this.engine.cancelDisplayTaskFor(imageAware);
        }
    }

    @Deprecated
    public void clearDiscCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            clearDiskCache();
        }
    }

    public void clearDiskCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            checkConfiguration();
            this.configuration.diskCache.clear();
        }
    }

    public void clearMemoryCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            checkConfiguration();
            this.configuration.memoryCache.clear();
        }
    }

    public void denyNetworkDownloads(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.engine.denyNetworkDownloads(z);
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.configuration != null) {
                L.d(LOG_DESTROY, new Object[0]);
            }
            stop();
            this.configuration.diskCache.close();
            this.engine = null;
            this.configuration = null;
        }
    }

    public void displayImage(String str, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, imageView) == null) {
            displayImage(str, new ImageViewAware(imageView), (DisplayImageOptions) null, (ImageLoadingListener) null, (ImageLoadingProgressListener) null);
        }
    }

    public void displayImage(String str, ImageView imageView, DisplayImageOptions displayImageOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, imageView, displayImageOptions) == null) {
            displayImage(str, new ImageViewAware(imageView), displayImageOptions, (ImageLoadingListener) null, (ImageLoadingProgressListener) null);
        }
    }

    public void displayImage(String str, ImageView imageView, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, str, imageView, displayImageOptions, imageLoadingListener) == null) {
            displayImage(str, imageView, displayImageOptions, imageLoadingListener, (ImageLoadingProgressListener) null);
        }
    }

    public void displayImage(String str, ImageView imageView, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener, ImageLoadingProgressListener imageLoadingProgressListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048586, this, str, imageView, displayImageOptions, imageLoadingListener, imageLoadingProgressListener) == null) {
            displayImage(str, new ImageViewAware(imageView), displayImageOptions, imageLoadingListener, imageLoadingProgressListener);
        }
    }

    public void displayImage(String str, ImageView imageView, ImageSize imageSize) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, str, imageView, imageSize) == null) {
            displayImage(str, new ImageViewAware(imageView), null, imageSize, null, null);
        }
    }

    public void displayImage(String str, ImageView imageView, ImageLoadingListener imageLoadingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, str, imageView, imageLoadingListener) == null) {
            displayImage(str, new ImageViewAware(imageView), (DisplayImageOptions) null, imageLoadingListener, (ImageLoadingProgressListener) null);
        }
    }

    public void displayImage(String str, ImageAware imageAware) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, imageAware) == null) {
            displayImage(str, imageAware, (DisplayImageOptions) null, (ImageLoadingListener) null, (ImageLoadingProgressListener) null);
        }
    }

    public void displayImage(String str, ImageAware imageAware, DisplayImageOptions displayImageOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, str, imageAware, displayImageOptions) == null) {
            displayImage(str, imageAware, displayImageOptions, (ImageLoadingListener) null, (ImageLoadingProgressListener) null);
        }
    }

    public void displayImage(String str, ImageAware imageAware, DisplayImageOptions displayImageOptions, ImageSize imageSize, ImageLoadingListener imageLoadingListener, ImageLoadingProgressListener imageLoadingProgressListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{str, imageAware, displayImageOptions, imageSize, imageLoadingListener, imageLoadingProgressListener}) == null) {
            checkConfiguration();
            if (imageAware == null) {
                throw new IllegalArgumentException(ERROR_WRONG_ARGUMENTS);
            }
            if (imageLoadingListener == null) {
                imageLoadingListener = this.defaultListener;
            }
            ImageLoadingListener imageLoadingListener2 = imageLoadingListener;
            if (displayImageOptions == null) {
                displayImageOptions = this.configuration.defaultDisplayImageOptions;
            }
            if (TextUtils.isEmpty(str)) {
                this.engine.cancelDisplayTaskFor(imageAware);
                imageLoadingListener2.onLoadingStarted(str, imageAware.getWrappedView());
                if (displayImageOptions.shouldShowImageForEmptyUri()) {
                    imageAware.setImageDrawable(displayImageOptions.getImageForEmptyUri(this.configuration.resources));
                } else {
                    imageAware.setImageDrawable(null);
                }
                imageLoadingListener2.onLoadingComplete(str, imageAware.getWrappedView(), null);
                return;
            }
            if (imageSize == null) {
                imageSize = ImageSizeUtils.defineTargetSizeForView(imageAware, this.configuration.getMaxImageSize());
            }
            ImageSize imageSize2 = imageSize;
            String generateKey = MemoryCacheUtils.generateKey(str, imageSize2);
            this.engine.prepareDisplayTaskFor(imageAware, generateKey);
            imageLoadingListener2.onLoadingStarted(str, imageAware.getWrappedView());
            DecodedResult decodedResult = this.configuration.memoryCache.get(generateKey);
            if (decodedResult == null || !decodedResult.isDecoded()) {
                if (displayImageOptions.shouldShowImageOnLoading()) {
                    imageAware.setImageDrawable(displayImageOptions.getImageOnLoading(this.configuration.resources));
                } else if (displayImageOptions.isResetViewBeforeLoading()) {
                    imageAware.setImageDrawable(null);
                }
                LoadAndDisplayImageTask loadAndDisplayImageTask = new LoadAndDisplayImageTask(this.engine, new ImageLoadingInfo(str, imageAware, imageSize2, generateKey, displayImageOptions, imageLoadingListener2, imageLoadingProgressListener, this.engine.getLockForUri(str)), defineHandler(displayImageOptions));
                if (displayImageOptions.isSyncLoading()) {
                    loadAndDisplayImageTask.run();
                    return;
                } else {
                    this.engine.submit(loadAndDisplayImageTask);
                    return;
                }
            }
            L.d(LOG_LOAD_IMAGE_FROM_MEMORY_CACHE, generateKey);
            if (!displayImageOptions.shouldPostProcess()) {
                displayImageOptions.getDisplayer().display(decodedResult, imageAware, LoadedFrom.MEMORY_CACHE);
                imageLoadingListener2.onLoadingComplete(str, imageAware.getWrappedView(), decodedResult);
                return;
            }
            ProcessAndDisplayImageTask processAndDisplayImageTask = new ProcessAndDisplayImageTask(this.engine, decodedResult, new ImageLoadingInfo(str, imageAware, imageSize2, generateKey, displayImageOptions, imageLoadingListener2, imageLoadingProgressListener, this.engine.getLockForUri(str)), defineHandler(displayImageOptions));
            if (displayImageOptions.isSyncLoading()) {
                processAndDisplayImageTask.run();
            } else {
                this.engine.submit(processAndDisplayImageTask);
            }
        }
    }

    public void displayImage(String str, ImageAware imageAware, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048592, this, str, imageAware, displayImageOptions, imageLoadingListener) == null) {
            displayImage(str, imageAware, displayImageOptions, imageLoadingListener, (ImageLoadingProgressListener) null);
        }
    }

    public void displayImage(String str, ImageAware imageAware, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener, ImageLoadingProgressListener imageLoadingProgressListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048593, this, str, imageAware, displayImageOptions, imageLoadingListener, imageLoadingProgressListener) == null) {
            displayImage(str, imageAware, displayImageOptions, null, imageLoadingListener, imageLoadingProgressListener);
        }
    }

    public void displayImage(String str, ImageAware imageAware, ImageLoadingListener imageLoadingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, str, imageAware, imageLoadingListener) == null) {
            displayImage(str, imageAware, (DisplayImageOptions) null, imageLoadingListener, (ImageLoadingProgressListener) null);
        }
    }

    @Deprecated
    public DiskCache getDiscCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? getDiskCache() : (DiskCache) invokeV.objValue;
    }

    public DiskCache getDiskCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            checkConfiguration();
            return this.configuration.diskCache;
        }
        return (DiskCache) invokeV.objValue;
    }

    public String getLoadingUriForView(ImageView imageView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, imageView)) == null) ? this.engine.getLoadingUriForView(new ImageViewAware(imageView)) : (String) invokeL.objValue;
    }

    public String getLoadingUriForView(ImageAware imageAware) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, imageAware)) == null) ? this.engine.getLoadingUriForView(imageAware) : (String) invokeL.objValue;
    }

    public MemoryCache getMemoryCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            checkConfiguration();
            return this.configuration.memoryCache;
        }
        return (MemoryCache) invokeV.objValue;
    }

    public void handleSlowNetwork(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.engine.handleSlowNetwork(z);
        }
    }

    public synchronized void init(ImageLoaderConfiguration imageLoaderConfiguration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, imageLoaderConfiguration) == null) {
            synchronized (this) {
                if (imageLoaderConfiguration == null) {
                    throw new IllegalArgumentException(ERROR_INIT_CONFIG_WITH_NULL);
                }
                if (this.configuration == null) {
                    L.d(LOG_INIT_CONFIG, new Object[0]);
                    this.engine = new ImageLoaderEngine(imageLoaderConfiguration);
                    this.configuration = imageLoaderConfiguration;
                } else {
                    L.w(WARNING_RE_INIT_CONFIG, new Object[0]);
                }
            }
        }
    }

    public boolean isInited() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.configuration != null : invokeV.booleanValue;
    }

    public void loadImage(String str, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048603, this, str, displayImageOptions, imageLoadingListener) == null) {
            loadImage(str, null, displayImageOptions, imageLoadingListener, null);
        }
    }

    public void loadImage(String str, ImageSize imageSize, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048604, this, str, imageSize, displayImageOptions, imageLoadingListener) == null) {
            loadImage(str, imageSize, displayImageOptions, imageLoadingListener, null);
        }
    }

    public void loadImage(String str, ImageSize imageSize, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener, ImageLoadingProgressListener imageLoadingProgressListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048605, this, str, imageSize, displayImageOptions, imageLoadingListener, imageLoadingProgressListener) == null) {
            checkConfiguration();
            if (imageSize == null) {
                imageSize = this.configuration.getMaxImageSize();
            }
            if (displayImageOptions == null) {
                displayImageOptions = this.configuration.defaultDisplayImageOptions;
            }
            displayImage(str, new NonViewAware(str, imageSize, ViewScaleType.CROP), displayImageOptions, imageLoadingListener, imageLoadingProgressListener);
        }
    }

    public void loadImage(String str, ImageSize imageSize, ImageLoadingListener imageLoadingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048606, this, str, imageSize, imageLoadingListener) == null) {
            loadImage(str, imageSize, null, imageLoadingListener, null);
        }
    }

    public void loadImage(String str, ImageLoadingListener imageLoadingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, str, imageLoadingListener) == null) {
            loadImage(str, null, null, imageLoadingListener, null);
        }
    }

    public Bitmap loadImageSync(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) ? loadImageSync(str, null, null) : (Bitmap) invokeL.objValue;
    }

    public Bitmap loadImageSync(String str, DisplayImageOptions displayImageOptions) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048609, this, str, displayImageOptions)) == null) ? loadImageSync(str, null, displayImageOptions) : (Bitmap) invokeLL.objValue;
    }

    public Bitmap loadImageSync(String str, ImageSize imageSize) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048610, this, str, imageSize)) == null) ? loadImageSync(str, imageSize, null) : (Bitmap) invokeLL.objValue;
    }

    public Bitmap loadImageSync(String str, ImageSize imageSize, DisplayImageOptions displayImageOptions) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048611, this, str, imageSize, displayImageOptions)) == null) {
            if (displayImageOptions == null) {
                displayImageOptions = this.configuration.defaultDisplayImageOptions;
            }
            DisplayImageOptions build = new DisplayImageOptions.Builder().cloneFrom(displayImageOptions).syncLoading(true).build();
            SyncImageLoadingListener syncImageLoadingListener = new SyncImageLoadingListener(null);
            loadImage(str, imageSize, build, syncImageLoadingListener);
            return syncImageLoadingListener.getLoadedBitmap();
        }
        return (Bitmap) invokeLLL.objValue;
    }

    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.engine.pause();
        }
    }

    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.engine.resume();
        }
    }

    public void setDefaultLoadingListener(ImageLoadingListener imageLoadingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, imageLoadingListener) == null) {
            if (imageLoadingListener == null) {
                imageLoadingListener = new SimpleImageLoadingListener();
            }
            this.defaultListener = imageLoadingListener;
        }
    }

    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.engine.stop();
        }
    }
}
