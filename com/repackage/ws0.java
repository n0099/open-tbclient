package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideo;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ws0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static kw0 a(@NonNull BdVideoSeries bdVideoSeries, @NonNull BdVideo bdVideo, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, bdVideoSeries, bdVideo, str, str2)) == null) {
            kw0 kw0Var = new kw0();
            kw0Var.k(str2);
            kw0Var.l(jw0.c(bdVideo.getCurrentLength()) + "/" + jw0.c(bdVideo.getTotalLength()));
            kw0Var.p(bdVideoSeries.getVid());
            kw0Var.m(bdVideo.getType());
            kw0Var.j(System.currentTimeMillis());
            kw0Var.n(bdVideo.getTitle());
            kw0Var.o(str);
            kw0Var.r(bdVideoSeries.getPositionMs());
            kw0Var.q(bdVideo.getCurrentLength());
            kw0Var.s(bdVideo.getTotalLength());
            return kw0Var;
        }
        return (kw0) invokeLLLL.objValue;
    }
}
