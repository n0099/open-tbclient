package com.dd.plist;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import org.apache.commons.base.CharEncoding;
import org.apache.http.protocol.HTTP;
/* loaded from: classes4.dex */
public class c {
    private byte[] bytes;
    private int lCm;
    private int lCn;
    private int lCo;
    private int[] lCp;

    protected c() {
    }

    public static i Z(byte[] bArr) throws PropertyListFormatException, UnsupportedEncodingException {
        return new c().aa(bArr);
    }

    private i aa(byte[] bArr) throws PropertyListFormatException, UnsupportedEncodingException {
        this.bytes = bArr;
        String str = new String(i(this.bytes, 0, 8));
        if (!str.startsWith("bplist")) {
            throw new IllegalArgumentException("The given data is no binary property list. Wrong magic bytes: " + str);
        }
        this.lCm = str.charAt(6) - '0';
        this.lCn = str.charAt(7) - '0';
        if (this.lCm > 0) {
            throw new IllegalArgumentException("Unsupported binary property list format: v" + this.lCm + "." + this.lCn + ". Version 1.0 and later are not yet supported.");
        }
        byte[] i = i(this.bytes, this.bytes.length - 32, this.bytes.length);
        int m = (int) m(i, 6, 7);
        this.lCo = (int) m(i, 7, 8);
        int m2 = (int) m(i, 8, 16);
        int m3 = (int) m(i, 16, 24);
        int m4 = (int) m(i, 24, 32);
        this.lCp = new int[m2];
        for (int i2 = 0; i2 < m2; i2++) {
            this.lCp[i2] = (int) ab(i(this.bytes, (i2 * m) + m4, ((i2 + 1) * m) + m4));
        }
        return Hb(m3);
    }

