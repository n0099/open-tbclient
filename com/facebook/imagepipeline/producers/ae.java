package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class ae implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.common.memory.a hYN;
    private final com.facebook.common.memory.g idU;
    private final af igb;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.idU = gVar;
        this.hYN = aVar;
        this.igb = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        ajVar.bWM().cW(ajVar.getId(), "NetworkFetchProducer");
        final s d = this.igb.d(jVar, ajVar);
        this.igb.a((af) d, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void e(InputStream inputStream, int i) throws IOException {
                ae.this.a(d, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void B(Throwable th) {
                ae.this.a(d, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void bQT() {
                ae.this.b(d);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(s sVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i bRc;
        if (i > 0) {
            bRc = this.idU.xx(i);
        } else {
            bRc = this.idU.bRc();
        }
        byte[] bArr = this.hYN.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        bRc.write(bArr, 0, read);
                        a(bRc, sVar);
                        sVar.bWY().az(cj(bRc.size(), i));
                    }
                } else {
                    this.igb.a((af) sVar, bRc.size());
                    b(bRc, sVar);
                    return;
                }
            } finally {
                this.hYN.release(bArr);
                bRc.close();
            }
        }
    }

    private static float cj(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    private void a(com.facebook.common.memory.i iVar, s sVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(sVar) && uptimeMillis - sVar.bXa() >= 100) {
            sVar.m24do(uptimeMillis);
            sVar.bWM().S(sVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, false, sVar.bWY());
        }
    }

    private void b(com.facebook.common.memory.i iVar, s sVar) {
        sVar.bWM().a(sVar.getId(), "NetworkFetchProducer", b(sVar, iVar.size()));
        a(iVar, true, sVar.bWY());
    }

    private void a(com.facebook.common.memory.i iVar, boolean z, j<com.facebook.imagepipeline.f.d> jVar) {
        com.facebook.imagepipeline.f.d dVar;
        com.facebook.common.references.a c = com.facebook.common.references.a.c(iVar.bRd());
        try {
            dVar = new com.facebook.imagepipeline.f.d(c);
            try {
                dVar.bVW();
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
        sVar.bWM().a(sVar.getId(), "NetworkFetchProducer", th, null);
        sVar.bWY().B(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(s sVar) {
        sVar.bWM().b(sVar.getId(), "NetworkFetchProducer", null);
        sVar.bWY().bQT();
    }

    private boolean c(s sVar) {
        if (sVar.bWZ().bWL().bXE()) {
            return this.igb.a(sVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> b(s sVar, int i) {
        if (sVar.bWM().yI(sVar.getId())) {
            return this.igb.b(sVar, i);
        }
        return null;
    }
}
