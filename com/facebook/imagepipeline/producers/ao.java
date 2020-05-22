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
    private static final ImmutableList<Integer> mAc = ImmutableList.of((Object[]) new Integer[]{2, 7, 4, 5});
    private final boolean mAd;
    private final Executor mExecutor;
    private final com.facebook.common.memory.g mtR;
    private final boolean mwD;
    private final aj<com.facebook.imagepipeline.g.e> myy;

    public ao(Executor executor, com.facebook.common.memory.g gVar, boolean z, aj<com.facebook.imagepipeline.g.e> ajVar, boolean z2) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.mtR = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.mAd = z;
        this.myy = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.mwD = z2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.myy.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes12.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private boolean dZV;
        private final ak myL;
        private final JobScheduler myR;

        public a(final k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.dZV = false;
            this.myL = akVar;
            this.myR = new JobScheduler(ao.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.ao.a.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.g.e eVar, int i) {
                    a.this.g(eVar, i);
                }
            }, 100);
            this.myL.a(new e() { // from class: com.facebook.imagepipeline.producers.ao.a.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dBq() {
                    if (a.this.myL.dBn()) {
                        a.this.myR.dBB();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dxA() {
                    a.this.myR.dBA();
                    a.this.dZV = true;
                    kVar.dum();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(@Nullable com.facebook.imagepipeline.g.e eVar, int i) {
            if (!this.dZV) {
                boolean Id = Id(i);
                if (eVar != null) {
                    TriState a = ao.a(this.myL.dBi(), eVar, ao.this.mAd);
                    if (Id || a != TriState.UNSET) {
                        if (a != TriState.YES) {
                            if (!this.myL.dBi().dCd().dyp() && eVar.dAh() != 0 && eVar.dAh() != -1) {
                                eVar = k(eVar);
                                eVar.HF(0);
                            }
                            dBu().h(eVar, i);
                        } else if (this.myR.e(eVar, i)) {
                            if (Id || this.myL.dBn()) {
                                this.myR.dBB();
                            }
                        }
                    }
                } else if (Id) {
                    dBu().h(null, 1);
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
            this.myL.dBj().fK(this.myL.getId(), "ResizeAndRotateProducer");
            ImageRequest dBi = this.myL.dBi();
            com.facebook.common.memory.i duy = ao.this.mtR.duy();
            try {
                int b = ao.b(dBi, eVar, ao.this.mAd);
                int a2 = q.a(dBi, eVar);
                int Ij = ao.Ij(a2);
                int i2 = ao.this.mwD ? Ij : b;
                inputStream = eVar.getInputStream();
                try {
                    if (ao.mAc.contains(Integer.valueOf(eVar.dAi()))) {
                        int b2 = ao.b(dBi.dCd(), eVar);
                        a = a(eVar, dBi, i2, Ij, b, 0);
                        JpegTranscoder.b(inputStream, duy, b2, i2, 85);
                    } else {
                        int a3 = ao.a(dBi.dCd(), eVar);
                        a = a(eVar, dBi, i2, Ij, b, a3);
                        JpegTranscoder.a(inputStream, duy, a3, i2, 85);
                    }
                    com.facebook.common.references.a e = com.facebook.common.references.a.e(duy.duz());
                    try {
                        com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(e);
                        eVar2.c(com.facebook.c.b.msL);
                        eVar2.dAn();
                        this.myL.dBj().a(this.myL.getId(), "ResizeAndRotateProducer", a);
                        if (a2 != 1) {
                            i |= 16;
                        }
                        dBu().h(eVar2, i);
                        com.facebook.imagepipeline.g.e.e(eVar2);
                        com.facebook.common.internal.b.p(inputStream);
                        duy.close();
                    } finally {
                        com.facebook.common.references.a.c(e);
                    }
                } catch (Exception e2) {
                    e = e2;
                    inputStream2 = inputStream;
                    try {
                        this.myL.dBj().a(this.myL.getId(), "ResizeAndRotateProducer", e, (Map<String, String>) null);
                        if (Id(i)) {
                            dBu().G(e);
                        }
                        com.facebook.common.internal.b.p(inputStream2);
                        duy.close();
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        com.facebook.common.internal.b.p(inputStream);
                        duy.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.facebook.common.internal.b.p(inputStream);
                    duy.close();
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
            if (!this.myL.dBj().Qc(this.myL.getId())) {
                return null;
            }
            String str2 = eVar.getWidth() + Config.EVENT_HEAT_X + eVar.getHeight();
            if (imageRequest.dCc() != null) {
                str = imageRequest.dCc().width + Config.EVENT_HEAT_X + imageRequest.dCc().height;
            } else {
                str = "Unspecified";
            }
            String str3 = i > 0 ? i + "/8" : "";
            HashMap hashMap = new HashMap();
            hashMap.put("Original size", str2);
            hashMap.put("Requested size", str);
            hashMap.put("Fraction", str3);
            hashMap.put("queueTime", String.valueOf(this.myR.dBF()));
            hashMap.put("downsampleEnumerator", Integer.toString(i2));
            hashMap.put("softwareEnumerator", Integer.toString(i3));
            hashMap.put("rotationAngle", Integer.toString(i4));
            return ImmutableMap.copyOf((Map) hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState a(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar, boolean z) {
        if (eVar == null || eVar.dAl() == com.facebook.c.c.msV) {
            return TriState.UNSET;
        }
        if (eVar.dAl() != com.facebook.c.b.msL) {
            return TriState.NO;
        }
        return TriState.valueOf(c(imageRequest.dCd(), eVar) || Ii(b(imageRequest, eVar, z)));
    }

    static float a(com.facebook.imagepipeline.common.d dVar, int i, int i2) {
        if (dVar == null) {
            return 1.0f;
        }
        float max = Math.max(dVar.width / i, dVar.height / i2);
        if (i * max > dVar.mvg) {
            max = dVar.mvg / i;
        }
        if (i2 * max > dVar.mvg) {
            return dVar.mvg / i2;
        }
        return max;
    }

    static int z(float f, float f2) {
        return (int) ((8.0f * f) + f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar, boolean z) {
        com.facebook.imagepipeline.common.d dCc;
        if (z && (dCc = imageRequest.dCc()) != null) {
            int a2 = a(imageRequest.dCd(), eVar);
            int b = mAc.contains(Integer.valueOf(eVar.dAi())) ? b(imageRequest.dCd(), eVar) : 0;
            boolean z2 = a2 == 90 || a2 == 270 || b == 5 || b == 7;
            int z3 = z(a(dCc, z2 ? eVar.getHeight() : eVar.getWidth(), z2 ? eVar.getWidth() : eVar.getHeight()), dCc.mvh);
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
        if (!eVar.dyn()) {
            return 0;
        }
        int j = j(eVar2);
        return !eVar.dym() ? (j + eVar.dyo()) % 360 : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        int indexOf = mAc.indexOf(Integer.valueOf(eVar2.dAi()));
        if (indexOf < 0) {
            throw new IllegalArgumentException("Only accepts inverted exif orientations");
        }
        int i = 0;
        if (!eVar.dym()) {
            i = eVar.dyo();
        }
        return mAc.get(((i / 90) + indexOf) % mAc.size()).intValue();
    }

    private static int j(com.facebook.imagepipeline.g.e eVar) {
        switch (eVar.dAh()) {
            case 90:
            case 180:
            case 270:
                return eVar.dAh();
            default:
                return 0;
        }
    }

    private static boolean Ii(int i) {
        return i < 8;
    }

    private static boolean c(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        return !eVar.dyp() && (a(eVar, eVar2) != 0 || d(eVar, eVar2));
    }

    private static boolean d(com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.g.e eVar2) {
        if (!eVar.dyn() || eVar.dyp()) {
            eVar2.HG(0);
            return false;
        }
        return mAc.contains(Integer.valueOf(eVar2.dAi()));
    }

    static int Ij(int i) {
        return Math.max(1, 8 / i);
    }
}
