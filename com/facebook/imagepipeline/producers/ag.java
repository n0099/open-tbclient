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
/* loaded from: classes25.dex */
public class ag implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.common.memory.g nDr;
    private final com.facebook.imagepipeline.c.f nEZ;
    private final com.facebook.imagepipeline.c.e nGe;
    private final aj<com.facebook.imagepipeline.g.e> nIa;
    private final com.facebook.common.memory.a nvq;

    public ag(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.f fVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.nGe = eVar;
        this.nEZ = fVar;
        this.nDr = gVar;
        this.nvq = aVar;
        this.nIa = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        ImageRequest dZv = akVar.dZv();
        if (!dZv.dWQ()) {
            this.nIa.c(kVar, akVar);
            return;
        }
        akVar.dZw().gA(akVar.getId(), "PartialDiskCacheProducer");
        com.facebook.cache.common.b a2 = this.nEZ.a(dZv, n(dZv), akVar.dUb());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.nGe.a(a2, atomicBoolean).a(a(kVar, akVar, a2));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.g.e, Void> a(final k<com.facebook.imagepipeline.g.e> kVar, final ak akVar, final com.facebook.cache.common.b bVar) {
        final String id = akVar.getId();
        final am dZw = akVar.dZw();
        return new bolts.f<com.facebook.imagepipeline.g.e, Void>() { // from class: com.facebook.imagepipeline.producers.ag.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.g.e> gVar) throws Exception {
                if (ag.d(gVar)) {
                    dZw.b(id, "PartialDiskCacheProducer", null);
                    kVar.dSB();
                } else if (gVar.ik()) {
                    dZw.a(id, "PartialDiskCacheProducer", gVar.il(), (Map<String, String>) null);
                    ag.this.a(kVar, akVar, bVar, (com.facebook.imagepipeline.g.e) null);
                } else {
                    com.facebook.imagepipeline.g.e result = gVar.getResult();
                    if (result != null) {
                        dZw.a(id, "PartialDiskCacheProducer", ag.a(dZw, id, true, result.getSize()));
                        com.facebook.imagepipeline.common.a Mn = com.facebook.imagepipeline.common.a.Mn(result.getSize() - 1);
                        result.b(Mn);
                        int size = result.getSize();
                        ImageRequest dZv = akVar.dZv();
                        if (Mn.a(dZv.dYz())) {
                            dZw.F(id, "PartialDiskCacheProducer", true);
                            kVar.h(result, 9);
                        } else {
                            kVar.h(result, 8);
                            ag.this.a(kVar, new ap(ImageRequestBuilder.o(dZv).d(com.facebook.imagepipeline.common.a.Mm(size - 1)).eay(), akVar), bVar, result);
                        }
                    } else {
                        dZw.a(id, "PartialDiskCacheProducer", ag.a(dZw, id, false, 0));
                        ag.this.a(kVar, akVar, bVar, result);
                    }
                }
                return null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, com.facebook.cache.common.b bVar, @Nullable com.facebook.imagepipeline.g.e eVar) {
        this.nIa.c(new a(kVar, this.nGe, bVar, this.nDr, this.nvq, eVar), akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(bolts.g<?> gVar) {
        return gVar.isCancelled() || (gVar.ik() && (gVar.il() instanceof CancellationException));
    }

    @Nullable
    static Map<String, String> a(am amVar, String str, boolean z, int i) {
        if (!amVar.Vh(str)) {
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
            public void dVN() {
                atomicBoolean.set(true);
            }
        });
    }

    private static Uri n(ImageRequest imageRequest) {
        return imageRequest.ean().buildUpon().appendQueryParameter("fresco_partial", "true").build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.common.memory.g nDr;
        private final com.facebook.imagepipeline.c.e nGe;
        private final com.facebook.cache.common.b nJr;
        @Nullable
        private final com.facebook.imagepipeline.g.e nJs;
        private final com.facebook.common.memory.a nvq;

        private a(k<com.facebook.imagepipeline.g.e> kVar, com.facebook.imagepipeline.c.e eVar, com.facebook.cache.common.b bVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, @Nullable com.facebook.imagepipeline.g.e eVar2) {
            super(kVar);
            this.nGe = eVar;
            this.nJr = bVar;
            this.nDr = gVar;
            this.nvq = aVar;
            this.nJs = eVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (!MR(i)) {
                if (this.nJs != null && eVar.dYz() != null) {
                    try {
                        a(a(this.nJs, eVar));
                    } catch (IOException e) {
                        com.facebook.common.c.a.e("PartialDiskCacheProducer", "Error while merging image data", e);
                        dZH().E(e);
                    } finally {
                        eVar.close();
                        this.nJs.close();
                    }
                    this.nGe.n(this.nJr);
                } else if (dN(i, 8) && MQ(i) && eVar.dYy() != com.facebook.c.c.nCw) {
                    this.nGe.a(this.nJr, eVar);
                    dZH().h(eVar, i);
                } else {
                    dZH().h(eVar, i);
                }
            }
        }

        private com.facebook.common.memory.i a(com.facebook.imagepipeline.g.e eVar, com.facebook.imagepipeline.g.e eVar2) throws IOException {
            com.facebook.common.memory.i LA = this.nDr.LA(eVar2.getSize() + eVar2.dYz().from);
            c(eVar.getInputStream(), LA, eVar2.dYz().from);
            c(eVar2.getInputStream(), LA, eVar2.getSize());
            return LA;
        }

        private void c(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
            byte[] bArr = this.nvq.get(16384);
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
                    this.nvq.release(bArr);
                }
            }
            if (i2 > 0) {
                throw new IOException(String.format(null, "Failed to read %d bytes - finished %d short", Integer.valueOf(i), Integer.valueOf(i2)));
            }
        }

        private void a(com.facebook.common.memory.i iVar) {
            com.facebook.imagepipeline.g.e eVar;
            com.facebook.common.references.a e = com.facebook.common.references.a.e(iVar.dSO());
            try {
                eVar = new com.facebook.imagepipeline.g.e(e);
            } catch (Throwable th) {
                th = th;
                eVar = null;
            }
            try {
                eVar.dYA();
                dZH().h(eVar, 1);
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
