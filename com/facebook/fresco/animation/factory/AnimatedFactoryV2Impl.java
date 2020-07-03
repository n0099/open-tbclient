package com.facebook.fresco.animation.factory;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.common.b.i;
import com.facebook.common.internal.d;
import com.facebook.common.internal.j;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.imagepipeline.animated.impl.b;
import com.facebook.imagepipeline.b.f;
import com.facebook.imagepipeline.c.h;
import com.facebook.imagepipeline.d.e;
import com.facebook.imagepipeline.g.c;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@d
@NotThreadSafe
/* loaded from: classes13.dex */
public class AnimatedFactoryV2Impl implements com.facebook.imagepipeline.animated.a.a {
    @Nullable
    private com.facebook.imagepipeline.f.a mKb;
    private final f mOM;
    @Nullable
    private b mPA;
    @Nullable
    private com.facebook.imagepipeline.animated.b.a mPB;
    private final e mPx;
    private final h<com.facebook.cache.common.b, c> mPy;
    @Nullable
    private com.facebook.imagepipeline.animated.a.d mPz;

    @d
    public AnimatedFactoryV2Impl(f fVar, e eVar, h<com.facebook.cache.common.b, c> hVar) {
        this.mOM = fVar;
        this.mPx = eVar;
        this.mPy = hVar;
    }

    @Override // com.facebook.imagepipeline.animated.a.a
    @Nullable
    public com.facebook.imagepipeline.f.a fW(Context context) {
        if (this.mKb == null) {
            this.mKb = dBW();
        }
        return this.mKb;
    }

    @Override // com.facebook.imagepipeline.animated.a.a
    public com.facebook.imagepipeline.decoder.b a(final Bitmap.Config config) {
        return new com.facebook.imagepipeline.decoder.b() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.1
            @Override // com.facebook.imagepipeline.decoder.b
            public c a(com.facebook.imagepipeline.g.e eVar, int i, com.facebook.imagepipeline.g.h hVar, com.facebook.imagepipeline.common.b bVar) {
                return AnimatedFactoryV2Impl.this.dBY().a(eVar, bVar, config);
            }
        };
    }

    @Override // com.facebook.imagepipeline.animated.a.a
    public com.facebook.imagepipeline.decoder.b b(final Bitmap.Config config) {
        return new com.facebook.imagepipeline.decoder.b() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.2
            @Override // com.facebook.imagepipeline.decoder.b
            public c a(com.facebook.imagepipeline.g.e eVar, int i, com.facebook.imagepipeline.g.h hVar, com.facebook.imagepipeline.common.b bVar) {
                return AnimatedFactoryV2Impl.this.dBY().b(eVar, bVar, config);
            }
        };
    }

    private a dBW() {
        j<Integer> jVar = new j<Integer>() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: dCb */
            public Integer get() {
                return 2;
            }
        };
        return new a(dBZ(), i.dze(), new com.facebook.common.b.c(this.mPx.dDi()), RealtimeSinceBootClock.get(), this.mOM, this.mPy, jVar, new j<Integer>() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: dCb */
            public Integer get() {
                return 3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.facebook.imagepipeline.animated.b.a dBX() {
        if (this.mPB == null) {
            this.mPB = new com.facebook.imagepipeline.animated.b.a();
        }
        return this.mPB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.facebook.imagepipeline.animated.a.d dBY() {
        if (this.mPz == null) {
            this.mPz = dCa();
        }
        return this.mPz;
    }

    private b dBZ() {
        if (this.mPA == null) {
            this.mPA = new b() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.5
                @Override // com.facebook.imagepipeline.animated.impl.b
                public com.facebook.imagepipeline.animated.base.a a(com.facebook.imagepipeline.animated.base.d dVar, Rect rect) {
                    return new com.facebook.imagepipeline.animated.impl.a(AnimatedFactoryV2Impl.this.dBX(), dVar, rect);
                }
            };
        }
        return this.mPA;
    }

    private com.facebook.imagepipeline.animated.a.d dCa() {
        return new com.facebook.imagepipeline.animated.a.e(new b() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.6
            @Override // com.facebook.imagepipeline.animated.impl.b
            public com.facebook.imagepipeline.animated.base.a a(com.facebook.imagepipeline.animated.base.d dVar, Rect rect) {
                return new com.facebook.imagepipeline.animated.impl.a(AnimatedFactoryV2Impl.this.dBX(), dVar, rect);
            }
        }, this.mOM);
    }
}
