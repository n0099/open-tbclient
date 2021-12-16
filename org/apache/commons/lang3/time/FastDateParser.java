package org.apache.commons.lang3.time;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.utility.FileUtil;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class FastDateParser implements DateParser, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Strategy ABBREVIATED_YEAR_STRATEGY;
    public static final Strategy DAY_OF_MONTH_STRATEGY;
    public static final Strategy DAY_OF_WEEK_IN_MONTH_STRATEGY;
    public static final Strategy DAY_OF_WEEK_STRATEGY;
    public static final Strategy DAY_OF_YEAR_STRATEGY;
    public static final Strategy HOUR12_STRATEGY;
    public static final Strategy HOUR24_OF_DAY_STRATEGY;
    public static final Strategy HOUR_OF_DAY_STRATEGY;
    public static final Strategy HOUR_STRATEGY;
    public static final Locale JAPANESE_IMPERIAL;
    public static final Strategy LITERAL_YEAR_STRATEGY;
    public static final Comparator<String> LONGER_FIRST_LOWERCASE;
    public static final Strategy MILLISECOND_STRATEGY;
    public static final Strategy MINUTE_STRATEGY;
    public static final Strategy NUMBER_MONTH_STRATEGY;
    public static final Strategy SECOND_STRATEGY;
    public static final Strategy WEEK_OF_MONTH_STRATEGY;
    public static final Strategy WEEK_OF_YEAR_STRATEGY;
    public static final ConcurrentMap<Locale, Strategy>[] caches;
    public static final long serialVersionUID = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public final int century;
    public final Locale locale;
    public final String pattern;
    public transient List<StrategyAndWidth> patterns;
    public final int startYear;
    public final TimeZone timeZone;

    /* loaded from: classes4.dex */
    public static class CaseInsensitiveTextStrategy extends PatternStrategy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int field;
        public final Map<String, Integer> lKeyValues;
        public final Locale locale;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CaseInsensitiveTextStrategy(int i2, Calendar calendar, Locale locale) {
            super();
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), calendar, locale};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.field = i2;
            this.locale = locale;
            StringBuilder sb = new StringBuilder();
            sb.append("((?iu)");
            this.lKeyValues = FastDateParser.appendDisplayNames(calendar, locale, i2, sb);
            sb.setLength(sb.length() - 1);
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            createPattern(sb);
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.PatternStrategy
        public void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, fastDateParser, calendar, str) == null) {
                calendar.set(this.field, this.lKeyValues.get(str.toLowerCase(this.locale)).intValue());
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class CopyQuotedStrategy extends Strategy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String formatField;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CopyQuotedStrategy(String str) {
            super();
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.formatField = str;
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        public boolean isNumber() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        public boolean parse(FastDateParser fastDateParser, Calendar calendar, String str, ParsePosition parsePosition, int i2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{fastDateParser, calendar, str, parsePosition, Integer.valueOf(i2)})) == null) {
                for (int i3 = 0; i3 < this.formatField.length(); i3++) {
                    int index = parsePosition.getIndex() + i3;
                    if (index == str.length()) {
                        parsePosition.setErrorIndex(index);
                        return false;
                    } else if (this.formatField.charAt(i3) != str.charAt(index)) {
                        parsePosition.setErrorIndex(index);
                        return false;
                    }
                }
                parsePosition.setIndex(this.formatField.length() + parsePosition.getIndex());
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class ISO8601TimeZoneStrategy extends PatternStrategy {
        public static /* synthetic */ Interceptable $ic;
        public static final Strategy ISO_8601_1_STRATEGY;
        public static final Strategy ISO_8601_2_STRATEGY;
        public static final Strategy ISO_8601_3_STRATEGY;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(918162303, "Lorg/apache/commons/lang3/time/FastDateParser$ISO8601TimeZoneStrategy;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(918162303, "Lorg/apache/commons/lang3/time/FastDateParser$ISO8601TimeZoneStrategy;");
                    return;
                }
            }
            ISO_8601_1_STRATEGY = new ISO8601TimeZoneStrategy("(Z|(?:[+-]\\d{2}))");
            ISO_8601_2_STRATEGY = new ISO8601TimeZoneStrategy("(Z|(?:[+-]\\d{2}\\d{2}))");
            ISO_8601_3_STRATEGY = new ISO8601TimeZoneStrategy("(Z|(?:[+-]\\d{2}(?::)\\d{2}))");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ISO8601TimeZoneStrategy(String str) {
            super();
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            createPattern(str);
        }

        public static Strategy getStrategy(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 == 3) {
                            return ISO_8601_3_STRATEGY;
                        }
                        throw new IllegalArgumentException("invalid number of X");
                    }
                    return ISO_8601_2_STRATEGY;
                }
                return ISO_8601_1_STRATEGY;
            }
            return (Strategy) invokeI.objValue;
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.PatternStrategy
        public void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, fastDateParser, calendar, str) == null) {
                if (str.equals("Z")) {
                    calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
                    return;
                }
                calendar.setTimeZone(TimeZone.getTimeZone("GMT" + str));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class NumberStrategy extends Strategy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int field;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NumberStrategy(int i2) {
            super();
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.field = i2;
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        public boolean isNumber() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public int modify(FastDateParser fastDateParser, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fastDateParser, i2)) == null) ? i2 : invokeLI.intValue;
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        public boolean parse(FastDateParser fastDateParser, Calendar calendar, String str, ParsePosition parsePosition, int i2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{fastDateParser, calendar, str, parsePosition, Integer.valueOf(i2)})) == null) {
                int index = parsePosition.getIndex();
                int length = str.length();
                if (i2 == 0) {
                    while (index < length && Character.isWhitespace(str.charAt(index))) {
                        index++;
                    }
                    parsePosition.setIndex(index);
                } else {
                    int i3 = i2 + index;
                    if (length > i3) {
                        length = i3;
                    }
                }
                while (index < length && Character.isDigit(str.charAt(index))) {
                    index++;
                }
                if (parsePosition.getIndex() == index) {
                    parsePosition.setErrorIndex(index);
                    return false;
                }
                int parseInt = Integer.parseInt(str.substring(parsePosition.getIndex(), index));
                parsePosition.setIndex(index);
                calendar.set(this.field, modify(fastDateParser, parseInt));
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class PatternStrategy extends Strategy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Pattern pattern;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PatternStrategy() {
            super();
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public void createPattern(StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sb) == null) {
                createPattern(sb.toString());
            }
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        public boolean isNumber() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        public boolean parse(FastDateParser fastDateParser, Calendar calendar, String str, ParsePosition parsePosition, int i2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{fastDateParser, calendar, str, parsePosition, Integer.valueOf(i2)})) == null) {
                Matcher matcher = this.pattern.matcher(str.substring(parsePosition.getIndex()));
                if (!matcher.lookingAt()) {
                    parsePosition.setErrorIndex(parsePosition.getIndex());
                    return false;
                }
                parsePosition.setIndex(parsePosition.getIndex() + matcher.end(1));
                setCalendar(fastDateParser, calendar, matcher.group(1));
                return true;
            }
            return invokeCommon.booleanValue;
        }

        public abstract void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str);

        public void createPattern(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.pattern = Pattern.compile(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class Strategy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Strategy() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public boolean isNumber() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        public abstract boolean parse(FastDateParser fastDateParser, Calendar calendar, String str, ParsePosition parsePosition, int i2);
    }

    /* loaded from: classes4.dex */
    public static class StrategyAndWidth {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Strategy strategy;
        public final int width;

        public StrategyAndWidth(Strategy strategy, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {strategy, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.strategy = strategy;
            this.width = i2;
        }

        public int getMaxWidth(ListIterator<StrategyAndWidth> listIterator) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, listIterator)) == null) {
                if (this.strategy.isNumber() && listIterator.hasNext()) {
                    Strategy strategy = listIterator.next().strategy;
                    listIterator.previous();
                    if (strategy.isNumber()) {
                        return this.width;
                    }
                    return 0;
                }
                return 0;
            }
            return invokeL.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public class StrategyParser {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int currentIdx;
        public final Calendar definingCalendar;
        public final String pattern;
        public final /* synthetic */ FastDateParser this$0;

        public StrategyParser(FastDateParser fastDateParser, String str, Calendar calendar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fastDateParser, str, calendar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = fastDateParser;
            this.pattern = str;
            this.definingCalendar = calendar;
        }

        private StrategyAndWidth letterPattern(char c2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{Character.valueOf(c2)})) == null) {
                int i2 = this.currentIdx;
                do {
                    int i3 = this.currentIdx + 1;
                    this.currentIdx = i3;
                    if (i3 >= this.pattern.length()) {
                        break;
                    }
                } while (this.pattern.charAt(this.currentIdx) == c2);
                int i4 = this.currentIdx - i2;
                return new StrategyAndWidth(this.this$0.getStrategy(c2, i4, this.definingCalendar), i4);
            }
            return (StrategyAndWidth) invokeCommon.objValue;
        }

        private StrategyAndWidth literal() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
                StringBuilder sb = new StringBuilder();
                boolean z = false;
                while (this.currentIdx < this.pattern.length()) {
                    char charAt = this.pattern.charAt(this.currentIdx);
                    if (!z && FastDateParser.isFormatLetter(charAt)) {
                        break;
                    }
                    if (charAt == '\'') {
                        int i2 = this.currentIdx + 1;
                        this.currentIdx = i2;
                        if (i2 == this.pattern.length() || this.pattern.charAt(this.currentIdx) != '\'') {
                            z = !z;
                        }
                    }
                    this.currentIdx++;
                    sb.append(charAt);
                }
                if (!z) {
                    String sb2 = sb.toString();
                    return new StrategyAndWidth(new CopyQuotedStrategy(sb2), sb2.length());
                }
                throw new IllegalArgumentException("Unterminated quote");
            }
            return (StrategyAndWidth) invokeV.objValue;
        }

        public StrategyAndWidth getNextStrategy() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.currentIdx >= this.pattern.length()) {
                    return null;
                }
                char charAt = this.pattern.charAt(this.currentIdx);
                if (FastDateParser.isFormatLetter(charAt)) {
                    return letterPattern(charAt);
                }
                return literal();
            }
            return (StrategyAndWidth) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class TimeZoneStrategy extends PatternStrategy {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String GMT_OPTION = "GMT[+-]\\d{1,2}:\\d{2}";
        public static final int ID = 0;
        public static final String RFC_822_TIME_ZONE = "[+-]\\d{4}";
        public transient /* synthetic */ FieldHolder $fh;
        public final Locale locale;
        public final Map<String, TzInfo> tzNames;

        /* loaded from: classes4.dex */
        public static class TzInfo {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int dstOffset;
            public TimeZone zone;

            public TzInfo(TimeZone timeZone, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {timeZone, Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.zone = timeZone;
                this.dstOffset = z ? timeZone.getDSTSavings() : 0;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TimeZoneStrategy(Locale locale) {
            super();
            String[][] zoneStrings;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {locale};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.tzNames = new HashMap();
            this.locale = locale;
            StringBuilder sb = new StringBuilder();
            sb.append("((?iu)[+-]\\d{4}|GMT[+-]\\d{1,2}:\\d{2}");
            TreeSet<String> treeSet = new TreeSet(FastDateParser.LONGER_FIRST_LOWERCASE);
            for (String[] strArr : DateFormatSymbols.getInstance(locale).getZoneStrings()) {
                String str = strArr[0];
                if (!str.equalsIgnoreCase("GMT")) {
                    TimeZone timeZone = TimeZone.getTimeZone(str);
                    TzInfo tzInfo = new TzInfo(timeZone, false);
                    TzInfo tzInfo2 = tzInfo;
                    for (int i4 = 1; i4 < strArr.length; i4++) {
                        if (i4 == 3) {
                            tzInfo2 = new TzInfo(timeZone, true);
                        } else if (i4 == 5) {
                            tzInfo2 = tzInfo;
                        }
                        String lowerCase = strArr[i4].toLowerCase(locale);
                        if (treeSet.add(lowerCase)) {
                            this.tzNames.put(lowerCase, tzInfo2);
                        }
                    }
                }
            }
            for (String str2 : treeSet) {
                sb.append('|');
                FastDateParser.simpleQuote(sb, str2);
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            createPattern(sb);
        }

        @Override // org.apache.commons.lang3.time.FastDateParser.PatternStrategy
        public void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, fastDateParser, calendar, str) == null) {
                if (str.charAt(0) != '+' && str.charAt(0) != '-') {
                    if (str.regionMatches(true, 0, "GMT", 0, 3)) {
                        calendar.setTimeZone(TimeZone.getTimeZone(str.toUpperCase()));
                        return;
                    }
                    TzInfo tzInfo = this.tzNames.get(str.toLowerCase(this.locale));
                    calendar.set(16, tzInfo.dstOffset);
                    calendar.set(15, tzInfo.zone.getRawOffset());
                    return;
                }
                calendar.setTimeZone(TimeZone.getTimeZone("GMT" + str));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-451436661, "Lorg/apache/commons/lang3/time/FastDateParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-451436661, "Lorg/apache/commons/lang3/time/FastDateParser;");
                return;
            }
        }
        JAPANESE_IMPERIAL = new Locale("ja", "JP", "JP");
        LONGER_FIRST_LOWERCASE = new Comparator<String>() { // from class: org.apache.commons.lang3.time.FastDateParser.1
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
            @Override // java.util.Comparator
            public int compare(String str, String str2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) ? str2.compareTo(str) : invokeLL.intValue;
            }
        };
        caches = new ConcurrentMap[17];
        ABBREVIATED_YEAR_STRATEGY = new NumberStrategy(1) { // from class: org.apache.commons.lang3.time.FastDateParser.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r7);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Integer.valueOf(r7)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super(((Integer) newInitContext.callArgs[0]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // org.apache.commons.lang3.time.FastDateParser.NumberStrategy
            public int modify(FastDateParser fastDateParser, int i2) {
                InterceptResult invokeLI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLI = interceptable2.invokeLI(1048576, this, fastDateParser, i2)) == null) ? i2 < 100 ? fastDateParser.adjustYear(i2) : i2 : invokeLI.intValue;
            }
        };
        NUMBER_MONTH_STRATEGY = new NumberStrategy(2) { // from class: org.apache.commons.lang3.time.FastDateParser.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r7);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Integer.valueOf(r7)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super(((Integer) newInitContext.callArgs[0]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // org.apache.commons.lang3.time.FastDateParser.NumberStrategy
            public int modify(FastDateParser fastDateParser, int i2) {
                InterceptResult invokeLI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLI = interceptable2.invokeLI(1048576, this, fastDateParser, i2)) == null) ? i2 - 1 : invokeLI.intValue;
            }
        };
        LITERAL_YEAR_STRATEGY = new NumberStrategy(1);
        WEEK_OF_YEAR_STRATEGY = new NumberStrategy(3);
        WEEK_OF_MONTH_STRATEGY = new NumberStrategy(4);
        DAY_OF_YEAR_STRATEGY = new NumberStrategy(6);
        DAY_OF_MONTH_STRATEGY = new NumberStrategy(5);
        DAY_OF_WEEK_STRATEGY = new NumberStrategy(7) { // from class: org.apache.commons.lang3.time.FastDateParser.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r7);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Integer.valueOf(r7)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super(((Integer) newInitContext.callArgs[0]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // org.apache.commons.lang3.time.FastDateParser.NumberStrategy
            public int modify(FastDateParser fastDateParser, int i2) {
                InterceptResult invokeLI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLI = interceptable2.invokeLI(1048576, this, fastDateParser, i2)) == null) {
                    if (i2 != 7) {
                        return 1 + i2;
                    }
                    return 1;
                }
                return invokeLI.intValue;
            }
        };
        DAY_OF_WEEK_IN_MONTH_STRATEGY = new NumberStrategy(8);
        HOUR_OF_DAY_STRATEGY = new NumberStrategy(11);
        HOUR24_OF_DAY_STRATEGY = new NumberStrategy(11) { // from class: org.apache.commons.lang3.time.FastDateParser.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r7);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Integer.valueOf(r7)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super(((Integer) newInitContext.callArgs[0]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // org.apache.commons.lang3.time.FastDateParser.NumberStrategy
            public int modify(FastDateParser fastDateParser, int i2) {
                InterceptResult invokeLI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLI = interceptable2.invokeLI(1048576, this, fastDateParser, i2)) == null) {
                    if (i2 == 24) {
                        return 0;
                    }
                    return i2;
                }
                return invokeLI.intValue;
            }
        };
        HOUR12_STRATEGY = new NumberStrategy(10) { // from class: org.apache.commons.lang3.time.FastDateParser.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r7);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Integer.valueOf(r7)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super(((Integer) newInitContext.callArgs[0]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // org.apache.commons.lang3.time.FastDateParser.NumberStrategy
            public int modify(FastDateParser fastDateParser, int i2) {
                InterceptResult invokeLI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLI = interceptable2.invokeLI(1048576, this, fastDateParser, i2)) == null) {
                    if (i2 == 12) {
                        return 0;
                    }
                    return i2;
                }
                return invokeLI.intValue;
            }
        };
        HOUR_STRATEGY = new NumberStrategy(10);
        MINUTE_STRATEGY = new NumberStrategy(12);
        SECOND_STRATEGY = new NumberStrategy(13);
        MILLISECOND_STRATEGY = new NumberStrategy(14);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FastDateParser(String str, TimeZone timeZone, Locale locale) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public int adjustYear(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, this, i2)) == null) {
            int i3 = this.century + i2;
            return i2 >= this.startYear ? i3 : i3 + 100;
        }
        return invokeI.intValue;
    }

    public static Map<String, Integer> appendDisplayNames(Calendar calendar, Locale locale, int i2, StringBuilder sb) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65546, null, calendar, locale, i2, sb)) == null) {
            HashMap hashMap = new HashMap();
            Map<String, Integer> displayNames = calendar.getDisplayNames(i2, 0, locale);
            TreeSet treeSet = new TreeSet(LONGER_FIRST_LOWERCASE);
            for (Map.Entry<String, Integer> entry : displayNames.entrySet()) {
                String lowerCase = entry.getKey().toLowerCase(locale);
                if (treeSet.add(lowerCase)) {
                    hashMap.put(lowerCase, entry.getValue());
                }
            }
            Iterator it = treeSet.iterator();
            while (it.hasNext()) {
                simpleQuote(sb, (String) it.next()).append('|');
            }
            return hashMap;
        }
        return (Map) invokeLLIL.objValue;
    }

    public static ConcurrentMap<Locale, Strategy> getCache(int i2) {
        InterceptResult invokeI;
        ConcurrentMap<Locale, Strategy> concurrentMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i2)) == null) {
            synchronized (caches) {
                if (caches[i2] == null) {
                    caches[i2] = new ConcurrentHashMap(3);
                }
                concurrentMap = caches[i2];
            }
            return concurrentMap;
        }
        return (ConcurrentMap) invokeI.objValue;
    }

    private Strategy getLocaleSpecificStrategy(int i2, Calendar calendar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65548, this, i2, calendar)) == null) {
            ConcurrentMap<Locale, Strategy> cache = getCache(i2);
            Strategy strategy = cache.get(this.locale);
            if (strategy == null) {
                strategy = i2 == 15 ? new TimeZoneStrategy(this.locale) : new CaseInsensitiveTextStrategy(i2, calendar, this.locale);
                Strategy putIfAbsent = cache.putIfAbsent(this.locale, strategy);
                if (putIfAbsent != null) {
                    return putIfAbsent;
                }
            }
            return strategy;
        }
        return (Strategy) invokeIL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Strategy getStrategy(char c2, int i2, Calendar calendar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, this, new Object[]{Character.valueOf(c2), Integer.valueOf(i2), calendar})) == null) {
            if (c2 != 'y') {
                if (c2 != 'z') {
                    switch (c2) {
                        case 'D':
                            return DAY_OF_YEAR_STRATEGY;
                        case 'E':
                            return getLocaleSpecificStrategy(7, calendar);
                        case 'F':
                            return DAY_OF_WEEK_IN_MONTH_STRATEGY;
                        case 'G':
                            return getLocaleSpecificStrategy(0, calendar);
                        case 'H':
                            return HOUR_OF_DAY_STRATEGY;
                        default:
                            switch (c2) {
                                case 'K':
                                    return HOUR_STRATEGY;
                                case 'M':
                                    return i2 >= 3 ? getLocaleSpecificStrategy(2, calendar) : NUMBER_MONTH_STRATEGY;
                                case 'S':
                                    return MILLISECOND_STRATEGY;
                                case 'a':
                                    return getLocaleSpecificStrategy(9, calendar);
                                case 'd':
                                    return DAY_OF_MONTH_STRATEGY;
                                case 'h':
                                    return HOUR12_STRATEGY;
                                case 'k':
                                    return HOUR24_OF_DAY_STRATEGY;
                                case 'm':
                                    return MINUTE_STRATEGY;
                                case 's':
                                    return SECOND_STRATEGY;
                                case 'u':
                                    return DAY_OF_WEEK_STRATEGY;
                                case 'w':
                                    return WEEK_OF_YEAR_STRATEGY;
                                default:
                                    switch (c2) {
                                        case 'W':
                                            return WEEK_OF_MONTH_STRATEGY;
                                        case 'X':
                                            return ISO8601TimeZoneStrategy.getStrategy(i2);
                                        case 'Y':
                                            break;
                                        case 'Z':
                                            if (i2 == 2) {
                                                return ISO8601TimeZoneStrategy.ISO_8601_3_STRATEGY;
                                            }
                                            break;
                                        default:
                                            throw new IllegalArgumentException("Format '" + c2 + "' not supported");
                                    }
                            }
                    }
                }
                return getLocaleSpecificStrategy(15, calendar);
            }
            return i2 > 2 ? LITERAL_YEAR_STRATEGY : ABBREVIATED_YEAR_STRATEGY;
        }
        return (Strategy) invokeCommon.objValue;
    }

    private void init(Calendar calendar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65550, this, calendar) != null) {
            return;
        }
        this.patterns = new ArrayList();
        StrategyParser strategyParser = new StrategyParser(this, this.pattern, calendar);
        while (true) {
            StrategyAndWidth nextStrategy = strategyParser.getNextStrategy();
            if (nextStrategy == null) {
                return;
            }
            this.patterns.add(nextStrategy);
        }
    }

    public static boolean isFormatLetter(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{Character.valueOf(c2)})) == null) ? (c2 >= 'A' && c2 <= 'Z') || (c2 >= 'a' && c2 <= 'z') : invokeCommon.booleanValue;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, objectInputStream) == null) {
            objectInputStream.defaultReadObject();
            init(Calendar.getInstance(this.timeZone, this.locale));
        }
    }

    public static StringBuilder simpleQuote(StringBuilder sb, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, sb, str)) == null) {
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (charAt != '$' && charAt != '.' && charAt != '?' && charAt != '^' && charAt != '[' && charAt != '\\' && charAt != '{' && charAt != '|') {
                    switch (charAt) {
                        case '(':
                        case ')':
                        case '*':
                        case '+':
                            break;
                        default:
                            sb.append(charAt);
                    }
                }
                sb.append(FileUtil.WINDOWS_SEPARATOR);
                sb.append(charAt);
            }
            return sb;
        }
        return (StringBuilder) invokeLL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj instanceof FastDateParser) {
                FastDateParser fastDateParser = (FastDateParser) obj;
                return this.pattern.equals(fastDateParser.pattern) && this.timeZone.equals(fastDateParser.timeZone) && this.locale.equals(fastDateParser.locale);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // org.apache.commons.lang3.time.DateParser, org.apache.commons.lang3.time.DatePrinter
    public Locale getLocale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.locale : (Locale) invokeV.objValue;
    }

    @Override // org.apache.commons.lang3.time.DateParser, org.apache.commons.lang3.time.DatePrinter
    public String getPattern() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.pattern : (String) invokeV.objValue;
    }

    @Override // org.apache.commons.lang3.time.DateParser, org.apache.commons.lang3.time.DatePrinter
    public TimeZone getTimeZone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.timeZone : (TimeZone) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.pattern.hashCode() + ((this.timeZone.hashCode() + (this.locale.hashCode() * 13)) * 13) : invokeV.intValue;
    }

    @Override // org.apache.commons.lang3.time.DateParser
    public Date parse(String str) throws ParseException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            ParsePosition parsePosition = new ParsePosition(0);
            Date parse = parse(str, parsePosition);
            if (parse == null) {
                if (this.locale.equals(JAPANESE_IMPERIAL)) {
                    throw new ParseException("(The " + this.locale + " locale does not support dates before 1868 AD)\nUnparseable date: \"" + str, parsePosition.getErrorIndex());
                }
                throw new ParseException("Unparseable date: " + str, parsePosition.getErrorIndex());
            }
            return parse;
        }
        return (Date) invokeL.objValue;
    }

    @Override // org.apache.commons.lang3.time.DateParser
    public Object parseObject(String str) throws ParseException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? parse(str) : invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return "FastDateParser[" + this.pattern + "," + this.locale + "," + this.timeZone.getID() + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }

    public FastDateParser(String str, TimeZone timeZone, Locale locale, Date date) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, timeZone, locale, date};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.pattern = str;
        this.timeZone = timeZone;
        this.locale = locale;
        Calendar calendar = Calendar.getInstance(timeZone, locale);
        if (date != null) {
            calendar.setTime(date);
            i2 = calendar.get(1);
        } else if (locale.equals(JAPANESE_IMPERIAL)) {
            i2 = 0;
        } else {
            calendar.setTime(new Date());
            i2 = calendar.get(1) - 80;
        }
        int i5 = (i2 / 100) * 100;
        this.century = i5;
        this.startYear = i2 - i5;
        init(calendar);
    }

    @Override // org.apache.commons.lang3.time.DateParser
    public Object parseObject(String str, ParsePosition parsePosition) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, parsePosition)) == null) ? parse(str, parsePosition) : invokeLL.objValue;
    }

    @Override // org.apache.commons.lang3.time.DateParser
    public Date parse(String str, ParsePosition parsePosition) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, parsePosition)) == null) {
            Calendar calendar = Calendar.getInstance(this.timeZone, this.locale);
            calendar.clear();
            if (parse(str, parsePosition, calendar)) {
                return calendar.getTime();
            }
            return null;
        }
        return (Date) invokeLL.objValue;
    }

    @Override // org.apache.commons.lang3.time.DateParser
    public boolean parse(String str, ParsePosition parsePosition, Calendar calendar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, str, parsePosition, calendar)) == null) {
            ListIterator<StrategyAndWidth> listIterator = this.patterns.listIterator();
            while (listIterator.hasNext()) {
                StrategyAndWidth next = listIterator.next();
                if (!next.strategy.parse(this, calendar, str, parsePosition, next.getMaxWidth(listIterator))) {
                    return false;
                }
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
