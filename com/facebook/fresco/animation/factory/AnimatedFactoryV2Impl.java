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
/* loaded from: classes13.dex */
public class AnimatedFactoryV2Impl implements com.facebook.imagepipeline.animated.a.a {
    @Nullable
    private com.facebook.imagepipeline.f.a mKe;
    private final f mOP;
    private final e mPA;
    private final h<b, c> mPB;
    @Nullable
    private com.facebook.imagepipeline.animated.a.d mPC;
    @Nullable
    private com.facebook.imagepipeline.animated.impl.b mPD;
    @Nullable
    private com.facebook.imagepipeline.animated.b.a mPE;

    @d
    public AnimatedFactoryV2Impl(f fVar, e eVar, h<b, c> hVar) {
        this.mOP = fVar;
        this.mPA = eVar;
        this.mPB = hVar;
    }

    @Override // com.facebook.imagepipeline.animated.a.a
    @Nullable
    public com.facebook.imagepipeline.f.a fW(Context context) {
        if (this.mKe == null) {
            this.mKe = dCa();
        }
        return this.mKe;
    }

    @Override // com.facebook.imagepipeline.animated.a.a
    public com.facebook.imagepipeline.decoder.b a(final Bitmap.Config config) {
        return new com.facebook.imagepipeline.decoder.b() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.1
            @Override // com.facebook.imagepipeline.decoder.b
            public c a(com.facebook.imagepipeline.g.e eVar, int i, com.facebook.imagepipeline.g.h hVar, com.facebook.imagepipeline.common.b bVar) {
                return AnimatedFactoryV2Impl.this.dCc().a(eVar, bVar, config);
            }
        };
    }

    @Override // com.facebook.imagepipeline.animated.a.a
    public com.facebook.imagepipeline.decoder.b b(final Bitmap.Config config) {
        return new com.facebook.imagepipeline.decoder.b() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.2
            @Override // com.facebook.imagepipeline.decoder.b
            public c a(com.facebook.imagepipeline.g.e eVar, int i, com.facebook.imagepipeline.g.h hVar, com.facebook.imagepipeline.common.b bVar) {
                return AnimatedFactoryV2Impl.this.dCc().b(eVar, bVar, config);
            }
        };
    }

    private a dCa() {
        j<Integer> jVar = new j<Integer>() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: dCf */
            public Integer get() {
                return 2;
            }
        };
        return new a(dCd(), i.dzi(), new com.facebook.common.b.c(this.mPA.dDm()), RealtimeSinceBootClock.get(), this.mOP, this.mPB, jVar, new j<Integer>() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: dCf */
            public Integer get() {
                return 3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.facebook.imagepipeline.animated.b.a dCb() {
        if (this.mPE == null) {
            this.mPE = new com.facebook.imagepipeline.animated.b.a();
        }
        return this.mPE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.facebook.imagepipeline.animated.a.d dCc() {
        if (this.mPC == null) {
            this.mPC = dCe();
        }
        return this.mPC;
    }

    private com.facebook.imagepipeline.animated.impl.b dCd() {
        if (this.mPD == null) {
            this.mPD = new com.facebook.imagepipeline.animated.impl.b() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.5
                @Override // com.facebook.imagepipeline.animated.impl.b
                public com.facebook.imagepipeline.animated.base.a a(com.facebook.imagepipeline.animated.base.d dVar, Rect rect) {
                    return new com.facebook.imagepipeline.animated.impl.a(AnimatedFactoryV2Impl.this.dCb(), dVar, rect);
                }
            };
        }
        return this.mPD;
    }

    private com.facebook.imagepipeline.animated.a.d dCe() {
        return new com.facebook.imagepipeline.animated.a.e(new com.facebook.imagepipeline.animated.impl.b() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.6
            @Override // com.facebook.imagepipeline.animated.impl.b
            public com.facebook.imagepipeline.animated.base.a a(com.facebook.imagepipeline.animated.base.d dVar, Rect rect) {
                return new com.facebook.imagepipeline.animated.impl.a(AnimatedFactoryV2Impl.this.dCb(), dVar, rect);
            }
        }, this.mOP);
    }
}
