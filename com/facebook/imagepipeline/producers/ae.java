package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class ae implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.common.memory.a oCc;
    private final com.facebook.common.memory.g oKc;
    private final af oMa;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.oKc = gVar;
        this.oCc = aVar;
        this.oMa = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        akVar.eng().gX(akVar.getId(), "NetworkFetchProducer");
        final t b = this.oMa.b(kVar, akVar);
        this.oMa.a((af) b, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void f(InputStream inputStream, int i) throws IOException {
                ae.this.a(b, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void E(Throwable th) {
                ae.this.a(b, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void egk() {
                ae.this.b(b);
            }
        });
    }

    protected void a(t tVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i egw;
        if (i > 0) {
            egw = this.oKc.NX(i);
        } else {
            egw = this.oKc.egw();
        }
        byte[] bArr = this.oCc.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        egw.write(bArr, 0, read);
                        a(egw, tVar);
                        tVar.enr().aL(dY(egw.size(), i));
                    }
                } else {
                    this.oMa.b((af) tVar, egw.size());
                    b(egw, tVar);
                    return;
                }
            } finally {
                this.oCc.release(bArr);
                egw.close();
            }
        }
    }

    protected static float dY(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    protected void a(com.facebook.common.memory.i iVar, t tVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(tVar) && uptimeMillis - tVar.ent() >= 100) {
            tVar.ht(uptimeMillis);
            tVar.eng().aN(tVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, tVar.enu(), tVar.env(), tVar.enr());
        }
    }

    protected void b(com.facebook.common.memory.i iVar, t tVar) {
        Map<String, String> a2 = a(tVar, iVar.size());
        am eng = tVar.eng();
        eng.a(tVar.getId(), "NetworkFetchProducer", a2);
        eng.G(tVar.getId(), "NetworkFetchProducer", true);
        a(iVar, tVar.enu() | 1, tVar.env(), tVar.enr());
    }

    private void a(com.facebook.common.memory.i iVar, int i, @Nullable com.facebook.imagepipeline.common.a aVar, k<com.facebook.imagepipeline.g.e> kVar) {
        com.facebook.imagepipeline.g.e eVar;
        com.facebook.common.references.a e = com.facebook.common.references.a.e(iVar.egx());
        try {
            eVar = new com.facebook.imagepipeline.g.e(e);
            try {
                eVar.b(aVar);
                eVar.emj();
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
        tVar.eng().a(tVar.getId(), "NetworkFetchProducer", th, (Map<String, String>) null);
        tVar.eng().G(tVar.getId(), "NetworkFetchProducer", false);
        tVar.enr().E(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(t tVar) {
        tVar.eng().b(tVar.getId(), "NetworkFetchProducer", null);
        tVar.enr().egk();
    }

    private boolean c(t tVar) {
        if (tVar.ens().enk()) {
            return this.oMa.a(tVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> a(t tVar, int i) {
        if (tVar.eng().XI(tVar.getId())) {
            return this.oMa.a((af) tVar, i);
        }
        return null;
    }
}
