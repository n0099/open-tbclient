package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideo;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class as0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ov0 a(@NonNull BdVideoSeries bdVideoSeries, @NonNull BdVideo bdVideo, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, bdVideoSeries, bdVideo, str, str2)) == null) {
            ov0 ov0Var = new ov0();
            ov0Var.k(str2);
            ov0Var.l(nv0.c(bdVideo.getCurrentLength()) + "/" + nv0.c(bdVideo.getTotalLength()));
            ov0Var.p(bdVideoSeries.getVid());
            ov0Var.m(bdVideo.getType());
            ov0Var.j(System.currentTimeMillis());
            ov0Var.n(bdVideo.getTitle());
            ov0Var.o(str);
            ov0Var.r(bdVideoSeries.getPositionMs());
            ov0Var.q(bdVideo.getCurrentLength());
            ov0Var.s(bdVideo.getTotalLength());
            return ov0Var;
        }
        return (ov0) invokeLLLL.objValue;
    }
}
