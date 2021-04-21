package d.b.h0.k.c;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.request.PostStringRequest;
/* loaded from: classes3.dex */
public class h extends PostStringRequest.PostStringRequestBuilder {
    public h(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
    }

    @Override // com.baidu.searchbox.http.request.PostStringRequest.PostStringRequestBuilder, com.baidu.searchbox.http.request.HttpRequestBuilder
    public HttpRequest build() {
        d.b.h0.k.b.a().e(this.httpUrl.toString(), this);
        return super.build();
    }
}
