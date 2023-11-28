package com.kwad.components.ad.reward;
/* loaded from: classes10.dex */
public final class n {
    public static void a(int i, int i2, g gVar, com.kwad.components.ad.reward.model.c cVar) {
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    if (i2 == 0) {
                        if (gVar.pp.jz()) {
                            com.kwad.sdk.core.report.a.o(cVar.getAdTemplate(), 1);
                            return;
                        }
                        return;
                    } else if (gVar.pp.jz()) {
                        com.kwad.sdk.core.report.a.o(cVar.getAdTemplate(), 3);
                        return;
                    } else {
                        com.kwad.sdk.core.report.a.o(cVar.getAdTemplate(), 2);
                        return;
                    }
                }
                return;
            } else if (i2 == 0) {
                if (gVar.pq.jz()) {
                    com.kwad.sdk.core.report.a.o(cVar.getAdTemplate(), 1);
                    return;
                }
                return;
            } else if (gVar.pq.jz()) {
                com.kwad.sdk.core.report.a.o(cVar.getAdTemplate(), 5);
                return;
            } else {
                com.kwad.sdk.core.report.a.o(cVar.getAdTemplate(), 4);
                return;
            }
        }
        com.kwad.sdk.core.report.a.o(cVar.getAdTemplate(), 1);
    }
}
