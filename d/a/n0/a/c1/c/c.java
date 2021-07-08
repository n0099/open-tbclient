package d.a.n0.a.c1.c;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.f1.e.b;
import d.a.n0.a.l;
import d.a.n0.a.v2.f0;
import d.a.n0.a.v2.q0;
import d.a.n0.a.v2.s0;
import java.io.File;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes7.dex */
public class c implements d.a.n0.f.i.m.b.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
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

    @Override // d.a.n0.f.i.m.b.b
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? d.a.n0.a.c1.a.m().a() : (String) invokeV.objValue;
    }

    @Override // d.a.n0.f.i.m.b.b
    public boolean b(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull DownloadParams.SwanAppDownloadType swanAppDownloadType, @NonNull d.a.n0.f.i.k.f.a aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jSONObject, swanAppDownloadType, aVar)) == null) ? d.a.n0.a.c1.a.c().b(context, jSONObject, swanAppDownloadType, aVar) : invokeLLLL.booleanValue;
    }

    @Override // d.a.n0.f.i.m.b.b
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String i2 = d.a.n0.a.c1.a.a0().i(d.a.n0.a.c1.a.b());
            return TextUtils.isEmpty(i2) ? q0.r() : i2;
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.n0.f.i.m.b.b
    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            d.a.n0.a.a2.e i2 = d.a.n0.a.a2.e.i();
            return i2 != null ? i2.f43381f : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.n0.f.i.m.b.b
    public String getAppKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            d.a.n0.a.a2.e i2 = d.a.n0.a.a2.e.i();
            return i2 != null ? i2.D() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.n0.f.i.m.b.b
    public String getSdkVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? l.a() : (String) invokeV.objValue;
    }

    @Override // d.a.n0.f.i.m.b.b
    public String k() {
        InterceptResult invokeV;
        b.a L;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            d.a.n0.a.a2.e Q = d.a.n0.a.a2.e.Q();
            return (Q == null || (L = Q.L()) == null) ? "" : L.T();
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.n0.f.i.m.b.b
    public String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? d.a.n0.a.c1.a.p().a().getCookie(str) : (String) invokeL.objValue;
    }

    @Override // d.a.n0.f.i.m.b.b
    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            d.a.n0.a.a2.e Q = d.a.n0.a.a2.e.Q();
            return Q != null ? Q.L().h1().optString("eqid", "") : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.n0.f.i.m.b.b
    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (d.a.n0.a.g1.f.V().getActivity() != null) {
                return f0.e(d.a.n0.a.g1.f.V().getActivity());
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // d.a.n0.f.i.m.b.b
    public String o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) ? d.a.n0.a.s2.a.b(str) : (String) invokeL.objValue;
    }

    @Override // d.a.n0.f.i.m.b.b
    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? ((Integer) d.a.n0.a.g1.f.V().y().second).intValue() : invokeV.intValue;
    }

    @Override // d.a.n0.f.i.m.b.b
    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? ((Integer) d.a.n0.a.g1.f.V().y().first).intValue() : invokeV.intValue;
    }

    @Override // d.a.n0.f.i.m.b.b
    public Uri r(@NonNull Context context, @NonNull File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, context, file)) == null) ? s0.a(context, file) : (Uri) invokeLL.objValue;
    }

    @Override // d.a.n0.f.i.m.b.b
    public String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? q0.r() : (String) invokeV.objValue;
    }

    @Override // d.a.n0.f.i.m.b.b
    public JSONObject t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            d.a.n0.a.a2.e Q = d.a.n0.a.a2.e.Q();
            return Q != null ? Q.L().M() : new JSONObject();
        }
        return (JSONObject) invokeV.objValue;
    }

    @Override // d.a.n0.f.i.m.b.b
    public boolean u(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, view)) == null) {
            if (d.a.n0.a.g1.f.V().getActivity() != null) {
                return f0.q(d.a.n0.a.g1.f.V().getActivity(), view);
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
