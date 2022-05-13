package com.repackage;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.m11;
/* loaded from: classes7.dex */
public class vv0 extends mv0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdImageView e;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vv0 a;

        public a(vv0 vv0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vv0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vv0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.v().l();
            }
        }
    }

    public vv0() {
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

    @Override // com.repackage.ev0
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.C();
            AdImageView adImageView = (AdImageView) LayoutInflater.from(this.c).inflate(R.layout.obfuscated_res_0x7f0d058c, y()).findViewById(R.id.obfuscated_res_0x7f090e83);
            this.e = adImageView;
            adImageView.setVisibility(8);
            if (this.e.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) this.e.getLayoutParams()).gravity = 17;
            }
        }
    }

    @Override // com.repackage.ev0
    public void G(rs0 rs0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rs0Var) == null) {
            super.G(rs0Var);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void L(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) != null) {
            return;
        }
        int i2 = -1;
        if (z) {
            if (m11.c.c(this.c) < m11.c.e(this.c)) {
                i2 = (m11.c.c(this.c) * 16) / 9;
            } else {
                i = (m11.c.e(this.c) * 9) / 16;
                if (this.e.getLayoutParams() == null) {
                    this.e.getLayoutParams().width = i2;
                    this.e.getLayoutParams().height = i;
                    return;
                }
                return;
            }
        }
        i = -1;
        if (this.e.getLayoutParams() == null) {
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ay0.a("hidePoster()");
            this.e.setVisibility(8);
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ay0.a("loadPoster()");
            BdVideoSeries o1 = v().o1();
            String poster = o1 != null ? o1.getPoster() : "";
            if (TextUtils.isEmpty(poster)) {
                this.e.setVisibility(8);
                return;
            }
            this.e.o(poster);
            L(v().V0());
            this.e.setOnClickListener(new a(this));
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ay0.a("showPoster()");
            this.e.setVisibility(0);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.repackage.ev0, com.repackage.st0
    public void d(@NonNull rs0 rs0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, rs0Var) == null) {
            String c2 = rs0Var.c();
            switch (c2.hashCode()) {
                case -1043170264:
                    if (c2.equals(PlayerEvent.ACTION_PLAYER_ATTACH)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -971135626:
                    if (c2.equals(PlayerEvent.ACTION_PLAYER_DETACH)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -882902390:
                    if (c2.equals(PlayerEvent.ACTION_SET_DATA_SOURCE)) {
                        c = 1;
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
                default:
                    c = 65535;
                    break;
            }
            if (c == 0) {
                int g = rs0Var.g(1);
                if (g == 904 || g == 956) {
                    M();
                }
            } else if (c == 1 || c == 2) {
                N();
            } else if (c != 3) {
            } else {
                this.e.n("");
            }
        }
    }

    @Override // com.repackage.rv0
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? y() : (View) invokeV.objValue;
    }

    @Override // com.repackage.st0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new int[]{4, 2, 5, 3} : (int[]) invokeV.objValue;
    }

    @Override // com.repackage.ev0, com.repackage.st0
    public void h(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, playerStatus, playerStatus2) == null) {
            super.h(playerStatus, playerStatus2);
            if (playerStatus == PlayerStatus.PLAYING) {
                M();
            } else if (playerStatus == PlayerStatus.PREPARING) {
                O();
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.repackage.ev0, com.repackage.st0
    public void k(@NonNull rs0 rs0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, rs0Var) == null) {
            String c2 = rs0Var.c();
            switch (c2.hashCode()) {
                case -552621273:
                    if (c2.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -552580917:
                    if (c2.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 1554330967:
                    if (c2.equals(LayerEvent.ACTION_HIDE_POSTER)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 2062901052:
                    if (c2.equals(LayerEvent.ACTION_SHOW_POSTER)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c == 0) {
                O();
            } else if (c == 1) {
                M();
            } else if (c == 2) {
                L(true);
            } else if (c != 3) {
            } else {
                L(false);
            }
        }
    }

    @Override // com.repackage.mv0, com.repackage.ev0, com.repackage.rv0
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onLayerRelease();
            this.e.n("");
        }
    }
}
