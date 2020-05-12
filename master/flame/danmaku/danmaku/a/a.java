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

    protected abstract l dGj();

    public a c(m mVar) {
        this.ndV = mVar;
        this.ndQ = mVar.getWidth();
        this.ndR = mVar.getHeight();
        this.ndS = mVar.getDensity();
        this.ndT = mVar.dFC();
        this.mZU.ndh.j(this.ndQ, this.ndR, dGg());
        this.mZU.ndh.dFW();
        return this;
    }

    public a a(InterfaceC0820a interfaceC0820a) {
        this.ndW = interfaceC0820a;
        return this;
    }

    protected float dGg() {
        return 1.0f / (this.ndS - 0.6f);
    }

    public a d(f fVar) {
        this.naD = fVar;
        return this;
    }

    public l dGh() {
        if (this.ndU != null) {
            return this.ndU;
        }
        this.mZU.ndh.dFV();
        this.ndU = dGj();
        dGi();
        this.mZU.ndh.dFW();
        return this.ndU;
    }

    protected void dGi() {
        if (this.ndP != null) {
            this.ndP.release();
        }
        this.ndP = null;
    }

    public void release() {
        dGi();
    }

    public a c(DanmakuContext danmakuContext) {
        if (this.mZU != null && this.mZU != danmakuContext) {
            this.ndU = null;
        }
        this.mZU = danmakuContext;
        return this;
    }
}
