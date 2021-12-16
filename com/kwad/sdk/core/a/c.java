package com.kwad.sdk.core.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.charset.Charset;
import java.util.Arrays;
import org.aspectj.runtime.reflect.SignatureImpl;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static final Charset a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f57792b;

        /* renamed from: c  reason: collision with root package name */
        public static final int[] f57793c;

        /* renamed from: d  reason: collision with root package name */
        public static final int[] f57794d;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f57795e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f57796f;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-613023874, "Lcom/kwad/sdk/core/a/c$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-613023874, "Lcom/kwad/sdk/core/a/c$a;");
                    return;
                }
            }
            a = new a(false, false);
            f57792b = new a(true, false);
            int[] iArr = new int[256];
            f57793c = iArr;
            f57794d = new int[256];
            Arrays.fill(iArr, -1);
            for (int i2 = 0; i2 < b.f57799d.length; i2++) {
                f57793c[b.f57799d[i2]] = i2;
            }
            f57793c[61] = -2;
            Arrays.fill(f57794d, -1);
            for (int i3 = 0; i3 < b.f57800e.length; i3++) {
                f57794d[b.f57800e[i3]] = i3;
            }
            f57794d[61] = -2;
        }

        public a(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f57795e = z;
            this.f57796f = z2;
        }

        private int a(byte[] bArr, int i2, int i3) {
            InterceptResult invokeLII;
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, this, bArr, i2, i3)) == null) {
                int[] iArr = this.f57795e ? f57794d : f57793c;
                int i5 = i3 - i2;
                int i6 = 0;
                if (i5 == 0) {
                    return 0;
                }
                if (i5 < 2) {
                    if (this.f57796f && iArr[0] == -1) {
                        return 0;
                    }
                    throw new IllegalArgumentException("Input byte[] should at least have 2 bytes for base64 bytes");
                }
                if (this.f57796f) {
                    int i7 = 0;
                    while (true) {
                        if (i2 >= i3) {
                            break;
                        }
                        int i8 = i2 + 1;
                        int i9 = bArr[i2] & 255;
                        if (i9 == 61) {
                            i5 -= (i3 - i8) + 1;
                            break;
                        }
                        if (iArr[i9] == -1) {
                            i7++;
                        }
                        i2 = i8;
                    }
                    i5 -= i7;
                } else if (bArr[i3 - 1] == 61) {
                    i6 = bArr[i3 - 2] == 61 ? 2 : 1;
                }
                if (i6 == 0 && (i4 = i5 & 3) != 0) {
                    i6 = 4 - i4;
                }
                return (((i5 + 3) / 4) * 3) - i6;
            }
            return invokeLII.intValue;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:
            if (r11[r8] == 61) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0034, code lost:
            if (r4 != 18) goto L27;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private int a(byte[] bArr, int i2, int i3, byte[] bArr2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), bArr2})) == null) {
                int[] iArr = this.f57795e ? f57794d : f57793c;
                int i4 = 0;
                int i5 = 18;
                int i6 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int i7 = i2 + 1;
                    int i8 = iArr[bArr[i2] & 255];
                    if (i8 >= 0) {
                        int i9 = (i8 << i5) | i4;
                        i5 -= 6;
                        if (i5 < 0) {
                            int i10 = i6 + 1;
                            bArr2[i6] = (byte) (i9 >> 16);
                            int i11 = i10 + 1;
                            bArr2[i10] = (byte) (i9 >> 8);
                            i6 = i11 + 1;
                            bArr2[i11] = (byte) i9;
                            i4 = 0;
                            i5 = 18;
                        } else {
                            i4 = i9;
                        }
                    } else if (i8 == -2) {
                        if (i5 == 6) {
                            if (i7 != i3) {
                                i2 = i7 + 1;
                            }
                            throw new IllegalArgumentException("Input byte array has wrong 4-byte ending unit");
                        }
                        i2 = i7;
                    } else if (!this.f57796f) {
                        throw new IllegalArgumentException("Illegal base64 character " + Integer.toString(bArr[i7 - 1], 16));
                    }
                    i2 = i7;
                }
                if (i5 == 6) {
                    bArr2[i6] = (byte) (i4 >> 16);
                    i6++;
                } else if (i5 == 0) {
                    int i12 = i6 + 1;
                    bArr2[i6] = (byte) (i4 >> 16);
                    i6 = i12 + 1;
                    bArr2[i12] = (byte) (i4 >> 8);
                } else if (i5 == 12) {
                    throw new IllegalArgumentException("Last unit does not have enough valid bits");
                }
                while (i2 < i3) {
                    if (this.f57796f) {
                        int i13 = i2 + 1;
                        if (iArr[bArr[i2]] < 0) {
                            i2 = i13;
                        } else {
                            i2 = i13;
                        }
                    }
                    throw new IllegalArgumentException("Input byte array has incorrect ending byte at " + i2);
                }
                return i6;
            }
            return invokeCommon.intValue;
        }

        public byte[] a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? a(str.getBytes(c.a)) : (byte[]) invokeL.objValue;
        }

        public byte[] a(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr)) == null) {
                int a2 = a(bArr, 0, bArr.length);
                byte[] bArr2 = new byte[a2];
                int a3 = a(bArr, 0, bArr.length, bArr2);
                return a3 != a2 ? Arrays.copyOf(bArr2, a3) : bArr2;
            }
            return (byte[]) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;

        /* renamed from: b  reason: collision with root package name */
        public static final b f57797b;

        /* renamed from: c  reason: collision with root package name */
        public static final b f57798c;

        /* renamed from: d  reason: collision with root package name */
        public static final char[] f57799d;

        /* renamed from: e  reason: collision with root package name */
        public static final char[] f57800e;

        /* renamed from: f  reason: collision with root package name */
        public static final byte[] f57801f;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final byte[] f57802g;

        /* renamed from: h  reason: collision with root package name */
        public final int f57803h;

        /* renamed from: i  reason: collision with root package name */
        public final boolean f57804i;

        /* renamed from: j  reason: collision with root package name */
        public final boolean f57805j;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-613023843, "Lcom/kwad/sdk/core/a/c$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-613023843, "Lcom/kwad/sdk/core/a/c$b;");
                    return;
                }
            }
            a = new b(false, null, -1, true);
            f57797b = new b(true, null, -1, false);
            f57799d = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
            f57800e = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', SignatureImpl.SEP, '_'};
            byte[] bArr = {13, 10};
            f57801f = bArr;
            f57798c = new b(false, bArr, 76, true);
        }

        public b(boolean z, byte[] bArr, int i2, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), bArr, Integer.valueOf(i2), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f57804i = z;
            this.f57802g = bArr;
            this.f57803h = i2;
            this.f57805j = z2;
        }

        private final int a(int i2) {
            InterceptResult invokeI;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i2)) == null) {
                if (this.f57805j) {
                    i3 = ((i2 + 2) / 3) * 4;
                } else {
                    int i4 = i2 % 3;
                    i3 = ((i2 / 3) * 4) + (i4 == 0 ? 0 : i4 + 1);
                }
                int i5 = this.f57803h;
                return i5 > 0 ? i3 + (((i3 - 1) / i5) * this.f57802g.length) : i3;
            }
            return invokeI.intValue;
        }

        private int a(byte[] bArr, int i2, int i3, byte[] bArr2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), bArr2})) == null) {
                char[] cArr = this.f57804i ? f57800e : f57799d;
                int i4 = ((i3 - i2) / 3) * 3;
                int i5 = i2 + i4;
                int i6 = this.f57803h;
                if (i6 > 0 && i4 > (i6 / 4) * 3) {
                    i4 = (i6 / 4) * 3;
                }
                int i7 = 0;
                while (i2 < i5) {
                    int min = Math.min(i2 + i4, i5);
                    int i8 = i2;
                    int i9 = i7;
                    while (i8 < min) {
                        int i10 = i8 + 1;
                        int i11 = i10 + 1;
                        int i12 = ((bArr[i8] & 255) << 16) | ((bArr[i10] & 255) << 8);
                        int i13 = i11 + 1;
                        int i14 = i12 | (bArr[i11] & 255);
                        int i15 = i9 + 1;
                        bArr2[i9] = (byte) cArr[(i14 >>> 18) & 63];
                        int i16 = i15 + 1;
                        bArr2[i15] = (byte) cArr[(i14 >>> 12) & 63];
                        int i17 = i16 + 1;
                        bArr2[i16] = (byte) cArr[(i14 >>> 6) & 63];
                        i9 = i17 + 1;
                        bArr2[i17] = (byte) cArr[i14 & 63];
                        i8 = i13;
                    }
                    int i18 = ((min - i2) / 3) * 4;
                    i7 += i18;
                    if (i18 == this.f57803h && min < i3) {
                        byte[] bArr3 = this.f57802g;
                        int length = bArr3.length;
                        int i19 = 0;
                        while (i19 < length) {
                            bArr2[i7] = bArr3[i19];
                            i19++;
                            i7++;
                        }
                    }
                    i2 = min;
                }
                if (i2 < i3) {
                    int i20 = i2 + 1;
                    int i21 = bArr[i2] & 255;
                    int i22 = i7 + 1;
                    bArr2[i7] = (byte) cArr[i21 >> 2];
                    if (i20 == i3) {
                        int i23 = i22 + 1;
                        bArr2[i22] = (byte) cArr[(i21 << 4) & 63];
                        if (this.f57805j) {
                            int i24 = i23 + 1;
                            bArr2[i23] = 61;
                            int i25 = i24 + 1;
                            bArr2[i24] = 61;
                            return i25;
                        }
                        return i23;
                    }
                    int i26 = bArr[i20] & 255;
                    int i27 = i22 + 1;
                    bArr2[i22] = (byte) cArr[((i21 << 4) & 63) | (i26 >> 4)];
                    int i28 = i27 + 1;
                    bArr2[i27] = (byte) cArr[(i26 << 2) & 63];
                    if (this.f57805j) {
                        int i29 = i28 + 1;
                        bArr2[i28] = 61;
                        return i29;
                    }
                    return i28;
                }
                return i7;
            }
            return invokeCommon.intValue;
        }

        public byte[] a(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
                int a2 = a(bArr.length);
                byte[] bArr2 = new byte[a2];
                int a3 = a(bArr, 0, bArr.length, bArr2);
                return a3 != a2 ? Arrays.copyOf(bArr2, a3) : bArr2;
            }
            return (byte[]) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1889862811, "Lcom/kwad/sdk/core/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1889862811, "Lcom/kwad/sdk/core/a/c;");
                return;
            }
        }
        a = Charset.forName("ISO-8859-1");
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? b.a : (b) invokeV.objValue;
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.a : (a) invokeV.objValue;
    }
}
