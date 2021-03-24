package d.b.g0.k.c;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.request.PostBodyRequest;
/* loaded from: classes3.dex */
public class f extends PostBodyRequest.PostBodyRequestBuilder {
    public f(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.PostBodyRequest.PostBodyRequestBuilder, com.baidu.searchbox.http.request.HttpRequestBuilder
    public PostBodyRequest build() {
        d.b.g0.k.b.a().e(this.httpUrl.toString(), this);
        return super.build();
    }
}
