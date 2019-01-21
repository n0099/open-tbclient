package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class ae implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.common.memory.a iks;
    private final com.facebook.common.memory.g ipy;
    private final af irF;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.ipy = gVar;
        this.iks = aVar;
        this.irF = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        ajVar.caq().de(ajVar.getId(), "NetworkFetchProducer");
        final s d = this.irF.d(jVar, ajVar);
        this.irF.a((af) d, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void e(InputStream inputStream, int i) throws IOException {
                ae.this.a(d, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void B(Throwable th) {
                ae.this.a(d, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void bUx() {
                ae.this.b(d);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(s sVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i bUG;
        if (i > 0) {
            bUG = this.ipy.yj(i);
        } else {
            bUG = this.ipy.bUG();
        }
        byte[] bArr = this.iks.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        bUG.write(bArr, 0, read);
                        a(bUG, sVar);
                        sVar.caC().az(ci(bUG.size(), i));
                    }
                } else {
                    this.irF.a((af) sVar, bUG.size());
                    b(bUG, sVar);
                    return;
                }
            } finally {
                this.iks.release(bArr);
                bUG.close();
            }
        }
    }

    private static float ci(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    private void a(com.facebook.common.memory.i iVar, s sVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(sVar) && uptimeMillis - sVar.caE() >= 100) {
            sVar.dA(uptimeMillis);
            sVar.caq().T(sVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, false, sVar.caC());
        }
    }

    private void b(com.facebook.common.memory.i iVar, s sVar) {
        sVar.caq().a(sVar.getId(), "NetworkFetchProducer", b(sVar, iVar.size()));
        a(iVar, true, sVar.caC());
    }

    private void a(com.facebook.common.memory.i iVar, boolean z, j<com.facebook.imagepipeline.f.d> jVar) {
        com.facebook.imagepipeline.f.d dVar;
        com.facebook.common.references.a c = com.facebook.common.references.a.c(iVar.bUH());
        try {
            dVar = new com.facebook.imagepipeline.f.d(c);
            try {
                dVar.bZA();
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
        sVar.caq().a(sVar.getId(), "NetworkFetchProducer", th, null);
        sVar.caC().B(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(s sVar) {
        sVar.caq().b(sVar.getId(), "NetworkFetchProducer", null);
        sVar.caC().bUx();
    }

    private boolean c(s sVar) {
        if (sVar.caD().cap().cbi()) {
            return this.irF.a(sVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> b(s sVar, int i) {
        if (sVar.caq().zE(sVar.getId())) {
            return this.irF.b(sVar, i);
        }
        return null;
    }
}
