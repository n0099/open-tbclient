package d.a.m0.m.f;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.request.HttpCommonRequest;
import com.baidu.searchbox.http.request.HttpCommonRequestBuilder;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.apache.http.client.methods.HttpTrace;
/* loaded from: classes3.dex */
public class c extends HttpCommonRequest<a> {

    /* loaded from: classes3.dex */
    public static class a extends HttpCommonRequestBuilder<a> {
        public a(AbstractHttpManager abstractHttpManager) {
            super(abstractHttpManager);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.request.HttpRequestBuilder
        /* renamed from: a */
        public c build() {
            return new c(this);
        }

        public a(c cVar) {
            this(cVar, null);
        }

        public a(c cVar, AbstractHttpManager abstractHttpManager) {
            super(cVar, abstractHttpManager);
        }
    }

    public c(a aVar) {
        super(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    /* renamed from: a */
    public a newBuilder() {
        return new a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    /* renamed from: b */
    public a newBuilder(AbstractHttpManager abstractHttpManager) {
        return new a(this, abstractHttpManager);
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    public Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.method(HttpTrace.METHOD_NAME, requestBody).build();
    }
}
