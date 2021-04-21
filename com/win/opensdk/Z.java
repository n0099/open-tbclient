package com.win.opensdk;

import android.graphics.Bitmap;
import android.os.Build;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class Z {

    /* renamed from: a  reason: collision with root package name */
    public int[] f40225a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f40226b;

    /* renamed from: c  reason: collision with root package name */
    public ByteBuffer f40227c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f40228d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f40229e;

    /* renamed from: f  reason: collision with root package name */
    public int f40230f;

    /* renamed from: g  reason: collision with root package name */
    public int f40231g;

    /* renamed from: h  reason: collision with root package name */
    public c0 f40232h;
    public short[] i;
    public byte[] j;
    public byte[] k;
    public byte[] l;
    public int[] m;
    public int n;
    public int o;
    public b0 p;
    public i0 q;
    public Bitmap r;
    public boolean s;
    public int t;
    public int u;
    public int v;
    public int w;
    public boolean x;

    public Z() {
        i0 i0Var = new i0();
        this.f40226b = new int[256];
        this.f40230f = 0;
        this.f40231g = 0;
        this.q = i0Var;
        this.p = new b0();
    }

    public final Bitmap a() {
        Bitmap a2 = this.q.a(this.w, this.v, this.x ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        if (Build.VERSION.SDK_INT >= 12) {
            a2.setHasAlpha(true);
        }
        return a2;
    }

    public synchronized void a(b0 b0Var, ByteBuffer byteBuffer) {
        a(b0Var, byteBuffer, 1);
    }

    public synchronized void a(b0 b0Var, byte[] bArr) {
        a(b0Var, ByteBuffer.wrap(bArr));
    }

    public final void a(int[] iArr, a0 a0Var, int i) {
        int i2 = a0Var.f40241d;
        int i3 = this.u;
        int i4 = i2 / i3;
        int i5 = a0Var.f40239b / i3;
        int i6 = a0Var.f40240c / i3;
        int i7 = a0Var.f40238a / i3;
        int i8 = this.w;
        int i9 = (i5 * i8) + i7;
        int i10 = (i4 * i8) + i9;
        while (i9 < i10) {
            int i11 = i9 + i6;
            for (int i12 = i9; i12 < i11; i12++) {
                iArr[i12] = i;
            }
            i9 += this.w;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:254:0x01f8 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v32, resolved type: short */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0180 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0185  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized Bitmap b() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        short s;
        int i9;
        int i10;
        int i11;
        int i12 = 1;
        if (this.p.f40265c <= 0 || this.n < 0) {
            this.t = 1;
        }
        int i13 = this.t;
        if (i13 != 1 && i13 != 2) {
            int i14 = 0;
            this.t = 0;
            a0 a0Var = (a0) this.p.f40267e.get(this.n);
            int i15 = this.n - 1;
            a0 a0Var2 = i15 >= 0 ? (a0) this.p.f40267e.get(i15) : null;
            int[] iArr = a0Var.k;
            if (iArr == null) {
                iArr = this.p.f40263a;
            }
            this.f40225a = iArr;
            if (iArr == null) {
                this.t = 1;
                return null;
            }
            if (a0Var.f40243f) {
                System.arraycopy(iArr, 0, this.f40226b, 0, iArr.length);
                int[] iArr2 = this.f40226b;
                this.f40225a = iArr2;
                iArr2[a0Var.f40245h] = 0;
            }
            int[] iArr3 = this.m;
            if (a0Var2 == null) {
                Arrays.fill(iArr3, 0);
            }
            if (a0Var2 != null && (i10 = a0Var2.f40244g) > 0) {
                if (i10 == 2) {
                    if (!a0Var.f40243f) {
                        b0 b0Var = this.p;
                        i11 = b0Var.l;
                        if (a0Var.k != null && b0Var.j == a0Var.f40245h) {
                        }
                        a(iArr3, a0Var2, i11);
                    } else if (this.n == 0) {
                        this.x = true;
                    }
                    i11 = 0;
                    a(iArr3, a0Var2, i11);
                } else if (i10 == 3) {
                    Bitmap bitmap = this.r;
                    if (bitmap == null) {
                        a(iArr3, a0Var2, 0);
                    } else {
                        int i16 = a0Var2.f40241d;
                        int i17 = this.u;
                        int i18 = a0Var2.f40239b / i17;
                        int i19 = a0Var2.f40240c / i17;
                        int i20 = a0Var2.f40238a / i17;
                        int i21 = this.w;
                        bitmap.getPixels(iArr3, (i18 * i21) + i20, i21, i20, i18, i19, i16 / i17);
                    }
                }
            }
            this.f40230f = 0;
            this.f40231g = 0;
            this.f40227c.position(a0Var.j);
            int i22 = a0Var.f40240c * a0Var.f40241d;
            byte[] bArr = this.l;
            if (bArr == null || bArr.length < i22) {
                this.l = this.q.a(i22);
            }
            if (this.i == null) {
                this.i = new short[4096];
            }
            if (this.j == null) {
                this.j = new byte[4096];
            }
            if (this.k == null) {
                this.k = new byte[4097];
            }
            int c2 = c();
            int i23 = 1 << c2;
            int i24 = i23 + 1;
            int i25 = i23 + 2;
            int i26 = c2 + 1;
            int i27 = (1 << i26) - 1;
            for (int i28 = 0; i28 < i23; i28++) {
                this.i[i28] = 0;
                this.j[i28] = (byte) i28;
            }
            int i29 = i26;
            int i30 = i25;
            int i31 = i27;
            int i32 = 0;
            int i33 = 0;
            int i34 = 0;
            int i35 = 0;
            int i36 = 0;
            int i37 = 0;
            int i38 = 0;
            int i39 = 0;
            int i40 = -1;
            while (true) {
                if (i32 >= i22) {
                    break;
                }
                if (i33 == 0) {
                    i33 = c();
                    if (i33 > 0) {
                        try {
                            if (this.f40228d == null) {
                                this.f40228d = this.q.a(255);
                            }
                            int i41 = this.f40230f - this.f40231g;
                            if (i41 >= i33) {
                                System.arraycopy(this.f40229e, this.f40231g, this.f40228d, i14, i33);
                                i9 = this.f40231g + i33;
                            } else if (this.f40227c.remaining() + i41 >= i33) {
                                try {
                                    System.arraycopy(this.f40229e, this.f40231g, this.f40228d, i14, i41);
                                    this.f40231g = this.f40230f;
                                    d();
                                    int i42 = i33 - i41;
                                    System.arraycopy(this.f40229e, i14, this.f40228d, i41, i42);
                                    i9 = this.f40231g + i42;
                                } catch (Exception unused) {
                                    i12 = 1;
                                    this.t = i12;
                                    if (i33 > 0) {
                                    }
                                }
                            } else {
                                this.t = i12;
                            }
                            this.f40231g = i9;
                        } catch (Exception unused2) {
                        }
                    }
                    if (i33 > 0) {
                        this.t = 3;
                        break;
                    }
                    i35 = 0;
                }
                i34 += (this.f40228d[i35] & 255) << i36;
                i35++;
                i33--;
                int i43 = i36 + 8;
                int i44 = i38;
                int i45 = i30;
                int i46 = i29;
                int i47 = i40;
                while (i43 >= i46) {
                    int i48 = i26;
                    int i49 = i34 & i31;
                    i34 >>= i46;
                    i43 -= i46;
                    if (i49 != i23) {
                        if (i49 > i45) {
                            i8 = i43;
                            this.t = 3;
                        } else {
                            i8 = i43;
                            if (i49 != i24) {
                                if (i47 == -1) {
                                    this.k[i39] = this.j[i49];
                                    i39++;
                                    i47 = i49;
                                    i44 = i47;
                                    i26 = i48;
                                    i43 = i8;
                                } else {
                                    if (i49 >= i45) {
                                        this.k[i39] = (byte) i44;
                                        s = i47;
                                        i39++;
                                    } else {
                                        s = i49;
                                    }
                                    while (s >= i23) {
                                        this.k[i39] = this.j[s];
                                        s = this.i[s];
                                        i39++;
                                        i49 = i49;
                                    }
                                    int i50 = i49;
                                    byte[] bArr2 = this.j;
                                    int i51 = bArr2[s] & 255;
                                    int i52 = i39 + 1;
                                    int i53 = i23;
                                    byte b2 = (byte) i51;
                                    this.k[i39] = b2;
                                    if (i45 < 4096) {
                                        this.i[i45] = (short) i47;
                                        bArr2[i45] = b2;
                                        i45++;
                                        if ((i45 & i31) == 0 && i45 < 4096) {
                                            i46++;
                                            i31 += i45;
                                        }
                                    }
                                    i39 = i52;
                                    while (i39 > 0) {
                                        i39--;
                                        this.l[i37] = this.k[i39];
                                        i32++;
                                        i37++;
                                    }
                                    i44 = i51;
                                    i26 = i48;
                                    i43 = i8;
                                    i47 = i50;
                                    i23 = i53;
                                }
                            }
                        }
                        i40 = i47;
                        i29 = i46;
                        i26 = i48;
                        i36 = i8;
                        i14 = 0;
                        i12 = 1;
                        i38 = i44;
                        i30 = i45;
                        break;
                    }
                    i45 = i25;
                    i31 = i27;
                    i26 = i48;
                    i46 = i26;
                    i47 = -1;
                }
                i40 = i47;
                i36 = i43;
                i38 = i44;
                i30 = i45;
                i29 = i46;
                i14 = 0;
                i12 = 1;
            }
            for (int i54 = i37; i54 < i22; i54++) {
                this.l[i54] = 0;
            }
            int i55 = a0Var.f40241d;
            int i56 = this.u;
            int i57 = i55 / i56;
            int i58 = a0Var.f40239b / i56;
            int i59 = a0Var.f40240c / i56;
            int i60 = a0Var.f40238a / i56;
            boolean z = this.n == 0;
            int i61 = 0;
            int i62 = 1;
            int i63 = 0;
            int i64 = 8;
            while (i63 < i57) {
                if (a0Var.f40242e) {
                    if (i61 >= i57) {
                        i62++;
                        if (i62 == 2) {
                            i61 = 4;
                        } else if (i62 == 3) {
                            i61 = 2;
                            i64 = 4;
                        } else if (i62 == 4) {
                            i61 = 1;
                            i64 = 2;
                        }
                    }
                    i2 = i61 + i64;
                } else {
                    i2 = i61;
                    i61 = i63;
                }
                int i65 = i61 + i58;
                if (i65 < this.v) {
                    int i66 = this.w;
                    int i67 = i65 * i66;
                    int i68 = i67 + i60;
                    int i69 = i68 + i59;
                    int i70 = i67 + i66;
                    if (i70 < i69) {
                        i69 = i70;
                    }
                    int i71 = this.u;
                    int i72 = i63 * i71 * a0Var.f40240c;
                    int i73 = ((i69 - i68) * i71) + i72;
                    int i74 = i68;
                    while (i74 < i69) {
                        int i75 = i57;
                        int i76 = i58;
                        if (this.u == 1) {
                            i6 = this.f40225a[this.l[i72] & 255];
                            i3 = i59;
                            i4 = i60;
                            i5 = i62;
                        } else {
                            int i77 = a0Var.f40240c;
                            i3 = i59;
                            int i78 = i72;
                            int i79 = 0;
                            int i80 = 0;
                            int i81 = 0;
                            int i82 = 0;
                            int i83 = 0;
                            while (true) {
                                if (i78 >= this.u + i72) {
                                    i4 = i60;
                                    break;
                                }
                                byte[] bArr3 = this.l;
                                i4 = i60;
                                if (i78 >= bArr3.length || i78 >= i73) {
                                    break;
                                }
                                int i84 = this.f40225a[bArr3[i78] & 255];
                                if (i84 != 0) {
                                    i7 = i62;
                                    i82 += (i84 >> 24) & 255;
                                    i81 += (i84 >> 16) & 255;
                                    i80 += (i84 >> 8) & 255;
                                    i79 += i84 & 255;
                                    i83++;
                                } else {
                                    i7 = i62;
                                }
                                i78++;
                                i60 = i4;
                                i62 = i7;
                            }
                            i5 = i62;
                            int i85 = i77 + i72;
                            for (int i86 = i85; i86 < this.u + i85; i86++) {
                                byte[] bArr4 = this.l;
                                if (i86 >= bArr4.length || i86 >= i73) {
                                    break;
                                }
                                int i87 = this.f40225a[bArr4[i86] & 255];
                                if (i87 != 0) {
                                    i82 += (i87 >> 24) & 255;
                                    i81 += (i87 >> 16) & 255;
                                    i80 += (i87 >> 8) & 255;
                                    i79 += i87 & 255;
                                    i83++;
                                }
                            }
                            i6 = i83 == 0 ? 0 : ((i82 / i83) << 24) | ((i81 / i83) << 16) | ((i80 / i83) << 8) | (i79 / i83);
                        }
                        if (i6 != 0) {
                            iArr3[i74] = i6;
                        } else if (!this.x && z) {
                            this.x = true;
                        }
                        i72 += this.u;
                        i74++;
                        i57 = i75;
                        i58 = i76;
                        i59 = i3;
                        i60 = i4;
                        i62 = i5;
                    }
                }
                i63++;
                i61 = i2;
                i57 = i57;
                i58 = i58;
                i59 = i59;
                i60 = i60;
                i62 = i62;
            }
            if (this.s && ((i = a0Var.f40244g) == 0 || i == 1)) {
                if (this.r == null) {
                    this.r = a();
                }
                Bitmap bitmap2 = this.r;
                int i88 = this.w;
                bitmap2.setPixels(iArr3, 0, i88, 0, 0, i88, this.v);
            }
            Bitmap a2 = a();
            int i89 = this.w;
            a2.setPixels(iArr3, 0, i89, 0, 0, i89, this.v);
            return a2;
        }
        return null;
    }

    public final int c() {
        try {
            d();
            byte[] bArr = this.f40229e;
            int i = this.f40231g;
            this.f40231g = i + 1;
            return bArr[i] & 255;
        } catch (Exception unused) {
            this.t = 1;
            return 0;
        }
    }

    public final void d() {
        if (this.f40230f > this.f40231g) {
            return;
        }
        if (this.f40229e == null) {
            this.f40229e = this.q.a(16384);
        }
        this.f40231g = 0;
        int min = Math.min(this.f40227c.remaining(), 16384);
        this.f40230f = min;
        this.f40227c.get(this.f40229e, 0, min);
    }

    public synchronized int a(byte[] bArr) {
        if (this.f40232h == null) {
            this.f40232h = new c0();
        }
        c0 a2 = this.f40232h.a(bArr);
        if (a2.f40289b != null) {
            if (!a2.a()) {
                String str = "";
                for (int i = 0; i < 6; i++) {
                    str = str + ((char) a2.b());
                }
                if (str.startsWith("GIF")) {
                    a2.f40290c.f40268f = a2.f40289b.getShort();
                    a2.f40290c.f40269g = a2.f40289b.getShort();
                    int b2 = a2.b();
                    a2.f40290c.f40270h = (b2 & 128) != 0;
                    b0 b0Var = a2.f40290c;
                    b0Var.i = 2 << (b2 & 7);
                    b0Var.j = a2.b();
                    a2.f40290c.k = a2.b();
                    if (a2.f40290c.f40270h && !a2.a()) {
                        b0 b0Var2 = a2.f40290c;
                        b0Var2.f40263a = a2.a(b0Var2.i);
                        b0 b0Var3 = a2.f40290c;
                        b0Var3.l = b0Var3.f40263a[b0Var3.j];
                    }
                } else {
                    a2.f40290c.f40264b = 1;
                }
                if (!a2.a()) {
                    boolean z = false;
                    while (!z && !a2.a() && a2.f40290c.f40265c <= Integer.MAX_VALUE) {
                        int b3 = a2.b();
                        if (b3 == 33) {
                            int b4 = a2.b();
                            if (b4 != 1) {
                                if (b4 == 249) {
                                    a2.f40290c.f40266d = new a0();
                                    a2.b();
                                    int b5 = a2.b();
                                    a0 a0Var = a2.f40290c.f40266d;
                                    int i2 = (b5 & 28) >> 2;
                                    a0Var.f40244g = i2;
                                    if (i2 == 0) {
                                        a0Var.f40244g = 1;
                                    }
                                    a2.f40290c.f40266d.f40243f = (b5 & 1) != 0;
                                    short s = a2.f40289b.getShort();
                                    if (s < 2) {
                                        s = 10;
                                    }
                                    a0 a0Var2 = a2.f40290c.f40266d;
                                    a0Var2.i = s * 10;
                                    a0Var2.f40245h = a2.b();
                                    a2.b();
                                } else if (b4 != 254 && b4 == 255) {
                                    a2.c();
                                    String str2 = "";
                                    for (int i3 = 0; i3 < 11; i3++) {
                                        str2 = str2 + ((char) a2.f40288a[i3]);
                                    }
                                    if (str2.equals("NETSCAPE2.0")) {
                                        do {
                                            a2.c();
                                            byte[] bArr2 = a2.f40288a;
                                            if (bArr2[0] == 1) {
                                                b0 b0Var4 = a2.f40290c;
                                                int i4 = ((bArr2[2] & 255) << 8) | (bArr2[1] & 255);
                                                b0Var4.m = i4;
                                                if (i4 == 0) {
                                                    b0Var4.m = -1;
                                                }
                                            }
                                            if (a2.f40291d > 0) {
                                            }
                                        } while (!a2.a());
                                    }
                                }
                            }
                            a2.d();
                        } else if (b3 == 44) {
                            b0 b0Var5 = a2.f40290c;
                            if (b0Var5.f40266d == null) {
                                b0Var5.f40266d = new a0();
                            }
                            a2.f40290c.f40266d.f40238a = a2.f40289b.getShort();
                            a2.f40290c.f40266d.f40239b = a2.f40289b.getShort();
                            a2.f40290c.f40266d.f40240c = a2.f40289b.getShort();
                            a2.f40290c.f40266d.f40241d = a2.f40289b.getShort();
                            int b6 = a2.b();
                            boolean z2 = (b6 & 128) != 0;
                            int pow = (int) Math.pow(2.0d, (b6 & 7) + 1);
                            a2.f40290c.f40266d.f40242e = (b6 & 64) != 0;
                            if (z2) {
                                a2.f40290c.f40266d.k = a2.a(pow);
                            } else {
                                a2.f40290c.f40266d.k = null;
                            }
                            a2.f40290c.f40266d.j = a2.f40289b.position();
                            a2.b();
                            a2.d();
                            if (!a2.a()) {
                                b0 b0Var6 = a2.f40290c;
                                b0Var6.f40265c++;
                                b0Var6.f40267e.add(b0Var6.f40266d);
                            }
                        } else if (b3 != 59) {
                            a2.f40290c.f40264b = 1;
                        } else {
                            z = true;
                        }
                    }
                    b0 b0Var7 = a2.f40290c;
                    if (b0Var7.f40265c < 0) {
                        b0Var7.f40264b = 1;
                    }
                }
            }
            b0 b0Var8 = a2.f40290c;
            this.p = b0Var8;
            if (bArr != null) {
                a(b0Var8, bArr);
            }
        } else {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        return this.t;
    }

    public synchronized void a(b0 b0Var, ByteBuffer byteBuffer, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
        }
        int highestOneBit = Integer.highestOneBit(i);
        this.t = 0;
        this.p = b0Var;
        this.x = false;
        this.n = -1;
        this.o = 0;
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f40227c = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.f40227c.order(ByteOrder.LITTLE_ENDIAN);
        this.s = false;
        Iterator it = b0Var.f40267e.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (((a0) it.next()).f40244g == 3) {
                this.s = true;
                break;
            }
        }
        this.u = highestOneBit;
        int i2 = b0Var.f40268f;
        this.w = i2 / highestOneBit;
        int i3 = b0Var.f40269g;
        this.v = i3 / highestOneBit;
        this.l = this.q.a(i2 * i3);
        this.m = this.q.b(this.w * this.v);
    }

    public boolean a(int i) {
        if (i < -1 || i >= this.p.f40265c) {
            return false;
        }
        this.n = i;
        return true;
    }
}
