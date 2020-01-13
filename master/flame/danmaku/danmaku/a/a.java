package master.flame.danmaku.danmaku.a;

import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.f;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes4.dex */
public abstract class a {
    protected DanmakuContext nDu;
    protected f nEd;
    protected b<?> nHo;
    protected int nHp;
    protected int nHq;
    protected float nHr;
    protected float nHs;
    private l nHt;
    protected m nHu;
    protected InterfaceC0767a nHv;

    /* renamed from: master.flame.danmaku.danmaku.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0767a {
    }

    protected abstract l dLu();

    public a c(m mVar) {
        this.nHu = mVar;
        this.nHp = mVar.getWidth();
        this.nHq = mVar.getHeight();
        this.nHr = mVar.getDensity();
        this.nHs = mVar.dKN();
        this.nDu.nGF.i(this.nHp, this.nHq, dLr());
        this.nDu.nGF.dLh();
        return this;
    }

    public a a(InterfaceC0767a interfaceC0767a) {
        this.nHv = interfaceC0767a;
        return this;
    }

    protected float dLr() {
        return 1.0f / (this.nHr - 0.6f);
    }

    public a d(f fVar) {
        this.nEd = fVar;
        return this;
    }

    public l dLs() {
        if (this.nHt != null) {
            return this.nHt;
        }
        this.nDu.nGF.dLg();
        this.nHt = dLu();
        dLt();
        this.nDu.nGF.dLh();
        return this.nHt;
    }

    protected void dLt() {
        if (this.nHo != null) {
            this.nHo.release();
        }
        this.nHo = null;
    }

    public void release() {
        dLt();
    }

    public a c(DanmakuContext danmakuContext) {
        if (this.nDu != null && this.nDu != danmakuContext) {
            this.nHt = null;
        }
        this.nDu = danmakuContext;
        return this;
    }
}
