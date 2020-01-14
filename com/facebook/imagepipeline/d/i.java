package com.facebook.imagepipeline.d;

import android.content.Context;
import com.facebook.common.g.b;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.c.p;
import com.facebook.imagepipeline.d.h;
/* loaded from: classes10.dex */
public class i {
    private final boolean lRV;
    private final b.a lRW;
    private final boolean lRX;
    private final com.facebook.common.g.b lRY;
    private final boolean lRZ;
    private final com.facebook.common.internal.j<Boolean> lRv;
    private final boolean lSa;
    private final int lSb;
    private final int lSc;
    private boolean lSd;
    private final boolean lSe;
    private final c lSf;

    /* loaded from: classes10.dex */
    public interface c {
        l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4);
    }

    private i(a aVar) {
        this.lRV = aVar.lRV;
        this.lRW = aVar.lRW;
        this.lRX = aVar.lRX;
        this.lRY = aVar.lRY;
        this.lRZ = aVar.lRZ;
        this.lSa = aVar.lSa;
        this.lSb = aVar.lSb;
        this.lSc = aVar.lSc;
        this.lSd = aVar.lSd;
        this.lSe = aVar.lSe;
        if (aVar.lSf == null) {
            this.lSf = new b();
        } else {
            this.lSf = aVar.lSf;
        }
        this.lRv = aVar.lRv;
    }

    public boolean dnV() {
        return this.lRZ;
    }

    public boolean dnW() {
        return this.lRV;
    }

    public boolean dnX() {
        return this.lRX;
    }

    public b.a dnY() {
        return this.lRW;
    }

    public com.facebook.common.g.b dnZ() {
        return this.lRY;
    }

    public boolean doa() {
        return this.lSa;
    }

    public int dob() {
        return this.lSb;
    }

    public int doc() {
        return this.lSc;
    }

    public boolean dod() {
        return this.lSe;
    }

    public c doe() {
        return this.lSf;
    }

    public boolean dof() {
        return this.lSd;
    }

    public com.facebook.common.internal.j<Boolean> dog() {
        return this.lRv;
    }

    /* loaded from: classes10.dex */
    public static class a {
        private b.a lRW;
        private com.facebook.common.g.b lRY;
        public com.facebook.common.internal.j<Boolean> lRv;
        private c lSf;
        private final h.a lSg;
        private boolean lRV = false;
        private boolean lRX = false;
        private boolean lRZ = false;
        private boolean lSa = false;
        private int lSb = 0;
        private int lSc = 0;
        public boolean lSd = false;
        private boolean lSe = false;

        public a(h.a aVar) {
            this.lSg = aVar;
        }

        public i doh() {
            return new i(this);
        }
    }

    /* loaded from: classes10.dex */
    public static class b implements c {
        @Override // com.facebook.imagepipeline.d.i.c
        public l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4) {
            return new l(context, aVar, bVar, dVar, z, z2, z3, eVar, gVar, pVar, pVar2, eVar2, eVar3, fVar, fVar2, i, i2, z4);
        }
    }
}
