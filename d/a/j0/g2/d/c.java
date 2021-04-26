package d.a.j0.g2.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import d.a.c.j.e.n;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public BdTypeListView f54548a;

    /* renamed from: b  reason: collision with root package name */
    public a f54549b;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f54548a = bdTypeListView;
        this.f54549b = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void a() {
        this.f54549b.a();
    }

    public void b() {
        this.f54549b.c();
    }

    public void c() {
        this.f54549b.c();
    }

    public void d(List<n> list) {
        this.f54548a.setData(list);
    }

    public void e() {
        this.f54549b.d();
    }
}
