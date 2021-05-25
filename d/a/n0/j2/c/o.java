package d.a.n0.j2.c;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public f f56278a;

    /* renamed from: b  reason: collision with root package name */
    public l f56279b;

    /* renamed from: c  reason: collision with root package name */
    public g f56280c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.g2.h.a f56281d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.c.j.e.a> f56282e = new ArrayList();

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.f56278a = new f(tbPageContext, d.a.n0.j2.e.o.f56437g);
        this.f56279b = new l(tbPageContext);
        this.f56280c = new g(tbPageContext, d.a.n0.j2.e.h.f56414g);
        this.f56281d = new d.a.n0.g2.h.a(tbPageContext.getPageActivity(), d.a.n0.g2.d.f55164h);
        this.f56282e.add(this.f56278a);
        this.f56282e.add(this.f56279b);
        this.f56282e.add(this.f56280c);
        this.f56282e.add(this.f56281d);
        hTypeListView.a(this.f56282e);
    }

    public void a(View.OnClickListener onClickListener) {
        this.f56278a.g0(onClickListener);
    }

    public void b(View.OnClickListener onClickListener) {
        this.f56280c.g0(onClickListener);
    }
}
