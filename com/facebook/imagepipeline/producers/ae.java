package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class ae implements aj<com.facebook.imagepipeline.f.e> {
    private final com.facebook.common.memory.g pBc;
    private final af pCX;
    private final com.facebook.common.memory.a ptw;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.pBc = gVar;
        this.ptw = aVar;
        this.pCX = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        akVar.eAI().hn(akVar.getId(), "NetworkFetchProducer");
        final t d = this.pCX.d(kVar, akVar);
        this.pCX.a((af) d, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void f(InputStream inputStream, int i) throws IOException {
                ae.this.a(d, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void D(Throwable th) {
                ae.this.a(d, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void etW() {
                ae.this.b(d);
            }
        });
    }

    protected void a(t tVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i eui;
        if (i > 0) {
            eui = this.pBc.Qh(i);
        } else {
            eui = this.pBc.eui();
        }
        byte[] bArr = this.ptw.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        eui.write(bArr, 0, read);
                        a(eui, tVar);
                        tVar.eAU().aX(eh(eui.size(), i));
                    }
                } else {
                    this.pCX.a((af) tVar, eui.size());
                    b(eui, tVar);
                    return;
                }
            } finally {
                this.ptw.release(bArr);
                eui.close();
            }
        }
    }

    protected static float eh(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    protected void a(com.facebook.common.memory.i iVar, t tVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(tVar) && uptimeMillis - tVar.eAW() >= 100) {
            tVar.iL(uptimeMillis);
            tVar.eAI().aW(tVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, tVar.eAX(), tVar.eAY(), tVar.eAU());
        }
    }

    protected void b(com.facebook.common.memory.i iVar, t tVar) {
        Map<String, String> b2 = b(tVar, iVar.size());
        am eAI = tVar.eAI();
        eAI.b(tVar.getId(), "NetworkFetchProducer", b2);
        eAI.M(tVar.getId(), "NetworkFetchProducer", true);
        a(iVar, tVar.eAX() | 1, tVar.eAY(), tVar.eAU());
    }

    private void a(com.facebook.common.memory.i iVar, int i, @Nullable com.facebook.imagepipeline.common.a aVar, k<com.facebook.imagepipeline.f.e> kVar) {
        com.facebook.imagepipeline.f.e eVar;
        com.facebook.common.references.a f = com.facebook.common.references.a.f(iVar.euj());
        try {
            eVar = new com.facebook.imagepipeline.f.e(f);
            try {
                eVar.b(aVar);
                eVar.ezP();
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
        tVar.eAI().a(tVar.getId(), "NetworkFetchProducer", th, (Map<String, String>) null);
        tVar.eAI().M(tVar.getId(), "NetworkFetchProducer", false);
        tVar.eAU().D(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(t tVar) {
        tVar.eAI().c(tVar.getId(), "NetworkFetchProducer", null);
        tVar.eAU().etW();
    }

    private boolean c(t tVar) {
        if (tVar.eAV().eAM()) {
            return this.pCX.a(tVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> b(t tVar, int i) {
        if (tVar.eAI().ZA(tVar.getId())) {
            return this.pCX.b(tVar, i);
        }
        return null;
    }
}
