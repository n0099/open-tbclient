package com.yy.hiidostatis.defs.controller;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.DefaultPreference;
import com.yy.hiidostatis.inner.util.Util;
import com.yy.hiidostatis.inner.util.cipher.Base64Util;
/* loaded from: classes4.dex */
public class CacheManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public Context f63956c;
    public String mCacheKey;
    public String mCacheValue;
    public String mPrefCacheKey;
    public String mPrefCacheValue;

    public CacheManager(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63956c = context;
        this.mPrefCacheKey = str;
        this.mPrefCacheValue = str2;
        String cacheKey = getCacheKey();
        this.mCacheKey = cacheKey;
        this.mCacheValue = getCacheValue(context, cacheKey);
    }

    private String getCacheKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            try {
                return Util.formatDate("yyyyMMdd", System.currentTimeMillis());
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    private String getCacheValue(Context context, String str) {
        InterceptResult invokeLL;
        String prefString;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, context, str)) == null) {
            String prefString2 = DefaultPreference.getPreference().getPrefString(context, this.mPrefCacheKey, null);
            return (prefString2 == null || !prefString2.equals(this.mCacheKey) || (prefString = DefaultPreference.getPreference().getPrefString(context, this.mPrefCacheValue, null)) == null) ? "" : new String(Base64Util.decode(prefString));
        }
        return (String) invokeLL.objValue;
    }

    private void saveCacheValue(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, this, context, str, str2) == null) {
            DefaultPreference.getPreference().clearKey(context, DefaultPreference.getPreference().getPrefString(context, this.mPrefCacheKey, ""));
            DefaultPreference.getPreference().setPrefString(context, this.mPrefCacheKey, str);
            DefaultPreference.getPreference().setPrefString(context, this.mPrefCacheValue, Base64Util.encode(str2.getBytes()));
        }
    }

    public void add(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (this.mCacheValue.length() == 0) {
                this.mCacheValue = "|";
            }
            this.mCacheValue += str + "|";
        }
    }

    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            saveCacheValue(this.f63956c, this.mCacheKey, this.mCacheValue);
            this.mCacheValue = null;
        }
    }

    public boolean isContains(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            String str2 = this.mCacheValue;
            return str2.contains("|" + str + "|");
        }
        return invokeL.booleanValue;
    }
}
