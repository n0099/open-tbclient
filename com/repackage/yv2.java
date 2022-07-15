package com.repackage;

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
import com.repackage.po1;
import com.repackage.q53;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class yv2 extends uv2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements af3<k53<q53.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t12 a;
        public final /* synthetic */ sv2 b;
        public final /* synthetic */ t53 c;

        public a(yv2 yv2Var, t12 t12Var, sv2 sv2Var, t53 t53Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yv2Var, t12Var, sv2Var, t53Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t12Var;
            this.b = sv2Var;
            this.c = t53Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(k53<q53.d> k53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k53Var) == null) {
                if (k53Var != null && k53Var.c() && !TextUtils.isEmpty(k53Var.a.a)) {
                    JSONObject jSONObject = this.c.g;
                    if (jSONObject != null) {
                        try {
                            jSONObject.put("code", k53Var.a.a);
                            this.b.d = true;
                        } catch (JSONException e) {
                            if (rg1.a) {
                                zv2.b(Log.getStackTraceString(e));
                            }
                        }
                        this.b.e = jSONObject.toString();
                    }
                    this.a.a(this.b);
                    return;
                }
                zv2.b("login failure, can't get login code");
                this.a.a(this.b);
            }
        }
    }

    public yv2() {
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

    @Override // com.repackage.vv2
    public hs1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            return null;
        }
        return (hs1) invokeL.objValue;
    }

    @Override // com.repackage.vv2
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "snsapi_userinfo" : (String) invokeV.objValue;
    }

    @Override // com.repackage.vv2
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "SwanPluginUserInfoFunPage" : (String) invokeV.objValue;
    }

    @Override // com.repackage.uv2
    public void p(SwanAppActivity swanAppActivity, String str, rv2 rv2Var, t53 t53Var, t12<sv2> t12Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, swanAppActivity, str, rv2Var, t53Var, t12Var) == null) {
            sv2 sv2Var = new sv2(rv2Var.f);
            sv2Var.a = rv2Var.e;
            if (t53Var != null && t53Var.j.a() == 0) {
                zv2.b("obtain user info detail, get login code");
                po1.d dVar = new po1.d(rv2Var.g);
                Bundle bundle = new Bundle();
                bundle.putString("__plugin__", rv2Var.a);
                g03.K().q().e0().r(swanAppActivity, dVar, bundle, new a(this, t12Var, sv2Var, t53Var), "SwanPluginUserInfoFunPage");
                return;
            }
            zv2.b("open data result failure");
            t12Var.a(sv2Var);
        }
    }
}
