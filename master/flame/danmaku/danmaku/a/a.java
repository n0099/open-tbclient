package master.flame.danmaku.danmaku.a;

import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.f;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes5.dex */
public abstract class a {
    protected b<?> nAb;
    protected int nAc;
    protected int nAd;
    protected float nAe;
    protected float nAf;
    private l nAg;
    protected m nAh;
    protected InterfaceC0883a nAi;
    protected f nwQ;
    protected DanmakuContext nwh;

    /* renamed from: master.flame.danmaku.danmaku.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0883a {
    }

    protected abstract l dOr();

    public a c(m mVar) {
        this.nAh = mVar;
        this.nAc = mVar.getWidth();
        this.nAd = mVar.getHeight();
        this.nAe = mVar.getDensity();
        this.nAf = mVar.dNK();
        this.nwh.nzu.j(this.nAc, this.nAd, dOo());
        this.nwh.nzu.dOe();
        return this;
    }

    public a a(InterfaceC0883a interfaceC0883a) {
        this.nAi = interfaceC0883a;
        return this;
    }

    protected float dOo() {
        return 1.0f / (this.nAe - 0.6f);
    }

    public a d(f fVar) {
        this.nwQ = fVar;
        return this;
    }

    public l dOp() {
        if (this.nAg != null) {
            return this.nAg;
        }
        this.nwh.nzu.dOd();
        this.nAg = dOr();
        dOq();
        this.nwh.nzu.dOe();
        return this.nAg;
    }

    protected void dOq() {
        if (this.nAb != null) {
            this.nAb.release();
        }
        this.nAb = null;
    }

    public void release() {
        dOq();
    }

    public a c(DanmakuContext danmakuContext) {
        if (this.nwh != null && this.nwh != danmakuContext) {
            this.nAg = null;
        }
        this.nwh = danmakuContext;
        return this;
    }
}
