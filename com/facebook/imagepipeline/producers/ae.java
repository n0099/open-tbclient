package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class ae implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.common.memory.a lEt;
    private final com.facebook.common.memory.g lLT;
    private final af lNQ;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.lLT = gVar;
        this.lEt = aVar;
        this.lNQ = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        akVar.doY().fc(akVar.getId(), "NetworkFetchProducer");
        final t b = this.lNQ.b(kVar, akVar);
        this.lNQ.a((af) b, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void g(InputStream inputStream, int i) throws IOException {
                ae.this.a(b, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void D(Throwable th) {
                ae.this.a(b, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void dim() {
                ae.this.b(b);
            }
        });
    }

    protected void a(t tVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i diy;
        if (i > 0) {
            diy = this.lLT.Hk(i);
        } else {
            diy = this.lLT.diy();
        }
        byte[] bArr = this.lEt.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        diy.write(bArr, 0, read);
                        a(diy, tVar);
                        tVar.dpj().aM(dB(diy.size(), i));
                    }
                } else {
                    this.lNQ.b((af) tVar, diy.size());
                    b(diy, tVar);
                    return;
                }
            } finally {
                this.lEt.release(bArr);
                diy.close();
            }
        }
    }

    protected static float dB(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    protected void a(com.facebook.common.memory.i iVar, t tVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(tVar) && uptimeMillis - tVar.dpl() >= 100) {
            tVar.fg(uptimeMillis);
            tVar.doY().ay(tVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, tVar.dpm(), tVar.dpn(), tVar.dpj());
        }
    }

    protected void b(com.facebook.common.memory.i iVar, t tVar) {
        Map<String, String> a = a(tVar, iVar.size());
        am doY = tVar.doY();
        doY.a(tVar.getId(), "NetworkFetchProducer", a);
        doY.C(tVar.getId(), "NetworkFetchProducer", true);
        a(iVar, tVar.dpm() | 1, tVar.dpn(), tVar.dpj());
    }

    private void a(com.facebook.common.memory.i iVar, int i, @Nullable com.facebook.imagepipeline.common.a aVar, k<com.facebook.imagepipeline.g.e> kVar) {
        com.facebook.imagepipeline.g.e eVar;
        com.facebook.common.references.a b = com.facebook.common.references.a.b(iVar.diz());
        try {
            eVar = new com.facebook.imagepipeline.g.e(b);
            try {
                eVar.b(aVar);
                eVar.dof();
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
        tVar.doY().a(tVar.getId(), "NetworkFetchProducer", th, (Map<String, String>) null);
        tVar.doY().C(tVar.getId(), "NetworkFetchProducer", false);
        tVar.dpj().D(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(t tVar) {
        tVar.doY().b(tVar.getId(), "NetworkFetchProducer", null);
        tVar.dpj().dim();
    }

    private boolean c(t tVar) {
        if (tVar.dpk().dpc()) {
            return this.lNQ.a(tVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> a(t tVar, int i) {
        if (tVar.doY().OF(tVar.getId())) {
            return this.lNQ.a((af) tVar, i);
        }
        return null;
    }
}
