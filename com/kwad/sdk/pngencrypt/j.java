package com.kwad.sdk.pngencrypt;

import java.util.Arrays;
import java.util.zip.Inflater;
/* loaded from: classes6.dex */
public class j extends DeflatedChunksSet {

    /* renamed from: g  reason: collision with root package name */
    public byte[] f36181g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f36182h;
    public final k i;
    public final e j;
    public final p k;
    public int[] l;

    /* renamed from: com.kwad.sdk.pngencrypt.j$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f36183a;

        static {
            int[] iArr = new int[FilterType.values().length];
            f36183a = iArr;
            try {
                iArr[FilterType.FILTER_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f36183a[FilterType.FILTER_SUB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f36183a[FilterType.FILTER_UP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f36183a[FilterType.FILTER_AVERAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f36183a[FilterType.FILTER_PAETH.ordinal()] = 5;
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
            this.f36181g[i2] = (byte) (this.f36087a[i2] + (((i3 > 0 ? this.f36181g[i3] & 255 : 0) + (this.f36182h[i2] & 255)) / 2));
            i2++;
            i3++;
        }
    }

    private void d(int i) {
        for (int i2 = 1; i2 <= i; i2++) {
            this.f36181g[i2] = this.f36087a[i2];
        }
    }

    private void e(int i) {
        int i2 = 1;
        int i3 = 1 - this.i.j;
        while (i2 <= i) {
            int i4 = 0;
            int i5 = i3 > 0 ? this.f36181g[i3] & 255 : 0;
            if (i3 > 0) {
                i4 = this.f36182h[i3] & 255;
            }
            this.f36181g[i2] = (byte) (this.f36087a[i2] + n.a(i5, this.f36182h[i2] & 255, i4));
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
            this.f36181g[i3] = this.f36087a[i3];
            i3++;
        }
        int i4 = i2 + 1;
        int i5 = 1;
        while (i4 <= i) {
            byte[] bArr = this.f36181g;
            bArr[i4] = (byte) (this.f36087a[i4] + bArr[i5]);
            i4++;
            i5++;
        }
    }

    private void g(int i) {
        for (int i2 = 1; i2 <= i; i2++) {
            this.f36181g[i2] = (byte) (this.f36087a[i2] + this.f36182h[i2]);
        }
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public void a() {
        super.a();
        this.k.a(h());
        i();
        p pVar = this.k;
        pVar.a(this.f36181g, pVar.m + 1);
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public int b() {
        return j();
    }

    public void b(int i) {
        byte[] bArr = this.f36181g;
        if (bArr == null || bArr.length < this.f36087a.length) {
            byte[] bArr2 = this.f36087a;
            this.f36181g = new byte[bArr2.length];
            this.f36182h = new byte[bArr2.length];
        }
        if (this.k.j == 0) {
            Arrays.fill(this.f36181g, (byte) 0);
        }
        byte[] bArr3 = this.f36181g;
        this.f36181g = this.f36182h;
        this.f36182h = bArr3;
        byte b2 = this.f36087a[0];
        if (!FilterType.isValidStandard(b2)) {
            throw new PngjException("Filter type " + ((int) b2) + " invalid");
        }
        FilterType byVal = FilterType.getByVal(b2);
        int[] iArr = this.l;
        iArr[b2] = iArr[b2] + 1;
        this.f36181g[0] = this.f36087a[0];
        int i2 = AnonymousClass1.f36183a[byVal.ordinal()];
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
            throw new PngjException("Filter type " + ((int) b2) + " not implemented");
        }
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public void c() {
        super.c();
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public void f() {
        super.f();
        this.f36181g = null;
        this.f36182h = null;
    }

    public void i() {
        b(this.k.m);
    }

    public int j() {
        int h2;
        e eVar = this.j;
        int i = 0;
        if (eVar == null) {
            int h3 = h();
            k kVar = this.i;
            if (h3 < kVar.f36185b - 1) {
                h2 = kVar.k;
                i = h2 + 1;
            }
        } else if (eVar.a()) {
            h2 = this.j.h();
            i = h2 + 1;
        }
        if (!this.f36089c) {
            a(i);
        }
        return i;
    }
}
