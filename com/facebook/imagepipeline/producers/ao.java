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
/* loaded from: classes25.dex */
public class ao implements aj<com.facebook.imagepipeline.g.e> {
    private static final ImmutableList<Integer> nJE = ImmutableList.of((Object[]) new Integer[]{2, 7, 4, 5});
    private final Executor mExecutor;
    private final com.facebook.common.memory.g nDr;
    private final boolean nGf;
    private final aj<com.facebook.imagepipeline.g.e> nIa;
    private final boolean nJF;

    public ao(Executor executor, com.facebook.common.memory.g gVar, boolean z, aj<com.facebook.imagepipeline.g.e> ajVar, boolean z2) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.nDr = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.nJF = z;
        this.nIa = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.nGf = z2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.nIa.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes25.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private boolean eBl;
        private final ak nIn;
        private final JobScheduler nIt;

        public a(final k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.eBl = false;
            this.nIn = akVar;
            this.nIt = new JobScheduler(ao.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.ao.a.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.g.e eVar, int i) {
                    a.this.g(eVar, i);
                }
            }, 100);
            this.nIn.a(new e() { // from class: com.facebook.imagepipeline.producers.ao.a.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dZD() {
                    if (a.this.nIn.dZA()) {
                        a.this.nIt.dZO();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dVN() {
                    a.this.nIt.dZN();
                    a.this.eBl = true;
                    kVar.dSB();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(@Nullable com.facebook.imagepipeline.g.e eVar, int i) {
            if (!this.eBl) {
                boolean MQ = MQ(i);
                if (eVar != null) {
                    TriState a = ao.a(this.nIn.dZv(), eVar, ao.this.nJF);
                    if (MQ || a != TriState.UNSET) {
                        if (a != TriState.YES) {
                            if (!this.nIn.dZv().eaq().dWC() && eVar.dYu() != 0 && eVar.dYu() != -1) {
                                eVar = k(eVar);
                                eVar.Ms(0);
                            }
                            dZH().h(eVar, i);
                        } else if (this.nIt.e(eVar, i)) {
                            if (MQ || this.nIn.dZA()) {
                                this.nIt.dZO();
                            }
                        }
                    }
                } else if (MQ) {
                    dZH().h(null, 1);
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
            this.nIn.dZw().gA(this.nIn.getId(), "ResizeAndRotateProducer");
            ImageRequest dZv = this.nIn.dZv();
            com.facebook.common.memory.i dSN = ao.this.nDr.dSN();
            try {
                int b = ao.b(dZv, eVar, ao.this.nJF);
                int a2 = q.a(dZv, eVar);
                int MW = ao.MW(a2);
                int i2 = ao.this.nGf ? MW : b;
                inputStream = eVar.getInputStream();
                try {
                    if (ao.nJE.contains(Integer.valueOf(eVar.dYv()))) {
                        int b2 = ao.b(dZv.eaq(), eVar);
                        a = a(eVar, dZv, i2, MW, b, 0);
                        JpegTranscoder.b(inputStream, dSN, b2, i2, 85);
                    } else {
                        int a3 = ao.a(dZv.eaq(), eVar);
                        a = a(eVar, dZv, i2, MW, b, a3);
                        JpegTranscoder.a(inputStream, dSN, a3, i2, 85);
                    }
                    com.facebook.common.references.a e = com.facebook.common.references.a.e(dSN.dSO());
                    try {
                        com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(e);
                        eVar2.c(com.facebook.c.b.nCm);
                        eVar2.dYA();
                        this.nIn.dZw().a(this.nIn.getId(), "ResizeAndRotateProducer", a);
                        if (a2 != 1) {
                            i |= 16;
                        }
                        dZH().h(eVar2, i);
                        com.facebook.imagepipeline.g.e.e(eVar2);
                        com.facebook.common.internal.b.p(inputStream);
                        dSN.close();
                    } finally {
                        com.facebook.common.references.a.c(e);
                    }
                } catch (Exception e2) {
                    e = e2;
                    inputStream2 = inputStream;
                    try {
                        this.nIn.dZw().a(this.nIn.getId(), "ResizeAndRotateProducer", e, (Map<String, String>) null);
                        if (MQ(i)) {
                            dZH().E(e);
                        }
                        com.facebook.common.internal.b.p(inputStream2);
                        dSN.close();
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        com.facebook.common.internal.b.p(inputStream);
                        dSN.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.facebook.common.internal.b.p(inputStream);
                    dSN.close();
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
            if (!this.nIn.dZw().Vh(this.nIn.getId())) {
                return null;
            }
            String str2 = eVar.getWidth() + "x" + eVar.getHeight();
            if (imageRequest.eap() != null) {
                str = imageRequest.eap().width + "x" + imageRequest.eap().height;
            } else {
                str = "Unspecified";
            }
            String str3 = i > 0 ? i + "/8" : "";
            HashMap hashMap = new HashMap();
            hashMap.put("Original size", str2);
            hashMap.put("Requested size", str);
            hashMap.put("Fraction", str3);
            hashMap.put("queueTime", String.valueOf(this.nIt.dZS()));
            hashMap.put("downsampleEnumerator", Integer.toString(i2));
            hashMap.put("softwareEnumerator", Integer.toString(i3));
            hashMap.put("rotationAngle", Integer.toString(i4));
            return ImmutableMap.copyOf((Map) hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState a(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar, boolean z) {
        if (eVar == null || eVar.dYy() == com.facebook.c.c.nCw) {
            return TriState.UNSET;
        }
        if (eVar.dYy() != com.facebook.c.b.nCm) {
            return TriState.NO;
        }
        return TriState.valueOf(c(imageRequest.eaq(), eVar) || MV(b(imageRequest, eVar, z)));
    }

    static float a(com.facebook.imagepipeline.common.d dVar, int i, int i2) {
        if (dVar == null) {
            return 1.0f;
        }
        float max = Math.max(dVar.width / i, dVar.height / i2);
        if (i * max > dVar.nEG) {
            max = dVar.nEG / i;
        }
        if (i2 * max > dVar.nEG) {
            return dVar.nEG / i2;
        }
        return max;
    }

    static int E(float f, float f2) {
        return (int) ((8.0f * f) + f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar, boolean z) {
        com.facebook.imagepipeline.common.d eap;
        if (z && (eap = imageRequest.eap()) != null) {
            int a2 = a(imageRequest.eaq(), eVar);
            int b = nJE.contains(Integer.valueOf(eVar.dYv())) ? b(imageRequest.eaq(), eVar) : 0;
            boolean z2 = a2 == 90 || a2 == 270 || b == 5 || b == 7;
            int E = E(a(eap, z2 ? eVar.getHeight() : eVar.getWidth(), z2 ? eVar.getWidth() : eVar.getHeight()), eap.nEH);
            if (E > 8) {
                return 8;
            }
            if (E < 1) {
                return 1;
            }
            return E;
        }
        return 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int a(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        if (!eVar.dWA()) {
            return 0;
        }
        int j = j(eVar2);
        return !eVar.dWz() ? (j + eVar.dWB()) % EncoderTextureDrawer.X264_WIDTH : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        int indexOf = nJE.indexOf(Integer.valueOf(eVar2.dYv()));
        if (indexOf < 0) {
            throw new IllegalArgumentException("Only accepts inverted exif orientations");
        }
        int i = 0;
        if (!eVar.dWz()) {
            i = eVar.dWB();
        }
        return nJE.get(((i / 90) + indexOf) % nJE.size()).intValue();
    }

    private static int j(com.facebook.imagepipeline.g.e eVar) {
        switch (eVar.dYu()) {
            case 90:
            case 180:
            case 270:
                return eVar.dYu();
            default:
                return 0;
        }
    }

    private static boolean MV(int i) {
        return i < 8;
    }

    private static boolean c(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        return !eVar.dWC() && (a(eVar, eVar2) != 0 || d(eVar, eVar2));
    }

    private static boolean d(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        if (!eVar.dWA() || eVar.dWC()) {
            eVar2.Mt(0);
            return false;
        }
        return nJE.contains(Integer.valueOf(eVar2.dYv()));
    }

    static int MW(int i) {
        return Math.max(1, 8 / i);
    }
}
