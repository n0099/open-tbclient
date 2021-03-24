package com.kwad.sdk.core.imageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
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
/* loaded from: classes6.dex */
public final class LoadAndDisplayImageTask implements IoUtils.CopyListener, Runnable {
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
    public final ImageLoaderConfiguration configuration;
    public final ImageDecoder decoder;
    public final ImageDownloader downloader;
    public final ImageLoaderEngine engine;
    public final Handler handler;
    public final ImageAware imageAware;
    public final ImageLoadingInfo imageLoadingInfo;
    public final ImageLoadingListener listener;
    public LoadedFrom loadedFrom = LoadedFrom.NETWORK;
    public final String memoryCacheKey;
    public final ImageDownloader networkDeniedDownloader;
    public final DisplayImageOptions options;
    public final ImageLoadingProgressListener progressListener;
    public final ImageDownloader slowNetworkDownloader;
    public final boolean syncLoading;
    public final ImageSize targetSize;
    public final String uri;

    /* loaded from: classes6.dex */
    public static class FireCancelEventRunnable implements Runnable {
        public WeakReference<LoadAndDisplayImageTask> weakReference;

        public FireCancelEventRunnable(LoadAndDisplayImageTask loadAndDisplayImageTask) {
            this.weakReference = new WeakReference<>(loadAndDisplayImageTask);
        }

