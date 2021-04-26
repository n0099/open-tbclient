package d.a.j0.s2.e0.d.a;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import d.a.j0.j1.o.l.e;
/* loaded from: classes5.dex */
public abstract class a implements e<AdCard> {

    /* renamed from: e  reason: collision with root package name */
    public AdCard f60239e;

    /* renamed from: f  reason: collision with root package name */
    public AdvertAppInfo f60240f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f60241g;

    /* renamed from: h  reason: collision with root package name */
    public Context f60242h;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext f60243i;
    public d.a.j0.j1.o.a j;

    public a(TbPageContext tbPageContext) {
        this.f60243i = tbPageContext;
        this.f60242h = tbPageContext.getPageActivity();
    }

    public abstract void c();

    public void d(AdCard adCard) {
        this.f60239e = adCard;
        this.f60240f = adCard.getAdvertAppInfo();
    }

    @Override // d.a.j0.j1.o.l.e
    public void e() {
    }

    @Override // d.a.j0.j1.o.l.e
    public void f() {
    }

    @Override // d.a.j0.j1.o.l.e
    public void g(Object obj) {
        if (obj instanceof AdCard) {
            this.f60239e = (AdCard) obj;
            c();
            d(this.f60239e);
        }
    }

    @Override // d.a.j0.j1.o.l.e
    public void h() {
    }

    @Override // d.a.j0.j1.o.l.e
    public void i() {
    }

    @Override // d.a.j0.j1.o.l.e
    public void k(BdUniqueId bdUniqueId) {
    }

    @Override // d.a.j0.j1.o.l.e
    public void setAfterClickSchemeListener(d.a.j0.j1.o.a aVar) {
        this.j = aVar;
    }

    @Override // d.a.j0.j1.o.l.e
    public void setBusinessType(int i2) {
    }

    @Override // d.a.j0.j1.o.l.e
    public void setDownloadAppCallback(d.a.j0.j1.o.c cVar) {
    }

    @Override // d.a.j0.j1.o.l.e
    public void setFromCDN(boolean z) {
        this.f60241g = z;
    }

    @Override // d.a.j0.j1.o.l.e
    public void setPosition(int i2) {
    }
}
