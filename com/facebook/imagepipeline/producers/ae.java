package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class ae implements aj<com.facebook.imagepipeline.f.e> {
    private final af pBq;
    private final com.facebook.common.memory.a pto;
    private final com.facebook.common.memory.g pzv;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.pzv = gVar;
        this.pto = aVar;
        this.pBq = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        akVar.eAe().hm(akVar.getId(), "NetworkFetchProducer");
        final t d = this.pBq.d(kVar, akVar);
        this.pBq.a((af) d, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void f(InputStream inputStream, int i) throws IOException {
                ae.this.a(d, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void D(Throwable th) {
                ae.this.a(d, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void etQ() {
                ae.this.b(d);
            }
        });
    }

    protected void a(t tVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i eub;
        if (i > 0) {
            eub = this.pzv.Qc(i);
        } else {
            eub = this.pzv.eub();
        }
        byte[] bArr = this.pto.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        eub.write(bArr, 0, read);
                        a(eub, tVar);
                        tVar.eAq().aX(ef(eub.size(), i));
                    }
                } else {
                    this.pBq.a((af) tVar, eub.size());
                    b(eub, tVar);
                    return;
                }
            } finally {
                this.pto.release(bArr);
                eub.close();
            }
        }
    }

    protected static float ef(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    protected void a(com.facebook.common.memory.i iVar, t tVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(tVar) && uptimeMillis - tVar.eAs() >= 100) {
            tVar.iI(uptimeMillis);
            tVar.eAe().aW(tVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, tVar.eAt(), tVar.eAu(), tVar.eAq());
        }
    }

    protected void b(com.facebook.common.memory.i iVar, t tVar) {
        Map<String, String> b2 = b(tVar, iVar.size());
        am eAe = tVar.eAe();
        eAe.b(tVar.getId(), "NetworkFetchProducer", b2);
        eAe.M(tVar.getId(), "NetworkFetchProducer", true);
        a(iVar, tVar.eAt() | 1, tVar.eAu(), tVar.eAq());
    }

    private void a(com.facebook.common.memory.i iVar, int i, @Nullable com.facebook.imagepipeline.common.a aVar, k<com.facebook.imagepipeline.f.e> kVar) {
        com.facebook.imagepipeline.f.e eVar;
        com.facebook.common.references.a f = com.facebook.common.references.a.f(iVar.euc());
        try {
            eVar = new com.facebook.imagepipeline.f.e(f);
            try {
                eVar.b(aVar);
                eVar.ezl();
                kVar.g(eVar, i);
                com.facebook.imagepipeline.f.e.e(eVar);
                com.facebook.common.references.a.c(f);
            } catch (Throwable th) {
                th = th;
                com.facebook.imagepipeline.f.e.e(eVar);
                com.facebook.common.references.a.c(f);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            eVar = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(t tVar, Throwable th) {
        tVar.eAe().a(tVar.getId(), "NetworkFetchProducer", th, (Map<String, String>) null);
        tVar.eAe().M(tVar.getId(), "NetworkFetchProducer", false);
        tVar.eAq().D(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(t tVar) {
        tVar.eAe().c(tVar.getId(), "NetworkFetchProducer", null);
        tVar.eAq().etQ();
    }

    private boolean c(t tVar) {
        if (tVar.eAr().eAi()) {
            return this.pBq.a(tVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> b(t tVar, int i) {
        if (tVar.eAe().ZA(tVar.getId())) {
            return this.pBq.b(tVar, i);
        }
        return null;
    }
}
