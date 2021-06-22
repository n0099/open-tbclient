package d.a.m0.m.f;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.request.HttpCommonRequest;
import com.baidu.searchbox.http.request.HttpCommonRequestBuilder;
import okhttp3.Request;
import okhttp3.RequestBody;
/* loaded from: classes3.dex */
public class a extends HttpCommonRequest<C1134a> {

    /* renamed from: d.a.m0.m.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1134a extends HttpCommonRequestBuilder<C1134a> {
        public C1134a(AbstractHttpManager abstractHttpManager) {
            super(abstractHttpManager);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.request.HttpRequestBuilder
        /* renamed from: a */
        public a build() {
            return new a(this);
        }

        public C1134a(a aVar) {
            this(aVar, null);
        }

        public C1134a(a aVar, AbstractHttpManager abstractHttpManager) {
            super(aVar, abstractHttpManager);
        }
    }

    public a(C1134a c1134a) {
        super(c1134a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    /* renamed from: a */
    public C1134a newBuilder() {
        return new C1134a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    /* renamed from: b */
    public C1134a newBuilder(AbstractHttpManager abstractHttpManager) {
        return new C1134a(this, abstractHttpManager);
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    public Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.method("CONNECT", requestBody).build();
    }
}
