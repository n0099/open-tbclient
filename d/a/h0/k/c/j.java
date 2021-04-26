package d.a.h0.k.c;

import com.baidu.searchbox.http.AbstractHttpManager;
import d.a.h0.k.f.c;
/* loaded from: classes3.dex */
public class j extends c.a {
    public j(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.k.f.c.a, com.baidu.searchbox.http.request.HttpRequestBuilder
    /* renamed from: a */
    public d.a.h0.k.f.c build() {
        d.a.h0.k.b.a().d(this.httpUrl.toString(), this);
        return super.build();
    }
}
