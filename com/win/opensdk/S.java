package com.win.opensdk;

import android.graphics.Bitmap;
import android.os.Build;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class S {

    /* renamed from: a  reason: collision with root package name */
    public int[] f40714a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f40715b;

    /* renamed from: c  reason: collision with root package name */
    public ByteBuffer f40716c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f40717d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f40718e;

    /* renamed from: f  reason: collision with root package name */
    public int f40719f;

    /* renamed from: g  reason: collision with root package name */
    public int f40720g;

    /* renamed from: h  reason: collision with root package name */
    public V f40721h;

    /* renamed from: i  reason: collision with root package name */
    public short[] f40722i;
    public byte[] j;
    public byte[] k;
    public byte[] l;
    public int[] m;
    public int n;
    public int o;
    public U p;
    public b0 q;
    public Bitmap r;
    public boolean s;
    public int t;
    public int u;
    public int v;
    public int w;
    public boolean x;

    public S() {
        b0 b0Var = new b0();
        this.f40715b = new int[256];
        this.f40719f = 0;
        this.f40720g = 0;
        this.q = b0Var;
        this.p = new U();
    }

    public final Bitmap a() {
        Bitmap a2 = this.q.a(this.w, this.v, this.x ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        if (Build.VERSION.SDK_INT >= 12) {
            a2.setHasAlpha(true);
        }
        return a2;
    }

    public synchronized void a(U u, ByteBuffer byteBuffer) {
        a(u, byteBuffer, 1);
    }

    public synchronized void a(U u, byte[] bArr) {
        a(u, ByteBuffer.wrap(bArr));
    }

    public final void a(int[] iArr, T t, int i2) {
        int i3 = t.f40728d;
        int i4 = this.u;
        int i5 = i3 / i4;
        int i6 = t.f40726b / i4;
        int i7 = t.f40727c / i4;
        int i8 = t.f40725a / i4;
        int i9 = this.w;
        int i10 = (i6 * i9) + i8;
        int i11 = (i5 * i9) + i10;
        while (i10 < i11) {
            int i12 = i10 + i7;
            for (int i13 = i10; i13 < i12; i13++) {
                iArr[i13] = i2;
            }
            i10 += this.w;
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
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        short s;
        int i10;
        int i11;
        int i12;
        int i13 = 1;
        if (this.p.f40737c <= 0 || this.n < 0) {
            this.t = 1;
        }
        int i14 = this.t;
        if (i14 != 1 && i14 != 2) {
            int i15 = 0;
            this.t = 0;
            T t = (T) this.p.f40739e.get(this.n);
            int i16 = this.n - 1;
            T t2 = i16 >= 0 ? (T) this.p.f40739e.get(i16) : null;
            int[] iArr = t.k;
            if (iArr == null) {
                iArr = this.p.f40735a;
            }
            this.f40714a = iArr;
            if (iArr == null) {
                this.t = 1;
                return null;
            }
            if (t.f40730f) {
                System.arraycopy(iArr, 0, this.f40715b, 0, iArr.length);
                int[] iArr2 = this.f40715b;
                this.f40714a = iArr2;
                iArr2[t.f40732h] = 0;
            }
            int[] iArr3 = this.m;
            if (t2 == null) {
                Arrays.fill(iArr3, 0);
            }
            if (t2 != null && (i11 = t2.f40731g) > 0) {
                if (i11 == 2) {
                    if (!t.f40730f) {
                        U u = this.p;
                        i12 = u.l;
                        if (t.k != null && u.j == t.f40732h) {
                        }
                        a(iArr3, t2, i12);
                    } else if (this.n == 0) {
                        this.x = true;
                    }
                    i12 = 0;
                    a(iArr3, t2, i12);
                } else if (i11 == 3) {
                    Bitmap bitmap = this.r;
                    if (bitmap == null) {
                        a(iArr3, t2, 0);
                    } else {
                        int i17 = t2.f40728d;
                        int i18 = this.u;
                        int i19 = t2.f40726b / i18;
                        int i20 = t2.f40727c / i18;
                        int i21 = t2.f40725a / i18;
                        int i22 = this.w;
                        bitmap.getPixels(iArr3, (i19 * i22) + i21, i22, i21, i19, i20, i17 / i18);
                    }
                }
            }
            this.f40719f = 0;
            this.f40720g = 0;
            this.f40716c.position(t.j);
            int i23 = t.f40727c * t.f40728d;
            byte[] bArr = this.l;
            if (bArr == null || bArr.length < i23) {
                this.l = this.q.a(i23);
            }
            if (this.f40722i == null) {
                this.f40722i = new short[4096];
            }
            if (this.j == null) {
                this.j = new byte[4096];
            }
            if (this.k == null) {
                this.k = new byte[4097];
            }
            int c2 = c();
            int i24 = 1 << c2;
            int i25 = i24 + 1;
            int i26 = i24 + 2;
            int i27 = c2 + 1;
            int i28 = (1 << i27) - 1;
            for (int i29 = 0; i29 < i24; i29++) {
                this.f40722i[i29] = 0;
                this.j[i29] = (byte) i29;
            }
            int i30 = i27;
            int i31 = i26;
            int i32 = i28;
            int i33 = 0;
            int i34 = 0;
            int i35 = 0;
            int i36 = 0;
            int i37 = 0;
            int i38 = 0;
            int i39 = 0;
            int i40 = 0;
            int i41 = -1;
            while (true) {
                if (i33 >= i23) {
                    break;
                }
                if (i34 == 0) {
                    i34 = c();
                    if (i34 > 0) {
                        try {
                            if (this.f40717d == null) {
                                this.f40717d = this.q.a(255);
                            }
                            int i42 = this.f40719f - this.f40720g;
                            if (i42 >= i34) {
                                System.arraycopy(this.f40718e, this.f40720g, this.f40717d, i15, i34);
                                i10 = this.f40720g + i34;
                            } else if (this.f40716c.remaining() + i42 >= i34) {
                                try {
                                    System.arraycopy(this.f40718e, this.f40720g, this.f40717d, i15, i42);
                                    this.f40720g = this.f40719f;
                                    d();
                                    int i43 = i34 - i42;
                                    System.arraycopy(this.f40718e, i15, this.f40717d, i42, i43);
                                    i10 = this.f40720g + i43;
                                } catch (Exception unused) {
                                    i13 = 1;
                                    this.t = i13;
                                    if (i34 > 0) {
                                    }
                                }
                            } else {
                                this.t = i13;
                            }
                            this.f40720g = i10;
                        } catch (Exception unused2) {
                        }
                    }
                    if (i34 > 0) {
                        this.t = 3;
                        break;
                    }
                    i36 = 0;
                }
                i35 += (this.f40717d[i36] & 255) << i37;
                i36++;
                i34--;
                int i44 = i37 + 8;
                int i45 = i39;
                int i46 = i31;
                int i47 = i30;
                int i48 = i41;
                while (i44 >= i47) {
                    int i49 = i27;
                    int i50 = i35 & i32;
                    i35 >>= i47;
                    i44 -= i47;
                    if (i50 != i24) {
                        if (i50 > i46) {
                            i9 = i44;
                            this.t = 3;
                        } else {
                            i9 = i44;
                            if (i50 != i25) {
                                if (i48 == -1) {
                                    this.k[i40] = this.j[i50];
                                    i40++;
                                    i48 = i50;
                                    i45 = i48;
                                    i27 = i49;
                                    i44 = i9;
                                } else {
                                    if (i50 >= i46) {
                                        this.k[i40] = (byte) i45;
                                        s = i48;
                                        i40++;
                                    } else {
                                        s = i50;
                                    }
                                    while (s >= i24) {
                                        this.k[i40] = this.j[s];
                                        s = this.f40722i[s];
                                        i40++;
                                        i50 = i50;
                                    }
                                    int i51 = i50;
                                    byte[] bArr2 = this.j;
                                    int i52 = bArr2[s] & 255;
                                    int i53 = i40 + 1;
                                    int i54 = i24;
                                    byte b2 = (byte) i52;
                                    this.k[i40] = b2;
                                    if (i46 < 4096) {
                                        this.f40722i[i46] = (short) i48;
                                        bArr2[i46] = b2;
                                        i46++;
                                        if ((i46 & i32) == 0 && i46 < 4096) {
                                            i47++;
                                            i32 += i46;
                                        }
                                    }
                                    i40 = i53;
                                    while (i40 > 0) {
                                        i40--;
                                        this.l[i38] = this.k[i40];
                                        i33++;
                                        i38++;
                                    }
                                    i45 = i52;
                                    i27 = i49;
                                    i44 = i9;
                                    i48 = i51;
                                    i24 = i54;
                                }
                            }
                        }
                        i41 = i48;
                        i30 = i47;
                        i27 = i49;
                        i37 = i9;
                        i15 = 0;
                        i13 = 1;
                        i39 = i45;
                        i31 = i46;
                        break;
                    }
                    i46 = i26;
                    i32 = i28;
                    i27 = i49;
                    i47 = i27;
                    i48 = -1;
                }
                i41 = i48;
                i37 = i44;
                i39 = i45;
                i31 = i46;
                i30 = i47;
                i15 = 0;
                i13 = 1;
            }
            for (int i55 = i38; i55 < i23; i55++) {
                this.l[i55] = 0;
            }
            int i56 = t.f40728d;
            int i57 = this.u;
            int i58 = i56 / i57;
            int i59 = t.f40726b / i57;
            int i60 = t.f40727c / i57;
            int i61 = t.f40725a / i57;
            boolean z = this.n == 0;
            int i62 = 0;
            int i63 = 1;
            int i64 = 0;
            int i65 = 8;
            while (i64 < i58) {
                if (t.f40729e) {
                    if (i62 >= i58) {
                        i63++;
                        if (i63 == 2) {
                            i62 = 4;
                        } else if (i63 == 3) {
                            i62 = 2;
                            i65 = 4;
                        } else if (i63 == 4) {
                            i62 = 1;
                            i65 = 2;
                        }
                    }
                    i3 = i62 + i65;
                } else {
                    i3 = i62;
                    i62 = i64;
                }
                int i66 = i62 + i59;
                if (i66 < this.v) {
                    int i67 = this.w;
                    int i68 = i66 * i67;
                    int i69 = i68 + i61;
                    int i70 = i69 + i60;
                    int i71 = i68 + i67;
                    if (i71 < i70) {
                        i70 = i71;
                    }
                    int i72 = this.u;
                    int i73 = i64 * i72 * t.f40727c;
                    int i74 = ((i70 - i69) * i72) + i73;
                    int i75 = i69;
                    while (i75 < i70) {
                        int i76 = i58;
                        int i77 = i59;
                        if (this.u == 1) {
                            i7 = this.f40714a[this.l[i73] & 255];
                            i4 = i60;
                            i5 = i61;
                            i6 = i63;
                        } else {
                            int i78 = t.f40727c;
                            i4 = i60;
                            int i79 = i73;
                            int i80 = 0;
                            int i81 = 0;
                            int i82 = 0;
                            int i83 = 0;
                            int i84 = 0;
                            while (true) {
                                if (i79 >= this.u + i73) {
                                    i5 = i61;
                                    break;
                                }
                                byte[] bArr3 = this.l;
                                i5 = i61;
                                if (i79 >= bArr3.length || i79 >= i74) {
                                    break;
                                }
                                int i85 = this.f40714a[bArr3[i79] & 255];
                                if (i85 != 0) {
                                    i8 = i63;
                                    i83 += (i85 >> 24) & 255;
                                    i82 += (i85 >> 16) & 255;
                                    i81 += (i85 >> 8) & 255;
                                    i80 += i85 & 255;
                                    i84++;
                                } else {
                                    i8 = i63;
                                }
                                i79++;
                                i61 = i5;
                                i63 = i8;
                            }
                            i6 = i63;
                            int i86 = i78 + i73;
                            for (int i87 = i86; i87 < this.u + i86; i87++) {
                                byte[] bArr4 = this.l;
                                if (i87 >= bArr4.length || i87 >= i74) {
                                    break;
                                }
                                int i88 = this.f40714a[bArr4[i87] & 255];
                                if (i88 != 0) {
                                    i83 += (i88 >> 24) & 255;
                                    i82 += (i88 >> 16) & 255;
                                    i81 += (i88 >> 8) & 255;
                                    i80 += i88 & 255;
                                    i84++;
                                }
                            }
                            i7 = i84 == 0 ? 0 : ((i83 / i84) << 24) | ((i82 / i84) << 16) | ((i81 / i84) << 8) | (i80 / i84);
                        }
                        if (i7 != 0) {
                            iArr3[i75] = i7;
                        } else if (!this.x && z) {
                            this.x = true;
                        }
                        i73 += this.u;
                        i75++;
                        i58 = i76;
                        i59 = i77;
                        i60 = i4;
                        i61 = i5;
                        i63 = i6;
                    }
                }
                i64++;
                i62 = i3;
                i58 = i58;
                i59 = i59;
                i60 = i60;
                i61 = i61;
                i63 = i63;
            }
            if (this.s && ((i2 = t.f40731g) == 0 || i2 == 1)) {
                if (this.r == null) {
                    this.r = a();
                }
                Bitmap bitmap2 = this.r;
                int i89 = this.w;
                bitmap2.setPixels(iArr3, 0, i89, 0, 0, i89, this.v);
            }
            Bitmap a2 = a();
            int i90 = this.w;
            a2.setPixels(iArr3, 0, i90, 0, 0, i90, this.v);
            return a2;
        }
        return null;
    }

    public final int c() {
        try {
            d();
            byte[] bArr = this.f40718e;
            int i2 = this.f40720g;
            this.f40720g = i2 + 1;
            return bArr[i2] & 255;
        } catch (Exception unused) {
            this.t = 1;
            return 0;
        }
    }

    public final void d() {
        if (this.f40719f > this.f40720g) {
            return;
        }
        if (this.f40718e == null) {
            this.f40718e = this.q.a(16384);
        }
        this.f40720g = 0;
        int min = Math.min(this.f40716c.remaining(), 16384);
        this.f40719f = min;
        this.f40716c.get(this.f40718e, 0, min);
    }

    public synchronized int a(byte[] bArr) {
        if (this.f40721h == null) {
            this.f40721h = new V();
        }
        V a2 = this.f40721h.a(bArr);
        if (a2.f40747b != null) {
            if (!a2.a()) {
                String str = "";
                for (int i2 = 0; i2 < 6; i2++) {
                    str = str + ((char) a2.b());
                }
                if (str.startsWith("GIF")) {
                    a2.f40748c.f40740f = a2.f40747b.getShort();
                    a2.f40748c.f40741g = a2.f40747b.getShort();
                    int b2 = a2.b();
                    a2.f40748c.f40742h = (b2 & 128) != 0;
                    U u = a2.f40748c;
                    u.f40743i = 2 << (b2 & 7);
                    u.j = a2.b();
                    a2.f40748c.k = a2.b();
                    if (a2.f40748c.f40742h && !a2.a()) {
                        U u2 = a2.f40748c;
                        u2.f40735a = a2.a(u2.f40743i);
                        U u3 = a2.f40748c;
                        u3.l = u3.f40735a[u3.j];
                    }
                } else {
                    a2.f40748c.f40736b = 1;
                }
                if (!a2.a()) {
                    boolean z = false;
                    while (!z && !a2.a() && a2.f40748c.f40737c <= Integer.MAX_VALUE) {
                        int b3 = a2.b();
                        if (b3 == 33) {
                            int b4 = a2.b();
                            if (b4 != 1) {
                                if (b4 == 249) {
                                    a2.f40748c.f40738d = new T();
                                    a2.b();
                                    int b5 = a2.b();
                                    T t = a2.f40748c.f40738d;
                                    int i3 = (b5 & 28) >> 2;
                                    t.f40731g = i3;
                                    if (i3 == 0) {
                                        t.f40731g = 1;
                                    }
                                    a2.f40748c.f40738d.f40730f = (b5 & 1) != 0;
                                    short s = a2.f40747b.getShort();
                                    if (s < 2) {
                                        s = 10;
                                    }
                                    T t2 = a2.f40748c.f40738d;
                                    t2.f40733i = s * 10;
                                    t2.f40732h = a2.b();
                                    a2.b();
                                } else if (b4 != 254 && b4 == 255) {
                                    a2.c();
                                    String str2 = "";
                                    for (int i4 = 0; i4 < 11; i4++) {
                                        str2 = str2 + ((char) a2.f40746a[i4]);
                                    }
                                    if (str2.equals("NETSCAPE2.0")) {
                                        do {
                                            a2.c();
                                            byte[] bArr2 = a2.f40746a;
                                            if (bArr2[0] == 1) {
                                                U u4 = a2.f40748c;
                                                int i5 = ((bArr2[2] & 255) << 8) | (bArr2[1] & 255);
                                                u4.m = i5;
                                                if (i5 == 0) {
                                                    u4.m = -1;
                                                }
                                            }
                                            if (a2.f40749d > 0) {
                                            }
                                        } while (!a2.a());
                                    }
                                }
                            }
                            a2.d();
                        } else if (b3 == 44) {
                            U u5 = a2.f40748c;
                            if (u5.f40738d == null) {
                                u5.f40738d = new T();
                            }
                            a2.f40748c.f40738d.f40725a = a2.f40747b.getShort();
                            a2.f40748c.f40738d.f40726b = a2.f40747b.getShort();
                            a2.f40748c.f40738d.f40727c = a2.f40747b.getShort();
                            a2.f40748c.f40738d.f40728d = a2.f40747b.getShort();
                            int b6 = a2.b();
                            boolean z2 = (b6 & 128) != 0;
                            int pow = (int) Math.pow(2.0d, (b6 & 7) + 1);
                            a2.f40748c.f40738d.f40729e = (b6 & 64) != 0;
                            if (z2) {
                                a2.f40748c.f40738d.k = a2.a(pow);
                            } else {
                                a2.f40748c.f40738d.k = null;
                            }
                            a2.f40748c.f40738d.j = a2.f40747b.position();
                            a2.b();
                            a2.d();
                            if (!a2.a()) {
                                U u6 = a2.f40748c;
                                u6.f40737c++;
                                u6.f40739e.add(u6.f40738d);
                            }
                        } else if (b3 != 59) {
                            a2.f40748c.f40736b = 1;
                        } else {
                            z = true;
                        }
                    }
                    U u7 = a2.f40748c;
                    if (u7.f40737c < 0) {
                        u7.f40736b = 1;
                    }
                }
            }
            U u8 = a2.f40748c;
            this.p = u8;
            if (bArr != null) {
                a(u8, bArr);
            }
        } else {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        return this.t;
    }

    public synchronized void a(U u, ByteBuffer byteBuffer, int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i2);
        }
        int highestOneBit = Integer.highestOneBit(i2);
        this.t = 0;
        this.p = u;
        this.x = false;
        this.n = -1;
        this.o = 0;
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f40716c = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.f40716c.order(ByteOrder.LITTLE_ENDIAN);
        this.s = false;
        Iterator it = u.f40739e.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (((T) it.next()).f40731g == 3) {
                this.s = true;
                break;
            }
        }
        this.u = highestOneBit;
        int i3 = u.f40740f;
        this.w = i3 / highestOneBit;
        int i4 = u.f40741g;
        this.v = i4 / highestOneBit;
        this.l = this.q.a(i3 * i4);
        this.m = this.q.b(this.w * this.v);
    }

    public boolean a(int i2) {
        if (i2 < -1 || i2 >= this.p.f40737c) {
            return false;
        }
        this.n = i2;
        return true;
    }
}
