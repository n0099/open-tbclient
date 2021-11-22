package org.apache.commons.lang3.time;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
/* loaded from: classes3.dex */
public class DurationFormatUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Object H;
    public static final String ISO_EXTENDED_FORMAT_PATTERN = "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.SSS'S'";
    public static final Object M;
    public static final Object S;

    /* renamed from: d  reason: collision with root package name */
    public static final Object f73486d;
    public static final Object m;
    public static final Object s;
    public static final Object y;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-527454532, "Lorg/apache/commons/lang3/time/DurationFormatUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-527454532, "Lorg/apache/commons/lang3/time/DurationFormatUtils;");
                return;
            }
        }
        y = "y";
        M = "M";
        f73486d = "d";
        H = "H";
        m = "m";
        s = "s";
        S = "S";
    }

    public DurationFormatUtils() {
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

    public static String format(Token[] tokenArr, long j, long j2, long j3, long j4, long j5, long j6, long j7, boolean z) {
        InterceptResult invokeCommon;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{tokenArr, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(j7), Boolean.valueOf(z)})) == null) {
            Token[] tokenArr2 = tokenArr;
            StringBuilder sb = new StringBuilder();
            int length = tokenArr2.length;
            int i4 = 0;
            boolean z2 = false;
            while (i4 < length) {
                Token token = tokenArr2[i4];
                Object value = token.getValue();
                int count = token.getCount();
                if (value instanceof StringBuilder) {
                    sb.append(value.toString());
                    i3 = length;
                    i2 = i4;
                } else {
                    if (value.equals(y)) {
                        sb.append(paddedValue(j, z, count));
                        i3 = length;
                        i2 = i4;
                    } else {
                        if (value.equals(M)) {
                            i2 = i4;
                            sb.append(paddedValue(j2, z, count));
                        } else {
                            i2 = i4;
                            if (value.equals(f73486d)) {
                                sb.append(paddedValue(j3, z, count));
                            } else if (value.equals(H)) {
                                sb.append(paddedValue(j4, z, count));
                                i3 = length;
                            } else if (value.equals(m)) {
                                sb.append(paddedValue(j5, z, count));
                                i3 = length;
                            } else {
                                if (value.equals(s)) {
                                    i3 = length;
                                    sb.append(paddedValue(j6, z, count));
                                    z2 = true;
                                } else {
                                    i3 = length;
                                    if (value.equals(S)) {
                                        if (z2) {
                                            sb.append(paddedValue(j7, true, z ? Math.max(3, count) : 3));
                                        } else {
                                            sb.append(paddedValue(j7, z, count));
                                        }
                                        z2 = false;
                                    }
                                }
                                i4 = i2 + 1;
                                length = i3;
                                tokenArr2 = tokenArr;
                            }
                        }
                        i3 = length;
                    }
                    z2 = false;
                }
                i4 = i2 + 1;
                length = i3;
                tokenArr2 = tokenArr;
            }
            return sb.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static String formatDuration(long j, String str) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(65539, null, j, str)) == null) ? formatDuration(j, str, true) : (String) invokeJL.objValue;
    }

    public static String formatDurationHMS(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(AdIconUtil.AD_TEXT_ID, null, j)) == null) ? formatDuration(j, "HH:mm:ss.SSS") : (String) invokeJ.objValue;
    }

    public static String formatDurationISO(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(AdIconUtil.BAIDU_LOGO_ID, null, j)) == null) ? formatDuration(j, ISO_EXTENDED_FORMAT_PATTERN, false) : (String) invokeJ.objValue;
    }

    public static String formatDurationWords(long j, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            String formatDuration = formatDuration(j, "d' days 'H' hours 'm' minutes 's' seconds'");
            if (z) {
                formatDuration = " " + formatDuration;
                String replaceOnce = StringUtils.replaceOnce(formatDuration, " 0 days", "");
                if (replaceOnce.length() != formatDuration.length()) {
                    String replaceOnce2 = StringUtils.replaceOnce(replaceOnce, " 0 hours", "");
                    if (replaceOnce2.length() != replaceOnce.length()) {
                        formatDuration = StringUtils.replaceOnce(replaceOnce2, " 0 minutes", "");
                        if (formatDuration.length() != formatDuration.length()) {
                            formatDuration = StringUtils.replaceOnce(formatDuration, " 0 seconds", "");
                        }
                    } else {
                        formatDuration = replaceOnce;
                    }
                }
                if (formatDuration.length() != 0) {
                    formatDuration = formatDuration.substring(1);
                }
            }
            if (z2) {
                String replaceOnce3 = StringUtils.replaceOnce(formatDuration, " 0 seconds", "");
                if (replaceOnce3.length() != formatDuration.length()) {
                    formatDuration = StringUtils.replaceOnce(replaceOnce3, " 0 minutes", "");
                    if (formatDuration.length() != replaceOnce3.length()) {
                        String replaceOnce4 = StringUtils.replaceOnce(formatDuration, " 0 hours", "");
                        if (replaceOnce4.length() != formatDuration.length()) {
                            formatDuration = StringUtils.replaceOnce(replaceOnce4, " 0 days", "");
                        }
                    } else {
                        formatDuration = replaceOnce3;
                    }
                }
            }
            return StringUtils.replaceOnce(StringUtils.replaceOnce(StringUtils.replaceOnce(StringUtils.replaceOnce(" " + formatDuration, " 1 seconds", " 1 second"), " 1 minutes", " 1 minute"), " 1 hours", " 1 hour"), " 1 days", " 1 day").trim();
        }
        return (String) invokeCommon.objValue;
    }

    public static String formatPeriod(long j, long j2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), str})) == null) ? formatPeriod(j, j2, str, true, TimeZone.getDefault()) : (String) invokeCommon.objValue;
    }

    public static String formatPeriodISO(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? formatPeriod(j, j2, ISO_EXTENDED_FORMAT_PATTERN, false, TimeZone.getDefault()) : (String) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Token[] lexx(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            ArrayList arrayList = new ArrayList(str.length());
            StringBuilder sb = null;
            Token token = null;
            boolean z = false;
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (z && charAt != '\'') {
                    sb.append(charAt);
                } else if (charAt != '\'') {
                    if (charAt == 'H') {
                        obj = H;
                    } else if (charAt == 'M') {
                        obj = M;
                    } else if (charAt == 'S') {
                        obj = S;
                    } else if (charAt == 'd') {
                        obj = f73486d;
                    } else if (charAt == 'm') {
                        obj = m;
                    } else if (charAt == 's') {
                        obj = s;
                    } else if (charAt != 'y') {
                        if (sb == null) {
                            sb = new StringBuilder();
                            arrayList.add(new Token(sb));
                        }
                        sb.append(charAt);
                        obj = null;
                    } else {
                        obj = y;
                    }
                    if (obj != null) {
                        if (token != null && token.getValue().equals(obj)) {
                            token.increment();
                        } else {
                            Token token2 = new Token(obj);
                            arrayList.add(token2);
                            token = token2;
                        }
                        sb = null;
                    }
                } else if (z) {
                    sb = null;
                    obj = null;
                    z = false;
                    if (obj != null) {
                    }
                } else {
                    sb = new StringBuilder();
                    arrayList.add(new Token(sb));
                    z = true;
                    obj = null;
                    if (obj != null) {
                    }
                }
            }
            if (!z) {
                return (Token[]) arrayList.toArray(new Token[arrayList.size()]);
            }
            throw new IllegalArgumentException("Unmatched quote in format: " + str);
        }
        return (Token[]) invokeL.objValue;
    }

    public static String paddedValue(long j, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{Long.valueOf(j), Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            String l = Long.toString(j);
            return z ? StringUtils.leftPad(l, i2, '0') : l;
        }
        return (String) invokeCommon.objValue;
    }

    public static String formatDuration(long j, String str, boolean z) {
        InterceptResult invokeCommon;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j), str, Boolean.valueOf(z)})) == null) {
            Validate.inclusiveBetween(0L, Long.MAX_VALUE, j, "durationMillis must not be negative");
            Token[] lexx = lexx(str);
            if (Token.containsTokenWithValue(lexx, f73486d)) {
                long j8 = j / 86400000;
                j2 = j - (86400000 * j8);
                j3 = j8;
            } else {
                j2 = j;
                j3 = 0;
            }
            if (Token.containsTokenWithValue(lexx, H)) {
                long j9 = j2 / 3600000;
                j2 -= 3600000 * j9;
                j4 = j9;
            } else {
                j4 = 0;
            }
            if (Token.containsTokenWithValue(lexx, m)) {
                long j10 = j2 / 60000;
                j2 -= 60000 * j10;
                j5 = j10;
            } else {
                j5 = 0;
            }
            if (Token.containsTokenWithValue(lexx, s)) {
                long j11 = j2 / 1000;
                j7 = j2 - (1000 * j11);
                j6 = j11;
            } else {
                j6 = 0;
                j7 = j2;
            }
            return format(lexx, 0L, 0L, j3, j4, j5, j6, j7, z);
        }
        return (String) invokeCommon.objValue;
    }

    public static String formatPeriod(long j, long j2, String str, boolean z, TimeZone timeZone) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, Boolean.valueOf(z), timeZone})) == null) {
            int i2 = 0;
            Validate.isTrue(j <= j2, "startMillis must not be greater than endMillis", new Object[0]);
            Token[] lexx = lexx(str);
            Calendar calendar = Calendar.getInstance(timeZone);
            calendar.setTime(new Date(j));
            Calendar calendar2 = Calendar.getInstance(timeZone);
            calendar2.setTime(new Date(j2));
            int i3 = calendar2.get(14) - calendar.get(14);
            int i4 = calendar2.get(13) - calendar.get(13);
            int i5 = calendar2.get(12) - calendar.get(12);
            int i6 = calendar2.get(11) - calendar.get(11);
            int i7 = calendar2.get(5) - calendar.get(5);
            int i8 = calendar2.get(2) - calendar.get(2);
            int i9 = calendar2.get(1) - calendar.get(1);
            while (i3 < 0) {
                i3 += 1000;
                i4--;
            }
            while (i4 < 0) {
                i4 += 60;
                i5--;
            }
            while (i5 < 0) {
                i5 += 60;
                i6--;
            }
            while (i6 < 0) {
                i6 += 24;
                i7--;
            }
            if (Token.containsTokenWithValue(lexx, M)) {
                while (i7 < 0) {
                    i7 += calendar.getActualMaximum(5);
                    i8--;
                    calendar.add(2, 1);
                }
                while (i8 < 0) {
                    i8 += 12;
                    i9--;
                }
                if (!Token.containsTokenWithValue(lexx, y) && i9 != 0) {
                    while (i9 != 0) {
                        i8 += i9 * 12;
                        i9 = 0;
                    }
                }
            } else {
                if (!Token.containsTokenWithValue(lexx, y)) {
                    int i10 = calendar2.get(1);
                    if (i8 < 0) {
                        i10--;
                    }
                    while (calendar.get(1) != i10) {
                        int actualMaximum = i7 + (calendar.getActualMaximum(6) - calendar.get(6));
                        if ((calendar instanceof GregorianCalendar) && calendar.get(2) == 1 && calendar.get(5) == 29) {
                            actualMaximum++;
                        }
                        calendar.add(1, 1);
                        i7 = actualMaximum + calendar.get(6);
                    }
                    i9 = 0;
                }
                while (calendar.get(2) != calendar2.get(2)) {
                    i7 += calendar.getActualMaximum(5);
                    calendar.add(2, 1);
                }
                i8 = 0;
                while (i7 < 0) {
                    i7 += calendar.getActualMaximum(5);
                    i8--;
                    calendar.add(2, 1);
                }
            }
            if (!Token.containsTokenWithValue(lexx, f73486d)) {
                i6 += i7 * 24;
                i7 = 0;
            }
            if (!Token.containsTokenWithValue(lexx, H)) {
                i5 += i6 * 60;
                i6 = 0;
            }
            if (!Token.containsTokenWithValue(lexx, m)) {
                i4 += i5 * 60;
                i5 = 0;
            }
            if (Token.containsTokenWithValue(lexx, s)) {
                i2 = i4;
            } else {
                i3 += i4 * 1000;
            }
            return format(lexx, i9, i8, i7, i6, i5, i2, i3, z);
        }
        return (String) invokeCommon.objValue;
    }

    /* loaded from: classes3.dex */
    public static class Token {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int count;
        public final Object value;

        public Token(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.value = obj;
            this.count = 1;
        }

        public static boolean containsTokenWithValue(Token[] tokenArr, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tokenArr, obj)) == null) {
                for (Token token : tokenArr) {
                    if (token.getValue() == obj) {
                        return true;
                    }
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj instanceof Token) {
                    Token token = (Token) obj;
                    if (this.value.getClass() == token.value.getClass() && this.count == token.count) {
                        Object obj2 = this.value;
                        if (obj2 instanceof StringBuilder) {
                            return obj2.toString().equals(token.value.toString());
                        }
                        if (obj2 instanceof Number) {
                            return obj2.equals(token.value);
                        }
                        return obj2 == token.value;
                    }
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.count : invokeV.intValue;
        }

        public Object getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.value : invokeV.objValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.value.hashCode() : invokeV.intValue;
        }

        public void increment() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.count++;
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? StringUtils.repeat(this.value.toString(), this.count) : (String) invokeV.objValue;
        }

        public Token(Object obj, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.value = obj;
            this.count = i2;
        }
    }
}
