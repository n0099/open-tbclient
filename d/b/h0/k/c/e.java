package d.b.h0.k.c;

import com.baidu.searchbox.http.AbstractHttpManager;
import d.b.h0.k.f.b;
/* loaded from: classes3.dex */
public class e extends b.a {
    public e(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.k.f.b.a, com.baidu.searchbox.http.request.HttpRequestBuilder
    /* renamed from: a */
    public d.b.h0.k.f.b build() {
        d.b.h0.k.b.a().e(this.httpUrl.toString(), this);
        return super.build();
    }
}
