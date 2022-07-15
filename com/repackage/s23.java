package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.l03;
/* loaded from: classes7.dex */
public class s23 extends r23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s23(k03 k03Var) {
        super(k03Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {k03Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((k03) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.r23
    public void I(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && M() && (str2 = this.d) != null && str2.equals(str)) {
            g03 K = g03.K();
            if (K.E()) {
                if (K.q().n0()) {
                    K.n("flag_finish_activity", "flag_remove_task");
                    return;
                }
                ac3 ac3Var = new ac3();
                ac3Var.k(10L);
                ac3Var.i(2107L);
                ac3Var.d("app forbidden");
                n03.y0(c84.i().u(str), oj2.c(), K.q().W(), false, null, ac3Var);
            }
        }
    }

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (h03.b0() == null || this.b == 0) ? false : true : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.af3
    /* renamed from: N */
    public void a(l03.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            if (tw2.J(aVar.D(), "swan_forbidden_kill_on_client")) {
                this.b = aVar.j("ipc_forbidden_flag", 1);
                this.d = aVar.o("mAppId", g03.K().getAppId());
            }
            if (tw2.J(aVar.D(), "swan_kill_to_client")) {
                g03.K().n("flag_finish_activity", "flag_remove_task");
            }
        }
    }
}
