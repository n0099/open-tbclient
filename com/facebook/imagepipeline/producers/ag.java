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
    private final com.facebook.common.memory.g pBc;
    private final com.facebook.imagepipeline.b.f pCH;
    private final com.facebook.imagepipeline.b.e pDK;
    private final aj<com.facebook.imagepipeline.f.e> pFG;
    private final com.facebook.common.memory.a ptw;

    public ag(com.facebook.imagepipeline.b.e eVar, com.facebook.imagepipeline.b.f fVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.pDK = eVar;
        this.pCH = fVar;
        this.pBc = gVar;
        this.ptw = aVar;
        this.pFG = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        ImageRequest eAH = akVar.eAH();
        if (!eAH.eyf()) {
            this.pFG.a(kVar, akVar);
            return;
        }
        akVar.eAI().hn(akVar.getId(), "PartialDiskCacheProducer");
        com.facebook.cache.common.b a2 = this.pCH.a(eAH, n(eAH), akVar.evw());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.pDK.a(a2, atomicBoolean).a(a(kVar, akVar, a2));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.f.e, Void> a(final k<com.facebook.imagepipeline.f.e> kVar, final ak akVar, final com.facebook.cache.common.b bVar) {
        final String id = akVar.getId();
        final am eAI = akVar.eAI();
        return new bolts.f<com.facebook.imagepipeline.f.e, Void>() { // from class: com.facebook.imagepipeline.producers.ag.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.f.e> gVar) throws Exception {
                if (ag.d(gVar)) {
                    eAI.c(id, "PartialDiskCacheProducer", null);
                    kVar.etW();
                } else if (gVar.hC()) {
                    eAI.a(id, "PartialDiskCacheProducer", gVar.hD(), (Map<String, String>) null);
                    ag.this.a(kVar, akVar, bVar, (com.facebook.imagepipeline.f.e) null);
                } else {
                    com.facebook.imagepipeline.f.e result = gVar.getResult();
                    if (result != null) {
                        eAI.b(id, "PartialDiskCacheProducer", ag.a(eAI, id, true, result.getSize()));
                        com.facebook.imagepipeline.common.a QS = com.facebook.imagepipeline.common.a.QS(result.getSize() - 1);
                        result.b(QS);
                        int size = result.getSize();
                        ImageRequest eAH = akVar.eAH();
                        if (QS.a(eAH.ezO())) {
                            eAI.M(id, "PartialDiskCacheProducer", true);
                            kVar.g(result, 9);
                        } else {
                            kVar.g(result, 8);
                            ag.this.a(kVar, new ap(ImageRequestBuilder.o(eAH).c(com.facebook.imagepipeline.common.a.QR(size - 1)).eBI(), akVar), bVar, result);
                        }
                    } else {
                        eAI.b(id, "PartialDiskCacheProducer", ag.a(eAI, id, false, 0));
                        ag.this.a(kVar, akVar, bVar, result);
                    }
                }
                return null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar, com.facebook.cache.common.b bVar, @Nullable com.facebook.imagepipeline.f.e eVar) {
        this.pFG.a(new a(kVar, this.pDK, bVar, this.pBc, this.ptw, eVar), akVar);
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
            public void eAO() {
                atomicBoolean.set(true);
            }
        });
    }

    private static Uri n(ImageRequest imageRequest) {
        return imageRequest.eBx().buildUpon().appendQueryParameter("fresco_partial", "true").build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private final com.facebook.common.memory.g pBc;
        private final com.facebook.imagepipeline.b.e pDK;
        private final com.facebook.cache.common.b pGY;
        @Nullable
        private final com.facebook.imagepipeline.f.e pGZ;
        private final com.facebook.common.memory.a ptw;

        private a(k<com.facebook.imagepipeline.f.e> kVar, com.facebook.imagepipeline.b.e eVar, com.facebook.cache.common.b bVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, @Nullable com.facebook.imagepipeline.f.e eVar2) {
            super(kVar);
            this.pDK = eVar;
            this.pGY = bVar;
            this.pBc = gVar;
            this.ptw = aVar;
            this.pGZ = eVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.f.e eVar, int i) {
            if (!Rw(i)) {
                if (this.pGZ != null && eVar.ezO() != null) {
                    try {
                        a(a(this.pGZ, eVar));
                    } catch (IOException e) {
                        com.facebook.common.c.a.e("PartialDiskCacheProducer", "Error while merging image data", e);
                        eAU().D(e);
                    } finally {
                        eVar.close();
                        this.pGZ.close();
                    }
                    this.pDK.n(this.pGY);
                } else if (ef(i, 8) && Rv(i) && eVar.ezN() != com.facebook.c.c.pAq) {
                    this.pDK.a(this.pGY, eVar);
                    eAU().g(eVar, i);
                } else {
                    eAU().g(eVar, i);
                }
            }
        }

        private com.facebook.common.memory.i a(com.facebook.imagepipeline.f.e eVar, com.facebook.imagepipeline.f.e eVar2) throws IOException {
            com.facebook.common.memory.i Qh = this.pBc.Qh(eVar2.getSize() + eVar2.ezO().from);
            c(eVar.getInputStream(), Qh, eVar2.ezO().from);
            c(eVar2.getInputStream(), Qh, eVar2.getSize());
            return Qh;
        }

        private void c(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
            byte[] bArr = this.ptw.get(16384);
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
                    this.ptw.release(bArr);
                }
            }
            if (i2 > 0) {
                throw new IOException(String.format(null, "Failed to read %d bytes - finished %d short", Integer.valueOf(i), Integer.valueOf(i2)));
            }
        }

        private void a(com.facebook.common.memory.i iVar) {
            com.facebook.imagepipeline.f.e eVar;
            com.facebook.common.references.a f = com.facebook.common.references.a.f(iVar.euj());
            try {
                eVar = new com.facebook.imagepipeline.f.e(f);
            } catch (Throwable th) {
                th = th;
                eVar = null;
            }
            try {
                eVar.ezP();
                eAU().g(eVar, 1);
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
