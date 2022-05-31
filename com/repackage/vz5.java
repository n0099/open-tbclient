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
public final class vz5 extends zy5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ly5 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vz5(wy5 context) {
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
                super((wy5) newInitContext.callArgs[0]);
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

    @Override // com.repackage.zy5
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public final ly5 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : (ly5) invokeV.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ly5 ly5Var = this.e;
            if (ly5Var != null) {
                ly5 c = i().c();
                if (c.j() != ly5Var.j() || c.g() != ly5Var.g()) {
                    BdLog.w("DanmakuEngine [Config] density from " + c.j() + " to " + ly5Var.j());
                    ly5Var.G();
                    ly5Var.I();
                    ly5Var.F();
                    ly5Var.C();
                }
                if (!(c.v() == ly5Var.v())) {
                    BdLog.w("DanmakuEngine [Config] textSizeScale change from " + c.v() + " to " + ly5Var.v());
                    ly5Var.I();
                    ly5Var.F();
                    ly5Var.G();
                    ly5Var.C();
                }
                if (c.w() != ly5Var.w()) {
                    ly5Var.J();
                }
                if (!(c.u() == ly5Var.u()) || c.e() != ly5Var.e()) {
                    ly5Var.F();
                    ly5Var.J();
                    ly5Var.I();
                }
                if (c.n().size() != ly5Var.n().size() || c.l() != ly5Var.l()) {
                    ly5Var.D();
                }
                i().h(ly5Var);
            }
            this.e = null;
        }
    }

    public final void m(ly5 danmakuConfig) {
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
