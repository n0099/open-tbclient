package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class wv2 extends uv2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements xg1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sv2 a;
        public final /* synthetic */ t12 b;

        public a(wv2 wv2Var, sv2 sv2Var, t12 t12Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wv2Var, sv2Var, t12Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sv2Var;
            this.b = t12Var;
        }

        @Override // com.repackage.xg1
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                zv2.b("obtain address failure, errCode = " + i);
                this.b.a(this.a);
            }
        }

        @Override // com.repackage.xg1
        public void b(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                zv2.b("obtain address success");
                sv2 sv2Var = this.a;
                sv2Var.d = true;
                if (jSONObject != null) {
                    sv2Var.e = jSONObject.toString();
                }
                this.b.a(this.a);
            }
        }
    }

    public wv2() {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "mapp_choose_address" : (String) invokeV.objValue;
    }

    @Override // com.repackage.vv2
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "SwanPluginAddressFunPage" : (String) invokeV.objValue;
    }

    @Override // com.repackage.uv2
    public void p(SwanAppActivity swanAppActivity, String str, rv2 rv2Var, t53 t53Var, t12<sv2> t12Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, swanAppActivity, str, rv2Var, t53Var, t12Var) == null) {
            sv2 sv2Var = new sv2(rv2Var.f);
            sv2Var.a = rv2Var.e;
            if (t53Var != null && t53Var.j.a() != 10003) {
                zv2.b("obtain address detail");
                oj2.j0().a(swanAppActivity, str, str, new a(this, sv2Var, t12Var));
                return;
            }
            zv2.b("user denied");
            t12Var.a(sv2Var);
        }
    }
}
