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
    private static final ImmutableList<Integer> mXu = ImmutableList.of((Object[]) new Integer[]{2, 7, 4, 5});
    private final Executor mExecutor;
    private final com.facebook.common.memory.g mQZ;
    private final boolean mTT;
    private final aj<com.facebook.imagepipeline.g.e> mVP;
    private final boolean mXv;

    public ao(Executor executor, com.facebook.common.memory.g gVar, boolean z, aj<com.facebook.imagepipeline.g.e> ajVar, boolean z2) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.mQZ = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.mXv = z;
        this.mVP = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.mTT = z2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.mVP.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes12.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private boolean eiF;
        private final ak mWc;
        private final JobScheduler mWi;

        public a(final k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.eiF = false;
            this.mWc = akVar;
            this.mWi = new JobScheduler(ao.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.ao.a.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.g.e eVar, int i) {
                    a.this.g(eVar, i);
                }
            }, 100);
            this.mWc.a(new e() { // from class: com.facebook.imagepipeline.producers.ao.a.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dGg() {
                    if (a.this.mWc.dGd()) {
                        a.this.mWi.dGr();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dCq() {
                    a.this.mWi.dGq();
                    a.this.eiF = true;
                    kVar.dzd();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(@Nullable com.facebook.imagepipeline.g.e eVar, int i) {
            if (!this.eiF) {
                boolean Jm = Jm(i);
                if (eVar != null) {
                    TriState a = ao.a(this.mWc.dFY(), eVar, ao.this.mXv);
                    if (Jm || a != TriState.UNSET) {
                        if (a != TriState.YES) {
                            if (!this.mWc.dFY().dGT().dDf() && eVar.dEX() != 0 && eVar.dEX() != -1) {
                                eVar = k(eVar);
                                eVar.IO(0);
                            }
                            dGk().h(eVar, i);
                        } else if (this.mWi.e(eVar, i)) {
                            if (Jm || this.mWc.dGd()) {
                                this.mWi.dGr();
                            }
                        }
                    }
                } else if (Jm) {
                    dGk().h(null, 1);
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
            this.mWc.dFZ().fU(this.mWc.getId(), "ResizeAndRotateProducer");
            ImageRequest dFY = this.mWc.dFY();
            com.facebook.common.memory.i dzp = ao.this.mQZ.dzp();
            try {
                int b = ao.b(dFY, eVar, ao.this.mXv);
                int a2 = q.a(dFY, eVar);
                int Js = ao.Js(a2);
                int i2 = ao.this.mTT ? Js : b;
                inputStream = eVar.getInputStream();
                try {
                    if (ao.mXu.contains(Integer.valueOf(eVar.dEY()))) {
                        int b2 = ao.b(dFY.dGT(), eVar);
                        a = a(eVar, dFY, i2, Js, b, 0);
                        JpegTranscoder.b(inputStream, dzp, b2, i2, 85);
                    } else {
                        int a3 = ao.a(dFY.dGT(), eVar);
                        a = a(eVar, dFY, i2, Js, b, a3);
                        JpegTranscoder.a(inputStream, dzp, a3, i2, 85);
                    }
                    com.facebook.common.references.a e = com.facebook.common.references.a.e(dzp.dzq());
                    try {
                        com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(e);
                        eVar2.c(com.facebook.c.b.mPU);
                        eVar2.dFd();
                        this.mWc.dFZ().a(this.mWc.getId(), "ResizeAndRotateProducer", a);
                        if (a2 != 1) {
                            i |= 16;
                        }
                        dGk().h(eVar2, i);
                        com.facebook.imagepipeline.g.e.e(eVar2);
                        com.facebook.common.internal.b.p(inputStream);
                        dzp.close();
                    } finally {
                        com.facebook.common.references.a.c(e);
                    }
                } catch (Exception e2) {
                    e = e2;
                    inputStream2 = inputStream;
                    try {
                        this.mWc.dFZ().a(this.mWc.getId(), "ResizeAndRotateProducer", e, (Map<String, String>) null);
                        if (Jm(i)) {
                            dGk().G(e);
                        }
                        com.facebook.common.internal.b.p(inputStream2);
                        dzp.close();
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        com.facebook.common.internal.b.p(inputStream);
                        dzp.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.facebook.common.internal.b.p(inputStream);
                    dzp.close();
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
            if (!this.mWc.dFZ().QP(this.mWc.getId())) {
                return null;
            }
            String str2 = eVar.getWidth() + Config.EVENT_HEAT_X + eVar.getHeight();
            if (imageRequest.dGS() != null) {
                str = imageRequest.dGS().width + Config.EVENT_HEAT_X + imageRequest.dGS().height;
            } else {
                str = "Unspecified";
            }
            String str3 = i > 0 ? i + "/8" : "";
            HashMap hashMap = new HashMap();
            hashMap.put("Original size", str2);
            hashMap.put("Requested size", str);
            hashMap.put("Fraction", str3);
            hashMap.put("queueTime", String.valueOf(this.mWi.dGv()));
            hashMap.put("downsampleEnumerator", Integer.toString(i2));
            hashMap.put("softwareEnumerator", Integer.toString(i3));
            hashMap.put("rotationAngle", Integer.toString(i4));
            return ImmutableMap.copyOf((Map) hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState a(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar, boolean z) {
        if (eVar == null || eVar.dFb() == com.facebook.c.c.mQe) {
            return TriState.UNSET;
        }
        if (eVar.dFb() != com.facebook.c.b.mPU) {
            return TriState.NO;
        }
        return TriState.valueOf(c(imageRequest.dGT(), eVar) || Jr(b(imageRequest, eVar, z)));
    }

    static float a(com.facebook.imagepipeline.common.d dVar, int i, int i2) {
        if (dVar == null) {
            return 1.0f;
        }
        float max = Math.max(dVar.width / i, dVar.height / i2);
        if (i * max > dVar.mSq) {
            max = dVar.mSq / i;
        }
        if (i2 * max > dVar.mSq) {
            return dVar.mSq / i2;
        }
        return max;
    }

    static int z(float f, float f2) {
        return (int) ((8.0f * f) + f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar, boolean z) {
        com.facebook.imagepipeline.common.d dGS;
        if (z && (dGS = imageRequest.dGS()) != null) {
            int a2 = a(imageRequest.dGT(), eVar);
            int b = mXu.contains(Integer.valueOf(eVar.dEY())) ? b(imageRequest.dGT(), eVar) : 0;
            boolean z2 = a2 == 90 || a2 == 270 || b == 5 || b == 7;
            int z3 = z(a(dGS, z2 ? eVar.getHeight() : eVar.getWidth(), z2 ? eVar.getWidth() : eVar.getHeight()), dGS.mSr);
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
        if (!eVar.dDd()) {
            return 0;
        }
        int j = j(eVar2);
        return !eVar.dDc() ? (j + eVar.dDe()) % 360 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        int indexOf = mXu.indexOf(Integer.valueOf(eVar2.dEY()));
        if (indexOf < 0) {
            throw new IllegalArgumentException("Only accepts inverted exif orientations");
        }
        int i = 0;
        if (!eVar.dDc()) {
            i = eVar.dDe();
        }
        return mXu.get(((i / 90) + indexOf) % mXu.size()).intValue();
    }

    private static int j(com.facebook.imagepipeline.g.e eVar) {
        switch (eVar.dEX()) {
            case 90:
            case 180:
            case 270:
                return eVar.dEX();
            default:
                return 0;
        }
    }

    private static boolean Jr(int i) {
        return i < 8;
    }

    private static boolean c(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        return !eVar.dDf() && (a(eVar, eVar2) != 0 || d(eVar, eVar2));
    }

    private static boolean d(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        if (!eVar.dDd() || eVar.dDf()) {
            eVar2.IP(0);
            return false;
        }
        return mXu.contains(Integer.valueOf(eVar2.dEY()));
    }

    static int Js(int i) {
        return Math.max(1, 8 / i);
    }
}
