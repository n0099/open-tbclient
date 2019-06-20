package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class ae implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.common.memory.a jSu;
    private final com.facebook.common.memory.g jXB;
    private final af jZI;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.jXB = gVar;
        this.jSu = aVar;
        this.jZI = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        ajVar.cHy().ez(ajVar.getId(), "NetworkFetchProducer");
        final s d = this.jZI.d(jVar, ajVar);
        this.jZI.a((af) d, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void f(InputStream inputStream, int i) throws IOException {
                ae.this.a(d, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void B(Throwable th) {
                ae.this.a(d, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void cBz() {
                ae.this.b(d);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(s sVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i cBI;
        if (i > 0) {
            cBI = this.jXB.CQ(i);
        } else {
            cBI = this.jXB.cBI();
        }
        byte[] bArr = this.jSu.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        cBI.write(bArr, 0, read);
                        a(cBI, sVar);
                        sVar.cHK().aQ(cK(cBI.size(), i));
                    }
                } else {
                    this.jZI.a((af) sVar, cBI.size());
                    b(cBI, sVar);
                    return;
                }
            } finally {
                this.jSu.release(bArr);
                cBI.close();
            }
        }
    }

    private static float cK(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    private void a(com.facebook.common.memory.i iVar, s sVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(sVar) && uptimeMillis - sVar.cHM() >= 100) {
            sVar.eD(uptimeMillis);
            sVar.cHy().ae(sVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, false, sVar.cHK());
        }
    }

    private void b(com.facebook.common.memory.i iVar, s sVar) {
        sVar.cHy().a(sVar.getId(), "NetworkFetchProducer", b(sVar, iVar.size()));
        a(iVar, true, sVar.cHK());
    }

    private void a(com.facebook.common.memory.i iVar, boolean z, j<com.facebook.imagepipeline.f.d> jVar) {
        com.facebook.imagepipeline.f.d dVar;
        com.facebook.common.references.a d = com.facebook.common.references.a.d(iVar.cBJ());
        try {
            dVar = new com.facebook.imagepipeline.f.d(d);
            try {
                dVar.cGI();
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
        sVar.cHy().a(sVar.getId(), "NetworkFetchProducer", th, null);
        sVar.cHK().B(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(s sVar) {
        sVar.cHy().b(sVar.getId(), "NetworkFetchProducer", null);
        sVar.cHK().cBz();
    }

    private boolean c(s sVar) {
        if (sVar.cHL().cHx().cIq()) {
            return this.jZI.a(sVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> b(s sVar, int i) {
        if (sVar.cHy().GV(sVar.getId())) {
            return this.jZI.b(sVar, i);
        }
        return null;
    }
}
