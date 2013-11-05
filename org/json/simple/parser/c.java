package org.json.simple.parser;

import com.baidu.video.download.JNITaskBuffer;
import com.baidu.zeus.bouncycastle.DERTags;
import java.io.Reader;
/* loaded from: classes.dex */
class c {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f2839a = {0, 0, 1, 1};
    private static final char[] b = a("\t\u0000\u0001\u0007\u0001\u0007\u0002\u0000\u0001\u0007\u0012\u0000\u0001\u0007\u0001\u0000\u0001\t\b\u0000\u0001\u0006\u0001\u0019\u0001\u0002\u0001\u0004\u0001\n\n\u0003\u0001\u001a\u0006\u0000\u0004\u0001\u0001\u0005\u0001\u0001\u0014\u0000\u0001\u0017\u0001\b\u0001\u0018\u0003\u0000\u0001\u0012\u0001\u000b\u0002\u0001\u0001\u0011\u0001\f\u0005\u0000\u0001\u0013\u0001\u0000\u0001\r\u0003\u0000\u0001\u000e\u0001\u0014\u0001\u000f\u0001\u0010\u0005\u0000\u0001\u0015\u0001\u0000\u0001\u0016ﾂ\u0000");
    private static final int[] c = d();
    private static final int[] d = e();
    private static final int[] e = {2, 2, 3, 4, 2, 2, 2, 5, 2, 6, 2, 2, 7, 8, 2, 9, 2, 2, 2, 2, 2, 10, 11, 12, 13, 14, 15, 16, 16, 16, 16, 16, 16, 16, 16, 17, 18, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 4, 19, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 5, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 21, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 22, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 23, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 16, 16, 16, 16, 16, 16, 16, 16, -1, -1, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, -1, -1, -1, -1, -1, -1, -1, -1, 24, 25, 26, 27, 28, 29, 30, 31, 32, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 33, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 34, 35, -1, -1, 34, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 37, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 38, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 39, -1, 39, -1, 39, -1, -1, -1, -1, -1, 39, 39, -1, -1, -1, -1, 39, 39, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 33, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 35, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 38, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 40, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 41, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 42, -1, 42, -1, 42, -1, -1, -1, -1, -1, 42, 42, -1, -1, -1, -1, 42, 42, -1, -1, -1, -1, -1, -1, -1, -1, -1, 43, -1, 43, -1, 43, -1, -1, -1, -1, -1, 43, 43, -1, -1, -1, -1, 43, 43, -1, -1, -1, -1, -1, -1, -1, -1, -1, 44, -1, 44, -1, 44, -1, -1, -1, -1, -1, 44, 44, -1, -1, -1, -1, 44, 44, -1, -1, -1, -1, -1, -1, -1, -1};
    private static final String[] f = {"Unkown internal scanner error", "Error: could not match input", "Error: pushback value was too large"};
    private static final int[] g = f();
    private Reader h;
    private int i;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private boolean t;
    private int j = 0;
    private char[] k = new char[JNITaskBuffer.BufferSize];
    private boolean s = true;
    private StringBuffer u = new StringBuffer();

    private static int[] d() {
        int[] iArr = new int[45];
        a("\u0002\u0000\u0002\u0001\u0001\u0002\u0001\u0003\u0001\u0004\u0003\u0001\u0001\u0005\u0001\u0006\u0001\u0007\u0001\b\u0001\t\u0001\n\u0001\u000b\u0001\f\u0001\r\u0005\u0000\u0001\f\u0001\u000e\u0001\u000f\u0001\u0010\u0001\u0011\u0001\u0012\u0001\u0013\u0001\u0014\u0001\u0000\u0001\u0015\u0001\u0000\u0001\u0015\u0004\u0000\u0001\u0016\u0001\u0017\u0002\u0000\u0001\u0018", 0, iArr);
        return iArr;
    }

