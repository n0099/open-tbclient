package d.a.k0.v0.b;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.godSquare.adapter.GodSquareHotGodAdapter;
import com.baidu.tieba.godSquare.adapter.GodSquareRecGodAdapter;
import d.a.c.j.e.e;
import d.a.k0.x.f0.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d f62357a;

    /* renamed from: b  reason: collision with root package name */
    public GodSquareRecGodAdapter f62358b;

    /* renamed from: c  reason: collision with root package name */
    public GodSquareHotGodAdapter f62359c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.c.j.e.a> f62360d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f62361e;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f62361e = bdTypeListView;
        this.f62357a = new d(tbPageContext);
        this.f62358b = new GodSquareRecGodAdapter(tbPageContext);
        this.f62359c = new GodSquareHotGodAdapter(tbPageContext);
        this.f62360d.add(this.f62357a);
        this.f62360d.add(this.f62358b);
        this.f62360d.add(this.f62359c);
    }

    public List<d.a.c.j.e.a> a() {
        return this.f62360d;
    }

    public void b() {
        BdTypeListView bdTypeListView = this.f62361e;
        if (bdTypeListView == null || !(bdTypeListView.getAdapter2() instanceof e)) {
            return;
        }
        this.f62361e.getAdapter2().notifyDataSetChanged();
    }
}
