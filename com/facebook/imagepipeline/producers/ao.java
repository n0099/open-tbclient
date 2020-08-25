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
    private static final ImmutableList<Integer> nzp = ImmutableList.of((Object[]) new Integer[]{2, 7, 4, 5});
    private final Executor mExecutor;
    private final com.facebook.common.memory.g ntb;
    private final boolean nvQ;
    private final aj<com.facebook.imagepipeline.g.e> nxL;
    private final boolean nzq;

    public ao(Executor executor, com.facebook.common.memory.g gVar, boolean z, aj<com.facebook.imagepipeline.g.e> ajVar, boolean z2) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.ntb = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.nzq = z;
        this.nxL = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.nvQ = z2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.nxL.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes8.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private boolean ezd;
        private final ak nxY;
        private final JobScheduler nye;

        public a(final k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.ezd = false;
            this.nxY = akVar;
            this.nye = new JobScheduler(ao.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.ao.a.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.g.e eVar, int i) {
                    a.this.g(eVar, i);
                }
            }, 100);
            this.nxY.a(new e() { // from class: com.facebook.imagepipeline.producers.ao.a.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dVw() {
                    if (a.this.nxY.dVt()) {
                        a.this.nye.dVH();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dRG() {
                    a.this.nye.dVG();
                    a.this.ezd = true;
                    kVar.dOu();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(@Nullable com.facebook.imagepipeline.g.e eVar, int i) {
            if (!this.ezd) {
                boolean Ml = Ml(i);
                if (eVar != null) {
                    TriState a = ao.a(this.nxY.dVo(), eVar, ao.this.nzq);
                    if (Ml || a != TriState.UNSET) {
                        if (a != TriState.YES) {
                            if (!this.nxY.dVo().dWj().dSv() && eVar.dUn() != 0 && eVar.dUn() != -1) {
                                eVar = k(eVar);
                                eVar.LN(0);
                            }
                            dVA().h(eVar, i);
                        } else if (this.nye.e(eVar, i)) {
                            if (Ml || this.nxY.dVt()) {
                                this.nye.dVH();
                            }
                        }
                    }
                } else if (Ml) {
                    dVA().h(null, 1);
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
            this.nxY.dVp().gn(this.nxY.getId(), "ResizeAndRotateProducer");
            ImageRequest dVo = this.nxY.dVo();
            com.facebook.common.memory.i dOG = ao.this.ntb.dOG();
            try {
                int b = ao.b(dVo, eVar, ao.this.nzq);
                int a2 = q.a(dVo, eVar);
                int Mr = ao.Mr(a2);
                int i2 = ao.this.nvQ ? Mr : b;
                inputStream = eVar.getInputStream();
                try {
                    if (ao.nzp.contains(Integer.valueOf(eVar.dUo()))) {
                        int b2 = ao.b(dVo.dWj(), eVar);
                        a = a(eVar, dVo, i2, Mr, b, 0);
                        JpegTranscoder.b(inputStream, dOG, b2, i2, 85);
                    } else {
                        int a3 = ao.a(dVo.dWj(), eVar);
                        a = a(eVar, dVo, i2, Mr, b, a3);
                        JpegTranscoder.a(inputStream, dOG, a3, i2, 85);
                    }
                    com.facebook.common.references.a e = com.facebook.common.references.a.e(dOG.dOH());
                    try {
                        com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(e);
                        eVar2.c(com.facebook.c.b.nrW);
                        eVar2.dUt();
                        this.nxY.dVp().a(this.nxY.getId(), "ResizeAndRotateProducer", a);
                        if (a2 != 1) {
                            i |= 16;
                        }
                        dVA().h(eVar2, i);
                        com.facebook.imagepipeline.g.e.e(eVar2);
                        com.facebook.common.internal.b.p(inputStream);
                        dOG.close();
                    } finally {
                        com.facebook.common.references.a.c(e);
                    }
                } catch (Exception e2) {
                    e = e2;
                    inputStream2 = inputStream;
                    try {
                        this.nxY.dVp().a(this.nxY.getId(), "ResizeAndRotateProducer", e, (Map<String, String>) null);
                        if (Ml(i)) {
                            dVA().E(e);
                        }
                        com.facebook.common.internal.b.p(inputStream2);
                        dOG.close();
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        com.facebook.common.internal.b.p(inputStream);
                        dOG.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.facebook.common.internal.b.p(inputStream);
                    dOG.close();
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
            if (!this.nxY.dVp().UF(this.nxY.getId())) {
                return null;
            }
            String str2 = eVar.getWidth() + "x" + eVar.getHeight();
            if (imageRequest.dWi() != null) {
                str = imageRequest.dWi().width + "x" + imageRequest.dWi().height;
            } else {
                str = "Unspecified";
            }
            String str3 = i > 0 ? i + "/8" : "";
            HashMap hashMap = new HashMap();
            hashMap.put("Original size", str2);
            hashMap.put("Requested size", str);
            hashMap.put("Fraction", str3);
            hashMap.put("queueTime", String.valueOf(this.nye.dVL()));
            hashMap.put("downsampleEnumerator", Integer.toString(i2));
            hashMap.put("softwareEnumerator", Integer.toString(i3));
            hashMap.put("rotationAngle", Integer.toString(i4));
            return ImmutableMap.copyOf((Map) hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState a(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar, boolean z) {
        if (eVar == null || eVar.dUr() == com.facebook.c.c.nsg) {
            return TriState.UNSET;
        }
        if (eVar.dUr() != com.facebook.c.b.nrW) {
            return TriState.NO;
        }
        return TriState.valueOf(c(imageRequest.dWj(), eVar) || Mq(b(imageRequest, eVar, z)));
    }

    static float a(com.facebook.imagepipeline.common.d dVar, int i, int i2) {
        if (dVar == null) {
            return 1.0f;
        }
        float max = Math.max(dVar.width / i, dVar.height / i2);
        if (i * max > dVar.nur) {
            max = dVar.nur / i;
        }
        if (i2 * max > dVar.nur) {
            return dVar.nur / i2;
        }
        return max;
    }

    static int D(float f, float f2) {
        return (int) ((8.0f * f) + f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar, boolean z) {
        com.facebook.imagepipeline.common.d dWi;
        if (z && (dWi = imageRequest.dWi()) != null) {
            int a2 = a(imageRequest.dWj(), eVar);
            int b = nzp.contains(Integer.valueOf(eVar.dUo())) ? b(imageRequest.dWj(), eVar) : 0;
            boolean z2 = a2 == 90 || a2 == 270 || b == 5 || b == 7;
            int D = D(a(dWi, z2 ? eVar.getHeight() : eVar.getWidth(), z2 ? eVar.getWidth() : eVar.getHeight()), dWi.nus);
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
        if (!eVar.dSt()) {
            return 0;
        }
        int j = j(eVar2);
        return !eVar.dSs() ? (j + eVar.dSu()) % EncoderTextureDrawer.X264_WIDTH : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        int indexOf = nzp.indexOf(Integer.valueOf(eVar2.dUo()));
        if (indexOf < 0) {
            throw new IllegalArgumentException("Only accepts inverted exif orientations");
        }
        int i = 0;
        if (!eVar.dSs()) {
            i = eVar.dSu();
        }
        return nzp.get(((i / 90) + indexOf) % nzp.size()).intValue();
    }

    private static int j(com.facebook.imagepipeline.g.e eVar) {
        switch (eVar.dUn()) {
            case 90:
            case 180:
            case 270:
                return eVar.dUn();
            default:
                return 0;
        }
    }

    private static boolean Mq(int i) {
        return i < 8;
    }

    private static boolean c(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        return !eVar.dSv() && (a(eVar, eVar2) != 0 || d(eVar, eVar2));
    }

    private static boolean d(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        if (!eVar.dSt() || eVar.dSv()) {
            eVar2.LO(0);
            return false;
        }
        return nzp.contains(Integer.valueOf(eVar2.dUo()));
    }

    static int Mr(int i) {
        return Math.max(1, 8 / i);
    }
}
