package com.repackage;

import android.app.Activity;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class zs0 implements rt0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public lv0 a;
    public lv0 b;

    public zs0() {
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

    @Override // com.repackage.rt0
    public void a(yp0 player) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, player) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            i(player, player.u());
            lv0 k = player.k();
            if (k != null) {
                if (!Intrinsics.areEqual(k, this.b)) {
                    j(this.b);
                    this.b = null;
                } else if (!Intrinsics.areEqual(k, this.a)) {
                    j(this.a);
                    this.a = null;
                }
                j(k);
            }
        }
    }

    @Override // com.repackage.rt0
    public lv0 b(yp0 player, lv0 lv0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, player, lv0Var)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (player.u1()) {
                lv0Var = h(player, player.u());
            }
            if (lv0Var == null) {
                lv0Var = f(player.o());
            }
            this.a = lv0Var;
            return lv0Var;
        }
        return (lv0) invokeLL.objValue;
    }

    @Override // com.repackage.rt0
    public void c(yp0 player, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, player, z) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            lv0 lv0Var = this.a;
            if (lv0Var != null) {
                e(player, lv0Var);
                return;
            }
            if (this.b == null) {
                this.b = f(player.o());
            }
            e(player, this.b);
        }
    }

    @Override // com.repackage.rt0
    public boolean d(yp0 player, lv0 lv0Var) {
        InterceptResult invokeLL;
        String vid;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, player, lv0Var)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            BdVideoSeries o1 = player.o1();
            if (o1 == null || (vid = o1.getVid()) == null) {
                return false;
            }
            Intrinsics.checkNotNullExpressionValue(vid, "player.videoSeries?.vid ?: return false");
            sv0 sv0Var = (sv0) (!(lv0Var instanceof sv0) ? null : lv0Var);
            if (Intrinsics.areEqual(vid, sv0Var != null ? sv0Var.y0() : null)) {
                return PlayerStatus.isActiveStatus(lv0Var != null ? lv0Var.R() : null);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void e(yp0 yp0Var, lv0 lv0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, yp0Var, lv0Var) == null) || lv0Var == null) {
            return;
        }
        yp0Var.e(lv0Var);
    }

    public final sv0 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (str == null) {
                str = "CyberNetPlayer";
            }
            return new sv0(str);
        }
        return (sv0) invokeL.objValue;
    }

    public boolean g(xp0 player, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, player, str)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (str == null || str.length() == 0) {
                return false;
            }
            lv0 k = player.k();
            ay0.a("ReuseHelper: detach,cache is " + k + ",cacheKey is " + str);
            if (k != null) {
                k.Y();
                pq0.a().c(str, k);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public lv0 h(xp0 player, String str) {
        InterceptResult invokeLL;
        ru0 T;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, player, str)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            lv0 b = pq0.a().b(str);
            if (Intrinsics.areEqual((b == null || (T = b.T()) == null) ? null : Boolean.valueOf(T.verify(player.o())), Boolean.TRUE)) {
                pq0.a().d(str);
                player.A0(true);
                if (b.v() != null) {
                    b.v().k();
                    return b;
                }
                return b;
            }
            player.A0(false);
            return null;
        }
        return (lv0) invokeLL.objValue;
    }

    public void i(yp0 player, String str) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, player, str) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (player.u1() && player.b0() && !player.S() && (activity = player.getActivity()) != null && activity.isFinishing()) {
                ay0.a("performAutoDetachCache begin");
                lv0 A = player.A();
                lv0 lv0Var = this.a;
                if (Intrinsics.areEqual(lv0Var != null ? lv0Var.v() : null, player)) {
                    ay0.a("autoDetachCache,cacheKey:" + str + ", kernelLayer:" + A);
                    if (g(player, str)) {
                        this.a = null;
                    }
                } else if (this.a != null) {
                    ay0.a("detachCache,cacheKey:" + str + ", kernelLayer:" + A);
                    lv0 lv0Var2 = this.a;
                    if (lv0Var2 != null) {
                        lv0Var2.Y();
                    }
                    pq0.a().c(str, this.a);
                    this.a = null;
                }
            }
        }
    }

    public final void j(lv0 lv0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, lv0Var) == null) || lv0Var == null) {
            return;
        }
        lv0Var.Y();
        lv0Var.t0();
        lv0Var.a0();
    }
}
