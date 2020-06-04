package com.facebook.imagepipeline.d;

import android.content.Context;
import com.facebook.common.g.b;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.c.p;
import com.facebook.imagepipeline.d.h;
/* loaded from: classes12.dex */
public class i {
    private final com.facebook.common.internal.j<Boolean> mwN;
    private final boolean mxn;
    private final b.a mxo;
    private final boolean mxp;
    private final com.facebook.common.g.b mxq;
    private final boolean mxr;
    private final boolean mxs;
    private final int mxt;
    private final int mxu;
    private boolean mxv;
    private final boolean mxw;
    private final c mxx;

    /* loaded from: classes12.dex */
    public interface c {
        l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4);
    }

    private i(a aVar) {
        this.mxn = aVar.mxn;
        this.mxo = aVar.mxo;
        this.mxp = aVar.mxp;
        this.mxq = aVar.mxq;
        this.mxr = aVar.mxr;
        this.mxs = aVar.mxs;
        this.mxt = aVar.mxt;
        this.mxu = aVar.mxu;
        this.mxv = aVar.mxv;
        this.mxw = aVar.mxw;
        if (aVar.mxx == null) {
            this.mxx = new b();
        } else {
            this.mxx = aVar.mxx;
        }
        this.mwN = aVar.mwN;
    }

    public boolean dzj() {
        return this.mxr;
    }

    public boolean dzk() {
        return this.mxn;
    }

    public boolean dzl() {
        return this.mxp;
    }

    public b.a dzm() {
        return this.mxo;
    }

    public com.facebook.common.g.b dzn() {
        return this.mxq;
    }

    public boolean dzo() {
        return this.mxs;
    }

    public int dzp() {
        return this.mxt;
    }

    public int dzq() {
        return this.mxu;
    }

    public boolean dzr() {
        return this.mxw;
    }

    public c dzs() {
        return this.mxx;
    }

    public boolean dzt() {
        return this.mxv;
    }

    public com.facebook.common.internal.j<Boolean> dzu() {
        return this.mwN;
    }

    /* loaded from: classes12.dex */
    public static class a {
        public com.facebook.common.internal.j<Boolean> mwN;
        private b.a mxo;
        private com.facebook.common.g.b mxq;
        private c mxx;
        private final h.a mxy;
        private boolean mxn = false;
        private boolean mxp = false;
        private boolean mxr = false;
        private boolean mxs = false;
        private int mxt = 0;
        private int mxu = 0;
        public boolean mxv = false;
        private boolean mxw = false;

        public a(h.a aVar) {
            this.mxy = aVar;
        }

        public i dzv() {
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
