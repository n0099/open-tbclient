package com.facebook.imagepipeline.d;

import android.content.Context;
import com.facebook.common.g.b;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.c.p;
import com.facebook.imagepipeline.d.h;
/* loaded from: classes8.dex */
public class i {
    private final com.facebook.common.internal.j<Boolean> nuO;
    private final boolean nvo;
    private final b.a nvp;
    private final boolean nvq;
    private final com.facebook.common.g.b nvr;
    private final boolean nvs;
    private final boolean nvt;
    private final int nvu;
    private final int nvv;
    private boolean nvw;
    private final boolean nvx;
    private final c nvy;

    /* loaded from: classes8.dex */
    public interface c {
        l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4);
    }

    private i(a aVar) {
        this.nvo = aVar.nvo;
        this.nvp = aVar.nvp;
        this.nvq = aVar.nvq;
        this.nvr = aVar.nvr;
        this.nvs = aVar.nvs;
        this.nvt = aVar.nvt;
        this.nvu = aVar.nvu;
        this.nvv = aVar.nvv;
        this.nvw = aVar.nvw;
        this.nvx = aVar.nvx;
        if (aVar.nvy == null) {
            this.nvy = new b();
        } else {
            this.nvy = aVar.nvy;
        }
        this.nuO = aVar.nuO;
    }

    public boolean dTb() {
        return this.nvs;
    }

    public boolean dTc() {
        return this.nvo;
    }

    public boolean dTd() {
        return this.nvq;
    }

    public b.a dTe() {
        return this.nvp;
    }

    public com.facebook.common.g.b dTf() {
        return this.nvr;
    }

    public boolean dTg() {
        return this.nvt;
    }

    public int dTh() {
        return this.nvu;
    }

    public int dTi() {
        return this.nvv;
    }

    public boolean dTj() {
        return this.nvx;
    }

    public c dTk() {
        return this.nvy;
    }

    public boolean dTl() {
        return this.nvw;
    }

    public com.facebook.common.internal.j<Boolean> dTm() {
        return this.nuO;
    }

    /* loaded from: classes8.dex */
    public static class a {
        public com.facebook.common.internal.j<Boolean> nuO;
        private b.a nvp;
        private com.facebook.common.g.b nvr;
        private c nvy;
        private final h.a nvz;
        private boolean nvo = false;
        private boolean nvq = false;
        private boolean nvs = false;
        private boolean nvt = false;
        private int nvu = 0;
        private int nvv = 0;
        public boolean nvw = false;
        private boolean nvx = false;

        public a(h.a aVar) {
            this.nvz = aVar;
        }

        public i dTn() {
            return new i(this);
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements c {
        @Override // com.facebook.imagepipeline.d.i.c
        public l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4) {
            return new l(context, aVar, bVar, dVar, z, z2, z3, eVar, gVar, pVar, pVar2, eVar2, eVar3, fVar, fVar2, i, i2, z4);
        }
    }
}
