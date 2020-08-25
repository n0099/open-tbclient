package com.facebook.fresco.animation.factory;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.cache.common.b;
import com.facebook.common.b.i;
import com.facebook.common.internal.d;
import com.facebook.common.internal.j;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.imagepipeline.b.f;
import com.facebook.imagepipeline.c.h;
import com.facebook.imagepipeline.d.e;
import com.facebook.imagepipeline.g.c;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@d
@NotThreadSafe
/* loaded from: classes3.dex */
public class AnimatedFactoryV2Impl implements com.facebook.imagepipeline.animated.a.a {
    @Nullable
    private com.facebook.imagepipeline.f.a nmd;
    private final f nqQ;
    private final h<b, c> nrA;
    @Nullable
    private com.facebook.imagepipeline.animated.a.d nrB;
    @Nullable
    private com.facebook.imagepipeline.animated.impl.b nrC;
    @Nullable
    private com.facebook.imagepipeline.animated.b.a nrD;
    private final e nrz;

    @d
    public AnimatedFactoryV2Impl(f fVar, e eVar, h<b, c> hVar) {
        this.nqQ = fVar;
        this.nrz = eVar;
        this.nrA = hVar;
    }

    @Override // com.facebook.imagepipeline.animated.a.a
    @Nullable
    public com.facebook.imagepipeline.f.a gs(Context context) {
        if (this.nmd == null) {
            this.nmd = dRm();
        }
        return this.nmd;
    }

    @Override // com.facebook.imagepipeline.animated.a.a
    public com.facebook.imagepipeline.decoder.b a(final Bitmap.Config config) {
        return new com.facebook.imagepipeline.decoder.b() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.1
            @Override // com.facebook.imagepipeline.decoder.b
            public c a(com.facebook.imagepipeline.g.e eVar, int i, com.facebook.imagepipeline.g.h hVar, com.facebook.imagepipeline.common.b bVar) {
                return AnimatedFactoryV2Impl.this.dRo().a(eVar, bVar, config);
            }
        };
    }

    @Override // com.facebook.imagepipeline.animated.a.a
    public com.facebook.imagepipeline.decoder.b b(final Bitmap.Config config) {
        return new com.facebook.imagepipeline.decoder.b() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.2
            @Override // com.facebook.imagepipeline.decoder.b
            public c a(com.facebook.imagepipeline.g.e eVar, int i, com.facebook.imagepipeline.g.h hVar, com.facebook.imagepipeline.common.b bVar) {
                return AnimatedFactoryV2Impl.this.dRo().b(eVar, bVar, config);
            }
        };
    }

    private a dRm() {
        j<Integer> jVar = new j<Integer>() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: dRr */
            public Integer get() {
                return 2;
            }
        };
        return new a(dRp(), i.dOv(), new com.facebook.common.b.c(this.nrz.dSy()), RealtimeSinceBootClock.get(), this.nqQ, this.nrA, jVar, new j<Integer>() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: dRr */
            public Integer get() {
                return 3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.facebook.imagepipeline.animated.b.a dRn() {
        if (this.nrD == null) {
            this.nrD = new com.facebook.imagepipeline.animated.b.a();
        }
        return this.nrD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.facebook.imagepipeline.animated.a.d dRo() {
        if (this.nrB == null) {
            this.nrB = dRq();
        }
        return this.nrB;
    }

    private com.facebook.imagepipeline.animated.impl.b dRp() {
        if (this.nrC == null) {
            this.nrC = new com.facebook.imagepipeline.animated.impl.b() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.5
                @Override // com.facebook.imagepipeline.animated.impl.b
                public com.facebook.imagepipeline.animated.base.a a(com.facebook.imagepipeline.animated.base.d dVar, Rect rect) {
                    return new com.facebook.imagepipeline.animated.impl.a(AnimatedFactoryV2Impl.this.dRn(), dVar, rect);
                }
            };
        }
        return this.nrC;
    }

    private com.facebook.imagepipeline.animated.a.d dRq() {
        return new com.facebook.imagepipeline.animated.a.e(new com.facebook.imagepipeline.animated.impl.b() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.6
            @Override // com.facebook.imagepipeline.animated.impl.b
            public com.facebook.imagepipeline.animated.base.a a(com.facebook.imagepipeline.animated.base.d dVar, Rect rect) {
                return new com.facebook.imagepipeline.animated.impl.a(AnimatedFactoryV2Impl.this.dRn(), dVar, rect);
            }
        }, this.nqQ);
    }
}
