package d.b.g0.k.c;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.request.PostFormRequest;
/* loaded from: classes3.dex */
public class g extends PostFormRequest.PostFormRequestBuilder {
    public g(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.PostFormRequest.PostFormRequestBuilder, com.baidu.searchbox.http.request.HttpRequestBuilder
    public PostFormRequest build() {
        d.b.g0.k.b.a().e(this.httpUrl.toString(), this);
        return super.build();
    }
}
