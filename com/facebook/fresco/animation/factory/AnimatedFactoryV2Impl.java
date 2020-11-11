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
/* loaded from: classes12.dex */
public class AnimatedFactoryV2Impl implements com.facebook.imagepipeline.animated.a.a {
    @Nullable
    private com.facebook.imagepipeline.f.a oMA;
    private final e oRT;
    private final h<b, c> oRU;
    @Nullable
    private com.facebook.imagepipeline.animated.a.d oRV;
    @Nullable
    private com.facebook.imagepipeline.animated.impl.b oRW;
    @Nullable
    private com.facebook.imagepipeline.animated.b.a oRX;
    private final f oRk;

    @d
    public AnimatedFactoryV2Impl(f fVar, e eVar, h<b, c> hVar) {
        this.oRk = fVar;
        this.oRT = eVar;
        this.oRU = hVar;
    }

    @Override // com.facebook.imagepipeline.animated.a.a
    @Nullable
    public com.facebook.imagepipeline.f.a ha(Context context) {
        if (this.oMA == null) {
            this.oMA = emR();
        }
        return this.oMA;
    }

    @Override // com.facebook.imagepipeline.animated.a.a
    public com.facebook.imagepipeline.decoder.b a(final Bitmap.Config config) {
        return new com.facebook.imagepipeline.decoder.b() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.1
            @Override // com.facebook.imagepipeline.decoder.b
            public c a(com.facebook.imagepipeline.g.e eVar, int i, com.facebook.imagepipeline.g.h hVar, com.facebook.imagepipeline.common.b bVar) {
                return AnimatedFactoryV2Impl.this.emT().a(eVar, bVar, config);
            }
        };
    }

    @Override // com.facebook.imagepipeline.animated.a.a
    public com.facebook.imagepipeline.decoder.b b(final Bitmap.Config config) {
        return new com.facebook.imagepipeline.decoder.b() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.2
            @Override // com.facebook.imagepipeline.decoder.b
            public c a(com.facebook.imagepipeline.g.e eVar, int i, com.facebook.imagepipeline.g.h hVar, com.facebook.imagepipeline.common.b bVar) {
                return AnimatedFactoryV2Impl.this.emT().b(eVar, bVar, config);
            }
        };
    }

    private a emR() {
        j<Integer> jVar = new j<Integer>() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: emW */
            public Integer get() {
                return 2;
            }
        };
        return new a(emU(), i.eka(), new com.facebook.common.b.c(this.oRT.eoe()), RealtimeSinceBootClock.get(), this.oRk, this.oRU, jVar, new j<Integer>() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: emW */
            public Integer get() {
                return 3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.facebook.imagepipeline.animated.b.a emS() {
        if (this.oRX == null) {
            this.oRX = new com.facebook.imagepipeline.animated.b.a();
        }
        return this.oRX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.facebook.imagepipeline.animated.a.d emT() {
        if (this.oRV == null) {
            this.oRV = emV();
        }
        return this.oRV;
    }

    private com.facebook.imagepipeline.animated.impl.b emU() {
        if (this.oRW == null) {
            this.oRW = new com.facebook.imagepipeline.animated.impl.b() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.5
                @Override // com.facebook.imagepipeline.animated.impl.b
                public com.facebook.imagepipeline.animated.base.a a(com.facebook.imagepipeline.animated.base.d dVar, Rect rect) {
                    return new com.facebook.imagepipeline.animated.impl.a(AnimatedFactoryV2Impl.this.emS(), dVar, rect);
                }
            };
        }
        return this.oRW;
    }

    private com.facebook.imagepipeline.animated.a.d emV() {
        return new com.facebook.imagepipeline.animated.a.e(new com.facebook.imagepipeline.animated.impl.b() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.6
            @Override // com.facebook.imagepipeline.animated.impl.b
            public com.facebook.imagepipeline.animated.base.a a(com.facebook.imagepipeline.animated.base.d dVar, Rect rect) {
                return new com.facebook.imagepipeline.animated.impl.a(AnimatedFactoryV2Impl.this.emS(), dVar, rect);
            }
        }, this.oRk);
    }
}
