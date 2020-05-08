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
/* loaded from: classes12.dex */
public class ag implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.common.memory.a lRU;
    private final com.facebook.common.memory.g lZW;
    private final com.facebook.imagepipeline.c.f mbI;
    private final com.facebook.imagepipeline.c.e mcL;
    private final aj<com.facebook.imagepipeline.g.e> meH;

    public ag(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.f fVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.mcL = eVar;
        this.mbI = fVar;
        this.lZW = gVar;
        this.lRU = aVar;
        this.meH = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        ImageRequest dtQ = akVar.dtQ();
        if (!dtQ.drk()) {
            this.meH.c(kVar, akVar);
            return;
        }
        akVar.dtR().fi(akVar.getId(), "PartialDiskCacheProducer");
        com.facebook.cache.common.b a2 = this.mbI.a(dtQ, n(dtQ), akVar.dot());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.mcL.a(a2, atomicBoolean).a(a(kVar, akVar, a2));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.g.e, Void> a(final k<com.facebook.imagepipeline.g.e> kVar, final ak akVar, final com.facebook.cache.common.b bVar) {
        final String id = akVar.getId();
        final am dtR = akVar.dtR();
        return new bolts.f<com.facebook.imagepipeline.g.e, Void>() { // from class: com.facebook.imagepipeline.producers.ag.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.g.e> gVar) throws Exception {
                if (ag.d(gVar)) {
                    dtR.b(id, "PartialDiskCacheProducer", null);
                    kVar.dmS();
                } else if (gVar.gu()) {
                    dtR.a(id, "PartialDiskCacheProducer", gVar.gv(), (Map<String, String>) null);
                    ag.this.a(kVar, akVar, bVar, (com.facebook.imagepipeline.g.e) null);
                } else {
                    com.facebook.imagepipeline.g.e result = gVar.getResult();
                    if (result != null) {
                        dtR.a(id, "PartialDiskCacheProducer", ag.a(dtR, id, true, result.getSize()));
                        com.facebook.imagepipeline.common.a GO = com.facebook.imagepipeline.common.a.GO(result.getSize() - 1);
                        result.b(GO);
                        int size = result.getSize();
                        ImageRequest dtQ = akVar.dtQ();
                        if (GO.a(dtQ.dsT())) {
                            dtR.D(id, "PartialDiskCacheProducer", true);
                            kVar.h(result, 9);
                        } else {
                            kVar.h(result, 8);
                            ag.this.a(kVar, new ap(ImageRequestBuilder.o(dtQ).d(com.facebook.imagepipeline.common.a.GN(size - 1)).duT(), akVar), bVar, result);
                        }
                    } else {
                        dtR.a(id, "PartialDiskCacheProducer", ag.a(dtR, id, false, 0));
                        ag.this.a(kVar, akVar, bVar, result);
                    }
                }
                return null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, com.facebook.cache.common.b bVar, @Nullable com.facebook.imagepipeline.g.e eVar) {
        this.meH.c(new a(kVar, this.mcL, bVar, this.lZW, this.lRU, eVar), akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(bolts.g<?> gVar) {
        return gVar.isCancelled() || (gVar.gu() && (gVar.gv() instanceof CancellationException));
    }

    @Nullable
    static Map<String, String> a(am amVar, String str, boolean z, int i) {
        if (!amVar.Oo(str)) {
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
            public void dqh() {
                atomicBoolean.set(true);
            }
        });
    }

    private static Uri n(ImageRequest imageRequest) {
        return imageRequest.duI().buildUpon().appendQueryParameter("fresco_partial", "true").build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.common.memory.a lRU;
        private final com.facebook.common.memory.g lZW;
        private final com.facebook.imagepipeline.c.e mcL;
        private final com.facebook.cache.common.b mfY;
        @Nullable
        private final com.facebook.imagepipeline.g.e mfZ;

        private a(k<com.facebook.imagepipeline.g.e> kVar, com.facebook.imagepipeline.c.e eVar, com.facebook.cache.common.b bVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, @Nullable com.facebook.imagepipeline.g.e eVar2) {
            super(kVar);
            this.mcL = eVar;
            this.mfY = bVar;
            this.lZW = gVar;
            this.lRU = aVar;
            this.mfZ = eVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (!Hs(i)) {
                if (this.mfZ != null && eVar.dsT() != null) {
                    try {
                        a(a(this.mfZ, eVar));
                    } catch (IOException e) {
                        com.facebook.common.c.a.e("PartialDiskCacheProducer", "Error while merging image data", e);
                        duc().G(e);
                    } finally {
                        eVar.close();
                        this.mfZ.close();
                    }
                    this.mcL.n(this.mfY);
                } else if (dl(i, 8) && Hr(i) && eVar.dsS() != com.facebook.c.c.lZa) {
                    this.mcL.a(this.mfY, eVar);
                    duc().h(eVar, i);
                } else {
                    duc().h(eVar, i);
                }
            }
        }

        private com.facebook.common.memory.i a(com.facebook.imagepipeline.g.e eVar, com.facebook.imagepipeline.g.e eVar2) throws IOException {
            com.facebook.common.memory.i Gb = this.lZW.Gb(eVar2.getSize() + eVar2.dsT().from);
            b(eVar.getInputStream(), Gb, eVar2.dsT().from);
            b(eVar2.getInputStream(), Gb, eVar2.getSize());
            return Gb;
        }

        private void b(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
            byte[] bArr = this.lRU.get(16384);
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
                    this.lRU.release(bArr);
                }
            }
            if (i2 > 0) {
                throw new IOException(String.format(null, "Failed to read %d bytes - finished %d short", Integer.valueOf(i), Integer.valueOf(i2)));
            }
        }

        private void a(com.facebook.common.memory.i iVar) {
            com.facebook.imagepipeline.g.e eVar;
            com.facebook.common.references.a c = com.facebook.common.references.a.c(iVar.dnf());
            try {
                eVar = new com.facebook.imagepipeline.g.e(c);
            } catch (Throwable th) {
                th = th;
                eVar = null;
            }
            try {
                eVar.dsU();
                duc().h(eVar, 1);
                com.facebook.imagepipeline.g.e.e(eVar);
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) c);
            } catch (Throwable th2) {
                th = th2;
                com.facebook.imagepipeline.g.e.e(eVar);
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) c);
                throw th;
            }
        }
    }
}
