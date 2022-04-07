package com.repackage;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.nadcore.player.minivideo.view.LineLoadingView;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.SystemEvent;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class cw0 extends mv0 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup e;
    public ImageView f;
    public boolean g;
    public LineLoadingView h;

    public cw0() {
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
        this.g = false;
    }

    @Override // com.repackage.ev0
    @SuppressLint({"InflateParams"})
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.c).inflate(R.layout.obfuscated_res_0x7f0d05bf, (ViewGroup) null);
            this.e = viewGroup;
            this.f = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f092334);
            this.h = (LineLoadingView) this.e.findViewById(R.id.obfuscated_res_0x7f091257);
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.h.g();
        }
    }

    public void M(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.g = z;
        }
    }

    public void N(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && this.g) {
            this.f.setVisibility(i);
            this.g = false;
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.h.f();
        }
    }

    @Override // com.repackage.ev0, com.repackage.st0
    public void d(@NonNull rs0 rs0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, rs0Var) == null) {
            if (PlayerEvent.ACTION_ON_INFO.equals(rs0Var.c())) {
                int intValue = ((Integer) rs0Var.f(1)).intValue();
                if (intValue == 904 || 956 == intValue) {
                    this.g = false;
                    this.f.setVisibility(4);
                    L();
                } else if (701 == intValue) {
                    O();
                } else if (702 == intValue) {
                    L();
                }
            } else if (PlayerEvent.ACTION_ON_PREPARED.equals(rs0Var.c())) {
                L();
            } else if (PlayerEvent.ACTION_ON_ERROR.equals(rs0Var.c())) {
                L();
            }
        }
    }

    @Override // com.repackage.rv0
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.e : (View) invokeV.objValue;
    }

    @Override // com.repackage.st0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new int[]{4, 2, 1, 5} : (int[]) invokeV.objValue;
    }

    @Override // com.repackage.ev0, com.repackage.st0
    public void h(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, playerStatus, playerStatus2) == null) {
            super.h(playerStatus, playerStatus2);
            if (playerStatus == PlayerStatus.PLAYING || playerStatus == PlayerStatus.PAUSE || playerStatus == PlayerStatus.STOP) {
                L();
            }
        }
    }

    @Override // com.repackage.ev0, com.repackage.st0
    public void n(@NonNull rs0 rs0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, rs0Var) == null) || !SystemEvent.ACTION_VOLUME_CHANGED.equals(rs0Var.c()) || v().a0() || v().Q() || ((Integer) rs0Var.f(5)).intValue() <= 0 || !v().V()) {
            return;
        }
        v().w0(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view2) == null) {
        }
    }

    @Override // com.repackage.ev0, com.repackage.st0
    public void r(@NonNull rs0 rs0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, rs0Var) == null) {
            if (ControlEvent.ACTION_PAUSE.equals(rs0Var.c())) {
                if (this.g) {
                    this.f.setVisibility(0);
                }
            } else if (ControlEvent.ACTION_RESUME.equals(rs0Var.c())) {
                this.g = false;
                this.f.setVisibility(4);
            } else if (ControlEvent.ACTION_START.equals(rs0Var.c())) {
                if (v().Y()) {
                    return;
                }
                O();
            } else if (ControlEvent.ACTION_STOP.equals(rs0Var.c())) {
                L();
            }
        }
    }
}
