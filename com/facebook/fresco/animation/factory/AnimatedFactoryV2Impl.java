package com.facebook.fresco.animation.factory;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.common.b.i;
import com.facebook.common.internal.d;
import com.facebook.common.internal.j;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.imagepipeline.a.f;
import com.facebook.imagepipeline.animated.impl.b;
import com.facebook.imagepipeline.b.h;
import com.facebook.imagepipeline.c.e;
import com.facebook.imagepipeline.f.c;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@d
@NotThreadSafe
/* loaded from: classes12.dex */
public class AnimatedFactoryV2Impl implements com.facebook.imagepipeline.animated.a.a {
    @Nullable
    private com.facebook.imagepipeline.e.a pdo;
    private final f phL;
    @Nullable
    private b piA;
    @Nullable
    private com.facebook.imagepipeline.animated.b.a piB;
    private final e pix;
    private final h<com.facebook.cache.common.b, c> piy;
    @Nullable
    private com.facebook.imagepipeline.animated.a.d piz;

    @d
    public AnimatedFactoryV2Impl(f fVar, e eVar, h<com.facebook.cache.common.b, c> hVar) {
        this.phL = fVar;
        this.pix = eVar;
        this.piy = hVar;
    }

    @Override // com.facebook.imagepipeline.animated.a.a
    @Nullable
    public com.facebook.imagepipeline.e.a hH(Context context) {
        if (this.pdo == null) {
            this.pdo = esB();
        }
        return this.pdo;
    }

    @Override // com.facebook.imagepipeline.animated.a.a
    public com.facebook.imagepipeline.decoder.b a(final Bitmap.Config config) {
        return new com.facebook.imagepipeline.decoder.b() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.1
            @Override // com.facebook.imagepipeline.decoder.b
            public c a(com.facebook.imagepipeline.f.e eVar, int i, com.facebook.imagepipeline.f.h hVar, com.facebook.imagepipeline.common.b bVar) {
                return AnimatedFactoryV2Impl.this.esD().a(eVar, bVar, config);
            }
        };
    }

    @Override // com.facebook.imagepipeline.animated.a.a
    public com.facebook.imagepipeline.decoder.b b(final Bitmap.Config config) {
        return new com.facebook.imagepipeline.decoder.b() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.2
            @Override // com.facebook.imagepipeline.decoder.b
            public c a(com.facebook.imagepipeline.f.e eVar, int i, com.facebook.imagepipeline.f.h hVar, com.facebook.imagepipeline.common.b bVar) {
                return AnimatedFactoryV2Impl.this.esD().b(eVar, bVar, config);
            }
        };
    }

    private a esB() {
        j<Integer> jVar = new j<Integer>() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: esG */
            public Integer get() {
                return 2;
            }
        };
        return new a(esE(), i.epO(), new com.facebook.common.b.c(this.pix.etJ()), RealtimeSinceBootClock.get(), this.phL, this.piy, jVar, new j<Integer>() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: esG */
            public Integer get() {
                return 3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.facebook.imagepipeline.animated.b.a esC() {
        if (this.piB == null) {
            this.piB = new com.facebook.imagepipeline.animated.b.a();
        }
        return this.piB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.facebook.imagepipeline.animated.a.d esD() {
        if (this.piz == null) {
            this.piz = esF();
        }
        return this.piz;
    }

    private b esE() {
        if (this.piA == null) {
            this.piA = new b() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.5
                @Override // com.facebook.imagepipeline.animated.impl.b
                public com.facebook.imagepipeline.animated.base.a a(com.facebook.imagepipeline.animated.base.d dVar, Rect rect) {
                    return new com.facebook.imagepipeline.animated.impl.a(AnimatedFactoryV2Impl.this.esC(), dVar, rect);
                }
            };
        }
        return this.piA;
    }

    private com.facebook.imagepipeline.animated.a.d esF() {
        return new com.facebook.imagepipeline.animated.a.e(new b() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.6
            @Override // com.facebook.imagepipeline.animated.impl.b
            public com.facebook.imagepipeline.animated.base.a a(com.facebook.imagepipeline.animated.base.d dVar, Rect rect) {
                return new com.facebook.imagepipeline.animated.impl.a(AnimatedFactoryV2Impl.this.esC(), dVar, rect);
            }
        }, this.phL);
    }
}
