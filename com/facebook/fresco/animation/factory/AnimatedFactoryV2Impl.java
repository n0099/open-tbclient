package com.facebook.fresco.animation.factory;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.cache.common.b;
import com.facebook.common.b.i;
import com.facebook.common.internal.d;
import com.facebook.common.internal.j;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.imagepipeline.a.f;
import com.facebook.imagepipeline.b.h;
import com.facebook.imagepipeline.c.e;
import com.facebook.imagepipeline.f.c;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@d
@NotThreadSafe
/* loaded from: classes3.dex */
public class AnimatedFactoryV2Impl implements com.facebook.imagepipeline.animated.a.a {
    @Nullable
    private com.facebook.imagepipeline.e.a pAJ;
    private final e pFR;
    private final h<b, c> pFS;
    @Nullable
    private com.facebook.imagepipeline.animated.a.d pFT;
    @Nullable
    private com.facebook.imagepipeline.animated.impl.b pFU;
    @Nullable
    private com.facebook.imagepipeline.animated.b.a pFV;
    private final f pFi;

    @d
    public AnimatedFactoryV2Impl(f fVar, e eVar, h<b, c> hVar) {
        this.pFi = fVar;
        this.pFR = eVar;
        this.pFS = hVar;
    }

    @Override // com.facebook.imagepipeline.animated.a.a
    @Nullable
    public com.facebook.imagepipeline.e.a ik(Context context) {
        if (this.pAJ == null) {
            this.pAJ = evt();
        }
        return this.pAJ;
    }

    @Override // com.facebook.imagepipeline.animated.a.a
    public com.facebook.imagepipeline.decoder.b c(final Bitmap.Config config) {
        return new com.facebook.imagepipeline.decoder.b() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.1
            @Override // com.facebook.imagepipeline.decoder.b
            public c a(com.facebook.imagepipeline.f.e eVar, int i, com.facebook.imagepipeline.f.h hVar, com.facebook.imagepipeline.common.b bVar) {
                return AnimatedFactoryV2Impl.this.evv().a(eVar, bVar, config);
            }
        };
    }

    @Override // com.facebook.imagepipeline.animated.a.a
    public com.facebook.imagepipeline.decoder.b d(final Bitmap.Config config) {
        return new com.facebook.imagepipeline.decoder.b() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.2
            @Override // com.facebook.imagepipeline.decoder.b
            public c a(com.facebook.imagepipeline.f.e eVar, int i, com.facebook.imagepipeline.f.h hVar, com.facebook.imagepipeline.common.b bVar) {
                return AnimatedFactoryV2Impl.this.evv().b(eVar, bVar, config);
            }
        };
    }

    private a evt() {
        j<Integer> jVar = new j<Integer>() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: evy */
            public Integer get() {
                return 2;
            }
        };
        return new a(evw(), i.esE(), new com.facebook.common.b.c(this.pFR.ewC()), RealtimeSinceBootClock.get(), this.pFi, this.pFS, jVar, new j<Integer>() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: evy */
            public Integer get() {
                return 3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.facebook.imagepipeline.animated.b.a evu() {
        if (this.pFV == null) {
            this.pFV = new com.facebook.imagepipeline.animated.b.a();
        }
        return this.pFV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.facebook.imagepipeline.animated.a.d evv() {
        if (this.pFT == null) {
            this.pFT = evx();
        }
        return this.pFT;
    }

    private com.facebook.imagepipeline.animated.impl.b evw() {
        if (this.pFU == null) {
            this.pFU = new com.facebook.imagepipeline.animated.impl.b() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.5
                @Override // com.facebook.imagepipeline.animated.impl.b
                public com.facebook.imagepipeline.animated.base.a a(com.facebook.imagepipeline.animated.base.d dVar, Rect rect) {
                    return new com.facebook.imagepipeline.animated.impl.a(AnimatedFactoryV2Impl.this.evu(), dVar, rect);
                }
            };
        }
        return this.pFU;
    }

    private com.facebook.imagepipeline.animated.a.d evx() {
        return new com.facebook.imagepipeline.animated.a.e(new com.facebook.imagepipeline.animated.impl.b() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.6
            @Override // com.facebook.imagepipeline.animated.impl.b
            public com.facebook.imagepipeline.animated.base.a a(com.facebook.imagepipeline.animated.base.d dVar, Rect rect) {
                return new com.facebook.imagepipeline.animated.impl.a(AnimatedFactoryV2Impl.this.evu(), dVar, rect);
            }
        }, this.pFi);
    }
}
