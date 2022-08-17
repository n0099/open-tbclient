package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.InteractiveEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class zp0 extends lq0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public cq0 d;
    public iq0 e;
    public hq0 f;
    public dq0 g;
    public bq0 h;

    public zp0() {
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
        hq0 hq0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (hq0Var = this.f) == null) {
            return;
        }
        hq0Var.b();
    }

    public void C() {
        hq0 hq0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (hq0Var = this.f) == null) {
            return;
        }
        hq0Var.a();
    }

    public void D(boolean z, boolean z2) {
        bq0 bq0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (bq0Var = this.h) == null) {
            return;
        }
        bq0Var.a(z, z2);
    }

    public void E(boolean z) {
        iq0 iq0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (iq0Var = this.e) == null) {
            return;
        }
        iq0Var.a(z);
    }

    public void F(int i, int i2) {
        dq0 dq0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) || (dq0Var = this.g) == null) {
            return;
        }
        dq0Var.a(i, i2);
    }

    public void G(int i) {
        cq0 cq0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || (cq0Var = this.d) == null) {
            return;
        }
        cq0Var.a(i);
    }

    @Override // com.repackage.mq0
    public void b(ur0 ur0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ur0Var) == null) {
            super.b(ur0Var);
            if (InteractiveEvent.ACTION_INTERACTIVE_START.equals(ur0Var.c())) {
                B();
            } else if (InteractiveEvent.ACTION_INTERACTIVE_FINISH.equals(ur0Var.c())) {
                C();
            }
        }
    }

    @Override // com.repackage.lq0, com.repackage.mq0
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
