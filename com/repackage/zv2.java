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
import com.repackage.qo1;
import com.repackage.r53;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class zv2 extends vv2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements bf3<l53<r53.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u12 a;
        public final /* synthetic */ tv2 b;
        public final /* synthetic */ u53 c;

        public a(zv2 zv2Var, u12 u12Var, tv2 tv2Var, u53 u53Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv2Var, u12Var, tv2Var, u53Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u12Var;
            this.b = tv2Var;
            this.c = u53Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.bf3
        /* renamed from: b */
        public void a(l53<r53.d> l53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l53Var) == null) {
                if (l53Var != null && l53Var.c() && !TextUtils.isEmpty(l53Var.a.a)) {
                    JSONObject jSONObject = this.c.g;
                    if (jSONObject != null) {
                        try {
                            jSONObject.put("code", l53Var.a.a);
                            this.b.d = true;
                        } catch (JSONException e) {
                            if (sg1.a) {
                                aw2.b(Log.getStackTraceString(e));
                            }
                        }
                        this.b.e = jSONObject.toString();
                    }
                    this.a.a(this.b);
                    return;
                }
                aw2.b("login failure, can't get login code");
                this.a.a(this.b);
            }
        }
    }

    public zv2() {
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

    @Override // com.repackage.wv2
    public is1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            return null;
        }
        return (is1) invokeL.objValue;
    }

    @Override // com.repackage.wv2
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "snsapi_userinfo" : (String) invokeV.objValue;
    }

    @Override // com.repackage.wv2
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "SwanPluginUserInfoFunPage" : (String) invokeV.objValue;
    }

    @Override // com.repackage.vv2
    public void p(SwanAppActivity swanAppActivity, String str, sv2 sv2Var, u53 u53Var, u12<tv2> u12Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, swanAppActivity, str, sv2Var, u53Var, u12Var) == null) {
            tv2 tv2Var = new tv2(sv2Var.f);
            tv2Var.a = sv2Var.e;
            if (u53Var != null && u53Var.j.a() == 0) {
                aw2.b("obtain user info detail, get login code");
                qo1.d dVar = new qo1.d(sv2Var.g);
                Bundle bundle = new Bundle();
                bundle.putString("__plugin__", sv2Var.a);
                h03.K().q().e0().r(swanAppActivity, dVar, bundle, new a(this, u12Var, tv2Var, u53Var), "SwanPluginUserInfoFunPage");
                return;
            }
            aw2.b("open data result failure");
            u12Var.a(tv2Var);
        }
    }
}
