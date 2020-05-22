package com.facebook.imagepipeline.d;

import android.content.Context;
import com.facebook.common.g.b;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.c.p;
import com.facebook.imagepipeline.d.h;
/* loaded from: classes12.dex */
public class i {
    private final com.facebook.common.internal.j<Boolean> mvD;
    private final boolean mwd;
    private final b.a mwe;
    private final boolean mwf;
    private final com.facebook.common.g.b mwg;
    private final boolean mwh;
    private final boolean mwi;
    private final int mwj;
    private final int mwk;
    private boolean mwl;
    private final boolean mwm;
    private final c mwn;

    /* loaded from: classes12.dex */
    public interface c {
        l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4);
    }

    private i(a aVar) {
        this.mwd = aVar.mwd;
        this.mwe = aVar.mwe;
        this.mwf = aVar.mwf;
        this.mwg = aVar.mwg;
        this.mwh = aVar.mwh;
        this.mwi = aVar.mwi;
        this.mwj = aVar.mwj;
        this.mwk = aVar.mwk;
        this.mwl = aVar.mwl;
        this.mwm = aVar.mwm;
        if (aVar.mwn == null) {
            this.mwn = new b();
        } else {
            this.mwn = aVar.mwn;
        }
        this.mvD = aVar.mvD;
    }

    public boolean dyV() {
        return this.mwh;
    }

    public boolean dyW() {
        return this.mwd;
    }

    public boolean dyX() {
        return this.mwf;
    }

    public b.a dyY() {
        return this.mwe;
    }

    public com.facebook.common.g.b dyZ() {
        return this.mwg;
    }

    public boolean dza() {
        return this.mwi;
    }

    public int dzb() {
        return this.mwj;
    }

    public int dzc() {
        return this.mwk;
    }

    public boolean dzd() {
        return this.mwm;
    }

    public c dze() {
        return this.mwn;
    }

    public boolean dzf() {
        return this.mwl;
    }

    public com.facebook.common.internal.j<Boolean> dzg() {
        return this.mvD;
    }

    /* loaded from: classes12.dex */
    public static class a {
        public com.facebook.common.internal.j<Boolean> mvD;
        private b.a mwe;
        private com.facebook.common.g.b mwg;
        private c mwn;
        private final h.a mwo;
        private boolean mwd = false;
        private boolean mwf = false;
        private boolean mwh = false;
        private boolean mwi = false;
        private int mwj = 0;
        private int mwk = 0;
        public boolean mwl = false;
        private boolean mwm = false;

        public a(h.a aVar) {
            this.mwo = aVar;
        }

        public i dzh() {
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
