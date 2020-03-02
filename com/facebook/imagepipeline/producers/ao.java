package com.facebook.imagepipeline.producers;

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
/* loaded from: classes12.dex */
public class ao implements aj<com.facebook.imagepipeline.g.e> {
    private static final ImmutableList<Integer> lWF = ImmutableList.of((Object[]) new Integer[]{2, 7, 4, 5});
    private final com.facebook.common.memory.g lQs;
    private final boolean lTg;
    private final aj<com.facebook.imagepipeline.g.e> lVb;
    private final boolean lWG;
    private final Executor mExecutor;

    public ao(Executor executor, com.facebook.common.memory.g gVar, boolean z, aj<com.facebook.imagepipeline.g.e> ajVar, boolean z2) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.lQs = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.lWG = z;
        this.lVb = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.lTg = z2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.lVb.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes12.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private boolean UW;
        private final ak lVo;
        private final JobScheduler lVu;

        public a(final k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.UW = false;
            this.lVo = akVar;
            this.lVu = new JobScheduler(ao.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.ao.a.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.g.e eVar, int i) {
                    a.this.g(eVar, i);
                }
            }, 100);
            this.lVo.a(new e() { // from class: com.facebook.imagepipeline.producers.ao.a.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void drF() {
                    if (a.this.lVo.drC()) {
                        a.this.lVu.drQ();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dnP() {
                    a.this.lVu.drP();
                    a.this.UW = true;
                    kVar.dkE();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(@Nullable com.facebook.imagepipeline.g.e eVar, int i) {
            if (!this.UW) {
                boolean IJ = IJ(i);
                if (eVar != null) {
                    TriState a = ao.a(this.lVo.drx(), eVar, ao.this.lWG);
                    if (IJ || a != TriState.UNSET) {
                        if (a != TriState.YES) {
                            if (!this.lVo.drx().dst().doC() && eVar.dqv() != 0 && eVar.dqv() != -1) {
                                eVar = k(eVar);
                                eVar.Il(0);
                            }
                            drJ().g(eVar, i);
                        } else if (this.lVu.e(eVar, i)) {
                            if (IJ || this.lVo.drC()) {
                                this.lVu.drQ();
                            }
                        }
                    }
                } else if (IJ) {
                    drJ().g(null, 1);
                }
            }
        }

        private com.facebook.imagepipeline.g.e k(com.facebook.imagepipeline.g.e eVar) {
            com.facebook.imagepipeline.g.e b = com.facebook.imagepipeline.g.e.b(eVar);
            eVar.close();
            return b;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [252=4] */
        /* JADX INFO: Access modifiers changed from: private */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            InputStream inputStream;
            InputStream inputStream2;
            Map<String, String> a;
            this.lVo.dry().fm(this.lVo.getId(), "ResizeAndRotateProducer");
            ImageRequest drx = this.lVo.drx();
            com.facebook.common.memory.i dkQ = ao.this.lQs.dkQ();
            try {
                int b = ao.b(drx, eVar, ao.this.lWG);
                int a2 = q.a(drx, eVar);
                int IO = ao.IO(a2);
                int i2 = ao.this.lTg ? IO : b;
                inputStream = eVar.getInputStream();
                try {
                    if (ao.lWF.contains(Integer.valueOf(eVar.dqw()))) {
                        int b2 = ao.b(drx.dst(), eVar);
                        a = a(eVar, drx, i2, IO, b, 0);
                        JpegTranscoder.b(inputStream, dkQ, b2, i2, 85);
                    } else {
                        int a3 = ao.a(drx.dst(), eVar);
                        a = a(eVar, drx, i2, IO, b, a3);
                        JpegTranscoder.a(inputStream, dkQ, a3, i2, 85);
                    }
                    com.facebook.common.references.a b3 = com.facebook.common.references.a.b(dkQ.dkR());
                    try {
                        com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(b3);
                        eVar2.c(com.facebook.c.b.lPq);
                        eVar2.dqB();
                        this.lVo.dry().a(this.lVo.getId(), "ResizeAndRotateProducer", a);
                        if (a2 != 1) {
                            i |= 16;
                        }
                        drJ().g(eVar2, i);
                        com.facebook.imagepipeline.g.e.e(eVar2);
                        com.facebook.common.internal.b.r(inputStream);
                        dkQ.close();
                    } finally {
                        com.facebook.common.references.a.c(b3);
                    }
                } catch (Exception e) {
                    e = e;
                    inputStream2 = inputStream;
                    try {
                        this.lVo.dry().a(this.lVo.getId(), "ResizeAndRotateProducer", e, (Map<String, String>) null);
                        if (IJ(i)) {
                            drJ().C(e);
                        }
                        com.facebook.common.internal.b.r(inputStream2);
                        dkQ.close();
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        com.facebook.common.internal.b.r(inputStream);
                        dkQ.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.facebook.common.internal.b.r(inputStream);
                    dkQ.close();
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                inputStream2 = null;
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
            }
        }

        private Map<String, String> a(com.facebook.imagepipeline.g.e eVar, ImageRequest imageRequest, int i, int i2, int i3, int i4) {
            String str;
            if (!this.lVo.dry().Pd(this.lVo.getId())) {
                return null;
            }
            String str2 = eVar.getWidth() + Config.EVENT_HEAT_X + eVar.getHeight();
            if (imageRequest.dss() != null) {
                str = imageRequest.dss().width + Config.EVENT_HEAT_X + imageRequest.dss().height;
            } else {
                str = "Unspecified";
            }
            String str3 = i > 0 ? i + "/8" : "";
            HashMap hashMap = new HashMap();
            hashMap.put("Original size", str2);
            hashMap.put("Requested size", str);
            hashMap.put("Fraction", str3);
            hashMap.put("queueTime", String.valueOf(this.lVu.drU()));
            hashMap.put("downsampleEnumerator", Integer.toString(i2));
            hashMap.put("softwareEnumerator", Integer.toString(i3));
            hashMap.put("rotationAngle", Integer.toString(i4));
            return ImmutableMap.copyOf((Map) hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState a(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar, boolean z) {
        if (eVar == null || eVar.dqz() == com.facebook.c.c.lPA) {
            return TriState.UNSET;
        }
        if (eVar.dqz() != com.facebook.c.b.lPq) {
            return TriState.NO;
        }
        return TriState.valueOf(c(imageRequest.dst(), eVar) || IN(b(imageRequest, eVar, z)));
    }

    static float a(com.facebook.imagepipeline.common.d dVar, int i, int i2) {
        if (dVar == null) {
            return 1.0f;
        }
        float max = Math.max(dVar.width / i, dVar.height / i2);
        if (i * max > dVar.lRH) {
            max = dVar.lRH / i;
        }
        if (i2 * max > dVar.lRH) {
            return dVar.lRH / i2;
        }
        return max;
    }

    static int D(float f, float f2) {
        return (int) ((8.0f * f) + f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar, boolean z) {
        com.facebook.imagepipeline.common.d dss;
        if (z && (dss = imageRequest.dss()) != null) {
            int a2 = a(imageRequest.dst(), eVar);
            int b = lWF.contains(Integer.valueOf(eVar.dqw())) ? b(imageRequest.dst(), eVar) : 0;
            boolean z2 = a2 == 90 || a2 == 270 || b == 5 || b == 7;
            int D = D(a(dss, z2 ? eVar.getHeight() : eVar.getWidth(), z2 ? eVar.getWidth() : eVar.getHeight()), dss.lRI);
            if (D > 8) {
                return 8;
            }
            if (D < 1) {
                return 1;
            }
            return D;
        }
        return 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int a(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        if (!eVar.doA()) {
            return 0;
        }
        int j = j(eVar2);
        return !eVar.doz() ? (j + eVar.doB()) % 360 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        int indexOf = lWF.indexOf(Integer.valueOf(eVar2.dqw()));
        if (indexOf < 0) {
            throw new IllegalArgumentException("Only accepts inverted exif orientations");
        }
        int i = 0;
        if (!eVar.doz()) {
            i = eVar.doB();
        }
        return lWF.get(((i / 90) + indexOf) % lWF.size()).intValue();
    }

    private static int j(com.facebook.imagepipeline.g.e eVar) {
        switch (eVar.dqv()) {
            case 90:
            case 180:
            case 270:
                return eVar.dqv();
            default:
                return 0;
        }
    }

    private static boolean IN(int i) {
        return i < 8;
    }

    private static boolean c(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        return !eVar.doC() && (a(eVar, eVar2) != 0 || d(eVar, eVar2));
    }

    private static boolean d(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        if (!eVar.doA() || eVar.doC()) {
            eVar2.Im(0);
            return false;
        }
        return lWF.contains(Integer.valueOf(eVar2.dqw()));
    }

    static int IO(int i) {
        return Math.max(1, 8 / i);
    }
}
