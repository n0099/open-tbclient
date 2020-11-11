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
/* loaded from: classes18.dex */
public class ao implements aj<com.facebook.imagepipeline.g.e> {
    private static final ImmutableList<Integer> oZG = ImmutableList.of((Object[]) new Integer[]{2, 7, 4, 5});
    private final Executor mExecutor;
    private final com.facebook.common.memory.g oTv;
    private final boolean oWh;
    private final aj<com.facebook.imagepipeline.g.e> oYc;
    private final boolean oZH;

    public ao(Executor executor, com.facebook.common.memory.g gVar, boolean z, aj<com.facebook.imagepipeline.g.e> ajVar, boolean z2) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.oTv = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.oZH = z;
        this.oYc = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.oWh = z2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.oYc.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes18.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private boolean fbD;
        private final ak oYp;
        private final JobScheduler oYv;

        public a(final k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.fbD = false;
            this.oYp = akVar;
            this.oYv = new JobScheduler(ao.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.ao.a.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.g.e eVar, int i) {
                    a.this.g(eVar, i);
                }
            }, 100);
            this.oYp.a(new e() { // from class: com.facebook.imagepipeline.producers.ao.a.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void erd() {
                    if (a.this.oYp.era()) {
                        a.this.oYv.ero();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void enm() {
                    a.this.oYv.ern();
                    a.this.fbD = true;
                    kVar.ejZ();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(@Nullable com.facebook.imagepipeline.g.e eVar, int i) {
            if (!this.fbD) {
                boolean PI = PI(i);
                if (eVar != null) {
                    TriState a2 = ao.a(this.oYp.eqV(), eVar, ao.this.oZH);
                    if (PI || a2 != TriState.UNSET) {
                        if (a2 != TriState.YES) {
                            if (!this.oYp.eqV().erQ().eob() && eVar.epU() != 0 && eVar.epU() != -1) {
                                eVar = k(eVar);
                                eVar.Pk(0);
                            }
                            erh().h(eVar, i);
                        } else if (this.oYv.e(eVar, i)) {
                            if (PI || this.oYp.era()) {
                                this.oYv.ero();
                            }
                        }
                    }
                } else if (PI) {
                    erh().h(null, 1);
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
            Map<String, String> a2;
            this.oYp.eqW().gZ(this.oYp.getId(), "ResizeAndRotateProducer");
            ImageRequest eqV = this.oYp.eqV();
            com.facebook.common.memory.i ekl = ao.this.oTv.ekl();
            try {
                int b = ao.b(eqV, eVar, ao.this.oZH);
                int a3 = q.a(eqV, eVar);
                int PO = ao.PO(a3);
                int i2 = ao.this.oWh ? PO : b;
                inputStream = eVar.getInputStream();
                try {
                    if (ao.oZG.contains(Integer.valueOf(eVar.epV()))) {
                        int b2 = ao.b(eqV.erQ(), eVar);
                        a2 = a(eVar, eqV, i2, PO, b, 0);
                        JpegTranscoder.b(inputStream, ekl, b2, i2, 85);
                    } else {
                        int a4 = ao.a(eqV.erQ(), eVar);
                        a2 = a(eVar, eqV, i2, PO, b, a4);
                        JpegTranscoder.a(inputStream, ekl, a4, i2, 85);
                    }
                    com.facebook.common.references.a e = com.facebook.common.references.a.e(ekl.ekm());
                    try {
                        com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(e);
                        eVar2.c(com.facebook.c.b.oSq);
                        eVar2.eqa();
                        this.oYp.eqW().a(this.oYp.getId(), "ResizeAndRotateProducer", a2);
                        if (a3 != 1) {
                            i |= 16;
                        }
                        erh().h(eVar2, i);
                        com.facebook.imagepipeline.g.e.e(eVar2);
                        com.facebook.common.internal.b.q(inputStream);
                        ekl.close();
                    } finally {
                        com.facebook.common.references.a.c(e);
                    }
                } catch (Exception e2) {
                    e = e2;
                    inputStream2 = inputStream;
                    try {
                        this.oYp.eqW().a(this.oYp.getId(), "ResizeAndRotateProducer", e, (Map<String, String>) null);
                        if (PI(i)) {
                            erh().E(e);
                        }
                        com.facebook.common.internal.b.q(inputStream2);
                        ekl.close();
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        com.facebook.common.internal.b.q(inputStream);
                        ekl.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.facebook.common.internal.b.q(inputStream);
                    ekl.close();
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
            if (!this.oYp.eqW().Ym(this.oYp.getId())) {
                return null;
            }
            String str2 = eVar.getWidth() + "x" + eVar.getHeight();
            if (imageRequest.erP() != null) {
                str = imageRequest.erP().width + "x" + imageRequest.erP().height;
            } else {
                str = "Unspecified";
            }
            String str3 = i > 0 ? i + "/8" : "";
            HashMap hashMap = new HashMap();
            hashMap.put("Original size", str2);
            hashMap.put("Requested size", str);
            hashMap.put("Fraction", str3);
            hashMap.put("queueTime", String.valueOf(this.oYv.ers()));
            hashMap.put("downsampleEnumerator", Integer.toString(i2));
            hashMap.put("softwareEnumerator", Integer.toString(i3));
            hashMap.put("rotationAngle", Integer.toString(i4));
            return ImmutableMap.copyOf((Map) hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState a(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar, boolean z) {
        if (eVar == null || eVar.epY() == com.facebook.c.c.oSA) {
            return TriState.UNSET;
        }
        if (eVar.epY() != com.facebook.c.b.oSq) {
            return TriState.NO;
        }
        return TriState.valueOf(c(imageRequest.erQ(), eVar) || PN(b(imageRequest, eVar, z)));
    }

    static float a(com.facebook.imagepipeline.common.d dVar, int i, int i2) {
        if (dVar == null) {
            return 1.0f;
        }
        float max = Math.max(dVar.width / i, dVar.height / i2);
        if (i * max > dVar.oUK) {
            max = dVar.oUK / i;
        }
        if (i2 * max > dVar.oUK) {
            return dVar.oUK / i2;
        }
        return max;
    }

    static int I(float f, float f2) {
        return (int) ((8.0f * f) + f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar, boolean z) {
        com.facebook.imagepipeline.common.d erP;
        if (z && (erP = imageRequest.erP()) != null) {
            int a2 = a(imageRequest.erQ(), eVar);
            int b = oZG.contains(Integer.valueOf(eVar.epV())) ? b(imageRequest.erQ(), eVar) : 0;
            boolean z2 = a2 == 90 || a2 == 270 || b == 5 || b == 7;
            int I = I(a(erP, z2 ? eVar.getHeight() : eVar.getWidth(), z2 ? eVar.getWidth() : eVar.getHeight()), erP.oUL);
            if (I > 8) {
                return 8;
            }
            if (I < 1) {
                return 1;
            }
            return I;
        }
        return 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int a(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        if (!eVar.enZ()) {
            return 0;
        }
        int j = j(eVar2);
        return !eVar.enY() ? (j + eVar.eoa()) % EncoderTextureDrawer.X264_WIDTH : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        int indexOf = oZG.indexOf(Integer.valueOf(eVar2.epV()));
        if (indexOf < 0) {
            throw new IllegalArgumentException("Only accepts inverted exif orientations");
        }
        int i = 0;
        if (!eVar.enY()) {
            i = eVar.eoa();
        }
        return oZG.get(((i / 90) + indexOf) % oZG.size()).intValue();
    }

    private static int j(com.facebook.imagepipeline.g.e eVar) {
        switch (eVar.epU()) {
            case 90:
            case 180:
            case 270:
                return eVar.epU();
            default:
                return 0;
        }
    }

    private static boolean PN(int i) {
        return i < 8;
    }

    private static boolean c(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        return !eVar.eob() && (a(eVar, eVar2) != 0 || d(eVar, eVar2));
    }

    private static boolean d(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        if (!eVar.enZ() || eVar.eob()) {
            eVar2.Pl(0);
            return false;
        }
        return oZG.contains(Integer.valueOf(eVar2.epV()));
    }

    static int PO(int i) {
        return Math.max(1, 8 / i);
    }
}
