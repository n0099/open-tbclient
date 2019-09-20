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
    private final com.facebook.common.memory.g kik;
    private final boolean kld;
    private final ai<com.facebook.imagepipeline.f.d> kmM;
    private final boolean koq;
    private final Executor mExecutor;

    public am(Executor executor, com.facebook.common.memory.g gVar, boolean z, ai<com.facebook.imagepipeline.f.d> aiVar, boolean z2) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.kik = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.koq = z;
        this.kmM = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.kld = z2;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.kmM.a(new a(jVar, ajVar), ajVar);
    }

    /* loaded from: classes2.dex */
    private class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private boolean cfF;
        private final aj kmX;
        private final JobScheduler knd;

        public a(final j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
            super(jVar);
            this.cfF = false;
            this.kmX = ajVar;
            this.knd = new JobScheduler(am.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.am.a.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
                    a.this.g(dVar, z);
                }
            }, 100);
            this.kmX.a(new e() { // from class: com.facebook.imagepipeline.producers.am.a.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cLT() {
                    if (a.this.kmX.cLP()) {
                        a.this.knd.cMb();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cLR() {
                    a.this.knd.cMa();
                    a.this.cfF = true;
                    jVar.cFJ();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(@Nullable com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (!this.cfF) {
                if (dVar != null) {
                    TriState a = am.a(this.kmX.cLK(), dVar, am.this.koq);
                    if (z || a != TriState.UNSET) {
                        if (a != TriState.YES) {
                            cLX().e(dVar, z);
                        } else if (this.knd.e(dVar, z)) {
                            if (z || this.kmX.cLP()) {
                                this.knd.cMb();
                            }
                        }
                    }
                } else if (z) {
                    cLX().e(null, true);
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
            al cLL = this.kmX.cLL();
            ?? id = this.kmX.getId();
            cLL.eB(id, "ResizeAndRotateProducer");
            ImageRequest cLK = this.kmX.cLK();
            com.facebook.common.memory.i cFS = am.this.kik.cFS();
            try {
                try {
                    try {
                        int b = am.b(cLK, dVar, am.this.koq);
                        int Ew = am.Ew(p.b(cLK, dVar));
                        int i = am.this.kld ? Ew : b;
                        int a = am.a(cLK.cMB(), dVar);
                        Map<String, String> a2 = a(dVar, cLK, i, Ew, b, a);
                        try {
                            inputStream = dVar.getInputStream();
                            try {
                                JpegTranscoder.a(inputStream, cFS, a, i, 85);
                                com.facebook.common.references.a d = com.facebook.common.references.a.d(cFS.cFT());
                                try {
                                    com.facebook.imagepipeline.f.d dVar2 = new com.facebook.imagepipeline.f.d(d);
                                    dVar2.c(com.facebook.c.b.khP);
                                    dVar2.cKU();
                                    this.kmX.cLL().a(this.kmX.getId(), "ResizeAndRotateProducer", a2);
                                    cLX().e(dVar2, z);
                                    com.facebook.imagepipeline.f.d.e(dVar2);
                                    com.facebook.common.internal.b.q(inputStream);
                                    cFS.close();
                                } finally {
                                    com.facebook.common.references.a.c(d);
                                }
                            } catch (Exception e) {
                                e = e;
                                map = a2;
                                this.kmX.cLL().a(this.kmX.getId(), "ResizeAndRotateProducer", e, map);
                                cLX().B(e);
                                com.facebook.common.internal.b.q(inputStream);
                                cFS.close();
                            }
                        } catch (Exception e2) {
                            e = e2;
                            inputStream = null;
                            map = a2;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.facebook.common.internal.b.q(id);
                        cFS.close();
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
                cFS.close();
                throw th;
            }
        }

        private Map<String, String> a(com.facebook.imagepipeline.f.d dVar, ImageRequest imageRequest, int i, int i2, int i3, int i4) {
            String str;
            if (!this.kmX.cLL().Iq(this.kmX.getId())) {
                return null;
            }
            String str2 = dVar.getWidth() + Config.EVENT_HEAT_X + dVar.getHeight();
            if (imageRequest.cMA() != null) {
                str = imageRequest.cMA().width + Config.EVENT_HEAT_X + imageRequest.cMA().height;
            } else {
                str = "Unspecified";
            }
            String str3 = i > 0 ? i + "/8" : "";
            HashMap hashMap = new HashMap();
            hashMap.put("Original size", str2);
            hashMap.put("Requested size", str);
            hashMap.put("Fraction", str3);
            hashMap.put("queueTime", String.valueOf(this.knd.cMf()));
            hashMap.put("downsampleEnumerator", Integer.toString(i2));
            hashMap.put("softwareEnumerator", Integer.toString(i3));
            hashMap.put("rotationAngle", Integer.toString(i4));
            return ImmutableMap.copyOf((Map) hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState a(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar, boolean z) {
        if (dVar == null || dVar.cKS() == com.facebook.c.c.khY) {
            return TriState.UNSET;
        }
        if (dVar.cKS() != com.facebook.c.b.khP) {
            return TriState.NO;
        }
        return TriState.valueOf(b(imageRequest.cMB(), dVar) || Ev(b(imageRequest, dVar, z)));
    }

    static float a(com.facebook.imagepipeline.common.c cVar, int i, int i2) {
        if (cVar == null) {
            return 1.0f;
        }
        float max = Math.max(cVar.width / i, cVar.height / i2);
        if (i * max > cVar.kjM) {
            max = cVar.kjM / i;
        }
        if (i2 * max > cVar.kjM) {
            return cVar.kjM / i2;
        }
        return max;
    }

    static int F(float f, float f2) {
        return (int) ((8.0f * f) + f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar, boolean z) {
        com.facebook.imagepipeline.common.c cMA;
        if (z && (cMA = imageRequest.cMA()) != null) {
            int a2 = a(imageRequest.cMB(), dVar);
            boolean z2 = a2 == 90 || a2 == 270;
            int F = F(a(cMA, z2 ? dVar.getHeight() : dVar.getWidth(), z2 ? dVar.getWidth() : dVar.getHeight()), cMA.kjN);
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
        if (!dVar.cJe()) {
            return 0;
        }
        int k = k(dVar2);
        return !dVar.cJd() ? (k + dVar.cJf()) % 360 : k;
    }

    private static int k(com.facebook.imagepipeline.f.d dVar) {
        switch (dVar.cKP()) {
            case 90:
            case SubsamplingScaleImageView.ORIENTATION_180 /* 180 */:
            case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                return dVar.cKP();
            default:
                return 0;
        }
    }

    private static boolean Ev(int i) {
        return i < 8;
    }

    private static boolean b(com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.f.d dVar2) {
        return (dVar.cJg() || a(dVar, dVar2) == 0) ? false : true;
    }

    static int Ew(int i) {
        return Math.max(1, 8 / i);
    }
}
