package master.flame.danmaku.danmaku.a;

import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.f;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes5.dex */
public abstract class a {
    protected DanmakuContext nEt;
    protected f nFc;
    protected b<?> nIl;
    protected int nIm;
    protected int nIn;
    protected float nIo;
    protected float nIp;
    private l nIq;
    protected m nIr;
    protected InterfaceC0775a nIs;

    /* renamed from: master.flame.danmaku.danmaku.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0775a {
    }

    protected abstract l dML();

    public a c(m mVar) {
        this.nIr = mVar;
        this.nIm = mVar.getWidth();
        this.nIn = mVar.getHeight();
        this.nIo = mVar.getDensity();
        this.nIp = mVar.dMe();
        this.nEt.nHD.i(this.nIm, this.nIn, dMI());
        this.nEt.nHD.dMy();
        return this;
    }

    public a a(InterfaceC0775a interfaceC0775a) {
        this.nIs = interfaceC0775a;
        return this;
    }

    protected float dMI() {
        return 1.0f / (this.nIo - 0.6f);
    }

    public a d(f fVar) {
        this.nFc = fVar;
        return this;
    }

    public l dMJ() {
        if (this.nIq != null) {
            return this.nIq;
        }
        this.nEt.nHD.dMx();
        this.nIq = dML();
        dMK();
        this.nEt.nHD.dMy();
        return this.nIq;
    }

    protected void dMK() {
        if (this.nIl != null) {
            this.nIl.release();
        }
        this.nIl = null;
    }

    public void release() {
        dMK();
    }

    public a c(DanmakuContext danmakuContext) {
        if (this.nEt != null && this.nEt != danmakuContext) {
            this.nIq = null;
        }
        this.nEt = danmakuContext;
        return this;
    }
}
