package d.a.n0.b1.j.a.b;

import com.baidu.tbadk.TbPageContext;
import d.a.c.j.e.n;
import d.a.c.j.e.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f51925a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.c.j.e.a> f51926b;

    /* renamed from: c  reason: collision with root package name */
    public s f51927c;

    /* renamed from: d  reason: collision with root package name */
    public c f51928d;

    /* renamed from: e  reason: collision with root package name */
    public a f51929e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.b1.j.b.b.b f51930f;

    public b(TbPageContext tbPageContext, s sVar) {
        this.f51925a = tbPageContext;
        this.f51927c = sVar;
        a();
        this.f51927c.a(this.f51926b);
    }

    public final void a() {
        this.f51926b = new ArrayList();
        this.f51928d = new c(this.f51925a);
        this.f51929e = new a(this.f51925a);
        this.f51930f = new d.a.n0.b1.j.b.b.b(this.f51925a);
        this.f51926b.add(this.f51928d);
        this.f51926b.add(this.f51929e);
        this.f51926b.add(this.f51930f);
    }

    public void b() {
        s sVar = this.f51927c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        this.f51927c.setData(list);
    }
}
