package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class ae implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.common.memory.a mRb;
    private final com.facebook.common.memory.g mZk;
    private final af nbi;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.mZk = gVar;
        this.mRb = aVar;
        this.nbi = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        akVar.dJp().fW(akVar.getId(), "NetworkFetchProducer");
        final t b = this.nbi.b(kVar, akVar);
        this.nbi.a((af) b, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void g(InputStream inputStream, int i) throws IOException {
                ae.this.a(b, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void F(Throwable th) {
                ae.this.a(b, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void dCt() {
                ae.this.b(b);
            }
        });
    }

    protected void a(t tVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i dCF;
        if (i > 0) {
            dCF = this.mZk.Ir(i);
        } else {
            dCF = this.mZk.dCF();
        }
        byte[] bArr = this.mRb.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        dCF.write(bArr, 0, read);
                        a(dCF, tVar);
                        tVar.dJA().ax(dD(dCF.size(), i));
                    }
                } else {
                    this.nbi.b((af) tVar, dCF.size());
                    b(dCF, tVar);
                    return;
                }
            } finally {
                this.mRb.release(bArr);
                dCF.close();
            }
        }
    }

    protected static float dD(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    protected void a(com.facebook.common.memory.i iVar, t tVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(tVar) && uptimeMillis - tVar.dJC() >= 100) {
            tVar.gi(uptimeMillis);
            tVar.dJp().aA(tVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, tVar.dJD(), tVar.dJE(), tVar.dJA());
        }
    }

    protected void b(com.facebook.common.memory.i iVar, t tVar) {
        Map<String, String> a = a(tVar, iVar.size());
        am dJp = tVar.dJp();
        dJp.a(tVar.getId(), "NetworkFetchProducer", a);
        dJp.G(tVar.getId(), "NetworkFetchProducer", true);
        a(iVar, tVar.dJD() | 1, tVar.dJE(), tVar.dJA());
    }

    private void a(com.facebook.common.memory.i iVar, int i, @Nullable com.facebook.imagepipeline.common.a aVar, k<com.facebook.imagepipeline.g.e> kVar) {
        com.facebook.imagepipeline.g.e eVar;
        com.facebook.common.references.a e = com.facebook.common.references.a.e(iVar.dCG());
        try {
            eVar = new com.facebook.imagepipeline.g.e(e);
            try {
                eVar.b(aVar);
                eVar.dIt();
                kVar.h(eVar, i);
                com.facebook.imagepipeline.g.e.e(eVar);
                com.facebook.common.references.a.c(e);
            } catch (Throwable th) {
                th = th;
                com.facebook.imagepipeline.g.e.e(eVar);
                com.facebook.common.references.a.c(e);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            eVar = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(t tVar, Throwable th) {
        tVar.dJp().a(tVar.getId(), "NetworkFetchProducer", th, (Map<String, String>) null);
        tVar.dJp().G(tVar.getId(), "NetworkFetchProducer", false);
        tVar.dJA().F(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(t tVar) {
        tVar.dJp().b(tVar.getId(), "NetworkFetchProducer", null);
        tVar.dJA().dCt();
    }

    private boolean c(t tVar) {
        if (tVar.dJB().dJt()) {
            return this.nbi.a(tVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> a(t tVar, int i) {
        if (tVar.dJp().RB(tVar.getId())) {
            return this.nbi.a((af) tVar, i);
        }
        return null;
    }
}
