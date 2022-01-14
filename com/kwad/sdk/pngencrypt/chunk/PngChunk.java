package com.kwad.sdk.pngencrypt.chunk;

import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes3.dex */
public abstract class PngChunk {
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f57044b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f57045c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f57046d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.pngencrypt.k f57047e;

    /* renamed from: f  reason: collision with root package name */
    public d f57048f;

    /* renamed from: h  reason: collision with root package name */
    public boolean f57050h = false;

    /* renamed from: g  reason: collision with root package name */
    public int f57049g = -1;

    /* loaded from: classes3.dex */
    public enum ChunkOrderingConstraint {
        NONE,
        BEFORE_PLTE_AND_IDAT,
        AFTER_PLTE_BEFORE_IDAT,
        AFTER_PLTE_BEFORE_IDAT_PLTE_REQUIRED,
        BEFORE_IDAT,
        AFTER_IDAT,
        NA;

        public boolean isOk(int i2, boolean z) {
            if (this == NONE) {
                return true;
            }
            if (this == BEFORE_IDAT) {
                return i2 < 4;
            } else if (this == BEFORE_PLTE_AND_IDAT) {
                return i2 < 2;
            } else if (this != AFTER_PLTE_BEFORE_IDAT) {
                return this == AFTER_IDAT && i2 > 4;
            } else {
                if (z) {
                    if (i2 < 4) {
                        return true;
                    }
                } else if (i2 < 4 && i2 > 2) {
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
        this.f57047e = kVar;
        this.f57044b = b.b(str);
        this.f57045c = b.c(str);
        this.f57046d = b.d(str);
    }

    public int a() {
        d dVar = this.f57048f;
        if (dVar != null) {
            return dVar.a;
        }
        return -1;
    }

    public final void a(int i2) {
        this.f57049g = i2;
    }

    public abstract void a(d dVar);

    public long b() {
        d dVar = this.f57048f;
        if (dVar != null) {
            return dVar.c();
        }
        return -1L;
    }

    public void b(d dVar) {
        this.f57048f = dVar;
    }

    public String toString() {
        return "chunk id= " + this.a + " (len=" + a() + " offset=" + b() + SmallTailInfo.EMOTION_SUFFIX;
    }
}
