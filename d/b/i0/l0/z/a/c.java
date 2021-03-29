package d.b.i0.l0.z.a;

import android.widget.BaseAdapter;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.faceshop.forumpackage.data.ForumEmotionPackageData;
import com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel;
import d.b.b.j.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f56697a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f56698b;

    /* renamed from: d  reason: collision with root package name */
    public b f56700d;

    /* renamed from: e  reason: collision with root package name */
    public d f56701e;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.b.b.j.e.a> f56699c = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public final List<n> f56702f = new ArrayList();

    public c(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, ForumEmotionModel forumEmotionModel) {
        this.f56697a = tbPageContext;
        this.f56698b = bdTypeListView;
        c(forumEmotionModel);
    }

    public void a(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (this.f56698b != null) {
            this.f56702f.addAll(list);
            this.f56698b.setData(this.f56702f);
        }
        d();
    }

    public int b() {
        return this.f56702f.size();
    }

    public final void c(ForumEmotionModel forumEmotionModel) {
        b bVar = new b(this.f56697a, forumEmotionModel.u(), d.b.i0.l0.z.b.c.f56706f);
        this.f56700d = bVar;
        this.f56699c.add(bVar);
        d dVar = new d(this.f56697a, forumEmotionModel.u(), d.b.i0.l0.z.b.a.f56703e);
        this.f56701e = dVar;
        this.f56699c.add(dVar);
        this.f56698b.a(this.f56699c);
    }

    public void d() {
        BdTypeListView bdTypeListView = this.f56698b;
        if (bdTypeListView == null || bdTypeListView.getAdapter2() == null || !(this.f56698b.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f56698b.getAdapter2().notifyDataSetChanged();
    }

    public void e(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f56702f)) {
            this.f56702f.clear();
        }
        BdTypeListView bdTypeListView = this.f56698b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
            this.f56702f.addAll(list);
        }
        d();
    }

    public void f(a aVar) {
        this.f56700d.j0(aVar);
        this.f56701e.j0(aVar);
    }

    public void g(ForumEmotionPackageData forumEmotionPackageData) {
        ForumEmotionPackageData forumEmotionPackageData2;
        if (forumEmotionPackageData == null || ListUtils.isEmpty(this.f56702f)) {
            return;
        }
        for (n nVar : this.f56702f) {
            if (nVar != null && (nVar instanceof d.b.i0.l0.z.b.c) && (forumEmotionPackageData2 = ((d.b.i0.l0.z.b.c) nVar).f56707e) != null && forumEmotionPackageData2.id == forumEmotionPackageData.id) {
                forumEmotionPackageData2.download = forumEmotionPackageData.download;
                forumEmotionPackageData2.share = forumEmotionPackageData.share;
                d();
                return;
            }
        }
    }
}
