package com.kwad.sdk.core.imageloader.core;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.kwad.sdk.core.imageloader.cache.disc.DiskCache;
import com.kwad.sdk.core.imageloader.cache.disc.naming.FileNameGenerator;
import com.kwad.sdk.core.imageloader.cache.memory.MemoryCache;
import com.kwad.sdk.core.imageloader.cache.memory.impl.FuzzyKeyMemoryCache;
import com.kwad.sdk.core.imageloader.core.assist.FlushedInputStream;
import com.kwad.sdk.core.imageloader.core.assist.ImageSize;
import com.kwad.sdk.core.imageloader.core.assist.QueueProcessingType;
import com.kwad.sdk.core.imageloader.core.decode.ImageDecoder;
import com.kwad.sdk.core.imageloader.core.download.ConnectionConfig;
import com.kwad.sdk.core.imageloader.core.download.ImageDownloader;
import com.kwad.sdk.core.imageloader.core.process.BitmapProcessor;
import com.kwad.sdk.core.imageloader.utils.L;
import com.kwad.sdk.core.imageloader.utils.MemoryCacheUtils;
import java.io.InputStream;
import java.util.concurrent.Executor;
/* loaded from: classes3.dex */
public final class ImageLoaderConfiguration {
    public final boolean customExecutor;
    public final boolean customExecutorForCachedImages;
    public final ImageDecoder decoder;
    public final DisplayImageOptions defaultDisplayImageOptions;
    public final DiskCache diskCache;
    public final ImageDownloader downloader;
    public final int maxImageHeightForDiskCache;
    public final int maxImageHeightForMemoryCache;
    public final int maxImageWidthForDiskCache;
    public final int maxImageWidthForMemoryCache;
    public final MemoryCache memoryCache;
    public final ImageDownloader networkDeniedDownloader;
    public final BitmapProcessor processorForDiskCache;
    public final Resources resources;
    public final ImageDownloader slowNetworkDownloader;
    public final Executor taskDistributor;
    public final Executor taskExecutor;
    public final Executor taskExecutorForCachedImages;
    public final QueueProcessingType tasksProcessingType;
    public final int threadPoolSize;
    public final int threadPriority;

