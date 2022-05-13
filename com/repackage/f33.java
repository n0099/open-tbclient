package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.y03;
/* loaded from: classes6.dex */
public class f33 extends e33 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f33(x03 x03Var) {
        super(x03Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {x03Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((x03) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.e33
    public void H(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && L() && (str2 = this.d) != null && str2.equals(str)) {
            t03 J = t03.J();
            if (J.D()) {
                if (J.r().m0()) {
                    J.o("flag_finish_activity", "flag_remove_task");
                    return;
                }
                nc3 nc3Var = new nc3();
                nc3Var.k(10L);
                nc3Var.i(2107L);
                nc3Var.d("app forbidden");
                a13.x0(p84.i().u(str), bk2.c(), J.r().V(), false, null, nc3Var);
            }
        }
    }

    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (u03.a0() == null || this.b == 0) ? false : true : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.nf3
    /* renamed from: M */
    public void onCallback(y03.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            if (gx2.I(aVar.D(), "swan_forbidden_kill_on_client")) {
                this.b = aVar.j("ipc_forbidden_flag", 1);
                this.d = aVar.o("mAppId", t03.J().getAppId());
            }
            if (gx2.I(aVar.D(), "swan_kill_to_client")) {
                t03.J().o("flag_finish_activity", "flag_remove_task");
            }
        }
    }
}
