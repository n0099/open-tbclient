package d.a.k0.x.e0;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class i extends a {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f63198h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.k0.b1.b.c> f63199e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public String f63200f;

    /* renamed from: g  reason: collision with root package name */
    public String f63201g;

    public List<d.a.k0.b1.b.c> getDataList() {
        return this.f63199e;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return f63198h;
    }

    public void h(d.a.k0.b1.b.c cVar) {
        this.f63199e.add(cVar);
    }

    public String l() {
        return this.f63200f;
    }

    public String m() {
        return this.f63201g;
    }

    public void p(String str) {
        this.f63200f = str;
    }

    public void s(String str) {
        this.f63201g = str;
    }
}
