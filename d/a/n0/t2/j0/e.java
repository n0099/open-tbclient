package d.a.n0.t2.j0;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import d.a.n0.t2.f0.b.f;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public final String f64881a;

    /* renamed from: b  reason: collision with root package name */
    public final View f64882b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.t2.i0.c f64883c;

    /* renamed from: d  reason: collision with root package name */
    public AdvertAppInfo f64884d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.k1.o.h.b f64885e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f64886f;

    public e(View view, String str) {
        this.f64882b = view;
        this.f64881a = str;
    }

    public void a(boolean z) {
    }

    public final <T> T b(int i2) {
        return (T) this.f64882b.findViewById(i2);
    }

    public void c() {
    }

    public void d(f fVar) {
    }

    public void e() {
        this.f64882b.setVisibility(0);
        d.a.n0.t2.i0.c cVar = this.f64883c;
        if (cVar != null) {
            cVar.i(303);
            d.a.n0.t2.i0.e.b().d(this.f64883c);
        }
    }

    public void f() {
        this.f64882b.setVisibility(8);
    }

    public void g(AdvertAppInfo advertAppInfo) {
        this.f64884d = advertAppInfo;
    }

    public void h(d.a.n0.k1.o.c cVar) {
    }

    public void i(d.a.n0.k1.o.h.b bVar) {
        this.f64885e = bVar;
    }

    public void j(TbPageContext<?> tbPageContext) {
        this.f64886f = tbPageContext;
    }

    public void k(d.a.n0.t2.i0.c cVar) {
        this.f64883c = cVar;
    }

    public void l(CountDownTextView.c cVar) {
    }
}
