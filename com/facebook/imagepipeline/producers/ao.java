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
    private static final ImmutableList<Integer> oQn = ImmutableList.of((Object[]) new Integer[]{2, 7, 4, 5});
    private final Executor mExecutor;
    private final com.facebook.common.memory.g oKc;
    private final boolean oMO;
    private final aj<com.facebook.imagepipeline.g.e> oOJ;
    private final boolean oQo;

    public ao(Executor executor, com.facebook.common.memory.g gVar, boolean z, aj<com.facebook.imagepipeline.g.e> ajVar, boolean z2) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.oKc = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.oQo = z;
        this.oOJ = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.oMO = z2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.oOJ.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes18.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private boolean eVO;
        private final ak oOW;
        private final JobScheduler oPc;

        public a(final k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.eVO = false;
            this.oOW = akVar;
            this.oPc = new JobScheduler(ao.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.ao.a.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.g.e eVar, int i) {
                    a.this.g(eVar, i);
                }
            }, 100);
            this.oOW.a(new e() { // from class: com.facebook.imagepipeline.producers.ao.a.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void enn() {
                    if (a.this.oOW.enk()) {
                        a.this.oPc.eny();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void ejw() {
                    a.this.oPc.enx();
                    a.this.eVO = true;
                    kVar.egk();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(@Nullable com.facebook.imagepipeline.g.e eVar, int i) {
            if (!this.eVO) {
                boolean Pn = Pn(i);
                if (eVar != null) {
                    TriState a2 = ao.a(this.oOW.enf(), eVar, ao.this.oQo);
                    if (Pn || a2 != TriState.UNSET) {
                        if (a2 != TriState.YES) {
                            if (!this.oOW.enf().eoa().ekl() && eVar.emd() != 0 && eVar.emd() != -1) {
                                eVar = k(eVar);
                                eVar.OP(0);
                            }
                            enr().h(eVar, i);
                        } else if (this.oPc.e(eVar, i)) {
                            if (Pn || this.oOW.enk()) {
                                this.oPc.eny();
                            }
                        }
                    }
                } else if (Pn) {
                    enr().h(null, 1);
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
            this.oOW.eng().gX(this.oOW.getId(), "ResizeAndRotateProducer");
            ImageRequest enf = this.oOW.enf();
            com.facebook.common.memory.i egw = ao.this.oKc.egw();
            try {
                int b = ao.b(enf, eVar, ao.this.oQo);
                int a3 = q.a(enf, eVar);
                int Pt = ao.Pt(a3);
                int i2 = ao.this.oMO ? Pt : b;
                inputStream = eVar.getInputStream();
                try {
                    if (ao.oQn.contains(Integer.valueOf(eVar.eme()))) {
                        int b2 = ao.b(enf.eoa(), eVar);
                        a2 = a(eVar, enf, i2, Pt, b, 0);
                        JpegTranscoder.b(inputStream, egw, b2, i2, 85);
                    } else {
                        int a4 = ao.a(enf.eoa(), eVar);
                        a2 = a(eVar, enf, i2, Pt, b, a4);
                        JpegTranscoder.a(inputStream, egw, a4, i2, 85);
                    }
                    com.facebook.common.references.a e = com.facebook.common.references.a.e(egw.egx());
                    try {
                        com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(e);
                        eVar2.c(com.facebook.c.b.oIX);
                        eVar2.emj();
                        this.oOW.eng().a(this.oOW.getId(), "ResizeAndRotateProducer", a2);
                        if (a3 != 1) {
                            i |= 16;
                        }
                        enr().h(eVar2, i);
                        com.facebook.imagepipeline.g.e.e(eVar2);
                        com.facebook.common.internal.b.q(inputStream);
                        egw.close();
                    } finally {
                        com.facebook.common.references.a.c(e);
                    }
                } catch (Exception e2) {
                    e = e2;
                    inputStream2 = inputStream;
                    try {
                        this.oOW.eng().a(this.oOW.getId(), "ResizeAndRotateProducer", e, (Map<String, String>) null);
                        if (Pn(i)) {
                            enr().E(e);
                        }
                        com.facebook.common.internal.b.q(inputStream2);
                        egw.close();
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        com.facebook.common.internal.b.q(inputStream);
                        egw.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.facebook.common.internal.b.q(inputStream);
                    egw.close();
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
            if (!this.oOW.eng().XI(this.oOW.getId())) {
                return null;
            }
            String str2 = eVar.getWidth() + "x" + eVar.getHeight();
            if (imageRequest.enZ() != null) {
                str = imageRequest.enZ().width + "x" + imageRequest.enZ().height;
            } else {
                str = "Unspecified";
            }
            String str3 = i > 0 ? i + "/8" : "";
            HashMap hashMap = new HashMap();
            hashMap.put("Original size", str2);
            hashMap.put("Requested size", str);
            hashMap.put("Fraction", str3);
            hashMap.put("queueTime", String.valueOf(this.oPc.enC()));
            hashMap.put("downsampleEnumerator", Integer.toString(i2));
            hashMap.put("softwareEnumerator", Integer.toString(i3));
            hashMap.put("rotationAngle", Integer.toString(i4));
            return ImmutableMap.copyOf((Map) hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState a(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar, boolean z) {
        if (eVar == null || eVar.emh() == com.facebook.c.c.oJh) {
            return TriState.UNSET;
        }
        if (eVar.emh() != com.facebook.c.b.oIX) {
            return TriState.NO;
        }
        return TriState.valueOf(c(imageRequest.eoa(), eVar) || Ps(b(imageRequest, eVar, z)));
    }

    static float a(com.facebook.imagepipeline.common.d dVar, int i, int i2) {
        if (dVar == null) {
            return 1.0f;
        }
        float max = Math.max(dVar.width / i, dVar.height / i2);
        if (i * max > dVar.oLr) {
            max = dVar.oLr / i;
        }
        if (i2 * max > dVar.oLr) {
            return dVar.oLr / i2;
        }
        return max;
    }

    static int G(float f, float f2) {
        return (int) ((8.0f * f) + f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar, boolean z) {
        com.facebook.imagepipeline.common.d enZ;
        if (z && (enZ = imageRequest.enZ()) != null) {
            int a2 = a(imageRequest.eoa(), eVar);
            int b = oQn.contains(Integer.valueOf(eVar.eme())) ? b(imageRequest.eoa(), eVar) : 0;
            boolean z2 = a2 == 90 || a2 == 270 || b == 5 || b == 7;
            int G = G(a(enZ, z2 ? eVar.getHeight() : eVar.getWidth(), z2 ? eVar.getWidth() : eVar.getHeight()), enZ.oLs);
            if (G > 8) {
                return 8;
            }
            if (G < 1) {
                return 1;
            }
            return G;
        }
        return 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int a(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        if (!eVar.ekj()) {
            return 0;
        }
        int j = j(eVar2);
        return !eVar.eki() ? (j + eVar.ekk()) % EncoderTextureDrawer.X264_WIDTH : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        int indexOf = oQn.indexOf(Integer.valueOf(eVar2.eme()));
        if (indexOf < 0) {
            throw new IllegalArgumentException("Only accepts inverted exif orientations");
        }
        int i = 0;
        if (!eVar.eki()) {
            i = eVar.ekk();
        }
        return oQn.get(((i / 90) + indexOf) % oQn.size()).intValue();
    }

    private static int j(com.facebook.imagepipeline.g.e eVar) {
        switch (eVar.emd()) {
            case 90:
            case 180:
            case 270:
                return eVar.emd();
            default:
                return 0;
        }
    }

    private static boolean Ps(int i) {
        return i < 8;
    }

    private static boolean c(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        return !eVar.ekl() && (a(eVar, eVar2) != 0 || d(eVar, eVar2));
    }

    private static boolean d(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        if (!eVar.ekj() || eVar.ekl()) {
            eVar2.OQ(0);
            return false;
        }
        return oQn.contains(Integer.valueOf(eVar2.eme()));
    }

    static int Pt(int i) {
        return Math.max(1, 8 / i);
    }
}
