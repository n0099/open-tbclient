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
    private static final ImmutableList<Integer> pPy = ImmutableList.of((Object[]) new Integer[]{2, 7, 4, 5});
    private final Executor mExecutor;
    private final com.facebook.common.memory.g pJp;
    private final boolean pLY;
    private final aj<com.facebook.imagepipeline.f.e> pNT;
    private final boolean pPz;

    public ao(Executor executor, com.facebook.common.memory.g gVar, boolean z, aj<com.facebook.imagepipeline.f.e> ajVar, boolean z2) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.pJp = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.pPz = z;
        this.pNT = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.pLY = z2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        this.pNT.a(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes5.dex */
    private class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private boolean frb;
        private final ak pOg;
        private final JobScheduler pOm;

        public a(final k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
            super(kVar);
            this.frb = false;
            this.pOg = akVar;
            this.pOm = new JobScheduler(ao.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.ao.a.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.f.e eVar, int i) {
                    a.this.g(eVar, i);
                }
            }, 100);
            this.pOg.a(new e() { // from class: com.facebook.imagepipeline.producers.ao.a.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ezH() {
                    if (a.this.pOg.ezD()) {
                        a.this.pOm.ezR();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ezF() {
                    a.this.pOm.ezQ();
                    a.this.frb = true;
                    kVar.esM();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void e(@Nullable com.facebook.imagepipeline.f.e eVar, int i) {
            if (!this.frb) {
                boolean Qo = Qo(i);
                if (eVar != null) {
                    TriState a2 = ao.a(this.pOg.ezy(), eVar, ao.this.pPz);
                    if (Qo || a2 != TriState.UNSET) {
                        if (a2 != TriState.YES) {
                            if (!this.pOg.ezy().eAr().ewI() && eVar.eyB() != 0 && eVar.eyB() != -1) {
                                eVar = k(eVar);
                                eVar.PQ(0);
                            }
                            ezL().f(eVar, i);
                        } else if (this.pOm.e(eVar, i)) {
                            if (Qo || this.pOg.ezD()) {
                                this.pOm.ezR();
                            }
                        }
                    }
                } else if (Qo) {
                    ezL().f(null, 1);
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
            Map<String, String> map;
            Map<String, String> a2;
            this.pOg.ezz().hv(this.pOg.getId(), "ResizeAndRotateProducer");
            ImageRequest ezy = this.pOg.ezy();
            com.facebook.common.memory.i esY = ao.this.pJp.esY();
            try {
                int b = ao.b(ezy, eVar, ao.this.pPz);
                int a3 = q.a(ezy, eVar);
                int Qs = ao.Qs(a3);
                int i2 = ao.this.pLY ? Qs : b;
                inputStream = eVar.getInputStream();
                try {
                    try {
                        try {
                            if (ao.pPy.contains(Integer.valueOf(eVar.eyC()))) {
                                int b2 = ao.b(ezy.eAr(), eVar);
                                a2 = a(eVar, ezy, i2, Qs, b, 0);
                                JpegTranscoder.b(inputStream, esY, b2, i2, 85);
                            } else {
                                int a4 = ao.a(ezy.eAr(), eVar);
                                a2 = a(eVar, ezy, i2, Qs, b, a4);
                                JpegTranscoder.a(inputStream, esY, a4, i2, 85);
                            }
                            com.facebook.common.references.a d = com.facebook.common.references.a.d(esY.esZ());
                            try {
                                com.facebook.imagepipeline.f.e eVar2 = new com.facebook.imagepipeline.f.e(d);
                                eVar2.c(com.facebook.c.b.pIt);
                                eVar2.eyH();
                                this.pOg.ezz().b(this.pOg.getId(), "ResizeAndRotateProducer", a2);
                                if (a3 != 1) {
                                    i |= 16;
                                }
                                ezL().f(eVar2, i);
                                com.facebook.imagepipeline.f.e.e(eVar2);
                                com.facebook.common.internal.b.r(inputStream);
                                esY.close();
                            } finally {
                                com.facebook.common.references.a.c(d);
                            }
                        } catch (Exception e) {
                            e = e;
                            inputStream2 = inputStream;
                            map = null;
                            try {
                                this.pOg.ezz().a(this.pOg.getId(), "ResizeAndRotateProducer", e, map);
                                if (Qo(i)) {
                                    ezL().C(e);
                                }
                                com.facebook.common.internal.b.r(inputStream2);
                                esY.close();
                            } catch (Throwable th) {
                                th = th;
                                inputStream = inputStream2;
                                com.facebook.common.internal.b.r(inputStream);
                                esY.close();
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        com.facebook.common.internal.b.r(inputStream);
                        esY.close();
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
            if (!this.pOg.ezz().ZM(this.pOg.getId())) {
                return null;
            }
            String str2 = eVar.getWidth() + Config.EVENT_HEAT_X + eVar.getHeight();
            if (imageRequest.eAq() != null) {
                str = imageRequest.eAq().width + Config.EVENT_HEAT_X + imageRequest.eAq().height;
            } else {
                str = "Unspecified";
            }
            String str3 = i > 0 ? i + "/8" : "";
            HashMap hashMap = new HashMap();
            hashMap.put("Original size", str2);
            hashMap.put("Requested size", str);
            hashMap.put("Fraction", str3);
            hashMap.put("queueTime", String.valueOf(this.pOm.ezV()));
            hashMap.put("downsampleEnumerator", Integer.toString(i2));
            hashMap.put("softwareEnumerator", Integer.toString(i3));
            hashMap.put("rotationAngle", Integer.toString(i4));
            return ImmutableMap.copyOf((Map) hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState a(ImageRequest imageRequest, com.facebook.imagepipeline.f.e eVar, boolean z) {
        if (eVar == null || eVar.eyF() == com.facebook.c.c.pID) {
            return TriState.UNSET;
        }
        if (eVar.eyF() != com.facebook.c.b.pIt) {
            return TriState.NO;
        }
        return TriState.valueOf(c(imageRequest.eAr(), eVar) || Qr(b(imageRequest, eVar, z)));
    }

    static float a(com.facebook.imagepipeline.common.d dVar, int i, int i2) {
        if (dVar == null) {
            return 1.0f;
        }
        float max = Math.max(dVar.width / i, dVar.height / i2);
        if (i * max > dVar.pKB) {
            max = dVar.pKB / i;
        }
        if (i2 * max > dVar.pKB) {
            return dVar.pKB / i2;
        }
        return max;
    }

    static int K(float f, float f2) {
        return (int) ((8.0f * f) + f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(ImageRequest imageRequest, com.facebook.imagepipeline.f.e eVar, boolean z) {
        com.facebook.imagepipeline.common.d eAq;
        if (z && (eAq = imageRequest.eAq()) != null) {
            int a2 = a(imageRequest.eAr(), eVar);
            int b = pPy.contains(Integer.valueOf(eVar.eyC())) ? b(imageRequest.eAr(), eVar) : 0;
            boolean z2 = a2 == 90 || a2 == 270 || b == 5 || b == 7;
            int K = K(a(eAq, z2 ? eVar.getHeight() : eVar.getWidth(), z2 ? eVar.getWidth() : eVar.getHeight()), eAq.pKC);
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
        if (!eVar.ewG()) {
            return 0;
        }
        int j = j(eVar2);
        return !eVar.ewF() ? (j + eVar.ewH()) % EncoderTextureDrawer.X264_WIDTH : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.f.e eVar2) {
        int indexOf = pPy.indexOf(Integer.valueOf(eVar2.eyC()));
        if (indexOf < 0) {
            throw new IllegalArgumentException("Only accepts inverted exif orientations");
        }
        int i = 0;
        if (!eVar.ewF()) {
            i = eVar.ewH();
        }
        return pPy.get(((i / 90) + indexOf) % pPy.size()).intValue();
    }

    private static int j(com.facebook.imagepipeline.f.e eVar) {
        switch (eVar.eyB()) {
            case 90:
            case 180:
            case 270:
                return eVar.eyB();
            default:
                return 0;
        }
    }

    private static boolean Qr(int i) {
        return i < 8;
    }

    private static boolean c(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.f.e eVar2) {
        return !eVar.ewI() && (a(eVar, eVar2) != 0 || d(eVar, eVar2));
    }

    private static boolean d(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.f.e eVar2) {
        if (!eVar.ewG() || eVar.ewI()) {
            eVar2.PR(0);
            return false;
        }
        return pPy.contains(Integer.valueOf(eVar2.eyC()));
    }

    static int Qs(int i) {
        return Math.max(1, 8 / i);
    }
}
