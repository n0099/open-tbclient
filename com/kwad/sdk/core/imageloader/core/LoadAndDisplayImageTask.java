package com.kwad.sdk.core.imageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptions;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.assist.ImageScaleType;
import com.kwad.sdk.core.imageloader.core.assist.ImageSize;
import com.kwad.sdk.core.imageloader.core.assist.LoadedFrom;
import com.kwad.sdk.core.imageloader.core.assist.ViewScaleType;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.decode.ImageDecoder;
import com.kwad.sdk.core.imageloader.core.decode.ImageDecodingInfo;
import com.kwad.sdk.core.imageloader.core.download.ImageDownloader;
import com.kwad.sdk.core.imageloader.core.imageaware.ImageAware;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingProgressListener;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import com.kwad.sdk.core.imageloader.utils.L;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes10.dex */
public final class LoadAndDisplayImageTask implements IoUtils.CopyListener, Runnable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ERROR_NO_IMAGE_STREAM = "No stream for image [%s]";
    public static final String ERROR_POST_PROCESSOR_NULL = "Post-processor returned null [%s]";
    public static final String ERROR_PRE_PROCESSOR_NULL = "Pre-processor returned null [%s]";
    public static final String ERROR_PROCESSOR_FOR_DISK_CACHE_NULL = "Bitmap processor for disk cache returned null [%s]";
    public static final String LOG_CACHE_IMAGE_IN_MEMORY = "Cache image in memory [%s]";
    public static final String LOG_CACHE_IMAGE_ON_DISK = "Cache image on disk [%s]";
    public static final String LOG_DELAY_BEFORE_LOADING = "Delay %d ms before loading...  [%s]";
    public static final String LOG_GET_IMAGE_FROM_MEMORY_CACHE_AFTER_WAITING = "...Get cached bitmap from memory after waiting. [%s]";
    public static final String LOG_LOAD_IMAGE_FROM_DISK_CACHE = "Load image from disk cache [%s]";
    public static final String LOG_LOAD_IMAGE_FROM_NETWORK = "Load image from network [%s]";
    public static final String LOG_POSTPROCESS_IMAGE = "PostProcess image before displaying [%s]";
    public static final String LOG_PREPROCESS_IMAGE = "PreProcess image before caching in memory [%s]";
    public static final String LOG_PROCESS_IMAGE_BEFORE_CACHE_ON_DISK = "Process image before cache on disk [%s]";
    public static final String LOG_RESIZE_CACHED_IMAGE_FILE = "Resize image in disk cache [%s]";
    public static final String LOG_RESUME_AFTER_PAUSE = ".. Resume loading [%s]";
    public static final String LOG_START_DISPLAY_IMAGE_TASK = "Start display image task [%s]";
    public static final String LOG_TASK_CANCELLED_IMAGEAWARE_COLLECTED = "ImageAware was collected by GC. Task is cancelled. [%s]";
    public static final String LOG_TASK_CANCELLED_IMAGEAWARE_REUSED = "ImageAware is reused for another image. Task is cancelled. [%s]";
    public static final String LOG_TASK_INTERRUPTED = "Task was interrupted [%s]";
    public static final String LOG_WAITING_FOR_IMAGE_LOADED = "Image already is loading. Waiting... [%s]";
    public static final String LOG_WAITING_FOR_RESUME = "ImageLoader is paused. Waiting...  [%s]";
    public transient /* synthetic */ FieldHolder $fh;
    public final ImageLoaderConfiguration configuration;
    public final ImageDecoder decoder;
    public final ImageDownloader downloader;
    public final ImageLoaderEngine engine;
    public final Handler handler;
    public final ImageAware imageAware;
    public final ImageLoadingInfo imageLoadingInfo;
    public final ImageLoadingListener listener;
    public LoadedFrom loadedFrom;
    public final String memoryCacheKey;
    public final ImageDownloader networkDeniedDownloader;
    public final DisplayImageOptions options;
    public final ImageLoadingProgressListener progressListener;
    public final ImageDownloader slowNetworkDownloader;
    public final boolean syncLoading;
    public final ImageSize targetSize;
    public final String uri;

    /* loaded from: classes10.dex */
    public static class FireCancelEventRunnable implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<LoadAndDisplayImageTask> weakReference;

        public FireCancelEventRunnable(LoadAndDisplayImageTask loadAndDisplayImageTask) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loadAndDisplayImageTask};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.weakReference = new WeakReference<>(loadAndDisplayImageTask);
        }

        @Override // java.lang.Runnable
        public void run() {
            LoadAndDisplayImageTask loadAndDisplayImageTask;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (loadAndDisplayImageTask = this.weakReference.get()) == null) {
                return;
            }
            loadAndDisplayImageTask.listener.onLoadingCancelled(loadAndDisplayImageTask.uri, loadAndDisplayImageTask.imageAware.getWrappedView());
        }
    }

    /* loaded from: classes10.dex */
    public static class FireFailEventRunnable implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Throwable failCause;
        public final FailReason.FailType failType;
        public WeakReference<LoadAndDisplayImageTask> weakReference;

        public FireFailEventRunnable(LoadAndDisplayImageTask loadAndDisplayImageTask, FailReason.FailType failType, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loadAndDisplayImageTask, failType, th};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.weakReference = new WeakReference<>(loadAndDisplayImageTask);
            this.failCause = th;
            this.failType = failType;
        }

        @Override // java.lang.Runnable
        public void run() {
            LoadAndDisplayImageTask loadAndDisplayImageTask;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (loadAndDisplayImageTask = this.weakReference.get()) == null) {
                return;
            }
            if (loadAndDisplayImageTask.options.shouldShowImageOnFail()) {
                loadAndDisplayImageTask.imageAware.setImageDrawable(loadAndDisplayImageTask.options.getImageOnFail(loadAndDisplayImageTask.configuration.resources));
            }
            loadAndDisplayImageTask.listener.onLoadingFailed(loadAndDisplayImageTask.uri, loadAndDisplayImageTask.imageAware.getWrappedView(), new FailReason(this.failType, this.failCause));
        }
    }

    /* loaded from: classes10.dex */
    public class TaskCancelledException extends Exception {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -504619855289909996L;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LoadAndDisplayImageTask this$0;

        public TaskCancelledException(LoadAndDisplayImageTask loadAndDisplayImageTask) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loadAndDisplayImageTask};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = loadAndDisplayImageTask;
        }
    }

    public LoadAndDisplayImageTask(ImageLoaderEngine imageLoaderEngine, ImageLoadingInfo imageLoadingInfo, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageLoaderEngine, imageLoadingInfo, handler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.loadedFrom = LoadedFrom.NETWORK;
        this.engine = imageLoaderEngine;
        this.imageLoadingInfo = imageLoadingInfo;
        this.handler = handler;
        ImageLoaderConfiguration imageLoaderConfiguration = imageLoaderEngine.configuration;
        this.configuration = imageLoaderConfiguration;
        this.downloader = imageLoaderConfiguration.downloader;
        this.networkDeniedDownloader = imageLoaderConfiguration.networkDeniedDownloader;
        this.slowNetworkDownloader = imageLoaderConfiguration.slowNetworkDownloader;
        this.decoder = imageLoaderConfiguration.decoder;
        this.uri = imageLoadingInfo.uri;
        this.memoryCacheKey = imageLoadingInfo.memoryCacheKey;
        this.imageAware = imageLoadingInfo.imageAware;
        this.targetSize = imageLoadingInfo.targetSize;
        DisplayImageOptions displayImageOptions = imageLoadingInfo.options;
        this.options = displayImageOptions;
        this.listener = imageLoadingInfo.listener;
        this.progressListener = imageLoadingInfo.progressListener;
        this.syncLoading = displayImageOptions.isSyncLoading();
    }

    private void checkTaskInterrupted() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && isTaskInterrupted()) {
            throw new TaskCancelledException(this);
        }
    }

    private void checkTaskNotActual() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            checkViewCollected();
            checkViewReused();
        }
    }

    private void checkViewCollected() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && isViewCollected()) {
            throw new TaskCancelledException(this);
        }
    }

    private void checkViewReused() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) && isViewReused()) {
            throw new TaskCancelledException(this);
        }
    }

    private DecodedResult decodeImage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str)) == null) ? this.decoder.decode(new ImageDecodingInfo(this.memoryCacheKey, str, this.uri, this.targetSize, this.imageAware.getScaleType(), getDownloader(), this.options, this.listener)) : (DecodedResult) invokeL.objValue;
    }

    private boolean delayIfNeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            if (this.options.shouldDelayBeforeLoading()) {
                L.d(LOG_DELAY_BEFORE_LOADING, Integer.valueOf(this.options.getDelayBeforeLoading()), this.memoryCacheKey);
                try {
                    Thread.sleep(this.options.getDelayBeforeLoading());
                    return isTaskNotActual();
                } catch (InterruptedException unused) {
                    L.e(LOG_TASK_INTERRUPTED, this.memoryCacheKey);
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private boolean downloadImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            InputStream stream = getDownloader().getStream(this.uri, this.options.getExtraForDownloader());
            if (stream == null) {
                L.e("No stream for image [%s]", this.memoryCacheKey);
                return false;
            }
            try {
                return this.configuration.diskCache.save(this.uri, stream, this);
            } finally {
                IoUtils.closeSilently(stream);
            }
        }
        return invokeV.booleanValue;
    }

    private void fireCancelEvent() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || this.syncLoading || isTaskInterrupted()) {
            return;
        }
        runTask(new FireCancelEventRunnable(this), false, this.handler, this.engine);
    }

    private void fireFailEvent(FailReason.FailType failType, Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, this, failType, th) == null) || this.syncLoading || isTaskInterrupted() || isTaskNotActual()) {
            return;
        }
        runTask(new FireFailEventRunnable(this, failType, th), false, this.handler, this.engine);
    }

    private boolean fireProgressEvent(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65547, this, i2, i3)) == null) {
            if (isTaskInterrupted() || isTaskNotActual()) {
                return false;
            }
            if (this.progressListener != null) {
                runTask(new Runnable(this, i2, i3) { // from class: com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LoadAndDisplayImageTask this$0;
                    public final /* synthetic */ int val$current;
                    public final /* synthetic */ int val$total;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(i2), Integer.valueOf(i3)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$current = i2;
                        this.val$total = i3;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            LoadAndDisplayImageTask loadAndDisplayImageTask = this.this$0;
                            loadAndDisplayImageTask.progressListener.onProgressUpdate(loadAndDisplayImageTask.uri, loadAndDisplayImageTask.imageAware.getWrappedView(), this.val$current, this.val$total);
                        }
                    }
                }, false, this.handler, this.engine);
                return true;
            }
            return true;
        }
        return invokeII.booleanValue;
    }

    private ImageDownloader getDownloader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) ? this.engine.isNetworkDenied() ? this.networkDeniedDownloader : this.engine.isSlowNetwork() ? this.slowNetworkDownloader : this.downloader : (ImageDownloader) invokeV.objValue;
    }

    private boolean isTaskInterrupted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            if (Thread.interrupted()) {
                L.d(LOG_TASK_INTERRUPTED, this.memoryCacheKey);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private boolean isTaskNotActual() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) ? isViewCollected() || isViewReused() : invokeV.booleanValue;
    }

    private boolean isViewCollected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            if (this.imageAware.isCollected()) {
                L.d("ImageAware was collected by GC. Task is cancelled. [%s]", this.memoryCacheKey);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private boolean isViewReused() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            if (!this.memoryCacheKey.equals(this.engine.getLoadingUriForView(this.imageAware))) {
                L.d("ImageAware is reused for another image. Task is cancelled. [%s]", this.memoryCacheKey);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private boolean resizeAndSaveImage(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65553, this, i2, i3)) == null) {
            File file = this.configuration.diskCache.get(this.uri);
            if (file == null || !file.exists()) {
                return false;
            }
            DecodedResult decode = this.decoder.decode(new ImageDecodingInfo(this.memoryCacheKey, ImageDownloader.Scheme.FILE.wrap(file.getAbsolutePath()), this.uri, new ImageSize(i2, i3), ViewScaleType.FIT_INSIDE, getDownloader(), new DisplayImageOptions.Builder().cloneFrom(this.options).imageScaleType(ImageScaleType.IN_SAMPLE_INT).build(), this.listener));
            Bitmap bitmap = decode != null ? decode.mBitmap : null;
            if (bitmap != null && this.configuration.processorForDiskCache != null) {
                L.d(LOG_PROCESS_IMAGE_BEFORE_CACHE_ON_DISK, this.memoryCacheKey);
                bitmap = this.configuration.processorForDiskCache.process(bitmap);
                if (bitmap == null) {
                    L.e(ERROR_PROCESSOR_FOR_DISK_CACHE_NULL, this.memoryCacheKey);
                }
            }
            if (bitmap != null) {
                boolean save = this.configuration.diskCache.save(this.uri, bitmap);
                bitmap.recycle();
                return save;
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    public static void runTask(Runnable runnable, boolean z, Handler handler, ImageLoaderEngine imageLoaderEngine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65554, null, new Object[]{runnable, Boolean.valueOf(z), handler, imageLoaderEngine}) == null) {
            if (z) {
                runnable.run();
            } else if (handler == null) {
                imageLoaderEngine.fireCallback(runnable);
            } else {
                handler.post(runnable);
            }
        }
    }

    private boolean tryCacheImageOnDisk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
            L.d(LOG_CACHE_IMAGE_ON_DISK, this.memoryCacheKey);
            try {
                boolean downloadImage = downloadImage();
                if (downloadImage) {
                    int i2 = this.configuration.maxImageWidthForDiskCache;
                    int i3 = this.configuration.maxImageHeightForDiskCache;
                    if (i2 > 0 || i3 > 0) {
                        L.d(LOG_RESIZE_CACHED_IMAGE_FILE, this.memoryCacheKey);
                        resizeAndSaveImage(i2, i3);
                    }
                }
                return downloadImage;
            } catch (IOException e2) {
                L.e(e2);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004b, code lost:
        if (r1.isDecoded() == false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private DecodedResult tryLoadBitmap() {
        InterceptResult invokeV;
        DecodedResult decodedResult;
        FailReason.FailType failType;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65556, this)) != null) {
            return (DecodedResult) invokeV.objValue;
        }
        DecodedResult decodedResult2 = null;
        try {
            try {
                File file2 = this.configuration.diskCache.get(this.uri);
                if (file2 == null || !file2.exists() || file2.length() <= 0) {
                    decodedResult = null;
                } else {
                    L.d(LOG_LOAD_IMAGE_FROM_DISK_CACHE, this.memoryCacheKey);
                    this.loadedFrom = LoadedFrom.DISC_CACHE;
                    checkTaskNotActual();
                    decodedResult = decodeImage(ImageDownloader.Scheme.FILE.wrap(file2.getAbsolutePath()));
                }
                if (decodedResult != null) {
                    try {
                    } catch (IOException e2) {
                        DecodedResult decodedResult3 = decodedResult;
                        e = e2;
                        decodedResult2 = decodedResult3;
                        L.e(e);
                        failType = FailReason.FailType.IO_ERROR;
                        fireFailEvent(failType, e);
                        return decodedResult2;
                    } catch (IllegalStateException unused) {
                        fireFailEvent(FailReason.FailType.NETWORK_DENIED, null);
                        return decodedResult;
                    } catch (OutOfMemoryError e3) {
                        DecodedResult decodedResult4 = decodedResult;
                        e = e3;
                        decodedResult2 = decodedResult4;
                        L.e(e);
                        failType = FailReason.FailType.OUT_OF_MEMORY;
                        fireFailEvent(failType, e);
                        return decodedResult2;
                    } catch (Throwable th) {
                        DecodedResult decodedResult5 = decodedResult;
                        e = th;
                        decodedResult2 = decodedResult5;
                        L.e(e);
                        failType = FailReason.FailType.UNKNOWN;
                        fireFailEvent(failType, e);
                        return decodedResult2;
                    }
                }
                L.d(LOG_LOAD_IMAGE_FROM_NETWORK, this.memoryCacheKey);
                this.loadedFrom = LoadedFrom.NETWORK;
                String str = this.uri;
                if (this.options.isCacheOnDisk() && tryCacheImageOnDisk() && (file = this.configuration.diskCache.get(this.uri)) != null) {
                    str = ImageDownloader.Scheme.FILE.wrap(file.getAbsolutePath());
                }
                checkTaskNotActual();
                decodedResult = decodeImage(str);
                if (decodedResult == null || !decodedResult.isDecoded()) {
                    fireFailEvent(FailReason.FailType.DECODING_ERROR, null);
                    return decodedResult;
                }
                return decodedResult;
            } catch (TaskCancelledException e4) {
                throw e4;
            }
        } catch (IOException e5) {
            e = e5;
        } catch (IllegalStateException unused2) {
            decodedResult = null;
        } catch (OutOfMemoryError e6) {
            e = e6;
        } catch (Throwable th2) {
            e = th2;
        }
    }

    private boolean waitIfPaused() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            AtomicBoolean pause = this.engine.getPause();
            if (pause.get()) {
                synchronized (this.engine.getPauseLock()) {
                    if (pause.get()) {
                        L.d(LOG_WAITING_FOR_RESUME, this.memoryCacheKey);
                        try {
                            this.engine.getPauseLock().wait();
                            L.d(LOG_RESUME_AFTER_PAUSE, this.memoryCacheKey);
                        } catch (InterruptedException unused) {
                            L.e(LOG_TASK_INTERRUPTED, this.memoryCacheKey);
                            return true;
                        }
                    }
                }
            }
            return isTaskNotActual();
        }
        return invokeV.booleanValue;
    }

    public String getLoadingUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.uri : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.imageloader.utils.IoUtils.CopyListener
    public boolean onBytesCopied(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) ? this.syncLoading || fireProgressEvent(i2, i3) : invokeII.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00e8 A[Catch: all -> 0x0115, TaskCancelledException -> 0x0117, Merged into TryCatch #0 {all -> 0x0115, TaskCancelledException -> 0x0117, blocks: (B:14:0x0037, B:16:0x0046, B:19:0x004d, B:38:0x00c5, B:40:0x00cd, B:42:0x00e8, B:43:0x00f3, B:20:0x005d, B:22:0x0063, B:25:0x006b, B:27:0x0079, B:29:0x0088, B:30:0x0096, B:32:0x009a, B:34:0x00a7, B:36:0x00af, B:50:0x0117), top: B:58:0x0037 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Bitmap process;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || waitIfPaused() || delayIfNeed()) {
            return;
        }
        ReentrantLock reentrantLock = this.imageLoadingInfo.loadFromUriLock;
        L.d(LOG_START_DISPLAY_IMAGE_TASK, this.memoryCacheKey);
        if (reentrantLock.isLocked()) {
            L.d(LOG_WAITING_FOR_IMAGE_LOADED, this.memoryCacheKey);
        }
        reentrantLock.lock();
        try {
            checkTaskNotActual();
            DecodedResult decodedResult = this.configuration.memoryCache.get(this.memoryCacheKey);
            if (decodedResult != null && decodedResult.isDecoded()) {
                this.loadedFrom = LoadedFrom.MEMORY_CACHE;
                L.d(LOG_GET_IMAGE_FROM_MEMORY_CACHE_AFTER_WAITING, this.memoryCacheKey);
                if (decodedResult != null && this.options.shouldPostProcess()) {
                    L.d("PostProcess image before displaying [%s]", this.memoryCacheKey);
                    process = this.options.getPostProcessor().process(decodedResult.mBitmap);
                    decodedResult.mBitmap = process;
                    if (process == null) {
                        L.e(ERROR_POST_PROCESSOR_NULL, this.memoryCacheKey);
                    }
                }
                checkTaskNotActual();
                checkTaskInterrupted();
                reentrantLock.unlock();
                runTask(new DisplayBitmapTask(decodedResult, this.imageLoadingInfo, this.engine, this.loadedFrom), this.syncLoading, this.handler, this.engine);
            }
            decodedResult = tryLoadBitmap();
            if (decodedResult != null && decodedResult.isDecoded()) {
                checkTaskNotActual();
                checkTaskInterrupted();
                if (this.options.shouldPreProcess()) {
                    L.d(LOG_PREPROCESS_IMAGE, this.memoryCacheKey);
                    if (decodedResult.mBitmap != null) {
                        decodedResult.mBitmap = this.options.getPreProcessor().process(decodedResult.mBitmap);
                    }
                    if (decodedResult.mBitmap == null) {
                        L.e(ERROR_PRE_PROCESSOR_NULL, this.memoryCacheKey);
                    }
                }
                if (decodedResult != null && this.options.isCacheInMemory()) {
                    L.d(LOG_CACHE_IMAGE_IN_MEMORY, this.memoryCacheKey);
                    this.configuration.memoryCache.put(this.memoryCacheKey, decodedResult);
                }
                if (decodedResult != null) {
                    L.d("PostProcess image before displaying [%s]", this.memoryCacheKey);
                    process = this.options.getPostProcessor().process(decodedResult.mBitmap);
                    decodedResult.mBitmap = process;
                    if (process == null) {
                    }
                }
                checkTaskNotActual();
                checkTaskInterrupted();
                reentrantLock.unlock();
                runTask(new DisplayBitmapTask(decodedResult, this.imageLoadingInfo, this.engine, this.loadedFrom), this.syncLoading, this.handler, this.engine);
            }
        } catch (TaskCancelledException unused) {
            fireCancelEvent();
        } finally {
            reentrantLock.unlock();
        }
    }
}
