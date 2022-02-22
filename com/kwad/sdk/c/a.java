package com.kwad.sdk.c;

import android.content.Context;
import com.kwad.sdk.c.a.b;
import com.kwad.sdk.c.kwai.f;
import com.kwai.filedownloader.i;
import com.kwai.filedownloader.m;
import com.kwai.filedownloader.r;
/* loaded from: classes4.dex */
public class a implements com.kwad.sdk.c.a.b {
    public final Context a;

    public a(Context context) {
        this.a = context;
    }

    @Override // com.kwad.sdk.c.a.b
    public void a(final com.kwad.sdk.c.kwai.d dVar, final b.a aVar) {
        com.kwad.sdk.c.b.b.a(dVar, 1);
        String d2 = dVar.d();
        String c2 = new f(d2).c();
        if (c2 == null) {
            return;
        }
        dVar.d(c2.substring(0, c2.indexOf(".zip")));
        String b2 = com.kwad.sdk.c.b.a.b(this.a, dVar.f());
        dVar.c(b2);
        r.a().a(d2).a(dVar).a(b2).a((i) new m() { // from class: com.kwad.sdk.c.a.1
            @Override // com.kwai.filedownloader.m, com.kwai.filedownloader.i
            public void a(com.kwai.filedownloader.a aVar2, Throwable th) {
                super.a(aVar2, th);
                com.kwad.sdk.c.b.b.a(dVar, 1, th.getMessage());
                b.a aVar3 = aVar;
                if (aVar3 != null) {
                    aVar3.b((com.kwad.sdk.c.kwai.d) aVar2.z());
                }
            }

            @Override // com.kwai.filedownloader.m, com.kwai.filedownloader.i
            public void c(com.kwai.filedownloader.a aVar2) {
                super.c(aVar2);
                if (aVar != null && aVar2.v() == -3) {
                    aVar.a((com.kwad.sdk.c.kwai.d) aVar2.z());
                    return;
                }
                b.a aVar3 = aVar;
                if (aVar3 != null) {
                    aVar3.b((com.kwad.sdk.c.kwai.d) aVar2.z());
                    com.kwad.sdk.c.kwai.d dVar2 = dVar;
                    com.kwad.sdk.c.b.b.a(dVar2, 1, "task.getStatus()=" + ((int) aVar2.v()));
                }
            }
        }).e();
    }
}
