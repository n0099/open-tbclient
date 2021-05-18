package com.kwad.sdk.pngencrypt.chunk;

import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes6.dex */
public abstract class PngChunk {

    /* renamed from: a  reason: collision with root package name */
    public final String f33444a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f33445b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f33446c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f33447d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.pngencrypt.k f33448e;

    /* renamed from: f  reason: collision with root package name */
    public d f33449f;

    /* renamed from: h  reason: collision with root package name */
    public boolean f33451h = false;

    /* renamed from: g  reason: collision with root package name */
    public int f33450g = -1;

    /* loaded from: classes6.dex */
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
        this.f33444a = str;
        this.f33448e = kVar;
        this.f33445b = b.b(str);
        this.f33446c = b.c(str);
        this.f33447d = b.d(str);
    }

    public int a() {
        d dVar = this.f33449f;
        if (dVar != null) {
            return dVar.f33467a;
        }
        return -1;
    }

    public final void a(int i2) {
        this.f33450g = i2;
    }

    public abstract void a(d dVar);

    public long b() {
        d dVar = this.f33449f;
        if (dVar != null) {
            return dVar.c();
        }
        return -1L;
    }

    public void b(d dVar) {
        this.f33449f = dVar;
    }

    public String toString() {
        return "chunk id= " + this.f33444a + " (len=" + a() + " offset=" + b() + SmallTailInfo.EMOTION_SUFFIX;
    }
}
