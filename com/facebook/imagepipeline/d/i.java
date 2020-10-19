package com.facebook.imagepipeline.d;

import android.content.Context;
import com.facebook.common.g.b;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.c.p;
import com.facebook.imagepipeline.d.h;
/* loaded from: classes18.dex */
public class i {
    private final boolean nUW;
    private final b.a nUX;
    private final boolean nUY;
    private final com.facebook.common.g.b nUZ;
    private final com.facebook.common.internal.j<Boolean> nUw;
    private final boolean nVa;
    private final boolean nVb;
    private final int nVc;
    private final int nVd;
    private boolean nVe;
    private final boolean nVf;
    private final c nVg;

    /* loaded from: classes18.dex */
    public interface c {
        l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4);
    }

    private i(a aVar) {
        this.nUW = aVar.nUW;
        this.nUX = aVar.nUX;
        this.nUY = aVar.nUY;
        this.nUZ = aVar.nUZ;
        this.nVa = aVar.nVa;
        this.nVb = aVar.nVb;
        this.nVc = aVar.nVc;
        this.nVd = aVar.nVd;
        this.nVe = aVar.nVe;
        this.nVf = aVar.nVf;
        if (aVar.nVg == null) {
            this.nVg = new b();
        } else {
            this.nVg = aVar.nVg;
        }
        this.nUw = aVar.nUw;
    }

    public boolean eaT() {
        return this.nVa;
    }

    public boolean eaU() {
        return this.nUW;
    }

    public boolean eaV() {
        return this.nUY;
    }

    public b.a eaW() {
        return this.nUX;
    }

    public com.facebook.common.g.b eaX() {
        return this.nUZ;
    }

    public boolean eaY() {
        return this.nVb;
    }

    public int eaZ() {
        return this.nVc;
    }

    public int eba() {
        return this.nVd;
    }

    public boolean ebb() {
        return this.nVf;
    }

    public c ebc() {
        return this.nVg;
    }

    public boolean ebd() {
        return this.nVe;
    }

    public com.facebook.common.internal.j<Boolean> ebe() {
        return this.nUw;
    }

    /* loaded from: classes18.dex */
    public static class a {
        private b.a nUX;
        private com.facebook.common.g.b nUZ;
        public com.facebook.common.internal.j<Boolean> nUw;
        private c nVg;
        private final h.a nVh;
        private boolean nUW = false;
        private boolean nUY = false;
        private boolean nVa = false;
        private boolean nVb = false;
        private int nVc = 0;
        private int nVd = 0;
        public boolean nVe = false;
        private boolean nVf = false;

        public a(h.a aVar) {
            this.nVh = aVar;
        }

        public i ebf() {
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
