package com.kwad.sdk.pngencrypt.chunk;

import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes5.dex */
public abstract class PngChunk {
    public final String a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final com.kwad.sdk.pngencrypt.k e;
    public d f;
    public boolean h = false;
    public int g = -1;

    /* loaded from: classes5.dex */
    public enum ChunkOrderingConstraint {
        NONE,
        BEFORE_PLTE_AND_IDAT,
        AFTER_PLTE_BEFORE_IDAT,
        AFTER_PLTE_BEFORE_IDAT_PLTE_REQUIRED,
        BEFORE_IDAT,
        AFTER_IDAT,
        NA;

        public boolean isOk(int i, boolean z) {
            if (this == NONE) {
                return true;
            }
            if (this == BEFORE_IDAT) {
                return i < 4;
            } else if (this == BEFORE_PLTE_AND_IDAT) {
                return i < 2;
            } else if (this != AFTER_PLTE_BEFORE_IDAT) {
                return this == AFTER_IDAT && i > 4;
            } else {
                if (z) {
                    if (i < 4) {
                        return true;
                    }
                } else if (i < 4 && i > 2) {
                    return true;
                }
                return false;
            }
        }

        public boolean mustGoAfterIDAT() {
            return this == AFTER_IDAT;
        }

        public boolean mustGoAfterPLTE() {
            return this == AFTER_PLTE_BEFORE_IDAT || this == AFTER_PLTE_BEFORE_IDAT_PLTE_REQUIRED;
        }

        public boolean mustGoBeforeIDAT() {
            return this == BEFORE_IDAT || this == BEFORE_PLTE_AND_IDAT || this == AFTER_PLTE_BEFORE_IDAT;
        }

        public boolean mustGoBeforePLTE() {
            return this == BEFORE_PLTE_AND_IDAT;
        }
    }

    public PngChunk(String str, com.kwad.sdk.pngencrypt.k kVar) {
        this.a = str;
        this.e = kVar;
        this.b = b.b(str);
        this.c = b.c(str);
        this.d = b.d(str);
    }

    public int a() {
        d dVar = this.f;
        if (dVar != null) {
            return dVar.a;
        }
        return -1;
    }

    public final void a(int i) {
        this.g = i;
    }

    public abstract void a(d dVar);

    public long b() {
        d dVar = this.f;
        if (dVar != null) {
            return dVar.c();
        }
        return -1L;
    }

    public void b(d dVar) {
        this.f = dVar;
    }

    public String toString() {
        return "chunk id= " + this.a + " (len=" + a() + " offset=" + b() + SmallTailInfo.EMOTION_SUFFIX;
    }
}
