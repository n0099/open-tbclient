package d.a.o0.g2.h;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import d.a.c.k.e.n;
import d.a.n0.t.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.c.k.e.a> f59000a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f59001b;

    /* renamed from: c  reason: collision with root package name */
    public HTypeListView f59002c;

    /* renamed from: d  reason: collision with root package name */
    public c f59003d;

    /* renamed from: e  reason: collision with root package name */
    public b f59004e;

    /* renamed from: f  reason: collision with root package name */
    public a f59005f;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.f59001b = tbPageContext;
        this.f59002c = hTypeListView;
        a();
    }

    public final void a() {
        this.f59003d = new c(this.f59001b, o.f54586h);
        this.f59004e = new b(this.f59001b, d.a.o0.g2.i.c.f59014f);
        this.f59005f = new a(this.f59001b.getPageActivity(), d.a.o0.g2.d.f58978h);
        this.f59000a.add(this.f59003d);
        this.f59000a.add(this.f59004e);
        this.f59000a.add(this.f59005f);
        this.f59002c.a(this.f59000a);
    }

    public void b() {
        HTypeListView hTypeListView = this.f59002c;
        if (hTypeListView == null || !(hTypeListView.getAdapter() instanceof TypeAdapter)) {
            return;
        }
        ((TypeAdapter) this.f59002c.getAdapter()).notifyDataSetChanged();
    }

    public void c(List<n> list) {
        HTypeListView hTypeListView = this.f59002c;
        if (hTypeListView != null) {
            hTypeListView.setData(list);
        }
    }

    public void d(View.OnClickListener onClickListener) {
        this.f59003d.h0(onClickListener);
        this.f59004e.h0(onClickListener);
    }
}
