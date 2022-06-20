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
public final class qr0 implements is0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public cu0 a;
    public cu0 b;

    public qr0() {
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

    @Override // com.repackage.is0
    public void a(po0 player) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, player) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            i(player, player.u());
            cu0 k = player.k();
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

    @Override // com.repackage.is0
    public cu0 b(po0 player, cu0 cu0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, player, cu0Var)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (player.u1()) {
                cu0Var = h(player, player.u());
            }
            if (cu0Var == null) {
                cu0Var = f(player.o());
            }
            this.a = cu0Var;
            return cu0Var;
        }
        return (cu0) invokeLL.objValue;
    }

    @Override // com.repackage.is0
    public void c(po0 player, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, player, z) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            cu0 cu0Var = this.a;
            if (cu0Var != null) {
                e(player, cu0Var);
                return;
            }
            if (this.b == null) {
                this.b = f(player.o());
            }
            e(player, this.b);
        }
    }

    @Override // com.repackage.is0
    public boolean d(po0 player, cu0 cu0Var) {
        InterceptResult invokeLL;
        String vid;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, player, cu0Var)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            BdVideoSeries o1 = player.o1();
            if (o1 == null || (vid = o1.getVid()) == null) {
                return false;
            }
            Intrinsics.checkNotNullExpressionValue(vid, "player.videoSeries?.vid ?: return false");
            ju0 ju0Var = (ju0) (!(cu0Var instanceof ju0) ? null : cu0Var);
            if (Intrinsics.areEqual(vid, ju0Var != null ? ju0Var.y0() : null)) {
                return PlayerStatus.isActiveStatus(cu0Var != null ? cu0Var.R() : null);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void e(po0 po0Var, cu0 cu0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, po0Var, cu0Var) == null) || cu0Var == null) {
            return;
        }
        po0Var.e(cu0Var);
    }

    public final ju0 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (str == null) {
                str = "CyberNetPlayer";
            }
            return new ju0(str);
        }
        return (ju0) invokeL.objValue;
    }

    public boolean g(oo0 player, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, player, str)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (str == null || str.length() == 0) {
                return false;
            }
            cu0 k = player.k();
            rw0.a("ReuseHelper: detach,cache is " + k + ",cacheKey is " + str);
            if (k != null) {
                k.Y();
                gp0.a().c(str, k);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public cu0 h(oo0 player, String str) {
        InterceptResult invokeLL;
        it0 T;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, player, str)) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            cu0 b = gp0.a().b(str);
            if (Intrinsics.areEqual((b == null || (T = b.T()) == null) ? null : Boolean.valueOf(T.verify(player.o())), Boolean.TRUE)) {
                gp0.a().d(str);
                player.A0(true);
                if (b.u() != null) {
                    b.u().k();
                    return b;
                }
                return b;
            }
            player.A0(false);
            return null;
        }
        return (cu0) invokeLL.objValue;
    }

    public void i(po0 player, String str) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, player, str) == null) {
            Intrinsics.checkNotNullParameter(player, "player");
            if (player.u1() && player.b0() && !player.S() && (activity = player.getActivity()) != null && activity.isFinishing()) {
                rw0.a("performAutoDetachCache begin");
                cu0 A = player.A();
                cu0 cu0Var = this.a;
                if (Intrinsics.areEqual(cu0Var != null ? cu0Var.u() : null, player)) {
                    rw0.a("autoDetachCache,cacheKey:" + str + ", kernelLayer:" + A);
                    if (g(player, str)) {
                        this.a = null;
                    }
                } else if (this.a != null) {
                    rw0.a("detachCache,cacheKey:" + str + ", kernelLayer:" + A);
                    cu0 cu0Var2 = this.a;
                    if (cu0Var2 != null) {
                        cu0Var2.Y();
                    }
                    gp0.a().c(str, this.a);
                    this.a = null;
                }
            }
        }
    }

    public final void j(cu0 cu0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, cu0Var) == null) || cu0Var == null) {
            return;
        }
        cu0Var.Y();
        cu0Var.t0();
        cu0Var.a0();
    }
}
