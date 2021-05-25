package d.a.n0.g2.h;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import d.a.c.j.e.n;
import d.a.m0.t.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.c.j.e.a> f55186a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f55187b;

    /* renamed from: c  reason: collision with root package name */
    public HTypeListView f55188c;

    /* renamed from: d  reason: collision with root package name */
    public c f55189d;

    /* renamed from: e  reason: collision with root package name */
    public b f55190e;

    /* renamed from: f  reason: collision with root package name */
    public a f55191f;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.f55187b = tbPageContext;
        this.f55188c = hTypeListView;
        a();
    }

    public final void a() {
        this.f55189d = new c(this.f55187b, o.f50802h);
        this.f55190e = new b(this.f55187b, d.a.n0.g2.i.c.f55200f);
        this.f55191f = new a(this.f55187b.getPageActivity(), d.a.n0.g2.d.f55164h);
        this.f55186a.add(this.f55189d);
        this.f55186a.add(this.f55190e);
        this.f55186a.add(this.f55191f);
        this.f55188c.a(this.f55186a);
    }

    public void b() {
        HTypeListView hTypeListView = this.f55188c;
        if (hTypeListView == null || !(hTypeListView.getAdapter() instanceof TypeAdapter)) {
            return;
        }
        ((TypeAdapter) this.f55188c.getAdapter()).notifyDataSetChanged();
    }

    public void c(List<n> list) {
        HTypeListView hTypeListView = this.f55188c;
        if (hTypeListView != null) {
            hTypeListView.setData(list);
        }
    }

    public void d(View.OnClickListener onClickListener) {
        this.f55189d.g0(onClickListener);
        this.f55190e.g0(onClickListener);
    }
}
