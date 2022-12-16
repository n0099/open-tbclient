package okhttp3;

import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.encrypt.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpDate;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes9.dex */
public final class Cookie {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern DAY_OF_MONTH_PATTERN;
    public static final Pattern MONTH_PATTERN;
    public static final Pattern TIME_PATTERN;
    public static final Pattern YEAR_PATTERN;
    public transient /* synthetic */ FieldHolder $fh;
    public final String domain;
    public final long expiresAt;
    public final boolean hostOnly;
    public final boolean httpOnly;
    public final String name;
    public final String path;
    public final boolean persistent;
    public final boolean secure;
    public final String value;

    /* loaded from: classes9.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public String domain;
        public long expiresAt;
        public boolean hostOnly;
        public boolean httpOnly;
        @Nullable
        public String name;
        public String path;
        public boolean persistent;
        public boolean secure;
        @Nullable
        public String value;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.expiresAt = 253402300799999L;
            this.path = "/";
        }

        public Cookie build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new Cookie(this);
            }
            return (Cookie) invokeV.objValue;
        }

        public Builder httpOnly() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                this.httpOnly = true;
                return this;
            }
            return (Builder) invokeV.objValue;
        }

        public Builder secure() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                this.secure = true;
                return this;
            }
            return (Builder) invokeV.objValue;
        }

        private Builder domain(String str, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, this, str, z)) == null) {
                if (str != null) {
                    String canonicalizeHost = Util.canonicalizeHost(str);
                    if (canonicalizeHost != null) {
                        this.domain = canonicalizeHost;
                        this.hostOnly = z;
                        return this;
                    }
                    throw new IllegalArgumentException("unexpected domain: " + str);
                }
                throw new NullPointerException("domain == null");
            }
            return (Builder) invokeLZ.objValue;
        }

        public Builder domain(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                return domain(str, false);
            }
            return (Builder) invokeL.objValue;
        }

        public Builder expiresAt(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
                if (j <= 0) {
                    j = Long.MIN_VALUE;
                }
                if (j > 253402300799999L) {
                    j = 253402300799999L;
                }
                this.expiresAt = j;
                this.persistent = true;
                return this;
            }
            return (Builder) invokeJ.objValue;
        }

        public Builder hostOnlyDomain(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                return domain(str, true);
            }
            return (Builder) invokeL.objValue;
        }

        public Builder name(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                if (str != null) {
                    if (str.trim().equals(str)) {
                        this.name = str;
                        return this;
                    }
                    throw new IllegalArgumentException("name is not trimmed");
                }
                throw new NullPointerException("name == null");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder path(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                if (str.startsWith("/")) {
                    this.path = str;
                    return this;
                }
                throw new IllegalArgumentException("path must start with '/'");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder value(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                if (str != null) {
                    if (str.trim().equals(str)) {
                        this.value = str;
                        return this;
                    }
                    throw new IllegalArgumentException("value is not trimmed");
                }
                throw new NullPointerException("value == null");
            }
            return (Builder) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1184070315, "Lokhttp3/Cookie;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1184070315, "Lokhttp3/Cookie;");
                return;
            }
        }
        YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
        MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
        DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
        TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    }

    public Cookie(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Long.valueOf(j), str3, str4, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.name = str;
        this.value = str2;
        this.expiresAt = j;
        this.domain = str3;
        this.path = str4;
        this.secure = z;
        this.httpOnly = z2;
        this.hostOnly = z3;
        this.persistent = z4;
    }

    public Cookie(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        String str = builder.name;
        if (str != null) {
            String str2 = builder.value;
            if (str2 != null) {
                String str3 = builder.domain;
                if (str3 != null) {
                    this.name = str;
                    this.value = str2;
                    this.expiresAt = builder.expiresAt;
                    this.domain = str3;
                    this.path = builder.path;
                    this.secure = builder.secure;
                    this.httpOnly = builder.httpOnly;
                    this.persistent = builder.persistent;
                    this.hostOnly = builder.hostOnly;
                    return;
                }
                throw new NullPointerException("builder.domain == null");
            }
            throw new NullPointerException("builder.value == null");
        }
        throw new NullPointerException("builder.name == null");
    }

    public String toString(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.name);
            sb.append(a.h);
            sb.append(this.value);
            if (this.persistent) {
                if (this.expiresAt == Long.MIN_VALUE) {
                    sb.append("; max-age=0");
                } else {
                    sb.append("; expires=");
                    sb.append(HttpDate.format(new Date(this.expiresAt)));
                }
            }
            if (!this.hostOnly) {
                sb.append("; domain=");
                if (z) {
                    sb.append(".");
                }
                sb.append(this.domain);
            }
            sb.append("; path=");
            sb.append(this.path);
            if (this.secure) {
                sb.append("; secure");
            }
            if (this.httpOnly) {
                sb.append("; httponly");
            }
            return sb.toString();
        }
        return (String) invokeZ.objValue;
    }

    public static int dateCharacterOffset(String str, int i, int i2, boolean z) {
        boolean z2;
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if ((charAt >= ' ' || charAt == '\t') && charAt < 127 && ((charAt < '0' || charAt > '9') && ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && charAt != ':')))) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z2 == (!z)) {
                    return i;
                }
                i++;
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    public static boolean domainMatch(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            if (str.equals(str2)) {
                return true;
            }
            if (str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !Util.verifyAsIpAddress(str)) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean pathMatch(HttpUrl httpUrl, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, httpUrl, str)) == null) {
            String encodedPath = httpUrl.encodedPath();
            if (encodedPath.equals(str)) {
                return true;
            }
            if (encodedPath.startsWith(str)) {
                if (str.endsWith("/") || encodedPath.charAt(str.length()) == '/') {
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x012c  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Cookie parse(long j, HttpUrl httpUrl, String str) {
        InterceptResult invokeCommon;
        long j2;
        long j3;
        String host;
        Cookie cookie;
        String str2;
        String str3;
        int lastIndexOf;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Long.valueOf(j), httpUrl, str})) == null) {
            int length = str.length();
            char c = WebvttCueParser.CHAR_SEMI_COLON;
            int delimiterOffset = Util.delimiterOffset(str, 0, length, (char) WebvttCueParser.CHAR_SEMI_COLON);
            char c2 = a.h;
            int delimiterOffset2 = Util.delimiterOffset(str, 0, delimiterOffset, (char) a.h);
            if (delimiterOffset2 == delimiterOffset) {
                return null;
            }
            String trimSubstring = Util.trimSubstring(str, 0, delimiterOffset2);
            if (trimSubstring.isEmpty() || Util.indexOfControlOrNonAscii(trimSubstring) != -1) {
                return null;
            }
            String trimSubstring2 = Util.trimSubstring(str, delimiterOffset2 + 1, delimiterOffset);
            if (Util.indexOfControlOrNonAscii(trimSubstring2) != -1) {
                return null;
            }
            int i = delimiterOffset + 1;
            String str6 = null;
            String str7 = null;
            long j4 = -1;
            long j5 = 253402300799999L;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = true;
            boolean z4 = false;
            while (i < length) {
                int delimiterOffset3 = Util.delimiterOffset(str, i, length, c);
                int delimiterOffset4 = Util.delimiterOffset(str, i, delimiterOffset3, c2);
                String trimSubstring3 = Util.trimSubstring(str, i, delimiterOffset4);
                if (delimiterOffset4 < delimiterOffset3) {
                    str5 = Util.trimSubstring(str, delimiterOffset4 + 1, delimiterOffset3);
                } else {
                    str5 = "";
                }
                if (trimSubstring3.equalsIgnoreCase("expires")) {
                    try {
                        j5 = parseExpires(str5, 0, str5.length());
                    } catch (NumberFormatException | IllegalArgumentException unused) {
                    }
                } else if (trimSubstring3.equalsIgnoreCase(ClientCookie.MAX_AGE_ATTR)) {
                    j4 = parseMaxAge(str5);
                } else {
                    if (trimSubstring3.equalsIgnoreCase("domain")) {
                        str7 = parseDomain(str5);
                        z3 = false;
                    } else if (trimSubstring3.equalsIgnoreCase("path")) {
                        str6 = str5;
                    } else if (trimSubstring3.equalsIgnoreCase(ClientCookie.SECURE_ATTR)) {
                        z = true;
                    } else if (trimSubstring3.equalsIgnoreCase("httponly")) {
                        z2 = true;
                    }
                    i = delimiterOffset3 + 1;
                    c = WebvttCueParser.CHAR_SEMI_COLON;
                    c2 = a.h;
                }
                z4 = true;
                i = delimiterOffset3 + 1;
                c = WebvttCueParser.CHAR_SEMI_COLON;
                c2 = a.h;
            }
            long j6 = Long.MIN_VALUE;
            if (j4 != Long.MIN_VALUE) {
                if (j4 != -1) {
                    if (j4 <= 9223372036854775L) {
                        j3 = j4 * 1000;
                    } else {
                        j3 = Long.MAX_VALUE;
                    }
                    j6 = j + j3;
                    if (j6 < j || j6 > 253402300799999L) {
                        j2 = 253402300799999L;
                    }
                } else {
                    j2 = j5;
                }
                host = httpUrl.host();
                if (str7 != null) {
                    str2 = host;
                    cookie = null;
                } else if (!domainMatch(host, str7)) {
                    return null;
                } else {
                    cookie = null;
                    str2 = str7;
                }
                if (host.length() == str2.length() && PublicSuffixDatabase.get().getEffectiveTldPlusOne(str2) == null) {
                    return cookie;
                }
                str3 = "/";
                if (str6 == null && str6.startsWith("/")) {
                    str4 = str6;
                } else {
                    String encodedPath = httpUrl.encodedPath();
                    lastIndexOf = encodedPath.lastIndexOf(47);
                    if (lastIndexOf != 0) {
                        str3 = encodedPath.substring(0, lastIndexOf);
                    }
                    str4 = str3;
                }
                return new Cookie(trimSubstring, trimSubstring2, j2, str2, str4, z, z2, z3, z4);
            }
            j2 = j6;
            host = httpUrl.host();
            if (str7 != null) {
            }
            if (host.length() == str2.length()) {
            }
            str3 = "/";
            if (str6 == null) {
            }
            String encodedPath2 = httpUrl.encodedPath();
            lastIndexOf = encodedPath2.lastIndexOf(47);
            if (lastIndexOf != 0) {
            }
            str4 = str3;
            return new Cookie(trimSubstring, trimSubstring2, j2, str2, str4, z, z2, z3, z4);
        }
        return (Cookie) invokeCommon.objValue;
    }

    public static long parseExpires(String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65545, null, str, i, i2)) == null) {
            int dateCharacterOffset = dateCharacterOffset(str, i, i2, false);
            Matcher matcher = TIME_PATTERN.matcher(str);
            int i3 = -1;
            int i4 = -1;
            int i5 = -1;
            int i6 = -1;
            int i7 = -1;
            int i8 = -1;
            while (dateCharacterOffset < i2) {
                int dateCharacterOffset2 = dateCharacterOffset(str, dateCharacterOffset + 1, i2, true);
                matcher.region(dateCharacterOffset, dateCharacterOffset2);
                if (i4 == -1 && matcher.usePattern(TIME_PATTERN).matches()) {
                    i4 = Integer.parseInt(matcher.group(1));
                    i7 = Integer.parseInt(matcher.group(2));
                    i8 = Integer.parseInt(matcher.group(3));
                } else if (i5 == -1 && matcher.usePattern(DAY_OF_MONTH_PATTERN).matches()) {
                    i5 = Integer.parseInt(matcher.group(1));
                } else if (i6 == -1 && matcher.usePattern(MONTH_PATTERN).matches()) {
                    i6 = MONTH_PATTERN.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                } else if (i3 == -1 && matcher.usePattern(YEAR_PATTERN).matches()) {
                    i3 = Integer.parseInt(matcher.group(1));
                }
                dateCharacterOffset = dateCharacterOffset(str, dateCharacterOffset2 + 1, i2, false);
            }
            if (i3 >= 70 && i3 <= 99) {
                i3 += FeatureCodes.SKY_SEG;
            }
            if (i3 >= 0 && i3 <= 69) {
                i3 += 2000;
            }
            if (i3 >= 1601) {
                if (i6 != -1) {
                    if (i5 >= 1 && i5 <= 31) {
                        if (i4 >= 0 && i4 <= 23) {
                            if (i7 >= 0 && i7 <= 59) {
                                if (i8 >= 0 && i8 <= 59) {
                                    GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.UTC);
                                    gregorianCalendar.setLenient(false);
                                    gregorianCalendar.set(1, i3);
                                    gregorianCalendar.set(2, i6 - 1);
                                    gregorianCalendar.set(5, i5);
                                    gregorianCalendar.set(11, i4);
                                    gregorianCalendar.set(12, i7);
                                    gregorianCalendar.set(13, i8);
                                    gregorianCalendar.set(14, 0);
                                    return gregorianCalendar.getTimeInMillis();
                                }
                                throw new IllegalArgumentException();
                            }
                            throw new IllegalArgumentException();
                        }
                        throw new IllegalArgumentException();
                    }
                    throw new IllegalArgumentException();
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException();
        }
        return invokeLII.longValue;
    }

    @Nullable
    public static Cookie parse(HttpUrl httpUrl, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, httpUrl, str)) == null) {
            return parse(System.currentTimeMillis(), httpUrl, str);
        }
        return (Cookie) invokeLL.objValue;
    }

    public static List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, httpUrl, headers)) == null) {
            List<String> values = headers.values("Set-Cookie");
            int size = values.size();
            ArrayList arrayList = null;
            for (int i = 0; i < size; i++) {
                Cookie parse = parse(httpUrl, values.get(i));
                if (parse != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(parse);
                }
            }
            if (arrayList != null) {
                return Collections.unmodifiableList(arrayList);
            }
            return Collections.emptyList();
        }
        return (List) invokeLL.objValue;
    }

    public static String parseDomain(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (!str.endsWith(".")) {
                if (str.startsWith(".")) {
                    str = str.substring(1);
                }
                String canonicalizeHost = Util.canonicalizeHost(str);
                if (canonicalizeHost != null) {
                    return canonicalizeHost;
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException();
        }
        return (String) invokeL.objValue;
    }

    public static long parseMaxAge(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong <= 0) {
                    return Long.MIN_VALUE;
                }
                return parseLong;
            } catch (NumberFormatException e) {
                if (str.matches("-?\\d+")) {
                    if (str.startsWith("-")) {
                        return Long.MIN_VALUE;
                    }
                    return Long.MAX_VALUE;
                }
                throw e;
            }
        }
        return invokeL.longValue;
    }

    public boolean matches(HttpUrl httpUrl) {
        InterceptResult invokeL;
        boolean domainMatch;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, httpUrl)) == null) {
            if (this.hostOnly) {
                domainMatch = httpUrl.host().equals(this.domain);
            } else {
                domainMatch = domainMatch(httpUrl.host(), this.domain);
            }
            if (!domainMatch || !pathMatch(httpUrl, this.path)) {
                return false;
            }
            if (this.secure && !httpUrl.isHttps()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public String domain() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.domain;
        }
        return (String) invokeV.objValue;
    }

    public long expiresAt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.expiresAt;
        }
        return invokeV.longValue;
    }

    public boolean hostOnly() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.hostOnly;
        }
        return invokeV.booleanValue;
    }

    public boolean httpOnly() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.httpOnly;
        }
        return invokeV.booleanValue;
    }

    public String name() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.name;
        }
        return (String) invokeV.objValue;
    }

    public String path() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.path;
        }
        return (String) invokeV.objValue;
    }

    public boolean persistent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.persistent;
        }
        return invokeV.booleanValue;
    }

    public boolean secure() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.secure;
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return toString(false);
        }
        return (String) invokeV.objValue;
    }

    public String value() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.value;
        }
        return (String) invokeV.objValue;
    }

    public boolean equals(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (!(obj instanceof Cookie)) {
                return false;
            }
            Cookie cookie = (Cookie) obj;
            if (!cookie.name.equals(this.name) || !cookie.value.equals(this.value) || !cookie.domain.equals(this.domain) || !cookie.path.equals(this.path) || cookie.expiresAt != this.expiresAt || cookie.secure != this.secure || cookie.httpOnly != this.httpOnly || cookie.persistent != this.persistent || cookie.hostOnly != this.hostOnly) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            long j = this.expiresAt;
            return ((((((((((((((((527 + this.name.hashCode()) * 31) + this.value.hashCode()) * 31) + this.domain.hashCode()) * 31) + this.path.hashCode()) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + (!this.secure ? 1 : 0)) * 31) + (!this.httpOnly ? 1 : 0)) * 31) + (!this.persistent ? 1 : 0)) * 31) + (!this.hostOnly ? 1 : 0);
        }
        return invokeV.intValue;
    }
}
