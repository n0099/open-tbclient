package d.a.j0.l0.z.a;

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
    public TbPageContext f56532a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f56533b;

    /* renamed from: d  reason: collision with root package name */
    public b f56535d;

    /* renamed from: e  reason: collision with root package name */
    public d f56536e;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.a.c.j.e.a> f56534c = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public final List<n> f56537f = new ArrayList();

    public c(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, ForumEmotionModel forumEmotionModel) {
        this.f56532a = tbPageContext;
        this.f56533b = bdTypeListView;
        c(forumEmotionModel);
    }

    public void a(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (this.f56533b != null) {
            this.f56537f.addAll(list);
            this.f56533b.setData(this.f56537f);
        }
        d();
    }

    public int b() {
        return this.f56537f.size();
    }

    public final void c(ForumEmotionModel forumEmotionModel) {
        b bVar = new b(this.f56532a, forumEmotionModel.u(), d.a.j0.l0.z.b.c.f56541f);
        this.f56535d = bVar;
        this.f56534c.add(bVar);
        d dVar = new d(this.f56532a, forumEmotionModel.u(), d.a.j0.l0.z.b.a.f56538e);
        this.f56536e = dVar;
        this.f56534c.add(dVar);
        this.f56533b.a(this.f56534c);
    }

    public void d() {
        BdTypeListView bdTypeListView = this.f56533b;
        if (bdTypeListView == null || bdTypeListView.getAdapter2() == null || !(this.f56533b.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f56533b.getAdapter2().notifyDataSetChanged();
    }

    public void e(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f56537f)) {
            this.f56537f.clear();
        }
        BdTypeListView bdTypeListView = this.f56533b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
            this.f56537f.addAll(list);
        }
        d();
    }

    public void f(a aVar) {
        this.f56535d.g0(aVar);
        this.f56536e.g0(aVar);
    }

    public void g(ForumEmotionPackageData forumEmotionPackageData) {
        ForumEmotionPackageData forumEmotionPackageData2;
        if (forumEmotionPackageData == null || ListUtils.isEmpty(this.f56537f)) {
            return;
        }
        for (n nVar : this.f56537f) {
            if (nVar != null && (nVar instanceof d.a.j0.l0.z.b.c) && (forumEmotionPackageData2 = ((d.a.j0.l0.z.b.c) nVar).f56542e) != null && forumEmotionPackageData2.id == forumEmotionPackageData.id) {
                forumEmotionPackageData2.download = forumEmotionPackageData.download;
                forumEmotionPackageData2.share = forumEmotionPackageData.share;
                d();
                return;
            }
        }
    }
}
