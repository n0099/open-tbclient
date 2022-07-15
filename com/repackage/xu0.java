package com.repackage;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.nadcore.video.videoplayer.ui.full.BdThumbSeekBar;
import com.baidu.nadcore.video.videoplayer.ui.full.BdVideoNewCacheView;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class xu0 extends qu0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout e;
    public BdThumbSeekBar f;
    public BdVideoNewCacheView g;

    public xu0() {
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

    @Override // com.repackage.iu0
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.e = new FrameLayout(this.c);
            L();
            M();
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.e == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        layoutParams.bottomMargin = q11.b(-4.0f);
        BdThumbSeekBar bdThumbSeekBar = new BdThumbSeekBar(this.c, 2);
        this.f = bdThumbSeekBar;
        bdThumbSeekBar.setThumbScaleVisible(false);
        this.f.setDragable(false);
        this.f.setProgressColor(this.c.getResources().getColor(R.color.obfuscated_res_0x7f060854));
        this.e.addView(this.f, layoutParams);
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            BdVideoNewCacheView bdVideoNewCacheView = new BdVideoNewCacheView(this.c);
            this.g = bdVideoNewCacheView;
            bdVideoNewCacheView.setVisibility(4);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.e.addView(this.g, layoutParams);
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.g.c(4);
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.g.c(0);
        }
    }

    @Override // com.repackage.iu0, com.repackage.ws0
    public void d(@NonNull vr0 vr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, vr0Var) == null) {
            if (PlayerEvent.ACTION_ON_INFO.equals(vr0Var.c())) {
                if (701 == vr0Var.g(1)) {
                    O();
                    return;
                } else {
                    N();
                    return;
                }
            }
            N();
        }
    }

    @Override // com.repackage.vu0
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.e : (View) invokeV.objValue;
    }

    @Override // com.repackage.ws0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new int[]{2, 4, 5} : (int[]) invokeV.objValue;
    }

    @Override // com.repackage.iu0, com.repackage.ws0
    public void h(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, playerStatus, playerStatus2) == null) {
            super.h(playerStatus, playerStatus2);
            if (playerStatus == PlayerStatus.PLAYING || playerStatus == PlayerStatus.PAUSE || playerStatus == PlayerStatus.STOP) {
                N();
            }
        }
    }

    @Override // com.repackage.iu0, com.repackage.ws0
    public void q(@NonNull vr0 vr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, vr0Var) == null) {
            if (ControlEvent.ACTION_SYNC_PROGRESS.equals(vr0Var.c())) {
                this.f.h(vr0Var.g(1), vr0Var.g(2), vr0Var.g(3));
            } else if (ControlEvent.ACTION_START.equals(vr0Var.c())) {
                O();
            } else if (ControlEvent.ACTION_STOP.equals(vr0Var.c())) {
                N();
            }
        }
    }
}
