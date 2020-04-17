package com.facebook.fresco.animation.factory;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import com.facebook.common.internal.j;
import com.facebook.common.time.b;
import com.facebook.imagepipeline.animated.base.d;
import com.facebook.imagepipeline.b.f;
import com.facebook.imagepipeline.c.h;
import com.facebook.imagepipeline.g.c;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes13.dex */
public class a implements com.facebook.imagepipeline.f.a {
    private final b lTK;
    private final f lXG;
    private final ScheduledExecutorService lXy;
    private final h<com.facebook.cache.common.b, c> lYq;
    private final com.facebook.imagepipeline.animated.impl.b lYs;
    private final ExecutorService lYw;
    private final j<Integer> lYx;
    private final j<Integer> lYy;

    public a(com.facebook.imagepipeline.animated.impl.b bVar, ScheduledExecutorService scheduledExecutorService, ExecutorService executorService, b bVar2, f fVar, h<com.facebook.cache.common.b, c> hVar, j<Integer> jVar, j<Integer> jVar2) {
        this.lYs = bVar;
        this.lXy = scheduledExecutorService;
        this.lYw = executorService;
        this.lTK = bVar2;
        this.lXG = fVar;
        this.lYq = hVar;
        this.lYx = jVar;
        this.lYy = jVar2;
    }

    @Override // com.facebook.imagepipeline.f.a
    public boolean a(c cVar) {
        return cVar instanceof com.facebook.imagepipeline.g.a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.imagepipeline.f.a
    /* renamed from: d */
    public com.facebook.fresco.animation.c.a b(c cVar) {
        return new com.facebook.fresco.animation.c.a(a(((com.facebook.imagepipeline.g.a) cVar).dsM()));
    }

    private com.facebook.fresco.animation.a.a a(d dVar) {
        com.facebook.fresco.animation.b.b.d dVar2;
        com.facebook.fresco.animation.b.b.b bVar = null;
        com.facebook.imagepipeline.animated.base.a b = b(dVar);
        com.facebook.fresco.animation.b.b c = c(dVar);
        com.facebook.fresco.animation.b.c.b bVar2 = new com.facebook.fresco.animation.b.c.b(c, b);
        int intValue = this.lYy.get().intValue();
        if (intValue > 0) {
            dVar2 = new com.facebook.fresco.animation.b.b.d(intValue);
            bVar = a(bVar2);
        } else {
            dVar2 = null;
        }
        return com.facebook.fresco.animation.a.c.a(new com.facebook.fresco.animation.b.a(this.lXG, c, new com.facebook.fresco.animation.b.c.a(b), bVar2, dVar2, bVar), this.lTK, this.lXy);
    }

    private com.facebook.fresco.animation.b.b.b a(com.facebook.fresco.animation.b.c cVar) {
        return new com.facebook.fresco.animation.b.b.c(this.lXG, cVar, Bitmap.Config.ARGB_8888, this.lYw);
    }

    private com.facebook.imagepipeline.animated.base.a b(d dVar) {
        com.facebook.imagepipeline.animated.base.b dqc = dVar.dqc();
        return this.lYs.a(dVar, new Rect(0, 0, dqc.getWidth(), dqc.getHeight()));
    }

    private com.facebook.fresco.animation.b.b c(d dVar) {
        switch (this.lYx.get().intValue()) {
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
        return new com.facebook.imagepipeline.animated.impl.c(new C0708a(dVar.hashCode()), this.lYq);
    }

    /* renamed from: com.facebook.fresco.animation.factory.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static class C0708a implements com.facebook.cache.common.b {
        private final String lYz;

        public C0708a(int i) {
            this.lYz = "anim://" + i;
        }

        @Override // com.facebook.cache.common.b
        public boolean E(Uri uri) {
            return uri.toString().startsWith(this.lYz);
        }

        @Override // com.facebook.cache.common.b
        public String dmk() {
            return this.lYz;
        }
    }
}
