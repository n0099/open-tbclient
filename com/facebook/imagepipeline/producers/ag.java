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
    private final com.facebook.common.memory.a mlM;
    private final com.facebook.common.memory.g mtR;
    private final com.facebook.imagepipeline.c.f mvz;
    private final com.facebook.imagepipeline.c.e mwC;
    private final aj<com.facebook.imagepipeline.g.e> myy;

    public ag(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.f fVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.mwC = eVar;
        this.mvz = fVar;
        this.mtR = gVar;
        this.mlM = aVar;
        this.myy = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        ImageRequest dBi = akVar.dBi();
        if (!dBi.dyD()) {
            this.myy.c(kVar, akVar);
            return;
        }
        akVar.dBj().fK(akVar.getId(), "PartialDiskCacheProducer");
        com.facebook.cache.common.b a2 = this.mvz.a(dBi, n(dBi), akVar.dvM());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.mwC.a(a2, atomicBoolean).a(a(kVar, akVar, a2));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.g.e, Void> a(final k<com.facebook.imagepipeline.g.e> kVar, final ak akVar, final com.facebook.cache.common.b bVar) {
        final String id = akVar.getId();
        final am dBj = akVar.dBj();
        return new bolts.f<com.facebook.imagepipeline.g.e, Void>() { // from class: com.facebook.imagepipeline.producers.ag.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.g.e> gVar) throws Exception {
                if (ag.d(gVar)) {
                    dBj.b(id, "PartialDiskCacheProducer", null);
                    kVar.dum();
                } else if (gVar.gu()) {
                    dBj.a(id, "PartialDiskCacheProducer", gVar.gv(), (Map<String, String>) null);
                    ag.this.a(kVar, akVar, bVar, (com.facebook.imagepipeline.g.e) null);
                } else {
                    com.facebook.imagepipeline.g.e result = gVar.getResult();
                    if (result != null) {
                        dBj.a(id, "PartialDiskCacheProducer", ag.a(dBj, id, true, result.getSize()));
                        com.facebook.imagepipeline.common.a HA = com.facebook.imagepipeline.common.a.HA(result.getSize() - 1);
                        result.b(HA);
                        int size = result.getSize();
                        ImageRequest dBi = akVar.dBi();
                        if (HA.a(dBi.dAm())) {
                            dBj.F(id, "PartialDiskCacheProducer", true);
                            kVar.h(result, 9);
                        } else {
                            kVar.h(result, 8);
                            ag.this.a(kVar, new ap(ImageRequestBuilder.o(dBi).d(com.facebook.imagepipeline.common.a.Hz(size - 1)).dCl(), akVar), bVar, result);
                        }
                    } else {
                        dBj.a(id, "PartialDiskCacheProducer", ag.a(dBj, id, false, 0));
                        ag.this.a(kVar, akVar, bVar, result);
                    }
                }
                return null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, com.facebook.cache.common.b bVar, @Nullable com.facebook.imagepipeline.g.e eVar) {
        this.myy.c(new a(kVar, this.mwC, bVar, this.mtR, this.mlM, eVar), akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(bolts.g<?> gVar) {
        return gVar.isCancelled() || (gVar.gu() && (gVar.gv() instanceof CancellationException));
    }

    @Nullable
    static Map<String, String> a(am amVar, String str, boolean z, int i) {
        if (!amVar.Qc(str)) {
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
            public void dxA() {
                atomicBoolean.set(true);
            }
        });
    }

    private static Uri n(ImageRequest imageRequest) {
        return imageRequest.dCa().buildUpon().appendQueryParameter("fresco_partial", "true").build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.common.memory.a mlM;
        private final com.facebook.common.memory.g mtR;
        private final com.facebook.imagepipeline.c.e mwC;
        private final com.facebook.cache.common.b mzP;
        @Nullable
        private final com.facebook.imagepipeline.g.e mzQ;

        private a(k<com.facebook.imagepipeline.g.e> kVar, com.facebook.imagepipeline.c.e eVar, com.facebook.cache.common.b bVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, @Nullable com.facebook.imagepipeline.g.e eVar2) {
            super(kVar);
            this.mwC = eVar;
            this.mzP = bVar;
            this.mtR = gVar;
            this.mlM = aVar;
            this.mzQ = eVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (!Ie(i)) {
                if (this.mzQ != null && eVar.dAm() != null) {
                    try {
                        a(a(this.mzQ, eVar));
                    } catch (IOException e) {
                        com.facebook.common.c.a.e("PartialDiskCacheProducer", "Error while merging image data", e);
                        dBu().G(e);
                    } finally {
                        eVar.close();
                        this.mzQ.close();
                    }
                    this.mwC.n(this.mzP);
                } else if (dq(i, 8) && Id(i) && eVar.dAl() != com.facebook.c.c.msV) {
                    this.mwC.a(this.mzP, eVar);
                    dBu().h(eVar, i);
                } else {
                    dBu().h(eVar, i);
                }
            }
        }

        private com.facebook.common.memory.i a(com.facebook.imagepipeline.g.e eVar, com.facebook.imagepipeline.g.e eVar2) throws IOException {
            com.facebook.common.memory.i GN = this.mtR.GN(eVar2.getSize() + eVar2.dAm().from);
            c(eVar.getInputStream(), GN, eVar2.dAm().from);
            c(eVar2.getInputStream(), GN, eVar2.getSize());
            return GN;
        }

        private void c(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
            byte[] bArr = this.mlM.get(16384);
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
                    this.mlM.release(bArr);
                }
            }
            if (i2 > 0) {
                throw new IOException(String.format(null, "Failed to read %d bytes - finished %d short", Integer.valueOf(i), Integer.valueOf(i2)));
            }
        }

        private void a(com.facebook.common.memory.i iVar) {
            com.facebook.imagepipeline.g.e eVar;
            com.facebook.common.references.a e = com.facebook.common.references.a.e(iVar.duz());
            try {
                eVar = new com.facebook.imagepipeline.g.e(e);
            } catch (Throwable th) {
                th = th;
                eVar = null;
            }
            try {
                eVar.dAn();
                dBu().h(eVar, 1);
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
