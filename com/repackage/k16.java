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
public final class k16 extends o06 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a06 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k16(l06 context) {
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
                super((l06) newInitContext.callArgs[0]);
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

    @Override // com.repackage.o06
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public final a06 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : (a06) invokeV.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            a06 a06Var = this.e;
            if (a06Var != null) {
                a06 c = i().c();
                if (c.j() != a06Var.j() || c.g() != a06Var.g()) {
                    BdLog.w("DanmakuEngine [Config] density from " + c.j() + " to " + a06Var.j());
                    a06Var.G();
                    a06Var.I();
                    a06Var.F();
                    a06Var.C();
                }
                if (!(c.v() == a06Var.v())) {
                    BdLog.w("DanmakuEngine [Config] textSizeScale change from " + c.v() + " to " + a06Var.v());
                    a06Var.I();
                    a06Var.F();
                    a06Var.G();
                    a06Var.C();
                }
                if (c.w() != a06Var.w()) {
                    a06Var.J();
                }
                if (!(c.u() == a06Var.u()) || c.e() != a06Var.e()) {
                    a06Var.F();
                    a06Var.J();
                    a06Var.I();
                }
                if (c.n().size() != a06Var.n().size() || c.l() != a06Var.l()) {
                    a06Var.D();
                }
                i().h(a06Var);
            }
            this.e = null;
        }
    }

    public final void m(a06 danmakuConfig) {
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
