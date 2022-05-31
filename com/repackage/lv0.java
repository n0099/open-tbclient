package com.repackage;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class lv0 implements nv0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public lu0 a;
    public Context b;
    public qv0 c;

    public lv0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        l(null);
    }

    @Override // com.repackage.fs0
    public void a(@NonNull er0 er0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, er0Var) == null) {
        }
    }

    public void b(@NonNull qv0 qv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qv0Var) == null) {
            this.c = qv0Var;
        }
    }

    public void c(@NonNull lu0 lu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lu0Var) == null) {
            this.a = lu0Var;
            o();
        }
    }

    @Override // com.repackage.fs0
    public void d(@NonNull er0 er0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, er0Var) == null) {
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.c = null;
        }
    }

    public void f() {
        lu0 lu0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (lu0Var = this.a) == null) {
            return;
        }
        lu0Var.e(this);
        this.a = null;
    }

    @Override // com.repackage.nv0
    public void g(@NonNull er0 er0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, er0Var) == null) {
        }
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.b : (Context) invokeV.objValue;
    }

    @Override // com.repackage.fs0
    public int getExpectOrder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.fs0
    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.fs0
    public void h(@NonNull PlayerStatus playerStatus, @NonNull PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, playerStatus, playerStatus2) == null) {
        }
    }

    @Nullable
    public ko0 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            qv0 qv0Var = this.c;
            if (qv0Var != null) {
                return qv0Var.b();
            }
            return null;
        }
        return (ko0) invokeV.objValue;
    }

    @Override // com.repackage.fs0
    public void j(@NonNull er0 er0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, er0Var) == null) {
        }
    }

    @Override // com.repackage.fs0
    public void k(@NonNull er0 er0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, er0Var) == null) {
        }
    }

    public void l(@Nullable Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, context) == null) {
            if (context == null) {
                this.b = jo0.b();
            } else {
                this.b = context;
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }

    @Override // com.repackage.fs0
    public void n(@NonNull er0 er0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, er0Var) == null) {
        }
    }

    public final void o() {
        int[] subscribeEvent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (subscribeEvent = getSubscribeEvent()) == null || subscribeEvent.length <= 0) {
            return;
        }
        for (int i : subscribeEvent) {
            this.a.c(i, this);
        }
    }

    @Override // com.repackage.fs0
    public void r(@NonNull er0 er0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, er0Var) == null) {
        }
    }

    public lv0(@Nullable Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        l(context);
    }
}
