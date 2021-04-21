package d.b.j0.l0.y.b;

import android.widget.BaseAdapter;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.emotioncenter.adapter.EmotionCategoryAdapter;
import com.baidu.tieba.faceshop.emotioncenter.adapter.EmotionHorizontalAdapter;
import d.b.c.a.f;
import d.b.c.j.e.n;
import d.b.j0.l0.y.c.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public f f58503a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f58504b;

    /* renamed from: d  reason: collision with root package name */
    public EmotionCategoryAdapter f58506d;

    /* renamed from: e  reason: collision with root package name */
    public EmotionHorizontalAdapter f58507e;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.b.c.j.e.a> f58505c = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public List<n> f58508f = new ArrayList();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f58503a = tbPageContext;
        this.f58504b = bdTypeListView;
        b();
    }

    public void a(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (this.f58504b != null) {
            this.f58508f.addAll(list);
            this.f58504b.setData(this.f58508f);
        }
        c();
    }

    public final void b() {
        this.f58506d = new EmotionCategoryAdapter((TbPageContext) this.f58503a, d.b.j0.l0.y.c.a.f58509e);
        this.f58507e = new EmotionHorizontalAdapter((TbPageContext) this.f58503a, b.f58510f);
        this.f58505c.add(this.f58506d);
        this.f58505c.add(this.f58507e);
        this.f58504b.a(this.f58505c);
    }

    public void c() {
        BdTypeListView bdTypeListView = this.f58504b;
        if (bdTypeListView == null || bdTypeListView.getAdapter2() == null || !(this.f58504b.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f58504b.getAdapter2().notifyDataSetChanged();
    }

    public void d(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f58508f)) {
            this.f58508f.clear();
        }
        BdTypeListView bdTypeListView = this.f58504b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
            this.f58508f.addAll(list);
        }
        c();
    }

    public void e(EmotionPackageData emotionPackageData) {
        b bVar;
        EmotionPackageData emotionPackageData2;
        if (emotionPackageData == null || ListUtils.isEmpty(this.f58508f)) {
            return;
        }
        for (n nVar : this.f58508f) {
            if ((nVar instanceof b) && (bVar = (b) nVar) != null && (emotionPackageData2 = bVar.f58511e) != null && emotionPackageData2.id == emotionPackageData.id) {
                emotionPackageData2.download = emotionPackageData.download;
                emotionPackageData2.share = emotionPackageData.share;
                c();
                return;
            }
        }
    }
}
