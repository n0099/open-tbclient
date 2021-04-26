package d.a.h0.k.f;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.request.HttpCommonRequest;
import com.baidu.searchbox.http.request.HttpCommonRequestBuilder;
import okhttp3.Request;
import okhttp3.RequestBody;
/* loaded from: classes3.dex */
public class a extends HttpCommonRequest<C0989a> {

    /* renamed from: d.a.h0.k.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0989a extends HttpCommonRequestBuilder<C0989a> {
        public C0989a(AbstractHttpManager abstractHttpManager) {
            super(abstractHttpManager);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.request.HttpRequestBuilder
        /* renamed from: a */
        public a build() {
            return new a(this);
        }

        public C0989a(a aVar) {
            this(aVar, null);
        }

        public C0989a(a aVar, AbstractHttpManager abstractHttpManager) {
            super(aVar, abstractHttpManager);
        }
    }

    public a(C0989a c0989a) {
        super(c0989a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    /* renamed from: a */
    public C0989a newBuilder() {
        return new C0989a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    /* renamed from: b */
    public C0989a newBuilder(AbstractHttpManager abstractHttpManager) {
        return new C0989a(this, abstractHttpManager);
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    public Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.method("CONNECT", requestBody).build();
    }
}
