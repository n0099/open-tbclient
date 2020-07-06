package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.baidu.mobstat.Config;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.util.ExceptionWithNoStacktrace;
import com.facebook.imagepipeline.decoder.DecodeException;
import com.facebook.imagepipeline.producers.JobScheduler;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class m implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final Executor mExecutor;
    private final com.facebook.common.memory.a mIZ;
    private final boolean mSY;
    private final com.facebook.imagepipeline.decoder.b mTb;
    private final com.facebook.imagepipeline.decoder.d mTh;
    private final boolean mTw;
    private final aj<com.facebook.imagepipeline.g.e> mVS;
    private final boolean mWh;

    public m(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.mIZ = (com.facebook.common.memory.a) com.facebook.common.internal.g.checkNotNull(aVar);
        this.mExecutor = (Executor) com.facebook.common.internal.g.checkNotNull(executor);
        this.mTb = (com.facebook.imagepipeline.decoder.b) com.facebook.common.internal.g.checkNotNull(bVar);
        this.mTh = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
        this.mSY = z;
        this.mWh = z2;
        this.mVS = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.mTw = z3;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        k<com.facebook.imagepipeline.g.e> bVar;
        if (!com.facebook.common.util.d.J(akVar.dGc().dGU())) {
            bVar = new a(kVar, akVar, this.mTw);
        } else {
            bVar = new b(kVar, akVar, new com.facebook.imagepipeline.decoder.e(this.mIZ), this.mTh, this.mTw);
        }
        this.mVS.c(bVar, akVar);
    }

    /* loaded from: classes12.dex */
    private abstract class c extends n<com.facebook.imagepipeline.g.e, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final String TAG;
        private final com.facebook.imagepipeline.common.b mRn;
        @GuardedBy("this")
        private boolean mVT;
        private final am mVU;
        private final ak mWf;
        private final JobScheduler mWl;

        protected abstract com.facebook.imagepipeline.g.h dEY();

        protected abstract int g(com.facebook.imagepipeline.g.e eVar);

        public c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, final ak akVar, final boolean z) {
            super(kVar);
            this.TAG = "ProgressiveDecoder";
            this.mWf = akVar;
            this.mVU = akVar.dGd();
            this.mRn = akVar.dGc().dGY();
            this.mVT = false;
            this.mWl = new JobScheduler(m.this.mExecutor, new JobScheduler.a() { // from class: com.facebook.imagepipeline.producers.m.c.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.a
                public void d(com.facebook.imagepipeline.g.e eVar, int i) {
                    if (eVar != null) {
                        if (m.this.mSY || !com.facebook.imagepipeline.producers.b.dz(i, 16)) {
                            ImageRequest dGc = akVar.dGc();
                            if (m.this.mWh || !com.facebook.common.util.d.J(dGc.dGU())) {
                                eVar.setSampleSize(q.a(dGc, eVar));
                            }
                        }
                        c.this.c(eVar, i);
                    }
                }
            }, this.mRn.mSf);
            this.mWf.a(new e() { // from class: com.facebook.imagepipeline.producers.m.c.2
                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dGk() {
                    if (c.this.mWf.dGh()) {
                        c.this.mWl.dGv();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
                public void dCu() {
                    if (z) {
                        c.this.dGn();
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            boolean Jm = Jm(i);
            if (Jm && !com.facebook.imagepipeline.g.e.f(eVar)) {
                H(new ExceptionWithNoStacktrace("Encoded image is not valid."));
            } else if (b(eVar, i)) {
                boolean dz = dz(i, 4);
                if (Jm || dz || this.mWf.dGh()) {
                    this.mWl.dGv();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void aN(float f) {
            super.aN(0.99f * f);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void F(Throwable th) {
            H(th);
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        public void dEN() {
            dGn();
        }

        protected boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            return this.mWl.e(eVar, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(com.facebook.imagepipeline.g.e eVar, int i) {
            String str;
            com.facebook.imagepipeline.common.d dGW;
            String str2;
            long dGz;
            int size;
            com.facebook.imagepipeline.g.h dEY;
            if ((eVar.dFf() == com.facebook.c.b.mPX || !Jn(i)) && !isFinished() && com.facebook.imagepipeline.g.e.f(eVar)) {
                com.facebook.c.c dFf = eVar.dFf();
                if (dFf != null) {
                    str = dFf.getName();
                } else {
                    str = "unknown";
                }
                String str3 = eVar.getWidth() + Config.EVENT_HEAT_X + eVar.getHeight();
                String valueOf = String.valueOf(eVar.getSampleSize());
                boolean Jm = Jm(i);
                boolean z = Jm && !dz(i, 8);
                boolean dz = dz(i, 4);
                if (this.mWf.dGc().dGW() != null) {
                    str2 = dGW.width + Config.EVENT_HEAT_X + dGW.height;
                } else {
                    str2 = "unknown";
                }
                try {
                    dGz = this.mWl.dGz();
                    String valueOf2 = String.valueOf(this.mWf.dGc().dGU());
                    if (z || dz) {
                        size = eVar.getSize();
                    } else {
                        size = g(eVar);
                    }
                    dEY = (z || dz) ? com.facebook.imagepipeline.g.g.mUN : dEY();
                    this.mVU.fU(this.mWf.getId(), "DecodeProducer");
                    try {
                        com.facebook.imagepipeline.g.c a = m.this.mTb.a(eVar, size, dEY, this.mRn);
                        if (eVar.getSampleSize() != 1) {
                            i |= 16;
                        }
                        this.mVU.a(this.mWf.getId(), "DecodeProducer", a(a, dGz, dEY, Jm, str, str3, str2, valueOf));
                        a(a, i);
                    } catch (DecodeException e) {
                        com.facebook.imagepipeline.g.e encodedImage = e.getEncodedImage();
                        com.facebook.common.c.a.k("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", e.getMessage(), valueOf2, encodedImage.IR(10), Integer.valueOf(encodedImage.getSize()));
                        throw e;
                    }
                } catch (Exception e2) {
                    Map<String, String> a2 = a(null, dGz, dEY, Jm, str, str3, str2, valueOf);
                    this.mVU.a(this.mWf.getId(), "DecodeProducer", e2, a2);
                    this.mVU.a(this.mWf.dGc(), eVar, e2, a2);
                    H(e2);
                } finally {
                    com.facebook.imagepipeline.g.e.e(eVar);
                }
            }
        }

        private Map<String, String> a(@Nullable com.facebook.imagepipeline.g.c cVar, long j, com.facebook.imagepipeline.g.h hVar, boolean z, String str, String str2, String str3, String str4) {
            if (!this.mVU.QQ(this.mWf.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(hVar.dFl());
            String valueOf3 = String.valueOf(z);
            if (cVar instanceof com.facebook.imagepipeline.g.d) {
                Bitmap dEX = ((com.facebook.imagepipeline.g.d) cVar).dEX();
                HashMap hashMap = new HashMap(8);
                hashMap.put("bitmapSize", dEX.getWidth() + Config.EVENT_HEAT_X + dEX.getHeight());
                hashMap.put("queueTime", valueOf);
                hashMap.put("hasGoodQuality", valueOf2);
                hashMap.put("isFinal", valueOf3);
                hashMap.put("encodedImageSize", str2);
                hashMap.put("imageFormat", str);
                hashMap.put("requestedImageSize", str3);
                hashMap.put("sampleSize", str4);
                return ImmutableMap.copyOf((Map) hashMap);
            }
            HashMap hashMap2 = new HashMap(7);
            hashMap2.put("queueTime", valueOf);
            hashMap2.put("hasGoodQuality", valueOf2);
            hashMap2.put("isFinal", valueOf3);
            hashMap2.put("encodedImageSize", str2);
            hashMap2.put("imageFormat", str);
            hashMap2.put("requestedImageSize", str3);
            hashMap2.put("sampleSize", str4);
            return ImmutableMap.copyOf((Map) hashMap2);
        }

        private synchronized boolean isFinished() {
            return this.mVT;
        }

        private void wK(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.mVT) {
                        dGo().ay(1.0f);
                        this.mVT = true;
                        this.mWl.dGu();
                    }
                }
            }
        }

        private void a(com.facebook.imagepipeline.g.c cVar, int i) {
            com.facebook.common.references.a<com.facebook.imagepipeline.g.c> e = com.facebook.common.references.a.e(cVar);
            try {
                wK(Jm(i));
                dGo().h(e, i);
            } finally {
                com.facebook.common.references.a.c(e);
            }
        }

        private void H(Throwable th) {
            wK(true);
            dGo().G(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dGn() {
            wK(true);
            dGo().dzh();
        }
    }

    /* loaded from: classes12.dex */
    private class a extends c {
        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar, boolean z) {
            super(kVar, akVar, z);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            return Jn(i) ? false : super.b(eVar, i);
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected int g(com.facebook.imagepipeline.g.e eVar) {
            return eVar.getSize();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.g.h dEY() {
            return com.facebook.imagepipeline.g.g.i(0, false, false);
        }
    }

    /* loaded from: classes12.dex */
    private class b extends c {
        private final com.facebook.imagepipeline.decoder.d mTh;
        private final com.facebook.imagepipeline.decoder.e mWj;
        private int mWk;

        public b(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z) {
            super(kVar, akVar, z);
            this.mWj = (com.facebook.imagepipeline.decoder.e) com.facebook.common.internal.g.checkNotNull(eVar);
            this.mTh = (com.facebook.imagepipeline.decoder.d) com.facebook.common.internal.g.checkNotNull(dVar);
            this.mWk = 0;
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected synchronized boolean b(com.facebook.imagepipeline.g.e eVar, int i) {
            boolean b;
            b = super.b(eVar, i);
            if ((Jn(i) || dz(i, 8)) && !dz(i, 4) && com.facebook.imagepipeline.g.e.f(eVar) && eVar.dFf() == com.facebook.c.b.mPX) {
                if (this.mWj.a(eVar)) {
                    int dES = this.mWj.dES();
                    if (dES <= this.mWk) {
                        b = false;
                    } else if (dES >= this.mTh.IK(this.mWk) || this.mWj.dET()) {
                        this.mWk = dES;
                    } else {
                        b = false;
                    }
                } else {
                    b = false;
                }
            }
            return b;
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected int g(com.facebook.imagepipeline.g.e eVar) {
            return this.mWj.dER();
        }

        @Override // com.facebook.imagepipeline.producers.m.c
        protected com.facebook.imagepipeline.g.h dEY() {
            return this.mTh.IL(this.mWj.dES());
        }
    }
}
