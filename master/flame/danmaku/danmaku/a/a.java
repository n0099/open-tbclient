package master.flame.danmaku.danmaku.a;

import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.f;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes6.dex */
public abstract class a {
    protected f pLY;
    protected DanmakuContext pLp;
    protected b<?> pPf;
    protected int pPg;
    protected int pPh;
    protected float pPi;
    protected float pPj;
    private l pPk;
    protected m pPl;
    protected InterfaceC1063a pPm;

    /* renamed from: master.flame.danmaku.danmaku.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1063a {
    }

    protected abstract l eAs();

    public a c(m mVar) {
        this.pPl = mVar;
        this.pPg = mVar.getWidth();
        this.pPh = mVar.getHeight();
        this.pPi = mVar.getDensity();
        this.pPj = mVar.ezL();
        this.pLp.pOz.l(this.pPg, this.pPh, eAp());
        this.pLp.pOz.eAf();
        return this;
    }

    public a a(InterfaceC1063a interfaceC1063a) {
        this.pPm = interfaceC1063a;
        return this;
    }

    protected float eAp() {
        return 1.0f / (this.pPi - 0.6f);
    }

    public a d(f fVar) {
        this.pLY = fVar;
        return this;
    }

    public l eAq() {
        if (this.pPk != null) {
            return this.pPk;
        }
        this.pLp.pOz.eAe();
        this.pPk = eAs();
        eAr();
        this.pLp.pOz.eAf();
        return this.pPk;
    }

    protected void eAr() {
        if (this.pPf != null) {
            this.pPf.release();
        }
        this.pPf = null;
    }

    public void release() {
        eAr();
    }

    public a c(DanmakuContext danmakuContext) {
        if (this.pLp != null && this.pLp != danmakuContext) {
            this.pPk = null;
        }
        this.pLp = danmakuContext;
        return this;
    }
}
