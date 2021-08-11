package com.google.gson.internal.bind.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import org.aspectj.runtime.reflect.SignatureImpl;
/* loaded from: classes10.dex */
public class ISO8601Utils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final TimeZone TIMEZONE_UTC;
    public static final String UTC_ID = "UTC";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(268662057, "Lcom/google/gson/internal/bind/util/ISO8601Utils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(268662057, "Lcom/google/gson/internal/bind/util/ISO8601Utils;");
                return;
            }
        }
        TIMEZONE_UTC = TimeZone.getTimeZone("UTC");
    }

    public ISO8601Utils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean checkOffset(String str, int i2, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i2), Character.valueOf(c2)})) == null) ? i2 < str.length() && str.charAt(i2) == c2 : invokeCommon.booleanValue;
    }

    public static String format(Date date) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, date)) == null) ? format(date, false, TIMEZONE_UTC) : (String) invokeL.objValue;
    }

    public static int indexOfNonDigit(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.BAIDU_LOGO_ID, null, str, i2)) == null) {
            while (i2 < str.length()) {
                char charAt = str.charAt(i2);
                if (charAt < '0' || charAt > '9') {
                    return i2;
                }
                i2++;
            }
            return str.length();
        }
        return invokeLI.intValue;
    }

    public static void padInt(StringBuilder sb, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65543, null, sb, i2, i3) == null) {
            String num = Integer.toString(i2);
            for (int length = i3 - num.length(); length > 0; length--) {
                sb.append('0');
            }
            sb.append(num);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00d3 A[Catch: IllegalArgumentException -> 0x01c0, NumberFormatException -> 0x01c2, IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01c4, TryCatch #2 {IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01c4, blocks: (B:5:0x0008, B:7:0x001a, B:8:0x001c, B:10:0x0028, B:11:0x002a, B:13:0x0039, B:15:0x003f, B:19:0x0054, B:21:0x0064, B:22:0x0066, B:24:0x0072, B:25:0x0074, B:27:0x007a, B:31:0x0084, B:36:0x0094, B:38:0x009c, B:49:0x00cd, B:51:0x00d3, B:53:0x00da, B:77:0x0187, B:57:0x00e4, B:58:0x00ff, B:59:0x0100, B:63:0x011c, B:65:0x0129, B:68:0x0132, B:70:0x0151, B:73:0x0160, B:74:0x0182, B:76:0x0185, B:62:0x010b, B:79:0x01b8, B:80:0x01bf, B:42:0x00b4, B:43:0x00b7), top: B:100:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01b8 A[Catch: IllegalArgumentException -> 0x01c0, NumberFormatException -> 0x01c2, IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01c4, TryCatch #2 {IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01c4, blocks: (B:5:0x0008, B:7:0x001a, B:8:0x001c, B:10:0x0028, B:11:0x002a, B:13:0x0039, B:15:0x003f, B:19:0x0054, B:21:0x0064, B:22:0x0066, B:24:0x0072, B:25:0x0074, B:27:0x007a, B:31:0x0084, B:36:0x0094, B:38:0x009c, B:49:0x00cd, B:51:0x00d3, B:53:0x00da, B:77:0x0187, B:57:0x00e4, B:58:0x00ff, B:59:0x0100, B:63:0x011c, B:65:0x0129, B:68:0x0132, B:70:0x0151, B:73:0x0160, B:74:0x0182, B:76:0x0185, B:62:0x010b, B:79:0x01b8, B:80:0x01bf, B:42:0x00b4, B:43:0x00b7), top: B:100:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Date parse(String str, ParsePosition parsePosition) throws ParseException {
        InterceptResult invokeLL;
        String str2;
        int i2;
        int i3;
        int i4;
        int i5;
        int length;
        TimeZone timeZone;
        char charAt;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65544, null, str, parsePosition)) != null) {
            return (Date) invokeLL.objValue;
        }
        try {
            int index = parsePosition.getIndex();
            int i6 = index + 4;
            int parseInt = parseInt(str, index, i6);
            if (checkOffset(str, i6, SignatureImpl.SEP)) {
                i6++;
            }
            int i7 = i6 + 2;
            int parseInt2 = parseInt(str, i6, i7);
            if (checkOffset(str, i7, SignatureImpl.SEP)) {
                i7++;
            }
            int i8 = i7 + 2;
            int parseInt3 = parseInt(str, i7, i8);
            boolean checkOffset = checkOffset(str, i8, 'T');
            if (!checkOffset && str.length() <= i8) {
                GregorianCalendar gregorianCalendar = new GregorianCalendar(parseInt, parseInt2 - 1, parseInt3);
                parsePosition.setIndex(i8);
                return gregorianCalendar.getTime();
            }
            if (checkOffset) {
                int i9 = i8 + 1;
                int i10 = i9 + 2;
                int parseInt4 = parseInt(str, i9, i10);
                if (checkOffset(str, i10, ':')) {
                    i10++;
                }
                int i11 = i10 + 2;
                int parseInt5 = parseInt(str, i10, i11);
                if (checkOffset(str, i11, ':')) {
                    i11++;
                }
                if (str.length() > i11 && (charAt = str.charAt(i11)) != 'Z' && charAt != '+' && charAt != '-') {
                    int i12 = i11 + 2;
                    i5 = parseInt(str, i11, i12);
                    if (i5 > 59 && i5 < 63) {
                        i5 = 59;
                    }
                    if (checkOffset(str, i12, '.')) {
                        int i13 = i12 + 1;
                        int indexOfNonDigit = indexOfNonDigit(str, i13 + 1);
                        int min = Math.min(indexOfNonDigit, i13 + 3);
                        int parseInt6 = parseInt(str, i13, min);
                        int i14 = min - i13;
                        if (i14 == 1) {
                            parseInt6 *= 100;
                        } else if (i14 == 2) {
                            parseInt6 *= 10;
                        }
                        i3 = parseInt5;
                        i4 = parseInt6;
                        i2 = parseInt4;
                        i8 = indexOfNonDigit;
                    } else {
                        i3 = parseInt5;
                        i2 = parseInt4;
                        i8 = i12;
                        i4 = 0;
                    }
                    if (str.length() <= i8) {
                        char charAt2 = str.charAt(i8);
                        if (charAt2 == 'Z') {
                            timeZone = TIMEZONE_UTC;
                            length = i8 + 1;
                        } else {
                            if (charAt2 != '+' && charAt2 != '-') {
                                throw new IndexOutOfBoundsException("Invalid time zone indicator '" + charAt2 + "'");
                            }
                            String substring = str.substring(i8);
                            if (substring.length() < 5) {
                                substring = substring + "00";
                            }
                            length = i8 + substring.length();
                            if (!"+0000".equals(substring) && !"+00:00".equals(substring)) {
                                String str3 = "GMT" + substring;
                                TimeZone timeZone2 = TimeZone.getTimeZone(str3);
                                String id = timeZone2.getID();
                                if (!id.equals(str3) && !id.replace(":", "").equals(str3)) {
                                    throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + str3 + " given, resolves to " + timeZone2.getID());
                                }
                                timeZone = timeZone2;
                            }
                            timeZone = TIMEZONE_UTC;
                        }
                        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(timeZone);
                        gregorianCalendar2.setLenient(false);
                        gregorianCalendar2.set(1, parseInt);
                        gregorianCalendar2.set(2, parseInt2 - 1);
                        gregorianCalendar2.set(5, parseInt3);
                        gregorianCalendar2.set(11, i2);
                        gregorianCalendar2.set(12, i3);
                        gregorianCalendar2.set(13, i5);
                        gregorianCalendar2.set(14, i4);
                        parsePosition.setIndex(length);
                        return gregorianCalendar2.getTime();
                    }
                    throw new IllegalArgumentException("No time zone indicator");
                }
                i3 = parseInt5;
                i4 = 0;
                i2 = parseInt4;
                i8 = i11;
            } else {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            }
            i5 = 0;
            if (str.length() <= i8) {
            }
        } catch (IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException e2) {
            if (str == null) {
                str2 = null;
            } else {
                str2 = '\"' + str + '\"';
            }
            String message = e2.getMessage();
            if (message == null || message.isEmpty()) {
                message = "(" + e2.getClass().getName() + SmallTailInfo.EMOTION_SUFFIX;
            }
            ParseException parseException = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException.initCause(e2);
            throw parseException;
        }
    }

    public static int parseInt(String str, int i2, int i3) throws NumberFormatException {
        InterceptResult invokeLII;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65545, null, str, i2, i3)) == null) {
            if (i2 < 0 || i3 > str.length() || i2 > i3) {
                throw new NumberFormatException(str);
            }
            if (i2 < i3) {
                i4 = i2 + 1;
                int digit = Character.digit(str.charAt(i2), 10);
                if (digit < 0) {
                    throw new NumberFormatException("Invalid number: " + str.substring(i2, i3));
                }
                i5 = -digit;
            } else {
                i4 = i2;
                i5 = 0;
            }
            while (i4 < i3) {
                int i6 = i4 + 1;
                int digit2 = Character.digit(str.charAt(i4), 10);
                if (digit2 < 0) {
                    throw new NumberFormatException("Invalid number: " + str.substring(i2, i3));
                }
                i5 = (i5 * 10) - digit2;
                i4 = i6;
            }
            return -i5;
        }
        return invokeLII.intValue;
    }

    public static String format(Date date, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, date, z)) == null) ? format(date, z, TIMEZONE_UTC) : (String) invokeLZ.objValue;
    }

    public static String format(Date date, boolean z, TimeZone timeZone) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{date, Boolean.valueOf(z), timeZone})) == null) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
            gregorianCalendar.setTime(date);
            StringBuilder sb = new StringBuilder(19 + (z ? 4 : 0) + (timeZone.getRawOffset() == 0 ? 1 : 6));
            padInt(sb, gregorianCalendar.get(1), 4);
            char c2 = SignatureImpl.SEP;
            sb.append(SignatureImpl.SEP);
            padInt(sb, gregorianCalendar.get(2) + 1, 2);
            sb.append(SignatureImpl.SEP);
            padInt(sb, gregorianCalendar.get(5), 2);
            sb.append('T');
            padInt(sb, gregorianCalendar.get(11), 2);
            sb.append(':');
            padInt(sb, gregorianCalendar.get(12), 2);
            sb.append(':');
            padInt(sb, gregorianCalendar.get(13), 2);
            if (z) {
                sb.append('.');
                padInt(sb, gregorianCalendar.get(14), 3);
            }
            int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
            if (offset != 0) {
                int i2 = offset / 60000;
                int abs = Math.abs(i2 / 60);
                int abs2 = Math.abs(i2 % 60);
                if (offset >= 0) {
                    c2 = '+';
                }
                sb.append(c2);
                padInt(sb, abs, 2);
                sb.append(':');
                padInt(sb, abs2, 2);
            } else {
                sb.append('Z');
            }
            return sb.toString();
        }
        return (String) invokeCommon.objValue;
    }
}
