package master.flame.danmaku.danmaku.a;

import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.f;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes5.dex */
public abstract class a {
    protected DanmakuContext mZR;
    protected f naA;
    protected b<?> ndM;
    protected int ndN;
    protected int ndO;
    protected float ndP;
    protected float ndQ;
    private l ndR;
    protected m ndS;
    protected InterfaceC0799a ndT;

    /* renamed from: master.flame.danmaku.danmaku.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0799a {
    }

    protected abstract l dGm();

    public a c(m mVar) {
        this.ndS = mVar;
        this.ndN = mVar.getWidth();
        this.ndO = mVar.getHeight();
        this.ndP = mVar.getDensity();
        this.ndQ = mVar.dFF();
        this.mZR.nde.j(this.ndN, this.ndO, dGj());
        this.mZR.nde.dFZ();
        return this;
    }

    public a a(InterfaceC0799a interfaceC0799a) {
        this.ndT = interfaceC0799a;
        return this;
    }

    protected float dGj() {
        return 1.0f / (this.ndP - 0.6f);
    }

    public a d(f fVar) {
        this.naA = fVar;
        return this;
    }

    public l dGk() {
        if (this.ndR != null) {
            return this.ndR;
        }
        this.mZR.nde.dFY();
        this.ndR = dGm();
        dGl();
        this.mZR.nde.dFZ();
        return this.ndR;
    }

    protected void dGl() {
        if (this.ndM != null) {
            this.ndM.release();
        }
        this.ndM = null;
    }

    public void release() {
        dGl();
    }

    public a c(DanmakuContext danmakuContext) {
        if (this.mZR != null && this.mZR != danmakuContext) {
            this.ndR = null;
        }
        this.mZR = danmakuContext;
        return this;
    }
}
