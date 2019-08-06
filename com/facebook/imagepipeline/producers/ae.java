package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class ae implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.common.memory.a kaE;
    private final com.facebook.common.memory.g kfM;
    private final af khU;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.kfM = gVar;
        this.kaE = aVar;
        this.khU = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        ajVar.cKX().eA(ajVar.getId(), "NetworkFetchProducer");
        final s d = this.khU.d(jVar, ajVar);
        this.khU.a((af) d, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void f(InputStream inputStream, int i) throws IOException {
                ae.this.a(d, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void B(Throwable th) {
                ae.this.a(d, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void cEV() {
                ae.this.b(d);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(s sVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i cFe;
        if (i > 0) {
            cFe = this.kfM.Dz(i);
        } else {
            cFe = this.kfM.cFe();
        }
        byte[] bArr = this.kaE.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        cFe.write(bArr, 0, read);
                        a(cFe, sVar);
                        sVar.cLj().aR(cP(cFe.size(), i));
                    }
                } else {
                    this.khU.a((af) sVar, cFe.size());
                    b(cFe, sVar);
                    return;
                }
            } finally {
                this.kaE.release(bArr);
                cFe.close();
            }
        }
    }

    private static float cP(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    private void a(com.facebook.common.memory.i iVar, s sVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(sVar) && uptimeMillis - sVar.cLl() >= 100) {
            sVar.eL(uptimeMillis);
            sVar.cKX().ae(sVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, false, sVar.cLj());
        }
    }

    private void b(com.facebook.common.memory.i iVar, s sVar) {
        sVar.cKX().a(sVar.getId(), "NetworkFetchProducer", b(sVar, iVar.size()));
        a(iVar, true, sVar.cLj());
    }

    private void a(com.facebook.common.memory.i iVar, boolean z, j<com.facebook.imagepipeline.f.d> jVar) {
        com.facebook.imagepipeline.f.d dVar;
        com.facebook.common.references.a d = com.facebook.common.references.a.d(iVar.cFf());
        try {
            dVar = new com.facebook.imagepipeline.f.d(d);
            try {
                dVar.cKg();
                jVar.e(dVar, z);
                com.facebook.imagepipeline.f.d.e(dVar);
                com.facebook.common.references.a.c(d);
            } catch (Throwable th) {
                th = th;
                com.facebook.imagepipeline.f.d.e(dVar);
                com.facebook.common.references.a.c(d);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            dVar = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(s sVar, Throwable th) {
        sVar.cKX().a(sVar.getId(), "NetworkFetchProducer", th, null);
        sVar.cLj().B(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(s sVar) {
        sVar.cKX().b(sVar.getId(), "NetworkFetchProducer", null);
        sVar.cLj().cEV();
    }

    private boolean c(s sVar) {
        if (sVar.cLk().cKW().cLP()) {
            return this.khU.a(sVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> b(s sVar, int i) {
        if (sVar.cKX().HQ(sVar.getId())) {
            return this.khU.b(sVar, i);
        }
        return null;
    }
}
