package com.repackage;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class sr9 {
    public static /* synthetic */ Interceptable $ic;
    public static final sr9[] d;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int b;
    public final byte[] c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755310793, "Lcom/repackage/sr9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755310793, "Lcom/repackage/sr9;");
                return;
            }
        }
        d = new sr9[]{new sr9("", 0, ""), new sr9("", 0, " "), new sr9(" ", 0, " "), new sr9("", 12, ""), new sr9("", 10, " "), new sr9("", 0, " the "), new sr9(" ", 0, ""), new sr9("s ", 0, " "), new sr9("", 0, " of "), new sr9("", 10, ""), new sr9("", 0, " and "), new sr9("", 13, ""), new sr9("", 1, ""), new sr9(StringUtil.ARRAY_ELEMENT_SEPARATOR, 0, " "), new sr9("", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new sr9(" ", 10, " "), new sr9("", 0, " in "), new sr9("", 0, " to "), new sr9("e ", 0, " "), new sr9("", 0, "\""), new sr9("", 0, "."), new sr9("", 0, "\">"), new sr9("", 0, "\n"), new sr9("", 3, ""), new sr9("", 0, PreferencesUtil.RIGHT_MOUNT), new sr9("", 0, " for "), new sr9("", 14, ""), new sr9("", 2, ""), new sr9("", 0, " a "), new sr9("", 0, " that "), new sr9(" ", 10, ""), new sr9("", 0, ". "), new sr9(".", 0, ""), new sr9(" ", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new sr9("", 15, ""), new sr9("", 0, " with "), new sr9("", 0, "'"), new sr9("", 0, " from "), new sr9("", 0, " by "), new sr9("", 16, ""), new sr9("", 17, ""), new sr9(" the ", 0, ""), new sr9("", 4, ""), new sr9("", 0, ". The "), new sr9("", 11, ""), new sr9("", 0, " on "), new sr9("", 0, " as "), new sr9("", 0, " is "), new sr9("", 7, ""), new sr9("", 1, "ing "), new sr9("", 0, "\n\t"), new sr9("", 0, ":"), new sr9(" ", 0, ". "), new sr9("", 0, "ed "), new sr9("", 20, ""), new sr9("", 18, ""), new sr9("", 6, ""), new sr9("", 0, "("), new sr9("", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new sr9("", 8, ""), new sr9("", 0, " at "), new sr9("", 0, "ly "), new sr9(" the ", 0, " of "), new sr9("", 5, ""), new sr9("", 9, ""), new sr9(" ", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new sr9("", 10, "\""), new sr9(".", 0, "("), new sr9("", 11, " "), new sr9("", 10, "\">"), new sr9("", 0, "=\""), new sr9(" ", 0, "."), new sr9(".com/", 0, ""), new sr9(" the ", 0, " of the "), new sr9("", 10, "'"), new sr9("", 0, ". This "), new sr9("", 0, ","), new sr9(".", 0, " "), new sr9("", 10, "("), new sr9("", 10, "."), new sr9("", 0, " not "), new sr9(" ", 0, "=\""), new sr9("", 0, "er "), new sr9(" ", 11, " "), new sr9("", 0, "al "), new sr9(" ", 11, ""), new sr9("", 0, "='"), new sr9("", 11, "\""), new sr9("", 10, ". "), new sr9(" ", 0, "("), new sr9("", 0, "ful "), new sr9(" ", 10, ". "), new sr9("", 0, "ive "), new sr9("", 0, "less "), new sr9("", 11, "'"), new sr9("", 0, "est "), new sr9(" ", 10, "."), new sr9("", 11, "\">"), new sr9(" ", 0, "='"), new sr9("", 10, ","), new sr9("", 0, "ize "), new sr9("", 11, "."), new sr9("Â ", 0, ""), new sr9(" ", 0, ","), new sr9("", 10, "=\""), new sr9("", 11, "=\""), new sr9("", 0, "ous "), new sr9("", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new sr9("", 10, "='"), new sr9(" ", 10, ","), new sr9(" ", 11, "=\""), new sr9(" ", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new sr9("", 11, ","), new sr9("", 11, "("), new sr9("", 11, ". "), new sr9(" ", 11, "."), new sr9("", 11, "='"), new sr9(" ", 11, ". "), new sr9(" ", 10, "=\""), new sr9(" ", 11, "='"), new sr9(" ", 10, "='")};
    }

    public sr9(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = a(str);
        this.b = i;
        this.c = a(str2);
    }

    public static byte[] a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            int length = str.length();
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                bArr[i] = (byte) str.charAt(i);
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public static int b(byte[] bArr, int i, byte[] bArr2, int i2, int i3, sr9 sr9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{bArr, Integer.valueOf(i), bArr2, Integer.valueOf(i2), Integer.valueOf(i3), sr9Var})) == null) {
            int i4 = i;
            for (byte b : sr9Var.a) {
                bArr[i4] = b;
                i4++;
            }
            int i5 = sr9Var.b;
            int a = ur9.a(i5);
            if (a > i3) {
                a = i3;
            }
            int i6 = i2 + a;
            int b2 = (i3 - a) - ur9.b(i5);
            int i7 = b2;
            while (i7 > 0) {
                bArr[i4] = bArr2[i6];
                i7--;
                i4++;
                i6++;
            }
            if (i5 == 11 || i5 == 10) {
                int i8 = i4 - b2;
                if (i5 == 10) {
                    b2 = 1;
                }
                while (b2 > 0) {
                    int i9 = bArr[i8] & 255;
                    if (i9 < 192) {
                        if (i9 >= 97 && i9 <= 122) {
                            bArr[i8] = (byte) (bArr[i8] ^ 32);
                        }
                        i8++;
                        b2--;
                    } else if (i9 < 224) {
                        int i10 = i8 + 1;
                        bArr[i10] = (byte) (bArr[i10] ^ 32);
                        i8 += 2;
                        b2 -= 2;
                    } else {
                        int i11 = i8 + 2;
                        bArr[i11] = (byte) (bArr[i11] ^ 5);
                        i8 += 3;
                        b2 -= 3;
                    }
                }
            }
            for (byte b3 : sr9Var.c) {
                bArr[i4] = b3;
                i4++;
            }
            return i4 - i;
        }
        return invokeCommon.intValue;
    }
}
