package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideo;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jr0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static xu0 a(@NonNull BdVideoSeries bdVideoSeries, @NonNull BdVideo bdVideo, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, bdVideoSeries, bdVideo, str, str2)) == null) {
            xu0 xu0Var = new xu0();
            xu0Var.k(str2);
            xu0Var.l(wu0.c(bdVideo.getCurrentLength()) + "/" + wu0.c(bdVideo.getTotalLength()));
            xu0Var.p(bdVideoSeries.getVid());
            xu0Var.m(bdVideo.getType());
            xu0Var.j(System.currentTimeMillis());
            xu0Var.n(bdVideo.getTitle());
            xu0Var.o(str);
            xu0Var.r(bdVideoSeries.getPositionMs());
            xu0Var.q(bdVideo.getCurrentLength());
            xu0Var.s(bdVideo.getTotalLength());
            return xu0Var;
        }
        return (xu0) invokeLLLL.objValue;
    }
}
