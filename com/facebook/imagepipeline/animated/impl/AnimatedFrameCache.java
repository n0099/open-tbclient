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
/* loaded from: classes7.dex */
public class AnimatedFrameCache {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CountingMemoryCache<CacheKey, CloseableImage> mBackingCache;
    public final CountingMemoryCache.EntryStateObserver<CacheKey> mEntryStateObserver;
    @GuardedBy("this")
    public final LinkedHashSet<CacheKey> mFreeItemsPool;
    public final CacheKey mImageCacheKey;

    @VisibleForTesting
    /* loaded from: classes7.dex */
    public static class FrameKey implements CacheKey {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int mFrameIndex;
        public final CacheKey mImageCacheKey;

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
        public boolean isResourceIdForDebugging() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        public FrameKey(CacheKey cacheKey, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cacheKey, Integer.valueOf(i)};
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
            this.mFrameIndex = i;
        }

        @Override // com.facebook.cache.common.CacheKey
        public boolean containsUri(Uri uri) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, uri)) == null) {
                return this.mImageCacheKey.containsUri(uri);
            }
            return invokeL.booleanValue;
        }

        @Override // com.facebook.cache.common.CacheKey
        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof FrameKey)) {
                    return false;
                }
                FrameKey frameKey = (FrameKey) obj;
                if (this.mFrameIndex == frameKey.mFrameIndex && this.mImageCacheKey.equals(frameKey.mImageCacheKey)) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.facebook.cache.common.CacheKey
        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return (this.mImageCacheKey.hashCode() * 1013) + this.mFrameIndex;
            }
            return invokeV.intValue;
        }

        @Override // com.facebook.cache.common.CacheKey
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return Objects.toStringHelper(this).add("imageCacheKey", this.mImageCacheKey).add("frameIndex", this.mFrameIndex).toString();
            }
            return (String) invokeV.objValue;
        }
    }

    public AnimatedFrameCache(CacheKey cacheKey, CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCache) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cacheKey, countingMemoryCache};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
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

    private FrameKey keyFor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i)) == null) {
            return new FrameKey(this.mImageCacheKey, i);
        }
        return (FrameKey) invokeI.objValue;
    }

    public boolean contains(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return this.mBackingCache.contains((CountingMemoryCache<CacheKey, CloseableImage>) keyFor(i));
        }
        return invokeI.booleanValue;
    }

    @Nullable
    public CloseableReference<CloseableImage> get(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            return this.mBackingCache.get(keyFor(i));
        }
        return (CloseableReference) invokeI.objValue;
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

    @Nullable
    public CloseableReference<CloseableImage> cache(int i, CloseableReference<CloseableImage> closeableReference) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, closeableReference)) == null) {
            return this.mBackingCache.cache(keyFor(i), closeableReference, this.mEntryStateObserver);
        }
        return (CloseableReference) invokeIL.objValue;
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
