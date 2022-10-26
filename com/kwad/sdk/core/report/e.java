package com.kwad.sdk.core.report;

import android.content.Context;
import com.kwad.sdk.service.ServiceProvider;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class e extends b {
    public static volatile boolean HJ;
    public static volatile e ZU;
    public static q ZV;

    public static void a(m mVar) {
        a(mVar, false);
    }

    public static void a(m mVar, boolean z) {
        uu().b(mVar, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.b
    /* renamed from: b */
    public d a(m mVar) {
        q qVar = ZV;
        return (d) (qVar != null ? qVar.uD() : super.a((c) mVar));
    }

    private void b(final m mVar, boolean z) {
        if (mVar == null || !HJ) {
            return;
        }
        if (z || h(mVar.aai)) {
            ZU.b(new i() { // from class: com.kwad.sdk.core.report.e.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.report.i
                /* renamed from: uv */
                public m us() {
                    return mVar.uz();
                }
            });
        } else {
            ZU.a(new i() { // from class: com.kwad.sdk.core.report.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.report.i
                /* renamed from: uv */
                public m us() {
                    return mVar.uz();
                }
            });
        }
    }

    private synchronized void checkInit() {
        if (HJ) {
            return;
        }
        com.kwad.sdk.service.kwai.d dVar = (com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class);
        if (dVar == null) {
            return;
        }
        com.kwad.sdk.service.kwai.f fVar = (com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class);
        if (fVar == null) {
            return;
        }
        Context context = dVar.getContext();
        if (context == null) {
            return;
        }
        int af = fVar.af(context);
        e(context, af);
        s.init(context);
        s.uF();
        com.kwad.sdk.core.e.b.d("BatchReporter", "cache type = " + af);
        if (af == 2) {
            a(p.bx(context));
        }
        HJ = true;
    }

    public static boolean h(long j) {
        r rVar = (r) ServiceProvider.get(r.class);
        return rVar != null && rVar.h(j);
    }

    public static d p(List list) {
        q qVar = ZV;
        return qVar != null ? (d) qVar.uE() : new d(list);
    }

    public static e uu() {
        if (ZU == null) {
            synchronized (e.class) {
                if (ZU == null) {
                    ZU = new e();
                }
            }
        }
        ZU.checkInit();
        return ZU;
    }

    @Override // com.kwad.sdk.core.report.b
    public final Runnable a(Context context, j jVar, AtomicInteger atomicInteger) {
        v uC;
        q qVar = ZV;
        return (qVar == null || (uC = qVar.uC()) == null) ? super.a(context, jVar, atomicInteger) : uC;
    }

    @Override // com.kwad.sdk.core.report.b
    public final /* synthetic */ com.kwad.sdk.core.network.g o(List list) {
        return p(list);
    }
}
