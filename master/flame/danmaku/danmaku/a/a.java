package master.flame.danmaku.danmaku.a;

import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.f;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes5.dex */
public abstract class a {
    protected DanmakuContext nEE;
    protected f nFn;
    protected float nIA;
    private l nIB;
    protected m nIC;
    protected InterfaceC0775a nID;
    protected b<?> nIw;
    protected int nIx;
    protected int nIy;
    protected float nIz;

    /* renamed from: master.flame.danmaku.danmaku.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0775a {
    }

    protected abstract l dMM();

    public a c(m mVar) {
        this.nIC = mVar;
        this.nIx = mVar.getWidth();
        this.nIy = mVar.getHeight();
        this.nIz = mVar.getDensity();
        this.nIA = mVar.dMf();
        this.nEE.nHO.i(this.nIx, this.nIy, dMJ());
        this.nEE.nHO.dMz();
        return this;
    }

    public a a(InterfaceC0775a interfaceC0775a) {
        this.nID = interfaceC0775a;
        return this;
    }

    protected float dMJ() {
        return 1.0f / (this.nIz - 0.6f);
    }

    public a d(f fVar) {
        this.nFn = fVar;
        return this;
    }

    public l dMK() {
        if (this.nIB != null) {
            return this.nIB;
        }
        this.nEE.nHO.dMy();
        this.nIB = dMM();
        dML();
        this.nEE.nHO.dMz();
        return this.nIB;
    }

    protected void dML() {
        if (this.nIw != null) {
            this.nIw.release();
        }
        this.nIw = null;
    }

    public void release() {
        dML();
    }

    public a c(DanmakuContext danmakuContext) {
        if (this.nEE != null && this.nEE != danmakuContext) {
            this.nIB = null;
        }
        this.nEE = danmakuContext;
        return this;
    }
}
