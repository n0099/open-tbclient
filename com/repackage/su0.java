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
/* loaded from: classes7.dex */
public class su0 extends pu0 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout e;
    public LinearLayout f;
    public TextView g;
    public Button h;
    public LinearLayout i;
    public TextView j;
    public boolean k;

    public su0() {
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
                LinearLayout linearLayout = (LinearLayout) View.inflate(this.c, R.layout.obfuscated_res_0x7f0d05c2, null);
                this.i = linearLayout;
                TextView textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0919b0);
                this.j = textView;
                textView.setOnClickListener(this);
                this.e.addView(this.i, new FrameLayout.LayoutParams(-1, -1));
            }
            this.j.setText(R.string.obfuscated_res_0x7f0f0b69);
            P(u().V0());
            this.i.setVisibility(0);
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.k) {
            if (this.f == null) {
                LinearLayout linearLayout = (LinearLayout) View.inflate(this.c, R.layout.obfuscated_res_0x7f0d05c3, null);
                this.f = linearLayout;
                this.g = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f092332);
                Button button = (Button) this.f.findViewById(R.id.obfuscated_res_0x7f09040c);
                this.h = button;
                button.setOnClickListener(this);
                this.e.addView(this.f, new FrameLayout.LayoutParams(-1, -1));
            }
            Q(u().V0());
            F(kr0.w(LayerEvent.ACTION_NET_ERROR_SHOW));
            this.f.setVisibility(0);
            u().y().y(true);
        }
    }

    public final void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            Drawable[] compoundDrawables = this.j.getCompoundDrawables();
            if (z) {
                this.j.setTextSize(0, this.c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0704f3));
                compoundDrawables[1].setBounds(0, 0, this.c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070501), this.c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070501));
            } else {
                this.j.setTextSize(0, this.c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0704f1));
                compoundDrawables[1].setBounds(0, 0, this.c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070500), this.c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070500));
            }
            this.j.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
        }
    }

    public final void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.h.getLayoutParams();
            if (z) {
                this.g.setTextSize(0, this.c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0704f3));
                this.h.setTextSize(0, this.c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0704f3));
                layoutParams.width = this.c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0704ee);
                layoutParams.height = this.c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0704fe);
                layoutParams.topMargin = this.c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0704fd);
            } else {
                this.g.setTextSize(0, this.c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0704f1));
                this.h.setTextSize(0, this.c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0704f1));
                layoutParams.width = this.c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070504);
                layoutParams.height = this.c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0704f8);
                layoutParams.topMargin = this.c.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0704fa);
            }
            this.h.setLayoutParams(layoutParams);
        }
    }

    @Override // com.repackage.hu0, com.repackage.vs0
    public void d(@NonNull ur0 ur0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, ur0Var) == null) && PlayerEvent.ACTION_ON_ERROR.equals(ur0Var.c()) && !u().U0()) {
            this.e.setVisibility(0);
            u().y().j(this);
            if (!BdNetUtils.f()) {
                O();
                L();
                return;
            }
            N();
            M();
        }
    }

    @Override // com.repackage.uu0
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.e : (View) invokeV.objValue;
    }

    @Override // com.repackage.vs0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new int[]{4, 5, 2, 3, 8} : (int[]) invokeV.objValue;
    }

    @Override // com.repackage.hu0, com.repackage.vs0
    public void h(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, playerStatus, playerStatus2) == null) {
            super.h(playerStatus, playerStatus2);
            if (playerStatus == PlayerStatus.PLAYING || playerStatus == PlayerStatus.PREPARING) {
                u().y().i(this);
                M();
                L();
            }
        }
    }

    @Override // com.repackage.hu0, com.repackage.vs0
    public void k(@NonNull ur0 ur0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ur0Var) == null) {
            String c2 = ur0Var.c();
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
            if (view2.getId() == R.id.obfuscated_res_0x7f09040c || view2.getId() == R.id.obfuscated_res_0x7f0919b0) {
                if (!BdNetUtils.f()) {
                    ViewGroup n = u().n();
                    if (n != null && u().n1().a()) {
                        xz0.a().a(n.getContext(), R.string.obfuscated_res_0x7f0f0b6a);
                        return;
                    }
                    return;
                }
                L();
                M();
                this.e.setVisibility(4);
                u().m0();
                F(kr0.w(LayerEvent.ACTION_CLICK_RETRY));
            }
        }
    }

    @Override // com.repackage.hu0, com.repackage.vs0
    public void q(@NonNull ur0 ur0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, ur0Var) == null) {
            if (ControlEvent.ACTION_RESUME.equals(ur0Var.c()) || ControlEvent.ACTION_SHOW_TIP.equals(ur0Var.c()) || ControlEvent.ACTION_START.equals(ur0Var.c())) {
                u().y().i(this);
                L();
                M();
            }
        }
    }
}
