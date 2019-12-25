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
/* loaded from: classes9.dex */
public class ao implements aj<com.facebook.imagepipeline.g.e> {
    private static final ImmutableList<Integer> lSd = ImmutableList.of((Object[]) new Integer[]{2, 7, 4, 5});
    private final com.facebook.common.memory.g lLT;
    private final boolean lOG;
    private final aj<com.facebook.imagepipeline.g.e> lQz;
    private final boolean lSe;
    private final Executor mExecutor;

    public ao(Executor executor, com.facebook.common.memory.g gVar, boolean z, aj<com.facebook.imagepipeline.g.e> ajVar, boolean z2) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.lLT = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.lSe = z;
        this.lQz = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.lOG = z2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.lQz.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes9.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private boolean Tn;
        private final ak lQM;
        private final JobScheduler lQS;

        public a(final k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.Tn = false;
            this.lQM = akVar;
            this.lQS = new JobScheduler(ao.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.ao.a.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.g.e eVar, int i) {
                    a.this.g(eVar, i);
                }
            }, 100);
            this.lQM.a(new e() { // from class: com.facebook.imagepipeline.producers.ao.a.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dpf() {
                    if (a.this.lQM.dpc()) {
                        a.this.lQS.dpq();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dlt() {
                    a.this.lQS.dpp();
                    a.this.Tn = true;
                    kVar.dim();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(@Nullable com.facebook.imagepipeline.g.e eVar, int i) {
            if (!this.Tn) {
                boolean Iv = Iv(i);
                if (eVar != null) {
                    TriState a = ao.a(this.lQM.doX(), eVar, ao.this.lSe);
                    if (Iv || a != TriState.UNSET) {
                        if (a != TriState.YES) {
                            if (!this.lQM.doX().dpQ().dmf() && eVar.dnZ() != 0 && eVar.dnZ() != -1) {
                                eVar = k(eVar);
                                eVar.HX(0);
                            }
                            dpj().g(eVar, i);
                        } else if (this.lQS.e(eVar, i)) {
                            if (Iv || this.lQM.dpc()) {
                                this.lQS.dpq();
                            }
                        }
                    }
                } else if (Iv) {
                    dpj().g(null, 1);
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
            this.lQM.doY().fc(this.lQM.getId(), "ResizeAndRotateProducer");
            ImageRequest doX = this.lQM.doX();
            com.facebook.common.memory.i diy = ao.this.lLT.diy();
            try {
                int b = ao.b(doX, eVar, ao.this.lSe);
                int a2 = q.a(doX, eVar);
                int IA = ao.IA(a2);
                int i2 = ao.this.lOG ? IA : b;
                inputStream = eVar.getInputStream();
                try {
                    if (ao.lSd.contains(Integer.valueOf(eVar.doa()))) {
                        int b2 = ao.b(doX.dpQ(), eVar);
                        a = a(eVar, doX, i2, IA, b, 0);
                        JpegTranscoder.b(inputStream, diy, b2, i2, 85);
                    } else {
                        int a3 = ao.a(doX.dpQ(), eVar);
                        a = a(eVar, doX, i2, IA, b, a3);
                        JpegTranscoder.a(inputStream, diy, a3, i2, 85);
                    }
                    com.facebook.common.references.a b3 = com.facebook.common.references.a.b(diy.diz());
                    try {
                        com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(b3);
                        eVar2.c(com.facebook.c.b.lKR);
                        eVar2.dof();
                        this.lQM.doY().a(this.lQM.getId(), "ResizeAndRotateProducer", a);
                        if (a2 != 1) {
                            i |= 16;
                        }
                        dpj().g(eVar2, i);
                        com.facebook.imagepipeline.g.e.e(eVar2);
                        com.facebook.common.internal.b.r(inputStream);
                        diy.close();
                    } finally {
                        com.facebook.common.references.a.c(b3);
                    }
                } catch (Exception e) {
                    e = e;
                    inputStream2 = inputStream;
                    try {
                        this.lQM.doY().a(this.lQM.getId(), "ResizeAndRotateProducer", e, (Map<String, String>) null);
                        if (Iv(i)) {
                            dpj().D(e);
                        }
                        com.facebook.common.internal.b.r(inputStream2);
                        diy.close();
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        com.facebook.common.internal.b.r(inputStream);
                        diy.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.facebook.common.internal.b.r(inputStream);
                    diy.close();
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
            if (!this.lQM.doY().OF(this.lQM.getId())) {
                return null;
            }
            String str2 = eVar.getWidth() + Config.EVENT_HEAT_X + eVar.getHeight();
            if (imageRequest.dpP() != null) {
                str = imageRequest.dpP().width + Config.EVENT_HEAT_X + imageRequest.dpP().height;
            } else {
                str = "Unspecified";
            }
            String str3 = i > 0 ? i + "/8" : "";
            HashMap hashMap = new HashMap();
            hashMap.put("Original size", str2);
            hashMap.put("Requested size", str);
            hashMap.put("Fraction", str3);
            hashMap.put("queueTime", String.valueOf(this.lQS.dpu()));
            hashMap.put("downsampleEnumerator", Integer.toString(i2));
            hashMap.put("softwareEnumerator", Integer.toString(i3));
            hashMap.put("rotationAngle", Integer.toString(i4));
            return ImmutableMap.copyOf((Map) hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState a(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar, boolean z) {
        if (eVar == null || eVar.dod() == com.facebook.c.c.lLb) {
            return TriState.UNSET;
        }
        if (eVar.dod() != com.facebook.c.b.lKR) {
            return TriState.NO;
        }
        return TriState.valueOf(c(imageRequest.dpQ(), eVar) || Iz(b(imageRequest, eVar, z)));
    }

    static float a(com.facebook.imagepipeline.common.d dVar, int i, int i2) {
        if (dVar == null) {
            return 1.0f;
        }
        float max = Math.max(dVar.width / i, dVar.height / i2);
        if (i * max > dVar.lNh) {
            max = dVar.lNh / i;
        }
        if (i2 * max > dVar.lNh) {
            return dVar.lNh / i2;
        }
        return max;
    }

    static int D(float f, float f2) {
        return (int) ((8.0f * f) + f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar, boolean z) {
        com.facebook.imagepipeline.common.d dpP;
        if (z && (dpP = imageRequest.dpP()) != null) {
            int a2 = a(imageRequest.dpQ(), eVar);
            int b = lSd.contains(Integer.valueOf(eVar.doa())) ? b(imageRequest.dpQ(), eVar) : 0;
            boolean z2 = a2 == 90 || a2 == 270 || b == 5 || b == 7;
            int D = D(a(dpP, z2 ? eVar.getHeight() : eVar.getWidth(), z2 ? eVar.getWidth() : eVar.getHeight()), dpP.lNi);
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
        if (!eVar.dmd()) {
            return 0;
        }
        int j = j(eVar2);
        return !eVar.dmc() ? (j + eVar.dme()) % 360 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        int indexOf = lSd.indexOf(Integer.valueOf(eVar2.doa()));
        if (indexOf < 0) {
            throw new IllegalArgumentException("Only accepts inverted exif orientations");
        }
        int i = 0;
        if (!eVar.dmc()) {
            i = eVar.dme();
        }
        return lSd.get(((i / 90) + indexOf) % lSd.size()).intValue();
    }

    private static int j(com.facebook.imagepipeline.g.e eVar) {
        switch (eVar.dnZ()) {
            case 90:
            case 180:
            case 270:
                return eVar.dnZ();
            default:
                return 0;
        }
    }

    private static boolean Iz(int i) {
        return i < 8;
    }

    private static boolean c(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        return !eVar.dmf() && (a(eVar, eVar2) != 0 || d(eVar, eVar2));
    }

    private static boolean d(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        if (!eVar.dmd() || eVar.dmf()) {
            eVar2.HY(0);
            return false;
        }
        return lSd.contains(Integer.valueOf(eVar2.doa()));
    }

    static int IA(int i) {
        return Math.max(1, 8 / i);
    }
}
