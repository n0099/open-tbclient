package com.kwad.components.ad.reward;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public final class q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(int i, int i2, k kVar, com.kwad.components.ad.reward.model.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), kVar, cVar}) == null) {
            if (i == 0) {
                com.kwad.sdk.core.report.a.n(cVar.getAdTemplate(), 1);
            } else if (i == 1) {
                boolean iC = kVar.mL.iC();
                if (i2 == 0) {
                    if (iC) {
                        com.kwad.sdk.core.report.a.n(cVar.getAdTemplate(), 1);
                    }
                } else if (iC) {
                    com.kwad.sdk.core.report.a.n(cVar.getAdTemplate(), 5);
                } else {
                    com.kwad.sdk.core.report.a.n(cVar.getAdTemplate(), 4);
                }
            } else if (i != 2) {
            } else {
                boolean iC2 = kVar.mK.iC();
                if (i2 == 0) {
                    if (iC2) {
                        com.kwad.sdk.core.report.a.n(cVar.getAdTemplate(), 1);
                    }
                } else if (iC2) {
                    com.kwad.sdk.core.report.a.n(cVar.getAdTemplate(), 3);
                } else {
                    com.kwad.sdk.core.report.a.n(cVar.getAdTemplate(), 2);
                }
            }
        }
    }
}
