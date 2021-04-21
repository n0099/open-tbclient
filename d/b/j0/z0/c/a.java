package d.b.j0.z0.c;

import com.baidu.tieba.lego.card.model.ICardInfo;
import d.b.j0.d3.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends d.b.j0.a1.h.a.a {

    /* renamed from: g  reason: collision with root package name */
    public d.b.j0.j1.p.a f64644g;

    public final void b() {
        List<Object> list = this.f53269e;
        if (list != null) {
            v.e(list, 2);
        }
    }

    public void c(d.b.j0.j1.p.a aVar) {
        this.f64644g = aVar;
        d();
        b();
    }

    public final void d() {
        d.b.j0.j1.p.a aVar = this.f64644g;
        if (aVar == null || !aVar.c()) {
            return;
        }
        List<ICardInfo> e2 = this.f64644g.e();
        ArrayList arrayList = new ArrayList();
        this.f53269e = arrayList;
        arrayList.addAll(e2);
        this.f64644g.b();
        this.f64644g.a();
    }
}
