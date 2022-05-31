package com.repackage;

import android.annotation.SuppressLint;
import android.os.Message;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes7.dex */
public abstract class st0 extends xt0<FrameLayout, fq0> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean g;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ st0 a;

        public a(st0 st0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {st0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = st0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.W(false);
            }
        }
    }

    public st0() {
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

    @Override // com.repackage.bu0, com.repackage.rt0
    public void A(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            super.A(message);
            if (message.what == 1) {
                W(false);
            }
        }
    }

    @Override // com.repackage.bu0
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.e = new FrameLayout(this.c);
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.d.removeMessages(1);
        }
    }

    public void U(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            T();
            this.d.sendMessageDelayed(this.d.obtainMessage(1), i);
        }
    }

    public boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.g : invokeV.booleanValue;
    }

    public void W(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            X(z, false);
        }
    }

    public void X(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.d.removeMessages(2);
            boolean z3 = z && (!xo0.W0() || !v().V0());
            if (z3) {
                U(3000);
                this.g = true;
            } else {
                T();
                this.g = false;
            }
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                ((fq0) it.next()).t(z3, z2);
            }
            er0 w = uq0.w(LayerEvent.ACTION_PANEL_VISIBLE_CHANGED);
            w.n(9, Boolean.valueOf(z3));
            G(w);
            if (v().V0() && pw0.i(getActivity())) {
                pw0.o(pw0.e(getActivity()), true);
            }
            v().y().y(z3);
        }
    }

    @Override // com.repackage.bu0, com.repackage.rt0, com.repackage.fs0
    public void d(@NonNull er0 er0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, er0Var) == null) {
            if (PlayerEvent.ACTION_ON_COMPLETE.equals(er0Var.c())) {
                W(false);
            } else if (PlayerEvent.ACTION_ON_ERROR.equals(er0Var.c())) {
                W(false);
            }
            N(er0Var);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.repackage.bu0, com.repackage.rt0, com.repackage.fs0
    public void k(@NonNull er0 er0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, er0Var) == null) {
            String c2 = er0Var.c();
            switch (c2.hashCode()) {
                case -1814572281:
                    if (c2.equals(LayerEvent.ACTION_SPEED_CLICK)) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case -1225548796:
                    if (c2.equals(LayerEvent.ACTION_PRAISE_ANIM_START)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -915923721:
                    if (c2.equals(LayerEvent.ACTION_ADJUST_VOLUME)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case -361192620:
                    if (c2.equals(LayerEvent.ACTION_CLARITY_CLICK)) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case -316059751:
                    if (c2.equals(LayerEvent.ACTION_ADJUST_LIGHT)) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case -150198673:
                    if (c2.equals(LayerEvent.ACTION_CLICK_NET_TIP)) {
                        c = 3;
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
                case 555655894:
                    if (c2.equals(LayerEvent.ACTION_GOODS_CLICK)) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case 1231554669:
                    if (c2.equals(LayerEvent.ACTION_LOCK_SCREEN)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 1249368243:
                    if (c2.equals(LayerEvent.ACTION_LONG_PRESS)) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                case 1626817018:
                    if (c2.equals(LayerEvent.ACTION_SHOW_FACE_AI_HEAD_BOX)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 2064424334:
                    if (c2.equals(LayerEvent.ACTION_POSITION_SLIDE)) {
                        c = 5;
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
                    T();
                    break;
                case 1:
                    W(!this.g);
                    break;
                case 2:
                    this.d.postDelayed(new a(this), 100L);
                    break;
                case 3:
                    W(true);
                    w().h();
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                case '\b':
                case '\t':
                case '\n':
                case 11:
                    W(false);
                    break;
            }
            N(er0Var);
        }
    }

    @Override // com.repackage.bu0, com.repackage.rt0, com.repackage.eu0
    public void onContainerDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onContainerDetach();
            W(false);
        }
    }

    @Override // com.repackage.bu0, com.repackage.rt0, com.repackage.fs0
    @SuppressLint({"WrongConstant"})
    public void r(@NonNull er0 er0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, er0Var) == null) {
            if (ControlEvent.ACTION_SHOW_TIP.equals(er0Var.c())) {
                W(false);
            }
            N(er0Var);
        }
    }
}
