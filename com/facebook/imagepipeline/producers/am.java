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
    private final com.facebook.common.memory.g kfD;
    private final boolean kiy;
    private final ai<com.facebook.imagepipeline.f.d> kkh;
    private final boolean klL;
    private final Executor mExecutor;

    public am(Executor executor, com.facebook.common.memory.g gVar, boolean z, ai<com.facebook.imagepipeline.f.d> aiVar, boolean z2) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.kfD = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.klL = z;
        this.kkh = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.kiy = z2;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.kkh.a(new a(jVar, ajVar), ajVar);
    }

    /* loaded from: classes2.dex */
    private class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private boolean cta;
        private final aj kks;
        private final JobScheduler kky;

        public a(final j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
            super(jVar);
            this.cta = false;
            this.kks = ajVar;
            this.kky = new JobScheduler(am.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.am.a.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
                    a.this.g(dVar, z);
                }
            }, 100);
            this.kks.a(new e() { // from class: com.facebook.imagepipeline.producers.am.a.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cIO() {
                    if (a.this.kks.cIK()) {
                        a.this.kky.cIW();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void cIM() {
                    a.this.kky.cIV();
                    a.this.cta = true;
                    jVar.cCF();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void e(@Nullable com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (!this.cta) {
                if (dVar != null) {
                    TriState a = am.a(this.kks.cIF(), dVar, am.this.klL);
                    if (z || a != TriState.UNSET) {
                        if (a != TriState.YES) {
                            cIS().f(dVar, z);
                        } else if (this.kky.e(dVar, z)) {
                            if (z || this.kks.cIK()) {
                                this.kky.cIW();
                            }
                        }
                    }
                } else if (z) {
                    cIS().f(null, true);
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
            al cIG = this.kks.cIG();
            ?? id = this.kks.getId();
            cIG.en(id, "ResizeAndRotateProducer");
            ImageRequest cIF = this.kks.cIF();
            com.facebook.common.memory.i cCO = am.this.kfD.cCO();
            try {
                try {
                    try {
                        int b = am.b(cIF, dVar, am.this.klL);
                        int CR = am.CR(p.b(cIF, dVar));
                        int i = am.this.kiy ? CR : b;
                        int a = am.a(cIF.cJw(), dVar);
                        Map<String, String> a2 = a(dVar, cIF, i, CR, b, a);
                        try {
                            inputStream = dVar.getInputStream();
                            try {
                                JpegTranscoder.a(inputStream, cCO, a, i, 85);
                                com.facebook.common.references.a c = com.facebook.common.references.a.c(cCO.cCP());
                                try {
                                    com.facebook.imagepipeline.f.d dVar2 = new com.facebook.imagepipeline.f.d(c);
                                    dVar2.c(com.facebook.c.b.kfj);
                                    dVar2.cHP();
                                    this.kks.cIG().a(this.kks.getId(), "ResizeAndRotateProducer", a2);
                                    cIS().f(dVar2, z);
                                    com.facebook.imagepipeline.f.d.e(dVar2);
                                    com.facebook.common.internal.b.n(inputStream);
                                    cCO.close();
                                } finally {
                                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) c);
                                }
                            } catch (Exception e) {
                                e = e;
                                map = a2;
                                this.kks.cIG().a(this.kks.getId(), "ResizeAndRotateProducer", e, map);
                                cIS().B(e);
                                com.facebook.common.internal.b.n(inputStream);
                                cCO.close();
                            }
                        } catch (Exception e2) {
                            e = e2;
                            inputStream = null;
                            map = a2;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.facebook.common.internal.b.n(id);
                        cCO.close();
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
                cCO.close();
                throw th;
            }
        }

        private Map<String, String> a(com.facebook.imagepipeline.f.d dVar, ImageRequest imageRequest, int i, int i2, int i3, int i4) {
            String str;
            if (!this.kks.cIG().GH(this.kks.getId())) {
                return null;
            }
            String str2 = dVar.getWidth() + Config.EVENT_HEAT_X + dVar.getHeight();
            if (imageRequest.cJv() != null) {
                str = imageRequest.cJv().width + Config.EVENT_HEAT_X + imageRequest.cJv().height;
            } else {
                str = "Unspecified";
            }
            String str3 = i > 0 ? i + "/8" : "";
            HashMap hashMap = new HashMap();
            hashMap.put("Original size", str2);
            hashMap.put("Requested size", str);
            hashMap.put("Fraction", str3);
            hashMap.put("queueTime", String.valueOf(this.kky.cJa()));
            hashMap.put("downsampleEnumerator", Integer.toString(i2));
            hashMap.put("softwareEnumerator", Integer.toString(i3));
            hashMap.put("rotationAngle", Integer.toString(i4));
            return ImmutableMap.copyOf((Map) hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState a(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar, boolean z) {
        if (dVar == null || dVar.cHN() == com.facebook.c.c.kfs) {
            return TriState.UNSET;
        }
        if (dVar.cHN() != com.facebook.c.b.kfj) {
            return TriState.NO;
        }
        return TriState.valueOf(b(imageRequest.cJw(), dVar) || CQ(b(imageRequest, dVar, z)));
    }

    static float a(com.facebook.imagepipeline.common.c cVar, int i, int i2) {
        if (cVar == null) {
            return 1.0f;
        }
        float max = Math.max(cVar.width / i, cVar.height / i2);
        if (i * max > cVar.khg) {
            max = cVar.khg / i;
        }
        if (i2 * max > cVar.khg) {
            return cVar.khg / i2;
        }
        return max;
    }

    static int y(float f, float f2) {
        return (int) ((8.0f * f) + f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar, boolean z) {
        com.facebook.imagepipeline.common.c cJv;
        if (z && (cJv = imageRequest.cJv()) != null) {
            int a2 = a(imageRequest.cJw(), dVar);
            boolean z2 = a2 == 90 || a2 == 270;
            int y = y(a(cJv, z2 ? dVar.getHeight() : dVar.getWidth(), z2 ? dVar.getWidth() : dVar.getHeight()), cJv.khh);
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
        if (!dVar.cFZ()) {
            return 0;
        }
        int k = k(dVar2);
        return !dVar.cFY() ? (k + dVar.cGa()) % 360 : k;
    }

    private static int k(com.facebook.imagepipeline.f.d dVar) {
        switch (dVar.cHK()) {
            case 90:
            case SubsamplingScaleImageView.ORIENTATION_180 /* 180 */:
            case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                return dVar.cHK();
            default:
                return 0;
        }
    }

    private static boolean CQ(int i) {
        return i < 8;
    }

    private static boolean b(com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.f.d dVar2) {
        return (dVar.cGb() || a(dVar, dVar2) == 0) ? false : true;
    }

    static int CR(int i) {
        return Math.max(1, 8 / i);
    }
}
