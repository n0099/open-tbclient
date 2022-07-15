package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoAd;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ps0;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class mu0 extends hu0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String g;

    public mu0() {
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

    @Override // com.repackage.iu0
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            S();
        }
    }

    @Override // com.repackage.hu0
    public void O(ns0 ns0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ns0Var) == null) {
            super.O(ns0Var);
            ns0 ns0Var2 = this.f;
            if (ns0Var2 != null) {
                ns0Var2.d(this);
            }
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if ("ad_video_tail_frame_layer".equals(this.g) || "ad_video_detail_tail_frame_layer".equals(this.g)) {
                R();
            }
        }
    }

    public final void R() {
        BdVideoAd videoAd;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            BdVideoSeries o1 = u().o1();
            cp0 u = u();
            if (o1 == null || u == null || (videoAd = o1.getVideoAd()) == null || !videoAd.suffixAdEnable) {
                return;
            }
            rs0 a = ps0.b.a().a(new HashMap(), videoAd.mAdVideoTailFrameData);
            a.a(u.V0());
            O(a);
        }
    }

    public void S() {
        ns0 ns0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (ns0Var = this.f) == null) {
            return;
        }
        ns0Var.onDestroy();
        this.f = null;
    }

    public final void T() {
        BdVideoSeries o1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (("ad_video_tail_frame_layer".equals(this.g) || "ad_video_detail_tail_frame_layer".equals(this.g)) && (this.f instanceof rs0) && (o1 = u().o1()) != null) {
                BdVideoAd videoAd = o1.getVideoAd();
                ((rs0) this.f).e(videoAd == null ? null : videoAd.mAdVideoTailFrameData);
            }
        }
    }

    @Override // com.repackage.iu0, com.repackage.ws0
    public void d(@NonNull vr0 vr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, vr0Var) == null) {
            if (PlayerEvent.ACTION_SET_DATA_SOURCE.equals(vr0Var.c()) && !TextUtils.isEmpty(this.g)) {
                if (this.f != null) {
                    T();
                } else {
                    Q();
                }
            }
            ns0 ns0Var = this.f;
            if (ns0Var != null) {
                ns0Var.c(vr0Var);
            }
        }
    }

    @Override // com.repackage.hu0, com.repackage.xs0
    public boolean e(@NonNull vr0 vr0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, vr0Var)) == null) {
            if (u().U0()) {
                return false;
            }
            return super.e(vr0Var);
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.ws0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new int[]{4, 2, 3, 1} : (int[]) invokeV.objValue;
    }

    @Override // com.repackage.iu0, com.repackage.ws0
    public void k(@NonNull vr0 vr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, vr0Var) == null) {
            super.k(vr0Var);
            if (LayerEvent.ACTION_SWITCH_FULL.equals(vr0Var.c()) || LayerEvent.ACTION_SWITCH_HALF.equals(vr0Var.c())) {
                ci0.a("AdLayer", "screen mode: " + vr0Var.c());
            }
            ns0 ns0Var = this.f;
            if (ns0Var != null) {
                ns0Var.c(vr0Var);
            }
        }
    }

    @Override // com.repackage.iu0, com.repackage.ws0
    public void n(@NonNull vr0 vr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, vr0Var) == null) {
            super.n(vr0Var);
            ns0 ns0Var = this.f;
            if (ns0Var != null) {
                ns0Var.c(vr0Var);
            }
        }
    }

    @Override // com.repackage.hu0, com.repackage.qu0, com.repackage.iu0, com.repackage.vu0
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onLayerRelease();
            S();
        }
    }

    @Override // com.repackage.iu0, com.repackage.ws0
    public void q(@NonNull vr0 vr0Var) {
        ns0 ns0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, vr0Var) == null) || (ns0Var = this.f) == null) {
            return;
        }
        ns0Var.c(vr0Var);
    }

    public mu0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = str;
    }
}
