package d.a.j0.f2.h;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import d.a.c.j.e.n;
import d.a.i0.t.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.c.j.e.a> f54291a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f54292b;

    /* renamed from: c  reason: collision with root package name */
    public HTypeListView f54293c;

    /* renamed from: d  reason: collision with root package name */
    public c f54294d;

    /* renamed from: e  reason: collision with root package name */
    public b f54295e;

    /* renamed from: f  reason: collision with root package name */
    public a f54296f;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.f54292b = tbPageContext;
        this.f54293c = hTypeListView;
        a();
    }

    public final void a() {
        this.f54294d = new c(this.f54292b, o.f49910h);
        this.f54295e = new b(this.f54292b, d.a.j0.f2.i.c.f54305f);
        this.f54296f = new a(this.f54292b.getPageActivity(), d.a.j0.f2.d.f54269h);
        this.f54291a.add(this.f54294d);
        this.f54291a.add(this.f54295e);
        this.f54291a.add(this.f54296f);
        this.f54293c.a(this.f54291a);
    }

    public void b() {
        HTypeListView hTypeListView = this.f54293c;
        if (hTypeListView == null || !(hTypeListView.getAdapter() instanceof TypeAdapter)) {
            return;
        }
        ((TypeAdapter) this.f54293c.getAdapter()).notifyDataSetChanged();
    }

    public void c(List<n> list) {
        HTypeListView hTypeListView = this.f54293c;
        if (hTypeListView != null) {
            hTypeListView.setData(list);
        }
    }

    public void d(View.OnClickListener onClickListener) {
        this.f54294d.g0(onClickListener);
        this.f54295e.g0(onClickListener);
    }
}
