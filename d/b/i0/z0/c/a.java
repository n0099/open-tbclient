package d.b.i0.z0.c;

import com.baidu.tieba.lego.card.model.ICardInfo;
import d.b.i0.d3.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends d.b.i0.a1.h.a.a {

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.j1.p.a f64223g;

    public final void b() {
        List<Object> list = this.f52848e;
        if (list != null) {
            v.e(list, 2);
        }
    }

    public void c(d.b.i0.j1.p.a aVar) {
        this.f64223g = aVar;
        d();
        b();
    }

    public final void d() {
        d.b.i0.j1.p.a aVar = this.f64223g;
        if (aVar == null || !aVar.c()) {
            return;
        }
        List<ICardInfo> e2 = this.f64223g.e();
        ArrayList arrayList = new ArrayList();
        this.f52848e = arrayList;
        arrayList.addAll(e2);
        this.f64223g.b();
        this.f64223g.a();
    }
}
