package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class ae implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.common.memory.a kat;
    private final com.facebook.common.memory.g kfD;
    private final af khM;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.kfD = gVar;
        this.kat = aVar;
        this.khM = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        ajVar.cIG().en(ajVar.getId(), "NetworkFetchProducer");
        final s d = this.khM.d(jVar, ajVar);
        this.khM.a((af) d, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void f(InputStream inputStream, int i) throws IOException {
                ae.this.a(d, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void B(Throwable th) {
                ae.this.a(d, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void cCF() {
                ae.this.b(d);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(s sVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i cCO;
        if (i > 0) {
            cCO = this.kfD.BY(i);
        } else {
            cCO = this.kfD.cCO();
        }
        byte[] bArr = this.kat.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        cCO.write(bArr, 0, read);
                        a(cCO, sVar);
                        sVar.cIS().av(cF(cCO.size(), i));
                    }
                } else {
                    this.khM.a((af) sVar, cCO.size());
                    b(cCO, sVar);
                    return;
                }
            } finally {
                this.kat.release(bArr);
                cCO.close();
            }
        }
    }

    private static float cF(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    private void a(com.facebook.common.memory.i iVar, s sVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(sVar) && uptimeMillis - sVar.cIU() >= 100) {
            sVar.eh(uptimeMillis);
            sVar.cIG().ai(sVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, false, sVar.cIS());
        }
    }

    private void b(com.facebook.common.memory.i iVar, s sVar) {
        sVar.cIG().a(sVar.getId(), "NetworkFetchProducer", b(sVar, iVar.size()));
        a(iVar, true, sVar.cIS());
    }

    private void a(com.facebook.common.memory.i iVar, boolean z, j<com.facebook.imagepipeline.f.d> jVar) {
        com.facebook.imagepipeline.f.d dVar;
        com.facebook.common.references.a c = com.facebook.common.references.a.c(iVar.cCP());
        try {
            dVar = new com.facebook.imagepipeline.f.d(c);
            try {
                dVar.cHP();
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
        sVar.cIG().a(sVar.getId(), "NetworkFetchProducer", th, null);
        sVar.cIS().B(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(s sVar) {
        sVar.cIG().b(sVar.getId(), "NetworkFetchProducer", null);
        sVar.cIS().cCF();
    }

    private boolean c(s sVar) {
        if (sVar.cIT().cIF().cJy()) {
            return this.khM.a(sVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> b(s sVar, int i) {
        if (sVar.cIG().GH(sVar.getId())) {
            return this.khM.b(sVar, i);
        }
        return null;
    }
}
