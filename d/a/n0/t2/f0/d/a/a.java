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
    public AdCard f61086e;

    /* renamed from: f  reason: collision with root package name */
    public AdvertAppInfo f61087f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f61088g;

    /* renamed from: h  reason: collision with root package name */
    public Context f61089h;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext f61090i;
    public d.a.n0.k1.o.a j;

    public a(TbPageContext tbPageContext) {
        this.f61090i = tbPageContext;
        this.f61089h = tbPageContext.getPageActivity();
    }

    public abstract void c();

    public void d(AdCard adCard) {
        this.f61086e = adCard;
        this.f61087f = adCard.getAdvertAppInfo();
    }

    @Override // d.a.n0.k1.o.l.e
    public void e() {
    }

    @Override // d.a.n0.k1.o.l.e
    public void f() {
    }

    @Override // d.a.n0.k1.o.l.e
    public void g(Object obj) {
        if (obj instanceof AdCard) {
            this.f61086e = (AdCard) obj;
            c();
            d(this.f61086e);
        }
    }

    @Override // d.a.n0.k1.o.l.e
    public void h() {
    }

    @Override // d.a.n0.k1.o.l.e
    public void i() {
    }

    @Override // d.a.n0.k1.o.l.e
    public void k(BdUniqueId bdUniqueId) {
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
        this.f61088g = z;
    }

    @Override // d.a.n0.k1.o.l.e
    public void setPosition(int i2) {
    }
}
