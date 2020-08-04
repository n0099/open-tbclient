package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class ae implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.common.memory.a mRe;
    private final com.facebook.common.memory.g mZm;
    private final af nbk;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.mZm = gVar;
        this.mRe = aVar;
        this.nbk = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        akVar.dJq().fW(akVar.getId(), "NetworkFetchProducer");
        final t b = this.nbk.b(kVar, akVar);
        this.nbk.a((af) b, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void g(InputStream inputStream, int i) throws IOException {
                ae.this.a(b, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void F(Throwable th) {
                ae.this.a(b, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void dCu() {
                ae.this.b(b);
            }
        });
    }

    protected void a(t tVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i dCG;
        if (i > 0) {
            dCG = this.mZm.Ir(i);
        } else {
            dCG = this.mZm.dCG();
        }
        byte[] bArr = this.mRe.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        dCG.write(bArr, 0, read);
                        a(dCG, tVar);
                        tVar.dJB().ax(dD(dCG.size(), i));
                    }
                } else {
                    this.nbk.b((af) tVar, dCG.size());
                    b(dCG, tVar);
                    return;
                }
            } finally {
                this.mRe.release(bArr);
                dCG.close();
            }
        }
    }

    protected static float dD(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    protected void a(com.facebook.common.memory.i iVar, t tVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(tVar) && uptimeMillis - tVar.dJD() >= 100) {
            tVar.gi(uptimeMillis);
            tVar.dJq().aA(tVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, tVar.dJE(), tVar.dJF(), tVar.dJB());
        }
    }

    protected void b(com.facebook.common.memory.i iVar, t tVar) {
        Map<String, String> a = a(tVar, iVar.size());
        am dJq = tVar.dJq();
        dJq.a(tVar.getId(), "NetworkFetchProducer", a);
        dJq.G(tVar.getId(), "NetworkFetchProducer", true);
        a(iVar, tVar.dJE() | 1, tVar.dJF(), tVar.dJB());
    }

    private void a(com.facebook.common.memory.i iVar, int i, @Nullable com.facebook.imagepipeline.common.a aVar, k<com.facebook.imagepipeline.g.e> kVar) {
        com.facebook.imagepipeline.g.e eVar;
        com.facebook.common.references.a e = com.facebook.common.references.a.e(iVar.dCH());
        try {
            eVar = new com.facebook.imagepipeline.g.e(e);
            try {
                eVar.b(aVar);
                eVar.dIu();
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
        tVar.dJq().a(tVar.getId(), "NetworkFetchProducer", th, (Map<String, String>) null);
        tVar.dJq().G(tVar.getId(), "NetworkFetchProducer", false);
        tVar.dJB().F(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(t tVar) {
        tVar.dJq().b(tVar.getId(), "NetworkFetchProducer", null);
        tVar.dJB().dCu();
    }

    private boolean c(t tVar) {
        if (tVar.dJC().dJu()) {
            return this.nbk.a(tVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> a(t tVar, int i) {
        if (tVar.dJq().RB(tVar.getId())) {
            return this.nbk.a((af) tVar, i);
        }
        return null;
    }
}
