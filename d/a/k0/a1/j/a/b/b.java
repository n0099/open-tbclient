package d.a.k0.a1.j.a.b;

import com.baidu.tbadk.TbPageContext;
import d.a.c.j.e.n;
import d.a.c.j.e.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f51758a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.c.j.e.a> f51759b;

    /* renamed from: c  reason: collision with root package name */
    public s f51760c;

    /* renamed from: d  reason: collision with root package name */
    public c f51761d;

    /* renamed from: e  reason: collision with root package name */
    public a f51762e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.k0.a1.j.b.b.b f51763f;

    public b(TbPageContext tbPageContext, s sVar) {
        this.f51758a = tbPageContext;
        this.f51760c = sVar;
        a();
        this.f51760c.a(this.f51759b);
    }

    public final void a() {
        this.f51759b = new ArrayList();
        this.f51761d = new c(this.f51758a);
        this.f51762e = new a(this.f51758a);
        this.f51763f = new d.a.k0.a1.j.b.b.b(this.f51758a);
        this.f51759b.add(this.f51761d);
        this.f51759b.add(this.f51762e);
        this.f51759b.add(this.f51763f);
    }

    public void b() {
        s sVar = this.f51760c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        this.f51760c.setData(list);
    }
}
