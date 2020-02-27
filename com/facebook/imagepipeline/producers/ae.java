package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class ae implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.common.memory.a lID;
    private final com.facebook.common.memory.g lQq;
    private final af lSo;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.lQq = gVar;
        this.lID = aVar;
        this.lSo = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        akVar.drw().fm(akVar.getId(), "NetworkFetchProducer");
        final t b = this.lSo.b(kVar, akVar);
        this.lSo.a((af) b, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void g(InputStream inputStream, int i) throws IOException {
                ae.this.a(b, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void C(Throwable th) {
                ae.this.a(b, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void dkC() {
                ae.this.b(b);
            }
        });
    }

    protected void a(t tVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i dkO;
        if (i > 0) {
            dkO = this.lQq.Hu(i);
        } else {
            dkO = this.lQq.dkO();
        }
        byte[] bArr = this.lID.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        dkO.write(bArr, 0, read);
                        a(dkO, tVar);
                        tVar.drH().aK(dC(dkO.size(), i));
                    }
                } else {
                    this.lSo.b((af) tVar, dkO.size());
                    b(dkO, tVar);
                    return;
                }
            } finally {
                this.lID.release(bArr);
                dkO.close();
            }
        }
    }

    protected static float dC(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    protected void a(com.facebook.common.memory.i iVar, t tVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(tVar) && uptimeMillis - tVar.drJ() >= 100) {
            tVar.fj(uptimeMillis);
            tVar.drw().az(tVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, tVar.drK(), tVar.drL(), tVar.drH());
        }
    }

    protected void b(com.facebook.common.memory.i iVar, t tVar) {
        Map<String, String> a = a(tVar, iVar.size());
        am drw = tVar.drw();
        drw.a(tVar.getId(), "NetworkFetchProducer", a);
        drw.D(tVar.getId(), "NetworkFetchProducer", true);
        a(iVar, tVar.drK() | 1, tVar.drL(), tVar.drH());
    }

    private void a(com.facebook.common.memory.i iVar, int i, @Nullable com.facebook.imagepipeline.common.a aVar, k<com.facebook.imagepipeline.g.e> kVar) {
        com.facebook.imagepipeline.g.e eVar;
        com.facebook.common.references.a b = com.facebook.common.references.a.b(iVar.dkP());
        try {
            eVar = new com.facebook.imagepipeline.g.e(b);
            try {
                eVar.b(aVar);
                eVar.dqz();
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
        tVar.drw().a(tVar.getId(), "NetworkFetchProducer", th, (Map<String, String>) null);
        tVar.drw().D(tVar.getId(), "NetworkFetchProducer", false);
        tVar.drH().C(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(t tVar) {
        tVar.drw().b(tVar.getId(), "NetworkFetchProducer", null);
        tVar.drH().dkC();
    }

    private boolean c(t tVar) {
        if (tVar.drI().drA()) {
            return this.lSo.a(tVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> a(t tVar, int i) {
        if (tVar.drw().Pd(tVar.getId())) {
            return this.lSo.a((af) tVar, i);
        }
        return null;
    }
}
