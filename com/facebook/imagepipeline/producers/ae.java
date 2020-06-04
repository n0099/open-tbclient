package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class ae implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.common.memory.a mmW;
    private final com.facebook.common.memory.g mvb;
    private final af mwZ;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.mvb = gVar;
        this.mmW = aVar;
        this.mwZ = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        akVar.dBx().fK(akVar.getId(), "NetworkFetchProducer");
        final t b = this.mwZ.b(kVar, akVar);
        this.mwZ.a((af) b, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void g(InputStream inputStream, int i) throws IOException {
                ae.this.a(b, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void G(Throwable th) {
                ae.this.a(b, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void duA() {
                ae.this.b(b);
            }
        });
    }

    protected void a(t tVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i duM;
        if (i > 0) {
            duM = this.mvb.GP(i);
        } else {
            duM = this.mvb.duM();
        }
        byte[] bArr = this.mmW.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        duM.write(bArr, 0, read);
                        a(duM, tVar);
                        tVar.dBI().at(ds(duM.size(), i));
                    }
                } else {
                    this.mwZ.b((af) tVar, duM.size());
                    b(duM, tVar);
                    return;
                }
            } finally {
                this.mmW.release(bArr);
                duM.close();
            }
        }
    }

    protected static float ds(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    protected void a(com.facebook.common.memory.i iVar, t tVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(tVar) && uptimeMillis - tVar.dBK() >= 100) {
            tVar.fQ(uptimeMillis);
            tVar.dBx().aA(tVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, tVar.dBL(), tVar.dBM(), tVar.dBI());
        }
    }

    protected void b(com.facebook.common.memory.i iVar, t tVar) {
        Map<String, String> a = a(tVar, iVar.size());
        am dBx = tVar.dBx();
        dBx.a(tVar.getId(), "NetworkFetchProducer", a);
        dBx.F(tVar.getId(), "NetworkFetchProducer", true);
        a(iVar, tVar.dBL() | 1, tVar.dBM(), tVar.dBI());
    }

    private void a(com.facebook.common.memory.i iVar, int i, @Nullable com.facebook.imagepipeline.common.a aVar, k<com.facebook.imagepipeline.g.e> kVar) {
        com.facebook.imagepipeline.g.e eVar;
        com.facebook.common.references.a e = com.facebook.common.references.a.e(iVar.duN());
        try {
            eVar = new com.facebook.imagepipeline.g.e(e);
            try {
                eVar.b(aVar);
                eVar.dAB();
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
        tVar.dBx().a(tVar.getId(), "NetworkFetchProducer", th, (Map<String, String>) null);
        tVar.dBx().F(tVar.getId(), "NetworkFetchProducer", false);
        tVar.dBI().G(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(t tVar) {
        tVar.dBx().b(tVar.getId(), "NetworkFetchProducer", null);
        tVar.dBI().duA();
    }

    private boolean c(t tVar) {
        if (tVar.dBJ().dBB()) {
            return this.mwZ.a(tVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> a(t tVar, int i) {
        if (tVar.dBx().Qd(tVar.getId())) {
            return this.mwZ.a((af) tVar, i);
        }
        return null;
    }
}
