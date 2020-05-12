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
    private static final ImmutableList<Integer> mgl = ImmutableList.of((Object[]) new Integer[]{2, 7, 4, 5});
    private final com.facebook.common.memory.g lZW;
    private final Executor mExecutor;
    private final boolean mcM;
    private final aj<com.facebook.imagepipeline.g.e> meH;
    private final boolean mgm;

    public ao(Executor executor, com.facebook.common.memory.g gVar, boolean z, aj<com.facebook.imagepipeline.g.e> ajVar, boolean z2) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.lZW = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.mgm = z;
        this.meH = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.mcM = z2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.meH.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes12.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private boolean dLE;
        private final ak meU;
        private final JobScheduler mfa;

        public a(final k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.dLE = false;
            this.meU = akVar;
            this.mfa = new JobScheduler(ao.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.ao.a.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.g.e eVar, int i) {
                    a.this.g(eVar, i);
                }
            }, 100);
            this.meU.a(new e() { // from class: com.facebook.imagepipeline.producers.ao.a.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dtZ() {
                    if (a.this.meU.dtW()) {
                        a.this.mfa.duk();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dqi() {
                    a.this.mfa.duj();
                    a.this.dLE = true;
                    kVar.dmT();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(@Nullable com.facebook.imagepipeline.g.e eVar, int i) {
            if (!this.dLE) {
                boolean Hr = Hr(i);
                if (eVar != null) {
                    TriState a = ao.a(this.meU.dtR(), eVar, ao.this.mgm);
                    if (Hr || a != TriState.UNSET) {
                        if (a != TriState.YES) {
                            if (!this.meU.dtR().duM().dqX() && eVar.dsP() != 0 && eVar.dsP() != -1) {
                                eVar = k(eVar);
                                eVar.GT(0);
                            }
                            dud().h(eVar, i);
                        } else if (this.mfa.e(eVar, i)) {
                            if (Hr || this.meU.dtW()) {
                                this.mfa.duk();
                            }
                        }
                    }
                } else if (Hr) {
                    dud().h(null, 1);
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
            this.meU.dtS().fi(this.meU.getId(), "ResizeAndRotateProducer");
            ImageRequest dtR = this.meU.dtR();
            com.facebook.common.memory.i dnf = ao.this.lZW.dnf();
            try {
                int b = ao.b(dtR, eVar, ao.this.mgm);
                int a2 = q.a(dtR, eVar);
                int Hx = ao.Hx(a2);
                int i2 = ao.this.mcM ? Hx : b;
                inputStream = eVar.getInputStream();
                try {
                    if (ao.mgl.contains(Integer.valueOf(eVar.dsQ()))) {
                        int b2 = ao.b(dtR.duM(), eVar);
                        a = a(eVar, dtR, i2, Hx, b, 0);
                        JpegTranscoder.b(inputStream, dnf, b2, i2, 85);
                    } else {
                        int a3 = ao.a(dtR.duM(), eVar);
                        a = a(eVar, dtR, i2, Hx, b, a3);
                        JpegTranscoder.a(inputStream, dnf, a3, i2, 85);
                    }
                    com.facebook.common.references.a c = com.facebook.common.references.a.c(dnf.dng());
                    try {
                        com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(c);
                        eVar2.c(com.facebook.c.b.lYQ);
                        eVar2.dsV();
                        this.meU.dtS().a(this.meU.getId(), "ResizeAndRotateProducer", a);
                        if (a2 != 1) {
                            i |= 16;
                        }
                        dud().h(eVar2, i);
                        com.facebook.imagepipeline.g.e.e(eVar2);
                        com.facebook.common.internal.b.o(inputStream);
                        dnf.close();
                    } finally {
                        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) c);
                    }
                } catch (Exception e) {
                    e = e;
                    inputStream2 = inputStream;
                    try {
                        this.meU.dtS().a(this.meU.getId(), "ResizeAndRotateProducer", e, (Map<String, String>) null);
                        if (Hr(i)) {
                            dud().G(e);
                        }
                        com.facebook.common.internal.b.o(inputStream2);
                        dnf.close();
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        com.facebook.common.internal.b.o(inputStream);
                        dnf.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.facebook.common.internal.b.o(inputStream);
                    dnf.close();
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
            if (!this.meU.dtS().Oo(this.meU.getId())) {
                return null;
            }
            String str2 = eVar.getWidth() + Config.EVENT_HEAT_X + eVar.getHeight();
            if (imageRequest.duL() != null) {
                str = imageRequest.duL().width + Config.EVENT_HEAT_X + imageRequest.duL().height;
            } else {
                str = "Unspecified";
            }
            String str3 = i > 0 ? i + "/8" : "";
            HashMap hashMap = new HashMap();
            hashMap.put("Original size", str2);
            hashMap.put("Requested size", str);
            hashMap.put("Fraction", str3);
            hashMap.put("queueTime", String.valueOf(this.mfa.duo()));
            hashMap.put("downsampleEnumerator", Integer.toString(i2));
            hashMap.put("softwareEnumerator", Integer.toString(i3));
            hashMap.put("rotationAngle", Integer.toString(i4));
            return ImmutableMap.copyOf((Map) hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState a(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar, boolean z) {
        if (eVar == null || eVar.dsT() == com.facebook.c.c.lZa) {
            return TriState.UNSET;
        }
        if (eVar.dsT() != com.facebook.c.b.lYQ) {
            return TriState.NO;
        }
        return TriState.valueOf(c(imageRequest.duM(), eVar) || Hw(b(imageRequest, eVar, z)));
    }

    static float a(com.facebook.imagepipeline.common.d dVar, int i, int i2) {
        if (dVar == null) {
            return 1.0f;
        }
        float max = Math.max(dVar.width / i, dVar.height / i2);
        if (i * max > dVar.mbp) {
            max = dVar.mbp / i;
        }
        if (i2 * max > dVar.mbp) {
            return dVar.mbp / i2;
        }
        return max;
    }

    static int z(float f, float f2) {
        return (int) ((8.0f * f) + f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar, boolean z) {
        com.facebook.imagepipeline.common.d duL;
        if (z && (duL = imageRequest.duL()) != null) {
            int a2 = a(imageRequest.duM(), eVar);
            int b = mgl.contains(Integer.valueOf(eVar.dsQ())) ? b(imageRequest.duM(), eVar) : 0;
            boolean z2 = a2 == 90 || a2 == 270 || b == 5 || b == 7;
            int z3 = z(a(duL, z2 ? eVar.getHeight() : eVar.getWidth(), z2 ? eVar.getWidth() : eVar.getHeight()), duL.mbq);
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
        if (!eVar.dqV()) {
            return 0;
        }
        int j = j(eVar2);
        return !eVar.dqU() ? (j + eVar.dqW()) % 360 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        int indexOf = mgl.indexOf(Integer.valueOf(eVar2.dsQ()));
        if (indexOf < 0) {
            throw new IllegalArgumentException("Only accepts inverted exif orientations");
        }
        int i = 0;
        if (!eVar.dqU()) {
            i = eVar.dqW();
        }
        return mgl.get(((i / 90) + indexOf) % mgl.size()).intValue();
    }

    private static int j(com.facebook.imagepipeline.g.e eVar) {
        switch (eVar.dsP()) {
            case 90:
            case 180:
            case 270:
                return eVar.dsP();
            default:
                return 0;
        }
    }

    private static boolean Hw(int i) {
        return i < 8;
    }

    private static boolean c(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        return !eVar.dqX() && (a(eVar, eVar2) != 0 || d(eVar, eVar2));
    }

    private static boolean d(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        if (!eVar.dqV() || eVar.dqX()) {
            eVar2.GU(0);
            return false;
        }
        return mgl.contains(Integer.valueOf(eVar2.dsQ()));
    }

    static int Hx(int i) {
        return Math.max(1, 8 / i);
    }
}
