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
    private final com.facebook.common.memory.g jXB;
    private final boolean kat;
    private final ai<com.facebook.imagepipeline.f.d> kcc;
    private final boolean kdG;
    private final Executor mExecutor;

    public am(Executor executor, com.facebook.common.memory.g gVar, boolean z, ai<com.facebook.imagepipeline.f.d> aiVar, boolean z2) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.jXB = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.kdG = z;
        this.kcc = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.kat = z2;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.kcc.a(new a(jVar, ajVar), ajVar);
    }

    /* loaded from: classes2.dex */
    private class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private boolean cdC;
        private final aj kcn;
        private final JobScheduler kct;

        public a(final j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
            super(jVar);
            this.cdC = false;
            this.kcn = ajVar;
            this.kct = new JobScheduler(am.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.am.a.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
                    a.this.g(dVar, z);
                }
            }, 100);
            this.kcn.a(new e() { // from class: com.facebook.imagepipeline.producers.am.a.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cHG() {
                    if (a.this.kcn.cHC()) {
                        a.this.kct.cHO();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cHE() {
                    a.this.kct.cHN();
                    a.this.cdC = true;
                    jVar.cBz();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(@Nullable com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (!this.cdC) {
                if (dVar != null) {
                    TriState a = am.a(this.kcn.cHx(), dVar, am.this.kdG);
                    if (z || a != TriState.UNSET) {
                        if (a != TriState.YES) {
                            cHK().e(dVar, z);
                        } else if (this.kct.e(dVar, z)) {
                            if (z || this.kcn.cHC()) {
                                this.kct.cHO();
                            }
                        }
                    }
                } else if (z) {
                    cHK().e(null, true);
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
            al cHy = this.kcn.cHy();
            ?? id = this.kcn.getId();
            cHy.ez(id, "ResizeAndRotateProducer");
            ImageRequest cHx = this.kcn.cHx();
            com.facebook.common.memory.i cBI = am.this.jXB.cBI();
            try {
                try {
                    try {
                        int b = am.b(cHx, dVar, am.this.kdG);
                        int DJ = am.DJ(p.b(cHx, dVar));
                        int i = am.this.kat ? DJ : b;
                        int a = am.a(cHx.cIo(), dVar);
                        Map<String, String> a2 = a(dVar, cHx, i, DJ, b, a);
                        try {
                            inputStream = dVar.getInputStream();
                            try {
                                JpegTranscoder.a(inputStream, cBI, a, i, 85);
                                com.facebook.common.references.a d = com.facebook.common.references.a.d(cBI.cBJ());
                                try {
                                    com.facebook.imagepipeline.f.d dVar2 = new com.facebook.imagepipeline.f.d(d);
                                    dVar2.c(com.facebook.c.b.jXh);
                                    dVar2.cGI();
                                    this.kcn.cHy().a(this.kcn.getId(), "ResizeAndRotateProducer", a2);
                                    cHK().e(dVar2, z);
                                    com.facebook.imagepipeline.f.d.e(dVar2);
                                    com.facebook.common.internal.b.q(inputStream);
                                    cBI.close();
                                } finally {
                                    com.facebook.common.references.a.c(d);
                                }
                            } catch (Exception e) {
                                e = e;
                                map = a2;
                                this.kcn.cHy().a(this.kcn.getId(), "ResizeAndRotateProducer", e, map);
                                cHK().B(e);
                                com.facebook.common.internal.b.q(inputStream);
                                cBI.close();
                            }
                        } catch (Exception e2) {
                            e = e2;
                            inputStream = null;
                            map = a2;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.facebook.common.internal.b.q(id);
                        cBI.close();
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
                cBI.close();
                throw th;
            }
        }

        private Map<String, String> a(com.facebook.imagepipeline.f.d dVar, ImageRequest imageRequest, int i, int i2, int i3, int i4) {
            String str;
            if (!this.kcn.cHy().GV(this.kcn.getId())) {
                return null;
            }
            String str2 = dVar.getWidth() + Config.EVENT_HEAT_X + dVar.getHeight();
            if (imageRequest.cIn() != null) {
                str = imageRequest.cIn().width + Config.EVENT_HEAT_X + imageRequest.cIn().height;
            } else {
                str = "Unspecified";
            }
            String str3 = i > 0 ? i + "/8" : "";
            HashMap hashMap = new HashMap();
            hashMap.put("Original size", str2);
            hashMap.put("Requested size", str);
            hashMap.put("Fraction", str3);
            hashMap.put("queueTime", String.valueOf(this.kct.cHS()));
            hashMap.put("downsampleEnumerator", Integer.toString(i2));
            hashMap.put("softwareEnumerator", Integer.toString(i3));
            hashMap.put("rotationAngle", Integer.toString(i4));
            return ImmutableMap.copyOf((Map) hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState a(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar, boolean z) {
        if (dVar == null || dVar.cGG() == com.facebook.c.c.jXq) {
            return TriState.UNSET;
        }
        if (dVar.cGG() != com.facebook.c.b.jXh) {
            return TriState.NO;
        }
        return TriState.valueOf(b(imageRequest.cIo(), dVar) || DI(b(imageRequest, dVar, z)));
    }

    static float a(com.facebook.imagepipeline.common.c cVar, int i, int i2) {
        if (cVar == null) {
            return 1.0f;
        }
        float max = Math.max(cVar.width / i, cVar.height / i2);
        if (i * max > cVar.jZc) {
            max = cVar.jZc / i;
        }
        if (i2 * max > cVar.jZc) {
            return cVar.jZc / i2;
        }
        return max;
    }

    static int D(float f, float f2) {
        return (int) ((8.0f * f) + f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar, boolean z) {
        com.facebook.imagepipeline.common.c cIn;
        if (z && (cIn = imageRequest.cIn()) != null) {
            int a2 = a(imageRequest.cIo(), dVar);
            boolean z2 = a2 == 90 || a2 == 270;
            int D = D(a(cIn, z2 ? dVar.getHeight() : dVar.getWidth(), z2 ? dVar.getWidth() : dVar.getHeight()), cIn.jZd);
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
    public static int a(com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.f.d dVar2) {
        if (!dVar.cES()) {
            return 0;
        }
        int k = k(dVar2);
        return !dVar.cER() ? (k + dVar.cET()) % 360 : k;
    }

    private static int k(com.facebook.imagepipeline.f.d dVar) {
        switch (dVar.cGD()) {
            case 90:
            case SubsamplingScaleImageView.ORIENTATION_180 /* 180 */:
            case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                return dVar.cGD();
            default:
                return 0;
        }
    }

    private static boolean DI(int i) {
        return i < 8;
    }

    private static boolean b(com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.f.d dVar2) {
        return (dVar.cEU() || a(dVar, dVar2) == 0) ? false : true;
    }

    static int DJ(int i) {
        return Math.max(1, 8 / i);
    }
}
