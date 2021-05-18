package d.a.k0.f2.j;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.a.k0.g2.c.d;
import d.a.k0.g2.e.h;
import d.a.k0.x.b0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d f55017a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f55018b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.j.e.a> f55019c = new ArrayList();

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, b0<h> b0Var) {
        this.f55018b = bdTypeListView;
        d dVar = new d(tbPageContext, h.p);
        this.f55017a = dVar;
        dVar.g0(b0Var);
        this.f55019c.add(this.f55017a);
        this.f55018b.a(this.f55019c);
    }

    public void a() {
        this.f55017a.K();
    }
}
