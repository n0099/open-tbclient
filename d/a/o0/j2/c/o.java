package d.a.o0.j2.c;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public f f60092a;

    /* renamed from: b  reason: collision with root package name */
    public l f60093b;

    /* renamed from: c  reason: collision with root package name */
    public g f60094c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.o0.g2.h.a f60095d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.c.k.e.a> f60096e = new ArrayList();

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.f60092a = new f(tbPageContext, d.a.o0.j2.e.o.f60251g);
        this.f60093b = new l(tbPageContext);
        this.f60094c = new g(tbPageContext, d.a.o0.j2.e.h.f60228g);
        this.f60095d = new d.a.o0.g2.h.a(tbPageContext.getPageActivity(), d.a.o0.g2.d.f58978h);
        this.f60096e.add(this.f60092a);
        this.f60096e.add(this.f60093b);
        this.f60096e.add(this.f60094c);
        this.f60096e.add(this.f60095d);
        hTypeListView.a(this.f60096e);
    }

    public void a(View.OnClickListener onClickListener) {
        this.f60092a.h0(onClickListener);
    }

    public void b(View.OnClickListener onClickListener) {
        this.f60094c.h0(onClickListener);
    }
}
