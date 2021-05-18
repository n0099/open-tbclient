package d.a.k0.s2.j0;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import d.a.k0.s2.f0.b.f;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public final String f61087a;

    /* renamed from: b  reason: collision with root package name */
    public final View f61088b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.k0.s2.i0.c f61089c;

    /* renamed from: d  reason: collision with root package name */
    public AdvertAppInfo f61090d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.k0.j1.o.h.b f61091e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f61092f;

    public e(View view, String str) {
        this.f61088b = view;
        this.f61087a = str;
    }

    public void a(boolean z) {
    }

    public final <T> T b(int i2) {
        return (T) this.f61088b.findViewById(i2);
    }

    public void c() {
    }

    public void d(f fVar) {
    }

    public void e() {
        this.f61088b.setVisibility(0);
        d.a.k0.s2.i0.c cVar = this.f61089c;
        if (cVar != null) {
            cVar.i(303);
            d.a.k0.s2.i0.e.b().d(this.f61089c);
        }
    }

    public void f() {
        this.f61088b.setVisibility(8);
    }

    public void g(AdvertAppInfo advertAppInfo) {
        this.f61090d = advertAppInfo;
    }

    public void h(d.a.k0.j1.o.c cVar) {
    }

    public void i(d.a.k0.j1.o.h.b bVar) {
        this.f61091e = bVar;
    }

    public void j(TbPageContext<?> tbPageContext) {
        this.f61092f = tbPageContext;
    }

    public void k(d.a.k0.s2.i0.c cVar) {
        this.f61089c = cVar;
    }

    public void l(CountDownTextView.c cVar) {
    }
}
