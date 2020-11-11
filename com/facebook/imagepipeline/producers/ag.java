package com.facebook.imagepipeline.producers;

import android.net.Uri;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class ag implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.common.memory.a oLv;
    private final com.facebook.common.memory.g oTv;
    private final com.facebook.imagepipeline.c.f oVd;
    private final com.facebook.imagepipeline.c.e oWg;
    private final aj<com.facebook.imagepipeline.g.e> oYc;

    public ag(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.f fVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.oWg = eVar;
        this.oVd = fVar;
        this.oTv = gVar;
        this.oLv = aVar;
        this.oYc = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        ImageRequest eqV = akVar.eqV();
        if (!eqV.eoq()) {
            this.oYc.c(kVar, akVar);
            return;
        }
        akVar.eqW().gZ(akVar.getId(), "PartialDiskCacheProducer");
        com.facebook.cache.common.b a2 = this.oVd.a(eqV, n(eqV), akVar.elz());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.oWg.a(a2, atomicBoolean).a(a(kVar, akVar, a2));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.g.e, Void> a(final k<com.facebook.imagepipeline.g.e> kVar, final ak akVar, final com.facebook.cache.common.b bVar) {
        final String id = akVar.getId();
        final am eqW = akVar.eqW();
        return new bolts.f<com.facebook.imagepipeline.g.e, Void>() { // from class: com.facebook.imagepipeline.producers.ag.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.g.e> gVar) throws Exception {
                if (ag.d(gVar)) {
                    eqW.b(id, "PartialDiskCacheProducer", null);
                    kVar.ejZ();
                } else if (gVar.il()) {
                    eqW.a(id, "PartialDiskCacheProducer", gVar.im(), (Map<String, String>) null);
                    ag.this.a(kVar, akVar, bVar, (com.facebook.imagepipeline.g.e) null);
                } else {
                    com.facebook.imagepipeline.g.e result = gVar.getResult();
                    if (result != null) {
                        eqW.a(id, "PartialDiskCacheProducer", ag.a(eqW, id, true, result.getSize()));
                        com.facebook.imagepipeline.common.a Pf = com.facebook.imagepipeline.common.a.Pf(result.getSize() - 1);
                        result.b(Pf);
                        int size = result.getSize();
                        ImageRequest eqV = akVar.eqV();
                        if (Pf.a(eqV.epZ())) {
                            eqW.H(id, "PartialDiskCacheProducer", true);
                            kVar.h(result, 9);
                        } else {
                            kVar.h(result, 8);
                            ag.this.a(kVar, new ap(ImageRequestBuilder.o(eqV).d(com.facebook.imagepipeline.common.a.Pe(size - 1)).erY(), akVar), bVar, result);
                        }
                    } else {
                        eqW.a(id, "PartialDiskCacheProducer", ag.a(eqW, id, false, 0));
                        ag.this.a(kVar, akVar, bVar, result);
                    }
                }
                return null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, com.facebook.cache.common.b bVar, @Nullable com.facebook.imagepipeline.g.e eVar) {
        this.oYc.c(new a(kVar, this.oWg, bVar, this.oTv, this.oLv, eVar), akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(bolts.g<?> gVar) {
        return gVar.isCancelled() || (gVar.il() && (gVar.im() instanceof CancellationException));
    }

    @Nullable
    static Map<String, String> a(am amVar, String str, boolean z, int i) {
        if (!amVar.Ym(str)) {
            return null;
        }
        if (z) {
            return ImmutableMap.of("cached_value_found", String.valueOf(z), "encodedImageSize", String.valueOf(i));
        }
        return ImmutableMap.of("cached_value_found", String.valueOf(z));
    }

    private void a(final AtomicBoolean atomicBoolean, ak akVar) {
        akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ag.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
            public void enm() {
                atomicBoolean.set(true);
            }
        });
    }

    private static Uri n(ImageRequest imageRequest) {
        return imageRequest.erN().buildUpon().appendQueryParameter("fresco_partial", "true").build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.common.memory.a oLv;
        private final com.facebook.common.memory.g oTv;
        private final com.facebook.imagepipeline.c.e oWg;
        private final com.facebook.cache.common.b oZt;
        @Nullable
        private final com.facebook.imagepipeline.g.e oZu;

        private a(k<com.facebook.imagepipeline.g.e> kVar, com.facebook.imagepipeline.c.e eVar, com.facebook.cache.common.b bVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, @Nullable com.facebook.imagepipeline.g.e eVar2) {
            super(kVar);
            this.oWg = eVar;
            this.oZt = bVar;
            this.oTv = gVar;
            this.oLv = aVar;
            this.oZu = eVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (!PJ(i)) {
                if (this.oZu != null && eVar.epZ() != null) {
                    try {
                        a(a(this.oZu, eVar));
                    } catch (IOException e) {
                        com.facebook.common.c.a.e("PartialDiskCacheProducer", "Error while merging image data", e);
                        erh().E(e);
                    } finally {
                        eVar.close();
                        this.oZu.close();
                    }
                    this.oWg.n(this.oZt);
                } else if (dZ(i, 8) && PI(i) && eVar.epY() != com.facebook.c.c.oSA) {
                    this.oWg.a(this.oZt, eVar);
                    erh().h(eVar, i);
                } else {
                    erh().h(eVar, i);
                }
            }
        }

        private com.facebook.common.memory.i a(com.facebook.imagepipeline.g.e eVar, com.facebook.imagepipeline.g.e eVar2) throws IOException {
            com.facebook.common.memory.i Os = this.oTv.Os(eVar2.getSize() + eVar2.epZ().from);
            c(eVar.getInputStream(), Os, eVar2.epZ().from);
            c(eVar2.getInputStream(), Os, eVar2.getSize());
            return Os;
        }

        private void c(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
            byte[] bArr = this.oLv.get(16384);
            int i2 = i;
            while (i2 > 0) {
                try {
                    int read = inputStream.read(bArr, 0, Math.min(16384, i2));
                    if (read < 0) {
                        break;
                    } else if (read > 0) {
                        outputStream.write(bArr, 0, read);
                        i2 -= read;
                    }
                } finally {
                    this.oLv.release(bArr);
                }
            }
            if (i2 > 0) {
                throw new IOException(String.format(null, "Failed to read %d bytes - finished %d short", Integer.valueOf(i), Integer.valueOf(i2)));
            }
        }

        private void a(com.facebook.common.memory.i iVar) {
            com.facebook.imagepipeline.g.e eVar;
            com.facebook.common.references.a e = com.facebook.common.references.a.e(iVar.ekm());
            try {
                eVar = new com.facebook.imagepipeline.g.e(e);
            } catch (Throwable th) {
                th = th;
                eVar = null;
            }
            try {
                eVar.eqa();
                erh().h(eVar, 1);
                com.facebook.imagepipeline.g.e.e(eVar);
                com.facebook.common.references.a.c(e);
            } catch (Throwable th2) {
                th = th2;
                com.facebook.imagepipeline.g.e.e(eVar);
                com.facebook.common.references.a.c(e);
                throw th;
            }
        }
    }
}
