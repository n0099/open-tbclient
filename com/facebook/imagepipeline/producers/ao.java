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
/* loaded from: classes10.dex */
public class ao implements aj<com.facebook.imagepipeline.g.e> {
    private static final ImmutableList<Integer> lVR = ImmutableList.of((Object[]) new Integer[]{2, 7, 4, 5});
    private final com.facebook.common.memory.g lPE;
    private final boolean lSs;
    private final aj<com.facebook.imagepipeline.g.e> lUn;
    private final boolean lVS;
    private final Executor mExecutor;

    public ao(Executor executor, com.facebook.common.memory.g gVar, boolean z, aj<com.facebook.imagepipeline.g.e> ajVar, boolean z2) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.lPE = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.lVS = z;
        this.lUn = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.lSs = z2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.lUn.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes10.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private boolean Tq;
        private final ak lUA;
        private final JobScheduler lUG;

        public a(final k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.Tq = false;
            this.lUA = akVar;
            this.lUG = new JobScheduler(ao.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.ao.a.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.g.e eVar, int i) {
                    a.this.g(eVar, i);
                }
            }, 100);
            this.lUA.a(new e() { // from class: com.facebook.imagepipeline.producers.ao.a.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dqp() {
                    if (a.this.lUA.dqm()) {
                        a.this.lUG.dqA();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dmy() {
                    a.this.lUG.dqz();
                    a.this.Tq = true;
                    kVar.djn();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(@Nullable com.facebook.imagepipeline.g.e eVar, int i) {
            if (!this.Tq) {
                boolean IE = IE(i);
                if (eVar != null) {
                    TriState a = ao.a(this.lUA.dqh(), eVar, ao.this.lVS);
                    if (IE || a != TriState.UNSET) {
                        if (a != TriState.YES) {
                            if (!this.lUA.dqh().drd().dnl() && eVar.dpf() != 0 && eVar.dpf() != -1) {
                                eVar = k(eVar);
                                eVar.Ig(0);
                            }
                            dqt().g(eVar, i);
                        } else if (this.lUG.e(eVar, i)) {
                            if (IE || this.lUA.dqm()) {
                                this.lUG.dqA();
                            }
                        }
                    }
                } else if (IE) {
                    dqt().g(null, 1);
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
            this.lUA.dqi().fe(this.lUA.getId(), "ResizeAndRotateProducer");
            ImageRequest dqh = this.lUA.dqh();
            com.facebook.common.memory.i djz = ao.this.lPE.djz();
            try {
                int b = ao.b(dqh, eVar, ao.this.lVS);
                int a2 = q.a(dqh, eVar);
                int IJ = ao.IJ(a2);
                int i2 = ao.this.lSs ? IJ : b;
                inputStream = eVar.getInputStream();
                try {
                    if (ao.lVR.contains(Integer.valueOf(eVar.dpg()))) {
                        int b2 = ao.b(dqh.drd(), eVar);
                        a = a(eVar, dqh, i2, IJ, b, 0);
                        JpegTranscoder.b(inputStream, djz, b2, i2, 85);
                    } else {
                        int a3 = ao.a(dqh.drd(), eVar);
                        a = a(eVar, dqh, i2, IJ, b, a3);
                        JpegTranscoder.a(inputStream, djz, a3, i2, 85);
                    }
                    com.facebook.common.references.a b3 = com.facebook.common.references.a.b(djz.djA());
                    try {
                        com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(b3);
                        eVar2.c(com.facebook.c.b.lOC);
                        eVar2.dpl();
                        this.lUA.dqi().a(this.lUA.getId(), "ResizeAndRotateProducer", a);
                        if (a2 != 1) {
                            i |= 16;
                        }
                        dqt().g(eVar2, i);
                        com.facebook.imagepipeline.g.e.e(eVar2);
                        com.facebook.common.internal.b.r(inputStream);
                        djz.close();
                    } finally {
                        com.facebook.common.references.a.c(b3);
                    }
                } catch (Exception e) {
                    e = e;
                    inputStream2 = inputStream;
                    try {
                        this.lUA.dqi().a(this.lUA.getId(), "ResizeAndRotateProducer", e, (Map<String, String>) null);
                        if (IE(i)) {
                            dqt().D(e);
                        }
                        com.facebook.common.internal.b.r(inputStream2);
                        djz.close();
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        com.facebook.common.internal.b.r(inputStream);
                        djz.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.facebook.common.internal.b.r(inputStream);
                    djz.close();
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
            if (!this.lUA.dqi().OQ(this.lUA.getId())) {
                return null;
            }
            String str2 = eVar.getWidth() + Config.EVENT_HEAT_X + eVar.getHeight();
            if (imageRequest.drc() != null) {
                str = imageRequest.drc().width + Config.EVENT_HEAT_X + imageRequest.drc().height;
            } else {
                str = "Unspecified";
            }
            String str3 = i > 0 ? i + "/8" : "";
            HashMap hashMap = new HashMap();
            hashMap.put("Original size", str2);
            hashMap.put("Requested size", str);
            hashMap.put("Fraction", str3);
            hashMap.put("queueTime", String.valueOf(this.lUG.dqE()));
            hashMap.put("downsampleEnumerator", Integer.toString(i2));
            hashMap.put("softwareEnumerator", Integer.toString(i3));
            hashMap.put("rotationAngle", Integer.toString(i4));
            return ImmutableMap.copyOf((Map) hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState a(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar, boolean z) {
        if (eVar == null || eVar.dpj() == com.facebook.c.c.lOM) {
            return TriState.UNSET;
        }
        if (eVar.dpj() != com.facebook.c.b.lOC) {
            return TriState.NO;
        }
        return TriState.valueOf(c(imageRequest.drd(), eVar) || II(b(imageRequest, eVar, z)));
    }

    static float a(com.facebook.imagepipeline.common.d dVar, int i, int i2) {
        if (dVar == null) {
            return 1.0f;
        }
        float max = Math.max(dVar.width / i, dVar.height / i2);
        if (i * max > dVar.lQT) {
            max = dVar.lQT / i;
        }
        if (i2 * max > dVar.lQT) {
            return dVar.lQT / i2;
        }
        return max;
    }

    static int D(float f, float f2) {
        return (int) ((8.0f * f) + f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar, boolean z) {
        com.facebook.imagepipeline.common.d drc;
        if (z && (drc = imageRequest.drc()) != null) {
            int a2 = a(imageRequest.drd(), eVar);
            int b = lVR.contains(Integer.valueOf(eVar.dpg())) ? b(imageRequest.drd(), eVar) : 0;
            boolean z2 = a2 == 90 || a2 == 270 || b == 5 || b == 7;
            int D = D(a(drc, z2 ? eVar.getHeight() : eVar.getWidth(), z2 ? eVar.getWidth() : eVar.getHeight()), drc.lQU);
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
        if (!eVar.dnj()) {
            return 0;
        }
        int j = j(eVar2);
        return !eVar.dni() ? (j + eVar.dnk()) % 360 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        int indexOf = lVR.indexOf(Integer.valueOf(eVar2.dpg()));
        if (indexOf < 0) {
            throw new IllegalArgumentException("Only accepts inverted exif orientations");
        }
        int i = 0;
        if (!eVar.dni()) {
            i = eVar.dnk();
        }
        return lVR.get(((i / 90) + indexOf) % lVR.size()).intValue();
    }

    private static int j(com.facebook.imagepipeline.g.e eVar) {
        switch (eVar.dpf()) {
            case 90:
            case 180:
            case 270:
                return eVar.dpf();
            default:
                return 0;
        }
    }

    private static boolean II(int i) {
        return i < 8;
    }

    private static boolean c(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        return !eVar.dnl() && (a(eVar, eVar2) != 0 || d(eVar, eVar2));
    }

    private static boolean d(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        if (!eVar.dnj() || eVar.dnl()) {
            eVar2.Ih(0);
            return false;
        }
        return lVR.contains(Integer.valueOf(eVar2.dpg()));
    }

    static int IJ(int i) {
        return Math.max(1, 8 / i);
    }
}
