package d.a.k0.f2.h;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import d.a.c.j.e.n;
import d.a.j0.t.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.c.j.e.a> f54998a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f54999b;

    /* renamed from: c  reason: collision with root package name */
    public HTypeListView f55000c;

    /* renamed from: d  reason: collision with root package name */
    public c f55001d;

    /* renamed from: e  reason: collision with root package name */
    public b f55002e;

    /* renamed from: f  reason: collision with root package name */
    public a f55003f;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.f54999b = tbPageContext;
        this.f55000c = hTypeListView;
        a();
    }

    public final void a() {
        this.f55001d = new c(this.f54999b, o.f50729h);
        this.f55002e = new b(this.f54999b, d.a.k0.f2.i.c.f55012f);
        this.f55003f = new a(this.f54999b.getPageActivity(), d.a.k0.f2.d.f54976h);
        this.f54998a.add(this.f55001d);
        this.f54998a.add(this.f55002e);
        this.f54998a.add(this.f55003f);
        this.f55000c.a(this.f54998a);
    }

    public void b() {
        HTypeListView hTypeListView = this.f55000c;
        if (hTypeListView == null || !(hTypeListView.getAdapter() instanceof TypeAdapter)) {
            return;
        }
        ((TypeAdapter) this.f55000c.getAdapter()).notifyDataSetChanged();
    }

    public void c(List<n> list) {
        HTypeListView hTypeListView = this.f55000c;
        if (hTypeListView != null) {
            hTypeListView.setData(list);
        }
    }

    public void d(View.OnClickListener onClickListener) {
        this.f55001d.g0(onClickListener);
        this.f55002e.g0(onClickListener);
    }
}
