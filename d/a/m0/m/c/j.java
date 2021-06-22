package d.a.m0.m.c;

import com.baidu.searchbox.http.AbstractHttpManager;
import d.a.m0.m.f.c;
/* loaded from: classes3.dex */
public class j extends c.a {
    public j(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.m.f.c.a, com.baidu.searchbox.http.request.HttpRequestBuilder
    /* renamed from: a */
    public d.a.m0.m.f.c build() {
        d.a.m0.m.b.b().j(this.httpUrl.toString(), this);
        requestFrom(6);
        return super.build();
    }
}
