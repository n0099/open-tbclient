package com.repackage;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.nadcore.player.utils.BdNetUtils;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class cu0 extends zt0 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout e;
    public LinearLayout f;
    public TextView g;
    public Button h;
    public LinearLayout i;
    public TextView j;
    public boolean k;

    public cu0() {
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
        this.k = true;
        FrameLayout frameLayout = new FrameLayout(this.c);
        this.e = frameLayout;
        frameLayout.setVisibility(4);
    }

    public final void L() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (linearLayout = this.i) == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    public final void M() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (linearLayout = this.f) == null) {
            return;
        }
        linearLayout.setVisibility(4);
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.i == null) {
                LinearLayout linearLayout = (LinearLayout) View.inflate(this.c, R.layout.obfuscated_res_0x7f0d0584, null);
                this.i = linearLayout;
                TextView textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091864);
                this.j = textView;
                textView.setOnClickListener(this);
                this.e.addView(this.i, new FrameLayout.LayoutParams(-1, -1));
            }
            this.j.setText(R.string.obfuscated_res_0x7f0f0b64);
            P(v().V0());
            this.i.setVisibility(0);
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.k) {
            if (this.f == null) {
                LinearLayout linearLayout = (LinearLayout) View.inflate(this.c, R.layout.obfuscated_res_0x7f0d0585, null);
                this.f = linearLayout;
                this.g = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f09218b);
                Button button = (Button) this.f.findViewById(R.id.obfuscated_res_0x7f0903f6);
                this.h = button;
                button.setOnClickListener(this);
                this.e.addView(this.f, new FrameLayout.LayoutParams(-1, -1));
            }
            Q(v().V0());
            G(uq0.w(LayerEvent.ACTION_NET_ERROR_SHOW));
            this.f.setVisibility(0);
            v().y().y(true);
        }
    }

    public final void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            Drawable[] compoundDrawables = this.j.getCompoundDrawables();
            if (z) {
                this.j.setTextSize(0, this.c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07048f));
                compoundDrawables[1].setBounds(0, 0, this.c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07049b), this.c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07049b));
            } else {
                this.j.setTextSize(0, this.c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07048d));
                compoundDrawables[1].setBounds(0, 0, this.c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07049a), this.c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07049a));
            }
            this.j.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
        }
    }

    public final void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.h.getLayoutParams();
            if (z) {
                this.g.setTextSize(0, this.c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07048f));
                this.h.setTextSize(0, this.c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07048f));
                layoutParams.width = this.c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07048a);
                layoutParams.height = this.c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070498);
                layoutParams.topMargin = this.c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070497);
            } else {
                this.g.setTextSize(0, this.c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07048d));
                this.h.setTextSize(0, this.c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07048d));
                layoutParams.width = this.c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0704ae);
                layoutParams.height = this.c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070493);
                layoutParams.topMargin = this.c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070494);
            }
            this.h.setLayoutParams(layoutParams);
        }
    }

    @Override // com.repackage.rt0, com.repackage.fs0
    public void d(@NonNull er0 er0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, er0Var) == null) && PlayerEvent.ACTION_ON_ERROR.equals(er0Var.c()) && !v().U0()) {
            this.e.setVisibility(0);
            v().y().j(this);
            if (!BdNetUtils.f()) {
                O();
                L();
                return;
            }
            N();
            M();
        }
    }

    @Override // com.repackage.eu0
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.e : (View) invokeV.objValue;
    }

    @Override // com.repackage.fs0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new int[]{4, 5, 2, 3, 8} : (int[]) invokeV.objValue;
    }

    @Override // com.repackage.rt0, com.repackage.fs0
    public void h(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, playerStatus, playerStatus2) == null) {
            super.h(playerStatus, playerStatus2);
            if (playerStatus == PlayerStatus.PLAYING || playerStatus == PlayerStatus.PREPARING) {
                v().y().i(this);
                M();
                L();
            }
        }
    }

    @Override // com.repackage.rt0, com.repackage.fs0
    public void k(@NonNull er0 er0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, er0Var) == null) {
            String c2 = er0Var.c();
            int hashCode = c2.hashCode();
            if (hashCode == -552621273) {
                if (c2.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                    c = 0;
                }
                c = 65535;
            } else if (hashCode != -552580917) {
                if (hashCode == 1409909918 && c2.equals(LayerEvent.ACTION_SWITCH_FLOATING)) {
                    c = 2;
                }
                c = 65535;
            } else {
                if (c2.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                    c = 1;
                }
                c = 65535;
            }
            if (c == 0) {
                if (this.f != null) {
                    Q(true);
                }
                if (this.i != null) {
                    P(true);
                }
            } else if (c != 1) {
                if (c != 2) {
                    return;
                }
                L();
                M();
            } else {
                if (this.f != null) {
                    Q(false);
                }
                if (this.i != null) {
                    P(false);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f0903f6 || view2.getId() == R.id.obfuscated_res_0x7f091864) {
                if (!BdNetUtils.f()) {
                    ViewGroup n = v().n();
                    if (n != null && v().n1().a()) {
                        hz0.a().b(n.getContext(), R.string.obfuscated_res_0x7f0f0b65);
                        return;
                    }
                    return;
                }
                L();
                M();
                this.e.setVisibility(4);
                v().m0();
                G(uq0.w(LayerEvent.ACTION_CLICK_RETRY));
            }
        }
    }

    @Override // com.repackage.rt0, com.repackage.fs0
    public void r(@NonNull er0 er0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, er0Var) == null) {
            if (ControlEvent.ACTION_RESUME.equals(er0Var.c()) || ControlEvent.ACTION_SHOW_TIP.equals(er0Var.c()) || ControlEvent.ACTION_START.equals(er0Var.c())) {
                v().y().i(this);
                L();
                M();
            }
        }
    }
}
