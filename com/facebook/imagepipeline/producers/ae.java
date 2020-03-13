package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class ae implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.common.memory.a lIQ;
    private final com.facebook.common.memory.g lQD;
    private final af lSB;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.lQD = gVar;
        this.lIQ = aVar;
        this.lSB = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        akVar.drz().fm(akVar.getId(), "NetworkFetchProducer");
        final t b = this.lSB.b(kVar, akVar);
        this.lSB.a((af) b, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void g(InputStream inputStream, int i) throws IOException {
                ae.this.a(b, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void C(Throwable th) {
                ae.this.a(b, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void dkF() {
                ae.this.b(b);
            }
        });
    }

    protected void a(t tVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i dkR;
        if (i > 0) {
            dkR = this.lQD.Hu(i);
        } else {
            dkR = this.lQD.dkR();
        }
        byte[] bArr = this.lIQ.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        dkR.write(bArr, 0, read);
                        a(dkR, tVar);
                        tVar.drK().aK(dC(dkR.size(), i));
                    }
                } else {
                    this.lSB.b((af) tVar, dkR.size());
                    b(dkR, tVar);
                    return;
                }
            } finally {
                this.lIQ.release(bArr);
                dkR.close();
            }
        }
    }

    protected static float dC(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    protected void a(com.facebook.common.memory.i iVar, t tVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(tVar) && uptimeMillis - tVar.drM() >= 100) {
            tVar.fj(uptimeMillis);
            tVar.drz().az(tVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, tVar.drN(), tVar.drO(), tVar.drK());
        }
    }

    protected void b(com.facebook.common.memory.i iVar, t tVar) {
        Map<String, String> a = a(tVar, iVar.size());
        am drz = tVar.drz();
        drz.a(tVar.getId(), "NetworkFetchProducer", a);
        drz.D(tVar.getId(), "NetworkFetchProducer", true);
        a(iVar, tVar.drN() | 1, tVar.drO(), tVar.drK());
    }

    private void a(com.facebook.common.memory.i iVar, int i, @Nullable com.facebook.imagepipeline.common.a aVar, k<com.facebook.imagepipeline.g.e> kVar) {
        com.facebook.imagepipeline.g.e eVar;
        com.facebook.common.references.a b = com.facebook.common.references.a.b(iVar.dkS());
        try {
            eVar = new com.facebook.imagepipeline.g.e(b);
            try {
                eVar.b(aVar);
                eVar.dqC();
                kVar.g(eVar, i);
                com.facebook.imagepipeline.g.e.e(eVar);
                com.facebook.common.references.a.c(b);
            } catch (Throwable th) {
                th = th;
                com.facebook.imagepipeline.g.e.e(eVar);
                com.facebook.common.references.a.c(b);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            eVar = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(t tVar, Throwable th) {
        tVar.drz().a(tVar.getId(), "NetworkFetchProducer", th, (Map<String, String>) null);
        tVar.drz().D(tVar.getId(), "NetworkFetchProducer", false);
        tVar.drK().C(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(t tVar) {
        tVar.drz().b(tVar.getId(), "NetworkFetchProducer", null);
        tVar.drK().dkF();
    }

    private boolean c(t tVar) {
        if (tVar.drL().drD()) {
            return this.lSB.a(tVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> a(t tVar, int i) {
        if (tVar.drz().Pe(tVar.getId())) {
            return this.lSB.a((af) tVar, i);
        }
        return null;
    }
}
