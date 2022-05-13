package com.repackage;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.nadcore.video.videoplayer.widget.PlayDrawable;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class zr0 extends sr0 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView b;
    public PlayDrawable c;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ zr0 b;

        public a(zr0 zr0Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zr0Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zr0Var;
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a) {
                    this.b.b.setVisibility(0);
                } else {
                    this.b.b.setVisibility(8);
                }
            }
        }
    }

    public zr0() {
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

    @Override // com.repackage.tr0
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (View) invokeV.objValue;
    }

    @Override // com.repackage.mr0
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l21.b(42.0f), l21.b(42.0f));
            layoutParams.gravity = 17;
            this.c = new PlayDrawable();
            this.b.setLayoutParams(layoutParams);
            this.b.setBackground(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e2a));
            this.b.setImageDrawable(this.c);
            this.b.setOnClickListener(this);
            this.b.setVisibility(8);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.repackage.mr0
    public void k(@NonNull rs0 rs0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rs0Var) == null) {
            String c2 = rs0Var.c();
            switch (c2.hashCode()) {
                case -150836531:
                    if (c2.equals(LayerEvent.ACTION_DOUBLE_CLICK)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 14382657:
                    if (c2.equals(ControlEvent.ACTION_STATUS_SYNC)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 154871702:
                    if (c2.equals(PlayerEvent.ACTION_ON_COMPLETE)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 720027695:
                    if (c2.equals(ControlEvent.ACTION_PAUSE)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 723345051:
                    if (c2.equals(ControlEvent.ACTION_START)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 906917140:
                    if (c2.equals(ControlEvent.ACTION_RESUME)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 1370689931:
                    if (c2.equals(PlayerEvent.ACTION_ON_INFO)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 1610373035:
                    if (c2.equals(LayerEvent.ACTION_WAKE_UP_END)) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    int g = rs0Var.g(1);
                    if (g != 904 && g != 956) {
                        if (702 == g && r().Y()) {
                            this.c.q(PlayDrawable.IconState.PAUSE_STATE);
                            return;
                        }
                        return;
                    }
                    this.c.q(PlayDrawable.IconState.PAUSE_STATE);
                    this.b.setImageDrawable(this.c);
                    return;
                case 1:
                    this.c.q(rs0Var.d(6) ? PlayDrawable.IconState.PAUSE_STATE : PlayDrawable.IconState.PLAY_STATE);
                    return;
                case 2:
                    this.c.q(PlayDrawable.IconState.PLAY_STATE);
                    return;
                case 3:
                    this.c.q(PlayDrawable.IconState.PAUSE_STATE);
                    return;
                case 4:
                    if (this.b.getVisibility() == 0) {
                        this.b.setVisibility(4);
                        return;
                    }
                    return;
                case 5:
                    this.c.q(this.a.v().W() ? PlayDrawable.IconState.PLAY_STATE : PlayDrawable.IconState.PAUSE_STATE);
                    return;
                case 6:
                    this.b.setVisibility(4);
                    return;
                case 7:
                    this.b.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.repackage.mr0
    public void n(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, playerStatus, playerStatus2) == null) {
            if (playerStatus != PlayerStatus.PLAYING && playerStatus != PlayerStatus.PREPARED && playerStatus != PlayerStatus.PREPARING) {
                this.c.q(PlayDrawable.IconState.PLAY_STATE);
            } else {
                this.c.q(PlayDrawable.IconState.PAUSE_STATE);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            if (r().Y()) {
                r().f0(1);
                w();
            } else if (r().W()) {
                r().l0();
                x();
            } else {
                r().K0();
            }
            this.c.r(true);
        }
    }

    @Override // com.repackage.sr0
    public void t(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (r().V0() && r().f1() == 0) {
                this.b.postDelayed(new a(this, z), 200L);
            } else if (z && !z2) {
                this.b.setVisibility(0);
            } else {
                this.b.setVisibility(8);
            }
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }
}
