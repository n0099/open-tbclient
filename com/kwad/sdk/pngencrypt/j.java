package com.kwad.sdk.pngencrypt;

import java.util.Arrays;
import java.util.zip.Inflater;
/* loaded from: classes6.dex */
public class j extends DeflatedChunksSet {

    /* renamed from: g  reason: collision with root package name */
    public byte[] f34278g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f34279h;

    /* renamed from: i  reason: collision with root package name */
    public final k f34280i;
    public final e j;
    public final p k;
    public int[] l;

    /* renamed from: com.kwad.sdk.pngencrypt.j$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f34281a;

        static {
            int[] iArr = new int[FilterType.values().length];
            f34281a = iArr;
            try {
                iArr[FilterType.FILTER_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34281a[FilterType.FILTER_SUB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f34281a[FilterType.FILTER_UP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f34281a[FilterType.FILTER_AVERAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f34281a[FilterType.FILTER_PAETH.ordinal()] = 5;
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
        this.f34280i = kVar;
        this.j = eVar;
        this.k = new p(kVar, eVar);
        com.kwad.sdk.core.d.a.a("PNG_ENCRYPT", "Creating IDAT set ");
    }

    private void c(int i2) {
        int i3 = 1;
        int i4 = 1 - this.f34280i.j;
        while (i3 <= i2) {
            this.f34278g[i3] = (byte) (this.f34164a[i3] + (((i4 > 0 ? this.f34278g[i4] & 255 : 0) + (this.f34279h[i3] & 255)) / 2));
            i3++;
            i4++;
        }
    }

    private void d(int i2) {
        for (int i3 = 1; i3 <= i2; i3++) {
            this.f34278g[i3] = this.f34164a[i3];
        }
    }

    private void e(int i2) {
        int i3 = 1;
        int i4 = 1 - this.f34280i.j;
        while (i3 <= i2) {
            int i5 = 0;
            int i6 = i4 > 0 ? this.f34278g[i4] & 255 : 0;
            if (i4 > 0) {
                i5 = this.f34279h[i4] & 255;
            }
            this.f34278g[i3] = (byte) (this.f34164a[i3] + n.a(i6, this.f34279h[i3] & 255, i5));
            i3++;
            i4++;
        }
    }

    private void f(int i2) {
        int i3;
        int i4 = 1;
        while (true) {
            i3 = this.f34280i.j;
            if (i4 > i3) {
                break;
            }
            this.f34278g[i4] = this.f34164a[i4];
            i4++;
        }
        int i5 = i3 + 1;
        int i6 = 1;
        while (i5 <= i2) {
            byte[] bArr = this.f34278g;
            bArr[i5] = (byte) (this.f34164a[i5] + bArr[i6]);
            i5++;
            i6++;
        }
    }

    private void g(int i2) {
        for (int i3 = 1; i3 <= i2; i3++) {
            this.f34278g[i3] = (byte) (this.f34164a[i3] + this.f34279h[i3]);
        }
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public void a() {
        super.a();
        this.k.a(h());
        i();
        p pVar = this.k;
        pVar.a(this.f34278g, pVar.m + 1);
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public int b() {
        return j();
    }

    public void b(int i2) {
        byte[] bArr = this.f34278g;
        if (bArr == null || bArr.length < this.f34164a.length) {
            byte[] bArr2 = this.f34164a;
            this.f34278g = new byte[bArr2.length];
            this.f34279h = new byte[bArr2.length];
        }
        if (this.k.j == 0) {
            Arrays.fill(this.f34278g, (byte) 0);
        }
        byte[] bArr3 = this.f34278g;
        this.f34278g = this.f34279h;
        this.f34279h = bArr3;
        byte b2 = this.f34164a[0];
        if (!FilterType.isValidStandard(b2)) {
            throw new PngjException("Filter type " + ((int) b2) + " invalid");
        }
        FilterType byVal = FilterType.getByVal(b2);
        int[] iArr = this.l;
        iArr[b2] = iArr[b2] + 1;
        this.f34278g[0] = this.f34164a[0];
        int i3 = AnonymousClass1.f34281a[byVal.ordinal()];
        if (i3 == 1) {
            d(i2);
        } else if (i3 == 2) {
            f(i2);
        } else if (i3 == 3) {
            g(i2);
        } else if (i3 == 4) {
            c(i2);
        } else if (i3 == 5) {
            e(i2);
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
        this.f34278g = null;
        this.f34279h = null;
    }

    public void i() {
        b(this.k.m);
    }

    public int j() {
        int h2;
        e eVar = this.j;
        int i2 = 0;
        if (eVar == null) {
            int h3 = h();
            k kVar = this.f34280i;
            if (h3 < kVar.f34283b - 1) {
                h2 = kVar.k;
                i2 = h2 + 1;
            }
        } else if (eVar.a()) {
            h2 = this.j.h();
            i2 = h2 + 1;
        }
        if (!this.f34166c) {
            a(i2);
        }
        return i2;
    }
}
