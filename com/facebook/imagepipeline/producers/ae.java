package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class ae implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.common.memory.a kbk;
    private final com.facebook.common.memory.g kgu;
    private final af kiE;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.kgu = gVar;
        this.kbk = aVar;
        this.kiE = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        ajVar.cII().en(ajVar.getId(), "NetworkFetchProducer");
        final s d = this.kiE.d(jVar, ajVar);
        this.kiE.a((af) d, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void f(InputStream inputStream, int i) throws IOException {
                ae.this.a(d, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void A(Throwable th) {
                ae.this.a(d, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void cCH() {
                ae.this.b(d);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(s sVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i cCQ;
        if (i > 0) {
            cCQ = this.kgu.BZ(i);
        } else {
            cCQ = this.kgu.cCQ();
        }
        byte[] bArr = this.kbk.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        cCQ.write(bArr, 0, read);
                        a(cCQ, sVar);
                        sVar.cIU().av(cH(cCQ.size(), i));
                    }
                } else {
                    this.kiE.a((af) sVar, cCQ.size());
                    b(cCQ, sVar);
                    return;
                }
            } finally {
                this.kbk.release(bArr);
                cCQ.close();
            }
        }
    }

    private static float cH(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    private void a(com.facebook.common.memory.i iVar, s sVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(sVar) && uptimeMillis - sVar.cIW() >= 100) {
            sVar.ei(uptimeMillis);
            sVar.cII().ai(sVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, false, sVar.cIU());
        }
    }

    private void b(com.facebook.common.memory.i iVar, s sVar) {
        sVar.cII().a(sVar.getId(), "NetworkFetchProducer", b(sVar, iVar.size()));
        a(iVar, true, sVar.cIU());
    }

    private void a(com.facebook.common.memory.i iVar, boolean z, j<com.facebook.imagepipeline.f.d> jVar) {
        com.facebook.imagepipeline.f.d dVar;
        com.facebook.common.references.a c = com.facebook.common.references.a.c(iVar.cCR());
        try {
            dVar = new com.facebook.imagepipeline.f.d(c);
            try {
                dVar.cHR();
                jVar.f(dVar, z);
                com.facebook.imagepipeline.f.d.e(dVar);
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) c);
            } catch (Throwable th) {
                th = th;
                com.facebook.imagepipeline.f.d.e(dVar);
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) c);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            dVar = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(s sVar, Throwable th) {
        sVar.cII().a(sVar.getId(), "NetworkFetchProducer", th, null);
        sVar.cIU().A(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(s sVar) {
        sVar.cII().b(sVar.getId(), "NetworkFetchProducer", null);
        sVar.cIU().cCH();
    }

    private boolean c(s sVar) {
        if (sVar.cIV().cIH().cJA()) {
            return this.kiE.a(sVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> b(s sVar, int i) {
        if (sVar.cII().GH(sVar.getId())) {
            return this.kiE.b(sVar, i);
        }
        return null;
    }
}
