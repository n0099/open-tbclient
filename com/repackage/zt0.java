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
import com.repackage.cs0;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class zt0 extends ut0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String g;

    public zt0() {
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

    @Override // com.repackage.vt0
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            S();
        }
    }

    @Override // com.repackage.ut0
    public void O(as0 as0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, as0Var) == null) {
            super.O(as0Var);
            as0 as0Var2 = this.f;
            if (as0Var2 != null) {
                as0Var2.d(this);
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
            po0 u = u();
            if (o1 == null || u == null || (videoAd = o1.getVideoAd()) == null || !videoAd.suffixAdEnable) {
                return;
            }
            es0 a = cs0.b.a().a(new HashMap(), videoAd.mAdVideoTailFrameData);
            a.a(u.V0());
            O(a);
        }
    }

    public void S() {
        as0 as0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (as0Var = this.f) == null) {
            return;
        }
        as0Var.onDestroy();
        this.f = null;
    }

    public final void T() {
        BdVideoSeries o1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (("ad_video_tail_frame_layer".equals(this.g) || "ad_video_detail_tail_frame_layer".equals(this.g)) && (this.f instanceof es0) && (o1 = u().o1()) != null) {
                BdVideoAd videoAd = o1.getVideoAd();
                ((es0) this.f).e(videoAd == null ? null : videoAd.mAdVideoTailFrameData);
            }
        }
    }

    @Override // com.repackage.vt0, com.repackage.js0
    public void d(@NonNull ir0 ir0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ir0Var) == null) {
            if (PlayerEvent.ACTION_SET_DATA_SOURCE.equals(ir0Var.c()) && !TextUtils.isEmpty(this.g)) {
                if (this.f != null) {
                    T();
                } else {
                    Q();
                }
            }
            as0 as0Var = this.f;
            if (as0Var != null) {
                as0Var.c(ir0Var);
            }
        }
    }

    @Override // com.repackage.ut0, com.repackage.ks0
    public boolean e(@NonNull ir0 ir0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, ir0Var)) == null) {
            if (u().U0()) {
                return false;
            }
            return super.e(ir0Var);
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.js0
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new int[]{4, 2, 3, 1} : (int[]) invokeV.objValue;
    }

    @Override // com.repackage.vt0, com.repackage.js0
    public void k(@NonNull ir0 ir0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, ir0Var) == null) {
            super.k(ir0Var);
            if (LayerEvent.ACTION_SWITCH_FULL.equals(ir0Var.c()) || LayerEvent.ACTION_SWITCH_HALF.equals(ir0Var.c())) {
                th0.a("AdLayer", "screen mode: " + ir0Var.c());
            }
            as0 as0Var = this.f;
            if (as0Var != null) {
                as0Var.c(ir0Var);
            }
        }
    }

    @Override // com.repackage.vt0, com.repackage.js0
    public void n(@NonNull ir0 ir0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ir0Var) == null) {
            super.n(ir0Var);
            as0 as0Var = this.f;
            if (as0Var != null) {
                as0Var.c(ir0Var);
            }
        }
    }

    @Override // com.repackage.ut0, com.repackage.du0, com.repackage.vt0, com.repackage.iu0
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onLayerRelease();
            S();
        }
    }

    @Override // com.repackage.vt0, com.repackage.js0
    public void q(@NonNull ir0 ir0Var) {
        as0 as0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, ir0Var) == null) || (as0Var = this.f) == null) {
            return;
        }
        as0Var.c(ir0Var);
    }

    public zt0(String str) {
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
