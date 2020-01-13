package tv.chushou.basis.http.a;

import java.util.HashSet;
import java.util.Map;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import tv.chushou.basis.http.model.HttpParam;
import tv.chushou.basis.http.model.RequestTag;
/* loaded from: classes4.dex */
public class a implements Interceptor {
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Request request = chain.request();
        RequestBody body = request.body();
        if (body instanceof MultipartBody) {
            return chain.proceed(request);
        }
        RequestTag thirdParty = request.tag() instanceof RequestTag ? (RequestTag) request.tag() : RequestTag.thirdParty();
        HttpUrl url = request.url();
        String method = request.method();
        HttpParam httpParam = new HttpParam(thirdParty);
        HashSet<String> hashSet = new HashSet();
        if ("GET".equalsIgnoreCase(method)) {
            for (int i = 0; i < url.querySize(); i++) {
                String queryParameterName = url.queryParameterName(i);
                String queryParameterValue = url.queryParameterValue(i);
                hashSet.add(queryParameterName);
                if (thirdParty.supportEmpty) {
                    httpParam.a(queryParameterName, queryParameterValue);
                } else {
                    httpParam.b(queryParameterName, queryParameterValue);
                }
            }
        } else if (body instanceof FormBody) {
            FormBody formBody = (FormBody) body;
            int size = formBody.size();
            for (int i2 = 0; i2 < size; i2++) {
                String name = formBody.name(i2);
                String value = formBody.value(i2);
                if (thirdParty.supportEmpty) {
                    httpParam.a(name, value);
                } else {
                    httpParam.b(name, value);
                }
            }
        }
        httpParam.a();
        httpParam.b();
        httpParam.c();
        Request.Builder newBuilder = request.newBuilder();
        if ("GET".equalsIgnoreCase(method)) {
            HttpUrl.Builder newBuilder2 = url.newBuilder();
            for (String str : hashSet) {
                newBuilder2.removeAllQueryParameters(str);
            }
            for (Map.Entry<String, String> entry : httpParam.dOA()) {
                newBuilder2.addQueryParameter(entry.getKey(), entry.getValue());
            }
            newBuilder.url(newBuilder2.build());
        } else {
            FormBody.Builder builder = new FormBody.Builder();
            for (Map.Entry<String, String> entry2 : httpParam.dOA()) {
                builder.add(entry2.getKey(), entry2.getValue());
            }
            newBuilder.post(builder.build());
        }
        return chain.proceed(newBuilder.build());
    }
}
