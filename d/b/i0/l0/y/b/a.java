package d.b.i0.l0.y.b;

import android.widget.BaseAdapter;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.emotioncenter.adapter.EmotionCategoryAdapter;
import com.baidu.tieba.faceshop.emotioncenter.adapter.EmotionHorizontalAdapter;
import d.b.c.a.f;
import d.b.c.j.e.n;
import d.b.i0.l0.y.c.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public f f58082a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f58083b;

    /* renamed from: d  reason: collision with root package name */
    public EmotionCategoryAdapter f58085d;

    /* renamed from: e  reason: collision with root package name */
    public EmotionHorizontalAdapter f58086e;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.b.c.j.e.a> f58084c = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public List<n> f58087f = new ArrayList();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f58082a = tbPageContext;
        this.f58083b = bdTypeListView;
        b();
    }

    public void a(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (this.f58083b != null) {
            this.f58087f.addAll(list);
            this.f58083b.setData(this.f58087f);
        }
        c();
    }

    public final void b() {
        this.f58085d = new EmotionCategoryAdapter((TbPageContext) this.f58082a, d.b.i0.l0.y.c.a.f58088e);
        this.f58086e = new EmotionHorizontalAdapter((TbPageContext) this.f58082a, b.f58089f);
        this.f58084c.add(this.f58085d);
        this.f58084c.add(this.f58086e);
        this.f58083b.a(this.f58084c);
    }

    public void c() {
        BdTypeListView bdTypeListView = this.f58083b;
        if (bdTypeListView == null || bdTypeListView.getAdapter2() == null || !(this.f58083b.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f58083b.getAdapter2().notifyDataSetChanged();
    }

    public void d(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f58087f)) {
            this.f58087f.clear();
        }
        BdTypeListView bdTypeListView = this.f58083b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
            this.f58087f.addAll(list);
        }
        c();
    }

    public void e(EmotionPackageData emotionPackageData) {
        b bVar;
        EmotionPackageData emotionPackageData2;
        if (emotionPackageData == null || ListUtils.isEmpty(this.f58087f)) {
            return;
        }
        for (n nVar : this.f58087f) {
            if ((nVar instanceof b) && (bVar = (b) nVar) != null && (emotionPackageData2 = bVar.f58090e) != null && emotionPackageData2.id == emotionPackageData.id) {
                emotionPackageData2.download = emotionPackageData.download;
                emotionPackageData2.share = emotionPackageData.share;
                c();
                return;
            }
        }
    }
}
