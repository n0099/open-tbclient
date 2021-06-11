package okhttp3.internal.http;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.Challenge;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
/* loaded from: classes8.dex */
public final class HttpHeaders {
    public static final Pattern PARAMETER = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");
    public static final String QUOTED_STRING = "\"([^\"]*)\"";
    public static final String TOKEN = "([^ \"=]*)";

    public static long contentLength(Response response) {
        return contentLength(response.headers());
    }

    public static boolean hasBody(Response response) {
        if (response.request().method().equals("HEAD")) {
            return false;
        }
        int code = response.code();
        return (((code >= 100 && code < 200) || code == 204 || code == 304) && contentLength(response) == -1 && !"chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) ? false : true;
    }

    public static boolean hasVaryAll(Response response) {
        return hasVaryAll(response.headers());
    }

    public static List<Challenge> parseChallenges(Headers headers, String str) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : headers.values(str)) {
            int indexOf = str2.indexOf(32);
            if (indexOf != -1) {
                String substring = str2.substring(0, indexOf);
                Matcher matcher = PARAMETER.matcher(str2);
                String str3 = null;
                String str4 = null;
                while (matcher.find(indexOf)) {
                    if (str2.regionMatches(true, matcher.start(1), "realm", 0, 5)) {
                        str3 = matcher.group(3);
                    } else if (str2.regionMatches(true, matcher.start(1), "charset", 0, 7)) {
                        str4 = matcher.group(3);
                    }
                    if (str3 != null && str4 != null) {
                        break;
                    }
                    indexOf = matcher.end();
                }
                if (str3 != null) {
                    Challenge challenge = new Challenge(substring, str3);
                    if (str4 != null) {
                        if (str4.equalsIgnoreCase("UTF-8")) {
                            challenge = challenge.withCharset(Util.UTF_8);
                        }
                    }
                    arrayList.add(challenge);
                }
            }
        }
        return arrayList;
    }

    public static int parseSeconds(String str, int i2) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i2;
        }
    }

    public static void receiveHeaders(CookieJar cookieJar, HttpUrl httpUrl, Headers headers) {
        if (cookieJar == CookieJar.NO_COOKIES) {
            return;
        }
        List<Cookie> parseAll = Cookie.parseAll(httpUrl, headers);
        if (parseAll.isEmpty()) {
            return;
        }
        cookieJar.saveFromResponse(httpUrl, parseAll);
    }

    public static int skipUntil(String str, int i2, String str2) {
        while (i2 < str.length() && str2.indexOf(str.charAt(i2)) == -1) {
            i2++;
        }
        return i2;
    }

    public static int skipWhitespace(String str, int i2) {
        char charAt;
        while (i2 < str.length() && ((charAt = str.charAt(i2)) == ' ' || charAt == '\t')) {
            i2++;
        }
        return i2;
    }

    public static long stringToLong(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static Set<String> varyFields(Response response) {
        return varyFields(response.headers());
    }

    public static Headers varyHeaders(Response response) {
        return varyHeaders(response.networkResponse().request().headers(), response.headers());
    }

    public static boolean varyMatches(Response response, Headers headers, Request request) {
        for (String str : varyFields(response)) {
            if (!Util.equal(headers.values(str), request.headers(str))) {
                return false;
            }
        }
        return true;
    }

    public static long contentLength(Headers headers) {
        return stringToLong(headers.get("Content-Length"));
    }

    public static boolean hasVaryAll(Headers headers) {
        return varyFields(headers).contains("*");
    }

    public static Set<String> varyFields(Headers headers) {
        Set<String> emptySet = Collections.emptySet();
        int size = headers.size();
        for (int i2 = 0; i2 < size; i2++) {
            if ("Vary".equalsIgnoreCase(headers.name(i2))) {
                String value = headers.value(i2);
                if (emptySet.isEmpty()) {
                    emptySet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
                }
                for (String str : value.split(",")) {
                    emptySet.add(str.trim());
                }
            }
        }
        return emptySet;
    }

    public static Headers varyHeaders(Headers headers, Headers headers2) {
        Set<String> varyFields = varyFields(headers2);
        if (varyFields.isEmpty()) {
            return new Headers.Builder().build();
        }
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        for (int i2 = 0; i2 < size; i2++) {
            String name = headers.name(i2);
            if (varyFields.contains(name)) {
                builder.add(name, headers.value(i2));
            }
        }
        return builder.build();
    }
}
