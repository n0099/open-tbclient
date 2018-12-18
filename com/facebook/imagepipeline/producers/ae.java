package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class ae implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.common.memory.a iga;
    private final com.facebook.common.memory.g ile;
    private final af inm;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.ile = gVar;
        this.iga = aVar;
        this.inm = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        ajVar.bYR().db(ajVar.getId(), "NetworkFetchProducer");
        final s d = this.inm.d(jVar, ajVar);
        this.inm.a((af) d, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void e(InputStream inputStream, int i) throws IOException {
                ae.this.a(d, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void B(Throwable th) {
                ae.this.a(d, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void bSY() {
                ae.this.b(d);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(s sVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i bTh;
        if (i > 0) {
            bTh = this.ile.xU(i);
        } else {
            bTh = this.ile.bTh();
        }
        byte[] bArr = this.iga.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        bTh.write(bArr, 0, read);
                        a(bTh, sVar);
                        sVar.bZd().az(ch(bTh.size(), i));
                    }
                } else {
                    this.inm.a((af) sVar, bTh.size());
                    b(bTh, sVar);
                    return;
                }
            } finally {
                this.iga.release(bArr);
                bTh.close();
            }
        }
    }

    private static float ch(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    private void a(com.facebook.common.memory.i iVar, s sVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(sVar) && uptimeMillis - sVar.bZf() >= 100) {
            sVar.dv(uptimeMillis);
            sVar.bYR().T(sVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, false, sVar.bZd());
        }
    }

    private void b(com.facebook.common.memory.i iVar, s sVar) {
        sVar.bYR().a(sVar.getId(), "NetworkFetchProducer", b(sVar, iVar.size()));
        a(iVar, true, sVar.bZd());
    }

    private void a(com.facebook.common.memory.i iVar, boolean z, j<com.facebook.imagepipeline.f.d> jVar) {
        com.facebook.imagepipeline.f.d dVar;
        com.facebook.common.references.a c = com.facebook.common.references.a.c(iVar.bTi());
        try {
            dVar = new com.facebook.imagepipeline.f.d(c);
            try {
                dVar.bYb();
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
        sVar.bYR().a(sVar.getId(), "NetworkFetchProducer", th, null);
        sVar.bZd().B(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(s sVar) {
        sVar.bYR().b(sVar.getId(), "NetworkFetchProducer", null);
        sVar.bZd().bSY();
    }

    private boolean c(s sVar) {
        if (sVar.bZe().bYQ().bZJ()) {
            return this.inm.a(sVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> b(s sVar, int i) {
        if (sVar.bYR().zl(sVar.getId())) {
            return this.inm.b(sVar, i);
        }
        return null;
    }
}
