package com.kwad.sdk.core.network;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
import com.kwad.sdk.utils.q;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public abstract class b implements g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final JSONObject f72320a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, String> f72321b;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f72321b = new HashMap();
        this.f72320a = new JSONObject();
        f();
        g();
        DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class)).a("KEY_HOST_ENCRYPT_DISABLE");
        if (a2 != null && ((Boolean) a2.getValue()).booleanValue()) {
            a("x-ksad-ignore-decrypt", String.valueOf(true));
        }
        String b2 = e.a().b();
        if (!TextUtils.isEmpty(b2)) {
            a("cookie", b2);
        }
        com.kwad.sdk.core.b.d.a(c());
    }

    @Override // com.kwad.sdk.core.network.g
    public abstract String a();

    public void a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2) == null) {
            q.a(this.f72320a, str, i2);
        }
    }

    public void a(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, str, j2) == null) {
            q.a(this.f72320a, str, j2);
        }
    }

    public void a(String str, com.kwad.sdk.core.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, bVar) == null) {
            q.a(this.f72320a, str, bVar);
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            this.f72321b.put(str, str2);
        }
    }

    public void a(String str, List<? extends com.kwad.sdk.core.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, list) == null) {
            q.a(this.f72320a, str, list);
        }
    }

    public void a(String str, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, jSONArray) == null) {
            q.a(this.f72320a, str, jSONArray);
        }
    }

    public void a(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, jSONObject) == null) {
            q.a(this.f72320a, str, jSONObject);
        }
    }

    public void a(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, z) == null) {
            q.a(this.f72320a, str, z);
        }
    }

    @Override // com.kwad.sdk.core.network.g
    @Nullable
    public SceneImpl b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (SceneImpl) invokeV.objValue;
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) {
            q.a(this.f72320a, str, str2);
        }
    }

    @Override // com.kwad.sdk.core.network.g
    public Map<String, String> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f72321b : (Map) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.network.g
    public Map<String, String> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return null;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.network.g
    public JSONObject e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class)).a("KEY_HOST_ENCRYPT_DISABLE");
            if (a2 == null || !((Boolean) a2.getValue()).booleanValue()) {
                JSONObject jSONObject = new JSONObject();
                q.a(jSONObject, "version", KsAdSDKImpl.get().getSDKVersion());
                q.a(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, KsAdSDKImpl.get().getAppId());
                q.a(jSONObject, "message", com.kwad.sdk.core.b.d.a(this.f72320a.toString()));
                com.kwad.sdk.core.b.d.a(a().replace(com.kwad.sdk.d.a(), ""), c(), jSONObject);
                return jSONObject;
            }
            return this.f72320a;
        }
        return (JSONObject) invokeV.objValue;
    }

    public abstract void f();

    public abstract void g();
}
