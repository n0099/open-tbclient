package com.facebook.cache.disk;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.CacheKeyUtil;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.common.disk.DiskTrimmable;
import com.facebook.common.disk.DiskTrimmableRegistry;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClock;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes6.dex */
public class DiskStorageCache implements FileCache, DiskTrimmable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long FILECACHE_SIZE_UPDATE_PERIOD_MS;
    public static final long FUTURE_TIMESTAMP_THRESHOLD_MS;
    public static final String SHARED_PREFS_FILENAME_PREFIX = "disk_entries_list";
    public static final int START_OF_VERSIONING = 1;
    public static final Class<?> TAG;
    public static final double TRIMMING_LOWER_BOUND = 0.02d;
    public static final long UNINITIALIZED = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public final CacheErrorLogger mCacheErrorLogger;
    public final CacheEventListener mCacheEventListener;
    public long mCacheSizeLastUpdateTime;
    public long mCacheSizeLimit;
    public final long mCacheSizeLimitMinimum;
    public final CacheStats mCacheStats;
    public final Clock mClock;
    public final CountDownLatch mCountDownLatch;
    public final long mDefaultCacheSizeLimit;
    public final EntryEvictionComparatorSupplier mEntryEvictionComparatorSupplier;
    public final boolean mIndexPopulateAtStartupEnabled;
    public boolean mIndexReady;
    public final Object mLock;
    public final long mLowDiskSpaceCacheSizeLimit;
    @VisibleForTesting
    @GuardedBy("mLock")
    public final Set<String> mResourceIndex;
    public final StatFsHelper mStatFsHelper;
    public final DiskStorage mStorage;

    @VisibleForTesting
    /* loaded from: classes6.dex */
    public static class CacheStats {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long mCount;
        public boolean mInitialized;
        public long mSize;

        public CacheStats() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mInitialized = false;
            this.mSize = -1L;
            this.mCount = -1L;
        }

        public synchronized long getCount() {
            InterceptResult invokeV;
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                synchronized (this) {
                    j = this.mCount;
                }
                return j;
            }
            return invokeV.longValue;
        }

        public synchronized long getSize() {
            InterceptResult invokeV;
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                synchronized (this) {
                    j = this.mSize;
                }
                return j;
            }
            return invokeV.longValue;
        }

        public synchronized void increment(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                synchronized (this) {
                    if (this.mInitialized) {
                        this.mSize += j;
                        this.mCount += j2;
                    }
                }
            }
        }

        public synchronized boolean isInitialized() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                synchronized (this) {
                    z = this.mInitialized;
                }
                return z;
            }
            return invokeV.booleanValue;
        }

        public synchronized void reset() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                synchronized (this) {
                    this.mInitialized = false;
                    this.mCount = -1L;
                    this.mSize = -1L;
                }
            }
        }

        public synchronized void set(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                synchronized (this) {
                    this.mCount = j2;
                    this.mSize = j;
                    this.mInitialized = true;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class Params {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long mCacheSizeLimitMinimum;
        public final long mDefaultCacheSizeLimit;
        public final long mLowDiskSpaceCacheSizeLimit;

        public Params(long j, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mCacheSizeLimitMinimum = j;
            this.mLowDiskSpaceCacheSizeLimit = j2;
            this.mDefaultCacheSizeLimit = j3;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(182594465, "Lcom/facebook/cache/disk/DiskStorageCache;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(182594465, "Lcom/facebook/cache/disk/DiskStorageCache;");
                return;
            }
        }
        TAG = DiskStorageCache.class;
        FUTURE_TIMESTAMP_THRESHOLD_MS = TimeUnit.HOURS.toMillis(2L);
        FILECACHE_SIZE_UPDATE_PERIOD_MS = TimeUnit.MINUTES.toMillis(30L);
    }

    public DiskStorageCache(DiskStorage diskStorage, EntryEvictionComparatorSupplier entryEvictionComparatorSupplier, Params params, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable DiskTrimmableRegistry diskTrimmableRegistry, Context context, Executor executor, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {diskStorage, entryEvictionComparatorSupplier, params, cacheEventListener, cacheErrorLogger, diskTrimmableRegistry, context, executor, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mLock = new Object();
        this.mLowDiskSpaceCacheSizeLimit = params.mLowDiskSpaceCacheSizeLimit;
        long j = params.mDefaultCacheSizeLimit;
        this.mDefaultCacheSizeLimit = j;
        this.mCacheSizeLimit = j;
        this.mStatFsHelper = StatFsHelper.getInstance();
        this.mStorage = diskStorage;
        this.mEntryEvictionComparatorSupplier = entryEvictionComparatorSupplier;
        this.mCacheSizeLastUpdateTime = -1L;
        this.mCacheEventListener = cacheEventListener;
        this.mCacheSizeLimitMinimum = params.mCacheSizeLimitMinimum;
        this.mCacheErrorLogger = cacheErrorLogger;
        this.mCacheStats = new CacheStats();
        this.mClock = SystemClock.get();
        this.mIndexPopulateAtStartupEnabled = z;
        this.mResourceIndex = new HashSet();
        if (diskTrimmableRegistry != null) {
            diskTrimmableRegistry.registerDiskTrimmable(this);
        }
        if (this.mIndexPopulateAtStartupEnabled) {
            this.mCountDownLatch = new CountDownLatch(1);
            executor.execute(new Runnable(this) { // from class: com.facebook.cache.disk.DiskStorageCache.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DiskStorageCache this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i4 = newInitContext2.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.this$0.mLock) {
                            this.this$0.maybeUpdateFileCacheSize();
                        }
                        this.this$0.mIndexReady = true;
                        this.this$0.mCountDownLatch.countDown();
                    }
                }
            });
            return;
        }
        this.mCountDownLatch = new CountDownLatch(0);
    }

    private BinaryResource endInsert(DiskStorage.Inserter inserter, CacheKey cacheKey, String str) throws IOException {
        InterceptResult invokeLLL;
        BinaryResource commit;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, this, inserter, cacheKey, str)) == null) {
            synchronized (this.mLock) {
                commit = inserter.commit(cacheKey);
                this.mResourceIndex.add(str);
                this.mCacheStats.increment(commit.size(), 1L);
            }
            return commit;
        }
        return (BinaryResource) invokeLLL.objValue;
    }

    @GuardedBy("mLock")
    private void evictAboveSize(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(65543, this, j, evictionReason) == null) {
            try {
                Collection<DiskStorage.Entry> sortedEntries = getSortedEntries(this.mStorage.getEntries());
                long size = this.mCacheStats.getSize();
                long j2 = size - j;
                int i2 = 0;
                long j3 = 0;
                for (DiskStorage.Entry entry : sortedEntries) {
                    if (j3 > j2) {
                        break;
                    }
                    long remove = this.mStorage.remove(entry);
                    this.mResourceIndex.remove(entry.getId());
                    if (remove > 0) {
                        i2++;
                        j3 += remove;
                        SettableCacheEvent cacheLimit = SettableCacheEvent.obtain().setResourceId(entry.getId()).setEvictionReason(evictionReason).setItemSize(remove).setCacheSize(size - j3).setCacheLimit(j);
                        this.mCacheEventListener.onEviction(cacheLimit);
                        cacheLimit.recycle();
                    }
                }
                this.mCacheStats.increment(-j3, -i2);
                this.mStorage.purgeUnexpectedResources();
            } catch (IOException e2) {
                CacheErrorLogger cacheErrorLogger = this.mCacheErrorLogger;
                CacheErrorLogger.CacheErrorCategory cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.EVICTION;
                Class<?> cls = TAG;
                cacheErrorLogger.logError(cacheErrorCategory, cls, "evictAboveSize: " + e2.getMessage(), e2);
                throw e2;
            }
        }
    }

    private Collection<DiskStorage.Entry> getSortedEntries(Collection<DiskStorage.Entry> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, collection)) == null) {
            long now = this.mClock.now() + FUTURE_TIMESTAMP_THRESHOLD_MS;
            ArrayList arrayList = new ArrayList(collection.size());
            ArrayList arrayList2 = new ArrayList(collection.size());
            for (DiskStorage.Entry entry : collection) {
                if (entry.getTimestamp() > now) {
                    arrayList.add(entry);
                } else {
                    arrayList2.add(entry);
                }
            }
            Collections.sort(arrayList2, this.mEntryEvictionComparatorSupplier.get());
            arrayList.addAll(arrayList2);
            return arrayList;
        }
        return (Collection) invokeL.objValue;
    }

    private void maybeEvictFilesInCacheDir() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            synchronized (this.mLock) {
                boolean maybeUpdateFileCacheSize = maybeUpdateFileCacheSize();
                updateFileCacheSizeLimit();
                long size = this.mCacheStats.getSize();
                if (size > this.mCacheSizeLimit && !maybeUpdateFileCacheSize) {
                    this.mCacheStats.reset();
                    maybeUpdateFileCacheSize();
                }
                if (size > this.mCacheSizeLimit) {
                    evictAboveSize((this.mCacheSizeLimit * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public boolean maybeUpdateFileCacheSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            long now = this.mClock.now();
            if (this.mCacheStats.isInitialized()) {
                long j = this.mCacheSizeLastUpdateTime;
                if (j != -1 && now - j <= FILECACHE_SIZE_UPDATE_PERIOD_MS) {
                    return false;
                }
            }
            return maybeUpdateFileCacheSizeAndIndex();
        }
        return invokeV.booleanValue;
    }

    @GuardedBy("mLock")
    private boolean maybeUpdateFileCacheSizeAndIndex() {
        InterceptResult invokeV;
        Set<String> hashSet;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            long now = this.mClock.now();
            long j2 = FUTURE_TIMESTAMP_THRESHOLD_MS + now;
            if (this.mIndexPopulateAtStartupEnabled && this.mResourceIndex.isEmpty()) {
                hashSet = this.mResourceIndex;
            } else {
                hashSet = this.mIndexPopulateAtStartupEnabled ? new HashSet<>() : null;
            }
            try {
                long j3 = 0;
                long j4 = -1;
                int i2 = 0;
                boolean z = false;
                int i3 = 0;
                int i4 = 0;
                for (DiskStorage.Entry entry : this.mStorage.getEntries()) {
                    i3++;
                    j3 += entry.getSize();
                    if (entry.getTimestamp() > j2) {
                        i4++;
                        i2 = (int) (i2 + entry.getSize());
                        j = j2;
                        j4 = Math.max(entry.getTimestamp() - now, j4);
                        z = true;
                    } else {
                        j = j2;
                        if (this.mIndexPopulateAtStartupEnabled) {
                            hashSet.add(entry.getId());
                        }
                    }
                    j2 = j;
                }
                if (z) {
                    this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, TAG, "Future timestamp found in " + i4 + " files , with a total size of " + i2 + " bytes, and a maximum time delta of " + j4 + "ms", null);
                }
                long j5 = i3;
                if (this.mCacheStats.getCount() != j5 || this.mCacheStats.getSize() != j3) {
                    if (this.mIndexPopulateAtStartupEnabled && this.mResourceIndex != hashSet) {
                        this.mResourceIndex.clear();
                        this.mResourceIndex.addAll(hashSet);
                    }
                    this.mCacheStats.set(j3, j5);
                }
                this.mCacheSizeLastUpdateTime = now;
                return true;
            } catch (IOException e2) {
                this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, TAG, "calcFileCacheSize: " + e2.getMessage(), e2);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    private DiskStorage.Inserter startInsert(String str, CacheKey cacheKey) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, this, str, cacheKey)) == null) {
            maybeEvictFilesInCacheDir();
            return this.mStorage.insert(str, cacheKey);
        }
        return (DiskStorage.Inserter) invokeLL.objValue;
    }

    private void trimBy(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, this, new Object[]{Double.valueOf(d2)}) == null) {
            synchronized (this.mLock) {
                try {
                    this.mCacheStats.reset();
                    maybeUpdateFileCacheSize();
                    long size = this.mCacheStats.getSize();
                    evictAboveSize(size - ((long) (d2 * size)), CacheEventListener.EvictionReason.CACHE_MANAGER_TRIMMED);
                } catch (IOException e2) {
                    CacheErrorLogger cacheErrorLogger = this.mCacheErrorLogger;
                    CacheErrorLogger.CacheErrorCategory cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.EVICTION;
                    Class<?> cls = TAG;
                    cacheErrorLogger.logError(cacheErrorCategory, cls, "trimBy: " + e2.getMessage(), e2);
                }
            }
        }
    }

    @GuardedBy("mLock")
    private void updateFileCacheSizeLimit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            if (this.mStatFsHelper.testLowDiskSpace(this.mStorage.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.mDefaultCacheSizeLimit - this.mCacheStats.getSize())) {
                this.mCacheSizeLimit = this.mLowDiskSpaceCacheSizeLimit;
            } else {
                this.mCacheSizeLimit = this.mDefaultCacheSizeLimit;
            }
        }
    }

    @VisibleForTesting
    public void awaitIndex() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                this.mCountDownLatch.await();
            } catch (InterruptedException unused) {
                FLog.e(TAG, "Memory Index is not ready yet. ");
            }
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public void clearAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this.mLock) {
                try {
                    this.mStorage.clearAll();
                    this.mResourceIndex.clear();
                    this.mCacheEventListener.onCleared();
                } catch (IOException | NullPointerException e2) {
                    CacheErrorLogger cacheErrorLogger = this.mCacheErrorLogger;
                    CacheErrorLogger.CacheErrorCategory cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.EVICTION;
                    Class<?> cls = TAG;
                    cacheErrorLogger.logError(cacheErrorCategory, cls, "clearAll: " + e2.getMessage(), e2);
                }
                this.mCacheStats.reset();
            }
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public long clearOldEntries(long j) {
        InterceptResult invokeJ;
        long j2;
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            synchronized (this.mLock) {
                try {
                    long now = this.mClock.now();
                    Collection<DiskStorage.Entry> entries = this.mStorage.getEntries();
                    long size = this.mCacheStats.getSize();
                    int i2 = 0;
                    long j4 = 0;
                    j3 = 0;
                    for (DiskStorage.Entry entry : entries) {
                        try {
                            long j5 = now;
                            long max = Math.max(1L, Math.abs(now - entry.getTimestamp()));
                            if (max >= j) {
                                long remove = this.mStorage.remove(entry);
                                this.mResourceIndex.remove(entry.getId());
                                if (remove > 0) {
                                    i2++;
                                    j4 += remove;
                                    SettableCacheEvent cacheSize = SettableCacheEvent.obtain().setResourceId(entry.getId()).setEvictionReason(CacheEventListener.EvictionReason.CONTENT_STALE).setItemSize(remove).setCacheSize(size - j4);
                                    this.mCacheEventListener.onEviction(cacheSize);
                                    cacheSize.recycle();
                                }
                            } else {
                                j3 = Math.max(j3, max);
                            }
                            now = j5;
                        } catch (IOException e2) {
                            e = e2;
                            j2 = j3;
                            this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "clearOldEntries: " + e.getMessage(), e);
                            j3 = j2;
                            return j3;
                        }
                    }
                    this.mStorage.purgeUnexpectedResources();
                    if (i2 > 0) {
                        maybeUpdateFileCacheSize();
                        this.mCacheStats.increment(-j4, -i2);
                    }
                } catch (IOException e3) {
                    e = e3;
                    j2 = 0;
                }
            }
            return j3;
        }
        return invokeJ.longValue;
    }

    @Override // com.facebook.cache.disk.FileCache
    public long getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mCacheStats.getCount() : invokeV.longValue;
    }

    @Override // com.facebook.cache.disk.FileCache
    public DiskStorage.DiskDumpInfo getDumpInfo() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mStorage.getDumpInfo() : (DiskStorage.DiskDumpInfo) invokeV.objValue;
    }

    @Override // com.facebook.cache.disk.FileCache
    @Nullable
    public BinaryResource getResource(CacheKey cacheKey) {
        InterceptResult invokeL;
        BinaryResource binaryResource;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cacheKey)) == null) {
            SettableCacheEvent cacheKey2 = SettableCacheEvent.obtain().setCacheKey(cacheKey);
            try {
                synchronized (this.mLock) {
                    List<String> resourceIds = CacheKeyUtil.getResourceIds(cacheKey);
                    String str = null;
                    binaryResource = null;
                    for (int i2 = 0; i2 < resourceIds.size(); i2++) {
                        str = resourceIds.get(i2);
                        cacheKey2.setResourceId(str);
                        binaryResource = this.mStorage.getResource(str, cacheKey);
                        if (binaryResource != null) {
                            break;
                        }
                    }
                    if (binaryResource == null) {
                        this.mCacheEventListener.onMiss(cacheKey2);
                        this.mResourceIndex.remove(str);
                    } else {
                        this.mCacheEventListener.onHit(cacheKey2);
                        this.mResourceIndex.add(str);
                    }
                }
                return binaryResource;
            } catch (IOException e2) {
                this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, TAG, "getResource", e2);
                cacheKey2.setException(e2);
                this.mCacheEventListener.onReadException(cacheKey2);
                return null;
            } finally {
                cacheKey2.recycle();
            }
        }
        return (BinaryResource) invokeL.objValue;
    }

    @Override // com.facebook.cache.disk.FileCache
    public long getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mCacheStats.getSize() : invokeV.longValue;
    }

    @Override // com.facebook.cache.disk.FileCache
    public boolean hasKey(CacheKey cacheKey) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cacheKey)) == null) {
            synchronized (this.mLock) {
                if (hasKeySync(cacheKey)) {
                    return true;
                }
                try {
                    List<String> resourceIds = CacheKeyUtil.getResourceIds(cacheKey);
                    for (int i2 = 0; i2 < resourceIds.size(); i2++) {
                        String str = resourceIds.get(i2);
                        if (this.mStorage.contains(str, cacheKey)) {
                            this.mResourceIndex.add(str);
                            return true;
                        }
                    }
                    return false;
                } catch (IOException unused) {
                    return false;
                }
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.facebook.cache.disk.FileCache
    public boolean hasKeySync(CacheKey cacheKey) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cacheKey)) == null) {
            synchronized (this.mLock) {
                List<String> resourceIds = CacheKeyUtil.getResourceIds(cacheKey);
                for (int i2 = 0; i2 < resourceIds.size(); i2++) {
                    if (this.mResourceIndex.contains(resourceIds.get(i2))) {
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.facebook.cache.disk.FileCache
    public BinaryResource insert(CacheKey cacheKey, WriterCallback writerCallback) throws IOException {
        InterceptResult invokeLL;
        String firstResourceId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, cacheKey, writerCallback)) == null) {
            SettableCacheEvent cacheKey2 = SettableCacheEvent.obtain().setCacheKey(cacheKey);
            this.mCacheEventListener.onWriteAttempt(cacheKey2);
            synchronized (this.mLock) {
                firstResourceId = CacheKeyUtil.getFirstResourceId(cacheKey);
            }
            cacheKey2.setResourceId(firstResourceId);
            try {
                try {
                    DiskStorage.Inserter startInsert = startInsert(firstResourceId, cacheKey);
                    try {
                        startInsert.writeData(writerCallback, cacheKey);
                        BinaryResource endInsert = endInsert(startInsert, cacheKey, firstResourceId);
                        cacheKey2.setItemSize(endInsert.size()).setCacheSize(this.mCacheStats.getSize());
                        this.mCacheEventListener.onWriteSuccess(cacheKey2);
                        return endInsert;
                    } finally {
                        if (!startInsert.cleanUp()) {
                            FLog.e(TAG, "Failed to delete temp file");
                        }
                    }
                } catch (IOException e2) {
                    cacheKey2.setException(e2);
                    this.mCacheEventListener.onWriteException(cacheKey2);
                    FLog.e(TAG, "Failed inserting a file into the cache", e2);
                    throw e2;
                }
            } finally {
                cacheKey2.recycle();
            }
        }
        return (BinaryResource) invokeLL.objValue;
    }

    @Override // com.facebook.cache.disk.FileCache
    public boolean isEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mStorage.isEnabled() : invokeV.booleanValue;
    }

    public boolean isIndexReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mIndexReady || !this.mIndexPopulateAtStartupEnabled : invokeV.booleanValue;
    }

    @Override // com.facebook.cache.disk.FileCache
    public boolean probe(CacheKey cacheKey) {
        InterceptResult invokeL;
        String str;
        IOException e2;
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048588, this, cacheKey)) != null) {
            return invokeL.booleanValue;
        }
        String str2 = null;
        try {
            synchronized (this.mLock) {
                try {
                    List<String> resourceIds = CacheKeyUtil.getResourceIds(cacheKey);
                    int i2 = 0;
                    while (i2 < resourceIds.size()) {
                        str = resourceIds.get(i2);
                        try {
                            if (this.mStorage.touch(str, cacheKey)) {
                                this.mResourceIndex.add(str);
                                return true;
                            }
                            i2++;
                            str2 = str;
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                throw th;
                            } catch (IOException e3) {
                                e2 = e3;
                                SettableCacheEvent exception = SettableCacheEvent.obtain().setCacheKey(cacheKey).setResourceId(str).setException(e2);
                                this.mCacheEventListener.onReadException(exception);
                                exception.recycle();
                                return false;
                            }
                        }
                    }
                    return false;
                } catch (Throwable th3) {
                    str = str2;
                    th = th3;
                }
            }
        } catch (IOException e4) {
            str = null;
            e2 = e4;
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public void remove(CacheKey cacheKey) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, cacheKey) == null) {
            synchronized (this.mLock) {
                try {
                    List<String> resourceIds = CacheKeyUtil.getResourceIds(cacheKey);
                    for (int i2 = 0; i2 < resourceIds.size(); i2++) {
                        String str = resourceIds.get(i2);
                        this.mStorage.remove(str);
                        this.mResourceIndex.remove(str);
                    }
                } catch (IOException e2) {
                    CacheErrorLogger cacheErrorLogger = this.mCacheErrorLogger;
                    CacheErrorLogger.CacheErrorCategory cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.DELETE_FILE;
                    Class<?> cls = TAG;
                    cacheErrorLogger.logError(cacheErrorCategory, cls, "delete: " + e2.getMessage(), e2);
                }
            }
        }
    }

    @Override // com.facebook.common.disk.DiskTrimmable
    public void trimToMinimum() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            synchronized (this.mLock) {
                maybeUpdateFileCacheSize();
                long size = this.mCacheStats.getSize();
                if (this.mCacheSizeLimitMinimum > 0 && size > 0 && size >= this.mCacheSizeLimitMinimum) {
                    double d2 = 1.0d - (this.mCacheSizeLimitMinimum / size);
                    if (d2 > 0.02d) {
                        trimBy(d2);
                    }
                }
            }
        }
    }

    @Override // com.facebook.common.disk.DiskTrimmable
    public void trimToNothing() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            clearAll();
        }
    }
}
