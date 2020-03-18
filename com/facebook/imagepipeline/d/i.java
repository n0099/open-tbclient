package com.facebook.imagepipeline.d;

import android.content.Context;
import com.facebook.common.g.b;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.c.p;
import com.facebook.imagepipeline.d.h;
/* loaded from: classes12.dex */
public class i {
    private final com.facebook.common.internal.j<Boolean> lTV;
    private final boolean lUA;
    private final int lUB;
    private final int lUC;
    private boolean lUD;
    private final boolean lUE;
    private final c lUF;
    private final boolean lUv;
    private final b.a lUw;
    private final boolean lUx;
    private final com.facebook.common.g.b lUy;
    private final boolean lUz;

    /* loaded from: classes12.dex */
    public interface c {
        l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4);
    }

    private i(a aVar) {
        this.lUv = aVar.lUv;
        this.lUw = aVar.lUw;
        this.lUx = aVar.lUx;
        this.lUy = aVar.lUy;
        this.lUz = aVar.lUz;
        this.lUA = aVar.lUA;
        this.lUB = aVar.lUB;
        this.lUC = aVar.lUC;
        this.lUD = aVar.lUD;
        this.lUE = aVar.lUE;
        if (aVar.lUF == null) {
            this.lUF = new b();
        } else {
            this.lUF = aVar.lUF;
        }
        this.lTV = aVar.lTV;
    }

    public boolean dpH() {
        return this.lUz;
    }

    public boolean dpI() {
        return this.lUv;
    }

    public boolean dpJ() {
        return this.lUx;
    }

    public b.a dpK() {
        return this.lUw;
    }

    public com.facebook.common.g.b dpL() {
        return this.lUy;
    }

    public boolean dpM() {
        return this.lUA;
    }

    public int dpN() {
        return this.lUB;
    }

    public int dpO() {
        return this.lUC;
    }

    public boolean dpP() {
        return this.lUE;
    }

    public c dpQ() {
        return this.lUF;
    }

    public boolean dpR() {
        return this.lUD;
    }

    public com.facebook.common.internal.j<Boolean> dpS() {
        return this.lTV;
    }

    /* loaded from: classes12.dex */
    public static class a {
        public com.facebook.common.internal.j<Boolean> lTV;
        private c lUF;
        private final h.a lUG;
        private b.a lUw;
        private com.facebook.common.g.b lUy;
        private boolean lUv = false;
        private boolean lUx = false;
        private boolean lUz = false;
        private boolean lUA = false;
        private int lUB = 0;
        private int lUC = 0;
        public boolean lUD = false;
        private boolean lUE = false;

        public a(h.a aVar) {
            this.lUG = aVar;
        }

        public i dpT() {
            return new i(this);
        }
    }

    /* loaded from: classes12.dex */
    public static class b implements c {
        @Override // com.facebook.imagepipeline.d.i.c
        public l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4) {
            return new l(context, aVar, bVar, dVar, z, z2, z3, eVar, gVar, pVar, pVar2, eVar2, eVar3, fVar, fVar2, i, i2, z4);
        }
    }
}
