package d.a.j0.a1.j.a.b;

import com.baidu.tbadk.TbPageContext;
import d.a.c.j.e.n;
import d.a.c.j.e.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f51059a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.c.j.e.a> f51060b;

    /* renamed from: c  reason: collision with root package name */
    public s f51061c;

    /* renamed from: d  reason: collision with root package name */
    public c f51062d;

    /* renamed from: e  reason: collision with root package name */
    public a f51063e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.j0.a1.j.b.b.b f51064f;

    public b(TbPageContext tbPageContext, s sVar) {
        this.f51059a = tbPageContext;
        this.f51061c = sVar;
        a();
        this.f51061c.a(this.f51060b);
    }

    public final void a() {
        this.f51060b = new ArrayList();
        this.f51062d = new c(this.f51059a);
        this.f51063e = new a(this.f51059a);
        this.f51064f = new d.a.j0.a1.j.b.b.b(this.f51059a);
        this.f51060b.add(this.f51062d);
        this.f51060b.add(this.f51063e);
        this.f51060b.add(this.f51064f);
    }

    public void b() {
        s sVar = this.f51061c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        this.f51061c.setData(list);
    }
}
