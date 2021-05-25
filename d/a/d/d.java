package d.a.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.afd.ParseError;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import d.a.n0.k1.o.h.b;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends BaseCardInfo implements d.a.n0.k1.o.l.i, d.a.n0.k1.o.h.b {

    /* renamed from: e  reason: collision with root package name */
    public e f39532e;

    /* renamed from: f  reason: collision with root package name */
    public ICardInfo f39533f;

    /* renamed from: g  reason: collision with root package name */
    public h f39534g;

    /* renamed from: i  reason: collision with root package name */
    public boolean f39536i;
    public AdvertAppInfo k;
    public boolean j = false;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f39535h = BdUniqueId.gen();

    public static d h(h hVar) {
        d dVar = new d();
        dVar.f39534g = hVar;
        return dVar;
    }

    @Override // d.a.n0.k1.o.h.b
    public b.a getParallelCharge() {
        ICardInfo iCardInfo = this.f39533f;
        if (iCardInfo == null || !(iCardInfo instanceof d.a.n0.k1.o.h.b)) {
            return null;
        }
        return ((d.a.n0.k1.o.h.b) iCardInfo).getParallelCharge();
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        if (p() != null) {
            return b.f39527b;
        }
        return b.f39526a;
    }

    public e l() {
        return this.f39532e;
    }

    public int m() {
        h hVar = this.f39534g;
        if (hVar != null) {
            return hVar.e();
        }
        return 0;
    }

    public ICardInfo p() {
        return this.f39533f;
    }

    public BdUniqueId s() {
        return this.f39535h;
    }

    @Override // d.a.n0.k1.o.l.i
    public void setAutoPlay(boolean z) {
        if (p() instanceof d.a.n0.k1.o.l.i) {
            ((d.a.n0.k1.o.l.i) p()).setAutoPlay(z);
        }
    }

    @Override // d.a.n0.k1.o.l.i
    public void setWaitConfirm(boolean z) {
        if (p() instanceof d.a.n0.k1.o.l.i) {
            ((d.a.n0.k1.o.l.i) p()).setWaitConfirm(z);
        }
    }

    public void t() {
        if (!this.j) {
            d.a.n0.t2.i0.e.b().d(d.a.n0.t2.i0.g.o(this, ParseError.ERROR_SMOOTH_SCROLL));
            return;
        }
        d.a.m0.r.q.d.h(this);
    }

    public void u(e eVar) {
        this.f39532e = eVar;
        ICardInfo iCardInfo = eVar != null ? eVar.f39539c : null;
        this.f39533f = iCardInfo;
        if (iCardInfo instanceof i) {
            ((i) iCardInfo).setAdFacadeData(this);
        }
        this.j = true;
    }

    public AdvertAppInfo v() {
        if (this.k == null) {
            this.k = new AdvertAppInfo();
            h hVar = this.f39534g;
            if (hVar != null) {
                Map<String, String> d2 = hVar.d();
                this.k.M3 = String.valueOf(this.f39534g.b());
                this.k.A = d2 != null ? d2.get("thread_id") : "";
                this.k.x3(d2 != null ? Long.valueOf(d2.get("forum_id")).longValue() : 0L);
            }
            AdvertAppInfo advertAppInfo = this.k;
            e eVar = this.f39532e;
            advertAppInfo.N3 = eVar != null ? eVar.f39538b : "";
            this.k.Q3 = "VIDEO_LIST";
        }
        return this.k;
    }
}
