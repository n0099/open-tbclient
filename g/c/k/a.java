package g.c.k;

import androidx.exifinterface.media.ExifInterface;
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
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f68654a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f68655b = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, StandardMessageCodec.LIST, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, PublicSuffixDatabase.EXCEPTION_MARKER, 34, Base64.INTERNAL_PADDING, 36, 37, 38, 39, 40, 41, ExifInterface.START_CODE, 43, 44, UtilsBlink.VER_TYPE_SEPARATOR, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f68656c = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, UtilsBlink.VER_TYPE_SEPARATOR, 95};

    /* renamed from: d  reason: collision with root package name */
    public static final byte[] f68657d = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, StandardMessageCodec.LIST, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, PublicSuffixDatabase.EXCEPTION_MARKER, 34, Base64.INTERNAL_PADDING, 36, 37, 38, 39, 40, 41, ExifInterface.START_CODE, 43, 44, UtilsBlink.VER_TYPE_SEPARATOR, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: e  reason: collision with root package name */
    public static final byte[] f68658e = {UtilsBlink.VER_TYPE_SEPARATOR, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122};

    /* renamed from: f  reason: collision with root package name */
    public static final byte[] f68659f = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, StandardMessageCodec.LIST, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, PublicSuffixDatabase.EXCEPTION_MARKER, 34, Base64.INTERNAL_PADDING, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, ExifInterface.START_CODE, 43, 44, UtilsBlink.VER_TYPE_SEPARATOR, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    public static int d(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        int i4;
        int i5;
        if (bArr != null) {
            if (bArr2 != null) {
                if (i >= 0 && (i4 = i + 3) < bArr.length) {
                    if (i2 >= 0 && (i5 = i2 + 2) < bArr2.length) {
                        byte[] k = k(i3);
                        int i6 = i + 2;
                        if (bArr[i6] == 61) {
                            bArr2[i2] = (byte) ((((k[bArr[i + 1]] & 255) << 12) | ((k[bArr[i]] & 255) << 18)) >>> 16);
                            return 1;
                        } else if (bArr[i4] == 61) {
                            int i7 = ((k[bArr[i6]] & 255) << 6) | ((k[bArr[i + 1]] & 255) << 12) | ((k[bArr[i]] & 255) << 18);
                            bArr2[i2] = (byte) (i7 >>> 16);
                            bArr2[i2 + 1] = (byte) (i7 >>> 8);
                            return 2;
                        } else {
                            int i8 = (k[bArr[i4]] & 255) | ((k[bArr[i + 1]] & 255) << 12) | ((k[bArr[i]] & 255) << 18) | ((k[bArr[i6]] & 255) << 6);
                            bArr2[i2] = (byte) (i8 >> 16);
                            bArr2[i2 + 1] = (byte) (i8 >> 8);
                            bArr2[i5] = (byte) i8;
                            return 3;
                        }
                    }
                    throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(bArr2.length), Integer.valueOf(i2)));
                }
                throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i)));
            }
            throw new IllegalArgumentException("Destination array was null.");
        }
        throw new IllegalArgumentException("Source array was null.");
    }

    public static byte[] e(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        byte[] j = j(i4);
        int i5 = (i2 > 0 ? (bArr[i] << 24) >>> 8 : 0) | (i2 > 1 ? (bArr[i + 1] << 24) >>> 16 : 0) | (i2 > 2 ? (bArr[i + 2] << 24) >>> 24 : 0);
        if (i2 == 1) {
            bArr2[i3] = j[i5 >>> 18];
            bArr2[i3 + 1] = j[(i5 >>> 12) & 63];
            bArr2[i3 + 2] = 61;
            bArr2[i3 + 3] = 61;
            return bArr2;
        } else if (i2 == 2) {
            bArr2[i3] = j[i5 >>> 18];
            bArr2[i3 + 1] = j[(i5 >>> 12) & 63];
            bArr2[i3 + 2] = j[(i5 >>> 6) & 63];
            bArr2[i3 + 3] = 61;
            return bArr2;
        } else if (i2 != 3) {
            return bArr2;
        } else {
            bArr2[i3] = j[i5 >>> 18];
            bArr2[i3 + 1] = j[(i5 >>> 12) & 63];
            bArr2[i3 + 2] = j[(i5 >>> 6) & 63];
            bArr2[i3 + 3] = j[i5 & 63];
            return bArr2;
        }
    }

    public static byte[] f(byte[] bArr, byte[] bArr2, int i, int i2) {
        e(bArr2, 0, i, bArr, 0, i2);
        return bArr;
    }

    public static String g(byte[] bArr) {
        try {
            return h(bArr, 0, bArr.length, 0);
        } catch (IOException unused) {
            return null;
        }
    }

    public static String h(byte[] bArr, int i, int i2, int i3) throws IOException {
        byte[] i4 = i(bArr, i, i2, i3);
        try {
            return new String(i4, "US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new String(i4);
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
    public static byte[] i(byte[] bArr, int i, int i2, int i3) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        C1897a c1897a;
        GZIPOutputStream gZIPOutputStream;
        if (bArr != null) {
            if (i < 0) {
                throw new IllegalArgumentException("Cannot have negative offset: " + i);
            } else if (i2 >= 0) {
                if (i + i2 <= bArr.length) {
                    if ((i3 & 2) != 0) {
                        GZIPOutputStream gZIPOutputStream2 = null;
                        try {
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            try {
                                c1897a = new C1897a(byteArrayOutputStream, i3 | 1);
                                try {
                                    gZIPOutputStream = new GZIPOutputStream(c1897a);
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
                                        c1897a.close();
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
                                c1897a = null;
                                gZIPOutputStream = null;
                            } catch (Throwable th2) {
                                th = th2;
                                c1897a = null;
                            }
                        } catch (IOException e4) {
                            e = e4;
                            c1897a = null;
                            gZIPOutputStream = null;
                        } catch (Throwable th3) {
                            th = th3;
                            byteArrayOutputStream = 0;
                            c1897a = null;
                        }
                        try {
                            gZIPOutputStream.write(bArr, i, i2);
                            gZIPOutputStream.close();
                            try {
                                gZIPOutputStream.close();
                            } catch (Exception unused4) {
                            }
                            try {
                                c1897a.close();
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
                                c1897a.close();
                                byteArrayOutputStream.close();
                                throw th;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            gZIPOutputStream2 = gZIPOutputStream;
                            gZIPOutputStream2.close();
                            c1897a.close();
                            byteArrayOutputStream.close();
                            throw th;
                        }
                    }
                    boolean z = (i3 & 8) != 0;
                    int i4 = ((i2 / 3) * 4) + (i2 % 3 > 0 ? 4 : 0);
                    if (z) {
                        i4 += i4 / 76;
                    }
                    int i5 = i4;
                    byte[] bArr2 = new byte[i5];
                    int i6 = i2 - 2;
                    int i7 = 0;
                    int i8 = 0;
                    int i9 = 0;
                    while (i7 < i6) {
                        int i10 = i7;
                        e(bArr, i7 + i, 3, bArr2, i8, i3);
                        int i11 = i9 + 4;
                        if (!z || i11 < 76) {
                            i9 = i11;
                        } else {
                            bArr2[i8 + 4] = 10;
                            i8++;
                            i9 = 0;
                        }
                        i7 = i10 + 3;
                        i8 += 4;
                    }
                    int i12 = i7;
                    if (i12 < i2) {
                        e(bArr, i12 + i, i2 - i12, bArr2, i8, i3);
                        i8 += 4;
                    }
                    int i13 = i8;
                    if (i13 <= i5 - 1) {
                        byte[] bArr3 = new byte[i13];
                        System.arraycopy(bArr2, 0, bArr3, 0, i13);
                        return bArr3;
                    }
                    return bArr2;
                }
                throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(bArr.length)));
            } else {
                throw new IllegalArgumentException("Cannot have length offset: " + i2);
            }
        }
        throw new IllegalArgumentException("Cannot serialize a null array.");
    }

    public static final byte[] j(int i) {
        if ((i & 16) == 16) {
            return f68656c;
        }
        if ((i & 32) == 32) {
            return f68658e;
        }
        return f68654a;
    }

    public static final byte[] k(int i) {
        if ((i & 16) == 16) {
            return f68657d;
        }
        if ((i & 32) == 32) {
            return f68659f;
        }
        return f68655b;
    }

    /* renamed from: g.c.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1897a extends FilterOutputStream {

        /* renamed from: e  reason: collision with root package name */
        public boolean f68660e;

        /* renamed from: f  reason: collision with root package name */
        public int f68661f;

        /* renamed from: g  reason: collision with root package name */
        public byte[] f68662g;

        /* renamed from: h  reason: collision with root package name */
        public int f68663h;
        public int i;
        public boolean j;
        public byte[] k;
        public boolean l;
        public int m;
        public byte[] n;

        public C1897a(OutputStream outputStream, int i) {
            super(outputStream);
            this.j = (i & 8) != 0;
            boolean z = (i & 1) != 0;
            this.f68660e = z;
            int i2 = z ? 3 : 4;
            this.f68663h = i2;
            this.f68662g = new byte[i2];
            this.f68661f = 0;
            this.i = 0;
            this.l = false;
            this.k = new byte[4];
            this.m = i;
            this.n = a.k(i);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            n();
            super.close();
            this.f68662g = null;
            ((FilterOutputStream) this).out = null;
        }

        public void n() throws IOException {
            int i = this.f68661f;
            if (i > 0) {
                if (this.f68660e) {
                    OutputStream outputStream = ((FilterOutputStream) this).out;
                    byte[] bArr = this.k;
                    a.f(bArr, this.f68662g, i, this.m);
                    outputStream.write(bArr);
                    this.f68661f = 0;
                    return;
                }
                throw new IOException("Base64 input not properly padded.");
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i) throws IOException {
            if (this.l) {
                ((FilterOutputStream) this).out.write(i);
            } else if (this.f68660e) {
                byte[] bArr = this.f68662g;
                int i2 = this.f68661f;
                int i3 = i2 + 1;
                this.f68661f = i3;
                bArr[i2] = (byte) i;
                int i4 = this.f68663h;
                if (i3 >= i4) {
                    OutputStream outputStream = ((FilterOutputStream) this).out;
                    byte[] bArr2 = this.k;
                    a.f(bArr2, bArr, i4, this.m);
                    outputStream.write(bArr2);
                    int i5 = this.i + 4;
                    this.i = i5;
                    if (this.j && i5 >= 76) {
                        ((FilterOutputStream) this).out.write(10);
                        this.i = 0;
                    }
                    this.f68661f = 0;
                }
            } else {
                byte[] bArr3 = this.n;
                int i6 = i & 127;
                if (bArr3[i6] > -5) {
                    byte[] bArr4 = this.f68662g;
                    int i7 = this.f68661f;
                    int i8 = i7 + 1;
                    this.f68661f = i8;
                    bArr4[i7] = (byte) i;
                    if (i8 >= this.f68663h) {
                        ((FilterOutputStream) this).out.write(this.k, 0, a.d(bArr4, 0, this.k, 0, this.m));
                        this.f68661f = 0;
                    }
                } else if (bArr3[i6] != -5) {
                    throw new IOException("Invalid character in Base64 data.");
                }
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            if (this.l) {
                ((FilterOutputStream) this).out.write(bArr, i, i2);
                return;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                write(bArr[i + i3]);
            }
        }
    }
}
