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
/* loaded from: classes7.dex */
public final class CacheKeyUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CacheKeyUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }
        return (String) invokeL.objValue;
    }

    public static List<String> getResourceIds(CacheKey cacheKey) {
        ArrayList arrayList;
        String secureHashKey;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cacheKey)) == null) {
            try {
                if (cacheKey instanceof MultiCacheKey) {
                    List<CacheKey> cacheKeys = ((MultiCacheKey) cacheKey).getCacheKeys();
                    arrayList = new ArrayList(cacheKeys.size());
                    for (int i = 0; i < cacheKeys.size(); i++) {
                        arrayList.add(secureHashKey(cacheKeys.get(i)));
                    }
                } else {
                    arrayList = new ArrayList(1);
                    if (cacheKey.isResourceIdForDebugging()) {
                        secureHashKey = cacheKey.getUriString();
                    } else {
                        secureHashKey = secureHashKey(cacheKey);
                    }
                    arrayList.add(secureHashKey);
                }
                return arrayList;
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }
        return (List) invokeL.objValue;
    }

    public static String secureHashKey(CacheKey cacheKey) throws UnsupportedEncodingException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, cacheKey)) == null) {
            return SecureHashUtil.makeSHA1HashBase64(cacheKey.getUriString().getBytes("UTF-8"));
        }
        return (String) invokeL.objValue;
    }
}
