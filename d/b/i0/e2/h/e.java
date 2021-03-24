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
    public List<d.b.b.j.e.a> f54540a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f54541b;

    /* renamed from: c  reason: collision with root package name */
    public HTypeListView f54542c;

    /* renamed from: d  reason: collision with root package name */
    public c f54543d;

    /* renamed from: e  reason: collision with root package name */
    public b f54544e;

    /* renamed from: f  reason: collision with root package name */
    public a f54545f;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.f54541b = tbPageContext;
        this.f54542c = hTypeListView;
        a();
    }

    public final void a() {
        this.f54543d = new c(this.f54541b, n.f51486h);
        this.f54544e = new b(this.f54541b, d.b.i0.e2.i.c.f54554f);
        this.f54545f = new a(this.f54541b.getPageActivity(), d.b.i0.e2.d.f54519h);
        this.f54540a.add(this.f54543d);
        this.f54540a.add(this.f54544e);
        this.f54540a.add(this.f54545f);
        this.f54542c.a(this.f54540a);
    }

    public void b() {
        HTypeListView hTypeListView = this.f54542c;
        if (hTypeListView == null || !(hTypeListView.getAdapter() instanceof TypeAdapter)) {
            return;
        }
        ((TypeAdapter) this.f54542c.getAdapter()).notifyDataSetChanged();
    }

    public void c(List<d.b.b.j.e.n> list) {
        HTypeListView hTypeListView = this.f54542c;
        if (hTypeListView != null) {
            hTypeListView.setData(list);
        }
    }

    public void d(View.OnClickListener onClickListener) {
        this.f54543d.j0(onClickListener);
        this.f54544e.j0(onClickListener);
    }
}
