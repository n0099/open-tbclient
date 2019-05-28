package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class ae implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.common.memory.a jSr;
    private final com.facebook.common.memory.g jXy;
    private final af jZF;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.jXy = gVar;
        this.jSr = aVar;
        this.jZF = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        ajVar.cHz().ez(ajVar.getId(), "NetworkFetchProducer");
        final s d = this.jZF.d(jVar, ajVar);
        this.jZF.a((af) d, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void f(InputStream inputStream, int i) throws IOException {
                ae.this.a(d, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void B(Throwable th) {
                ae.this.a(d, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void cBA() {
                ae.this.b(d);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(s sVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i cBJ;
        if (i > 0) {
            cBJ = this.jXy.CQ(i);
        } else {
            cBJ = this.jXy.cBJ();
        }
        byte[] bArr = this.jSr.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        cBJ.write(bArr, 0, read);
                        a(cBJ, sVar);
                        sVar.cHL().aQ(cK(cBJ.size(), i));
                    }
                } else {
                    this.jZF.a((af) sVar, cBJ.size());
                    b(cBJ, sVar);
                    return;
                }
            } finally {
                this.jSr.release(bArr);
                cBJ.close();
            }
        }
    }

    private static float cK(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    private void a(com.facebook.common.memory.i iVar, s sVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(sVar) && uptimeMillis - sVar.cHN() >= 100) {
            sVar.eD(uptimeMillis);
            sVar.cHz().ae(sVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, false, sVar.cHL());
        }
    }

    private void b(com.facebook.common.memory.i iVar, s sVar) {
        sVar.cHz().a(sVar.getId(), "NetworkFetchProducer", b(sVar, iVar.size()));
        a(iVar, true, sVar.cHL());
    }

    private void a(com.facebook.common.memory.i iVar, boolean z, j<com.facebook.imagepipeline.f.d> jVar) {
        com.facebook.imagepipeline.f.d dVar;
        com.facebook.common.references.a d = com.facebook.common.references.a.d(iVar.cBK());
        try {
            dVar = new com.facebook.imagepipeline.f.d(d);
            try {
                dVar.cGJ();
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
        sVar.cHz().a(sVar.getId(), "NetworkFetchProducer", th, null);
        sVar.cHL().B(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(s sVar) {
        sVar.cHz().b(sVar.getId(), "NetworkFetchProducer", null);
        sVar.cHL().cBA();
    }

    private boolean c(s sVar) {
        if (sVar.cHM().cHy().cIr()) {
            return this.jZF.a(sVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> b(s sVar, int i) {
        if (sVar.cHz().GT(sVar.getId())) {
            return this.jZF.b(sVar, i);
        }
        return null;
    }
}
