package d.b.j0.f2.j;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.b.j0.g2.c.d;
import d.b.j0.g2.e.h;
import d.b.j0.x.b0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d f56422a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f56423b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.b.c.j.e.a> f56424c = new ArrayList();

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, b0<h> b0Var) {
        this.f56423b = bdTypeListView;
        d dVar = new d(tbPageContext, h.p);
        this.f56422a = dVar;
        dVar.j0(b0Var);
        this.f56424c.add(this.f56422a);
        this.f56423b.a(this.f56424c);
    }

    public void a() {
        this.f56422a.L();
    }
}
