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
    private final com.facebook.common.memory.a nkY;
    private final com.facebook.common.memory.g ntb;
    private final com.facebook.imagepipeline.c.f nuK;
    private final com.facebook.imagepipeline.c.e nvP;
    private final aj<com.facebook.imagepipeline.g.e> nxL;

    public ag(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.f fVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.nvP = eVar;
        this.nuK = fVar;
        this.ntb = gVar;
        this.nkY = aVar;
        this.nxL = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        ImageRequest dVo = akVar.dVo();
        if (!dVo.dSJ()) {
            this.nxL.c(kVar, akVar);
            return;
        }
        akVar.dVp().gn(akVar.getId(), "PartialDiskCacheProducer");
        com.facebook.cache.common.b a2 = this.nuK.a(dVo, n(dVo), akVar.dPU());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.nvP.a(a2, atomicBoolean).a(a(kVar, akVar, a2));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.g.e, Void> a(final k<com.facebook.imagepipeline.g.e> kVar, final ak akVar, final com.facebook.cache.common.b bVar) {
        final String id = akVar.getId();
        final am dVp = akVar.dVp();
        return new bolts.f<com.facebook.imagepipeline.g.e, Void>() { // from class: com.facebook.imagepipeline.producers.ag.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.g.e> gVar) throws Exception {
                if (ag.d(gVar)) {
                    dVp.b(id, "PartialDiskCacheProducer", null);
                    kVar.dOu();
                } else if (gVar.ik()) {
                    dVp.a(id, "PartialDiskCacheProducer", gVar.il(), (Map<String, String>) null);
                    ag.this.a(kVar, akVar, bVar, (com.facebook.imagepipeline.g.e) null);
                } else {
                    com.facebook.imagepipeline.g.e result = gVar.getResult();
                    if (result != null) {
                        dVp.a(id, "PartialDiskCacheProducer", ag.a(dVp, id, true, result.getSize()));
                        com.facebook.imagepipeline.common.a LI = com.facebook.imagepipeline.common.a.LI(result.getSize() - 1);
                        result.b(LI);
                        int size = result.getSize();
                        ImageRequest dVo = akVar.dVo();
                        if (LI.a(dVo.dUs())) {
                            dVp.F(id, "PartialDiskCacheProducer", true);
                            kVar.h(result, 9);
                        } else {
                            kVar.h(result, 8);
                            ag.this.a(kVar, new ap(ImageRequestBuilder.o(dVo).d(com.facebook.imagepipeline.common.a.LH(size - 1)).dWr(), akVar), bVar, result);
                        }
                    } else {
                        dVp.a(id, "PartialDiskCacheProducer", ag.a(dVp, id, false, 0));
                        ag.this.a(kVar, akVar, bVar, result);
                    }
                }
                return null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, com.facebook.cache.common.b bVar, @Nullable com.facebook.imagepipeline.g.e eVar) {
        this.nxL.c(new a(kVar, this.nvP, bVar, this.ntb, this.nkY, eVar), akVar);
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
            public void dRG() {
                atomicBoolean.set(true);
            }
        });
    }

    private static Uri n(ImageRequest imageRequest) {
        return imageRequest.dWg().buildUpon().appendQueryParameter("fresco_partial", "true").build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.common.memory.a nkY;
        private final com.facebook.common.memory.g ntb;
        private final com.facebook.imagepipeline.c.e nvP;
        private final com.facebook.cache.common.b nzc;
        @Nullable
        private final com.facebook.imagepipeline.g.e nzd;

        private a(k<com.facebook.imagepipeline.g.e> kVar, com.facebook.imagepipeline.c.e eVar, com.facebook.cache.common.b bVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, @Nullable com.facebook.imagepipeline.g.e eVar2) {
            super(kVar);
            this.nvP = eVar;
            this.nzc = bVar;
            this.ntb = gVar;
            this.nkY = aVar;
            this.nzd = eVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (!Mm(i)) {
                if (this.nzd != null && eVar.dUs() != null) {
                    try {
                        a(a(this.nzd, eVar));
                    } catch (IOException e) {
                        com.facebook.common.c.a.e("PartialDiskCacheProducer", "Error while merging image data", e);
                        dVA().E(e);
                    } finally {
                        eVar.close();
                        this.nzd.close();
                    }
                    this.nvP.n(this.nzc);
                } else if (dJ(i, 8) && Ml(i) && eVar.dUr() != com.facebook.c.c.nsg) {
                    this.nvP.a(this.nzc, eVar);
                    dVA().h(eVar, i);
                } else {
                    dVA().h(eVar, i);
                }
            }
        }

        private com.facebook.common.memory.i a(com.facebook.imagepipeline.g.e eVar, com.facebook.imagepipeline.g.e eVar2) throws IOException {
            com.facebook.common.memory.i KV = this.ntb.KV(eVar2.getSize() + eVar2.dUs().from);
            c(eVar.getInputStream(), KV, eVar2.dUs().from);
            c(eVar2.getInputStream(), KV, eVar2.getSize());
            return KV;
        }

        private void c(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
            byte[] bArr = this.nkY.get(16384);
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
                    this.nkY.release(bArr);
                }
            }
            if (i2 > 0) {
                throw new IOException(String.format(null, "Failed to read %d bytes - finished %d short", Integer.valueOf(i), Integer.valueOf(i2)));
            }
        }

        private void a(com.facebook.common.memory.i iVar) {
            com.facebook.imagepipeline.g.e eVar;
            com.facebook.common.references.a e = com.facebook.common.references.a.e(iVar.dOH());
            try {
                eVar = new com.facebook.imagepipeline.g.e(e);
            } catch (Throwable th) {
                th = th;
                eVar = null;
            }
            try {
                eVar.dUt();
                dVA().h(eVar, 1);
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
