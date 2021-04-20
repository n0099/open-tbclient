package d.b.i0.v0.b;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.godSquare.adapter.GodSquareHotGodAdapter;
import com.baidu.tieba.godSquare.adapter.GodSquareRecGodAdapter;
import d.b.c.j.e.e;
import d.b.i0.x.f0.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d f62982a;

    /* renamed from: b  reason: collision with root package name */
    public GodSquareRecGodAdapter f62983b;

    /* renamed from: c  reason: collision with root package name */
    public GodSquareHotGodAdapter f62984c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.b.c.j.e.a> f62985d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f62986e;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f62986e = bdTypeListView;
        this.f62982a = new d(tbPageContext);
        this.f62983b = new GodSquareRecGodAdapter(tbPageContext);
        this.f62984c = new GodSquareHotGodAdapter(tbPageContext);
        this.f62985d.add(this.f62982a);
        this.f62985d.add(this.f62983b);
        this.f62985d.add(this.f62984c);
    }

    public List<d.b.c.j.e.a> a() {
        return this.f62985d;
    }

    public void b() {
        BdTypeListView bdTypeListView = this.f62986e;
        if (bdTypeListView == null || !(bdTypeListView.getAdapter2() instanceof e)) {
            return;
        }
        this.f62986e.getAdapter2().notifyDataSetChanged();
    }
}
