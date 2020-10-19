package master.flame.danmaku.danmaku.a;

import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.f;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes6.dex */
public abstract class a {
    protected DanmakuContext oTT;
    protected f oUC;
    protected b<?> oXJ;
    protected int oXK;
    protected int oXL;
    protected float oXM;
    protected float oXN;
    private l oXO;
    protected m oXP;
    protected InterfaceC0991a oXQ;

    /* renamed from: master.flame.danmaku.danmaku.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0991a {
    }

    protected abstract l equ();

    public a c(m mVar) {
        this.oXP = mVar;
        this.oXK = mVar.getWidth();
        this.oXL = mVar.getHeight();
        this.oXM = mVar.getDensity();
        this.oXN = mVar.epN();
        this.oTT.oXd.j(this.oXK, this.oXL, eqr());
        this.oTT.oXd.eqh();
        return this;
    }

    public a a(InterfaceC0991a interfaceC0991a) {
        this.oXQ = interfaceC0991a;
        return this;
    }

    protected float eqr() {
        return 1.0f / (this.oXM - 0.6f);
    }

    public a d(f fVar) {
        this.oUC = fVar;
        return this;
    }

    public l eqs() {
        if (this.oXO != null) {
            return this.oXO;
        }
        this.oTT.oXd.eqg();
        this.oXO = equ();
        eqt();
        this.oTT.oXd.eqh();
        return this.oXO;
    }

    protected void eqt() {
        if (this.oXJ != null) {
            this.oXJ.release();
        }
        this.oXJ = null;
    }

    public void release() {
        eqt();
    }

    public a c(DanmakuContext danmakuContext) {
        if (this.oTT != null && this.oTT != danmakuContext) {
            this.oXO = null;
        }
        this.oTT = danmakuContext;
        return this;
    }
}
