package d.a.k0.l0.y.b;

import android.widget.BaseAdapter;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.emotioncenter.adapter.EmotionCategoryAdapter;
import com.baidu.tieba.faceshop.emotioncenter.adapter.EmotionHorizontalAdapter;
import d.a.c.a.f;
import d.a.c.j.e.n;
import d.a.k0.l0.y.c.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public f f57216a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f57217b;

    /* renamed from: d  reason: collision with root package name */
    public EmotionCategoryAdapter f57219d;

    /* renamed from: e  reason: collision with root package name */
    public EmotionHorizontalAdapter f57220e;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.a.c.j.e.a> f57218c = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public List<n> f57221f = new ArrayList();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f57216a = tbPageContext;
        this.f57217b = bdTypeListView;
        b();
    }

    public void a(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (this.f57217b != null) {
            this.f57221f.addAll(list);
            this.f57217b.setData(this.f57221f);
        }
        c();
    }

    public final void b() {
        this.f57219d = new EmotionCategoryAdapter((TbPageContext) this.f57216a, d.a.k0.l0.y.c.a.f57222e);
        this.f57220e = new EmotionHorizontalAdapter((TbPageContext) this.f57216a, b.f57223f);
        this.f57218c.add(this.f57219d);
        this.f57218c.add(this.f57220e);
        this.f57217b.a(this.f57218c);
    }

    public void c() {
        BdTypeListView bdTypeListView = this.f57217b;
        if (bdTypeListView == null || bdTypeListView.getAdapter2() == null || !(this.f57217b.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f57217b.getAdapter2().notifyDataSetChanged();
    }

    public void d(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f57221f)) {
            this.f57221f.clear();
        }
        BdTypeListView bdTypeListView = this.f57217b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
            this.f57221f.addAll(list);
        }
        c();
    }

    public void e(EmotionPackageData emotionPackageData) {
        b bVar;
        EmotionPackageData emotionPackageData2;
        if (emotionPackageData == null || ListUtils.isEmpty(this.f57221f)) {
            return;
        }
        for (n nVar : this.f57221f) {
            if ((nVar instanceof b) && (bVar = (b) nVar) != null && (emotionPackageData2 = bVar.f57224e) != null && emotionPackageData2.id == emotionPackageData.id) {
                emotionPackageData2.download = emotionPackageData.download;
                emotionPackageData2.share = emotionPackageData.share;
                c();
                return;
            }
        }
    }
}
