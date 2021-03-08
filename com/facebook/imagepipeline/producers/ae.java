package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class ae implements aj<com.facebook.imagepipeline.f.e> {
    private final com.facebook.common.memory.a pBJ;
    private final com.facebook.common.memory.g pJp;
    private final af pLk;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.pJp = gVar;
        this.pBJ = aVar;
        this.pLk = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        akVar.ezz().hv(akVar.getId(), "NetworkFetchProducer");
        final t d = this.pLk.d(kVar, akVar);
        this.pLk.a((af) d, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void f(InputStream inputStream, int i) throws IOException {
                ae.this.a(d, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void C(Throwable th) {
                ae.this.a(d, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void esM() {
                ae.this.b(d);
            }
        });
    }

    protected void a(t tVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i esY;
        if (i > 0) {
            esY = this.pJp.Pa(i);
        } else {
            esY = this.pJp.esY();
        }
        byte[] bArr = this.pBJ.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        esY.write(bArr, 0, read);
                        a(esY, tVar);
                        tVar.ezL().be(ef(esY.size(), i));
                    }
                } else {
                    this.pLk.a((af) tVar, esY.size());
                    b(esY, tVar);
                    return;
                }
            } finally {
                this.pBJ.release(bArr);
                esY.close();
            }
        }
    }

    protected static float ef(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    protected void a(com.facebook.common.memory.i iVar, t tVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(tVar) && uptimeMillis - tVar.ezN() >= 100) {
            tVar.iO(uptimeMillis);
            tVar.ezz().aW(tVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, tVar.ezO(), tVar.ezP(), tVar.ezL());
        }
    }

    protected void b(com.facebook.common.memory.i iVar, t tVar) {
        Map<String, String> b = b(tVar, iVar.size());
        am ezz = tVar.ezz();
        ezz.b(tVar.getId(), "NetworkFetchProducer", b);
        ezz.M(tVar.getId(), "NetworkFetchProducer", true);
        a(iVar, tVar.ezO() | 1, tVar.ezP(), tVar.ezL());
    }

    private void a(com.facebook.common.memory.i iVar, int i, @Nullable com.facebook.imagepipeline.common.a aVar, k<com.facebook.imagepipeline.f.e> kVar) {
        com.facebook.imagepipeline.f.e eVar;
        com.facebook.common.references.a d = com.facebook.common.references.a.d(iVar.esZ());
        try {
            eVar = new com.facebook.imagepipeline.f.e(d);
            try {
                eVar.b(aVar);
                eVar.eyH();
                kVar.f(eVar, i);
                com.facebook.imagepipeline.f.e.e(eVar);
                com.facebook.common.references.a.c(d);
            } catch (Throwable th) {
                th = th;
                com.facebook.imagepipeline.f.e.e(eVar);
                com.facebook.common.references.a.c(d);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            eVar = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(t tVar, Throwable th) {
        tVar.ezz().a(tVar.getId(), "NetworkFetchProducer", th, (Map<String, String>) null);
        tVar.ezz().M(tVar.getId(), "NetworkFetchProducer", false);
        tVar.ezL().C(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(t tVar) {
        tVar.ezz().c(tVar.getId(), "NetworkFetchProducer", null);
        tVar.ezL().esM();
    }

    private boolean c(t tVar) {
        if (tVar.ezM().ezD()) {
            return this.pLk.a(tVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> b(t tVar, int i) {
        if (tVar.ezz().ZM(tVar.getId())) {
            return this.pLk.b(tVar, i);
        }
        return null;
    }
}
