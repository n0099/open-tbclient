package com.facebook.imagepipeline.d;

import android.content.Context;
import com.facebook.common.g.b;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.c.p;
import com.facebook.imagepipeline.d.h;
/* loaded from: classes12.dex */
public class i {
    private final com.facebook.common.internal.j<Boolean> mSO;
    private final boolean mTA;
    private final c mTB;
    private final boolean mTr;
    private final b.a mTs;
    private final boolean mTt;
    private final com.facebook.common.g.b mTu;
    private final boolean mTv;
    private final boolean mTw;
    private final int mTx;
    private final int mTy;
    private boolean mTz;

    /* loaded from: classes12.dex */
    public interface c {
        l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4);
    }

    private i(a aVar) {
        this.mTr = aVar.mTr;
        this.mTs = aVar.mTs;
        this.mTt = aVar.mTt;
        this.mTu = aVar.mTu;
        this.mTv = aVar.mTv;
        this.mTw = aVar.mTw;
        this.mTx = aVar.mTx;
        this.mTy = aVar.mTy;
        this.mTz = aVar.mTz;
        this.mTA = aVar.mTA;
        if (aVar.mTB == null) {
            this.mTB = new b();
        } else {
            this.mTB = aVar.mTB;
        }
        this.mSO = aVar.mSO;
    }

    public boolean dDL() {
        return this.mTv;
    }

    public boolean dDM() {
        return this.mTr;
    }

    public boolean dDN() {
        return this.mTt;
    }

    public b.a dDO() {
        return this.mTs;
    }

    public com.facebook.common.g.b dDP() {
        return this.mTu;
    }

    public boolean dDQ() {
        return this.mTw;
    }

    public int dDR() {
        return this.mTx;
    }

    public int dDS() {
        return this.mTy;
    }

    public boolean dDT() {
        return this.mTA;
    }

    public c dDU() {
        return this.mTB;
    }

    public boolean dDV() {
        return this.mTz;
    }

    public com.facebook.common.internal.j<Boolean> dDW() {
        return this.mSO;
    }

    /* loaded from: classes12.dex */
    public static class a {
        public com.facebook.common.internal.j<Boolean> mSO;
        private c mTB;
        private final h.a mTC;
        private b.a mTs;
        private com.facebook.common.g.b mTu;
        private boolean mTr = false;
        private boolean mTt = false;
        private boolean mTv = false;
        private boolean mTw = false;
        private int mTx = 0;
        private int mTy = 0;
        public boolean mTz = false;
        private boolean mTA = false;

        public a(h.a aVar) {
            this.mTC = aVar;
        }

        public i dDX() {
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
