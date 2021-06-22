package d.a.o0.z.e0;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class i extends a {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f67321h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.o0.c1.b.c> f67322e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public String f67323f;

    /* renamed from: g  reason: collision with root package name */
    public String f67324g;

    public void c(d.a.o0.c1.b.c cVar) {
        this.f67322e.add(cVar);
    }

    public String g() {
        return this.f67323f;
    }

    public List<d.a.o0.c1.b.c> getDataList() {
        return this.f67322e;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return f67321h;
    }

    public String i() {
        return this.f67324g;
    }

    public void k(String str) {
        this.f67323f = str;
    }

    public void o(String str) {
        this.f67324g = str;
    }
}
