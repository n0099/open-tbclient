package d.a.o0.m0.y.b;

import android.widget.BaseAdapter;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.emotioncenter.adapter.EmotionCategoryAdapter;
import com.baidu.tieba.faceshop.emotioncenter.adapter.EmotionHorizontalAdapter;
import d.a.c.a.f;
import d.a.c.k.e.n;
import d.a.o0.m0.y.c.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public f f61220a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f61221b;

    /* renamed from: d  reason: collision with root package name */
    public EmotionCategoryAdapter f61223d;

    /* renamed from: e  reason: collision with root package name */
    public EmotionHorizontalAdapter f61224e;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.a.c.k.e.a> f61222c = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public List<n> f61225f = new ArrayList();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f61220a = tbPageContext;
        this.f61221b = bdTypeListView;
        b();
    }

    public void a(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (this.f61221b != null) {
            this.f61225f.addAll(list);
            this.f61221b.setData(this.f61225f);
        }
        c();
    }

    public final void b() {
        this.f61223d = new EmotionCategoryAdapter((TbPageContext) this.f61220a, d.a.o0.m0.y.c.a.f61226e);
        this.f61224e = new EmotionHorizontalAdapter((TbPageContext) this.f61220a, b.f61227f);
        this.f61222c.add(this.f61223d);
        this.f61222c.add(this.f61224e);
        this.f61221b.a(this.f61222c);
    }

    public void c() {
        BdTypeListView bdTypeListView = this.f61221b;
        if (bdTypeListView == null || bdTypeListView.getAdapter2() == null || !(this.f61221b.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f61221b.getAdapter2().notifyDataSetChanged();
    }

    public void d(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f61225f)) {
            this.f61225f.clear();
        }
        BdTypeListView bdTypeListView = this.f61221b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
            this.f61225f.addAll(list);
        }
        c();
    }

    public void e(EmotionPackageData emotionPackageData) {
        b bVar;
        EmotionPackageData emotionPackageData2;
        if (emotionPackageData == null || ListUtils.isEmpty(this.f61225f)) {
            return;
        }
        for (n nVar : this.f61225f) {
            if ((nVar instanceof b) && (bVar = (b) nVar) != null && (emotionPackageData2 = bVar.f61228e) != null && emotionPackageData2.id == emotionPackageData.id) {
                emotionPackageData2.download = emotionPackageData.download;
                emotionPackageData2.share = emotionPackageData.share;
                c();
                return;
            }
        }
    }
}
