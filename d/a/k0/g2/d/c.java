package d.a.k0.g2.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.j.e.n;
import java.util.List;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public BdTypeListView f55255a;

    /* renamed from: b  reason: collision with root package name */
    public a f55256b;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f55255a = bdTypeListView;
        this.f55256b = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void a() {
        this.f55256b.a();
    }

    public void b() {
        this.f55256b.c();
    }

    public void c() {
        this.f55256b.c();
    }

    public void d(List<n> list) {
        this.f55255a.setData(list);
    }

    public void e() {
        this.f55256b.d();
    }
}
