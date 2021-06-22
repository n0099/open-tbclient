package d.a.o0.a1.c;

import com.baidu.tieba.lego.card.model.ICardInfo;
import d.a.o0.e3.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends d.a.o0.b1.i.a.a {

    /* renamed from: g  reason: collision with root package name */
    public d.a.o0.k1.p.a f54944g;

    public final void a() {
        List<Object> list = this.f55661e;
        if (list != null) {
            v.e(list, 2);
        }
    }

    public void b(d.a.o0.k1.p.a aVar) {
        this.f54944g = aVar;
        c();
        a();
    }

    public final void c() {
        d.a.o0.k1.p.a aVar = this.f54944g;
        if (aVar == null || !aVar.b()) {
            return;
        }
        List<ICardInfo> e2 = this.f54944g.e();
        ArrayList arrayList = new ArrayList();
        this.f55661e = arrayList;
        arrayList.addAll(e2);
        this.f54944g.a();
        this.f54944g.c();
    }
}
