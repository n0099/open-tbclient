package com.kwad.sdk.core.imageloader.core;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
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
import com.kwad.sdk.core.imageloader.cache.disc.naming.FileNameGenerator;
import com.kwad.sdk.core.imageloader.cache.memory.MemoryCache;
import com.kwad.sdk.core.imageloader.cache.memory.impl.FuzzyKeyMemoryCache;
import com.kwad.sdk.core.imageloader.core.assist.FlushedInputStream;
import com.kwad.sdk.core.imageloader.core.assist.ImageSize;
import com.kwad.sdk.core.imageloader.core.assist.QueueProcessingType;
import com.kwad.sdk.core.imageloader.core.decode.ImageDecoder;
import com.kwad.sdk.core.imageloader.core.download.ImageDownloader;
import com.kwad.sdk.core.imageloader.core.process.BitmapProcessor;
import com.kwad.sdk.core.imageloader.utils.L;
import com.kwad.sdk.core.imageloader.utils.MemoryCacheUtils;
import java.io.InputStream;
import java.util.concurrent.Executor;
/* loaded from: classes10.dex */
public final class ImageLoaderConfiguration {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
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
    public final Executor taskExecutor;
    public final Executor taskExecutorForCachedImages;
    public final QueueProcessingType tasksProcessingType;
    public final int threadPoolSize;
    public final int threadPriority;