    private static int a(String str, int i, int[] iArr) {
        int i2;
        int i3 = 0;
        int length = str.length();
        int i4 = i;
        while (i3 < length) {
            int i5 = i3 + 1;
            int charAt = str.charAt(i3);
            int i6 = i5 + 1;
            char charAt2 = str.charAt(i5);
            while (true) {
                i2 = i4 + 1;
                iArr[i4] = charAt2;
                charAt--;
                if (charAt <= 0) {
                    break;
                }
                i4 = i2;
            }
            i4 = i2;
            i3 = i6;
        }
        return i4;
    }

    private static int[] e() {
        int[] iArr = new int[45];
        b("\u0000\u0000\u0000\u001b\u00006\u0000Q\u0000l\u0000\u0087\u00006\u0000¢\u0000½\u0000Ø\u00006\u00006\u00006\u00006\u00006\u00006\u0000ó\u0000Ď\u00006\u0000ĩ\u0000ń\u0000ş\u0000ź\u0000ƕ\u00006\u00006\u00006\u00006\u00006\u00006\u00006\u00006\u0000ư\u0000ǋ\u0000Ǧ\u0000Ǧ\u0000ȁ\u0000Ȝ\u0000ȷ\u0000ɒ\u00006\u00006\u0000ɭ\u0000ʈ\u00006", 0, iArr);
        return iArr;
    }

    private static int b(String str, int i, int[] iArr) {
        int i2 = 0;
        int length = str.length();
        while (i2 < length) {
            int i3 = i2 + 1;
            iArr[i] = str.charAt(i3) | (str.charAt(i2) << 16);
            i++;
            i2 = i3 + 1;
        }
        return i;
    }

    private static int[] f() {
        int[] iArr = new int[45];
        c("\u0002\u0000\u0001\t\u0003\u0001\u0001\t\u0003\u0001\u0006\t\u0002\u0001\u0001\t\u0005\u0000\b\t\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0004\u0000\u0002\t\u0002\u0000\u0001\t", 0, iArr);
        return iArr;
    }

