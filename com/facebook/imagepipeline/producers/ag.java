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
    private final com.facebook.common.memory.a mRe;
    private final com.facebook.common.memory.g mZm;
    private final com.facebook.imagepipeline.c.f naU;
    private final com.facebook.imagepipeline.c.e nbZ;
    private final aj<com.facebook.imagepipeline.g.e> ndV;

    public ag(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.f fVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.nbZ = eVar;
        this.naU = fVar;
        this.mZm = gVar;
        this.mRe = aVar;
        this.ndV = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        ImageRequest dJp = akVar.dJp();
        if (!dJp.dGK()) {
            this.ndV.c(kVar, akVar);
            return;
        }
        akVar.dJq().fW(akVar.getId(), "PartialDiskCacheProducer");
        com.facebook.cache.common.b a2 = this.naU.a(dJp, n(dJp), akVar.dDU());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.nbZ.a(a2, atomicBoolean).a(a(kVar, akVar, a2));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.g.e, Void> a(final k<com.facebook.imagepipeline.g.e> kVar, final ak akVar, final com.facebook.cache.common.b bVar) {
        final String id = akVar.getId();
        final am dJq = akVar.dJq();
        return new bolts.f<com.facebook.imagepipeline.g.e, Void>() { // from class: com.facebook.imagepipeline.producers.ag.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.g.e> gVar) throws Exception {
                if (ag.d(gVar)) {
                    dJq.b(id, "PartialDiskCacheProducer", null);
                    kVar.dCu();
                } else if (gVar.gK()) {
                    dJq.a(id, "PartialDiskCacheProducer", gVar.gL(), (Map<String, String>) null);
                    ag.this.a(kVar, akVar, bVar, (com.facebook.imagepipeline.g.e) null);
                } else {
                    com.facebook.imagepipeline.g.e result = gVar.getResult();
                    if (result != null) {
                        dJq.a(id, "PartialDiskCacheProducer", ag.a(dJq, id, true, result.getSize()));
                        com.facebook.imagepipeline.common.a Je = com.facebook.imagepipeline.common.a.Je(result.getSize() - 1);
                        result.b(Je);
                        int size = result.getSize();
                        ImageRequest dJp = akVar.dJp();
                        if (Je.a(dJp.dIt())) {
                            dJq.G(id, "PartialDiskCacheProducer", true);
                            kVar.h(result, 9);
                        } else {
                            kVar.h(result, 8);
                            ag.this.a(kVar, new ap(ImageRequestBuilder.o(dJp).d(com.facebook.imagepipeline.common.a.Jd(size - 1)).dKs(), akVar), bVar, result);
                        }
                    } else {
                        dJq.a(id, "PartialDiskCacheProducer", ag.a(dJq, id, false, 0));
                        ag.this.a(kVar, akVar, bVar, result);
                    }
                }
                return null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, com.facebook.cache.common.b bVar, @Nullable com.facebook.imagepipeline.g.e eVar) {
        this.ndV.c(new a(kVar, this.nbZ, bVar, this.mZm, this.mRe, eVar), akVar);
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
            public void dFH() {
                atomicBoolean.set(true);
            }
        });
    }

    private static Uri n(ImageRequest imageRequest) {
        return imageRequest.dKh().buildUpon().appendQueryParameter("fresco_partial", "true").build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.common.memory.a mRe;
        private final com.facebook.common.memory.g mZm;
        private final com.facebook.imagepipeline.c.e nbZ;
        private final com.facebook.cache.common.b nfn;
        @Nullable
        private final com.facebook.imagepipeline.g.e nfo;

        private a(k<com.facebook.imagepipeline.g.e> kVar, com.facebook.imagepipeline.c.e eVar, com.facebook.cache.common.b bVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, @Nullable com.facebook.imagepipeline.g.e eVar2) {
            super(kVar);
            this.nbZ = eVar;
            this.nfn = bVar;
            this.mZm = gVar;
            this.mRe = aVar;
            this.nfo = eVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (!JI(i)) {
                if (this.nfo != null && eVar.dIt() != null) {
                    try {
                        a(a(this.nfo, eVar));
                    } catch (IOException e) {
                        com.facebook.common.c.a.e("PartialDiskCacheProducer", "Error while merging image data", e);
                        dJB().F(e);
                    } finally {
                        eVar.close();
                        this.nfo.close();
                    }
                    this.nbZ.n(this.nfn);
                } else if (dB(i, 8) && JH(i) && eVar.dIs() != com.facebook.c.c.mYr) {
                    this.nbZ.a(this.nfn, eVar);
                    dJB().h(eVar, i);
                } else {
                    dJB().h(eVar, i);
                }
            }
        }

        private com.facebook.common.memory.i a(com.facebook.imagepipeline.g.e eVar, com.facebook.imagepipeline.g.e eVar2) throws IOException {
            com.facebook.common.memory.i Ir = this.mZm.Ir(eVar2.getSize() + eVar2.dIt().from);
            c(eVar.getInputStream(), Ir, eVar2.dIt().from);
            c(eVar2.getInputStream(), Ir, eVar2.getSize());
            return Ir;
        }

        private void c(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
            byte[] bArr = this.mRe.get(16384);
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
                    this.mRe.release(bArr);
                }
            }
            if (i2 > 0) {
                throw new IOException(String.format(null, "Failed to read %d bytes - finished %d short", Integer.valueOf(i), Integer.valueOf(i2)));
            }
        }

        private void a(com.facebook.common.memory.i iVar) {
            com.facebook.imagepipeline.g.e eVar;
            com.facebook.common.references.a e = com.facebook.common.references.a.e(iVar.dCH());
            try {
                eVar = new com.facebook.imagepipeline.g.e(e);
            } catch (Throwable th) {
                th = th;
                eVar = null;
            }
            try {
                eVar.dIu();
                dJB().h(eVar, 1);
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
