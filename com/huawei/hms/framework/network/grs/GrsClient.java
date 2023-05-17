package com.huawei.hms.framework.network.grs;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class GrsClient {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EMPTY_STRING = "";
    public transient /* synthetic */ FieldHolder $fh;
    public final c grsClientGlobal;

    public GrsClient(Context context, GrsBaseInfo grsBaseInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, grsBaseInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (context == null || grsBaseInfo == null) {
            throw new NullPointerException("invalid init params for context is null or GrsBaseInfo instance is null Object.");
        }
        this.grsClientGlobal = d.a(grsBaseInfo, context);
    }

    public void ayncGetGrsUrl(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, iQueryUrlCallBack) == null) {
            c cVar = this.grsClientGlobal;
            if (cVar == null) {
                iQueryUrlCallBack.onCallBackFail(-8);
            } else {
                cVar.a(str, str2, iQueryUrlCallBack);
            }
        }
    }

    public void ayncGetGrsUrls(String str, IQueryUrlsCallBack iQueryUrlsCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, iQueryUrlsCallBack) == null) {
            c cVar = this.grsClientGlobal;
            if (cVar == null) {
                iQueryUrlsCallBack.onCallBackFail(-8);
            } else {
                cVar.a(str, iQueryUrlsCallBack);
            }
        }
    }

    public void clearSp() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (cVar = this.grsClientGlobal) == null) {
            return;
        }
        cVar.a();
    }

    public boolean forceExpire() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c cVar = this.grsClientGlobal;
            if (cVar == null) {
                return false;
            }
            return cVar.b();
        }
        return invokeV.booleanValue;
    }

    public String synGetGrsUrl(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            c cVar = this.grsClientGlobal;
            return cVar == null ? "" : cVar.a(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    public Map<String, String> synGetGrsUrls(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            c cVar = this.grsClientGlobal;
            return cVar == null ? new HashMap() : cVar.a(str);
        }
        return (Map) invokeL.objValue;
    }
}
