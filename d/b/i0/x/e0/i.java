package d.b.i0.x.e0;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class i extends a {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f62213h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.i0.a1.b.c> f62214e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public String f62215f;

    /* renamed from: g  reason: collision with root package name */
    public String f62216g;

    public void g(d.b.i0.a1.b.c cVar) {
        this.f62214e.add(cVar);
    }

    public List<d.b.i0.a1.b.c> getDataList() {
        return this.f62214e;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return f62213h;
    }

    public String j() {
        return this.f62215f;
    }

    public String n() {
        return this.f62216g;
    }

    public void o(String str) {
        this.f62215f = str;
    }

    public void s(String str) {
        this.f62216g = str;
    }
}
