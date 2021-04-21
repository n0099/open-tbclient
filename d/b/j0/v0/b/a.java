package d.b.j0.v0.b;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.godSquare.adapter.GodSquareHotGodAdapter;
import com.baidu.tieba.godSquare.adapter.GodSquareRecGodAdapter;
import d.b.c.j.e.e;
import d.b.j0.x.f0.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d f63403a;

    /* renamed from: b  reason: collision with root package name */
    public GodSquareRecGodAdapter f63404b;

    /* renamed from: c  reason: collision with root package name */
    public GodSquareHotGodAdapter f63405c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.b.c.j.e.a> f63406d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f63407e;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f63407e = bdTypeListView;
        this.f63403a = new d(tbPageContext);
        this.f63404b = new GodSquareRecGodAdapter(tbPageContext);
        this.f63405c = new GodSquareHotGodAdapter(tbPageContext);
        this.f63406d.add(this.f63403a);
        this.f63406d.add(this.f63404b);
        this.f63406d.add(this.f63405c);
    }

    public List<d.b.c.j.e.a> a() {
        return this.f63406d;
    }

    public void b() {
        BdTypeListView bdTypeListView = this.f63407e;
        if (bdTypeListView == null || !(bdTypeListView.getAdapter2() instanceof e)) {
            return;
        }
        this.f63407e.getAdapter2().notifyDataSetChanged();
    }
}
