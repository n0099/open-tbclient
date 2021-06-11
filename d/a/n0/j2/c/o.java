package d.a.n0.j2.c;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public f f59967a;

    /* renamed from: b  reason: collision with root package name */
    public l f59968b;

    /* renamed from: c  reason: collision with root package name */
    public g f59969c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.g2.h.a f59970d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.c.k.e.a> f59971e = new ArrayList();

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.f59967a = new f(tbPageContext, d.a.n0.j2.e.o.f60126g);
        this.f59968b = new l(tbPageContext);
        this.f59969c = new g(tbPageContext, d.a.n0.j2.e.h.f60103g);
        this.f59970d = new d.a.n0.g2.h.a(tbPageContext.getPageActivity(), d.a.n0.g2.d.f58853h);
        this.f59971e.add(this.f59967a);
        this.f59971e.add(this.f59968b);
        this.f59971e.add(this.f59969c);
        this.f59971e.add(this.f59970d);
        hTypeListView.a(this.f59971e);
    }

    public void a(View.OnClickListener onClickListener) {
        this.f59967a.h0(onClickListener);
    }

    public void b(View.OnClickListener onClickListener) {
        this.f59969c.h0(onClickListener);
    }
}
