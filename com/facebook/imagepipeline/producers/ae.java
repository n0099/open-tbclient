package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class ae implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.common.memory.a nKJ;
    private final com.facebook.common.memory.g nSK;
    private final af nUI;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.nSK = gVar;
        this.nKJ = aVar;
        this.nUI = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        akVar.edh().gH(akVar.getId(), "NetworkFetchProducer");
        final t b = this.nUI.b(kVar, akVar);
        this.nUI.a((af) b, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void f(InputStream inputStream, int i) throws IOException {
                ae.this.a(b, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void E(Throwable th) {
                ae.this.a(b, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void dWm() {
                ae.this.b(b);
            }
        });
    }

    protected void a(t tVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i dWy;
        if (i > 0) {
            dWy = this.nSK.Mg(i);
        } else {
            dWy = this.nSK.dWy();
        }
        byte[] bArr = this.nKJ.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        dWy.write(bArr, 0, read);
                        a(dWy, tVar);
                        tVar.eds().aJ(dP(dWy.size(), i));
                    }
                } else {
                    this.nUI.b((af) tVar, dWy.size());
                    b(dWy, tVar);
                    return;
                }
            } finally {
                this.nKJ.release(bArr);
                dWy.close();
            }
        }
    }

    protected static float dP(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    protected void a(com.facebook.common.memory.i iVar, t tVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(tVar) && uptimeMillis - tVar.edu() >= 100) {
            tVar.hd(uptimeMillis);
            tVar.edh().aC(tVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, tVar.edv(), tVar.edw(), tVar.eds());
        }
    }

    protected void b(com.facebook.common.memory.i iVar, t tVar) {
        Map<String, String> a2 = a(tVar, iVar.size());
        am edh = tVar.edh();
        edh.a(tVar.getId(), "NetworkFetchProducer", a2);
        edh.F(tVar.getId(), "NetworkFetchProducer", true);
        a(iVar, tVar.edv() | 1, tVar.edw(), tVar.eds());
    }

    private void a(com.facebook.common.memory.i iVar, int i, @Nullable com.facebook.imagepipeline.common.a aVar, k<com.facebook.imagepipeline.g.e> kVar) {
        com.facebook.imagepipeline.g.e eVar;
        com.facebook.common.references.a e = com.facebook.common.references.a.e(iVar.dWz());
        try {
            eVar = new com.facebook.imagepipeline.g.e(e);
            try {
                eVar.b(aVar);
                eVar.ecl();
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
        tVar.edh().a(tVar.getId(), "NetworkFetchProducer", th, (Map<String, String>) null);
        tVar.edh().F(tVar.getId(), "NetworkFetchProducer", false);
        tVar.eds().E(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(t tVar) {
        tVar.edh().b(tVar.getId(), "NetworkFetchProducer", null);
        tVar.eds().dWm();
    }

    private boolean c(t tVar) {
        if (tVar.edt().edl()) {
            return this.nUI.a(tVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> a(t tVar, int i) {
        if (tVar.edh().VV(tVar.getId())) {
            return this.nUI.a((af) tVar, i);
        }
        return null;
    }
}
