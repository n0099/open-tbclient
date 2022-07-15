package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.s03;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Interceptor;
@Singleton
@Service
/* loaded from: classes5.dex */
public class bk2 implements w64 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public bk2() {
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

    public final s03.a a() {
        InterceptResult invokeV;
        s03.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            h03 b0 = h03.b0();
            if (b0 == null) {
                if (rg1.a) {
                    Log.e("SwanNetworkImpl", "swanapp is null");
                }
                return null;
            }
            SwanAppConfigData Q = b0.Q();
            if (Q == null || (aVar = Q.h) == null) {
                if (rg1.a) {
                    Log.e("SwanNetworkImpl", "config or mNetworkConfig is null");
                }
                return null;
            }
            return aVar;
        }
        return (s03.a) invokeV.objValue;
    }

    @Override // com.repackage.w64
    public CookieManager f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? oj2.q().a() : (CookieManager) invokeV.objValue;
    }

    @Override // com.repackage.w64
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? s03.a.c(a()) : invokeV.intValue;
    }

    @Override // com.repackage.w64
    public Context getAppContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? AppRuntime.getAppContext() : (Context) invokeV.objValue;
    }

    @Override // com.repackage.w64
    public int getReadTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? s03.a.c(a()) : invokeV.intValue;
    }

    @Override // com.repackage.w64
    public String getUserAgent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            String g = SwanAppNetworkUtils.g();
            return (TextUtils.isEmpty(g) && j74.g().c()) ? gc3.a() : g;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.w64
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            oj2.g0().getSwitch("bbasm_framework_request_with_ua", true);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.w64
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName()) && iu2.c() : invokeV.booleanValue;
    }

    @Override // com.repackage.w64
    public boolean isDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? rg1.a : invokeV.booleanValue;
    }

    @Override // com.repackage.w64
    public void j(String str, HttpRequestBuilder httpRequestBuilder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, str, httpRequestBuilder) == null) && dx1.u(str)) {
            httpRequestBuilder.setHeader("x-u-id", rg4.b(AppRuntime.getAppContext()).a());
            try {
                httpRequestBuilder.setHeader("x-c2-id", oj2.h0().i(AppRuntime.getAppContext()));
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    @Override // com.repackage.w64
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? fu2.a() == 2 ? 128 : 0 : invokeV.intValue;
    }

    @Override // com.repackage.w64
    public List<Interceptor> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new zr2());
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.repackage.w64
    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? s03.a.c(a()) : invokeV.intValue;
    }
}
