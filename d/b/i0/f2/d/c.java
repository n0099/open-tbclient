package d.b.i0.f2.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.b.b.j.e.n;
import java.util.List;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public BdTypeListView f54758a;

    /* renamed from: b  reason: collision with root package name */
    public a f54759b;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f54758a = bdTypeListView;
        this.f54759b = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void a() {
        this.f54759b.a();
    }

    public void b() {
        this.f54759b.c();
    }

    public void c() {
        this.f54759b.c();
    }

    public void d(List<n> list) {
        this.f54758a.setData(list);
    }

    public void e() {
        this.f54759b.d();
    }
}
