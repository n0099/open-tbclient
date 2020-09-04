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
/* loaded from: classes8.dex */
public class ag implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.common.memory.a nlq;
    private final com.facebook.common.memory.g ntt;
    private final com.facebook.imagepipeline.c.f nvc;
    private final com.facebook.imagepipeline.c.e nwh;
    private final aj<com.facebook.imagepipeline.g.e> nyd;

    public ag(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.f fVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.nwh = eVar;
        this.nvc = fVar;
        this.ntt = gVar;
        this.nlq = aVar;
        this.nyd = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        ImageRequest dVx = akVar.dVx();
        if (!dVx.dSS()) {
            this.nyd.c(kVar, akVar);
            return;
        }
        akVar.dVy().go(akVar.getId(), "PartialDiskCacheProducer");
        com.facebook.cache.common.b a2 = this.nvc.a(dVx, n(dVx), akVar.dQd());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.nwh.a(a2, atomicBoolean).a(a(kVar, akVar, a2));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.g.e, Void> a(final k<com.facebook.imagepipeline.g.e> kVar, final ak akVar, final com.facebook.cache.common.b bVar) {
        final String id = akVar.getId();
        final am dVy = akVar.dVy();
        return new bolts.f<com.facebook.imagepipeline.g.e, Void>() { // from class: com.facebook.imagepipeline.producers.ag.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.g.e> gVar) throws Exception {
                if (ag.d(gVar)) {
                    dVy.b(id, "PartialDiskCacheProducer", null);
                    kVar.dOD();
                } else if (gVar.ik()) {
                    dVy.a(id, "PartialDiskCacheProducer", gVar.il(), (Map<String, String>) null);
                    ag.this.a(kVar, akVar, bVar, (com.facebook.imagepipeline.g.e) null);
                } else {
                    com.facebook.imagepipeline.g.e result = gVar.getResult();
                    if (result != null) {
                        dVy.a(id, "PartialDiskCacheProducer", ag.a(dVy, id, true, result.getSize()));
                        com.facebook.imagepipeline.common.a LI = com.facebook.imagepipeline.common.a.LI(result.getSize() - 1);
                        result.b(LI);
                        int size = result.getSize();
                        ImageRequest dVx = akVar.dVx();
                        if (LI.a(dVx.dUB())) {
                            dVy.F(id, "PartialDiskCacheProducer", true);
                            kVar.h(result, 9);
                        } else {
                            kVar.h(result, 8);
                            ag.this.a(kVar, new ap(ImageRequestBuilder.o(dVx).d(com.facebook.imagepipeline.common.a.LH(size - 1)).dWA(), akVar), bVar, result);
                        }
                    } else {
                        dVy.a(id, "PartialDiskCacheProducer", ag.a(dVy, id, false, 0));
                        ag.this.a(kVar, akVar, bVar, result);
                    }
                }
                return null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, com.facebook.cache.common.b bVar, @Nullable com.facebook.imagepipeline.g.e eVar) {
        this.nyd.c(new a(kVar, this.nwh, bVar, this.ntt, this.nlq, eVar), akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(bolts.g<?> gVar) {
        return gVar.isCancelled() || (gVar.ik() && (gVar.il() instanceof CancellationException));
    }

    @Nullable
    static Map<String, String> a(am amVar, String str, boolean z, int i) {
        if (!amVar.UF(str)) {
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
            public void dRP() {
                atomicBoolean.set(true);
            }
        });
    }

    private static Uri n(ImageRequest imageRequest) {
        return imageRequest.dWp().buildUpon().appendQueryParameter("fresco_partial", "true").build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.common.memory.a nlq;
        private final com.facebook.common.memory.g ntt;
        private final com.facebook.imagepipeline.c.e nwh;
        private final com.facebook.cache.common.b nzu;
        @Nullable
        private final com.facebook.imagepipeline.g.e nzv;

        private a(k<com.facebook.imagepipeline.g.e> kVar, com.facebook.imagepipeline.c.e eVar, com.facebook.cache.common.b bVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, @Nullable com.facebook.imagepipeline.g.e eVar2) {
            super(kVar);
            this.nwh = eVar;
            this.nzu = bVar;
            this.ntt = gVar;
            this.nlq = aVar;
            this.nzv = eVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (!Mm(i)) {
                if (this.nzv != null && eVar.dUB() != null) {
                    try {
                        a(a(this.nzv, eVar));
                    } catch (IOException e) {
                        com.facebook.common.c.a.e("PartialDiskCacheProducer", "Error while merging image data", e);
                        dVJ().E(e);
                    } finally {
                        eVar.close();
                        this.nzv.close();
                    }
                    this.nwh.n(this.nzu);
                } else if (dJ(i, 8) && Ml(i) && eVar.dUA() != com.facebook.c.c.nsy) {
                    this.nwh.a(this.nzu, eVar);
                    dVJ().h(eVar, i);
                } else {
                    dVJ().h(eVar, i);
                }
            }
        }

        private com.facebook.common.memory.i a(com.facebook.imagepipeline.g.e eVar, com.facebook.imagepipeline.g.e eVar2) throws IOException {
            com.facebook.common.memory.i KV = this.ntt.KV(eVar2.getSize() + eVar2.dUB().from);
            c(eVar.getInputStream(), KV, eVar2.dUB().from);
            c(eVar2.getInputStream(), KV, eVar2.getSize());
            return KV;
        }

        private void c(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
            byte[] bArr = this.nlq.get(16384);
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
                    this.nlq.release(bArr);
                }
            }
            if (i2 > 0) {
                throw new IOException(String.format(null, "Failed to read %d bytes - finished %d short", Integer.valueOf(i), Integer.valueOf(i2)));
            }
        }

        private void a(com.facebook.common.memory.i iVar) {
            com.facebook.imagepipeline.g.e eVar;
            com.facebook.common.references.a e = com.facebook.common.references.a.e(iVar.dOQ());
            try {
                eVar = new com.facebook.imagepipeline.g.e(e);
            } catch (Throwable th) {
                th = th;
                eVar = null;
            }
            try {
                eVar.dUC();
                dVJ().h(eVar, 1);
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
