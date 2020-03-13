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
    private final com.facebook.common.memory.a lIQ;
    private final com.facebook.common.memory.g lQD;
    private final com.facebook.imagepipeline.c.f lSl;
    private final com.facebook.imagepipeline.c.e lTq;
    private final aj<com.facebook.imagepipeline.g.e> lVm;

    public ag(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.f fVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.lTq = eVar;
        this.lSl = fVar;
        this.lQD = gVar;
        this.lIQ = aVar;
        this.lVm = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        ImageRequest dry = akVar.dry();
        if (!dry.doS()) {
            this.lVm.c(kVar, akVar);
            return;
        }
        akVar.drz().fm(akVar.getId(), "PartialDiskCacheProducer");
        com.facebook.cache.common.b a2 = this.lSl.a(dry, o(dry), akVar.dmg());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.lTq.a(a2, atomicBoolean).a(a(kVar, akVar, a2));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.g.e, Void> a(final k<com.facebook.imagepipeline.g.e> kVar, final ak akVar, final com.facebook.cache.common.b bVar) {
        final String id = akVar.getId();
        final am drz = akVar.drz();
        return new bolts.f<com.facebook.imagepipeline.g.e, Void>() { // from class: com.facebook.imagepipeline.producers.ag.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.g.e> gVar) throws Exception {
                if (ag.d(gVar)) {
                    drz.b(id, "PartialDiskCacheProducer", null);
                    kVar.dkF();
                } else if (gVar.aX()) {
                    drz.a(id, "PartialDiskCacheProducer", gVar.aY(), (Map<String, String>) null);
                    ag.this.a(kVar, akVar, bVar, (com.facebook.imagepipeline.g.e) null);
                } else {
                    com.facebook.imagepipeline.g.e result = gVar.getResult();
                    if (result != null) {
                        drz.a(id, "PartialDiskCacheProducer", ag.a(drz, id, true, result.getSize()));
                        com.facebook.imagepipeline.common.a Ig = com.facebook.imagepipeline.common.a.Ig(result.getSize() - 1);
                        result.b(Ig);
                        int size = result.getSize();
                        ImageRequest dry = akVar.dry();
                        if (Ig.a(dry.dqB())) {
                            drz.D(id, "PartialDiskCacheProducer", true);
                            kVar.g(result, 9);
                        } else {
                            kVar.g(result, 8);
                            ag.this.a(kVar, new ap(ImageRequestBuilder.p(dry).d(com.facebook.imagepipeline.common.a.If(size - 1)).dsD(), akVar), bVar, result);
                        }
                    } else {
                        drz.a(id, "PartialDiskCacheProducer", ag.a(drz, id, false, 0));
                        ag.this.a(kVar, akVar, bVar, result);
                    }
                }
                return null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, com.facebook.cache.common.b bVar, @Nullable com.facebook.imagepipeline.g.e eVar) {
        this.lVm.c(new a(kVar, this.lTq, bVar, this.lQD, this.lIQ, eVar), akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(bolts.g<?> gVar) {
        return gVar.isCancelled() || (gVar.aX() && (gVar.aY() instanceof CancellationException));
    }

    @Nullable
    static Map<String, String> a(am amVar, String str, boolean z, int i) {
        if (!amVar.Pe(str)) {
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
            public void dnQ() {
                atomicBoolean.set(true);
            }
        });
    }

    private static Uri o(ImageRequest imageRequest) {
        return imageRequest.dsr().buildUpon().appendQueryParameter("fresco_partial", "true").build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.common.memory.a lIQ;
        private final com.facebook.common.memory.g lQD;
        private final com.facebook.imagepipeline.c.e lTq;
        private final com.facebook.cache.common.b lWD;
        @Nullable
        private final com.facebook.imagepipeline.g.e lWE;

        private a(k<com.facebook.imagepipeline.g.e> kVar, com.facebook.imagepipeline.c.e eVar, com.facebook.cache.common.b bVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, @Nullable com.facebook.imagepipeline.g.e eVar2) {
            super(kVar);
            this.lTq = eVar;
            this.lWD = bVar;
            this.lQD = gVar;
            this.lIQ = aVar;
            this.lWE = eVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.g.e eVar, int i) {
            if (!IK(i)) {
                if (this.lWE != null && eVar.dqB() != null) {
                    try {
                        a(a(this.lWE, eVar));
                    } catch (IOException e) {
                        com.facebook.common.c.a.e("PartialDiskCacheProducer", "Error while merging image data", e);
                        drK().C(e);
                    } finally {
                        eVar.close();
                        this.lWE.close();
                    }
                    this.lTq.n(this.lWD);
                } else if (dA(i, 8) && IJ(i) && eVar.dqA() != com.facebook.c.c.lPL) {
                    this.lTq.a(this.lWD, eVar);
                    drK().g(eVar, i);
                } else {
                    drK().g(eVar, i);
                }
            }
        }

        private com.facebook.common.memory.i a(com.facebook.imagepipeline.g.e eVar, com.facebook.imagepipeline.g.e eVar2) throws IOException {
            com.facebook.common.memory.i Hu = this.lQD.Hu(eVar2.getSize() + eVar2.dqB().from);
            b(eVar.getInputStream(), Hu, eVar2.dqB().from);
            b(eVar2.getInputStream(), Hu, eVar2.getSize());
            return Hu;
        }

        private void b(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
            byte[] bArr = this.lIQ.get(16384);
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
                    this.lIQ.release(bArr);
                }
            }
            if (i2 > 0) {
                throw new IOException(String.format(null, "Failed to read %d bytes - finished %d short", Integer.valueOf(i), Integer.valueOf(i2)));
            }
        }

        private void a(com.facebook.common.memory.i iVar) {
            com.facebook.imagepipeline.g.e eVar;
            com.facebook.common.references.a b = com.facebook.common.references.a.b(iVar.dkS());
            try {
                eVar = new com.facebook.imagepipeline.g.e(b);
            } catch (Throwable th) {
                th = th;
                eVar = null;
            }
            try {
                eVar.dqC();
                drK().g(eVar, 1);
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
