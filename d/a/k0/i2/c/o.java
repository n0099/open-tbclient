package d.a.k0.i2.c;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public f f56094a;

    /* renamed from: b  reason: collision with root package name */
    public l f56095b;

    /* renamed from: c  reason: collision with root package name */
    public g f56096c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.k0.f2.h.a f56097d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.c.j.e.a> f56098e = new ArrayList();

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.f56094a = new f(tbPageContext, d.a.k0.i2.e.o.f56253g);
        this.f56095b = new l(tbPageContext);
        this.f56096c = new g(tbPageContext, d.a.k0.i2.e.h.f56230g);
        this.f56097d = new d.a.k0.f2.h.a(tbPageContext.getPageActivity(), d.a.k0.f2.d.f54976h);
        this.f56098e.add(this.f56094a);
        this.f56098e.add(this.f56095b);
        this.f56098e.add(this.f56096c);
        this.f56098e.add(this.f56097d);
        hTypeListView.a(this.f56098e);
    }

    public void a(View.OnClickListener onClickListener) {
        this.f56094a.g0(onClickListener);
    }

    public void b(View.OnClickListener onClickListener) {
        this.f56096c.g0(onClickListener);
    }
}
