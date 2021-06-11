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
    public d f58894a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f58895b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.k.e.a> f58896c = new ArrayList();

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, b0<h> b0Var) {
        this.f58895b = bdTypeListView;
        d dVar = new d(tbPageContext, h.p);
        this.f58894a = dVar;
        dVar.h0(b0Var);
        this.f58896c.add(this.f58894a);
        this.f58895b.a(this.f58896c);
    }

    public void a() {
        this.f58894a.L();
    }
}
