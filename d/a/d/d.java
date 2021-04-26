package d.a.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.afd.ParseError;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import d.a.j0.j1.o.h.b;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends BaseCardInfo implements d.a.j0.j1.o.l.i, d.a.j0.j1.o.h.b {

    /* renamed from: e  reason: collision with root package name */
    public e f40471e;

    /* renamed from: f  reason: collision with root package name */
    public ICardInfo f40472f;

    /* renamed from: g  reason: collision with root package name */
    public h f40473g;

    /* renamed from: i  reason: collision with root package name */
    public boolean f40475i;
    public AdvertAppInfo k;
    public boolean j = false;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f40474h = BdUniqueId.gen();

    public static d h(h hVar) {
        d dVar = new d();
        dVar.f40473g = hVar;
        return dVar;
    }

    @Override // d.a.j0.j1.o.h.b
    public b.a getParallelCharge() {
        ICardInfo iCardInfo = this.f40472f;
        if (iCardInfo == null || !(iCardInfo instanceof d.a.j0.j1.o.h.b)) {
            return null;
        }
        return ((d.a.j0.j1.o.h.b) iCardInfo).getParallelCharge();
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        if (p() != null) {
            return b.f40466b;
        }
        return b.f40465a;
    }

    public e l() {
        return this.f40471e;
    }

    public int m() {
        h hVar = this.f40473g;
        if (hVar != null) {
            return hVar.e();
        }
        return 0;
    }

    public ICardInfo p() {
        return this.f40472f;
    }

    public BdUniqueId s() {
        return this.f40474h;
    }

    @Override // d.a.j0.j1.o.l.i
    public void setAutoPlay(boolean z) {
        if (p() instanceof d.a.j0.j1.o.l.i) {
            ((d.a.j0.j1.o.l.i) p()).setAutoPlay(z);
        }
    }

    @Override // d.a.j0.j1.o.l.i
    public void setWaitConfirm(boolean z) {
        if (p() instanceof d.a.j0.j1.o.l.i) {
            ((d.a.j0.j1.o.l.i) p()).setWaitConfirm(z);
        }
    }

    public void t() {
        if (!this.j) {
            d.a.j0.s2.h0.e.b().d(d.a.j0.s2.h0.h.o(this, ParseError.ERROR_SMOOTH_SCROLL));
            return;
        }
        d.a.i0.r.q.d.h(this);
    }

    public void u(e eVar) {
        this.f40471e = eVar;
        ICardInfo iCardInfo = eVar != null ? eVar.f40478c : null;
        this.f40472f = iCardInfo;
        if (iCardInfo instanceof i) {
            ((i) iCardInfo).setAdFacadeData(this);
        }
        this.j = true;
    }

    public AdvertAppInfo v() {
        if (this.k == null) {
            this.k = new AdvertAppInfo();
            h hVar = this.f40473g;
            if (hVar != null) {
                Map<String, String> d2 = hVar.d();
                this.k.K3 = String.valueOf(this.f40473g.b());
                this.k.A = d2 != null ? d2.get("thread_id") : "";
                this.k.u3(d2 != null ? Long.valueOf(d2.get("forum_id")).longValue() : 0L);
            }
            AdvertAppInfo advertAppInfo = this.k;
            e eVar = this.f40471e;
            advertAppInfo.T3 = eVar != null ? eVar.f40477b : "";
            this.k.c4 = "VIDEO_LIST";
        }
        return this.k;
    }
}
