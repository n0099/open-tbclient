package d.b.i0.h2.c;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public f f55166a;

    /* renamed from: b  reason: collision with root package name */
    public l f55167b;

    /* renamed from: c  reason: collision with root package name */
    public g f55168c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.e2.h.a f55169d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.b.j.e.a> f55170e = new ArrayList();

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.f55166a = new f(tbPageContext, d.b.i0.h2.e.o.f55311g);
        this.f55167b = new l(tbPageContext);
        this.f55168c = new g(tbPageContext, d.b.i0.h2.e.h.f55290g);
        this.f55169d = new d.b.i0.e2.h.a(tbPageContext.getPageActivity(), d.b.i0.e2.d.f54519h);
        this.f55170e.add(this.f55166a);
        this.f55170e.add(this.f55167b);
        this.f55170e.add(this.f55168c);
        this.f55170e.add(this.f55169d);
        hTypeListView.a(this.f55170e);
    }

    public void a(View.OnClickListener onClickListener) {
        this.f55166a.j0(onClickListener);
    }

    public void b(View.OnClickListener onClickListener) {
        this.f55168c.j0(onClickListener);
    }
}