        @Override // java.lang.Runnable
        public void run() {
            LoadAndDisplayImageTask loadAndDisplayImageTask = this.weakReference.get();
            if (loadAndDisplayImageTask != null) {
                loadAndDisplayImageTask.listener.onLoadingCancelled(loadAndDisplayImageTask.uri, loadAndDisplayImageTask.imageAware.getWrappedView());
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class FireFailEventRunnable implements Runnable {
        public final Throwable failCause;
        public final FailReason.FailType failType;
        public WeakReference<LoadAndDisplayImageTask> weakReference;

        public FireFailEventRunnable(LoadAndDisplayImageTask loadAndDisplayImageTask, FailReason.FailType failType, Throwable th) {
            this.weakReference = new WeakReference<>(loadAndDisplayImageTask);
            this.failCause = th;
            this.failType = failType;
        }

        @Override // java.lang.Runnable
        public void run() {
            LoadAndDisplayImageTask loadAndDisplayImageTask = this.weakReference.get();
            if (loadAndDisplayImageTask != null) {
                if (loadAndDisplayImageTask.options.shouldShowImageOnFail()) {
                    loadAndDisplayImageTask.imageAware.setImageDrawable(loadAndDisplayImageTask.options.getImageOnFail(loadAndDisplayImageTask.configuration.resources));
                }
                loadAndDisplayImageTask.listener.onLoadingFailed(loadAndDisplayImageTask.uri, loadAndDisplayImageTask.imageAware.getWrappedView(), new FailReason(this.failType, this.failCause));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class TaskCancelledException extends Exception {
        public TaskCancelledException() {
        }
    }

    public LoadAndDisplayImageTask(ImageLoaderEngine imageLoaderEngine, ImageLoadingInfo imageLoadingInfo, Handler handler) {
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
        if (isTaskInterrupted()) {
            throw new TaskCancelledException();
        }
    }

    private void checkTaskNotActual() {
        checkViewCollected();
        checkViewReused();
    }

    private void checkViewCollected() {
        if (isViewCollected()) {
            throw new TaskCancelledException();
        }
    }

    private void checkViewReused() {
        if (isViewReused()) {
            throw new TaskCancelledException();
        }
    }

    private DecodedResult decodeImage(String str) {
        return this.decoder.decode(new ImageDecodingInfo(this.memoryCacheKey, str, this.uri, this.targetSize, this.imageAware.getScaleType(), getDownloader(), this.options, this.listener));
    }

    private boolean delayIfNeed() {
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

    private boolean downloadImage() {
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

    private void fireCancelEvent() {
        if (this.syncLoading || isTaskInterrupted()) {
            return;
        }
        runTask(new FireCancelEventRunnable(this), false, this.handler, this.engine);
    }

    private void fireFailEvent(FailReason.FailType failType, Throwable th) {
        if (this.syncLoading || isTaskInterrupted() || isTaskNotActual()) {
            return;
        }
        runTask(new FireFailEventRunnable(this, failType, th), false, this.handler, this.engine);
    }

    private boolean fireProgressEvent(final int i, final int i2) {
        if (isTaskInterrupted() || isTaskNotActual()) {
            return false;
        }
        if (this.progressListener != null) {
            runTask(new Runnable() { // from class: com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.1
                @Override // java.lang.Runnable
                public void run() {
                    LoadAndDisplayImageTask loadAndDisplayImageTask = LoadAndDisplayImageTask.this;
                    loadAndDisplayImageTask.progressListener.onProgressUpdate(loadAndDisplayImageTask.uri, loadAndDisplayImageTask.imageAware.getWrappedView(), i, i2);
                }
            }, false, this.handler, this.engine);
            return true;
        }
        return true;
    }

    private ImageDownloader getDownloader() {
        return this.engine.isNetworkDenied() ? this.networkDeniedDownloader : this.engine.isSlowNetwork() ? this.slowNetworkDownloader : this.downloader;
    }

    private boolean isTaskInterrupted() {
        if (Thread.interrupted()) {
            L.d(LOG_TASK_INTERRUPTED, this.memoryCacheKey);
            return true;
        }
        return false;
    }

    private boolean isTaskNotActual() {
        return isViewCollected() || isViewReused();
    }

    private boolean isViewCollected() {
        if (this.imageAware.isCollected()) {
            L.d("ImageAware was collected by GC. Task is cancelled. [%s]", this.memoryCacheKey);
            return true;
        }
        return false;
    }

    private boolean isViewReused() {
        if (!this.memoryCacheKey.equals(this.engine.getLoadingUriForView(this.imageAware))) {
            L.d("ImageAware is reused for another image. Task is cancelled. [%s]", this.memoryCacheKey);
            return true;
        }
        return false;
    }

    private boolean resizeAndSaveImage(int i, int i2) {
        File file = this.configuration.diskCache.get(this.uri);
        if (file == null || !file.exists()) {
            return false;
        }
        DecodedResult decode = this.decoder.decode(new ImageDecodingInfo(this.memoryCacheKey, ImageDownloader.Scheme.FILE.wrap(file.getAbsolutePath()), this.uri, new ImageSize(i, i2), ViewScaleType.FIT_INSIDE, getDownloader(), new DisplayImageOptions.Builder().cloneFrom(this.options).imageScaleType(ImageScaleType.IN_SAMPLE_INT).build(), this.listener));
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

    public static void runTask(Runnable runnable, boolean z, Handler handler, ImageLoaderEngine imageLoaderEngine) {
        if (z) {
            runnable.run();
        } else if (handler == null) {
            imageLoaderEngine.fireCallback(runnable);
        } else {
            handler.post(runnable);
        }
    }

    private boolean tryCacheImageOnDisk() {
        L.d(LOG_CACHE_IMAGE_ON_DISK, this.memoryCacheKey);
        try {
            boolean downloadImage = downloadImage();
            if (downloadImage) {
                int i = this.configuration.maxImageWidthForDiskCache;
                int i2 = this.configuration.maxImageHeightForDiskCache;
                if (i > 0 || i2 > 0) {
                    L.d(LOG_RESIZE_CACHED_IMAGE_FILE, this.memoryCacheKey);
                    resizeAndSaveImage(i, i2);
                }
            }
            return downloadImage;
        } catch (IOException e2) {
            L.e(e2);
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0047, code lost:
        if (r1.isDecoded() == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private DecodedResult tryLoadBitmap() {
        DecodedResult decodedResult;
        FailReason.FailType failType;
        File file;
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

    public String getLoadingUri() {
        return this.uri;
    }

    @Override // com.kwad.sdk.core.imageloader.utils.IoUtils.CopyListener
    public boolean onBytesCopied(int i, int i2) {
        return this.syncLoading || fireProgressEvent(i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00e4 A[Catch: all -> 0x0111, TaskCancelledException -> 0x0113, Merged into TryCatch #0 {all -> 0x0111, TaskCancelledException -> 0x0113, blocks: (B:12:0x0033, B:14:0x0042, B:17:0x0049, B:36:0x00c1, B:38:0x00c9, B:40:0x00e4, B:41:0x00ef, B:18:0x0059, B:20:0x005f, B:23:0x0067, B:25:0x0075, B:27:0x0084, B:28:0x0092, B:30:0x0096, B:32:0x00a3, B:34:0x00ab, B:48:0x0113), top: B:53:0x0033 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Bitmap process;
        if (waitIfPaused() || delayIfNeed()) {
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
