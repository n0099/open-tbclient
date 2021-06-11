package d.a.n0.w0.b;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.godSquare.adapter.GodSquareHotGodAdapter;
import com.baidu.tieba.godSquare.adapter.GodSquareRecGodAdapter;
import d.a.c.k.e.e;
import d.a.n0.z.f0.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d f66178a;

    /* renamed from: b  reason: collision with root package name */
    public GodSquareRecGodAdapter f66179b;

    /* renamed from: c  reason: collision with root package name */
    public GodSquareHotGodAdapter f66180c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.c.k.e.a> f66181d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f66182e;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f66182e = bdTypeListView;
        this.f66178a = new d(tbPageContext);
        this.f66179b = new GodSquareRecGodAdapter(tbPageContext);
        this.f66180c = new GodSquareHotGodAdapter(tbPageContext);
        this.f66181d.add(this.f66178a);
        this.f66181d.add(this.f66179b);
        this.f66181d.add(this.f66180c);
    }

    public List<d.a.c.k.e.a> a() {
        return this.f66181d;
    }

    public void b() {
        BdTypeListView bdTypeListView = this.f66182e;
        if (bdTypeListView == null || !(bdTypeListView.getAdapter2() instanceof e)) {
            return;
        }
        this.f66182e.getAdapter2().notifyDataSetChanged();
    }
}
