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
/* loaded from: classes5.dex */
public class AnimatedFactoryV2Impl implements com.facebook.imagepipeline.animated.a.a {
    @Nullable
    private com.facebook.imagepipeline.e.a pqa;
    private final f puA;
    private final e pvj;
    private final h<b, c> pvk;
    @Nullable
    private com.facebook.imagepipeline.animated.a.d pvl;
    @Nullable
    private com.facebook.imagepipeline.animated.impl.b pvm;
    @Nullable
    private com.facebook.imagepipeline.animated.b.a pvn;

    @d
    public AnimatedFactoryV2Impl(f fVar, e eVar, h<b, c> hVar) {
        this.puA = fVar;
        this.pvj = eVar;
        this.pvk = hVar;
    }

    @Override // com.facebook.imagepipeline.animated.a.a
    @Nullable
    public com.facebook.imagepipeline.e.a ih(Context context) {
        if (this.pqa == null) {
            this.pqa = esT();
        }
        return this.pqa;
    }

    @Override // com.facebook.imagepipeline.animated.a.a
    public com.facebook.imagepipeline.decoder.b c(final Bitmap.Config config) {
        return new com.facebook.imagepipeline.decoder.b() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.1
            @Override // com.facebook.imagepipeline.decoder.b
            public c a(com.facebook.imagepipeline.f.e eVar, int i, com.facebook.imagepipeline.f.h hVar, com.facebook.imagepipeline.common.b bVar) {
                return AnimatedFactoryV2Impl.this.esV().a(eVar, bVar, config);
            }
        };
    }

    @Override // com.facebook.imagepipeline.animated.a.a
    public com.facebook.imagepipeline.decoder.b d(final Bitmap.Config config) {
        return new com.facebook.imagepipeline.decoder.b() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.2
            @Override // com.facebook.imagepipeline.decoder.b
            public c a(com.facebook.imagepipeline.f.e eVar, int i, com.facebook.imagepipeline.f.h hVar, com.facebook.imagepipeline.common.b bVar) {
                return AnimatedFactoryV2Impl.this.esV().b(eVar, bVar, config);
            }
        };
    }

    private a esT() {
        j<Integer> jVar = new j<Integer>() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: esY */
            public Integer get() {
                return 2;
            }
        };
        return new a(esW(), i.eqd(), new com.facebook.common.b.c(this.pvj.euc()), RealtimeSinceBootClock.get(), this.puA, this.pvk, jVar, new j<Integer>() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: esY */
            public Integer get() {
                return 3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.facebook.imagepipeline.animated.b.a esU() {
        if (this.pvn == null) {
            this.pvn = new com.facebook.imagepipeline.animated.b.a();
        }
        return this.pvn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.facebook.imagepipeline.animated.a.d esV() {
        if (this.pvl == null) {
            this.pvl = esX();
        }
        return this.pvl;
    }

    private com.facebook.imagepipeline.animated.impl.b esW() {
        if (this.pvm == null) {
            this.pvm = new com.facebook.imagepipeline.animated.impl.b() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.5
                @Override // com.facebook.imagepipeline.animated.impl.b
                public com.facebook.imagepipeline.animated.base.a a(com.facebook.imagepipeline.animated.base.d dVar, Rect rect) {
                    return new com.facebook.imagepipeline.animated.impl.a(AnimatedFactoryV2Impl.this.esU(), dVar, rect);
                }
            };
        }
        return this.pvm;
    }

    private com.facebook.imagepipeline.animated.a.d esX() {
        return new com.facebook.imagepipeline.animated.a.e(new com.facebook.imagepipeline.animated.impl.b() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.6
            @Override // com.facebook.imagepipeline.animated.impl.b
            public com.facebook.imagepipeline.animated.base.a a(com.facebook.imagepipeline.animated.base.d dVar, Rect rect) {
                return new com.facebook.imagepipeline.animated.impl.a(AnimatedFactoryV2Impl.this.esU(), dVar, rect);
            }
        }, this.puA);
    }
}
