package com.kwad.sdk.core.imageloader.cache.memory.impl;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.cache.memory.MemoryCache;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class LruMemoryCache implements MemoryCache {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinkedHashMap<String, DecodedResult> map;
    public final int maxSize;
    public int size;

    public LruMemoryCache(int i2) {
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
        if (i2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.maxSize = i2;
        this.map = new LinkedHashMap<>(0, 0.75f, true);
    }

    private int sizeOf(String str, DecodedResult decodedResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, str, decodedResult)) == null) ? decodedResult.getByteSize() : invokeLL.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0071, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void trimToSize(int i2) {
        Map.Entry<String, DecodedResult> next;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, this, i2) == null) {
            while (true) {
                synchronized (this) {
                    if (this.size >= 0 && (!this.map.isEmpty() || this.size == 0)) {
                        if (this.size <= i2 || this.map.isEmpty() || (next = this.map.entrySet().iterator().next()) == null) {
                            break;
                        }
                        String key = next.getKey();
                        this.map.remove(key);
                        this.size -= sizeOf(key, next.getValue());
                    } else {
                        break;
                    }
                }
            }
        }
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            trimToSize(-1);
        }
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public final DecodedResult get(String str) {
        InterceptResult invokeL;
        DecodedResult decodedResult;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (str != null) {
                synchronized (this) {
                    decodedResult = this.map.get(str);
                }
                return decodedResult;
            }
            throw new NullPointerException("key == null");
        }
        return (DecodedResult) invokeL.objValue;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public Collection<String> keys() {
        InterceptResult invokeV;
        HashSet hashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                hashSet = new HashSet(this.map.keySet());
            }
            return hashSet;
        }
        return (Collection) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public final boolean put(String str, DecodedResult decodedResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, decodedResult)) == null) {
            if (str == null || decodedResult == null) {
                throw new NullPointerException("key == null || value == null");
            }
            synchronized (this) {
                this.size += sizeOf(str, decodedResult);
                DecodedResult put = this.map.put(str, decodedResult);
                if (put != null) {
                    this.size -= sizeOf(str, put);
                }
            }
            trimToSize(this.maxSize);
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public final DecodedResult remove(String str) {
        InterceptResult invokeL;
        DecodedResult remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str != null) {
                synchronized (this) {
                    remove = this.map.remove(str);
                    if (remove != null) {
                        this.size -= sizeOf(str, remove);
                    }
                }
                return remove;
            }
            throw new NullPointerException("key == null");
        }
        return (DecodedResult) invokeL.objValue;
    }

    public final synchronized String toString() {
        InterceptResult invokeV;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                format = String.format("LruCache[maxSize=%d]", Integer.valueOf(this.maxSize));
            }
            return format;
        }
        return (String) invokeV.objValue;
    }
}
