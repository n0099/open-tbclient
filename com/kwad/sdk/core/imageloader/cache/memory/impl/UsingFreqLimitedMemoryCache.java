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
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public class UsingFreqLimitedMemoryCache extends LimitedMemoryCache {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<DecodedResult, Integer> usingCounts;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UsingFreqLimitedMemoryCache(int i2) {
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
        this.usingCounts = Collections.synchronizedMap(new HashMap());
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.LimitedMemoryCache, com.kwad.sdk.core.imageloader.cache.memory.BaseMemoryCache, com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.usingCounts.clear();
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
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            DecodedResult decodedResult = super.get(str);
            if (decodedResult != null && (num = this.usingCounts.get(decodedResult)) != null) {
                this.usingCounts.put(decodedResult, Integer.valueOf(num.intValue() + 1));
            }
            return decodedResult;
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
                this.usingCounts.put(decodedResult, 0);
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
            DecodedResult decodedResult = super.get(str);
            if (decodedResult != null) {
                this.usingCounts.remove(decodedResult);
            }
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
            Set<Map.Entry<DecodedResult, Integer>> entrySet = this.usingCounts.entrySet();
            synchronized (this.usingCounts) {
                decodedResult = null;
                Integer num = null;
                for (Map.Entry<DecodedResult, Integer> entry : entrySet) {
                    if (decodedResult == null) {
                        decodedResult = entry.getKey();
                        num = entry.getValue();
                    } else {
                        Integer value = entry.getValue();
                        if (value.intValue() < num.intValue()) {
                            decodedResult = entry.getKey();
                            num = value;
                        }
                    }
                }
            }
            this.usingCounts.remove(decodedResult);
            return decodedResult;
        }
        return (DecodedResult) invokeV.objValue;
    }
}
