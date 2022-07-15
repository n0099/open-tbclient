package com.kwad.components.ad.reward;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public final class r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(int i, int i2, l lVar, com.kwad.components.ad.reward.model.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), lVar, cVar}) == null) {
            if (i == 0) {
                com.kwad.sdk.core.report.a.g(cVar.d(), 1);
            } else if (i == 1) {
                boolean j = lVar.C.j();
                if (i2 == 0) {
                    if (j) {
                        com.kwad.sdk.core.report.a.g(cVar.d(), 1);
                    }
                } else if (j) {
                    com.kwad.sdk.core.report.a.g(cVar.d(), 5);
                } else {
                    com.kwad.sdk.core.report.a.g(cVar.d(), 4);
                }
            } else if (i != 2) {
            } else {
                boolean l = lVar.B.l();
                if (i2 == 0) {
                    if (l) {
                        com.kwad.sdk.core.report.a.g(cVar.d(), 1);
                    }
                } else if (l) {
                    com.kwad.sdk.core.report.a.g(cVar.d(), 3);
                } else {
                    com.kwad.sdk.core.report.a.g(cVar.d(), 2);
                }
            }
        }
    }
}
