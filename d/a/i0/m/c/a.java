package d.a.i0.m.c;

import com.baidu.searchbox.http.AbstractHttpManager;
import d.a.i0.m.f.a;
/* loaded from: classes3.dex */
public class a extends a.C1064a {
    public a(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.m.f.a.C1064a, com.baidu.searchbox.http.request.HttpRequestBuilder
    /* renamed from: a */
    public d.a.i0.m.f.a build() {
        d.a.i0.m.b.b().j(this.httpUrl.toString(), this);
        requestFrom(6);
        return super.build();
    }
}
