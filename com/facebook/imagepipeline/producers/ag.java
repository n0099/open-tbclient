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
/* loaded from: classes5.dex */
public class ag implements aj<com.facebook.imagepipeline.f.e> {
    private final com.facebook.imagepipeline.b.f pBa;
    private final com.facebook.imagepipeline.b.e pCd;
    private final aj<com.facebook.imagepipeline.f.e> pDZ;
    private final com.facebook.common.memory.a pto;
    private final com.facebook.common.memory.g pzv;

    public ag(com.facebook.imagepipeline.b.e eVar, com.facebook.imagepipeline.b.f fVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.pCd = eVar;
        this.pBa = fVar;
        this.pzv = gVar;
        this.pto = aVar;
        this.pDZ = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        ImageRequest eAd = akVar.eAd();
        if (!eAd.exD()) {
            this.pDZ.a(kVar, akVar);
            return;
        }
        akVar.eAe().hm(akVar.getId(), "PartialDiskCacheProducer");
        com.facebook.cache.common.b a2 = this.pBa.a(eAd, n(eAd), akVar.evp());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.pCd.a(a2, atomicBoolean).a(a(kVar, akVar, a2));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.f.e, Void> a(final k<com.facebook.imagepipeline.f.e> kVar, final ak akVar, final com.facebook.cache.common.b bVar) {
        final String id = akVar.getId();
        final am eAe = akVar.eAe();
        return new bolts.f<com.facebook.imagepipeline.f.e, Void>() { // from class: com.facebook.imagepipeline.producers.ag.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.f.e> gVar) throws Exception {
                if (ag.d(gVar)) {
                    eAe.c(id, "PartialDiskCacheProducer", null);
                    kVar.etQ();
                } else if (gVar.hC()) {
                    eAe.a(id, "PartialDiskCacheProducer", gVar.hD(), (Map<String, String>) null);
                    ag.this.a(kVar, akVar, bVar, (com.facebook.imagepipeline.f.e) null);
                } else {
                    com.facebook.imagepipeline.f.e result = gVar.getResult();
                    if (result != null) {
                        eAe.b(id, "PartialDiskCacheProducer", ag.a(eAe, id, true, result.getSize()));
                        com.facebook.imagepipeline.common.a QB = com.facebook.imagepipeline.common.a.QB(result.getSize() - 1);
                        result.b(QB);
                        int size = result.getSize();
                        ImageRequest eAd = akVar.eAd();
                        if (QB.a(eAd.ezk())) {
                            eAe.M(id, "PartialDiskCacheProducer", true);
                            kVar.g(result, 9);
                        } else {
                            kVar.g(result, 8);
                            ag.this.a(kVar, new ap(ImageRequestBuilder.o(eAd).c(com.facebook.imagepipeline.common.a.QA(size - 1)).eBe(), akVar), bVar, result);
                        }
                    } else {
                        eAe.b(id, "PartialDiskCacheProducer", ag.a(eAe, id, false, 0));
                        ag.this.a(kVar, akVar, bVar, result);
                    }
                }
                return null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar, com.facebook.cache.common.b bVar, @Nullable com.facebook.imagepipeline.f.e eVar) {
        this.pDZ.a(new a(kVar, this.pCd, bVar, this.pzv, this.pto, eVar), akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(bolts.g<?> gVar) {
        return gVar.isCancelled() || (gVar.hC() && (gVar.hD() instanceof CancellationException));
    }

    @Nullable
    static Map<String, String> a(am amVar, String str, boolean z, int i) {
        if (!amVar.ZA(str)) {
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
            public void eAk() {
                atomicBoolean.set(true);
            }
        });
    }

    private static Uri n(ImageRequest imageRequest) {
        return imageRequest.eAT().buildUpon().appendQueryParameter("fresco_partial", "true").build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private final com.facebook.imagepipeline.b.e pCd;
        private final com.facebook.cache.common.b pFr;
        @Nullable
        private final com.facebook.imagepipeline.f.e pFs;
        private final com.facebook.common.memory.a pto;
        private final com.facebook.common.memory.g pzv;

        private a(k<com.facebook.imagepipeline.f.e> kVar, com.facebook.imagepipeline.b.e eVar, com.facebook.cache.common.b bVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, @Nullable com.facebook.imagepipeline.f.e eVar2) {
            super(kVar);
            this.pCd = eVar;
            this.pFr = bVar;
            this.pzv = gVar;
            this.pto = aVar;
            this.pFs = eVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.f.e eVar, int i) {
            if (!Rg(i)) {
                if (this.pFs != null && eVar.ezk() != null) {
                    try {
                        a(a(this.pFs, eVar));
                    } catch (IOException e) {
                        com.facebook.common.c.a.e("PartialDiskCacheProducer", "Error while merging image data", e);
                        eAq().D(e);
                    } finally {
                        eVar.close();
                        this.pFs.close();
                    }
                    this.pCd.n(this.pFr);
                } else if (ed(i, 8) && Rf(i) && eVar.ezj() != com.facebook.c.c.pzf) {
                    this.pCd.a(this.pFr, eVar);
                    eAq().g(eVar, i);
                } else {
                    eAq().g(eVar, i);
                }
            }
        }

        private com.facebook.common.memory.i a(com.facebook.imagepipeline.f.e eVar, com.facebook.imagepipeline.f.e eVar2) throws IOException {
            com.facebook.common.memory.i Qc = this.pzv.Qc(eVar2.getSize() + eVar2.ezk().from);
            c(eVar.getInputStream(), Qc, eVar2.ezk().from);
            c(eVar2.getInputStream(), Qc, eVar2.getSize());
            return Qc;
        }

        private void c(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
            byte[] bArr = this.pto.get(16384);
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
                    this.pto.release(bArr);
                }
            }
            if (i2 > 0) {
                throw new IOException(String.format(null, "Failed to read %d bytes - finished %d short", Integer.valueOf(i), Integer.valueOf(i2)));
            }
        }

        private void a(com.facebook.common.memory.i iVar) {
            com.facebook.imagepipeline.f.e eVar;
            com.facebook.common.references.a f = com.facebook.common.references.a.f(iVar.euc());
            try {
                eVar = new com.facebook.imagepipeline.f.e(f);
            } catch (Throwable th) {
                th = th;
                eVar = null;
            }
            try {
                eVar.ezl();
                eAq().g(eVar, 1);
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
