package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class ae implements aj<com.facebook.imagepipeline.f.e> {
    private final com.facebook.common.memory.a pcj;
    private final com.facebook.common.memory.g pjQ;
    private final af plN;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.pjQ = gVar;
        this.pcj = aVar;
        this.plN = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        akVar.ewx().hh(akVar.getId(), "NetworkFetchProducer");
        final t d = this.plN.d(kVar, akVar);
        this.plN.a((af) d, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void f(InputStream inputStream, int i) throws IOException {
                ae.this.a(d, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void E(Throwable th) {
                ae.this.a(d, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void epN() {
                ae.this.b(d);
            }
        });
    }

    protected void a(t tVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i epZ;
        if (i > 0) {
            epZ = this.pjQ.PT(i);
        } else {
            epZ = this.pjQ.epZ();
        }
        byte[] bArr = this.pcj.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        epZ.write(bArr, 0, read);
                        a(epZ, tVar);
                        tVar.ewJ().aV(eh(epZ.size(), i));
                    }
                } else {
                    this.plN.a((af) tVar, epZ.size());
                    b(epZ, tVar);
                    return;
                }
            } finally {
                this.pcj.release(bArr);
                epZ.close();
            }
        }
    }

    protected static float eh(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    protected void a(com.facebook.common.memory.i iVar, t tVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(tVar) && uptimeMillis - tVar.ewL() >= 100) {
            tVar.ix(uptimeMillis);
            tVar.ewx().aR(tVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, tVar.ewM(), tVar.ewN(), tVar.ewJ());
        }
    }

    protected void b(com.facebook.common.memory.i iVar, t tVar) {
        Map<String, String> b = b(tVar, iVar.size());
        am ewx = tVar.ewx();
        ewx.a(tVar.getId(), "NetworkFetchProducer", b);
        ewx.J(tVar.getId(), "NetworkFetchProducer", true);
        a(iVar, tVar.ewM() | 1, tVar.ewN(), tVar.ewJ());
    }

    private void a(com.facebook.common.memory.i iVar, int i, @Nullable com.facebook.imagepipeline.common.a aVar, k<com.facebook.imagepipeline.f.e> kVar) {
        com.facebook.imagepipeline.f.e eVar;
        com.facebook.common.references.a e = com.facebook.common.references.a.e(iVar.eqa());
        try {
            eVar = new com.facebook.imagepipeline.f.e(e);
            try {
                eVar.b(aVar);
                eVar.evE();
                kVar.h(eVar, i);
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
        tVar.ewx().a(tVar.getId(), "NetworkFetchProducer", th, (Map<String, String>) null);
        tVar.ewx().J(tVar.getId(), "NetworkFetchProducer", false);
        tVar.ewJ().E(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(t tVar) {
        tVar.ewx().b(tVar.getId(), "NetworkFetchProducer", null);
        tVar.ewJ().epN();
    }

    private boolean c(t tVar) {
        if (tVar.ewK().ewB()) {
            return this.plN.a(tVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> b(t tVar, int i) {
        if (tVar.ewx().Zq(tVar.getId())) {
            return this.plN.b(tVar, i);
        }
        return null;
    }
}
