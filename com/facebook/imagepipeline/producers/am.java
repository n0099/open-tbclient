package com.facebook.imagepipeline.producers;

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
    private final com.facebook.common.memory.g jFe;
    private final boolean jHW;
    private final ai<com.facebook.imagepipeline.f.d> jJF;
    private final boolean jLj;
    private final Executor mExecutor;

    public am(Executor executor, com.facebook.common.memory.g gVar, boolean z, ai<com.facebook.imagepipeline.f.d> aiVar, boolean z2) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.jFe = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.jLj = z;
        this.jJF = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.jHW = z2;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.jJF.a(new a(jVar, ajVar), ajVar);
    }

    /* loaded from: classes2.dex */
    private class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private boolean bVC;
        private final aj jJQ;
        private final JobScheduler jJW;

        public a(final j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
            super(jVar);
            this.bVC = false;
            this.jJQ = ajVar;
            this.jJW = new JobScheduler(am.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.am.a.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
                    a.this.g(dVar, z);
                }
            }, 100);
            this.jJQ.a(new e() { // from class: com.facebook.imagepipeline.producers.am.a.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void czD() {
                    if (a.this.jJQ.czz()) {
                        a.this.jJW.czL();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void czB() {
                    a.this.jJW.czK();
                    a.this.bVC = true;
                    jVar.ctv();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(@Nullable com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (!this.bVC) {
                if (dVar != null) {
                    TriState a = am.a(this.jJQ.czu(), dVar, am.this.jLj);
                    if (z || a != TriState.UNSET) {
                        if (a != TriState.YES) {
                            czH().e(dVar, z);
                        } else if (this.jJW.e(dVar, z)) {
                            if (z || this.jJQ.czz()) {
                                this.jJW.czL();
                            }
                        }
                    }
                } else if (z) {
                    czH().e(null, true);
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
            al czv = this.jJQ.czv();
            ?? id = this.jJQ.getId();
            czv.em(id, "ResizeAndRotateProducer");
            ImageRequest czu = this.jJQ.czu();
            com.facebook.common.memory.i ctE = am.this.jFe.ctE();
            try {
                try {
                    try {
                        int b = am.b(czu, dVar, am.this.jLj);
                        int CO = am.CO(p.b(czu, dVar));
                        int i = am.this.jHW ? CO : b;
                        int a = am.a(czu.cAl(), dVar);
                        Map<String, String> a2 = a(dVar, czu, i, CO, b, a);
                        try {
                            inputStream = dVar.getInputStream();
                            try {
                                JpegTranscoder.a(inputStream, ctE, a, i, 85);
                                com.facebook.common.references.a d = com.facebook.common.references.a.d(ctE.ctF());
                                try {
                                    com.facebook.imagepipeline.f.d dVar2 = new com.facebook.imagepipeline.f.d(d);
                                    dVar2.c(com.facebook.c.b.jEK);
                                    dVar2.cyF();
                                    this.jJQ.czv().a(this.jJQ.getId(), "ResizeAndRotateProducer", a2);
                                    czH().e(dVar2, z);
                                    com.facebook.imagepipeline.f.d.e(dVar2);
                                    com.facebook.common.internal.b.q(inputStream);
                                    ctE.close();
                                } finally {
                                    com.facebook.common.references.a.c(d);
                                }
                            } catch (Exception e) {
                                e = e;
                                map = a2;
                                this.jJQ.czv().a(this.jJQ.getId(), "ResizeAndRotateProducer", e, map);
                                czH().C(e);
                                com.facebook.common.internal.b.q(inputStream);
                                ctE.close();
                            }
                        } catch (Exception e2) {
                            e = e2;
                            inputStream = null;
                            map = a2;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.facebook.common.internal.b.q(id);
                        ctE.close();
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
                ctE.close();
                throw th;
            }
        }

        private Map<String, String> a(com.facebook.imagepipeline.f.d dVar, ImageRequest imageRequest, int i, int i2, int i3, int i4) {
            String str;
            if (!this.jJQ.czv().FH(this.jJQ.getId())) {
                return null;
            }
            String str2 = dVar.getWidth() + "x" + dVar.getHeight();
            if (imageRequest.cAk() != null) {
                str = imageRequest.cAk().width + "x" + imageRequest.cAk().height;
            } else {
                str = "Unspecified";
            }
            String str3 = i > 0 ? i + "/8" : "";
            HashMap hashMap = new HashMap();
            hashMap.put("Original size", str2);
            hashMap.put("Requested size", str);
            hashMap.put("Fraction", str3);
            hashMap.put("queueTime", String.valueOf(this.jJW.czP()));
            hashMap.put("downsampleEnumerator", Integer.toString(i2));
            hashMap.put("softwareEnumerator", Integer.toString(i3));
            hashMap.put("rotationAngle", Integer.toString(i4));
            return ImmutableMap.copyOf((Map) hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState a(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar, boolean z) {
        if (dVar == null || dVar.cyD() == com.facebook.c.c.jET) {
            return TriState.UNSET;
        }
        if (dVar.cyD() != com.facebook.c.b.jEK) {
            return TriState.NO;
        }
        return TriState.valueOf(b(imageRequest.cAl(), dVar) || CN(b(imageRequest, dVar, z)));
    }

    static float a(com.facebook.imagepipeline.common.c cVar, int i, int i2) {
        if (cVar == null) {
            return 1.0f;
        }
        float max = Math.max(cVar.width / i, cVar.height / i2);
        if (i * max > cVar.jGF) {
            max = cVar.jGF / i;
        }
        if (i2 * max > cVar.jGF) {
            return cVar.jGF / i2;
        }
        return max;
    }

    static int D(float f, float f2) {
        return (int) ((8.0f * f) + f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar, boolean z) {
        com.facebook.imagepipeline.common.c cAk;
        if (z && (cAk = imageRequest.cAk()) != null) {
            int a2 = a(imageRequest.cAl(), dVar);
            boolean z2 = a2 == 90 || a2 == 270;
            int D = D(a(cAk, z2 ? dVar.getHeight() : dVar.getWidth(), z2 ? dVar.getWidth() : dVar.getHeight()), cAk.jGG);
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
        if (!dVar.cwP()) {
            return 0;
        }
        int k = k(dVar2);
        return !dVar.cwO() ? (k + dVar.cwQ()) % 360 : k;
    }

    private static int k(com.facebook.imagepipeline.f.d dVar) {
        switch (dVar.cyA()) {
            case 90:
            case SubsamplingScaleImageView.ORIENTATION_180 /* 180 */:
            case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                return dVar.cyA();
            default:
                return 0;
        }
    }

    private static boolean CN(int i) {
        return i < 8;
    }

    private static boolean b(com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.f.d dVar2) {
        return (dVar.cwR() || a(dVar, dVar2) == 0) ? false : true;
    }

    static int CO(int i) {
        return Math.max(1, 8 / i);
    }
}
