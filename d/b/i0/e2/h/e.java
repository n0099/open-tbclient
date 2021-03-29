package d.b.i0.e2.h;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import d.b.h0.t.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public List<d.b.b.j.e.a> f54541a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f54542b;

    /* renamed from: c  reason: collision with root package name */
    public HTypeListView f54543c;

    /* renamed from: d  reason: collision with root package name */
    public c f54544d;

    /* renamed from: e  reason: collision with root package name */
    public b f54545e;

    /* renamed from: f  reason: collision with root package name */
    public a f54546f;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.f54542b = tbPageContext;
        this.f54543c = hTypeListView;
        a();
    }

    public final void a() {
        this.f54544d = new c(this.f54542b, n.f51487h);
        this.f54545e = new b(this.f54542b, d.b.i0.e2.i.c.f54555f);
        this.f54546f = new a(this.f54542b.getPageActivity(), d.b.i0.e2.d.f54520h);
        this.f54541a.add(this.f54544d);
        this.f54541a.add(this.f54545e);
        this.f54541a.add(this.f54546f);
        this.f54543c.a(this.f54541a);
    }

    public void b() {
        HTypeListView hTypeListView = this.f54543c;
        if (hTypeListView == null || !(hTypeListView.getAdapter() instanceof TypeAdapter)) {
            return;
        }
        ((TypeAdapter) this.f54543c.getAdapter()).notifyDataSetChanged();
    }

    public void c(List<d.b.b.j.e.n> list) {
        HTypeListView hTypeListView = this.f54543c;
        if (hTypeListView != null) {
            hTypeListView.setData(list);
        }
    }

    public void d(View.OnClickListener onClickListener) {
        this.f54544d.j0(onClickListener);
        this.f54545e.j0(onClickListener);
    }
}
