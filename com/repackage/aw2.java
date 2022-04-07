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
import com.repackage.ro1;
import com.repackage.s53;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class aw2 extends wv2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements cf3<m53<s53.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v12 a;
        public final /* synthetic */ uv2 b;
        public final /* synthetic */ v53 c;

        public a(aw2 aw2Var, v12 v12Var, uv2 uv2Var, v53 v53Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aw2Var, v12Var, uv2Var, v53Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v12Var;
            this.b = uv2Var;
            this.c = v53Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.cf3
        /* renamed from: a */
        public void onCallback(m53<s53.d> m53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m53Var) == null) {
                if (m53Var != null && m53Var.c() && !TextUtils.isEmpty(m53Var.a.a)) {
                    JSONObject jSONObject = this.c.g;
                    if (jSONObject != null) {
                        try {
                            jSONObject.put("code", m53Var.a.a);
                            this.b.d = true;
                        } catch (JSONException e) {
                            if (tg1.a) {
                                bw2.b(Log.getStackTraceString(e));
                            }
                        }
                        this.b.e = jSONObject.toString();
                    }
                    this.a.a(this.b);
                    return;
                }
                bw2.b("login failure, can't get login code");
                this.a.a(this.b);
            }
        }
    }

    public aw2() {
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

    @Override // com.repackage.xv2
    public js1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            return null;
        }
        return (js1) invokeL.objValue;
    }

    @Override // com.repackage.xv2
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "snsapi_userinfo" : (String) invokeV.objValue;
    }

    @Override // com.repackage.xv2
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "SwanPluginUserInfoFunPage" : (String) invokeV.objValue;
    }

    @Override // com.repackage.wv2
    public void p(SwanAppActivity swanAppActivity, String str, tv2 tv2Var, v53 v53Var, v12<uv2> v12Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, swanAppActivity, str, tv2Var, v53Var, v12Var) == null) {
            uv2 uv2Var = new uv2(tv2Var.f);
            uv2Var.a = tv2Var.e;
            if (v53Var != null && v53Var.j.a() == 0) {
                bw2.b("obtain user info detail, get login code");
                ro1.d dVar = new ro1.d(tv2Var.g);
                Bundle bundle = new Bundle();
                bundle.putString("__plugin__", tv2Var.a);
                i03.J().r().d0().r(swanAppActivity, dVar, bundle, new a(this, v12Var, uv2Var, v53Var), "SwanPluginUserInfoFunPage");
                return;
            }
            bw2.b("open data result failure");
            v12Var.a(uv2Var);
        }
    }
}
