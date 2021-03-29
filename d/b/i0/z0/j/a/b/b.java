package d.b.i0.z0.j.a.b;

import com.baidu.tbadk.TbPageContext;
import d.b.b.j.e.n;
import d.b.b.j.e.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f63298a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.b.b.j.e.a> f63299b;

    /* renamed from: c  reason: collision with root package name */
    public s f63300c;

    /* renamed from: d  reason: collision with root package name */
    public c f63301d;

    /* renamed from: e  reason: collision with root package name */
    public a f63302e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.z0.j.b.b.b f63303f;

    public b(TbPageContext tbPageContext, s sVar) {
        this.f63298a = tbPageContext;
        this.f63300c = sVar;
        a();
        this.f63300c.a(this.f63299b);
    }

    public final void a() {
        this.f63299b = new ArrayList();
        this.f63301d = new c(this.f63298a);
        this.f63302e = new a(this.f63298a);
        this.f63303f = new d.b.i0.z0.j.b.b.b(this.f63298a);
        this.f63299b.add(this.f63301d);
        this.f63299b.add(this.f63302e);
        this.f63299b.add(this.f63303f);
    }

    public void b() {
        s sVar = this.f63300c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        this.f63300c.setData(list);
    }
}
