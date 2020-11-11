package master.flame.danmaku.danmaku.a;

import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.f;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes6.dex */
public abstract class a {
    protected DanmakuContext pUJ;
    protected f pVs;
    protected int pYA;
    protected int pYB;
    protected float pYC;
    protected float pYD;
    private l pYE;
    protected m pYF;
    protected InterfaceC1083a pYG;
    protected b<?> pYz;

    /* renamed from: master.flame.danmaku.danmaku.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1083a {
    }

    protected abstract l eEh();

    public a c(m mVar) {
        this.pYF = mVar;
        this.pYA = mVar.getWidth();
        this.pYB = mVar.getHeight();
        this.pYC = mVar.getDensity();
        this.pYD = mVar.eDA();
        this.pUJ.pXT.l(this.pYA, this.pYB, eEe());
        this.pUJ.pXT.eDU();
        return this;
    }

    public a a(InterfaceC1083a interfaceC1083a) {
        this.pYG = interfaceC1083a;
        return this;
    }

    protected float eEe() {
        return 1.0f / (this.pYC - 0.6f);
    }

    public a d(f fVar) {
        this.pVs = fVar;
        return this;
    }

    public l eEf() {
        if (this.pYE != null) {
            return this.pYE;
        }
        this.pUJ.pXT.eDT();
        this.pYE = eEh();
        eEg();
        this.pUJ.pXT.eDU();
        return this.pYE;
    }

    protected void eEg() {
        if (this.pYz != null) {
            this.pYz.release();
        }
        this.pYz = null;
    }

    public void release() {
        eEg();
    }

    public a c(DanmakuContext danmakuContext) {
        if (this.pUJ != null && this.pUJ != danmakuContext) {
            this.pYE = null;
        }
        this.pUJ = danmakuContext;
        return this;
    }
}
