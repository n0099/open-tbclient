package com.google.android.exoplayer2.upstream.cache;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.upstream.cache.Cache;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;
/* loaded from: classes7.dex */
public final class CachedRegionTracker implements Cache.Listener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CACHED_TO_END = -2;
    public static final int NOT_CACHED = -1;
    public static final String TAG = "CachedRegionTracker";
    public transient /* synthetic */ FieldHolder $fh;
    public final Cache cache;
    public final String cacheKey;
    public final ChunkIndex chunkIndex;
    public final Region lookupRegion;
    public final TreeSet regions;

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
    public void onSpanTouched(Cache cache, CacheSpan cacheSpan, CacheSpan cacheSpan2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, cache, cacheSpan, cacheSpan2) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class Region implements Comparable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long endOffset;
        public int endOffsetIndex;
        public long startOffset;

        public Region(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.startOffset = j;
            this.endOffset = j2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        public int compareTo(Region region) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, region)) == null) {
                long j = this.startOffset;
                long j2 = region.startOffset;
                if (j < j2) {
                    return -1;
                }
                if (j == j2) {
                    return 0;
                }
                return 1;
            }
            return invokeL.intValue;
        }
    }

    public CachedRegionTracker(Cache cache, String str, ChunkIndex chunkIndex) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cache, str, chunkIndex};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.cache = cache;
        this.cacheKey = str;
        this.chunkIndex = chunkIndex;
        this.regions = new TreeSet();
        this.lookupRegion = new Region(0L, 0L);
        synchronized (this) {
            NavigableSet addListener = cache.addListener(str, this);
            if (addListener != null) {
                Iterator descendingIterator = addListener.descendingIterator();
                while (descendingIterator.hasNext()) {
                    mergeSpan((CacheSpan) descendingIterator.next());
                }
            }
        }
    }

    private void mergeSpan(CacheSpan cacheSpan) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, cacheSpan) == null) {
            long j = cacheSpan.position;
            Region region = new Region(j, cacheSpan.length + j);
            Region region2 = (Region) this.regions.floor(region);
            Region region3 = (Region) this.regions.ceiling(region);
            boolean regionsConnect = regionsConnect(region2, region);
            if (regionsConnect(region, region3)) {
                if (regionsConnect) {
                    region2.endOffset = region3.endOffset;
                    region2.endOffsetIndex = region3.endOffsetIndex;
                } else {
                    region.endOffset = region3.endOffset;
                    region.endOffsetIndex = region3.endOffsetIndex;
                    this.regions.add(region);
                }
                this.regions.remove(region3);
            } else if (regionsConnect) {
                region2.endOffset = region.endOffset;
                int i = region2.endOffsetIndex;
                while (true) {
                    ChunkIndex chunkIndex = this.chunkIndex;
                    if (i >= chunkIndex.length - 1) {
                        break;
                    }
                    int i2 = i + 1;
                    if (chunkIndex.offsets[i2] > region2.endOffset) {
                        break;
                    }
                    i = i2;
                }
                region2.endOffsetIndex = i;
            } else {
                int binarySearch = Arrays.binarySearch(this.chunkIndex.offsets, region.endOffset);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 2;
                }
                region.endOffsetIndex = binarySearch;
                this.regions.add(region);
            }
        }
    }

    public synchronized int getRegionEndTimeMs(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            synchronized (this) {
                this.lookupRegion.startOffset = j;
                Region region = (Region) this.regions.floor(this.lookupRegion);
                if (region != null && j <= region.endOffset && region.endOffsetIndex != -1) {
                    int i = region.endOffsetIndex;
                    if (i == this.chunkIndex.length - 1) {
                        if (region.endOffset == this.chunkIndex.offsets[i] + this.chunkIndex.sizes[i]) {
                            return -2;
                        }
                    }
                    return (int) ((this.chunkIndex.timesUs[i] + ((this.chunkIndex.durationsUs[i] * (region.endOffset - this.chunkIndex.offsets[i])) / this.chunkIndex.sizes[i])) / 1000);
                }
                return -1;
            }
        }
        return invokeJ.intValue;
    }

    private boolean regionsConnect(Region region, Region region2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, region, region2)) == null) {
            if (region != null && region2 != null && region.endOffset == region2.startOffset) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
    public synchronized void onSpanAdded(Cache cache, CacheSpan cacheSpan) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cache, cacheSpan) == null) {
            synchronized (this) {
                mergeSpan(cacheSpan);
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
    public synchronized void onSpanRemoved(Cache cache, CacheSpan cacheSpan) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cache, cacheSpan) == null) {
            synchronized (this) {
                Region region = new Region(cacheSpan.position, cacheSpan.position + cacheSpan.length);
                Region region2 = (Region) this.regions.floor(region);
                if (region2 == null) {
                    Log.e(TAG, "Removed a span we were not aware of");
                    return;
                }
                this.regions.remove(region2);
                if (region2.startOffset < region.startOffset) {
                    Region region3 = new Region(region2.startOffset, region.startOffset);
                    int binarySearch = Arrays.binarySearch(this.chunkIndex.offsets, region3.endOffset);
                    if (binarySearch < 0) {
                        binarySearch = (-binarySearch) - 2;
                    }
                    region3.endOffsetIndex = binarySearch;
                    this.regions.add(region3);
                }
                if (region2.endOffset > region.endOffset) {
                    Region region4 = new Region(region.endOffset + 1, region2.endOffset);
                    region4.endOffsetIndex = region2.endOffsetIndex;
                    this.regions.add(region4);
                }
            }
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.cache.removeListener(this.cacheKey, this);
        }
    }
}
