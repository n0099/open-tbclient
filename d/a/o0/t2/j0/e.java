package d.a.o0.t2.j0;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import d.a.o0.t2.f0.b.f;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public final String f65006a;

    /* renamed from: b  reason: collision with root package name */
    public final View f65007b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.o0.t2.i0.c f65008c;

    /* renamed from: d  reason: collision with root package name */
    public AdvertAppInfo f65009d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.k1.o.h.b f65010e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f65011f;

    public e(View view, String str) {
        this.f65007b = view;
        this.f65006a = str;
    }

    public void a(boolean z) {
    }

    public final <T> T b(int i2) {
        return (T) this.f65007b.findViewById(i2);
    }

    public void c() {
    }

    public void d(f fVar) {
    }

    public void e() {
        this.f65007b.setVisibility(0);
        d.a.o0.t2.i0.c cVar = this.f65008c;
        if (cVar != null) {
            cVar.i(303);
            d.a.o0.t2.i0.e.b().d(this.f65008c);
        }
    }

    public void f() {
        this.f65007b.setVisibility(8);
    }

    public void g(AdvertAppInfo advertAppInfo) {
        this.f65009d = advertAppInfo;
    }

    public void h(d.a.o0.k1.o.c cVar) {
    }

    public void i(d.a.o0.k1.o.h.b bVar) {
        this.f65010e = bVar;
    }

    public void j(TbPageContext<?> tbPageContext) {
        this.f65011f = tbPageContext;
    }

    public void k(d.a.o0.t2.i0.c cVar) {
        this.f65008c = cVar;
    }

    public void l(CountDownTextView.c cVar) {
    }
}
