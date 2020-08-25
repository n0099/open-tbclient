package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public class ae implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.common.memory.a nkY;
    private final com.facebook.common.memory.g ntb;
    private final af nva;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.ntb = gVar;
        this.nkY = aVar;
        this.nva = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        akVar.dVp().gn(akVar.getId(), "NetworkFetchProducer");
        final t b = this.nva.b(kVar, akVar);
        this.nva.a((af) b, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void f(InputStream inputStream, int i) throws IOException {
                ae.this.a(b, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void E(Throwable th) {
                ae.this.a(b, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void dOu() {
                ae.this.b(b);
            }
        });
    }

    protected void a(t tVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i dOG;
        if (i > 0) {
            dOG = this.ntb.KV(i);
        } else {
            dOG = this.ntb.dOG();
        }
        byte[] bArr = this.nkY.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        dOG.write(bArr, 0, read);
                        a(dOG, tVar);
                        tVar.dVA().aD(dL(dOG.size(), i));
                    }
                } else {
                    this.nva.b((af) tVar, dOG.size());
                    b(dOG, tVar);
                    return;
                }
            } finally {
                this.nkY.release(bArr);
                dOG.close();
            }
        }
    }

    protected static float dL(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    protected void a(com.facebook.common.memory.i iVar, t tVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(tVar) && uptimeMillis - tVar.dVC() >= 100) {
            tVar.gv(uptimeMillis);
            tVar.dVp().aA(tVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, tVar.dVD(), tVar.dVE(), tVar.dVA());
        }
    }

    protected void b(com.facebook.common.memory.i iVar, t tVar) {
        Map<String, String> a = a(tVar, iVar.size());
        am dVp = tVar.dVp();
        dVp.a(tVar.getId(), "NetworkFetchProducer", a);
        dVp.F(tVar.getId(), "NetworkFetchProducer", true);
        a(iVar, tVar.dVD() | 1, tVar.dVE(), tVar.dVA());
    }

    private void a(com.facebook.common.memory.i iVar, int i, @Nullable com.facebook.imagepipeline.common.a aVar, k<com.facebook.imagepipeline.g.e> kVar) {
        com.facebook.imagepipeline.g.e eVar;
        com.facebook.common.references.a e = com.facebook.common.references.a.e(iVar.dOH());
        try {
            eVar = new com.facebook.imagepipeline.g.e(e);
            try {
                eVar.b(aVar);
                eVar.dUt();
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
        tVar.dVp().a(tVar.getId(), "NetworkFetchProducer", th, (Map<String, String>) null);
        tVar.dVp().F(tVar.getId(), "NetworkFetchProducer", false);
        tVar.dVA().E(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(t tVar) {
        tVar.dVp().b(tVar.getId(), "NetworkFetchProducer", null);
        tVar.dVA().dOu();
    }

    private boolean c(t tVar) {
        if (tVar.dVB().dVt()) {
            return this.nva.a(tVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> a(t tVar, int i) {
        if (tVar.dVp().UF(tVar.getId())) {
            return this.nva.a((af) tVar, i);
        }
        return null;
    }
}
