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
    public d f54559a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f54560b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.b.b.j.e.a> f54561c = new ArrayList();

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, b0<h> b0Var) {
        this.f54560b = bdTypeListView;
        d dVar = new d(tbPageContext, h.p);
        this.f54559a = dVar;
        dVar.j0(b0Var);
        this.f54561c.add(this.f54559a);
        this.f54560b.a(this.f54561c);
    }

    public void a() {
        this.f54559a.L();
    }
}
