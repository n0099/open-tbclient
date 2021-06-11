package okhttp3;

import com.alipay.sdk.encrypt.a;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
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
    public static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
    public static final String FRAGMENT_ENCODE_SET = "";
    public static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
    public static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
    public static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
    public static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
    public static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";
    public static final String QUERY_ENCODE_SET = " \"'<>#";
    public static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
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

    public HttpUrl(Builder builder) {
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

    public static String canonicalize(String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        int i4 = i2;
        while (i4 < i3) {
            int codePointAt = str.codePointAt(i4);
            if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || !z4)) {
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || percentEncoded(str, i4, i3)))) && (codePointAt != 43 || !z3))) {
                    i4 += Character.charCount(codePointAt);
                }
            }
            Buffer buffer = new Buffer();
            buffer.writeUtf8(str, i2, i4);
            canonicalize(buffer, str, i4, i3, str2, z, z2, z3, z4, charset);
            return buffer.readUtf8();
        }
        return str.substring(i2, i3);
    }

    public static int defaultPort(String str) {
        if (str.equals("http")) {
            return 80;
        }
        if (str.equals("https")) {
            return Constants.SOCKET_PORT_SSL;
        }
        return -1;
    }

    public static HttpUrl get(String str) {
        return new Builder().parse(null, str).build();
    }

    public static void namesAndValuesToQueryString(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            String str = list.get(i2);
            String str2 = list.get(i2 + 1);
            if (i2 > 0) {
                sb.append(Typography.amp);
            }
            sb.append(str);
            if (str2 != null) {
                sb.append(a.f1886h);
                sb.append(str2);
            }
        }
    }

    @Nullable
    public static HttpUrl parse(String str) {
        try {
            return get(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static void pathSegmentsToString(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append('/');
            sb.append(list.get(i2));
        }
    }

    public static String percentDecode(String str, boolean z) {
        return percentDecode(str, 0, str.length(), z);
    }

    public static boolean percentEncoded(String str, int i2, int i3) {
        int i4 = i2 + 2;
        return i4 < i3 && str.charAt(i2) == '%' && Util.decodeHexDigit(str.charAt(i2 + 1)) != -1 && Util.decodeHexDigit(str.charAt(i4)) != -1;
    }

    public static List<String> queryStringToNamesAndValues(String str) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 <= str.length()) {
            int indexOf = str.indexOf(38, i2);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i2);
            if (indexOf2 != -1 && indexOf2 <= indexOf) {
                arrayList.add(str.substring(i2, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            } else {
                arrayList.add(str.substring(i2, indexOf));
                arrayList.add(null);
            }
            i2 = indexOf + 1;
        }
        return arrayList;
    }

    @Nullable
    public String encodedFragment() {
        if (this.fragment == null) {
            return null;
        }
        return this.url.substring(this.url.indexOf(35) + 1);
    }

    public String encodedPassword() {
        if (this.password.isEmpty()) {
            return "";
        }
        int indexOf = this.url.indexOf(64);
        return this.url.substring(this.url.indexOf(58, this.scheme.length() + 3) + 1, indexOf);
    }

    public String encodedPath() {
        int indexOf = this.url.indexOf(47, this.scheme.length() + 3);
        String str = this.url;
        return this.url.substring(indexOf, Util.delimiterOffset(str, indexOf, str.length(), "?#"));
    }

    public List<String> encodedPathSegments() {
        int indexOf = this.url.indexOf(47, this.scheme.length() + 3);
        String str = this.url;
        int delimiterOffset = Util.delimiterOffset(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < delimiterOffset) {
            int i2 = indexOf + 1;
            int delimiterOffset2 = Util.delimiterOffset(this.url, i2, delimiterOffset, '/');
            arrayList.add(this.url.substring(i2, delimiterOffset2));
            indexOf = delimiterOffset2;
        }
        return arrayList;
    }

    @Nullable
    public String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int indexOf = this.url.indexOf(63) + 1;
        String str = this.url;
        return this.url.substring(indexOf, Util.delimiterOffset(str, indexOf, str.length(), '#'));
    }

    public String encodedUsername() {
        if (this.username.isEmpty()) {
            return "";
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        return this.url.substring(length, Util.delimiterOffset(str, length, str.length(), ":@"));
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof HttpUrl) && ((HttpUrl) obj).url.equals(this.url);
    }

    @Nullable
    public String fragment() {
        return this.fragment;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public String host() {
        return this.host;
    }

    public boolean isHttps() {
        return this.scheme.equals("https");
    }

    public Builder newBuilder() {
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

    public String password() {
        return this.password;
    }

    public List<String> pathSegments() {
        return this.pathSegments;
    }

    public int pathSize() {
        return this.pathSegments.size();
    }

    public int port() {
        return this.port;
    }

    @Nullable
    public String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        namesAndValuesToQueryString(sb, this.queryNamesAndValues);
        return sb.toString();
    }

    @Nullable
    public String queryParameter(String str) {
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            return null;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            if (str.equals(this.queryNamesAndValues.get(i2))) {
                return this.queryNamesAndValues.get(i2 + 1);
            }
        }
        return null;
    }

    public String queryParameterName(int i2) {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.get(i2 * 2);
        }
        throw new IndexOutOfBoundsException();
    }

    public Set<String> queryParameterNames() {
        if (this.queryNamesAndValues == null) {
            return Collections.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int size = this.queryNamesAndValues.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            linkedHashSet.add(this.queryNamesAndValues.get(i2));
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    public String queryParameterValue(int i2) {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.get((i2 * 2) + 1);
        }
        throw new IndexOutOfBoundsException();
    }

    public List<String> queryParameterValues(String str) {
        if (this.queryNamesAndValues == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = this.queryNamesAndValues.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            if (str.equals(this.queryNamesAndValues.get(i2))) {
                arrayList.add(this.queryNamesAndValues.get(i2 + 1));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public int querySize() {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    public String redact() {
        return newBuilder("/...").username("").password("").build().toString();
    }

    @Nullable
    public HttpUrl resolve(String str) {
        Builder newBuilder = newBuilder(str);
        if (newBuilder != null) {
            return newBuilder.build();
        }
        return null;
    }

    public String scheme() {
        return this.scheme;
    }

    public String toString() {
        return this.url;
    }

    @Nullable
    public String topPrivateDomain() {
        if (Util.verifyAsIpAddress(this.host)) {
            return null;
        }
        return PublicSuffixDatabase.get().getEffectiveTldPlusOne(this.host);
    }

    public URI uri() {
        String builder = newBuilder().reencodeForUri().toString();
        try {
            return new URI(builder);
        } catch (URISyntaxException e2) {
            try {
                return URI.create(builder.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e2);
            }
        }
    }

    public URL url() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException e2) {
            throw new RuntimeException(e2);
        }
    }

    public String username() {
        return this.username;
    }

    /* loaded from: classes8.dex */
    public static final class Builder {
        public static final String INVALID_HOST = "Invalid URL host";
        @Nullable
        public String encodedFragment;
        public final List<String> encodedPathSegments;
        @Nullable
        public List<String> encodedQueryNamesAndValues;
        @Nullable
        public String host;
        @Nullable
        public String scheme;
        public String encodedUsername = "";
        public String encodedPassword = "";
        public int port = -1;

        public Builder() {
            ArrayList arrayList = new ArrayList();
            this.encodedPathSegments = arrayList;
            arrayList.add("");
        }

        public static String canonicalizeHost(String str, int i2, int i3) {
            return Util.canonicalizeHost(HttpUrl.percentDecode(str, i2, i3, false));
        }

        private boolean isDot(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private boolean isDotDot(String str) {
            return str.equals(IStringUtil.TOP_PATH) || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        public static int parsePort(String str, int i2, int i3) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(HttpUrl.canonicalize(str, i2, i3, "", false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (parseInt <= 0 || parseInt > 65535) {
                return -1;
            }
            return parseInt;
        }

        private void pop() {
            List<String> list = this.encodedPathSegments;
            if (list.remove(list.size() - 1).isEmpty() && !this.encodedPathSegments.isEmpty()) {
                List<String> list2 = this.encodedPathSegments;
                list2.set(list2.size() - 1, "");
                return;
            }
            this.encodedPathSegments.add("");
        }

        public static int portColonOffset(String str, int i2, int i3) {
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (charAt == ':') {
                    return i2;
                }
                if (charAt == '[') {
                    do {
                        i2++;
                        if (i2 < i3) {
                        }
                    } while (str.charAt(i2) != ']');
                }
                i2++;
            }
            return i3;
        }

        private void push(String str, int i2, int i3, boolean z, boolean z2) {
            String canonicalize = HttpUrl.canonicalize(str, i2, i3, " \"<>^`{}|/\\?#", z2, false, false, true, null);
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

        private void removeAllCanonicalQueryParameters(String str) {
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

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0044 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0041 -> B:11:0x0029). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void resolvePath(java.lang.String r11, int r12, int r13) {
            /*
                r10 = this;
                if (r12 != r13) goto L3
                return
            L3:
                char r0 = r11.charAt(r12)
                r1 = 47
                java.lang.String r2 = ""
                r3 = 1
                if (r0 == r1) goto L1e
                r1 = 92
                if (r0 != r1) goto L13
                goto L1e
            L13:
                java.util.List<java.lang.String> r0 = r10.encodedPathSegments
                int r1 = r0.size()
                int r1 = r1 - r3
                r0.set(r1, r2)
                goto L29
            L1e:
                java.util.List<java.lang.String> r0 = r10.encodedPathSegments
                r0.clear()
                java.util.List<java.lang.String> r0 = r10.encodedPathSegments
                r0.add(r2)
                goto L41
            L29:
                r6 = r12
                if (r6 >= r13) goto L44
                java.lang.String r12 = "/\\"
                int r12 = okhttp3.internal.Util.delimiterOffset(r11, r6, r13, r12)
                if (r12 >= r13) goto L36
                r0 = 1
                goto L37
            L36:
                r0 = 0
            L37:
                r9 = 1
                r4 = r10
                r5 = r11
                r7 = r12
                r8 = r0
                r4.push(r5, r6, r7, r8, r9)
                if (r0 == 0) goto L29
            L41:
                int r12 = r12 + 1
                goto L29
            L44:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Builder.resolvePath(java.lang.String, int, int):void");
        }

        public static int schemeDelimiterOffset(String str, int i2, int i3) {
            if (i3 - i2 < 2) {
                return -1;
            }
            char charAt = str.charAt(i2);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i2++;
                    if (i2 >= i3) {
                        break;
                    }
                    char charAt2 = str.charAt(i2);
                    if (charAt2 < 'a' || charAt2 > 'z') {
                        if (charAt2 < 'A' || charAt2 > 'Z') {
                            if (charAt2 < '0' || charAt2 > '9') {
                                if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                    if (charAt2 == ':') {
                                        return i2;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        public static int slashCount(String str, int i2, int i3) {
            int i4 = 0;
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i4++;
                i2++;
            }
            return i4;
        }

        public Builder addEncodedPathSegment(String str) {
            if (str != null) {
                push(str, 0, str.length(), false, true);
                return this;
            }
            throw new NullPointerException("encodedPathSegment == null");
        }

        public Builder addEncodedPathSegments(String str) {
            if (str != null) {
                return addPathSegments(str, true);
            }
            throw new NullPointerException("encodedPathSegments == null");
        }

        public Builder addEncodedQueryParameter(String str, @Nullable String str2) {
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

        public Builder addPathSegment(String str) {
            if (str != null) {
                push(str, 0, str.length(), false, false);
                return this;
            }
            throw new NullPointerException("pathSegment == null");
        }

        public Builder addPathSegments(String str) {
            if (str != null) {
                return addPathSegments(str, false);
            }
            throw new NullPointerException("pathSegments == null");
        }

        public Builder addQueryParameter(String str, @Nullable String str2) {
            if (str != null) {
                if (this.encodedQueryNamesAndValues == null) {
                    this.encodedQueryNamesAndValues = new ArrayList();
                }
                this.encodedQueryNamesAndValues.add(HttpUrl.canonicalize(str, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, true));
                this.encodedQueryNamesAndValues.add(str2 != null ? HttpUrl.canonicalize(str2, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, true) : null);
                return this;
            }
            throw new NullPointerException("name == null");
        }

        public HttpUrl build() {
            if (this.scheme != null) {
                if (this.host != null) {
                    return new HttpUrl(this);
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        public int effectivePort() {
            int i2 = this.port;
            return i2 != -1 ? i2 : HttpUrl.defaultPort(this.scheme);
        }

        public Builder encodedFragment(@Nullable String str) {
            this.encodedFragment = str != null ? HttpUrl.canonicalize(str, "", true, false, false, false) : null;
            return this;
        }

        public Builder encodedPassword(String str) {
            if (str != null) {
                this.encodedPassword = HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                return this;
            }
            throw new NullPointerException("encodedPassword == null");
        }

        public Builder encodedPath(String str) {
            if (str != null) {
                if (str.startsWith("/")) {
                    resolvePath(str, 0, str.length());
                    return this;
                }
                throw new IllegalArgumentException("unexpected encodedPath: " + str);
            }
            throw new NullPointerException("encodedPath == null");
        }

        public Builder encodedQuery(@Nullable String str) {
            this.encodedQueryNamesAndValues = str != null ? HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public Builder encodedUsername(String str) {
            if (str != null) {
                this.encodedUsername = HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                return this;
            }
            throw new NullPointerException("encodedUsername == null");
        }

        public Builder fragment(@Nullable String str) {
            this.encodedFragment = str != null ? HttpUrl.canonicalize(str, "", false, false, false, false) : null;
            return this;
        }

        public Builder host(String str) {
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

        public Builder parse(@Nullable HttpUrl httpUrl, String str) {
            int schemeDelimiterOffset;
            int delimiterOffset;
            int i2;
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
            char c2 = '?';
            char c3 = '#';
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
                int i3 = skipLeadingAsciiWhitespace + slashCount;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    delimiterOffset = Util.delimiterOffset(str, i3, skipTrailingAsciiWhitespace, "@/\\?#");
                    char charAt = delimiterOffset != skipTrailingAsciiWhitespace ? str.charAt(delimiterOffset) : (char) 65535;
                    if (charAt == 65535 || charAt == c3 || charAt == '/' || charAt == '\\' || charAt == c2) {
                        break;
                    }
                    if (charAt == '@') {
                        if (!z) {
                            int delimiterOffset2 = Util.delimiterOffset(str, i3, delimiterOffset, ':');
                            i2 = delimiterOffset;
                            String canonicalize = HttpUrl.canonicalize(str, i3, delimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z2) {
                                canonicalize = this.encodedUsername + "%40" + canonicalize;
                            }
                            this.encodedUsername = canonicalize;
                            if (delimiterOffset2 != i2) {
                                this.encodedPassword = HttpUrl.canonicalize(str, delimiterOffset2 + 1, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z = true;
                            }
                            z2 = true;
                        } else {
                            i2 = delimiterOffset;
                            this.encodedPassword += "%40" + HttpUrl.canonicalize(str, i3, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        }
                        i3 = i2 + 1;
                    }
                    c2 = '?';
                    c3 = '#';
                }
                int portColonOffset = portColonOffset(str, i3, delimiterOffset);
                int i4 = portColonOffset + 1;
                if (i4 < delimiterOffset) {
                    this.host = canonicalizeHost(str, i3, portColonOffset);
                    int parsePort = parsePort(str, i4, delimiterOffset);
                    this.port = parsePort;
                    if (parsePort == -1) {
                        throw new IllegalArgumentException("Invalid URL port: \"" + str.substring(i4, delimiterOffset) + Typography.quote);
                    }
                } else {
                    this.host = canonicalizeHost(str, i3, portColonOffset);
                    this.port = HttpUrl.defaultPort(this.scheme);
                }
                if (this.host == null) {
                    throw new IllegalArgumentException("Invalid URL host: \"" + str.substring(i3, portColonOffset) + Typography.quote);
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

        public Builder password(String str) {
            if (str != null) {
                this.encodedPassword = HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("password == null");
        }

        public Builder port(int i2) {
            if (i2 > 0 && i2 <= 65535) {
                this.port = i2;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i2);
        }

        public Builder query(@Nullable String str) {
            this.encodedQueryNamesAndValues = str != null ? HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(str, " \"'<>#", false, false, true, true)) : null;
            return this;
        }

        public Builder reencodeForUri() {
            int size = this.encodedPathSegments.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.encodedPathSegments.set(i2, HttpUrl.canonicalize(this.encodedPathSegments.get(i2), "[]", true, true, false, true));
            }
            List<String> list = this.encodedQueryNamesAndValues;
            if (list != null) {
                int size2 = list.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    String str = this.encodedQueryNamesAndValues.get(i3);
                    if (str != null) {
                        this.encodedQueryNamesAndValues.set(i3, HttpUrl.canonicalize(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.encodedFragment;
            if (str2 != null) {
                this.encodedFragment = HttpUrl.canonicalize(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public Builder removeAllEncodedQueryParameters(String str) {
            if (str != null) {
                if (this.encodedQueryNamesAndValues == null) {
                    return this;
                }
                removeAllCanonicalQueryParameters(HttpUrl.canonicalize(str, " \"'<>#&=", true, false, true, true));
                return this;
            }
            throw new NullPointerException("encodedName == null");
        }

        public Builder removeAllQueryParameters(String str) {
            if (str != null) {
                if (this.encodedQueryNamesAndValues == null) {
                    return this;
                }
                removeAllCanonicalQueryParameters(HttpUrl.canonicalize(str, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, true));
                return this;
            }
            throw new NullPointerException("name == null");
        }

        public Builder removePathSegment(int i2) {
            this.encodedPathSegments.remove(i2);
            if (this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            }
            return this;
        }

        public Builder scheme(String str) {
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

        public Builder setEncodedPathSegment(int i2, String str) {
            if (str != null) {
                String canonicalize = HttpUrl.canonicalize(str, 0, str.length(), " \"<>^`{}|/\\?#", true, false, false, true, null);
                this.encodedPathSegments.set(i2, canonicalize);
                if (isDot(canonicalize) || isDotDot(canonicalize)) {
                    throw new IllegalArgumentException("unexpected path segment: " + str);
                }
                return this;
            }
            throw new NullPointerException("encodedPathSegment == null");
        }

        public Builder setEncodedQueryParameter(String str, @Nullable String str2) {
            removeAllEncodedQueryParameters(str);
            addEncodedQueryParameter(str, str2);
            return this;
        }

        public Builder setPathSegment(int i2, String str) {
            if (str != null) {
                String canonicalize = HttpUrl.canonicalize(str, 0, str.length(), " \"<>^`{}|/\\?#", false, false, false, true, null);
                if (!isDot(canonicalize) && !isDotDot(canonicalize)) {
                    this.encodedPathSegments.set(i2, canonicalize);
                    return this;
                }
                throw new IllegalArgumentException("unexpected path segment: " + str);
            }
            throw new NullPointerException("pathSegment == null");
        }

        public Builder setQueryParameter(String str, @Nullable String str2) {
            removeAllQueryParameters(str);
            addQueryParameter(str, str2);
            return this;
        }

        public String toString() {
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

        public Builder username(String str) {
            if (str != null) {
                this.encodedUsername = HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("username == null");
        }

        private Builder addPathSegments(String str, boolean z) {
            int i2 = 0;
            do {
                int delimiterOffset = Util.delimiterOffset(str, i2, str.length(), "/\\");
                push(str, i2, delimiterOffset, delimiterOffset < str.length(), z);
                i2 = delimiterOffset + 1;
            } while (i2 <= str.length());
            return this;
        }
    }

    @Nullable
    public static HttpUrl get(URL url) {
        return parse(url.toString());
    }

    private List<String> percentDecode(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            String str = list.get(i2);
            arrayList.add(str != null ? percentDecode(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Nullable
    public static HttpUrl get(URI uri) {
        return parse(uri.toString());
    }

    public static String percentDecode(String str, int i2, int i3, boolean z) {
        for (int i4 = i2; i4 < i3; i4++) {
            char charAt = str.charAt(i4);
            if (charAt == '%' || (charAt == '+' && z)) {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, i2, i4);
                percentDecode(buffer, str, i4, i3, z);
                return buffer.readUtf8();
            }
        }
        return str.substring(i2, i3);
    }

    public static void canonicalize(Buffer buffer, String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        Buffer buffer2 = null;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt == 43 && z3) {
                    buffer.writeUtf8(z ? BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX : "%2B");
                } else if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || !z4) && str2.indexOf(codePointAt) == -1 && (codePointAt != 37 || (z && (!z2 || percentEncoded(str, i2, i3)))))) {
                    buffer.writeUtf8CodePoint(codePointAt);
                } else {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    if (charset != null && !charset.equals(Util.UTF_8)) {
                        buffer2.writeString(str, i2, Character.charCount(codePointAt) + i2, charset);
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
            i2 += Character.charCount(codePointAt);
        }
    }

    @Nullable
    public Builder newBuilder(String str) {
        try {
            return new Builder().parse(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static void percentDecode(Buffer buffer, String str, int i2, int i3, boolean z) {
        int i4;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (codePointAt == 37 && (i4 = i2 + 2) < i3) {
                int decodeHexDigit = Util.decodeHexDigit(str.charAt(i2 + 1));
                int decodeHexDigit2 = Util.decodeHexDigit(str.charAt(i4));
                if (decodeHexDigit != -1 && decodeHexDigit2 != -1) {
                    buffer.writeByte((decodeHexDigit << 4) + decodeHexDigit2);
                    i2 = i4;
                }
                buffer.writeUtf8CodePoint(codePointAt);
            } else {
                if (codePointAt == 43 && z) {
                    buffer.writeByte(32);
                }
                buffer.writeUtf8CodePoint(codePointAt);
            }
            i2 += Character.charCount(codePointAt);
        }
    }

    public static String canonicalize(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        return canonicalize(str, 0, str.length(), str2, z, z2, z3, z4, charset);
    }

    public static String canonicalize(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return canonicalize(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }
}
