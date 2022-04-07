package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.InteractiveEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class wq0 extends ir0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zq0 d;
    public fr0 e;
    public er0 f;
    public ar0 g;
    public yq0 h;

    public wq0() {
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
        er0 er0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (er0Var = this.f) == null) {
            return;
        }
        er0Var.b();
    }

    public void C() {
        er0 er0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (er0Var = this.f) == null) {
            return;
        }
        er0Var.a();
    }

    public void D(boolean z, boolean z2) {
        yq0 yq0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (yq0Var = this.h) == null) {
            return;
        }
        yq0Var.a(z, z2);
    }

    public void E(boolean z) {
        fr0 fr0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (fr0Var = this.e) == null) {
            return;
        }
        fr0Var.a(z);
    }

    public void F(int i, int i2) {
        ar0 ar0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) || (ar0Var = this.g) == null) {
            return;
        }
        ar0Var.a(i, i2);
    }

    public void G(int i) {
        zq0 zq0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || (zq0Var = this.d) == null) {
            return;
        }
        zq0Var.a(i);
    }

    @Override // com.repackage.jr0
    public void b(rs0 rs0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, rs0Var) == null) {
            super.b(rs0Var);
            if (InteractiveEvent.ACTION_INTERACTIVE_START.equals(rs0Var.c())) {
                B();
            } else if (InteractiveEvent.ACTION_INTERACTIVE_FINISH.equals(rs0Var.c())) {
                C();
            }
        }
    }

    @Override // com.repackage.ir0, com.repackage.jr0
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
