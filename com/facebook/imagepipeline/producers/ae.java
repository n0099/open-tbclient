package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class ae implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.common.memory.a kdb;
    private final com.facebook.common.memory.g kik;
    private final af kks;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.kik = gVar;
        this.kdb = aVar;
        this.kks = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        ajVar.cLL().eB(ajVar.getId(), "NetworkFetchProducer");
        final s d = this.kks.d(jVar, ajVar);
        this.kks.a((af) d, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void f(InputStream inputStream, int i) throws IOException {
                ae.this.a(d, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void B(Throwable th) {
                ae.this.a(d, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void cFJ() {
                ae.this.b(d);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(s sVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i cFS;
        if (i > 0) {
            cFS = this.kik.DD(i);
        } else {
            cFS = this.kik.cFS();
        }
        byte[] bArr = this.kdb.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        cFS.write(bArr, 0, read);
                        a(cFS, sVar);
                        sVar.cLX().aS(cO(cFS.size(), i));
                    }
                } else {
                    this.kks.a((af) sVar, cFS.size());
                    b(cFS, sVar);
                    return;
                }
            } finally {
                this.kdb.release(bArr);
                cFS.close();
            }
        }
    }

    private static float cO(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    private void a(com.facebook.common.memory.i iVar, s sVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(sVar) && uptimeMillis - sVar.cLZ() >= 100) {
            sVar.eO(uptimeMillis);
            sVar.cLL().ag(sVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, false, sVar.cLX());
        }
    }

    private void b(com.facebook.common.memory.i iVar, s sVar) {
        sVar.cLL().a(sVar.getId(), "NetworkFetchProducer", b(sVar, iVar.size()));
        a(iVar, true, sVar.cLX());
    }

    private void a(com.facebook.common.memory.i iVar, boolean z, j<com.facebook.imagepipeline.f.d> jVar) {
        com.facebook.imagepipeline.f.d dVar;
        com.facebook.common.references.a d = com.facebook.common.references.a.d(iVar.cFT());
        try {
            dVar = new com.facebook.imagepipeline.f.d(d);
            try {
                dVar.cKU();
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
        sVar.cLL().a(sVar.getId(), "NetworkFetchProducer", th, null);
        sVar.cLX().B(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(s sVar) {
        sVar.cLL().b(sVar.getId(), "NetworkFetchProducer", null);
        sVar.cLX().cFJ();
    }

    private boolean c(s sVar) {
        if (sVar.cLY().cLK().cMD()) {
            return this.kks.a(sVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> b(s sVar, int i) {
        if (sVar.cLL().Iq(sVar.getId())) {
            return this.kks.b(sVar, i);
        }
        return null;
    }
}
