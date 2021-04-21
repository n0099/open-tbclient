package d.b.j0.f2.h;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import d.b.c.j.e.n;
import d.b.i0.t.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public List<d.b.c.j.e.a> f56403a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f56404b;

    /* renamed from: c  reason: collision with root package name */
    public HTypeListView f56405c;

    /* renamed from: d  reason: collision with root package name */
    public c f56406d;

    /* renamed from: e  reason: collision with root package name */
    public b f56407e;

    /* renamed from: f  reason: collision with root package name */
    public a f56408f;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.f56404b = tbPageContext;
        this.f56405c = hTypeListView;
        a();
    }

    public final void a() {
        this.f56406d = new c(this.f56404b, o.f52241h);
        this.f56407e = new b(this.f56404b, d.b.j0.f2.i.c.f56417f);
        this.f56408f = new a(this.f56404b.getPageActivity(), d.b.j0.f2.d.f56382h);
        this.f56403a.add(this.f56406d);
        this.f56403a.add(this.f56407e);
        this.f56403a.add(this.f56408f);
        this.f56405c.a(this.f56403a);
    }

    public void b() {
        HTypeListView hTypeListView = this.f56405c;
        if (hTypeListView == null || !(hTypeListView.getAdapter() instanceof TypeAdapter)) {
            return;
        }
        ((TypeAdapter) this.f56405c.getAdapter()).notifyDataSetChanged();
    }

    public void c(List<n> list) {
        HTypeListView hTypeListView = this.f56405c;
        if (hTypeListView != null) {
            hTypeListView.setData(list);
        }
    }

    public void d(View.OnClickListener onClickListener) {
        this.f56406d.j0(onClickListener);
        this.f56407e.j0(onClickListener);
    }
}
