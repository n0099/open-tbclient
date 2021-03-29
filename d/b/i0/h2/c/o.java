package d.b.i0.h2.c;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public f f55167a;

    /* renamed from: b  reason: collision with root package name */
    public l f55168b;

    /* renamed from: c  reason: collision with root package name */
    public g f55169c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.e2.h.a f55170d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.b.j.e.a> f55171e = new ArrayList();

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.f55167a = new f(tbPageContext, d.b.i0.h2.e.o.f55312g);
        this.f55168b = new l(tbPageContext);
        this.f55169c = new g(tbPageContext, d.b.i0.h2.e.h.f55291g);
        this.f55170d = new d.b.i0.e2.h.a(tbPageContext.getPageActivity(), d.b.i0.e2.d.f54520h);
        this.f55171e.add(this.f55167a);
        this.f55171e.add(this.f55168b);
        this.f55171e.add(this.f55169c);
        this.f55171e.add(this.f55170d);
        hTypeListView.a(this.f55171e);
    }

    public void a(View.OnClickListener onClickListener) {
        this.f55167a.j0(onClickListener);
    }

    public void b(View.OnClickListener onClickListener) {
        this.f55169c.j0(onClickListener);
    }
}
