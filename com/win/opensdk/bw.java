package com.win.opensdk;

import android.graphics.Bitmap;
import android.os.Build;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
/* loaded from: classes14.dex */
public class bw {

    /* renamed from: a  reason: collision with root package name */
    public int[] f8134a;
    public int[] aov;
    public final int[] b;
    public ByteBuffer c;
    public byte[] d;
    public byte[] e;
    public int f;
    public int g;
    public byte[] j;
    public byte[] k;
    public byte[] l;
    public int n;
    public int o;
    public cf qlk;
    public short[] qll;
    public cc qlm;
    public cz qln;
    public Bitmap r;
    public boolean s;
    public int t;
    public int u;
    public int v;
    public int w;
    public boolean x;

    public bw() {
        cz czVar = new cz();
        this.b = new int[256];
        this.f = 0;
        this.g = 0;
        this.qln = czVar;
        this.qlm = new cc();
    }

    public final Bitmap a() {
        Bitmap a2 = this.qln.a(this.w, this.v, this.x ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        if (Build.VERSION.SDK_INT >= 12) {
            a2.setHasAlpha(true);
        }
        return a2;
    }

    public synchronized void a(cc ccVar, ByteBuffer byteBuffer) {
        a(ccVar, byteBuffer, 1);
    }

    public synchronized void a(cc ccVar, byte[] bArr) {
        a(ccVar, ByteBuffer.wrap(bArr));
    }

    public final void a(int[] iArr, bz bzVar, int i) {
        int i2 = bzVar.d;
        int i3 = this.u;
        int i4 = i2 / i3;
        int i5 = bzVar.b / i3;
        int i6 = bzVar.c / i3;
        int i7 = bzVar.f8137a / i3;
        int i8 = this.w;
        int i9 = i7 + (i5 * i8);
        int i10 = (i4 * i8) + i9;
        while (i9 < i10) {
            int i11 = i9 + i6;
            for (int i12 = i9; i12 < i11; i12++) {
                iArr[i12] = i;
            }
            i9 += this.w;
        }
    }

    public final int c() {
        try {
            d();
            byte[] bArr = this.e;
            int i = this.g;
            this.g = i + 1;
            return bArr[i] & 255;
        } catch (Exception e) {
            this.t = 1;
            return 0;
        }
    }

    public final void d() {
        if (this.f > this.g) {
            return;
        }
        if (this.e == null) {
            this.e = this.qln.a(16384);
        }
        this.g = 0;
        this.f = Math.min(this.c.remaining(), 16384);
        this.c.get(this.e, 0, this.f);
    }

    public synchronized int a(byte[] bArr) {
        if (this.qlk == null) {
            this.qlk = new cf();
        }
        cf at = this.qlk.at(bArr);
        if (at.b != null) {
            if (!at.a()) {
                String str = "";
                for (int i = 0; i < 6; i++) {
                    str = str + ((char) at.b());
                }
                if (str.startsWith("GIF")) {
                    at.qlx.f = at.b.getShort();
                    at.qlx.g = at.b.getShort();
                    int b = at.b();
                    at.qlx.h = (b & 128) != 0;
                    cc ccVar = at.qlx;
                    ccVar.i = 2 << (b & 7);
                    ccVar.j = at.b();
                    at.qlx.k = at.b();
                    if (at.qlx.h && !at.a()) {
                        cc ccVar2 = at.qlx;
                        ccVar2.f8140a = at.Rr(ccVar2.i);
                        cc ccVar3 = at.qlx;
                        ccVar3.l = ccVar3.f8140a[ccVar3.j];
                    }
                } else {
                    at.qlx.b = 1;
                }
                if (!at.a()) {
                    boolean z = false;
                    while (!z && !at.a() && at.qlx.c <= Integer.MAX_VALUE) {
                        int b2 = at.b();
                        if (b2 == 33) {
                            int b3 = at.b();
                            if (b3 != 1) {
                                if (b3 == 249) {
                                    at.qlx.qlu = new bz();
                                    at.b();
                                    int b4 = at.b();
                                    bz bzVar = at.qlx.qlu;
                                    bzVar.g = (b4 & 28) >> 2;
                                    if (bzVar.g == 0) {
                                        bzVar.g = 1;
                                    }
                                    at.qlx.qlu.f = (b4 & 1) != 0;
                                    short s = at.b.getShort();
                                    if (s < 2) {
                                        s = 10;
                                    }
                                    bz bzVar2 = at.qlx.qlu;
                                    bzVar2.i = s * 10;
                                    bzVar2.h = at.b();
                                    at.b();
                                } else if (b3 != 254 && b3 == 255) {
                                    at.c();
                                    String str2 = "";
                                    for (int i2 = 0; i2 < 11; i2++) {
                                        str2 = str2 + ((char) at.f8142a[i2]);
                                    }
                                    if (str2.equals("NETSCAPE2.0")) {
                                        do {
                                            at.c();
                                            byte[] bArr2 = at.f8142a;
                                            if (bArr2[0] == 1) {
                                                cc ccVar4 = at.qlx;
                                                ccVar4.m = ((bArr2[2] & 255) << 8) | (bArr2[1] & 255);
                                                if (ccVar4.m == 0) {
                                                    ccVar4.m = -1;
                                                }
                                            }
                                            if (at.d > 0) {
                                            }
                                        } while (!at.a());
                                    }
                                }
                            }
                            at.d();
                        } else if (b2 == 44) {
                            cc ccVar5 = at.qlx;
                            if (ccVar5.qlu == null) {
                                ccVar5.qlu = new bz();
                            }
                            at.qlx.qlu.f8137a = at.b.getShort();
                            at.qlx.qlu.b = at.b.getShort();
                            at.qlx.qlu.c = at.b.getShort();
                            at.qlx.qlu.d = at.b.getShort();
                            int b5 = at.b();
                            boolean z2 = (b5 & 128) != 0;
                            int pow = (int) Math.pow(2.0d, (b5 & 7) + 1);
                            at.qlx.qlu.e = (b5 & 64) != 0;
                            if (z2) {
                                at.qlx.qlu.k = at.Rr(pow);
                            } else {
                                at.qlx.qlu.k = null;
                            }
                            at.qlx.qlu.j = at.b.position();
                            at.b();
                            at.d();
                            if (!at.a()) {
                                cc ccVar6 = at.qlx;
                                ccVar6.c++;
                                ccVar6.e.add(ccVar6.qlu);
                            }
                        } else if (b2 != 59) {
                            at.qlx.b = 1;
                        } else {
                            z = true;
                        }
                    }
                    cc ccVar7 = at.qlx;
                    if (ccVar7.c < 0) {
                        ccVar7.b = 1;
                    }
                }
            }
            this.qlm = at.qlx;
            if (bArr != null) {
                a(this.qlm, bArr);
            }
        } else {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        return this.t;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:240:0x02d6 */
    /* JADX DEBUG: Multi-variable search result rejected for r13v15, resolved type: short */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:133:0x032e A[Catch: all -> 0x0149, LOOP:4: B:132:0x032c->B:133:0x032e, LOOP_END, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x0014, B:17:0x0022, B:19:0x0041, B:20:0x004e, B:22:0x0052, B:24:0x005c, B:26:0x006a, B:28:0x006e, B:29:0x0089, B:31:0x008f, B:33:0x0095, B:37:0x009c, B:39:0x00a1, B:41:0x00ab, B:44:0x00b2, B:63:0x013c, B:65:0x0142, B:72:0x014f, B:74:0x0155, B:75:0x015d, B:45:0x00b7, B:47:0x00d6, B:50:0x00e9, B:52:0x00ef, B:53:0x00f7, B:55:0x00fd, B:56:0x0105, B:58:0x010b, B:59:0x0113, B:62:0x012b, B:80:0x0197, B:82:0x019d, B:84:0x01a3, B:85:0x01b3, B:87:0x01c1, B:88:0x01e1, B:96:0x01fa, B:98:0x020a, B:99:0x025a, B:91:0x01e8, B:105:0x0269, B:108:0x0289, B:112:0x029e, B:118:0x02b6, B:120:0x02ca, B:123:0x02da, B:125:0x02f7, B:127:0x0314, B:131:0x0327, B:133:0x032e, B:103:0x0262, B:94:0x01f0, B:135:0x034b, B:141:0x0372, B:145:0x037a, B:151:0x0385, B:152:0x038e, B:154:0x0396, B:157:0x03a5, B:160:0x03b9, B:162:0x03c0, B:164:0x03d0, B:165:0x03d2, B:197:0x04c8, B:200:0x04d0, B:172:0x03f1, B:173:0x03f9, B:175:0x0405, B:179:0x0418, B:181:0x042a, B:182:0x0452, B:183:0x0455, B:184:0x0457, B:186:0x0463, B:190:0x0476, B:192:0x0488, B:193:0x04b0, B:196:0x04b8, B:201:0x04d7, B:202:0x04e1, B:204:0x04e7, B:208:0x04ee, B:210:0x04f4, B:211:0x04fc, B:212:0x050f, B:49:0x00db, B:25:0x0063, B:7:0x000f), top: B:220:0x0001, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized Bitmap b() {
        Bitmap bitmap;
        int i;
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
        if (this.qlm.c <= 0 || this.n < 0) {
            this.t = 1;
        }
        int i13 = this.t;
        if (i13 != 1 && i13 != 2) {
            this.t = 0;
            bz bzVar = (bz) this.qlm.e.get(this.n);
            int i14 = this.n - 1;
            bz bzVar2 = i14 >= 0 ? (bz) this.qlm.e.get(i14) : null;
            int[] iArr = bzVar.k;
            if (iArr == null) {
                iArr = this.qlm.f8140a;
            }
            this.f8134a = iArr;
            int[] iArr2 = this.f8134a;
            if (iArr2 == null) {
                this.t = 1;
                bitmap = null;
            } else {
                if (bzVar.f) {
                    System.arraycopy(iArr2, 0, this.b, 0, iArr2.length);
                    this.f8134a = this.b;
                    this.f8134a[bzVar.h] = 0;
                }
                int[] iArr3 = this.aov;
                if (bzVar2 == null) {
                    Arrays.fill(iArr3, 0);
                }
                if (bzVar2 != null && (i12 = bzVar2.g) > 0) {
                    if (i12 == 2) {
                        int i15 = 0;
                        if (!bzVar.f) {
                            cc ccVar = this.qlm;
                            i15 = ccVar.l;
                            if (bzVar.k != null && ccVar.j == bzVar.h) {
                                i15 = 0;
                            }
                        } else if (this.n == 0) {
                            this.x = true;
                        }
                        a(iArr3, bzVar2, i15);
                    } else if (i12 == 3) {
                        Bitmap bitmap2 = this.r;
                        if (bitmap2 == null) {
                            a(iArr3, bzVar2, 0);
                        } else {
                            int i16 = bzVar2.d;
                            int i17 = this.u;
                            int i18 = i16 / i17;
                            int i19 = bzVar2.b / i17;
                            int i20 = bzVar2.c / i17;
                            int i21 = bzVar2.f8137a / i17;
                            int i22 = this.w;
                            bitmap2.getPixels(iArr3, (i19 * i22) + i21, i22, i21, i19, i20, i18);
                        }
                    }
                }
                this.f = 0;
                this.g = 0;
                this.c.position(bzVar.j);
                int i23 = bzVar.c * bzVar.d;
                byte[] bArr = this.l;
                if (bArr == null || bArr.length < i23) {
                    this.l = this.qln.a(i23);
                }
                if (this.qll == null) {
                    this.qll = new short[4096];
                }
                if (this.j == null) {
                    this.j = new byte[4096];
                }
                if (this.k == null) {
                    this.k = new byte[4097];
                }
                int c = c();
                int i24 = 1 << c;
                int i25 = i24 + 1;
                int i26 = i24 + 2;
                int i27 = c + 1;
                int i28 = (1 << i27) - 1;
                for (int i29 = 0; i29 < i24; i29++) {
                    this.qll[i29] = 0;
                    this.j[i29] = (byte) i29;
                }
                int i30 = 0;
                int i31 = -1;
                int i32 = i27;
                int i33 = i28;
                int i34 = i26;
                int i35 = 0;
                int i36 = 0;
                int i37 = 0;
                int i38 = 0;
                int i39 = 0;
                int i40 = 0;
                int i41 = 0;
                while (true) {
                    if (i30 >= i23) {
                        break;
                    }
                    if (i40 == 0) {
                        i8 = c();
                        if (i8 > 0) {
                            try {
                                if (this.d == null) {
                                    this.d = this.qln.a(255);
                                }
                                int i42 = this.f - this.g;
                                if (i42 >= i8) {
                                    System.arraycopy(this.e, this.g, this.d, 0, i8);
                                    i11 = this.g + i8;
                                } else if (this.c.remaining() + i42 >= i8) {
                                    System.arraycopy(this.e, this.g, this.d, 0, i42);
                                    this.g = this.f;
                                    d();
                                    int i43 = i8 - i42;
                                    System.arraycopy(this.e, 0, this.d, i42, i43);
                                    i11 = this.g + i43;
                                } else {
                                    this.t = 1;
                                }
                                this.g = i11;
                            } catch (Exception e) {
                                this.t = 1;
                            }
                        }
                        if (i8 <= 0) {
                            this.t = 3;
                            break;
                        }
                        i7 = 0;
                    } else {
                        i7 = i38;
                        i8 = i40;
                    }
                    i39 += (this.d[i7] & 255) << i37;
                    int i44 = i7 + 1;
                    i40 = i8 - 1;
                    int i45 = i31;
                    i37 += 8;
                    int i46 = i41;
                    while (true) {
                        if (i37 < i32) {
                            i31 = i45;
                            i38 = i44;
                            i41 = i46;
                            break;
                        }
                        int i47 = i39 & i33;
                        i39 >>= i32;
                        i37 -= i32;
                        if (i47 == i24) {
                            i45 = -1;
                            i32 = i27;
                            i33 = i28;
                            i34 = i26;
                        } else if (i47 > i34) {
                            this.t = 3;
                            i31 = i45;
                            i38 = i44;
                            i41 = i46;
                            break;
                        } else if (i47 == i25) {
                            i31 = i45;
                            i38 = i44;
                            i41 = i46;
                            break;
                        } else if (i45 == -1) {
                            this.k[i35] = this.j[i47];
                            i45 = i47;
                            i35++;
                            i36 = i47;
                        } else {
                            if (i47 >= i34) {
                                i9 = i35 + 1;
                                this.k[i35] = (byte) i36;
                                s = i45;
                            } else {
                                i9 = i35;
                                s = i47;
                            }
                            while (s >= i24) {
                                this.k[i9] = this.j[s];
                                s = this.qll[s];
                                i9++;
                            }
                            byte[] bArr2 = this.j;
                            int i48 = bArr2[s] & 255;
                            i35 = i9 + 1;
                            byte b = (byte) i48;
                            this.k[i9] = b;
                            if (i34 < 4096) {
                                this.qll[i34] = (short) i45;
                                bArr2[i34] = b;
                                i34++;
                                if ((i34 & i33) == 0 && i34 < 4096) {
                                    i10 = i32 + 1;
                                    i33 += i34;
                                    while (i35 > 0) {
                                        int i49 = i35 - 1;
                                        this.l[i46] = this.k[i49];
                                        i30++;
                                        i35 = i49;
                                        i46++;
                                    }
                                    i45 = i47;
                                    i32 = i10;
                                    i36 = i48;
                                }
                            }
                            i10 = i32;
                            while (i35 > 0) {
                            }
                            i45 = i47;
                            i32 = i10;
                            i36 = i48;
                        }
                    }
                }
                while (i41 < i23) {
                    this.l[i41] = 0;
                    i41++;
                }
                int i50 = bzVar.d;
                int i51 = this.u;
                int i52 = i50 / i51;
                int i53 = bzVar.b / i51;
                int i54 = bzVar.c / i51;
                int i55 = bzVar.f8137a / i51;
                int i56 = 1;
                int i57 = 8;
                int i58 = 0;
                boolean z = this.n == 0;
                int i59 = 0;
                while (i59 < i52) {
                    if (bzVar.e) {
                        if (i58 >= i52) {
                            i56++;
                            if (i56 == 2) {
                                i58 = 4;
                            } else if (i56 == 3) {
                                i58 = 2;
                                i57 = 4;
                            } else if (i56 == 4) {
                                i58 = 1;
                                i57 = 2;
                            }
                        }
                        i2 = i58 + i57;
                        i3 = i58;
                        i4 = i57;
                        i5 = i56;
                    } else {
                        i2 = i58;
                        i3 = i59;
                        i4 = i57;
                        i5 = i56;
                    }
                    int i60 = i3 + i53;
                    if (i60 < this.v) {
                        int i61 = this.w;
                        int i62 = i60 * i61;
                        int i63 = i62 + i55;
                        int i64 = i63 + i54;
                        int i65 = i61 + i62;
                        int i66 = i65 < i64 ? i65 : i64;
                        int i67 = this.u;
                        int i68 = i59 * i67 * bzVar.c;
                        int i69 = (i67 * (i66 - i63)) + i68;
                        for (int i70 = i63; i70 < i66; i70++) {
                            if (this.u == 1) {
                                i6 = this.f8134a[this.l[i68] & 255];
                            } else {
                                int i71 = bzVar.c;
                                int i72 = 0;
                                int i73 = 0;
                                int i74 = 0;
                                int i75 = 0;
                                int i76 = 0;
                                for (int i77 = i68; i77 < this.u + i68; i77++) {
                                    byte[] bArr3 = this.l;
                                    if (i77 >= bArr3.length || i77 >= i69) {
                                        break;
                                    }
                                    int i78 = this.f8134a[bArr3[i77] & 255];
                                    if (i78 != 0) {
                                        i72 += (i78 >> 24) & 255;
                                        i73 += (i78 >> 16) & 255;
                                        i74 += (i78 >> 8) & 255;
                                        i75 += i78 & 255;
                                        i76++;
                                    }
                                }
                                int i79 = i71 + i68;
                                for (int i80 = i79; i80 < this.u + i79; i80++) {
                                    byte[] bArr4 = this.l;
                                    if (i80 >= bArr4.length || i80 >= i69) {
                                        break;
                                    }
                                    int i81 = this.f8134a[bArr4[i80] & 255];
                                    if (i81 != 0) {
                                        i72 += (i81 >> 24) & 255;
                                        i73 += (i81 >> 16) & 255;
                                        i74 += (i81 >> 8) & 255;
                                        i75 += i81 & 255;
                                        i76++;
                                    }
                                }
                                i6 = i76 == 0 ? 0 : (i75 / i76) | ((i72 / i76) << 24) | ((i73 / i76) << 16) | ((i74 / i76) << 8);
                            }
                            if (i6 != 0) {
                                iArr3[i70] = i6;
                            } else if (!this.x && z) {
                                this.x = true;
                            }
                            i68 += this.u;
                        }
                    }
                    i59++;
                    i58 = i2;
                    i57 = i4;
                    i56 = i5;
                }
                if (this.s && ((i = bzVar.g) == 0 || i == 1)) {
                    if (this.r == null) {
                        this.r = a();
                    }
                    Bitmap bitmap3 = this.r;
                    int i82 = this.w;
                    bitmap3.setPixels(iArr3, 0, i82, 0, 0, i82, this.v);
                }
                bitmap = a();
                int i83 = this.w;
                bitmap.setPixels(iArr3, 0, i83, 0, 0, i83, this.v);
            }
        } else {
            bitmap = null;
        }
        return bitmap;
    }

    public synchronized void a(cc ccVar, ByteBuffer byteBuffer, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
        }
        int highestOneBit = Integer.highestOneBit(i);
        this.t = 0;
        this.qlm = ccVar;
        this.x = false;
        this.n = -1;
        this.o = 0;
        this.c = byteBuffer.asReadOnlyBuffer();
        this.c.position(0);
        this.c.order(ByteOrder.LITTLE_ENDIAN);
        this.s = false;
        Iterator it = ccVar.e.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (((bz) it.next()).g == 3) {
                this.s = true;
                break;
            }
        }
        this.u = highestOneBit;
        int i2 = ccVar.f;
        this.w = i2 / highestOneBit;
        int i3 = ccVar.g;
        this.v = i3 / highestOneBit;
        this.l = this.qln.a(i2 * i3);
        this.aov = this.qln.b(this.w * this.v);
    }

    public boolean a(int i) {
        if (i < -1 || i >= this.qlm.c) {
            return false;
        }
        this.n = i;
        return true;
    }
}
