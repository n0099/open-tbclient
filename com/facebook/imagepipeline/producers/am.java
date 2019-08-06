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
    private final com.facebook.common.memory.g kfM;
    private final boolean kiG;
    private final ai<com.facebook.imagepipeline.f.d> kkp;
    private final boolean klT;
    private final Executor mExecutor;

    public am(Executor executor, com.facebook.common.memory.g gVar, boolean z, ai<com.facebook.imagepipeline.f.d> aiVar, boolean z2) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.kfM = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.klT = z;
        this.kkp = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.kiG = z2;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.kkp.a(new a(jVar, ajVar), ajVar);
    }

    /* loaded from: classes2.dex */
    private class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private boolean ceM;
        private final aj kkA;
        private final JobScheduler kkG;

        public a(final j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
            super(jVar);
            this.ceM = false;
            this.kkA = ajVar;
            this.kkG = new JobScheduler(am.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.am.a.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
                    a.this.g(dVar, z);
                }
            }, 100);
            this.kkA.a(new e() { // from class: com.facebook.imagepipeline.producers.am.a.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cLf() {
                    if (a.this.kkA.cLb()) {
                        a.this.kkG.cLn();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cLd() {
                    a.this.kkG.cLm();
                    a.this.ceM = true;
                    jVar.cEV();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(@Nullable com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (!this.ceM) {
                if (dVar != null) {
                    TriState a = am.a(this.kkA.cKW(), dVar, am.this.klT);
                    if (z || a != TriState.UNSET) {
                        if (a != TriState.YES) {
                            cLj().e(dVar, z);
                        } else if (this.kkG.e(dVar, z)) {
                            if (z || this.kkA.cLb()) {
                                this.kkG.cLn();
                            }
                        }
                    }
                } else if (z) {
                    cLj().e(null, true);
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
            al cKX = this.kkA.cKX();
            ?? id = this.kkA.getId();
            cKX.eA(id, "ResizeAndRotateProducer");
            ImageRequest cKW = this.kkA.cKW();
            com.facebook.common.memory.i cFe = am.this.kfM.cFe();
            try {
                try {
                    try {
                        int b = am.b(cKW, dVar, am.this.klT);
                        int Es = am.Es(p.b(cKW, dVar));
                        int i = am.this.kiG ? Es : b;
                        int a = am.a(cKW.cLN(), dVar);
                        Map<String, String> a2 = a(dVar, cKW, i, Es, b, a);
                        try {
                            inputStream = dVar.getInputStream();
                            try {
                                JpegTranscoder.a(inputStream, cFe, a, i, 85);
                                com.facebook.common.references.a d = com.facebook.common.references.a.d(cFe.cFf());
                                try {
                                    com.facebook.imagepipeline.f.d dVar2 = new com.facebook.imagepipeline.f.d(d);
                                    dVar2.c(com.facebook.c.b.kfs);
                                    dVar2.cKg();
                                    this.kkA.cKX().a(this.kkA.getId(), "ResizeAndRotateProducer", a2);
                                    cLj().e(dVar2, z);
                                    com.facebook.imagepipeline.f.d.e(dVar2);
                                    com.facebook.common.internal.b.q(inputStream);
                                    cFe.close();
                                } finally {
                                    com.facebook.common.references.a.c(d);
                                }
                            } catch (Exception e) {
                                e = e;
                                map = a2;
                                this.kkA.cKX().a(this.kkA.getId(), "ResizeAndRotateProducer", e, map);
                                cLj().B(e);
                                com.facebook.common.internal.b.q(inputStream);
                                cFe.close();
                            }
                        } catch (Exception e2) {
                            e = e2;
                            inputStream = null;
                            map = a2;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.facebook.common.internal.b.q(id);
                        cFe.close();
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
                cFe.close();
                throw th;
            }
        }

        private Map<String, String> a(com.facebook.imagepipeline.f.d dVar, ImageRequest imageRequest, int i, int i2, int i3, int i4) {
            String str;
            if (!this.kkA.cKX().HQ(this.kkA.getId())) {
                return null;
            }
            String str2 = dVar.getWidth() + Config.EVENT_HEAT_X + dVar.getHeight();
            if (imageRequest.cLM() != null) {
                str = imageRequest.cLM().width + Config.EVENT_HEAT_X + imageRequest.cLM().height;
            } else {
                str = "Unspecified";
            }
            String str3 = i > 0 ? i + "/8" : "";
            HashMap hashMap = new HashMap();
            hashMap.put("Original size", str2);
            hashMap.put("Requested size", str);
            hashMap.put("Fraction", str3);
            hashMap.put("queueTime", String.valueOf(this.kkG.cLr()));
            hashMap.put("downsampleEnumerator", Integer.toString(i2));
            hashMap.put("softwareEnumerator", Integer.toString(i3));
            hashMap.put("rotationAngle", Integer.toString(i4));
            return ImmutableMap.copyOf((Map) hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState a(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar, boolean z) {
        if (dVar == null || dVar.cKe() == com.facebook.c.c.kfB) {
            return TriState.UNSET;
        }
        if (dVar.cKe() != com.facebook.c.b.kfs) {
            return TriState.NO;
        }
        return TriState.valueOf(b(imageRequest.cLN(), dVar) || Er(b(imageRequest, dVar, z)));
    }

    static float a(com.facebook.imagepipeline.common.c cVar, int i, int i2) {
        if (cVar == null) {
            return 1.0f;
        }
        float max = Math.max(cVar.width / i, cVar.height / i2);
        if (i * max > cVar.kho) {
            max = cVar.kho / i;
        }
        if (i2 * max > cVar.kho) {
            return cVar.kho / i2;
        }
        return max;
    }

    static int F(float f, float f2) {
        return (int) ((8.0f * f) + f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar, boolean z) {
        com.facebook.imagepipeline.common.c cLM;
        if (z && (cLM = imageRequest.cLM()) != null) {
            int a2 = a(imageRequest.cLN(), dVar);
            boolean z2 = a2 == 90 || a2 == 270;
            int F = F(a(cLM, z2 ? dVar.getHeight() : dVar.getWidth(), z2 ? dVar.getWidth() : dVar.getHeight()), cLM.khp);
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
        if (!dVar.cIq()) {
            return 0;
        }
        int k = k(dVar2);
        return !dVar.cIp() ? (k + dVar.cIr()) % 360 : k;
    }

    private static int k(com.facebook.imagepipeline.f.d dVar) {
        switch (dVar.cKb()) {
            case 90:
            case SubsamplingScaleImageView.ORIENTATION_180 /* 180 */:
            case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                return dVar.cKb();
            default:
                return 0;
        }
    }

    private static boolean Er(int i) {
        return i < 8;
    }

    private static boolean b(com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.f.d dVar2) {
        return (dVar.cIs() || a(dVar, dVar2) == 0) ? false : true;
    }

    static int Es(int i) {
        return Math.max(1, 8 / i);
    }
}
