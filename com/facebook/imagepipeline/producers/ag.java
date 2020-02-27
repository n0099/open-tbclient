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
    private final com.facebook.common.memory.a lID;
    private final com.facebook.common.memory.g lQq;
    private final com.facebook.imagepipeline.c.f lRY;
    private final com.facebook.imagepipeline.c.e lTd;
    private final aj<com.facebook.imagepipeline.g.e> lUZ;

    public ag(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.f fVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.lTd = eVar;
        this.lRY = fVar;
        this.lQq = gVar;
        this.lID = aVar;
        this.lUZ = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        ImageRequest drv = akVar.drv();
        if (!drv.doP()) {
            this.lUZ.c(kVar, akVar);
            return;
        }
        akVar.drw().fm(akVar.getId(), "PartialDiskCacheProducer");
        com.facebook.cache.common.b a2 = this.lRY.a(drv, o(drv), akVar.dmd());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.lTd.a(a2, atomicBoolean).a(a(kVar, akVar, a2));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.g.e, Void> a(final k<com.facebook.imagepipeline.g.e> kVar, final ak akVar, final com.facebook.cache.common.b bVar) {
        final String id = akVar.getId();
        final am drw = akVar.drw();
        return new bolts.f<com.facebook.imagepipeline.g.e, Void>() { // from class: com.facebook.imagepipeline.producers.ag.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.g.e> gVar) throws Exception {
                if (ag.d(gVar)) {
                    drw.b(id, "PartialDiskCacheProducer", null);
                    kVar.dkC();
                } else if (gVar.aX()) {
                    drw.a(id, "PartialDiskCacheProducer", gVar.aY(), (Map<String, String>) null);
                    ag.this.a(kVar, akVar, bVar, (com.facebook.imagepipeline.g.e) null);
                } else {
                    com.facebook.imagepipeline.g.e result = gVar.getResult();
                    if (result != null) {
                        drw.a(id, "PartialDiskCacheProducer", ag.a(drw, id, true, result.getSize()));
                        com.facebook.imagepipeline.common.a Ig = com.facebook.imagepipeline.common.a.Ig(result.getSize() - 1);
                        result.b(Ig);
                        int size = result.getSize();
                        ImageRequest drv = akVar.drv();
                        if (Ig.a(drv.dqy())) {
                            drw.D(id, "PartialDiskCacheProducer", true);
                            kVar.g(result, 9);
                        } else {
                            kVar.g(result, 8);
                            ag.this.a(kVar, new ap(ImageRequestBuilder.p(drv).d(com.facebook.imagepipeline.common.a.If(size - 1)).dsA(), akVar), bVar, result);
                        }
                    } else {
                        drw.a(id, "PartialDiskCacheProducer", ag.a(drw, id, false, 0));
                        ag.this.a(kVar, akVar, bVar, result);
                    }
                }
                return null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, com.facebook.cache.common.b bVar, @Nullable com.facebook.imagepipeline.g.e eVar) {
        this.lUZ.c(new a(kVar, this.lTd, bVar, this.lQq, this.lID, eVar), akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(bolts.g<?> gVar) {
        return gVar.isCancelled() || (gVar.aX() && (gVar.aY() instanceof CancellationException));
    }

    @Nullable
    static Map<String, String> a(am amVar, String str, boolean z, int i) {
        if (!amVar.Pd(str)) {
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
            public void dnN() {
                atomicBoolean.set(true);
            }
        });
    }

    private static Uri o(ImageRequest imageRequest) {
        return imageRequest.dso().buildUpon().appendQueryParameter("fresco_partial", "true").build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.common.memory.a lID;
        private final com.facebook.common.memory.g lQq;
        private final com.facebook.imagepipeline.c.e lTd;
        private final com.facebook.cache.common.b lWq;
        @Nullable
        private final com.facebook.imagepipeline.g.e lWr;

        private a(k<com.facebook.imagepipeline.g.e> kVar, com.facebook.imagepipeline.c.e eVar, com.facebook.cache.common.b bVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, @Nullable com.facebook.imagepipeline.g.e eVar2) {
            super(kVar);
            this.lTd = eVar;
            this.lWq = bVar;
            this.lQq = gVar;
            this.lID = aVar;
            this.lWr = eVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.g.e eVar, int i) {
            if (!IK(i)) {
                if (this.lWr != null && eVar.dqy() != null) {
                    try {
                        a(a(this.lWr, eVar));
                    } catch (IOException e) {
                        com.facebook.common.c.a.e("PartialDiskCacheProducer", "Error while merging image data", e);
                        drH().C(e);
                    } finally {
                        eVar.close();
                        this.lWr.close();
                    }
                    this.lTd.n(this.lWq);
                } else if (dA(i, 8) && IJ(i) && eVar.dqx() != com.facebook.c.c.lPy) {
                    this.lTd.a(this.lWq, eVar);
                    drH().g(eVar, i);
                } else {
                    drH().g(eVar, i);
                }
            }
        }

        private com.facebook.common.memory.i a(com.facebook.imagepipeline.g.e eVar, com.facebook.imagepipeline.g.e eVar2) throws IOException {
            com.facebook.common.memory.i Hu = this.lQq.Hu(eVar2.getSize() + eVar2.dqy().from);
            b(eVar.getInputStream(), Hu, eVar2.dqy().from);
            b(eVar2.getInputStream(), Hu, eVar2.getSize());
            return Hu;
        }

        private void b(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
            byte[] bArr = this.lID.get(16384);
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
                    this.lID.release(bArr);
                }
            }
            if (i2 > 0) {
                throw new IOException(String.format(null, "Failed to read %d bytes - finished %d short", Integer.valueOf(i), Integer.valueOf(i2)));
            }
        }

        private void a(com.facebook.common.memory.i iVar) {
            com.facebook.imagepipeline.g.e eVar;
            com.facebook.common.references.a b = com.facebook.common.references.a.b(iVar.dkP());
            try {
                eVar = new com.facebook.imagepipeline.g.e(b);
            } catch (Throwable th) {
                th = th;
                eVar = null;
            }
            try {
                eVar.dqz();
                drH().g(eVar, 1);
                com.facebook.imagepipeline.g.e.e(eVar);
                com.facebook.common.references.a.c(b);
            } catch (Throwable th2) {
                th = th2;
                com.facebook.imagepipeline.g.e.e(eVar);
                com.facebook.common.references.a.c(b);
                throw th;
            }
        }
    }
}
