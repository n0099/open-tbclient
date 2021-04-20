package d.b.g0.k.f;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.request.HttpCommonRequest;
import com.baidu.searchbox.http.request.HttpCommonRequestBuilder;
import okhttp3.Request;
import okhttp3.RequestBody;
/* loaded from: classes3.dex */
public class a extends HttpCommonRequest<C1030a> {

    /* renamed from: d.b.g0.k.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1030a extends HttpCommonRequestBuilder<C1030a> {
        public C1030a(AbstractHttpManager abstractHttpManager) {
            super(abstractHttpManager);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.request.HttpRequestBuilder
        /* renamed from: a */
        public a build() {
            return new a(this);
        }

        public C1030a(a aVar) {
            this(aVar, null);
        }

        public C1030a(a aVar, AbstractHttpManager abstractHttpManager) {
            super(aVar, abstractHttpManager);
        }
    }

    public a(C1030a c1030a) {
        super(c1030a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    /* renamed from: a */
    public C1030a newBuilder() {
        return new C1030a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    /* renamed from: b */
    public C1030a newBuilder(AbstractHttpManager abstractHttpManager) {
        return new C1030a(this, abstractHttpManager);
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    public Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.method("CONNECT", requestBody).build();
    }
}
