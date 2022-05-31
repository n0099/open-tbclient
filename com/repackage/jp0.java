package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.InteractiveEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class jp0 extends vp0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mp0 d;
    public sp0 e;
    public rp0 f;
    public np0 g;
    public lp0 h;

    public jp0() {
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
        rp0 rp0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (rp0Var = this.f) == null) {
            return;
        }
        rp0Var.b();
    }

    public void C() {
        rp0 rp0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (rp0Var = this.f) == null) {
            return;
        }
        rp0Var.a();
    }

    public void D(boolean z, boolean z2) {
        lp0 lp0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (lp0Var = this.h) == null) {
            return;
        }
        lp0Var.a(z, z2);
    }

    public void E(boolean z) {
        sp0 sp0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (sp0Var = this.e) == null) {
            return;
        }
        sp0Var.a(z);
    }

    public void F(int i, int i2) {
        np0 np0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) || (np0Var = this.g) == null) {
            return;
        }
        np0Var.a(i, i2);
    }

    public void G(int i) {
        mp0 mp0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || (mp0Var = this.d) == null) {
            return;
        }
        mp0Var.a(i);
    }

    @Override // com.repackage.wp0
    public void b(er0 er0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, er0Var) == null) {
            super.b(er0Var);
            if (InteractiveEvent.ACTION_INTERACTIVE_START.equals(er0Var.c())) {
                B();
            } else if (InteractiveEvent.ACTION_INTERACTIVE_FINISH.equals(er0Var.c())) {
                C();
            }
        }
    }

    @Override // com.repackage.vp0, com.repackage.wp0
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
