package d.a.o0.w0.b;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.godSquare.adapter.GodSquareHotGodAdapter;
import com.baidu.tieba.godSquare.adapter.GodSquareRecGodAdapter;
import d.a.c.k.e.e;
import d.a.o0.z.f0.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d f66303a;

    /* renamed from: b  reason: collision with root package name */
    public GodSquareRecGodAdapter f66304b;

    /* renamed from: c  reason: collision with root package name */
    public GodSquareHotGodAdapter f66305c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.c.k.e.a> f66306d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f66307e;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f66307e = bdTypeListView;
        this.f66303a = new d(tbPageContext);
        this.f66304b = new GodSquareRecGodAdapter(tbPageContext);
        this.f66305c = new GodSquareHotGodAdapter(tbPageContext);
        this.f66306d.add(this.f66303a);
        this.f66306d.add(this.f66304b);
        this.f66306d.add(this.f66305c);
    }

    public List<d.a.c.k.e.a> a() {
        return this.f66306d;
    }

    public void b() {
        BdTypeListView bdTypeListView = this.f66307e;
        if (bdTypeListView == null || !(bdTypeListView.getAdapter2() instanceof e)) {
            return;
        }
        this.f66307e.getAdapter2().notifyDataSetChanged();
    }
}
