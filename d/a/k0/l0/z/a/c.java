package d.a.k0.l0.z.a;

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
    public TbPageContext f57239a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f57240b;

    /* renamed from: d  reason: collision with root package name */
    public b f57242d;

    /* renamed from: e  reason: collision with root package name */
    public d f57243e;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.a.c.j.e.a> f57241c = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public final List<n> f57244f = new ArrayList();

    public c(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, ForumEmotionModel forumEmotionModel) {
        this.f57239a = tbPageContext;
        this.f57240b = bdTypeListView;
        c(forumEmotionModel);
    }

    public void a(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (this.f57240b != null) {
            this.f57244f.addAll(list);
            this.f57240b.setData(this.f57244f);
        }
        d();
    }

    public int b() {
        return this.f57244f.size();
    }

    public final void c(ForumEmotionModel forumEmotionModel) {
        b bVar = new b(this.f57239a, forumEmotionModel.u(), d.a.k0.l0.z.b.c.f57248f);
        this.f57242d = bVar;
        this.f57241c.add(bVar);
        d dVar = new d(this.f57239a, forumEmotionModel.u(), d.a.k0.l0.z.b.a.f57245e);
        this.f57243e = dVar;
        this.f57241c.add(dVar);
        this.f57240b.a(this.f57241c);
    }

    public void d() {
        BdTypeListView bdTypeListView = this.f57240b;
        if (bdTypeListView == null || bdTypeListView.getAdapter2() == null || !(this.f57240b.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f57240b.getAdapter2().notifyDataSetChanged();
    }

    public void e(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f57244f)) {
            this.f57244f.clear();
        }
        BdTypeListView bdTypeListView = this.f57240b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
            this.f57244f.addAll(list);
        }
        d();
    }

    public void f(a aVar) {
        this.f57242d.g0(aVar);
        this.f57243e.g0(aVar);
    }

    public void g(ForumEmotionPackageData forumEmotionPackageData) {
        ForumEmotionPackageData forumEmotionPackageData2;
        if (forumEmotionPackageData == null || ListUtils.isEmpty(this.f57244f)) {
            return;
        }
        for (n nVar : this.f57244f) {
            if (nVar != null && (nVar instanceof d.a.k0.l0.z.b.c) && (forumEmotionPackageData2 = ((d.a.k0.l0.z.b.c) nVar).f57249e) != null && forumEmotionPackageData2.id == forumEmotionPackageData.id) {
                forumEmotionPackageData2.download = forumEmotionPackageData.download;
                forumEmotionPackageData2.share = forumEmotionPackageData.share;
                d();
                return;
            }
        }
    }
}
