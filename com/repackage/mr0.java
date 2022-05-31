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
/* loaded from: classes6.dex */
public final class mr0 implements es0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yt0 a;
    public yt0 b;

    public mr0() {
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

    @Override // com.repackage.es0
    public void a(lo0 player) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, player) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            i(player, player.u());
            yt0 k = player.k();
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

    @Override // com.repackage.es0
    public yt0 b(lo0 player, yt0 yt0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, player, yt0Var)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (player.u1()) {
                yt0Var = h(player, player.u());
            }
            if (yt0Var == null) {
                yt0Var = f(player.o());
            }
            this.a = yt0Var;
            return yt0Var;
        }
        return (yt0) invokeLL.objValue;
    }

    @Override // com.repackage.es0
    public void c(lo0 player, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, player, z) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            yt0 yt0Var = this.a;
            if (yt0Var != null) {
                e(player, yt0Var);
                return;
            }
            if (this.b == null) {
                this.b = f(player.o());
            }
            e(player, this.b);
        }
    }

    @Override // com.repackage.es0
    public boolean d(lo0 player, yt0 yt0Var) {
        InterceptResult invokeLL;
        String vid;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, player, yt0Var)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            BdVideoSeries o1 = player.o1();
            if (o1 == null || (vid = o1.getVid()) == null) {
                return false;
            }
            Intrinsics.checkNotNullExpressionValue(vid, "player.videoSeries?.vid ?: return false");
            fu0 fu0Var = (fu0) (!(yt0Var instanceof fu0) ? null : yt0Var);
            if (Intrinsics.areEqual(vid, fu0Var != null ? fu0Var.y0() : null)) {
                return PlayerStatus.isActiveStatus(yt0Var != null ? yt0Var.R() : null);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void e(lo0 lo0Var, yt0 yt0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, lo0Var, yt0Var) == null) || yt0Var == null) {
            return;
        }
        lo0Var.e(yt0Var);
    }

    public final fu0 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (str == null) {
                str = "CyberNetPlayer";
            }
            return new fu0(str);
        }
        return (fu0) invokeL.objValue;
    }

    public boolean g(ko0 player, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, player, str)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (str == null || str.length() == 0) {
                return false;
            }
            yt0 k = player.k();
            nw0.a("ReuseHelper: detach,cache is " + k + ",cacheKey is " + str);
            if (k != null) {
                k.Y();
                cp0.a().c(str, k);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public yt0 h(ko0 player, String str) {
        InterceptResult invokeLL;
        et0 T;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, player, str)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            yt0 b = cp0.a().b(str);
            if (Intrinsics.areEqual((b == null || (T = b.T()) == null) ? null : Boolean.valueOf(T.verify(player.o())), Boolean.TRUE)) {
                cp0.a().d(str);
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
        return (yt0) invokeLL.objValue;
    }

    public void i(lo0 player, String str) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, player, str) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (player.u1() && player.b0() && !player.S() && (activity = player.getActivity()) != null && activity.isFinishing()) {
                nw0.a("performAutoDetachCache begin");
                yt0 A = player.A();
                yt0 yt0Var = this.a;
                if (Intrinsics.areEqual(yt0Var != null ? yt0Var.v() : null, player)) {
                    nw0.a("autoDetachCache,cacheKey:" + str + ", kernelLayer:" + A);
                    if (g(player, str)) {
                        this.a = null;
                    }
                } else if (this.a != null) {
                    nw0.a("detachCache,cacheKey:" + str + ", kernelLayer:" + A);
                    yt0 yt0Var2 = this.a;
                    if (yt0Var2 != null) {
                        yt0Var2.Y();
                    }
                    cp0.a().c(str, this.a);
                    this.a = null;
                }
            }
        }
    }

    public final void j(yt0 yt0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, yt0Var) == null) || yt0Var == null) {
            return;
        }
        yt0Var.Y();
        yt0Var.t0();
        yt0Var.a0();
    }
}
