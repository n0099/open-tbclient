package com.kwad.components.a.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwai.filedownloader.m;
import com.kwai.filedownloader.r;
/* loaded from: classes10.dex */
public final class a {

    /* renamed from: com.kwad.components.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0586a {
        void c(com.kwad.sdk.e.kwai.b bVar);

        void d(com.kwad.sdk.e.kwai.b bVar);

        void e(com.kwad.sdk.e.kwai.b bVar);
    }

    public static void a(Context context, final com.kwad.sdk.e.kwai.b bVar, @NonNull final InterfaceC0586a interfaceC0586a) {
        com.kwad.sdk.core.e.b.d("HybridDownloader", "reportHybrid: download+++url " + bVar.packageUrl);
        interfaceC0586a.c(bVar);
        bVar.N(System.currentTimeMillis());
        com.kwad.components.a.b.b.a(bVar, 1);
        r.dD(context);
        r.CZ();
        r.eq(bVar.packageUrl).g(bVar).en(bVar.aiv).bz(true).a(new m() { // from class: com.kwad.components.a.a.a.1
            @Override // com.kwai.filedownloader.m, com.kwai.filedownloader.i
            public final void a(com.kwai.filedownloader.a aVar, Throwable th) {
                super.a(aVar, th);
                com.kwad.components.a.b.b.a(bVar, 0, 1, th.getMessage());
                InterfaceC0586a.this.e((com.kwad.sdk.e.kwai.b) aVar.getTag());
            }

            @Override // com.kwai.filedownloader.m, com.kwai.filedownloader.i
            public final void c(com.kwai.filedownloader.a aVar) {
                super.c(aVar);
                if (aVar.Ca() == -3) {
                    InterfaceC0586a.this.d(bVar);
                    return;
                }
                InterfaceC0586a.this.e(bVar);
                com.kwad.sdk.e.kwai.b bVar2 = bVar;
                com.kwad.components.a.b.b.a(bVar2, 0, 1, "task.getStatus()=" + ((int) aVar.Ca()));
            }
        }).start();
    }
}
