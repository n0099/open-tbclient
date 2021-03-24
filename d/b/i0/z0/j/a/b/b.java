package d.b.i0.z0.j.a.b;

import com.baidu.tbadk.TbPageContext;
import d.b.b.j.e.n;
import d.b.b.j.e.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f63297a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.b.b.j.e.a> f63298b;

    /* renamed from: c  reason: collision with root package name */
    public s f63299c;

    /* renamed from: d  reason: collision with root package name */
    public c f63300d;

    /* renamed from: e  reason: collision with root package name */
    public a f63301e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.z0.j.b.b.b f63302f;

    public b(TbPageContext tbPageContext, s sVar) {
        this.f63297a = tbPageContext;
        this.f63299c = sVar;
        a();
        this.f63299c.a(this.f63298b);
    }

    public final void a() {
        this.f63298b = new ArrayList();
        this.f63300d = new c(this.f63297a);
        this.f63301e = new a(this.f63297a);
        this.f63302f = new d.b.i0.z0.j.b.b.b(this.f63297a);
        this.f63298b.add(this.f63300d);
        this.f63298b.add(this.f63301e);
        this.f63298b.add(this.f63302f);
    }

    public void b() {
        s sVar = this.f63299c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        this.f63299c.setData(list);
    }
}
