package master.flame.danmaku.danmaku.a;

import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.f;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes5.dex */
public abstract class a {
    protected DanmakuContext nGr;
    protected f nHa;
    protected b<?> nKj;
    protected int nKk;
    protected int nKl;
    protected float nKm;
    protected float nKn;
    private l nKo;
    protected m nKp;
    protected InterfaceC0776a nKq;

    /* renamed from: master.flame.danmaku.danmaku.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0776a {
    }

    protected abstract l dNm();

    public a c(m mVar) {
        this.nKp = mVar;
        this.nKk = mVar.getWidth();
        this.nKl = mVar.getHeight();
        this.nKm = mVar.getDensity();
        this.nKn = mVar.dMF();
        this.nGr.nJB.i(this.nKk, this.nKl, dNj());
        this.nGr.nJB.dMZ();
        return this;
    }

    public a a(InterfaceC0776a interfaceC0776a) {
        this.nKq = interfaceC0776a;
        return this;
    }

    protected float dNj() {
        return 1.0f / (this.nKm - 0.6f);
    }

    public a d(f fVar) {
        this.nHa = fVar;
        return this;
    }

    public l dNk() {
        if (this.nKo != null) {
            return this.nKo;
        }
        this.nGr.nJB.dMY();
        this.nKo = dNm();
        dNl();
        this.nGr.nJB.dMZ();
        return this.nKo;
    }

    protected void dNl() {
        if (this.nKj != null) {
            this.nKj.release();
        }
        this.nKj = null;
    }

    public void release() {
        dNl();
    }

    public a c(DanmakuContext danmakuContext) {
        if (this.nGr != null && this.nGr != danmakuContext) {
            this.nKo = null;
        }
        this.nGr = danmakuContext;
        return this;
    }
}
