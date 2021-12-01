package h.b.k;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.Base64;
import com.baidu.webkit.internal.utils.UtilsBlink;
import com.kwad.yoga.YogaNodeJNIBase;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPOutputStream;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] a;

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f63547b;

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f63548c;

    /* renamed from: d  reason: collision with root package name */
    public static final byte[] f63549d;

    /* renamed from: e  reason: collision with root package name */
    public static final byte[] f63550e;

    /* renamed from: f  reason: collision with root package name */
    public static final byte[] f63551f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1743606402, "Lh/b/k/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1743606402, "Lh/b/k/a;");
                return;
            }
        }
        a = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        f63547b = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, StandardMessageCodec.LIST, 13, 14, 15, YogaNodeJNIBase.HAS_NEW_LAYOUT, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, PublicSuffixDatabase.EXCEPTION_MARKER, 34, Base64.INTERNAL_PADDING, 36, 37, 38, 39, 40, 41, 42, 43, 44, UtilsBlink.VER_TYPE_SEPARATOR, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
        f63548c = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, UtilsBlink.VER_TYPE_SEPARATOR, 95};
        f63549d = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, StandardMessageCodec.LIST, 13, 14, 15, YogaNodeJNIBase.HAS_NEW_LAYOUT, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, PublicSuffixDatabase.EXCEPTION_MARKER, 34, Base64.INTERNAL_PADDING, 36, 37, 38, 39, 40, 41, 42, 43, 44, UtilsBlink.VER_TYPE_SEPARATOR, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
        f63550e = new byte[]{UtilsBlink.VER_TYPE_SEPARATOR, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122};
        f63551f = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, StandardMessageCodec.LIST, 13, 14, 15, YogaNodeJNIBase.HAS_NEW_LAYOUT, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, PublicSuffixDatabase.EXCEPTION_MARKER, 34, Base64.INTERNAL_PADDING, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, UtilsBlink.VER_TYPE_SEPARATOR, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    }

    public static int d(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        InterceptResult invokeCommon;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{bArr, Integer.valueOf(i2), bArr2, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (bArr != null) {
                if (bArr2 != null) {
                    if (i2 >= 0 && (i5 = i2 + 3) < bArr.length) {
                        if (i3 >= 0 && (i6 = i3 + 2) < bArr2.length) {
                            byte[] k2 = k(i4);
                            int i7 = i2 + 2;
                            if (bArr[i7] == 61) {
                                bArr2[i3] = (byte) ((((k2[bArr[i2 + 1]] & 255) << 12) | ((k2[bArr[i2]] & 255) << 18)) >>> 16);
                                return 1;
                            } else if (bArr[i5] == 61) {
                                int i8 = ((k2[bArr[i7]] & 255) << 6) | ((k2[bArr[i2 + 1]] & 255) << 12) | ((k2[bArr[i2]] & 255) << 18);
                                bArr2[i3] = (byte) (i8 >>> 16);
                                bArr2[i3 + 1] = (byte) (i8 >>> 8);
                                return 2;
                            } else {
                                int i9 = (k2[bArr[i5]] & 255) | ((k2[bArr[i2 + 1]] & 255) << 12) | ((k2[bArr[i2]] & 255) << 18) | ((k2[bArr[i7]] & 255) << 6);
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
        return invokeCommon.intValue;
    }

    public static byte[] e(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), bArr2, Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            byte[] j2 = j(i5);
            int i6 = (i3 > 0 ? (bArr[i2] << 24) >>> 8 : 0) | (i3 > 1 ? (bArr[i2 + 1] << 24) >>> 16 : 0) | (i3 > 2 ? (bArr[i2 + 2] << 24) >>> 24 : 0);
            if (i3 == 1) {
                bArr2[i4] = j2[i6 >>> 18];
                bArr2[i4 + 1] = j2[(i6 >>> 12) & 63];
                bArr2[i4 + 2] = 61;
                bArr2[i4 + 3] = 61;
                return bArr2;
            } else if (i3 == 2) {
                bArr2[i4] = j2[i6 >>> 18];
                bArr2[i4 + 1] = j2[(i6 >>> 12) & 63];
                bArr2[i4 + 2] = j2[(i6 >>> 6) & 63];
                bArr2[i4 + 3] = 61;
                return bArr2;
            } else if (i3 != 3) {
                return bArr2;
            } else {
                bArr2[i4] = j2[i6 >>> 18];
                bArr2[i4 + 1] = j2[(i6 >>> 12) & 63];
                bArr2[i4 + 2] = j2[(i6 >>> 6) & 63];
                bArr2[i4 + 3] = j2[i6 & 63];
                return bArr2;
            }
        }
        return (byte[]) invokeCommon.objValue;
    }

    public static byte[] f(byte[] bArr, byte[] bArr2, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65542, null, bArr, bArr2, i2, i3)) == null) {
            e(bArr2, 0, i2, bArr, 0, i3);
            return bArr;
        }
        return (byte[]) invokeLLII.objValue;
    }

    public static String g(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bArr)) == null) {
            try {
                return h(bArr, 0, bArr.length, 0);
            } catch (IOException unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String h(byte[] bArr, int i2, int i3, int i4) throws IOException {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65544, null, bArr, i2, i3, i4)) == null) {
            byte[] i5 = i(bArr, i2, i3, i4);
            try {
                return new String(i5, "US-ASCII");
            } catch (UnsupportedEncodingException unused) {
                return new String(i5);
            }
        }
        return (String) invokeLIII.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x0040 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x0044 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v16, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v17, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v18, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v19, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v20, resolved type: java.io.ByteArrayOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    public static byte[] i(byte[] bArr, int i2, int i3, int i4) throws IOException {
        InterceptResult invokeLIII;
        ByteArrayOutputStream byteArrayOutputStream;
        C2188a c2188a;
        GZIPOutputStream gZIPOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLIII = interceptable.invokeLIII(65545, null, bArr, i2, i3, i4)) != null) {
            return (byte[]) invokeLIII.objValue;
        }
        if (bArr == null) {
            throw new IllegalArgumentException("Cannot serialize a null array.");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Cannot have negative offset: " + i2);
        } else if (i3 >= 0) {
            if (i2 + i3 > bArr.length) {
                throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(bArr.length)));
            }
            if ((i4 & 2) != 0) {
                GZIPOutputStream gZIPOutputStream2 = null;
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        c2188a = new C2188a(byteArrayOutputStream, i4 | 1);
                        try {
                            gZIPOutputStream = new GZIPOutputStream(c2188a);
                            try {
                                gZIPOutputStream.write(bArr, i2, i3);
                                gZIPOutputStream.close();
                                try {
                                    gZIPOutputStream.close();
                                } catch (Exception unused) {
                                }
                                try {
                                    c2188a.close();
                                } catch (Exception unused2) {
                                }
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Exception unused3) {
                                }
                                return byteArrayOutputStream.toByteArray();
                            } catch (IOException e2) {
                                e = e2;
                                gZIPOutputStream2 = byteArrayOutputStream;
                                try {
                                    throw e;
                                } catch (Throwable th) {
                                    th = th;
                                    byteArrayOutputStream = gZIPOutputStream2;
                                    gZIPOutputStream2 = gZIPOutputStream;
                                    try {
                                        gZIPOutputStream2.close();
                                    } catch (Exception unused4) {
                                    }
                                    try {
                                        c2188a.close();
                                    } catch (Exception unused5) {
                                    }
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Exception unused6) {
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                gZIPOutputStream2 = gZIPOutputStream;
                                gZIPOutputStream2.close();
                                c2188a.close();
                                byteArrayOutputStream.close();
                                throw th;
                            }
                        } catch (IOException e3) {
                            e = e3;
                            gZIPOutputStream = null;
                        } catch (Throwable th3) {
                            th = th3;
                            gZIPOutputStream2.close();
                            c2188a.close();
                            byteArrayOutputStream.close();
                            throw th;
                        }
                    } catch (IOException e4) {
                        e = e4;
                        c2188a = null;
                        gZIPOutputStream = null;
                    } catch (Throwable th4) {
                        th = th4;
                        c2188a = null;
                    }
                } catch (IOException e5) {
                    e = e5;
                    c2188a = null;
                    gZIPOutputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    byteArrayOutputStream = 0;
                    c2188a = null;
                }
            } else {
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
        } else {
            throw new IllegalArgumentException("Cannot have length offset: " + i3);
        }
    }

    public static final byte[] j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i2)) == null) {
            if ((i2 & 16) == 16) {
                return f63548c;
            }
            if ((i2 & 32) == 32) {
                return f63550e;
            }
            return a;
        }
        return (byte[]) invokeI.objValue;
    }

    public static final byte[] k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i2)) == null) {
            if ((i2 & 16) == 16) {
                return f63549d;
            }
            if ((i2 & 32) == 32) {
                return f63551f;
            }
            return f63547b;
        }
        return (byte[]) invokeI.objValue;
    }

    /* renamed from: h.b.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C2188a extends FilterOutputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f63552e;

        /* renamed from: f  reason: collision with root package name */
        public int f63553f;

        /* renamed from: g  reason: collision with root package name */
        public byte[] f63554g;

        /* renamed from: h  reason: collision with root package name */
        public int f63555h;

        /* renamed from: i  reason: collision with root package name */
        public int f63556i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f63557j;

        /* renamed from: k  reason: collision with root package name */
        public byte[] f63558k;
        public boolean l;
        public int m;
        public byte[] n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C2188a(OutputStream outputStream, int i2) {
            super(outputStream);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {outputStream, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super((OutputStream) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63557j = (i2 & 8) != 0;
            boolean z = (i2 & 1) != 0;
            this.f63552e = z;
            int i5 = z ? 3 : 4;
            this.f63555h = i5;
            this.f63554g = new byte[i5];
            this.f63553f = 0;
            this.f63556i = 0;
            this.l = false;
            this.f63558k = new byte[4];
            this.m = i2;
            this.n = a.k(i2);
        }

        public void a() throws IOException {
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (i2 = this.f63553f) <= 0) {
                return;
            }
            if (this.f63552e) {
                OutputStream outputStream = ((FilterOutputStream) this).out;
                byte[] bArr = this.f63558k;
                a.f(bArr, this.f63554g, i2, this.m);
                outputStream.write(bArr);
                this.f63553f = 0;
                return;
            }
            throw new IOException("Base64 input not properly padded.");
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                a();
                super.close();
                this.f63554g = null;
                ((FilterOutputStream) this).out = null;
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                if (this.l) {
                    ((FilterOutputStream) this).out.write(i2);
                } else if (this.f63552e) {
                    byte[] bArr = this.f63554g;
                    int i3 = this.f63553f;
                    int i4 = i3 + 1;
                    this.f63553f = i4;
                    bArr[i3] = (byte) i2;
                    int i5 = this.f63555h;
                    if (i4 >= i5) {
                        OutputStream outputStream = ((FilterOutputStream) this).out;
                        byte[] bArr2 = this.f63558k;
                        a.f(bArr2, bArr, i5, this.m);
                        outputStream.write(bArr2);
                        int i6 = this.f63556i + 4;
                        this.f63556i = i6;
                        if (this.f63557j && i6 >= 76) {
                            ((FilterOutputStream) this).out.write(10);
                            this.f63556i = 0;
                        }
                        this.f63553f = 0;
                    }
                } else {
                    byte[] bArr3 = this.n;
                    int i7 = i2 & 127;
                    if (bArr3[i7] > -5) {
                        byte[] bArr4 = this.f63554g;
                        int i8 = this.f63553f;
                        int i9 = i8 + 1;
                        this.f63553f = i9;
                        bArr4[i8] = (byte) i2;
                        if (i9 >= this.f63555h) {
                            ((FilterOutputStream) this).out.write(this.f63558k, 0, a.d(bArr4, 0, this.f63558k, 0, this.m));
                            this.f63553f = 0;
                        }
                    } else if (bArr3[i7] != -5) {
                        throw new IOException("Invalid character in Base64 data.");
                    }
                }
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i2, int i3) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048579, this, bArr, i2, i3) == null) {
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
}
