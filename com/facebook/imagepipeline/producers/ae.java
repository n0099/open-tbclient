package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public class ae implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.common.memory.a nlq;
    private final com.facebook.common.memory.g ntt;
    private final af nvs;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.ntt = gVar;
        this.nlq = aVar;
        this.nvs = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        akVar.dVy().go(akVar.getId(), "NetworkFetchProducer");
        final t b = this.nvs.b(kVar, akVar);
        this.nvs.a((af) b, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void f(InputStream inputStream, int i) throws IOException {
                ae.this.a(b, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void E(Throwable th) {
                ae.this.a(b, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void dOD() {
                ae.this.b(b);
            }
        });
    }

    protected void a(t tVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i dOP;
        if (i > 0) {
            dOP = this.ntt.KV(i);
        } else {
            dOP = this.ntt.dOP();
        }
        byte[] bArr = this.nlq.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        dOP.write(bArr, 0, read);
                        a(dOP, tVar);
                        tVar.dVJ().aD(dL(dOP.size(), i));
                    }
                } else {
                    this.nvs.b((af) tVar, dOP.size());
                    b(dOP, tVar);
                    return;
                }
            } finally {
                this.nlq.release(bArr);
                dOP.close();
            }
        }
    }

    protected static float dL(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    protected void a(com.facebook.common.memory.i iVar, t tVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(tVar) && uptimeMillis - tVar.dVL() >= 100) {
            tVar.gx(uptimeMillis);
            tVar.dVy().aA(tVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, tVar.dVM(), tVar.dVN(), tVar.dVJ());
        }
    }

    protected void b(com.facebook.common.memory.i iVar, t tVar) {
        Map<String, String> a = a(tVar, iVar.size());
        am dVy = tVar.dVy();
        dVy.a(tVar.getId(), "NetworkFetchProducer", a);
        dVy.F(tVar.getId(), "NetworkFetchProducer", true);
        a(iVar, tVar.dVM() | 1, tVar.dVN(), tVar.dVJ());
    }

    private void a(com.facebook.common.memory.i iVar, int i, @Nullable com.facebook.imagepipeline.common.a aVar, k<com.facebook.imagepipeline.g.e> kVar) {
        com.facebook.imagepipeline.g.e eVar;
        com.facebook.common.references.a e = com.facebook.common.references.a.e(iVar.dOQ());
        try {
            eVar = new com.facebook.imagepipeline.g.e(e);
            try {
                eVar.b(aVar);
                eVar.dUC();
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
        tVar.dVy().a(tVar.getId(), "NetworkFetchProducer", th, (Map<String, String>) null);
        tVar.dVy().F(tVar.getId(), "NetworkFetchProducer", false);
        tVar.dVJ().E(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(t tVar) {
        tVar.dVy().b(tVar.getId(), "NetworkFetchProducer", null);
        tVar.dVJ().dOD();
    }

    private boolean c(t tVar) {
        if (tVar.dVK().dVC()) {
            return this.nvs.a(tVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> a(t tVar, int i) {
        if (tVar.dVy().UF(tVar.getId())) {
            return this.nvs.a((af) tVar, i);
        }
        return null;
    }
}
