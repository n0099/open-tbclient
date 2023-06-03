package com.facebook.imagepipeline.cache;

import com.baidu.tieba.s;
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
/* loaded from: classes9.dex */
public class BufferedDiskCache {
    public static final Class<?> TAG = BufferedDiskCache.class;
    public final FileCache mFileCache;
    public final ImageCacheStatsTracker mImageCacheStatsTracker;
    public final PooledByteBufferFactory mPooledByteBufferFactory;
    public final PooledByteStreams mPooledByteStreams;
    public final Executor mReadExecutor;
    public final StagingArea mStagingArea = StagingArea.getInstance();
    public final Executor mWriteExecutor;

    public s<Void> clearAll() {
        this.mStagingArea.clearAll();
        final Object onBeforeSubmitWork = FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_clearAll");
        try {
            return s.call(new Callable<Void>() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache.6
                /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    Object onBeginWork = FrescoInstrumenter.onBeginWork(onBeforeSubmitWork, null);
                    try {
                        BufferedDiskCache.this.mStagingArea.clearAll();
                        BufferedDiskCache.this.mFileCache.clearAll();
                        return null;
                    } finally {
                    }
                }
            }, this.mWriteExecutor);
        } catch (Exception e) {
            FLog.w(TAG, e, "Failed to schedule disk-cache clear", new Object[0]);
            return s.i(e);
        }
    }

    public long getCount() {
        FileCache fileCache = this.mFileCache;
        if (fileCache != null) {
            return fileCache.getCount();
        }
        return -1L;
    }

    public long getSize() {
        FileCache fileCache = this.mFileCache;
        if (fileCache != null) {
            return fileCache.getSize();
        }
        return -1L;
    }

    public BufferedDiskCache(FileCache fileCache, PooledByteBufferFactory pooledByteBufferFactory, PooledByteStreams pooledByteStreams, Executor executor, Executor executor2, ImageCacheStatsTracker imageCacheStatsTracker) {
        this.mFileCache = fileCache;
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
        this.mPooledByteStreams = pooledByteStreams;
        this.mReadExecutor = executor;
        this.mWriteExecutor = executor2;
        this.mImageCacheStatsTracker = imageCacheStatsTracker;
    }

    private s<EncodedImage> foundPinnedImage(CacheKey cacheKey, EncodedImage encodedImage) {
        FLog.v(TAG, "Found image for %s in staging area", cacheKey.getUriString());
        this.mImageCacheStatsTracker.onStagingAreaHit(cacheKey);
        return s.j(encodedImage);
    }

    private s<EncodedImage> getAsync(final CacheKey cacheKey, final AtomicBoolean atomicBoolean) {
        try {
            final Object onBeforeSubmitWork = FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_getAsync");
            return s.call(new Callable<EncodedImage>() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache.3
                /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                @Nullable
                public EncodedImage call() throws Exception {
                    Object onBeginWork = FrescoInstrumenter.onBeginWork(onBeforeSubmitWork, null);
                    try {
                        if (!atomicBoolean.get()) {
                            EncodedImage encodedImage = BufferedDiskCache.this.mStagingArea.get(cacheKey);
                            if (encodedImage != null) {
                                FLog.v(BufferedDiskCache.TAG, "Found image for %s in staging area", cacheKey.getUriString());
                                BufferedDiskCache.this.mImageCacheStatsTracker.onStagingAreaHit(cacheKey);
                            } else {
                                FLog.v(BufferedDiskCache.TAG, "Did not find image for %s in staging area", cacheKey.getUriString());
                                BufferedDiskCache.this.mImageCacheStatsTracker.onStagingAreaMiss(cacheKey);
                                try {
                                    PooledByteBuffer readFromDiskCache = BufferedDiskCache.this.readFromDiskCache(cacheKey);
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
                    } catch (Throwable th) {
                        try {
                            FrescoInstrumenter.markFailure(onBeforeSubmitWork, th);
                            throw th;
                        } finally {
                            FrescoInstrumenter.onEndWork(onBeginWork);
                        }
                    }
                }
            }, this.mReadExecutor);
        } catch (Exception e) {
            FLog.w(TAG, e, "Failed to schedule disk-cache read for %s", cacheKey.getUriString());
            return s.i(e);
        }
    }

    private s<Boolean> containsAsync(final CacheKey cacheKey) {
        try {
            final Object onBeforeSubmitWork = FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_containsAsync");
            return s.call(new Callable<Boolean>() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache.1
                /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Boolean call() throws Exception {
                    Object onBeginWork = FrescoInstrumenter.onBeginWork(onBeforeSubmitWork, null);
                    try {
                        return Boolean.valueOf(BufferedDiskCache.this.checkInStagingAreaAndFileCache(cacheKey));
                    } finally {
                    }
                }
            }, this.mReadExecutor);
        } catch (Exception e) {
            FLog.w(TAG, e, "Failed to schedule disk-cache read for %s", cacheKey.getUriString());
            return s.i(e);
        }
    }

    public void addKeyForAsyncProbing(CacheKey cacheKey) {
        Preconditions.checkNotNull(cacheKey);
        this.mFileCache.probe(cacheKey);
    }

    public s<Boolean> contains(CacheKey cacheKey) {
        if (containsSync(cacheKey)) {
            return s.j(Boolean.TRUE);
        }
        return containsAsync(cacheKey);
    }

    public boolean containsSync(CacheKey cacheKey) {
        if (!this.mStagingArea.containsKey(cacheKey) && !this.mFileCache.hasKeySync(cacheKey)) {
            return false;
        }
        return true;
    }

    public boolean diskCheckSync(CacheKey cacheKey) {
        if (containsSync(cacheKey)) {
            return true;
        }
        return checkInStagingAreaAndFileCache(cacheKey);
    }

    public s<Void> probe(final CacheKey cacheKey) {
        Preconditions.checkNotNull(cacheKey);
        try {
            final Object onBeforeSubmitWork = FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_probe");
            return s.call(new Callable<Void>() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    Object onBeginWork = FrescoInstrumenter.onBeginWork(onBeforeSubmitWork, null);
                    try {
                        BufferedDiskCache.this.mFileCache.probe(cacheKey);
                        return null;
                    } finally {
                        FrescoInstrumenter.onEndWork(onBeginWork);
                    }
                }
            }, this.mWriteExecutor);
        } catch (Exception e) {
            FLog.w(TAG, e, "Failed to schedule disk-cache probe for %s", cacheKey.getUriString());
            return s.i(e);
        }
    }

    public s<Void> remove(final CacheKey cacheKey) {
        Preconditions.checkNotNull(cacheKey);
        this.mStagingArea.remove(cacheKey);
        try {
            final Object onBeforeSubmitWork = FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_remove");
            return s.call(new Callable<Void>() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache.5
                /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    Object onBeginWork = FrescoInstrumenter.onBeginWork(onBeforeSubmitWork, null);
                    try {
                        BufferedDiskCache.this.mStagingArea.remove(cacheKey);
                        BufferedDiskCache.this.mFileCache.remove(cacheKey);
                        return null;
                    } finally {
                    }
                }
            }, this.mWriteExecutor);
        } catch (Exception e) {
            FLog.w(TAG, e, "Failed to schedule disk-cache remove for %s", cacheKey.getUriString());
            return s.i(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkInStagingAreaAndFileCache(CacheKey cacheKey) {
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

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public PooledByteBuffer readFromDiskCache(CacheKey cacheKey) throws IOException {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void writeToDiskCache(CacheKey cacheKey, final EncodedImage encodedImage) {
        FLog.v(TAG, "About to write to disk-cache for key %s", cacheKey.getUriString());
        try {
            this.mFileCache.insert(cacheKey, new WriterCallback() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache.7
                @Override // com.facebook.cache.common.WriterCallback
                public void write(OutputStream outputStream) throws IOException {
                    BufferedDiskCache.this.mPooledByteStreams.copy(encodedImage.getInputStream(), outputStream);
                }
            });
            this.mImageCacheStatsTracker.onDiskCachePut(cacheKey);
            FLog.v(TAG, "Successful disk-cache write for key %s", cacheKey.getUriString());
        } catch (IOException e) {
            FLog.w(TAG, e, "Failed to write to disk-cache for key %s", cacheKey.getUriString());
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, INVOKE, IF] complete} */
    public s<EncodedImage> get(CacheKey cacheKey, AtomicBoolean atomicBoolean) {
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("BufferedDiskCache#get");
            }
            EncodedImage encodedImage = this.mStagingArea.get(cacheKey);
            if (encodedImage != null) {
                return foundPinnedImage(cacheKey, encodedImage);
            }
            s<EncodedImage> async = getAsync(cacheKey, atomicBoolean);
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

    public void put(final CacheKey cacheKey, EncodedImage encodedImage) {
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("BufferedDiskCache#put");
            }
            Preconditions.checkNotNull(cacheKey);
            Preconditions.checkArgument(EncodedImage.isValid(encodedImage));
            this.mStagingArea.put(cacheKey, encodedImage);
            final EncodedImage cloneOrNull = EncodedImage.cloneOrNull(encodedImage);
            try {
                final Object onBeforeSubmitWork = FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_putAsync");
                this.mWriteExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache.4
                    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                    @Override // java.lang.Runnable
                    public void run() {
                        Object onBeginWork = FrescoInstrumenter.onBeginWork(onBeforeSubmitWork, null);
                        try {
                            BufferedDiskCache.this.writeToDiskCache(cacheKey, cloneOrNull);
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
