package d.a.n0.t2.f0.d.a;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import d.a.n0.k1.o.l.e;
/* loaded from: classes5.dex */
public abstract class a implements e<AdCard> {

    /* renamed from: e  reason: collision with root package name */
    public AdCard f64778e;

    /* renamed from: f  reason: collision with root package name */
    public AdvertAppInfo f64779f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f64780g;

    /* renamed from: h  reason: collision with root package name */
    public Context f64781h;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext f64782i;
    public d.a.n0.k1.o.a j;

    public a(TbPageContext tbPageContext) {
        this.f64782i = tbPageContext;
        this.f64781h = tbPageContext.getPageActivity();
    }

    @Override // d.a.n0.k1.o.l.e
    public void c(BdUniqueId bdUniqueId) {
    }

    public abstract void d();

    public void e(AdCard adCard) {
        this.f64778e = adCard;
        this.f64779f = adCard.getAdvertAppInfo();
    }

    @Override // d.a.n0.k1.o.l.e
    public void f() {
    }

    @Override // d.a.n0.k1.o.l.e
    public void h() {
    }

    @Override // d.a.n0.k1.o.l.e
    public void i(Object obj) {
        if (obj instanceof AdCard) {
            this.f64778e = (AdCard) obj;
            d();
            e(this.f64778e);
        }
    }

    @Override // d.a.n0.k1.o.l.e
    public void j() {
    }

    @Override // d.a.n0.k1.o.l.e
    public void k() {
    }

    @Override // d.a.n0.k1.o.l.e
    public void setAfterClickSchemeListener(d.a.n0.k1.o.a aVar) {
        this.j = aVar;
    }

    @Override // d.a.n0.k1.o.l.e
    public void setBusinessType(int i2) {
    }

    @Override // d.a.n0.k1.o.l.e
    public void setDownloadAppCallback(d.a.n0.k1.o.c cVar) {
    }

    @Override // d.a.n0.k1.o.l.e
    public void setFromCDN(boolean z) {
        this.f64780g = z;
    }

    @Override // d.a.n0.k1.o.l.e
    public void setPosition(int i2) {
    }
}
