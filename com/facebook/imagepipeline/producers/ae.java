package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes25.dex */
public class ae implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.common.memory.g nDr;
    private final af nFp;
    private final com.facebook.common.memory.a nvq;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.nDr = gVar;
        this.nvq = aVar;
        this.nFp = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        akVar.dZw().gA(akVar.getId(), "NetworkFetchProducer");
        final t b = this.nFp.b(kVar, akVar);
        this.nFp.a((af) b, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void f(InputStream inputStream, int i) throws IOException {
                ae.this.a(b, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void E(Throwable th) {
                ae.this.a(b, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void dSB() {
                ae.this.b(b);
            }
        });
    }

    protected void a(t tVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i dSN;
        if (i > 0) {
            dSN = this.nDr.LA(i);
        } else {
            dSN = this.nDr.dSN();
        }
        byte[] bArr = this.nvq.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        dSN.write(bArr, 0, read);
                        a(dSN, tVar);
                        tVar.dZH().aD(dP(dSN.size(), i));
                    }
                } else {
                    this.nFp.b((af) tVar, dSN.size());
                    b(dSN, tVar);
                    return;
                }
            } finally {
                this.nvq.release(bArr);
                dSN.close();
            }
        }
    }

    protected static float dP(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    protected void a(com.facebook.common.memory.i iVar, t tVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(tVar) && uptimeMillis - tVar.dZJ() >= 100) {
            tVar.gL(uptimeMillis);
            tVar.dZw().aA(tVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, tVar.dZK(), tVar.dZL(), tVar.dZH());
        }
    }

    protected void b(com.facebook.common.memory.i iVar, t tVar) {
        Map<String, String> a = a(tVar, iVar.size());
        am dZw = tVar.dZw();
        dZw.a(tVar.getId(), "NetworkFetchProducer", a);
        dZw.F(tVar.getId(), "NetworkFetchProducer", true);
        a(iVar, tVar.dZK() | 1, tVar.dZL(), tVar.dZH());
    }

    private void a(com.facebook.common.memory.i iVar, int i, @Nullable com.facebook.imagepipeline.common.a aVar, k<com.facebook.imagepipeline.g.e> kVar) {
        com.facebook.imagepipeline.g.e eVar;
        com.facebook.common.references.a e = com.facebook.common.references.a.e(iVar.dSO());
        try {
            eVar = new com.facebook.imagepipeline.g.e(e);
            try {
                eVar.b(aVar);
                eVar.dYA();
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
        tVar.dZw().a(tVar.getId(), "NetworkFetchProducer", th, (Map<String, String>) null);
        tVar.dZw().F(tVar.getId(), "NetworkFetchProducer", false);
        tVar.dZH().E(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(t tVar) {
        tVar.dZw().b(tVar.getId(), "NetworkFetchProducer", null);
        tVar.dZH().dSB();
    }

    private boolean c(t tVar) {
        if (tVar.dZI().dZA()) {
            return this.nFp.a(tVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> a(t tVar, int i) {
        if (tVar.dZw().Vh(tVar.getId())) {
            return this.nFp.a((af) tVar, i);
        }
        return null;
    }
}
