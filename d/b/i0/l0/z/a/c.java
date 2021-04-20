package d.b.i0.l0.z.a;

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
    public TbPageContext f58103a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f58104b;

    /* renamed from: d  reason: collision with root package name */
    public b f58106d;

    /* renamed from: e  reason: collision with root package name */
    public d f58107e;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.b.c.j.e.a> f58105c = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public final List<n> f58108f = new ArrayList();

    public c(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, ForumEmotionModel forumEmotionModel) {
        this.f58103a = tbPageContext;
        this.f58104b = bdTypeListView;
        c(forumEmotionModel);
    }

    public void a(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (this.f58104b != null) {
            this.f58108f.addAll(list);
            this.f58104b.setData(this.f58108f);
        }
        d();
    }

    public int b() {
        return this.f58108f.size();
    }

    public final void c(ForumEmotionModel forumEmotionModel) {
        b bVar = new b(this.f58103a, forumEmotionModel.u(), d.b.i0.l0.z.b.c.f58112f);
        this.f58106d = bVar;
        this.f58105c.add(bVar);
        d dVar = new d(this.f58103a, forumEmotionModel.u(), d.b.i0.l0.z.b.a.f58109e);
        this.f58107e = dVar;
        this.f58105c.add(dVar);
        this.f58104b.a(this.f58105c);
    }

    public void d() {
        BdTypeListView bdTypeListView = this.f58104b;
        if (bdTypeListView == null || bdTypeListView.getAdapter2() == null || !(this.f58104b.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f58104b.getAdapter2().notifyDataSetChanged();
    }

    public void e(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f58108f)) {
            this.f58108f.clear();
        }
        BdTypeListView bdTypeListView = this.f58104b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
            this.f58108f.addAll(list);
        }
        d();
    }

    public void f(a aVar) {
        this.f58106d.j0(aVar);
        this.f58107e.j0(aVar);
    }

    public void g(ForumEmotionPackageData forumEmotionPackageData) {
        ForumEmotionPackageData forumEmotionPackageData2;
        if (forumEmotionPackageData == null || ListUtils.isEmpty(this.f58108f)) {
            return;
        }
        for (n nVar : this.f58108f) {
            if (nVar != null && (nVar instanceof d.b.i0.l0.z.b.c) && (forumEmotionPackageData2 = ((d.b.i0.l0.z.b.c) nVar).f58113e) != null && forumEmotionPackageData2.id == forumEmotionPackageData.id) {
                forumEmotionPackageData2.download = forumEmotionPackageData.download;
                forumEmotionPackageData2.share = forumEmotionPackageData.share;
                d();
                return;
            }
        }
    }
}
