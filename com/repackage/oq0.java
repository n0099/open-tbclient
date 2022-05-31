package com.repackage;

import android.app.Activity;
import android.media.AudioManager;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.ui.VerticalVolumeBar;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.SystemEvent;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.zz0;
/* loaded from: classes6.dex */
public class oq0 extends fq0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VerticalVolumeBar b;
    public AudioManager c;
    public boolean d;
    public boolean e;
    public boolean f;
    public int g;
    public final Runnable h;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oq0 a;

        public a(oq0 oq0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oq0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oq0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.z();
            }
        }
    }

    public oq0() {
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
        this.e = false;
        this.f = false;
        this.h = new a(this);
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Activity activity = r().getActivity();
            if (activity != null && activity.hasWindowFocus()) {
                if ((!r().Y() && !r().W()) || this.e) {
                    z();
                    return;
                }
                VerticalVolumeBar verticalVolumeBar = this.b;
                if (verticalVolumeBar != null && verticalVolumeBar.getVisibility() != 0) {
                    this.b.setVisibility(0);
                    er0 w = uq0.w(LayerEvent.ACTION_SHOW_VOLUME_BAR);
                    e(w);
                    o(w);
                }
                y();
                if (this.c == null) {
                    this.c = (AudioManager) getContext().getApplicationContext().getSystemService("audio");
                }
                int streamMaxVolume = this.c.getStreamMaxVolume(3);
                int streamVolume = this.c.getStreamVolume(3);
                VerticalVolumeBar verticalVolumeBar2 = this.b;
                if (verticalVolumeBar2 != null) {
                    if (!this.f) {
                        verticalVolumeBar2.setMax(streamMaxVolume);
                        this.b.setProgress(streamVolume);
                    } else {
                        verticalVolumeBar2.setMax(100);
                        this.b.setProgress(this.g);
                    }
                }
                s().x().removeCallbacks(this.h);
                s().x().postDelayed(this.h, 1000L);
                return;
            }
            z();
        }
    }

    public final void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (this.b == null) {
                i();
            }
            this.b.setLayoutParams(x(z));
            z();
        }
    }

    @Override // com.repackage.gq0
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : (View) invokeV.objValue;
    }

    @Override // com.repackage.zp0
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            VerticalVolumeBar verticalVolumeBar = new VerticalVolumeBar(getContext(), null, 16842872);
            this.b = verticalVolumeBar;
            verticalVolumeBar.setLayoutParams(x(false));
            this.b.setProgressDrawable(ContextCompat.getDrawable(getContext(), R.drawable.obfuscated_res_0x7f080e47));
            this.b.setBackgroundResource(R.drawable.obfuscated_res_0x7f080e48);
            int dimension = (int) getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f07053f);
            int i = dimension / 2;
            this.b.setPadding(i, dimension, i, dimension);
            this.b.setVisibility(8);
        }
    }

    @Override // com.repackage.zp0
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.j();
            z();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.repackage.zp0
    public void k(@NonNull er0 er0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, er0Var) == null) {
            String c2 = er0Var.c();
            switch (c2.hashCode()) {
                case -915923721:
                    if (c2.equals(LayerEvent.ACTION_ADJUST_VOLUME)) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case -552621273:
                    if (c2.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case -552580917:
                    if (c2.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case -316059751:
                    if (c2.equals(LayerEvent.ACTION_ADJUST_LIGHT)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -21461611:
                    if (c2.equals(LayerEvent.ACTION_TOUCH_DOWN)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -14542718:
                    if (c2.equals(LayerEvent.ACTION_HIDE_VOLUME_BAR)) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case 649538615:
                    if (c2.equals(LayerEvent.ACTION_ADJUST_VOLUME_COMPLETE)) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case 1547354793:
                    if (c2.equals(ControlEvent.ACTION_STOP)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 1822725860:
                    if (c2.equals(SystemEvent.ACTION_VOLUME_CHANGED)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 2064424334:
                    if (c2.equals(LayerEvent.ACTION_POSITION_SLIDE)) {
                        c = 3;
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
                    A();
                    return;
                case 1:
                    if (this.d) {
                        return;
                    }
                    z();
                    return;
                case 2:
                case 3:
                case 4:
                    z();
                    return;
                case 5:
                    B(true);
                    return;
                case 6:
                    B(false);
                    return;
                case 7:
                    this.f = true;
                    this.g = er0Var.g(20);
                    A();
                    return;
                case '\b':
                    this.f = false;
                    return;
                case '\t':
                    VerticalVolumeBar verticalVolumeBar = this.b;
                    if (verticalVolumeBar == null || verticalVolumeBar.getVisibility() != 0) {
                        return;
                    }
                    this.b.setVisibility(8);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.repackage.fq0
    public void t(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.d = z;
            if (z) {
                z();
            }
        }
    }

    public FrameLayout.LayoutParams x(boolean z) {
        InterceptResult invokeZ;
        int i;
        float dimension;
        float dimension2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            int dimension3 = (int) getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f07053f);
            int min = Math.min(zz0.c.e(getContext()), zz0.c.c(getContext()));
            if (!z) {
                i = ((min / 16) * 9) / 2;
            } else {
                i = min / 2;
            }
            int i2 = i + dimension3;
            int dimension4 = (dimension3 * 2) + ((int) getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f07053d));
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(i2, dimension4);
            }
            layoutParams.width = i2;
            layoutParams.height = dimension4;
            if (!z) {
                dimension = getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f07053e);
            } else {
                dimension = getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f07053c);
            }
            layoutParams.leftMargin = ((int) dimension) - dimension3;
            layoutParams.gravity = 80;
            if (!z) {
                dimension2 = getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f07053a);
            } else {
                dimension2 = getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f07053b);
            }
            layoutParams.bottomMargin = ((int) dimension2) - dimension3;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeZ.objValue;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && s() != null && s().V()) {
            s().W(false);
        }
    }

    public final void z() {
        VerticalVolumeBar verticalVolumeBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (verticalVolumeBar = this.b) != null && verticalVolumeBar.getVisibility() == 0) {
            this.b.setVisibility(8);
            e(uq0.w(LayerEvent.ACTION_HIDE_VOLUME_BAR));
        }
    }
}
