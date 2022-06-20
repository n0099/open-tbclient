package com.repackage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.pk2;
import java.io.File;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes5.dex */
public class dj2 implements lo3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public dj2() {
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

    @Override // com.repackage.lo3
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? zi2.n().a() : (String) invokeV.objValue;
    }

    @Override // com.repackage.lo3
    public boolean b(Context context, Intent intent, String str, String str2, String str3) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, intent, str, str2, str3)) == null) {
            if (zi2.a().d()) {
                return zi2.a().b(context, intent, str, str2, str3);
            }
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // com.repackage.lo3
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? zi2.y0().c() : (String) invokeV.objValue;
    }

    @Override // com.repackage.lo3
    public boolean d(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull DownloadParams.SwanAppDownloadType swanAppDownloadType, @NonNull sn3 sn3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, context, jSONObject, swanAppDownloadType, sn3Var)) == null) ? zi2.d().d(context, jSONObject, swanAppDownloadType, sn3Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.lo3
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String i = zi2.h0().i(zi2.c());
            return TextUtils.isEmpty(i) ? md3.r() : i;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.lo3
    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            sz2 M = sz2.M();
            return M != null ? M.b : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.lo3
    public String getAppKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            sz2 M = sz2.M();
            return M != null ? M.O() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.lo3
    public String getSdkVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? dg1.a() : (String) invokeV.objValue;
    }

    @Override // com.repackage.lo3
    public String k() {
        InterceptResult invokeV;
        pk2.a W;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            sz2 b0 = sz2.b0();
            return (b0 == null || (W = b0.W()) == null) ? "" : W.T();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.lo3
    public String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) ? zi2.q().a().getCookie(str) : (String) invokeL.objValue;
    }

    @Override // com.repackage.lo3
    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            sz2 b0 = sz2.b0();
            return b0 != null ? b0.W().j1().optString(TiebaStatic.Params.EQID, "") : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.lo3
    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (fl2.U().getActivity() != null) {
                return bd3.e(fl2.U().getActivity());
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.lo3
    public String o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) ? rb3.b(str) : (String) invokeL.objValue;
    }

    @Override // com.repackage.lo3
    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? ((Integer) fl2.U().x().second).intValue() : invokeV.intValue;
    }

    @Override // com.repackage.lo3
    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? ((Integer) fl2.U().x().first).intValue() : invokeV.intValue;
    }

    @Override // com.repackage.lo3
    public Uri r(@NonNull Context context, @NonNull File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, context, file)) == null) ? pd3.a(context, file) : (Uri) invokeLL.objValue;
    }

    @Override // com.repackage.lo3
    public String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? md3.r() : (String) invokeV.objValue;
    }

    @Override // com.repackage.lo3
    public JSONObject t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            sz2 b0 = sz2.b0();
            return b0 != null ? b0.W().M() : new JSONObject();
        }
        return (JSONObject) invokeV.objValue;
    }

    @Override // com.repackage.lo3
    public boolean u(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, view2)) == null) {
            if (fl2.U().getActivity() != null) {
                return bd3.q(fl2.U().getActivity(), view2);
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
