package com.repackage;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class h16 extends l06 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xz5 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h16(i06 context) {
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
                super((i06) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.repackage.n0
    public void c(k0 engine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, engine) == null) {
            Intrinsics.checkNotNullParameter(engine, "engine");
        }
    }

    @Override // com.repackage.l06
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public final xz5 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : (xz5) invokeV.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            xz5 xz5Var = this.e;
            if (xz5Var != null) {
                xz5 c = i().c();
                if (c.j() != xz5Var.j() || c.g() != xz5Var.g()) {
                    BdLog.w("DanmakuEngine [Config] density from " + c.j() + " to " + xz5Var.j());
                    xz5Var.G();
                    xz5Var.I();
                    xz5Var.F();
                    xz5Var.C();
                }
                if (!(c.v() == xz5Var.v())) {
                    BdLog.w("DanmakuEngine [Config] textSizeScale change from " + c.v() + " to " + xz5Var.v());
                    xz5Var.I();
                    xz5Var.F();
                    xz5Var.G();
                    xz5Var.C();
                }
                if (c.w() != xz5Var.w()) {
                    xz5Var.J();
                }
                if (!(c.u() == xz5Var.u()) || c.e() != xz5Var.e()) {
                    xz5Var.F();
                    xz5Var.J();
                    xz5Var.I();
                }
                if (c.n().size() != xz5Var.n().size() || c.l() != xz5Var.l()) {
                    xz5Var.D();
                }
                i().h(xz5Var);
            }
            this.e = null;
        }
    }

    public final void m(xz5 danmakuConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, danmakuConfig) == null) {
            Intrinsics.checkNotNullParameter(danmakuConfig, "danmakuConfig");
            this.e = danmakuConfig;
        }
    }

    @Override // com.repackage.n0
    public void update(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f) == null) {
            l();
        }
    }
}
