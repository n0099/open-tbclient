package com.google.zxing.client.result;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public final class VINResultParser extends ResultParser {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern AZ09;
    public static final Pattern IOQ;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1660721511, "Lcom/google/zxing/client/result/VINResultParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1660721511, "Lcom/google/zxing/client/result/VINResultParser;");
                return;
            }
        }
        IOQ = Pattern.compile("[IOQ]");
        AZ09 = Pattern.compile("[A-Z0-9]{17}");
    }

    public VINResultParser() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static char checkChar(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if (i < 10) {
                return (char) (i + 48);
            }
            if (i == 10) {
                return 'X';
            }
            throw new IllegalArgumentException();
        }
        return invokeI.charValue;
    }

    public static boolean checkChecksum(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, charSequence)) == null) {
            int i = 0;
            int i2 = 0;
            while (i < charSequence.length()) {
                int i3 = i + 1;
                i2 += vinPositionWeight(i3) * vinCharValue(charSequence.charAt(i));
                i = i3;
            }
            if (charSequence.charAt(8) != checkChar(i2 % 11)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static int vinPositionWeight(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i)) == null) {
            if (i > 0 && i <= 7) {
                return 9 - i;
            }
            if (i == 8) {
                return 10;
            }
            if (i == 9) {
                return 0;
            }
            if (i >= 10 && i <= 17) {
                return 19 - i;
            }
            throw new IllegalArgumentException();
        }
        return invokeI.intValue;
    }

    public static String countryCode(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, charSequence)) == null) {
            char charAt = charSequence.charAt(0);
            char charAt2 = charSequence.charAt(1);
            if (charAt != '9') {
                if (charAt != 'S') {
                    if (charAt != 'Z') {
                        switch (charAt) {
                            case '1':
                            case '4':
                            case '5':
                                return "US";
                            case '2':
                                return "CA";
                            case '3':
                                if (charAt2 >= 'A' && charAt2 <= 'W') {
                                    return "MX";
                                }
                                return null;
                            default:
                                switch (charAt) {
                                    case 'J':
                                        if (charAt2 >= 'A' && charAt2 <= 'T') {
                                            return "JP";
                                        }
                                        return null;
                                    case 'K':
                                        if (charAt2 >= 'L' && charAt2 <= 'R') {
                                            return "KO";
                                        }
                                        return null;
                                    case 'L':
                                        return "CN";
                                    case 'M':
                                        if (charAt2 >= 'A' && charAt2 <= 'E') {
                                            return "IN";
                                        }
                                        return null;
                                    default:
                                        switch (charAt) {
                                            case 'V':
                                                if (charAt2 >= 'F' && charAt2 <= 'R') {
                                                    return "FR";
                                                }
                                                if (charAt2 >= 'S' && charAt2 <= 'W') {
                                                    return "ES";
                                                }
                                                return null;
                                            case 'W':
                                                return "DE";
                                            case 'X':
                                                if (charAt2 != '0') {
                                                    if (charAt2 >= '3' && charAt2 <= '9') {
                                                        return "RU";
                                                    }
                                                    return null;
                                                }
                                                return "RU";
                                            default:
                                                return null;
                                        }
                                }
                        }
                    } else if (charAt2 >= 'A' && charAt2 <= 'R') {
                        return "IT";
                    } else {
                        return null;
                    }
                } else if (charAt2 >= 'A' && charAt2 <= 'M') {
                    return "UK";
                } else {
                    if (charAt2 >= 'N' && charAt2 <= 'T') {
                        return "DE";
                    }
                    return null;
                }
            } else if (charAt2 < 'A' || charAt2 > 'E') {
                if (charAt2 >= '3' && charAt2 <= '9') {
                    return "BR";
                }
                return null;
            } else {
                return "BR";
            }
        }
        return (String) invokeL.objValue;
    }

    public static int modelYear(char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Character.valueOf(c)})) == null) {
            if (c >= 'E' && c <= 'H') {
                return (c - 'E') + 1984;
            }
            if (c >= 'J' && c <= 'N') {
                return (c - 'J') + 1988;
            }
            if (c == 'P') {
                return 1993;
            }
            if (c >= 'R' && c <= 'T') {
                return (c - 'R') + 1994;
            }
            if (c >= 'V' && c <= 'Y') {
                return (c - 'V') + 1997;
            }
            if (c >= '1' && c <= '9') {
                return (c - '1') + 2001;
            }
            if (c >= 'A' && c <= 'D') {
                return (c - 'A') + 2010;
            }
            throw new IllegalArgumentException();
        }
        return invokeCommon.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.zxing.client.result.ResultParser
    public VINParsedResult parse(Result result) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, result)) == null) {
            if (result.getBarcodeFormat() != BarcodeFormat.CODE_39) {
                return null;
            }
            String trim = IOQ.matcher(result.getText()).replaceAll("").trim();
            if (!AZ09.matcher(trim).matches()) {
                return null;
            }
            try {
                if (!checkChecksum(trim)) {
                    return null;
                }
                String substring = trim.substring(0, 3);
                return new VINParsedResult(trim, substring, trim.substring(3, 9), trim.substring(9, 17), countryCode(substring), trim.substring(3, 8), modelYear(trim.charAt(9)), trim.charAt(10), trim.substring(11));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        return (VINParsedResult) invokeL.objValue;
    }

    public static int vinCharValue(char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Character.valueOf(c)})) == null) {
            if (c >= 'A' && c <= 'I') {
                return (c - 'A') + 1;
            }
            if (c >= 'J' && c <= 'R') {
                return (c - 'J') + 1;
            }
            if (c >= 'S' && c <= 'Z') {
                return (c - 'S') + 2;
            }
            if (c >= '0' && c <= '9') {
                return c - '0';
            }
            throw new IllegalArgumentException();
        }
        return invokeCommon.intValue;
    }
}
