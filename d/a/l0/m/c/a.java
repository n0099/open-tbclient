package d.a.l0.m.c;

import com.baidu.searchbox.http.AbstractHttpManager;
import d.a.l0.m.f.a;
/* loaded from: classes3.dex */
public class a extends a.C1131a {
    public a(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.m.f.a.C1131a, com.baidu.searchbox.http.request.HttpRequestBuilder
    /* renamed from: a */
    public d.a.l0.m.f.a build() {
        d.a.l0.m.b.b().j(this.httpUrl.toString(), this);
        requestFrom(6);
        return super.build();
    }
}