    /* renamed from: com.kwad.sdk.core.imageloader.core.ImageLoaderConfiguration$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$kwad$sdk$core$imageloader$core$download$ImageDownloader$Scheme;

        static {
            int[] iArr = new int[ImageDownloader.Scheme.values().length];
            $SwitchMap$com$kwad$sdk$core$imageloader$core$download$ImageDownloader$Scheme = iArr;
            try {
                iArr[ImageDownloader.Scheme.HTTP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.HTTPS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class Builder {
        public static final QueueProcessingType DEFAULT_TASK_PROCESSING_TYPE = QueueProcessingType.FIFO;
        public static final int DEFAULT_THREAD_POOL_SIZE = 3;
        public static final int DEFAULT_THREAD_PRIORITY = 3;
        public static final String WARNING_OVERLAP_DISK_CACHE_NAME_GENERATOR = "diskCache() and diskCacheFileNameGenerator() calls overlap each other";
        public static final String WARNING_OVERLAP_DISK_CACHE_PARAMS = "diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other";
        public static final String WARNING_OVERLAP_EXECUTOR = "threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.";
        public static final String WARNING_OVERLAP_MEMORY_CACHE = "memoryCache() and memoryCacheSize() calls overlap each other";
        public String cacheParentDir;
        public ConnectionConfig connectionConfig;
        public Context context;
        public ImageDecoder decoder;
        public int maxImageWidthForMemoryCache = 0;
        public int maxImageHeightForMemoryCache = 0;
        public int maxImageWidthForDiskCache = 0;
        public int maxImageHeightForDiskCache = 0;
        public BitmapProcessor processorForDiskCache = null;
        public Executor taskExecutor = null;
        public Executor taskExecutorForCachedImages = null;
        public Executor taskDistributor = null;
        public boolean customExecutor = false;
        public boolean customExecutorForCachedImages = false;
        public int threadPoolSize = 3;
        public int threadPriority = 3;
        public boolean denyCacheImageMultipleSizesInMemory = false;
        public QueueProcessingType tasksProcessingType = DEFAULT_TASK_PROCESSING_TYPE;
        public int memoryCacheSize = 0;
        public long diskCacheSize = 0;
        public int diskCacheFileCount = 0;
        public MemoryCache memoryCache = null;
        public DiskCache diskCache = null;
        public FileNameGenerator diskCacheFileNameGenerator = null;
        public ImageDownloader downloader = null;
        public DisplayImageOptions defaultDisplayImageOptions = null;
        public boolean writeLogs = false;

        public Builder(Context context) {
            this.context = context.getApplicationContext();
        }

        private void initEmptyFieldsWithDefaultValues() {
            if (this.taskExecutor == null) {
                this.taskExecutor = DefaultConfigurationFactory.createExecutor(this.threadPoolSize, this.threadPriority, this.tasksProcessingType);
            } else {
                this.customExecutor = true;
            }
            if (this.taskExecutorForCachedImages == null) {
                this.taskExecutorForCachedImages = DefaultConfigurationFactory.createExecutor(this.threadPoolSize, this.threadPriority, this.tasksProcessingType);
            } else {
                this.customExecutorForCachedImages = true;
            }
            if (this.taskDistributor == null) {
                this.taskDistributor = DefaultConfigurationFactory.createTaskDistributor();
            }
            if (this.diskCache == null) {
                if (this.diskCacheFileNameGenerator == null) {
                    this.diskCacheFileNameGenerator = DefaultConfigurationFactory.createFileNameGenerator();
                }
                if (this.cacheParentDir == null) {
                    this.cacheParentDir = this.context.getExternalCacheDir().getPath();
                }
                this.diskCache = DefaultConfigurationFactory.createDiskCache(this.context, this.diskCacheFileNameGenerator, this.diskCacheSize, this.diskCacheFileCount, this.cacheParentDir);
            }
            if (this.memoryCache == null) {
                this.memoryCache = DefaultConfigurationFactory.createMemoryCache(this.context, this.memoryCacheSize);
            }
            if (this.denyCacheImageMultipleSizesInMemory) {
                this.memoryCache = new FuzzyKeyMemoryCache(this.memoryCache, MemoryCacheUtils.createFuzzyKeyComparator());
            }
            if (this.downloader == null) {
                this.downloader = DefaultConfigurationFactory.createImageDownloader(this.context);
            }
            if (this.decoder == null) {
                this.decoder = DefaultConfigurationFactory.createImageDecoder(this.writeLogs);
            }
            if (this.defaultDisplayImageOptions == null) {
                this.defaultDisplayImageOptions = DisplayImageOptions.createSimple();
            }
        }

        public ImageLoaderConfiguration build() {
            initEmptyFieldsWithDefaultValues();
            return new ImageLoaderConfiguration(this, null);
        }

        public Builder cacheParentDir(String str) {
            this.cacheParentDir = str;
            return this;
        }

        public Builder connectionConfig(ConnectionConfig connectionConfig) {
            this.connectionConfig = connectionConfig;
            return this;
        }

        public Builder defaultDisplayImageOptions(DisplayImageOptions displayImageOptions) {
            this.defaultDisplayImageOptions = displayImageOptions;
            return this;
        }

        public Builder denyCacheImageMultipleSizesInMemory() {
            this.denyCacheImageMultipleSizesInMemory = true;
            return this;
        }

        @Deprecated
        public Builder discCache(DiskCache diskCache) {
            return diskCache(diskCache);
        }

        @Deprecated
        public Builder discCacheExtraOptions(int i2, int i3, BitmapProcessor bitmapProcessor) {
            return diskCacheExtraOptions(i2, i3, bitmapProcessor);
        }

        @Deprecated
        public Builder discCacheFileCount(int i2) {
            return diskCacheFileCount(i2);
        }

        @Deprecated
        public Builder discCacheFileNameGenerator(FileNameGenerator fileNameGenerator) {
            return diskCacheFileNameGenerator(fileNameGenerator);
        }

        @Deprecated
        public Builder discCacheSize(int i2) {
            return diskCacheSize(i2);
        }

        public Builder diskCache(DiskCache diskCache) {
            if (this.diskCacheSize > 0 || this.diskCacheFileCount > 0) {
                L.w(WARNING_OVERLAP_DISK_CACHE_PARAMS, new Object[0]);
            }
            if (this.diskCacheFileNameGenerator != null) {
                L.w(WARNING_OVERLAP_DISK_CACHE_NAME_GENERATOR, new Object[0]);
            }
            this.diskCache = diskCache;
            return this;
        }

        public Builder diskCacheExtraOptions(int i2, int i3, BitmapProcessor bitmapProcessor) {
            this.maxImageWidthForDiskCache = i2;
            this.maxImageHeightForDiskCache = i3;
            this.processorForDiskCache = bitmapProcessor;
            return this;
        }

        public Builder diskCacheFileCount(int i2) {
            if (i2 > 0) {
                if (this.diskCache != null) {
                    L.w(WARNING_OVERLAP_DISK_CACHE_PARAMS, new Object[0]);
                }
                this.diskCacheFileCount = i2;
                return this;
            }
            throw new IllegalArgumentException("maxFileCount must be a positive number");
        }

        public Builder diskCacheFileNameGenerator(FileNameGenerator fileNameGenerator) {
            if (this.diskCache != null) {
                L.w(WARNING_OVERLAP_DISK_CACHE_NAME_GENERATOR, new Object[0]);
            }
            this.diskCacheFileNameGenerator = fileNameGenerator;
            return this;
        }

        public Builder diskCacheSize(int i2) {
            if (i2 > 0) {
                if (this.diskCache != null) {
                    L.w(WARNING_OVERLAP_DISK_CACHE_PARAMS, new Object[0]);
                }
                this.diskCacheSize = i2;
                return this;
            }
            throw new IllegalArgumentException("maxCacheSize must be a positive number");
        }

        public Builder imageDecoder(ImageDecoder imageDecoder) {
            this.decoder = imageDecoder;
            return this;
        }

        public Builder imageDownloader(ImageDownloader imageDownloader) {
            this.downloader = imageDownloader;
            return this;
        }

        public Builder memoryCache(MemoryCache memoryCache) {
            if (this.memoryCacheSize != 0) {
                L.w(WARNING_OVERLAP_MEMORY_CACHE, new Object[0]);
            }
            this.memoryCache = memoryCache;
            return this;
        }

        public Builder memoryCacheExtraOptions(int i2, int i3) {
            this.maxImageWidthForMemoryCache = i2;
            this.maxImageHeightForMemoryCache = i3;
            return this;
        }

        public Builder memoryCacheSize(int i2) {
            if (i2 > 0) {
                if (this.memoryCache != null) {
                    L.w(WARNING_OVERLAP_MEMORY_CACHE, new Object[0]);
                }
                this.memoryCacheSize = i2;
                return this;
            }
            throw new IllegalArgumentException("memoryCacheSize must be a positive number");
        }

        public Builder memoryCacheSizePercentage(int i2) {
            if (i2 <= 0 || i2 >= 100) {
                throw new IllegalArgumentException("availableMemoryPercent must be in range (0 < % < 100)");
            }
            if (this.memoryCache != null) {
                L.w(WARNING_OVERLAP_MEMORY_CACHE, new Object[0]);
            }
            this.memoryCacheSize = (int) (((float) Runtime.getRuntime().maxMemory()) * (i2 / 100.0f));
            return this;
        }

        public Builder setTaskDistributor(Executor executor) {
            this.taskDistributor = executor;
            return this;
        }

        public Builder taskExecutor(Executor executor) {
            if (this.threadPoolSize != 3 || this.threadPriority != 3 || this.tasksProcessingType != DEFAULT_TASK_PROCESSING_TYPE) {
                L.w(WARNING_OVERLAP_EXECUTOR, new Object[0]);
            }
            this.taskExecutor = executor;
            return this;
        }

        public Builder taskExecutorForCachedImages(Executor executor) {
            if (this.threadPoolSize != 3 || this.threadPriority != 3 || this.tasksProcessingType != DEFAULT_TASK_PROCESSING_TYPE) {
                L.w(WARNING_OVERLAP_EXECUTOR, new Object[0]);
            }
            this.taskExecutorForCachedImages = executor;
            return this;
        }

        public Builder tasksProcessingOrder(QueueProcessingType queueProcessingType) {
            if (this.taskExecutor != null || this.taskExecutorForCachedImages != null) {
                L.w(WARNING_OVERLAP_EXECUTOR, new Object[0]);
            }
            this.tasksProcessingType = queueProcessingType;
            return this;
        }

        public Builder threadPoolSize(int i2) {
            if (this.taskExecutor != null || this.taskExecutorForCachedImages != null) {
                L.w(WARNING_OVERLAP_EXECUTOR, new Object[0]);
            }
            this.threadPoolSize = i2;
            return this;
        }

        public Builder threadPriority(int i2) {
            if (this.taskExecutor != null || this.taskExecutorForCachedImages != null) {
                L.w(WARNING_OVERLAP_EXECUTOR, new Object[0]);
            }
            int i3 = 1;
            if (i2 >= 1) {
                i3 = 10;
                if (i2 <= 10) {
                    this.threadPriority = i2;
                    return this;
                }
            }
            this.threadPriority = i3;
            return this;
        }

        public Builder writeDebugLogs() {
            this.writeLogs = true;
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static class NetworkDeniedImageDownloader implements ImageDownloader {
        public final ImageDownloader wrappedDownloader;

        public NetworkDeniedImageDownloader(ImageDownloader imageDownloader) {
            this.wrappedDownloader = imageDownloader;
        }

        @Override // com.kwad.sdk.core.imageloader.core.download.ImageDownloader
        public InputStream getStream(String str, Object obj) {
            int i2 = AnonymousClass1.$SwitchMap$com$kwad$sdk$core$imageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.ofUri(str).ordinal()];
            if (i2 == 1 || i2 == 2) {
                throw new IllegalStateException();
            }
            return this.wrappedDownloader.getStream(str, obj);
        }
    }

    /* loaded from: classes3.dex */
    public static class SlowNetworkImageDownloader implements ImageDownloader {
        public final ImageDownloader wrappedDownloader;

