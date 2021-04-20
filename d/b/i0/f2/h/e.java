package d.b.i0.f2.h;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import d.b.c.j.e.n;
import d.b.h0.t.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public List<d.b.c.j.e.a> f55982a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f55983b;

    /* renamed from: c  reason: collision with root package name */
    public HTypeListView f55984c;

    /* renamed from: d  reason: collision with root package name */
    public c f55985d;

    /* renamed from: e  reason: collision with root package name */
    public b f55986e;

    /* renamed from: f  reason: collision with root package name */
    public a f55987f;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.f55983b = tbPageContext;
        this.f55984c = hTypeListView;
        a();
    }

    public final void a() {
        this.f55985d = new c(this.f55983b, o.f51905h);
        this.f55986e = new b(this.f55983b, d.b.i0.f2.i.c.f55996f);
        this.f55987f = new a(this.f55983b.getPageActivity(), d.b.i0.f2.d.f55961h);
        this.f55982a.add(this.f55985d);
        this.f55982a.add(this.f55986e);
        this.f55982a.add(this.f55987f);
        this.f55984c.a(this.f55982a);
    }

    public void b() {
        HTypeListView hTypeListView = this.f55984c;
        if (hTypeListView == null || !(hTypeListView.getAdapter() instanceof TypeAdapter)) {
            return;
        }
        ((TypeAdapter) this.f55984c.getAdapter()).notifyDataSetChanged();
    }

    public void c(List<n> list) {
        HTypeListView hTypeListView = this.f55984c;
        if (hTypeListView != null) {
            hTypeListView.setData(list);
        }
    }

    public void d(View.OnClickListener onClickListener) {
        this.f55985d.j0(onClickListener);
        this.f55986e.j0(onClickListener);
    }
}
