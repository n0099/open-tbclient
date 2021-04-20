package d.b.i0.g2.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.b.c.j.e.n;
import java.util.List;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public BdTypeListView f56228a;

    /* renamed from: b  reason: collision with root package name */
    public a f56229b;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f56228a = bdTypeListView;
        this.f56229b = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void a() {
        this.f56229b.a();
    }

    public void b() {
        this.f56229b.c();
    }

    public void c() {
        this.f56229b.c();
    }

    public void d(List<n> list) {
        this.f56228a.setData(list);
    }

    public void e() {
        this.f56229b.d();
    }
}
