package com.facebook.imagepipeline.animated.impl;

import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.Iterator;
import java.util.LinkedHashSet;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes11.dex */
public class AnimatedFrameCache {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CountingMemoryCache<CacheKey, CloseableImage> mBackingCache;
    public final CountingMemoryCache.EntryStateObserver<CacheKey> mEntryStateObserver;
    @GuardedBy("this")
    public final LinkedHashSet<CacheKey> mFreeItemsPool;
    public final CacheKey mImageCacheKey;

    @VisibleForTesting
    /* loaded from: classes11.dex */
    public static class FrameKey implements CacheKey {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int mFrameIndex;
        public final CacheKey mImageCacheKey;

        public FrameKey(CacheKey cacheKey, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cacheKey, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mImageCacheKey = cacheKey;
            this.mFrameIndex = i2;
        }

        @Override // com.facebook.cache.common.CacheKey
        public boolean containsUri(Uri uri) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, uri)) == null) ? this.mImageCacheKey.containsUri(uri) : invokeL.booleanValue;
        }

        @Override // com.facebook.cache.common.CacheKey
        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof FrameKey) {
                    FrameKey frameKey = (FrameKey) obj;
                    return this.mFrameIndex == frameKey.mFrameIndex && this.mImageCacheKey.equals(frameKey.mImageCacheKey);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.facebook.cache.common.CacheKey
        @Nullable
        public String getUriString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.facebook.cache.common.CacheKey
        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.mImageCacheKey.hashCode() * 1013) + this.mFrameIndex : invokeV.intValue;
        }

        @Override // com.facebook.cache.common.CacheKey
        public boolean isResourceIdForDebugging() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.facebook.cache.common.CacheKey
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? Objects.toStringHelper(this).add("imageCacheKey", this.mImageCacheKey).add("frameIndex", this.mFrameIndex).toString() : (String) invokeV.objValue;
        }
    }

    public AnimatedFrameCache(CacheKey cacheKey, CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCache) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cacheKey, countingMemoryCache};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mImageCacheKey = cacheKey;
        this.mBackingCache = countingMemoryCache;
        this.mFreeItemsPool = new LinkedHashSet<>();
        this.mEntryStateObserver = new CountingMemoryCache.EntryStateObserver<CacheKey>(this) { // from class: com.facebook.imagepipeline.animated.impl.AnimatedFrameCache.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AnimatedFrameCache this$0;

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

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.cache.CountingMemoryCache.EntryStateObserver
            public void onExclusivityChanged(CacheKey cacheKey2, boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLZ(1048576, this, cacheKey2, z) == null) {
                    this.this$0.onReusabilityChange(cacheKey2, z);
                }
            }
        };
    }

    private FrameKey keyFor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i2)) == null) ? new FrameKey(this.mImageCacheKey, i2) : (FrameKey) invokeI.objValue;
    }

    @Nullable
    private synchronized CacheKey popFirstFreeItemKey() {
        InterceptResult invokeV;
        CacheKey cacheKey;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            synchronized (this) {
                cacheKey = null;
                Iterator<CacheKey> it = this.mFreeItemsPool.iterator();
                if (it.hasNext()) {
                    cacheKey = it.next();
                    it.remove();
                }
            }
            return cacheKey;
        }
        return (CacheKey) invokeV.objValue;
    }

    @Nullable
    public CloseableReference<CloseableImage> cache(int i2, CloseableReference<CloseableImage> closeableReference) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, closeableReference)) == null) ? this.mBackingCache.cache(keyFor(i2), closeableReference, this.mEntryStateObserver) : (CloseableReference) invokeIL.objValue;
    }

    public boolean contains(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.mBackingCache.contains((CountingMemoryCache<CacheKey, CloseableImage>) keyFor(i2)) : invokeI.booleanValue;
    }

    @Nullable
    public CloseableReference<CloseableImage> get(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.mBackingCache.get(keyFor(i2)) : (CloseableReference) invokeI.objValue;
    }

    @Nullable
    public CloseableReference<CloseableImage> getForReuse() {
        CloseableReference<CloseableImage> reuse;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            do {
                CacheKey popFirstFreeItemKey = popFirstFreeItemKey();
                if (popFirstFreeItemKey == null) {
                    return null;
                }
                reuse = this.mBackingCache.reuse(popFirstFreeItemKey);
            } while (reuse == null);
            return reuse;
        }
        return (CloseableReference) invokeV.objValue;
    }

    public synchronized void onReusabilityChange(CacheKey cacheKey, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, cacheKey, z) == null) {
            synchronized (this) {
                if (z) {
                    this.mFreeItemsPool.add(cacheKey);
                } else {
                    this.mFreeItemsPool.remove(cacheKey);
                }
            }
        }
    }
}
