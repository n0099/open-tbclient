package d.a.n0.m0.y.b;

import android.widget.BaseAdapter;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.emotioncenter.adapter.EmotionCategoryAdapter;
import com.baidu.tieba.faceshop.emotioncenter.adapter.EmotionHorizontalAdapter;
import d.a.c.a.f;
import d.a.c.j.e.n;
import d.a.n0.m0.y.c.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public f f57406a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f57407b;

    /* renamed from: d  reason: collision with root package name */
    public EmotionCategoryAdapter f57409d;

    /* renamed from: e  reason: collision with root package name */
    public EmotionHorizontalAdapter f57410e;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.a.c.j.e.a> f57408c = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public List<n> f57411f = new ArrayList();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f57406a = tbPageContext;
        this.f57407b = bdTypeListView;
        b();
    }

    public void a(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (this.f57407b != null) {
            this.f57411f.addAll(list);
            this.f57407b.setData(this.f57411f);
        }
        c();
    }

    public final void b() {
        this.f57409d = new EmotionCategoryAdapter((TbPageContext) this.f57406a, d.a.n0.m0.y.c.a.f57412e);
        this.f57410e = new EmotionHorizontalAdapter((TbPageContext) this.f57406a, b.f57413f);
        this.f57408c.add(this.f57409d);
        this.f57408c.add(this.f57410e);
        this.f57407b.a(this.f57408c);
    }

    public void c() {
        BdTypeListView bdTypeListView = this.f57407b;
        if (bdTypeListView == null || bdTypeListView.getAdapter2() == null || !(this.f57407b.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f57407b.getAdapter2().notifyDataSetChanged();
    }

    public void d(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f57411f)) {
            this.f57411f.clear();
        }
        BdTypeListView bdTypeListView = this.f57407b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
            this.f57411f.addAll(list);
        }
        c();
    }

    public void e(EmotionPackageData emotionPackageData) {
        b bVar;
        EmotionPackageData emotionPackageData2;
        if (emotionPackageData == null || ListUtils.isEmpty(this.f57411f)) {
            return;
        }
        for (n nVar : this.f57411f) {
            if ((nVar instanceof b) && (bVar = (b) nVar) != null && (emotionPackageData2 = bVar.f57414e) != null && emotionPackageData2.id == emotionPackageData.id) {
                emotionPackageData2.download = emotionPackageData.download;
                emotionPackageData2.share = emotionPackageData.share;
                c();
                return;
            }
        }
    }
}
