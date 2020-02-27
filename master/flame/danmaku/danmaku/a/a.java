package master.flame.danmaku.danmaku.a;

import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.f;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes5.dex */
public abstract class a {
    protected DanmakuContext nEr;
    protected f nFa;
    protected b<?> nIj;
    protected int nIk;
    protected int nIl;
    protected float nIm;
    protected float nIn;
    private l nIo;
    protected m nIp;
    protected InterfaceC0775a nIq;

    /* renamed from: master.flame.danmaku.danmaku.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0775a {
    }

    protected abstract l dMJ();

    public a c(m mVar) {
        this.nIp = mVar;
        this.nIk = mVar.getWidth();
        this.nIl = mVar.getHeight();
        this.nIm = mVar.getDensity();
        this.nIn = mVar.dMc();
        this.nEr.nHB.i(this.nIk, this.nIl, dMG());
        this.nEr.nHB.dMw();
        return this;
    }

    public a a(InterfaceC0775a interfaceC0775a) {
        this.nIq = interfaceC0775a;
        return this;
    }

    protected float dMG() {
        return 1.0f / (this.nIm - 0.6f);
    }

    public a d(f fVar) {
        this.nFa = fVar;
        return this;
    }

    public l dMH() {
        if (this.nIo != null) {
            return this.nIo;
        }
        this.nEr.nHB.dMv();
        this.nIo = dMJ();
        dMI();
        this.nEr.nHB.dMw();
        return this.nIo;
    }

    protected void dMI() {
        if (this.nIj != null) {
            this.nIj.release();
        }
        this.nIj = null;
    }

    public void release() {
        dMI();
    }

    public a c(DanmakuContext danmakuContext) {
        if (this.nEr != null && this.nEr != danmakuContext) {
            this.nIo = null;
        }
        this.nEr = danmakuContext;
        return this;
    }
}
