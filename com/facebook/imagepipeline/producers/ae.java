package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class ae implements aj<com.facebook.imagepipeline.f.e> {
    private final com.facebook.common.memory.a pch;
    private final com.facebook.common.memory.g pjO;
    private final af plL;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.pjO = gVar;
        this.pch = aVar;
        this.plL = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        akVar.eww().hh(akVar.getId(), "NetworkFetchProducer");
        final t d = this.plL.d(kVar, akVar);
        this.plL.a((af) d, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void f(InputStream inputStream, int i) throws IOException {
                ae.this.a(d, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void E(Throwable th) {
                ae.this.a(d, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void epM() {
                ae.this.b(d);
            }
        });
    }

    protected void a(t tVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i epY;
        if (i > 0) {
            epY = this.pjO.PT(i);
        } else {
            epY = this.pjO.epY();
        }
        byte[] bArr = this.pch.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        epY.write(bArr, 0, read);
                        a(epY, tVar);
                        tVar.ewI().aV(eh(epY.size(), i));
                    }
                } else {
                    this.plL.a((af) tVar, epY.size());
                    b(epY, tVar);
                    return;
                }
            } finally {
                this.pch.release(bArr);
                epY.close();
            }
        }
    }

    protected static float eh(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    protected void a(com.facebook.common.memory.i iVar, t tVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(tVar) && uptimeMillis - tVar.ewK() >= 100) {
            tVar.ix(uptimeMillis);
            tVar.eww().aR(tVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, tVar.ewL(), tVar.ewM(), tVar.ewI());
        }
    }

    protected void b(com.facebook.common.memory.i iVar, t tVar) {
        Map<String, String> b = b(tVar, iVar.size());
        am eww = tVar.eww();
        eww.a(tVar.getId(), "NetworkFetchProducer", b);
        eww.J(tVar.getId(), "NetworkFetchProducer", true);
        a(iVar, tVar.ewL() | 1, tVar.ewM(), tVar.ewI());
    }

    private void a(com.facebook.common.memory.i iVar, int i, @Nullable com.facebook.imagepipeline.common.a aVar, k<com.facebook.imagepipeline.f.e> kVar) {
        com.facebook.imagepipeline.f.e eVar;
        com.facebook.common.references.a e = com.facebook.common.references.a.e(iVar.epZ());
        try {
            eVar = new com.facebook.imagepipeline.f.e(e);
            try {
                eVar.b(aVar);
                eVar.evD();
                kVar.h(eVar, i);
                com.facebook.imagepipeline.f.e.e(eVar);
                com.facebook.common.references.a.c(e);
            } catch (Throwable th) {
                th = th;
                com.facebook.imagepipeline.f.e.e(eVar);
                com.facebook.common.references.a.c(e);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            eVar = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(t tVar, Throwable th) {
        tVar.eww().a(tVar.getId(), "NetworkFetchProducer", th, (Map<String, String>) null);
        tVar.eww().J(tVar.getId(), "NetworkFetchProducer", false);
        tVar.ewI().E(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(t tVar) {
        tVar.eww().b(tVar.getId(), "NetworkFetchProducer", null);
        tVar.ewI().epM();
    }

    private boolean c(t tVar) {
        if (tVar.ewJ().ewA()) {
            return this.plL.a(tVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> b(t tVar, int i) {
        if (tVar.eww().Zq(tVar.getId())) {
            return this.plL.b(tVar, i);
        }
        return null;
    }
}
