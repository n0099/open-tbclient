package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.producers.af;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class ae implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.common.memory.a oLv;
    private final com.facebook.common.memory.g oTv;
    private final af oVt;

    public ae(com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, af afVar) {
        this.oTv = gVar;
        this.oLv = aVar;
        this.oVt = afVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        akVar.eqW().gZ(akVar.getId(), "NetworkFetchProducer");
        final t b = this.oVt.b(kVar, akVar);
        this.oVt.a((af) b, new af.a() { // from class: com.facebook.imagepipeline.producers.ae.1
            @Override // com.facebook.imagepipeline.producers.af.a
            public void f(InputStream inputStream, int i) throws IOException {
                ae.this.a(b, inputStream, i);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void E(Throwable th) {
                ae.this.a(b, th);
            }

            @Override // com.facebook.imagepipeline.producers.af.a
            public void ejZ() {
                ae.this.b(b);
            }
        });
    }

    protected void a(t tVar, InputStream inputStream, int i) throws IOException {
        com.facebook.common.memory.i ekl;
        if (i > 0) {
            ekl = this.oTv.Os(i);
        } else {
            ekl = this.oTv.ekl();
        }
        byte[] bArr = this.oLv.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read >= 0) {
                    if (read > 0) {
                        ekl.write(bArr, 0, read);
                        a(ekl, tVar);
                        tVar.erh().aN(eb(ekl.size(), i));
                    }
                } else {
                    this.oVt.b((af) tVar, ekl.size());
                    b(ekl, tVar);
                    return;
                }
            } finally {
                this.oLv.release(bArr);
                ekl.close();
            }
        }
    }

    protected static float eb(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp((-i) / 50000.0d));
    }

    protected void a(com.facebook.common.memory.i iVar, t tVar) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (c(tVar) && uptimeMillis - tVar.erj() >= 100) {
            tVar.hP(uptimeMillis);
            tVar.eqW().aO(tVar.getId(), "NetworkFetchProducer", "intermediate_result");
            a(iVar, tVar.erk(), tVar.erl(), tVar.erh());
        }
    }

    protected void b(com.facebook.common.memory.i iVar, t tVar) {
        Map<String, String> a2 = a(tVar, iVar.size());
        am eqW = tVar.eqW();
        eqW.a(tVar.getId(), "NetworkFetchProducer", a2);
        eqW.H(tVar.getId(), "NetworkFetchProducer", true);
        a(iVar, tVar.erk() | 1, tVar.erl(), tVar.erh());
    }

    private void a(com.facebook.common.memory.i iVar, int i, @Nullable com.facebook.imagepipeline.common.a aVar, k<com.facebook.imagepipeline.g.e> kVar) {
        com.facebook.imagepipeline.g.e eVar;
        com.facebook.common.references.a e = com.facebook.common.references.a.e(iVar.ekm());
        try {
            eVar = new com.facebook.imagepipeline.g.e(e);
            try {
                eVar.b(aVar);
                eVar.eqa();
                kVar.h(eVar, i);
                com.facebook.imagepipeline.g.e.e(eVar);
                com.facebook.common.references.a.c(e);
            } catch (Throwable th) {
                th = th;
                com.facebook.imagepipeline.g.e.e(eVar);
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
        tVar.eqW().a(tVar.getId(), "NetworkFetchProducer", th, (Map<String, String>) null);
        tVar.eqW().H(tVar.getId(), "NetworkFetchProducer", false);
        tVar.erh().E(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(t tVar) {
        tVar.eqW().b(tVar.getId(), "NetworkFetchProducer", null);
        tVar.erh().ejZ();
    }

    private boolean c(t tVar) {
        if (tVar.eri().era()) {
            return this.oVt.a(tVar);
        }
        return false;
    }

    @Nullable
    private Map<String, String> a(t tVar, int i) {
        if (tVar.eqW().Ym(tVar.getId())) {
            return this.oVt.a((af) tVar, i);
        }
        return null;
    }
}
