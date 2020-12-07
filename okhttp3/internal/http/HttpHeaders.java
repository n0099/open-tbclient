package okhttp3.internal.http;

import android.support.v7.widget.ActivityChooserView;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import okhttp3.Challenge;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.message.BasicHeaderValueFormatter;
import org.apache.http.protocol.HTTP;
/* loaded from: classes15.dex */
public final class HttpHeaders {
    private static final ByteString QUOTED_STRING_DELIMITERS = ByteString.encodeUtf8(BasicHeaderValueFormatter.UNSAFE_CHARS);
    private static final ByteString TOKEN_DELIMITERS = ByteString.encodeUtf8("\t ,=");

    private HttpHeaders() {
    }

    public static long contentLength(Response response) {
        return contentLength(response.headers());
    }

    public static long contentLength(Headers headers) {
        return stringToLong(headers.get("Content-Length"));
    }

    private static long stringToLong(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            return -1L;
        }
    }

    public static boolean varyMatches(Response response, Headers headers, Request request) {
        for (String str : varyFields(response)) {
            if (!Util.equal(headers.values(str), request.headers(str))) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasVaryAll(Response response) {
        return hasVaryAll(response.headers());
    }

    public static boolean hasVaryAll(Headers headers) {
        return varyFields(headers).contains("*");
    }

    private static Set<String> varyFields(Response response) {
        return varyFields(response.headers());
    }

    public static Set<String> varyFields(Headers headers) {
        Set<String> emptySet = Collections.emptySet();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            if ("Vary".equalsIgnoreCase(headers.name(i))) {
                String value = headers.value(i);
                if (emptySet.isEmpty()) {
                    emptySet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
                }
                String[] split = value.split(",");
                for (String str : split) {
                    emptySet.add(str.trim());
                }
            }
        }
        return emptySet;
    }

    public static Headers varyHeaders(Response response) {
        return varyHeaders(response.networkResponse().request().headers(), response.headers());
    }

    public static Headers varyHeaders(Headers headers, Headers headers2) {
        Set<String> varyFields = varyFields(headers2);
        if (varyFields.isEmpty()) {
            return new Headers.Builder().build();
        }
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            String name = headers.name(i);
            if (varyFields.contains(name)) {
                builder.add(name, headers.value(i));
            }
        }
        return builder.build();
    }

    public static List<Challenge> parseChallenges(Headers headers, String str) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < headers.size(); i++) {
            if (str.equalsIgnoreCase(headers.name(i))) {
                parseChallengeHeader(arrayList, new Buffer().writeUtf8(headers.value(i)));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x007c, code lost:
        r9.add(new okhttp3.Challenge(r2, r5));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void parseChallengeHeader(List<Challenge> list, Buffer buffer) {
        int i;
        String readToken;
        String str = null;
        while (true) {
            if (str == null) {
                skipWhitespaceAndCommas(buffer);
                str = readToken(buffer);
                if (str == null) {
                    return;
                }
            }
            String str2 = str;
            boolean skipWhitespaceAndCommas = skipWhitespaceAndCommas(buffer);
            String readToken2 = readToken(buffer);
            if (readToken2 == null) {
                if (buffer.exhausted()) {
                    list.add(new Challenge(str2, Collections.emptyMap()));
                    return;
                }
                return;
            }
            int skipAll = skipAll(buffer, (byte) 61);
            boolean skipWhitespaceAndCommas2 = skipWhitespaceAndCommas(buffer);
            if (!skipWhitespaceAndCommas && (skipWhitespaceAndCommas2 || buffer.exhausted())) {
                list.add(new Challenge(str2, Collections.singletonMap(null, readToken2 + repeat('=', skipAll))));
                str = null;
            } else {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                int skipAll2 = skipAll(buffer, (byte) 61) + skipAll;
                while (true) {
                    if (readToken2 == null) {
                        str = readToken(buffer);
                        if (skipWhitespaceAndCommas(buffer)) {
                            break;
                        }
                        i = skipAll(buffer, (byte) 61);
                    } else {
                        i = skipAll2;
                        str = readToken2;
                    }
                    if (i == 0) {
                        break;
                    } else if (i <= 1 && !skipWhitespaceAndCommas(buffer)) {
                        if (!buffer.exhausted() && buffer.getByte(0L) == 34) {
                            readToken = readQuotedString(buffer);
                        } else {
                            readToken = readToken(buffer);
                        }
                        if (readToken == null || ((String) linkedHashMap.put(str, readToken)) != null) {
                            return;
                        }
                        if (!skipWhitespaceAndCommas(buffer) && !buffer.exhausted()) {
                            return;
                        }
                        skipAll2 = i;
                        readToken2 = null;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private static boolean skipWhitespaceAndCommas(Buffer buffer) {
        boolean z = false;
        while (!buffer.exhausted()) {
            byte b = buffer.getByte(0L);
            if (b == 44) {
                buffer.readByte();
                z = true;
            } else if (b != 32 && b != 9) {
                break;
            } else {
                buffer.readByte();
            }
        }
        return z;
    }

    private static int skipAll(Buffer buffer, byte b) {
        int i = 0;
        while (!buffer.exhausted() && buffer.getByte(0L) == b) {
            i++;
            buffer.readByte();
        }
        return i;
    }

    private static String readQuotedString(Buffer buffer) {
        if (buffer.readByte() != 34) {
            throw new IllegalArgumentException();
        }
        Buffer buffer2 = new Buffer();
        while (true) {
            long indexOfElement = buffer.indexOfElement(QUOTED_STRING_DELIMITERS);
            if (indexOfElement == -1) {
                return null;
            }
            if (buffer.getByte(indexOfElement) == 34) {
                buffer2.write(buffer, indexOfElement);
                buffer.readByte();
                return buffer2.readUtf8();
            } else if (buffer.size() == indexOfElement + 1) {
                return null;
            } else {
                buffer2.write(buffer, indexOfElement);
                buffer.readByte();
                buffer2.write(buffer, 1L);
            }
        }
    }

    private static String readToken(Buffer buffer) {
        try {
            long indexOfElement = buffer.indexOfElement(TOKEN_DELIMITERS);
            if (indexOfElement == -1) {
                indexOfElement = buffer.size();
            }
            if (indexOfElement != 0) {
                return buffer.readUtf8(indexOfElement);
            }
            return null;
        } catch (EOFException e) {
            throw new AssertionError();
        }
    }

    private static String repeat(char c, int i) {
        char[] cArr = new char[i];
        Arrays.fill(cArr, c);
        return new String(cArr);
    }

    public static void receiveHeaders(CookieJar cookieJar, HttpUrl httpUrl, Headers headers) {
        if (cookieJar != CookieJar.NO_COOKIES) {
            List<Cookie> parseAll = Cookie.parseAll(httpUrl, headers);
            if (!parseAll.isEmpty()) {
                cookieJar.saveFromResponse(httpUrl, parseAll);
            }
        }
    }

    public static boolean hasBody(Response response) {
        if (response.request().method().equals(HttpHead.METHOD_NAME)) {
            return false;
        }
        int code = response.code();
        if ((code >= 100 && code < 200) || code == 204 || code == 304) {
            return contentLength(response) != -1 || HTTP.CHUNK_CODING.equalsIgnoreCase(response.header("Transfer-Encoding"));
        }
        return true;
    }

    public static int skipUntil(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static int skipWhitespace(String str, int i) {
        char charAt;
        while (i < str.length() && ((charAt = str.charAt(i)) == ' ' || charAt == '\t')) {
            i++;
        }
        return i;
    }

    public static int parseSeconds(String str, int i) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException e) {
            return i;
        }
    }
}
