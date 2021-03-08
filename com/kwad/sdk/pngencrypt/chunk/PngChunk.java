package com.kwad.sdk.pngencrypt.chunk;
/* loaded from: classes3.dex */
public abstract class PngChunk {

    /* renamed from: a  reason: collision with root package name */
    public final String f6917a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    protected final com.kwad.sdk.pngencrypt.k e;
    protected d f;
    private boolean h = false;
    protected int g = -1;

    /* loaded from: classes3.dex */
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
            return this == BEFORE_IDAT ? i < 4 : this == BEFORE_PLTE_AND_IDAT ? i < 2 : this == AFTER_PLTE_BEFORE_IDAT ? z ? i < 4 : i < 4 && i > 2 : this == AFTER_IDAT && i > 4;
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
        this.f6917a = str;
        this.e = kVar;
        this.b = b.b(str);
        this.c = b.c(str);
        this.d = b.d(str);
    }

    public int a() {
        if (this.f != null) {
            return this.f.f6921a;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i) {
        this.g = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(d dVar);

    public long b() {
        if (this.f != null) {
            return this.f.c();
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(d dVar) {
        this.f = dVar;
    }

    public String toString() {
        return "chunk id= " + this.f6917a + " (len=" + a() + " offset=" + b() + ")";
    }
}
