package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class ae implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.common.memory.a jZy;
    private final com.facebook.common.memory.g keG;
    private final af kgO;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.keG = gVar;
        this.jZy = aVar;
        this.kgO = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        ajVar.cKC().eA(ajVar.getId(), "NetworkFetchProducer");
        final s d = this.kgO.d(jVar, ajVar);
        this.kgO.a((af) d, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void f(InputStream inputStream, int i) throws IOException {
                ae.this.a(d, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void B(Throwable th) {
                ae.this.a(d, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void cEA() {
                ae.this.b(d);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(s sVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i cEJ;
        if (i > 0) {
            cEJ = this.keG.Dx(i);
        } else {
            cEJ = this.keG.cEJ();
        }
        byte[] bArr = this.jZy.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        cEJ.write(bArr, 0, read);
                        a(cEJ, sVar);
                        sVar.cKO().aR(cP(cEJ.size(), i));
                    }
                } else {
                    this.kgO.a((af) sVar, cEJ.size());
                    b(cEJ, sVar);
                    return;
                }
            } finally {
                this.jZy.release(bArr);
                cEJ.close();
            }
        }
    }

    private static float cP(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    private void a(com.facebook.common.memory.i iVar, s sVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(sVar) && uptimeMillis - sVar.cKQ() >= 100) {
            sVar.eL(uptimeMillis);
            sVar.cKC().ae(sVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, false, sVar.cKO());
        }
    }

    private void b(com.facebook.common.memory.i iVar, s sVar) {
        sVar.cKC().a(sVar.getId(), "NetworkFetchProducer", b(sVar, iVar.size()));
        a(iVar, true, sVar.cKO());
    }

    private void a(com.facebook.common.memory.i iVar, boolean z, j<com.facebook.imagepipeline.f.d> jVar) {
        com.facebook.imagepipeline.f.d dVar;
        com.facebook.common.references.a d = com.facebook.common.references.a.d(iVar.cEK());
        try {
            dVar = new com.facebook.imagepipeline.f.d(d);
            try {
                dVar.cJL();
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
        sVar.cKC().a(sVar.getId(), "NetworkFetchProducer", th, null);
        sVar.cKO().B(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(s sVar) {
        sVar.cKC().b(sVar.getId(), "NetworkFetchProducer", null);
        sVar.cKO().cEA();
    }

    private boolean c(s sVar) {
        if (sVar.cKP().cKB().cLu()) {
            return this.kgO.a(sVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> b(s sVar, int i) {
        if (sVar.cKC().HP(sVar.getId())) {
            return this.kgO.b(sVar, i);
        }
        return null;
    }
}
