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
    private final com.facebook.common.memory.g pHk;
    private final com.facebook.imagepipeline.b.f pIP;
    private final com.facebook.imagepipeline.b.e pJS;
    private final aj<com.facebook.imagepipeline.f.e> pLO;
    private final com.facebook.common.memory.a pzE;

    public ag(com.facebook.imagepipeline.b.e eVar, com.facebook.imagepipeline.b.f fVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.pJS = eVar;
        this.pIP = fVar;
        this.pHk = gVar;
        this.pzE = aVar;
        this.pLO = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        ImageRequest ezp = akVar.ezp();
        if (!ezp.ewO()) {
            this.pLO.a(kVar, akVar);
            return;
        }
        akVar.ezq().hv(akVar.getId(), "PartialDiskCacheProducer");
        com.facebook.cache.common.b a2 = this.pIP.a(ezp, n(ezp), akVar.eud());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.pJS.a(a2, atomicBoolean).a(a(kVar, akVar, a2));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.f.e, Void> a(final k<com.facebook.imagepipeline.f.e> kVar, final ak akVar, final com.facebook.cache.common.b bVar) {
        final String id = akVar.getId();
        final am ezq = akVar.ezq();
        return new bolts.f<com.facebook.imagepipeline.f.e, Void>() { // from class: com.facebook.imagepipeline.producers.ag.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.f.e> gVar) throws Exception {
                if (ag.d(gVar)) {
                    ezq.c(id, "PartialDiskCacheProducer", null);
                    kVar.esD();
                } else if (gVar.hC()) {
                    ezq.a(id, "PartialDiskCacheProducer", gVar.hD(), (Map<String, String>) null);
                    ag.this.a(kVar, akVar, bVar, (com.facebook.imagepipeline.f.e) null);
                } else {
                    com.facebook.imagepipeline.f.e result = gVar.getResult();
                    if (result != null) {
                        ezq.b(id, "PartialDiskCacheProducer", ag.a(ezq, id, true, result.getSize()));
                        com.facebook.imagepipeline.common.a PH = com.facebook.imagepipeline.common.a.PH(result.getSize() - 1);
                        result.b(PH);
                        int size = result.getSize();
                        ImageRequest ezp = akVar.ezp();
                        if (PH.a(ezp.eyx())) {
                            ezq.M(id, "PartialDiskCacheProducer", true);
                            kVar.g(result, 9);
                        } else {
                            kVar.g(result, 8);
                            ag.this.a(kVar, new ap(ImageRequestBuilder.o(ezp).c(com.facebook.imagepipeline.common.a.PG(size - 1)).eAq(), akVar), bVar, result);
                        }
                    } else {
                        ezq.b(id, "PartialDiskCacheProducer", ag.a(ezq, id, false, 0));
                        ag.this.a(kVar, akVar, bVar, result);
                    }
                }
                return null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar, com.facebook.cache.common.b bVar, @Nullable com.facebook.imagepipeline.f.e eVar) {
        this.pLO.a(new a(kVar, this.pJS, bVar, this.pHk, this.pzE, eVar), akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(bolts.g<?> gVar) {
        return gVar.isCancelled() || (gVar.hC() && (gVar.hD() instanceof CancellationException));
    }

    @Nullable
    static Map<String, String> a(am amVar, String str, boolean z, int i) {
        if (!amVar.ZG(str)) {
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
            public void ezw() {
                atomicBoolean.set(true);
            }
        });
    }

    private static Uri n(ImageRequest imageRequest) {
        return imageRequest.eAf().buildUpon().appendQueryParameter("fresco_partial", "true").build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private final com.facebook.common.memory.g pHk;
        private final com.facebook.imagepipeline.b.e pJS;
        private final com.facebook.cache.common.b pNg;
        @Nullable
        private final com.facebook.imagepipeline.f.e pNh;
        private final com.facebook.common.memory.a pzE;

        private a(k<com.facebook.imagepipeline.f.e> kVar, com.facebook.imagepipeline.b.e eVar, com.facebook.cache.common.b bVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, @Nullable com.facebook.imagepipeline.f.e eVar2) {
            super(kVar);
            this.pJS = eVar;
            this.pNg = bVar;
            this.pHk = gVar;
            this.pzE = aVar;
            this.pNh = eVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.f.e eVar, int i) {
            if (!Ql(i)) {
                if (this.pNh != null && eVar.eyx() != null) {
                    try {
                        a(a(this.pNh, eVar));
                    } catch (IOException e) {
                        com.facebook.common.c.a.e("PartialDiskCacheProducer", "Error while merging image data", e);
                        ezC().C(e);
                    } finally {
                        eVar.close();
                        this.pNh.close();
                    }
                    this.pJS.n(this.pNg);
                } else if (ed(i, 8) && Qk(i) && eVar.eyw() != com.facebook.c.c.pGy) {
                    this.pJS.a(this.pNg, eVar);
                    ezC().g(eVar, i);
                } else {
                    ezC().g(eVar, i);
                }
            }
        }

        private com.facebook.common.memory.i a(com.facebook.imagepipeline.f.e eVar, com.facebook.imagepipeline.f.e eVar2) throws IOException {
            com.facebook.common.memory.i OW = this.pHk.OW(eVar2.getSize() + eVar2.eyx().from);
            c(eVar.getInputStream(), OW, eVar2.eyx().from);
            c(eVar2.getInputStream(), OW, eVar2.getSize());
            return OW;
        }

        private void c(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
            byte[] bArr = this.pzE.get(16384);
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
                    this.pzE.release(bArr);
                }
            }
            if (i2 > 0) {
                throw new IOException(String.format(null, "Failed to read %d bytes - finished %d short", Integer.valueOf(i), Integer.valueOf(i2)));
            }
        }

        private void a(com.facebook.common.memory.i iVar) {
            com.facebook.imagepipeline.f.e eVar;
            com.facebook.common.references.a e = com.facebook.common.references.a.e(iVar.esQ());
            try {
                eVar = new com.facebook.imagepipeline.f.e(e);
            } catch (Throwable th) {
                th = th;
                eVar = null;
            }
            try {
                eVar.eyy();
                ezC().g(eVar, 1);
                com.facebook.imagepipeline.f.e.e(eVar);
                com.facebook.common.references.a.c(e);
            } catch (Throwable th2) {
                th = th2;
                com.facebook.imagepipeline.f.e.e(eVar);
                com.facebook.common.references.a.c(e);
                throw th;
            }
        }
    }
}
