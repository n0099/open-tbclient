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
/* loaded from: classes3.dex */
public class ag implements aj<com.facebook.imagepipeline.f.e> {
    private final aj<com.facebook.imagepipeline.f.e> pBf;
    private final com.facebook.common.memory.a poT;
    private final com.facebook.common.memory.g pwB;
    private final com.facebook.imagepipeline.b.f pyg;
    private final com.facebook.imagepipeline.b.e pzj;

    public ag(com.facebook.imagepipeline.b.e eVar, com.facebook.imagepipeline.b.f fVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.pzj = eVar;
        this.pyg = fVar;
        this.pwB = gVar;
        this.poT = aVar;
        this.pBf = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        ImageRequest ewP = akVar.ewP();
        if (!ewP.eun()) {
            this.pBf.a(kVar, akVar);
            return;
        }
        akVar.ewQ().hm(akVar.getId(), "PartialDiskCacheProducer");
        com.facebook.cache.common.b a2 = this.pyg.a(ewP, n(ewP), akVar.erD());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.pzj.a(a2, atomicBoolean).a(a(kVar, akVar, a2));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.f.e, Void> a(final k<com.facebook.imagepipeline.f.e> kVar, final ak akVar, final com.facebook.cache.common.b bVar) {
        final String id = akVar.getId();
        final am ewQ = akVar.ewQ();
        return new bolts.f<com.facebook.imagepipeline.f.e, Void>() { // from class: com.facebook.imagepipeline.producers.ag.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.f.e> gVar) throws Exception {
                if (ag.d(gVar)) {
                    ewQ.c(id, "PartialDiskCacheProducer", null);
                    kVar.eqc();
                } else if (gVar.hC()) {
                    ewQ.a(id, "PartialDiskCacheProducer", gVar.hD(), (Map<String, String>) null);
                    ag.this.a(kVar, akVar, bVar, (com.facebook.imagepipeline.f.e) null);
                } else {
                    com.facebook.imagepipeline.f.e result = gVar.getResult();
                    if (result != null) {
                        ewQ.b(id, "PartialDiskCacheProducer", ag.a(ewQ, id, true, result.getSize()));
                        com.facebook.imagepipeline.common.a Pl = com.facebook.imagepipeline.common.a.Pl(result.getSize() - 1);
                        result.b(Pl);
                        int size = result.getSize();
                        ImageRequest ewP = akVar.ewP();
                        if (Pl.a(ewP.evW())) {
                            ewQ.M(id, "PartialDiskCacheProducer", true);
                            kVar.g(result, 9);
                        } else {
                            kVar.g(result, 8);
                            ag.this.a(kVar, new ap(ImageRequestBuilder.o(ewP).c(com.facebook.imagepipeline.common.a.Pk(size - 1)).exQ(), akVar), bVar, result);
                        }
                    } else {
                        ewQ.b(id, "PartialDiskCacheProducer", ag.a(ewQ, id, false, 0));
                        ag.this.a(kVar, akVar, bVar, result);
                    }
                }
                return null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar, com.facebook.cache.common.b bVar, @Nullable com.facebook.imagepipeline.f.e eVar) {
        this.pBf.a(new a(kVar, this.pzj, bVar, this.pwB, this.poT, eVar), akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(bolts.g<?> gVar) {
        return gVar.isCancelled() || (gVar.hC() && (gVar.hD() instanceof CancellationException));
    }

    @Nullable
    static Map<String, String> a(am amVar, String str, boolean z, int i) {
        if (!amVar.Ys(str)) {
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
            public void ewW() {
                atomicBoolean.set(true);
            }
        });
    }

    private static Uri n(ImageRequest imageRequest) {
        return imageRequest.exF().buildUpon().appendQueryParameter("fresco_partial", "true").build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private final com.facebook.cache.common.b pCx;
        @Nullable
        private final com.facebook.imagepipeline.f.e pCy;
        private final com.facebook.common.memory.a poT;
        private final com.facebook.common.memory.g pwB;
        private final com.facebook.imagepipeline.b.e pzj;

        private a(k<com.facebook.imagepipeline.f.e> kVar, com.facebook.imagepipeline.b.e eVar, com.facebook.cache.common.b bVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, @Nullable com.facebook.imagepipeline.f.e eVar2) {
            super(kVar);
            this.pzj = eVar;
            this.pCx = bVar;
            this.pwB = gVar;
            this.poT = aVar;
            this.pCy = eVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.f.e eVar, int i) {
            if (!PP(i)) {
                if (this.pCy != null && eVar.evW() != null) {
                    try {
                        a(a(this.pCy, eVar));
                    } catch (IOException e) {
                        com.facebook.common.c.a.e("PartialDiskCacheProducer", "Error while merging image data", e);
                        exc().D(e);
                    } finally {
                        eVar.close();
                        this.pCy.close();
                    }
                    this.pzj.n(this.pCx);
                } else if (ef(i, 8) && PO(i) && eVar.evV() != com.facebook.c.c.pvP) {
                    this.pzj.a(this.pCx, eVar);
                    exc().g(eVar, i);
                } else {
                    exc().g(eVar, i);
                }
            }
        }

        private com.facebook.common.memory.i a(com.facebook.imagepipeline.f.e eVar, com.facebook.imagepipeline.f.e eVar2) throws IOException {
            com.facebook.common.memory.i OA = this.pwB.OA(eVar2.getSize() + eVar2.evW().from);
            c(eVar.getInputStream(), OA, eVar2.evW().from);
            c(eVar2.getInputStream(), OA, eVar2.getSize());
            return OA;
        }

        private void c(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
            byte[] bArr = this.poT.get(16384);
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
                    this.poT.release(bArr);
                }
            }
            if (i2 > 0) {
                throw new IOException(String.format(null, "Failed to read %d bytes - finished %d short", Integer.valueOf(i), Integer.valueOf(i2)));
            }
        }

        private void a(com.facebook.common.memory.i iVar) {
            com.facebook.imagepipeline.f.e eVar;
            com.facebook.common.references.a f = com.facebook.common.references.a.f(iVar.eqp());
            try {
                eVar = new com.facebook.imagepipeline.f.e(f);
            } catch (Throwable th) {
                th = th;
                eVar = null;
            }
            try {
                eVar.evX();
                exc().g(eVar, 1);
                com.facebook.imagepipeline.f.e.e(eVar);
                com.facebook.common.references.a.c(f);
            } catch (Throwable th2) {
                th = th2;
                com.facebook.imagepipeline.f.e.e(eVar);
                com.facebook.common.references.a.c(f);
                throw th;
            }
        }
    }
}
