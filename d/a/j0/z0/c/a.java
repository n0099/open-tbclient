package d.a.j0.z0.c;

import com.baidu.tieba.lego.card.model.ICardInfo;
import d.a.j0.d3.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends d.a.j0.a1.h.a.a {

    /* renamed from: g  reason: collision with root package name */
    public d.a.j0.j1.p.a f62927g;

    public final void a() {
        List<Object> list = this.f50987e;
        if (list != null) {
            v.e(list, 2);
        }
    }

    public void b(d.a.j0.j1.p.a aVar) {
        this.f62927g = aVar;
        d();
        a();
    }

    public final void d() {
        d.a.j0.j1.p.a aVar = this.f62927g;
        if (aVar == null || !aVar.b()) {
            return;
        }
        List<ICardInfo> e2 = this.f62927g.e();
        ArrayList arrayList = new ArrayList();
        this.f50987e = arrayList;
        arrayList.addAll(e2);
        this.f62927g.a();
        this.f62927g.c();
    }
}
