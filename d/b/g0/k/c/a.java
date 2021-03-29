package d.b.g0.k.c;

import com.baidu.searchbox.http.AbstractHttpManager;
import d.b.g0.k.f.a;
/* loaded from: classes3.dex */
public class a extends a.C1018a {
    public a(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.k.f.a.C1018a, com.baidu.searchbox.http.request.HttpRequestBuilder
    /* renamed from: a */
    public d.b.g0.k.f.a build() {
        d.b.g0.k.b.a().e(this.httpUrl.toString(), this);
        return super.build();
    }
}
