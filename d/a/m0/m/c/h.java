package d.a.m0.m.c;

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
        d.a.m0.m.b.b().j(this.httpUrl.toString(), this);
        requestFrom(6);
        return super.build();
    }
}
