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
    private final com.facebook.common.memory.g jFp;
    private final boolean jIh;
    private final ai<com.facebook.imagepipeline.f.d> jJQ;
    private final boolean jLu;
    private final Executor mExecutor;

    public am(Executor executor, com.facebook.common.memory.g gVar, boolean z, ai<com.facebook.imagepipeline.f.d> aiVar, boolean z2) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.jFp = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.jLu = z;
        this.jJQ = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.jIh = z2;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.jJQ.a(new a(jVar, ajVar), ajVar);
    }

    /* loaded from: classes2.dex */
    private class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private boolean bVD;
        private final aj jKb;
        private final JobScheduler jKh;

        public a(final j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
            super(jVar);
            this.bVD = false;
            this.jKb = ajVar;
            this.jKh = new JobScheduler(am.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.am.a.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
                    a.this.g(dVar, z);
                }
            }, 100);
            this.jKb.a(new e() { // from class: com.facebook.imagepipeline.producers.am.a.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void czQ() {
                    if (a.this.jKb.czM()) {
                        a.this.jKh.czY();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void czO() {
                    a.this.jKh.czX();
                    a.this.bVD = true;
                    jVar.ctI();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(@Nullable com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (!this.bVD) {
                if (dVar != null) {
                    TriState a = am.a(this.jKb.czH(), dVar, am.this.jLu);
                    if (z || a != TriState.UNSET) {
                        if (a != TriState.YES) {
                            czU().e(dVar, z);
                        } else if (this.jKh.e(dVar, z)) {
                            if (z || this.jKb.czM()) {
                                this.jKh.czY();
                            }
                        }
                    }
                } else if (z) {
                    czU().e(null, true);
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
            al czI = this.jKb.czI();
            ?? id = this.jKb.getId();
            czI.el(id, "ResizeAndRotateProducer");
            ImageRequest czH = this.jKb.czH();
            com.facebook.common.memory.i ctR = am.this.jFp.ctR();
            try {
                try {
                    try {
                        int b = am.b(czH, dVar, am.this.jLu);
                        int CP = am.CP(p.b(czH, dVar));
                        int i = am.this.jIh ? CP : b;
                        int a = am.a(czH.cAy(), dVar);
                        Map<String, String> a2 = a(dVar, czH, i, CP, b, a);
                        try {
                            inputStream = dVar.getInputStream();
                            try {
                                JpegTranscoder.a(inputStream, ctR, a, i, 85);
                                com.facebook.common.references.a d = com.facebook.common.references.a.d(ctR.ctS());
                                try {
                                    com.facebook.imagepipeline.f.d dVar2 = new com.facebook.imagepipeline.f.d(d);
                                    dVar2.c(com.facebook.c.b.jEV);
                                    dVar2.cyS();
                                    this.jKb.czI().a(this.jKb.getId(), "ResizeAndRotateProducer", a2);
                                    czU().e(dVar2, z);
                                    com.facebook.imagepipeline.f.d.e(dVar2);
                                    com.facebook.common.internal.b.q(inputStream);
                                    ctR.close();
                                } finally {
                                    com.facebook.common.references.a.c(d);
                                }
                            } catch (Exception e) {
                                e = e;
                                map = a2;
                                this.jKb.czI().a(this.jKb.getId(), "ResizeAndRotateProducer", e, map);
                                czU().C(e);
                                com.facebook.common.internal.b.q(inputStream);
                                ctR.close();
                            }
                        } catch (Exception e2) {
                            e = e2;
                            inputStream = null;
                            map = a2;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.facebook.common.internal.b.q(id);
                        ctR.close();
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
                ctR.close();
                throw th;
            }
        }

        private Map<String, String> a(com.facebook.imagepipeline.f.d dVar, ImageRequest imageRequest, int i, int i2, int i3, int i4) {
            String str;
            if (!this.jKb.czI().FI(this.jKb.getId())) {
                return null;
            }
            String str2 = dVar.getWidth() + Config.EVENT_HEAT_X + dVar.getHeight();
            if (imageRequest.cAx() != null) {
                str = imageRequest.cAx().width + Config.EVENT_HEAT_X + imageRequest.cAx().height;
            } else {
                str = "Unspecified";
            }
            String str3 = i > 0 ? i + "/8" : "";
            HashMap hashMap = new HashMap();
            hashMap.put("Original size", str2);
            hashMap.put("Requested size", str);
            hashMap.put("Fraction", str3);
            hashMap.put("queueTime", String.valueOf(this.jKh.cAc()));
            hashMap.put("downsampleEnumerator", Integer.toString(i2));
            hashMap.put("softwareEnumerator", Integer.toString(i3));
            hashMap.put("rotationAngle", Integer.toString(i4));
            return ImmutableMap.copyOf((Map) hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState a(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar, boolean z) {
        if (dVar == null || dVar.cyQ() == com.facebook.c.c.jFe) {
            return TriState.UNSET;
        }
        if (dVar.cyQ() != com.facebook.c.b.jEV) {
            return TriState.NO;
        }
        return TriState.valueOf(b(imageRequest.cAy(), dVar) || CO(b(imageRequest, dVar, z)));
    }

    static float a(com.facebook.imagepipeline.common.c cVar, int i, int i2) {
        if (cVar == null) {
            return 1.0f;
        }
        float max = Math.max(cVar.width / i, cVar.height / i2);
        if (i * max > cVar.jGQ) {
            max = cVar.jGQ / i;
        }
        if (i2 * max > cVar.jGQ) {
            return cVar.jGQ / i2;
        }
        return max;
    }

    static int D(float f, float f2) {
        return (int) ((8.0f * f) + f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar, boolean z) {
        com.facebook.imagepipeline.common.c cAx;
        if (z && (cAx = imageRequest.cAx()) != null) {
            int a2 = a(imageRequest.cAy(), dVar);
            boolean z2 = a2 == 90 || a2 == 270;
            int D = D(a(cAx, z2 ? dVar.getHeight() : dVar.getWidth(), z2 ? dVar.getWidth() : dVar.getHeight()), cAx.jGR);
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
        if (!dVar.cxc()) {
            return 0;
        }
        int k = k(dVar2);
        return !dVar.cxb() ? (k + dVar.cxd()) % 360 : k;
    }

    private static int k(com.facebook.imagepipeline.f.d dVar) {
        switch (dVar.cyN()) {
            case 90:
            case SubsamplingScaleImageView.ORIENTATION_180 /* 180 */:
            case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                return dVar.cyN();
            default:
                return 0;
        }
    }

    private static boolean CO(int i) {
        return i < 8;
    }

    private static boolean b(com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.f.d dVar2) {
        return (dVar.cxe() || a(dVar, dVar2) == 0) ? false : true;
    }

    static int CP(int i) {
        return Math.max(1, 8 / i);
    }
}
