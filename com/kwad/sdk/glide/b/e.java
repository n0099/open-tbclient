package com.kwad.sdk.glide.b;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.b.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class e implements a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f10241a = e.class.getSimpleName();
    @ColorInt

    /* renamed from: b  reason: collision with root package name */
    private int[] f10242b;
    @ColorInt
    private final int[] c;
    private final a.InterfaceC1092a d;
    private ByteBuffer e;
    private byte[] f;
    private short[] g;
    private byte[] h;
    private byte[] i;
    private byte[] j;
    @ColorInt
    private int[] k;
    private int l;
    private c m;
    private Bitmap n;
    private boolean o;
    private int p;
    private int q;
    private int r;
    private int s;
    @Nullable
    private Boolean t;
    @NonNull
    private Bitmap.Config u;

    public e(@NonNull a.InterfaceC1092a interfaceC1092a) {
        this.c = new int[256];
        this.u = Bitmap.Config.ARGB_8888;
        this.d = interfaceC1092a;
        this.m = new c();
    }

    public e(@NonNull a.InterfaceC1092a interfaceC1092a, c cVar, ByteBuffer byteBuffer, int i) {
        this(interfaceC1092a);
        a(cVar, byteBuffer, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x006b, code lost:
        return 0;
     */
    @ColorInt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int a(int i, int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = i; i9 < this.q + i && i9 < this.j.length && i9 < i2; i9++) {
            int i10 = this.f10242b[this.j[i9] & 255];
            if (i10 != 0) {
                i8 += (i10 >> 24) & 255;
                i7 += (i10 >> 16) & 255;
                i6 += (i10 >> 8) & 255;
                i5 += i10 & 255;
                i4++;
            }
        }
        for (int i11 = i + i3; i11 < i + i3 + this.q && i11 < this.j.length && i11 < i2; i11++) {
            int i12 = this.f10242b[this.j[i11] & 255];
            if (i12 != 0) {
                i8 += (i12 >> 24) & 255;
                i7 += (i12 >> 16) & 255;
                i6 += (i12 >> 8) & 255;
                i5 += i12 & 255;
                i4++;
            }
        }
        return ((i8 / i4) << 24) | ((i7 / i4) << 16) | ((i6 / i4) << 8) | (i5 / i4);
    }

    private Bitmap a(b bVar, b bVar2) {
        int i;
        int[] iArr = this.k;
        if (bVar2 == null) {
            if (this.n != null) {
                this.d.a(this.n);
            }
            this.n = null;
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && bVar2.g == 3 && this.n == null) {
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && bVar2.g > 0) {
            if (bVar2.g == 2) {
                if (bVar.f) {
                    if (this.l == 0) {
                        this.t = true;
                    }
                    i = 0;
                } else {
                    i = this.m.l;
                    if (bVar.k != null && this.m.j == bVar.h) {
                        i = 0;
                    }
                }
                int i2 = bVar2.d / this.q;
                int i3 = bVar2.f10236b / this.q;
                int i4 = bVar2.c / this.q;
                int i5 = (i3 * this.s) + (bVar2.f10235a / this.q);
                int i6 = i5 + (i2 * this.s);
                while (i5 < i6) {
                    int i7 = i5 + i4;
                    for (int i8 = i5; i8 < i7; i8++) {
                        iArr[i8] = i;
                    }
                    i5 += this.s;
                }
            } else if (bVar2.g == 3 && this.n != null) {
                this.n.getPixels(iArr, 0, this.s, 0, 0, this.s, this.r);
            }
        }
        c(bVar);
        if (bVar.e || this.q != 1) {
            b(bVar);
        } else {
            a(bVar);
        }
        if (this.o && (bVar.g == 0 || bVar.g == 1)) {
            if (this.n == null) {
                this.n = l();
            }
            this.n.setPixels(iArr, 0, this.s, 0, 0, this.s, this.r);
        }
        Bitmap l = l();
        l.setPixels(iArr, 0, this.s, 0, 0, this.s, this.r);
        return l;
    }

    private void a(b bVar) {
        int[] iArr = this.k;
        int i = bVar.d;
        int i2 = bVar.f10236b;
        int i3 = bVar.c;
        int i4 = bVar.f10235a;
        boolean z = this.l == 0;
        int i5 = this.s;
        byte[] bArr = this.j;
        int[] iArr2 = this.f10242b;
        byte b2 = -1;
        for (int i6 = 0; i6 < i; i6++) {
            int i7 = (i6 + i2) * i5;
            int i8 = i7 + i4;
            int i9 = i8 + i3;
            if (i7 + i5 < i9) {
                i9 = i7 + i5;
            }
            int i10 = bVar.c * i6;
            while (i8 < i9) {
                byte b3 = bArr[i10];
                int i11 = b3 & 255;
                if (i11 != b2) {
                    int i12 = iArr2[i11];
                    if (i12 != 0) {
                        iArr[i8] = i12;
                    } else {
                        b2 = b3;
                    }
                }
                i8++;
                i10++;
            }
        }
        this.t = Boolean.valueOf(this.t == null && z && b2 != -1);
    }

    private void b(b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int[] iArr = this.k;
        int i5 = bVar.d / this.q;
        int i6 = bVar.f10236b / this.q;
        int i7 = bVar.c / this.q;
        int i8 = bVar.f10235a / this.q;
        int i9 = 1;
        int i10 = 8;
        int i11 = 0;
        boolean z = this.l == 0;
        int i12 = this.q;
        int i13 = this.s;
        int i14 = this.r;
        byte[] bArr = this.j;
        int[] iArr2 = this.f10242b;
        Boolean bool = this.t;
        int i15 = 0;
        while (i15 < i5) {
            if (bVar.e) {
                if (i11 >= i5) {
                    i9++;
                    switch (i9) {
                        case 2:
                            i11 = 4;
                            break;
                        case 3:
                            i11 = 2;
                            i10 = 4;
                            break;
                        case 4:
                            i11 = 1;
                            i10 = 2;
                            break;
                    }
                }
                i2 = i11 + i10;
                i = i11;
                i3 = i10;
                i4 = i9;
            } else {
                i = i15;
                i2 = i11;
                i3 = i10;
                i4 = i9;
            }
            int i16 = i + i6;
            boolean z2 = i12 == 1;
            if (i16 < i14) {
                int i17 = i16 * i13;
                int i18 = i17 + i8;
                int i19 = i18 + i7;
                if (i17 + i13 < i19) {
                    i19 = i17 + i13;
                }
                int i20 = i15 * i12 * bVar.c;
                if (z2) {
                    Boolean bool2 = bool;
                    while (i18 < i19) {
                        int i21 = iArr2[bArr[i20] & 255];
                        if (i21 != 0) {
                            iArr[i18] = i21;
                        } else if (z && bool2 == null) {
                            bool2 = true;
                        }
                        i20 += i12;
                        i18++;
                    }
                    bool = bool2;
                } else {
                    int i22 = i20 + ((i19 - i18) * i12);
                    Boolean bool3 = bool;
                    while (i18 < i19) {
                        int a2 = a(i20, i22, bVar.c);
                        if (a2 != 0) {
                            iArr[i18] = a2;
                        } else if (z && bool3 == null) {
                            bool3 = true;
                        }
                        i20 += i12;
                        i18++;
                    }
                    bool = bool3;
                }
            }
            i15++;
            i11 = i2;
            i10 = i3;
            i9 = i4;
        }
        if (this.t == null) {
            this.t = Boolean.valueOf(bool == null ? false : bool.booleanValue());
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:81:0x010c */
    /* JADX DEBUG: Multi-variable search result rejected for r2v39, resolved type: short */
    /* JADX WARN: Multi-variable type inference failed */
    private void c(b bVar) {
        int i;
        short s;
        int i2;
        int i3;
        if (bVar != null) {
            this.e.position(bVar.j);
        }
        int i4 = bVar == null ? this.m.f * this.m.g : bVar.c * bVar.d;
        if (this.j == null || this.j.length < i4) {
            this.j = this.d.a(i4);
        }
        byte[] bArr = this.j;
        if (this.g == null) {
            this.g = new short[4096];
        }
        short[] sArr = this.g;
        if (this.h == null) {
            this.h = new byte[4096];
        }
        byte[] bArr2 = this.h;
        if (this.i == null) {
            this.i = new byte[4097];
        }
        byte[] bArr3 = this.i;
        int j = j();
        int i5 = 1 << j;
        int i6 = i5 + 1;
        int i7 = i5 + 2;
        int i8 = -1;
        int i9 = j + 1;
        int i10 = (1 << i9) - 1;
        for (int i11 = 0; i11 < i5; i11++) {
            sArr[i11] = 0;
            bArr2[i11] = (byte) i11;
        }
        byte[] bArr4 = this.f;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        while (true) {
            if (i17 >= i4) {
                break;
            }
            if (i18 == 0) {
                i18 = k();
                if (i18 <= 0) {
                    this.p = 3;
                    break;
                }
                i13 = 0;
            }
            i19 += 8;
            int i20 = i13 + 1;
            int i21 = i18 - 1;
            int i22 = i15;
            i16 = ((bArr4[i13] & 255) << i19) + i16;
            while (true) {
                if (i19 < i9) {
                    i13 = i20;
                    i15 = i22;
                    i18 = i21;
                    break;
                }
                int i23 = i16 & i10;
                i16 >>= i9;
                i19 -= i9;
                if (i23 == i5) {
                    i9 = j + 1;
                    i10 = (1 << i9) - 1;
                    i7 = i5 + 2;
                    i8 = -1;
                } else if (i23 == i6) {
                    i13 = i20;
                    i15 = i22;
                    i18 = i21;
                    break;
                } else if (i8 == -1) {
                    bArr[i12] = bArr2[i23];
                    i12++;
                    i22 = i23;
                    i17++;
                    i8 = i23;
                } else {
                    if (i23 >= i7) {
                        bArr3[i14] = (byte) i22;
                        i = i14 + 1;
                        s = i8;
                    } else {
                        i = i14;
                        s = i23;
                    }
                    while (s >= i5) {
                        bArr3[i] = bArr2[s];
                        i++;
                        s = sArr[s];
                    }
                    i22 = bArr2[s] & 255;
                    bArr[i12] = (byte) i22;
                    int i24 = i17 + 1;
                    i12++;
                    i14 = i;
                    while (i14 > 0) {
                        int i25 = i14 - 1;
                        bArr[i12] = bArr3[i25];
                        i24++;
                        i12++;
                        i14 = i25;
                    }
                    if (i7 < 4096) {
                        sArr[i7] = (short) i8;
                        bArr2[i7] = (byte) i22;
                        i7++;
                        if ((i7 & i10) == 0 && i7 < 4096) {
                            i2 = i9 + 1;
                            i3 = i10 + i7;
                            i17 = i24;
                            i8 = i23;
                            i9 = i2;
                            i10 = i3;
                        }
                    }
                    i2 = i9;
                    i3 = i10;
                    i17 = i24;
                    i8 = i23;
                    i9 = i2;
                    i10 = i3;
                }
            }
        }
        Arrays.fill(bArr, i12, i4, (byte) 0);
    }

    private int j() {
        return this.e.get() & 255;
    }

    private int k() {
        int j = j();
        if (j > 0) {
            this.e.get(this.f, 0, Math.min(j, this.e.remaining()));
        }
        return j;
    }

    private Bitmap l() {
        Bitmap a2 = this.d.a(this.s, this.r, (this.t == null || this.t.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.u);
        a2.setHasAlpha(true);
        return a2;
    }

    public int a(int i) {
        if (i < 0 || i >= this.m.c) {
            return -1;
        }
        return this.m.e.get(i).i;
    }

    @Override // com.kwad.sdk.glide.b.a
    @NonNull
    public ByteBuffer a() {
        return this.e;
    }

    @Override // com.kwad.sdk.glide.b.a
    public void a(@NonNull Bitmap.Config config) {
        if (config != Bitmap.Config.ARGB_8888 && config != Bitmap.Config.RGB_565) {
            throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
        }
        this.u = config;
    }

    public synchronized void a(@NonNull c cVar, @NonNull ByteBuffer byteBuffer, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
        }
        int highestOneBit = Integer.highestOneBit(i);
        this.p = 0;
        this.m = cVar;
        this.l = -1;
        this.e = byteBuffer.asReadOnlyBuffer();
        this.e.position(0);
        this.e.order(ByteOrder.LITTLE_ENDIAN);
        this.o = false;
        Iterator<b> it = cVar.e.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().g == 3) {
                this.o = true;
                break;
            }
        }
        this.q = highestOneBit;
        this.s = cVar.f / highestOneBit;
        this.r = cVar.g / highestOneBit;
        this.j = this.d.a(cVar.f * cVar.g);
        this.k = this.d.b(this.s * this.r);
    }

    @Override // com.kwad.sdk.glide.b.a
    public void b() {
        this.l = (this.l + 1) % this.m.c;
    }

    @Override // com.kwad.sdk.glide.b.a
    public int c() {
        if (this.m.c <= 0 || this.l < 0) {
            return 0;
        }
        return a(this.l);
    }

    @Override // com.kwad.sdk.glide.b.a
    public int d() {
        return this.m.c;
    }

    @Override // com.kwad.sdk.glide.b.a
    public int e() {
        return this.l;
    }

    @Override // com.kwad.sdk.glide.b.a
    public void f() {
        this.l = -1;
    }

    @Override // com.kwad.sdk.glide.b.a
    public int g() {
        return this.e.limit() + this.j.length + (this.k.length * 4);
    }

    @Override // com.kwad.sdk.glide.b.a
    @Nullable
    public synchronized Bitmap h() {
        Bitmap bitmap;
        if (this.m.c <= 0 || this.l < 0) {
            if (Log.isLoggable(f10241a, 3)) {
                Log.d(f10241a, "Unable to decode frame, frameCount=" + this.m.c + ", framePointer=" + this.l);
            }
            this.p = 1;
        }
        if (this.p == 1 || this.p == 2) {
            if (Log.isLoggable(f10241a, 3)) {
                Log.d(f10241a, "Unable to decode frame, status=" + this.p);
            }
            bitmap = null;
        } else {
            this.p = 0;
            if (this.f == null) {
                this.f = this.d.a(255);
            }
            b bVar = this.m.e.get(this.l);
            int i = this.l - 1;
            b bVar2 = i >= 0 ? this.m.e.get(i) : null;
            this.f10242b = bVar.k != null ? bVar.k : this.m.f10237a;
            if (this.f10242b == null) {
                if (Log.isLoggable(f10241a, 3)) {
                    Log.d(f10241a, "No valid color table found for frame #" + this.l);
                }
                this.p = 1;
                bitmap = null;
            } else {
                if (bVar.f) {
                    System.arraycopy(this.f10242b, 0, this.c, 0, this.f10242b.length);
                    this.f10242b = this.c;
                    this.f10242b[bVar.h] = 0;
                }
                bitmap = a(bVar, bVar2);
            }
        }
        return bitmap;
    }

    @Override // com.kwad.sdk.glide.b.a
    public void i() {
        this.m = null;
        if (this.j != null) {
            this.d.a(this.j);
        }
        if (this.k != null) {
            this.d.a(this.k);
        }
        if (this.n != null) {
            this.d.a(this.n);
        }
        this.n = null;
        this.e = null;
        this.t = null;
        if (this.f != null) {
            this.d.a(this.f);
        }
    }
}
