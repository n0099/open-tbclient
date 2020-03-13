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
    private static final ImmutableList<Integer> lWQ = ImmutableList.of((Object[]) new Integer[]{2, 7, 4, 5});
    private final com.facebook.common.memory.g lQD;
    private final boolean lTr;
    private final aj<com.facebook.imagepipeline.g.e> lVm;
    private final boolean lWR;
    private final Executor mExecutor;

    public ao(Executor executor, com.facebook.common.memory.g gVar, boolean z, aj<com.facebook.imagepipeline.g.e> ajVar, boolean z2) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.lQD = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.lWR = z;
        this.lVm = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.lTr = z2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.lVm.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes12.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private boolean UW;
        private final JobScheduler lVF;
        private final ak lVz;

        public a(final k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.UW = false;
            this.lVz = akVar;
            this.lVF = new JobScheduler(ao.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.ao.a.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.g.e eVar, int i) {
                    a.this.g(eVar, i);
                }
            }, 100);
            this.lVz.a(new e() { // from class: com.facebook.imagepipeline.producers.ao.a.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void drG() {
                    if (a.this.lVz.drD()) {
                        a.this.lVF.drR();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dnQ() {
                    a.this.lVF.drQ();
                    a.this.UW = true;
                    kVar.dkF();
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
                    TriState a = ao.a(this.lVz.dry(), eVar, ao.this.lWR);
                    if (IJ || a != TriState.UNSET) {
                        if (a != TriState.YES) {
                            if (!this.lVz.dry().dsu().doD() && eVar.dqw() != 0 && eVar.dqw() != -1) {
                                eVar = k(eVar);
                                eVar.Il(0);
                            }
                            drK().g(eVar, i);
                        } else if (this.lVF.e(eVar, i)) {
                            if (IJ || this.lVz.drD()) {
                                this.lVF.drR();
                            }
                        }
                    }
                } else if (IJ) {
                    drK().g(null, 1);
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
            this.lVz.drz().fm(this.lVz.getId(), "ResizeAndRotateProducer");
            ImageRequest dry = this.lVz.dry();
            com.facebook.common.memory.i dkR = ao.this.lQD.dkR();
            try {
                int b = ao.b(dry, eVar, ao.this.lWR);
                int a2 = q.a(dry, eVar);
                int IO = ao.IO(a2);
                int i2 = ao.this.lTr ? IO : b;
                inputStream = eVar.getInputStream();
                try {
                    if (ao.lWQ.contains(Integer.valueOf(eVar.dqx()))) {
                        int b2 = ao.b(dry.dsu(), eVar);
                        a = a(eVar, dry, i2, IO, b, 0);
                        JpegTranscoder.b(inputStream, dkR, b2, i2, 85);
                    } else {
                        int a3 = ao.a(dry.dsu(), eVar);
                        a = a(eVar, dry, i2, IO, b, a3);
                        JpegTranscoder.a(inputStream, dkR, a3, i2, 85);
                    }
                    com.facebook.common.references.a b3 = com.facebook.common.references.a.b(dkR.dkS());
                    try {
                        com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(b3);
                        eVar2.c(com.facebook.c.b.lPB);
                        eVar2.dqC();
                        this.lVz.drz().a(this.lVz.getId(), "ResizeAndRotateProducer", a);
                        if (a2 != 1) {
                            i |= 16;
                        }
                        drK().g(eVar2, i);
                        com.facebook.imagepipeline.g.e.e(eVar2);
                        com.facebook.common.internal.b.r(inputStream);
                        dkR.close();
                    } finally {
                        com.facebook.common.references.a.c(b3);
                    }
                } catch (Exception e) {
                    e = e;
                    inputStream2 = inputStream;
                    try {
                        this.lVz.drz().a(this.lVz.getId(), "ResizeAndRotateProducer", e, (Map<String, String>) null);
                        if (IJ(i)) {
                            drK().C(e);
                        }
                        com.facebook.common.internal.b.r(inputStream2);
                        dkR.close();
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        com.facebook.common.internal.b.r(inputStream);
                        dkR.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.facebook.common.internal.b.r(inputStream);
                    dkR.close();
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
            if (!this.lVz.drz().Pe(this.lVz.getId())) {
                return null;
            }
            String str2 = eVar.getWidth() + Config.EVENT_HEAT_X + eVar.getHeight();
            if (imageRequest.dst() != null) {
                str = imageRequest.dst().width + Config.EVENT_HEAT_X + imageRequest.dst().height;
            } else {
                str = "Unspecified";
            }
            String str3 = i > 0 ? i + "/8" : "";
            HashMap hashMap = new HashMap();
            hashMap.put("Original size", str2);
            hashMap.put("Requested size", str);
            hashMap.put("Fraction", str3);
            hashMap.put("queueTime", String.valueOf(this.lVF.drV()));
            hashMap.put("downsampleEnumerator", Integer.toString(i2));
            hashMap.put("softwareEnumerator", Integer.toString(i3));
            hashMap.put("rotationAngle", Integer.toString(i4));
            return ImmutableMap.copyOf((Map) hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState a(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar, boolean z) {
        if (eVar == null || eVar.dqA() == com.facebook.c.c.lPL) {
            return TriState.UNSET;
        }
        if (eVar.dqA() != com.facebook.c.b.lPB) {
            return TriState.NO;
        }
        return TriState.valueOf(c(imageRequest.dsu(), eVar) || IN(b(imageRequest, eVar, z)));
    }

    static float a(com.facebook.imagepipeline.common.d dVar, int i, int i2) {
        if (dVar == null) {
            return 1.0f;
        }
        float max = Math.max(dVar.width / i, dVar.height / i2);
        if (i * max > dVar.lRS) {
            max = dVar.lRS / i;
        }
        if (i2 * max > dVar.lRS) {
            return dVar.lRS / i2;
        }
        return max;
    }

    static int D(float f, float f2) {
        return (int) ((8.0f * f) + f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar, boolean z) {
        com.facebook.imagepipeline.common.d dst;
        if (z && (dst = imageRequest.dst()) != null) {
            int a2 = a(imageRequest.dsu(), eVar);
            int b = lWQ.contains(Integer.valueOf(eVar.dqx())) ? b(imageRequest.dsu(), eVar) : 0;
            boolean z2 = a2 == 90 || a2 == 270 || b == 5 || b == 7;
            int D = D(a(dst, z2 ? eVar.getHeight() : eVar.getWidth(), z2 ? eVar.getWidth() : eVar.getHeight()), dst.lRT);
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
        if (!eVar.doB()) {
            return 0;
        }
        int j = j(eVar2);
        return !eVar.doA() ? (j + eVar.doC()) % 360 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        int indexOf = lWQ.indexOf(Integer.valueOf(eVar2.dqx()));
        if (indexOf < 0) {
            throw new IllegalArgumentException("Only accepts inverted exif orientations");
        }
        int i = 0;
        if (!eVar.doA()) {
            i = eVar.doC();
        }
        return lWQ.get(((i / 90) + indexOf) % lWQ.size()).intValue();
    }

    private static int j(com.facebook.imagepipeline.g.e eVar) {
        switch (eVar.dqw()) {
            case 90:
            case 180:
            case 270:
                return eVar.dqw();
            default:
                return 0;
        }
    }

    private static boolean IN(int i) {
        return i < 8;
    }

    private static boolean c(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        return !eVar.doD() && (a(eVar, eVar2) != 0 || d(eVar, eVar2));
    }

    private static boolean d(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        if (!eVar.doB() || eVar.doD()) {
            eVar2.Im(0);
            return false;
        }
        return lWQ.contains(Integer.valueOf(eVar2.dqx()));
    }

    static int IO(int i) {
        return Math.max(1, 8 / i);
    }
}
