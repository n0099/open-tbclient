package com.repackage;

import android.view.View;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.SystemEvent;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.badge.BadgeDrawable;
/* loaded from: classes7.dex */
public class ur0 extends sr0 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView b;
    public boolean c;
    public int d;
    public int e;
    public boolean f;
    public boolean g;
    public boolean h;

    public ur0() {
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
        this.d = -1;
        this.e = -1;
        this.f = false;
        this.g = false;
        this.h = false;
    }

    public boolean A(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) ? z : invokeZ.booleanValue;
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!r().n1().c()) {
                this.b.setVisibility(4);
                return;
            }
            if (!D() && dy0.c(getContext()) != 0) {
                if (this.c && !C()) {
                    this.b.setVisibility(0);
                } else if (this.f) {
                    this.b.setVisibility(0);
                } else {
                    this.b.setVisibility(4);
                }
            } else if (G()) {
                this.b.setVisibility(0);
            } else {
                this.b.setVisibility(4);
            }
            ImageView imageView = this.b;
            if (imageView == null || imageView.getVisibility() == 0) {
                return;
            }
            y();
        }
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.h && !D() : invokeV.booleanValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? xp0.T() : invokeV.booleanValue;
    }

    public final void E(rs0 rs0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, rs0Var) == null) {
            M(rs0Var.d(16));
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.c = r().f1() == 0;
            B();
        }
    }

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            yp0 r = r();
            iv0 a = fy0.a(r().v().getLayerList());
            return (r.Q() || r.R() || r.a0() || (a != null && a.getContentView().getVisibility() == 0)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            boolean D = D();
            if (D && dy0.c(getContext()) == 0) {
                dy0.d(getContext(), (int) (dy0.b(getContext()) * 0.35d));
            }
            K(D);
            boolean z = !D;
            L(z);
            r().s0(z);
            mx0.c().d(hs0.w(LayerEvent.ACTION_MUTE_SYNC_TO_ALL_PLAYER));
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            boolean z = r().X() || dy0.c(getContext()) <= 0;
            A(z);
            r().w0(z);
            L(z);
        }
    }

    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
        }
    }

    public void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            if (this.g) {
                if (!z) {
                    if (!this.f) {
                        this.b.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.obfuscated_res_0x7f080e1e));
                    } else {
                        this.b.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.obfuscated_res_0x7f080e1b));
                    }
                } else if (!this.f) {
                    this.b.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.obfuscated_res_0x7f080e18));
                } else {
                    this.b.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.obfuscated_res_0x7f080e15));
                }
                y();
            } else if (!z && dy0.c(getContext()) != 0) {
                if (!this.f) {
                    this.b.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.obfuscated_res_0x7f080e17));
                } else {
                    this.b.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.obfuscated_res_0x7f080e16));
                }
                y();
            } else {
                if (!this.f) {
                    this.b.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.obfuscated_res_0x7f080e1d));
                } else {
                    this.b.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.obfuscated_res_0x7f080e1c));
                }
                H();
            }
        }
    }

    public void M(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            N(z, true);
        }
    }

    public void N(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
            boolean z3 = true;
            if (!((r().V0() && r().f1() == 1) ? false : false) && !z) {
                layoutParams.bottomMargin = 0;
                layoutParams.leftMargin = (int) getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f070538);
            } else if (z2) {
                int i = this.e;
                if (i == -1) {
                    i = (int) getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f070535);
                }
                layoutParams.bottomMargin = i;
                layoutParams.leftMargin = this.d;
            } else {
                layoutParams.bottomMargin = 0;
                layoutParams.leftMargin = (int) getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f070538);
            }
            this.b.setLayoutParams(layoutParams);
        }
    }

    @Override // com.repackage.tr0
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.b : (View) invokeV.objValue;
    }

    @Override // com.repackage.mr0
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            ImageView imageView = new ImageView(getContext());
            this.b = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            this.b.setOnClickListener(this);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f070539), (int) getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f070536));
            layoutParams.gravity = BadgeDrawable.BOTTOM_START;
            if (this.d == -1) {
                this.d = (int) getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f070538);
            }
            layoutParams.leftMargin = this.d;
            this.b.setLayoutParams(layoutParams);
            this.b.setVisibility(8);
            if (this.a.y() != null) {
                J();
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.repackage.mr0
    public void k(@NonNull rs0 rs0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, rs0Var) == null) {
            String c2 = rs0Var.c();
            switch (c2.hashCode()) {
                case -1759675333:
                    if (c2.equals(PlayerEvent.ACTION_GO_BACK_OR_FOREGROUND)) {
                        c = '\r';
                        break;
                    }
                    c = 65535;
                    break;
                case -1009727513:
                    if (c2.equals(LayerEvent.ACTION_SHOW_VOLUME_BAR)) {
                        c = 17;
                        break;
                    }
                    c = 65535;
                    break;
                case -849541738:
                    if (c2.equals(LayerEvent.ACTION_BARRAGE_CLICK)) {
                        c = 14;
                        break;
                    }
                    c = 65535;
                    break;
                case -552621273:
                    if (c2.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case -552580917:
                    if (c2.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case -461848373:
                    if (c2.equals(PlayerEvent.ACTION_ON_ERROR)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -333704320:
                    if (c2.equals(ControlEvent.ACTION_SHOW_TIP)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -316059751:
                    if (c2.equals(LayerEvent.ACTION_ADJUST_LIGHT)) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case -150198673:
                    if (c2.equals(LayerEvent.ACTION_CLICK_NET_TIP)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case -14542718:
                    if (c2.equals(LayerEvent.ACTION_HIDE_VOLUME_BAR)) {
                        c = 18;
                        break;
                    }
                    c = 65535;
                    break;
                case 14382657:
                    if (c2.equals(ControlEvent.ACTION_STATUS_SYNC)) {
                        c = 16;
                        break;
                    }
                    c = 65535;
                    break;
                case 154871702:
                    if (c2.equals(PlayerEvent.ACTION_ON_COMPLETE)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 250537257:
                    if (c2.equals(LayerEvent.ACTION_NET_ERROR_SHOW)) {
                        c = 1;
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
                case 1231554669:
                    if (c2.equals(LayerEvent.ACTION_LOCK_SCREEN)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 1586388829:
                    if (c2.equals(LayerEvent.ACTION_BARRAGE_EDIT_VIEW_VISIBLE_STATUS)) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                case 1673877948:
                    if (c2.equals(LayerEvent.ACTION_MUTE_SYNC_TO_ALL_PLAYER)) {
                        c = 15;
                        break;
                    }
                    c = 65535;
                    break;
                case 1822725860:
                    if (c2.equals(SystemEvent.ACTION_VOLUME_CHANGED)) {
                        c = '\f';
                        break;
                    }
                    c = 65535;
                    break;
                case 2064424334:
                    if (c2.equals(LayerEvent.ACTION_POSITION_SLIDE)) {
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
                case 1:
                case 2:
                case 3:
                    this.b.setVisibility(4);
                    return;
                case 4:
                    if (r().V0() && r().f1() == 1) {
                        ImageView imageView = this.b;
                        if (G() && !C()) {
                            r6 = 0;
                        }
                        imageView.setVisibility(r6);
                        return;
                    }
                    B();
                    return;
                case 5:
                    if (D()) {
                        if (kq0.W0()) {
                            if (this.b.getVisibility() == 0) {
                                this.b.setVisibility(4);
                                return;
                            }
                            return;
                        } else if (this.b.getVisibility() != 0) {
                            this.b.setVisibility(0);
                            return;
                        } else {
                            return;
                        }
                    }
                    this.b.setVisibility(4);
                    return;
                case 6:
                    this.b.setVisibility(C() ? 4 : 0);
                    return;
                case 7:
                case '\b':
                    if (D()) {
                        this.b.setVisibility(0);
                        return;
                    } else {
                        this.b.setVisibility(4);
                        return;
                    }
                case '\t':
                    this.g = true;
                    L(D());
                    F();
                    return;
                case '\n':
                    this.g = false;
                    L(D());
                    this.c = false;
                    M(false);
                    B();
                    return;
                case 11:
                    E(rs0Var);
                    return;
                case '\f':
                    if (r().a0() || r().Q()) {
                        return;
                    }
                    int g = rs0Var.g(5);
                    L(g <= 0);
                    B();
                    boolean D = D();
                    if ((!D || g <= 0) && (D || g != 0)) {
                        return;
                    }
                    I();
                    B();
                    return;
                case '\r':
                    if (rs0Var.d(4)) {
                        J();
                        B();
                        return;
                    }
                    return;
                case 14:
                    M(rs0Var.d(11));
                    return;
                case 15:
                case 16:
                    J();
                    return;
                case 17:
                    this.f = true;
                    L(D());
                    if (this.b.getVisibility() != 0) {
                        this.b.setVisibility(0);
                        return;
                    }
                    return;
                case 18:
                    this.f = false;
                    L(D());
                    if (this.b.getVisibility() == 0) {
                        if ((!this.c || C()) && !D()) {
                            this.b.setVisibility(8);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.repackage.mr0
    public void n(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, playerStatus, playerStatus2) == null) {
            super.n(playerStatus, playerStatus2);
            if ((PlayerStatus.PREPARING == playerStatus || PlayerStatus.PLAYING == playerStatus) && this.c && this.b.getVisibility() != 0 && !C()) {
                this.b.setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, view2) == null) && view2.equals(this.b) && !this.f) {
            I();
            B();
        }
    }

    @Override // com.repackage.sr0
    public void t(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            boolean z3 = false;
            if (((kq0.W0() && r().V0()) ? false : true) && z) {
                z3 = true;
            }
            this.c = z3;
            if (r().V0()) {
                w(this.c);
            } else {
                x(this.c);
            }
        }
    }

    public int w(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048596, this, z)) == null) {
            int i = 0;
            if (!r().V0() || r().f1() != 1) {
                if (z) {
                    z();
                    return 4;
                }
                if (D() && G()) {
                    this.b.setVisibility(0);
                } else if (this.f) {
                    this.b.setVisibility(0);
                } else {
                    this.b.setVisibility(4);
                }
                return 0;
            } else if (z) {
                this.b.setVisibility((!G() || C()) ? 8 : 8);
                return 4;
            } else {
                if ((D() || dy0.c(getContext()) == 0) && G()) {
                    this.b.setVisibility(0);
                } else if (this.f) {
                    this.b.setVisibility(0);
                } else {
                    this.b.setVisibility(4);
                }
                return 0;
            }
        }
        return invokeZ.intValue;
    }

    public int x(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048597, this, z)) == null) {
            if (z) {
                this.b.setVisibility(0);
                return 4;
            }
            B();
            return 0;
        }
        return invokeZ.intValue;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            Animation a = yx0.a();
            if (this.b.getVisibility() != 0) {
                this.b.setVisibility(0);
                this.b.startAnimation(a);
            }
        }
    }
}