    private static int c(String str, int i, int[] iArr) {
        int i2;
        int i3 = 0;
        int length = str.length();
        int i4 = i;
        while (i3 < length) {
            int i5 = i3 + 1;
            int charAt = str.charAt(i3);
            int i6 = i5 + 1;
            char charAt2 = str.charAt(i5);
            while (true) {
                i2 = i4 + 1;
                iArr[i4] = charAt2;
                charAt--;
                if (charAt <= 0) {
                    break;
                }
                i4 = i2;
            }
            i4 = i2;
            i3 = i6;
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Reader reader) {
        this.h = reader;
    }

    private static char[] a(String str) {
        int i;
        int i2 = 0;
        char[] cArr = new char[65536];
        int i3 = 0;
        while (i3 < 90) {
            int i4 = i3 + 1;
            int charAt = str.charAt(i3);
            int i5 = i4 + 1;
            char charAt2 = str.charAt(i4);
            while (true) {
                i = i2 + 1;
                cArr[i2] = charAt2;
                charAt--;
                if (charAt <= 0) {
                    break;
                }
                i2 = i;
            }
            i2 = i;
            i3 = i5;
        }
        return cArr;
    }

    private boolean g() {
        int read;
        if (this.n > 0) {
            System.arraycopy(this.k, this.n, this.k, 0, this.o - this.n);
            this.o -= this.n;
            this.m -= this.n;
            this.l -= this.n;
            this.n = 0;
        }
        if (this.m >= this.k.length) {
            char[] cArr = new char[this.m * 2];
            System.arraycopy(this.k, 0, cArr, 0, this.k.length);
            this.k = cArr;
        }
        int read2 = this.h.read(this.k, this.o, this.k.length - this.o);
        if (read2 > 0) {
            this.o += read2;
            return false;
        }
        if (read2 == 0 && (read = this.h.read()) != -1) {
            char[] cArr2 = this.k;
            int i = this.o;
            this.o = i + 1;
            cArr2[i] = (char) read;
            return false;
        }
        return true;
    }

    public final void a(Reader reader) {
        this.h = reader;
        this.s = true;
        this.t = false;
        this.n = 0;
        this.o = 0;
        this.l = 0;
        this.m = 0;
        this.r = 0;
        this.q = 0;
        this.p = 0;
        this.j = 0;
    }

    public final void a(int i) {
        this.j = i;
    }

    public final String b() {
        return new String(this.k, this.n, this.l - this.n);
    }

    public final char b(int i) {
        return this.k[this.n + i];
    }

    private void c(int i) {
        String str;
        try {
            str = f[i];
        } catch (ArrayIndexOutOfBoundsException e2) {
            str = f[0];
        }
        throw new Error(str);
    }

    public d c() {
        char c2;
        int i;
        int i2;
        int i3 = this.o;
        char[] cArr = this.k;
        char[] cArr2 = b;
        int[] iArr = e;
        int[] iArr2 = d;
        int[] iArr3 = g;
        while (true) {
            int i4 = this.l;
            this.q += i4 - this.n;
            int i5 = -1;
            this.n = i4;
            this.m = i4;
            this.i = f2839a[this.j];
            int i6 = i4;
            while (true) {
                if (i6 < i3) {
                    i = i6 + 1;
                    c2 = cArr[i6];
                } else if (this.t) {
                    c2 = 65535;
                } else {
                    this.m = i6;
                    this.l = i4;
                    boolean g2 = g();
                    int i7 = this.m;
                    i4 = this.l;
                    cArr = this.k;
                    i3 = this.o;
                    if (g2) {
                        c2 = 65535;
                    } else {
                        i = i7 + 1;
                        c2 = cArr[i7];
                    }
                }
                int i8 = iArr[iArr2[this.i] + cArr2[c2]];
                if (i8 != -1) {
                    this.i = i8;
                    int i9 = iArr3[this.i];
                    if ((i9 & 1) == 1) {
                        int i10 = this.i;
                        if ((i9 & 8) == 8) {
                            i5 = i10;
                            i4 = i;
                        } else {
                            i2 = i10;
                            i4 = i;
                        }
                    } else {
                        i2 = i5;
                    }
                    i5 = i2;
                    i6 = i;
                }
            }
            this.l = i4;
            if (i5 >= 0) {
                i5 = c[i5];
            }
            switch (i5) {
                case 1:
                    throw new ParseException(this.q, 0, new Character(b(0)));
                case 2:
                    return new d(0, Long.valueOf(b()));
                case 3:
                case DERTags.GRAPHIC_STRING /* 25 */:
                case DERTags.VISIBLE_STRING /* 26 */:
                case DERTags.GENERAL_STRING /* 27 */:
                case DERTags.UNIVERSAL_STRING /* 28 */:
                case 29:
                case DERTags.BMP_STRING /* 30 */:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                    break;
                case 4:
                    this.u.delete(0, this.u.length());
                    a(2);
                    break;
                case 5:
                    return new d(1, null);
                case 6:
                    return new d(2, null);
                case 7:
                    return new d(3, null);
                case 8:
                    return new d(4, null);
                case 9:
                    return new d(5, null);
                case 10:
                    return new d(6, null);
                case 11:
                    this.u.append(b());
                    break;
                case 12:
                    this.u.append('\\');
                    break;
                case 13:
                    a(0);
                    return new d(0, this.u.toString());
                case 14:
                    this.u.append('\"');
                    break;
                case 15:
                    this.u.append('/');
                    break;
                case 16:
                    this.u.append('\b');
                    break;
                case 17:
                    this.u.append('\f');
                    break;
                case 18:
                    this.u.append('\n');
                    break;
                case 19:
                    this.u.append('\r');
                    break;
                case 20:
                    this.u.append('\t');
                    break;
                case 21:
                    return new d(0, Double.valueOf(b()));
                case 22:
                    return new d(0, null);
                case DERTags.UTC_TIME /* 23 */:
                    return new d(0, Boolean.valueOf(b()));
                case DERTags.GENERALIZED_TIME /* 24 */:
                    try {
                        this.u.append((char) Integer.parseInt(b().substring(2), 16));
                        break;
                    } catch (Exception e2) {
                        throw new ParseException(this.q, 2, e2);
                    }
                default:
                    if (c2 == 65535 && this.n == this.m) {
                        this.t = true;
                        return null;
                    }
                    c(1);
                    break;
            }
        }
    }
}
