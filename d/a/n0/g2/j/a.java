package d.a.n0.g2.j;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.a.n0.h2.c.d;
import d.a.n0.h2.e.h;
import d.a.n0.z.b0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d f55205a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f55206b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.j.e.a> f55207c = new ArrayList();

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, b0<h> b0Var) {
        this.f55206b = bdTypeListView;
        d dVar = new d(tbPageContext, h.p);
        this.f55205a = dVar;
        dVar.g0(b0Var);
        this.f55207c.add(this.f55205a);
        this.f55206b.a(this.f55207c);
    }

    public void a() {
        this.f55205a.K();
    }
}
