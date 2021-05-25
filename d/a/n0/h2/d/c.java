package d.a.n0.h2.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.j.e.n;
import java.util.List;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public BdTypeListView f55529a;

    /* renamed from: b  reason: collision with root package name */
    public a f55530b;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f55529a = bdTypeListView;
        this.f55530b = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void a() {
        this.f55530b.a();
    }

    public void b() {
        this.f55530b.c();
    }

    public void c() {
        this.f55530b.c();
    }

    public void d(List<n> list) {
        this.f55529a.setData(list);
    }

    public void e() {
        this.f55530b.d();
    }
}
