package d.a.j0.i2.c;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public f f55387a;

    /* renamed from: b  reason: collision with root package name */
    public l f55388b;

    /* renamed from: c  reason: collision with root package name */
    public g f55389c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.j0.f2.h.a f55390d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.c.j.e.a> f55391e = new ArrayList();

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.f55387a = new f(tbPageContext, d.a.j0.i2.e.o.f55546g);
        this.f55388b = new l(tbPageContext);
        this.f55389c = new g(tbPageContext, d.a.j0.i2.e.h.f55523g);
        this.f55390d = new d.a.j0.f2.h.a(tbPageContext.getPageActivity(), d.a.j0.f2.d.f54269h);
        this.f55391e.add(this.f55387a);
        this.f55391e.add(this.f55388b);
        this.f55391e.add(this.f55389c);
        this.f55391e.add(this.f55390d);
        hTypeListView.a(this.f55391e);
    }

    public void a(View.OnClickListener onClickListener) {
        this.f55387a.g0(onClickListener);
    }

    public void b(View.OnClickListener onClickListener) {
        this.f55389c.g0(onClickListener);
    }
}
