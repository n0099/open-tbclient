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
/* loaded from: classes10.dex */
public class ag implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.common.memory.a lHW;
    private final com.facebook.common.memory.g lPJ;
    private final com.facebook.imagepipeline.c.f lRr;
    private final com.facebook.imagepipeline.c.e lSw;
    private final aj<com.facebook.imagepipeline.g.e> lUs;

    public ag(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.f fVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.lSw = eVar;
        this.lRr = fVar;
        this.lPJ = gVar;
        this.lHW = aVar;
        this.lUs = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        ImageRequest dqj = akVar.dqj();
        if (!dqj.dnD()) {
            this.lUs.c(kVar, akVar);
            return;
        }
        akVar.dqk().fe(akVar.getId(), "PartialDiskCacheProducer");
        com.facebook.cache.common.b a2 = this.lRr.a(dqj, o(dqj), akVar.dkQ());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.lSw.a(a2, atomicBoolean).a(a(kVar, akVar, a2));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.g.e, Void> a(final k<com.facebook.imagepipeline.g.e> kVar, final ak akVar, final com.facebook.cache.common.b bVar) {
        final String id = akVar.getId();
        final am dqk = akVar.dqk();
        return new bolts.f<com.facebook.imagepipeline.g.e, Void>() { // from class: com.facebook.imagepipeline.producers.ag.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.g.e> gVar) throws Exception {
                if (ag.d(gVar)) {
                    dqk.b(id, "PartialDiskCacheProducer", null);
                    kVar.djp();
                } else if (gVar.aX()) {
                    dqk.a(id, "PartialDiskCacheProducer", gVar.aY(), (Map<String, String>) null);
                    ag.this.a(kVar, akVar, bVar, (com.facebook.imagepipeline.g.e) null);
                } else {
                    com.facebook.imagepipeline.g.e result = gVar.getResult();
                    if (result != null) {
                        dqk.a(id, "PartialDiskCacheProducer", ag.a(dqk, id, true, result.getSize()));
                        com.facebook.imagepipeline.common.a Ib = com.facebook.imagepipeline.common.a.Ib(result.getSize() - 1);
                        result.b(Ib);
                        int size = result.getSize();
                        ImageRequest dqj = akVar.dqj();
                        if (Ib.a(dqj.dpm())) {
                            dqk.C(id, "PartialDiskCacheProducer", true);
                            kVar.g(result, 9);
                        } else {
                            kVar.g(result, 8);
                            ag.this.a(kVar, new ap(ImageRequestBuilder.p(dqj).d(com.facebook.imagepipeline.common.a.Ia(size - 1)).dro(), akVar), bVar, result);
                        }
                    } else {
                        dqk.a(id, "PartialDiskCacheProducer", ag.a(dqk, id, false, 0));
                        ag.this.a(kVar, akVar, bVar, result);
                    }
                }
                return null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, com.facebook.cache.common.b bVar, @Nullable com.facebook.imagepipeline.g.e eVar) {
        this.lUs.c(new a(kVar, this.lSw, bVar, this.lPJ, this.lHW, eVar), akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(bolts.g<?> gVar) {
        return gVar.isCancelled() || (gVar.aX() && (gVar.aY() instanceof CancellationException));
    }

    @Nullable
    static Map<String, String> a(am amVar, String str, boolean z, int i) {
        if (!amVar.OQ(str)) {
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
            public void dmA() {
                atomicBoolean.set(true);
            }
        });
    }

    private static Uri o(ImageRequest imageRequest) {
        return imageRequest.drc().buildUpon().appendQueryParameter("fresco_partial", "true").build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.common.memory.a lHW;
        private final com.facebook.common.memory.g lPJ;
        private final com.facebook.imagepipeline.c.e lSw;
        private final com.facebook.cache.common.b lVJ;
        @Nullable
        private final com.facebook.imagepipeline.g.e lVK;

        private a(k<com.facebook.imagepipeline.g.e> kVar, com.facebook.imagepipeline.c.e eVar, com.facebook.cache.common.b bVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, @Nullable com.facebook.imagepipeline.g.e eVar2) {
            super(kVar);
            this.lSw = eVar;
            this.lVJ = bVar;
            this.lPJ = gVar;
            this.lHW = aVar;
            this.lVK = eVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.g.e eVar, int i) {
            if (!IF(i)) {
                if (this.lVK != null && eVar.dpm() != null) {
                    try {
                        a(a(this.lVK, eVar));
                    } catch (IOException e) {
                        com.facebook.common.c.a.e("PartialDiskCacheProducer", "Error while merging image data", e);
                        dqv().D(e);
                    } finally {
                        eVar.close();
                        this.lVK.close();
                    }
                    this.lSw.n(this.lVJ);
                } else if (dx(i, 8) && IE(i) && eVar.dpl() != com.facebook.c.c.lOR) {
                    this.lSw.a(this.lVJ, eVar);
                    dqv().g(eVar, i);
                } else {
                    dqv().g(eVar, i);
                }
            }
        }

        private com.facebook.common.memory.i a(com.facebook.imagepipeline.g.e eVar, com.facebook.imagepipeline.g.e eVar2) throws IOException {
            com.facebook.common.memory.i Hp = this.lPJ.Hp(eVar2.getSize() + eVar2.dpm().from);
            b(eVar.getInputStream(), Hp, eVar2.dpm().from);
            b(eVar2.getInputStream(), Hp, eVar2.getSize());
            return Hp;
        }

        private void b(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
            byte[] bArr = this.lHW.get(16384);
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
                    this.lHW.release(bArr);
                }
            }
            if (i2 > 0) {
                throw new IOException(String.format(null, "Failed to read %d bytes - finished %d short", Integer.valueOf(i), Integer.valueOf(i2)));
            }
        }

        private void a(com.facebook.common.memory.i iVar) {
            com.facebook.imagepipeline.g.e eVar;
            com.facebook.common.references.a b = com.facebook.common.references.a.b(iVar.djC());
            try {
                eVar = new com.facebook.imagepipeline.g.e(b);
            } catch (Throwable th) {
                th = th;
                eVar = null;
            }
            try {
                eVar.dpn();
                dqv().g(eVar, 1);
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
