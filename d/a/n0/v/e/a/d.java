package d.a.n0.v.e.a;

import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.a.f f61855a;

    /* renamed from: b  reason: collision with root package name */
    public final List<d.a.c.j.e.a> f61856b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public BdTypeMultiColumnListView f61857c;

    /* renamed from: d  reason: collision with root package name */
    public e f61858d;

    /* renamed from: e  reason: collision with root package name */
    public h f61859e;

    public d(d.a.c.a.f fVar, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        this.f61855a = fVar;
        this.f61857c = bdTypeMultiColumnListView;
        a();
    }

    public final void a() {
        this.f61858d = new e((TbPageContext) this.f61855a, d.a.n0.v.e.b.c.f61869f);
        this.f61859e = new h((TbPageContext) this.f61855a, d.a.n0.v.e.b.c.f61870g);
        this.f61856b.add(this.f61858d);
        this.f61856b.add(this.f61859e);
        this.f61857c.addAdapters(this.f61856b);
    }

    public void b(d.a.n0.v.c cVar) {
        e eVar = this.f61858d;
        if (eVar != null) {
            eVar.g0(cVar);
        }
        h hVar = this.f61859e;
        if (hVar != null) {
            hVar.g0(cVar);
        }
    }

    public void c(List<n> list) {
        BdTypeMultiColumnListView bdTypeMultiColumnListView = this.f61857c;
        if (bdTypeMultiColumnListView != null) {
            bdTypeMultiColumnListView.setData(list);
        }
    }
}
