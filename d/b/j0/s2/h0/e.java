package d.b.j0.s2.h0;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public final String f62151a;

    /* renamed from: b  reason: collision with root package name */
    public final View f62152b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.j0.s2.f0.c f62153c;

    /* renamed from: d  reason: collision with root package name */
    public AdvertAppInfo f62154d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.j0.j1.o.h.b f62155e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f62156f;

    public e(View view, String str) {
        this.f62152b = view;
        this.f62151a = str;
    }

    public void a(boolean z) {
    }

    public final <T> T b(int i) {
        return (T) this.f62152b.findViewById(i);
    }

    public void c() {
    }

    public void d(d.b.j0.s2.c0.b.e eVar) {
    }

    public void e() {
        this.f62152b.setVisibility(0);
        d.b.j0.s2.f0.c cVar = this.f62153c;
        if (cVar != null) {
            cVar.j(303);
            d.b.j0.s2.f0.e.b().d(this.f62153c);
        }
    }

    public void f() {
        this.f62152b.setVisibility(8);
    }

    public void g(AdvertAppInfo advertAppInfo) {
        this.f62154d = advertAppInfo;
    }

    public void h(d.b.j0.j1.o.c cVar) {
    }

    public void i(d.b.j0.j1.o.h.b bVar) {
        this.f62155e = bVar;
    }

    public void j(TbPageContext<?> tbPageContext) {
        this.f62156f = tbPageContext;
    }

    public void k(d.b.j0.s2.f0.c cVar) {
        this.f62153c = cVar;
    }

    public void l(CountDownTextView.c cVar) {
    }
}
