package com.kwad.sdk.pngencrypt;

import java.util.Arrays;
import java.util.zip.Inflater;
/* loaded from: classes5.dex */
public class j extends DeflatedChunksSet {
    public byte[] g;
    public byte[] h;
    public final k i;
    public final e j;
    public final p k;
    public int[] l;

    /* renamed from: com.kwad.sdk.pngencrypt.j$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[FilterType.values().length];
            a = iArr;
            try {
                iArr[FilterType.FILTER_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[FilterType.FILTER_SUB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[FilterType.FILTER_UP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[FilterType.FILTER_AVERAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[FilterType.FILTER_PAETH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public j(String str, boolean z, k kVar, e eVar) {
        this(str, z, kVar, eVar, null, null);
    }

    public j(String str, boolean z, k kVar, e eVar, Inflater inflater, byte[] bArr) {
        super(str, z, (eVar != null ? eVar.h() : kVar.k) + 1, kVar.k + 1, inflater, bArr);
        this.l = new int[5];
        this.i = kVar;
        this.j = eVar;
        this.k = new p(kVar, eVar);
        com.kwad.sdk.core.d.a.a("PNG_ENCRYPT", "Creating IDAT set ");
    }

    private void c(int i) {
        int i2 = 1;
        int i3 = 1 - this.i.j;
        while (i2 <= i) {
            this.g[i2] = (byte) (this.a[i2] + (((i3 > 0 ? this.g[i3] & 255 : 0) + (this.h[i2] & 255)) / 2));
            i2++;
            i3++;
        }
    }

    private void d(int i) {
        for (int i2 = 1; i2 <= i; i2++) {
            this.g[i2] = this.a[i2];
        }
    }

    private void e(int i) {
        int i2 = 1;
        int i3 = 1 - this.i.j;
        while (i2 <= i) {
            int i4 = 0;
            int i5 = i3 > 0 ? this.g[i3] & 255 : 0;
            if (i3 > 0) {
                i4 = this.h[i3] & 255;
            }
            this.g[i2] = (byte) (this.a[i2] + n.a(i5, this.h[i2] & 255, i4));
            i2++;
            i3++;
        }
    }

    private void f(int i) {
        int i2;
        int i3 = 1;
        while (true) {
            i2 = this.i.j;
            if (i3 > i2) {
                break;
            }
            this.g[i3] = this.a[i3];
            i3++;
        }
        int i4 = i2 + 1;
        int i5 = 1;
        while (i4 <= i) {
            byte[] bArr = this.g;
            bArr[i4] = (byte) (this.a[i4] + bArr[i5]);
            i4++;
            i5++;
        }
    }

    private void g(int i) {
        for (int i2 = 1; i2 <= i; i2++) {
            this.g[i2] = (byte) (this.a[i2] + this.h[i2]);
        }
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public void a() {
        super.a();
        this.k.a(h());
        i();
        p pVar = this.k;
        pVar.a(this.g, pVar.m + 1);
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public int b() {
        return j();
    }

    public void b(int i) {
        byte[] bArr = this.g;
        if (bArr == null || bArr.length < this.a.length) {
            byte[] bArr2 = this.a;
            this.g = new byte[bArr2.length];
            this.h = new byte[bArr2.length];
        }
        if (this.k.j == 0) {
            Arrays.fill(this.g, (byte) 0);
        }
        byte[] bArr3 = this.g;
        this.g = this.h;
        this.h = bArr3;
        byte b = this.a[0];
        if (!FilterType.isValidStandard(b)) {
            throw new PngjException("Filter type " + ((int) b) + " invalid");
        }
        FilterType byVal = FilterType.getByVal(b);
        int[] iArr = this.l;
        iArr[b] = iArr[b] + 1;
        this.g[0] = this.a[0];
        int i2 = AnonymousClass1.a[byVal.ordinal()];
        if (i2 == 1) {
            d(i);
        } else if (i2 == 2) {
            f(i);
        } else if (i2 == 3) {
            g(i);
        } else if (i2 == 4) {
            c(i);
        } else if (i2 == 5) {
            e(i);
        } else {
            throw new PngjException("Filter type " + ((int) b) + " not implemented");
        }
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public void c() {
        super.c();
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public void f() {
        super.f();
        this.g = null;
        this.h = null;
    }

    public void i() {
        b(this.k.m);
    }

    public int j() {
        int h;
        e eVar = this.j;
        int i = 0;
        if (eVar == null) {
            int h2 = h();
            k kVar = this.i;
            if (h2 < kVar.b - 1) {
                h = kVar.k;
                i = h + 1;
            }
        } else if (eVar.a()) {
            h = this.j.h();
            i = h + 1;
        }
        if (!this.c) {
            a(i);
        }
        return i;
    }
}
