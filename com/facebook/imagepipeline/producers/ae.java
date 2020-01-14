package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes10.dex */
public class ae implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.common.memory.a lHW;
    private final com.facebook.common.memory.g lPJ;
    private final af lRH;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.lPJ = gVar;
        this.lHW = aVar;
        this.lRH = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        akVar.dqk().fe(akVar.getId(), "NetworkFetchProducer");
        final t b = this.lRH.b(kVar, akVar);
        this.lRH.a((af) b, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void g(InputStream inputStream, int i) throws IOException {
                ae.this.a(b, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void D(Throwable th) {
                ae.this.a(b, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void djp() {
                ae.this.b(b);
            }
        });
    }

    protected void a(t tVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i djB;
        if (i > 0) {
            djB = this.lPJ.Hp(i);
        } else {
            djB = this.lPJ.djB();
        }
        byte[] bArr = this.lHW.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        djB.write(bArr, 0, read);
                        a(djB, tVar);
                        tVar.dqv().aL(dz(djB.size(), i));
                    }
                } else {
                    this.lRH.b((af) tVar, djB.size());
                    b(djB, tVar);
                    return;
                }
            } finally {
                this.lHW.release(bArr);
                djB.close();
            }
        }
    }

    protected static float dz(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    protected void a(com.facebook.common.memory.i iVar, t tVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(tVar) && uptimeMillis - tVar.dqx() >= 100) {
            tVar.fl(uptimeMillis);
            tVar.dqk().az(tVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, tVar.dqy(), tVar.dqz(), tVar.dqv());
        }
    }

    protected void b(com.facebook.common.memory.i iVar, t tVar) {
        Map<String, String> a = a(tVar, iVar.size());
        am dqk = tVar.dqk();
        dqk.a(tVar.getId(), "NetworkFetchProducer", a);
        dqk.C(tVar.getId(), "NetworkFetchProducer", true);
        a(iVar, tVar.dqy() | 1, tVar.dqz(), tVar.dqv());
    }

    private void a(com.facebook.common.memory.i iVar, int i, @Nullable com.facebook.imagepipeline.common.a aVar, k<com.facebook.imagepipeline.g.e> kVar) {
        com.facebook.imagepipeline.g.e eVar;
        com.facebook.common.references.a b = com.facebook.common.references.a.b(iVar.djC());
        try {
            eVar = new com.facebook.imagepipeline.g.e(b);
            try {
                eVar.b(aVar);
                eVar.dpn();
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
        tVar.dqk().a(tVar.getId(), "NetworkFetchProducer", th, (Map<String, String>) null);
        tVar.dqk().C(tVar.getId(), "NetworkFetchProducer", false);
        tVar.dqv().D(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(t tVar) {
        tVar.dqk().b(tVar.getId(), "NetworkFetchProducer", null);
        tVar.dqv().djp();
    }

    private boolean c(t tVar) {
        if (tVar.dqw().dqo()) {
            return this.lRH.a(tVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> a(t tVar, int i) {
        if (tVar.dqk().OQ(tVar.getId())) {
            return this.lRH.a((af) tVar, i);
        }
        return null;
    }
}
