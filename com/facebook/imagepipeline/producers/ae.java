package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class ae implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.common.memory.a lRU;
    private final com.facebook.common.memory.g lZW;
    private final af mbY;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.lZW = gVar;
        this.lRU = aVar;
        this.mbY = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        akVar.dtR().fi(akVar.getId(), "NetworkFetchProducer");
        final t b = this.mbY.b(kVar, akVar);
        this.mbY.a((af) b, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void g(InputStream inputStream, int i) throws IOException {
                ae.this.a(b, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void G(Throwable th) {
                ae.this.a(b, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void dmS() {
                ae.this.b(b);
            }
        });
    }

    protected void a(t tVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i dne;
        if (i > 0) {
            dne = this.lZW.Gb(i);
        } else {
            dne = this.lZW.dne();
        }
        byte[] bArr = this.lRU.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        dne.write(bArr, 0, read);
                        a(dne, tVar);
                        tVar.duc().au(dn(dne.size(), i));
                    }
                } else {
                    this.mbY.b((af) tVar, dne.size());
                    b(dne, tVar);
                    return;
                }
            } finally {
                this.lRU.release(bArr);
                dne.close();
            }
        }
    }

    protected static float dn(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    protected void a(com.facebook.common.memory.i iVar, t tVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(tVar) && uptimeMillis - tVar.due() >= 100) {
            tVar.fQ(uptimeMillis);
            tVar.dtR().aw(tVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, tVar.duf(), tVar.dug(), tVar.duc());
        }
    }

    protected void b(com.facebook.common.memory.i iVar, t tVar) {
        Map<String, String> a = a(tVar, iVar.size());
        am dtR = tVar.dtR();
        dtR.a(tVar.getId(), "NetworkFetchProducer", a);
        dtR.D(tVar.getId(), "NetworkFetchProducer", true);
        a(iVar, tVar.duf() | 1, tVar.dug(), tVar.duc());
    }

    private void a(com.facebook.common.memory.i iVar, int i, @Nullable com.facebook.imagepipeline.common.a aVar, k<com.facebook.imagepipeline.g.e> kVar) {
        com.facebook.imagepipeline.g.e eVar;
        com.facebook.common.references.a c = com.facebook.common.references.a.c(iVar.dnf());
        try {
            eVar = new com.facebook.imagepipeline.g.e(c);
            try {
                eVar.b(aVar);
                eVar.dsU();
                kVar.h(eVar, i);
                com.facebook.imagepipeline.g.e.e(eVar);
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) c);
            } catch (Throwable th) {
                th = th;
                com.facebook.imagepipeline.g.e.e(eVar);
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) c);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            eVar = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(t tVar, Throwable th) {
        tVar.dtR().a(tVar.getId(), "NetworkFetchProducer", th, (Map<String, String>) null);
        tVar.dtR().D(tVar.getId(), "NetworkFetchProducer", false);
        tVar.duc().G(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(t tVar) {
        tVar.dtR().b(tVar.getId(), "NetworkFetchProducer", null);
        tVar.duc().dmS();
    }

    private boolean c(t tVar) {
        if (tVar.dud().dtV()) {
            return this.mbY.a(tVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> a(t tVar, int i) {
        if (tVar.dtR().Oo(tVar.getId())) {
            return this.mbY.a((af) tVar, i);
        }
        return null;
    }
}
