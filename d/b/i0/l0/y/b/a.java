package d.b.i0.l0.y.b;

import android.widget.BaseAdapter;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.emotioncenter.adapter.EmotionCategoryAdapter;
import com.baidu.tieba.faceshop.emotioncenter.adapter.EmotionHorizontalAdapter;
import d.b.b.a.f;
import d.b.b.j.e.n;
import d.b.i0.l0.y.c.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public f f56675a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f56676b;

    /* renamed from: d  reason: collision with root package name */
    public EmotionCategoryAdapter f56678d;

    /* renamed from: e  reason: collision with root package name */
    public EmotionHorizontalAdapter f56679e;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.b.b.j.e.a> f56677c = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public List<n> f56680f = new ArrayList();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f56675a = tbPageContext;
        this.f56676b = bdTypeListView;
        b();
    }

    public void a(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (this.f56676b != null) {
            this.f56680f.addAll(list);
            this.f56676b.setData(this.f56680f);
        }
        c();
    }

    public final void b() {
        this.f56678d = new EmotionCategoryAdapter((TbPageContext) this.f56675a, d.b.i0.l0.y.c.a.f56681e);
        this.f56679e = new EmotionHorizontalAdapter((TbPageContext) this.f56675a, b.f56682f);
        this.f56677c.add(this.f56678d);
        this.f56677c.add(this.f56679e);
        this.f56676b.a(this.f56677c);
    }

    public void c() {
        BdTypeListView bdTypeListView = this.f56676b;
        if (bdTypeListView == null || bdTypeListView.getAdapter2() == null || !(this.f56676b.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f56676b.getAdapter2().notifyDataSetChanged();
    }

    public void d(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f56680f)) {
            this.f56680f.clear();
        }
        BdTypeListView bdTypeListView = this.f56676b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
            this.f56680f.addAll(list);
        }
        c();
    }

    public void e(EmotionPackageData emotionPackageData) {
        b bVar;
        EmotionPackageData emotionPackageData2;
        if (emotionPackageData == null || ListUtils.isEmpty(this.f56680f)) {
            return;
        }
        for (n nVar : this.f56680f) {
            if ((nVar instanceof b) && (bVar = (b) nVar) != null && (emotionPackageData2 = bVar.f56683e) != null && emotionPackageData2.id == emotionPackageData.id) {
                emotionPackageData2.download = emotionPackageData.download;
                emotionPackageData2.share = emotionPackageData.share;
                c();
                return;
            }
        }
    }
}
