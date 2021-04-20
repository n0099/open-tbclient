package d.b.i0.x.e0;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class i extends a {

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f63789h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.i0.b1.b.c> f63790e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public String f63791f;

    /* renamed from: g  reason: collision with root package name */
    public String f63792g;

    public void g(d.b.i0.b1.b.c cVar) {
        this.f63790e.add(cVar);
    }

    public List<d.b.i0.b1.b.c> getDataList() {
        return this.f63790e;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return f63789h;
    }

    public String j() {
        return this.f63791f;
    }

    public String n() {
        return this.f63792g;
    }

    public void o(String str) {
        this.f63791f = str;
    }

    public void s(String str) {
        this.f63792g = str;
    }
}
