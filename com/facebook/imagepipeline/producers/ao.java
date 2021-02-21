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
    private static final ImmutableList<Integer> pNt = ImmutableList.of((Object[]) new Integer[]{2, 7, 4, 5});
    private final Executor mExecutor;
    private final com.facebook.common.memory.g pHk;
    private final boolean pJT;
    private final aj<com.facebook.imagepipeline.f.e> pLO;
    private final boolean pNu;

    public ao(Executor executor, com.facebook.common.memory.g gVar, boolean z, aj<com.facebook.imagepipeline.f.e> ajVar, boolean z2) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.pHk = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.pNu = z;
        this.pLO = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.pJT = z2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        this.pLO.a(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes5.dex */
    private class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private boolean fpC;
        private final ak pMb;
        private final JobScheduler pMh;

        public a(final k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
            super(kVar);
            this.fpC = false;
            this.pMb = akVar;
            this.pMh = new JobScheduler(ao.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.ao.a.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.f.e eVar, int i) {
                    a.this.g(eVar, i);
                }
            }, 100);
            this.pMb.a(new e() { // from class: com.facebook.imagepipeline.producers.ao.a.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ezy() {
                    if (a.this.pMb.ezu()) {
                        a.this.pMh.ezI();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ezw() {
                    a.this.pMh.ezH();
                    a.this.fpC = true;
                    kVar.esD();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(@Nullable com.facebook.imagepipeline.f.e eVar, int i) {
            if (!this.fpC) {
                boolean Qk = Qk(i);
                if (eVar != null) {
                    TriState a2 = ao.a(this.pMb.ezp(), eVar, ao.this.pNu);
                    if (Qk || a2 != TriState.UNSET) {
                        if (a2 != TriState.YES) {
                            if (!this.pMb.ezp().eAi().ewz() && eVar.eys() != 0 && eVar.eys() != -1) {
                                eVar = k(eVar);
                                eVar.PM(0);
                            }
                            ezC().g(eVar, i);
                        } else if (this.pMh.e(eVar, i)) {
                            if (Qk || this.pMb.ezu()) {
                                this.pMh.ezI();
                            }
                        }
                    }
                } else if (Qk) {
                    ezC().g(null, 1);
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
            this.pMb.ezq().hv(this.pMb.getId(), "ResizeAndRotateProducer");
            ImageRequest ezp = this.pMb.ezp();
            com.facebook.common.memory.i esP = ao.this.pHk.esP();
            try {
                int b2 = ao.b(ezp, eVar, ao.this.pNu);
                int a3 = q.a(ezp, eVar);
                int Qo = ao.Qo(a3);
                int i2 = ao.this.pJT ? Qo : b2;
                inputStream = eVar.getInputStream();
                try {
                    try {
                        try {
                            if (ao.pNt.contains(Integer.valueOf(eVar.eyt()))) {
                                int b3 = ao.b(ezp.eAi(), eVar);
                                a2 = a(eVar, ezp, i2, Qo, b2, 0);
                                JpegTranscoder.b(inputStream, esP, b3, i2, 85);
                            } else {
                                int a4 = ao.a(ezp.eAi(), eVar);
                                a2 = a(eVar, ezp, i2, Qo, b2, a4);
                                JpegTranscoder.a(inputStream, esP, a4, i2, 85);
                            }
                            com.facebook.common.references.a e = com.facebook.common.references.a.e(esP.esQ());
                            try {
                                com.facebook.imagepipeline.f.e eVar2 = new com.facebook.imagepipeline.f.e(e);
                                eVar2.c(com.facebook.c.b.pGo);
                                eVar2.eyy();
                                this.pMb.ezq().b(this.pMb.getId(), "ResizeAndRotateProducer", a2);
                                if (a3 != 1) {
                                    i |= 16;
                                }
                                ezC().g(eVar2, i);
                                com.facebook.imagepipeline.f.e.e(eVar2);
                                com.facebook.common.internal.b.r(inputStream);
                                esP.close();
                            } finally {
                                com.facebook.common.references.a.c(e);
                            }
                        } catch (Exception e2) {
                            e = e2;
                            inputStream2 = inputStream;
                            map = null;
                            try {
                                this.pMb.ezq().a(this.pMb.getId(), "ResizeAndRotateProducer", e, map);
                                if (Qk(i)) {
                                    ezC().C(e);
                                }
                                com.facebook.common.internal.b.r(inputStream2);
                                esP.close();
                            } catch (Throwable th) {
                                th = th;
                                inputStream = inputStream2;
                                com.facebook.common.internal.b.r(inputStream);
                                esP.close();
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        com.facebook.common.internal.b.r(inputStream);
                        esP.close();
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
            if (!this.pMb.ezq().ZG(this.pMb.getId())) {
                return null;
            }
            String str2 = eVar.getWidth() + Config.EVENT_HEAT_X + eVar.getHeight();
            if (imageRequest.eAh() != null) {
                str = imageRequest.eAh().width + Config.EVENT_HEAT_X + imageRequest.eAh().height;
            } else {
                str = "Unspecified";
            }
            String str3 = i > 0 ? i + "/8" : "";
            HashMap hashMap = new HashMap();
            hashMap.put("Original size", str2);
            hashMap.put("Requested size", str);
            hashMap.put("Fraction", str3);
            hashMap.put("queueTime", String.valueOf(this.pMh.ezM()));
            hashMap.put("downsampleEnumerator", Integer.toString(i2));
            hashMap.put("softwareEnumerator", Integer.toString(i3));
            hashMap.put("rotationAngle", Integer.toString(i4));
            return ImmutableMap.copyOf((Map) hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState a(ImageRequest imageRequest, com.facebook.imagepipeline.f.e eVar, boolean z) {
        if (eVar == null || eVar.eyw() == com.facebook.c.c.pGy) {
            return TriState.UNSET;
        }
        if (eVar.eyw() != com.facebook.c.b.pGo) {
            return TriState.NO;
        }
        return TriState.valueOf(c(imageRequest.eAi(), eVar) || Qn(b(imageRequest, eVar, z)));
    }

    static float a(com.facebook.imagepipeline.common.d dVar, int i, int i2) {
        if (dVar == null) {
            return 1.0f;
        }
        float max = Math.max(dVar.width / i, dVar.height / i2);
        if (i * max > dVar.pIw) {
            max = dVar.pIw / i;
        }
        if (i2 * max > dVar.pIw) {
            return dVar.pIw / i2;
        }
        return max;
    }

    static int K(float f, float f2) {
        return (int) ((8.0f * f) + f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(ImageRequest imageRequest, com.facebook.imagepipeline.f.e eVar, boolean z) {
        com.facebook.imagepipeline.common.d eAh;
        if (z && (eAh = imageRequest.eAh()) != null) {
            int a2 = a(imageRequest.eAi(), eVar);
            int b2 = pNt.contains(Integer.valueOf(eVar.eyt())) ? b(imageRequest.eAi(), eVar) : 0;
            boolean z2 = a2 == 90 || a2 == 270 || b2 == 5 || b2 == 7;
            int K = K(a(eAh, z2 ? eVar.getHeight() : eVar.getWidth(), z2 ? eVar.getWidth() : eVar.getHeight()), eAh.pIx);
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
        if (!eVar.ewx()) {
            return 0;
        }
        int j = j(eVar2);
        return !eVar.eww() ? (j + eVar.ewy()) % EncoderTextureDrawer.X264_WIDTH : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.f.e eVar2) {
        int indexOf = pNt.indexOf(Integer.valueOf(eVar2.eyt()));
        if (indexOf < 0) {
            throw new IllegalArgumentException("Only accepts inverted exif orientations");
        }
        int i = 0;
        if (!eVar.eww()) {
            i = eVar.ewy();
        }
        return pNt.get(((i / 90) + indexOf) % pNt.size()).intValue();
    }

    private static int j(com.facebook.imagepipeline.f.e eVar) {
        switch (eVar.eys()) {
            case 90:
            case 180:
            case 270:
                return eVar.eys();
            default:
                return 0;
        }
    }

    private static boolean Qn(int i) {
        return i < 8;
    }

    private static boolean c(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.f.e eVar2) {
        return !eVar.ewz() && (a(eVar, eVar2) != 0 || d(eVar, eVar2));
    }

    private static boolean d(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.f.e eVar2) {
        if (!eVar.ewx() || eVar.ewz()) {
            eVar2.PN(0);
            return false;
        }
        return pNt.contains(Integer.valueOf(eVar2.eyt()));
    }

    static int Qo(int i) {
        return Math.max(1, 8 / i);
    }
}
