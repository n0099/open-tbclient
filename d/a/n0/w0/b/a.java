package d.a.n0.w0.b;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.godSquare.adapter.GodSquareHotGodAdapter;
import com.baidu.tieba.godSquare.adapter.GodSquareRecGodAdapter;
import d.a.c.j.e.e;
import d.a.n0.z.f0.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d f62463a;

    /* renamed from: b  reason: collision with root package name */
    public GodSquareRecGodAdapter f62464b;

    /* renamed from: c  reason: collision with root package name */
    public GodSquareHotGodAdapter f62465c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.c.j.e.a> f62466d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f62467e;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f62467e = bdTypeListView;
        this.f62463a = new d(tbPageContext);
        this.f62464b = new GodSquareRecGodAdapter(tbPageContext);
        this.f62465c = new GodSquareHotGodAdapter(tbPageContext);
        this.f62466d.add(this.f62463a);
        this.f62466d.add(this.f62464b);
        this.f62466d.add(this.f62465c);
    }

    public List<d.a.c.j.e.a> a() {
        return this.f62466d;
    }

    public void b() {
        BdTypeListView bdTypeListView = this.f62467e;
        if (bdTypeListView == null || !(bdTypeListView.getAdapter2() instanceof e)) {
            return;
        }
        this.f62467e.getAdapter2().notifyDataSetChanged();
    }
}
