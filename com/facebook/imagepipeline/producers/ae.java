package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class ae implements aj<com.facebook.imagepipeline.f.e> {
    private final com.facebook.common.memory.g pHk;
    private final af pJf;
    private final com.facebook.common.memory.a pzE;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.pHk = gVar;
        this.pzE = aVar;
        this.pJf = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        akVar.ezq().hv(akVar.getId(), "NetworkFetchProducer");
        final t d = this.pJf.d(kVar, akVar);
        this.pJf.a((af) d, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void f(InputStream inputStream, int i) throws IOException {
                ae.this.a(d, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void C(Throwable th) {
                ae.this.a(d, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void esD() {
                ae.this.b(d);
            }
        });
    }

    protected void a(t tVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i esP;
        if (i > 0) {
            esP = this.pHk.OW(i);
        } else {
            esP = this.pHk.esP();
        }
        byte[] bArr = this.pzE.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        esP.write(bArr, 0, read);
                        a(esP, tVar);
                        tVar.ezC().ba(ef(esP.size(), i));
                    }
                } else {
                    this.pJf.a((af) tVar, esP.size());
                    b(esP, tVar);
                    return;
                }
            } finally {
                this.pzE.release(bArr);
                esP.close();
            }
        }
    }

    protected static float ef(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    protected void a(com.facebook.common.memory.i iVar, t tVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(tVar) && uptimeMillis - tVar.ezE() >= 100) {
            tVar.iO(uptimeMillis);
            tVar.ezq().aW(tVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, tVar.ezF(), tVar.ezG(), tVar.ezC());
        }
    }

    protected void b(com.facebook.common.memory.i iVar, t tVar) {
        Map<String, String> b2 = b(tVar, iVar.size());
        am ezq = tVar.ezq();
        ezq.b(tVar.getId(), "NetworkFetchProducer", b2);
        ezq.M(tVar.getId(), "NetworkFetchProducer", true);
        a(iVar, tVar.ezF() | 1, tVar.ezG(), tVar.ezC());
    }

    private void a(com.facebook.common.memory.i iVar, int i, @Nullable com.facebook.imagepipeline.common.a aVar, k<com.facebook.imagepipeline.f.e> kVar) {
        com.facebook.imagepipeline.f.e eVar;
        com.facebook.common.references.a e = com.facebook.common.references.a.e(iVar.esQ());
        try {
            eVar = new com.facebook.imagepipeline.f.e(e);
            try {
                eVar.b(aVar);
                eVar.eyy();
                kVar.g(eVar, i);
                com.facebook.imagepipeline.f.e.e(eVar);
                com.facebook.common.references.a.c(e);
            } catch (Throwable th) {
                th = th;
                com.facebook.imagepipeline.f.e.e(eVar);
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
        tVar.ezq().a(tVar.getId(), "NetworkFetchProducer", th, (Map<String, String>) null);
        tVar.ezq().M(tVar.getId(), "NetworkFetchProducer", false);
        tVar.ezC().C(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(t tVar) {
        tVar.ezq().c(tVar.getId(), "NetworkFetchProducer", null);
        tVar.ezC().esD();
    }

    private boolean c(t tVar) {
        if (tVar.ezD().ezu()) {
            return this.pJf.a(tVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> b(t tVar, int i) {
        if (tVar.ezq().ZG(tVar.getId())) {
            return this.pJf.b(tVar, i);
        }
        return null;
    }
}
