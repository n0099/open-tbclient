package com.facebook.imagepipeline.d;

import android.content.Context;
import com.facebook.common.g.b;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.c.p;
import com.facebook.imagepipeline.d.h;
/* loaded from: classes18.dex */
public class i {
    private final boolean oVH;
    private final b.a oVI;
    private final boolean oVJ;
    private final com.facebook.common.g.b oVK;
    private final boolean oVL;
    private final boolean oVM;
    private final int oVN;
    private final int oVO;
    private boolean oVP;
    private final boolean oVQ;
    private final c oVR;
    private final com.facebook.common.internal.j<Boolean> oVh;

    /* loaded from: classes18.dex */
    public interface c {
        l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4);
    }

    private i(a aVar) {
        this.oVH = aVar.oVH;
        this.oVI = aVar.oVI;
        this.oVJ = aVar.oVJ;
        this.oVK = aVar.oVK;
        this.oVL = aVar.oVL;
        this.oVM = aVar.oVM;
        this.oVN = aVar.oVN;
        this.oVO = aVar.oVO;
        this.oVP = aVar.oVP;
        this.oVQ = aVar.oVQ;
        if (aVar.oVR == null) {
            this.oVR = new b();
        } else {
            this.oVR = aVar.oVR;
        }
        this.oVh = aVar.oVh;
    }

    public boolean eoI() {
        return this.oVL;
    }

    public boolean eoJ() {
        return this.oVH;
    }

    public boolean eoK() {
        return this.oVJ;
    }

    public b.a eoL() {
        return this.oVI;
    }

    public com.facebook.common.g.b eoM() {
        return this.oVK;
    }

    public boolean eoN() {
        return this.oVM;
    }

    public int eoO() {
        return this.oVN;
    }

    public int eoP() {
        return this.oVO;
    }

    public boolean eoQ() {
        return this.oVQ;
    }

    public c eoR() {
        return this.oVR;
    }

    public boolean eoS() {
        return this.oVP;
    }

    public com.facebook.common.internal.j<Boolean> eoT() {
        return this.oVh;
    }

    /* loaded from: classes18.dex */
    public static class a {
        private b.a oVI;
        private com.facebook.common.g.b oVK;
        private c oVR;
        private final h.a oVS;
        public com.facebook.common.internal.j<Boolean> oVh;
        private boolean oVH = false;
        private boolean oVJ = false;
        private boolean oVL = false;
        private boolean oVM = false;
        private int oVN = 0;
        private int oVO = 0;
        public boolean oVP = false;
        private boolean oVQ = false;

        public a(h.a aVar) {
            this.oVS = aVar;
        }

        public i eoU() {
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
