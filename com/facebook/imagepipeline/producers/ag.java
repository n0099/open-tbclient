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
    private final com.facebook.common.memory.a pcj;
    private final com.facebook.common.memory.g pjQ;
    private final com.facebook.imagepipeline.b.f plx;
    private final com.facebook.imagepipeline.b.e pmA;
    private final aj<com.facebook.imagepipeline.f.e> poz;

    public ag(com.facebook.imagepipeline.b.e eVar, com.facebook.imagepipeline.b.f fVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.pmA = eVar;
        this.plx = fVar;
        this.pjQ = gVar;
        this.pcj = aVar;
        this.poz = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        ImageRequest eww = akVar.eww();
        if (!eww.etU()) {
            this.poz.a(kVar, akVar);
            return;
        }
        akVar.ewx().hh(akVar.getId(), "PartialDiskCacheProducer");
        com.facebook.cache.common.b a2 = this.plx.a(eww, n(eww), akVar.ern());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.pmA.a(a2, atomicBoolean).a(a(kVar, akVar, a2));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.f.e, Void> a(final k<com.facebook.imagepipeline.f.e> kVar, final ak akVar, final com.facebook.cache.common.b bVar) {
        final String id = akVar.getId();
        final am ewx = akVar.ewx();
        return new bolts.f<com.facebook.imagepipeline.f.e, Void>() { // from class: com.facebook.imagepipeline.producers.ag.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.f.e> gVar) throws Exception {
                if (ag.d(gVar)) {
                    ewx.b(id, "PartialDiskCacheProducer", null);
                    kVar.epN();
                } else if (gVar.il()) {
                    ewx.a(id, "PartialDiskCacheProducer", gVar.im(), (Map<String, String>) null);
                    ag.this.a(kVar, akVar, bVar, (com.facebook.imagepipeline.f.e) null);
                } else {
                    com.facebook.imagepipeline.f.e result = gVar.getResult();
                    if (result != null) {
                        ewx.a(id, "PartialDiskCacheProducer", ag.a(ewx, id, true, result.getSize()));
                        com.facebook.imagepipeline.common.a QE = com.facebook.imagepipeline.common.a.QE(result.getSize() - 1);
                        result.b(QE);
                        int size = result.getSize();
                        ImageRequest eww = akVar.eww();
                        if (QE.a(eww.evD())) {
                            ewx.J(id, "PartialDiskCacheProducer", true);
                            kVar.h(result, 9);
                        } else {
                            kVar.h(result, 8);
                            ag.this.a(kVar, new ap(ImageRequestBuilder.o(eww).c(com.facebook.imagepipeline.common.a.QD(size - 1)).exx(), akVar), bVar, result);
                        }
                    } else {
                        ewx.a(id, "PartialDiskCacheProducer", ag.a(ewx, id, false, 0));
                        ag.this.a(kVar, akVar, bVar, result);
                    }
                }
                return null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar, com.facebook.cache.common.b bVar, @Nullable com.facebook.imagepipeline.f.e eVar) {
        this.poz.a(new a(kVar, this.pmA, bVar, this.pjQ, this.pcj, eVar), akVar);
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
            public void ewD() {
                atomicBoolean.set(true);
            }
        });
    }

    private static Uri n(ImageRequest imageRequest) {
        return imageRequest.exm().buildUpon().appendQueryParameter("fresco_partial", "true").build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private final com.facebook.common.memory.a pcj;
        private final com.facebook.common.memory.g pjQ;
        private final com.facebook.imagepipeline.b.e pmA;
        private final com.facebook.cache.common.b ppS;
        @Nullable
        private final com.facebook.imagepipeline.f.e ppT;

        private a(k<com.facebook.imagepipeline.f.e> kVar, com.facebook.imagepipeline.b.e eVar, com.facebook.cache.common.b bVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, @Nullable com.facebook.imagepipeline.f.e eVar2) {
            super(kVar);
            this.pmA = eVar;
            this.ppS = bVar;
            this.pjQ = gVar;
            this.pcj = aVar;
            this.ppT = eVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.f.e eVar, int i) {
            if (!Ri(i)) {
                if (this.ppT != null && eVar.evD() != null) {
                    try {
                        a(a(this.ppT, eVar));
                    } catch (IOException e) {
                        com.facebook.common.c.a.e("PartialDiskCacheProducer", "Error while merging image data", e);
                        ewJ().E(e);
                    } finally {
                        eVar.close();
                        this.ppT.close();
                    }
                    this.pmA.n(this.ppS);
                } else if (ef(i, 8) && Rh(i) && eVar.evC() != com.facebook.c.c.pje) {
                    this.pmA.a(this.ppS, eVar);
                    ewJ().h(eVar, i);
                } else {
                    ewJ().h(eVar, i);
                }
            }
        }

        private com.facebook.common.memory.i a(com.facebook.imagepipeline.f.e eVar, com.facebook.imagepipeline.f.e eVar2) throws IOException {
            com.facebook.common.memory.i PT = this.pjQ.PT(eVar2.getSize() + eVar2.evD().from);
            c(eVar.getInputStream(), PT, eVar2.evD().from);
            c(eVar2.getInputStream(), PT, eVar2.getSize());
            return PT;
        }

        private void c(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
            byte[] bArr = this.pcj.get(16384);
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
                    this.pcj.release(bArr);
                }
            }
            if (i2 > 0) {
                throw new IOException(String.format(null, "Failed to read %d bytes - finished %d short", Integer.valueOf(i), Integer.valueOf(i2)));
            }
        }

        private void a(com.facebook.common.memory.i iVar) {
            com.facebook.imagepipeline.f.e eVar;
            com.facebook.common.references.a e = com.facebook.common.references.a.e(iVar.eqa());
            try {
                eVar = new com.facebook.imagepipeline.f.e(e);
            } catch (Throwable th) {
                th = th;
                eVar = null;
            }
            try {
                eVar.evE();
                ewJ().h(eVar, 1);
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
