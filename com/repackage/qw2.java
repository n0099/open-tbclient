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
import com.repackage.hp1;
import com.repackage.i63;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class qw2 extends mw2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements sf3<c63<i63.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l22 a;
        public final /* synthetic */ kw2 b;
        public final /* synthetic */ l63 c;

        public a(qw2 qw2Var, l22 l22Var, kw2 kw2Var, l63 l63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qw2Var, l22Var, kw2Var, l63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l22Var;
            this.b = kw2Var;
            this.c = l63Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.sf3
        /* renamed from: b */
        public void a(c63<i63.d> c63Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c63Var) == null) {
                if (c63Var != null && c63Var.c() && !TextUtils.isEmpty(c63Var.a.a)) {
                    JSONObject jSONObject = this.c.g;
                    if (jSONObject != null) {
                        try {
                            jSONObject.put("code", c63Var.a.a);
                            this.b.d = true;
                        } catch (JSONException e) {
                            if (jh1.a) {
                                rw2.b(Log.getStackTraceString(e));
                            }
                        }
                        this.b.e = jSONObject.toString();
                    }
                    this.a.a(this.b);
                    return;
                }
                rw2.b("login failure, can't get login code");
                this.a.a(this.b);
            }
        }
    }

    public qw2() {
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

    @Override // com.repackage.nw2
    public zs1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            return null;
        }
        return (zs1) invokeL.objValue;
    }

    @Override // com.repackage.nw2
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "snsapi_userinfo" : (String) invokeV.objValue;
    }

    @Override // com.repackage.nw2
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "SwanPluginUserInfoFunPage" : (String) invokeV.objValue;
    }

    @Override // com.repackage.mw2
    public void p(SwanAppActivity swanAppActivity, String str, jw2 jw2Var, l63 l63Var, l22<kw2> l22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, swanAppActivity, str, jw2Var, l63Var, l22Var) == null) {
            kw2 kw2Var = new kw2(jw2Var.f);
            kw2Var.a = jw2Var.e;
            if (l63Var != null && l63Var.j.a() == 0) {
                rw2.b("obtain user info detail, get login code");
                hp1.d dVar = new hp1.d(jw2Var.g);
                Bundle bundle = new Bundle();
                bundle.putString("__plugin__", jw2Var.a);
                y03.K().q().e0().r(swanAppActivity, dVar, bundle, new a(this, l22Var, kw2Var, l63Var), "SwanPluginUserInfoFunPage");
                return;
            }
            rw2.b("open data result failure");
            l22Var.a(kw2Var);
        }
    }
}
