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
    private final com.facebook.common.memory.a lRQ;
    private final com.facebook.common.memory.g lZS;
    private final com.facebook.imagepipeline.c.f mbE;
    private final com.facebook.imagepipeline.c.e mcH;
    private final aj<com.facebook.imagepipeline.g.e> meD;

    public ag(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.f fVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.mcH = eVar;
        this.mbE = fVar;
        this.lZS = gVar;
        this.lRQ = aVar;
        this.meD = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        ImageRequest dtT = akVar.dtT();
        if (!dtT.drn()) {
            this.meD.c(kVar, akVar);
            return;
        }
        akVar.dtU().fi(akVar.getId(), "PartialDiskCacheProducer");
        com.facebook.cache.common.b a2 = this.mbE.a(dtT, n(dtT), akVar.dow());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.mcH.a(a2, atomicBoolean).a(a(kVar, akVar, a2));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.g.e, Void> a(final k<com.facebook.imagepipeline.g.e> kVar, final ak akVar, final com.facebook.cache.common.b bVar) {
        final String id = akVar.getId();
        final am dtU = akVar.dtU();
        return new bolts.f<com.facebook.imagepipeline.g.e, Void>() { // from class: com.facebook.imagepipeline.producers.ag.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.g.e> gVar) throws Exception {
                if (ag.d(gVar)) {
                    dtU.b(id, "PartialDiskCacheProducer", null);
                    kVar.dmV();
                } else if (gVar.gu()) {
                    dtU.a(id, "PartialDiskCacheProducer", gVar.gv(), (Map<String, String>) null);
                    ag.this.a(kVar, akVar, bVar, (com.facebook.imagepipeline.g.e) null);
                } else {
                    com.facebook.imagepipeline.g.e result = gVar.getResult();
                    if (result != null) {
                        dtU.a(id, "PartialDiskCacheProducer", ag.a(dtU, id, true, result.getSize()));
                        com.facebook.imagepipeline.common.a GO = com.facebook.imagepipeline.common.a.GO(result.getSize() - 1);
                        result.b(GO);
                        int size = result.getSize();
                        ImageRequest dtT = akVar.dtT();
                        if (GO.a(dtT.dsW())) {
                            dtU.D(id, "PartialDiskCacheProducer", true);
                            kVar.h(result, 9);
                        } else {
                            kVar.h(result, 8);
                            ag.this.a(kVar, new ap(ImageRequestBuilder.o(dtT).d(com.facebook.imagepipeline.common.a.GN(size - 1)).duW(), akVar), bVar, result);
                        }
                    } else {
                        dtU.a(id, "PartialDiskCacheProducer", ag.a(dtU, id, false, 0));
                        ag.this.a(kVar, akVar, bVar, result);
                    }
                }
                return null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, com.facebook.cache.common.b bVar, @Nullable com.facebook.imagepipeline.g.e eVar) {
        this.meD.c(new a(kVar, this.mcH, bVar, this.lZS, this.lRQ, eVar), akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(bolts.g<?> gVar) {
        return gVar.isCancelled() || (gVar.gu() && (gVar.gv() instanceof CancellationException));
    }

    @Nullable
    static Map<String, String> a(am amVar, String str, boolean z, int i) {
        if (!amVar.Ol(str)) {
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
            public void dqk() {
                atomicBoolean.set(true);
            }
        });
    }

    private static Uri n(ImageRequest imageRequest) {
        return imageRequest.duL().buildUpon().appendQueryParameter("fresco_partial", "true").build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.common.memory.a lRQ;
        private final com.facebook.common.memory.g lZS;
        private final com.facebook.imagepipeline.c.e mcH;
        private final com.facebook.cache.common.b mfU;
        @Nullable
        private final com.facebook.imagepipeline.g.e mfV;

        private a(k<com.facebook.imagepipeline.g.e> kVar, com.facebook.imagepipeline.c.e eVar, com.facebook.cache.common.b bVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, @Nullable com.facebook.imagepipeline.g.e eVar2) {
            super(kVar);
            this.mcH = eVar;
            this.mfU = bVar;
            this.lZS = gVar;
            this.lRQ = aVar;
            this.mfV = eVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (!Hs(i)) {
                if (this.mfV != null && eVar.dsW() != null) {
                    try {
                        a(a(this.mfV, eVar));
                    } catch (IOException e) {
                        com.facebook.common.c.a.e("PartialDiskCacheProducer", "Error while merging image data", e);
                        duf().G(e);
                    } finally {
                        eVar.close();
                        this.mfV.close();
                    }
                    this.mcH.n(this.mfU);
                } else if (dl(i, 8) && Hr(i) && eVar.dsV() != com.facebook.c.c.lYW) {
                    this.mcH.a(this.mfU, eVar);
                    duf().h(eVar, i);
                } else {
                    duf().h(eVar, i);
                }
            }
        }

        private com.facebook.common.memory.i a(com.facebook.imagepipeline.g.e eVar, com.facebook.imagepipeline.g.e eVar2) throws IOException {
            com.facebook.common.memory.i Gb = this.lZS.Gb(eVar2.getSize() + eVar2.dsW().from);
            b(eVar.getInputStream(), Gb, eVar2.dsW().from);
            b(eVar2.getInputStream(), Gb, eVar2.getSize());
            return Gb;
        }

        private void b(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
            byte[] bArr = this.lRQ.get(16384);
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
                    this.lRQ.release(bArr);
                }
            }
            if (i2 > 0) {
                throw new IOException(String.format(null, "Failed to read %d bytes - finished %d short", Integer.valueOf(i), Integer.valueOf(i2)));
            }
        }

        private void a(com.facebook.common.memory.i iVar) {
            com.facebook.imagepipeline.g.e eVar;
            com.facebook.common.references.a c = com.facebook.common.references.a.c(iVar.dni());
            try {
                eVar = new com.facebook.imagepipeline.g.e(c);
            } catch (Throwable th) {
                th = th;
                eVar = null;
            }
            try {
                eVar.dsX();
                duf().h(eVar, 1);
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
