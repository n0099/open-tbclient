package d.b.i0.s2.h0;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public final String f61730a;

    /* renamed from: b  reason: collision with root package name */
    public final View f61731b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.s2.f0.c f61732c;

    /* renamed from: d  reason: collision with root package name */
    public AdvertAppInfo f61733d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.j1.o.h.b f61734e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f61735f;

    public e(View view, String str) {
        this.f61731b = view;
        this.f61730a = str;
    }

    public void a(boolean z) {
    }

    public final <T> T b(int i) {
        return (T) this.f61731b.findViewById(i);
    }

    public void c() {
    }

    public void d(d.b.i0.s2.c0.b.e eVar) {
    }

    public void e() {
        this.f61731b.setVisibility(0);
        d.b.i0.s2.f0.c cVar = this.f61732c;
        if (cVar != null) {
            cVar.j(303);
            d.b.i0.s2.f0.e.b().d(this.f61732c);
        }
    }

    public void f() {
        this.f61731b.setVisibility(8);
    }

    public void g(AdvertAppInfo advertAppInfo) {
        this.f61733d = advertAppInfo;
    }

    public void h(d.b.i0.j1.o.c cVar) {
    }

    public void i(d.b.i0.j1.o.h.b bVar) {
        this.f61734e = bVar;
    }

    public void j(TbPageContext<?> tbPageContext) {
        this.f61735f = tbPageContext;
    }

    public void k(d.b.i0.s2.f0.c cVar) {
        this.f61732c = cVar;
    }

    public void l(CountDownTextView.c cVar) {
    }
}
