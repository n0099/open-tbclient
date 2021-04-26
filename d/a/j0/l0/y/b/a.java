package d.a.j0.l0.y.b;

import android.widget.BaseAdapter;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.emotioncenter.adapter.EmotionCategoryAdapter;
import com.baidu.tieba.faceshop.emotioncenter.adapter.EmotionHorizontalAdapter;
import d.a.c.a.f;
import d.a.c.j.e.n;
import d.a.j0.l0.y.c.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public f f56509a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f56510b;

    /* renamed from: d  reason: collision with root package name */
    public EmotionCategoryAdapter f56512d;

    /* renamed from: e  reason: collision with root package name */
    public EmotionHorizontalAdapter f56513e;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.a.c.j.e.a> f56511c = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public List<n> f56514f = new ArrayList();

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f56509a = tbPageContext;
        this.f56510b = bdTypeListView;
        b();
    }

    public void a(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (this.f56510b != null) {
            this.f56514f.addAll(list);
            this.f56510b.setData(this.f56514f);
        }
        c();
    }

    public final void b() {
        this.f56512d = new EmotionCategoryAdapter((TbPageContext) this.f56509a, d.a.j0.l0.y.c.a.f56515e);
        this.f56513e = new EmotionHorizontalAdapter((TbPageContext) this.f56509a, b.f56516f);
        this.f56511c.add(this.f56512d);
        this.f56511c.add(this.f56513e);
        this.f56510b.a(this.f56511c);
    }

    public void c() {
        BdTypeListView bdTypeListView = this.f56510b;
        if (bdTypeListView == null || bdTypeListView.getAdapter2() == null || !(this.f56510b.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f56510b.getAdapter2().notifyDataSetChanged();
    }

    public void d(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f56514f)) {
            this.f56514f.clear();
        }
        BdTypeListView bdTypeListView = this.f56510b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
            this.f56514f.addAll(list);
        }
        c();
    }

    public void e(EmotionPackageData emotionPackageData) {
        b bVar;
        EmotionPackageData emotionPackageData2;
        if (emotionPackageData == null || ListUtils.isEmpty(this.f56514f)) {
            return;
        }
        for (n nVar : this.f56514f) {
            if ((nVar instanceof b) && (bVar = (b) nVar) != null && (emotionPackageData2 = bVar.f56517e) != null && emotionPackageData2.id == emotionPackageData.id) {
                emotionPackageData2.download = emotionPackageData.download;
                emotionPackageData2.share = emotionPackageData.share;
                c();
                return;
            }
        }
    }
}
