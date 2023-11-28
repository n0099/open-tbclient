package com.kwad.sdk.pngencrypt.chunk;

import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes10.dex */
public abstract class PngChunk {
    public final com.kwad.sdk.pngencrypt.k aJz;
    public final boolean aKA;
    public final boolean aKB;
    public d aKC;
    public boolean aKD = false;
    public int aKE = -1;
    public final boolean aKz;
    public final String agT;

    public abstract void a(d dVar);

    public PngChunk(String str, com.kwad.sdk.pngencrypt.k kVar) {
        this.agT = str;
        this.aJz = kVar;
        this.aKz = b.fB(str);
        this.aKA = b.fC(str);
        this.aKB = b.fD(str);
    }

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
            if (this == BEFORE_IDAT) {
                if (i < 4) {
                    return true;
                }
                return false;
            } else if (this == BEFORE_PLTE_AND_IDAT) {
                if (i < 2) {
                    return true;
                }
                return false;
            } else if (this == AFTER_PLTE_BEFORE_IDAT) {
                if (z) {
                    if (i < 4) {
                        return true;
                    }
                    return false;
                } else if (i < 4 && i > 2) {
                    return true;
                } else {
                    return false;
                }
            } else if (this == AFTER_IDAT && i > 4) {
                return true;
            } else {
                return false;
            }
        }

        public final boolean mustGoAfterIDAT() {
            if (this == AFTER_IDAT) {
                return true;
            }
            return false;
        }

        public final boolean mustGoAfterPLTE() {
            if (this != AFTER_PLTE_BEFORE_IDAT && this != AFTER_PLTE_BEFORE_IDAT_PLTE_REQUIRED) {
                return false;
            }
            return true;
        }

        public final boolean mustGoBeforeIDAT() {
            if (this != BEFORE_IDAT && this != BEFORE_PLTE_AND_IDAT && this != AFTER_PLTE_BEFORE_IDAT) {
                return false;
            }
            return true;
        }

        public final boolean mustGoBeforePLTE() {
            if (this == BEFORE_PLTE_AND_IDAT) {
                return true;
            }
            return false;
        }
    }

    private long IJ() {
        d dVar = this.aKC;
        if (dVar != null) {
            return dVar.IJ();
        }
        return -1L;
    }

    private int IL() {
        d dVar = this.aKC;
        if (dVar != null) {
            return dVar.len;
        }
        return -1;
    }

    public String toString() {
        return "chunk id= " + this.agT + " (len=" + IL() + " offset=" + IJ() + SmallTailInfo.EMOTION_SUFFIX;
    }

    public final void b(d dVar) {
        this.aKC = dVar;
    }

    public final void dq(int i) {
        this.aKE = i;
    }
}
