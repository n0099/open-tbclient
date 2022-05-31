package com.repackage;

import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class vp0 extends wp0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pp0 c;

    public vp0() {
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

    public void A() {
        pp0 pp0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (pp0Var = this.c) == null) {
            return;
        }
        pp0Var.onVideoSwitchToHalf();
    }

    @Override // com.repackage.wp0
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.r();
            this.c = null;
        }
    }

    public void t() {
        pp0 pp0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (pp0Var = this.c) == null) {
            return;
        }
        pp0Var.onBeforeSwitchToFull();
    }

    public void u() {
        pp0 pp0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (pp0Var = this.c) == null) {
            return;
        }
        pp0Var.onBeforeSwitchToHalf();
    }

    public void v() {
        pp0 pp0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (pp0Var = this.c) == null) {
            return;
        }
        pp0Var.onGestureActionEnd();
    }

    public void w() {
        pp0 pp0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (pp0Var = this.c) == null) {
            return;
        }
        pp0Var.onGestureActionStart();
    }

    public boolean x(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            pp0 pp0Var = this.c;
            if (pp0Var != null) {
                return pp0Var.onGestureDoubleClick(motionEvent);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void y(boolean z) {
        pp0 pp0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || (pp0Var = this.c) == null) {
            return;
        }
        pp0Var.onPanelVisibilityChanged(z);
    }

    public void z() {
        pp0 pp0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (pp0Var = this.c) == null) {
            return;
        }
        pp0Var.onVideoSwitchToFull();
    }
}
