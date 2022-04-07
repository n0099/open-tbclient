package okhttp3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.google.android.material.badge.BadgeDrawable;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import kotlin.text.Typography;
import okhttp3.internal.Util;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okio.Buffer;
/* loaded from: classes8.dex */
public final class HttpUrl {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
    public static final String FRAGMENT_ENCODE_SET = "";
    public static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
    public static final char[] HEX_DIGITS;
    public static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
    public static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
    public static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
    public static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";
    public static final String QUERY_ENCODE_SET = " \"'<>#";
    public static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public final String fragment;
    public final String host;
    public final String password;
    public final List<String> pathSegments;
    public final int port;
    @Nullable
    public final List<String> queryNamesAndValues;
    public final String scheme;
    public final String url;
    public final String username;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1534676096, "Lokhttp3/HttpUrl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1534676096, "Lokhttp3/HttpUrl;");
                return;
            }
        }
        HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public HttpUrl(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.scheme = builder.scheme;
        this.username = percentDecode(builder.encodedUsername, false);
        this.password = percentDecode(builder.encodedPassword, false);
        this.host = builder.host;
        this.port = builder.effectivePort();
        this.pathSegments = percentDecode(builder.encodedPathSegments, false);
        List<String> list = builder.encodedQueryNamesAndValues;
        this.queryNamesAndValues = list != null ? percentDecode(list, true) : null;
        String str = builder.encodedFragment;
        this.fragment = str != null ? percentDecode(str, false) : null;
        this.url = builder.toString();
    }

    public static String canonicalize(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), charset})) == null) {
            int i3 = i;
            while (i3 < i2) {
                int codePointAt = str.codePointAt(i3);
                if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || !z4)) {
                    if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || percentEncoded(str, i3, i2)))) && (codePointAt != 43 || !z3))) {
                        i3 += Character.charCount(codePointAt);
                    }
                }
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, i, i3);
                canonicalize(buffer, str, i3, i2, str2, z, z2, z3, z4, charset);
                return buffer.readUtf8();
            }
            return str.substring(i, i2);
        }
        return (String) invokeCommon.objValue;
    }

    public static int defaultPort(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (str.equals("http")) {
                return 80;
            }
            return str.equals("https") ? 443 : -1;
        }
        return invokeL.intValue;
    }

    public static HttpUrl get(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? new Builder().parse(null, str).build() : (HttpUrl) invokeL.objValue;
    }

    public static void namesAndValuesToQueryString(StringBuilder sb, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, sb, list) == null) {
            int size = list.size();
            for (int i = 0; i < size; i += 2) {
                String str = list.get(i);
                String str2 = list.get(i + 1);
                if (i > 0) {
                    sb.append('&');
                }
                sb.append(str);
                if (str2 != null) {
                    sb.append('=');
                    sb.append(str2);
                }
            }
        }
    }

    @Nullable
    public static HttpUrl parse(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            try {
                return get(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        return (HttpUrl) invokeL.objValue;
    }

    public static void pathSegmentsToString(StringBuilder sb, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, sb, list) == null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                sb.append(WebvttCueParser.CHAR_SLASH);
                sb.append(list.get(i));
            }
        }
    }

    public static String percentDecode(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65550, null, str, z)) == null) ? percentDecode(str, 0, str.length(), z) : (String) invokeLZ.objValue;
    }

    public static boolean percentEncoded(String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65553, null, str, i, i2)) == null) {
            int i3 = i + 2;
            return i3 < i2 && str.charAt(i) == '%' && Util.decodeHexDigit(str.charAt(i + 1)) != -1 && Util.decodeHexDigit(str.charAt(i3)) != -1;
        }
        return invokeLII.booleanValue;
    }

    public static List<String> queryStringToNamesAndValues(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i <= str.length()) {
                int indexOf = str.indexOf(38, i);
                if (indexOf == -1) {
                    indexOf = str.length();
                }
                int indexOf2 = str.indexOf(61, i);
                if (indexOf2 != -1 && indexOf2 <= indexOf) {
                    arrayList.add(str.substring(i, indexOf2));
                    arrayList.add(str.substring(indexOf2 + 1, indexOf));
                } else {
                    arrayList.add(str.substring(i, indexOf));
                    arrayList.add(null);
                }
                i = indexOf + 1;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Nullable
    public String encodedFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.fragment == null) {
                return null;
            }
            return this.url.substring(this.url.indexOf(35) + 1);
        }
        return (String) invokeV.objValue;
    }

    public String encodedPassword() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.password.isEmpty()) {
                return "";
            }
            return this.url.substring(this.url.indexOf(58, this.scheme.length() + 3) + 1, this.url.indexOf(64));
        }
        return (String) invokeV.objValue;
    }

    public String encodedPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int indexOf = this.url.indexOf(47, this.scheme.length() + 3);
            String str = this.url;
            return this.url.substring(indexOf, Util.delimiterOffset(str, indexOf, str.length(), "?#"));
        }
        return (String) invokeV.objValue;
    }

    public List<String> encodedPathSegments() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int indexOf = this.url.indexOf(47, this.scheme.length() + 3);
            String str = this.url;
            int delimiterOffset = Util.delimiterOffset(str, indexOf, str.length(), "?#");
            ArrayList arrayList = new ArrayList();
            while (indexOf < delimiterOffset) {
                int i = indexOf + 1;
                int delimiterOffset2 = Util.delimiterOffset(this.url, i, delimiterOffset, (char) WebvttCueParser.CHAR_SLASH);
                arrayList.add(this.url.substring(i, delimiterOffset2));
                indexOf = delimiterOffset2;
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Nullable
    public String encodedQuery() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.queryNamesAndValues == null) {
                return null;
            }
            int indexOf = this.url.indexOf(63) + 1;
            String str = this.url;
            return this.url.substring(indexOf, Util.delimiterOffset(str, indexOf, str.length(), '#'));
        }
        return (String) invokeV.objValue;
    }

    public String encodedUsername() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.username.isEmpty()) {
                return "";
            }
            int length = this.scheme.length() + 3;
            String str = this.url;
            return this.url.substring(length, Util.delimiterOffset(str, length, str.length(), ":@"));
        }
        return (String) invokeV.objValue;
    }

    public boolean equals(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) ? (obj instanceof HttpUrl) && ((HttpUrl) obj).url.equals(this.url) : invokeL.booleanValue;
    }

    @Nullable
    public String fragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.fragment : (String) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.url.hashCode() : invokeV.intValue;
    }

    public String host() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.host : (String) invokeV.objValue;
    }

    public boolean isHttps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.scheme.equals("https") : invokeV.booleanValue;
    }

    public Builder newBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            Builder builder = new Builder();
            builder.scheme = this.scheme;
            builder.encodedUsername = encodedUsername();
            builder.encodedPassword = encodedPassword();
            builder.host = this.host;
            builder.port = this.port != defaultPort(this.scheme) ? this.port : -1;
            builder.encodedPathSegments.clear();
            builder.encodedPathSegments.addAll(encodedPathSegments());
            builder.encodedQuery(encodedQuery());
            builder.encodedFragment = encodedFragment();
            return builder;
        }
        return (Builder) invokeV.objValue;
    }

    public String password() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.password : (String) invokeV.objValue;
    }

    public List<String> pathSegments() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.pathSegments : (List) invokeV.objValue;
    }

    public int pathSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.pathSegments.size() : invokeV.intValue;
    }

    public int port() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.port : invokeV.intValue;
    }

    @Nullable
    public String query() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.queryNamesAndValues == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            namesAndValuesToQueryString(sb, this.queryNamesAndValues);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public String queryParameter(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            List<String> list = this.queryNamesAndValues;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i = 0; i < size; i += 2) {
                if (str.equals(this.queryNamesAndValues.get(i))) {
                    return this.queryNamesAndValues.get(i + 1);
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public String queryParameterName(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) {
            List<String> list = this.queryNamesAndValues;
            if (list != null) {
                return list.get(i * 2);
            }
            throw new IndexOutOfBoundsException();
        }
        return (String) invokeI.objValue;
    }

    public Set<String> queryParameterNames() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.queryNamesAndValues == null) {
                return Collections.emptySet();
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int size = this.queryNamesAndValues.size();
            for (int i = 0; i < size; i += 2) {
                linkedHashSet.add(this.queryNamesAndValues.get(i));
            }
            return Collections.unmodifiableSet(linkedHashSet);
        }
        return (Set) invokeV.objValue;
    }

    public String queryParameterValue(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) {
            List<String> list = this.queryNamesAndValues;
            if (list != null) {
                return list.get((i * 2) + 1);
            }
            throw new IndexOutOfBoundsException();
        }
        return (String) invokeI.objValue;
    }

    public List<String> queryParameterValues(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
            if (this.queryNamesAndValues == null) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            int size = this.queryNamesAndValues.size();
            for (int i = 0; i < size; i += 2) {
                if (str.equals(this.queryNamesAndValues.get(i))) {
                    arrayList.add(this.queryNamesAndValues.get(i + 1));
                }
            }
            return Collections.unmodifiableList(arrayList);
        }
        return (List) invokeL.objValue;
    }

    public int querySize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            List<String> list = this.queryNamesAndValues;
            if (list != null) {
                return list.size() / 2;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public String redact() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? newBuilder("/...").username("").password("").build().toString() : (String) invokeV.objValue;
    }

    @Nullable
    public HttpUrl resolve(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            Builder newBuilder = newBuilder(str);
            if (newBuilder != null) {
                return newBuilder.build();
            }
            return null;
        }
        return (HttpUrl) invokeL.objValue;
    }

    public String scheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.scheme : (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.url : (String) invokeV.objValue;
    }

    @Nullable
    public String topPrivateDomain() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (Util.verifyAsIpAddress(this.host)) {
                return null;
            }
            return PublicSuffixDatabase.get().getEffectiveTldPlusOne(this.host);
        }
        return (String) invokeV.objValue;
    }

    public URI uri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            String builder = newBuilder().reencodeForUri().toString();
            try {
                return new URI(builder);
            } catch (URISyntaxException e) {
                try {
                    return URI.create(builder.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
                } catch (Exception unused) {
                    throw new RuntimeException(e);
                }
            }
        }
        return (URI) invokeV.objValue;
    }

    public URL url() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            try {
                return new URL(this.url);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
        return (URL) invokeV.objValue;
    }

    public String username() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.username : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String INVALID_HOST = "Invalid URL host";
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public String encodedFragment;
        public String encodedPassword;
        public final List<String> encodedPathSegments;
        @Nullable
        public List<String> encodedQueryNamesAndValues;
        public String encodedUsername;
        @Nullable
        public String host;
        public int port;
        @Nullable
        public String scheme;

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
            this.encodedUsername = "";
            this.encodedPassword = "";
            this.port = -1;
            ArrayList arrayList = new ArrayList();
            this.encodedPathSegments = arrayList;
            arrayList.add("");
        }

        public static String canonicalizeHost(String str, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, str, i, i2)) == null) ? Util.canonicalizeHost(HttpUrl.percentDecode(str, i, i2, false)) : (String) invokeLII.objValue;
        }

        private boolean isDot(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) ? str.equals(".") || str.equalsIgnoreCase("%2e") : invokeL.booleanValue;
        }

        private boolean isDotDot(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) ? str.equals(IStringUtil.TOP_PATH) || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e") : invokeL.booleanValue;
        }

        public static int parsePort(String str, int i, int i2) {
            InterceptResult invokeLII;
            int parseInt;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(65541, null, str, i, i2)) == null) {
                try {
                    parseInt = Integer.parseInt(HttpUrl.canonicalize(str, i, i2, "", false, false, false, true, null));
                } catch (NumberFormatException unused) {
                }
                if (parseInt <= 0 || parseInt > 65535) {
                    return -1;
                }
                return parseInt;
            }
            return invokeLII.intValue;
        }

        private void pop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65542, this) == null) {
                List<String> list = this.encodedPathSegments;
                if (list.remove(list.size() - 1).isEmpty() && !this.encodedPathSegments.isEmpty()) {
                    List<String> list2 = this.encodedPathSegments;
                    list2.set(list2.size() - 1, "");
                    return;
                }
                this.encodedPathSegments.add("");
            }
        }

        public static int portColonOffset(String str, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(65543, null, str, i, i2)) == null) {
                while (i < i2) {
                    char charAt = str.charAt(i);
                    if (charAt == ':') {
                        return i;
                    }
                    if (charAt == '[') {
                        do {
                            i++;
                            if (i < i2) {
                            }
                        } while (str.charAt(i) != ']');
                    }
                    i++;
                }
                return i2;
            }
            return invokeLII.intValue;
        }

        private void push(String str, int i, int i2, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                String canonicalize = HttpUrl.canonicalize(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true, null);
                if (isDot(canonicalize)) {
                    return;
                }
                if (isDotDot(canonicalize)) {
                    pop();
                    return;
                }
                List<String> list = this.encodedPathSegments;
                if (list.get(list.size() - 1).isEmpty()) {
                    List<String> list2 = this.encodedPathSegments;
                    list2.set(list2.size() - 1, canonicalize);
                } else {
                    this.encodedPathSegments.add(canonicalize);
                }
                if (z) {
                    this.encodedPathSegments.add("");
                }
            }
        }

        private void removeAllCanonicalQueryParameters(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65545, this, str) == null) {
                for (int size = this.encodedQueryNamesAndValues.size() - 2; size >= 0; size -= 2) {
                    if (str.equals(this.encodedQueryNamesAndValues.get(size))) {
                        this.encodedQueryNamesAndValues.remove(size + 1);
                        this.encodedQueryNamesAndValues.remove(size);
                        if (this.encodedQueryNamesAndValues.isEmpty()) {
                            this.encodedQueryNamesAndValues = null;
                            return;
                        }
                    }
                }
            }
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0030  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0048 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0045 -> B:13:0x002d). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void resolvePath(java.lang.String r11, int r12, int r13) {
            /*
                r10 = this;
                com.baidu.titan.sdk.runtime.Interceptable r0 = okhttp3.HttpUrl.Builder.$ic
                if (r0 != 0) goto L49
            L4:
                if (r12 != r13) goto L7
                return
            L7:
                char r0 = r11.charAt(r12)
                r1 = 47
                java.lang.String r2 = ""
                r3 = 1
                if (r0 == r1) goto L22
                r1 = 92
                if (r0 != r1) goto L17
                goto L22
            L17:
                java.util.List<java.lang.String> r0 = r10.encodedPathSegments
                int r1 = r0.size()
                int r1 = r1 - r3
                r0.set(r1, r2)
                goto L2d
            L22:
                java.util.List<java.lang.String> r0 = r10.encodedPathSegments
                r0.clear()
                java.util.List<java.lang.String> r0 = r10.encodedPathSegments
                r0.add(r2)
                goto L45
            L2d:
                r6 = r12
                if (r6 >= r13) goto L48
                java.lang.String r12 = "/\\"
                int r12 = okhttp3.internal.Util.delimiterOffset(r11, r6, r13, r12)
                if (r12 >= r13) goto L3a
                r0 = 1
                goto L3b
            L3a:
                r0 = 0
            L3b:
                r9 = 1
                r4 = r10
                r5 = r11
                r7 = r12
                r8 = r0
                r4.push(r5, r6, r7, r8, r9)
                if (r0 == 0) goto L2d
            L45:
                int r12 = r12 + 1
                goto L2d
            L48:
                return
            L49:
                r8 = r0
                r9 = 65546(0x1000a, float:9.185E-41)
                com.baidu.titan.sdk.runtime.InterceptResult r0 = r8.invokeLII(r9, r10, r11, r12, r13)
                if (r0 == 0) goto L4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Builder.resolvePath(java.lang.String, int, int):void");
        }

        public static int schemeDelimiterOffset(String str, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(65547, null, str, i, i2)) == null) {
                if (i2 - i < 2) {
                    return -1;
                }
                char charAt = str.charAt(i);
                if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                    while (true) {
                        i++;
                        if (i >= i2) {
                            break;
                        }
                        char charAt2 = str.charAt(i);
                        if (charAt2 < 'a' || charAt2 > 'z') {
                            if (charAt2 < 'A' || charAt2 > 'Z') {
                                if (charAt2 < '0' || charAt2 > '9') {
                                    if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                        if (charAt2 == ':') {
                                            return i;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return -1;
            }
            return invokeLII.intValue;
        }

        public static int slashCount(String str, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(65548, null, str, i, i2)) == null) {
                int i3 = 0;
                while (i < i2) {
                    char charAt = str.charAt(i);
                    if (charAt != '\\' && charAt != '/') {
                        break;
                    }
                    i3++;
                    i++;
                }
                return i3;
            }
            return invokeLII.intValue;
        }

        public Builder addEncodedPathSegment(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (str != null) {
                    push(str, 0, str.length(), false, true);
                    return this;
                }
                throw new NullPointerException("encodedPathSegment == null");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder addEncodedPathSegments(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                if (str != null) {
                    return addPathSegments(str, true);
                }
                throw new NullPointerException("encodedPathSegments == null");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder addEncodedQueryParameter(String str, @Nullable String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
                if (str != null) {
                    if (this.encodedQueryNamesAndValues == null) {
                        this.encodedQueryNamesAndValues = new ArrayList();
                    }
                    this.encodedQueryNamesAndValues.add(HttpUrl.canonicalize(str, " \"'<>#&=", true, false, true, true));
                    this.encodedQueryNamesAndValues.add(str2 != null ? HttpUrl.canonicalize(str2, " \"'<>#&=", true, false, true, true) : null);
                    return this;
                }
                throw new NullPointerException("encodedName == null");
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder addPathSegment(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                if (str != null) {
                    push(str, 0, str.length(), false, false);
                    return this;
                }
                throw new NullPointerException("pathSegment == null");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder addPathSegments(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                if (str != null) {
                    return addPathSegments(str, false);
                }
                throw new NullPointerException("pathSegments == null");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder addQueryParameter(String str, @Nullable String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
                if (str != null) {
                    if (this.encodedQueryNamesAndValues == null) {
                        this.encodedQueryNamesAndValues = new ArrayList();
                    }
                    this.encodedQueryNamesAndValues.add(HttpUrl.canonicalize(str, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
                    this.encodedQueryNamesAndValues.add(str2 != null ? HttpUrl.canonicalize(str2, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true) : null);
                    return this;
                }
                throw new NullPointerException("name == null");
            }
            return (Builder) invokeLL.objValue;
        }

        public HttpUrl build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                if (this.scheme != null) {
                    if (this.host != null) {
                        return new HttpUrl(this);
                    }
                    throw new IllegalStateException("host == null");
                }
                throw new IllegalStateException("scheme == null");
            }
            return (HttpUrl) invokeV.objValue;
        }

        public int effectivePort() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                int i = this.port;
                return i != -1 ? i : HttpUrl.defaultPort(this.scheme);
            }
            return invokeV.intValue;
        }

        public Builder encodedFragment(@Nullable String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                this.encodedFragment = str != null ? HttpUrl.canonicalize(str, "", true, false, false, false) : null;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder encodedPassword(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                if (str != null) {
                    this.encodedPassword = HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                    return this;
                }
                throw new NullPointerException("encodedPassword == null");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder encodedPath(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
                if (str != null) {
                    if (str.startsWith("/")) {
                        resolvePath(str, 0, str.length());
                        return this;
                    }
                    throw new IllegalArgumentException("unexpected encodedPath: " + str);
                }
                throw new NullPointerException("encodedPath == null");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder encodedQuery(@Nullable String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
                this.encodedQueryNamesAndValues = str != null ? HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(str, " \"'<>#", true, false, true, true)) : null;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder encodedUsername(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
                if (str != null) {
                    this.encodedUsername = HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                    return this;
                }
                throw new NullPointerException("encodedUsername == null");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder fragment(@Nullable String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
                this.encodedFragment = str != null ? HttpUrl.canonicalize(str, "", false, false, false, false) : null;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder host(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
                if (str != null) {
                    String canonicalizeHost = canonicalizeHost(str, 0, str.length());
                    if (canonicalizeHost != null) {
                        this.host = canonicalizeHost;
                        return this;
                    }
                    throw new IllegalArgumentException("unexpected host: " + str);
                }
                throw new NullPointerException("host == null");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder parse(@Nullable HttpUrl httpUrl, String str) {
            InterceptResult invokeLL;
            int schemeDelimiterOffset;
            int delimiterOffset;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, httpUrl, str)) == null) {
                int skipLeadingAsciiWhitespace = Util.skipLeadingAsciiWhitespace(str, 0, str.length());
                int skipTrailingAsciiWhitespace = Util.skipTrailingAsciiWhitespace(str, skipLeadingAsciiWhitespace, str.length());
                if (schemeDelimiterOffset(str, skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace) != -1) {
                    if (str.regionMatches(true, skipLeadingAsciiWhitespace, UrlSchemaHelper.SCHEMA_TYPE_HTTPS, 0, 6)) {
                        this.scheme = "https";
                        skipLeadingAsciiWhitespace += 6;
                    } else if (str.regionMatches(true, skipLeadingAsciiWhitespace, UrlSchemaHelper.SCHEMA_TYPE_HTTP, 0, 5)) {
                        this.scheme = "http";
                        skipLeadingAsciiWhitespace += 5;
                    } else {
                        throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str.substring(0, schemeDelimiterOffset) + "'");
                    }
                } else if (httpUrl != null) {
                    this.scheme = httpUrl.scheme;
                } else {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
                }
                int slashCount = slashCount(str, skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace);
                char c = '?';
                char c2 = '#';
                if (slashCount < 2 && httpUrl != null && httpUrl.scheme.equals(this.scheme)) {
                    this.encodedUsername = httpUrl.encodedUsername();
                    this.encodedPassword = httpUrl.encodedPassword();
                    this.host = httpUrl.host;
                    this.port = httpUrl.port;
                    this.encodedPathSegments.clear();
                    this.encodedPathSegments.addAll(httpUrl.encodedPathSegments());
                    if (skipLeadingAsciiWhitespace == skipTrailingAsciiWhitespace || str.charAt(skipLeadingAsciiWhitespace) == '#') {
                        encodedQuery(httpUrl.encodedQuery());
                    }
                } else {
                    int i2 = skipLeadingAsciiWhitespace + slashCount;
                    boolean z = false;
                    boolean z2 = false;
                    while (true) {
                        delimiterOffset = Util.delimiterOffset(str, i2, skipTrailingAsciiWhitespace, "@/\\?#");
                        char charAt = delimiterOffset != skipTrailingAsciiWhitespace ? str.charAt(delimiterOffset) : (char) 65535;
                        if (charAt == 65535 || charAt == c2 || charAt == '/' || charAt == '\\' || charAt == c) {
                            break;
                        }
                        if (charAt == '@') {
                            if (!z) {
                                int delimiterOffset2 = Util.delimiterOffset(str, i2, delimiterOffset, ':');
                                i = delimiterOffset;
                                String canonicalize = HttpUrl.canonicalize(str, i2, delimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                if (z2) {
                                    canonicalize = this.encodedUsername + "%40" + canonicalize;
                                }
                                this.encodedUsername = canonicalize;
                                if (delimiterOffset2 != i) {
                                    this.encodedPassword = HttpUrl.canonicalize(str, delimiterOffset2 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                    z = true;
                                }
                                z2 = true;
                            } else {
                                i = delimiterOffset;
                                this.encodedPassword += "%40" + HttpUrl.canonicalize(str, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            }
                            i2 = i + 1;
                        }
                        c = '?';
                        c2 = '#';
                    }
                    int portColonOffset = portColonOffset(str, i2, delimiterOffset);
                    int i3 = portColonOffset + 1;
                    if (i3 < delimiterOffset) {
                        this.host = canonicalizeHost(str, i2, portColonOffset);
                        int parsePort = parsePort(str, i3, delimiterOffset);
                        this.port = parsePort;
                        if (parsePort == -1) {
                            throw new IllegalArgumentException("Invalid URL port: \"" + str.substring(i3, delimiterOffset) + Typography.quote);
                        }
                    } else {
                        this.host = canonicalizeHost(str, i2, portColonOffset);
                        this.port = HttpUrl.defaultPort(this.scheme);
                    }
                    if (this.host == null) {
                        throw new IllegalArgumentException("Invalid URL host: \"" + str.substring(i2, portColonOffset) + Typography.quote);
                    }
                    skipLeadingAsciiWhitespace = delimiterOffset;
                }
                int delimiterOffset3 = Util.delimiterOffset(str, skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace, "?#");
                resolvePath(str, skipLeadingAsciiWhitespace, delimiterOffset3);
                if (delimiterOffset3 < skipTrailingAsciiWhitespace && str.charAt(delimiterOffset3) == '?') {
                    int delimiterOffset4 = Util.delimiterOffset(str, delimiterOffset3, skipTrailingAsciiWhitespace, '#');
                    this.encodedQueryNamesAndValues = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(str, delimiterOffset3 + 1, delimiterOffset4, " \"'<>#", true, false, true, true, null));
                    delimiterOffset3 = delimiterOffset4;
                }
                if (delimiterOffset3 < skipTrailingAsciiWhitespace && str.charAt(delimiterOffset3) == '#') {
                    this.encodedFragment = HttpUrl.canonicalize(str, 1 + delimiterOffset3, skipTrailingAsciiWhitespace, "", true, false, false, false, null);
                }
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder password(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
                if (str != null) {
                    this.encodedPassword = HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                    return this;
                }
                throw new NullPointerException("password == null");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder port(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
                if (i > 0 && i <= 65535) {
                    this.port = i;
                    return this;
                }
                throw new IllegalArgumentException("unexpected port: " + i);
            }
            return (Builder) invokeI.objValue;
        }

        public Builder query(@Nullable String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
                this.encodedQueryNamesAndValues = str != null ? HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(str, " \"'<>#", false, false, true, true)) : null;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder reencodeForUri() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                int size = this.encodedPathSegments.size();
                for (int i = 0; i < size; i++) {
                    this.encodedPathSegments.set(i, HttpUrl.canonicalize(this.encodedPathSegments.get(i), "[]", true, true, false, true));
                }
                List<String> list = this.encodedQueryNamesAndValues;
                if (list != null) {
                    int size2 = list.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        String str = this.encodedQueryNamesAndValues.get(i2);
                        if (str != null) {
                            this.encodedQueryNamesAndValues.set(i2, HttpUrl.canonicalize(str, "\\^`{|}", true, true, true, true));
                        }
                    }
                }
                String str2 = this.encodedFragment;
                if (str2 != null) {
                    this.encodedFragment = HttpUrl.canonicalize(str2, " \"#<>\\^`{|}", true, true, false, false);
                }
                return this;
            }
            return (Builder) invokeV.objValue;
        }

        public Builder removeAllEncodedQueryParameters(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
                if (str != null) {
                    if (this.encodedQueryNamesAndValues == null) {
                        return this;
                    }
                    removeAllCanonicalQueryParameters(HttpUrl.canonicalize(str, " \"'<>#&=", true, false, true, true));
                    return this;
                }
                throw new NullPointerException("encodedName == null");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder removeAllQueryParameters(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
                if (str != null) {
                    if (this.encodedQueryNamesAndValues == null) {
                        return this;
                    }
                    removeAllCanonicalQueryParameters(HttpUrl.canonicalize(str, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
                    return this;
                }
                throw new NullPointerException("name == null");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder removePathSegment(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
                this.encodedPathSegments.remove(i);
                if (this.encodedPathSegments.isEmpty()) {
                    this.encodedPathSegments.add("");
                }
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder scheme(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
                if (str != null) {
                    if (str.equalsIgnoreCase("http")) {
                        this.scheme = "http";
                    } else if (str.equalsIgnoreCase("https")) {
                        this.scheme = "https";
                    } else {
                        throw new IllegalArgumentException("unexpected scheme: " + str);
                    }
                    return this;
                }
                throw new NullPointerException("scheme == null");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setEncodedPathSegment(int i, String str) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048600, this, i, str)) == null) {
                if (str != null) {
                    String canonicalize = HttpUrl.canonicalize(str, 0, str.length(), " \"<>^`{}|/\\?#", true, false, false, true, null);
                    this.encodedPathSegments.set(i, canonicalize);
                    if (isDot(canonicalize) || isDotDot(canonicalize)) {
                        throw new IllegalArgumentException("unexpected path segment: " + str);
                    }
                    return this;
                }
                throw new NullPointerException("encodedPathSegment == null");
            }
            return (Builder) invokeIL.objValue;
        }

        public Builder setEncodedQueryParameter(String str, @Nullable String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, str, str2)) == null) {
                removeAllEncodedQueryParameters(str);
                addEncodedQueryParameter(str, str2);
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder setPathSegment(int i, String str) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048602, this, i, str)) == null) {
                if (str != null) {
                    String canonicalize = HttpUrl.canonicalize(str, 0, str.length(), " \"<>^`{}|/\\?#", false, false, false, true, null);
                    if (!isDot(canonicalize) && !isDotDot(canonicalize)) {
                        this.encodedPathSegments.set(i, canonicalize);
                        return this;
                    }
                    throw new IllegalArgumentException("unexpected path segment: " + str);
                }
                throw new NullPointerException("pathSegment == null");
            }
            return (Builder) invokeIL.objValue;
        }

        public Builder setQueryParameter(String str, @Nullable String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, str, str2)) == null) {
                removeAllQueryParameters(str);
                addQueryParameter(str, str2);
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.scheme);
                sb.append("://");
                if (!this.encodedUsername.isEmpty() || !this.encodedPassword.isEmpty()) {
                    sb.append(this.encodedUsername);
                    if (!this.encodedPassword.isEmpty()) {
                        sb.append(':');
                        sb.append(this.encodedPassword);
                    }
                    sb.append('@');
                }
                if (this.host.indexOf(58) != -1) {
                    sb.append('[');
                    sb.append(this.host);
                    sb.append(']');
                } else {
                    sb.append(this.host);
                }
                int effectivePort = effectivePort();
                if (effectivePort != HttpUrl.defaultPort(this.scheme)) {
                    sb.append(':');
                    sb.append(effectivePort);
                }
                HttpUrl.pathSegmentsToString(sb, this.encodedPathSegments);
                if (this.encodedQueryNamesAndValues != null) {
                    sb.append('?');
                    HttpUrl.namesAndValuesToQueryString(sb, this.encodedQueryNamesAndValues);
                }
                if (this.encodedFragment != null) {
                    sb.append('#');
                    sb.append(this.encodedFragment);
                }
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }

        public Builder username(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) {
                if (str != null) {
                    this.encodedUsername = HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                    return this;
                }
                throw new NullPointerException("username == null");
            }
            return (Builder) invokeL.objValue;
        }

        private Builder addPathSegments(String str, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, this, str, z)) == null) {
                int i = 0;
                do {
                    int delimiterOffset = Util.delimiterOffset(str, i, str.length(), "/\\");
                    push(str, i, delimiterOffset, delimiterOffset < str.length(), z);
                    i = delimiterOffset + 1;
                } while (i <= str.length());
                return this;
            }
            return (Builder) invokeLZ.objValue;
        }
    }

    @Nullable
    public static HttpUrl get(URL url) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, url)) == null) ? parse(url.toString()) : (HttpUrl) invokeL.objValue;
    }

    private List<String> percentDecode(List<String> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65551, this, list, z)) == null) {
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                String str = list.get(i);
                arrayList.add(str != null ? percentDecode(str, z) : null);
            }
            return Collections.unmodifiableList(arrayList);
        }
        return (List) invokeLZ.objValue;
    }

    @Nullable
    public static HttpUrl get(URI uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, uri)) == null) ? parse(uri.toString()) : (HttpUrl) invokeL.objValue;
    }

    public static String percentDecode(String str, int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            for (int i3 = i; i3 < i2; i3++) {
                char charAt = str.charAt(i3);
                if (charAt == '%' || (charAt == '+' && z)) {
                    Buffer buffer = new Buffer();
                    buffer.writeUtf8(str, i, i3);
                    percentDecode(buffer, str, i3, i2, z);
                    return buffer.readUtf8();
                }
            }
            return str.substring(i, i2);
        }
        return (String) invokeCommon.objValue;
    }

    public static void canonicalize(Buffer buffer, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{buffer, str, Integer.valueOf(i), Integer.valueOf(i2), str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), charset}) == null) {
            Buffer buffer2 = null;
            while (i < i2) {
                int codePointAt = str.codePointAt(i);
                if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                    if (codePointAt == 43 && z3) {
                        buffer.writeUtf8(z ? BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX : "%2B");
                    } else if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || !z4) && str2.indexOf(codePointAt) == -1 && (codePointAt != 37 || (z && (!z2 || percentEncoded(str, i, i2)))))) {
                        buffer.writeUtf8CodePoint(codePointAt);
                    } else {
                        if (buffer2 == null) {
                            buffer2 = new Buffer();
                        }
                        if (charset != null && !charset.equals(Util.UTF_8)) {
                            buffer2.writeString(str, i, Character.charCount(codePointAt) + i, charset);
                        } else {
                            buffer2.writeUtf8CodePoint(codePointAt);
                        }
                        while (!buffer2.exhausted()) {
                            int readByte = buffer2.readByte() & 255;
                            buffer.writeByte(37);
                            buffer.writeByte((int) HEX_DIGITS[(readByte >> 4) & 15]);
                            buffer.writeByte((int) HEX_DIGITS[readByte & 15]);
                        }
                    }
                }
                i += Character.charCount(codePointAt);
            }
        }
    }

    @Nullable
    public Builder newBuilder(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            try {
                return new Builder().parse(this, str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        return (Builder) invokeL.objValue;
    }

    public static void percentDecode(Buffer buffer, String str, int i, int i2, boolean z) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{buffer, str, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            while (i < i2) {
                int codePointAt = str.codePointAt(i);
                if (codePointAt == 37 && (i3 = i + 2) < i2) {
                    int decodeHexDigit = Util.decodeHexDigit(str.charAt(i + 1));
                    int decodeHexDigit2 = Util.decodeHexDigit(str.charAt(i3));
                    if (decodeHexDigit != -1 && decodeHexDigit2 != -1) {
                        buffer.writeByte((decodeHexDigit << 4) + decodeHexDigit2);
                        i = i3;
                    }
                    buffer.writeUtf8CodePoint(codePointAt);
                } else {
                    if (codePointAt == 43 && z) {
                        buffer.writeByte(32);
                    }
                    buffer.writeUtf8CodePoint(codePointAt);
                }
                i += Character.charCount(codePointAt);
            }
        }
    }

    public static String canonicalize(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), charset})) == null) ? canonicalize(str, 0, str.length(), str2, z, z2, z3, z4, charset) : (String) invokeCommon.objValue;
    }

    public static String canonicalize(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) ? canonicalize(str, 0, str.length(), str2, z, z2, z3, z4, null) : (String) invokeCommon.objValue;
    }
}
