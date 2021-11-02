package com.kwad.sdk.core.imageloader.cache.memory.impl;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.cache.memory.LimitedMemoryCache;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class LRULimitedMemoryCache extends LimitedMemoryCache {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INITIAL_CAPACITY = 10;
    public static final float LOAD_FACTOR = 1.1f;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, DecodedResult> lruCache;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LRULimitedMemoryCache(int i2) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.lruCache = Collections.synchronizedMap(new LinkedHashMap(10, 1.1f, true));
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.LimitedMemoryCache, com.kwad.sdk.core.imageloader.cache.memory.BaseMemoryCache, com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.lruCache.clear();
            super.clear();
        }
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.BaseMemoryCache
    public Reference<DecodedResult> createReference(DecodedResult decodedResult) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, decodedResult)) == null) ? new WeakReference(decodedResult) : (Reference) invokeL.objValue;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.BaseMemoryCache, com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public DecodedResult get(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.lruCache.get(str);
            return super.get(str);
        }
        return (DecodedResult) invokeL.objValue;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.LimitedMemoryCache
    public int getSize(DecodedResult decodedResult) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, decodedResult)) == null) ? decodedResult.getByteSize() : invokeL.intValue;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.LimitedMemoryCache, com.kwad.sdk.core.imageloader.cache.memory.BaseMemoryCache, com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public boolean put(String str, DecodedResult decodedResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, decodedResult)) == null) {
            if (super.put(str, decodedResult)) {
                this.lruCache.put(str, decodedResult);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.LimitedMemoryCache, com.kwad.sdk.core.imageloader.cache.memory.BaseMemoryCache, com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public DecodedResult remove(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.lruCache.remove(str);
            return super.remove(str);
        }
        return (DecodedResult) invokeL.objValue;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.LimitedMemoryCache
    public DecodedResult removeNext() {
        InterceptResult invokeV;
        DecodedResult decodedResult;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this.lruCache) {
                Iterator<Map.Entry<String, DecodedResult>> it = this.lruCache.entrySet().iterator();
                if (it.hasNext()) {
                    decodedResult = it.next().getValue();
                    it.remove();
                } else {
                    decodedResult = null;
                }
            }
            return decodedResult;
        }
        return (DecodedResult) invokeV.objValue;
    }
}
