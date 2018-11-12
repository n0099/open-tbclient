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
    private final com.facebook.common.memory.g idU;
    private final boolean igN;
    private final ai<com.facebook.imagepipeline.f.d> iit;
    private final boolean ijW;
    private final Executor mExecutor;

    public am(Executor executor, com.facebook.common.memory.g gVar, boolean z, ai<com.facebook.imagepipeline.f.d> aiVar, boolean z2) {
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.idU = (com.facebook.common.memory.g) com.facebook.common.internal.g.checkNotNull(gVar);
        this.ijW = z;
        this.iit = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.igN = z2;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.iit.a(new a(jVar, ajVar), ajVar);
    }

    /* loaded from: classes2.dex */
    private class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private boolean aIY;
        private final aj iiE;
        private final JobScheduler iiK;

        public a(final j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
            super(jVar);
            this.aIY = false;
            this.iiE = ajVar;
            this.iiK = new JobScheduler(am.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.am.a.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
                    a.this.g(dVar, z);
                }
            }, 100);
            this.iiE.a(new e() { // from class: com.facebook.imagepipeline.producers.am.a.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void bWU() {
                    if (a.this.iiE.bWQ()) {
                        a.this.iiK.bXc();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
                public void bWS() {
                    a.this.iiK.bXb();
                    a.this.aIY = true;
                    jVar.bQT();
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(@Nullable com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (!this.aIY) {
                if (dVar != null) {
                    TriState a = am.a(this.iiE.bWL(), dVar, am.this.ijW);
                    if (z || a != TriState.UNSET) {
                        if (a != TriState.YES) {
                            bWY().e(dVar, z);
                        } else if (this.iiK.e(dVar, z)) {
                            if (z || this.iiE.bWQ()) {
                                this.iiK.bXc();
                            }
                        }
                    }
                } else if (z) {
                    bWY().e(null, true);
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
            al bWM = this.iiE.bWM();
            ?? id = this.iiE.getId();
            bWM.cW(id, "ResizeAndRotateProducer");
            ImageRequest bWL = this.iiE.bWL();
            com.facebook.common.memory.i bRc = am.this.idU.bRc();
            try {
                try {
                    try {
                        int b = am.b(bWL, dVar, am.this.ijW);
                        int yq = am.yq(p.b(bWL, dVar));
                        int i = am.this.igN ? yq : b;
                        int a = am.a(bWL.bXC(), dVar);
                        Map<String, String> a2 = a(dVar, bWL, i, yq, b, a);
                        try {
                            inputStream = dVar.getInputStream();
                            try {
                                JpegTranscoder.a(inputStream, bRc, a, i, 85);
                                com.facebook.common.references.a c = com.facebook.common.references.a.c(bRc.bRd());
                                try {
                                    com.facebook.imagepipeline.f.d dVar2 = new com.facebook.imagepipeline.f.d(c);
                                    dVar2.c(com.facebook.c.b.idA);
                                    dVar2.bVW();
                                    this.iiE.bWM().a(this.iiE.getId(), "ResizeAndRotateProducer", a2);
                                    bWY().e(dVar2, z);
                                    com.facebook.imagepipeline.f.d.e(dVar2);
                                    com.facebook.common.internal.b.n(inputStream);
                                    bRc.close();
                                } finally {
                                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) c);
                                }
                            } catch (Exception e) {
                                e = e;
                                map = a2;
                                this.iiE.bWM().a(this.iiE.getId(), "ResizeAndRotateProducer", e, map);
                                bWY().B(e);
                                com.facebook.common.internal.b.n(inputStream);
                                bRc.close();
                            }
                        } catch (Exception e2) {
                            e = e2;
                            inputStream = null;
                            map = a2;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.facebook.common.internal.b.n(id);
                        bRc.close();
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
                bRc.close();
                throw th;
            }
        }

        private Map<String, String> a(com.facebook.imagepipeline.f.d dVar, ImageRequest imageRequest, int i, int i2, int i3, int i4) {
            String str;
            if (!this.iiE.bWM().yI(this.iiE.getId())) {
                return null;
            }
            String str2 = dVar.getWidth() + Config.EVENT_HEAT_X + dVar.getHeight();
            if (imageRequest.bXB() != null) {
                str = imageRequest.bXB().width + Config.EVENT_HEAT_X + imageRequest.bXB().height;
            } else {
                str = "Unspecified";
            }
            String str3 = i > 0 ? i + "/8" : "";
            HashMap hashMap = new HashMap();
            hashMap.put("Original size", str2);
            hashMap.put("Requested size", str);
            hashMap.put("Fraction", str3);
            hashMap.put("queueTime", String.valueOf(this.iiK.bXg()));
            hashMap.put("downsampleEnumerator", Integer.toString(i2));
            hashMap.put("softwareEnumerator", Integer.toString(i3));
            hashMap.put("rotationAngle", Integer.toString(i4));
            return ImmutableMap.copyOf((Map) hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState a(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar, boolean z) {
        if (dVar == null || dVar.bVU() == com.facebook.c.c.idJ) {
            return TriState.UNSET;
        }
        if (dVar.bVU() != com.facebook.c.b.idA) {
            return TriState.NO;
        }
        return TriState.valueOf(b(imageRequest.bXC(), dVar) || yp(b(imageRequest, dVar, z)));
    }

    static float a(com.facebook.imagepipeline.common.c cVar, int i, int i2) {
        if (cVar == null) {
            return 1.0f;
        }
        float max = Math.max(cVar.width / i, cVar.height / i2);
        if (i * max > cVar.ifv) {
            max = cVar.ifv / i;
        }
        if (i2 * max > cVar.ifv) {
            return cVar.ifv / i2;
        }
        return max;
    }

    static int z(float f, float f2) {
        return (int) ((8.0f * f) + f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar, boolean z) {
        com.facebook.imagepipeline.common.c bXB;
        if (z && (bXB = imageRequest.bXB()) != null) {
            int a2 = a(imageRequest.bXC(), dVar);
            boolean z2 = a2 == 90 || a2 == 270;
            int z3 = z(a(bXB, z2 ? dVar.getHeight() : dVar.getWidth(), z2 ? dVar.getWidth() : dVar.getHeight()), bXB.ifw);
            if (z3 > 8) {
                return 8;
            }
            if (z3 < 1) {
                return 1;
            }
            return z3;
        }
        return 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int a(com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.f.d dVar2) {
        if (!dVar.bUk()) {
            return 0;
        }
        int k = k(dVar2);
        return !dVar.bUj() ? (k + dVar.bUl()) % 360 : k;
    }

    private static int k(com.facebook.imagepipeline.f.d dVar) {
        switch (dVar.bVR()) {
            case 90:
            case 180:
            case 270:
                return dVar.bVR();
            default:
                return 0;
        }
    }

    private static boolean yp(int i) {
        return i < 8;
    }

    private static boolean b(com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.f.d dVar2) {
        return (dVar.bUm() || a(dVar, dVar2) == 0) ? false : true;
    }

    static int yq(int i) {
        return Math.max(1, 8 / i);
    }
}
