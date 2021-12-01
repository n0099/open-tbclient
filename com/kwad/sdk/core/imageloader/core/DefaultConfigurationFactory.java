package com.kwad.sdk.core.imageloader.core;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.cache.disc.DiskCache;
import com.kwad.sdk.core.imageloader.cache.disc.impl.UnlimitedDiskCache;
import com.kwad.sdk.core.imageloader.cache.disc.impl.ext.LruDiskCache;
import com.kwad.sdk.core.imageloader.cache.disc.naming.FileNameGenerator;
import com.kwad.sdk.core.imageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.kwad.sdk.core.imageloader.cache.memory.MemoryCache;
import com.kwad.sdk.core.imageloader.cache.memory.impl.LruMemoryCache;
import com.kwad.sdk.core.imageloader.core.assist.QueueProcessingType;
import com.kwad.sdk.core.imageloader.core.assist.deque.LIFOLinkedBlockingDeque;
import com.kwad.sdk.core.imageloader.core.decode.BaseImageDecoder;
import com.kwad.sdk.core.imageloader.core.decode.ImageDecoder;
import com.kwad.sdk.core.imageloader.core.display.BitmapDisplayer;
import com.kwad.sdk.core.imageloader.core.display.SimpleBitmapDisplayer;
import com.kwad.sdk.core.imageloader.core.download.BaseImageDownloader;
import com.kwad.sdk.core.imageloader.core.download.ImageDownloader;
import com.kwad.sdk.core.imageloader.utils.L;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class DefaultConfigurationFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class DefaultThreadFactory implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;
        public static final AtomicInteger poolNumber;
        public transient /* synthetic */ FieldHolder $fh;
        public final ThreadGroup group;
        public final String namePrefix;
        public final AtomicInteger threadNumber;
        public final int threadPriority;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(670004595, "Lcom/kwad/sdk/core/imageloader/core/DefaultConfigurationFactory$DefaultThreadFactory;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(670004595, "Lcom/kwad/sdk/core/imageloader/core/DefaultConfigurationFactory$DefaultThreadFactory;");
                    return;
                }
            }
            poolNumber = new AtomicInteger(1);
        }

        public DefaultThreadFactory(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.threadNumber = new AtomicInteger(1);
            this.threadPriority = i2;
            this.group = Thread.currentThread().getThreadGroup();
            this.namePrefix = str + poolNumber.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                ThreadGroup threadGroup = this.group;
                Thread thread = new Thread(threadGroup, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
                if (thread.isDaemon()) {
                    thread.setDaemon(false);
                }
                thread.setPriority(this.threadPriority);
                return thread;
            }
            return (Thread) invokeL.objValue;
        }
    }

    public DefaultConfigurationFactory() {
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

    public static BitmapDisplayer createBitmapDisplayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new SimpleBitmapDisplayer() : (BitmapDisplayer) invokeV.objValue;
    }

    public static DiskCache createDiskCache(Context context, FileNameGenerator fileNameGenerator, long j2, int i2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, fileNameGenerator, Long.valueOf(j2), Integer.valueOf(i2), str})) == null) {
            File createReserveDiskCacheDir = createReserveDiskCacheDir(context, str);
            if (j2 > 0 || i2 > 0) {
                try {
                    return new LruDiskCache(StorageUtils.getIndividualCacheDirectory(context, str), createReserveDiskCacheDir, fileNameGenerator, j2, i2);
                } catch (IOException e2) {
                    L.e(e2);
                }
            }
            return new UnlimitedDiskCache(new File(str), createReserveDiskCacheDir, fileNameGenerator);
        }
        return (DiskCache) invokeCommon.objValue;
    }

    public static Executor createExecutor(int i2, int i3, QueueProcessingType queueProcessingType) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65539, null, i2, i3, queueProcessingType)) == null) {
            return new ThreadPoolExecutor(i2, i2, 0L, TimeUnit.MILLISECONDS, queueProcessingType == QueueProcessingType.LIFO ? new LIFOLinkedBlockingDeque() : new LinkedBlockingQueue(), createThreadFactory(i3, "uil-pool-"));
        }
        return (Executor) invokeIIL.objValue;
    }

    public static FileNameGenerator createFileNameGenerator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? new HashCodeFileNameGenerator() : (FileNameGenerator) invokeV.objValue;
    }

    public static ImageDecoder createImageDecoder(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(65541, null, z)) == null) ? new BaseImageDecoder(z) : (ImageDecoder) invokeZ.objValue;
    }

    public static ImageDownloader createImageDownloader(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) ? new BaseImageDownloader(context) : (ImageDownloader) invokeL.objValue;
    }

    public static MemoryCache createMemoryCache(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, context, i2)) == null) {
            if (i2 == 0) {
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                int memoryClass = activityManager.getMemoryClass();
                if (hasHoneycomb() && isLargeHeap(context)) {
                    memoryClass = getLargeMemoryClass(activityManager);
                }
                i2 = (memoryClass * 1048576) / 8;
            }
            return new LruMemoryCache(i2);
        }
        return (MemoryCache) invokeLI.objValue;
    }

    public static File createReserveDiskCacheDir(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, str)) == null) {
            File file = new File(str);
            File file2 = new File(file, StorageUtils.INDIVIDUAL_DIR_NAME);
            return (file2.exists() || file2.mkdir()) ? file2 : file;
        }
        return (File) invokeLL.objValue;
    }

    public static Executor createTaskDistributor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? Executors.newCachedThreadPool(createThreadFactory(5, "uil-pool-d-")) : (Executor) invokeV.objValue;
    }

    public static ThreadFactory createThreadFactory(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65546, null, i2, str)) == null) ? new DefaultThreadFactory(i2, str) : (ThreadFactory) invokeIL.objValue;
    }

    @TargetApi(11)
    public static int getLargeMemoryClass(ActivityManager activityManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, activityManager)) == null) ? activityManager.getLargeMemoryClass() : invokeL.intValue;
    }

    public static boolean hasHoneycomb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? Build.VERSION.SDK_INT >= 11 : invokeV.booleanValue;
    }

    @TargetApi(11)
    public static boolean isLargeHeap(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) ? (context.getApplicationInfo().flags & 1048576) != 0 : invokeL.booleanValue;
    }
}
