package d.a.m0.m.c;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.request.DeleteRequest;
/* loaded from: classes3.dex */
public class b extends DeleteRequest.DeleteRequestBuilder {
    public b(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.DeleteRequest.DeleteRequestBuilder, com.baidu.searchbox.http.request.HttpRequestBuilder
    public DeleteRequest build() {
        d.a.m0.m.b.b().j(this.httpUrl.toString(), this);
        requestFrom(6);
        return super.build();
    }
}
