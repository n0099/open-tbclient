package d.a.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.afd.ParseError;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import d.a.k0.j1.o.h.b;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends BaseCardInfo implements d.a.k0.j1.o.l.i, d.a.k0.j1.o.h.b {

    /* renamed from: e  reason: collision with root package name */
    public e f39716e;

    /* renamed from: f  reason: collision with root package name */
    public ICardInfo f39717f;

    /* renamed from: g  reason: collision with root package name */
    public h f39718g;

    /* renamed from: i  reason: collision with root package name */
    public boolean f39720i;
    public AdvertAppInfo k;
    public boolean j = false;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f39719h = BdUniqueId.gen();

    public static d h(h hVar) {
        d dVar = new d();
        dVar.f39718g = hVar;
        return dVar;
    }

    @Override // d.a.k0.j1.o.h.b
    public b.a getParallelCharge() {
        ICardInfo iCardInfo = this.f39717f;
        if (iCardInfo == null || !(iCardInfo instanceof d.a.k0.j1.o.h.b)) {
            return null;
        }
        return ((d.a.k0.j1.o.h.b) iCardInfo).getParallelCharge();
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        if (p() != null) {
            return b.f39711b;
        }
        return b.f39710a;
    }

    public e l() {
        return this.f39716e;
    }

    public int m() {
        h hVar = this.f39718g;
        if (hVar != null) {
            return hVar.e();
        }
        return 0;
    }

    public ICardInfo p() {
        return this.f39717f;
    }

    public BdUniqueId s() {
        return this.f39719h;
    }

    @Override // d.a.k0.j1.o.l.i
    public void setAutoPlay(boolean z) {
        if (p() instanceof d.a.k0.j1.o.l.i) {
            ((d.a.k0.j1.o.l.i) p()).setAutoPlay(z);
        }
    }

    @Override // d.a.k0.j1.o.l.i
    public void setWaitConfirm(boolean z) {
        if (p() instanceof d.a.k0.j1.o.l.i) {
            ((d.a.k0.j1.o.l.i) p()).setWaitConfirm(z);
        }
    }

    public void t() {
        if (!this.j) {
            d.a.k0.s2.i0.e.b().d(d.a.k0.s2.i0.g.o(this, ParseError.ERROR_SMOOTH_SCROLL));
            return;
        }
        d.a.j0.r.q.d.h(this);
    }

    public void u(e eVar) {
        this.f39716e = eVar;
        ICardInfo iCardInfo = eVar != null ? eVar.f39723c : null;
        this.f39717f = iCardInfo;
        if (iCardInfo instanceof i) {
            ((i) iCardInfo).setAdFacadeData(this);
        }
        this.j = true;
    }

    public AdvertAppInfo v() {
        if (this.k == null) {
            this.k = new AdvertAppInfo();
            h hVar = this.f39718g;
            if (hVar != null) {
                Map<String, String> d2 = hVar.d();
                this.k.L3 = String.valueOf(this.f39718g.b());
                this.k.A = d2 != null ? d2.get("thread_id") : "";
                this.k.w3(d2 != null ? Long.valueOf(d2.get("forum_id")).longValue() : 0L);
            }
            AdvertAppInfo advertAppInfo = this.k;
            e eVar = this.f39716e;
            advertAppInfo.M3 = eVar != null ? eVar.f39722b : "";
            this.k.P3 = "VIDEO_LIST";
        }
        return this.k;
    }
}
