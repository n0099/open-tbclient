package com.duxiaoman.okhttp3.internal.publicsuffix;

import c.d.b.e0.e;
import c.d.b.e0.m.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
/* loaded from: classes9.dex */
public final class PublicSuffixDatabase {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final byte[] f69563e;

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f69564f;

    /* renamed from: g  reason: collision with root package name */
    public static final String[] f69565g;

    /* renamed from: h  reason: collision with root package name */
    public static final PublicSuffixDatabase f69566h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f69567a;

    /* renamed from: b  reason: collision with root package name */
    public final CountDownLatch f69568b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f69569c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f69570d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1794866564, "Lcom/duxiaoman/okhttp3/internal/publicsuffix/PublicSuffixDatabase;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1794866564, "Lcom/duxiaoman/okhttp3/internal/publicsuffix/PublicSuffixDatabase;");
                return;
            }
        }
        f69563e = new byte[]{42};
        f69564f = new String[0];
        f69565g = new String[]{"*"};
        f69566h = new PublicSuffixDatabase();
    }

    public PublicSuffixDatabase() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f69567a = new AtomicBoolean(false);
        this.f69568b = new CountDownLatch(1);
    }

    public static String a(byte[] bArr, byte[][] bArr2, int i2) {
        InterceptResult invokeLLI;
        int i3;
        boolean z;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, bArr, bArr2, i2)) == null) {
            int length = bArr.length;
            int i6 = 0;
            while (i6 < length) {
                int i7 = (i6 + length) / 2;
                while (i7 > -1 && bArr[i7] != 10) {
                    i7--;
                }
                int i8 = i7 + 1;
                int i9 = 1;
                while (true) {
                    i3 = i8 + i9;
                    if (bArr[i3] == 10) {
                        break;
                    }
                    i9++;
                }
                int i10 = i3 - i8;
                int i11 = i2;
                boolean z2 = false;
                int i12 = 0;
                int i13 = 0;
                while (true) {
                    if (z2) {
                        i4 = 46;
                        z = false;
                    } else {
                        z = z2;
                        i4 = bArr2[i11][i12] & 255;
                    }
                    i5 = i4 - (bArr[i8 + i13] & 255);
                    if (i5 == 0) {
                        i13++;
                        i12++;
                        if (i13 == i10) {
                            break;
                        } else if (bArr2[i11].length != i12) {
                            z2 = z;
                        } else if (i11 == bArr2.length - 1) {
                            break;
                        } else {
                            i11++;
                            z2 = true;
                            i12 = -1;
                        }
                    } else {
                        break;
                    }
                }
                if (i5 >= 0) {
                    if (i5 <= 0) {
                        int i14 = i10 - i13;
                        int length2 = bArr2[i11].length - i12;
                        while (true) {
                            i11++;
                            if (i11 >= bArr2.length) {
                                break;
                            }
                            length2 += bArr2[i11].length;
                        }
                        if (length2 >= i14) {
                            if (length2 <= i14) {
                                return new String(bArr, i8, i10, e.f31785d);
                            }
                        }
                    }
                    i6 = i3 + 1;
                }
                length = i8 - 1;
            }
            return null;
        }
        return (String) invokeLLI.objValue;
    }

    public static PublicSuffixDatabase c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f69566h : (PublicSuffixDatabase) invokeV.objValue;
    }

    public final String[] b(String[] strArr) {
        InterceptResult invokeL;
        String str;
        String str2;
        String str3;
        String[] strArr2;
        String[] strArr3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
            int i2 = 0;
            if (!this.f69567a.get() && this.f69567a.compareAndSet(false, true)) {
                f();
            } else {
                try {
                    this.f69568b.await();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
            synchronized (this) {
                if (this.f69569c == null) {
                    throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
                }
            }
            int length = strArr.length;
            byte[][] bArr = new byte[length];
            for (int i3 = 0; i3 < strArr.length; i3++) {
                bArr[i3] = strArr[i3].getBytes(e.f31785d);
            }
            int i4 = 0;
            while (true) {
                str = null;
                if (i4 >= length) {
                    str2 = null;
                    break;
                }
                str2 = a(this.f69569c, bArr, i4);
                if (str2 != null) {
                    break;
                }
                i4++;
            }
            if (length > 1) {
                byte[][] bArr2 = (byte[][]) bArr.clone();
                for (int i5 = 0; i5 < bArr2.length - 1; i5++) {
                    bArr2[i5] = f69563e;
                    str3 = a(this.f69569c, bArr2, i5);
                    if (str3 != null) {
                        break;
                    }
                }
            }
            str3 = null;
            if (str3 != null) {
                while (true) {
                    if (i2 >= length - 1) {
                        break;
                    }
                    String a2 = a(this.f69570d, bArr, i2);
                    if (a2 != null) {
                        str = a2;
                        break;
                    }
                    i2++;
                }
            }
            if (str != null) {
                return ("!" + str).split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
            } else if (str2 == null && str3 == null) {
                return f69565g;
            } else {
                if (str2 != null) {
                    strArr2 = str2.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                } else {
                    strArr2 = f69564f;
                }
                if (str3 != null) {
                    strArr3 = str3.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                } else {
                    strArr3 = f69564f;
                }
                return strArr2.length > strArr3.length ? strArr2 : strArr3;
            }
        }
        return (String[]) invokeL.objValue;
    }

    public String d(String str) {
        InterceptResult invokeL;
        int length;
        int length2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (str != null) {
                String[] split = IDN.toUnicode(str).split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                String[] b2 = b(split);
                if (split.length != b2.length || b2[0].charAt(0) == '!') {
                    if (b2[0].charAt(0) == '!') {
                        length = split.length;
                        length2 = b2.length;
                    } else {
                        length = split.length;
                        length2 = b2.length + 1;
                    }
                    StringBuilder sb = new StringBuilder();
                    String[] split2 = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                    for (int i2 = length - length2; i2 < split2.length; i2++) {
                        sb.append(split2[i2]);
                        sb.append('.');
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    return sb.toString();
                }
                return null;
            }
            throw new NullPointerException("domain == null");
        }
        return (String) invokeL.objValue;
    }

    public final void e() throws IOException {
        InputStream resourceAsStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream(okhttp3.internal.publicsuffix.PublicSuffixDatabase.PUBLIC_SUFFIX_RESOURCE)) == null) {
            return;
        }
        BufferedSource buffer = Okio.buffer(new GzipSource(Okio.source(resourceAsStream)));
        try {
            byte[] bArr = new byte[buffer.readInt()];
            buffer.readFully(bArr);
            byte[] bArr2 = new byte[buffer.readInt()];
            buffer.readFully(bArr2);
            synchronized (this) {
                this.f69569c = bArr;
                this.f69570d = bArr2;
            }
            this.f69568b.countDown();
        } finally {
            e.f(buffer);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            boolean z = false;
            while (true) {
                try {
                    try {
                        try {
                            e();
                            break;
                        } catch (IOException e2) {
                            g.m().u(5, "Failed to read public suffix list", e2);
                            if (z) {
                                Thread.currentThread().interrupt();
                                return;
                            }
                            return;
                        }
                    } catch (InterruptedIOException unused) {
                        Thread.interrupted();
                        z = true;
                    }
                } catch (Throwable th) {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
