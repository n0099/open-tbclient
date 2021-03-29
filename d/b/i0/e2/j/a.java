package d.b.i0.e2.j;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.b.i0.f2.c.d;
import d.b.i0.f2.e.h;
import d.b.i0.x.b0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d f54560a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f54561b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.b.b.j.e.a> f54562c = new ArrayList();

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, b0<h> b0Var) {
        this.f54561b = bdTypeListView;
        d dVar = new d(tbPageContext, h.p);
        this.f54560a = dVar;
        dVar.j0(b0Var);
        this.f54562c.add(this.f54560a);
        this.f54561b.a(this.f54562c);
    }

    public void a() {
        this.f54560a.L();
    }
}
