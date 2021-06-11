package d.a.n0.z.e0;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class i extends a {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f67196h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.n0.c1.b.c> f67197e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public String f67198f;

    /* renamed from: g  reason: collision with root package name */
    public String f67199g;

    public void c(d.a.n0.c1.b.c cVar) {
        this.f67197e.add(cVar);
    }

    public String g() {
        return this.f67198f;
    }

    public List<d.a.n0.c1.b.c> getDataList() {
        return this.f67197e;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return f67196h;
    }

    public String i() {
        return this.f67199g;
    }

    public void k(String str) {
        this.f67198f = str;
    }

    public void o(String str) {
        this.f67199g = str;
    }
}
