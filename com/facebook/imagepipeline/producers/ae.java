package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class ae implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.common.memory.a mIW;
    private final com.facebook.common.memory.g mQZ;
    private final af mTb;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.mQZ = gVar;
        this.mIW = aVar;
        this.mTb = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        akVar.dFZ().fU(akVar.getId(), "NetworkFetchProducer");
        final t b = this.mTb.b(kVar, akVar);
        this.mTb.a((af) b, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void g(InputStream inputStream, int i) throws IOException {
                ae.this.a(b, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void G(Throwable th) {
                ae.this.a(b, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void dzd() {
                ae.this.b(b);
            }
        });
    }

    protected void a(t tVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i dzp;
        if (i > 0) {
            dzp = this.mQZ.HW(i);
        } else {
            dzp = this.mQZ.dzp();
        }
        byte[] bArr = this.mIW.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        dzp.write(bArr, 0, read);
                        a(dzp, tVar);
                        tVar.dGk().ay(dB(dzp.size(), i));
                    }
                } else {
                    this.mTb.b((af) tVar, dzp.size());
                    b(dzp, tVar);
                    return;
                }
            } finally {
                this.mIW.release(bArr);
                dzp.close();
            }
        }
    }

    protected static float dB(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    protected void a(com.facebook.common.memory.i iVar, t tVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(tVar) && uptimeMillis - tVar.dGm() >= 100) {
            tVar.fV(uptimeMillis);
            tVar.dFZ().aB(tVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, tVar.dGn(), tVar.dGo(), tVar.dGk());
        }
    }

    protected void b(com.facebook.common.memory.i iVar, t tVar) {
        Map<String, String> a = a(tVar, iVar.size());
        am dFZ = tVar.dFZ();
        dFZ.a(tVar.getId(), "NetworkFetchProducer", a);
        dFZ.G(tVar.getId(), "NetworkFetchProducer", true);
        a(iVar, tVar.dGn() | 1, tVar.dGo(), tVar.dGk());
    }

    private void a(com.facebook.common.memory.i iVar, int i, @Nullable com.facebook.imagepipeline.common.a aVar, k<com.facebook.imagepipeline.g.e> kVar) {
        com.facebook.imagepipeline.g.e eVar;
        com.facebook.common.references.a e = com.facebook.common.references.a.e(iVar.dzq());
        try {
            eVar = new com.facebook.imagepipeline.g.e(e);
            try {
                eVar.b(aVar);
                eVar.dFd();
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
        tVar.dFZ().a(tVar.getId(), "NetworkFetchProducer", th, (Map<String, String>) null);
        tVar.dFZ().G(tVar.getId(), "NetworkFetchProducer", false);
        tVar.dGk().G(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(t tVar) {
        tVar.dFZ().b(tVar.getId(), "NetworkFetchProducer", null);
        tVar.dGk().dzd();
    }

    private boolean c(t tVar) {
        if (tVar.dGl().dGd()) {
            return this.mTb.a(tVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> a(t tVar, int i) {
        if (tVar.dFZ().QP(tVar.getId())) {
            return this.mTb.a((af) tVar, i);
        }
        return null;
    }
}
