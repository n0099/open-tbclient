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
import com.repackage.pn1;
import com.repackage.q43;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class yu2 extends uu2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements ae3<k43<q43.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t02 a;
        public final /* synthetic */ su2 b;
        public final /* synthetic */ t43 c;

        public a(yu2 yu2Var, t02 t02Var, su2 su2Var, t43 t43Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yu2Var, t02Var, su2Var, t43Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t02Var;
            this.b = su2Var;
            this.c = t43Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(k43<q43.d> k43Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, k43Var) == null) {
                if (k43Var != null && k43Var.c() && !TextUtils.isEmpty(k43Var.a.a)) {
                    JSONObject jSONObject = this.c.g;
                    if (jSONObject != null) {
                        try {
                            jSONObject.put("code", k43Var.a.a);
                            this.b.d = true;
                        } catch (JSONException e) {
                            if (rf1.a) {
                                zu2.b(Log.getStackTraceString(e));
                            }
                        }
                        this.b.e = jSONObject.toString();
                    }
                    this.a.a(this.b);
                    return;
                }
                zu2.b("login failure, can't get login code");
                this.a.a(this.b);
            }
        }
    }

    public yu2() {
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

    @Override // com.repackage.vu2
    public hr1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            return null;
        }
        return (hr1) invokeL.objValue;
    }

    @Override // com.repackage.vu2
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "snsapi_userinfo" : (String) invokeV.objValue;
    }

    @Override // com.repackage.vu2
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "SwanPluginUserInfoFunPage" : (String) invokeV.objValue;
    }

    @Override // com.repackage.uu2
    public void p(SwanAppActivity swanAppActivity, String str, ru2 ru2Var, t43 t43Var, t02<su2> t02Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, swanAppActivity, str, ru2Var, t43Var, t02Var) == null) {
            su2 su2Var = new su2(ru2Var.f);
            su2Var.a = ru2Var.e;
            if (t43Var != null && t43Var.j.a() == 0) {
                zu2.b("obtain user info detail, get login code");
                pn1.d dVar = new pn1.d(ru2Var.g);
                Bundle bundle = new Bundle();
                bundle.putString("__plugin__", ru2Var.a);
                gz2.J().r().d0().r(swanAppActivity, dVar, bundle, new a(this, t02Var, su2Var, t43Var), "SwanPluginUserInfoFunPage");
                return;
            }
            zu2.b("open data result failure");
            t02Var.a(su2Var);
        }
    }
}
