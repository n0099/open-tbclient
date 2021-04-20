package d.b.i0.a2.c;

import com.baidu.tbadk.TbPageContext;
import d.b.c.j.e.n;
import d.b.c.j.e.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f53049a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.b.c.j.e.a> f53050b;

    /* renamed from: c  reason: collision with root package name */
    public s f53051c;

    public a(TbPageContext tbPageContext, s sVar) {
        this.f53049a = tbPageContext;
        this.f53051c = sVar;
        a();
        this.f53051c.a(this.f53050b);
    }

    public final void a() {
        ArrayList arrayList = new ArrayList();
        this.f53050b = arrayList;
        arrayList.add(new b(this.f53049a));
    }

    public void b() {
        s sVar = this.f53051c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        this.f53051c.setData(list);
    }
}
