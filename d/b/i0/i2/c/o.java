package d.b.i0.i2.c;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public f f57025a;

    /* renamed from: b  reason: collision with root package name */
    public l f57026b;

    /* renamed from: c  reason: collision with root package name */
    public g f57027c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.f2.h.a f57028d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.c.j.e.a> f57029e = new ArrayList();

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.f57025a = new f(tbPageContext, d.b.i0.i2.e.o.f57170g);
        this.f57026b = new l(tbPageContext);
        this.f57027c = new g(tbPageContext, d.b.i0.i2.e.h.f57149g);
        this.f57028d = new d.b.i0.f2.h.a(tbPageContext.getPageActivity(), d.b.i0.f2.d.f55961h);
        this.f57029e.add(this.f57025a);
        this.f57029e.add(this.f57026b);
        this.f57029e.add(this.f57027c);
        this.f57029e.add(this.f57028d);
        hTypeListView.a(this.f57029e);
    }

    public void a(View.OnClickListener onClickListener) {
        this.f57025a.j0(onClickListener);
    }

    public void b(View.OnClickListener onClickListener) {
        this.f57027c.j0(onClickListener);
    }
}