        public SlowNetworkImageDownloader(ImageDownloader imageDownloader) {
            this.wrappedDownloader = imageDownloader;
        }

        @Override // com.kwad.sdk.core.imageloader.core.download.ImageDownloader
        public InputStream getStream(String str, Object obj) {
            InputStream stream = this.wrappedDownloader.getStream(str, obj);
            int i2 = AnonymousClass1.$SwitchMap$com$kwad$sdk$core$imageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.ofUri(str).ordinal()];
            return (i2 == 1 || i2 == 2) ? new FlushedInputStream(stream) : stream;
        }
    }

    public ImageLoaderConfiguration(Builder builder) {
        this.resources = builder.context.getResources();
        this.maxImageWidthForMemoryCache = builder.maxImageWidthForMemoryCache;
        this.maxImageHeightForMemoryCache = builder.maxImageHeightForMemoryCache;
        this.maxImageWidthForDiskCache = builder.maxImageWidthForDiskCache;
        this.maxImageHeightForDiskCache = builder.maxImageHeightForDiskCache;
        this.processorForDiskCache = builder.processorForDiskCache;
        this.taskExecutor = builder.taskExecutor;
        this.taskExecutorForCachedImages = builder.taskExecutorForCachedImages;
        this.taskDistributor = builder.taskDistributor;
        this.threadPoolSize = builder.threadPoolSize;
        this.threadPriority = builder.threadPriority;
        this.tasksProcessingType = builder.tasksProcessingType;
        this.diskCache = builder.diskCache;
        this.memoryCache = builder.memoryCache;
        this.defaultDisplayImageOptions = builder.defaultDisplayImageOptions;
        this.downloader = builder.downloader;
        this.decoder = builder.decoder;
        this.customExecutor = builder.customExecutor;
        this.customExecutorForCachedImages = builder.customExecutorForCachedImages;
        this.networkDeniedDownloader = new NetworkDeniedImageDownloader(this.downloader);
        this.slowNetworkDownloader = new SlowNetworkImageDownloader(this.downloader);
        L.writeDebugLogs(builder.writeLogs);
    }

    public /* synthetic */ ImageLoaderConfiguration(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public static ImageLoaderConfiguration createDefault(Context context) {
        return new Builder(context).build();
    }

    public ImageSize getMaxImageSize() {
        DisplayMetrics displayMetrics = this.resources.getDisplayMetrics();
        int i2 = this.maxImageWidthForMemoryCache;
        if (i2 <= 0) {
            i2 = displayMetrics.widthPixels;
        }
        int i3 = this.maxImageHeightForMemoryCache;
        if (i3 <= 0) {
            i3 = displayMetrics.heightPixels;
        }
        return new ImageSize(i2, i3);
    }
}
