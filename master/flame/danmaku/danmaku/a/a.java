package master.flame.danmaku.danmaku.a;

import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.f;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes5.dex */
public abstract class a {
    protected DanmakuContext nRT;
    protected f nSC;
    protected b<?> nVM;
    protected int nVN;
    protected int nVO;
    protected float nVP;
    protected float nVQ;
    private l nVR;
    protected m nVS;
    protected InterfaceC0902a nVT;

    /* renamed from: master.flame.danmaku.danmaku.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0902a {
    }

    protected abstract l dSX();

    public a c(m mVar) {
        this.nVS = mVar;
        this.nVN = mVar.getWidth();
        this.nVO = mVar.getHeight();
        this.nVP = mVar.getDensity();
        this.nVQ = mVar.dSq();
        this.nRT.nVf.j(this.nVN, this.nVO, dSU());
        this.nRT.nVf.dSK();
        return this;
    }

    public a a(InterfaceC0902a interfaceC0902a) {
        this.nVT = interfaceC0902a;
        return this;
    }

    protected float dSU() {
        return 1.0f / (this.nVP - 0.6f);
    }

    public a d(f fVar) {
        this.nSC = fVar;
        return this;
    }

    public l dSV() {
        if (this.nVR != null) {
            return this.nVR;
        }
        this.nRT.nVf.dSJ();
        this.nVR = dSX();
        dSW();
        this.nRT.nVf.dSK();
        return this.nVR;
    }

    protected void dSW() {
        if (this.nVM != null) {
            this.nVM.release();
        }
        this.nVM = null;
    }

    public void release() {
        dSW();
    }

    public a c(DanmakuContext danmakuContext) {
        if (this.nRT != null && this.nRT != danmakuContext) {
            this.nVR = null;
        }
        this.nRT = danmakuContext;
        return this;
    }
}
