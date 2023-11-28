package com.kwad.sdk.core.webview;

import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.webview.a.c;
/* loaded from: classes10.dex */
public final class d {
    public long aCS;
    public boolean aCT;

    public static void d(c.a aVar) {
        if (aVar != null) {
            com.kwad.sdk.core.report.a.d(aVar.getAdTemplate(), aVar.getClientParams());
        }
    }

    public final void a(c.a aVar) {
        if (aVar != null) {
            com.kwad.sdk.core.report.a.a(aVar.getAdTemplate(), aVar.getClientParams());
        }
        if (aVar != null) {
            this.aCS = System.currentTimeMillis();
        }
    }

    public final void b(c.a aVar) {
        if (aVar != null) {
            y.b clientParams = aVar.getClientParams();
            if (clientParams == null) {
                clientParams = new y.b();
            }
            clientParams.Lc = System.currentTimeMillis() - this.aCS;
            com.kwad.sdk.core.report.a.c(aVar.getAdTemplate(), clientParams);
        }
    }

    public final void c(c.a aVar) {
        if (aVar != null && !this.aCT) {
            this.aCT = true;
            if (this.aCS > 0) {
                if (aVar.getClientParams() == null) {
                    aVar.b(new y.b());
                }
                aVar.getClientParams().axF = System.currentTimeMillis() - this.aCS;
                this.aCS = -1L;
            }
            com.kwad.sdk.core.report.a.b(aVar.getAdTemplate(), aVar.getClientParams());
        }
    }
}
