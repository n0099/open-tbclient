package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class ae implements aj<com.facebook.imagepipeline.f.e> {
    private final com.facebook.common.memory.g pGK;
    private final af pIF;
    private final com.facebook.common.memory.a pze;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.pGK = gVar;
        this.pze = aVar;
        this.pIF = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        akVar.ezi().ht(akVar.getId(), "NetworkFetchProducer");
        final t d = this.pIF.d(kVar, akVar);
        this.pIF.a((af) d, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void f(InputStream inputStream, int i) throws IOException {
                ae.this.a(d, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void C(Throwable th) {
                ae.this.a(d, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void esv() {
                ae.this.b(d);
            }
        });
    }

    protected void a(t tVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i esH;
        if (i > 0) {
            esH = this.pGK.OV(i);
        } else {
            esH = this.pGK.esH();
        }
        byte[] bArr = this.pze.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        esH.write(bArr, 0, read);
                        a(esH, tVar);
                        tVar.ezu().ba(ee(esH.size(), i));
                    }
                } else {
                    this.pIF.a((af) tVar, esH.size());
                    b(esH, tVar);
                    return;
                }
            } finally {
                this.pze.release(bArr);
                esH.close();
            }
        }
    }

    protected static float ee(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    protected void a(com.facebook.common.memory.i iVar, t tVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(tVar) && uptimeMillis - tVar.ezw() >= 100) {
            tVar.iO(uptimeMillis);
            tVar.ezi().aW(tVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, tVar.ezx(), tVar.ezy(), tVar.ezu());
        }
    }

    protected void b(com.facebook.common.memory.i iVar, t tVar) {
        Map<String, String> b2 = b(tVar, iVar.size());
        am ezi = tVar.ezi();
        ezi.b(tVar.getId(), "NetworkFetchProducer", b2);
        ezi.M(tVar.getId(), "NetworkFetchProducer", true);
        a(iVar, tVar.ezx() | 1, tVar.ezy(), tVar.ezu());
    }

    private void a(com.facebook.common.memory.i iVar, int i, @Nullable com.facebook.imagepipeline.common.a aVar, k<com.facebook.imagepipeline.f.e> kVar) {
        com.facebook.imagepipeline.f.e eVar;
        com.facebook.common.references.a e = com.facebook.common.references.a.e(iVar.esI());
        try {
            eVar = new com.facebook.imagepipeline.f.e(e);
            try {
                eVar.b(aVar);
                eVar.eyq();
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
        tVar.ezi().a(tVar.getId(), "NetworkFetchProducer", th, (Map<String, String>) null);
        tVar.ezi().M(tVar.getId(), "NetworkFetchProducer", false);
        tVar.ezu().C(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(t tVar) {
        tVar.ezi().c(tVar.getId(), "NetworkFetchProducer", null);
        tVar.ezu().esv();
    }

    private boolean c(t tVar) {
        if (tVar.ezv().ezm()) {
            return this.pIF.a(tVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> b(t tVar, int i) {
        if (tVar.ezi().Zu(tVar.getId())) {
            return this.pIF.b(tVar, i);
        }
        return null;
    }
}
