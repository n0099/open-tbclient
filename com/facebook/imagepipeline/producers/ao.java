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
    private static final ImmutableList<Integer> lVW = ImmutableList.of((Object[]) new Integer[]{2, 7, 4, 5});
    private final com.facebook.common.memory.g lPJ;
    private final boolean lSx;
    private final aj<com.facebook.imagepipeline.g.e> lUs;
    private final boolean lVX;
    private final Executor mExecutor;

    public ao(Executor executor, com.facebook.common.memory.g gVar, boolean z, aj<com.facebook.imagepipeline.g.e> ajVar, boolean z2) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.lPJ = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.lVX = z;
        this.lUs = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.lSx = z2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.lUs.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes10.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private boolean Tq;
        private final ak lUF;
        private final JobScheduler lUL;

        public a(final k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.Tq = false;
            this.lUF = akVar;
            this.lUL = new JobScheduler(ao.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.ao.a.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.g.e eVar, int i) {
                    a.this.g(eVar, i);
                }
            }, 100);
            this.lUF.a(new e() { // from class: com.facebook.imagepipeline.producers.ao.a.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dqr() {
                    if (a.this.lUF.dqo()) {
                        a.this.lUL.dqC();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dmA() {
                    a.this.lUL.dqB();
                    a.this.Tq = true;
                    kVar.djp();
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
                    TriState a = ao.a(this.lUF.dqj(), eVar, ao.this.lVX);
                    if (IE || a != TriState.UNSET) {
                        if (a != TriState.YES) {
                            if (!this.lUF.dqj().drf().dnn() && eVar.dph() != 0 && eVar.dph() != -1) {
                                eVar = k(eVar);
                                eVar.Ig(0);
                            }
                            dqv().g(eVar, i);
                        } else if (this.lUL.e(eVar, i)) {
                            if (IE || this.lUF.dqo()) {
                                this.lUL.dqC();
                            }
                        }
                    }
                } else if (IE) {
                    dqv().g(null, 1);
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
            this.lUF.dqk().fe(this.lUF.getId(), "ResizeAndRotateProducer");
            ImageRequest dqj = this.lUF.dqj();
            com.facebook.common.memory.i djB = ao.this.lPJ.djB();
            try {
                int b = ao.b(dqj, eVar, ao.this.lVX);
                int a2 = q.a(dqj, eVar);
                int IJ = ao.IJ(a2);
                int i2 = ao.this.lSx ? IJ : b;
                inputStream = eVar.getInputStream();
                try {
                    if (ao.lVW.contains(Integer.valueOf(eVar.dpi()))) {
                        int b2 = ao.b(dqj.drf(), eVar);
                        a = a(eVar, dqj, i2, IJ, b, 0);
                        JpegTranscoder.b(inputStream, djB, b2, i2, 85);
                    } else {
                        int a3 = ao.a(dqj.drf(), eVar);
                        a = a(eVar, dqj, i2, IJ, b, a3);
                        JpegTranscoder.a(inputStream, djB, a3, i2, 85);
                    }
                    com.facebook.common.references.a b3 = com.facebook.common.references.a.b(djB.djC());
                    try {
                        com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(b3);
                        eVar2.c(com.facebook.c.b.lOH);
                        eVar2.dpn();
                        this.lUF.dqk().a(this.lUF.getId(), "ResizeAndRotateProducer", a);
                        if (a2 != 1) {
                            i |= 16;
                        }
                        dqv().g(eVar2, i);
                        com.facebook.imagepipeline.g.e.e(eVar2);
                        com.facebook.common.internal.b.r(inputStream);
                        djB.close();
                    } finally {
                        com.facebook.common.references.a.c(b3);
                    }
                } catch (Exception e) {
                    e = e;
                    inputStream2 = inputStream;
                    try {
                        this.lUF.dqk().a(this.lUF.getId(), "ResizeAndRotateProducer", e, (Map<String, String>) null);
                        if (IE(i)) {
                            dqv().D(e);
                        }
                        com.facebook.common.internal.b.r(inputStream2);
                        djB.close();
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        com.facebook.common.internal.b.r(inputStream);
                        djB.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.facebook.common.internal.b.r(inputStream);
                    djB.close();
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
            if (!this.lUF.dqk().OQ(this.lUF.getId())) {
                return null;
            }
            String str2 = eVar.getWidth() + Config.EVENT_HEAT_X + eVar.getHeight();
            if (imageRequest.dre() != null) {
                str = imageRequest.dre().width + Config.EVENT_HEAT_X + imageRequest.dre().height;
            } else {
                str = "Unspecified";
            }
            String str3 = i > 0 ? i + "/8" : "";
            HashMap hashMap = new HashMap();
            hashMap.put("Original size", str2);
            hashMap.put("Requested size", str);
            hashMap.put("Fraction", str3);
            hashMap.put("queueTime", String.valueOf(this.lUL.dqG()));
            hashMap.put("downsampleEnumerator", Integer.toString(i2));
            hashMap.put("softwareEnumerator", Integer.toString(i3));
            hashMap.put("rotationAngle", Integer.toString(i4));
            return ImmutableMap.copyOf((Map) hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState a(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar, boolean z) {
        if (eVar == null || eVar.dpl() == com.facebook.c.c.lOR) {
            return TriState.UNSET;
        }
        if (eVar.dpl() != com.facebook.c.b.lOH) {
            return TriState.NO;
        }
        return TriState.valueOf(c(imageRequest.drf(), eVar) || II(b(imageRequest, eVar, z)));
    }

    static float a(com.facebook.imagepipeline.common.d dVar, int i, int i2) {
        if (dVar == null) {
            return 1.0f;
        }
        float max = Math.max(dVar.width / i, dVar.height / i2);
        if (i * max > dVar.lQY) {
            max = dVar.lQY / i;
        }
        if (i2 * max > dVar.lQY) {
            return dVar.lQY / i2;
        }
        return max;
    }

    static int D(float f, float f2) {
        return (int) ((8.0f * f) + f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar, boolean z) {
        com.facebook.imagepipeline.common.d dre;
        if (z && (dre = imageRequest.dre()) != null) {
            int a2 = a(imageRequest.drf(), eVar);
            int b = lVW.contains(Integer.valueOf(eVar.dpi())) ? b(imageRequest.drf(), eVar) : 0;
            boolean z2 = a2 == 90 || a2 == 270 || b == 5 || b == 7;
            int D = D(a(dre, z2 ? eVar.getHeight() : eVar.getWidth(), z2 ? eVar.getWidth() : eVar.getHeight()), dre.lQZ);
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
        if (!eVar.dnl()) {
            return 0;
        }
        int j = j(eVar2);
        return !eVar.dnk() ? (j + eVar.dnm()) % 360 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        int indexOf = lVW.indexOf(Integer.valueOf(eVar2.dpi()));
        if (indexOf < 0) {
            throw new IllegalArgumentException("Only accepts inverted exif orientations");
        }
        int i = 0;
        if (!eVar.dnk()) {
            i = eVar.dnm();
        }
        return lVW.get(((i / 90) + indexOf) % lVW.size()).intValue();
    }

    private static int j(com.facebook.imagepipeline.g.e eVar) {
        switch (eVar.dph()) {
            case 90:
            case 180:
            case 270:
                return eVar.dph();
            default:
                return 0;
        }
    }

    private static boolean II(int i) {
        return i < 8;
    }

    private static boolean c(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        return !eVar.dnn() && (a(eVar, eVar2) != 0 || d(eVar, eVar2));
    }

    private static boolean d(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        if (!eVar.dnl() || eVar.dnn()) {
            eVar2.Ih(0);
            return false;
        }
        return lVW.contains(Integer.valueOf(eVar2.dpi()));
    }

    static int IJ(int i) {
        return Math.max(1, 8 / i);
    }
}
