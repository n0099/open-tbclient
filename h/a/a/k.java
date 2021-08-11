package h.a.a;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes10.dex */
public final class k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final k[] f78071d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f78072a;

    /* renamed from: b  reason: collision with root package name */
    public final int f78073b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f78074c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1772533153, "Lh/a/a/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1772533153, "Lh/a/a/k;");
                return;
            }
        }
        f78071d = new k[]{new k("", 0, ""), new k("", 0, " "), new k(" ", 0, " "), new k("", 12, ""), new k("", 10, " "), new k("", 0, " the "), new k(" ", 0, ""), new k("s ", 0, " "), new k("", 0, " of "), new k("", 10, ""), new k("", 0, " and "), new k("", 13, ""), new k("", 1, ""), new k(StringUtil.ARRAY_ELEMENT_SEPARATOR, 0, " "), new k("", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new k(" ", 10, " "), new k("", 0, " in "), new k("", 0, " to "), new k("e ", 0, " "), new k("", 0, "\""), new k("", 0, "."), new k("", 0, "\">"), new k("", 0, StringUtils.LF), new k("", 3, ""), new k("", 0, PreferencesUtil.RIGHT_MOUNT), new k("", 0, " for "), new k("", 14, ""), new k("", 2, ""), new k("", 0, " a "), new k("", 0, " that "), new k(" ", 10, ""), new k("", 0, ". "), new k(".", 0, ""), new k(" ", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new k("", 15, ""), new k("", 0, " with "), new k("", 0, "'"), new k("", 0, " from "), new k("", 0, " by "), new k("", 16, ""), new k("", 17, ""), new k(" the ", 0, ""), new k("", 4, ""), new k("", 0, ". The "), new k("", 11, ""), new k("", 0, " on "), new k("", 0, " as "), new k("", 0, " is "), new k("", 7, ""), new k("", 1, "ing "), new k("", 0, "\n\t"), new k("", 0, ":"), new k(" ", 0, ". "), new k("", 0, "ed "), new k("", 20, ""), new k("", 18, ""), new k("", 6, ""), new k("", 0, "("), new k("", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new k("", 8, ""), new k("", 0, " at "), new k("", 0, "ly "), new k(" the ", 0, " of "), new k("", 5, ""), new k("", 9, ""), new k(" ", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new k("", 10, "\""), new k(".", 0, "("), new k("", 11, " "), new k("", 10, "\">"), new k("", 0, "=\""), new k(" ", 0, "."), new k(".com/", 0, ""), new k(" the ", 0, " of the "), new k("", 10, "'"), new k("", 0, ". This "), new k("", 0, ","), new k(".", 0, " "), new k("", 10, "("), new k("", 10, "."), new k("", 0, " not "), new k(" ", 0, "=\""), new k("", 0, "er "), new k(" ", 11, " "), new k("", 0, "al "), new k(" ", 11, ""), new k("", 0, "='"), new k("", 11, "\""), new k("", 10, ". "), new k(" ", 0, "("), new k("", 0, "ful "), new k(" ", 10, ". "), new k("", 0, "ive "), new k("", 0, "less "), new k("", 11, "'"), new k("", 0, "est "), new k(" ", 10, "."), new k("", 11, "\">"), new k(" ", 0, "='"), new k("", 10, ","), new k("", 0, "ize "), new k("", 11, "."), new k("Â ", 0, ""), new k(" ", 0, ","), new k("", 10, "=\""), new k("", 11, "=\""), new k("", 0, "ous "), new k("", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new k("", 10, "='"), new k(" ", 10, ","), new k(" ", 11, "=\""), new k(" ", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new k("", 11, ","), new k("", 11, "("), new k("", 11, ". "), new k(" ", 11, "."), new k("", 11, "='"), new k(" ", 11, ". "), new k(" ", 10, "=\""), new k(" ", 11, "='"), new k(" ", 10, "='")};
    }

    public k(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f78072a = a(str);
        this.f78073b = i2;
        this.f78074c = a(str2);
    }

    public static byte[] a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            int length = str.length();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                bArr[i2] = (byte) str.charAt(i2);
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public static int b(byte[] bArr, int i2, byte[] bArr2, int i3, int i4, k kVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{bArr, Integer.valueOf(i2), bArr2, Integer.valueOf(i3), Integer.valueOf(i4), kVar})) == null) {
            int i5 = i2;
            for (byte b2 : kVar.f78072a) {
                bArr[i5] = b2;
                i5++;
            }
            int i6 = kVar.f78073b;
            int a2 = m.a(i6);
            if (a2 > i4) {
                a2 = i4;
            }
            int i7 = i3 + a2;
            int b3 = (i4 - a2) - m.b(i6);
            int i8 = b3;
            while (i8 > 0) {
                bArr[i5] = bArr2[i7];
                i8--;
                i5++;
                i7++;
            }
            if (i6 == 11 || i6 == 10) {
                int i9 = i5 - b3;
                if (i6 == 10) {
                    b3 = 1;
                }
                while (b3 > 0) {
                    int i10 = bArr[i9] & 255;
                    if (i10 < 192) {
                        if (i10 >= 97 && i10 <= 122) {
                            bArr[i9] = (byte) (bArr[i9] ^ 32);
                        }
                        i9++;
                        b3--;
                    } else if (i10 < 224) {
                        int i11 = i9 + 1;
                        bArr[i11] = (byte) (bArr[i11] ^ 32);
                        i9 += 2;
                        b3 -= 2;
                    } else {
                        int i12 = i9 + 2;
                        bArr[i12] = (byte) (bArr[i12] ^ 5);
                        i9 += 3;
                        b3 -= 3;
                    }
                }
            }
            for (byte b4 : kVar.f78074c) {
                bArr[i5] = b4;
                i5++;
            }
            return i5 - i2;
        }
        return invokeCommon.intValue;
    }
}
