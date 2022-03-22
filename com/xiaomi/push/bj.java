package com.xiaomi.push;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
/* loaded from: classes7.dex */
public class bj {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;

    /* renamed from: a  reason: collision with other field name */
    public static byte[] f137a;

    /* renamed from: a  reason: collision with other field name */
    public static char[] f138a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56378632, "Lcom/xiaomi/push/bj;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56378632, "Lcom/xiaomi/push/bj;");
                return;
            }
        }
        a = System.getProperty("line.separator");
        f138a = new char[64];
        char c2 = 'A';
        int i = 0;
        while (c2 <= 'Z') {
            f138a[i] = c2;
            c2 = (char) (c2 + 1);
            i++;
        }
        char c3 = 'a';
        while (c3 <= 'z') {
            f138a[i] = c3;
            c3 = (char) (c3 + 1);
            i++;
        }
        char c4 = '0';
        while (c4 <= '9') {
            f138a[i] = c4;
            c4 = (char) (c4 + 1);
            i++;
        }
        char[] cArr = f138a;
        cArr[i] = '+';
        cArr[i + 1] = WebvttCueParser.CHAR_SLASH;
        f137a = new byte[128];
        int i2 = 0;
        while (true) {
            byte[] bArr = f137a;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = -1;
            i2++;
        }
        for (int i3 = 0; i3 < 64; i3++) {
            f137a[f138a[i3]] = (byte) i3;
        }
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? new String(a(str.getBytes())) : (String) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m222a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? a(str.toCharArray()) : (byte[]) invokeL.objValue;
    }

    public static byte[] a(char[] cArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, cArr)) == null) ? a(cArr, 0, cArr.length) : (byte[]) invokeL.objValue;
    }

    public static byte[] a(char[] cArr, int i, int i2) {
        InterceptResult invokeLII;
        int i3;
        char c2;
        int i4;
        char c3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, cArr, i, i2)) == null) {
            if (i2 % 4 == 0) {
                while (i2 > 0 && cArr[(i + i2) - 1] == '=') {
                    i2--;
                }
                int i5 = (i2 * 3) / 4;
                byte[] bArr = new byte[i5];
                int i6 = i2 + i;
                int i7 = 0;
                while (i < i6) {
                    int i8 = i + 1;
                    char c4 = cArr[i];
                    int i9 = i8 + 1;
                    char c5 = cArr[i8];
                    if (i9 < i6) {
                        i3 = i9 + 1;
                        c2 = cArr[i9];
                    } else {
                        i3 = i9;
                        c2 = 'A';
                    }
                    if (i3 < i6) {
                        i4 = i3 + 1;
                        c3 = cArr[i3];
                    } else {
                        i4 = i3;
                        c3 = 'A';
                    }
                    if (c4 > 127 || c5 > 127 || c2 > 127 || c3 > 127) {
                        throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
                    }
                    byte[] bArr2 = f137a;
                    byte b2 = bArr2[c4];
                    byte b3 = bArr2[c5];
                    byte b4 = bArr2[c2];
                    byte b5 = bArr2[c3];
                    if (b2 < 0 || b3 < 0 || b4 < 0 || b5 < 0) {
                        throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
                    }
                    int i10 = (b2 << 2) | (b3 >>> 4);
                    int i11 = ((b3 & 15) << 4) | (b4 >>> 2);
                    int i12 = ((b4 & 3) << 6) | b5;
                    int i13 = i7 + 1;
                    bArr[i7] = (byte) i10;
                    if (i13 < i5) {
                        bArr[i13] = (byte) i11;
                        i13++;
                    }
                    if (i13 < i5) {
                        bArr[i13] = (byte) i12;
                        i7 = i13 + 1;
                    } else {
                        i7 = i13;
                    }
                    i = i4;
                }
                return bArr;
            }
            throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
        }
        return (byte[]) invokeLII.objValue;
    }

    public static char[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bArr)) == null) ? a(bArr, 0, bArr.length) : (char[]) invokeL.objValue;
    }

    public static char[] a(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65542, null, bArr, i, i2)) == null) {
            int i6 = ((i2 * 4) + 2) / 3;
            char[] cArr = new char[((i2 + 2) / 3) * 4];
            int i7 = i2 + i;
            int i8 = 0;
            while (i < i7) {
                int i9 = i + 1;
                int i10 = bArr[i] & 255;
                if (i9 < i7) {
                    i3 = i9 + 1;
                    i4 = bArr[i9] & 255;
                } else {
                    i3 = i9;
                    i4 = 0;
                }
                if (i3 < i7) {
                    i5 = bArr[i3] & 255;
                    i3++;
                } else {
                    i5 = 0;
                }
                int i11 = i10 >>> 2;
                int i12 = ((i10 & 3) << 4) | (i4 >>> 4);
                int i13 = ((i4 & 15) << 2) | (i5 >>> 6);
                int i14 = i5 & 63;
                int i15 = i8 + 1;
                char[] cArr2 = f138a;
                cArr[i8] = cArr2[i11];
                int i16 = i15 + 1;
                cArr[i15] = cArr2[i12];
                char c2 = '=';
                cArr[i16] = i16 < i6 ? cArr2[i13] : '=';
                int i17 = i16 + 1;
                if (i17 < i6) {
                    c2 = f138a[i14];
                }
                cArr[i17] = c2;
                i8 = i17 + 1;
                i = i3;
            }
            return cArr;
        }
        return (char[]) invokeLII.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? new String(m222a(str)) : (String) invokeL.objValue;
    }
}
