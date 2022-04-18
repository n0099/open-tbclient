package com.repackage;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.badge.BadgeDrawable;
import com.tachikoma.core.component.anim.AnimationProperty;
/* loaded from: classes5.dex */
public class as0 extends sr0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView b;
    public FrameLayout.LayoutParams c;
    public boolean d;
    public Animator e;
    public Animator f;
    public String g;
    public int h;
    public int i;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ as0 a;

        public a(as0 as0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {as0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = as0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.x();
            }
        }
    }

    public as0() {
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

    public final void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            rs0 w = hs0.w(LayerEvent.ACTION_POPUP_SHOW);
            w.n(28, Boolean.valueOf(z));
            r().q0(w);
        }
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                this.h = R.string.obfuscated_res_0x7f0f0bf5;
                this.i = R.string.obfuscated_res_0x7f0f0bf1;
                return;
            }
            this.h = R.string.obfuscated_res_0x7f0f0bf2;
            this.i = R.string.obfuscated_res_0x7f0f0be6;
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            this.b.setBackground(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080deb));
            this.b.setText(getContext().getResources().getText(R.string.obfuscated_res_0x7f0f0bf5));
            this.b.setPadding(38, 14, 38, 14);
            this.b.setLayoutParams(layoutParams);
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = b21.b(35.0f);
            this.b.setPadding(0, 0, b21.b(15.0f), 0);
            this.b.setText(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0bf2));
            this.b.setBackground(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080de9));
            this.b.setLayoutParams(layoutParams);
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (r().V0()) {
                this.c.bottomMargin = b21.b(7.0f);
            } else {
                this.c.bottomMargin = 2;
                this.b.setBackground(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080de9));
            }
            this.b.setLayoutParams(this.c);
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (r().V0()) {
                this.c.bottomMargin = b21.b(81.0f);
            } else {
                this.c.bottomMargin = b21.b(32.0f);
                this.b.setBackgroundColor(0);
                this.c.height = b21.b(32.0f);
            }
            this.b.setLayoutParams(this.c);
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.b.bringToFront();
            this.e.start();
            w();
            A(true);
        }
    }

    @Override // com.repackage.tr0
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.b : (View) invokeV.objValue;
    }

    @Override // com.repackage.mr0
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            TextView textView = new TextView(getContext());
            this.b = textView;
            textView.setText(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0bf2));
            this.b.setTextSize(0, getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070568));
            this.b.setShadowLayer(0.0f, 0.0f, 1.0f, Color.parseColor("#80000000"));
            this.b.setTextColor(-1);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, b21.b(35.0f));
            this.c = layoutParams;
            layoutParams.gravity = BadgeDrawable.BOTTOM_END;
            this.b.setLayoutParams(layoutParams);
            this.b.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.obfuscated_res_0x7f080e0d));
            this.b.setGravity(8388629);
            this.b.setAlpha(0.0f);
            this.b.setPadding(0, 0, b21.b(15.0f), 0);
            y();
            B(false);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.repackage.mr0
    public void k(@NonNull rs0 rs0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, rs0Var) == null) {
            super.k(rs0Var);
            String c2 = rs0Var.c();
            switch (c2.hashCode()) {
                case -1244137507:
                    if (c2.equals(PlayerEvent.ACTION_SEEK_COMPLETE)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -882902390:
                    if (c2.equals(PlayerEvent.ACTION_SET_DATA_SOURCE)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -552621273:
                    if (c2.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -552580917:
                    if (c2.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 723345051:
                    if (c2.equals(ControlEvent.ACTION_START)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 1933234291:
                    if (c2.equals(ControlEvent.ACTION_CONTINUE_TIPS_SHOW)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c == 0 || c == 1 || c == 2) {
                x();
            } else if (c != 3) {
                if (c == 4) {
                    C();
                    B(true);
                } else if (c != 5) {
                } else {
                    D();
                    B(false);
                }
            } else if (r().r1()) {
            } else {
                boolean e = rs0Var.e(8, false);
                boolean e2 = rs0Var.e(9, false);
                if (e) {
                    this.b.setText(getContext().getResources().getString(this.i));
                } else if (e2) {
                    if (!TextUtils.isEmpty(this.g)) {
                        this.b.setText(this.g);
                        this.b.setBackground(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080de9));
                    }
                } else {
                    this.b.setText(getContext().getResources().getString(this.h));
                }
                if (this.d) {
                    F();
                } else {
                    E();
                }
                G();
            }
        }
    }

    @Override // com.repackage.sr0
    public void t(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            super.t(z, z2);
            this.d = z;
            x();
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.b.postDelayed(new a(this), 3000L);
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f.isRunning() || this.b.getAlpha() == 0.0f) {
            return;
        }
        this.f.start();
        A(false);
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.e = ObjectAnimator.ofFloat(this.b, AnimationProperty.OPACITY, 0.0f, 1.0f).setDuration(250L);
            this.f = ObjectAnimator.ofFloat(this.b, AnimationProperty.OPACITY, 1.0f, 0.0f).setDuration(250L);
        }
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.e.isRunning() || this.b.getAlpha() == 1.0f : invokeV.booleanValue;
    }
}
