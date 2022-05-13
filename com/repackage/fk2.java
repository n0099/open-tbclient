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
import com.repackage.rl2;
import java.io.File;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes6.dex */
public class fk2 implements np3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public fk2() {
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

    @Override // com.repackage.np3
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? bk2.n().a() : (String) invokeV.objValue;
    }

    @Override // com.repackage.np3
    public boolean b(Context context, Intent intent, String str, String str2, String str3) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, intent, str, str2, str3)) == null) {
            if (bk2.a().d()) {
                return bk2.a().b(context, intent, str, str2, str3);
            }
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // com.repackage.np3
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? bk2.y0().c() : (String) invokeV.objValue;
    }

    @Override // com.repackage.np3
    public boolean d(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull DownloadParams.SwanAppDownloadType swanAppDownloadType, @NonNull uo3 uo3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, context, jSONObject, swanAppDownloadType, uo3Var)) == null) ? bk2.d().d(context, jSONObject, swanAppDownloadType, uo3Var) : invokeLLLL.booleanValue;
    }

    @Override // com.repackage.np3
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String i = bk2.h0().i(bk2.c());
            return TextUtils.isEmpty(i) ? oe3.r() : i;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.np3
    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            u03 L = u03.L();
            return L != null ? L.b : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.np3
    public String getAppKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            u03 L = u03.L();
            return L != null ? L.N() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.np3
    public String getSdkVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? fh1.a() : (String) invokeV.objValue;
    }

    @Override // com.repackage.np3
    public String k() {
        InterceptResult invokeV;
        rl2.a V;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            u03 a0 = u03.a0();
            return (a0 == null || (V = a0.V()) == null) ? "" : V.T();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.np3
    public String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) ? bk2.q().a().getCookie(str) : (String) invokeL.objValue;
    }

    @Override // com.repackage.np3
    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            u03 a0 = u03.a0();
            return a0 != null ? a0.V().j1().optString(TiebaStatic.Params.EQID, "") : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.np3
    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (hm2.U().getActivity() != null) {
                return de3.e(hm2.U().getActivity());
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.np3
    public String o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) ? tc3.b(str) : (String) invokeL.objValue;
    }

    @Override // com.repackage.np3
    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? ((Integer) hm2.U().x().second).intValue() : invokeV.intValue;
    }

    @Override // com.repackage.np3
    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? ((Integer) hm2.U().x().first).intValue() : invokeV.intValue;
    }

    @Override // com.repackage.np3
    public Uri r(@NonNull Context context, @NonNull File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, context, file)) == null) ? re3.a(context, file) : (Uri) invokeLL.objValue;
    }

    @Override // com.repackage.np3
    public String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? oe3.r() : (String) invokeV.objValue;
    }

    @Override // com.repackage.np3
    public JSONObject t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            u03 a0 = u03.a0();
            return a0 != null ? a0.V().M() : new JSONObject();
        }
        return (JSONObject) invokeV.objValue;
    }

    @Override // com.repackage.np3
    public boolean u(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, view2)) == null) {
            if (hm2.U().getActivity() != null) {
                return de3.q(hm2.U().getActivity(), view2);
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
