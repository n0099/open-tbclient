package d.a.c.e.p;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.webkit.internal.Base64;
import com.baidu.webkit.internal.utils.UtilsBlink;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f39934a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f39935b = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, StandardMessageCodec.LIST, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, PublicSuffixDatabase.EXCEPTION_MARKER, 34, Base64.INTERNAL_PADDING, 36, 37, 38, 39, 40, 41, 42, 43, 44, UtilsBlink.VER_TYPE_SEPARATOR, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f39936c = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, UtilsBlink.VER_TYPE_SEPARATOR, 95};

    /* renamed from: d  reason: collision with root package name */
    public static final byte[] f39937d = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, StandardMessageCodec.LIST, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, PublicSuffixDatabase.EXCEPTION_MARKER, 34, Base64.INTERNAL_PADDING, 36, 37, 38, 39, 40, 41, 42, 43, 44, UtilsBlink.VER_TYPE_SEPARATOR, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: e  reason: collision with root package name */
    public static final byte[] f39938e = {UtilsBlink.VER_TYPE_SEPARATOR, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122};

    /* renamed from: f  reason: collision with root package name */
    public static final byte[] f39939f = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, StandardMessageCodec.LIST, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, PublicSuffixDatabase.EXCEPTION_MARKER, 34, Base64.INTERNAL_PADDING, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, UtilsBlink.VER_TYPE_SEPARATOR, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    public static byte[] d(String str) throws IOException {
        return e(str, 0);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x0060 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x0062 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:49:0x0082 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:57:0x0059 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:75:0x0039 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.io.ByteArrayInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0059 -> B:73:0x0059). Please submit an issue!!! */
    public static byte[] e(String str, int i2) throws IOException {
        byte[] bytes;
        ?? length;
        GZIPInputStream gZIPInputStream;
        if (str != null) {
            try {
                bytes = str.getBytes("US-ASCII");
            } catch (UnsupportedEncodingException unused) {
                bytes = str.getBytes();
            }
            byte[] f2 = f(bytes, 0, bytes.length, i2);
            boolean z = (i2 & 4) != 0;
            if (f2 != null && (length = f2.length) >= 4 && !z && 35615 == ((f2[0] & 255) | ((f2[1] << 8) & 65280))) {
                byte[] bArr = new byte[2048];
                ByteArrayOutputStream byteArrayOutputStream = null;
                try {
                    try {
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                        try {
                            length = new ByteArrayInputStream(f2);
                            try {
                                gZIPInputStream = new GZIPInputStream(length);
                                while (true) {
                                    try {
                                        int read = gZIPInputStream.read(bArr);
                                        if (read < 0) {
                                            break;
                                        }
                                        byteArrayOutputStream2.write(bArr, 0, read);
                                    } catch (IOException e2) {
                                        e = e2;
                                        byteArrayOutputStream = byteArrayOutputStream2;
                                        length = length;
                                        try {
                                            e.printStackTrace();
                                            byteArrayOutputStream.close();
                                            gZIPInputStream.close();
                                            length.close();
                                            return f2;
                                        } catch (Throwable th) {
                                            th = th;
                                            try {
                                                byteArrayOutputStream.close();
                                            } catch (Exception unused2) {
                                            }
                                            try {
                                                gZIPInputStream.close();
                                            } catch (Exception unused3) {
                                            }
                                            try {
                                                length.close();
                                            } catch (Exception unused4) {
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        byteArrayOutputStream = byteArrayOutputStream2;
                                        byteArrayOutputStream.close();
                                        gZIPInputStream.close();
                                        length.close();
                                        throw th;
                                    }
                                }
                                f2 = byteArrayOutputStream2.toByteArray();
                                byteArrayOutputStream2.close();
                            } catch (IOException e3) {
                                e = e3;
                                gZIPInputStream = null;
                            } catch (Throwable th3) {
                                th = th3;
                                gZIPInputStream = null;
                            }
                        } catch (IOException e4) {
                            e = e4;
                            length = 0;
                            gZIPInputStream = null;
                        } catch (Throwable th4) {
                            th = th4;
                            length = 0;
                            gZIPInputStream = null;
                        }
                    } catch (Exception unused5) {
                    }
                } catch (IOException e5) {
                    e = e5;
                    length = 0;
                    gZIPInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    length = 0;
                    gZIPInputStream = null;
                }
                try {
                    gZIPInputStream.close();
                } catch (Exception unused6) {
                }
                try {
                    length.close();
                } catch (Exception unused7) {
                }
            }
            return f2;
        }
        throw new NullPointerException("Input string was null.");
    }

    public static byte[] f(byte[] bArr, int i2, int i3, int i4) throws IOException {
        int i5;
        if (bArr != null) {
            if (i2 < 0 || (i5 = i2 + i3) > bArr.length) {
                throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
            }
            if (i3 == 0) {
                return new byte[0];
            }
            if (i3 >= 4) {
                byte[] p = p(i4);
                byte[] bArr2 = new byte[(i3 * 3) / 4];
                byte[] bArr3 = new byte[4];
                int i6 = 0;
                int i7 = 0;
                while (i2 < i5) {
                    byte b2 = p[bArr[i2] & 255];
                    if (b2 < -5) {
                        throw new IOException(String.format("Bad Base64 input character decimal %d in array position %d", Integer.valueOf(bArr[i2] & 255), Integer.valueOf(i2)));
                    }
                    if (b2 >= -1) {
                        int i8 = i6 + 1;
                        bArr3[i6] = bArr[i2];
                        if (i8 > 3) {
                            i7 += g(bArr3, 0, bArr2, i7, i4);
                            if (bArr[i2] == 61) {
                                break;
                            }
                            i6 = 0;
                        } else {
                            i6 = i8;
                        }
                    }
                    i2++;
                }
                byte[] bArr4 = new byte[i7];
                System.arraycopy(bArr2, 0, bArr4, 0, i7);
                return bArr4;
            }
            throw new IllegalArgumentException("Base64-encoded string must have at least four characters, but length specified was " + i3);
        }
        throw new NullPointerException("Cannot decode null source array.");
    }

    public static int g(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        int i5;
        int i6;
        if (bArr != null) {
            if (bArr2 != null) {
                if (i2 >= 0 && (i5 = i2 + 3) < bArr.length) {
                    if (i3 >= 0 && (i6 = i3 + 2) < bArr2.length) {
                        byte[] p = p(i4);
                        int i7 = i2 + 2;
                        if (bArr[i7] == 61) {
                            bArr2[i3] = (byte) ((((p[bArr[i2 + 1]] & 255) << 12) | ((p[bArr[i2]] & 255) << 18)) >>> 16);
                            return 1;
                        } else if (bArr[i5] == 61) {
                            int i8 = ((p[bArr[i7]] & 255) << 6) | ((p[bArr[i2 + 1]] & 255) << 12) | ((p[bArr[i2]] & 255) << 18);
                            bArr2[i3] = (byte) (i8 >>> 16);
                            bArr2[i3 + 1] = (byte) (i8 >>> 8);
                            return 2;
                        } else {
                            int i9 = (p[bArr[i5]] & 255) | ((p[bArr[i2 + 1]] & 255) << 12) | ((p[bArr[i2]] & 255) << 18) | ((p[bArr[i7]] & 255) << 6);
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
            throw new NullPointerException("Destination array was null.");
        }
        throw new NullPointerException("Source array was null.");
    }

    public static byte[] h(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5) {
        byte[] o = o(i5);
        int i6 = (i3 > 0 ? (bArr[i2] << 24) >>> 8 : 0) | (i3 > 1 ? (bArr[i2 + 1] << 24) >>> 16 : 0) | (i3 > 2 ? (bArr[i2 + 2] << 24) >>> 24 : 0);
        if (i3 == 1) {
            bArr2[i4] = o[i6 >>> 18];
            bArr2[i4 + 1] = o[(i6 >>> 12) & 63];
            bArr2[i4 + 2] = 61;
            bArr2[i4 + 3] = 61;
            return bArr2;
        } else if (i3 == 2) {
            bArr2[i4] = o[i6 >>> 18];
            bArr2[i4 + 1] = o[(i6 >>> 12) & 63];
            bArr2[i4 + 2] = o[(i6 >>> 6) & 63];
            bArr2[i4 + 3] = 61;
            return bArr2;
        } else if (i3 != 3) {
            return bArr2;
        } else {
            bArr2[i4] = o[i6 >>> 18];
            bArr2[i4 + 1] = o[(i6 >>> 12) & 63];
            bArr2[i4 + 2] = o[(i6 >>> 6) & 63];
            bArr2[i4 + 3] = o[i6 & 63];
            return bArr2;
        }
    }

    public static byte[] i(byte[] bArr, byte[] bArr2, int i2, int i3) {
        h(bArr2, 0, i2, bArr, 0, i3);
        return bArr;
    }

    public static String j(byte[] bArr) {
        try {
            return l(bArr, 0, bArr.length, 0);
        } catch (IOException unused) {
            return null;
        }
    }

    public static String k(byte[] bArr, int i2) throws IOException {
        return l(bArr, 0, bArr.length, i2);
    }

    public static String l(byte[] bArr, int i2, int i3, int i4) throws IOException {
        byte[] n = n(bArr, i2, i3, i4);
        try {
            return new String(n, "US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new String(n);
        }
    }

    public static byte[] m(byte[] bArr) {
        try {
            return n(bArr, 0, bArr.length, 0);
        } catch (IOException unused) {
            return null;
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
    public static byte[] n(byte[] bArr, int i2, int i3, int i4) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        a aVar;
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
                                aVar = new a(byteArrayOutputStream, i4 | 1);
                                try {
                                    gZIPOutputStream = new GZIPOutputStream(aVar);
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
                                        aVar.close();
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
                                aVar = null;
                                gZIPOutputStream = null;
                            } catch (Throwable th2) {
                                th = th2;
                                aVar = null;
                            }
                        } catch (IOException e4) {
                            e = e4;
                            aVar = null;
                            gZIPOutputStream = null;
                        } catch (Throwable th3) {
                            th = th3;
                            byteArrayOutputStream = 0;
                            aVar = null;
                        }
                        try {
                            gZIPOutputStream.write(bArr, i2, i3);
                            gZIPOutputStream.close();
                            try {
                                gZIPOutputStream.close();
                            } catch (Exception unused4) {
                            }
                            try {
                                aVar.close();
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
                                aVar.close();
                                byteArrayOutputStream.close();
                                throw th;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            gZIPOutputStream2 = gZIPOutputStream;
                            gZIPOutputStream2.close();
                            aVar.close();
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
                        h(bArr, i8 + i2, 3, bArr2, i9, i4);
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
                        h(bArr, i13 + i2, i3 - i13, bArr2, i9, i4);
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
        throw new NullPointerException("Cannot serialize a null array.");
    }

    public static final byte[] o(int i2) {
        if ((i2 & 16) == 16) {
            return f39936c;
        }
        if ((i2 & 32) == 32) {
            return f39938e;
        }
        return f39934a;
    }

    public static final byte[] p(int i2) {
        if ((i2 & 16) == 16) {
            return f39937d;
        }
        if ((i2 & 32) == 32) {
            return f39939f;
        }
        return f39935b;
    }

    /* loaded from: classes.dex */
    public static class a extends FilterOutputStream {

        /* renamed from: e  reason: collision with root package name */
        public boolean f39940e;

        /* renamed from: f  reason: collision with root package name */
        public int f39941f;

        /* renamed from: g  reason: collision with root package name */
        public byte[] f39942g;

        /* renamed from: h  reason: collision with root package name */
        public int f39943h;

        /* renamed from: i  reason: collision with root package name */
        public int f39944i;
        public boolean j;
        public byte[] k;
        public boolean l;
        public int m;
        public byte[] n;

        public a(OutputStream outputStream, int i2) {
            super(outputStream);
            this.j = (i2 & 8) != 0;
            boolean z = (i2 & 1) != 0;
            this.f39940e = z;
            int i3 = z ? 3 : 4;
            this.f39943h = i3;
            this.f39942g = new byte[i3];
            this.f39941f = 0;
            this.f39944i = 0;
            this.l = false;
            this.k = new byte[4];
            this.m = i2;
            this.n = c.p(i2);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            n();
            super.close();
            this.f39942g = null;
            ((FilterOutputStream) this).out = null;
        }

        public void n() throws IOException {
            int i2 = this.f39941f;
            if (i2 > 0) {
                if (this.f39940e) {
                    OutputStream outputStream = ((FilterOutputStream) this).out;
                    byte[] bArr = this.k;
                    c.i(bArr, this.f39942g, i2, this.m);
                    outputStream.write(bArr);
                    this.f39941f = 0;
                    return;
                }
                throw new IOException("Base64 input not properly padded.");
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i2) throws IOException {
            if (this.l) {
                ((FilterOutputStream) this).out.write(i2);
            } else if (this.f39940e) {
                byte[] bArr = this.f39942g;
                int i3 = this.f39941f;
                int i4 = i3 + 1;
                this.f39941f = i4;
                bArr[i3] = (byte) i2;
                int i5 = this.f39943h;
                if (i4 >= i5) {
                    OutputStream outputStream = ((FilterOutputStream) this).out;
                    byte[] bArr2 = this.k;
                    c.i(bArr2, bArr, i5, this.m);
                    outputStream.write(bArr2);
                    int i6 = this.f39944i + 4;
                    this.f39944i = i6;
                    if (this.j && i6 >= 76) {
                        ((FilterOutputStream) this).out.write(10);
                        this.f39944i = 0;
                    }
                    this.f39941f = 0;
                }
            } else {
                byte[] bArr3 = this.n;
                int i7 = i2 & 127;
                if (bArr3[i7] > -5) {
                    byte[] bArr4 = this.f39942g;
                    int i8 = this.f39941f;
                    int i9 = i8 + 1;
                    this.f39941f = i9;
                    bArr4[i8] = (byte) i2;
                    if (i9 >= this.f39943h) {
                        ((FilterOutputStream) this).out.write(this.k, 0, c.g(bArr4, 0, this.k, 0, this.m));
                        this.f39941f = 0;
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
