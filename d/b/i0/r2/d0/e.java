package d.b.i0.r2.d0;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public final String f59828a;

    /* renamed from: b  reason: collision with root package name */
    public final View f59829b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.r2.b0.c f59830c;

    /* renamed from: d  reason: collision with root package name */
    public AdvertAppInfo f59831d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.i1.o.h.b f59832e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f59833f;

    public e(View view, String str) {
        this.f59829b = view;
        this.f59828a = str;
    }

    public void a(boolean z) {
    }

    public final <T> T b(int i) {
        return (T) this.f59829b.findViewById(i);
    }

    public void c() {
    }

    public void d(AdCard.g gVar) {
    }

    public void e() {
        this.f59829b.setVisibility(0);
        d.b.i0.r2.b0.c cVar = this.f59830c;
        if (cVar != null) {
            cVar.j(303);
            d.b.i0.r2.b0.e.b().d(this.f59830c);
        }
    }

    public void f() {
        this.f59829b.setVisibility(8);
    }

    public void g(AdvertAppInfo advertAppInfo) {
        this.f59831d = advertAppInfo;
    }

    public void h(d.b.i0.i1.o.c cVar) {
    }

    public void i(d.b.i0.i1.o.h.b bVar) {
        this.f59832e = bVar;
    }

    public void j(TbPageContext<?> tbPageContext) {
        this.f59833f = tbPageContext;
    }

    public void k(d.b.i0.r2.b0.c cVar) {
        this.f59830c = cVar;
    }

    public void l(CountDownTextView.c cVar) {
    }
}
