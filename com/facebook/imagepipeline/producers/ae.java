package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class ae implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.common.memory.a lIF;
    private final com.facebook.common.memory.g lQs;
    private final af lSq;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.lQs = gVar;
        this.lIF = aVar;
        this.lSq = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        akVar.dry().fm(akVar.getId(), "NetworkFetchProducer");
        final t b = this.lSq.b(kVar, akVar);
        this.lSq.a((af) b, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void g(InputStream inputStream, int i) throws IOException {
                ae.this.a(b, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void C(Throwable th) {
                ae.this.a(b, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void dkE() {
                ae.this.b(b);
            }
        });
    }

    protected void a(t tVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i dkQ;
        if (i > 0) {
            dkQ = this.lQs.Hu(i);
        } else {
            dkQ = this.lQs.dkQ();
        }
        byte[] bArr = this.lIF.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        dkQ.write(bArr, 0, read);
                        a(dkQ, tVar);
                        tVar.drJ().aK(dC(dkQ.size(), i));
                    }
                } else {
                    this.lSq.b((af) tVar, dkQ.size());
                    b(dkQ, tVar);
                    return;
                }
            } finally {
                this.lIF.release(bArr);
                dkQ.close();
            }
        }
    }

    protected static float dC(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    protected void a(com.facebook.common.memory.i iVar, t tVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(tVar) && uptimeMillis - tVar.drL() >= 100) {
            tVar.fj(uptimeMillis);
            tVar.dry().az(tVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, tVar.drM(), tVar.drN(), tVar.drJ());
        }
    }

    protected void b(com.facebook.common.memory.i iVar, t tVar) {
        Map<String, String> a = a(tVar, iVar.size());
        am dry = tVar.dry();
        dry.a(tVar.getId(), "NetworkFetchProducer", a);
        dry.D(tVar.getId(), "NetworkFetchProducer", true);
        a(iVar, tVar.drM() | 1, tVar.drN(), tVar.drJ());
    }

    private void a(com.facebook.common.memory.i iVar, int i, @Nullable com.facebook.imagepipeline.common.a aVar, k<com.facebook.imagepipeline.g.e> kVar) {
        com.facebook.imagepipeline.g.e eVar;
        com.facebook.common.references.a b = com.facebook.common.references.a.b(iVar.dkR());
        try {
            eVar = new com.facebook.imagepipeline.g.e(b);
            try {
                eVar.b(aVar);
                eVar.dqB();
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
        tVar.dry().a(tVar.getId(), "NetworkFetchProducer", th, (Map<String, String>) null);
        tVar.dry().D(tVar.getId(), "NetworkFetchProducer", false);
        tVar.drJ().C(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(t tVar) {
        tVar.dry().b(tVar.getId(), "NetworkFetchProducer", null);
        tVar.drJ().dkE();
    }

    private boolean c(t tVar) {
        if (tVar.drK().drC()) {
            return this.lSq.a(tVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> a(t tVar, int i) {
        if (tVar.dry().Pd(tVar.getId())) {
            return this.lSq.a((af) tVar, i);
        }
        return null;
    }
}
