package d.b.j0.s2.c0.d.a;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import d.b.j0.j1.o.l.e;
/* loaded from: classes4.dex */
public abstract class a implements e<AdCard> {

    /* renamed from: e  reason: collision with root package name */
    public AdCard f62025e;

    /* renamed from: f  reason: collision with root package name */
    public AdvertAppInfo f62026f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f62027g;

    /* renamed from: h  reason: collision with root package name */
    public Context f62028h;
    public TbPageContext i;
    public d.b.j0.j1.o.a j;

    public a(TbPageContext tbPageContext) {
        this.i = tbPageContext;
        this.f62028h = tbPageContext.getPageActivity();
    }

    @Override // d.b.j0.j1.o.l.e
    public void c(Object obj) {
        if (obj instanceof AdCard) {
            this.f62025e = (AdCard) obj;
            d();
            g(this.f62025e);
        }
    }

    public abstract void d();

    @Override // d.b.j0.j1.o.l.e
    public void e() {
    }

    @Override // d.b.j0.j1.o.l.e
    public void f() {
    }

    public void g(AdCard adCard) {
        this.f62025e = adCard;
        this.f62026f = adCard.getAdvertAppInfo();
    }

    @Override // d.b.j0.j1.o.l.e
    public void h() {
    }

    @Override // d.b.j0.j1.o.l.e
    public void k() {
    }

    @Override // d.b.j0.j1.o.l.e
    public void l(BdUniqueId bdUniqueId) {
    }

    @Override // d.b.j0.j1.o.l.e
    public void setAfterClickSchemeListener(d.b.j0.j1.o.a aVar) {
        this.j = aVar;
    }

    @Override // d.b.j0.j1.o.l.e
    public void setBusinessType(int i) {
    }

    @Override // d.b.j0.j1.o.l.e
    public void setDownloadAppCallback(d.b.j0.j1.o.c cVar) {
    }

    @Override // d.b.j0.j1.o.l.e
    public void setFromCDN(boolean z) {
        this.f62027g = z;
    }

    @Override // d.b.j0.j1.o.l.e
    public void setPosition(int i) {
    }
}
