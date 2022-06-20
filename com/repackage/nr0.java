package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideo;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class nr0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static bv0 a(@NonNull BdVideoSeries bdVideoSeries, @NonNull BdVideo bdVideo, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, bdVideoSeries, bdVideo, str, str2)) == null) {
            bv0 bv0Var = new bv0();
            bv0Var.k(str2);
            bv0Var.l(av0.c(bdVideo.getCurrentLength()) + "/" + av0.c(bdVideo.getTotalLength()));
            bv0Var.p(bdVideoSeries.getVid());
            bv0Var.m(bdVideo.getType());
            bv0Var.j(System.currentTimeMillis());
            bv0Var.n(bdVideo.getTitle());
            bv0Var.o(str);
            bv0Var.r(bdVideoSeries.getPositionMs());
            bv0Var.q(bdVideo.getCurrentLength());
            bv0Var.s(bdVideo.getTotalLength());
            return bv0Var;
        }
        return (bv0) invokeLLLL.objValue;
    }
}
