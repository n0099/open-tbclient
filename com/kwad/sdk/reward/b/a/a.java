package com.kwad.sdk.reward.b.a;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.t;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends com.kwad.sdk.reward.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public c f58881b;

    /* renamed from: c  reason: collision with root package name */
    public C2047a f58882c;

    /* renamed from: d  reason: collision with root package name */
    public final b f58883d;

    /* renamed from: com.kwad.sdk.reward.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C2047a extends com.kwad.sdk.reward.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C2047a() {
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
            this.a = "安装应用";
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends com.kwad.sdk.reward.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = String.format("体验应用%s秒", i2 + "");
        }
    }

    /* loaded from: classes2.dex */
    public static class c extends com.kwad.sdk.reward.b.a {
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
                    return;
                }
            }
            this.a = "观看视频";
        }
    }

    public a() {
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
        this.f58881b = new c();
        this.f58882c = new C2047a();
        this.f58883d = new b(com.kwad.sdk.core.config.b.az());
    }

    public static void a(a aVar, Context context, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, aVar, context, adTemplate) == null) {
            if (ag.a(context, com.kwad.sdk.core.response.a.a.v(d.j(adTemplate)))) {
                aVar.h();
            } else {
                aVar.i();
            }
        }
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            if (this.f58881b.d() && this.f58882c.d() && this.f58883d.d()) {
                a();
            } else {
                b();
            }
        }
    }

    @Override // com.kwad.sdk.reward.b.a, com.kwad.sdk.reward.b.b
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f58881b.d() && this.f58882c.d() && this.f58883d.d() : invokeV.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            com.kwad.sdk.core.d.a.a("LaunchAppTask", "markWatchVideoCompleted");
            this.f58881b.a();
            n();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            com.kwad.sdk.core.d.a.a("LaunchAppTask", "markInstallCompleted");
            this.f58882c.a();
            n();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            com.kwad.sdk.core.d.a.a("LaunchAppTask", "markInstallUncompleted");
            this.f58882c.b();
            n();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            com.kwad.sdk.core.d.a.a("LaunchAppTask", "markUseAppCompleted");
            this.f58883d.a();
            n();
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            com.kwad.sdk.core.d.a.a("LaunchAppTask", "isInstallCompleted");
            return this.f58882c.d();
        }
        return invokeV.booleanValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int i2 = 0;
            for (com.kwad.sdk.reward.b.b bVar : m()) {
                if (!bVar.d()) {
                    i2++;
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public List<com.kwad.sdk.reward.b.b> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f58881b);
            arrayList.add(this.f58882c);
            arrayList.add(this.f58883d);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.kwad.sdk.reward.b.a, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) {
            try {
                this.f58881b.parseJson(jSONObject.optJSONObject("mWatchVideoTask"));
                this.f58882c.parseJson(jSONObject.optJSONObject("mInstallAppTask"));
                this.f58883d.parseJson(jSONObject.optJSONObject("mUseAppTask"));
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.kwad.sdk.reward.b.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            t.a(jSONObject, "mWatchVideoTask", this.f58881b);
            t.a(jSONObject, "mInstallAppTask", this.f58882c);
            t.a(jSONObject, "mUseAppTask", this.f58883d);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
