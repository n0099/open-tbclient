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
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.aspectj.runtime.reflect.SignatureImpl;
/* loaded from: classes5.dex */
public class FastDatePrinter implements DatePrinter, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FULL = 0;
    public static final int LONG = 1;
    public static final int MAX_DIGITS = 10;
    public static final int MEDIUM = 2;
    public static final int SHORT = 3;
    public static final ConcurrentMap<TimeZoneDisplayKey, String> cTimeZoneDisplayCache;
    public static final long serialVersionUID = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final Locale mLocale;
    public transient int mMaxLengthEstimate;
    public final String mPattern;
    public transient Rule[] mRules;
    public final TimeZone mTimeZone;

    /* loaded from: classes5.dex */
    public static class CharacterLiteral implements Rule {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final char mValue;

        public CharacterLiteral(char c2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Character.valueOf(c2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mValue = c2;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, appendable, calendar) == null) {
                appendable.append(this.mValue);
            }
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 1;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class Iso8601_Rule implements Rule {
        public static /* synthetic */ Interceptable $ic;
        public static final Iso8601_Rule ISO8601_HOURS;
        public static final Iso8601_Rule ISO8601_HOURS_COLON_MINUTES;
        public static final Iso8601_Rule ISO8601_HOURS_MINUTES;
        public transient /* synthetic */ FieldHolder $fh;
        public final int length;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1739893321, "Lorg/apache/commons/lang3/time/FastDatePrinter$Iso8601_Rule;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1739893321, "Lorg/apache/commons/lang3/time/FastDatePrinter$Iso8601_Rule;");
                    return;
                }
            }
            ISO8601_HOURS = new Iso8601_Rule(3);
            ISO8601_HOURS_MINUTES = new Iso8601_Rule(5);
            ISO8601_HOURS_COLON_MINUTES = new Iso8601_Rule(6);
        }

        public Iso8601_Rule(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.length = i2;
        }

        public static Iso8601_Rule getRule(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 == 3) {
                            return ISO8601_HOURS_COLON_MINUTES;
                        }
                        throw new IllegalArgumentException("invalid number of X");
                    }
                    return ISO8601_HOURS_MINUTES;
                }
                return ISO8601_HOURS;
            }
            return (Iso8601_Rule) invokeI.objValue;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, appendable, calendar) == null) {
                int i2 = calendar.get(15) + calendar.get(16);
                if (i2 == 0) {
                    appendable.append("Z");
                    return;
                }
                if (i2 < 0) {
                    appendable.append(SignatureImpl.SEP);
                    i2 = -i2;
                } else {
                    appendable.append('+');
                }
                int i3 = i2 / 3600000;
                FastDatePrinter.appendDigits(appendable, i3);
                int i4 = this.length;
                if (i4 < 5) {
                    return;
                }
                if (i4 == 6) {
                    appendable.append(':');
                }
                FastDatePrinter.appendDigits(appendable, (i2 / 60000) - (i3 * 60));
            }
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.length : invokeV.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public interface NumberRule extends Rule {
        void appendTo(Appendable appendable, int i2) throws IOException;
    }

    /* loaded from: classes5.dex */
    public static class PaddedNumberField implements NumberRule {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int mField;
        public final int mSize;

        public PaddedNumberField(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (i3 >= 3) {
                this.mField = i2;
                this.mSize = i3;
                return;
            }
            throw new IllegalArgumentException();
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, appendable, calendar) == null) {
                appendTo(appendable, calendar.get(this.mField));
            }
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mSize : invokeV.intValue;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(Appendable appendable, int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, appendable, i2) == null) {
                FastDatePrinter.appendFullDigits(appendable, i2, this.mSize);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface Rule {
        void appendTo(Appendable appendable, Calendar calendar) throws IOException;

        int estimateLength();
    }

    /* loaded from: classes5.dex */
    public static class StringLiteral implements Rule {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String mValue;

        public StringLiteral(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mValue = str;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, appendable, calendar) == null) {
                appendable.append(this.mValue);
            }
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mValue.length() : invokeV.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class TextField implements Rule {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int mField;
        public final String[] mValues;

        public TextField(int i2, String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), strArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mField = i2;
            this.mValues = strArr;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, appendable, calendar) == null) {
                appendable.append(this.mValues[calendar.get(this.mField)]);
            }
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
                return invokeV.intValue;
            }
            int length = this.mValues.length;
            int i2 = 0;
            while (true) {
                length--;
                if (length < 0) {
                    return i2;
                }
                int length2 = this.mValues[length].length();
                if (length2 > i2) {
                    i2 = length2;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class TimeZoneDisplayKey {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Locale mLocale;
        public final int mStyle;
        public final TimeZone mTimeZone;

        public TimeZoneDisplayKey(TimeZone timeZone, boolean z, int i2, Locale locale) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {timeZone, Boolean.valueOf(z), Integer.valueOf(i2), locale};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mTimeZone = timeZone;
            if (z) {
                this.mStyle = Integer.MIN_VALUE | i2;
            } else {
                this.mStyle = i2;
            }
            this.mLocale = locale;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof TimeZoneDisplayKey) {
                    TimeZoneDisplayKey timeZoneDisplayKey = (TimeZoneDisplayKey) obj;
                    return this.mTimeZone.equals(timeZoneDisplayKey.mTimeZone) && this.mStyle == timeZoneDisplayKey.mStyle && this.mLocale.equals(timeZoneDisplayKey.mLocale);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (((this.mStyle * 31) + this.mLocale.hashCode()) * 31) + this.mTimeZone.hashCode() : invokeV.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class TimeZoneNameRule implements Rule {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String mDaylight;
        public final Locale mLocale;
        public final String mStandard;
        public final int mStyle;

        public TimeZoneNameRule(TimeZone timeZone, Locale locale, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {timeZone, locale, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mLocale = locale;
            this.mStyle = i2;
            this.mStandard = FastDatePrinter.getTimeZoneDisplay(timeZone, false, i2, locale);
            this.mDaylight = FastDatePrinter.getTimeZoneDisplay(timeZone, true, i2, locale);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, appendable, calendar) == null) {
                TimeZone timeZone = calendar.getTimeZone();
                if (calendar.get(16) != 0) {
                    appendable.append(FastDatePrinter.getTimeZoneDisplay(timeZone, true, this.mStyle, this.mLocale));
                } else {
                    appendable.append(FastDatePrinter.getTimeZoneDisplay(timeZone, false, this.mStyle, this.mLocale));
                }
            }
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Math.max(this.mStandard.length(), this.mDaylight.length()) : invokeV.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class TimeZoneNumberRule implements Rule {
        public static /* synthetic */ Interceptable $ic;
        public static final TimeZoneNumberRule INSTANCE_COLON;
        public static final TimeZoneNumberRule INSTANCE_NO_COLON;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean mColon;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1316203646, "Lorg/apache/commons/lang3/time/FastDatePrinter$TimeZoneNumberRule;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1316203646, "Lorg/apache/commons/lang3/time/FastDatePrinter$TimeZoneNumberRule;");
                    return;
                }
            }
            INSTANCE_COLON = new TimeZoneNumberRule(true);
            INSTANCE_NO_COLON = new TimeZoneNumberRule(false);
        }

        public TimeZoneNumberRule(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mColon = z;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, appendable, calendar) == null) {
                int i2 = calendar.get(15) + calendar.get(16);
                if (i2 < 0) {
                    appendable.append(SignatureImpl.SEP);
                    i2 = -i2;
                } else {
                    appendable.append('+');
                }
                int i3 = i2 / 3600000;
                FastDatePrinter.appendDigits(appendable, i3);
                if (this.mColon) {
                    appendable.append(':');
                }
                FastDatePrinter.appendDigits(appendable, (i2 / 60000) - (i3 * 60));
            }
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 5;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class TwoDigitMonthField implements NumberRule {
        public static /* synthetic */ Interceptable $ic;
        public static final TwoDigitMonthField INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-416687483, "Lorg/apache/commons/lang3/time/FastDatePrinter$TwoDigitMonthField;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-416687483, "Lorg/apache/commons/lang3/time/FastDatePrinter$TwoDigitMonthField;");
                    return;
                }
            }
            INSTANCE = new TwoDigitMonthField();
        }

        public TwoDigitMonthField() {
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

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, appendable, calendar) == null) {
                appendTo(appendable, calendar.get(2) + 1);
            }
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return 2;
            }
            return invokeV.intValue;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(Appendable appendable, int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, appendable, i2) == null) {
                FastDatePrinter.appendDigits(appendable, i2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class TwoDigitNumberField implements NumberRule {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int mField;

        public TwoDigitNumberField(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mField = i2;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, appendable, calendar) == null) {
                appendTo(appendable, calendar.get(this.mField));
            }
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return 2;
            }
            return invokeV.intValue;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(Appendable appendable, int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, appendable, i2) == null) {
                if (i2 < 100) {
                    FastDatePrinter.appendDigits(appendable, i2);
                } else {
                    FastDatePrinter.appendFullDigits(appendable, i2, 2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class TwoDigitYearField implements NumberRule {
        public static /* synthetic */ Interceptable $ic;
        public static final TwoDigitYearField INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1495488710, "Lorg/apache/commons/lang3/time/FastDatePrinter$TwoDigitYearField;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1495488710, "Lorg/apache/commons/lang3/time/FastDatePrinter$TwoDigitYearField;");
                    return;
                }
            }
            INSTANCE = new TwoDigitYearField();
        }

        public TwoDigitYearField() {
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

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, appendable, calendar) == null) {
                appendTo(appendable, calendar.get(1) % 100);
            }
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return 2;
            }
            return invokeV.intValue;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(Appendable appendable, int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, appendable, i2) == null) {
                FastDatePrinter.appendDigits(appendable, i2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class UnpaddedMonthField implements NumberRule {
        public static /* synthetic */ Interceptable $ic;
        public static final UnpaddedMonthField INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(232417629, "Lorg/apache/commons/lang3/time/FastDatePrinter$UnpaddedMonthField;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(232417629, "Lorg/apache/commons/lang3/time/FastDatePrinter$UnpaddedMonthField;");
                    return;
                }
            }
            INSTANCE = new UnpaddedMonthField();
        }

        public UnpaddedMonthField() {
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

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, appendable, calendar) == null) {
                appendTo(appendable, calendar.get(2) + 1);
            }
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return 2;
            }
            return invokeV.intValue;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(Appendable appendable, int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, appendable, i2) == null) {
                if (i2 >= 10) {
                    FastDatePrinter.appendDigits(appendable, i2);
                } else {
                    appendable.append((char) (i2 + 48));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class UnpaddedNumberField implements NumberRule {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int mField;

        public UnpaddedNumberField(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mField = i2;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, appendable, calendar) == null) {
                appendTo(appendable, calendar.get(this.mField));
            }
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return 4;
            }
            return invokeV.intValue;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(Appendable appendable, int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, appendable, i2) == null) {
                if (i2 < 10) {
                    appendable.append((char) (i2 + 48));
                } else if (i2 < 100) {
                    FastDatePrinter.appendDigits(appendable, i2);
                } else {
                    FastDatePrinter.appendFullDigits(appendable, i2, 1);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class WeekYear implements NumberRule {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final NumberRule mRule;

        public WeekYear(NumberRule numberRule) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {numberRule};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mRule = numberRule;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, appendable, calendar) == null) {
                this.mRule.appendTo(appendable, CalendarReflection.getWeekYear(calendar));
            }
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mRule.estimateLength() : invokeV.intValue;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, appendable, i2) == null) {
                this.mRule.appendTo(appendable, i2);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(831182258, "Lorg/apache/commons/lang3/time/FastDatePrinter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(831182258, "Lorg/apache/commons/lang3/time/FastDatePrinter;");
                return;
            }
        }
        cTimeZoneDisplayCache = new ConcurrentHashMap(7);
    }

    public FastDatePrinter(String str, TimeZone timeZone, Locale locale) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, timeZone, locale};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mPattern = str;
        this.mTimeZone = timeZone;
        this.mLocale = locale;
        init();
    }

    public static void appendDigits(Appendable appendable, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, appendable, i2) == null) {
            appendable.append((char) ((i2 / 10) + 48));
            appendable.append((char) ((i2 % 10) + 48));
        }
    }

    public static void appendFullDigits(Appendable appendable, int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLII(65541, null, appendable, i2, i3) != null) {
            return;
        }
        if (i2 < 10000) {
            int i4 = i2 < 1000 ? i2 < 100 ? i2 < 10 ? 1 : 2 : 3 : 4;
            for (int i5 = i3 - i4; i5 > 0; i5--) {
                appendable.append('0');
            }
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 != 4) {
                            return;
                        }
                        appendable.append((char) ((i2 / 1000) + 48));
                        i2 %= 1000;
                    }
                    if (i2 >= 100) {
                        appendable.append((char) ((i2 / 100) + 48));
                        i2 %= 100;
                    } else {
                        appendable.append('0');
                    }
                }
                if (i2 >= 10) {
                    appendable.append((char) ((i2 / 10) + 48));
                    i2 %= 10;
                } else {
                    appendable.append('0');
                }
            }
            appendable.append((char) (i2 + 48));
            return;
        }
        char[] cArr = new char[10];
        int i6 = 0;
        while (i2 != 0) {
            cArr[i6] = (char) ((i2 % 10) + 48);
            i2 /= 10;
            i6++;
        }
        while (i6 < i3) {
            appendable.append('0');
            i3--;
        }
        while (true) {
            i6--;
            if (i6 < 0) {
                return;
            }
            appendable.append(cArr[i6]);
        }
    }

    private String applyRulesToString(Calendar calendar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, this, calendar)) == null) ? ((StringBuilder) applyRules(calendar, (Calendar) new StringBuilder(this.mMaxLengthEstimate))).toString() : (String) invokeL.objValue;
    }

    public static String getTimeZoneDisplay(TimeZone timeZone, boolean z, int i2, Locale locale) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{timeZone, Boolean.valueOf(z), Integer.valueOf(i2), locale})) == null) {
            TimeZoneDisplayKey timeZoneDisplayKey = new TimeZoneDisplayKey(timeZone, z, i2, locale);
            String str = cTimeZoneDisplayCache.get(timeZoneDisplayKey);
            if (str == null) {
                String displayName = timeZone.getDisplayName(z, i2, locale);
                String putIfAbsent = cTimeZoneDisplayCache.putIfAbsent(timeZoneDisplayKey, displayName);
                return putIfAbsent != null ? putIfAbsent : displayName;
            }
            return str;
        }
        return (String) invokeCommon.objValue;
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65545, this) != null) {
            return;
        }
        List<Rule> parsePattern = parsePattern();
        Rule[] ruleArr = (Rule[]) parsePattern.toArray(new Rule[parsePattern.size()]);
        this.mRules = ruleArr;
        int length = ruleArr.length;
        int i2 = 0;
        while (true) {
            length--;
            if (length >= 0) {
                i2 += this.mRules[length].estimateLength();
            } else {
                this.mMaxLengthEstimate = i2;
                return;
            }
        }
    }

    private Calendar newCalendar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? Calendar.getInstance(this.mTimeZone, this.mLocale) : (Calendar) invokeV.objValue;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, objectInputStream) == null) {
            objectInputStream.defaultReadObject();
            init();
        }
    }

    @Deprecated
    public StringBuffer applyRules(Calendar calendar, StringBuffer stringBuffer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, calendar, stringBuffer)) == null) ? (StringBuffer) applyRules(calendar, (Calendar) stringBuffer) : (StringBuffer) invokeLL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj instanceof FastDatePrinter) {
                FastDatePrinter fastDatePrinter = (FastDatePrinter) obj;
                return this.mPattern.equals(fastDatePrinter.mPattern) && this.mTimeZone.equals(fastDatePrinter.mTimeZone) && this.mLocale.equals(fastDatePrinter.mLocale);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    @Deprecated
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, obj, stringBuffer, fieldPosition)) == null) {
            if (obj instanceof Date) {
                return format((Date) obj, stringBuffer);
            }
            if (obj instanceof Calendar) {
                return format((Calendar) obj, stringBuffer);
            }
            if (obj instanceof Long) {
                return format(((Long) obj).longValue(), stringBuffer);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unknown class: ");
            sb.append(obj == null ? "<null>" : obj.getClass().getName());
            throw new IllegalArgumentException(sb.toString());
        }
        return (StringBuffer) invokeLLL.objValue;
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public Locale getLocale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mLocale : (Locale) invokeV.objValue;
    }

    public int getMaxLengthEstimate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mMaxLengthEstimate : invokeV.intValue;
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public String getPattern() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mPattern : (String) invokeV.objValue;
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public TimeZone getTimeZone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mTimeZone : (TimeZone) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mPattern.hashCode() + ((this.mTimeZone.hashCode() + (this.mLocale.hashCode() * 13)) * 13) : invokeV.intValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:86:0x0181 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v17, types: [org.apache.commons.lang3.time.FastDatePrinter$TextField] */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v12, types: [org.apache.commons.lang3.time.FastDatePrinter$StringLiteral] */
    /* JADX WARN: Type inference failed for: r9v13, types: [org.apache.commons.lang3.time.FastDatePrinter$CharacterLiteral] */
    /* JADX WARN: Type inference failed for: r9v15, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v17, types: [org.apache.commons.lang3.time.FastDatePrinter$UnpaddedMonthField] */
    /* JADX WARN: Type inference failed for: r9v18, types: [org.apache.commons.lang3.time.FastDatePrinter$TwoDigitMonthField] */
    /* JADX WARN: Type inference failed for: r9v19, types: [org.apache.commons.lang3.time.FastDatePrinter$TextField] */
    /* JADX WARN: Type inference failed for: r9v20, types: [org.apache.commons.lang3.time.FastDatePrinter$TextField] */
    /* JADX WARN: Type inference failed for: r9v22, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v23, types: [org.apache.commons.lang3.time.FastDatePrinter$TextField] */
    /* JADX WARN: Type inference failed for: r9v25, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v26, types: [org.apache.commons.lang3.time.FastDatePrinter$TwelveHourField] */
    /* JADX WARN: Type inference failed for: r9v27, types: [org.apache.commons.lang3.time.FastDatePrinter$TwentyFourHourField] */
    /* JADX WARN: Type inference failed for: r9v29, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v31, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v32, types: [org.apache.commons.lang3.time.FastDatePrinter$DayInWeekField] */
    /* JADX WARN: Type inference failed for: r9v34, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v36, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v41, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v42, types: [org.apache.commons.lang3.time.FastDatePrinter$TextField] */
    /* JADX WARN: Type inference failed for: r9v45, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v46, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v47, types: [org.apache.commons.lang3.time.FastDatePrinter$Iso8601_Rule] */
    /* JADX WARN: Type inference failed for: r9v50, types: [org.apache.commons.lang3.time.FastDatePrinter$TimeZoneNumberRule] */
    /* JADX WARN: Type inference failed for: r9v51, types: [org.apache.commons.lang3.time.FastDatePrinter$Iso8601_Rule] */
    /* JADX WARN: Type inference failed for: r9v52, types: [org.apache.commons.lang3.time.FastDatePrinter$TimeZoneNumberRule] */
    /* JADX WARN: Type inference failed for: r9v7, types: [org.apache.commons.lang3.time.FastDatePrinter$TimeZoneNameRule] */
    /* JADX WARN: Type inference failed for: r9v8, types: [org.apache.commons.lang3.time.FastDatePrinter$TimeZoneNameRule] */
    public List<Rule> parsePattern() {
        InterceptResult invokeV;
        int i2;
        WeekYear selectNumberRule;
        ?? timeZoneNameRule;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(this.mLocale);
            ArrayList arrayList = new ArrayList();
            String[] eras = dateFormatSymbols.getEras();
            String[] months = dateFormatSymbols.getMonths();
            String[] shortMonths = dateFormatSymbols.getShortMonths();
            String[] weekdays = dateFormatSymbols.getWeekdays();
            String[] shortWeekdays = dateFormatSymbols.getShortWeekdays();
            String[] amPmStrings = dateFormatSymbols.getAmPmStrings();
            int length = this.mPattern.length();
            int[] iArr = new int[1];
            int i3 = 0;
            int i4 = 0;
            while (i4 < length) {
                iArr[i3] = i4;
                String parseToken = parseToken(this.mPattern, iArr);
                int i5 = iArr[i3];
                int length2 = parseToken.length();
                if (length2 == 0) {
                    return arrayList;
                }
                char charAt = parseToken.charAt(i3);
                if (charAt != 'y') {
                    if (charAt != 'z') {
                        switch (charAt) {
                            case '\'':
                                String substring = parseToken.substring(1);
                                if (substring.length() == 1) {
                                    timeZoneNameRule = new CharacterLiteral(substring.charAt(0));
                                    break;
                                } else {
                                    timeZoneNameRule = new StringLiteral(substring);
                                    break;
                                }
                            case 'K':
                                timeZoneNameRule = selectNumberRule(10, length2);
                                break;
                            case 'M':
                                if (length2 < 4) {
                                    if (length2 != 3) {
                                        if (length2 == 2) {
                                            timeZoneNameRule = TwoDigitMonthField.INSTANCE;
                                            break;
                                        } else {
                                            timeZoneNameRule = UnpaddedMonthField.INSTANCE;
                                            break;
                                        }
                                    } else {
                                        timeZoneNameRule = new TextField(2, shortMonths);
                                        break;
                                    }
                                } else {
                                    timeZoneNameRule = new TextField(2, months);
                                    break;
                                }
                            case 'S':
                                timeZoneNameRule = selectNumberRule(14, length2);
                                break;
                            case 'a':
                                timeZoneNameRule = new TextField(9, amPmStrings);
                                break;
                            case 'd':
                                timeZoneNameRule = selectNumberRule(5, length2);
                                break;
                            case 'h':
                                timeZoneNameRule = new TwelveHourField(selectNumberRule(10, length2));
                                break;
                            case 'k':
                                timeZoneNameRule = new TwentyFourHourField(selectNumberRule(11, length2));
                                break;
                            case 'm':
                                timeZoneNameRule = selectNumberRule(12, length2);
                                break;
                            case 's':
                                timeZoneNameRule = selectNumberRule(13, length2);
                                break;
                            case 'u':
                                timeZoneNameRule = new DayInWeekField(selectNumberRule(7, length2));
                                break;
                            case 'w':
                                timeZoneNameRule = selectNumberRule(3, length2);
                                break;
                            default:
                                switch (charAt) {
                                    case 'D':
                                        timeZoneNameRule = selectNumberRule(6, length2);
                                        break;
                                    case 'E':
                                        selectNumberRule = new TextField(7, length2 < 4 ? shortWeekdays : weekdays);
                                        i3 = 0;
                                        break;
                                    case 'F':
                                        timeZoneNameRule = selectNumberRule(8, length2);
                                        break;
                                    case 'G':
                                        i3 = 0;
                                        selectNumberRule = new TextField(0, eras);
                                        break;
                                    case 'H':
                                        timeZoneNameRule = selectNumberRule(11, length2);
                                        break;
                                    default:
                                        switch (charAt) {
                                            case 'W':
                                                timeZoneNameRule = selectNumberRule(4, length2);
                                                break;
                                            case 'X':
                                                timeZoneNameRule = Iso8601_Rule.getRule(length2);
                                                break;
                                            case 'Y':
                                                break;
                                            case 'Z':
                                                if (length2 != 1) {
                                                    if (length2 == 2) {
                                                        timeZoneNameRule = Iso8601_Rule.ISO8601_HOURS_COLON_MINUTES;
                                                        break;
                                                    } else {
                                                        timeZoneNameRule = TimeZoneNumberRule.INSTANCE_COLON;
                                                        break;
                                                    }
                                                } else {
                                                    timeZoneNameRule = TimeZoneNumberRule.INSTANCE_NO_COLON;
                                                    break;
                                                }
                                            default:
                                                throw new IllegalArgumentException("Illegal pattern component: " + parseToken);
                                        }
                                }
                        }
                        arrayList.add(selectNumberRule);
                        i4 = i5 + 1;
                    } else if (length2 >= 4) {
                        timeZoneNameRule = new TimeZoneNameRule(this.mTimeZone, this.mLocale, 1);
                    } else {
                        timeZoneNameRule = new TimeZoneNameRule(this.mTimeZone, this.mLocale, 0);
                    }
                    selectNumberRule = timeZoneNameRule;
                    i3 = 0;
                    arrayList.add(selectNumberRule);
                    i4 = i5 + 1;
                }
                i3 = 0;
                if (length2 == 2) {
                    selectNumberRule = TwoDigitYearField.INSTANCE;
                } else {
                    if (length2 < 4) {
                        i2 = 1;
                        length2 = 4;
                    } else {
                        i2 = 1;
                    }
                    selectNumberRule = selectNumberRule(i2, length2);
                }
                if (charAt == 'Y') {
                    selectNumberRule = new WeekYear(selectNumberRule);
                }
                arrayList.add(selectNumberRule);
                i4 = i5 + 1;
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public String parseToken(String str, int[] iArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, str, iArr)) == null) {
            StringBuilder sb = new StringBuilder();
            int i2 = iArr[0];
            int length = str.length();
            char charAt = str.charAt(i2);
            if ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z')) {
                sb.append(charAt);
                while (true) {
                    int i3 = i2 + 1;
                    if (i3 >= length || str.charAt(i3) != charAt) {
                        break;
                    }
                    sb.append(charAt);
                    i2 = i3;
                }
            } else {
                sb.append(ExtendedMessageFormat.QUOTE);
                boolean z = false;
                while (i2 < length) {
                    char charAt2 = str.charAt(i2);
                    if (charAt2 != '\'') {
                        if (!z && ((charAt2 >= 'A' && charAt2 <= 'Z') || (charAt2 >= 'a' && charAt2 <= 'z'))) {
                            i2--;
                            break;
                        }
                        sb.append(charAt2);
                    } else {
                        int i4 = i2 + 1;
                        if (i4 >= length || str.charAt(i4) != '\'') {
                            z = !z;
                        } else {
                            sb.append(charAt2);
                            i2 = i4;
                        }
                    }
                    i2++;
                }
            }
            iArr[0] = i2;
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public NumberRule selectNumberRule(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048596, this, i2, i3)) == null) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return new PaddedNumberField(i2, i3);
                }
                return new TwoDigitNumberField(i2);
            }
            return new UnpaddedNumberField(i2);
        }
        return (NumberRule) invokeII.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return "FastDatePrinter[" + this.mPattern + "," + this.mLocale + "," + this.mTimeZone.getID() + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public static class DayInWeekField implements NumberRule {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final NumberRule mRule;

        public DayInWeekField(NumberRule numberRule) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {numberRule};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mRule = numberRule;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, appendable, calendar) == null) {
                int i2 = calendar.get(7);
                this.mRule.appendTo(appendable, i2 != 1 ? i2 - 1 : 7);
            }
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mRule.estimateLength() : invokeV.intValue;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, appendable, i2) == null) {
                this.mRule.appendTo(appendable, i2);
            }
        }
    }

    private <B extends Appendable> B applyRules(Calendar calendar, B b2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, this, calendar, b2)) == null) {
            try {
                for (Rule rule : this.mRules) {
                    rule.appendTo(b2, calendar);
                }
            } catch (IOException e2) {
                ExceptionUtils.rethrow(e2);
            }
            return b2;
        }
        return (B) invokeLL.objValue;
    }

    /* loaded from: classes5.dex */
    public static class TwelveHourField implements NumberRule {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final NumberRule mRule;

        public TwelveHourField(NumberRule numberRule) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {numberRule};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mRule = numberRule;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, appendable, calendar) == null) {
                int i2 = calendar.get(10);
                if (i2 == 0) {
                    i2 = calendar.getLeastMaximum(10) + 1;
                }
                this.mRule.appendTo(appendable, i2);
            }
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mRule.estimateLength() : invokeV.intValue;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, appendable, i2) == null) {
                this.mRule.appendTo(appendable, i2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class TwentyFourHourField implements NumberRule {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final NumberRule mRule;

        public TwentyFourHourField(NumberRule numberRule) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {numberRule};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mRule = numberRule;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, appendable, calendar) == null) {
                int i2 = calendar.get(11);
                if (i2 == 0) {
                    i2 = calendar.getMaximum(11) + 1;
                }
                this.mRule.appendTo(appendable, i2);
            }
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mRule.estimateLength() : invokeV.intValue;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, appendable, i2) == null) {
                this.mRule.appendTo(appendable, i2);
            }
        }
    }

    public String format(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (obj instanceof Date) {
                return format((Date) obj);
            }
            if (obj instanceof Calendar) {
                return format((Calendar) obj);
            }
            if (obj instanceof Long) {
                return format(((Long) obj).longValue());
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unknown class: ");
            sb.append(obj == null ? "<null>" : obj.getClass().getName());
            throw new IllegalArgumentException(sb.toString());
        }
        return (String) invokeL.objValue;
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public String format(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
            Calendar newCalendar = newCalendar();
            newCalendar.setTimeInMillis(j2);
            return applyRulesToString(newCalendar);
        }
        return (String) invokeJ.objValue;
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public String format(Date date) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, date)) == null) {
            Calendar newCalendar = newCalendar();
            newCalendar.setTime(date);
            return applyRulesToString(newCalendar);
        }
        return (String) invokeL.objValue;
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public String format(Calendar calendar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, calendar)) == null) ? ((StringBuilder) format(calendar, (Calendar) new StringBuilder(this.mMaxLengthEstimate))).toString() : (String) invokeL.objValue;
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public StringBuffer format(long j2, StringBuffer stringBuffer) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048585, this, j2, stringBuffer)) == null) {
            Calendar newCalendar = newCalendar();
            newCalendar.setTimeInMillis(j2);
            return (StringBuffer) applyRules(newCalendar, (Calendar) stringBuffer);
        }
        return (StringBuffer) invokeJL.objValue;
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public StringBuffer format(Date date, StringBuffer stringBuffer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, date, stringBuffer)) == null) {
            Calendar newCalendar = newCalendar();
            newCalendar.setTime(date);
            return (StringBuffer) applyRules(newCalendar, (Calendar) stringBuffer);
        }
        return (StringBuffer) invokeLL.objValue;
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public StringBuffer format(Calendar calendar, StringBuffer stringBuffer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, calendar, stringBuffer)) == null) ? format(calendar.getTime(), stringBuffer) : (StringBuffer) invokeLL.objValue;
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public <B extends Appendable> B format(long j2, B b2) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j2, b2)) == null) {
            Calendar newCalendar = newCalendar();
            newCalendar.setTimeInMillis(j2);
            return (B) applyRules(newCalendar, (Calendar) b2);
        }
        return (B) invokeJL.objValue;
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public <B extends Appendable> B format(Date date, B b2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, date, b2)) == null) {
            Calendar newCalendar = newCalendar();
            newCalendar.setTime(date);
            return (B) applyRules(newCalendar, (Calendar) b2);
        }
        return (B) invokeLL.objValue;
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public <B extends Appendable> B format(Calendar calendar, B b2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, calendar, b2)) == null) {
            if (!calendar.getTimeZone().equals(this.mTimeZone)) {
                calendar = (Calendar) calendar.clone();
                calendar.setTimeZone(this.mTimeZone);
            }
            return (B) applyRules(calendar, (Calendar) b2);
        }
        return (B) invokeLL.objValue;
    }
}
