package d.b.i0.a1.j.a.b;

import com.baidu.tbadk.TbPageContext;
import d.b.c.j.e.n;
import d.b.c.j.e.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f52917a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.b.c.j.e.a> f52918b;

    /* renamed from: c  reason: collision with root package name */
    public s f52919c;

    /* renamed from: d  reason: collision with root package name */
    public c f52920d;

    /* renamed from: e  reason: collision with root package name */
    public a f52921e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.a1.j.b.b.b f52922f;

    public b(TbPageContext tbPageContext, s sVar) {
        this.f52917a = tbPageContext;
        this.f52919c = sVar;
        a();
        this.f52919c.a(this.f52918b);
    }

    public final void a() {
        this.f52918b = new ArrayList();
        this.f52920d = new c(this.f52917a);
        this.f52921e = new a(this.f52917a);
        this.f52922f = new d.b.i0.a1.j.b.b.b(this.f52917a);
        this.f52918b.add(this.f52920d);
        this.f52918b.add(this.f52921e);
        this.f52918b.add(this.f52922f);
    }

    public void b() {
        s sVar = this.f52919c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        this.f52919c.setData(list);
    }
}
