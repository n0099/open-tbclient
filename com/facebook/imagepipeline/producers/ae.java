package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class ae implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.common.memory.g jFe;
    private final af jHl;
    private final com.facebook.common.memory.a jzU;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.jFe = gVar;
        this.jzU = aVar;
        this.jHl = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        ajVar.czv().em(ajVar.getId(), "NetworkFetchProducer");
        final s d = this.jHl.d(jVar, ajVar);
        this.jHl.a((af) d, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void f(InputStream inputStream, int i) throws IOException {
                ae.this.a(d, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void C(Throwable th) {
                ae.this.a(d, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void ctv() {
                ae.this.b(d);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(s sVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i ctE;
        if (i > 0) {
            ctE = this.jFe.BV(i);
        } else {
            ctE = this.jFe.ctE();
        }
        byte[] bArr = this.jzU.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        ctE.write(bArr, 0, read);
                        a(ctE, sVar);
                        sVar.czH().aM(cD(ctE.size(), i));
                    }
                } else {
                    this.jHl.a((af) sVar, ctE.size());
                    b(ctE, sVar);
                    return;
                }
            } finally {
                this.jzU.release(bArr);
                ctE.close();
            }
        }
    }

    private static float cD(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    private void a(com.facebook.common.memory.i iVar, s sVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(sVar) && uptimeMillis - sVar.czJ() >= 100) {
            sVar.ef(uptimeMillis);
            sVar.czv().ae(sVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, false, sVar.czH());
        }
    }

    private void b(com.facebook.common.memory.i iVar, s sVar) {
        sVar.czv().a(sVar.getId(), "NetworkFetchProducer", b(sVar, iVar.size()));
        a(iVar, true, sVar.czH());
    }

    private void a(com.facebook.common.memory.i iVar, boolean z, j<com.facebook.imagepipeline.f.d> jVar) {
        com.facebook.imagepipeline.f.d dVar;
        com.facebook.common.references.a d = com.facebook.common.references.a.d(iVar.ctF());
        try {
            dVar = new com.facebook.imagepipeline.f.d(d);
            try {
                dVar.cyF();
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
        sVar.czv().a(sVar.getId(), "NetworkFetchProducer", th, null);
        sVar.czH().C(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(s sVar) {
        sVar.czv().b(sVar.getId(), "NetworkFetchProducer", null);
        sVar.czH().ctv();
    }

    private boolean c(s sVar) {
        if (sVar.czI().czu().cAn()) {
            return this.jHl.a(sVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> b(s sVar, int i) {
        if (sVar.czv().FH(sVar.getId())) {
            return this.jHl.b(sVar, i);
        }
        return null;
    }
}
