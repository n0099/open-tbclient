package com.kwad.sdk.core.imageloader.cache.memory;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.utils.L;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public abstract class LimitedMemoryCache extends BaseMemoryCache {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_NORMAL_CACHE_SIZE = 16777216;
    public static final int MAX_NORMAL_CACHE_SIZE_IN_MB = 16;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicInteger cacheSize;
    public final List<DecodedResult> hardCache;
    public final int sizeLimit;

    public LimitedMemoryCache(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.hardCache = Collections.synchronizedList(new LinkedList());
        this.sizeLimit = i2;
        this.cacheSize = new AtomicInteger();
        if (i2 > 16777216) {
            L.w("You set too large memory cache size (more than %1$d Mb)", 16);
        }
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.BaseMemoryCache, com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.hardCache.clear();
            this.cacheSize.set(0);
            super.clear();
        }
    }

    public abstract int getSize(DecodedResult decodedResult);

    public int getSizeLimit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.sizeLimit : invokeV.intValue;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.BaseMemoryCache, com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public boolean put(String str, DecodedResult decodedResult) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, decodedResult)) == null) {
            int size = getSize(decodedResult);
            int sizeLimit = getSizeLimit();
            int i2 = this.cacheSize.get();
            if (size < sizeLimit) {
                while (i2 + size > sizeLimit) {
                    DecodedResult removeNext = removeNext();
                    if (this.hardCache.remove(removeNext)) {
                        i2 = this.cacheSize.addAndGet(-getSize(removeNext));
                    }
                }
                this.hardCache.add(decodedResult);
                this.cacheSize.addAndGet(size);
                z = true;
            } else {
                z = false;
            }
            super.put(str, decodedResult);
            return z;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.BaseMemoryCache, com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public DecodedResult remove(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            DecodedResult decodedResult = super.get(str);
            if (decodedResult != null && this.hardCache.remove(decodedResult)) {
                this.cacheSize.addAndGet(-getSize(decodedResult));
            }
            return super.remove(str);
        }
        return (DecodedResult) invokeL.objValue;
    }

    public abstract DecodedResult removeNext();
}
