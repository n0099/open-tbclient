package d.a.o0.g2.j;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.a.o0.h2.c.d;
import d.a.o0.h2.e.h;
import d.a.o0.z.b0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d f59019a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f59020b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.k.e.a> f59021c = new ArrayList();

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView, b0<h> b0Var) {
        this.f59020b = bdTypeListView;
        d dVar = new d(tbPageContext, h.p);
        this.f59019a = dVar;
        dVar.h0(b0Var);
        this.f59021c.add(this.f59019a);
        this.f59020b.a(this.f59021c);
    }

    public void a() {
        this.f59019a.L();
    }
}
