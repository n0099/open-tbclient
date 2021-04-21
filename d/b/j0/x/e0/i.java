package d.b.j0.x.e0;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class i extends a {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f64210h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.j0.b1.b.c> f64211e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public String f64212f;

    /* renamed from: g  reason: collision with root package name */
    public String f64213g;

    public void g(d.b.j0.b1.b.c cVar) {
        this.f64211e.add(cVar);
    }

    public List<d.b.j0.b1.b.c> getDataList() {
        return this.f64211e;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return f64210h;
    }

    public String j() {
        return this.f64212f;
    }

    public String n() {
        return this.f64213g;
    }

    public void o(String str) {
        this.f64212f = str;
    }

    public void s(String str) {
        this.f64213g = str;
    }
}
