package com.facebook.imagepipeline.producers;

import com.baidu.mobstat.Config;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
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
/* loaded from: classes2.dex */
public class am implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.common.memory.g keG;
    private final boolean khz;
    private final ai<com.facebook.imagepipeline.f.d> kjj;
    private final boolean kkN;
    private final Executor mExecutor;

    public am(Executor executor, com.facebook.common.memory.g gVar, boolean z, ai<com.facebook.imagepipeline.f.d> aiVar, boolean z2) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.keG = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.kkN = z;
        this.kjj = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.khz = z2;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.kjj.a(new a(jVar, ajVar), ajVar);
    }

    /* loaded from: classes2.dex */
    private class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private boolean ceF;
        private final JobScheduler kjA;
        private final aj kju;

        public a(final j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
            super(jVar);
            this.ceF = false;
            this.kju = ajVar;
            this.kjA = new JobScheduler(am.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.am.a.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
                    a.this.g(dVar, z);
                }
            }, 100);
            this.kju.a(new e() { // from class: com.facebook.imagepipeline.producers.am.a.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cKK() {
                    if (a.this.kju.cKG()) {
                        a.this.kjA.cKS();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cKI() {
                    a.this.kjA.cKR();
                    a.this.ceF = true;
                    jVar.cEA();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(@Nullable com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (!this.ceF) {
                if (dVar != null) {
                    TriState a = am.a(this.kju.cKB(), dVar, am.this.kkN);
                    if (z || a != TriState.UNSET) {
                        if (a != TriState.YES) {
                            cKO().e(dVar, z);
                        } else if (this.kjA.e(dVar, z)) {
                            if (z || this.kju.cKG()) {
                                this.kjA.cKS();
                            }
                        }
                    }
                } else if (z) {
                    cKO().e(null, true);
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [213=4] */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x00c7 */
        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v4, types: [java.io.InputStream] */
        public void g(com.facebook.imagepipeline.f.d dVar, boolean z) {
            InputStream inputStream;
            Map<String, String> map = null;
            al cKC = this.kju.cKC();
            ?? id = this.kju.getId();
            cKC.eA(id, "ResizeAndRotateProducer");
            ImageRequest cKB = this.kju.cKB();
            com.facebook.common.memory.i cEJ = am.this.keG.cEJ();
            try {
                try {
                    try {
                        int b = am.b(cKB, dVar, am.this.kkN);
                        int Eq = am.Eq(p.b(cKB, dVar));
                        int i = am.this.khz ? Eq : b;
                        int a = am.a(cKB.cLs(), dVar);
                        Map<String, String> a2 = a(dVar, cKB, i, Eq, b, a);
                        try {
                            inputStream = dVar.getInputStream();
                            try {
                                JpegTranscoder.a(inputStream, cEJ, a, i, 85);
                                com.facebook.common.references.a d = com.facebook.common.references.a.d(cEJ.cEK());
                                try {
                                    com.facebook.imagepipeline.f.d dVar2 = new com.facebook.imagepipeline.f.d(d);
                                    dVar2.c(com.facebook.c.b.kel);
                                    dVar2.cJL();
                                    this.kju.cKC().a(this.kju.getId(), "ResizeAndRotateProducer", a2);
                                    cKO().e(dVar2, z);
                                    com.facebook.imagepipeline.f.d.e(dVar2);
                                    com.facebook.common.internal.b.q(inputStream);
                                    cEJ.close();
                                } finally {
                                    com.facebook.common.references.a.c(d);
                                }
                            } catch (Exception e) {
                                e = e;
                                map = a2;
                                this.kju.cKC().a(this.kju.getId(), "ResizeAndRotateProducer", e, map);
                                cKO().B(e);
                                com.facebook.common.internal.b.q(inputStream);
                                cEJ.close();
                            }
                        } catch (Exception e2) {
                            e = e2;
                            inputStream = null;
                            map = a2;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.facebook.common.internal.b.q(id);
                        cEJ.close();
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    inputStream = null;
                }
            } catch (Throwable th2) {
                th = th2;
                id = 0;
                com.facebook.common.internal.b.q(id);
                cEJ.close();
                throw th;
            }
        }

        private Map<String, String> a(com.facebook.imagepipeline.f.d dVar, ImageRequest imageRequest, int i, int i2, int i3, int i4) {
            String str;
            if (!this.kju.cKC().HP(this.kju.getId())) {
                return null;
            }
            String str2 = dVar.getWidth() + Config.EVENT_HEAT_X + dVar.getHeight();
            if (imageRequest.cLr() != null) {
                str = imageRequest.cLr().width + Config.EVENT_HEAT_X + imageRequest.cLr().height;
            } else {
                str = "Unspecified";
            }
            String str3 = i > 0 ? i + "/8" : "";
            HashMap hashMap = new HashMap();
            hashMap.put("Original size", str2);
            hashMap.put("Requested size", str);
            hashMap.put("Fraction", str3);
            hashMap.put("queueTime", String.valueOf(this.kjA.cKW()));
            hashMap.put("downsampleEnumerator", Integer.toString(i2));
            hashMap.put("softwareEnumerator", Integer.toString(i3));
            hashMap.put("rotationAngle", Integer.toString(i4));
            return ImmutableMap.copyOf((Map) hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState a(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar, boolean z) {
        if (dVar == null || dVar.cJJ() == com.facebook.c.c.keu) {
            return TriState.UNSET;
        }
        if (dVar.cJJ() != com.facebook.c.b.kel) {
            return TriState.NO;
        }
        return TriState.valueOf(b(imageRequest.cLs(), dVar) || Ep(b(imageRequest, dVar, z)));
    }

    static float a(com.facebook.imagepipeline.common.c cVar, int i, int i2) {
        if (cVar == null) {
            return 1.0f;
        }
        float max = Math.max(cVar.width / i, cVar.height / i2);
        if (i * max > cVar.kgi) {
            max = cVar.kgi / i;
        }
        if (i2 * max > cVar.kgi) {
            return cVar.kgi / i2;
        }
        return max;
    }

    static int F(float f, float f2) {
        return (int) ((8.0f * f) + f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar, boolean z) {
        com.facebook.imagepipeline.common.c cLr;
        if (z && (cLr = imageRequest.cLr()) != null) {
            int a2 = a(imageRequest.cLs(), dVar);
            boolean z2 = a2 == 90 || a2 == 270;
            int F = F(a(cLr, z2 ? dVar.getHeight() : dVar.getWidth(), z2 ? dVar.getWidth() : dVar.getHeight()), cLr.kgj);
            if (F > 8) {
                return 8;
            }
            if (F < 1) {
                return 1;
            }
            return F;
        }
        return 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int a(com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.f.d dVar2) {
        if (!dVar.cHV()) {
            return 0;
        }
        int k = k(dVar2);
        return !dVar.cHU() ? (k + dVar.cHW()) % 360 : k;
    }

    private static int k(com.facebook.imagepipeline.f.d dVar) {
        switch (dVar.cJG()) {
            case 90:
            case SubsamplingScaleImageView.ORIENTATION_180 /* 180 */:
            case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                return dVar.cJG();
            default:
                return 0;
        }
    }

    private static boolean Ep(int i) {
        return i < 8;
    }

    private static boolean b(com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.f.d dVar2) {
        return (dVar.cHX() || a(dVar, dVar2) == 0) ? false : true;
    }

    static int Eq(int i) {
        return Math.max(1, 8 / i);
    }
}
