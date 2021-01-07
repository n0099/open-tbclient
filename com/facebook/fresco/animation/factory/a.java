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
/* loaded from: classes5.dex */
public class a implements com.facebook.imagepipeline.e.a {
    private final b pvp;
    private final ScheduledExecutorService pyS;
    private final h<com.facebook.cache.common.b, c> pzK;
    private final com.facebook.imagepipeline.animated.impl.b pzM;
    private final ExecutorService pzQ;
    private final j<Integer> pzR;
    private final j<Integer> pzS;
    private final f pza;

    public a(com.facebook.imagepipeline.animated.impl.b bVar, ScheduledExecutorService scheduledExecutorService, ExecutorService executorService, b bVar2, f fVar, h<com.facebook.cache.common.b, c> hVar, j<Integer> jVar, j<Integer> jVar2) {
        this.pzM = bVar;
        this.pyS = scheduledExecutorService;
        this.pzQ = executorService;
        this.pvp = bVar2;
        this.pza = fVar;
        this.pzK = hVar;
        this.pzR = jVar;
        this.pzS = jVar2;
    }

    @Override // com.facebook.imagepipeline.e.a
    public boolean a(c cVar) {
        return cVar instanceof com.facebook.imagepipeline.f.a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.imagepipeline.e.a
    /* renamed from: d */
    public com.facebook.fresco.animation.c.a b(c cVar) {
        return new com.facebook.fresco.animation.c.a(a(((com.facebook.imagepipeline.f.a) cVar).ezE()));
    }

    private com.facebook.fresco.animation.a.a a(d dVar) {
        com.facebook.fresco.animation.b.b.b bVar;
        com.facebook.fresco.animation.b.b.d dVar2;
        com.facebook.imagepipeline.animated.base.a b2 = b(dVar);
        com.facebook.fresco.animation.b.b c = c(dVar);
        com.facebook.fresco.animation.b.c.b bVar2 = new com.facebook.fresco.animation.b.c.b(c, b2);
        int intValue = this.pzS.get().intValue();
        if (intValue > 0) {
            dVar2 = new com.facebook.fresco.animation.b.b.d(intValue);
            bVar = a(bVar2);
        } else {
            bVar = null;
            dVar2 = null;
        }
        return com.facebook.fresco.animation.a.c.a(new com.facebook.fresco.animation.b.a(this.pza, c, new com.facebook.fresco.animation.b.c.a(b2), bVar2, dVar2, bVar), this.pvp, this.pyS);
    }

    private com.facebook.fresco.animation.b.b.b a(com.facebook.fresco.animation.b.c cVar) {
        return new com.facebook.fresco.animation.b.b.c(this.pza, cVar, Bitmap.Config.ARGB_8888, this.pzQ);
    }

    private com.facebook.imagepipeline.animated.base.a b(d dVar) {
        com.facebook.imagepipeline.animated.base.b ewX = dVar.ewX();
        return this.pzM.a(dVar, new Rect(0, 0, ewX.getWidth(), ewX.getHeight()));
    }

    private com.facebook.fresco.animation.b.b c(d dVar) {
        switch (this.pzR.get().intValue()) {
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
        return new com.facebook.imagepipeline.animated.impl.c(new C1064a(dVar.hashCode()), this.pzK);
    }

    /* renamed from: com.facebook.fresco.animation.factory.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1064a implements com.facebook.cache.common.b {
        private final String pzT;

        public C1064a(int i) {
            this.pzT = "anim://" + i;
        }

        @Override // com.facebook.cache.common.b
        public boolean L(Uri uri) {
            return uri.toString().startsWith(this.pzT);
        }

        @Override // com.facebook.cache.common.b
        public String etn() {
            return this.pzT;
        }
    }
}
