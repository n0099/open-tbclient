package d.a.n0.b1.k.a.b;

import com.baidu.tbadk.TbPageContext;
import d.a.c.k.e.n;
import d.a.c.k.e.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55614a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.c.k.e.a> f55615b;

    /* renamed from: c  reason: collision with root package name */
    public s f55616c;

    /* renamed from: d  reason: collision with root package name */
    public c f55617d;

    /* renamed from: e  reason: collision with root package name */
    public a f55618e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.b1.k.b.b.b f55619f;

    public b(TbPageContext tbPageContext, s sVar) {
        this.f55614a = tbPageContext;
        this.f55616c = sVar;
        a();
        this.f55616c.a(this.f55615b);
    }

    public final void a() {
        this.f55615b = new ArrayList();
        this.f55617d = new c(this.f55614a);
        this.f55618e = new a(this.f55614a);
        this.f55619f = new d.a.n0.b1.k.b.b.b(this.f55614a);
        this.f55615b.add(this.f55617d);
        this.f55615b.add(this.f55618e);
        this.f55615b.add(this.f55619f);
    }

    public void b() {
        s sVar = this.f55616c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        this.f55616c.setData(list);
    }
}
