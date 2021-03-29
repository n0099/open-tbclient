package d.b.i0.u0.b;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.godSquare.adapter.GodSquareHotGodAdapter;
import com.baidu.tieba.godSquare.adapter.GodSquareRecGodAdapter;
import d.b.b.j.e.e;
import d.b.i0.x.f0.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d f61244a;

    /* renamed from: b  reason: collision with root package name */
    public GodSquareRecGodAdapter f61245b;

    /* renamed from: c  reason: collision with root package name */
    public GodSquareHotGodAdapter f61246c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.b.b.j.e.a> f61247d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f61248e;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f61248e = bdTypeListView;
        this.f61244a = new d(tbPageContext);
        this.f61245b = new GodSquareRecGodAdapter(tbPageContext);
        this.f61246c = new GodSquareHotGodAdapter(tbPageContext);
        this.f61247d.add(this.f61244a);
        this.f61247d.add(this.f61245b);
        this.f61247d.add(this.f61246c);
    }

    public List<d.b.b.j.e.a> a() {
        return this.f61247d;
    }

    public void b() {
        BdTypeListView bdTypeListView = this.f61248e;
        if (bdTypeListView == null || !(bdTypeListView.getAdapter2() instanceof e)) {
            return;
        }
        this.f61248e.getAdapter2().notifyDataSetChanged();
    }
}
