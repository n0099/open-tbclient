package d.a.o0.b1.k.a.b;

import com.baidu.tbadk.TbPageContext;
import d.a.c.k.e.n;
import d.a.c.k.e.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55739a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.c.k.e.a> f55740b;

    /* renamed from: c  reason: collision with root package name */
    public s f55741c;

    /* renamed from: d  reason: collision with root package name */
    public c f55742d;

    /* renamed from: e  reason: collision with root package name */
    public a f55743e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.o0.b1.k.b.b.b f55744f;

    public b(TbPageContext tbPageContext, s sVar) {
        this.f55739a = tbPageContext;
        this.f55741c = sVar;
        a();
        this.f55741c.a(this.f55740b);
    }

    public final void a() {
        this.f55740b = new ArrayList();
        this.f55742d = new c(this.f55739a);
        this.f55743e = new a(this.f55739a);
        this.f55744f = new d.a.o0.b1.k.b.b.b(this.f55739a);
        this.f55740b.add(this.f55742d);
        this.f55740b.add(this.f55743e);
        this.f55740b.add(this.f55744f);
    }

    public void b() {
        s sVar = this.f55741c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<n> list) {
        this.f55741c.setData(list);
    }
}
