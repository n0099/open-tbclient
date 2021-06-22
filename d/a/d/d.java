package d.a.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.afd.ParseError;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import d.a.o0.k1.o.h.b;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends BaseCardInfo implements d.a.o0.k1.o.l.i, d.a.o0.k1.o.h.b {

    /* renamed from: e  reason: collision with root package name */
    public e f43316e;

    /* renamed from: f  reason: collision with root package name */
    public ICardInfo f43317f;

    /* renamed from: g  reason: collision with root package name */
    public h f43318g;

    /* renamed from: i  reason: collision with root package name */
    public boolean f43320i;
    public AdvertAppInfo k;
    public boolean j = false;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f43319h = BdUniqueId.gen();

    public static d c(h hVar) {
        d dVar = new d();
        dVar.f43318g = hVar;
        return dVar;
    }

    public e g() {
        return this.f43316e;
    }

    @Override // d.a.o0.k1.o.h.b
    public b.a getParallelCharge() {
        ICardInfo iCardInfo = this.f43317f;
        if (iCardInfo == null || !(iCardInfo instanceof d.a.o0.k1.o.h.b)) {
            return null;
        }
        return ((d.a.o0.k1.o.h.b) iCardInfo).getParallelCharge();
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        if (k() != null) {
            return b.f43311b;
        }
        return b.f43310a;
    }

    public int i() {
        h hVar = this.f43318g;
        if (hVar != null) {
            return hVar.e();
        }
        return 0;
    }

    public ICardInfo k() {
        return this.f43317f;
    }

    public BdUniqueId o() {
        return this.f43319h;
    }

    public void p() {
        if (!this.j) {
            d.a.o0.t2.i0.e.b().d(d.a.o0.t2.i0.g.o(this, ParseError.ERROR_SMOOTH_SCROLL));
            return;
        }
        d.a.n0.r.q.d.h(this);
    }

    public void q(e eVar) {
        this.f43316e = eVar;
        ICardInfo iCardInfo = eVar != null ? eVar.f43323c : null;
        this.f43317f = iCardInfo;
        if (iCardInfo instanceof i) {
            ((i) iCardInfo).setAdFacadeData(this);
        }
        this.j = true;
    }

    @Override // d.a.o0.k1.o.l.i
    public void setAutoPlay(boolean z) {
        if (k() instanceof d.a.o0.k1.o.l.i) {
            ((d.a.o0.k1.o.l.i) k()).setAutoPlay(z);
        }
    }

    @Override // d.a.o0.k1.o.l.i
    public void setWaitConfirm(boolean z) {
        if (k() instanceof d.a.o0.k1.o.l.i) {
            ((d.a.o0.k1.o.l.i) k()).setWaitConfirm(z);
        }
    }

    public AdvertAppInfo t() {
        if (this.k == null) {
            this.k = new AdvertAppInfo();
            h hVar = this.f43318g;
            if (hVar != null) {
                Map<String, String> d2 = hVar.d();
                this.k.P3 = String.valueOf(this.f43318g.b());
                this.k.A = d2 != null ? d2.get("thread_id") : "";
                this.k.y3(d2 != null ? Long.valueOf(d2.get("forum_id")).longValue() : 0L);
            }
            AdvertAppInfo advertAppInfo = this.k;
            e eVar = this.f43316e;
            advertAppInfo.Q3 = eVar != null ? eVar.f43322b : "";
            this.k.T3 = "VIDEO_LIST";
        }
        return this.k;
    }
}
