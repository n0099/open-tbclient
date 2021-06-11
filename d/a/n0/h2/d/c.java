package d.a.n0.h2.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.k.e.n;
import java.util.List;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public BdTypeListView f59218a;

    /* renamed from: b  reason: collision with root package name */
    public a f59219b;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f59218a = bdTypeListView;
        this.f59219b = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void a() {
        this.f59219b.a();
    }

    public void b() {
        this.f59219b.c();
    }

    public void c() {
        this.f59219b.c();
    }

    public void d(List<n> list) {
        this.f59218a.setData(list);
    }

    public void e() {
        this.f59219b.d();
    }
}
