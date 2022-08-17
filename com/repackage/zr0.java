package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideo;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class zr0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static nv0 a(@NonNull BdVideoSeries bdVideoSeries, @NonNull BdVideo bdVideo, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, bdVideoSeries, bdVideo, str, str2)) == null) {
            nv0 nv0Var = new nv0();
            nv0Var.k(str2);
            nv0Var.l(mv0.c(bdVideo.getCurrentLength()) + "/" + mv0.c(bdVideo.getTotalLength()));
            nv0Var.p(bdVideoSeries.getVid());
            nv0Var.m(bdVideo.getType());
            nv0Var.j(System.currentTimeMillis());
            nv0Var.n(bdVideo.getTitle());
            nv0Var.o(str);
            nv0Var.r(bdVideoSeries.getPositionMs());
            nv0Var.q(bdVideo.getCurrentLength());
            nv0Var.s(bdVideo.getTotalLength());
            return nv0Var;
        }
        return (nv0) invokeLLLL.objValue;
    }
}
