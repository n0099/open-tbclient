package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class ae implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.common.memory.a mIZ;
    private final com.facebook.common.memory.g mRd;
    private final af mTe;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.mRd = gVar;
        this.mIZ = aVar;
        this.mTe = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        akVar.dGd().fU(akVar.getId(), "NetworkFetchProducer");
        final t b = this.mTe.b(kVar, akVar);
        this.mTe.a((af) b, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void g(InputStream inputStream, int i) throws IOException {
                ae.this.a(b, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void G(Throwable th) {
                ae.this.a(b, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void dzh() {
                ae.this.b(b);
            }
        });
    }

    protected void a(t tVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i dzt;
        if (i > 0) {
            dzt = this.mRd.HW(i);
        } else {
            dzt = this.mRd.dzt();
        }
        byte[] bArr = this.mIZ.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        dzt.write(bArr, 0, read);
                        a(dzt, tVar);
                        tVar.dGo().ay(dB(dzt.size(), i));
                    }
                } else {
                    this.mTe.b((af) tVar, dzt.size());
                    b(dzt, tVar);
                    return;
                }
            } finally {
                this.mIZ.release(bArr);
                dzt.close();
            }
        }
    }

    protected static float dB(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    protected void a(com.facebook.common.memory.i iVar, t tVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(tVar) && uptimeMillis - tVar.dGq() >= 100) {
            tVar.fV(uptimeMillis);
            tVar.dGd().aB(tVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, tVar.dGr(), tVar.dGs(), tVar.dGo());
        }
    }

    protected void b(com.facebook.common.memory.i iVar, t tVar) {
        Map<String, String> a = a(tVar, iVar.size());
        am dGd = tVar.dGd();
        dGd.a(tVar.getId(), "NetworkFetchProducer", a);
        dGd.G(tVar.getId(), "NetworkFetchProducer", true);
        a(iVar, tVar.dGr() | 1, tVar.dGs(), tVar.dGo());
    }

    private void a(com.facebook.common.memory.i iVar, int i, @Nullable com.facebook.imagepipeline.common.a aVar, k<com.facebook.imagepipeline.g.e> kVar) {
        com.facebook.imagepipeline.g.e eVar;
        com.facebook.common.references.a e = com.facebook.common.references.a.e(iVar.dzu());
        try {
            eVar = new com.facebook.imagepipeline.g.e(e);
            try {
                eVar.b(aVar);
                eVar.dFh();
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
        tVar.dGd().a(tVar.getId(), "NetworkFetchProducer", th, (Map<String, String>) null);
        tVar.dGd().G(tVar.getId(), "NetworkFetchProducer", false);
        tVar.dGo().G(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(t tVar) {
        tVar.dGd().b(tVar.getId(), "NetworkFetchProducer", null);
        tVar.dGo().dzh();
    }

    private boolean c(t tVar) {
        if (tVar.dGp().dGh()) {
            return this.mTe.a(tVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> a(t tVar, int i) {
        if (tVar.dGd().QQ(tVar.getId())) {
            return this.mTe.a((af) tVar, i);
        }
        return null;
    }
}
