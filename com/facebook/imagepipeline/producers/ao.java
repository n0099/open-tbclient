package com.facebook.imagepipeline.producers;

import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
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
/* loaded from: classes3.dex */
public class ao implements aj<com.facebook.imagepipeline.f.e> {
    private static final ImmutableList<Integer> pHl = ImmutableList.of((Object[]) new Integer[]{2, 7, 4, 5});
    private final Executor mExecutor;
    private final com.facebook.common.memory.g pBc;
    private final boolean pDL;
    private final aj<com.facebook.imagepipeline.f.e> pFG;
    private final boolean pHm;

    public ao(Executor executor, com.facebook.common.memory.g gVar, boolean z, aj<com.facebook.imagepipeline.f.e> ajVar, boolean z2) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.pBc = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.pHm = z;
        this.pFG = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.pDL = z2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        this.pFG.a(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes3.dex */
    private class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private boolean frU;
        private final ak pFT;
        private final JobScheduler pFZ;

        public a(final k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
            super(kVar);
            this.frU = false;
            this.pFT = akVar;
            this.pFZ = new JobScheduler(ao.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.ao.a.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.f.e eVar, int i) {
                    a.this.g(eVar, i);
                }
            }, 100);
            this.pFT.a(new e() { // from class: com.facebook.imagepipeline.producers.ao.a.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void eAQ() {
                    if (a.this.pFT.eAM()) {
                        a.this.pFZ.eBa();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void eAO() {
                    a.this.pFZ.eAZ();
                    a.this.frU = true;
                    kVar.etW();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(@Nullable com.facebook.imagepipeline.f.e eVar, int i) {
            if (!this.frU) {
                boolean Rv = Rv(i);
                if (eVar != null) {
                    TriState a2 = ao.a(this.pFT.eAH(), eVar, ao.this.pHm);
                    if (Rv || a2 != TriState.UNSET) {
                        if (a2 != TriState.YES) {
                            if (!this.pFT.eAH().eBA().exR() && eVar.ezJ() != 0 && eVar.ezJ() != -1) {
                                eVar = k(eVar);
                                eVar.QX(0);
                            }
                            eAU().g(eVar, i);
                        } else if (this.pFZ.e(eVar, i)) {
                            if (Rv || this.pFT.eAM()) {
                                this.pFZ.eBa();
                            }
                        }
                    }
                } else if (Rv) {
                    eAU().g(null, 1);
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
            this.pFT.eAI().hn(this.pFT.getId(), "ResizeAndRotateProducer");
            ImageRequest eAH = this.pFT.eAH();
            com.facebook.common.memory.i eui = ao.this.pBc.eui();
            try {
                int b2 = ao.b(eAH, eVar, ao.this.pHm);
                int a3 = q.a(eAH, eVar);
                int Rz = ao.Rz(a3);
                int i2 = ao.this.pDL ? Rz : b2;
                inputStream = eVar.getInputStream();
                try {
                    try {
                        try {
                            if (ao.pHl.contains(Integer.valueOf(eVar.ezK()))) {
                                int b3 = ao.b(eAH.eBA(), eVar);
                                a2 = a(eVar, eAH, i2, Rz, b2, 0);
                                JpegTranscoder.b(inputStream, eui, b3, i2, 85);
                            } else {
                                int a4 = ao.a(eAH.eBA(), eVar);
                                a2 = a(eVar, eAH, i2, Rz, b2, a4);
                                JpegTranscoder.a(inputStream, eui, a4, i2, 85);
                            }
                            com.facebook.common.references.a f = com.facebook.common.references.a.f(eui.euj());
                            try {
                                com.facebook.imagepipeline.f.e eVar2 = new com.facebook.imagepipeline.f.e(f);
                                eVar2.c(com.facebook.c.b.pAg);
                                eVar2.ezP();
                                this.pFT.eAI().b(this.pFT.getId(), "ResizeAndRotateProducer", a2);
                                if (a3 != 1) {
                                    i |= 16;
                                }
                                eAU().g(eVar2, i);
                                com.facebook.imagepipeline.f.e.e(eVar2);
                                com.facebook.common.internal.b.u(inputStream);
                                eui.close();
                            } finally {
                                com.facebook.common.references.a.c(f);
                            }
                        } catch (Exception e) {
                            e = e;
                            inputStream2 = inputStream;
                            map = null;
                            try {
                                this.pFT.eAI().a(this.pFT.getId(), "ResizeAndRotateProducer", e, map);
                                if (Rv(i)) {
                                    eAU().D(e);
                                }
                                com.facebook.common.internal.b.u(inputStream2);
                                eui.close();
                            } catch (Throwable th) {
                                th = th;
                                inputStream = inputStream2;
                                com.facebook.common.internal.b.u(inputStream);
                                eui.close();
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        com.facebook.common.internal.b.u(inputStream);
                        eui.close();
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    inputStream2 = inputStream;
                    map = null;
                }
            } catch (Exception e3) {
                e = e3;
                inputStream2 = null;
                map = null;
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
            }
        }

        private Map<String, String> a(com.facebook.imagepipeline.f.e eVar, ImageRequest imageRequest, int i, int i2, int i3, int i4) {
            String str;
            if (!this.pFT.eAI().ZA(this.pFT.getId())) {
                return null;
            }
            String str2 = eVar.getWidth() + "x" + eVar.getHeight();
            if (imageRequest.eBz() != null) {
                str = imageRequest.eBz().width + "x" + imageRequest.eBz().height;
            } else {
                str = "Unspecified";
            }
            String str3 = i > 0 ? i + "/8" : "";
            HashMap hashMap = new HashMap();
            hashMap.put("Original size", str2);
            hashMap.put("Requested size", str);
            hashMap.put("Fraction", str3);
            hashMap.put("queueTime", String.valueOf(this.pFZ.eBe()));
            hashMap.put("downsampleEnumerator", Integer.toString(i2));
            hashMap.put("softwareEnumerator", Integer.toString(i3));
            hashMap.put("rotationAngle", Integer.toString(i4));
            return ImmutableMap.copyOf((Map) hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState a(ImageRequest imageRequest, com.facebook.imagepipeline.f.e eVar, boolean z) {
        if (eVar == null || eVar.ezN() == com.facebook.c.c.pAq) {
            return TriState.UNSET;
        }
        if (eVar.ezN() != com.facebook.c.b.pAg) {
            return TriState.NO;
        }
        return TriState.valueOf(c(imageRequest.eBA(), eVar) || Ry(b(imageRequest, eVar, z)));
    }

    static float a(com.facebook.imagepipeline.common.d dVar, int i, int i2) {
        if (dVar == null) {
            return 1.0f;
        }
        float max = Math.max(dVar.width / i, dVar.height / i2);
        if (i * max > dVar.pCo) {
            max = dVar.pCo / i;
        }
        if (i2 * max > dVar.pCo) {
            return dVar.pCo / i2;
        }
        return max;
    }

    static int J(float f, float f2) {
        return (int) ((8.0f * f) + f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(ImageRequest imageRequest, com.facebook.imagepipeline.f.e eVar, boolean z) {
        com.facebook.imagepipeline.common.d eBz;
        if (z && (eBz = imageRequest.eBz()) != null) {
            int a2 = a(imageRequest.eBA(), eVar);
            int b2 = pHl.contains(Integer.valueOf(eVar.ezK())) ? b(imageRequest.eBA(), eVar) : 0;
            boolean z2 = a2 == 90 || a2 == 270 || b2 == 5 || b2 == 7;
            int J = J(a(eBz, z2 ? eVar.getHeight() : eVar.getWidth(), z2 ? eVar.getWidth() : eVar.getHeight()), eBz.pCp);
            if (J > 8) {
                return 8;
            }
            if (J < 1) {
                return 1;
            }
            return J;
        }
        return 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int a(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.f.e eVar2) {
        if (!eVar.exP()) {
            return 0;
        }
        int j = j(eVar2);
        return !eVar.exO() ? (j + eVar.exQ()) % EncoderTextureDrawer.X264_WIDTH : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.f.e eVar2) {
        int indexOf = pHl.indexOf(Integer.valueOf(eVar2.ezK()));
        if (indexOf < 0) {
            throw new IllegalArgumentException("Only accepts inverted exif orientations");
        }
        int i = 0;
        if (!eVar.exO()) {
            i = eVar.exQ();
        }
        return pHl.get(((i / 90) + indexOf) % pHl.size()).intValue();
    }

    private static int j(com.facebook.imagepipeline.f.e eVar) {
        switch (eVar.ezJ()) {
            case 90:
            case 180:
            case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                return eVar.ezJ();
            default:
                return 0;
        }
    }

    private static boolean Ry(int i) {
        return i < 8;
    }

    private static boolean c(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.f.e eVar2) {
        return !eVar.exR() && (a(eVar, eVar2) != 0 || d(eVar, eVar2));
    }

    private static boolean d(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.f.e eVar2) {
        if (!eVar.exP() || eVar.exR()) {
            eVar2.QY(0);
            return false;
        }
        return pHl.contains(Integer.valueOf(eVar2.ezK()));
    }

    static int Rz(int i) {
        return Math.max(1, 8 / i);
    }
}
