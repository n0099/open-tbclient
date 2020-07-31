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
/* loaded from: classes4.dex */
public class ao implements aj<com.facebook.imagepipeline.g.e> {
    private static final ImmutableList<Integer> nfy = ImmutableList.of((Object[]) new Integer[]{2, 7, 4, 5});
    private final Executor mExecutor;
    private final com.facebook.common.memory.g mZk;
    private final boolean nbY;
    private final aj<com.facebook.imagepipeline.g.e> ndT;
    private final boolean nfz;

    public ao(Executor executor, com.facebook.common.memory.g gVar, boolean z, aj<com.facebook.imagepipeline.g.e> ajVar, boolean z2) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.mZk = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.nfz = z;
        this.ndT = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.nbY = z2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.ndT.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes4.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private boolean eoR;
        private final ak neg;
        private final JobScheduler nem;

        public a(final k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.eoR = false;
            this.neg = akVar;
            this.nem = new JobScheduler(ao.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.ao.a.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.g.e eVar, int i) {
                    a.this.g(eVar, i);
                }
            }, 100);
            this.neg.a(new e() { // from class: com.facebook.imagepipeline.producers.ao.a.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dJw() {
                    if (a.this.neg.dJt()) {
                        a.this.nem.dJH();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dFG() {
                    a.this.nem.dJG();
                    a.this.eoR = true;
                    kVar.dCt();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(@Nullable com.facebook.imagepipeline.g.e eVar, int i) {
            if (!this.eoR) {
                boolean JH = JH(i);
                if (eVar != null) {
                    TriState a = ao.a(this.neg.dJo(), eVar, ao.this.nfz);
                    if (JH || a != TriState.UNSET) {
                        if (a != TriState.YES) {
                            if (!this.neg.dJo().dKj().dGv() && eVar.dIn() != 0 && eVar.dIn() != -1) {
                                eVar = k(eVar);
                                eVar.Jj(0);
                            }
                            dJA().h(eVar, i);
                        } else if (this.nem.e(eVar, i)) {
                            if (JH || this.neg.dJt()) {
                                this.nem.dJH();
                            }
                        }
                    }
                } else if (JH) {
                    dJA().h(null, 1);
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
            this.neg.dJp().fW(this.neg.getId(), "ResizeAndRotateProducer");
            ImageRequest dJo = this.neg.dJo();
            com.facebook.common.memory.i dCF = ao.this.mZk.dCF();
            try {
                int b = ao.b(dJo, eVar, ao.this.nfz);
                int a2 = q.a(dJo, eVar);
                int JN = ao.JN(a2);
                int i2 = ao.this.nbY ? JN : b;
                inputStream = eVar.getInputStream();
                try {
                    if (ao.nfy.contains(Integer.valueOf(eVar.dIo()))) {
                        int b2 = ao.b(dJo.dKj(), eVar);
                        a = a(eVar, dJo, i2, JN, b, 0);
                        JpegTranscoder.b(inputStream, dCF, b2, i2, 85);
                    } else {
                        int a3 = ao.a(dJo.dKj(), eVar);
                        a = a(eVar, dJo, i2, JN, b, a3);
                        JpegTranscoder.a(inputStream, dCF, a3, i2, 85);
                    }
                    com.facebook.common.references.a e = com.facebook.common.references.a.e(dCF.dCG());
                    try {
                        com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(e);
                        eVar2.c(com.facebook.c.b.mYf);
                        eVar2.dIt();
                        this.neg.dJp().a(this.neg.getId(), "ResizeAndRotateProducer", a);
                        if (a2 != 1) {
                            i |= 16;
                        }
                        dJA().h(eVar2, i);
                        com.facebook.imagepipeline.g.e.e(eVar2);
                        com.facebook.common.internal.b.o(inputStream);
                        dCF.close();
                    } finally {
                        com.facebook.common.references.a.c(e);
                    }
                } catch (Exception e2) {
                    e = e2;
                    inputStream2 = inputStream;
                    try {
                        this.neg.dJp().a(this.neg.getId(), "ResizeAndRotateProducer", e, (Map<String, String>) null);
                        if (JH(i)) {
                            dJA().F(e);
                        }
                        com.facebook.common.internal.b.o(inputStream2);
                        dCF.close();
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        com.facebook.common.internal.b.o(inputStream);
                        dCF.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.facebook.common.internal.b.o(inputStream);
                    dCF.close();
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
            if (!this.neg.dJp().RB(this.neg.getId())) {
                return null;
            }
            String str2 = eVar.getWidth() + Config.EVENT_HEAT_X + eVar.getHeight();
            if (imageRequest.dKi() != null) {
                str = imageRequest.dKi().width + Config.EVENT_HEAT_X + imageRequest.dKi().height;
            } else {
                str = "Unspecified";
            }
            String str3 = i > 0 ? i + "/8" : "";
            HashMap hashMap = new HashMap();
            hashMap.put("Original size", str2);
            hashMap.put("Requested size", str);
            hashMap.put("Fraction", str3);
            hashMap.put("queueTime", String.valueOf(this.nem.dJL()));
            hashMap.put("downsampleEnumerator", Integer.toString(i2));
            hashMap.put("softwareEnumerator", Integer.toString(i3));
            hashMap.put("rotationAngle", Integer.toString(i4));
            return ImmutableMap.copyOf((Map) hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState a(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar, boolean z) {
        if (eVar == null || eVar.dIr() == com.facebook.c.c.mYp) {
            return TriState.UNSET;
        }
        if (eVar.dIr() != com.facebook.c.b.mYf) {
            return TriState.NO;
        }
        return TriState.valueOf(c(imageRequest.dKj(), eVar) || JM(b(imageRequest, eVar, z)));
    }

    static float a(com.facebook.imagepipeline.common.d dVar, int i, int i2) {
        if (dVar == null) {
            return 1.0f;
        }
        float max = Math.max(dVar.width / i, dVar.height / i2);
        if (i * max > dVar.naz) {
            max = dVar.naz / i;
        }
        if (i2 * max > dVar.naz) {
            return dVar.naz / i2;
        }
        return max;
    }

    static int z(float f, float f2) {
        return (int) ((8.0f * f) + f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar, boolean z) {
        com.facebook.imagepipeline.common.d dKi;
        if (z && (dKi = imageRequest.dKi()) != null) {
            int a2 = a(imageRequest.dKj(), eVar);
            int b = nfy.contains(Integer.valueOf(eVar.dIo())) ? b(imageRequest.dKj(), eVar) : 0;
            boolean z2 = a2 == 90 || a2 == 270 || b == 5 || b == 7;
            int z3 = z(a(dKi, z2 ? eVar.getHeight() : eVar.getWidth(), z2 ? eVar.getWidth() : eVar.getHeight()), dKi.naA);
            if (z3 > 8) {
                return 8;
            }
            if (z3 < 1) {
                return 1;
            }
            return z3;
        }
        return 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int a(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        if (!eVar.dGt()) {
            return 0;
        }
        int j = j(eVar2);
        return !eVar.dGs() ? (j + eVar.dGu()) % 360 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        int indexOf = nfy.indexOf(Integer.valueOf(eVar2.dIo()));
        if (indexOf < 0) {
            throw new IllegalArgumentException("Only accepts inverted exif orientations");
        }
        int i = 0;
        if (!eVar.dGs()) {
            i = eVar.dGu();
        }
        return nfy.get(((i / 90) + indexOf) % nfy.size()).intValue();
    }

    private static int j(com.facebook.imagepipeline.g.e eVar) {
        switch (eVar.dIn()) {
            case 90:
            case 180:
            case 270:
                return eVar.dIn();
            default:
                return 0;
        }
    }

    private static boolean JM(int i) {
        return i < 8;
    }

    private static boolean c(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        return !eVar.dGv() && (a(eVar, eVar2) != 0 || d(eVar, eVar2));
    }

    private static boolean d(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        if (!eVar.dGt() || eVar.dGv()) {
            eVar2.Jk(0);
            return false;
        }
        return nfy.contains(Integer.valueOf(eVar2.dIo()));
    }

    static int JN(int i) {
        return Math.max(1, 8 / i);
    }
}
