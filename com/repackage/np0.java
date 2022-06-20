package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.InteractiveEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class np0 extends zp0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qp0 d;
    public wp0 e;
    public vp0 f;
    public rp0 g;
    public pp0 h;

    public np0() {
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

    public void B() {
        vp0 vp0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (vp0Var = this.f) == null) {
            return;
        }
        vp0Var.b();
    }

    public void C() {
        vp0 vp0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (vp0Var = this.f) == null) {
            return;
        }
        vp0Var.a();
    }

    public void D(boolean z, boolean z2) {
        pp0 pp0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (pp0Var = this.h) == null) {
            return;
        }
        pp0Var.a(z, z2);
    }

    public void E(boolean z) {
        wp0 wp0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (wp0Var = this.e) == null) {
            return;
        }
        wp0Var.a(z);
    }

    public void F(int i, int i2) {
        rp0 rp0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) || (rp0Var = this.g) == null) {
            return;
        }
        rp0Var.a(i, i2);
    }

    public void G(int i) {
        qp0 qp0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || (qp0Var = this.d) == null) {
            return;
        }
        qp0Var.a(i);
    }

    @Override // com.repackage.aq0
    public void b(ir0 ir0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ir0Var) == null) {
            super.b(ir0Var);
            if (InteractiveEvent.ACTION_INTERACTIVE_START.equals(ir0Var.c())) {
                B();
            } else if (InteractiveEvent.ACTION_INTERACTIVE_FINISH.equals(ir0Var.c())) {
                C();
            }
        }
    }

    @Override // com.repackage.zp0, com.repackage.aq0
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.r();
            this.d = null;
            this.e = null;
            this.g = null;
            this.f = null;
            this.h = null;
        }
    }
}
