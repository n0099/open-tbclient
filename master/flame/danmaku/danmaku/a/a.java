package master.flame.danmaku.danmaku.a;

import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.f;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes4.dex */
public abstract class a {
    protected DanmakuContext nDz;
    protected f nEi;
    protected InterfaceC0767a nHA;
    protected b<?> nHt;
    protected int nHu;
    protected int nHv;
    protected float nHw;
    protected float nHx;
    private l nHy;
    protected m nHz;

    /* renamed from: master.flame.danmaku.danmaku.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0767a {
    }

    protected abstract l dLw();

    public a c(m mVar) {
        this.nHz = mVar;
        this.nHu = mVar.getWidth();
        this.nHv = mVar.getHeight();
        this.nHw = mVar.getDensity();
        this.nHx = mVar.dKP();
        this.nDz.nGK.i(this.nHu, this.nHv, dLt());
        this.nDz.nGK.dLj();
        return this;
    }

    public a a(InterfaceC0767a interfaceC0767a) {
        this.nHA = interfaceC0767a;
        return this;
    }

    protected float dLt() {
        return 1.0f / (this.nHw - 0.6f);
    }

    public a d(f fVar) {
        this.nEi = fVar;
        return this;
    }

    public l dLu() {
        if (this.nHy != null) {
            return this.nHy;
        }
        this.nDz.nGK.dLi();
        this.nHy = dLw();
        dLv();
        this.nDz.nGK.dLj();
        return this.nHy;
    }

    protected void dLv() {
        if (this.nHt != null) {
            this.nHt.release();
        }
        this.nHt = null;
    }

    public void release() {
        dLv();
    }

    public a c(DanmakuContext danmakuContext) {
        if (this.nDz != null && this.nDz != danmakuContext) {
            this.nHy = null;
        }
        this.nDz = danmakuContext;
        return this;
    }
}
