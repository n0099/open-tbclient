package com.facebook.imagepipeline.producers;

import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.util.TriState;
import com.facebook.imagepipeline.nativecode.JpegTranscoder;
import com.facebook.imagepipeline.producers.JobScheduler;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class ao implements aj<com.facebook.imagepipeline.f.e> {
    private static final ImmutableList<Integer> pqd = ImmutableList.of((Object[]) new Integer[]{2, 7, 4, 5});
    private final Executor mExecutor;
    private final com.facebook.common.memory.g pjO;
    private final boolean pmz;
    private final aj<com.facebook.imagepipeline.f.e> pox;
    private final boolean pqe;

    public ao(Executor executor, com.facebook.common.memory.g gVar, boolean z, aj<com.facebook.imagepipeline.f.e> ajVar, boolean z2) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.pjO = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.pqe = z;
        this.pox = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.pmz = z2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        this.pox.a(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes15.dex */
    private class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private boolean fij;
        private final ak poK;
        private final JobScheduler poQ;

        public a(final k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
            super(kVar);
            this.fij = false;
            this.poK = akVar;
            this.poQ = new JobScheduler(ao.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.ao.a.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.f.e eVar, int i) {
                    a.this.g(eVar, i);
                }
            }, 100);
            this.poK.a(new e() { // from class: com.facebook.imagepipeline.producers.ao.a.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ewE() {
                    if (a.this.poK.ewA()) {
                        a.this.poQ.ewO();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ewC() {
                    a.this.poQ.ewN();
                    a.this.fij = true;
                    kVar.epM();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(@Nullable com.facebook.imagepipeline.f.e eVar, int i) {
            if (!this.fij) {
                boolean Rh = Rh(i);
                if (eVar != null) {
                    TriState a2 = ao.a(this.poK.ewv(), eVar, ao.this.pqe);
                    if (Rh || a2 != TriState.UNSET) {
                        if (a2 != TriState.YES) {
                            if (!this.poK.ewv().exo().etF() && eVar.evx() != 0 && eVar.evx() != -1) {
                                eVar = k(eVar);
                                eVar.QJ(0);
                            }
                            ewI().h(eVar, i);
                        } else if (this.poQ.e(eVar, i)) {
                            if (Rh || this.poK.ewA()) {
                                this.poQ.ewO();
                            }
                        }
                    }
                } else if (Rh) {
                    ewI().h(null, 1);
                }
            }
        }

        private com.facebook.imagepipeline.f.e k(com.facebook.imagepipeline.f.e eVar) {
            com.facebook.imagepipeline.f.e b = com.facebook.imagepipeline.f.e.b(eVar);
            eVar.close();
            return b;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [252=4] */
        /* JADX INFO: Access modifiers changed from: private */
        public void g(com.facebook.imagepipeline.f.e eVar, int i) {
            InputStream inputStream;
            InputStream inputStream2;
            Map<String, String> a2;
            this.poK.eww().hh(this.poK.getId(), "ResizeAndRotateProducer");
            ImageRequest ewv = this.poK.ewv();
            com.facebook.common.memory.i epY = ao.this.pjO.epY();
            try {
                int b = ao.b(ewv, eVar, ao.this.pqe);
                int a3 = q.a(ewv, eVar);
                int Rm = ao.Rm(a3);
                int i2 = ao.this.pmz ? Rm : b;
                inputStream = eVar.getInputStream();
                try {
                    if (ao.pqd.contains(Integer.valueOf(eVar.evy()))) {
                        int b2 = ao.b(ewv.exo(), eVar);
                        a2 = a(eVar, ewv, i2, Rm, b, 0);
                        JpegTranscoder.b(inputStream, epY, b2, i2, 85);
                    } else {
                        int a4 = ao.a(ewv.exo(), eVar);
                        a2 = a(eVar, ewv, i2, Rm, b, a4);
                        JpegTranscoder.a(inputStream, epY, a4, i2, 85);
                    }
                    com.facebook.common.references.a e = com.facebook.common.references.a.e(epY.epZ());
                    try {
                        com.facebook.imagepipeline.f.e eVar2 = new com.facebook.imagepipeline.f.e(e);
                        eVar2.c(com.facebook.c.b.piS);
                        eVar2.evD();
                        this.poK.eww().a(this.poK.getId(), "ResizeAndRotateProducer", a2);
                        if (a3 != 1) {
                            i |= 16;
                        }
                        ewI().h(eVar2, i);
                        com.facebook.imagepipeline.f.e.e(eVar2);
                        com.facebook.common.internal.b.r(inputStream);
                        epY.close();
                    } finally {
                        com.facebook.common.references.a.c(e);
                    }
                } catch (Exception e2) {
                    e = e2;
                    inputStream2 = inputStream;
                    try {
                        this.poK.eww().a(this.poK.getId(), "ResizeAndRotateProducer", e, (Map<String, String>) null);
                        if (Rh(i)) {
                            ewI().E(e);
                        }
                        com.facebook.common.internal.b.r(inputStream2);
                        epY.close();
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        com.facebook.common.internal.b.r(inputStream);
                        epY.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.facebook.common.internal.b.r(inputStream);
                    epY.close();
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                inputStream2 = null;
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
            }
        }

        private Map<String, String> a(com.facebook.imagepipeline.f.e eVar, ImageRequest imageRequest, int i, int i2, int i3, int i4) {
            String str;
            if (!this.poK.eww().Zq(this.poK.getId())) {
                return null;
            }
            String str2 = eVar.getWidth() + "x" + eVar.getHeight();
            if (imageRequest.exn() != null) {
                str = imageRequest.exn().width + "x" + imageRequest.exn().height;
            } else {
                str = "Unspecified";
            }
            String str3 = i > 0 ? i + "/8" : "";
            HashMap hashMap = new HashMap();
            hashMap.put("Original size", str2);
            hashMap.put("Requested size", str);
            hashMap.put("Fraction", str3);
            hashMap.put("queueTime", String.valueOf(this.poQ.ewS()));
            hashMap.put("downsampleEnumerator", Integer.toString(i2));
            hashMap.put("softwareEnumerator", Integer.toString(i3));
            hashMap.put("rotationAngle", Integer.toString(i4));
            return ImmutableMap.copyOf((Map) hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState a(ImageRequest imageRequest, com.facebook.imagepipeline.f.e eVar, boolean z) {
        if (eVar == null || eVar.evB() == com.facebook.c.c.pjc) {
            return TriState.UNSET;
        }
        if (eVar.evB() != com.facebook.c.b.piS) {
            return TriState.NO;
        }
        return TriState.valueOf(c(imageRequest.exo(), eVar) || Rl(b(imageRequest, eVar, z)));
    }

    static float a(com.facebook.imagepipeline.common.d dVar, int i, int i2) {
        if (dVar == null) {
            return 1.0f;
        }
        float max = Math.max(dVar.width / i, dVar.height / i2);
        if (i * max > dVar.plc) {
            max = dVar.plc / i;
        }
        if (i2 * max > dVar.plc) {
            return dVar.plc / i2;
        }
        return max;
    }

    static int I(float f, float f2) {
        return (int) ((8.0f * f) + f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(ImageRequest imageRequest, com.facebook.imagepipeline.f.e eVar, boolean z) {
        com.facebook.imagepipeline.common.d exn;
        if (z && (exn = imageRequest.exn()) != null) {
            int a2 = a(imageRequest.exo(), eVar);
            int b = pqd.contains(Integer.valueOf(eVar.evy())) ? b(imageRequest.exo(), eVar) : 0;
            boolean z2 = a2 == 90 || a2 == 270 || b == 5 || b == 7;
            int I = I(a(exn, z2 ? eVar.getHeight() : eVar.getWidth(), z2 ? eVar.getWidth() : eVar.getHeight()), exn.pld);
            if (I > 8) {
                return 8;
            }
            if (I < 1) {
                return 1;
            }
            return I;
        }
        return 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int a(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.f.e eVar2) {
        if (!eVar.etD()) {
            return 0;
        }
        int j = j(eVar2);
        return !eVar.etC() ? (j + eVar.etE()) % EncoderTextureDrawer.X264_WIDTH : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.f.e eVar2) {
        int indexOf = pqd.indexOf(Integer.valueOf(eVar2.evy()));
        if (indexOf < 0) {
            throw new IllegalArgumentException("Only accepts inverted exif orientations");
        }
        int i = 0;
        if (!eVar.etC()) {
            i = eVar.etE();
        }
        return pqd.get(((i / 90) + indexOf) % pqd.size()).intValue();
    }

    private static int j(com.facebook.imagepipeline.f.e eVar) {
        switch (eVar.evx()) {
            case 90:
            case 180:
            case 270:
                return eVar.evx();
            default:
                return 0;
        }
    }

    private static boolean Rl(int i) {
        return i < 8;
    }

    private static boolean c(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.f.e eVar2) {
        return !eVar.etF() && (a(eVar, eVar2) != 0 || d(eVar, eVar2));
    }

    private static boolean d(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.f.e eVar2) {
        if (!eVar.etD() || eVar.etF()) {
            eVar2.QK(0);
            return false;
        }
        return pqd.contains(Integer.valueOf(eVar2.evy()));
    }

    static int Rm(int i) {
        return Math.max(1, 8 / i);
    }
}
