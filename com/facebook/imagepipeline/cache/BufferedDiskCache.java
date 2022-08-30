package com.facebook.imagepipeline.cache;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.i0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.instrumentation.FrescoInstrumenter;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class BufferedDiskCache {
    public static /* synthetic */ Interceptable $ic;
    public static final Class<?> TAG;
    public transient /* synthetic */ FieldHolder $fh;
    public final FileCache mFileCache;
    public final ImageCacheStatsTracker mImageCacheStatsTracker;
    public final PooledByteBufferFactory mPooledByteBufferFactory;
    public final PooledByteStreams mPooledByteStreams;
    public final Executor mReadExecutor;
    public final StagingArea mStagingArea;
    public final Executor mWriteExecutor;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2117955299, "Lcom/facebook/imagepipeline/cache/BufferedDiskCache;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2117955299, "Lcom/facebook/imagepipeline/cache/BufferedDiskCache;");
                return;
            }
        }
        TAG = BufferedDiskCache.class;
    }

    public BufferedDiskCache(FileCache fileCache, PooledByteBufferFactory pooledByteBufferFactory, PooledByteStreams pooledByteStreams, Executor executor, Executor executor2, ImageCacheStatsTracker imageCacheStatsTracker) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fileCache, pooledByteBufferFactory, pooledByteStreams, executor, executor2, imageCacheStatsTracker};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mFileCache = fileCache;
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
        this.mPooledByteStreams = pooledByteStreams;
        this.mReadExecutor = executor;
        this.mWriteExecutor = executor2;
        this.mImageCacheStatsTracker = imageCacheStatsTracker;
        this.mStagingArea = StagingArea.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkInStagingAreaAndFileCache(CacheKey cacheKey) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, cacheKey)) == null) {
            EncodedImage encodedImage = this.mStagingArea.get(cacheKey);
            if (encodedImage != null) {
                encodedImage.close();
                FLog.v(TAG, "Found image for %s in staging area", cacheKey.getUriString());
                this.mImageCacheStatsTracker.onStagingAreaHit(cacheKey);
                return true;
            }
            FLog.v(TAG, "Did not find image for %s in staging area", cacheKey.getUriString());
            this.mImageCacheStatsTracker.onStagingAreaMiss(cacheKey);
            try {
                return this.mFileCache.hasKey(cacheKey);
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    private i0<Boolean> containsAsync(CacheKey cacheKey) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, cacheKey)) == null) {
            try {
                return i0.call(new Callable<Boolean>(this, FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_containsAsync"), cacheKey) { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BufferedDiskCache this$0;
                    public final /* synthetic */ CacheKey val$key;
                    public final /* synthetic */ Object val$token;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r7, cacheKey};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$token = r7;
                        this.val$key = cacheKey;
                    }

                    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.concurrent.Callable
                    public Boolean call() throws Exception {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                            return (Boolean) invokeV.objValue;
                        }
                        Object onBeginWork = FrescoInstrumenter.onBeginWork(this.val$token, null);
                        try {
                            return Boolean.valueOf(this.this$0.checkInStagingAreaAndFileCache(this.val$key));
                        } finally {
                        }
                    }
                }, this.mReadExecutor);
            } catch (Exception e) {
                FLog.w(TAG, e, "Failed to schedule disk-cache read for %s", cacheKey.getUriString());
                return i0.i(e);
            }
        }
        return (i0) invokeL.objValue;
    }

    private i0<EncodedImage> foundPinnedImage(CacheKey cacheKey, EncodedImage encodedImage) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, this, cacheKey, encodedImage)) == null) {
            FLog.v(TAG, "Found image for %s in staging area", cacheKey.getUriString());
            this.mImageCacheStatsTracker.onStagingAreaHit(cacheKey);
            return i0.j(encodedImage);
        }
        return (i0) invokeLL.objValue;
    }

    private i0<EncodedImage> getAsync(CacheKey cacheKey, AtomicBoolean atomicBoolean) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, this, cacheKey, atomicBoolean)) == null) {
            try {
                return i0.call(new Callable<EncodedImage>(this, FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_getAsync"), atomicBoolean, cacheKey) { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BufferedDiskCache this$0;
                    public final /* synthetic */ AtomicBoolean val$isCancelled;
                    public final /* synthetic */ CacheKey val$key;
                    public final /* synthetic */ Object val$token;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r7, atomicBoolean, cacheKey};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$token = r7;
                        this.val$isCancelled = atomicBoolean;
                        this.val$key = cacheKey;
                    }

                    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.concurrent.Callable
                    @Nullable
                    public EncodedImage call() throws Exception {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                            return (EncodedImage) invokeV.objValue;
                        }
                        Object onBeginWork = FrescoInstrumenter.onBeginWork(this.val$token, null);
                        try {
                            if (!this.val$isCancelled.get()) {
                                EncodedImage encodedImage = this.this$0.mStagingArea.get(this.val$key);
                                if (encodedImage != null) {
                                    FLog.v(BufferedDiskCache.TAG, "Found image for %s in staging area", this.val$key.getUriString());
                                    this.this$0.mImageCacheStatsTracker.onStagingAreaHit(this.val$key);
                                } else {
                                    FLog.v(BufferedDiskCache.TAG, "Did not find image for %s in staging area", this.val$key.getUriString());
                                    this.this$0.mImageCacheStatsTracker.onStagingAreaMiss(this.val$key);
                                    try {
                                        PooledByteBuffer readFromDiskCache = this.this$0.readFromDiskCache(this.val$key);
                                        if (readFromDiskCache == null) {
                                            return null;
                                        }
                                        CloseableReference of = CloseableReference.of(readFromDiskCache);
                                        try {
                                            encodedImage = new EncodedImage(of);
                                        } finally {
                                            CloseableReference.closeSafely(of);
                                        }
                                    } catch (Exception unused) {
                                        return null;
                                    }
                                }
                                if (Thread.interrupted()) {
                                    FLog.v(BufferedDiskCache.TAG, "Host thread was interrupted, decreasing reference count");
                                    if (encodedImage != null) {
                                        encodedImage.close();
                                    }
                                    throw new InterruptedException();
                                }
                                return encodedImage;
                            }
                            throw new CancellationException();
                        } finally {
                        }
                    }
                }, this.mReadExecutor);
            } catch (Exception e) {
                FLog.w(TAG, e, "Failed to schedule disk-cache read for %s", cacheKey.getUriString());
                return i0.i(e);
            }
        }
        return (i0) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public PooledByteBuffer readFromDiskCache(CacheKey cacheKey) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, this, cacheKey)) == null) {
            try {
                FLog.v(TAG, "Disk cache read for %s", cacheKey.getUriString());
                BinaryResource resource = this.mFileCache.getResource(cacheKey);
                if (resource == null) {
                    FLog.v(TAG, "Disk cache miss for %s", cacheKey.getUriString());
                    this.mImageCacheStatsTracker.onDiskCacheMiss(cacheKey);
                    return null;
                }
                FLog.v(TAG, "Found entry in disk cache for %s", cacheKey.getUriString());
                this.mImageCacheStatsTracker.onDiskCacheHit(cacheKey);
                InputStream openStream = resource.openStream();
                PooledByteBuffer newByteBuffer = this.mPooledByteBufferFactory.newByteBuffer(openStream, (int) resource.size());
                openStream.close();
                FLog.v(TAG, "Successful read from disk cache for %s", cacheKey.getUriString());
                return newByteBuffer;
            } catch (IOException e) {
                FLog.w(TAG, e, "Exception reading from cache for %s", cacheKey.getUriString());
                this.mImageCacheStatsTracker.onDiskCacheGetFail(cacheKey);
                throw e;
            }
        }
        return (PooledByteBuffer) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeToDiskCache(CacheKey cacheKey, EncodedImage encodedImage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, this, cacheKey, encodedImage) == null) {
            FLog.v(TAG, "About to write to disk-cache for key %s", cacheKey.getUriString());
            try {
                this.mFileCache.insert(cacheKey, new WriterCallback(this, encodedImage) { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BufferedDiskCache this$0;
                    public final /* synthetic */ EncodedImage val$encodedImage;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, encodedImage};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$encodedImage = encodedImage;
                    }

                    @Override // com.facebook.cache.common.WriterCallback
                    public void write(OutputStream outputStream) throws IOException {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, outputStream) == null) {
                            this.this$0.mPooledByteStreams.copy(this.val$encodedImage.getInputStream(), outputStream);
                        }
                    }
                });
                this.mImageCacheStatsTracker.onDiskCachePut(cacheKey);
                FLog.v(TAG, "Successful disk-cache write for key %s", cacheKey.getUriString());
            } catch (IOException e) {
                FLog.w(TAG, e, "Failed to write to disk-cache for key %s", cacheKey.getUriString());
            }
        }
    }

    public void addKeyForAsyncProbing(CacheKey cacheKey) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cacheKey) == null) {
            Preconditions.checkNotNull(cacheKey);
            this.mFileCache.probe(cacheKey);
        }
    }

    public i0<Void> clearAll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.mStagingArea.clearAll();
            try {
                return i0.call(new Callable<Void>(this, FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_clearAll")) { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BufferedDiskCache this$0;
                    public final /* synthetic */ Object val$token;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r7};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$token = r7;
                    }

                    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // java.util.concurrent.Callable
                    public Void call() throws Exception {
                        InterceptResult invokeV2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && (invokeV2 = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
                            return (Void) invokeV2.objValue;
                        }
                        Object onBeginWork = FrescoInstrumenter.onBeginWork(this.val$token, null);
                        try {
                            this.this$0.mStagingArea.clearAll();
                            this.this$0.mFileCache.clearAll();
                            return null;
                        } finally {
                        }
                    }
                }, this.mWriteExecutor);
            } catch (Exception e) {
                FLog.w(TAG, e, "Failed to schedule disk-cache clear", new Object[0]);
                return i0.i(e);
            }
        }
        return (i0) invokeV.objValue;
    }

    public i0<Boolean> contains(CacheKey cacheKey) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cacheKey)) == null) {
            if (containsSync(cacheKey)) {
                return i0.j(Boolean.TRUE);
            }
            return containsAsync(cacheKey);
        }
        return (i0) invokeL.objValue;
    }

    public boolean containsSync(CacheKey cacheKey) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cacheKey)) == null) ? this.mStagingArea.containsKey(cacheKey) || this.mFileCache.hasKeySync(cacheKey) : invokeL.booleanValue;
    }

    public boolean diskCheckSync(CacheKey cacheKey) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cacheKey)) == null) {
            if (containsSync(cacheKey)) {
                return true;
            }
            return checkInStagingAreaAndFileCache(cacheKey);
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, INVOKE, IF] complete} */
    public i0<EncodedImage> get(CacheKey cacheKey, AtomicBoolean atomicBoolean) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, cacheKey, atomicBoolean)) == null) {
            try {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("BufferedDiskCache#get");
                }
                EncodedImage encodedImage = this.mStagingArea.get(cacheKey);
                if (encodedImage != null) {
                    return foundPinnedImage(cacheKey, encodedImage);
                }
                i0<EncodedImage> async = getAsync(cacheKey, atomicBoolean);
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                return async;
            } finally {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
        }
        return (i0) invokeLL.objValue;
    }

    public long getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            FileCache fileCache = this.mFileCache;
            if (fileCache != null) {
                return fileCache.getCount();
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public long getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            FileCache fileCache = this.mFileCache;
            if (fileCache != null) {
                return fileCache.getSize();
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public i0<Void> probe(CacheKey cacheKey) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cacheKey)) == null) {
            Preconditions.checkNotNull(cacheKey);
            try {
                return i0.call(new Callable<Void>(this, FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_probe"), cacheKey) { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BufferedDiskCache this$0;
                    public final /* synthetic */ CacheKey val$key;
                    public final /* synthetic */ Object val$token;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r7, cacheKey};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$token = r7;
                        this.val$key = cacheKey;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // java.util.concurrent.Callable
                    public Void call() throws Exception {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            Object onBeginWork = FrescoInstrumenter.onBeginWork(this.val$token, null);
                            try {
                                this.this$0.mFileCache.probe(this.val$key);
                                return null;
                            } finally {
                                FrescoInstrumenter.onEndWork(onBeginWork);
                            }
                        }
                        return (Void) invokeV.objValue;
                    }
                }, this.mWriteExecutor);
            } catch (Exception e) {
                FLog.w(TAG, e, "Failed to schedule disk-cache probe for %s", cacheKey.getUriString());
                return i0.i(e);
            }
        }
        return (i0) invokeL.objValue;
    }

    public void put(CacheKey cacheKey, EncodedImage encodedImage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, cacheKey, encodedImage) == null) {
            try {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("BufferedDiskCache#put");
                }
                Preconditions.checkNotNull(cacheKey);
                Preconditions.checkArgument(EncodedImage.isValid(encodedImage));
                this.mStagingArea.put(cacheKey, encodedImage);
                EncodedImage cloneOrNull = EncodedImage.cloneOrNull(encodedImage);
                try {
                    this.mWriteExecutor.execute(new Runnable(this, FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_putAsync"), cacheKey, cloneOrNull) { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ BufferedDiskCache this$0;
                        public final /* synthetic */ EncodedImage val$finalEncodedImage;
                        public final /* synthetic */ CacheKey val$key;
                        public final /* synthetic */ Object val$token;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, r7, cacheKey, cloneOrNull};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$token = r7;
                            this.val$key = cacheKey;
                            this.val$finalEncodedImage = cloneOrNull;
                        }

                        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                                return;
                            }
                            Object onBeginWork = FrescoInstrumenter.onBeginWork(this.val$token, null);
                            try {
                                this.this$0.writeToDiskCache(this.val$key, this.val$finalEncodedImage);
                            } finally {
                            }
                        }
                    });
                } catch (Exception e) {
                    FLog.w(TAG, e, "Failed to schedule disk-cache write for %s", cacheKey.getUriString());
                    this.mStagingArea.remove(cacheKey, encodedImage);
                    EncodedImage.closeSafely(cloneOrNull);
                }
            } finally {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
        }
    }

    public i0<Void> remove(CacheKey cacheKey) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, cacheKey)) == null) {
            Preconditions.checkNotNull(cacheKey);
            this.mStagingArea.remove(cacheKey);
            try {
                return i0.call(new Callable<Void>(this, FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_remove"), cacheKey) { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BufferedDiskCache this$0;
                    public final /* synthetic */ CacheKey val$key;
                    public final /* synthetic */ Object val$token;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r7, cacheKey};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$token = r7;
                        this.val$key = cacheKey;
                    }

                    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // java.util.concurrent.Callable
                    public Void call() throws Exception {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
                            return (Void) invokeV.objValue;
                        }
                        Object onBeginWork = FrescoInstrumenter.onBeginWork(this.val$token, null);
                        try {
                            this.this$0.mStagingArea.remove(this.val$key);
                            this.this$0.mFileCache.remove(this.val$key);
                            return null;
                        } finally {
                        }
                    }
                }, this.mWriteExecutor);
            } catch (Exception e) {
                FLog.w(TAG, e, "Failed to schedule disk-cache remove for %s", cacheKey.getUriString());
                return i0.i(e);
            }
        }
        return (i0) invokeL.objValue;
    }
}
