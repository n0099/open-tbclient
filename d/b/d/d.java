package d.b.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.afd.ParseError;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import d.b.j0.j1.o.h.b;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends BaseCardInfo implements d.b.j0.j1.o.l.i, d.b.j0.j1.o.h.b {

    /* renamed from: e  reason: collision with root package name */
    public e f43238e;

    /* renamed from: f  reason: collision with root package name */
    public ICardInfo f43239f;

    /* renamed from: g  reason: collision with root package name */
    public h f43240g;
    public boolean i;
    public AdvertAppInfo k;
    public boolean j = false;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f43241h = BdUniqueId.gen();

    public static d g(h hVar) {
        d dVar = new d();
        dVar.f43240g = hVar;
        return dVar;
    }

    @Override // d.b.j0.j1.o.h.b
    public b.a getParallelCharge() {
        ICardInfo iCardInfo = this.f43239f;
        if (iCardInfo == null || !(iCardInfo instanceof d.b.j0.j1.o.h.b)) {
            return null;
        }
        return ((d.b.j0.j1.o.h.b) iCardInfo).getParallelCharge();
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        if (o() != null) {
            return b.f43233b;
        }
        return b.f43232a;
    }

    public e j() {
        return this.f43238e;
    }

    public int n() {
        h hVar = this.f43240g;
        if (hVar != null) {
            return hVar.e();
        }
        return 0;
    }

    public ICardInfo o() {
        return this.f43239f;
    }

    public BdUniqueId s() {
        return this.f43241h;
    }

    @Override // d.b.j0.j1.o.l.i
    public void setAutoPlay(boolean z) {
        if (o() instanceof d.b.j0.j1.o.l.i) {
            ((d.b.j0.j1.o.l.i) o()).setAutoPlay(z);
        }
    }

    @Override // d.b.j0.j1.o.l.i
    public void setWaitConfirm(boolean z) {
        if (o() instanceof d.b.j0.j1.o.l.i) {
            ((d.b.j0.j1.o.l.i) o()).setWaitConfirm(z);
        }
    }

    public void t() {
        if (!this.j) {
            d.b.j0.s2.f0.e.b().d(d.b.j0.s2.f0.h.o(this, ParseError.ERROR_SMOOTH_SCROLL));
            return;
        }
        d.b.i0.r.q.d.h(this);
    }

    public void u(e eVar) {
        this.f43238e = eVar;
        ICardInfo iCardInfo = eVar != null ? eVar.f43244c : null;
        this.f43239f = iCardInfo;
        if (iCardInfo instanceof i) {
            ((i) iCardInfo).setAdFacadeData(this);
        }
        this.j = true;
    }

    public AdvertAppInfo v() {
        if (this.k == null) {
            this.k = new AdvertAppInfo();
            h hVar = this.f43240g;
            if (hVar != null) {
                Map<String, String> c2 = hVar.c();
                this.k.K3 = String.valueOf(this.f43240g.d());
                this.k.A = c2 != null ? c2.get("thread_id") : "";
                this.k.u3(c2 != null ? Long.valueOf(c2.get("forum_id")).longValue() : 0L);
            }
            AdvertAppInfo advertAppInfo = this.k;
            e eVar = this.f43238e;
            advertAppInfo.T3 = eVar != null ? eVar.f43243b : "";
            this.k.c4 = "VIDEO_LIST";
        }
        return this.k;
    }
}
