package master.flame.danmaku.danmaku.a;

import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.f;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes5.dex */
public abstract class a {
    protected DanmakuContext mZU;
    protected f naD;
    protected b<?> ndP;
    protected int ndQ;
    protected int ndR;
    protected float ndS;
    protected float ndT;
    private l ndU;
    protected m ndV;
    protected InterfaceC0820a ndW;

    /* renamed from: master.flame.danmaku.danmaku.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0820a {
    }

    protected abstract l dGi();

    public a c(m mVar) {
        this.ndV = mVar;
        this.ndQ = mVar.getWidth();
        this.ndR = mVar.getHeight();
        this.ndS = mVar.getDensity();
        this.ndT = mVar.dFB();
        this.mZU.ndh.j(this.ndQ, this.ndR, dGf());
        this.mZU.ndh.dFV();
        return this;
    }

    public a a(InterfaceC0820a interfaceC0820a) {
        this.ndW = interfaceC0820a;
        return this;
    }

    protected float dGf() {
        return 1.0f / (this.ndS - 0.6f);
    }

    public a d(f fVar) {
        this.naD = fVar;
        return this;
    }

    public l dGg() {
        if (this.ndU != null) {
            return this.ndU;
        }
        this.mZU.ndh.dFU();
        this.ndU = dGi();
        dGh();
        this.mZU.ndh.dFV();
        return this.ndU;
    }

    protected void dGh() {
        if (this.ndP != null) {
            this.ndP.release();
        }
        this.ndP = null;
    }

    public void release() {
        dGh();
    }

    public a c(DanmakuContext danmakuContext) {
        if (this.mZU != null && this.mZU != danmakuContext) {
            this.ndU = null;
        }
        this.mZU = danmakuContext;
        return this;
    }
}
