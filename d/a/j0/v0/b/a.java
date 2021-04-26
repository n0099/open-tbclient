package d.a.j0.v0.b;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.godSquare.adapter.GodSquareHotGodAdapter;
import com.baidu.tieba.godSquare.adapter.GodSquareRecGodAdapter;
import d.a.c.j.e.e;
import d.a.j0.x.f0.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d f61633a;

    /* renamed from: b  reason: collision with root package name */
    public GodSquareRecGodAdapter f61634b;

    /* renamed from: c  reason: collision with root package name */
    public GodSquareHotGodAdapter f61635c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.c.j.e.a> f61636d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f61637e;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f61637e = bdTypeListView;
        this.f61633a = new d(tbPageContext);
        this.f61634b = new GodSquareRecGodAdapter(tbPageContext);
        this.f61635c = new GodSquareHotGodAdapter(tbPageContext);
        this.f61636d.add(this.f61633a);
        this.f61636d.add(this.f61634b);
        this.f61636d.add(this.f61635c);
    }

    public List<d.a.c.j.e.a> a() {
        return this.f61636d;
    }

    public void b() {
        BdTypeListView bdTypeListView = this.f61637e;
        if (bdTypeListView == null || !(bdTypeListView.getAdapter2() instanceof e)) {
            return;
        }
        this.f61637e.getAdapter2().notifyDataSetChanged();
    }
}
