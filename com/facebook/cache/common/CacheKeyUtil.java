package com.facebook.cache.common;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.util.SecureHashUtil;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public final class CacheKeyUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CacheKeyUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String getFirstResourceId(CacheKey cacheKey) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cacheKey)) == null) {
            try {
                if (cacheKey instanceof MultiCacheKey) {
                    return secureHashKey(((MultiCacheKey) cacheKey).getCacheKeys().get(0));
                }
                return secureHashKey(cacheKey);
            } catch (UnsupportedEncodingException e2) {
                throw new RuntimeException(e2);
            }
        }
        return (String) invokeL.objValue;
    }

    public static List<String> getResourceIds(CacheKey cacheKey) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cacheKey)) == null) {
            try {
                if (cacheKey instanceof MultiCacheKey) {
                    List<CacheKey> cacheKeys = ((MultiCacheKey) cacheKey).getCacheKeys();
                    ArrayList arrayList = new ArrayList(cacheKeys.size());
                    for (int i2 = 0; i2 < cacheKeys.size(); i2++) {
                        arrayList.add(secureHashKey(cacheKeys.get(i2)));
                    }
                    return arrayList;
                }
                ArrayList arrayList2 = new ArrayList(1);
                arrayList2.add(secureHashKey(cacheKey));
                return arrayList2;
            } catch (UnsupportedEncodingException e2) {
                throw new RuntimeException(e2);
            }
        }
        return (List) invokeL.objValue;
    }

    public static String secureHashKey(CacheKey cacheKey) throws UnsupportedEncodingException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, cacheKey)) == null) ? SecureHashUtil.makeSHA1HashBase64(cacheKey.getUriString().getBytes("UTF-8")) : (String) invokeL.objValue;
    }
}
