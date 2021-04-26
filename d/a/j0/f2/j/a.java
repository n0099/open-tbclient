package d.a.j0.f2.j;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.a.j0.g2.c.d;
import d.a.j0.g2.e.h;
import d.a.j0.x.b0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d f54310a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f54311b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.j.e.a> f54312c = new ArrayList();

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, b0<h> b0Var) {
        this.f54311b = bdTypeListView;
        d dVar = new d(tbPageContext, h.p);
        this.f54310a = dVar;
        dVar.g0(b0Var);
        this.f54312c.add(this.f54310a);
        this.f54311b.a(this.f54312c);
    }

    public void a() {
        this.f54310a.K();
    }
}
