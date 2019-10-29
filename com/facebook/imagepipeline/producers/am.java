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
    private final com.facebook.common.memory.g kgu;
    private final boolean kjp;
    private final ai<com.facebook.imagepipeline.f.d> kkY;
    private final boolean kmC;
    private final Executor mExecutor;

    public am(Executor executor, com.facebook.common.memory.g gVar, boolean z, ai<com.facebook.imagepipeline.f.d> aiVar, boolean z2) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.kgu = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.kmC = z;
        this.kkY = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.kjp = z2;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.kkY.a(new a(jVar, ajVar), ajVar);
    }

    /* loaded from: classes2.dex */
    private class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private boolean ctR;
        private final aj klj;
        private final JobScheduler klp;

        public a(final j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
            super(jVar);
            this.ctR = false;
            this.klj = ajVar;
            this.klp = new JobScheduler(am.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.am.a.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
                    a.this.g(dVar, z);
                }
            }, 100);
            this.klj.a(new e() { // from class: com.facebook.imagepipeline.producers.am.a.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cIQ() {
                    if (a.this.klj.cIM()) {
                        a.this.klp.cIY();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cIO() {
                    a.this.klp.cIX();
                    a.this.ctR = true;
                    jVar.cCH();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void e(@Nullable com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (!this.ctR) {
                if (dVar != null) {
                    TriState a = am.a(this.klj.cIH(), dVar, am.this.kmC);
                    if (z || a != TriState.UNSET) {
                        if (a != TriState.YES) {
                            cIU().f(dVar, z);
                        } else if (this.klp.e(dVar, z)) {
                            if (z || this.klj.cIM()) {
                                this.klp.cIY();
                            }
                        }
                    }
                } else if (z) {
                    cIU().f(null, true);
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
            al cII = this.klj.cII();
            ?? id = this.klj.getId();
            cII.en(id, "ResizeAndRotateProducer");
            ImageRequest cIH = this.klj.cIH();
            com.facebook.common.memory.i cCQ = am.this.kgu.cCQ();
            try {
                try {
                    try {
                        int b = am.b(cIH, dVar, am.this.kmC);
                        int CS = am.CS(p.b(cIH, dVar));
                        int i = am.this.kjp ? CS : b;
                        int a = am.a(cIH.cJy(), dVar);
                        Map<String, String> a2 = a(dVar, cIH, i, CS, b, a);
                        try {
                            inputStream = dVar.getInputStream();
                            try {
                                JpegTranscoder.a(inputStream, cCQ, a, i, 85);
                                com.facebook.common.references.a c = com.facebook.common.references.a.c(cCQ.cCR());
                                try {
                                    com.facebook.imagepipeline.f.d dVar2 = new com.facebook.imagepipeline.f.d(c);
                                    dVar2.c(com.facebook.c.b.kga);
                                    dVar2.cHR();
                                    this.klj.cII().a(this.klj.getId(), "ResizeAndRotateProducer", a2);
                                    cIU().f(dVar2, z);
                                    com.facebook.imagepipeline.f.d.e(dVar2);
                                    com.facebook.common.internal.b.n(inputStream);
                                    cCQ.close();
                                } finally {
                                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) c);
                                }
                            } catch (Exception e) {
                                e = e;
                                map = a2;
                                this.klj.cII().a(this.klj.getId(), "ResizeAndRotateProducer", e, map);
                                cIU().A(e);
                                com.facebook.common.internal.b.n(inputStream);
                                cCQ.close();
                            }
                        } catch (Exception e2) {
                            e = e2;
                            inputStream = null;
                            map = a2;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.facebook.common.internal.b.n(id);
                        cCQ.close();
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    inputStream = null;
                }
            } catch (Throwable th2) {
                th = th2;
                id = 0;
                com.facebook.common.internal.b.n(id);
                cCQ.close();
                throw th;
            }
        }

        private Map<String, String> a(com.facebook.imagepipeline.f.d dVar, ImageRequest imageRequest, int i, int i2, int i3, int i4) {
            String str;
            if (!this.klj.cII().GH(this.klj.getId())) {
                return null;
            }
            String str2 = dVar.getWidth() + Config.EVENT_HEAT_X + dVar.getHeight();
            if (imageRequest.cJx() != null) {
                str = imageRequest.cJx().width + Config.EVENT_HEAT_X + imageRequest.cJx().height;
            } else {
                str = "Unspecified";
            }
            String str3 = i > 0 ? i + "/8" : "";
            HashMap hashMap = new HashMap();
            hashMap.put("Original size", str2);
            hashMap.put("Requested size", str);
            hashMap.put("Fraction", str3);
            hashMap.put("queueTime", String.valueOf(this.klp.cJc()));
            hashMap.put("downsampleEnumerator", Integer.toString(i2));
            hashMap.put("softwareEnumerator", Integer.toString(i3));
            hashMap.put("rotationAngle", Integer.toString(i4));
            return ImmutableMap.copyOf((Map) hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState a(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar, boolean z) {
        if (dVar == null || dVar.cHP() == com.facebook.c.c.kgj) {
            return TriState.UNSET;
        }
        if (dVar.cHP() != com.facebook.c.b.kga) {
            return TriState.NO;
        }
        return TriState.valueOf(b(imageRequest.cJy(), dVar) || CR(b(imageRequest, dVar, z)));
    }

    static float a(com.facebook.imagepipeline.common.c cVar, int i, int i2) {
        if (cVar == null) {
            return 1.0f;
        }
        float max = Math.max(cVar.width / i, cVar.height / i2);
        if (i * max > cVar.khX) {
            max = cVar.khX / i;
        }
        if (i2 * max > cVar.khX) {
            return cVar.khX / i2;
        }
        return max;
    }

    static int y(float f, float f2) {
        return (int) ((8.0f * f) + f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar, boolean z) {
        com.facebook.imagepipeline.common.c cJx;
        if (z && (cJx = imageRequest.cJx()) != null) {
            int a2 = a(imageRequest.cJy(), dVar);
            boolean z2 = a2 == 90 || a2 == 270;
            int y = y(a(cJx, z2 ? dVar.getHeight() : dVar.getWidth(), z2 ? dVar.getWidth() : dVar.getHeight()), cJx.khY);
            if (y > 8) {
                return 8;
            }
            if (y < 1) {
                return 1;
            }
            return y;
        }
        return 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int a(com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.f.d dVar2) {
        if (!dVar.cGb()) {
            return 0;
        }
        int k = k(dVar2);
        return !dVar.cGa() ? (k + dVar.cGc()) % 360 : k;
    }

    private static int k(com.facebook.imagepipeline.f.d dVar) {
        switch (dVar.cHM()) {
            case 90:
            case SubsamplingScaleImageView.ORIENTATION_180 /* 180 */:
            case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                return dVar.cHM();
            default:
                return 0;
        }
    }

    private static boolean CR(int i) {
        return i < 8;
    }

    private static boolean b(com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.f.d dVar2) {
        return (dVar.cGd() || a(dVar, dVar2) == 0) ? false : true;
    }

    static int CS(int i) {
        return Math.max(1, 8 / i);
    }
}
