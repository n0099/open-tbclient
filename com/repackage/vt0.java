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
import com.repackage.yr0;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class vt0 extends qt0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String g;

    public vt0() {
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
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            S();
        }
    }

    @Override // com.repackage.qt0
    public void O(wr0 wr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wr0Var) == null) {
            super.O(wr0Var);
            wr0 wr0Var2 = this.f;
            if (wr0Var2 != null) {
                wr0Var2.d(this);
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
            BdVideoSeries o1 = v().o1();
            lo0 v = v();
            if (o1 == null || v == null || (videoAd = o1.getVideoAd()) == null || !videoAd.suffixAdEnable) {
                return;
            }
            as0 a = yr0.b.a().a(new HashMap(), videoAd.mAdVideoTailFrameData);
            a.a(v.V0());
            O(a);
        }
    }

    public void S() {
        wr0 wr0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (wr0Var = this.f) == null) {
            return;
        }
        wr0Var.onDestroy();
        this.f = null;
    }

    public final void T() {
        BdVideoSeries o1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (("ad_video_tail_frame_layer".equals(this.g) || "ad_video_detail_tail_frame_layer".equals(this.g)) && (this.f instanceof as0) && (o1 = v().o1()) != null) {
                BdVideoAd videoAd = o1.getVideoAd();
                ((as0) this.f).e(videoAd == null ? null : videoAd.mAdVideoTailFrameData);
            }
        }
    }

    @Override // com.repackage.rt0, com.repackage.fs0
    public void d(@NonNull er0 er0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, er0Var) == null) {
            if (PlayerEvent.ACTION_SET_DATA_SOURCE.equals(er0Var.c()) && !TextUtils.isEmpty(this.g)) {
                if (this.f != null) {
                    T();
                } else {
                    Q();
                }
            }
            wr0 wr0Var = this.f;
            if (wr0Var != null) {
                wr0Var.c(er0Var);
            }
        }
    }

    @Override // com.repackage.qt0, com.repackage.gs0
    public boolean e(@NonNull er0 er0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, er0Var)) == null) {
            if (v().U0()) {
                return false;
            }
            return super.e(er0Var);
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.fs0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new int[]{4, 2, 3, 1} : (int[]) invokeV.objValue;
    }

    @Override // com.repackage.rt0, com.repackage.fs0
    public void k(@NonNull er0 er0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, er0Var) == null) {
            super.k(er0Var);
            if (LayerEvent.ACTION_SWITCH_FULL.equals(er0Var.c()) || LayerEvent.ACTION_SWITCH_HALF.equals(er0Var.c())) {
                ph0.a("AdLayer", "screen mode: " + er0Var.c());
            }
            wr0 wr0Var = this.f;
            if (wr0Var != null) {
                wr0Var.c(er0Var);
            }
        }
    }

    @Override // com.repackage.rt0, com.repackage.fs0
    public void n(@NonNull er0 er0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, er0Var) == null) {
            super.n(er0Var);
            wr0 wr0Var = this.f;
            if (wr0Var != null) {
                wr0Var.c(er0Var);
            }
        }
    }

    @Override // com.repackage.qt0, com.repackage.zt0, com.repackage.rt0, com.repackage.eu0
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onLayerRelease();
            S();
        }
    }

    @Override // com.repackage.rt0, com.repackage.fs0
    public void r(@NonNull er0 er0Var) {
        wr0 wr0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, er0Var) == null) || (wr0Var = this.f) == null) {
            return;
        }
        wr0Var.c(er0Var);
    }

    public vt0(String str) {
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
