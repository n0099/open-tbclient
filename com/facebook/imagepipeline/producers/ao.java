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
    private static final ImmutableList<Integer> mXx = ImmutableList.of((Object[]) new Integer[]{2, 7, 4, 5});
    private final Executor mExecutor;
    private final com.facebook.common.memory.g mRd;
    private final boolean mTW;
    private final aj<com.facebook.imagepipeline.g.e> mVS;
    private final boolean mXy;

    public ao(Executor executor, com.facebook.common.memory.g gVar, boolean z, aj<com.facebook.imagepipeline.g.e> ajVar, boolean z2) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.mRd = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.mXy = z;
        this.mVS = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.mTW = z2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.mVS.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes12.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private boolean eiF;
        private final ak mWf;
        private final JobScheduler mWl;

        public a(final k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.eiF = false;
            this.mWf = akVar;
            this.mWl = new JobScheduler(ao.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.ao.a.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.g.e eVar, int i) {
                    a.this.g(eVar, i);
                }
            }, 100);
            this.mWf.a(new e() { // from class: com.facebook.imagepipeline.producers.ao.a.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dGk() {
                    if (a.this.mWf.dGh()) {
                        a.this.mWl.dGv();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dCu() {
                    a.this.mWl.dGu();
                    a.this.eiF = true;
                    kVar.dzh();
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
                    TriState a = ao.a(this.mWf.dGc(), eVar, ao.this.mXy);
                    if (Jm || a != TriState.UNSET) {
                        if (a != TriState.YES) {
                            if (!this.mWf.dGc().dGX().dDj() && eVar.dFb() != 0 && eVar.dFb() != -1) {
                                eVar = k(eVar);
                                eVar.IO(0);
                            }
                            dGo().h(eVar, i);
                        } else if (this.mWl.e(eVar, i)) {
                            if (Jm || this.mWf.dGh()) {
                                this.mWl.dGv();
                            }
                        }
                    }
                } else if (Jm) {
                    dGo().h(null, 1);
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
            this.mWf.dGd().fU(this.mWf.getId(), "ResizeAndRotateProducer");
            ImageRequest dGc = this.mWf.dGc();
            com.facebook.common.memory.i dzt = ao.this.mRd.dzt();
            try {
                int b = ao.b(dGc, eVar, ao.this.mXy);
                int a2 = q.a(dGc, eVar);
                int Js = ao.Js(a2);
                int i2 = ao.this.mTW ? Js : b;
                inputStream = eVar.getInputStream();
                try {
                    if (ao.mXx.contains(Integer.valueOf(eVar.dFc()))) {
                        int b2 = ao.b(dGc.dGX(), eVar);
                        a = a(eVar, dGc, i2, Js, b, 0);
                        JpegTranscoder.b(inputStream, dzt, b2, i2, 85);
                    } else {
                        int a3 = ao.a(dGc.dGX(), eVar);
                        a = a(eVar, dGc, i2, Js, b, a3);
                        JpegTranscoder.a(inputStream, dzt, a3, i2, 85);
                    }
                    com.facebook.common.references.a e = com.facebook.common.references.a.e(dzt.dzu());
                    try {
                        com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(e);
                        eVar2.c(com.facebook.c.b.mPX);
                        eVar2.dFh();
                        this.mWf.dGd().a(this.mWf.getId(), "ResizeAndRotateProducer", a);
                        if (a2 != 1) {
                            i |= 16;
                        }
                        dGo().h(eVar2, i);
                        com.facebook.imagepipeline.g.e.e(eVar2);
                        com.facebook.common.internal.b.p(inputStream);
                        dzt.close();
                    } finally {
                        com.facebook.common.references.a.c(e);
                    }
                } catch (Exception e2) {
                    e = e2;
                    inputStream2 = inputStream;
                    try {
                        this.mWf.dGd().a(this.mWf.getId(), "ResizeAndRotateProducer", e, (Map<String, String>) null);
                        if (Jm(i)) {
                            dGo().G(e);
                        }
                        com.facebook.common.internal.b.p(inputStream2);
                        dzt.close();
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        com.facebook.common.internal.b.p(inputStream);
                        dzt.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.facebook.common.internal.b.p(inputStream);
                    dzt.close();
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
            if (!this.mWf.dGd().QQ(this.mWf.getId())) {
                return null;
            }
            String str2 = eVar.getWidth() + Config.EVENT_HEAT_X + eVar.getHeight();
            if (imageRequest.dGW() != null) {
                str = imageRequest.dGW().width + Config.EVENT_HEAT_X + imageRequest.dGW().height;
            } else {
                str = "Unspecified";
            }
            String str3 = i > 0 ? i + "/8" : "";
            HashMap hashMap = new HashMap();
            hashMap.put("Original size", str2);
            hashMap.put("Requested size", str);
            hashMap.put("Fraction", str3);
            hashMap.put("queueTime", String.valueOf(this.mWl.dGz()));
            hashMap.put("downsampleEnumerator", Integer.toString(i2));
            hashMap.put("softwareEnumerator", Integer.toString(i3));
            hashMap.put("rotationAngle", Integer.toString(i4));
            return ImmutableMap.copyOf((Map) hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState a(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar, boolean z) {
        if (eVar == null || eVar.dFf() == com.facebook.c.c.mQh) {
            return TriState.UNSET;
        }
        if (eVar.dFf() != com.facebook.c.b.mPX) {
            return TriState.NO;
        }
        return TriState.valueOf(c(imageRequest.dGX(), eVar) || Jr(b(imageRequest, eVar, z)));
    }

    static float a(com.facebook.imagepipeline.common.d dVar, int i, int i2) {
        if (dVar == null) {
            return 1.0f;
        }
        float max = Math.max(dVar.width / i, dVar.height / i2);
        if (i * max > dVar.mSt) {
            max = dVar.mSt / i;
        }
        if (i2 * max > dVar.mSt) {
            return dVar.mSt / i2;
        }
        return max;
    }

    static int z(float f, float f2) {
        return (int) ((8.0f * f) + f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar, boolean z) {
        com.facebook.imagepipeline.common.d dGW;
        if (z && (dGW = imageRequest.dGW()) != null) {
            int a2 = a(imageRequest.dGX(), eVar);
            int b = mXx.contains(Integer.valueOf(eVar.dFc())) ? b(imageRequest.dGX(), eVar) : 0;
            boolean z2 = a2 == 90 || a2 == 270 || b == 5 || b == 7;
            int z3 = z(a(dGW, z2 ? eVar.getHeight() : eVar.getWidth(), z2 ? eVar.getWidth() : eVar.getHeight()), dGW.mSu);
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
        if (!eVar.dDh()) {
            return 0;
        }
        int j = j(eVar2);
        return !eVar.dDg() ? (j + eVar.dDi()) % 360 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        int indexOf = mXx.indexOf(Integer.valueOf(eVar2.dFc()));
        if (indexOf < 0) {
            throw new IllegalArgumentException("Only accepts inverted exif orientations");
        }
        int i = 0;
        if (!eVar.dDg()) {
            i = eVar.dDi();
        }
        return mXx.get(((i / 90) + indexOf) % mXx.size()).intValue();
    }

    private static int j(com.facebook.imagepipeline.g.e eVar) {
        switch (eVar.dFb()) {
            case 90:
            case 180:
            case 270:
                return eVar.dFb();
            default:
                return 0;
        }
    }

    private static boolean Jr(int i) {
        return i < 8;
    }

    private static boolean c(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        return !eVar.dDj() && (a(eVar, eVar2) != 0 || d(eVar, eVar2));
    }

    private static boolean d(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        if (!eVar.dDh() || eVar.dDj()) {
            eVar2.IP(0);
            return false;
        }
        return mXx.contains(Integer.valueOf(eVar2.dFc()));
    }

    static int Js(int i) {
        return Math.max(1, 8 / i);
    }
}
