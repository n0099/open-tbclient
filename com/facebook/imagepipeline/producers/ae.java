package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class ae implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.common.memory.a hXd;
    private final com.facebook.common.memory.g ich;
    private final af ier;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.ich = gVar;
        this.hXd = aVar;
        this.ier = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        ajVar.bXr().cX(ajVar.getId(), "NetworkFetchProducer");
        final s d = this.ier.d(jVar, ajVar);
        this.ier.a((af) d, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void e(InputStream inputStream, int i) throws IOException {
                ae.this.a(d, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void B(Throwable th) {
                ae.this.a(d, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void bRy() {
                ae.this.b(d);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(s sVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i bRH;
        if (i > 0) {
            bRH = this.ich.xe(i);
        } else {
            bRH = this.ich.bRH();
        }
        byte[] bArr = this.hXd.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        bRH.write(bArr, 0, read);
                        a(bRH, sVar);
                        sVar.bXD().ax(cg(bRH.size(), i));
                    }
                } else {
                    this.ier.a((af) sVar, bRH.size());
                    b(bRH, sVar);
                    return;
                }
            } finally {
                this.hXd.release(bArr);
                bRH.close();
            }
        }
    }

    private static float cg(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    private void a(com.facebook.common.memory.i iVar, s sVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(sVar) && uptimeMillis - sVar.bXF() >= 100) {
            sVar.dt(uptimeMillis);
            sVar.bXr().S(sVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, false, sVar.bXD());
        }
    }

    private void b(com.facebook.common.memory.i iVar, s sVar) {
        sVar.bXr().a(sVar.getId(), "NetworkFetchProducer", b(sVar, iVar.size()));
        a(iVar, true, sVar.bXD());
    }

    private void a(com.facebook.common.memory.i iVar, boolean z, j<com.facebook.imagepipeline.f.d> jVar) {
        com.facebook.imagepipeline.f.d dVar;
        com.facebook.common.references.a c = com.facebook.common.references.a.c(iVar.bRI());
        try {
            dVar = new com.facebook.imagepipeline.f.d(c);
            try {
                dVar.bWB();
                jVar.e(dVar, z);
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
        sVar.bXr().a(sVar.getId(), "NetworkFetchProducer", th, null);
        sVar.bXD().B(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(s sVar) {
        sVar.bXr().b(sVar.getId(), "NetworkFetchProducer", null);
        sVar.bXD().bRy();
    }

    private boolean c(s sVar) {
        if (sVar.bXE().bXq().bYj()) {
            return this.ier.a(sVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> b(s sVar, int i) {
        if (sVar.bXr().yD(sVar.getId())) {
            return this.ier.b(sVar, i);
        }
        return null;
    }
}
