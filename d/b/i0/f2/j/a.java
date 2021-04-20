package d.b.i0.f2.j;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.b.i0.g2.c.d;
import d.b.i0.g2.e.h;
import d.b.i0.x.b0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d f56001a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f56002b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.b.c.j.e.a> f56003c = new ArrayList();

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, b0<h> b0Var) {
        this.f56002b = bdTypeListView;
        d dVar = new d(tbPageContext, h.p);
        this.f56001a = dVar;
        dVar.j0(b0Var);
        this.f56003c.add(this.f56001a);
        this.f56002b.a(this.f56003c);
    }

    public void a() {
        this.f56001a.L();
    }
}
