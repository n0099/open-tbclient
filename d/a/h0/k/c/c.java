package d.a.h0.k.c;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.request.GetRequest;
/* loaded from: classes3.dex */
public class c extends GetRequest.GetRequestBuilder {
    public c(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.GetRequest.GetRequestBuilder, com.baidu.searchbox.http.request.HttpRequestBuilder
    public GetRequest build() {
        d.a.h0.k.b.a().d(this.httpUrl.toString(), this);
        return super.build();
    }
}
