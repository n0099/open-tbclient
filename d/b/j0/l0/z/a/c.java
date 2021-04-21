package d.b.j0.l0.z.a;

import android.widget.BaseAdapter;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.faceshop.forumpackage.data.ForumEmotionPackageData;
import com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel;
import d.b.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f58524a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f58525b;

    /* renamed from: d  reason: collision with root package name */
    public b f58527d;

    /* renamed from: e  reason: collision with root package name */
    public d f58528e;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.b.c.j.e.a> f58526c = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public final List<n> f58529f = new ArrayList();

    public c(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, ForumEmotionModel forumEmotionModel) {
        this.f58524a = tbPageContext;
        this.f58525b = bdTypeListView;
        c(forumEmotionModel);
    }

    public void a(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (this.f58525b != null) {
            this.f58529f.addAll(list);
            this.f58525b.setData(this.f58529f);
        }
        d();
    }

    public int b() {
        return this.f58529f.size();
    }

    public final void c(ForumEmotionModel forumEmotionModel) {
        b bVar = new b(this.f58524a, forumEmotionModel.u(), d.b.j0.l0.z.b.c.f58533f);
        this.f58527d = bVar;
        this.f58526c.add(bVar);
        d dVar = new d(this.f58524a, forumEmotionModel.u(), d.b.j0.l0.z.b.a.f58530e);
        this.f58528e = dVar;
        this.f58526c.add(dVar);
        this.f58525b.a(this.f58526c);
    }

    public void d() {
        BdTypeListView bdTypeListView = this.f58525b;
        if (bdTypeListView == null || bdTypeListView.getAdapter2() == null || !(this.f58525b.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f58525b.getAdapter2().notifyDataSetChanged();
    }

    public void e(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f58529f)) {
            this.f58529f.clear();
        }
        BdTypeListView bdTypeListView = this.f58525b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
            this.f58529f.addAll(list);
        }
        d();
    }

    public void f(a aVar) {
        this.f58527d.j0(aVar);
        this.f58528e.j0(aVar);
    }

    public void g(ForumEmotionPackageData forumEmotionPackageData) {
        ForumEmotionPackageData forumEmotionPackageData2;
        if (forumEmotionPackageData == null || ListUtils.isEmpty(this.f58529f)) {
            return;
        }
        for (n nVar : this.f58529f) {
            if (nVar != null && (nVar instanceof d.b.j0.l0.z.b.c) && (forumEmotionPackageData2 = ((d.b.j0.l0.z.b.c) nVar).f58534e) != null && forumEmotionPackageData2.id == forumEmotionPackageData.id) {
                forumEmotionPackageData2.download = forumEmotionPackageData.download;
                forumEmotionPackageData2.share = forumEmotionPackageData.share;
                d();
                return;
            }
        }
    }
}
