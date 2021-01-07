package com.facebook.imagepipeline.c;

import android.content.Context;
import com.facebook.common.g.b;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.b.p;
import com.facebook.imagepipeline.c.h;
/* loaded from: classes3.dex */
public class i {
    private final com.facebook.common.internal.j<Boolean> pCL;
    private final boolean pDl;
    private final b.a pDm;
    private final boolean pDn;
    private final com.facebook.common.g.b pDo;
    private final boolean pDp;
    private final boolean pDq;
    private final int pDr;
    private final int pDs;
    private boolean pDt;
    private final boolean pDu;
    private final c pDv;

    /* loaded from: classes3.dex */
    public interface c {
        l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.e eVar3, com.facebook.imagepipeline.b.f fVar, com.facebook.imagepipeline.a.f fVar2, int i, int i2, boolean z4);
    }

    private i(a aVar) {
        this.pDl = aVar.pDl;
        this.pDm = aVar.pDm;
        this.pDn = aVar.pDn;
        this.pDo = aVar.pDo;
        this.pDp = aVar.pDp;
        this.pDq = aVar.pDq;
        this.pDr = aVar.pDr;
        this.pDs = aVar.pDs;
        this.pDt = aVar.pDt;
        this.pDu = aVar.pDu;
        if (aVar.pDv == null) {
            this.pDv = new b();
        } else {
            this.pDv = aVar.pDv;
        }
        this.pCL = aVar.pCL;
    }

    public boolean eyx() {
        return this.pDp;
    }

    public boolean eyy() {
        return this.pDl;
    }

    public boolean eyz() {
        return this.pDn;
    }

    public b.a eyA() {
        return this.pDm;
    }

    public com.facebook.common.g.b eyB() {
        return this.pDo;
    }

    public boolean eyC() {
        return this.pDq;
    }

    public int eyD() {
        return this.pDr;
    }

    public int eyE() {
        return this.pDs;
    }

    public boolean eyF() {
        return this.pDu;
    }

    public c eyG() {
        return this.pDv;
    }

    public boolean eyH() {
        return this.pDt;
    }

    public com.facebook.common.internal.j<Boolean> eyI() {
        return this.pCL;
    }

    /* loaded from: classes3.dex */
    public static class a {
        public com.facebook.common.internal.j<Boolean> pCL;
        private b.a pDm;
        private com.facebook.common.g.b pDo;
        private c pDv;
        private final h.a pDw;
        private boolean pDl = false;
        private boolean pDn = false;
        private boolean pDp = false;
        private boolean pDq = false;
        private int pDr = 0;
        private int pDs = 0;
        public boolean pDt = false;
        private boolean pDu = false;

        public a(h.a aVar) {
            this.pDw = aVar;
        }

        public i eyJ() {
            return new i(this);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements c {
        @Override // com.facebook.imagepipeline.c.i.c
        public l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.e eVar3, com.facebook.imagepipeline.b.f fVar, com.facebook.imagepipeline.a.f fVar2, int i, int i2, boolean z4) {
            return new l(context, aVar, bVar, dVar, z, z2, z3, eVar, gVar, pVar, pVar2, eVar2, eVar3, fVar, fVar2, i, i2, z4);
        }
    }
}
