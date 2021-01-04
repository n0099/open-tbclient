package com.kwad.sdk.pngencrypt;

import java.util.Arrays;
import java.util.zip.Inflater;
/* loaded from: classes5.dex */
public class j extends DeflatedChunksSet {
    protected byte[] g;
    protected byte[] h;
    protected final k i;
    protected final e j;
    final p k;
    protected int[] l;

    public j(String str, boolean z, k kVar, e eVar) {
        this(str, z, kVar, eVar, null, null);
    }

    public j(String str, boolean z, k kVar, e eVar, Inflater inflater, byte[] bArr) {
        super(str, z, eVar != null ? eVar.h() + 1 : kVar.k + 1, kVar.k + 1, inflater, bArr);
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
            this.g[i2] = (byte) ((((i3 > 0 ? this.g[i3] & 255 : 0) + (this.h[i2] & 255)) / 2) + this.f10786a[i2]);
            i2++;
            i3++;
        }
    }

    private void d(int i) {
        for (int i2 = 1; i2 <= i; i2++) {
            this.g[i2] = this.f10786a[i2];
        }
    }

    private void e(int i) {
        int i2 = 1 - this.i.j;
        for (int i3 = 1; i3 <= i; i3++) {
            this.g[i3] = (byte) (n.a(i2 > 0 ? this.g[i2] & 255 : 0, this.h[i3] & 255, i2 > 0 ? this.h[i2] & 255 : 0) + this.f10786a[i3]);
            i2++;
        }
    }

    private void f(int i) {
        int i2 = 1;
        for (int i3 = 1; i3 <= this.i.j; i3++) {
            this.g[i3] = this.f10786a[i3];
        }
        int i4 = this.i.j + 1;
        while (i4 <= i) {
            this.g[i4] = (byte) (this.f10786a[i4] + this.g[i2]);
            i4++;
            i2++;
        }
    }

    private void g(int i) {
        for (int i2 = 1; i2 <= i; i2++) {
            this.g[i2] = (byte) (this.f10786a[i2] + this.h[i2]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public void a() {
        super.a();
        this.k.a(h());
        i();
        this.k.a(this.g, this.k.m + 1);
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    protected int b() {
        return j();
    }

    protected void b(int i) {
        if (this.g == null || this.g.length < this.f10786a.length) {
            this.g = new byte[this.f10786a.length];
            this.h = new byte[this.f10786a.length];
        }
        if (this.k.j == 0) {
            Arrays.fill(this.g, (byte) 0);
        }
        byte[] bArr = this.g;
        this.g = this.h;
        this.h = bArr;
        byte b2 = this.f10786a[0];
        if (!FilterType.isValidStandard(b2)) {
            throw new PngjException("Filter type " + ((int) b2) + " invalid");
        }
        FilterType byVal = FilterType.getByVal(b2);
        int[] iArr = this.l;
        iArr[b2] = iArr[b2] + 1;
        this.g[0] = this.f10786a[0];
        switch (byVal) {
            case FILTER_NONE:
                d(i);
                return;
            case FILTER_SUB:
                f(i);
                return;
            case FILTER_UP:
                g(i);
                return;
            case FILTER_AVERAGE:
                c(i);
                return;
            case FILTER_PAETH:
                e(i);
                return;
            default:
                throw new PngjException("Filter type " + ((int) b2) + " not implemented");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
        int i = 0;
        if (this.j == null) {
            if (h() < this.i.f10811b - 1) {
                i = this.i.k + 1;
            }
        } else if (this.j.a()) {
            i = this.j.h() + 1;
        }
        if (!this.c) {
            a(i);
        }
        return i;
    }
}
