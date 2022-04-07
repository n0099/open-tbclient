package com.repackage;

import android.os.Message;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.searchbox.player.event.ControlEvent;
import com.baidu.searchbox.player.event.InteractiveEvent;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class nv0 extends fv0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean h;
    public wr0 i;
    public qr0 j;
    public ur0 k;
    @Nullable
    public yr0 l;
    public as0 m;
    public xr0 n;

    public nv0() {
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
        this.h = false;
    }

    @Override // com.repackage.fv0, com.repackage.ov0, com.repackage.ev0
    public void A(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            super.A(message);
            if (message.what == 0) {
                k0();
                W(false);
            }
        }
    }

    @Override // com.repackage.ov0
    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            wr0 wr0Var = new wr0();
            this.i = wr0Var;
            K(wr0Var);
            yr0 yr0Var = new yr0();
            this.l = yr0Var;
            K(yr0Var);
            xr0 xr0Var = new xr0();
            this.n = xr0Var;
            K(xr0Var);
            K(new zr0());
            as0 as0Var = new as0();
            this.m = as0Var;
            K(as0Var);
            Y();
            Z();
            K(new bs0());
            K(new vr0());
            a0();
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            rr0 rr0Var = new rr0();
            this.j = rr0Var;
            K(rr0Var);
        }
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ur0 ur0Var = new ur0();
            this.k = ur0Var;
            K(ur0Var);
        }
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public void b0() {
        qr0 qr0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (qr0Var = this.j) == null) {
            return;
        }
        qr0Var.w();
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // com.repackage.fv0, com.repackage.ov0, com.repackage.ev0, com.repackage.st0
    public void d(@NonNull rs0 rs0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, rs0Var) == null) {
            super.d(rs0Var);
            if (PlayerEvent.ACTION_PLAYER_DETACH.equals(rs0Var.c())) {
                W(false);
            } else if (PlayerEvent.ACTION_ON_ERROR.equals(rs0Var.c())) {
                W(false);
            }
        }
    }

    public boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.d.removeMessages(0);
        }
    }

    public final void f0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && ky0.f()) {
            int a = z ? wx0.a(this.e, 20.0f) : 0;
            T t = this.e;
            ((FrameLayout) t).setPadding(((FrameLayout) t).getPaddingLeft(), ((FrameLayout) this.e).getPaddingTop(), ((FrameLayout) this.e).getPaddingRight(), a);
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            ky0.k(this);
        }
    }

    @Override // com.repackage.ov0, com.repackage.st0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? new int[]{4, 2, 3, 5, 1, 8} : (int[]) invokeV.objValue;
    }

    public void h0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            if (z) {
                if (v().V0()) {
                    return;
                }
                v().c1(1);
            } else if (v().V0()) {
                v().d1(1);
            }
        }
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    @Override // com.repackage.ov0, com.repackage.ev0, com.repackage.st0
    public void j(@NonNull rs0 rs0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, rs0Var) == null) {
            super.j(rs0Var);
            if (InteractiveEvent.ACTION_SWITCH_INTERACTIVE_KERNEL.equals(rs0Var.c())) {
                if (rs0Var.d(9)) {
                    i0();
                } else {
                    j0();
                }
            }
        }
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    @Override // com.repackage.fv0, com.repackage.ov0, com.repackage.ev0, com.repackage.st0
    public void k(@NonNull rs0 rs0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, rs0Var) == null) {
            super.k(rs0Var);
            String c2 = rs0Var.c();
            int hashCode = c2.hashCode();
            if (hashCode == -552621273) {
                if (c2.equals(LayerEvent.ACTION_SWITCH_FULL)) {
                    c = 1;
                }
                c = 65535;
            } else if (hashCode != -552580917) {
                if (hashCode == -21461611 && c2.equals(LayerEvent.ACTION_TOUCH_DOWN)) {
                    c = 2;
                }
                c = 65535;
            } else {
                if (c2.equals(LayerEvent.ACTION_SWITCH_HALF)) {
                    c = 0;
                }
                c = 65535;
            }
            if (c == 0) {
                ky0.i(this);
                W(false);
                rs0 w = hs0.w(LayerEvent.ACTION_BARRAGE_EDIT_VIEW_VISIBLE_STATUS);
                w.n(16, Boolean.FALSE);
                G(w);
                if (this.h) {
                    l0();
                    this.d.removeMessages(0);
                    this.d.sendEmptyMessageDelayed(0, 2000L);
                }
                f0(false);
            } else if (c != 1) {
                if (c != 2) {
                    return;
                }
                this.d.removeMessages(0);
                this.h = false;
            } else {
                v().f1();
                g0();
                W(d0());
                b0();
                c0();
                f0(true);
            }
        }
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.d.removeMessages(0);
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                ((sr0) it.next()).u();
            }
            this.h = false;
        }
    }

    public final void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                ((sr0) it.next()).v();
            }
        }
    }

    @Override // com.repackage.ov0, com.repackage.ev0, com.repackage.rv0
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onLayerRelease();
        }
    }

    @Override // com.repackage.fv0, com.repackage.ov0, com.repackage.ev0, com.repackage.st0
    public void r(@NonNull rs0 rs0Var) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, rs0Var) == null) {
            super.r(rs0Var);
            String c2 = rs0Var.c();
            int hashCode = c2.hashCode();
            if (hashCode == 720027695) {
                if (c2.equals(ControlEvent.ACTION_PAUSE)) {
                    c = 1;
                }
                c = 65535;
            } else if (hashCode != 723345051) {
                if (hashCode == 906917140 && c2.equals(ControlEvent.ACTION_RESUME)) {
                    c = 2;
                }
                c = 65535;
            } else {
                if (c2.equals(ControlEvent.ACTION_START)) {
                    c = 0;
                }
                c = 65535;
            }
            if (c == 0) {
                W(false);
                BdVideoSeries o1 = v().o1();
                if (o1 == null || !o1.getSelectedVideo().getShowTitle()) {
                    return;
                }
                this.d.removeMessages(0);
                if (!v().V0()) {
                    l0();
                }
                this.d.sendEmptyMessageDelayed(0, 2000L);
                this.h = true;
            } else if (c != 1) {
                if (c != 2) {
                    return;
                }
                U(3000);
            } else if (rs0Var.g(11) != 2 || v().p1()) {
            } else {
                e0();
                W(true);
                T();
            }
        }
    }
}
