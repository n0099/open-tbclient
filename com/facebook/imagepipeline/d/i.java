package com.facebook.imagepipeline.d;

import android.content.Context;
import com.facebook.common.g.b;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.c.p;
import com.facebook.imagepipeline.d.h;
/* loaded from: classes8.dex */
public class i {
    private final boolean nvG;
    private final b.a nvH;
    private final boolean nvI;
    private final com.facebook.common.g.b nvJ;
    private final boolean nvK;
    private final boolean nvL;
    private final int nvM;
    private final int nvN;
    private boolean nvO;
    private final boolean nvP;
    private final c nvQ;
    private final com.facebook.common.internal.j<Boolean> nvg;

    /* loaded from: classes8.dex */
    public interface c {
        l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4);
    }

    private i(a aVar) {
        this.nvG = aVar.nvG;
        this.nvH = aVar.nvH;
        this.nvI = aVar.nvI;
        this.nvJ = aVar.nvJ;
        this.nvK = aVar.nvK;
        this.nvL = aVar.nvL;
        this.nvM = aVar.nvM;
        this.nvN = aVar.nvN;
        this.nvO = aVar.nvO;
        this.nvP = aVar.nvP;
        if (aVar.nvQ == null) {
            this.nvQ = new b();
        } else {
            this.nvQ = aVar.nvQ;
        }
        this.nvg = aVar.nvg;
    }

    public boolean dTk() {
        return this.nvK;
    }

    public boolean dTl() {
        return this.nvG;
    }

    public boolean dTm() {
        return this.nvI;
    }

    public b.a dTn() {
        return this.nvH;
    }

    public com.facebook.common.g.b dTo() {
        return this.nvJ;
    }

    public boolean dTp() {
        return this.nvL;
    }

    public int dTq() {
        return this.nvM;
    }

    public int dTr() {
        return this.nvN;
    }

    public boolean dTs() {
        return this.nvP;
    }

    public c dTt() {
        return this.nvQ;
    }

    public boolean dTu() {
        return this.nvO;
    }

    public com.facebook.common.internal.j<Boolean> dTv() {
        return this.nvg;
    }

    /* loaded from: classes8.dex */
    public static class a {
        private b.a nvH;
        private com.facebook.common.g.b nvJ;
        private c nvQ;
        private final h.a nvR;
        public com.facebook.common.internal.j<Boolean> nvg;
        private boolean nvG = false;
        private boolean nvI = false;
        private boolean nvK = false;
        private boolean nvL = false;
        private int nvM = 0;
        private int nvN = 0;
        public boolean nvO = false;
        private boolean nvP = false;

        public a(h.a aVar) {
            this.nvR = aVar;
        }

        public i dTw() {
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
