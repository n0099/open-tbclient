package d.a.o0.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.webkit.internal.Base64;
import com.baidu.webkit.internal.utils.UtilsBlink;
import d.a.o0.b.b;
import io.flutter.plugin.common.StandardMessageCodec;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes5.dex */
public class a extends b {
    public static final byte[] j = {13, 10};
    public static final byte[] k = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    public static final byte[] l = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, UtilsBlink.VER_TYPE_SEPARATOR, 95};
    public static final byte[] m = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, StandardMessageCodec.LIST, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, PublicSuffixDatabase.EXCEPTION_MARKER, 34, Base64.INTERNAL_PADDING, 36, 37, 38, 39, 40, 41, 42, 43, 44, UtilsBlink.VER_TYPE_SEPARATOR, 46, 47, 48, 49, 50, 51};

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f63451e;

    /* renamed from: f  reason: collision with root package name */
    public final byte[] f63452f;

    /* renamed from: g  reason: collision with root package name */
    public final byte[] f63453g;

    /* renamed from: h  reason: collision with root package name */
    public final int f63454h;

    /* renamed from: i  reason: collision with root package name */
    public final int f63455i;

    public a() {
        this(0);
    }

    public static byte[] n(String str) {
        return new a().d(str);
    }

    public static byte[] o(byte[] bArr, boolean z) {
        return p(bArr, z, false);
    }

    public static byte[] p(byte[] bArr, boolean z, boolean z2) {
        return q(bArr, z, z2, Integer.MAX_VALUE);
    }

    public static byte[] q(byte[] bArr, boolean z, boolean z2, int i2) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        a aVar = z ? new a(z2) : new a(0, j, z2);
        long j2 = aVar.j(bArr);
        if (j2 <= i2) {
            return aVar.g(bArr);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + j2 + ") than the specified maximum size of " + i2);
    }

    public static String r(byte[] bArr) {
        return d.d(o(bArr, false));
    }

    @Override // d.a.o0.b.b
    public void c(byte[] bArr, int i2, int i3, b.a aVar) {
        byte b2;
        if (aVar.f63465f) {
            return;
        }
        if (i3 < 0) {
            aVar.f63465f = true;
        }
        int i4 = 0;
        while (true) {
            if (i4 >= i3) {
                break;
            }
            byte[] h2 = h(this.f63454h, aVar);
            int i5 = i2 + 1;
            byte b3 = bArr[i2];
            if (b3 == 61) {
                aVar.f63465f = true;
                break;
            }
            if (b3 >= 0) {
                byte[] bArr2 = m;
                if (b3 < bArr2.length && (b2 = bArr2[b3]) >= 0) {
                    int i6 = (aVar.f63467h + 1) % 4;
                    aVar.f63467h = i6;
                    int i7 = (aVar.f63460a << 6) + b2;
                    aVar.f63460a = i7;
                    if (i6 == 0) {
                        int i8 = aVar.f63463d;
                        int i9 = i8 + 1;
                        aVar.f63463d = i9;
                        h2[i8] = (byte) ((i7 >> 16) & 255);
                        int i10 = i9 + 1;
                        aVar.f63463d = i10;
                        h2[i9] = (byte) ((i7 >> 8) & 255);
                        aVar.f63463d = i10 + 1;
                        h2[i10] = (byte) (i7 & 255);
                    }
                }
            }
            i4++;
            i2 = i5;
        }
        if (!aVar.f63465f || aVar.f63467h == 0) {
            return;
        }
        byte[] h3 = h(this.f63454h, aVar);
        int i11 = aVar.f63467h;
        if (i11 != 1) {
            if (i11 == 2) {
                int i12 = aVar.f63460a >> 4;
                aVar.f63460a = i12;
                int i13 = aVar.f63463d;
                aVar.f63463d = i13 + 1;
                h3[i13] = (byte) (i12 & 255);
            } else if (i11 == 3) {
                int i14 = aVar.f63460a >> 2;
                aVar.f63460a = i14;
                int i15 = aVar.f63463d;
                int i16 = i15 + 1;
                aVar.f63463d = i16;
                h3[i15] = (byte) ((i14 >> 8) & 255);
                aVar.f63463d = i16 + 1;
                h3[i16] = (byte) (i14 & 255);
            } else {
                throw new IllegalStateException("Impossible modulus " + aVar.f63467h);
            }
        }
    }

    @Override // d.a.o0.b.b
    public void f(byte[] bArr, int i2, int i3, b.a aVar) {
        if (aVar.f63465f) {
            return;
        }
        if (i3 >= 0) {
            int i4 = 0;
            while (i4 < i3) {
                byte[] h2 = h(this.f63455i, aVar);
                aVar.f63467h = (aVar.f63467h + 1) % 3;
                int i5 = i2 + 1;
                int i6 = bArr[i2];
                if (i6 < 0) {
                    i6 += 256;
                }
                int i7 = (aVar.f63460a << 8) + i6;
                aVar.f63460a = i7;
                if (aVar.f63467h == 0) {
                    int i8 = aVar.f63463d;
                    int i9 = i8 + 1;
                    aVar.f63463d = i9;
                    byte[] bArr2 = this.f63451e;
                    h2[i8] = bArr2[(i7 >> 18) & 63];
                    int i10 = i9 + 1;
                    aVar.f63463d = i10;
                    h2[i9] = bArr2[(i7 >> 12) & 63];
                    int i11 = i10 + 1;
                    aVar.f63463d = i11;
                    h2[i10] = bArr2[(i7 >> 6) & 63];
                    int i12 = i11 + 1;
                    aVar.f63463d = i12;
                    h2[i11] = bArr2[i7 & 63];
                    int i13 = aVar.f63466g + 4;
                    aVar.f63466g = i13;
                    int i14 = this.f63458c;
                    if (i14 > 0 && i14 <= i13) {
                        byte[] bArr3 = this.f63453g;
                        System.arraycopy(bArr3, 0, h2, i12, bArr3.length);
                        aVar.f63463d += this.f63453g.length;
                        aVar.f63466g = 0;
                    }
                }
                i4++;
                i2 = i5;
            }
            return;
        }
        aVar.f63465f = true;
        if (aVar.f63467h == 0 && this.f63458c == 0) {
            return;
        }
        byte[] h3 = h(this.f63455i, aVar);
        int i15 = aVar.f63463d;
        int i16 = aVar.f63467h;
        if (i16 != 0) {
            if (i16 == 1) {
                int i17 = i15 + 1;
                aVar.f63463d = i17;
                byte[] bArr4 = this.f63451e;
                int i18 = aVar.f63460a;
                h3[i15] = bArr4[(i18 >> 2) & 63];
                int i19 = i17 + 1;
                aVar.f63463d = i19;
                h3[i17] = bArr4[(i18 << 4) & 63];
                if (bArr4 == k) {
                    int i20 = i19 + 1;
                    aVar.f63463d = i20;
                    h3[i19] = 61;
                    aVar.f63463d = i20 + 1;
                    h3[i20] = 61;
                }
            } else if (i16 == 2) {
                int i21 = i15 + 1;
                aVar.f63463d = i21;
                byte[] bArr5 = this.f63451e;
                int i22 = aVar.f63460a;
                h3[i15] = bArr5[(i22 >> 10) & 63];
                int i23 = i21 + 1;
                aVar.f63463d = i23;
                h3[i21] = bArr5[(i22 >> 4) & 63];
                int i24 = i23 + 1;
                aVar.f63463d = i24;
                h3[i23] = bArr5[(i22 << 2) & 63];
                if (bArr5 == k) {
                    aVar.f63463d = i24 + 1;
                    h3[i24] = 61;
                }
            } else {
                throw new IllegalStateException("Impossible modulus " + aVar.f63467h);
            }
        }
        int i25 = aVar.f63466g;
        int i26 = aVar.f63463d;
        int i27 = i25 + (i26 - i15);
        aVar.f63466g = i27;
        if (this.f63458c <= 0 || i27 <= 0) {
            return;
        }
        byte[] bArr6 = this.f63453g;
        System.arraycopy(bArr6, 0, h3, i26, bArr6.length);
        aVar.f63463d += this.f63453g.length;
    }

    @Override // d.a.o0.b.b
    public boolean k(byte b2) {
        if (b2 >= 0) {
            byte[] bArr = this.f63452f;
            if (b2 < bArr.length && bArr[b2] != -1) {
                return true;
            }
        }
        return false;
    }

    public a(boolean z) {
        this(76, j, z);
    }

    public a(int i2) {
        this(i2, j);
    }

    public a(int i2, byte[] bArr) {
        this(i2, bArr, false);
    }

    public a(int i2, byte[] bArr, boolean z) {
        super(3, 4, i2, bArr == null ? 0 : bArr.length);
        this.f63452f = m;
        if (bArr != null) {
            if (b(bArr)) {
                String d2 = d.d(bArr);
                throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + d2 + "]");
            } else if (i2 > 0) {
                this.f63455i = bArr.length + 4;
                byte[] bArr2 = new byte[bArr.length];
                this.f63453g = bArr2;
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            } else {
                this.f63455i = 4;
                this.f63453g = null;
            }
        } else {
            this.f63455i = 4;
            this.f63453g = null;
        }
        this.f63454h = this.f63455i - 1;
        this.f63451e = z ? l : k;
    }
}