    private i Hb(int i) throws PropertyListFormatException, UnsupportedEncodingException {
        int i2 = 0;
        int i3 = this.lCp[i];
        byte b = this.bytes[i3];
        int i4 = (b & 240) >> 4;
        int i5 = b & 15;
        switch (i4) {
            case 0:
                switch (i5) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    default:
                        return null;
                    case 8:
                        return new h(false);
                    case 9:
                        return new h(true);
                }
            case 1:
                return new h(i(this.bytes, i3 + 1, i3 + 1 + ((int) Math.pow(2.0d, i5))), 0);
            case 2:
                return new h(i(this.bytes, i3 + 1, ((int) Math.pow(2.0d, i5)) + i3 + 1), 1);
            case 3:
                if (i5 != 3) {
                    throw new PropertyListFormatException("The given binary property list contains a date object of an unknown type (" + i5 + ")");
                }
                return new f(i(this.bytes, i3 + 1, i3 + 9));
            case 4:
                int[] dr = dr(i5, i3);
                int i6 = dr[0];
                int i7 = dr[1];
                return new e(i(this.bytes, i3 + i7, i6 + i3 + i7));
            case 5:
                int[] dr2 = dr(i5, i3);
                int i8 = dr2[0];
                int i9 = dr2[1];
                return new k(i(this.bytes, i3 + i9, i8 + i3 + i9), HTTP.ASCII);
            case 6:
                int[] dr3 = dr(i5, i3);
                int i10 = dr3[0];
                int i11 = dr3[1];
                return new k(i(this.bytes, i3 + i11, (i10 * 2) + i3 + i11), CharEncoding.UTF_16BE);
            case 7:
                int[] dr4 = dr(i5, i3);
                int i12 = dr4[1];
                return new k(i(this.bytes, i3 + i12, l(this.bytes, i3 + i12, dr4[0]) + i3 + i12), "UTF-8");
            case 8:
                return new m(String.valueOf(i), i(this.bytes, i3 + 1, i5 + 1 + i3 + 1));
            case 9:
            default:
                System.err.println("WARNING: The given binary property list contains an object of unknown type (" + i4 + ")");
                return null;
            case 10:
                int[] dr5 = dr(i5, i3);
                int i13 = dr5[0];
                int i14 = dr5[1];
                d dVar = new d(i13);
                while (i2 < i13) {
                    dVar.j(i2, Hb((int) ab(i(this.bytes, i3 + i14 + (this.lCo * i2), i3 + i14 + ((i2 + 1) * this.lCo)))));
                    i2++;
                }
                return dVar;
            case 11:
                int[] dr6 = dr(i5, i3);
                int i15 = dr6[0];
                int i16 = dr6[1];
                j jVar = new j(true);
                while (i2 < i15) {
                    jVar.a(Hb((int) ab(i(this.bytes, i3 + i16 + (this.lCo * i2), i3 + i16 + ((i2 + 1) * this.lCo)))));
                    i2++;
                }
                return jVar;
            case 12:
                int[] dr7 = dr(i5, i3);
                int i17 = dr7[0];
                int i18 = dr7[1];
                j jVar2 = new j();
                while (i2 < i17) {
                    jVar2.a(Hb((int) ab(i(this.bytes, i3 + i18 + (this.lCo * i2), i3 + i18 + ((i2 + 1) * this.lCo)))));
                    i2++;
                }
                return jVar2;
            case 13:
                int[] dr8 = dr(i5, i3);
                int i19 = dr8[0];
                int i20 = dr8[1];
                g gVar = new g();
                while (i2 < i19) {
                    i Hb = Hb((int) ab(i(this.bytes, i3 + i20 + (this.lCo * i2), i3 + i20 + ((i2 + 1) * this.lCo))));
                    gVar.put(Hb.toString(), Hb((int) ab(i(this.bytes, i3 + i20 + (this.lCo * i19) + (this.lCo * i2), i3 + i20 + (this.lCo * i19) + ((i2 + 1) * this.lCo)))));
                    i2++;
                }
                return gVar;
        }
    }

    private int[] dr(int i, int i2) {
        int i3;
        byte b;
        if (i == 15) {
            int i4 = (this.bytes[i2 + 1] & 240) >> 4;
            if (i4 != 1) {
                System.err.println("BinaryPropertyListParser: Length integer has an unexpected type" + i4 + ". Attempting to parse anyway...");
            }
            int pow = (int) Math.pow(2.0d, b & 15);
            i3 = pow + 2;
            if (pow < 3) {
                i = (int) ab(i(this.bytes, i2 + 2, pow + i2 + 2));
            } else {
                i = new BigInteger(i(this.bytes, i2 + 2, pow + i2 + 2)).intValue();
            }
        } else {
            i3 = 1;
        }
        return new int[]{i, i3};
    }

    private int l(byte[] bArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i + i3;
            if (bArr.length > i5) {
                if (bArr[i5] < 128) {
                    i3++;
                }
                if (bArr[i5] >= 194) {
                    if (bArr[i5] < 224) {
                        if ((bArr[i5 + 1] & 192) == 128) {
                            i3 += 2;
                        } else {
                            return i2;
                        }
                    } else if (bArr[i5] < 240) {
                        if ((bArr[i5 + 1] & 192) == 128 && (bArr[i5 + 2] & 192) == 128) {
                            i3 += 3;
                        } else {
                            return i2;
                        }
                    } else if (bArr[i5] >= 245) {
                        continue;
                    } else if ((bArr[i5 + 1] & 192) == 128 && (bArr[i5 + 2] & 192) == 128 && (bArr[i5 + 3] & 192) == 128) {
                        i3 += 4;
                    } else {
                        return i2;
                    }
                } else {
                    return i2;
                }
            } else {
                return i2;
            }
        }
        return i3;
    }

    public static long ab(byte[] bArr) {
        long j = 0;
        for (byte b : bArr) {
            j = (j << 8) | (b & 255);
        }
        return 4294967295L & j;
    }

    public static long m(byte[] bArr, int i, int i2) {
        long j = 0;
        while (i < i2) {
            j = (j << 8) | (bArr[i] & 255);
            i++;
        }
        return j & 4294967295L;
    }

    public static long ac(byte[] bArr) {
        long j = 0;
        for (byte b : bArr) {
            j = (j << 8) | (b & 255);
        }
        return j;
    }

    public static double ad(byte[] bArr) {
        if (bArr.length == 8) {
            return Double.longBitsToDouble(ac(bArr));
        }
        if (bArr.length == 4) {
            return Float.intBitsToFloat((int) ac(bArr));
        }
        throw new IllegalArgumentException("bad byte array length " + bArr.length);
    }

    public static byte[] i(byte[] bArr, int i, int i2) {
        int i3 = i2 - i;
        if (i3 < 0) {
            throw new IllegalArgumentException("startIndex (" + i + ") > endIndex (" + i2 + ")");
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i, bArr2, 0, i3);
        return bArr2;
    }
}
