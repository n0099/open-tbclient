package d.b.n0.b;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.webkit.internal.Base64;
import com.baidu.webkit.internal.utils.UtilsBlink;
import d.b.n0.b.b;
import io.flutter.plugin.common.StandardMessageCodec;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes5.dex */
public class a extends b {
    public static final byte[] j = {13, 10};
    public static final byte[] k = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    public static final byte[] l = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, UtilsBlink.VER_TYPE_SEPARATOR, 95};
    public static final byte[] m = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, StandardMessageCodec.LIST, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, PublicSuffixDatabase.EXCEPTION_MARKER, 34, Base64.INTERNAL_PADDING, 36, 37, 38, 39, 40, 41, ExifInterface.START_CODE, 43, 44, UtilsBlink.VER_TYPE_SEPARATOR, 46, 47, 48, 49, 50, 51};

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f64157e;

    /* renamed from: f  reason: collision with root package name */
    public final byte[] f64158f;

    /* renamed from: g  reason: collision with root package name */
    public final byte[] f64159g;

    /* renamed from: h  reason: collision with root package name */
    public final int f64160h;
    public final int i;

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

    public static byte[] q(byte[] bArr, boolean z, boolean z2, int i) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        a aVar = z ? new a(z2) : new a(0, j, z2);
        long j2 = aVar.j(bArr);
        if (j2 <= i) {
            return aVar.g(bArr);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + j2 + ") than the specified maximum size of " + i);
    }

    public static String r(byte[] bArr) {
        return d.d(o(bArr, false));
    }

    @Override // d.b.n0.b.b
    public void c(byte[] bArr, int i, int i2, b.a aVar) {
        byte b2;
        if (aVar.f64170f) {
            return;
        }
        if (i2 < 0) {
            aVar.f64170f = true;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            byte[] h2 = h(this.f64160h, aVar);
            int i4 = i + 1;
            byte b3 = bArr[i];
            if (b3 == 61) {
                aVar.f64170f = true;
                break;
            }
            if (b3 >= 0) {
                byte[] bArr2 = m;
                if (b3 < bArr2.length && (b2 = bArr2[b3]) >= 0) {
                    int i5 = (aVar.f64172h + 1) % 4;
                    aVar.f64172h = i5;
                    int i6 = (aVar.f64165a << 6) + b2;
                    aVar.f64165a = i6;
                    if (i5 == 0) {
                        int i7 = aVar.f64168d;
                        int i8 = i7 + 1;
                        aVar.f64168d = i8;
                        h2[i7] = (byte) ((i6 >> 16) & 255);
                        int i9 = i8 + 1;
                        aVar.f64168d = i9;
                        h2[i8] = (byte) ((i6 >> 8) & 255);
                        aVar.f64168d = i9 + 1;
                        h2[i9] = (byte) (i6 & 255);
                    }
                }
            }
            i3++;
            i = i4;
        }
        if (!aVar.f64170f || aVar.f64172h == 0) {
            return;
        }
        byte[] h3 = h(this.f64160h, aVar);
        int i10 = aVar.f64172h;
        if (i10 != 1) {
            if (i10 == 2) {
                int i11 = aVar.f64165a >> 4;
                aVar.f64165a = i11;
                int i12 = aVar.f64168d;
                aVar.f64168d = i12 + 1;
                h3[i12] = (byte) (i11 & 255);
            } else if (i10 == 3) {
                int i13 = aVar.f64165a >> 2;
                aVar.f64165a = i13;
                int i14 = aVar.f64168d;
                int i15 = i14 + 1;
                aVar.f64168d = i15;
                h3[i14] = (byte) ((i13 >> 8) & 255);
                aVar.f64168d = i15 + 1;
                h3[i15] = (byte) (i13 & 255);
            } else {
                throw new IllegalStateException("Impossible modulus " + aVar.f64172h);
            }
        }
    }

    @Override // d.b.n0.b.b
    public void f(byte[] bArr, int i, int i2, b.a aVar) {
        if (aVar.f64170f) {
            return;
        }
        if (i2 >= 0) {
            int i3 = 0;
            while (i3 < i2) {
                byte[] h2 = h(this.i, aVar);
                aVar.f64172h = (aVar.f64172h + 1) % 3;
                int i4 = i + 1;
                int i5 = bArr[i];
                if (i5 < 0) {
                    i5 += 256;
                }
                int i6 = (aVar.f64165a << 8) + i5;
                aVar.f64165a = i6;
                if (aVar.f64172h == 0) {
                    int i7 = aVar.f64168d;
                    int i8 = i7 + 1;
                    aVar.f64168d = i8;
                    byte[] bArr2 = this.f64157e;
                    h2[i7] = bArr2[(i6 >> 18) & 63];
                    int i9 = i8 + 1;
                    aVar.f64168d = i9;
                    h2[i8] = bArr2[(i6 >> 12) & 63];
                    int i10 = i9 + 1;
                    aVar.f64168d = i10;
                    h2[i9] = bArr2[(i6 >> 6) & 63];
                    int i11 = i10 + 1;
                    aVar.f64168d = i11;
                    h2[i10] = bArr2[i6 & 63];
                    int i12 = aVar.f64171g + 4;
                    aVar.f64171g = i12;
                    int i13 = this.f64163c;
                    if (i13 > 0 && i13 <= i12) {
                        byte[] bArr3 = this.f64159g;
                        System.arraycopy(bArr3, 0, h2, i11, bArr3.length);
                        aVar.f64168d += this.f64159g.length;
                        aVar.f64171g = 0;
                    }
                }
                i3++;
                i = i4;
            }
            return;
        }
        aVar.f64170f = true;
        if (aVar.f64172h == 0 && this.f64163c == 0) {
            return;
        }
        byte[] h3 = h(this.i, aVar);
        int i14 = aVar.f64168d;
        int i15 = aVar.f64172h;
        if (i15 != 0) {
            if (i15 == 1) {
                int i16 = i14 + 1;
                aVar.f64168d = i16;
                byte[] bArr4 = this.f64157e;
                int i17 = aVar.f64165a;
                h3[i14] = bArr4[(i17 >> 2) & 63];
                int i18 = i16 + 1;
                aVar.f64168d = i18;
                h3[i16] = bArr4[(i17 << 4) & 63];
                if (bArr4 == k) {
                    int i19 = i18 + 1;
                    aVar.f64168d = i19;
                    h3[i18] = 61;
                    aVar.f64168d = i19 + 1;
                    h3[i19] = 61;
                }
            } else if (i15 == 2) {
                int i20 = i14 + 1;
                aVar.f64168d = i20;
                byte[] bArr5 = this.f64157e;
                int i21 = aVar.f64165a;
                h3[i14] = bArr5[(i21 >> 10) & 63];
                int i22 = i20 + 1;
                aVar.f64168d = i22;
                h3[i20] = bArr5[(i21 >> 4) & 63];
                int i23 = i22 + 1;
                aVar.f64168d = i23;
                h3[i22] = bArr5[(i21 << 2) & 63];
                if (bArr5 == k) {
                    aVar.f64168d = i23 + 1;
                    h3[i23] = 61;
                }
            } else {
                throw new IllegalStateException("Impossible modulus " + aVar.f64172h);
            }
        }
        int i24 = aVar.f64171g;
        int i25 = aVar.f64168d;
        int i26 = i24 + (i25 - i14);
        aVar.f64171g = i26;
        if (this.f64163c <= 0 || i26 <= 0) {
            return;
        }
        byte[] bArr6 = this.f64159g;
        System.arraycopy(bArr6, 0, h3, i25, bArr6.length);
        aVar.f64168d += this.f64159g.length;
    }

    @Override // d.b.n0.b.b
    public boolean k(byte b2) {
        if (b2 >= 0) {
            byte[] bArr = this.f64158f;
            if (b2 < bArr.length && bArr[b2] != -1) {
                return true;
            }
        }
        return false;
    }

    public a(boolean z) {
        this(76, j, z);
    }

    public a(int i) {
        this(i, j);
    }

    public a(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    public a(int i, byte[] bArr, boolean z) {
        super(3, 4, i, bArr == null ? 0 : bArr.length);
        this.f64158f = m;
        if (bArr != null) {
            if (b(bArr)) {
                String d2 = d.d(bArr);
                throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + d2 + "]");
            } else if (i > 0) {
                this.i = bArr.length + 4;
                byte[] bArr2 = new byte[bArr.length];
                this.f64159g = bArr2;
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            } else {
                this.i = 4;
                this.f64159g = null;
            }
        } else {
            this.i = 4;
            this.f64159g = null;
        }
        this.f64160h = this.i - 1;
        this.f64157e = z ? l : k;
    }
}
