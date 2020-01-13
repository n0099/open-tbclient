package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes10.dex */
public class ae implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.common.memory.a lHR;
    private final com.facebook.common.memory.g lPE;
    private final af lRC;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.lPE = gVar;
        this.lHR = aVar;
        this.lRC = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        akVar.dqi().fe(akVar.getId(), "NetworkFetchProducer");
        final t b = this.lRC.b(kVar, akVar);
        this.lRC.a((af) b, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void g(InputStream inputStream, int i) throws IOException {
                ae.this.a(b, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void D(Throwable th) {
                ae.this.a(b, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void djn() {
                ae.this.b(b);
            }
        });
    }

    protected void a(t tVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i djz;
        if (i > 0) {
            djz = this.lPE.Hp(i);
        } else {
            djz = this.lPE.djz();
        }
        byte[] bArr = this.lHR.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        djz.write(bArr, 0, read);
                        a(djz, tVar);
                        tVar.dqt().aL(dz(djz.size(), i));
                    }
                } else {
                    this.lRC.b((af) tVar, djz.size());
                    b(djz, tVar);
                    return;
                }
            } finally {
                this.lHR.release(bArr);
                djz.close();
            }
        }
    }

    protected static float dz(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    protected void a(com.facebook.common.memory.i iVar, t tVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(tVar) && uptimeMillis - tVar.dqv() >= 100) {
            tVar.fl(uptimeMillis);
            tVar.dqi().az(tVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, tVar.dqw(), tVar.dqx(), tVar.dqt());
        }
    }

    protected void b(com.facebook.common.memory.i iVar, t tVar) {
        Map<String, String> a = a(tVar, iVar.size());
        am dqi = tVar.dqi();
        dqi.a(tVar.getId(), "NetworkFetchProducer", a);
        dqi.C(tVar.getId(), "NetworkFetchProducer", true);
        a(iVar, tVar.dqw() | 1, tVar.dqx(), tVar.dqt());
    }

    private void a(com.facebook.common.memory.i iVar, int i, @Nullable com.facebook.imagepipeline.common.a aVar, k<com.facebook.imagepipeline.g.e> kVar) {
        com.facebook.imagepipeline.g.e eVar;
        com.facebook.common.references.a b = com.facebook.common.references.a.b(iVar.djA());
        try {
            eVar = new com.facebook.imagepipeline.g.e(b);
            try {
                eVar.b(aVar);
                eVar.dpl();
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
        tVar.dqi().a(tVar.getId(), "NetworkFetchProducer", th, (Map<String, String>) null);
        tVar.dqi().C(tVar.getId(), "NetworkFetchProducer", false);
        tVar.dqt().D(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(t tVar) {
        tVar.dqi().b(tVar.getId(), "NetworkFetchProducer", null);
        tVar.dqt().djn();
    }

    private boolean c(t tVar) {
        if (tVar.dqu().dqm()) {
            return this.lRC.a(tVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> a(t tVar, int i) {
        if (tVar.dqi().OQ(tVar.getId())) {
            return this.lRC.a((af) tVar, i);
        }
        return null;
    }
}