    /* renamed from: com.kwad.sdk.core.imageloader.core.ImageLoaderConfiguration$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$kwad$sdk$core$imageloader$core$download$ImageDownloader$Scheme;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-312944852, "Lcom/kwad/sdk/core/imageloader/core/ImageLoaderConfiguration$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-312944852, "Lcom/kwad/sdk/core/imageloader/core/ImageLoaderConfiguration$1;");
                    return;
                }
            }
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

    /* loaded from: classes10.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final QueueProcessingType DEFAULT_TASK_PROCESSING_TYPE;
        public static final int DEFAULT_THREAD_POOL_SIZE = 3;
        public static final int DEFAULT_THREAD_PRIORITY = 3;
        public static final String WARNING_OVERLAP_DISK_CACHE_NAME_GENERATOR = "diskCache() and diskCacheFileNameGenerator() calls overlap each other";
        public static final String WARNING_OVERLAP_DISK_CACHE_PARAMS = "diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other";
        public static final String WARNING_OVERLAP_EXECUTOR = "threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.";
        public static final String WARNING_OVERLAP_MEMORY_CACHE = "memoryCache() and memoryCacheSize() calls overlap each other";
        public transient /* synthetic */ FieldHolder $fh;
        public Context context;
        public boolean customExecutor;
        public boolean customExecutorForCachedImages;
        public ImageDecoder decoder;
        public DisplayImageOptions defaultDisplayImageOptions;
        public boolean denyCacheImageMultipleSizesInMemory;
        public DiskCache diskCache;
        public int diskCacheFileCount;
        public FileNameGenerator diskCacheFileNameGenerator;
        public long diskCacheSize;
        public ImageDownloader downloader;
        public int maxImageHeightForDiskCache;
        public int maxImageHeightForMemoryCache;
        public int maxImageWidthForDiskCache;
        public int maxImageWidthForMemoryCache;
        public MemoryCache memoryCache;
        public int memoryCacheSize;
        public BitmapProcessor processorForDiskCache;
        public Executor taskExecutor;
        public Executor taskExecutorForCachedImages;
        public QueueProcessingType tasksProcessingType;
        public int threadPoolSize;
        public int threadPriority;
        public boolean writeLogs;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1709641822, "Lcom/kwad/sdk/core/imageloader/core/ImageLoaderConfiguration$Builder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1709641822, "Lcom/kwad/sdk/core/imageloader/core/ImageLoaderConfiguration$Builder;");
                    return;
                }
            }
            DEFAULT_TASK_PROCESSING_TYPE = QueueProcessingType.FIFO;
        }

        public Builder(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.maxImageWidthForMemoryCache = 0;
            this.maxImageHeightForMemoryCache = 0;
            this.maxImageWidthForDiskCache = 0;
            this.maxImageHeightForDiskCache = 0;
            this.processorForDiskCache = null;
            this.taskExecutor = null;
            this.taskExecutorForCachedImages = null;
            this.customExecutor = false;
            this.customExecutorForCachedImages = false;
            this.threadPoolSize = 3;
            this.threadPriority = 3;
            this.denyCacheImageMultipleSizesInMemory = false;
            this.tasksProcessingType = DEFAULT_TASK_PROCESSING_TYPE;
            this.memoryCacheSize = 0;
            this.diskCacheSize = 0L;
            this.diskCacheFileCount = 0;
            this.memoryCache = null;
            this.diskCache = null;
            this.diskCacheFileNameGenerator = null;
            this.downloader = null;
            this.defaultDisplayImageOptions = null;
            this.writeLogs = false;
            this.context = context.getApplicationContext();
        }

        private void initEmptyFieldsWithDefaultValues() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65557, this) == null) {
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
                if (this.diskCache == null) {
                    if (this.diskCacheFileNameGenerator == null) {
                        this.diskCacheFileNameGenerator = DefaultConfigurationFactory.createFileNameGenerator();
                    }
                    this.diskCache = DefaultConfigurationFactory.createDiskCache(this.context, this.diskCacheFileNameGenerator, this.diskCacheSize, this.diskCacheFileCount);
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
        }

        public ImageLoaderConfiguration build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                initEmptyFieldsWithDefaultValues();
                return new ImageLoaderConfiguration(this, null);
            }
            return (ImageLoaderConfiguration) invokeV.objValue;
        }

        public Builder defaultDisplayImageOptions(DisplayImageOptions displayImageOptions) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, displayImageOptions)) == null) {
                this.defaultDisplayImageOptions = displayImageOptions;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder denyCacheImageMultipleSizesInMemory() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                this.denyCacheImageMultipleSizesInMemory = true;
                return this;
            }
            return (Builder) invokeV.objValue;
        }

        @Deprecated
        public Builder discCache(DiskCache diskCache) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, diskCache)) == null) ? diskCache(diskCache) : (Builder) invokeL.objValue;
        }

        @Deprecated
        public Builder discCacheExtraOptions(int i2, int i3, BitmapProcessor bitmapProcessor) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048580, this, i2, i3, bitmapProcessor)) == null) ? diskCacheExtraOptions(i2, i3, bitmapProcessor) : (Builder) invokeIIL.objValue;
        }

        @Deprecated
        public Builder discCacheFileCount(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? diskCacheFileCount(i2) : (Builder) invokeI.objValue;
        }

        @Deprecated
        public Builder discCacheFileNameGenerator(FileNameGenerator fileNameGenerator) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, fileNameGenerator)) == null) ? diskCacheFileNameGenerator(fileNameGenerator) : (Builder) invokeL.objValue;
        }

        @Deprecated
        public Builder discCacheSize(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? diskCacheSize(i2) : (Builder) invokeI.objValue;
        }

        public Builder diskCache(DiskCache diskCache) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, diskCache)) == null) {
                if (this.diskCacheSize > 0 || this.diskCacheFileCount > 0) {
                    L.w(WARNING_OVERLAP_DISK_CACHE_PARAMS, new Object[0]);
                }
                if (this.diskCacheFileNameGenerator != null) {
                    L.w(WARNING_OVERLAP_DISK_CACHE_NAME_GENERATOR, new Object[0]);
                }
                this.diskCache = diskCache;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder diskCacheExtraOptions(int i2, int i3, BitmapProcessor bitmapProcessor) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048585, this, i2, i3, bitmapProcessor)) == null) {
                this.maxImageWidthForDiskCache = i2;
                this.maxImageHeightForDiskCache = i3;
                this.processorForDiskCache = bitmapProcessor;
                return this;
            }
            return (Builder) invokeIIL.objValue;
        }

        public Builder diskCacheFileCount(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
                if (i2 > 0) {
                    if (this.diskCache != null) {
                        L.w(WARNING_OVERLAP_DISK_CACHE_PARAMS, new Object[0]);
                    }
                    this.diskCacheFileCount = i2;
                    return this;
                }
                throw new IllegalArgumentException("maxFileCount must be a positive number");
            }
            return (Builder) invokeI.objValue;
        }

        public Builder diskCacheFileNameGenerator(FileNameGenerator fileNameGenerator) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, fileNameGenerator)) == null) {
                if (this.diskCache != null) {
                    L.w(WARNING_OVERLAP_DISK_CACHE_NAME_GENERATOR, new Object[0]);
                }
                this.diskCacheFileNameGenerator = fileNameGenerator;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder diskCacheSize(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
                if (i2 > 0) {
                    if (this.diskCache != null) {
                        L.w(WARNING_OVERLAP_DISK_CACHE_PARAMS, new Object[0]);
                    }
                    this.diskCacheSize = i2;
                    return this;
                }
                throw new IllegalArgumentException("maxCacheSize must be a positive number");
            }
            return (Builder) invokeI.objValue;
        }

        public Builder imageDecoder(ImageDecoder imageDecoder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, imageDecoder)) == null) {
                this.decoder = imageDecoder;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder imageDownloader(ImageDownloader imageDownloader) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, imageDownloader)) == null) {
                this.downloader = imageDownloader;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder memoryCache(MemoryCache memoryCache) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, memoryCache)) == null) {
                if (this.memoryCacheSize != 0) {
                    L.w(WARNING_OVERLAP_MEMORY_CACHE, new Object[0]);
                }
                this.memoryCache = memoryCache;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder memoryCacheExtraOptions(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048592, this, i2, i3)) == null) {
                this.maxImageWidthForMemoryCache = i2;
                this.maxImageHeightForMemoryCache = i3;
                return this;
            }
            return (Builder) invokeII.objValue;
        }

        public Builder memoryCacheSize(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
                if (i2 > 0) {
                    if (this.memoryCache != null) {
                        L.w(WARNING_OVERLAP_MEMORY_CACHE, new Object[0]);
                    }
                    this.memoryCacheSize = i2;
                    return this;
                }
                throw new IllegalArgumentException("memoryCacheSize must be a positive number");
            }
            return (Builder) invokeI.objValue;
        }

        public Builder memoryCacheSizePercentage(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
                if (i2 <= 0 || i2 >= 100) {
                    throw new IllegalArgumentException("availableMemoryPercent must be in range (0 < % < 100)");
                }
                if (this.memoryCache != null) {
                    L.w(WARNING_OVERLAP_MEMORY_CACHE, new Object[0]);
                }
                this.memoryCacheSize = (int) (((float) Runtime.getRuntime().maxMemory()) * (i2 / 100.0f));
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder taskExecutor(Executor executor) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, executor)) == null) {
                if (this.threadPoolSize != 3 || this.threadPriority != 3 || this.tasksProcessingType != DEFAULT_TASK_PROCESSING_TYPE) {
                    L.w(WARNING_OVERLAP_EXECUTOR, new Object[0]);
                }
                this.taskExecutor = executor;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder taskExecutorForCachedImages(Executor executor) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, executor)) == null) {
                if (this.threadPoolSize != 3 || this.threadPriority != 3 || this.tasksProcessingType != DEFAULT_TASK_PROCESSING_TYPE) {
                    L.w(WARNING_OVERLAP_EXECUTOR, new Object[0]);
                }
                this.taskExecutorForCachedImages = executor;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder tasksProcessingOrder(QueueProcessingType queueProcessingType) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, queueProcessingType)) == null) {
                if (this.taskExecutor != null || this.taskExecutorForCachedImages != null) {
                    L.w(WARNING_OVERLAP_EXECUTOR, new Object[0]);
                }
                this.tasksProcessingType = queueProcessingType;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder threadPoolSize(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
                if (this.taskExecutor != null || this.taskExecutorForCachedImages != null) {
                    L.w(WARNING_OVERLAP_EXECUTOR, new Object[0]);
                }
                this.threadPoolSize = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder threadPriority(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) {
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
            return (Builder) invokeI.objValue;
        }

        public Builder writeDebugLogs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
                this.writeLogs = true;
                return this;
            }
            return (Builder) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class NetworkDeniedImageDownloader implements ImageDownloader {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ImageDownloader wrappedDownloader;

        public NetworkDeniedImageDownloader(ImageDownloader imageDownloader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageDownloader};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.wrappedDownloader = imageDownloader;
        }

        @Override // com.kwad.sdk.core.imageloader.core.download.ImageDownloader
        public InputStream getStream(String str, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, obj)) == null) {
                int i2 = AnonymousClass1.$SwitchMap$com$kwad$sdk$core$imageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.ofUri(str).ordinal()];
                if (i2 == 1 || i2 == 2) {
                    throw new IllegalStateException();
                }
                return this.wrappedDownloader.getStream(str, obj);
            }
            return (InputStream) invokeLL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class SlowNetworkImageDownloader implements ImageDownloader {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ImageDownloader wrappedDownloader;

        public SlowNetworkImageDownloader(ImageDownloader imageDownloader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageDownloader};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.wrappedDownloader = imageDownloader;
        }

        @Override // com.kwad.sdk.core.imageloader.core.download.ImageDownloader
        public InputStream getStream(String str, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, obj)) == null) {
                InputStream stream = this.wrappedDownloader.getStream(str, obj);
                int i2 = AnonymousClass1.$SwitchMap$com$kwad$sdk$core$imageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.ofUri(str).ordinal()];
                return (i2 == 1 || i2 == 2) ? new FlushedInputStream(stream) : stream;
            }
            return (InputStream) invokeLL.objValue;
        }
    }

    public ImageLoaderConfiguration(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.resources = builder.context.getResources();
        this.maxImageWidthForMemoryCache = builder.maxImageWidthForMemoryCache;
        this.maxImageHeightForMemoryCache = builder.maxImageHeightForMemoryCache;
        this.maxImageWidthForDiskCache = builder.maxImageWidthForDiskCache;
        this.maxImageHeightForDiskCache = builder.maxImageHeightForDiskCache;
        this.processorForDiskCache = builder.processorForDiskCache;
        this.taskExecutor = builder.taskExecutor;
        this.taskExecutorForCachedImages = builder.taskExecutorForCachedImages;
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
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? new Builder(context).build() : (ImageLoaderConfiguration) invokeL.objValue;
    }

    public ImageSize getMaxImageSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
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
        return (ImageSize) invokeV.objValue;
    }
}
