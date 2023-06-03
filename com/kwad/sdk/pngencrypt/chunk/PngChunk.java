package com.kwad.sdk.pngencrypt.chunk;

import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes10.dex */
public abstract class PngChunk {
    public final com.kwad.sdk.pngencrypt.k akJ;
    public final String alB;
    public final boolean alK;
    public final boolean alL;
    public final boolean alM;
    public d alN;
    public boolean alO = false;
    public int alP = -1;

    /* loaded from: classes10.dex */
    public enum ChunkOrderingConstraint {
        NONE,
        BEFORE_PLTE_AND_IDAT,
        AFTER_PLTE_BEFORE_IDAT,
        AFTER_PLTE_BEFORE_IDAT_PLTE_REQUIRED,
        BEFORE_IDAT,
        AFTER_IDAT,
        NA;

        public final boolean isOk(int i, boolean z) {
            if (this == NONE) {
                return true;
            }
            return this == BEFORE_IDAT ? i < 4 : this == BEFORE_PLTE_AND_IDAT ? i < 2 : this == AFTER_PLTE_BEFORE_IDAT ? z ? i < 4 : i < 4 && i > 2 : this == AFTER_IDAT && i > 4;
        }

        public final boolean mustGoAfterIDAT() {
            return this == AFTER_IDAT;
        }

        public final boolean mustGoAfterPLTE() {
            return this == AFTER_PLTE_BEFORE_IDAT || this == AFTER_PLTE_BEFORE_IDAT_PLTE_REQUIRED;
        }

        public final boolean mustGoBeforeIDAT() {
            return this == BEFORE_IDAT || this == BEFORE_PLTE_AND_IDAT || this == AFTER_PLTE_BEFORE_IDAT;
        }

        public final boolean mustGoBeforePLTE() {
            return this == BEFORE_PLTE_AND_IDAT;
        }
    }

    public PngChunk(String str, com.kwad.sdk.pngencrypt.k kVar) {
        this.alB = str;
        this.akJ = kVar;
        this.alK = b.dr(str);
        this.alL = b.ds(str);
        this.alM = b.dt(str);
    }

    private long yG() {
        d dVar = this.alN;
        if (dVar != null) {
            return dVar.yG();
        }
        return -1L;
    }

    private int yI() {
        d dVar = this.alN;
        if (dVar != null) {
            return dVar.len;
        }
        return -1;
    }

    public abstract void a(d dVar);

    public final void b(d dVar) {
        this.alN = dVar;
    }

    public final void br(int i) {
        this.alP = i;
    }

    public String toString() {
        return "chunk id= " + this.alB + " (len=" + yI() + " offset=" + yG() + SmallTailInfo.EMOTION_SUFFIX;
    }
}
