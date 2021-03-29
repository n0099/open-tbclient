package d.b.i0.y0.c;

import com.baidu.tieba.lego.card.model.ICardInfo;
import d.b.i0.c3.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends d.b.i0.z0.h.a.a {

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.i1.p.a f62562g;

    public final void b() {
        List<Object> list = this.f63229e;
        if (list != null) {
            v.e(list, 2);
        }
    }

    public void c(d.b.i0.i1.p.a aVar) {
        this.f62562g = aVar;
        d();
        b();
    }

    public final void d() {
        d.b.i0.i1.p.a aVar = this.f62562g;
        if (aVar == null || !aVar.c()) {
            return;
        }
        List<ICardInfo> e2 = this.f62562g.e();
        ArrayList arrayList = new ArrayList();
        this.f63229e = arrayList;
        arrayList.addAll(e2);
        this.f62562g.b();
        this.f62562g.a();
    }
}
