package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class ae implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.common.memory.a lKw;
    private final com.facebook.common.memory.g lSj;
    private final af lUh;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.lSj = gVar;
        this.lKw = aVar;
        this.lUh = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        akVar.drW().fk(akVar.getId(), "NetworkFetchProducer");
        final t b = this.lUh.b(kVar, akVar);
        this.lUh.a((af) b, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void g(InputStream inputStream, int i) throws IOException {
                ae.this.a(b, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void C(Throwable th) {
                ae.this.a(b, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void dlc() {
                ae.this.b(b);
            }
        });
    }

    protected void a(t tVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i dlo;
        if (i > 0) {
            dlo = this.lSj.HA(i);
        } else {
            dlo = this.lSj.dlo();
        }
        byte[] bArr = this.lKw.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        dlo.write(bArr, 0, read);
                        a(dlo, tVar);
                        tVar.dsh().aK(dD(dlo.size(), i));
                    }
                } else {
                    this.lUh.b((af) tVar, dlo.size());
                    b(dlo, tVar);
                    return;
                }
            } finally {
                this.lKw.release(bArr);
                dlo.close();
            }
        }
    }

    protected static float dD(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    protected void a(com.facebook.common.memory.i iVar, t tVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(tVar) && uptimeMillis - tVar.dsj() >= 100) {
            tVar.fk(uptimeMillis);
            tVar.drW().az(tVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, tVar.dsk(), tVar.dsl(), tVar.dsh());
        }
    }

    protected void b(com.facebook.common.memory.i iVar, t tVar) {
        Map<String, String> a = a(tVar, iVar.size());
        am drW = tVar.drW();
        drW.a(tVar.getId(), "NetworkFetchProducer", a);
        drW.D(tVar.getId(), "NetworkFetchProducer", true);
        a(iVar, tVar.dsk() | 1, tVar.dsl(), tVar.dsh());
    }

    private void a(com.facebook.common.memory.i iVar, int i, @Nullable com.facebook.imagepipeline.common.a aVar, k<com.facebook.imagepipeline.g.e> kVar) {
        com.facebook.imagepipeline.g.e eVar;
        com.facebook.common.references.a b = com.facebook.common.references.a.b(iVar.dlp());
        try {
            eVar = new com.facebook.imagepipeline.g.e(b);
            try {
                eVar.b(aVar);
                eVar.dqZ();
                kVar.g(eVar, i);
                com.facebook.imagepipeline.g.e.e(eVar);
                com.facebook.common.references.a.c(b);
            } catch (Throwable th) {
                th = th;
                com.facebook.imagepipeline.g.e.e(eVar);
                com.facebook.common.references.a.c(b);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            eVar = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(t tVar, Throwable th) {
        tVar.drW().a(tVar.getId(), "NetworkFetchProducer", th, (Map<String, String>) null);
        tVar.drW().D(tVar.getId(), "NetworkFetchProducer", false);
        tVar.dsh().C(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(t tVar) {
        tVar.drW().b(tVar.getId(), "NetworkFetchProducer", null);
        tVar.dsh().dlc();
    }

    private boolean c(t tVar) {
        if (tVar.dsi().dsa()) {
            return this.lUh.a(tVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> a(t tVar, int i) {
        if (tVar.drW().Pe(tVar.getId())) {
            return this.lUh.a((af) tVar, i);
        }
        return null;
    }
}
