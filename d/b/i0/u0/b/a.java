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
    public d f61243a;

    /* renamed from: b  reason: collision with root package name */
    public GodSquareRecGodAdapter f61244b;

    /* renamed from: c  reason: collision with root package name */
    public GodSquareHotGodAdapter f61245c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.b.b.j.e.a> f61246d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f61247e;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f61247e = bdTypeListView;
        this.f61243a = new d(tbPageContext);
        this.f61244b = new GodSquareRecGodAdapter(tbPageContext);
        this.f61245c = new GodSquareHotGodAdapter(tbPageContext);
        this.f61246d.add(this.f61243a);
        this.f61246d.add(this.f61244b);
        this.f61246d.add(this.f61245c);
    }

    public List<d.b.b.j.e.a> a() {
        return this.f61246d;
    }

    public void b() {
        BdTypeListView bdTypeListView = this.f61247e;
        if (bdTypeListView == null || !(bdTypeListView.getAdapter2() instanceof e)) {
            return;
        }
        this.f61247e.getAdapter2().notifyDataSetChanged();
    }
}
