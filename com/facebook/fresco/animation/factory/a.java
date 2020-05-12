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
    private final b lTO;
    private final ScheduledExecutorService lXC;
    private final f lXK;
    private final ExecutorService lYA;
    private final j<Integer> lYB;
    private final j<Integer> lYC;
    private final h<com.facebook.cache.common.b, c> lYu;
    private final com.facebook.imagepipeline.animated.impl.b lYw;

    public a(com.facebook.imagepipeline.animated.impl.b bVar, ScheduledExecutorService scheduledExecutorService, ExecutorService executorService, b bVar2, f fVar, h<com.facebook.cache.common.b, c> hVar, j<Integer> jVar, j<Integer> jVar2) {
        this.lYw = bVar;
        this.lXC = scheduledExecutorService;
        this.lYA = executorService;
        this.lTO = bVar2;
        this.lXK = fVar;
        this.lYu = hVar;
        this.lYB = jVar;
        this.lYC = jVar2;
    }

    @Override // com.facebook.imagepipeline.f.a
    public boolean a(c cVar) {
        return cVar instanceof com.facebook.imagepipeline.g.a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.imagepipeline.f.a
    /* renamed from: d */
    public com.facebook.fresco.animation.c.a b(c cVar) {
        return new com.facebook.fresco.animation.c.a(a(((com.facebook.imagepipeline.g.a) cVar).dsK()));
    }

    private com.facebook.fresco.animation.a.a a(d dVar) {
        com.facebook.fresco.animation.b.b.d dVar2;
        com.facebook.fresco.animation.b.b.b bVar = null;
        com.facebook.imagepipeline.animated.base.a b = b(dVar);
        com.facebook.fresco.animation.b.b c = c(dVar);
        com.facebook.fresco.animation.b.c.b bVar2 = new com.facebook.fresco.animation.b.c.b(c, b);
        int intValue = this.lYC.get().intValue();
        if (intValue > 0) {
            dVar2 = new com.facebook.fresco.animation.b.b.d(intValue);
            bVar = a(bVar2);
        } else {
            dVar2 = null;
        }
        return com.facebook.fresco.animation.a.c.a(new com.facebook.fresco.animation.b.a(this.lXK, c, new com.facebook.fresco.animation.b.c.a(b), bVar2, dVar2, bVar), this.lTO, this.lXC);
    }

    private com.facebook.fresco.animation.b.b.b a(com.facebook.fresco.animation.b.c cVar) {
        return new com.facebook.fresco.animation.b.b.c(this.lXK, cVar, Bitmap.Config.ARGB_8888, this.lYA);
    }

    private com.facebook.imagepipeline.animated.base.a b(d dVar) {
        com.facebook.imagepipeline.animated.base.b dqa = dVar.dqa();
        return this.lYw.a(dVar, new Rect(0, 0, dqa.getWidth(), dqa.getHeight()));
    }

    private com.facebook.fresco.animation.b.b c(d dVar) {
        switch (this.lYB.get().intValue()) {
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
        return new com.facebook.imagepipeline.animated.impl.c(new C0729a(dVar.hashCode()), this.lYu);
    }

    /* renamed from: com.facebook.fresco.animation.factory.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static class C0729a implements com.facebook.cache.common.b {
        private final String lYD;

        public C0729a(int i) {
            this.lYD = "anim://" + i;
        }

        @Override // com.facebook.cache.common.b
        public boolean E(Uri uri) {
            return uri.toString().startsWith(this.lYD);
        }

        @Override // com.facebook.cache.common.b
        public String dmi() {
            return this.lYD;
        }
    }
}
