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
    private static final ImmutableList<Integer> lYw = ImmutableList.of((Object[]) new Integer[]{2, 7, 4, 5});
    private final com.facebook.common.memory.g lSj;
    private final boolean lUX;
    private final aj<com.facebook.imagepipeline.g.e> lWS;
    private final boolean lYx;
    private final Executor mExecutor;

    public ao(Executor executor, com.facebook.common.memory.g gVar, boolean z, aj<com.facebook.imagepipeline.g.e> ajVar, boolean z2) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.lSj = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.lYx = z;
        this.lWS = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.lUX = z2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.lWS.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes12.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private boolean Vh;
        private final ak lXf;
        private final JobScheduler lXl;

        public a(final k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.Vh = false;
            this.lXf = akVar;
            this.lXl = new JobScheduler(ao.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.ao.a.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.g.e eVar, int i) {
                    a.this.g(eVar, i);
                }
            }, 100);
            this.lXf.a(new e() { // from class: com.facebook.imagepipeline.producers.ao.a.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dsd() {
                    if (a.this.lXf.dsa()) {
                        a.this.lXl.dso();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void don() {
                    a.this.lXl.dsn();
                    a.this.Vh = true;
                    kVar.dlc();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(@Nullable com.facebook.imagepipeline.g.e eVar, int i) {
            if (!this.Vh) {
                boolean IP = IP(i);
                if (eVar != null) {
                    TriState a = ao.a(this.lXf.drV(), eVar, ao.this.lYx);
                    if (IP || a != TriState.UNSET) {
                        if (a != TriState.YES) {
                            if (!this.lXf.drV().dsR().dpa() && eVar.dqT() != 0 && eVar.dqT() != -1) {
                                eVar = k(eVar);
                                eVar.Ir(0);
                            }
                            dsh().g(eVar, i);
                        } else if (this.lXl.e(eVar, i)) {
                            if (IP || this.lXf.dsa()) {
                                this.lXl.dso();
                            }
                        }
                    }
                } else if (IP) {
                    dsh().g(null, 1);
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
            this.lXf.drW().fk(this.lXf.getId(), "ResizeAndRotateProducer");
            ImageRequest drV = this.lXf.drV();
            com.facebook.common.memory.i dlo = ao.this.lSj.dlo();
            try {
                int b = ao.b(drV, eVar, ao.this.lYx);
                int a2 = q.a(drV, eVar);
                int IU = ao.IU(a2);
                int i2 = ao.this.lUX ? IU : b;
                inputStream = eVar.getInputStream();
                try {
                    if (ao.lYw.contains(Integer.valueOf(eVar.dqU()))) {
                        int b2 = ao.b(drV.dsR(), eVar);
                        a = a(eVar, drV, i2, IU, b, 0);
                        JpegTranscoder.b(inputStream, dlo, b2, i2, 85);
                    } else {
                        int a3 = ao.a(drV.dsR(), eVar);
                        a = a(eVar, drV, i2, IU, b, a3);
                        JpegTranscoder.a(inputStream, dlo, a3, i2, 85);
                    }
                    com.facebook.common.references.a b3 = com.facebook.common.references.a.b(dlo.dlp());
                    try {
                        com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(b3);
                        eVar2.c(com.facebook.c.b.lRh);
                        eVar2.dqZ();
                        this.lXf.drW().a(this.lXf.getId(), "ResizeAndRotateProducer", a);
                        if (a2 != 1) {
                            i |= 16;
                        }
                        dsh().g(eVar2, i);
                        com.facebook.imagepipeline.g.e.e(eVar2);
                        com.facebook.common.internal.b.r(inputStream);
                        dlo.close();
                    } finally {
                        com.facebook.common.references.a.c(b3);
                    }
                } catch (Exception e) {
                    e = e;
                    inputStream2 = inputStream;
                    try {
                        this.lXf.drW().a(this.lXf.getId(), "ResizeAndRotateProducer", e, (Map<String, String>) null);
                        if (IP(i)) {
                            dsh().C(e);
                        }
                        com.facebook.common.internal.b.r(inputStream2);
                        dlo.close();
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        com.facebook.common.internal.b.r(inputStream);
                        dlo.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.facebook.common.internal.b.r(inputStream);
                    dlo.close();
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
            if (!this.lXf.drW().Pe(this.lXf.getId())) {
                return null;
            }
            String str2 = eVar.getWidth() + Config.EVENT_HEAT_X + eVar.getHeight();
            if (imageRequest.dsQ() != null) {
                str = imageRequest.dsQ().width + Config.EVENT_HEAT_X + imageRequest.dsQ().height;
            } else {
                str = "Unspecified";
            }
            String str3 = i > 0 ? i + "/8" : "";
            HashMap hashMap = new HashMap();
            hashMap.put("Original size", str2);
            hashMap.put("Requested size", str);
            hashMap.put("Fraction", str3);
            hashMap.put("queueTime", String.valueOf(this.lXl.dss()));
            hashMap.put("downsampleEnumerator", Integer.toString(i2));
            hashMap.put("softwareEnumerator", Integer.toString(i3));
            hashMap.put("rotationAngle", Integer.toString(i4));
            return ImmutableMap.copyOf((Map) hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState a(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar, boolean z) {
        if (eVar == null || eVar.dqX() == com.facebook.c.c.lRr) {
            return TriState.UNSET;
        }
        if (eVar.dqX() != com.facebook.c.b.lRh) {
            return TriState.NO;
        }
        return TriState.valueOf(c(imageRequest.dsR(), eVar) || IT(b(imageRequest, eVar, z)));
    }

    static float a(com.facebook.imagepipeline.common.d dVar, int i, int i2) {
        if (dVar == null) {
            return 1.0f;
        }
        float max = Math.max(dVar.width / i, dVar.height / i2);
        if (i * max > dVar.lTy) {
            max = dVar.lTy / i;
        }
        if (i2 * max > dVar.lTy) {
            return dVar.lTy / i2;
        }
        return max;
    }

    static int D(float f, float f2) {
        return (int) ((8.0f * f) + f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar, boolean z) {
        com.facebook.imagepipeline.common.d dsQ;
        if (z && (dsQ = imageRequest.dsQ()) != null) {
            int a2 = a(imageRequest.dsR(), eVar);
            int b = lYw.contains(Integer.valueOf(eVar.dqU())) ? b(imageRequest.dsR(), eVar) : 0;
            boolean z2 = a2 == 90 || a2 == 270 || b == 5 || b == 7;
            int D = D(a(dsQ, z2 ? eVar.getHeight() : eVar.getWidth(), z2 ? eVar.getWidth() : eVar.getHeight()), dsQ.lTz);
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
        if (!eVar.doY()) {
            return 0;
        }
        int j = j(eVar2);
        return !eVar.doX() ? (j + eVar.doZ()) % 360 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        int indexOf = lYw.indexOf(Integer.valueOf(eVar2.dqU()));
        if (indexOf < 0) {
            throw new IllegalArgumentException("Only accepts inverted exif orientations");
        }
        int i = 0;
        if (!eVar.doX()) {
            i = eVar.doZ();
        }
        return lYw.get(((i / 90) + indexOf) % lYw.size()).intValue();
    }

    private static int j(com.facebook.imagepipeline.g.e eVar) {
        switch (eVar.dqT()) {
            case 90:
            case 180:
            case 270:
                return eVar.dqT();
            default:
                return 0;
        }
    }

    private static boolean IT(int i) {
        return i < 8;
    }

    private static boolean c(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        return !eVar.dpa() && (a(eVar, eVar2) != 0 || d(eVar, eVar2));
    }

    private static boolean d(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        if (!eVar.doY() || eVar.dpa()) {
            eVar2.Is(0);
            return false;
        }
        return lYw.contains(Integer.valueOf(eVar2.dqU()));
    }

    static int IU(int i) {
        return Math.max(1, 8 / i);
    }
}
