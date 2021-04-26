package d.a.h0.k.c;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.request.HeadRequest;
/* loaded from: classes3.dex */
public class d extends HeadRequest.HeadRequestBuilder {
    public d(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HeadRequest.HeadRequestBuilder, com.baidu.searchbox.http.request.HttpRequestBuilder
    public HeadRequest build() {
        d.a.h0.k.b.a().d(this.httpUrl.toString(), this);
        return super.build();
    }
}
