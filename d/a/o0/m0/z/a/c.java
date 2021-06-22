package d.a.o0.m0.z.a;

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
    public TbPageContext f61243a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f61244b;

    /* renamed from: d  reason: collision with root package name */
    public b f61246d;

    /* renamed from: e  reason: collision with root package name */
    public d f61247e;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.a.c.k.e.a> f61245c = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public final List<n> f61248f = new ArrayList();

    public c(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, ForumEmotionModel forumEmotionModel) {
        this.f61243a = tbPageContext;
        this.f61244b = bdTypeListView;
        c(forumEmotionModel);
    }

    public void a(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (this.f61244b != null) {
            this.f61248f.addAll(list);
            this.f61244b.setData(this.f61248f);
        }
        d();
    }

    public int b() {
        return this.f61248f.size();
    }

    public final void c(ForumEmotionModel forumEmotionModel) {
        b bVar = new b(this.f61243a, forumEmotionModel.y(), d.a.o0.m0.z.b.c.f61252f);
        this.f61246d = bVar;
        this.f61245c.add(bVar);
        d dVar = new d(this.f61243a, forumEmotionModel.y(), d.a.o0.m0.z.b.a.f61249e);
        this.f61247e = dVar;
        this.f61245c.add(dVar);
        this.f61244b.a(this.f61245c);
    }

    public void d() {
        BdTypeListView bdTypeListView = this.f61244b;
        if (bdTypeListView == null || bdTypeListView.getAdapter2() == null || !(this.f61244b.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f61244b.getAdapter2().notifyDataSetChanged();
    }

    public void e(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f61248f)) {
            this.f61248f.clear();
        }
        BdTypeListView bdTypeListView = this.f61244b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
            this.f61248f.addAll(list);
        }
        d();
    }

    public void f(a aVar) {
        this.f61246d.h0(aVar);
        this.f61247e.h0(aVar);
    }

    public void g(ForumEmotionPackageData forumEmotionPackageData) {
        ForumEmotionPackageData forumEmotionPackageData2;
        if (forumEmotionPackageData == null || ListUtils.isEmpty(this.f61248f)) {
            return;
        }
        for (n nVar : this.f61248f) {
            if (nVar != null && (nVar instanceof d.a.o0.m0.z.b.c) && (forumEmotionPackageData2 = ((d.a.o0.m0.z.b.c) nVar).f61253e) != null && forumEmotionPackageData2.id == forumEmotionPackageData.id) {
                forumEmotionPackageData2.download = forumEmotionPackageData.download;
                forumEmotionPackageData2.share = forumEmotionPackageData.share;
                d();
                return;
            }
        }
    }
}
