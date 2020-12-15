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
/* loaded from: classes12.dex */
public class a implements com.facebook.imagepipeline.e.a {
    private final b pec;
    private final ScheduledExecutorService phD;
    private final f phL;
    private final com.facebook.imagepipeline.animated.impl.b piA;
    private final ExecutorService piE;
    private final j<Integer> piF;
    private final j<Integer> piG;
    private final h<com.facebook.cache.common.b, c> piy;

    public a(com.facebook.imagepipeline.animated.impl.b bVar, ScheduledExecutorService scheduledExecutorService, ExecutorService executorService, b bVar2, f fVar, h<com.facebook.cache.common.b, c> hVar, j<Integer> jVar, j<Integer> jVar2) {
        this.piA = bVar;
        this.phD = scheduledExecutorService;
        this.piE = executorService;
        this.pec = bVar2;
        this.phL = fVar;
        this.piy = hVar;
        this.piF = jVar;
        this.piG = jVar2;
    }

    @Override // com.facebook.imagepipeline.e.a
    public boolean a(c cVar) {
        return cVar instanceof com.facebook.imagepipeline.f.a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.imagepipeline.e.a
    /* renamed from: d */
    public com.facebook.fresco.animation.c.a b(c cVar) {
        return new com.facebook.fresco.animation.c.a(a(((com.facebook.imagepipeline.f.a) cVar).evt()));
    }

    private com.facebook.fresco.animation.a.a a(d dVar) {
        com.facebook.fresco.animation.b.b.d dVar2;
        com.facebook.fresco.animation.b.b.b bVar = null;
        com.facebook.imagepipeline.animated.base.a b = b(dVar);
        com.facebook.fresco.animation.b.b c = c(dVar);
        com.facebook.fresco.animation.b.c.b bVar2 = new com.facebook.fresco.animation.b.c.b(c, b);
        int intValue = this.piG.get().intValue();
        if (intValue > 0) {
            dVar2 = new com.facebook.fresco.animation.b.b.d(intValue);
            bVar = a(bVar2);
        } else {
            dVar2 = null;
        }
        return com.facebook.fresco.animation.a.c.a(new com.facebook.fresco.animation.b.a(this.phL, c, new com.facebook.fresco.animation.b.c.a(b), bVar2, dVar2, bVar), this.pec, this.phD);
    }

    private com.facebook.fresco.animation.b.b.b a(com.facebook.fresco.animation.b.c cVar) {
        return new com.facebook.fresco.animation.b.b.c(this.phL, cVar, Bitmap.Config.ARGB_8888, this.piE);
    }

    private com.facebook.imagepipeline.animated.base.a b(d dVar) {
        com.facebook.imagepipeline.animated.base.b esN = dVar.esN();
        return this.piA.a(dVar, new Rect(0, 0, esN.getWidth(), esN.getHeight()));
    }

    private com.facebook.fresco.animation.b.b c(d dVar) {
        switch (this.piF.get().intValue()) {
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
        return new com.facebook.imagepipeline.animated.impl.c(new C0997a(dVar.hashCode()), this.piy);
    }

    /* renamed from: com.facebook.fresco.animation.factory.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static class C0997a implements com.facebook.cache.common.b {
        private final String piH;

        public C0997a(int i) {
            this.piH = "anim://" + i;
        }

        @Override // com.facebook.cache.common.b
        public boolean K(Uri uri) {
            return uri.toString().startsWith(this.piH);
        }

        @Override // com.facebook.cache.common.b
        public String epd() {
            return this.piH;
        }
    }
}
