package com.kwad.sdk.core.report;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public class e extends b<m, d> {
    public static volatile boolean HJ;
    public static volatile e ZU;
    public static q<m, d> ZV;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(@NonNull m mVar) {
        a(mVar, false);
    }

    public static void a(@NonNull m mVar, boolean z) {
        uu().b(mVar, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.b
    /* renamed from: b */
    public d a(m mVar) {
        q<m, d> qVar = ZV;
        return (d) (qVar != null ? qVar.uD() : super.a((e) mVar));
    }

    private void b(final m mVar, boolean z) {
        if (mVar == null || !HJ) {
            return;
        }
        if (z || h(mVar.aai)) {
            ZU.b(new i<m>() { // from class: com.kwad.sdk.core.report.e.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.report.i
                /* renamed from: uv */
                public m us() {
                    return mVar.uz();
                }
            });
        } else {
            ZU.a(new i<m>() { // from class: com.kwad.sdk.core.report.e.2
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

    public static d p(List<m> list) {
        q<m, d> qVar = ZV;
        return qVar != null ? qVar.uE() : new d(list);
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
    public final Runnable a(Context context, j<m> jVar, AtomicInteger atomicInteger) {
        v<m, d> uC;
        q<m, d> qVar = ZV;
        return (qVar == null || (uC = qVar.uC()) == null) ? super.a(context, jVar, atomicInteger) : uC;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.List] */
    /* JADX DEBUG: Return type fixed from 'com.kwad.sdk.core.network.g' to match base method */
    @Override // com.kwad.sdk.core.report.b
    public final /* synthetic */ d o(List<m> list) {
        return p(list);
    }
}
