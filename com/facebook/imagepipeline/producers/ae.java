package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class ae implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.common.memory.a mlM;
    private final com.facebook.common.memory.g mtR;
    private final af mvP;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.mtR = gVar;
        this.mlM = aVar;
        this.mvP = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        akVar.dBj().fK(akVar.getId(), "NetworkFetchProducer");
        final t b = this.mvP.b(kVar, akVar);
        this.mvP.a((af) b, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void g(InputStream inputStream, int i) throws IOException {
                ae.this.a(b, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void G(Throwable th) {
                ae.this.a(b, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void dum() {
                ae.this.b(b);
            }
        });
    }

    protected void a(t tVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i duy;
        if (i > 0) {
            duy = this.mtR.GN(i);
        } else {
            duy = this.mtR.duy();
        }
        byte[] bArr = this.mlM.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        duy.write(bArr, 0, read);
                        a(duy, tVar);
                        tVar.dBu().at(ds(duy.size(), i));
                    }
                } else {
                    this.mvP.b((af) tVar, duy.size());
                    b(duy, tVar);
                    return;
                }
            } finally {
                this.mlM.release(bArr);
                duy.close();
            }
        }
    }

    protected static float ds(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    protected void a(com.facebook.common.memory.i iVar, t tVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(tVar) && uptimeMillis - tVar.dBw() >= 100) {
            tVar.fQ(uptimeMillis);
            tVar.dBj().aA(tVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, tVar.dBx(), tVar.dBy(), tVar.dBu());
        }
    }

    protected void b(com.facebook.common.memory.i iVar, t tVar) {
        Map<String, String> a = a(tVar, iVar.size());
        am dBj = tVar.dBj();
        dBj.a(tVar.getId(), "NetworkFetchProducer", a);
        dBj.F(tVar.getId(), "NetworkFetchProducer", true);
        a(iVar, tVar.dBx() | 1, tVar.dBy(), tVar.dBu());
    }

    private void a(com.facebook.common.memory.i iVar, int i, @Nullable com.facebook.imagepipeline.common.a aVar, k<com.facebook.imagepipeline.g.e> kVar) {
        com.facebook.imagepipeline.g.e eVar;
        com.facebook.common.references.a e = com.facebook.common.references.a.e(iVar.duz());
        try {
            eVar = new com.facebook.imagepipeline.g.e(e);
            try {
                eVar.b(aVar);
                eVar.dAn();
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
        tVar.dBj().a(tVar.getId(), "NetworkFetchProducer", th, (Map<String, String>) null);
        tVar.dBj().F(tVar.getId(), "NetworkFetchProducer", false);
        tVar.dBu().G(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(t tVar) {
        tVar.dBj().b(tVar.getId(), "NetworkFetchProducer", null);
        tVar.dBu().dum();
    }

    private boolean c(t tVar) {
        if (tVar.dBv().dBn()) {
            return this.mvP.a(tVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> a(t tVar, int i) {
        if (tVar.dBj().Qc(tVar.getId())) {
            return this.mvP.a((af) tVar, i);
        }
        return null;
    }
}
