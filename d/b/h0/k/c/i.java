package d.b.h0.k.c;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.request.PutBodyRequest;
/* loaded from: classes3.dex */
public class i extends PutBodyRequest.PutBodyRequestBuilder {
    public i(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.PutBodyRequest.PutBodyRequestBuilder, com.baidu.searchbox.http.request.HttpRequestBuilder
    public PutBodyRequest build() {
        d.b.h0.k.b.a().e(this.httpUrl.toString(), this);
        return super.build();
    }
}
