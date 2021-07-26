package okhttp3;

import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.encrypt.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
        public String domain;
        public long expiresAt;
        public boolean hostOnly;
        public boolean httpOnly;
        public String name;
        public String path;
        public boolean persistent;
        public boolean secure;
        public String value;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.expiresAt = HttpDate.MAX_DATE;
            this.path = "/";
        }

        public Cookie build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new Cookie(this) : (Cookie) invokeV.objValue;
        }

        public Builder domain(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? domain(str, false) : (Builder) invokeL.objValue;
        }

        public Builder expiresAt(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
                if (j <= 0) {
                    j = Long.MIN_VALUE;
                }
                if (j > HttpDate.MAX_DATE) {
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
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? domain(str, true) : (Builder) invokeL.objValue;
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

        public Builder secure() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                this.secure = true;
                return this;
            }
            return (Builder) invokeV.objValue;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    public static int dateCharacterOffset(String str, int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (((charAt < ' ' && charAt != '\t') || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z)) {
                    return i2;
                }
                i2++;
            }
            return i3;
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
            return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !Util.verifyAsIpAddress(str);
        }
        return invokeLL.booleanValue;
    }

    @Nullable
    public static Cookie parse(HttpUrl httpUrl, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, httpUrl, str)) == null) ? parse(System.currentTimeMillis(), httpUrl, str) : (Cookie) invokeLL.objValue;
    }

    public static List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, httpUrl, headers)) == null) {
            List<String> values = headers.values("Set-Cookie");
            int size = values.size();
            ArrayList arrayList = null;
            for (int i2 = 0; i2 < size; i2++) {
                Cookie parse = parse(httpUrl, values.get(i2));
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

    public static long parseExpires(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65545, null, str, i2, i3)) == null) {
            int dateCharacterOffset = dateCharacterOffset(str, i2, i3, false);
            Matcher matcher = TIME_PATTERN.matcher(str);
            int i4 = -1;
            int i5 = -1;
            int i6 = -1;
            int i7 = -1;
            int i8 = -1;
            int i9 = -1;
            while (dateCharacterOffset < i3) {
                int dateCharacterOffset2 = dateCharacterOffset(str, dateCharacterOffset + 1, i3, true);
                matcher.region(dateCharacterOffset, dateCharacterOffset2);
                if (i5 == -1 && matcher.usePattern(TIME_PATTERN).matches()) {
                    i5 = Integer.parseInt(matcher.group(1));
                    i8 = Integer.parseInt(matcher.group(2));
                    i9 = Integer.parseInt(matcher.group(3));
                } else if (i6 == -1 && matcher.usePattern(DAY_OF_MONTH_PATTERN).matches()) {
                    i6 = Integer.parseInt(matcher.group(1));
                } else if (i7 == -1 && matcher.usePattern(MONTH_PATTERN).matches()) {
                    i7 = MONTH_PATTERN.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                } else if (i4 == -1 && matcher.usePattern(YEAR_PATTERN).matches()) {
                    i4 = Integer.parseInt(matcher.group(1));
                }
                dateCharacterOffset = dateCharacterOffset(str, dateCharacterOffset2 + 1, i3, false);
            }
            if (i4 >= 70 && i4 <= 99) {
                i4 += FeatureCodes.SKY_SEG;
            }
            if (i4 >= 0 && i4 <= 69) {
                i4 += 2000;
            }
            if (i4 >= 1601) {
                if (i7 != -1) {
                    if (i6 < 1 || i6 > 31) {
                        throw new IllegalArgumentException();
                    }
                    if (i5 < 0 || i5 > 23) {
                        throw new IllegalArgumentException();
                    }
                    if (i8 < 0 || i8 > 59) {
                        throw new IllegalArgumentException();
                    }
                    if (i9 >= 0 && i9 <= 59) {
                        GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.UTC);
                        gregorianCalendar.setLenient(false);
                        gregorianCalendar.set(1, i4);
                        gregorianCalendar.set(2, i7 - 1);
                        gregorianCalendar.set(5, i6);
                        gregorianCalendar.set(11, i5);
                        gregorianCalendar.set(12, i8);
                        gregorianCalendar.set(13, i9);
                        gregorianCalendar.set(14, 0);
                        return gregorianCalendar.getTimeInMillis();
                    }
                    throw new IllegalArgumentException();
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException();
        }
        return invokeLII.longValue;
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
            } catch (NumberFormatException e2) {
                if (str.matches("-?\\d+")) {
                    return str.startsWith("-") ? Long.MIN_VALUE : Long.MAX_VALUE;
                }
                throw e2;
            }
        }
        return invokeL.longValue;
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
                return str.endsWith("/") || encodedPath.charAt(str.length()) == '/';
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public String domain() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.domain : (String) invokeV.objValue;
    }

    public boolean equals(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj instanceof Cookie) {
                Cookie cookie = (Cookie) obj;
                return cookie.name.equals(this.name) && cookie.value.equals(this.value) && cookie.domain.equals(this.domain) && cookie.path.equals(this.path) && cookie.expiresAt == this.expiresAt && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public long expiresAt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.expiresAt : invokeV.longValue;
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

    public boolean hostOnly() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.hostOnly : invokeV.booleanValue;
    }

    public boolean httpOnly() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.httpOnly : invokeV.booleanValue;
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
            if (domainMatch && pathMatch(httpUrl, this.path)) {
                return !this.secure || httpUrl.isHttps();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public String name() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.name : (String) invokeV.objValue;
    }

    public String path() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.path : (String) invokeV.objValue;
    }

    public boolean persistent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.persistent : invokeV.booleanValue;
    }

    public boolean secure() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.secure : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? toString(false) : (String) invokeV.objValue;
    }

    public String value() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.value : (String) invokeV.objValue;
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
        String host;
        Cookie cookie;
        String str2;
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{Long.valueOf(j), httpUrl, str})) == null) {
            int length = str.length();
            char c2 = ';';
            int delimiterOffset = Util.delimiterOffset(str, 0, length, ';');
            char c3 = a.f1923h;
            int delimiterOffset2 = Util.delimiterOffset(str, 0, delimiterOffset, (char) a.f1923h);
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
            int i2 = delimiterOffset + 1;
            String str3 = null;
            String str4 = null;
            long j3 = -1;
            long j4 = 253402300799999L;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = true;
            boolean z4 = false;
            while (i2 < length) {
                int delimiterOffset3 = Util.delimiterOffset(str, i2, length, c2);
                int delimiterOffset4 = Util.delimiterOffset(str, i2, delimiterOffset3, c3);
                String trimSubstring3 = Util.trimSubstring(str, i2, delimiterOffset4);
                String trimSubstring4 = delimiterOffset4 < delimiterOffset3 ? Util.trimSubstring(str, delimiterOffset4 + 1, delimiterOffset3) : "";
                if (trimSubstring3.equalsIgnoreCase("expires")) {
                    try {
                        j4 = parseExpires(trimSubstring4, 0, trimSubstring4.length());
                    } catch (NumberFormatException | IllegalArgumentException unused) {
                    }
                } else if (trimSubstring3.equalsIgnoreCase(ClientCookie.MAX_AGE_ATTR)) {
                    j3 = parseMaxAge(trimSubstring4);
                } else {
                    if (trimSubstring3.equalsIgnoreCase("domain")) {
                        str4 = parseDomain(trimSubstring4);
                        z3 = false;
                    } else if (trimSubstring3.equalsIgnoreCase("path")) {
                        str3 = trimSubstring4;
                    } else if (trimSubstring3.equalsIgnoreCase(ClientCookie.SECURE_ATTR)) {
                        z = true;
                    } else if (trimSubstring3.equalsIgnoreCase("httponly")) {
                        z2 = true;
                    }
                    i2 = delimiterOffset3 + 1;
                    c2 = ';';
                    c3 = a.f1923h;
                }
                z4 = true;
                i2 = delimiterOffset3 + 1;
                c2 = ';';
                c3 = a.f1923h;
            }
            long j5 = Long.MIN_VALUE;
            if (j3 != Long.MIN_VALUE) {
                if (j3 != -1) {
                    j5 = j + (j3 <= 9223372036854775L ? j3 * 1000 : Long.MAX_VALUE);
                    if (j5 < j || j5 > HttpDate.MAX_DATE) {
                        j2 = 253402300799999L;
                    }
                } else {
                    j2 = j4;
                }
                host = httpUrl.host();
                if (str4 != null) {
                    str2 = host;
                    cookie = null;
                } else if (!domainMatch(host, str4)) {
                    return null;
                } else {
                    cookie = null;
                    str2 = str4;
                }
                if (host.length() == str2.length() && PublicSuffixDatabase.get().getEffectiveTldPlusOne(str2) == null) {
                    return cookie;
                }
                if (str3 == null && str3.startsWith("/")) {
                    substring = str3;
                } else {
                    String encodedPath = httpUrl.encodedPath();
                    int lastIndexOf = encodedPath.lastIndexOf(47);
                    substring = lastIndexOf != 0 ? encodedPath.substring(0, lastIndexOf) : "/";
                }
                return new Cookie(trimSubstring, trimSubstring2, j2, str2, substring, z, z2, z3, z4);
            }
            j2 = j5;
            host = httpUrl.host();
            if (str4 != null) {
            }
            if (host.length() == str2.length()) {
            }
            if (str3 == null) {
            }
            String encodedPath2 = httpUrl.encodedPath();
            int lastIndexOf2 = encodedPath2.lastIndexOf(47);
            substring = lastIndexOf2 != 0 ? encodedPath2.substring(0, lastIndexOf2) : "/";
            return new Cookie(trimSubstring, trimSubstring2, j2, str2, substring, z, z2, z3, z4);
        }
        return (Cookie) invokeCommon.objValue;
    }

    public String toString(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.name);
            sb.append(a.f1923h);
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

    public Cookie(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
}
