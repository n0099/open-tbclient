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
import com.repackage.ao1;
import com.repackage.b53;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class jv2 extends fv2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements le3<v43<b53.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e12 a;
        public final /* synthetic */ dv2 b;
        public final /* synthetic */ e53 c;

        public a(jv2 jv2Var, e12 e12Var, dv2 dv2Var, e53 e53Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jv2Var, e12Var, dv2Var, e53Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e12Var;
            this.b = dv2Var;
            this.c = e53Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.le3
        /* renamed from: b */
        public void a(v43<b53.d> v43Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v43Var) == null) {
                if (v43Var != null && v43Var.c() && !TextUtils.isEmpty(v43Var.a.a)) {
                    JSONObject jSONObject = this.c.g;
                    if (jSONObject != null) {
                        try {
                            jSONObject.put("code", v43Var.a.a);
                            this.b.d = true;
                        } catch (JSONException e) {
                            if (cg1.a) {
                                kv2.b(Log.getStackTraceString(e));
                            }
                        }
                        this.b.e = jSONObject.toString();
                    }
                    this.a.a(this.b);
                    return;
                }
                kv2.b("login failure, can't get login code");
                this.a.a(this.b);
            }
        }
    }

    public jv2() {
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

    @Override // com.repackage.gv2
    public sr1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            return null;
        }
        return (sr1) invokeL.objValue;
    }

    @Override // com.repackage.gv2
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "snsapi_userinfo" : (String) invokeV.objValue;
    }

    @Override // com.repackage.gv2
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "SwanPluginUserInfoFunPage" : (String) invokeV.objValue;
    }

    @Override // com.repackage.fv2
    public void p(SwanAppActivity swanAppActivity, String str, cv2 cv2Var, e53 e53Var, e12<dv2> e12Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, swanAppActivity, str, cv2Var, e53Var, e12Var) == null) {
            dv2 dv2Var = new dv2(cv2Var.f);
            dv2Var.a = cv2Var.e;
            if (e53Var != null && e53Var.j.a() == 0) {
                kv2.b("obtain user info detail, get login code");
                ao1.d dVar = new ao1.d(cv2Var.g);
                Bundle bundle = new Bundle();
                bundle.putString("__plugin__", cv2Var.a);
                rz2.K().r().e0().r(swanAppActivity, dVar, bundle, new a(this, e12Var, dv2Var, e53Var), "SwanPluginUserInfoFunPage");
                return;
            }
            kv2.b("open data result failure");
            e12Var.a(dv2Var);
        }
    }
}
