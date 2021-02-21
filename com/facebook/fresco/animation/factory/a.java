package com.facebook.fresco.animation.factory;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import com.facebook.common.internal.j;
import com.facebook.common.time.b;
import com.facebook.imagepipeline.a.f;
import com.facebook.imagepipeline.animated.base.d;
import com.facebook.imagepipeline.b.h;
import com.facebook.imagepipeline.f.c;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes3.dex */
public class a implements com.facebook.imagepipeline.e.a {
    private final b pBx;
    private final h<com.facebook.cache.common.b, c> pFS;
    private final com.facebook.imagepipeline.animated.impl.b pFU;
    private final ExecutorService pFY;
    private final j<Integer> pFZ;
    private final ScheduledExecutorService pFa;
    private final f pFi;
    private final j<Integer> pGa;

    public a(com.facebook.imagepipeline.animated.impl.b bVar, ScheduledExecutorService scheduledExecutorService, ExecutorService executorService, b bVar2, f fVar, h<com.facebook.cache.common.b, c> hVar, j<Integer> jVar, j<Integer> jVar2) {
        this.pFU = bVar;
        this.pFa = scheduledExecutorService;
        this.pFY = executorService;
        this.pBx = bVar2;
        this.pFi = fVar;
        this.pFS = hVar;
        this.pFZ = jVar;
        this.pGa = jVar2;
    }

    @Override // com.facebook.imagepipeline.e.a
    public boolean a(c cVar) {
        return cVar instanceof com.facebook.imagepipeline.f.a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.imagepipeline.e.a
    /* renamed from: d */
    public com.facebook.fresco.animation.c.a b(c cVar) {
        return new com.facebook.fresco.animation.c.a(a(((com.facebook.imagepipeline.f.a) cVar).eyn()));
    }

    private com.facebook.fresco.animation.a.a a(d dVar) {
        com.facebook.fresco.animation.b.b.b bVar;
        com.facebook.fresco.animation.b.b.d dVar2;
        com.facebook.imagepipeline.animated.base.a b2 = b(dVar);
        com.facebook.fresco.animation.b.b c = c(dVar);
        com.facebook.fresco.animation.b.c.b bVar2 = new com.facebook.fresco.animation.b.c.b(c, b2);
        int intValue = this.pGa.get().intValue();
        if (intValue > 0) {
            dVar2 = new com.facebook.fresco.animation.b.b.d(intValue);
            bVar = a(bVar2);
        } else {
            bVar = null;
            dVar2 = null;
        }
        return com.facebook.fresco.animation.a.c.a(new com.facebook.fresco.animation.b.a(this.pFi, c, new com.facebook.fresco.animation.b.c.a(b2), bVar2, dVar2, bVar), this.pBx, this.pFa);
    }

    private com.facebook.fresco.animation.b.b.b a(com.facebook.fresco.animation.b.c cVar) {
        return new com.facebook.fresco.animation.b.b.c(this.pFi, cVar, Bitmap.Config.ARGB_8888, this.pFY);
    }

    private com.facebook.imagepipeline.animated.base.a b(d dVar) {
        com.facebook.imagepipeline.animated.base.b evF = dVar.evF();
        return this.pFU.a(dVar, new Rect(0, 0, evF.getWidth(), evF.getHeight()));
    }

    private com.facebook.fresco.animation.b.b c(d dVar) {
        switch (this.pFZ.get().intValue()) {
            case 1:
                return new com.facebook.fresco.animation.b.a.a(d(dVar), true);
            case 2:
                return new com.facebook.fresco.animation.b.a.a(d(dVar), false);
            case 3:
                return new com.facebook.fresco.animation.b.a.b();
            default:
                return new com.facebook.fresco.animation.b.a.c();
        }
    }

    private com.facebook.imagepipeline.animated.impl.c d(d dVar) {
        return new com.facebook.imagepipeline.animated.impl.c(new C1053a(dVar.hashCode()), this.pFS);
    }

    /* renamed from: com.facebook.fresco.animation.factory.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1053a implements com.facebook.cache.common.b {
        private final String pGb;

        public C1053a(int i) {
            this.pGb = "anim://" + i;
        }

        @Override // com.facebook.cache.common.b
        public boolean I(Uri uri) {
            return uri.toString().startsWith(this.pGb);
        }

        @Override // com.facebook.cache.common.b
        public String erU() {
            return this.pGb;
        }
    }
}
