package d.a.n0.t2.j0;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import d.a.n0.t2.f0.b.f;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public final String f61189a;

    /* renamed from: b  reason: collision with root package name */
    public final View f61190b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.t2.i0.c f61191c;

    /* renamed from: d  reason: collision with root package name */
    public AdvertAppInfo f61192d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.k1.o.h.b f61193e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f61194f;

    public e(View view, String str) {
        this.f61190b = view;
        this.f61189a = str;
    }

    public void a(boolean z) {
    }

    public final <T> T b(int i2) {
        return (T) this.f61190b.findViewById(i2);
    }

    public void c() {
    }

    public void d(f fVar) {
    }

    public void e() {
        this.f61190b.setVisibility(0);
        d.a.n0.t2.i0.c cVar = this.f61191c;
        if (cVar != null) {
            cVar.i(303);
            d.a.n0.t2.i0.e.b().d(this.f61191c);
        }
    }

    public void f() {
        this.f61190b.setVisibility(8);
    }

    public void g(AdvertAppInfo advertAppInfo) {
        this.f61192d = advertAppInfo;
    }

    public void h(d.a.n0.k1.o.c cVar) {
    }

    public void i(d.a.n0.k1.o.h.b bVar) {
        this.f61193e = bVar;
    }

    public void j(TbPageContext<?> tbPageContext) {
        this.f61194f = tbPageContext;
    }

    public void k(d.a.n0.t2.i0.c cVar) {
        this.f61191c = cVar;
    }

    public void l(CountDownTextView.c cVar) {
    }
}
