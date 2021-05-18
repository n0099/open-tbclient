package d.a.i0.m.c;

import com.baidu.searchbox.http.AbstractHttpManager;
import d.a.i0.m.f.b;
/* loaded from: classes3.dex */
public class e extends b.a {
    public e(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.m.f.b.a, com.baidu.searchbox.http.request.HttpRequestBuilder
    /* renamed from: a */
    public d.a.i0.m.f.b build() {
        d.a.i0.m.b.b().j(this.httpUrl.toString(), this);
        requestFrom(6);
        return super.build();
    }
}
