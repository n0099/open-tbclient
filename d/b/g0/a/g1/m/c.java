package d.b.g0.a.g1.m;

import android.text.TextUtils;
import com.baidu.searchbox.http.request.HttpRequest;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes2.dex */
public class c implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f44554a = true;

    public static Map<String, String> a(String str, String str2) {
        HashMap hashMap = new HashMap();
        if (f44554a) {
            if (str == null) {
                str = "";
            }
            if (str2 == null) {
                str2 = "";
            }
            hashMap.put("___check_redirect___", "on");
            hashMap.put("___request_type___", str);
            hashMap.put("___plugin_id___", str2);
            return hashMap;
        }
        return hashMap;
    }

    public static HttpRequest e(HttpRequest httpRequest, String str, String str2) {
        if (f44554a && httpRequest != null) {
            if (str == null) {
                str = "";
            }
            if (str2 == null) {
                str2 = "";
            }
            return httpRequest.newBuilder().addHeader("___check_redirect___", "on").addHeader("___request_type___", str).addHeader("___plugin_id___", str2).build();
        }
        return httpRequest;
    }

    public static Request f(Request request, String str, String str2) {
        if (f44554a && request != null) {
            if (str == null) {
                str = "";
            }
            if (str2 == null) {
                str2 = "";
            }
            return request.newBuilder().addHeader("___check_redirect___", "on").addHeader("___request_type___", str).addHeader("___plugin_id___", str2).build();
        }
        return request;
    }

    public final boolean b(Response response) {
        if (response == null) {
            return false;
        }
        int code = response.code();
        if (TextUtils.isEmpty(response.header("Location"))) {
            return false;
        }
        return (307 <= code && code <= 308) || (300 <= code && code <= 303);
    }

    public final boolean c(Request request) {
        if (request == null) {
            return false;
        }
        return TextUtils.equals(request.headers().get("___check_redirect___"), "on");
    }

    public final Request d(Request request) {
        return request == null ? request : request.newBuilder().removeHeader("___check_redirect___").removeHeader("___request_type___").removeHeader("___plugin_id___").build();
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        HttpUrl resolve;
        Request request = chain.request();
        if (!f44554a) {
            return chain.proceed(request);
        }
        if (!c(request)) {
            return chain.proceed(request);
        }
        Headers headers = request.headers();
        String str = headers.get("___request_type___");
        String str2 = headers.get("___plugin_id___");
        Response proceed = chain.proceed(d(request));
        if (b(proceed)) {
            String header = proceed.header("Location");
            if (TextUtils.isEmpty(header) || (resolve = proceed.request().url().resolve(header)) == null || d.b.g0.a.s1.a.b.c(str, resolve.toString(), str2) == 0) {
                return proceed;
            }
            String str3 = "redirect error:" + resolve.toString() + " scheme illegal or not in domain list";
            d.b.g0.a.c0.c.l("SafeRedirectCheck", str3);
            throw new InterruptedIOException(str3);
        }
        return proceed;
    }
}
