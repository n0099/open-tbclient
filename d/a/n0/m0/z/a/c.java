package d.a.n0.m0.z.a;

import android.widget.BaseAdapter;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.faceshop.forumpackage.data.ForumEmotionPackageData;
import com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel;
import d.a.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f57429a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f57430b;

    /* renamed from: d  reason: collision with root package name */
    public b f57432d;

    /* renamed from: e  reason: collision with root package name */
    public d f57433e;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.a.c.j.e.a> f57431c = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public final List<n> f57434f = new ArrayList();

    public c(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, ForumEmotionModel forumEmotionModel) {
        this.f57429a = tbPageContext;
        this.f57430b = bdTypeListView;
        c(forumEmotionModel);
    }

    public void a(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (this.f57430b != null) {
            this.f57434f.addAll(list);
            this.f57430b.setData(this.f57434f);
        }
        d();
    }

    public int b() {
        return this.f57434f.size();
    }

    public final void c(ForumEmotionModel forumEmotionModel) {
        b bVar = new b(this.f57429a, forumEmotionModel.u(), d.a.n0.m0.z.b.c.f57438f);
        this.f57432d = bVar;
        this.f57431c.add(bVar);
        d dVar = new d(this.f57429a, forumEmotionModel.u(), d.a.n0.m0.z.b.a.f57435e);
        this.f57433e = dVar;
        this.f57431c.add(dVar);
        this.f57430b.a(this.f57431c);
    }

    public void d() {
        BdTypeListView bdTypeListView = this.f57430b;
        if (bdTypeListView == null || bdTypeListView.getAdapter2() == null || !(this.f57430b.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f57430b.getAdapter2().notifyDataSetChanged();
    }

    public void e(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f57434f)) {
            this.f57434f.clear();
        }
        BdTypeListView bdTypeListView = this.f57430b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
            this.f57434f.addAll(list);
        }
        d();
    }

    public void f(a aVar) {
        this.f57432d.g0(aVar);
        this.f57433e.g0(aVar);
    }

    public void g(ForumEmotionPackageData forumEmotionPackageData) {
        ForumEmotionPackageData forumEmotionPackageData2;
        if (forumEmotionPackageData == null || ListUtils.isEmpty(this.f57434f)) {
            return;
        }
        for (n nVar : this.f57434f) {
            if (nVar != null && (nVar instanceof d.a.n0.m0.z.b.c) && (forumEmotionPackageData2 = ((d.a.n0.m0.z.b.c) nVar).f57439e) != null && forumEmotionPackageData2.id == forumEmotionPackageData.id) {
                forumEmotionPackageData2.download = forumEmotionPackageData.download;
                forumEmotionPackageData2.share = forumEmotionPackageData.share;
                d();
                return;
            }
        }
    }
}
