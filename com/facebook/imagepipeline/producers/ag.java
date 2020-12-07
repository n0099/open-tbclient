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
/* loaded from: classes15.dex */
public class ag implements aj<com.facebook.imagepipeline.f.e> {
    private final com.facebook.common.memory.a pch;
    private final com.facebook.common.memory.g pjO;
    private final com.facebook.imagepipeline.b.f plv;
    private final com.facebook.imagepipeline.b.e pmy;
    private final aj<com.facebook.imagepipeline.f.e> pox;

    public ag(com.facebook.imagepipeline.b.e eVar, com.facebook.imagepipeline.b.f fVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.pmy = eVar;
        this.plv = fVar;
        this.pjO = gVar;
        this.pch = aVar;
        this.pox = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        ImageRequest ewv = akVar.ewv();
        if (!ewv.etT()) {
            this.pox.a(kVar, akVar);
            return;
        }
        akVar.eww().hh(akVar.getId(), "PartialDiskCacheProducer");
        com.facebook.cache.common.b a2 = this.plv.a(ewv, n(ewv), akVar.erm());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.pmy.a(a2, atomicBoolean).a(a(kVar, akVar, a2));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.f.e, Void> a(final k<com.facebook.imagepipeline.f.e> kVar, final ak akVar, final com.facebook.cache.common.b bVar) {
        final String id = akVar.getId();
        final am eww = akVar.eww();
        return new bolts.f<com.facebook.imagepipeline.f.e, Void>() { // from class: com.facebook.imagepipeline.producers.ag.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.f.e> gVar) throws Exception {
                if (ag.d(gVar)) {
                    eww.b(id, "PartialDiskCacheProducer", null);
                    kVar.epM();
                } else if (gVar.il()) {
                    eww.a(id, "PartialDiskCacheProducer", gVar.im(), (Map<String, String>) null);
                    ag.this.a(kVar, akVar, bVar, (com.facebook.imagepipeline.f.e) null);
                } else {
                    com.facebook.imagepipeline.f.e result = gVar.getResult();
                    if (result != null) {
                        eww.a(id, "PartialDiskCacheProducer", ag.a(eww, id, true, result.getSize()));
                        com.facebook.imagepipeline.common.a QE = com.facebook.imagepipeline.common.a.QE(result.getSize() - 1);
                        result.b(QE);
                        int size = result.getSize();
                        ImageRequest ewv = akVar.ewv();
                        if (QE.a(ewv.evC())) {
                            eww.J(id, "PartialDiskCacheProducer", true);
                            kVar.h(result, 9);
                        } else {
                            kVar.h(result, 8);
                            ag.this.a(kVar, new ap(ImageRequestBuilder.o(ewv).c(com.facebook.imagepipeline.common.a.QD(size - 1)).exw(), akVar), bVar, result);
                        }
                    } else {
                        eww.a(id, "PartialDiskCacheProducer", ag.a(eww, id, false, 0));
                        ag.this.a(kVar, akVar, bVar, result);
                    }
                }
                return null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar, com.facebook.cache.common.b bVar, @Nullable com.facebook.imagepipeline.f.e eVar) {
        this.pox.a(new a(kVar, this.pmy, bVar, this.pjO, this.pch, eVar), akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(bolts.g<?> gVar) {
        return gVar.isCancelled() || (gVar.il() && (gVar.im() instanceof CancellationException));
    }

    @Nullable
    static Map<String, String> a(am amVar, String str, boolean z, int i) {
        if (!amVar.Zq(str)) {
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
            public void ewC() {
                atomicBoolean.set(true);
            }
        });
    }

    private static Uri n(ImageRequest imageRequest) {
        return imageRequest.exl().buildUpon().appendQueryParameter("fresco_partial", "true").build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private final com.facebook.common.memory.a pch;
        private final com.facebook.common.memory.g pjO;
        private final com.facebook.imagepipeline.b.e pmy;
        private final com.facebook.cache.common.b ppQ;
        @Nullable
        private final com.facebook.imagepipeline.f.e ppR;

        private a(k<com.facebook.imagepipeline.f.e> kVar, com.facebook.imagepipeline.b.e eVar, com.facebook.cache.common.b bVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, @Nullable com.facebook.imagepipeline.f.e eVar2) {
            super(kVar);
            this.pmy = eVar;
            this.ppQ = bVar;
            this.pjO = gVar;
            this.pch = aVar;
            this.ppR = eVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.f.e eVar, int i) {
            if (!Ri(i)) {
                if (this.ppR != null && eVar.evC() != null) {
                    try {
                        a(a(this.ppR, eVar));
                    } catch (IOException e) {
                        com.facebook.common.c.a.e("PartialDiskCacheProducer", "Error while merging image data", e);
                        ewI().E(e);
                    } finally {
                        eVar.close();
                        this.ppR.close();
                    }
                    this.pmy.n(this.ppQ);
                } else if (ef(i, 8) && Rh(i) && eVar.evB() != com.facebook.c.c.pjc) {
                    this.pmy.a(this.ppQ, eVar);
                    ewI().h(eVar, i);
                } else {
                    ewI().h(eVar, i);
                }
            }
        }

        private com.facebook.common.memory.i a(com.facebook.imagepipeline.f.e eVar, com.facebook.imagepipeline.f.e eVar2) throws IOException {
            com.facebook.common.memory.i PT = this.pjO.PT(eVar2.getSize() + eVar2.evC().from);
            c(eVar.getInputStream(), PT, eVar2.evC().from);
            c(eVar2.getInputStream(), PT, eVar2.getSize());
            return PT;
        }

        private void c(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
            byte[] bArr = this.pch.get(16384);
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
                    this.pch.release(bArr);
                }
            }
            if (i2 > 0) {
                throw new IOException(String.format(null, "Failed to read %d bytes - finished %d short", Integer.valueOf(i), Integer.valueOf(i2)));
            }
        }

        private void a(com.facebook.common.memory.i iVar) {
            com.facebook.imagepipeline.f.e eVar;
            com.facebook.common.references.a e = com.facebook.common.references.a.e(iVar.epZ());
            try {
                eVar = new com.facebook.imagepipeline.f.e(e);
            } catch (Throwable th) {
                th = th;
                eVar = null;
            }
            try {
                eVar.evD();
                ewI().h(eVar, 1);
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
