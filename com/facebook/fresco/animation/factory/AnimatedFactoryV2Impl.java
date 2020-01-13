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
    private com.facebook.imagepipeline.f.a lIV;
    private final f lNw;
    private final e lOf;
    private final h<b, c> lOg;
    @Nullable
    private com.facebook.imagepipeline.animated.a.d lOh;
    @Nullable
    private com.facebook.imagepipeline.animated.impl.b lOi;
    @Nullable
    private com.facebook.imagepipeline.animated.b.a lOj;

    @d
    public AnimatedFactoryV2Impl(f fVar, e eVar, h<b, c> hVar) {
        this.lNw = fVar;
        this.lOf = eVar;
        this.lOg = hVar;
    }

    @Override // com.facebook.imagepipeline.animated.a.a
    @Nullable
    public com.facebook.imagepipeline.f.a gn(Context context) {
        if (this.lIV == null) {
            this.lIV = dme();
        }
        return this.lIV;
    }

    @Override // com.facebook.imagepipeline.animated.a.a
    public com.facebook.imagepipeline.decoder.b a(final Bitmap.Config config) {
        return new com.facebook.imagepipeline.decoder.b() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.1
            @Override // com.facebook.imagepipeline.decoder.b
            public c a(com.facebook.imagepipeline.g.e eVar, int i, com.facebook.imagepipeline.g.h hVar, com.facebook.imagepipeline.common.b bVar) {
                return AnimatedFactoryV2Impl.this.dmg().a(eVar, bVar, config);
            }
        };
    }

    @Override // com.facebook.imagepipeline.animated.a.a
    public com.facebook.imagepipeline.decoder.b b(final Bitmap.Config config) {
        return new com.facebook.imagepipeline.decoder.b() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.2
            @Override // com.facebook.imagepipeline.decoder.b
            public c a(com.facebook.imagepipeline.g.e eVar, int i, com.facebook.imagepipeline.g.h hVar, com.facebook.imagepipeline.common.b bVar) {
                return AnimatedFactoryV2Impl.this.dmg().b(eVar, bVar, config);
            }
        };
    }

    private a dme() {
        j<Integer> jVar = new j<Integer>() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: dmj */
            public Integer get() {
                return 2;
            }
        };
        return new a(dmh(), i.djo(), new com.facebook.common.b.c(this.lOf.dno()), RealtimeSinceBootClock.get(), this.lNw, this.lOg, jVar, new j<Integer>() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: dmj */
            public Integer get() {
                return 3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.facebook.imagepipeline.animated.b.a dmf() {
        if (this.lOj == null) {
            this.lOj = new com.facebook.imagepipeline.animated.b.a();
        }
        return this.lOj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.facebook.imagepipeline.animated.a.d dmg() {
        if (this.lOh == null) {
            this.lOh = dmi();
        }
        return this.lOh;
    }

    private com.facebook.imagepipeline.animated.impl.b dmh() {
        if (this.lOi == null) {
            this.lOi = new com.facebook.imagepipeline.animated.impl.b() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.5
                @Override // com.facebook.imagepipeline.animated.impl.b
                public com.facebook.imagepipeline.animated.base.a a(com.facebook.imagepipeline.animated.base.d dVar, Rect rect) {
                    return new com.facebook.imagepipeline.animated.impl.a(AnimatedFactoryV2Impl.this.dmf(), dVar, rect);
                }
            };
        }
        return this.lOi;
    }

    private com.facebook.imagepipeline.animated.a.d dmi() {
        return new com.facebook.imagepipeline.animated.a.e(new com.facebook.imagepipeline.animated.impl.b() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.6
            @Override // com.facebook.imagepipeline.animated.impl.b
            public com.facebook.imagepipeline.animated.base.a a(com.facebook.imagepipeline.animated.base.d dVar, Rect rect) {
                return new com.facebook.imagepipeline.animated.impl.a(AnimatedFactoryV2Impl.this.dmf(), dVar, rect);
            }
        }, this.lNw);
    }
}
