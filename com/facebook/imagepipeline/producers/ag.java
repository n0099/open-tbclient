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
    private final com.facebook.common.memory.a mmW;
    private final com.facebook.common.memory.g mvb;
    private final com.facebook.imagepipeline.c.f mwJ;
    private final com.facebook.imagepipeline.c.e mxM;
    private final aj<com.facebook.imagepipeline.g.e> mzI;

    public ag(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.f fVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.mxM = eVar;
        this.mwJ = fVar;
        this.mvb = gVar;
        this.mmW = aVar;
        this.mzI = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        ImageRequest dBw = akVar.dBw();
        if (!dBw.dyR()) {
            this.mzI.c(kVar, akVar);
            return;
        }
        akVar.dBx().fK(akVar.getId(), "PartialDiskCacheProducer");
        com.facebook.cache.common.b a2 = this.mwJ.a(dBw, n(dBw), akVar.dwa());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.mxM.a(a2, atomicBoolean).a(a(kVar, akVar, a2));
        a(atomicBoolean, akVar);
    }

    private bolts.f<com.facebook.imagepipeline.g.e, Void> a(final k<com.facebook.imagepipeline.g.e> kVar, final ak akVar, final com.facebook.cache.common.b bVar) {
        final String id = akVar.getId();
        final am dBx = akVar.dBx();
        return new bolts.f<com.facebook.imagepipeline.g.e, Void>() { // from class: com.facebook.imagepipeline.producers.ag.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // bolts.f
            /* renamed from: b */
            public Void a(bolts.g<com.facebook.imagepipeline.g.e> gVar) throws Exception {
                if (ag.d(gVar)) {
                    dBx.b(id, "PartialDiskCacheProducer", null);
                    kVar.duA();
                } else if (gVar.gu()) {
                    dBx.a(id, "PartialDiskCacheProducer", gVar.gv(), (Map<String, String>) null);
                    ag.this.a(kVar, akVar, bVar, (com.facebook.imagepipeline.g.e) null);
                } else {
                    com.facebook.imagepipeline.g.e result = gVar.getResult();
                    if (result != null) {
                        dBx.a(id, "PartialDiskCacheProducer", ag.a(dBx, id, true, result.getSize()));
                        com.facebook.imagepipeline.common.a HC = com.facebook.imagepipeline.common.a.HC(result.getSize() - 1);
                        result.b(HC);
                        int size = result.getSize();
                        ImageRequest dBw = akVar.dBw();
                        if (HC.a(dBw.dAA())) {
                            dBx.F(id, "PartialDiskCacheProducer", true);
                            kVar.h(result, 9);
                        } else {
                            kVar.h(result, 8);
                            ag.this.a(kVar, new ap(ImageRequestBuilder.o(dBw).d(com.facebook.imagepipeline.common.a.HB(size - 1)).dCz(), akVar), bVar, result);
                        }
                    } else {
                        dBx.a(id, "PartialDiskCacheProducer", ag.a(dBx, id, false, 0));
                        ag.this.a(kVar, akVar, bVar, result);
                    }
                }
                return null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, com.facebook.cache.common.b bVar, @Nullable com.facebook.imagepipeline.g.e eVar) {
        this.mzI.c(new a(kVar, this.mxM, bVar, this.mvb, this.mmW, eVar), akVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(bolts.g<?> gVar) {
        return gVar.isCancelled() || (gVar.gu() && (gVar.gv() instanceof CancellationException));
    }

    @Nullable
    static Map<String, String> a(am amVar, String str, boolean z, int i) {
        if (!amVar.Qd(str)) {
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
            public void dxO() {
                atomicBoolean.set(true);
            }
        });
    }

    private static Uri n(ImageRequest imageRequest) {
        return imageRequest.dCo().buildUpon().appendQueryParameter("fresco_partial", "true").build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.cache.common.b mAZ;
        @Nullable
        private final com.facebook.imagepipeline.g.e mBa;
        private final com.facebook.common.memory.a mmW;
        private final com.facebook.common.memory.g mvb;
        private final com.facebook.imagepipeline.c.e mxM;

        private a(k<com.facebook.imagepipeline.g.e> kVar, com.facebook.imagepipeline.c.e eVar, com.facebook.cache.common.b bVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.a aVar, @Nullable com.facebook.imagepipeline.g.e eVar2) {
            super(kVar);
            this.mxM = eVar;
            this.mAZ = bVar;
            this.mvb = gVar;
            this.mmW = aVar;
            this.mBa = eVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (!Ig(i)) {
                if (this.mBa != null && eVar.dAA() != null) {
                    try {
                        a(a(this.mBa, eVar));
                    } catch (IOException e) {
                        com.facebook.common.c.a.e("PartialDiskCacheProducer", "Error while merging image data", e);
                        dBI().G(e);
                    } finally {
                        eVar.close();
                        this.mBa.close();
                    }
                    this.mxM.n(this.mAZ);
                } else if (dq(i, 8) && If(i) && eVar.dAz() != com.facebook.c.c.muf) {
                    this.mxM.a(this.mAZ, eVar);
                    dBI().h(eVar, i);
                } else {
                    dBI().h(eVar, i);
                }
            }
        }

        private com.facebook.common.memory.i a(com.facebook.imagepipeline.g.e eVar, com.facebook.imagepipeline.g.e eVar2) throws IOException {
            com.facebook.common.memory.i GP = this.mvb.GP(eVar2.getSize() + eVar2.dAA().from);
            c(eVar.getInputStream(), GP, eVar2.dAA().from);
            c(eVar2.getInputStream(), GP, eVar2.getSize());
            return GP;
        }

        private void c(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
            byte[] bArr = this.mmW.get(16384);
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
                    this.mmW.release(bArr);
                }
            }
            if (i2 > 0) {
                throw new IOException(String.format(null, "Failed to read %d bytes - finished %d short", Integer.valueOf(i), Integer.valueOf(i2)));
            }
        }

        private void a(com.facebook.common.memory.i iVar) {
            com.facebook.imagepipeline.g.e eVar;
            com.facebook.common.references.a e = com.facebook.common.references.a.e(iVar.duN());
            try {
                eVar = new com.facebook.imagepipeline.g.e(e);
            } catch (Throwable th) {
                th = th;
                eVar = null;
            }
            try {
                eVar.dAB();
                dBI().h(eVar, 1);
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
