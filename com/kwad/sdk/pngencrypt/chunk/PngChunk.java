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
        this.a = str;
        this.e = kVar;
        this.b = b.b(str);
        this.c = b.c(str);
        this.d = b.d(str);
    }

    private int a() {
        d dVar = this.f;
        if (dVar != null) {
            return dVar.a;
        }
        return -1;
    }

    private long b() {
        d dVar = this.f;
        if (dVar != null) {
            return dVar.b();
        }
        return -1L;
    }

    public final void a(int i) {
        this.g = i;
    }

    public abstract void a(d dVar);

    public final void b(d dVar) {
        this.f = dVar;
    }

    public String toString() {
        return "chunk id= " + this.a + " (len=" + a() + " offset=" + b() + SmallTailInfo.EMOTION_SUFFIX;
    }
}
