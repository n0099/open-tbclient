package d.a.o0.a.t1.c.d;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.e2.c.i;
import d.a.o0.a.e2.c.j.f;
import d.a.o0.a.k;
import d.a.o0.a.u.e.a.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e extends d.a.o0.a.t1.c.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements d.a.o0.a.v2.e1.b<i<f.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.h0.j.b f47916e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.t1.c.c.a f47917f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.e2.d.a f47918g;

        public a(e eVar, d.a.o0.a.h0.j.b bVar, d.a.o0.a.t1.c.c.a aVar, d.a.o0.a.e2.d.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, bVar, aVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47916e = bVar;
            this.f47917f = aVar;
            this.f47918g = aVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<f.d> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (iVar != null && iVar.c() && !TextUtils.isEmpty(iVar.f44872a.f44890a)) {
                    JSONObject jSONObject = this.f47918g.f44907g;
                    if (jSONObject != null) {
                        try {
                            jSONObject.put("code", iVar.f44872a.f44890a);
                            this.f47917f.f47894d = true;
                        } catch (JSONException e2) {
                            if (k.f46335a) {
                                d.a.o0.a.t1.d.a.a(Log.getStackTraceString(e2));
                            }
                        }
                        this.f47917f.f47895e = jSONObject.toString();
                    }
                    this.f47916e.a(this.f47917f);
                    return;
                }
                d.a.o0.a.t1.d.a.a("login failure, can't get login code");
                this.f47916e.a(this.f47917f);
            }
        }
    }

    public e() {
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

    @Override // d.a.o0.a.t1.c.d.b
    public d.a.o0.a.u.h.b b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            return null;
        }
        return (d.a.o0.a.u.h.b) invokeL.objValue;
    }

    @Override // d.a.o0.a.t1.c.d.b
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "snsapi_userinfo" : (String) invokeV.objValue;
    }

    @Override // d.a.o0.a.t1.c.d.b
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "SwanPluginUserInfoFunPage" : (String) invokeV.objValue;
    }

    @Override // d.a.o0.a.t1.c.d.a
    public void p(SwanAppActivity swanAppActivity, String str, d.a.o0.a.t1.c.b.b bVar, d.a.o0.a.e2.d.a aVar, d.a.o0.a.h0.j.b<d.a.o0.a.t1.c.c.a> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, swanAppActivity, str, bVar, aVar, bVar2) == null) {
            d.a.o0.a.t1.c.c.a aVar2 = new d.a.o0.a.t1.c.c.a(bVar.f47887f);
            aVar2.f47891a = bVar.f47886e;
            if (aVar != null && aVar.j.a() == 0) {
                d.a.o0.a.t1.d.a.a("obtain user info detail, get login code");
                c.C0909c c0909c = new c.C0909c(bVar.f47888g);
                Bundle bundle = new Bundle();
                bundle.putString("__plugin__", bVar.f47882a);
                d.a.o0.a.a2.d.g().r().T().r(swanAppActivity, c0909c, bundle, new a(this, bVar2, aVar2, aVar), "SwanPluginUserInfoFunPage");
                return;
            }
            d.a.o0.a.t1.d.a.a("open data result failure");
            bVar2.a(aVar2);
        }
    }
}
