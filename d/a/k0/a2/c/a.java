package d.a.k0.a2.c;

import com.baidu.tbadk.TbPageContext;
import d.a.c.j.e.n;
import d.a.c.j.e.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f51898a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.c.j.e.a> f51899b;

    /* renamed from: c  reason: collision with root package name */
    public s f51900c;

    public a(TbPageContext tbPageContext, s sVar) {
        this.f51898a = tbPageContext;
        this.f51900c = sVar;
        a();
        this.f51900c.a(this.f51899b);
    }

    public final void a() {
        ArrayList arrayList = new ArrayList();
        this.f51899b = arrayList;
        arrayList.add(new b(this.f51898a));
    }

    public void b() {
        s sVar = this.f51900c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        this.f51900c.setData(list);
    }
}
