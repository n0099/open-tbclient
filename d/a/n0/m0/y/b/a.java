package d.a.n0.m0.y.b;

import android.widget.BaseAdapter;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.emotioncenter.adapter.EmotionCategoryAdapter;
import com.baidu.tieba.faceshop.emotioncenter.adapter.EmotionHorizontalAdapter;
import d.a.c.a.f;
import d.a.c.k.e.n;
import d.a.n0.m0.y.c.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public f f61095a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f61096b;

    /* renamed from: d  reason: collision with root package name */
    public EmotionCategoryAdapter f61098d;

    /* renamed from: e  reason: collision with root package name */
    public EmotionHorizontalAdapter f61099e;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.a.c.k.e.a> f61097c = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public List<n> f61100f = new ArrayList();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f61095a = tbPageContext;
        this.f61096b = bdTypeListView;
        b();
    }

    public void a(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (this.f61096b != null) {
            this.f61100f.addAll(list);
            this.f61096b.setData(this.f61100f);
        }
        c();
    }

    public final void b() {
        this.f61098d = new EmotionCategoryAdapter((TbPageContext) this.f61095a, d.a.n0.m0.y.c.a.f61101e);
        this.f61099e = new EmotionHorizontalAdapter((TbPageContext) this.f61095a, b.f61102f);
        this.f61097c.add(this.f61098d);
        this.f61097c.add(this.f61099e);
        this.f61096b.a(this.f61097c);
    }

    public void c() {
        BdTypeListView bdTypeListView = this.f61096b;
        if (bdTypeListView == null || bdTypeListView.getAdapter2() == null || !(this.f61096b.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f61096b.getAdapter2().notifyDataSetChanged();
    }

    public void d(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f61100f)) {
            this.f61100f.clear();
        }
        BdTypeListView bdTypeListView = this.f61096b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
            this.f61100f.addAll(list);
        }
        c();
    }

    public void e(EmotionPackageData emotionPackageData) {
        b bVar;
        EmotionPackageData emotionPackageData2;
        if (emotionPackageData == null || ListUtils.isEmpty(this.f61100f)) {
            return;
        }
        for (n nVar : this.f61100f) {
            if ((nVar instanceof b) && (bVar = (b) nVar) != null && (emotionPackageData2 = bVar.f61103e) != null && emotionPackageData2.id == emotionPackageData.id) {
                emotionPackageData2.download = emotionPackageData.download;
                emotionPackageData2.share = emotionPackageData.share;
                c();
                return;
            }
        }
    }
}
