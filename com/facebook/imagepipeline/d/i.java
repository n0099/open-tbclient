package com.facebook.imagepipeline.d;

import android.content.Context;
import com.facebook.common.g.b;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.c.p;
import com.facebook.imagepipeline.d.h;
/* loaded from: classes9.dex */
public class i {
    private final com.facebook.common.internal.j<Boolean> lNE;
    private final boolean lOe;
    private final b.a lOf;
    private final boolean lOg;
    private final com.facebook.common.g.b lOh;
    private final boolean lOi;
    private final boolean lOj;
    private final int lOk;
    private final int lOl;
    private boolean lOm;
    private final boolean lOn;
    private final c lOo;

    /* loaded from: classes9.dex */
    public interface c {
        l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4);
    }

    private i(a aVar) {
        this.lOe = aVar.lOe;
        this.lOf = aVar.lOf;
        this.lOg = aVar.lOg;
        this.lOh = aVar.lOh;
        this.lOi = aVar.lOi;
        this.lOj = aVar.lOj;
        this.lOk = aVar.lOk;
        this.lOl = aVar.lOl;
        this.lOm = aVar.lOm;
        this.lOn = aVar.lOn;
        if (aVar.lOo == null) {
            this.lOo = new b();
        } else {
            this.lOo = aVar.lOo;
        }
        this.lNE = aVar.lNE;
    }

    public boolean dmM() {
        return this.lOi;
    }

    public boolean dmN() {
        return this.lOe;
    }

    public boolean dmO() {
        return this.lOg;
    }

    public b.a dmP() {
        return this.lOf;
    }

    public com.facebook.common.g.b dmQ() {
        return this.lOh;
    }

    public boolean dmR() {
        return this.lOj;
    }

    public int dmS() {
        return this.lOk;
    }

    public int dmT() {
        return this.lOl;
    }

    public boolean dmU() {
        return this.lOn;
    }

    public c dmV() {
        return this.lOo;
    }

    public boolean dmW() {
        return this.lOm;
    }

    public com.facebook.common.internal.j<Boolean> dmX() {
        return this.lNE;
    }

    /* loaded from: classes9.dex */
    public static class a {
        public com.facebook.common.internal.j<Boolean> lNE;
        private b.a lOf;
        private com.facebook.common.g.b lOh;
        private c lOo;
        private final h.a lOp;
        private boolean lOe = false;
        private boolean lOg = false;
        private boolean lOi = false;
        private boolean lOj = false;
        private int lOk = 0;
        private int lOl = 0;
        public boolean lOm = false;
        private boolean lOn = false;

        public a(h.a aVar) {
            this.lOp = aVar;
        }

        public i dmY() {
            return new i(this);
        }
    }

    /* loaded from: classes9.dex */
    public static class b implements c {
        @Override // com.facebook.imagepipeline.d.i.c
        public l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4) {
            return new l(context, aVar, bVar, dVar, z, z2, z3, eVar, gVar, pVar, pVar2, eVar2, eVar3, fVar, fVar2, i, i2, z4);
        }
    }
}
