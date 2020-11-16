package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class ae implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.common.memory.a oMZ;
    private final com.facebook.common.memory.g oUY;
    private final af oWW;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.oUY = gVar;
        this.oMZ = aVar;
        this.oWW = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        akVar.eqU().gZ(akVar.getId(), "NetworkFetchProducer");
        final t b = this.oWW.b(kVar, akVar);
        this.oWW.a((af) b, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void f(InputStream inputStream, int i) throws IOException {
                ae.this.a(b, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void E(Throwable th) {
                ae.this.a(b, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void ejX() {
                ae.this.b(b);
            }
        });
    }

    protected void a(t tVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i ekj;
        if (i > 0) {
            ekj = this.oUY.OV(i);
        } else {
            ekj = this.oUY.ekj();
        }
        byte[] bArr = this.oMZ.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        ekj.write(bArr, 0, read);
                        a(ekj, tVar);
                        tVar.erf().aU(ec(ekj.size(), i));
                    }
                } else {
                    this.oWW.b((af) tVar, ekj.size());
                    b(ekj, tVar);
                    return;
                }
            } finally {
                this.oMZ.release(bArr);
                ekj.close();
            }
        }
    }

    protected static float ec(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    protected void a(com.facebook.common.memory.i iVar, t tVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(tVar) && uptimeMillis - tVar.erh() >= 100) {
            tVar.hS(uptimeMillis);
            tVar.eqU().aO(tVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, tVar.eri(), tVar.erj(), tVar.erf());
        }
    }

    protected void b(com.facebook.common.memory.i iVar, t tVar) {
        Map<String, String> a2 = a(tVar, iVar.size());
        am eqU = tVar.eqU();
        eqU.a(tVar.getId(), "NetworkFetchProducer", a2);
        eqU.I(tVar.getId(), "NetworkFetchProducer", true);
        a(iVar, tVar.eri() | 1, tVar.erj(), tVar.erf());
    }

    private void a(com.facebook.common.memory.i iVar, int i, @Nullable com.facebook.imagepipeline.common.a aVar, k<com.facebook.imagepipeline.g.e> kVar) {
        com.facebook.imagepipeline.g.e eVar;
        com.facebook.common.references.a e = com.facebook.common.references.a.e(iVar.ekk());
        try {
            eVar = new com.facebook.imagepipeline.g.e(e);
            try {
                eVar.b(aVar);
                eVar.epY();
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
        tVar.eqU().a(tVar.getId(), "NetworkFetchProducer", th, (Map<String, String>) null);
        tVar.eqU().I(tVar.getId(), "NetworkFetchProducer", false);
        tVar.erf().E(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(t tVar) {
        tVar.eqU().b(tVar.getId(), "NetworkFetchProducer", null);
        tVar.erf().ejX();
    }

    private boolean c(t tVar) {
        if (tVar.erg().eqY()) {
            return this.oWW.a(tVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> a(t tVar, int i) {
        if (tVar.eqU().XX(tVar.getId())) {
            return this.oWW.a((af) tVar, i);
        }
        return null;
    }
}
