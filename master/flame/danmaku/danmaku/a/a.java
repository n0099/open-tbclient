package master.flame.danmaku.danmaku.a;

import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.f;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes5.dex */
public abstract class a {
    protected DanmakuContext nRW;
    protected f nSF;
    protected b<?> nVP;
    protected int nVQ;
    protected int nVR;
    protected float nVS;
    protected float nVT;
    private l nVU;
    protected m nVV;
    protected InterfaceC0903a nVW;

    /* renamed from: master.flame.danmaku.danmaku.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0903a {
    }

    protected abstract l dTb();

    public a c(m mVar) {
        this.nVV = mVar;
        this.nVQ = mVar.getWidth();
        this.nVR = mVar.getHeight();
        this.nVS = mVar.getDensity();
        this.nVT = mVar.dSu();
        this.nRW.nVi.j(this.nVQ, this.nVR, dSY());
        this.nRW.nVi.dSO();
        return this;
    }

    public a a(InterfaceC0903a interfaceC0903a) {
        this.nVW = interfaceC0903a;
        return this;
    }

    protected float dSY() {
        return 1.0f / (this.nVS - 0.6f);
    }

    public a d(f fVar) {
        this.nSF = fVar;
        return this;
    }

    public l dSZ() {
        if (this.nVU != null) {
            return this.nVU;
        }
        this.nRW.nVi.dSN();
        this.nVU = dTb();
        dTa();
        this.nRW.nVi.dSO();
        return this.nVU;
    }

    protected void dTa() {
        if (this.nVP != null) {
            this.nVP.release();
        }
        this.nVP = null;
    }

    public void release() {
        dTa();
    }

    public a c(DanmakuContext danmakuContext) {
        if (this.nRW != null && this.nRW != danmakuContext) {
            this.nVU = null;
        }
        this.nRW = danmakuContext;
        return this;
    }
}
