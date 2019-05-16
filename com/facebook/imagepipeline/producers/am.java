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
    private final com.facebook.common.memory.g jXx;
    private final boolean kap;
    private final ai<com.facebook.imagepipeline.f.d> kbY;
    private final boolean kdC;
    private final Executor mExecutor;

    public am(Executor executor, com.facebook.common.memory.g gVar, boolean z, ai<com.facebook.imagepipeline.f.d> aiVar, boolean z2) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.jXx = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.kdC = z;
        this.kbY = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.kap = z2;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.kbY.a(new a(jVar, ajVar), ajVar);
    }

    /* loaded from: classes2.dex */
    private class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private boolean cdB;
        private final aj kcj;
        private final JobScheduler kcp;

        public a(final j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
            super(jVar);
            this.cdB = false;
            this.kcj = ajVar;
            this.kcp = new JobScheduler(am.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.am.a.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
                    a.this.g(dVar, z);
                }
            }, 100);
            this.kcj.a(new e() { // from class: com.facebook.imagepipeline.producers.am.a.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cHF() {
                    if (a.this.kcj.cHB()) {
                        a.this.kcp.cHN();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cHD() {
                    a.this.kcp.cHM();
                    a.this.cdB = true;
                    jVar.cBy();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(@Nullable com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (!this.cdB) {
                if (dVar != null) {
                    TriState a = am.a(this.kcj.cHw(), dVar, am.this.kdC);
                    if (z || a != TriState.UNSET) {
                        if (a != TriState.YES) {
                            cHJ().e(dVar, z);
                        } else if (this.kcp.e(dVar, z)) {
                            if (z || this.kcj.cHB()) {
                                this.kcp.cHN();
                            }
                        }
                    }
                } else if (z) {
                    cHJ().e(null, true);
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
            al cHx = this.kcj.cHx();
            ?? id = this.kcj.getId();
            cHx.ez(id, "ResizeAndRotateProducer");
            ImageRequest cHw = this.kcj.cHw();
            com.facebook.common.memory.i cBH = am.this.jXx.cBH();
            try {
                try {
                    try {
                        int b = am.b(cHw, dVar, am.this.kdC);
                        int DJ = am.DJ(p.b(cHw, dVar));
                        int i = am.this.kap ? DJ : b;
                        int a = am.a(cHw.cIn(), dVar);
                        Map<String, String> a2 = a(dVar, cHw, i, DJ, b, a);
                        try {
                            inputStream = dVar.getInputStream();
                            try {
                                JpegTranscoder.a(inputStream, cBH, a, i, 85);
                                com.facebook.common.references.a d = com.facebook.common.references.a.d(cBH.cBI());
                                try {
                                    com.facebook.imagepipeline.f.d dVar2 = new com.facebook.imagepipeline.f.d(d);
                                    dVar2.c(com.facebook.c.b.jXd);
                                    dVar2.cGH();
                                    this.kcj.cHx().a(this.kcj.getId(), "ResizeAndRotateProducer", a2);
                                    cHJ().e(dVar2, z);
                                    com.facebook.imagepipeline.f.d.e(dVar2);
                                    com.facebook.common.internal.b.q(inputStream);
                                    cBH.close();
                                } finally {
                                    com.facebook.common.references.a.c(d);
                                }
                            } catch (Exception e) {
                                e = e;
                                map = a2;
                                this.kcj.cHx().a(this.kcj.getId(), "ResizeAndRotateProducer", e, map);
                                cHJ().B(e);
                                com.facebook.common.internal.b.q(inputStream);
                                cBH.close();
                            }
                        } catch (Exception e2) {
                            e = e2;
                            inputStream = null;
                            map = a2;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.facebook.common.internal.b.q(id);
                        cBH.close();
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
                cBH.close();
                throw th;
            }
        }

        private Map<String, String> a(com.facebook.imagepipeline.f.d dVar, ImageRequest imageRequest, int i, int i2, int i3, int i4) {
            String str;
            if (!this.kcj.cHx().GT(this.kcj.getId())) {
                return null;
            }
            String str2 = dVar.getWidth() + Config.EVENT_HEAT_X + dVar.getHeight();
            if (imageRequest.cIm() != null) {
                str = imageRequest.cIm().width + Config.EVENT_HEAT_X + imageRequest.cIm().height;
            } else {
                str = "Unspecified";
            }
            String str3 = i > 0 ? i + "/8" : "";
            HashMap hashMap = new HashMap();
            hashMap.put("Original size", str2);
            hashMap.put("Requested size", str);
            hashMap.put("Fraction", str3);
            hashMap.put("queueTime", String.valueOf(this.kcp.cHR()));
            hashMap.put("downsampleEnumerator", Integer.toString(i2));
            hashMap.put("softwareEnumerator", Integer.toString(i3));
            hashMap.put("rotationAngle", Integer.toString(i4));
            return ImmutableMap.copyOf((Map) hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState a(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar, boolean z) {
        if (dVar == null || dVar.cGF() == com.facebook.c.c.jXm) {
            return TriState.UNSET;
        }
        if (dVar.cGF() != com.facebook.c.b.jXd) {
            return TriState.NO;
        }
        return TriState.valueOf(b(imageRequest.cIn(), dVar) || DI(b(imageRequest, dVar, z)));
    }

    static float a(com.facebook.imagepipeline.common.c cVar, int i, int i2) {
        if (cVar == null) {
            return 1.0f;
        }
        float max = Math.max(cVar.width / i, cVar.height / i2);
        if (i * max > cVar.jYY) {
            max = cVar.jYY / i;
        }
        if (i2 * max > cVar.jYY) {
            return cVar.jYY / i2;
        }
        return max;
    }

    static int D(float f, float f2) {
        return (int) ((8.0f * f) + f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar, boolean z) {
        com.facebook.imagepipeline.common.c cIm;
        if (z && (cIm = imageRequest.cIm()) != null) {
            int a2 = a(imageRequest.cIn(), dVar);
            boolean z2 = a2 == 90 || a2 == 270;
            int D = D(a(cIm, z2 ? dVar.getHeight() : dVar.getWidth(), z2 ? dVar.getWidth() : dVar.getHeight()), cIm.jYZ);
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
        if (!dVar.cER()) {
            return 0;
        }
        int k = k(dVar2);
        return !dVar.cEQ() ? (k + dVar.cES()) % 360 : k;
    }

    private static int k(com.facebook.imagepipeline.f.d dVar) {
        switch (dVar.cGC()) {
            case 90:
            case SubsamplingScaleImageView.ORIENTATION_180 /* 180 */:
            case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                return dVar.cGC();
            default:
                return 0;
        }
    }

    private static boolean DI(int i) {
        return i < 8;
    }

    private static boolean b(com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.f.d dVar2) {
        return (dVar.cET() || a(dVar, dVar2) == 0) ? false : true;
    }

    static int DJ(int i) {
        return Math.max(1, 8 / i);
    }
}
