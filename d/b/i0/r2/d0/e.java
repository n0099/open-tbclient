package d.b.i0.r2.d0;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public final String f59829a;

    /* renamed from: b  reason: collision with root package name */
    public final View f59830b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.r2.b0.c f59831c;

    /* renamed from: d  reason: collision with root package name */
    public AdvertAppInfo f59832d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.i1.o.h.b f59833e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f59834f;

    public e(View view, String str) {
        this.f59830b = view;
        this.f59829a = str;
    }

    public void a(boolean z) {
    }

    public final <T> T b(int i) {
        return (T) this.f59830b.findViewById(i);
    }

    public void c() {
    }

    public void d(AdCard.g gVar) {
    }

    public void e() {
        this.f59830b.setVisibility(0);
        d.b.i0.r2.b0.c cVar = this.f59831c;
        if (cVar != null) {
            cVar.j(303);
            d.b.i0.r2.b0.e.b().d(this.f59831c);
        }
    }

    public void f() {
        this.f59830b.setVisibility(8);
    }

    public void g(AdvertAppInfo advertAppInfo) {
        this.f59832d = advertAppInfo;
    }

    public void h(d.b.i0.i1.o.c cVar) {
    }

    public void i(d.b.i0.i1.o.h.b bVar) {
        this.f59833e = bVar;
    }

    public void j(TbPageContext<?> tbPageContext) {
        this.f59834f = tbPageContext;
    }

    public void k(d.b.i0.r2.b0.c cVar) {
        this.f59831c = cVar;
    }

    public void l(CountDownTextView.c cVar) {
    }
}
