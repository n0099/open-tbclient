package com.facebook.imagepipeline.producers;

import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.mobstat.Config;
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
/* loaded from: classes5.dex */
public class ao implements aj<com.facebook.imagepipeline.f.e> {
    private static final ImmutableList<Integer> pMT = ImmutableList.of((Object[]) new Integer[]{2, 7, 4, 5});
    private final Executor mExecutor;
    private final com.facebook.common.memory.g pGK;
    private final boolean pJt;
    private final aj<com.facebook.imagepipeline.f.e> pLo;
    private final boolean pMU;

    public ao(Executor executor, com.facebook.common.memory.g gVar, boolean z, aj<com.facebook.imagepipeline.f.e> ajVar, boolean z2) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.pGK = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.pMU = z;
        this.pLo = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.pJt = z2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        this.pLo.a(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes5.dex */
    private class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private boolean fpC;
        private final ak pLB;
        private final JobScheduler pLH;

        public a(final k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
            super(kVar);
            this.fpC = false;
            this.pLB = akVar;
            this.pLH = new JobScheduler(ao.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.ao.a.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.f.e eVar, int i) {
                    a.this.g(eVar, i);
                }
            }, 100);
            this.pLB.a(new e() { // from class: com.facebook.imagepipeline.producers.ao.a.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ezq() {
                    if (a.this.pLB.ezm()) {
                        a.this.pLH.ezA();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ezo() {
                    a.this.pLH.ezz();
                    a.this.fpC = true;
                    kVar.esv();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(@Nullable com.facebook.imagepipeline.f.e eVar, int i) {
            if (!this.fpC) {
                boolean Qj = Qj(i);
                if (eVar != null) {
                    TriState a2 = ao.a(this.pLB.ezh(), eVar, ao.this.pMU);
                    if (Qj || a2 != TriState.UNSET) {
                        if (a2 != TriState.YES) {
                            if (!this.pLB.ezh().eAa().ewr() && eVar.eyk() != 0 && eVar.eyk() != -1) {
                                eVar = k(eVar);
                                eVar.PL(0);
                            }
                            ezu().g(eVar, i);
                        } else if (this.pLH.e(eVar, i)) {
                            if (Qj || this.pLB.ezm()) {
                                this.pLH.ezA();
                            }
                        }
                    }
                } else if (Qj) {
                    ezu().g(null, 1);
                }
            }
        }

        private com.facebook.imagepipeline.f.e k(com.facebook.imagepipeline.f.e eVar) {
            com.facebook.imagepipeline.f.e b2 = com.facebook.imagepipeline.f.e.b(eVar);
            eVar.close();
            return b2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [252=4] */
        /* JADX INFO: Access modifiers changed from: private */
        public void g(com.facebook.imagepipeline.f.e eVar, int i) {
            InputStream inputStream;
            InputStream inputStream2;
            Map<String, String> map;
            Map<String, String> a2;
            this.pLB.ezi().ht(this.pLB.getId(), "ResizeAndRotateProducer");
            ImageRequest ezh = this.pLB.ezh();
            com.facebook.common.memory.i esH = ao.this.pGK.esH();
            try {
                int b2 = ao.b(ezh, eVar, ao.this.pMU);
                int a3 = q.a(ezh, eVar);
                int Qn = ao.Qn(a3);
                int i2 = ao.this.pJt ? Qn : b2;
                inputStream = eVar.getInputStream();
                try {
                    try {
                        try {
                            if (ao.pMT.contains(Integer.valueOf(eVar.eyl()))) {
                                int b3 = ao.b(ezh.eAa(), eVar);
                                a2 = a(eVar, ezh, i2, Qn, b2, 0);
                                JpegTranscoder.b(inputStream, esH, b3, i2, 85);
                            } else {
                                int a4 = ao.a(ezh.eAa(), eVar);
                                a2 = a(eVar, ezh, i2, Qn, b2, a4);
                                JpegTranscoder.a(inputStream, esH, a4, i2, 85);
                            }
                            com.facebook.common.references.a e = com.facebook.common.references.a.e(esH.esI());
                            try {
                                com.facebook.imagepipeline.f.e eVar2 = new com.facebook.imagepipeline.f.e(e);
                                eVar2.c(com.facebook.c.b.pFO);
                                eVar2.eyq();
                                this.pLB.ezi().b(this.pLB.getId(), "ResizeAndRotateProducer", a2);
                                if (a3 != 1) {
                                    i |= 16;
                                }
                                ezu().g(eVar2, i);
                                com.facebook.imagepipeline.f.e.e(eVar2);
                                com.facebook.common.internal.b.r(inputStream);
                                esH.close();
                            } finally {
                                com.facebook.common.references.a.c(e);
                            }
                        } catch (Exception e2) {
                            e = e2;
                            inputStream2 = inputStream;
                            map = null;
                            try {
                                this.pLB.ezi().a(this.pLB.getId(), "ResizeAndRotateProducer", e, map);
                                if (Qj(i)) {
                                    ezu().C(e);
                                }
                                com.facebook.common.internal.b.r(inputStream2);
                                esH.close();
                            } catch (Throwable th) {
                                th = th;
                                inputStream = inputStream2;
                                com.facebook.common.internal.b.r(inputStream);
                                esH.close();
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        com.facebook.common.internal.b.r(inputStream);
                        esH.close();
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    inputStream2 = inputStream;
                    map = null;
                }
            } catch (Exception e4) {
                e = e4;
                inputStream2 = null;
                map = null;
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
            }
        }

        private Map<String, String> a(com.facebook.imagepipeline.f.e eVar, ImageRequest imageRequest, int i, int i2, int i3, int i4) {
            String str;
            if (!this.pLB.ezi().Zu(this.pLB.getId())) {
                return null;
            }
            String str2 = eVar.getWidth() + Config.EVENT_HEAT_X + eVar.getHeight();
            if (imageRequest.ezZ() != null) {
                str = imageRequest.ezZ().width + Config.EVENT_HEAT_X + imageRequest.ezZ().height;
            } else {
                str = "Unspecified";
            }
            String str3 = i > 0 ? i + "/8" : "";
            HashMap hashMap = new HashMap();
            hashMap.put("Original size", str2);
            hashMap.put("Requested size", str);
            hashMap.put("Fraction", str3);
            hashMap.put("queueTime", String.valueOf(this.pLH.ezE()));
            hashMap.put("downsampleEnumerator", Integer.toString(i2));
            hashMap.put("softwareEnumerator", Integer.toString(i3));
            hashMap.put("rotationAngle", Integer.toString(i4));
            return ImmutableMap.copyOf((Map) hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState a(ImageRequest imageRequest, com.facebook.imagepipeline.f.e eVar, boolean z) {
        if (eVar == null || eVar.eyo() == com.facebook.c.c.pFY) {
            return TriState.UNSET;
        }
        if (eVar.eyo() != com.facebook.c.b.pFO) {
            return TriState.NO;
        }
        return TriState.valueOf(c(imageRequest.eAa(), eVar) || Qm(b(imageRequest, eVar, z)));
    }

    static float a(com.facebook.imagepipeline.common.d dVar, int i, int i2) {
        if (dVar == null) {
            return 1.0f;
        }
        float max = Math.max(dVar.width / i, dVar.height / i2);
        if (i * max > dVar.pHW) {
            max = dVar.pHW / i;
        }
        if (i2 * max > dVar.pHW) {
            return dVar.pHW / i2;
        }
        return max;
    }

    static int K(float f, float f2) {
        return (int) ((8.0f * f) + f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(ImageRequest imageRequest, com.facebook.imagepipeline.f.e eVar, boolean z) {
        com.facebook.imagepipeline.common.d ezZ;
        if (z && (ezZ = imageRequest.ezZ()) != null) {
            int a2 = a(imageRequest.eAa(), eVar);
            int b2 = pMT.contains(Integer.valueOf(eVar.eyl())) ? b(imageRequest.eAa(), eVar) : 0;
            boolean z2 = a2 == 90 || a2 == 270 || b2 == 5 || b2 == 7;
            int K = K(a(ezZ, z2 ? eVar.getHeight() : eVar.getWidth(), z2 ? eVar.getWidth() : eVar.getHeight()), ezZ.pHX);
            if (K > 8) {
                return 8;
            }
            if (K < 1) {
                return 1;
            }
            return K;
        }
        return 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int a(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.f.e eVar2) {
        if (!eVar.ewp()) {
            return 0;
        }
        int j = j(eVar2);
        return !eVar.ewo() ? (j + eVar.ewq()) % EncoderTextureDrawer.X264_WIDTH : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.f.e eVar2) {
        int indexOf = pMT.indexOf(Integer.valueOf(eVar2.eyl()));
        if (indexOf < 0) {
            throw new IllegalArgumentException("Only accepts inverted exif orientations");
        }
        int i = 0;
        if (!eVar.ewo()) {
            i = eVar.ewq();
        }
        return pMT.get(((i / 90) + indexOf) % pMT.size()).intValue();
    }

    private static int j(com.facebook.imagepipeline.f.e eVar) {
        switch (eVar.eyk()) {
            case 90:
            case 180:
            case 270:
                return eVar.eyk();
            default:
                return 0;
        }
    }

    private static boolean Qm(int i) {
        return i < 8;
    }

    private static boolean c(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.f.e eVar2) {
        return !eVar.ewr() && (a(eVar, eVar2) != 0 || d(eVar, eVar2));
    }

    private static boolean d(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.f.e eVar2) {
        if (!eVar.ewp() || eVar.ewr()) {
            eVar2.PM(0);
            return false;
        }
        return pMT.contains(Integer.valueOf(eVar2.eyl()));
    }

    static int Qn(int i) {
        return Math.max(1, 8 / i);
    }
}
