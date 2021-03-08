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
/* loaded from: classes14.dex */
public class a implements com.facebook.imagepipeline.e.a {
    private final b pDC;
    private final h<com.facebook.cache.common.b, c> pHX;
    private final com.facebook.imagepipeline.animated.impl.b pHZ;
    private final ScheduledExecutorService pHf;
    private final f pHn;
    private final ExecutorService pId;
    private final j<Integer> pIe;
    private final j<Integer> pIf;

    public a(com.facebook.imagepipeline.animated.impl.b bVar, ScheduledExecutorService scheduledExecutorService, ExecutorService executorService, b bVar2, f fVar, h<com.facebook.cache.common.b, c> hVar, j<Integer> jVar, j<Integer> jVar2) {
        this.pHZ = bVar;
        this.pHf = scheduledExecutorService;
        this.pId = executorService;
        this.pDC = bVar2;
        this.pHn = fVar;
        this.pHX = hVar;
        this.pIe = jVar;
        this.pIf = jVar2;
    }

    @Override // com.facebook.imagepipeline.e.a
    public boolean a(c cVar) {
        return cVar instanceof com.facebook.imagepipeline.f.a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.imagepipeline.e.a
    /* renamed from: d */
    public com.facebook.fresco.animation.c.a b(c cVar) {
        return new com.facebook.fresco.animation.c.a(a(((com.facebook.imagepipeline.f.a) cVar).eyw()));
    }

    private com.facebook.fresco.animation.a.a a(d dVar) {
        com.facebook.fresco.animation.b.b.b bVar;
        com.facebook.fresco.animation.b.b.d dVar2;
        com.facebook.imagepipeline.animated.base.a b = b(dVar);
        com.facebook.fresco.animation.b.b c = c(dVar);
        com.facebook.fresco.animation.b.c.b bVar2 = new com.facebook.fresco.animation.b.c.b(c, b);
        int intValue = this.pIf.get().intValue();
        if (intValue > 0) {
            dVar2 = new com.facebook.fresco.animation.b.b.d(intValue);
            bVar = a(bVar2);
        } else {
            bVar = null;
            dVar2 = null;
        }
        return com.facebook.fresco.animation.a.c.a(new com.facebook.fresco.animation.b.a(this.pHn, c, new com.facebook.fresco.animation.b.c.a(b), bVar2, dVar2, bVar), this.pDC, this.pHf);
    }

    private com.facebook.fresco.animation.b.b.b a(com.facebook.fresco.animation.b.c cVar) {
        return new com.facebook.fresco.animation.b.b.c(this.pHn, cVar, Bitmap.Config.ARGB_8888, this.pId);
    }

    private com.facebook.imagepipeline.animated.base.a b(d dVar) {
        com.facebook.imagepipeline.animated.base.b evO = dVar.evO();
        return this.pHZ.a(dVar, new Rect(0, 0, evO.getWidth(), evO.getHeight()));
    }

    private com.facebook.fresco.animation.b.b c(d dVar) {
        switch (this.pIe.get().intValue()) {
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
        return new com.facebook.imagepipeline.animated.impl.c(new C1068a(dVar.hashCode()), this.pHX);
    }

    /* renamed from: com.facebook.fresco.animation.factory.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static class C1068a implements com.facebook.cache.common.b {
        private final String pIg;

        public C1068a(int i) {
            this.pIg = "anim://" + i;
        }

        @Override // com.facebook.cache.common.b
        public boolean I(Uri uri) {
            return uri.toString().startsWith(this.pIg);
        }

        @Override // com.facebook.cache.common.b
        public String esd() {
            return this.pIg;
        }
    }
}
