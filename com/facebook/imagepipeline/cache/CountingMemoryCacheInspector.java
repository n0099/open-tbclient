package com.facebook.imagepipeline.cache;

import android.graphics.Bitmap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class CountingMemoryCacheInspector<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CountingMemoryCache<K, V> mCountingBitmapCache;

    /* loaded from: classes4.dex */
    public static class DumpInfo<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final List<DumpInfoEntry<K, V>> lruEntries;
        public final int lruSize;
        public final int maxEntriesCount;
        public final int maxEntrySize;
        public final int maxSize;
        public final Map<Bitmap, Object> otherEntries;
        public final List<DumpInfoEntry<K, V>> sharedEntries;
        public final int size;

        public DumpInfo(int i, int i2, MemoryCacheParams memoryCacheParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), memoryCacheParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.maxSize = memoryCacheParams.maxCacheSize;
            this.maxEntriesCount = memoryCacheParams.maxCacheEntries;
            this.maxEntrySize = memoryCacheParams.maxCacheEntrySize;
            this.size = i;
            this.lruSize = i2;
            this.lruEntries = new ArrayList();
            this.sharedEntries = new ArrayList();
            this.otherEntries = new HashMap();
        }

        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (DumpInfoEntry<K, V> dumpInfoEntry : this.lruEntries) {
                    dumpInfoEntry.release();
                }
                for (DumpInfoEntry<K, V> dumpInfoEntry2 : this.sharedEntries) {
                    dumpInfoEntry2.release();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class DumpInfoEntry<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final K key;
        public final CloseableReference<V> value;

        public DumpInfoEntry(K k, CloseableReference<V> closeableReference) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k, closeableReference};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.key = (K) Preconditions.checkNotNull(k);
            this.value = CloseableReference.cloneOrNull(closeableReference);
        }

        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                CloseableReference.closeSafely((CloseableReference<?>) this.value);
            }
        }
    }

    public CountingMemoryCacheInspector(CountingMemoryCache<K, V> countingMemoryCache) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {countingMemoryCache};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCountingBitmapCache = countingMemoryCache;
    }

    public DumpInfo dumpCacheContent() {
        InterceptResult invokeV;
        DumpInfo dumpInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this.mCountingBitmapCache) {
                dumpInfo = new DumpInfo(this.mCountingBitmapCache.getSizeInBytes(), this.mCountingBitmapCache.getEvictionQueueSizeInBytes(), this.mCountingBitmapCache.mMemoryCacheParams);
                for (Map.Entry<K, CountingMemoryCache.Entry<K, V>> entry : this.mCountingBitmapCache.mCachedEntries.getMatchingEntries(null)) {
                    CountingMemoryCache.Entry<K, V> value = entry.getValue();
                    DumpInfoEntry<K, V> dumpInfoEntry = new DumpInfoEntry<>(value.key, value.valueRef);
                    if (value.clientCount > 0) {
                        dumpInfo.sharedEntries.add(dumpInfoEntry);
                    } else {
                        dumpInfo.lruEntries.add(dumpInfoEntry);
                    }
                }
                for (Map.Entry<Bitmap, Object> entry2 : this.mCountingBitmapCache.mOtherEntries.entrySet()) {
                    if (entry2 != null && !entry2.getKey().isRecycled()) {
                        dumpInfo.otherEntries.put(entry2.getKey(), entry2.getValue());
                    }
                }
            }
            return dumpInfo;
        }
        return (DumpInfo) invokeV.objValue;
    }
}
