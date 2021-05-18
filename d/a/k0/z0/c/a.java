package d.a.k0.z0.c;

import com.baidu.tieba.lego.card.model.ICardInfo;
import d.a.k0.d3.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends d.a.k0.a1.h.a.a {

    /* renamed from: g  reason: collision with root package name */
    public d.a.k0.j1.p.a f63651g;

    public final void a() {
        List<Object> list = this.f51686e;
        if (list != null) {
            v.e(list, 2);
        }
    }

    public void b(d.a.k0.j1.p.a aVar) {
        this.f63651g = aVar;
        d();
        a();
    }

    public final void d() {
        d.a.k0.j1.p.a aVar = this.f63651g;
        if (aVar == null || !aVar.b()) {
            return;
        }
        List<ICardInfo> e2 = this.f63651g.e();
        ArrayList arrayList = new ArrayList();
        this.f51686e = arrayList;
        arrayList.addAll(e2);
        this.f63651g.a();
        this.f63651g.c();
    }
}
