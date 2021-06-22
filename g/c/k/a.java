package g.c.k;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.webkit.internal.Base64;
import com.baidu.webkit.internal.utils.UtilsBlink;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPOutputStream;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes8.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f71752a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f71753b = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, StandardMessageCodec.LIST, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, PublicSuffixDatabase.EXCEPTION_MARKER, 34, Base64.INTERNAL_PADDING, 36, 37, 38, 39, 40, 41, 42, 43, 44, UtilsBlink.VER_TYPE_SEPARATOR, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f71754c = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, UtilsBlink.VER_TYPE_SEPARATOR, 95};

    /* renamed from: d  reason: collision with root package name */
    public static final byte[] f71755d = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, StandardMessageCodec.LIST, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, PublicSuffixDatabase.EXCEPTION_MARKER, 34, Base64.INTERNAL_PADDING, 36, 37, 38, 39, 40, 41, 42, 43, 44, UtilsBlink.VER_TYPE_SEPARATOR, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: e  reason: collision with root package name */
    public static final byte[] f71756e = {UtilsBlink.VER_TYPE_SEPARATOR, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122};

    /* renamed from: f  reason: collision with root package name */
    public static final byte[] f71757f = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, StandardMessageCodec.LIST, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, PublicSuffixDatabase.EXCEPTION_MARKER, 34, Base64.INTERNAL_PADDING, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, UtilsBlink.VER_TYPE_SEPARATOR, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    public static int d(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        int i5;
        int i6;
        if (bArr != null) {
            if (bArr2 != null) {
                if (i2 >= 0 && (i5 = i2 + 3) < bArr.length) {
                    if (i3 >= 0 && (i6 = i3 + 2) < bArr2.length) {
                        byte[] k = k(i4);
                        int i7 = i2 + 2;
                        if (bArr[i7] == 61) {
                            bArr2[i3] = (byte) ((((k[bArr[i2 + 1]] & 255) << 12) | ((k[bArr[i2]] & 255) << 18)) >>> 16);
                            return 1;
                        } else if (bArr[i5] == 61) {
                            int i8 = ((k[bArr[i7]] & 255) << 6) | ((k[bArr[i2 + 1]] & 255) << 12) | ((k[bArr[i2]] & 255) << 18);
                            bArr2[i3] = (byte) (i8 >>> 16);
                            bArr2[i3 + 1] = (byte) (i8 >>> 8);
                            return 2;
                        } else {
                            int i9 = (k[bArr[i5]] & 255) | ((k[bArr[i2 + 1]] & 255) << 12) | ((k[bArr[i2]] & 255) << 18) | ((k[bArr[i7]] & 255) << 6);
                            bArr2[i3] = (byte) (i9 >> 16);
                            bArr2[i3 + 1] = (byte) (i9 >> 8);
                            bArr2[i6] = (byte) i9;
                            return 3;
                        }
                    }
                    throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(bArr2.length), Integer.valueOf(i3)));
                }
                throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i2)));
            }
            throw new IllegalArgumentException("Destination array was null.");
        }
        throw new IllegalArgumentException("Source array was null.");
    }

    public static byte[] e(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5) {
        byte[] j = j(i5);
        int i6 = (i3 > 0 ? (bArr[i2] << 24) >>> 8 : 0) | (i3 > 1 ? (bArr[i2 + 1] << 24) >>> 16 : 0) | (i3 > 2 ? (bArr[i2 + 2] << 24) >>> 24 : 0);
        if (i3 == 1) {
            bArr2[i4] = j[i6 >>> 18];
            bArr2[i4 + 1] = j[(i6 >>> 12) & 63];
            bArr2[i4 + 2] = 61;
            bArr2[i4 + 3] = 61;
            return bArr2;
        } else if (i3 == 2) {
            bArr2[i4] = j[i6 >>> 18];
            bArr2[i4 + 1] = j[(i6 >>> 12) & 63];
            bArr2[i4 + 2] = j[(i6 >>> 6) & 63];
            bArr2[i4 + 3] = 61;
            return bArr2;
        } else if (i3 != 3) {
            return bArr2;
        } else {
            bArr2[i4] = j[i6 >>> 18];
            bArr2[i4 + 1] = j[(i6 >>> 12) & 63];
            bArr2[i4 + 2] = j[(i6 >>> 6) & 63];
            bArr2[i4 + 3] = j[i6 & 63];
            return bArr2;
        }
    }

    public static byte[] f(byte[] bArr, byte[] bArr2, int i2, int i3) {
        e(bArr2, 0, i2, bArr, 0, i3);
        return bArr;
    }

    public static String g(byte[] bArr) {
        try {
            return h(bArr, 0, bArr.length, 0);
        } catch (IOException unused) {
            return null;
        }
    }

    public static String h(byte[] bArr, int i2, int i3, int i4) throws IOException {
        byte[] i5 = i(bArr, i2, i3, i4);
        try {
            return new String(i5, "US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new String(i5);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x003c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0040 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v16, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v17, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v18, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v19, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v20, resolved type: java.io.ByteArrayOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    public static byte[] i(byte[] bArr, int i2, int i3, int i4) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        C1968a c1968a;
        GZIPOutputStream gZIPOutputStream;
        if (bArr != null) {
            if (i2 < 0) {
                throw new IllegalArgumentException("Cannot have negative offset: " + i2);
            } else if (i3 >= 0) {
                if (i2 + i3 <= bArr.length) {
                    if ((i4 & 2) != 0) {
                        GZIPOutputStream gZIPOutputStream2 = null;
                        try {
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            try {
                                c1968a = new C1968a(byteArrayOutputStream, i4 | 1);
                                try {
                                    gZIPOutputStream = new GZIPOutputStream(c1968a);
                                } catch (IOException e2) {
                                    e = e2;
                                    gZIPOutputStream = null;
                                } catch (Throwable th) {
                                    th = th;
                                    try {
                                        gZIPOutputStream2.close();
                                    } catch (Exception unused) {
                                    }
                                    try {
                                        c1968a.close();
                                    } catch (Exception unused2) {
                                    }
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Exception unused3) {
                                    }
                                    throw th;
                                }
                            } catch (IOException e3) {
                                e = e3;
                                c1968a = null;
                                gZIPOutputStream = null;
                            } catch (Throwable th2) {
                                th = th2;
                                c1968a = null;
                            }
                        } catch (IOException e4) {
                            e = e4;
                            c1968a = null;
                            gZIPOutputStream = null;
                        } catch (Throwable th3) {
                            th = th3;
                            byteArrayOutputStream = 0;
                            c1968a = null;
                        }
                        try {
                            gZIPOutputStream.write(bArr, i2, i3);
                            gZIPOutputStream.close();
                            try {
                                gZIPOutputStream.close();
                            } catch (Exception unused4) {
                            }
                            try {
                                c1968a.close();
                            } catch (Exception unused5) {
                            }
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception unused6) {
                            }
                            return byteArrayOutputStream.toByteArray();
                        } catch (IOException e5) {
                            e = e5;
                            gZIPOutputStream2 = byteArrayOutputStream;
                            try {
                                throw e;
                            } catch (Throwable th4) {
                                th = th4;
                                byteArrayOutputStream = gZIPOutputStream2;
                                gZIPOutputStream2 = gZIPOutputStream;
                                gZIPOutputStream2.close();
                                c1968a.close();
                                byteArrayOutputStream.close();
                                throw th;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            gZIPOutputStream2 = gZIPOutputStream;
                            gZIPOutputStream2.close();
                            c1968a.close();
                            byteArrayOutputStream.close();
                            throw th;
                        }
                    }
                    boolean z = (i4 & 8) != 0;
                    int i5 = ((i3 / 3) * 4) + (i3 % 3 > 0 ? 4 : 0);
                    if (z) {
                        i5 += i5 / 76;
                    }
                    int i6 = i5;
                    byte[] bArr2 = new byte[i6];
                    int i7 = i3 - 2;
                    int i8 = 0;
                    int i9 = 0;
                    int i10 = 0;
                    while (i8 < i7) {
                        int i11 = i8;
                        e(bArr, i8 + i2, 3, bArr2, i9, i4);
                        int i12 = i10 + 4;
                        if (!z || i12 < 76) {
                            i10 = i12;
                        } else {
                            bArr2[i9 + 4] = 10;
                            i9++;
                            i10 = 0;
                        }
                        i8 = i11 + 3;
                        i9 += 4;
                    }
                    int i13 = i8;
                    if (i13 < i3) {
                        e(bArr, i13 + i2, i3 - i13, bArr2, i9, i4);
                        i9 += 4;
                    }
                    int i14 = i9;
                    if (i14 <= i6 - 1) {
                        byte[] bArr3 = new byte[i14];
                        System.arraycopy(bArr2, 0, bArr3, 0, i14);
                        return bArr3;
                    }
                    return bArr2;
                }
                throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(bArr.length)));
            } else {
                throw new IllegalArgumentException("Cannot have length offset: " + i3);
            }
        }
        throw new IllegalArgumentException("Cannot serialize a null array.");
    }

    public static final byte[] j(int i2) {
        if ((i2 & 16) == 16) {
            return f71754c;
        }
        if ((i2 & 32) == 32) {
            return f71756e;
        }
        return f71752a;
    }

    public static final byte[] k(int i2) {
        if ((i2 & 16) == 16) {
            return f71755d;
        }
        if ((i2 & 32) == 32) {
            return f71757f;
        }
        return f71753b;
    }

    /* renamed from: g.c.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1968a extends FilterOutputStream {

        /* renamed from: e  reason: collision with root package name */
        public boolean f71758e;

        /* renamed from: f  reason: collision with root package name */
        public int f71759f;

        /* renamed from: g  reason: collision with root package name */
        public byte[] f71760g;

        /* renamed from: h  reason: collision with root package name */
        public int f71761h;

        /* renamed from: i  reason: collision with root package name */
        public int f71762i;
        public boolean j;
        public byte[] k;
        public boolean l;
        public int m;
        public byte[] n;

        public C1968a(OutputStream outputStream, int i2) {
            super(outputStream);
            this.j = (i2 & 8) != 0;
            boolean z = (i2 & 1) != 0;
            this.f71758e = z;
            int i3 = z ? 3 : 4;
            this.f71761h = i3;
            this.f71760g = new byte[i3];
            this.f71759f = 0;
            this.f71762i = 0;
            this.l = false;
            this.k = new byte[4];
            this.m = i2;
            this.n = a.k(i2);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            n();
            super.close();
            this.f71760g = null;
            ((FilterOutputStream) this).out = null;
        }

        public void n() throws IOException {
            int i2 = this.f71759f;
            if (i2 > 0) {
                if (this.f71758e) {
                    OutputStream outputStream = ((FilterOutputStream) this).out;
                    byte[] bArr = this.k;
                    a.f(bArr, this.f71760g, i2, this.m);
                    outputStream.write(bArr);
                    this.f71759f = 0;
                    return;
                }
                throw new IOException("Base64 input not properly padded.");
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i2) throws IOException {
            if (this.l) {
                ((FilterOutputStream) this).out.write(i2);
            } else if (this.f71758e) {
                byte[] bArr = this.f71760g;
                int i3 = this.f71759f;
                int i4 = i3 + 1;
                this.f71759f = i4;
                bArr[i3] = (byte) i2;
                int i5 = this.f71761h;
                if (i4 >= i5) {
                    OutputStream outputStream = ((FilterOutputStream) this).out;
                    byte[] bArr2 = this.k;
                    a.f(bArr2, bArr, i5, this.m);
                    outputStream.write(bArr2);
                    int i6 = this.f71762i + 4;
                    this.f71762i = i6;
                    if (this.j && i6 >= 76) {
                        ((FilterOutputStream) this).out.write(10);
                        this.f71762i = 0;
                    }
                    this.f71759f = 0;
                }
            } else {
                byte[] bArr3 = this.n;
                int i7 = i2 & 127;
                if (bArr3[i7] > -5) {
                    byte[] bArr4 = this.f71760g;
                    int i8 = this.f71759f;
                    int i9 = i8 + 1;
                    this.f71759f = i9;
                    bArr4[i8] = (byte) i2;
                    if (i9 >= this.f71761h) {
                        ((FilterOutputStream) this).out.write(this.k, 0, a.d(bArr4, 0, this.k, 0, this.m));
                        this.f71759f = 0;
                    }
                } else if (bArr3[i7] != -5) {
                    throw new IOException("Invalid character in Base64 data.");
                }
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i2, int i3) throws IOException {
            if (this.l) {
                ((FilterOutputStream) this).out.write(bArr, i2, i3);
                return;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                write(bArr[i2 + i4]);
            }
        }
    }
}
