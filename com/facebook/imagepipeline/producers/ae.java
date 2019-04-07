package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class ae implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.common.memory.g jEJ;
    private final af jGQ;
    private final com.facebook.common.memory.a jzz;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.jEJ = gVar;
        this.jzz = aVar;
        this.jGQ = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        ajVar.czB().em(ajVar.getId(), "NetworkFetchProducer");
        final s d = this.jGQ.d(jVar, ajVar);
        this.jGQ.a((af) d, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void f(InputStream inputStream, int i) throws IOException {
                ae.this.a(d, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void C(Throwable th) {
                ae.this.a(d, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void ctB() {
                ae.this.b(d);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(s sVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i ctK;
        if (i > 0) {
            ctK = this.jEJ.BM(i);
        } else {
            ctK = this.jEJ.ctK();
        }
        byte[] bArr = this.jzz.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        ctK.write(bArr, 0, read);
                        a(ctK, sVar);
                        sVar.czN().aM(cD(ctK.size(), i));
                    }
                } else {
                    this.jGQ.a((af) sVar, ctK.size());
                    b(ctK, sVar);
                    return;
                }
            } finally {
                this.jzz.release(bArr);
                ctK.close();
            }
        }
    }

    private static float cD(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    private void a(com.facebook.common.memory.i iVar, s sVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(sVar) && uptimeMillis - sVar.czP() >= 100) {
            sVar.ee(uptimeMillis);
            sVar.czB().ae(sVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, false, sVar.czN());
        }
    }

    private void b(com.facebook.common.memory.i iVar, s sVar) {
        sVar.czB().a(sVar.getId(), "NetworkFetchProducer", b(sVar, iVar.size()));
        a(iVar, true, sVar.czN());
    }

    private void a(com.facebook.common.memory.i iVar, boolean z, j<com.facebook.imagepipeline.f.d> jVar) {
        com.facebook.imagepipeline.f.d dVar;
        com.facebook.common.references.a d = com.facebook.common.references.a.d(iVar.ctL());
        try {
            dVar = new com.facebook.imagepipeline.f.d(d);
            try {
                dVar.cyL();
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
        sVar.czB().a(sVar.getId(), "NetworkFetchProducer", th, null);
        sVar.czN().C(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(s sVar) {
        sVar.czB().b(sVar.getId(), "NetworkFetchProducer", null);
        sVar.czN().ctB();
    }

    private boolean c(s sVar) {
        if (sVar.czO().czA().cAt()) {
            return this.jGQ.a(sVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> b(s sVar, int i) {
        if (sVar.czB().Fy(sVar.getId())) {
            return this.jGQ.b(sVar, i);
        }
        return null;
    }
}
