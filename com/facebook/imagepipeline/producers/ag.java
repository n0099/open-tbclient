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
/* loaded from: classes4.dex */
public class ag implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.common.memory.a mRb;
    private final com.facebook.common.memory.g mZk;
    private final com.facebook.imagepipeline.c.f naS;
    private final com.facebook.imagepipeline.c.e nbX;
    private final aj<com.facebook.imagepipeline.g.e> ndT;

    public ag(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.f fVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.nbX = eVar;
        this.naS = fVar;
        this.mZk = gVar;
        this.mRb = aVar;
        this.ndT = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        ImageRequest dJo = akVar.dJo();
        if (!dJo.dGJ()) {
            this.ndT.c(kVar, akVar);
            return;
        }
        akVar.dJp().fW(akVar.getId(), "PartialDiskCacheProducer");
        com.facebook.cache.common.b a2 = this.naS.a(dJo, n(dJo), akVar.dDT());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.nbX.a(a2, atomicBoolean).a(a(kVar, akVar, a2));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.g.e, Void> a(final k<com.facebook.imagepipeline.g.e> kVar, final ak akVar, final com.facebook.cache.common.b bVar) {
        final String id = akVar.getId();
        final am dJp = akVar.dJp();
        return new bolts.f<com.facebook.imagepipeline.g.e, Void>() { // from class: com.facebook.imagepipeline.producers.ag.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.g.e> gVar) throws Exception {
                if (ag.d(gVar)) {
                    dJp.b(id, "PartialDiskCacheProducer", null);
                    kVar.dCt();
                } else if (gVar.gK()) {
                    dJp.a(id, "PartialDiskCacheProducer", gVar.gL(), (Map<String, String>) null);
                    ag.this.a(kVar, akVar, bVar, (com.facebook.imagepipeline.g.e) null);
                } else {
                    com.facebook.imagepipeline.g.e result = gVar.getResult();
                    if (result != null) {
                        dJp.a(id, "PartialDiskCacheProducer", ag.a(dJp, id, true, result.getSize()));
                        com.facebook.imagepipeline.common.a Je = com.facebook.imagepipeline.common.a.Je(result.getSize() - 1);
                        result.b(Je);
                        int size = result.getSize();
                        ImageRequest dJo = akVar.dJo();
                        if (Je.a(dJo.dIs())) {
                            dJp.G(id, "PartialDiskCacheProducer", true);
                            kVar.h(result, 9);
                        } else {
                            kVar.h(result, 8);
                            ag.this.a(kVar, new ap(ImageRequestBuilder.o(dJo).d(com.facebook.imagepipeline.common.a.Jd(size - 1)).dKr(), akVar), bVar, result);
                        }
                    } else {
                        dJp.a(id, "PartialDiskCacheProducer", ag.a(dJp, id, false, 0));
                        ag.this.a(kVar, akVar, bVar, result);
                    }
                }
                return null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, com.facebook.cache.common.b bVar, @Nullable com.facebook.imagepipeline.g.e eVar) {
        this.ndT.c(new a(kVar, this.nbX, bVar, this.mZk, this.mRb, eVar), akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(bolts.g<?> gVar) {
        return gVar.isCancelled() || (gVar.gK() && (gVar.gL() instanceof CancellationException));
    }

    @Nullable
    static Map<String, String> a(am amVar, String str, boolean z, int i) {
        if (!amVar.RB(str)) {
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
            public void dFG() {
                atomicBoolean.set(true);
            }
        });
    }

    private static Uri n(ImageRequest imageRequest) {
        return imageRequest.dKg().buildUpon().appendQueryParameter("fresco_partial", "true").build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.common.memory.a mRb;
        private final com.facebook.common.memory.g mZk;
        private final com.facebook.imagepipeline.c.e nbX;
        private final com.facebook.cache.common.b nfl;
        @Nullable
        private final com.facebook.imagepipeline.g.e nfm;

        private a(k<com.facebook.imagepipeline.g.e> kVar, com.facebook.imagepipeline.c.e eVar, com.facebook.cache.common.b bVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, @Nullable com.facebook.imagepipeline.g.e eVar2) {
            super(kVar);
            this.nbX = eVar;
            this.nfl = bVar;
            this.mZk = gVar;
            this.mRb = aVar;
            this.nfm = eVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (!JI(i)) {
                if (this.nfm != null && eVar.dIs() != null) {
                    try {
                        a(a(this.nfm, eVar));
                    } catch (IOException e) {
                        com.facebook.common.c.a.e("PartialDiskCacheProducer", "Error while merging image data", e);
                        dJA().F(e);
                    } finally {
                        eVar.close();
                        this.nfm.close();
                    }
                    this.nbX.n(this.nfl);
                } else if (dB(i, 8) && JH(i) && eVar.dIr() != com.facebook.c.c.mYp) {
                    this.nbX.a(this.nfl, eVar);
                    dJA().h(eVar, i);
                } else {
                    dJA().h(eVar, i);
                }
            }
        }

        private com.facebook.common.memory.i a(com.facebook.imagepipeline.g.e eVar, com.facebook.imagepipeline.g.e eVar2) throws IOException {
            com.facebook.common.memory.i Ir = this.mZk.Ir(eVar2.getSize() + eVar2.dIs().from);
            c(eVar.getInputStream(), Ir, eVar2.dIs().from);
            c(eVar2.getInputStream(), Ir, eVar2.getSize());
            return Ir;
        }

        private void c(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
            byte[] bArr = this.mRb.get(16384);
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
                    this.mRb.release(bArr);
                }
            }
            if (i2 > 0) {
                throw new IOException(String.format(null, "Failed to read %d bytes - finished %d short", Integer.valueOf(i), Integer.valueOf(i2)));
            }
        }

        private void a(com.facebook.common.memory.i iVar) {
            com.facebook.imagepipeline.g.e eVar;
            com.facebook.common.references.a e = com.facebook.common.references.a.e(iVar.dCG());
            try {
                eVar = new com.facebook.imagepipeline.g.e(e);
            } catch (Throwable th) {
                th = th;
                eVar = null;
            }
            try {
                eVar.dIt();
                dJA().h(eVar, 1);
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
