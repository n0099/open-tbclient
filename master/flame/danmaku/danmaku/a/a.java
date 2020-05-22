package master.flame.danmaku.danmaku.a;

import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.f;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes5.dex */
public abstract class a {
    protected DanmakuContext nuX;
    protected f nvG;
    protected b<?> nyR;
    protected int nyS;
    protected int nyT;
    protected float nyU;
    protected float nyV;
    private l nyW;
    protected m nyX;
    protected InterfaceC0882a nyY;

    /* renamed from: master.flame.danmaku.danmaku.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0882a {
    }

    protected abstract l dOd();

    public a c(m mVar) {
        this.nyX = mVar;
        this.nyS = mVar.getWidth();
        this.nyT = mVar.getHeight();
        this.nyU = mVar.getDensity();
        this.nyV = mVar.dNw();
        this.nuX.nyk.j(this.nyS, this.nyT, dOa());
        this.nuX.nyk.dNQ();
        return this;
    }

    public a a(InterfaceC0882a interfaceC0882a) {
        this.nyY = interfaceC0882a;
        return this;
    }

    protected float dOa() {
        return 1.0f / (this.nyU - 0.6f);
    }

    public a d(f fVar) {
        this.nvG = fVar;
        return this;
    }

    public l dOb() {
        if (this.nyW != null) {
            return this.nyW;
        }
        this.nuX.nyk.dNP();
        this.nyW = dOd();
        dOc();
        this.nuX.nyk.dNQ();
        return this.nyW;
    }

    protected void dOc() {
        if (this.nyR != null) {
            this.nyR.release();
        }
        this.nyR = null;
    }

    public void release() {
        dOc();
    }

    public a c(DanmakuContext danmakuContext) {
        if (this.nuX != null && this.nuX != danmakuContext) {
            this.nyW = null;
        }
        this.nuX = danmakuContext;
        return this;
    }
}
