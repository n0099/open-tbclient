package d.a.j0.x.e0;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class i extends a {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f62474h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.j0.b1.b.c> f62475e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public String f62476f;

    /* renamed from: g  reason: collision with root package name */
    public String f62477g;

    public List<d.a.j0.b1.b.c> getDataList() {
        return this.f62475e;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return f62474h;
    }

    public void h(d.a.j0.b1.b.c cVar) {
        this.f62475e.add(cVar);
    }

    public String l() {
        return this.f62476f;
    }

    public String m() {
        return this.f62477g;
    }

    public void p(String str) {
        this.f62476f = str;
    }

    public void s(String str) {
        this.f62477g = str;
    }
}
