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
    private final com.facebook.common.memory.a pBJ;
    private final com.facebook.common.memory.g pJp;
    private final com.facebook.imagepipeline.b.f pKU;
    private final com.facebook.imagepipeline.b.e pLX;
    private final aj<com.facebook.imagepipeline.f.e> pNT;

    public ag(com.facebook.imagepipeline.b.e eVar, com.facebook.imagepipeline.b.f fVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.pLX = eVar;
        this.pKU = fVar;
        this.pJp = gVar;
        this.pBJ = aVar;
        this.pNT = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        ImageRequest ezy = akVar.ezy();
        if (!ezy.ewX()) {
            this.pNT.a(kVar, akVar);
            return;
        }
        akVar.ezz().hv(akVar.getId(), "PartialDiskCacheProducer");
        com.facebook.cache.common.b a2 = this.pKU.a(ezy, n(ezy), akVar.eum());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.pLX.a(a2, atomicBoolean).a(a(kVar, akVar, a2));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.f.e, Void> a(final k<com.facebook.imagepipeline.f.e> kVar, final ak akVar, final com.facebook.cache.common.b bVar) {
        final String id = akVar.getId();
        final am ezz = akVar.ezz();
        return new bolts.f<com.facebook.imagepipeline.f.e, Void>() { // from class: com.facebook.imagepipeline.producers.ag.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.f.e> gVar) throws Exception {
                if (ag.d(gVar)) {
                    ezz.c(id, "PartialDiskCacheProducer", null);
                    kVar.esM();
                } else if (gVar.hJ()) {
                    ezz.a(id, "PartialDiskCacheProducer", gVar.hK(), (Map<String, String>) null);
                    ag.this.a(kVar, akVar, bVar, (com.facebook.imagepipeline.f.e) null);
                } else {
                    com.facebook.imagepipeline.f.e result = gVar.getResult();
                    if (result != null) {
                        ezz.b(id, "PartialDiskCacheProducer", ag.a(ezz, id, true, result.getSize()));
                        com.facebook.imagepipeline.common.a PL = com.facebook.imagepipeline.common.a.PL(result.getSize() - 1);
                        result.b(PL);
                        int size = result.getSize();
                        ImageRequest ezy = akVar.ezy();
                        if (PL.a(ezy.eyG())) {
                            ezz.M(id, "PartialDiskCacheProducer", true);
                            kVar.f(result, 9);
                        } else {
                            kVar.f(result, 8);
                            ag.this.a(kVar, new ap(ImageRequestBuilder.o(ezy).c(com.facebook.imagepipeline.common.a.PK(size - 1)).eAz(), akVar), bVar, result);
                        }
                    } else {
                        ezz.b(id, "PartialDiskCacheProducer", ag.a(ezz, id, false, 0));
                        ag.this.a(kVar, akVar, bVar, result);
                    }
                }
                return null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar, com.facebook.cache.common.b bVar, @Nullable com.facebook.imagepipeline.f.e eVar) {
        this.pNT.a(new a(kVar, this.pLX, bVar, this.pJp, this.pBJ, eVar), akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(bolts.g<?> gVar) {
        return gVar.isCancelled() || (gVar.hJ() && (gVar.hK() instanceof CancellationException));
    }

    @Nullable
    static Map<String, String> a(am amVar, String str, boolean z, int i) {
        if (!amVar.ZM(str)) {
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
            public void ezF() {
                atomicBoolean.set(true);
            }
        });
    }

    private static Uri n(ImageRequest imageRequest) {
        return imageRequest.eAo().buildUpon().appendQueryParameter("fresco_partial", "true").build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private final com.facebook.common.memory.a pBJ;
        private final com.facebook.common.memory.g pJp;
        private final com.facebook.imagepipeline.b.e pLX;
        private final com.facebook.cache.common.b pPl;
        @Nullable
        private final com.facebook.imagepipeline.f.e pPm;

        private a(k<com.facebook.imagepipeline.f.e> kVar, com.facebook.imagepipeline.b.e eVar, com.facebook.cache.common.b bVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, @Nullable com.facebook.imagepipeline.f.e eVar2) {
            super(kVar);
            this.pLX = eVar;
            this.pPl = bVar;
            this.pJp = gVar;
            this.pBJ = aVar;
            this.pPm = eVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void e(com.facebook.imagepipeline.f.e eVar, int i) {
            if (!Qp(i)) {
                if (this.pPm != null && eVar.eyG() != null) {
                    try {
                        a(a(this.pPm, eVar));
                    } catch (IOException e) {
                        com.facebook.common.c.a.e("PartialDiskCacheProducer", "Error while merging image data", e);
                        ezL().C(e);
                    } finally {
                        eVar.close();
                        this.pPm.close();
                    }
                    this.pLX.n(this.pPl);
                } else if (ed(i, 8) && Qo(i) && eVar.eyF() != com.facebook.c.c.pID) {
                    this.pLX.a(this.pPl, eVar);
                    ezL().f(eVar, i);
                } else {
                    ezL().f(eVar, i);
                }
            }
        }

        private com.facebook.common.memory.i a(com.facebook.imagepipeline.f.e eVar, com.facebook.imagepipeline.f.e eVar2) throws IOException {
            com.facebook.common.memory.i Pa = this.pJp.Pa(eVar2.getSize() + eVar2.eyG().from);
            c(eVar.getInputStream(), Pa, eVar2.eyG().from);
            c(eVar2.getInputStream(), Pa, eVar2.getSize());
            return Pa;
        }

        private void c(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
            byte[] bArr = this.pBJ.get(16384);
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
                    this.pBJ.release(bArr);
                }
            }
            if (i2 > 0) {
                throw new IOException(String.format(null, "Failed to read %d bytes - finished %d short", Integer.valueOf(i), Integer.valueOf(i2)));
            }
        }

        private void a(com.facebook.common.memory.i iVar) {
            com.facebook.imagepipeline.f.e eVar;
            com.facebook.common.references.a d = com.facebook.common.references.a.d(iVar.esZ());
            try {
                eVar = new com.facebook.imagepipeline.f.e(d);
            } catch (Throwable th) {
                th = th;
                eVar = null;
            }
            try {
                eVar.eyH();
                ezL().f(eVar, 1);
                com.facebook.imagepipeline.f.e.e(eVar);
                com.facebook.common.references.a.c(d);
            } catch (Throwable th2) {
                th = th2;
                com.facebook.imagepipeline.f.e.e(eVar);
                com.facebook.common.references.a.c(d);
                throw th;
            }
        }
    }
}
