package org.apache.commons.lang3.time;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
/* loaded from: classes9.dex */
public class FastDateFormat extends Format implements DateParser, DatePrinter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FULL = 0;
    public static final int LONG = 1;
    public static final int MEDIUM = 2;
    public static final int SHORT = 3;
    public static final FormatCache<FastDateFormat> cache;
    public static final long serialVersionUID = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public final FastDateParser parser;
    public final FastDatePrinter printer;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-335913293, "Lorg/apache/commons/lang3/time/FastDateFormat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-335913293, "Lorg/apache/commons/lang3/time/FastDateFormat;");
                return;
            }
        }
        cache = new FormatCache<FastDateFormat>() { // from class: org.apache.commons.lang3.time.FastDateFormat.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // org.apache.commons.lang3.time.FormatCache
            public FastDateFormat createInstance(String str, TimeZone timeZone, Locale locale) {
                InterceptResult invokeLLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, timeZone, locale)) == null) ? new FastDateFormat(str, timeZone, locale) : (FastDateFormat) invokeLLL.objValue;
            }
        };
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FastDateFormat(String str, TimeZone timeZone, Locale locale) {
        this(str, timeZone, locale, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, timeZone, locale};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (TimeZone) objArr2[1], (Locale) objArr2[2], (Date) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static FastDateFormat getDateInstance(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? cache.getDateInstance(i2, null, null) : (FastDateFormat) invokeI.objValue;
    }

    public static FastDateFormat getDateTimeInstance(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65543, null, i2, i3)) == null) ? cache.getDateTimeInstance(i2, i3, (TimeZone) null, (Locale) null) : (FastDateFormat) invokeII.objValue;
    }

    public static FastDateFormat getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? cache.getInstance() : (FastDateFormat) invokeV.objValue;
    }

    public static FastDateFormat getTimeInstance(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65552, null, i2)) == null) ? cache.getTimeInstance(i2, null, null) : (FastDateFormat) invokeI.objValue;
    }

    @Deprecated
    public StringBuffer applyRules(Calendar calendar, StringBuffer stringBuffer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, calendar, stringBuffer)) == null) ? this.printer.applyRules(calendar, stringBuffer) : (StringBuffer) invokeLL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj instanceof FastDateFormat) {
                return this.printer.equals(((FastDateFormat) obj).printer);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // java.text.Format, org.apache.commons.lang3.time.DatePrinter
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, obj, stringBuffer, fieldPosition)) == null) {
            stringBuffer.append(this.printer.format(obj));
            return stringBuffer;
        }
        return (StringBuffer) invokeLLL.objValue;
    }

    @Override // org.apache.commons.lang3.time.DateParser, org.apache.commons.lang3.time.DatePrinter
    public Locale getLocale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.printer.getLocale() : (Locale) invokeV.objValue;
    }

    public int getMaxLengthEstimate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.printer.getMaxLengthEstimate() : invokeV.intValue;
    }

    @Override // org.apache.commons.lang3.time.DateParser, org.apache.commons.lang3.time.DatePrinter
    public String getPattern() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.printer.getPattern() : (String) invokeV.objValue;
    }

    @Override // org.apache.commons.lang3.time.DateParser, org.apache.commons.lang3.time.DatePrinter
    public TimeZone getTimeZone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.printer.getTimeZone() : (TimeZone) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.printer.hashCode() : invokeV.intValue;
    }

    @Override // org.apache.commons.lang3.time.DateParser
    public Date parse(String str) throws ParseException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) ? this.parser.parse(str) : (Date) invokeL.objValue;
    }

    @Override // java.text.Format, org.apache.commons.lang3.time.DateParser
    public Object parseObject(String str, ParsePosition parsePosition) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, str, parsePosition)) == null) ? this.parser.parseObject(str, parsePosition) : invokeLL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return "FastDateFormat[" + this.printer.getPattern() + "," + this.printer.getLocale() + "," + this.printer.getTimeZone().getID() + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }

    public FastDateFormat(String str, TimeZone timeZone, Locale locale, Date date) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, timeZone, locale, date};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.printer = new FastDatePrinter(str, timeZone, locale);
        this.parser = new FastDateParser(str, timeZone, locale, date);
    }

    public static FastDateFormat getDateInstance(int i2, Locale locale) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, locale)) == null) ? cache.getDateInstance(i2, null, locale) : (FastDateFormat) invokeIL.objValue;
    }

    public static FastDateFormat getDateTimeInstance(int i2, int i3, Locale locale) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(65544, null, i2, i3, locale)) == null) ? cache.getDateTimeInstance(i2, i3, (TimeZone) null, locale) : (FastDateFormat) invokeIIL.objValue;
    }

    public static FastDateFormat getInstance(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) ? cache.getInstance(str, null, null) : (FastDateFormat) invokeL.objValue;
    }

    public static FastDateFormat getTimeInstance(int i2, Locale locale) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65553, null, i2, locale)) == null) ? cache.getTimeInstance(i2, null, locale) : (FastDateFormat) invokeIL.objValue;
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public String format(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) ? this.printer.format(j2) : (String) invokeJ.objValue;
    }

    @Override // org.apache.commons.lang3.time.DateParser
    public Date parse(String str, ParsePosition parsePosition) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, str, parsePosition)) == null) ? this.parser.parse(str, parsePosition) : (Date) invokeLL.objValue;
    }

    public static FastDateFormat getDateInstance(int i2, TimeZone timeZone) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65541, null, i2, timeZone)) == null) ? cache.getDateInstance(i2, timeZone, null) : (FastDateFormat) invokeIL.objValue;
    }

    public static FastDateFormat getDateTimeInstance(int i2, int i3, TimeZone timeZone) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(65545, null, i2, i3, timeZone)) == null) ? getDateTimeInstance(i2, i3, timeZone, null) : (FastDateFormat) invokeIIL.objValue;
    }

    public static FastDateFormat getInstance(String str, TimeZone timeZone) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, str, timeZone)) == null) ? cache.getInstance(str, timeZone, null) : (FastDateFormat) invokeLL.objValue;
    }

    public static FastDateFormat getTimeInstance(int i2, TimeZone timeZone) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65554, null, i2, timeZone)) == null) ? cache.getTimeInstance(i2, timeZone, null) : (FastDateFormat) invokeIL.objValue;
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public String format(Date date) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, date)) == null) ? this.printer.format(date) : (String) invokeL.objValue;
    }

    @Override // org.apache.commons.lang3.time.DateParser
    public boolean parse(String str, ParsePosition parsePosition, Calendar calendar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048595, this, str, parsePosition, calendar)) == null) ? this.parser.parse(str, parsePosition, calendar) : invokeLLL.booleanValue;
    }

    public static FastDateFormat getDateInstance(int i2, TimeZone timeZone, Locale locale) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(65542, null, i2, timeZone, locale)) == null) ? cache.getDateInstance(i2, timeZone, locale) : (FastDateFormat) invokeILL.objValue;
    }

    public static FastDateFormat getDateTimeInstance(int i2, int i3, TimeZone timeZone, Locale locale) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), timeZone, locale})) == null) ? cache.getDateTimeInstance(i2, i3, timeZone, locale) : (FastDateFormat) invokeCommon.objValue;
    }

    public static FastDateFormat getInstance(String str, Locale locale) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, str, locale)) == null) ? cache.getInstance(str, null, locale) : (FastDateFormat) invokeLL.objValue;
    }

    public static FastDateFormat getTimeInstance(int i2, TimeZone timeZone, Locale locale) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(65555, null, i2, timeZone, locale)) == null) ? cache.getTimeInstance(i2, timeZone, locale) : (FastDateFormat) invokeILL.objValue;
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public String format(Calendar calendar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, calendar)) == null) ? this.printer.format(calendar) : (String) invokeL.objValue;
    }

    public static FastDateFormat getInstance(String str, TimeZone timeZone, Locale locale) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, str, timeZone, locale)) == null) ? cache.getInstance(str, timeZone, locale) : (FastDateFormat) invokeLLL.objValue;
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    @Deprecated
    public StringBuffer format(long j2, StringBuffer stringBuffer) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2, stringBuffer)) == null) ? this.printer.format(j2, stringBuffer) : (StringBuffer) invokeJL.objValue;
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    @Deprecated
    public StringBuffer format(Date date, StringBuffer stringBuffer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, date, stringBuffer)) == null) ? this.printer.format(date, stringBuffer) : (StringBuffer) invokeLL.objValue;
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    @Deprecated
    public StringBuffer format(Calendar calendar, StringBuffer stringBuffer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, calendar, stringBuffer)) == null) ? this.printer.format(calendar, stringBuffer) : (StringBuffer) invokeLL.objValue;
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public <B extends Appendable> B format(long j2, B b2) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j2, b2)) == null) ? (B) this.printer.format(j2, (long) b2) : (B) invokeJL.objValue;
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public <B extends Appendable> B format(Date date, B b2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, date, b2)) == null) ? (B) this.printer.format(date, (Date) b2) : (B) invokeLL.objValue;
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public <B extends Appendable> B format(Calendar calendar, B b2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, calendar, b2)) == null) ? (B) this.printer.format(calendar, (Calendar) b2) : (B) invokeLL.objValue;
    }
}
