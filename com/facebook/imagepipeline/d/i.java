package com.facebook.imagepipeline.d;

import android.content.Context;
import com.facebook.common.g.b;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.c.p;
import com.facebook.imagepipeline.d.h;
/* loaded from: classes18.dex */
public class i {
    private final com.facebook.common.internal.j<Boolean> oLO;
    private final boolean oMo;
    private final b.a oMp;
    private final boolean oMq;
    private final com.facebook.common.g.b oMr;
    private final boolean oMs;
    private final boolean oMt;
    private final int oMu;
    private final int oMv;
    private boolean oMw;
    private final boolean oMx;
    private final c oMy;

    /* loaded from: classes18.dex */
    public interface c {
        l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4);
    }

    private i(a aVar) {
        this.oMo = aVar.oMo;
        this.oMp = aVar.oMp;
        this.oMq = aVar.oMq;
        this.oMr = aVar.oMr;
        this.oMs = aVar.oMs;
        this.oMt = aVar.oMt;
        this.oMu = aVar.oMu;
        this.oMv = aVar.oMv;
        this.oMw = aVar.oMw;
        this.oMx = aVar.oMx;
        if (aVar.oMy == null) {
            this.oMy = new b();
        } else {
            this.oMy = aVar.oMy;
        }
        this.oLO = aVar.oLO;
    }

    public boolean ekR() {
        return this.oMs;
    }

    public boolean ekS() {
        return this.oMo;
    }

    public boolean ekT() {
        return this.oMq;
    }

    public b.a ekU() {
        return this.oMp;
    }

    public com.facebook.common.g.b ekV() {
        return this.oMr;
    }

    public boolean ekW() {
        return this.oMt;
    }

    public int ekX() {
        return this.oMu;
    }

    public int ekY() {
        return this.oMv;
    }

    public boolean ekZ() {
        return this.oMx;
    }

    public c ela() {
        return this.oMy;
    }

    public boolean elb() {
        return this.oMw;
    }

    public com.facebook.common.internal.j<Boolean> elc() {
        return this.oLO;
    }

    /* loaded from: classes18.dex */
    public static class a {
        public com.facebook.common.internal.j<Boolean> oLO;
        private b.a oMp;
        private com.facebook.common.g.b oMr;
        private c oMy;
        private final h.a oMz;
        private boolean oMo = false;
        private boolean oMq = false;
        private boolean oMs = false;
        private boolean oMt = false;
        private int oMu = 0;
        private int oMv = 0;
        public boolean oMw = false;
        private boolean oMx = false;

        public a(h.a aVar) {
            this.oMz = aVar;
        }

        public i eld() {
            return new i(this);
        }
    }

    /* loaded from: classes18.dex */
    public static class b implements c {
        @Override // com.facebook.imagepipeline.d.i.c
        public l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4) {
            return new l(context, aVar, bVar, dVar, z, z2, z3, eVar, gVar, pVar, pVar2, eVar2, eVar3, fVar, fVar2, i, i2, z4);
        }
    }
}
