package com.kwad.sdk.core.webview.b.b;

import androidx.annotation.NonNull;
import com.kwad.framework.filedownloader.m;
import com.kwad.framework.filedownloader.r;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.m.l;
/* loaded from: classes10.dex */
public final class a {

    /* renamed from: com.kwad.sdk.core.webview.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0714a {
        void c(com.kwad.sdk.h.a.b bVar);

        void d(com.kwad.sdk.h.a.b bVar);

        void e(com.kwad.sdk.h.a.b bVar);
    }

    public static void a(final com.kwad.sdk.h.a.b bVar, @NonNull final InterfaceC0714a interfaceC0714a) {
        c.d("HybridDownloader", "reportHybrid: download+++url " + bVar.packageUrl);
        interfaceC0714a.c(bVar);
        bVar.ar(System.currentTimeMillis());
        com.kwad.sdk.core.webview.b.c.b.a(bVar, 1);
        r.al(l.My());
        r.uK();
        r.aV(bVar.packageUrl).e(bVar).aS(bVar.aGU).ba(true).a(new m() { // from class: com.kwad.sdk.core.webview.b.b.a.1
            @Override // com.kwad.framework.filedownloader.m, com.kwad.framework.filedownloader.i
            public final void a(com.kwad.framework.filedownloader.a aVar, Throwable th) {
                super.a(aVar, th);
                com.kwad.sdk.core.webview.b.c.b.a(bVar, 0, 1, th.getMessage());
                InterfaceC0714a.this.e((com.kwad.sdk.h.a.b) aVar.getTag());
            }

            @Override // com.kwad.framework.filedownloader.m, com.kwad.framework.filedownloader.i
            public final void c(com.kwad.framework.filedownloader.a aVar) {
                super.c(aVar);
                if (aVar.tL() == -3) {
                    InterfaceC0714a.this.d(bVar);
                    return;
                }
                InterfaceC0714a.this.e(bVar);
                com.kwad.sdk.h.a.b bVar2 = bVar;
                com.kwad.sdk.core.webview.b.c.b.a(bVar2, 0, 1, "task.getStatus()=" + ((int) aVar.tL()));
            }
        }).start();
    }
}
