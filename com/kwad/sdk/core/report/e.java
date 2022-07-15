package com.kwad.sdk.core.report;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public class e extends b<m, d> {
    public static volatile boolean a;
    public static volatile e b;
    public static q<m, d> c;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(@NonNull m mVar) {
        a(mVar, false);
    }

    public static void a(@NonNull m mVar, boolean z) {
        d().b(mVar, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.b
    /* renamed from: b */
    public d a(m mVar) {
        q<m, d> qVar = c;
        return (d) (qVar != null ? qVar.b() : super.a((e) mVar));
    }

    public static d b(List<m> list) {
        q<m, d> qVar = c;
        return qVar != null ? qVar.c() : new d(list);
    }

    private void b(final m mVar, boolean z) {
        if (mVar == null || !a) {
            return;
        }
        if (z || b(mVar.i)) {
            b.b(new i<m>() { // from class: com.kwad.sdk.core.report.e.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.report.i
                /* renamed from: b */
                public m a() {
                    return mVar.b();
                }
            });
        } else {
            b.a(new i<m>() { // from class: com.kwad.sdk.core.report.e.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.report.i
                /* renamed from: b */
                public m a() {
                    return mVar.b();
                }
            });
        }
    }

    public static boolean b(long j) {
        r rVar = (r) ServiceProvider.a(r.class);
        return rVar != null && rVar.a(j);
    }

    public static e d() {
        if (b == null) {
            synchronized (e.class) {
                if (b == null) {
                    b = new e();
                }
            }
        }
        b.e();
        return b;
    }

    private synchronized void e() {
        if (a) {
            return;
        }
        com.kwad.sdk.service.kwai.d dVar = (com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class);
        if (dVar == null) {
            return;
        }
        com.kwad.sdk.service.kwai.f fVar = (com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class);
        if (fVar == null) {
            return;
        }
        Context a2 = dVar.a();
        if (a2 == null) {
            return;
        }
        int a3 = fVar.a(a2);
        a(a2, a3);
        s.a(a2);
        s.a();
        com.kwad.sdk.core.d.b.a("BatchReporter", "cache type = " + a3);
        if (a3 == 2) {
            a(p.a(a2));
        }
        a = true;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.List] */
    /* JADX DEBUG: Return type fixed from 'com.kwad.sdk.core.network.g' to match base method */
    @Override // com.kwad.sdk.core.report.b
    public final /* synthetic */ d a(List<m> list) {
        return b(list);
    }

    @Override // com.kwad.sdk.core.report.b
    public final Runnable a(Context context, j<m> jVar, AtomicInteger atomicInteger) {
        v<m, d> a2;
        q<m, d> qVar = c;
        return (qVar == null || (a2 = qVar.a()) == null) ? super.a(context, jVar, atomicInteger) : a2;
    }
}
