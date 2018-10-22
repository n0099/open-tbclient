package com.facebook.imagepipeline.producers;

import com.baidu.mobstat.Config;
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
    private final com.facebook.common.memory.g ich;
    private final boolean ifd;
    private final ai<com.facebook.imagepipeline.f.d> igJ;
    private final boolean iim;
    private final Executor mExecutor;

    public am(Executor executor, com.facebook.common.memory.g gVar, boolean z, ai<com.facebook.imagepipeline.f.d> aiVar, boolean z2) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.ich = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.iim = z;
        this.igJ = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.ifd = z2;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.igJ.a(new a(jVar, ajVar), ajVar);
    }

    /* loaded from: classes2.dex */
    private class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private boolean aIi;
        private final aj igU;
        private final JobScheduler iha;

        public a(final j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
            super(jVar);
            this.aIi = false;
            this.igU = ajVar;
            this.iha = new JobScheduler(am.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.am.a.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
                    a.this.g(dVar, z);
                }
            }, 100);
            this.igU.a(new e() { // from class: com.facebook.imagepipeline.producers.am.a.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void bXz() {
                    if (a.this.igU.bXv()) {
                        a.this.iha.bXH();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void bXx() {
                    a.this.iha.bXG();
                    a.this.aIi = true;
                    jVar.bRy();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(@Nullable com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (!this.aIi) {
                if (dVar != null) {
                    TriState a = am.a(this.igU.bXq(), dVar, am.this.iim);
                    if (z || a != TriState.UNSET) {
                        if (a != TriState.YES) {
                            bXD().e(dVar, z);
                        } else if (this.iha.e(dVar, z)) {
                            if (z || this.igU.bXv()) {
                                this.iha.bXH();
                            }
                        }
                    }
                } else if (z) {
                    bXD().e(null, true);
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
            al bXr = this.igU.bXr();
            ?? id = this.igU.getId();
            bXr.cX(id, "ResizeAndRotateProducer");
            ImageRequest bXq = this.igU.bXq();
            com.facebook.common.memory.i bRH = am.this.ich.bRH();
            try {
                try {
                    try {
                        int b = am.b(bXq, dVar, am.this.iim);
                        int xX = am.xX(p.b(bXq, dVar));
                        int i = am.this.ifd ? xX : b;
                        int a = am.a(bXq.bYh(), dVar);
                        Map<String, String> a2 = a(dVar, bXq, i, xX, b, a);
                        try {
                            inputStream = dVar.getInputStream();
                            try {
                                JpegTranscoder.a(inputStream, bRH, a, i, 85);
                                com.facebook.common.references.a c = com.facebook.common.references.a.c(bRH.bRI());
                                try {
                                    com.facebook.imagepipeline.f.d dVar2 = new com.facebook.imagepipeline.f.d(c);
                                    dVar2.c(com.facebook.c.b.ibN);
                                    dVar2.bWB();
                                    this.igU.bXr().a(this.igU.getId(), "ResizeAndRotateProducer", a2);
                                    bXD().e(dVar2, z);
                                    com.facebook.imagepipeline.f.d.e(dVar2);
                                    com.facebook.common.internal.b.n(inputStream);
                                    bRH.close();
                                } finally {
                                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) c);
                                }
                            } catch (Exception e) {
                                e = e;
                                map = a2;
                                this.igU.bXr().a(this.igU.getId(), "ResizeAndRotateProducer", e, map);
                                bXD().B(e);
                                com.facebook.common.internal.b.n(inputStream);
                                bRH.close();
                            }
                        } catch (Exception e2) {
                            e = e2;
                            inputStream = null;
                            map = a2;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.facebook.common.internal.b.n(id);
                        bRH.close();
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
                bRH.close();
                throw th;
            }
        }

        private Map<String, String> a(com.facebook.imagepipeline.f.d dVar, ImageRequest imageRequest, int i, int i2, int i3, int i4) {
            String str;
            if (!this.igU.bXr().yD(this.igU.getId())) {
                return null;
            }
            String str2 = dVar.getWidth() + Config.EVENT_HEAT_X + dVar.getHeight();
            if (imageRequest.bYg() != null) {
                str = imageRequest.bYg().width + Config.EVENT_HEAT_X + imageRequest.bYg().height;
            } else {
                str = "Unspecified";
            }
            String str3 = i > 0 ? i + "/8" : "";
            HashMap hashMap = new HashMap();
            hashMap.put("Original size", str2);
            hashMap.put("Requested size", str);
            hashMap.put("Fraction", str3);
            hashMap.put("queueTime", String.valueOf(this.iha.bXL()));
            hashMap.put("downsampleEnumerator", Integer.toString(i2));
            hashMap.put("softwareEnumerator", Integer.toString(i3));
            hashMap.put("rotationAngle", Integer.toString(i4));
            return ImmutableMap.copyOf((Map) hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState a(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar, boolean z) {
        if (dVar == null || dVar.bWz() == com.facebook.c.c.ibW) {
            return TriState.UNSET;
        }
        if (dVar.bWz() != com.facebook.c.b.ibN) {
            return TriState.NO;
        }
        return TriState.valueOf(b(imageRequest.bYh(), dVar) || xW(b(imageRequest, dVar, z)));
    }

    static float a(com.facebook.imagepipeline.common.c cVar, int i, int i2) {
        if (cVar == null) {
            return 1.0f;
        }
        float max = Math.max(cVar.width / i, cVar.height / i2);
        if (i * max > cVar.idL) {
            max = cVar.idL / i;
        }
        if (i2 * max > cVar.idL) {
            return cVar.idL / i2;
        }
        return max;
    }

    static int w(float f, float f2) {
        return (int) ((8.0f * f) + f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar, boolean z) {
        com.facebook.imagepipeline.common.c bYg;
        if (z && (bYg = imageRequest.bYg()) != null) {
            int a2 = a(imageRequest.bYh(), dVar);
            boolean z2 = a2 == 90 || a2 == 270;
            int w = w(a(bYg, z2 ? dVar.getHeight() : dVar.getWidth(), z2 ? dVar.getWidth() : dVar.getHeight()), bYg.idM);
            if (w > 8) {
                return 8;
            }
            if (w < 1) {
                return 1;
            }
            return w;
        }
        return 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int a(com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.f.d dVar2) {
        if (!dVar.bUP()) {
            return 0;
        }
        int k = k(dVar2);
        return !dVar.bUO() ? (k + dVar.bUQ()) % 360 : k;
    }

    private static int k(com.facebook.imagepipeline.f.d dVar) {
        switch (dVar.bWw()) {
            case 90:
            case 180:
            case 270:
                return dVar.bWw();
            default:
                return 0;
        }
    }

    private static boolean xW(int i) {
        return i < 8;
    }

    private static boolean b(com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.f.d dVar2) {
        return (dVar.bUR() || a(dVar, dVar2) == 0) ? false : true;
    }

    static int xX(int i) {
        return Math.max(1, 8 / i);
    }
}
