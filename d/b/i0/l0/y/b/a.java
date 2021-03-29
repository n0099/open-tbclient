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
    public f f56676a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f56677b;

    /* renamed from: d  reason: collision with root package name */
    public EmotionCategoryAdapter f56679d;

    /* renamed from: e  reason: collision with root package name */
    public EmotionHorizontalAdapter f56680e;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.b.b.j.e.a> f56678c = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public List<n> f56681f = new ArrayList();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f56676a = tbPageContext;
        this.f56677b = bdTypeListView;
        b();
    }

    public void a(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (this.f56677b != null) {
            this.f56681f.addAll(list);
            this.f56677b.setData(this.f56681f);
        }
        c();
    }

    public final void b() {
        this.f56679d = new EmotionCategoryAdapter((TbPageContext) this.f56676a, d.b.i0.l0.y.c.a.f56682e);
        this.f56680e = new EmotionHorizontalAdapter((TbPageContext) this.f56676a, b.f56683f);
        this.f56678c.add(this.f56679d);
        this.f56678c.add(this.f56680e);
        this.f56677b.a(this.f56678c);
    }

    public void c() {
        BdTypeListView bdTypeListView = this.f56677b;
        if (bdTypeListView == null || bdTypeListView.getAdapter2() == null || !(this.f56677b.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f56677b.getAdapter2().notifyDataSetChanged();
    }

    public void d(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f56681f)) {
            this.f56681f.clear();
        }
        BdTypeListView bdTypeListView = this.f56677b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
            this.f56681f.addAll(list);
        }
        c();
    }

    public void e(EmotionPackageData emotionPackageData) {
        b bVar;
        EmotionPackageData emotionPackageData2;
        if (emotionPackageData == null || ListUtils.isEmpty(this.f56681f)) {
            return;
        }
        for (n nVar : this.f56681f) {
            if ((nVar instanceof b) && (bVar = (b) nVar) != null && (emotionPackageData2 = bVar.f56684e) != null && emotionPackageData2.id == emotionPackageData.id) {
                emotionPackageData2.download = emotionPackageData.download;
                emotionPackageData2.share = emotionPackageData.share;
                c();
                return;
            }
        }
    }
}
