package d.b.i0.y0.c;

import com.baidu.tieba.lego.card.model.ICardInfo;
import d.b.i0.c3.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends d.b.i0.z0.h.a.a {

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.i1.p.a f62561g;

    public final void b() {
        List<Object> list = this.f63228e;
        if (list != null) {
            v.e(list, 2);
        }
    }

    public void c(d.b.i0.i1.p.a aVar) {
        this.f62561g = aVar;
        d();
        b();
    }

    public final void d() {
        d.b.i0.i1.p.a aVar = this.f62561g;
        if (aVar == null || !aVar.c()) {
            return;
        }
        List<ICardInfo> e2 = this.f62561g.e();
        ArrayList arrayList = new ArrayList();
        this.f63228e = arrayList;
        arrayList.addAll(e2);
        this.f62561g.b();
        this.f62561g.a();
    }
}
