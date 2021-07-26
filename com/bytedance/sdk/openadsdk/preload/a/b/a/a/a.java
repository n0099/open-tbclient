package com.bytedance.sdk.openadsdk.preload.a.b.a.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import kotlin.text.Typography;
import org.aspectj.runtime.reflect.SignatureImpl;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final TimeZone f32025a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(988667308, "Lcom/bytedance/sdk/openadsdk/preload/a/b/a/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(988667308, "Lcom/bytedance/sdk/openadsdk/preload/a/b/a/a/a;");
                return;
            }
        }
        f32025a = TimeZone.getTimeZone("UTC");
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00d3 A[Catch: IllegalArgumentException -> 0x01c0, NumberFormatException -> 0x01c2, IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01c4, TryCatch #2 {IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01c4, blocks: (B:5:0x0008, B:7:0x001a, B:8:0x001c, B:10:0x0028, B:11:0x002a, B:13:0x0039, B:15:0x003f, B:19:0x0054, B:21:0x0064, B:22:0x0066, B:24:0x0072, B:25:0x0074, B:27:0x007a, B:31:0x0084, B:36:0x0094, B:38:0x009c, B:49:0x00cd, B:51:0x00d3, B:53:0x00da, B:77:0x0187, B:57:0x00e4, B:58:0x00ff, B:59:0x0100, B:63:0x011c, B:65:0x0129, B:68:0x0132, B:70:0x0151, B:73:0x0160, B:74:0x0182, B:76:0x0185, B:62:0x010b, B:79:0x01b8, B:80:0x01bf, B:42:0x00b4, B:43:0x00b7), top: B:100:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01b8 A[Catch: IllegalArgumentException -> 0x01c0, NumberFormatException -> 0x01c2, IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01c4, TryCatch #2 {IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01c4, blocks: (B:5:0x0008, B:7:0x001a, B:8:0x001c, B:10:0x0028, B:11:0x002a, B:13:0x0039, B:15:0x003f, B:19:0x0054, B:21:0x0064, B:22:0x0066, B:24:0x0072, B:25:0x0074, B:27:0x007a, B:31:0x0084, B:36:0x0094, B:38:0x009c, B:49:0x00cd, B:51:0x00d3, B:53:0x00da, B:77:0x0187, B:57:0x00e4, B:58:0x00ff, B:59:0x0100, B:63:0x011c, B:65:0x0129, B:68:0x0132, B:70:0x0151, B:73:0x0160, B:74:0x0182, B:76:0x0185, B:62:0x010b, B:79:0x01b8, B:80:0x01bf, B:42:0x00b4, B:43:0x00b7), top: B:100:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Date a(String str, ParsePosition parsePosition) throws ParseException {
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
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65539, null, str, parsePosition)) != null) {
            return (Date) invokeLL.objValue;
        }
        try {
            int index = parsePosition.getIndex();
            int i6 = index + 4;
            int a2 = a(str, index, i6);
            if (a(str, i6, (char) SignatureImpl.SEP)) {
                i6++;
            }
            int i7 = i6 + 2;
            int a3 = a(str, i6, i7);
            if (a(str, i7, (char) SignatureImpl.SEP)) {
                i7++;
            }
            int i8 = i7 + 2;
            int a4 = a(str, i7, i8);
            boolean a5 = a(str, i8, 'T');
            if (!a5 && str.length() <= i8) {
                GregorianCalendar gregorianCalendar = new GregorianCalendar(a2, a3 - 1, a4);
                parsePosition.setIndex(i8);
                return gregorianCalendar.getTime();
            }
            if (a5) {
                int i9 = i8 + 1;
                int i10 = i9 + 2;
                int a6 = a(str, i9, i10);
                if (a(str, i10, ':')) {
                    i10++;
                }
                int i11 = i10 + 2;
                int a7 = a(str, i10, i11);
                if (a(str, i11, ':')) {
                    i11++;
                }
                if (str.length() > i11 && (charAt = str.charAt(i11)) != 'Z' && charAt != '+' && charAt != '-') {
                    int i12 = i11 + 2;
                    i5 = a(str, i11, i12);
                    if (i5 > 59 && i5 < 63) {
                        i5 = 59;
                    }
                    if (a(str, i12, (char) IStringUtil.EXTENSION_SEPARATOR)) {
                        int i13 = i12 + 1;
                        int a8 = a(str, i13 + 1);
                        int min = Math.min(a8, i13 + 3);
                        int a9 = a(str, i13, min);
                        int i14 = min - i13;
                        if (i14 == 1) {
                            a9 *= 100;
                        } else if (i14 == 2) {
                            a9 *= 10;
                        }
                        i3 = a7;
                        i4 = a9;
                        i2 = a6;
                        i8 = a8;
                    } else {
                        i3 = a7;
                        i2 = a6;
                        i8 = i12;
                        i4 = 0;
                    }
                    if (str.length() <= i8) {
                        char charAt2 = str.charAt(i8);
                        if (charAt2 == 'Z') {
                            timeZone = f32025a;
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
                            timeZone = f32025a;
                        }
                        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(timeZone);
                        gregorianCalendar2.setLenient(false);
                        gregorianCalendar2.set(1, a2);
                        gregorianCalendar2.set(2, a3 - 1);
                        gregorianCalendar2.set(5, a4);
                        gregorianCalendar2.set(11, i2);
                        gregorianCalendar2.set(12, i3);
                        gregorianCalendar2.set(13, i5);
                        gregorianCalendar2.set(14, i4);
                        parsePosition.setIndex(length);
                        return gregorianCalendar2.getTime();
                    }
                    throw new IllegalArgumentException("No time zone indicator");
                }
                i3 = a7;
                i4 = 0;
                i2 = a6;
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
                str2 = Typography.quote + str + Typography.quote;
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

    public static boolean a(String str, int i2, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, Integer.valueOf(i2), Character.valueOf(c2)})) == null) ? i2 < str.length() && str.charAt(i2) == c2 : invokeCommon.booleanValue;
    }

    public static int a(String str, int i2, int i3) throws NumberFormatException {
        InterceptResult invokeLII;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, str, i2, i3)) == null) {
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

    public static int a(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, str, i2)) == null) {
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
}
