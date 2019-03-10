package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class ae implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.common.memory.a jAn;
    private final com.facebook.common.memory.g jFx;
    private final af jHE;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.jFx = gVar;
        this.jAn = aVar;
        this.jHE = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        ajVar.czF().em(ajVar.getId(), "NetworkFetchProducer");
        final s d = this.jHE.d(jVar, ajVar);
        this.jHE.a((af) d, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void f(InputStream inputStream, int i) throws IOException {
                ae.this.a(d, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void C(Throwable th) {
                ae.this.a(d, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void ctF() {
                ae.this.b(d);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(s sVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i ctO;
        if (i > 0) {
            ctO = this.jFx.BW(i);
        } else {
            ctO = this.jFx.ctO();
        }
        byte[] bArr = this.jAn.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        ctO.write(bArr, 0, read);
                        a(ctO, sVar);
                        sVar.czR().aM(cD(ctO.size(), i));
                    }
                } else {
                    this.jHE.a((af) sVar, ctO.size());
                    b(ctO, sVar);
                    return;
                }
            } finally {
                this.jAn.release(bArr);
                ctO.close();
            }
        }
    }

    private static float cD(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    private void a(com.facebook.common.memory.i iVar, s sVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(sVar) && uptimeMillis - sVar.czT() >= 100) {
            sVar.ef(uptimeMillis);
            sVar.czF().ae(sVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, false, sVar.czR());
        }
    }

    private void b(com.facebook.common.memory.i iVar, s sVar) {
        sVar.czF().a(sVar.getId(), "NetworkFetchProducer", b(sVar, iVar.size()));
        a(iVar, true, sVar.czR());
    }

    private void a(com.facebook.common.memory.i iVar, boolean z, j<com.facebook.imagepipeline.f.d> jVar) {
        com.facebook.imagepipeline.f.d dVar;
        com.facebook.common.references.a d = com.facebook.common.references.a.d(iVar.ctP());
        try {
            dVar = new com.facebook.imagepipeline.f.d(d);
            try {
                dVar.cyP();
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
        sVar.czF().a(sVar.getId(), "NetworkFetchProducer", th, null);
        sVar.czR().C(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(s sVar) {
        sVar.czF().b(sVar.getId(), "NetworkFetchProducer", null);
        sVar.czR().ctF();
    }

    private boolean c(s sVar) {
        if (sVar.czS().czE().cAx()) {
            return this.jHE.a(sVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> b(s sVar, int i) {
        if (sVar.czF().FK(sVar.getId())) {
            return this.jHE.b(sVar, i);
        }
        return null;
    }
}
