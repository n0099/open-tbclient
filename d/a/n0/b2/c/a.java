package d.a.n0.b2.c;

import com.baidu.tbadk.TbPageContext;
import d.a.c.j.e.n;
import d.a.c.j.e.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f52065a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.c.j.e.a> f52066b;

    /* renamed from: c  reason: collision with root package name */
    public s f52067c;

    public a(TbPageContext tbPageContext, s sVar) {
        this.f52065a = tbPageContext;
        this.f52067c = sVar;
        a();
        this.f52067c.a(this.f52066b);
    }

    public final void a() {
        ArrayList arrayList = new ArrayList();
        this.f52066b = arrayList;
        arrayList.add(new b(this.f52065a));
    }

    public void b() {
        s sVar = this.f52067c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        this.f52067c.setData(list);
    }
}
