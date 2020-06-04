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
    private static final ImmutableList<Integer> mBn = ImmutableList.of((Object[]) new Integer[]{2, 7, 4, 5});
    private final boolean mBo;
    private final Executor mExecutor;
    private final com.facebook.common.memory.g mvb;
    private final boolean mxN;
    private final aj<com.facebook.imagepipeline.g.e> mzI;

    public ao(Executor executor, com.facebook.common.memory.g gVar, boolean z, aj<com.facebook.imagepipeline.g.e> ajVar, boolean z2) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.mvb = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.mBo = z;
        this.mzI = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.mxN = z2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.mzI.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes12.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private boolean dZV;
        private final JobScheduler mAb;
        private final ak mzV;

        public a(final k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.dZV = false;
            this.mzV = akVar;
            this.mAb = new JobScheduler(ao.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.ao.a.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.g.e eVar, int i) {
                    a.this.g(eVar, i);
                }
            }, 100);
            this.mzV.a(new e() { // from class: com.facebook.imagepipeline.producers.ao.a.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dBE() {
                    if (a.this.mzV.dBB()) {
                        a.this.mAb.dBP();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dxO() {
                    a.this.mAb.dBO();
                    a.this.dZV = true;
                    kVar.duA();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(@Nullable com.facebook.imagepipeline.g.e eVar, int i) {
            if (!this.dZV) {
                boolean If = If(i);
                if (eVar != null) {
                    TriState a = ao.a(this.mzV.dBw(), eVar, ao.this.mBo);
                    if (If || a != TriState.UNSET) {
                        if (a != TriState.YES) {
                            if (!this.mzV.dBw().dCr().dyD() && eVar.dAv() != 0 && eVar.dAv() != -1) {
                                eVar = k(eVar);
                                eVar.HH(0);
                            }
                            dBI().h(eVar, i);
                        } else if (this.mAb.e(eVar, i)) {
                            if (If || this.mzV.dBB()) {
                                this.mAb.dBP();
                            }
                        }
                    }
                } else if (If) {
                    dBI().h(null, 1);
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
            this.mzV.dBx().fK(this.mzV.getId(), "ResizeAndRotateProducer");
            ImageRequest dBw = this.mzV.dBw();
            com.facebook.common.memory.i duM = ao.this.mvb.duM();
            try {
                int b = ao.b(dBw, eVar, ao.this.mBo);
                int a2 = q.a(dBw, eVar);
                int Il = ao.Il(a2);
                int i2 = ao.this.mxN ? Il : b;
                inputStream = eVar.getInputStream();
                try {
                    if (ao.mBn.contains(Integer.valueOf(eVar.dAw()))) {
                        int b2 = ao.b(dBw.dCr(), eVar);
                        a = a(eVar, dBw, i2, Il, b, 0);
                        JpegTranscoder.b(inputStream, duM, b2, i2, 85);
                    } else {
                        int a3 = ao.a(dBw.dCr(), eVar);
                        a = a(eVar, dBw, i2, Il, b, a3);
                        JpegTranscoder.a(inputStream, duM, a3, i2, 85);
                    }
                    com.facebook.common.references.a e = com.facebook.common.references.a.e(duM.duN());
                    try {
                        com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(e);
                        eVar2.c(com.facebook.c.b.mtV);
                        eVar2.dAB();
                        this.mzV.dBx().a(this.mzV.getId(), "ResizeAndRotateProducer", a);
                        if (a2 != 1) {
                            i |= 16;
                        }
                        dBI().h(eVar2, i);
                        com.facebook.imagepipeline.g.e.e(eVar2);
                        com.facebook.common.internal.b.p(inputStream);
                        duM.close();
                    } finally {
                        com.facebook.common.references.a.c(e);
                    }
                } catch (Exception e2) {
                    e = e2;
                    inputStream2 = inputStream;
                    try {
                        this.mzV.dBx().a(this.mzV.getId(), "ResizeAndRotateProducer", e, (Map<String, String>) null);
                        if (If(i)) {
                            dBI().G(e);
                        }
                        com.facebook.common.internal.b.p(inputStream2);
                        duM.close();
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        com.facebook.common.internal.b.p(inputStream);
                        duM.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.facebook.common.internal.b.p(inputStream);
                    duM.close();
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

        private Map<String, String> a(com.facebook.imagepipeline.g.e eVar, ImageRequest imageRequest, int i, int i2, int i3, int i4) {
            String str;
            if (!this.mzV.dBx().Qd(this.mzV.getId())) {
                return null;
            }
            String str2 = eVar.getWidth() + Config.EVENT_HEAT_X + eVar.getHeight();
            if (imageRequest.dCq() != null) {
                str = imageRequest.dCq().width + Config.EVENT_HEAT_X + imageRequest.dCq().height;
            } else {
                str = "Unspecified";
            }
            String str3 = i > 0 ? i + "/8" : "";
            HashMap hashMap = new HashMap();
            hashMap.put("Original size", str2);
            hashMap.put("Requested size", str);
            hashMap.put("Fraction", str3);
            hashMap.put("queueTime", String.valueOf(this.mAb.dBT()));
            hashMap.put("downsampleEnumerator", Integer.toString(i2));
            hashMap.put("softwareEnumerator", Integer.toString(i3));
            hashMap.put("rotationAngle", Integer.toString(i4));
            return ImmutableMap.copyOf((Map) hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState a(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar, boolean z) {
        if (eVar == null || eVar.dAz() == com.facebook.c.c.muf) {
            return TriState.UNSET;
        }
        if (eVar.dAz() != com.facebook.c.b.mtV) {
            return TriState.NO;
        }
        return TriState.valueOf(c(imageRequest.dCr(), eVar) || Ik(b(imageRequest, eVar, z)));
    }

    static float a(com.facebook.imagepipeline.common.d dVar, int i, int i2) {
        if (dVar == null) {
            return 1.0f;
        }
        float max = Math.max(dVar.width / i, dVar.height / i2);
        if (i * max > dVar.mwq) {
            max = dVar.mwq / i;
        }
        if (i2 * max > dVar.mwq) {
            return dVar.mwq / i2;
        }
        return max;
    }

    static int z(float f, float f2) {
        return (int) ((8.0f * f) + f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar, boolean z) {
        com.facebook.imagepipeline.common.d dCq;
        if (z && (dCq = imageRequest.dCq()) != null) {
            int a2 = a(imageRequest.dCr(), eVar);
            int b = mBn.contains(Integer.valueOf(eVar.dAw())) ? b(imageRequest.dCr(), eVar) : 0;
            boolean z2 = a2 == 90 || a2 == 270 || b == 5 || b == 7;
            int z3 = z(a(dCq, z2 ? eVar.getHeight() : eVar.getWidth(), z2 ? eVar.getWidth() : eVar.getHeight()), dCq.mwr);
            if (z3 > 8) {
                return 8;
            }
            if (z3 < 1) {
                return 1;
            }
            return z3;
        }
        return 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int a(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        if (!eVar.dyB()) {
            return 0;
        }
        int j = j(eVar2);
        return !eVar.dyA() ? (j + eVar.dyC()) % 360 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        int indexOf = mBn.indexOf(Integer.valueOf(eVar2.dAw()));
        if (indexOf < 0) {
            throw new IllegalArgumentException("Only accepts inverted exif orientations");
        }
        int i = 0;
        if (!eVar.dyA()) {
            i = eVar.dyC();
        }
        return mBn.get(((i / 90) + indexOf) % mBn.size()).intValue();
    }

    private static int j(com.facebook.imagepipeline.g.e eVar) {
        switch (eVar.dAv()) {
            case 90:
            case 180:
            case 270:
                return eVar.dAv();
            default:
                return 0;
        }
    }

    private static boolean Ik(int i) {
        return i < 8;
    }

    private static boolean c(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        return !eVar.dyD() && (a(eVar, eVar2) != 0 || d(eVar, eVar2));
    }

    private static boolean d(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        if (!eVar.dyB() || eVar.dyD()) {
            eVar2.HI(0);
            return false;
        }
        return mBn.contains(Integer.valueOf(eVar2.dAw()));
    }

    static int Il(int i) {
        return Math.max(1, 8 / i);
    }
}
