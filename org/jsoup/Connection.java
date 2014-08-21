package org.jsoup;

import java.net.URL;
import java.util.Collection;
import java.util.Map;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
/* loaded from: classes.dex */
public interface Connection {

    /* loaded from: classes.dex */
    public interface Base<T extends Base> {
        String cookie(String str);

        T cookie(String str, String str2);

        Map<String, String> cookies();

        boolean hasCookie(String str);

        boolean hasHeader(String str);

        String header(String str);

        T header(String str, String str2);

        Map<String, String> headers();

        T method(Method method);

        Method method();

        T removeCookie(String str);

        T removeHeader(String str);

        URL url();

        T url(URL url);
    }

    /* loaded from: classes.dex */
    public interface KeyVal {
        String key();

        KeyVal key(String str);

        String value();

        KeyVal value(String str);
    }

    /* loaded from: classes.dex */
    public enum Method {
        GET,
        POST
    }

    /* loaded from: classes.dex */
    public interface Request extends Base<Request> {
        Collection<KeyVal> data();

        Request data(KeyVal keyVal);

        Request followRedirects(boolean z);

        boolean followRedirects();

        Request ignoreContentType(boolean z);

        boolean ignoreContentType();

        Request ignoreHttpErrors(boolean z);

        boolean ignoreHttpErrors();

        int maxBodySize();

        Request maxBodySize(int i);

        Request parser(Parser parser);

        Parser parser();

        int timeout();

        Request timeout(int i);
    }

    /* loaded from: classes.dex */
    public interface Response extends Base<Response> {
        String body();

        byte[] bodyAsBytes();

        String charset();

        String contentType();

        Document parse();

        int statusCode();

        String statusMessage();
    }

    Connection cookie(String str, String str2);

    Connection cookies(Map<String, String> map);

    Connection data(String str, String str2);

    Connection data(Collection<KeyVal> collection);

    Connection data(Map<String, String> map);

    Connection data(String... strArr);

    Response execute();

    Connection followRedirects(boolean z);

    Document get();

    Connection header(String str, String str2);

    Connection ignoreContentType(boolean z);

    Connection ignoreHttpErrors(boolean z);

    Connection maxBodySize(int i);

    Connection method(Method method);

    Connection parser(Parser parser);

    Document post();

    Connection referrer(String str);

    Request request();

    Connection request(Request request);

    Response response();

    Connection response(Response response);

    Connection timeout(int i);

    Connection url(String str);

    Connection url(URL url);

    Connection userAgent(String str);
}
