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
import com.repackage.cp1;
import com.repackage.d63;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class lw2 extends hw2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements nf3<x53<d63.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g22 a;
        public final /* synthetic */ fw2 b;
        public final /* synthetic */ g63 c;

        public a(lw2 lw2Var, g22 g22Var, fw2 fw2Var, g63 g63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lw2Var, g22Var, fw2Var, g63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g22Var;
            this.b = fw2Var;
            this.c = g63Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(x53<d63.d> x53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, x53Var) == null) {
                if (x53Var != null && x53Var.c() && !TextUtils.isEmpty(x53Var.a.a)) {
                    JSONObject jSONObject = this.c.g;
                    if (jSONObject != null) {
                        try {
                            jSONObject.put("code", x53Var.a.a);
                            this.b.d = true;
                        } catch (JSONException e) {
                            if (eh1.a) {
                                mw2.b(Log.getStackTraceString(e));
                            }
                        }
                        this.b.e = jSONObject.toString();
                    }
                    this.a.a(this.b);
                    return;
                }
                mw2.b("login failure, can't get login code");
                this.a.a(this.b);
            }
        }
    }

    public lw2() {
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

    @Override // com.repackage.iw2
    public us1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            return null;
        }
        return (us1) invokeL.objValue;
    }

    @Override // com.repackage.iw2
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "snsapi_userinfo" : (String) invokeV.objValue;
    }

    @Override // com.repackage.iw2
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "SwanPluginUserInfoFunPage" : (String) invokeV.objValue;
    }

    @Override // com.repackage.hw2
    public void p(SwanAppActivity swanAppActivity, String str, ew2 ew2Var, g63 g63Var, g22<fw2> g22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, swanAppActivity, str, ew2Var, g63Var, g22Var) == null) {
            fw2 fw2Var = new fw2(ew2Var.f);
            fw2Var.a = ew2Var.e;
            if (g63Var != null && g63Var.j.a() == 0) {
                mw2.b("obtain user info detail, get login code");
                cp1.d dVar = new cp1.d(ew2Var.g);
                Bundle bundle = new Bundle();
                bundle.putString("__plugin__", ew2Var.a);
                t03.J().r().d0().r(swanAppActivity, dVar, bundle, new a(this, g22Var, fw2Var, g63Var), "SwanPluginUserInfoFunPage");
                return;
            }
            mw2.b("open data result failure");
            g22Var.a(fw2Var);
        }
    }
}
