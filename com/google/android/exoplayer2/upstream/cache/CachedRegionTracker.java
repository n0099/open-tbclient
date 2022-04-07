package com.google.android.exoplayer2.upstream.cache;

import android.util.Log;
import androidx.annotation.NonNull;
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
/* loaded from: classes4.dex */
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
    public final TreeSet<Region> regions;

    /* loaded from: classes4.dex */
    public static class Region implements Comparable<Region> {
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
        public int compareTo(@NonNull Region region) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, region)) == null) {
                long j = this.startOffset;
                long j2 = region.startOffset;
                if (j < j2) {
                    return -1;
                }
                return j == j2 ? 0 : 1;
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
        this.regions = new TreeSet<>();
        this.lookupRegion = new Region(0L, 0L);
        synchronized (this) {
            NavigableSet<CacheSpan> addListener = cache.addListener(str, this);
            if (addListener != null) {
                Iterator<CacheSpan> descendingIterator = addListener.descendingIterator();
                while (descendingIterator.hasNext()) {
                    mergeSpan(descendingIterator.next());
                }
            }
        }
    }

    private void mergeSpan(CacheSpan cacheSpan) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, cacheSpan) == null) {
            long j = cacheSpan.position;
            Region region = new Region(j, cacheSpan.length + j);
            Region floor = this.regions.floor(region);
            Region ceiling = this.regions.ceiling(region);
            boolean regionsConnect = regionsConnect(floor, region);
            if (regionsConnect(region, ceiling)) {
                if (regionsConnect) {
                    floor.endOffset = ceiling.endOffset;
                    floor.endOffsetIndex = ceiling.endOffsetIndex;
                } else {
                    region.endOffset = ceiling.endOffset;
                    region.endOffsetIndex = ceiling.endOffsetIndex;
                    this.regions.add(region);
                }
                this.regions.remove(ceiling);
            } else if (regionsConnect) {
                floor.endOffset = region.endOffset;
                int i = floor.endOffsetIndex;
                while (true) {
                    ChunkIndex chunkIndex = this.chunkIndex;
                    if (i >= chunkIndex.length - 1) {
                        break;
                    }
                    int i2 = i + 1;
                    if (chunkIndex.offsets[i2] > floor.endOffset) {
                        break;
                    }
                    i = i2;
                }
                floor.endOffsetIndex = i;
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

    private boolean regionsConnect(Region region, Region region2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, region, region2)) == null) ? (region == null || region2 == null || region.endOffset != region2.startOffset) ? false : true : invokeLL.booleanValue;
    }

    public synchronized int getRegionEndTimeMs(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            synchronized (this) {
                this.lookupRegion.startOffset = j;
                Region floor = this.regions.floor(this.lookupRegion);
                if (floor != null && j <= floor.endOffset && floor.endOffsetIndex != -1) {
                    int i = floor.endOffsetIndex;
                    if (i == this.chunkIndex.length - 1) {
                        if (floor.endOffset == this.chunkIndex.offsets[i] + this.chunkIndex.sizes[i]) {
                            return -2;
                        }
                    }
                    return (int) ((this.chunkIndex.timesUs[i] + ((this.chunkIndex.durationsUs[i] * (floor.endOffset - this.chunkIndex.offsets[i])) / this.chunkIndex.sizes[i])) / 1000);
                }
                return -1;
            }
        }
        return invokeJ.intValue;
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
                Region floor = this.regions.floor(region);
                if (floor == null) {
                    Log.e(TAG, "Removed a span we were not aware of");
                    return;
                }
                this.regions.remove(floor);
                if (floor.startOffset < region.startOffset) {
                    Region region2 = new Region(floor.startOffset, region.startOffset);
                    int binarySearch = Arrays.binarySearch(this.chunkIndex.offsets, region2.endOffset);
                    if (binarySearch < 0) {
                        binarySearch = (-binarySearch) - 2;
                    }
                    region2.endOffsetIndex = binarySearch;
                    this.regions.add(region2);
                }
                if (floor.endOffset > region.endOffset) {
                    Region region3 = new Region(region.endOffset + 1, floor.endOffset);
                    region3.endOffsetIndex = floor.endOffsetIndex;
                    this.regions.add(region3);
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
    public void onSpanTouched(Cache cache, CacheSpan cacheSpan, CacheSpan cacheSpan2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, cache, cacheSpan, cacheSpan2) == null) {
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.cache.removeListener(this.cacheKey, this);
        }
    }
}
