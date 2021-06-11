package d.a.n0.g2.h;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import d.a.c.k.e.n;
import d.a.m0.t.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.c.k.e.a> f58875a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f58876b;

    /* renamed from: c  reason: collision with root package name */
    public HTypeListView f58877c;

    /* renamed from: d  reason: collision with root package name */
    public c f58878d;

    /* renamed from: e  reason: collision with root package name */
    public b f58879e;

    /* renamed from: f  reason: collision with root package name */
    public a f58880f;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.f58876b = tbPageContext;
        this.f58877c = hTypeListView;
        a();
    }

    public final void a() {
        this.f58878d = new c(this.f58876b, o.f54479h);
        this.f58879e = new b(this.f58876b, d.a.n0.g2.i.c.f58889f);
        this.f58880f = new a(this.f58876b.getPageActivity(), d.a.n0.g2.d.f58853h);
        this.f58875a.add(this.f58878d);
        this.f58875a.add(this.f58879e);
        this.f58875a.add(this.f58880f);
        this.f58877c.a(this.f58875a);
    }

    public void b() {
        HTypeListView hTypeListView = this.f58877c;
        if (hTypeListView == null || !(hTypeListView.getAdapter() instanceof TypeAdapter)) {
            return;
        }
        ((TypeAdapter) this.f58877c.getAdapter()).notifyDataSetChanged();
    }

    public void c(List<n> list) {
        HTypeListView hTypeListView = this.f58877c;
        if (hTypeListView != null) {
            hTypeListView.setData(list);
        }
    }

    public void d(View.OnClickListener onClickListener) {
        this.f58878d.h0(onClickListener);
        this.f58879e.h0(onClickListener);
    }
}
