package okhttp3.internal.http;

import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.net.Proxy;
import okhttp3.HttpUrl;
import okhttp3.Request;
import org.apache.commons.codec.net.RFC1522Codec;
/* loaded from: classes9.dex */
public final class RequestLine {
    public static String get(Request request, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(request.method());
        sb.append(WebvttCueParser.CHAR_SPACE);
        if (includeAuthorityInRequestLine(request, type)) {
            sb.append(request.url());
        } else {
            sb.append(requestPath(request.url()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    public static boolean includeAuthorityInRequestLine(Request request, Proxy.Type type) {
        if (!request.isHttps() && type == Proxy.Type.HTTP) {
            return true;
        }
        return false;
    }

    public static String requestPath(HttpUrl httpUrl) {
        String encodedPath = httpUrl.encodedPath();
        String encodedQuery = httpUrl.encodedQuery();
        if (encodedQuery != null) {
            return encodedPath + RFC1522Codec.SEP + encodedQuery;
        }
        return encodedPath;
    }
}
