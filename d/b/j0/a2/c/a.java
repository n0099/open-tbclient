package d.b.j0.a2.c;

import com.baidu.tbadk.TbPageContext;
import d.b.c.j.e.n;
import d.b.c.j.e.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f53470a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.b.c.j.e.a> f53471b;

    /* renamed from: c  reason: collision with root package name */
    public s f53472c;

    public a(TbPageContext tbPageContext, s sVar) {
        this.f53470a = tbPageContext;
        this.f53472c = sVar;
        a();
        this.f53472c.a(this.f53471b);
    }

    public final void a() {
        ArrayList arrayList = new ArrayList();
        this.f53471b = arrayList;
        arrayList.add(new b(this.f53470a));
    }

    public void b() {
        s sVar = this.f53472c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        this.f53472c.setData(list);
    }
}
