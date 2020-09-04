package com.facebook.imagepipeline.producers;

import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
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
/* loaded from: classes8.dex */
public class ao implements aj<com.facebook.imagepipeline.g.e> {
    private static final ImmutableList<Integer> nzH = ImmutableList.of((Object[]) new Integer[]{2, 7, 4, 5});
    private final Executor mExecutor;
    private final com.facebook.common.memory.g ntt;
    private final boolean nwi;
    private final aj<com.facebook.imagepipeline.g.e> nyd;
    private final boolean nzI;

    public ao(Executor executor, com.facebook.common.memory.g gVar, boolean z, aj<com.facebook.imagepipeline.g.e> ajVar, boolean z2) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.ntt = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.nzI = z;
        this.nyd = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.nwi = z2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.nyd.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes8.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private boolean ezh;
        private final ak nyq;
        private final JobScheduler nyw;

        public a(final k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.ezh = false;
            this.nyq = akVar;
            this.nyw = new JobScheduler(ao.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.ao.a.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.g.e eVar, int i) {
                    a.this.g(eVar, i);
                }
            }, 100);
            this.nyq.a(new e() { // from class: com.facebook.imagepipeline.producers.ao.a.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dVF() {
                    if (a.this.nyq.dVC()) {
                        a.this.nyw.dVQ();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dRP() {
                    a.this.nyw.dVP();
                    a.this.ezh = true;
                    kVar.dOD();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(@Nullable com.facebook.imagepipeline.g.e eVar, int i) {
            if (!this.ezh) {
                boolean Ml = Ml(i);
                if (eVar != null) {
                    TriState a = ao.a(this.nyq.dVx(), eVar, ao.this.nzI);
                    if (Ml || a != TriState.UNSET) {
                        if (a != TriState.YES) {
                            if (!this.nyq.dVx().dWs().dSE() && eVar.dUw() != 0 && eVar.dUw() != -1) {
                                eVar = k(eVar);
                                eVar.LN(0);
                            }
                            dVJ().h(eVar, i);
                        } else if (this.nyw.e(eVar, i)) {
                            if (Ml || this.nyq.dVC()) {
                                this.nyw.dVQ();
                            }
                        }
                    }
                } else if (Ml) {
                    dVJ().h(null, 1);
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
            this.nyq.dVy().go(this.nyq.getId(), "ResizeAndRotateProducer");
            ImageRequest dVx = this.nyq.dVx();
            com.facebook.common.memory.i dOP = ao.this.ntt.dOP();
            try {
                int b = ao.b(dVx, eVar, ao.this.nzI);
                int a2 = q.a(dVx, eVar);
                int Mr = ao.Mr(a2);
                int i2 = ao.this.nwi ? Mr : b;
                inputStream = eVar.getInputStream();
                try {
                    if (ao.nzH.contains(Integer.valueOf(eVar.dUx()))) {
                        int b2 = ao.b(dVx.dWs(), eVar);
                        a = a(eVar, dVx, i2, Mr, b, 0);
                        JpegTranscoder.b(inputStream, dOP, b2, i2, 85);
                    } else {
                        int a3 = ao.a(dVx.dWs(), eVar);
                        a = a(eVar, dVx, i2, Mr, b, a3);
                        JpegTranscoder.a(inputStream, dOP, a3, i2, 85);
                    }
                    com.facebook.common.references.a e = com.facebook.common.references.a.e(dOP.dOQ());
                    try {
                        com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(e);
                        eVar2.c(com.facebook.c.b.nso);
                        eVar2.dUC();
                        this.nyq.dVy().a(this.nyq.getId(), "ResizeAndRotateProducer", a);
                        if (a2 != 1) {
                            i |= 16;
                        }
                        dVJ().h(eVar2, i);
                        com.facebook.imagepipeline.g.e.e(eVar2);
                        com.facebook.common.internal.b.p(inputStream);
                        dOP.close();
                    } finally {
                        com.facebook.common.references.a.c(e);
                    }
                } catch (Exception e2) {
                    e = e2;
                    inputStream2 = inputStream;
                    try {
                        this.nyq.dVy().a(this.nyq.getId(), "ResizeAndRotateProducer", e, (Map<String, String>) null);
                        if (Ml(i)) {
                            dVJ().E(e);
                        }
                        com.facebook.common.internal.b.p(inputStream2);
                        dOP.close();
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        com.facebook.common.internal.b.p(inputStream);
                        dOP.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.facebook.common.internal.b.p(inputStream);
                    dOP.close();
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
            if (!this.nyq.dVy().UF(this.nyq.getId())) {
                return null;
            }
            String str2 = eVar.getWidth() + "x" + eVar.getHeight();
            if (imageRequest.dWr() != null) {
                str = imageRequest.dWr().width + "x" + imageRequest.dWr().height;
            } else {
                str = "Unspecified";
            }
            String str3 = i > 0 ? i + "/8" : "";
            HashMap hashMap = new HashMap();
            hashMap.put("Original size", str2);
            hashMap.put("Requested size", str);
            hashMap.put("Fraction", str3);
            hashMap.put("queueTime", String.valueOf(this.nyw.dVU()));
            hashMap.put("downsampleEnumerator", Integer.toString(i2));
            hashMap.put("softwareEnumerator", Integer.toString(i3));
            hashMap.put("rotationAngle", Integer.toString(i4));
            return ImmutableMap.copyOf((Map) hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState a(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar, boolean z) {
        if (eVar == null || eVar.dUA() == com.facebook.c.c.nsy) {
            return TriState.UNSET;
        }
        if (eVar.dUA() != com.facebook.c.b.nso) {
            return TriState.NO;
        }
        return TriState.valueOf(c(imageRequest.dWs(), eVar) || Mq(b(imageRequest, eVar, z)));
    }

    static float a(com.facebook.imagepipeline.common.d dVar, int i, int i2) {
        if (dVar == null) {
            return 1.0f;
        }
        float max = Math.max(dVar.width / i, dVar.height / i2);
        if (i * max > dVar.nuJ) {
            max = dVar.nuJ / i;
        }
        if (i2 * max > dVar.nuJ) {
            return dVar.nuJ / i2;
        }
        return max;
    }

    static int D(float f, float f2) {
        return (int) ((8.0f * f) + f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar, boolean z) {
        com.facebook.imagepipeline.common.d dWr;
        if (z && (dWr = imageRequest.dWr()) != null) {
            int a2 = a(imageRequest.dWs(), eVar);
            int b = nzH.contains(Integer.valueOf(eVar.dUx())) ? b(imageRequest.dWs(), eVar) : 0;
            boolean z2 = a2 == 90 || a2 == 270 || b == 5 || b == 7;
            int D = D(a(dWr, z2 ? eVar.getHeight() : eVar.getWidth(), z2 ? eVar.getWidth() : eVar.getHeight()), dWr.nuK);
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
        if (!eVar.dSC()) {
            return 0;
        }
        int j = j(eVar2);
        return !eVar.dSB() ? (j + eVar.dSD()) % EncoderTextureDrawer.X264_WIDTH : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        int indexOf = nzH.indexOf(Integer.valueOf(eVar2.dUx()));
        if (indexOf < 0) {
            throw new IllegalArgumentException("Only accepts inverted exif orientations");
        }
        int i = 0;
        if (!eVar.dSB()) {
            i = eVar.dSD();
        }
        return nzH.get(((i / 90) + indexOf) % nzH.size()).intValue();
    }

    private static int j(com.facebook.imagepipeline.g.e eVar) {
        switch (eVar.dUw()) {
            case 90:
            case 180:
            case 270:
                return eVar.dUw();
            default:
                return 0;
        }
    }

    private static boolean Mq(int i) {
        return i < 8;
    }

    private static boolean c(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        return !eVar.dSE() && (a(eVar, eVar2) != 0 || d(eVar, eVar2));
    }

    private static boolean d(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        if (!eVar.dSC() || eVar.dSE()) {
            eVar2.LO(0);
            return false;
        }
        return nzH.contains(Integer.valueOf(eVar2.dUx()));
    }

    static int Mr(int i) {
        return Math.max(1, 8 / i);
    }
}
