package d.b.i0.s2.c0.d.a;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import d.b.i0.j1.o.l.e;
/* loaded from: classes4.dex */
public abstract class a implements e<AdCard> {

    /* renamed from: e  reason: collision with root package name */
    public AdCard f61604e;

    /* renamed from: f  reason: collision with root package name */
    public AdvertAppInfo f61605f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f61606g;

    /* renamed from: h  reason: collision with root package name */
    public Context f61607h;
    public TbPageContext i;
    public d.b.i0.j1.o.a j;

    public a(TbPageContext tbPageContext) {
        this.i = tbPageContext;
        this.f61607h = tbPageContext.getPageActivity();
    }

    @Override // d.b.i0.j1.o.l.e
    public void c(Object obj) {
        if (obj instanceof AdCard) {
            this.f61604e = (AdCard) obj;
            d();
            g(this.f61604e);
        }
    }

    public abstract void d();

    @Override // d.b.i0.j1.o.l.e
    public void e() {
    }

    @Override // d.b.i0.j1.o.l.e
    public void f() {
    }

    public void g(AdCard adCard) {
        this.f61604e = adCard;
        this.f61605f = adCard.getAdvertAppInfo();
    }

    @Override // d.b.i0.j1.o.l.e
    public void h() {
    }

    @Override // d.b.i0.j1.o.l.e
    public void k() {
    }

    @Override // d.b.i0.j1.o.l.e
    public void l(BdUniqueId bdUniqueId) {
    }

    @Override // d.b.i0.j1.o.l.e
    public void setAfterClickSchemeListener(d.b.i0.j1.o.a aVar) {
        this.j = aVar;
    }

    @Override // d.b.i0.j1.o.l.e
    public void setBusinessType(int i) {
    }

    @Override // d.b.i0.j1.o.l.e
    public void setDownloadAppCallback(d.b.i0.j1.o.c cVar) {
    }

    @Override // d.b.i0.j1.o.l.e
    public void setFromCDN(boolean z) {
        this.f61606g = z;
    }

    @Override // d.b.i0.j1.o.l.e
    public void setPosition(int i) {
    }
}
