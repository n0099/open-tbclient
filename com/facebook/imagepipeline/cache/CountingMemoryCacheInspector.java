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
/* loaded from: classes7.dex */
public class CountingMemoryCacheInspector {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CountingMemoryCache mCountingBitmapCache;

    /* loaded from: classes7.dex */
    public class DumpInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final List lruEntries;
        public final int lruSize;
        public final int maxEntriesCount;
        public final int maxEntrySize;
        public final int maxSize;
        public final Map otherEntries;
        public final List sharedEntries;
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
                for (DumpInfoEntry dumpInfoEntry : this.lruEntries) {
                    dumpInfoEntry.release();
                }
                for (DumpInfoEntry dumpInfoEntry2 : this.sharedEntries) {
                    dumpInfoEntry2.release();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class DumpInfoEntry {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Object key;
        public final CloseableReference value;

        public DumpInfoEntry(Object obj, CloseableReference closeableReference) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj, closeableReference};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.key = Preconditions.checkNotNull(obj);
            this.value = CloseableReference.cloneOrNull(closeableReference);
        }

        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                CloseableReference.closeSafely(this.value);
            }
        }
    }

    public CountingMemoryCacheInspector(CountingMemoryCache countingMemoryCache) {
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
                for (Map.Entry entry : this.mCountingBitmapCache.mCachedEntries.getMatchingEntries(null)) {
                    CountingMemoryCache.Entry entry2 = (CountingMemoryCache.Entry) entry.getValue();
                    DumpInfoEntry dumpInfoEntry = new DumpInfoEntry(entry2.key, entry2.valueRef);
                    if (entry2.clientCount > 0) {
                        dumpInfo.sharedEntries.add(dumpInfoEntry);
                    } else {
                        dumpInfo.lruEntries.add(dumpInfoEntry);
                    }
                }
                for (Map.Entry entry3 : this.mCountingBitmapCache.mOtherEntries.entrySet()) {
                    if (entry3 != null && !((Bitmap) entry3.getKey()).isRecycled()) {
                        dumpInfo.otherEntries.put(entry3.getKey(), entry3.getValue());
                    }
                }
            }
            return dumpInfo;
        }
        return (DumpInfo) invokeV.objValue;
    }
}
