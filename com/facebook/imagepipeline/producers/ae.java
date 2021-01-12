package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class ae implements aj<com.facebook.imagepipeline.f.e> {
    private final com.facebook.common.memory.a poT;
    private final com.facebook.common.memory.g pwB;
    private final af pyw;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.pwB = gVar;
        this.poT = aVar;
        this.pyw = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        akVar.ewQ().hm(akVar.getId(), "NetworkFetchProducer");
        final t d = this.pyw.d(kVar, akVar);
        this.pyw.a((af) d, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void f(InputStream inputStream, int i) throws IOException {
                ae.this.a(d, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void D(Throwable th) {
                ae.this.a(d, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void eqc() {
                ae.this.b(d);
            }
        });
    }

    protected void a(t tVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i eqo;
        if (i > 0) {
            eqo = this.pwB.OA(i);
        } else {
            eqo = this.pwB.eqo();
        }
        byte[] bArr = this.poT.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        eqo.write(bArr, 0, read);
                        a(eqo, tVar);
                        tVar.exc().aX(eh(eqo.size(), i));
                    }
                } else {
                    this.pyw.a((af) tVar, eqo.size());
                    b(eqo, tVar);
                    return;
                }
            } finally {
                this.poT.release(bArr);
                eqo.close();
            }
        }
    }

    protected static float eh(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    protected void a(com.facebook.common.memory.i iVar, t tVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(tVar) && uptimeMillis - tVar.exe() >= 100) {
            tVar.iL(uptimeMillis);
            tVar.ewQ().aV(tVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, tVar.exf(), tVar.exg(), tVar.exc());
        }
    }

    protected void b(com.facebook.common.memory.i iVar, t tVar) {
        Map<String, String> b2 = b(tVar, iVar.size());
        am ewQ = tVar.ewQ();
        ewQ.b(tVar.getId(), "NetworkFetchProducer", b2);
        ewQ.M(tVar.getId(), "NetworkFetchProducer", true);
        a(iVar, tVar.exf() | 1, tVar.exg(), tVar.exc());
    }

    private void a(com.facebook.common.memory.i iVar, int i, @Nullable com.facebook.imagepipeline.common.a aVar, k<com.facebook.imagepipeline.f.e> kVar) {
        com.facebook.imagepipeline.f.e eVar;
        com.facebook.common.references.a f = com.facebook.common.references.a.f(iVar.eqp());
        try {
            eVar = new com.facebook.imagepipeline.f.e(f);
            try {
                eVar.b(aVar);
                eVar.evX();
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
        tVar.ewQ().a(tVar.getId(), "NetworkFetchProducer", th, (Map<String, String>) null);
        tVar.ewQ().M(tVar.getId(), "NetworkFetchProducer", false);
        tVar.exc().D(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(t tVar) {
        tVar.ewQ().c(tVar.getId(), "NetworkFetchProducer", null);
        tVar.exc().eqc();
    }

    private boolean c(t tVar) {
        if (tVar.exd().ewU()) {
            return this.pyw.a(tVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> b(t tVar, int i) {
        if (tVar.ewQ().Ys(tVar.getId())) {
            return this.pyw.b(tVar, i);
        }
        return null;
    }
}
