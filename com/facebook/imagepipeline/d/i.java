package com.facebook.imagepipeline.d;

import android.content.Context;
import com.facebook.common.g.b;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.c.p;
import com.facebook.imagepipeline.d.h;
/* loaded from: classes12.dex */
public class i {
    private final com.facebook.common.internal.j<Boolean> mSS;
    private final int mTA;
    private final int mTB;
    private boolean mTC;
    private final boolean mTD;
    private final c mTE;
    private final boolean mTu;
    private final b.a mTv;
    private final boolean mTw;
    private final com.facebook.common.g.b mTx;
    private final boolean mTy;
    private final boolean mTz;

    /* loaded from: classes12.dex */
    public interface c {
        l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4);
    }

    private i(a aVar) {
        this.mTu = aVar.mTu;
        this.mTv = aVar.mTv;
        this.mTw = aVar.mTw;
        this.mTx = aVar.mTx;
        this.mTy = aVar.mTy;
        this.mTz = aVar.mTz;
        this.mTA = aVar.mTA;
        this.mTB = aVar.mTB;
        this.mTC = aVar.mTC;
        this.mTD = aVar.mTD;
        if (aVar.mTE == null) {
            this.mTE = new b();
        } else {
            this.mTE = aVar.mTE;
        }
        this.mSS = aVar.mSS;
    }

    public boolean dDP() {
        return this.mTy;
    }

    public boolean dDQ() {
        return this.mTu;
    }

    public boolean dDR() {
        return this.mTw;
    }

    public b.a dDS() {
        return this.mTv;
    }

    public com.facebook.common.g.b dDT() {
        return this.mTx;
    }

    public boolean dDU() {
        return this.mTz;
    }

    public int dDV() {
        return this.mTA;
    }

    public int dDW() {
        return this.mTB;
    }

    public boolean dDX() {
        return this.mTD;
    }

    public c dDY() {
        return this.mTE;
    }

    public boolean dDZ() {
        return this.mTC;
    }

    public com.facebook.common.internal.j<Boolean> dEa() {
        return this.mSS;
    }

    /* loaded from: classes12.dex */
    public static class a {
        public com.facebook.common.internal.j<Boolean> mSS;
        private c mTE;
        private final h.a mTF;
        private b.a mTv;
        private com.facebook.common.g.b mTx;
        private boolean mTu = false;
        private boolean mTw = false;
        private boolean mTy = false;
        private boolean mTz = false;
        private int mTA = 0;
        private int mTB = 0;
        public boolean mTC = false;
        private boolean mTD = false;

        public a(h.a aVar) {
            this.mTF = aVar;
        }

        public i dEb() {
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
