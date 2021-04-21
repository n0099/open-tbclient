package d.b.j0.i2.c;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public f f57446a;

    /* renamed from: b  reason: collision with root package name */
    public l f57447b;

    /* renamed from: c  reason: collision with root package name */
    public g f57448c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.j0.f2.h.a f57449d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.c.j.e.a> f57450e = new ArrayList();

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.f57446a = new f(tbPageContext, d.b.j0.i2.e.o.f57591g);
        this.f57447b = new l(tbPageContext);
        this.f57448c = new g(tbPageContext, d.b.j0.i2.e.h.f57570g);
        this.f57449d = new d.b.j0.f2.h.a(tbPageContext.getPageActivity(), d.b.j0.f2.d.f56382h);
        this.f57450e.add(this.f57446a);
        this.f57450e.add(this.f57447b);
        this.f57450e.add(this.f57448c);
        this.f57450e.add(this.f57449d);
        hTypeListView.a(this.f57450e);
    }

    public void a(View.OnClickListener onClickListener) {
        this.f57446a.j0(onClickListener);
    }

    public void b(View.OnClickListener onClickListener) {
        this.f57448c.j0(onClickListener);
    }
}
