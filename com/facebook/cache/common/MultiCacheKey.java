package com.facebook.cache.common;

import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import java.util.List;
/* loaded from: classes6.dex */
public class MultiCacheKey implements CacheKey {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<CacheKey> mCacheKeys;

    public MultiCacheKey(List<CacheKey> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCacheKeys = (List) Preconditions.checkNotNull(list);
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean containsUri(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, uri)) == null) {
            for (int i2 = 0; i2 < this.mCacheKeys.size(); i2++) {
                if (this.mCacheKeys.get(i2).containsUri(uri)) {
                    return true;
                }
            }
            return false;
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
            if (obj instanceof MultiCacheKey) {
                return this.mCacheKeys.equals(((MultiCacheKey) obj).mCacheKeys);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public List<CacheKey> getCacheKeys() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mCacheKeys : (List) invokeV.objValue;
    }

    @Override // com.facebook.cache.common.CacheKey
    public String getUriString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mCacheKeys.get(0).getUriString() : (String) invokeV.objValue;
    }

    @Override // com.facebook.cache.common.CacheKey
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mCacheKeys.hashCode() : invokeV.intValue;
    }

    @Override // com.facebook.cache.common.CacheKey
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return "MultiCacheKey:" + this.mCacheKeys.toString();
        }
        return (String) invokeV.objValue;
    }
}
