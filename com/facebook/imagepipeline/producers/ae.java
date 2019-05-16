package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class ae implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.common.memory.a jSq;
    private final com.facebook.common.memory.g jXx;
    private final af jZE;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.jXx = gVar;
        this.jSq = aVar;
        this.jZE = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        ajVar.cHx().ez(ajVar.getId(), "NetworkFetchProducer");
        final s d = this.jZE.d(jVar, ajVar);
        this.jZE.a((af) d, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void f(InputStream inputStream, int i) throws IOException {
                ae.this.a(d, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void B(Throwable th) {
                ae.this.a(d, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void cBy() {
                ae.this.b(d);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(s sVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i cBH;
        if (i > 0) {
            cBH = this.jXx.CQ(i);
        } else {
            cBH = this.jXx.cBH();
        }
        byte[] bArr = this.jSq.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        cBH.write(bArr, 0, read);
                        a(cBH, sVar);
                        sVar.cHJ().aQ(cK(cBH.size(), i));
                    }
                } else {
                    this.jZE.a((af) sVar, cBH.size());
                    b(cBH, sVar);
                    return;
                }
            } finally {
                this.jSq.release(bArr);
                cBH.close();
            }
        }
    }

    private static float cK(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    private void a(com.facebook.common.memory.i iVar, s sVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(sVar) && uptimeMillis - sVar.cHL() >= 100) {
            sVar.eD(uptimeMillis);
            sVar.cHx().ae(sVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, false, sVar.cHJ());
        }
    }

    private void b(com.facebook.common.memory.i iVar, s sVar) {
        sVar.cHx().a(sVar.getId(), "NetworkFetchProducer", b(sVar, iVar.size()));
        a(iVar, true, sVar.cHJ());
    }

    private void a(com.facebook.common.memory.i iVar, boolean z, j<com.facebook.imagepipeline.f.d> jVar) {
        com.facebook.imagepipeline.f.d dVar;
        com.facebook.common.references.a d = com.facebook.common.references.a.d(iVar.cBI());
        try {
            dVar = new com.facebook.imagepipeline.f.d(d);
            try {
                dVar.cGH();
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
        sVar.cHx().a(sVar.getId(), "NetworkFetchProducer", th, null);
        sVar.cHJ().B(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(s sVar) {
        sVar.cHx().b(sVar.getId(), "NetworkFetchProducer", null);
        sVar.cHJ().cBy();
    }

    private boolean c(s sVar) {
        if (sVar.cHK().cHw().cIp()) {
            return this.jZE.a(sVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> b(s sVar, int i) {
        if (sVar.cHx().GT(sVar.getId())) {
            return this.jZE.b(sVar, i);
        }
        return null;
    }
}
