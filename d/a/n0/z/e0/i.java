package d.a.n0.z.e0;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class i extends a {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f63478h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.n0.c1.b.c> f63479e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public String f63480f;

    /* renamed from: g  reason: collision with root package name */
    public String f63481g;

    public List<d.a.n0.c1.b.c> getDataList() {
        return this.f63479e;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return f63478h;
    }

    public void h(d.a.n0.c1.b.c cVar) {
        this.f63479e.add(cVar);
    }

    public String l() {
        return this.f63480f;
    }

    public String m() {
        return this.f63481g;
    }

    public void p(String str) {
        this.f63480f = str;
    }

    public void s(String str) {
        this.f63481g = str;
    }
}
