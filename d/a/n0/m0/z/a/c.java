package d.a.n0.m0.z.a;

import android.widget.BaseAdapter;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.faceshop.forumpackage.data.ForumEmotionPackageData;
import com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel;
import d.a.c.k.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f61118a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f61119b;

    /* renamed from: d  reason: collision with root package name */
    public b f61121d;

    /* renamed from: e  reason: collision with root package name */
    public d f61122e;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.a.c.k.e.a> f61120c = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public final List<n> f61123f = new ArrayList();

    public c(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, ForumEmotionModel forumEmotionModel) {
        this.f61118a = tbPageContext;
        this.f61119b = bdTypeListView;
        c(forumEmotionModel);
    }

    public void a(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (this.f61119b != null) {
            this.f61123f.addAll(list);
            this.f61119b.setData(this.f61123f);
        }
        d();
    }

    public int b() {
        return this.f61123f.size();
    }

    public final void c(ForumEmotionModel forumEmotionModel) {
        b bVar = new b(this.f61118a, forumEmotionModel.y(), d.a.n0.m0.z.b.c.f61127f);
        this.f61121d = bVar;
        this.f61120c.add(bVar);
        d dVar = new d(this.f61118a, forumEmotionModel.y(), d.a.n0.m0.z.b.a.f61124e);
        this.f61122e = dVar;
        this.f61120c.add(dVar);
        this.f61119b.a(this.f61120c);
    }

    public void d() {
        BdTypeListView bdTypeListView = this.f61119b;
        if (bdTypeListView == null || bdTypeListView.getAdapter2() == null || !(this.f61119b.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f61119b.getAdapter2().notifyDataSetChanged();
    }

    public void e(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f61123f)) {
            this.f61123f.clear();
        }
        BdTypeListView bdTypeListView = this.f61119b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
            this.f61123f.addAll(list);
        }
        d();
    }

    public void f(a aVar) {
        this.f61121d.h0(aVar);
        this.f61122e.h0(aVar);
    }

    public void g(ForumEmotionPackageData forumEmotionPackageData) {
        ForumEmotionPackageData forumEmotionPackageData2;
        if (forumEmotionPackageData == null || ListUtils.isEmpty(this.f61123f)) {
            return;
        }
        for (n nVar : this.f61123f) {
            if (nVar != null && (nVar instanceof d.a.n0.m0.z.b.c) && (forumEmotionPackageData2 = ((d.a.n0.m0.z.b.c) nVar).f61128e) != null && forumEmotionPackageData2.id == forumEmotionPackageData.id) {
                forumEmotionPackageData2.download = forumEmotionPackageData.download;
                forumEmotionPackageData2.share = forumEmotionPackageData.share;
                d();
                return;
            }
        }
    }
}
