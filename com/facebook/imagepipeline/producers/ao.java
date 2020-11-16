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
/* loaded from: classes15.dex */
public class ao implements aj<com.facebook.imagepipeline.g.e> {
    private static final ImmutableList<Integer> pbl = ImmutableList.of((Object[]) new Integer[]{2, 7, 4, 5});
    private final Executor mExecutor;
    private final com.facebook.common.memory.g oUY;
    private final boolean oXK;
    private final aj<com.facebook.imagepipeline.g.e> oZF;
    private final boolean pbm;

    public ao(Executor executor, com.facebook.common.memory.g gVar, boolean z, aj<com.facebook.imagepipeline.g.e> ajVar, boolean z2) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.oUY = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.pbm = z;
        this.oZF = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.oXK = z2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.oZF.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes15.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private boolean faL;
        private final ak oZS;
        private final JobScheduler oZY;

        public a(final k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.faL = false;
            this.oZS = akVar;
            this.oZY = new JobScheduler(ao.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.ao.a.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.g.e eVar, int i) {
                    a.this.g(eVar, i);
                }
            }, 100);
            this.oZS.a(new e() { // from class: com.facebook.imagepipeline.producers.ao.a.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void erb() {
                    if (a.this.oZS.eqY()) {
                        a.this.oZY.erm();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void enk() {
                    a.this.oZY.erl();
                    a.this.faL = true;
                    kVar.ejX();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(@Nullable com.facebook.imagepipeline.g.e eVar, int i) {
            if (!this.faL) {
                boolean Ql = Ql(i);
                if (eVar != null) {
                    TriState a2 = ao.a(this.oZS.eqT(), eVar, ao.this.pbm);
                    if (Ql || a2 != TriState.UNSET) {
                        if (a2 != TriState.YES) {
                            if (!this.oZS.eqT().erO().enZ() && eVar.epS() != 0 && eVar.epS() != -1) {
                                eVar = k(eVar);
                                eVar.PN(0);
                            }
                            erf().h(eVar, i);
                        } else if (this.oZY.e(eVar, i)) {
                            if (Ql || this.oZS.eqY()) {
                                this.oZY.erm();
                            }
                        }
                    }
                } else if (Ql) {
                    erf().h(null, 1);
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
            this.oZS.eqU().gZ(this.oZS.getId(), "ResizeAndRotateProducer");
            ImageRequest eqT = this.oZS.eqT();
            com.facebook.common.memory.i ekj = ao.this.oUY.ekj();
            try {
                int b = ao.b(eqT, eVar, ao.this.pbm);
                int a3 = q.a(eqT, eVar);
                int Qr = ao.Qr(a3);
                int i2 = ao.this.oXK ? Qr : b;
                inputStream = eVar.getInputStream();
                try {
                    if (ao.pbl.contains(Integer.valueOf(eVar.epT()))) {
                        int b2 = ao.b(eqT.erO(), eVar);
                        a2 = a(eVar, eqT, i2, Qr, b, 0);
                        JpegTranscoder.b(inputStream, ekj, b2, i2, 85);
                    } else {
                        int a4 = ao.a(eqT.erO(), eVar);
                        a2 = a(eVar, eqT, i2, Qr, b, a4);
                        JpegTranscoder.a(inputStream, ekj, a4, i2, 85);
                    }
                    com.facebook.common.references.a e = com.facebook.common.references.a.e(ekj.ekk());
                    try {
                        com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(e);
                        eVar2.c(com.facebook.c.b.oTT);
                        eVar2.epY();
                        this.oZS.eqU().a(this.oZS.getId(), "ResizeAndRotateProducer", a2);
                        if (a3 != 1) {
                            i |= 16;
                        }
                        erf().h(eVar2, i);
                        com.facebook.imagepipeline.g.e.e(eVar2);
                        com.facebook.common.internal.b.q(inputStream);
                        ekj.close();
                    } finally {
                        com.facebook.common.references.a.c(e);
                    }
                } catch (Exception e2) {
                    e = e2;
                    inputStream2 = inputStream;
                    try {
                        this.oZS.eqU().a(this.oZS.getId(), "ResizeAndRotateProducer", e, (Map<String, String>) null);
                        if (Ql(i)) {
                            erf().E(e);
                        }
                        com.facebook.common.internal.b.q(inputStream2);
                        ekj.close();
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        com.facebook.common.internal.b.q(inputStream);
                        ekj.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.facebook.common.internal.b.q(inputStream);
                    ekj.close();
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
            if (!this.oZS.eqU().XX(this.oZS.getId())) {
                return null;
            }
            String str2 = eVar.getWidth() + "x" + eVar.getHeight();
            if (imageRequest.erN() != null) {
                str = imageRequest.erN().width + "x" + imageRequest.erN().height;
            } else {
                str = "Unspecified";
            }
            String str3 = i > 0 ? i + "/8" : "";
            HashMap hashMap = new HashMap();
            hashMap.put("Original size", str2);
            hashMap.put("Requested size", str);
            hashMap.put("Fraction", str3);
            hashMap.put("queueTime", String.valueOf(this.oZY.erq()));
            hashMap.put("downsampleEnumerator", Integer.toString(i2));
            hashMap.put("softwareEnumerator", Integer.toString(i3));
            hashMap.put("rotationAngle", Integer.toString(i4));
            return ImmutableMap.copyOf((Map) hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState a(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar, boolean z) {
        if (eVar == null || eVar.epW() == com.facebook.c.c.oUd) {
            return TriState.UNSET;
        }
        if (eVar.epW() != com.facebook.c.b.oTT) {
            return TriState.NO;
        }
        return TriState.valueOf(c(imageRequest.erO(), eVar) || Qq(b(imageRequest, eVar, z)));
    }

    static float a(com.facebook.imagepipeline.common.d dVar, int i, int i2) {
        if (dVar == null) {
            return 1.0f;
        }
        float max = Math.max(dVar.width / i, dVar.height / i2);
        if (i * max > dVar.oWn) {
            max = dVar.oWn / i;
        }
        if (i2 * max > dVar.oWn) {
            return dVar.oWn / i2;
        }
        return max;
    }

    static int I(float f, float f2) {
        return (int) ((8.0f * f) + f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar, boolean z) {
        com.facebook.imagepipeline.common.d erN;
        if (z && (erN = imageRequest.erN()) != null) {
            int a2 = a(imageRequest.erO(), eVar);
            int b = pbl.contains(Integer.valueOf(eVar.epT())) ? b(imageRequest.erO(), eVar) : 0;
            boolean z2 = a2 == 90 || a2 == 270 || b == 5 || b == 7;
            int I = I(a(erN, z2 ? eVar.getHeight() : eVar.getWidth(), z2 ? eVar.getWidth() : eVar.getHeight()), erN.oWo);
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
        if (!eVar.enX()) {
            return 0;
        }
        int j = j(eVar2);
        return !eVar.enW() ? (j + eVar.enY()) % EncoderTextureDrawer.X264_WIDTH : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        int indexOf = pbl.indexOf(Integer.valueOf(eVar2.epT()));
        if (indexOf < 0) {
            throw new IllegalArgumentException("Only accepts inverted exif orientations");
        }
        int i = 0;
        if (!eVar.enW()) {
            i = eVar.enY();
        }
        return pbl.get(((i / 90) + indexOf) % pbl.size()).intValue();
    }

    private static int j(com.facebook.imagepipeline.g.e eVar) {
        switch (eVar.epS()) {
            case 90:
            case 180:
            case 270:
                return eVar.epS();
            default:
                return 0;
        }
    }

    private static boolean Qq(int i) {
        return i < 8;
    }

    private static boolean c(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        return !eVar.enZ() && (a(eVar, eVar2) != 0 || d(eVar, eVar2));
    }

    private static boolean d(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        if (!eVar.enX() || eVar.enZ()) {
            eVar2.PO(0);
            return false;
        }
        return pbl.contains(Integer.valueOf(eVar2.epT()));
    }

    static int Qr(int i) {
        return Math.max(1, 8 / i);
    }
}
