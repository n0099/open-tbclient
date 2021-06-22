package d.a.o0.v.e.a;

import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.k.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.a.f f65695a;

    /* renamed from: b  reason: collision with root package name */
    public final List<d.a.c.k.e.a> f65696b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public BdTypeMultiColumnListView f65697c;

    /* renamed from: d  reason: collision with root package name */
    public e f65698d;

    /* renamed from: e  reason: collision with root package name */
    public h f65699e;

    public d(d.a.c.a.f fVar, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        this.f65695a = fVar;
        this.f65697c = bdTypeMultiColumnListView;
        a();
    }

    public final void a() {
        this.f65698d = new e((TbPageContext) this.f65695a, d.a.o0.v.e.b.c.f65709f);
        this.f65699e = new h((TbPageContext) this.f65695a, d.a.o0.v.e.b.c.f65710g);
        this.f65696b.add(this.f65698d);
        this.f65696b.add(this.f65699e);
        this.f65697c.addAdapters(this.f65696b);
    }

    public void b(d.a.o0.v.c cVar) {
        e eVar = this.f65698d;
        if (eVar != null) {
            eVar.h0(cVar);
        }
        h hVar = this.f65699e;
        if (hVar != null) {
            hVar.h0(cVar);
        }
    }

    public void c(List<n> list) {
        BdTypeMultiColumnListView bdTypeMultiColumnListView = this.f65697c;
        if (bdTypeMultiColumnListView != null) {
            bdTypeMultiColumnListView.setData(list);
        }
    }
}
