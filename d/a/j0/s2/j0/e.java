package d.a.j0.s2.j0;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public final String f60352a;

    /* renamed from: b  reason: collision with root package name */
    public final View f60353b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.j0.s2.h0.c f60354c;

    /* renamed from: d  reason: collision with root package name */
    public AdvertAppInfo f60355d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.j1.o.h.b f60356e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f60357f;

    public e(View view, String str) {
        this.f60353b = view;
        this.f60352a = str;
    }

    public void a(boolean z) {
    }

    public final <T> T b(int i2) {
        return (T) this.f60353b.findViewById(i2);
    }

    public void c() {
    }

    public void d(d.a.j0.s2.e0.b.e eVar) {
    }

    public void e() {
        this.f60353b.setVisibility(0);
        d.a.j0.s2.h0.c cVar = this.f60354c;
        if (cVar != null) {
            cVar.j(303);
            d.a.j0.s2.h0.e.b().d(this.f60354c);
        }
    }

    public void f() {
        this.f60353b.setVisibility(8);
    }

    public void g(AdvertAppInfo advertAppInfo) {
        this.f60355d = advertAppInfo;
    }

    public void h(d.a.j0.j1.o.c cVar) {
    }

    public void i(d.a.j0.j1.o.h.b bVar) {
        this.f60356e = bVar;
    }

    public void j(TbPageContext<?> tbPageContext) {
        this.f60357f = tbPageContext;
    }

    public void k(d.a.j0.s2.h0.c cVar) {
        this.f60354c = cVar;
    }

    public void l(CountDownTextView.c cVar) {
    }
}
