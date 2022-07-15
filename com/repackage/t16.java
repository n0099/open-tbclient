package com.repackage;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class t16 extends x06 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public j06 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t16(u06 context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((u06) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.repackage.q0
    public void c(n0 engine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, engine) == null) {
            Intrinsics.checkNotNullParameter(engine, "engine");
        }
    }

    @Override // com.repackage.x06
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public final j06 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : (j06) invokeV.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            j06 j06Var = this.e;
            if (j06Var != null) {
                j06 c = i().c();
                if (c.j() != j06Var.j() || c.g() != j06Var.g()) {
                    BdLog.w("DanmakuEngine [Config] density from " + c.j() + " to " + j06Var.j());
                    j06Var.G();
                    j06Var.I();
                    j06Var.F();
                    j06Var.C();
                }
                if (!(c.v() == j06Var.v())) {
                    BdLog.w("DanmakuEngine [Config] textSizeScale change from " + c.v() + " to " + j06Var.v());
                    j06Var.I();
                    j06Var.F();
                    j06Var.G();
                    j06Var.C();
                }
                if (c.w() != j06Var.w()) {
                    j06Var.J();
                }
                if (!(c.u() == j06Var.u()) || c.e() != j06Var.e()) {
                    j06Var.F();
                    j06Var.J();
                    j06Var.I();
                }
                if (c.n().size() != j06Var.n().size() || c.l() != j06Var.l()) {
                    j06Var.D();
                }
                i().h(j06Var);
            }
            this.e = null;
        }
    }

    public final void m(j06 danmakuConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, danmakuConfig) == null) {
            Intrinsics.checkNotNullParameter(danmakuConfig, "danmakuConfig");
            this.e = danmakuConfig;
        }
    }

    @Override // com.repackage.q0
    public void update(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f) == null) {
            l();
        }
    }
}
