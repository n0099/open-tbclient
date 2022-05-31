package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.lz2;
/* loaded from: classes7.dex */
public class s13 extends r13 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s13(kz2 kz2Var) {
        super(kz2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kz2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((kz2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.r13
    public void H(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && L() && (str2 = this.d) != null && str2.equals(str)) {
            gz2 J = gz2.J();
            if (J.D()) {
                if (J.r().m0()) {
                    J.o("flag_finish_activity", "flag_remove_task");
                    return;
                }
                ab3 ab3Var = new ab3();
                ab3Var.k(10L);
                ab3Var.i(2107L);
                ab3Var.d("app forbidden");
                nz2.x0(c74.i().u(str), oi2.c(), J.r().V(), false, null, ab3Var);
            }
        }
    }

    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (hz2.a0() == null || this.b == 0) ? false : true : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ae3
    /* renamed from: M */
    public void onCallback(lz2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            if (tv2.I(aVar.D(), "swan_forbidden_kill_on_client")) {
                this.b = aVar.j("ipc_forbidden_flag", 1);
                this.d = aVar.o("mAppId", gz2.J().getAppId());
            }
            if (tv2.I(aVar.D(), "swan_kill_to_client")) {
                gz2.J().o("flag_finish_activity", "flag_remove_task");
            }
        }
    }
}
