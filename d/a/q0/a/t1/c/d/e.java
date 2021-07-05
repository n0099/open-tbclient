package d.a.q0.a.t1.c.d;

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
import d.a.q0.a.e2.c.i;
import d.a.q0.a.e2.c.j.f;
import d.a.q0.a.k;
import d.a.q0.a.u.e.a.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e extends d.a.q0.a.t1.c.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements d.a.q0.a.v2.e1.b<i<f.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.h0.j.b f50714e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.t1.c.c.a f50715f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.e2.d.a f50716g;

        public a(e eVar, d.a.q0.a.h0.j.b bVar, d.a.q0.a.t1.c.c.a aVar, d.a.q0.a.e2.d.a aVar2) {
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
            this.f50714e = bVar;
            this.f50715f = aVar;
            this.f50716g = aVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<f.d> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (iVar != null && iVar.c() && !TextUtils.isEmpty(iVar.f47670a.f47688a)) {
                    JSONObject jSONObject = this.f50716g.f47705g;
                    if (jSONObject != null) {
                        try {
                            jSONObject.put("code", iVar.f47670a.f47688a);
                            this.f50715f.f50692d = true;
                        } catch (JSONException e2) {
                            if (k.f49133a) {
                                d.a.q0.a.t1.d.a.a(Log.getStackTraceString(e2));
                            }
                        }
                        this.f50715f.f50693e = jSONObject.toString();
                    }
                    this.f50714e.a(this.f50715f);
                    return;
                }
                d.a.q0.a.t1.d.a.a("login failure, can't get login code");
                this.f50714e.a(this.f50715f);
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

    @Override // d.a.q0.a.t1.c.d.b
    public d.a.q0.a.u.h.b b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            return null;
        }
        return (d.a.q0.a.u.h.b) invokeL.objValue;
    }

    @Override // d.a.q0.a.t1.c.d.b
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "snsapi_userinfo" : (String) invokeV.objValue;
    }

    @Override // d.a.q0.a.t1.c.d.b
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "SwanPluginUserInfoFunPage" : (String) invokeV.objValue;
    }

    @Override // d.a.q0.a.t1.c.d.a
    public void p(SwanAppActivity swanAppActivity, String str, d.a.q0.a.t1.c.b.b bVar, d.a.q0.a.e2.d.a aVar, d.a.q0.a.h0.j.b<d.a.q0.a.t1.c.c.a> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, swanAppActivity, str, bVar, aVar, bVar2) == null) {
            d.a.q0.a.t1.c.c.a aVar2 = new d.a.q0.a.t1.c.c.a(bVar.f50685f);
            aVar2.f50689a = bVar.f50684e;
            if (aVar != null && aVar.j.a() == 0) {
                d.a.q0.a.t1.d.a.a("obtain user info detail, get login code");
                c.C0951c c0951c = new c.C0951c(bVar.f50686g);
                Bundle bundle = new Bundle();
                bundle.putString("__plugin__", bVar.f50680a);
                d.a.q0.a.a2.d.g().r().T().r(swanAppActivity, c0951c, bundle, new a(this, bVar2, aVar2, aVar), "SwanPluginUserInfoFunPage");
                return;
            }
            d.a.q0.a.t1.d.a.a("open data result failure");
            bVar2.a(aVar2);
        }
    }
}
