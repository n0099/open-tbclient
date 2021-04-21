package d.b.j0.a1.j.a.b;

import com.baidu.tbadk.TbPageContext;
import d.b.c.j.e.n;
import d.b.c.j.e.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f53338a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.b.c.j.e.a> f53339b;

    /* renamed from: c  reason: collision with root package name */
    public s f53340c;

    /* renamed from: d  reason: collision with root package name */
    public c f53341d;

    /* renamed from: e  reason: collision with root package name */
    public a f53342e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.j0.a1.j.b.b.b f53343f;

    public b(TbPageContext tbPageContext, s sVar) {
        this.f53338a = tbPageContext;
        this.f53340c = sVar;
        a();
        this.f53340c.a(this.f53339b);
    }

    public final void a() {
        this.f53339b = new ArrayList();
        this.f53341d = new c(this.f53338a);
        this.f53342e = new a(this.f53338a);
        this.f53343f = new d.b.j0.a1.j.b.b.b(this.f53338a);
        this.f53339b.add(this.f53341d);
        this.f53339b.add(this.f53342e);
        this.f53339b.add(this.f53343f);
    }

    public void b() {
        s sVar = this.f53340c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        this.f53340c.setData(list);
    }
}
