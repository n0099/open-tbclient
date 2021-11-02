package com.kwad.sdk.core.imageloader.cache.memory;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import java.lang.ref.Reference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/* loaded from: classes2.dex */
public abstract class BaseMemoryCache implements MemoryCache {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, Reference<DecodedResult>> softMap;

    public BaseMemoryCache() {
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
        this.softMap = Collections.synchronizedMap(new HashMap());
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.softMap.clear();
        }
    }

    public abstract Reference<DecodedResult> createReference(DecodedResult decodedResult);

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public DecodedResult get(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            Reference<DecodedResult> reference = this.softMap.get(str);
            if (reference != null) {
                return reference.get();
            }
            return null;
        }
        return (DecodedResult) invokeL.objValue;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public Collection<String> keys() {
        InterceptResult invokeV;
        HashSet hashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this.softMap) {
                hashSet = new HashSet(this.softMap.keySet());
            }
            return hashSet;
        }
        return (Collection) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public boolean put(String str, DecodedResult decodedResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, decodedResult)) == null) {
            this.softMap.put(str, createReference(decodedResult));
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public DecodedResult remove(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            Reference<DecodedResult> remove = this.softMap.remove(str);
            if (remove == null) {
                return null;
            }
            return remove.get();
        }
        return (DecodedResult) invokeL.objValue;
    }
}
