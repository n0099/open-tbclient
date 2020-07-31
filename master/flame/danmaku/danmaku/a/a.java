package master.flame.danmaku.danmaku.a;

import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.f;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes6.dex */
public abstract class a {
    protected DanmakuContext oaF;
    protected f obp;
    protected int oeA;
    protected int oeB;
    protected float oeC;
    protected float oeD;
    private l oeE;
    protected m oeF;
    protected InterfaceC0918a oeG;
    protected b<?> oez;

    /* renamed from: master.flame.danmaku.danmaku.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0918a {
    }

    protected abstract l dWx();

    public a c(m mVar) {
        this.oeF = mVar;
        this.oeA = mVar.getWidth();
        this.oeB = mVar.getHeight();
        this.oeC = mVar.getDensity();
        this.oeD = mVar.dVQ();
        this.oaF.odS.j(this.oeA, this.oeB, dWu());
        this.oaF.odS.dWk();
        return this;
    }

    public a a(InterfaceC0918a interfaceC0918a) {
        this.oeG = interfaceC0918a;
        return this;
    }

    protected float dWu() {
        return 1.0f / (this.oeC - 0.6f);
    }

    public a d(f fVar) {
        this.obp = fVar;
        return this;
    }

    public l dWv() {
        if (this.oeE != null) {
            return this.oeE;
        }
        this.oaF.odS.dWj();
        this.oeE = dWx();
        dWw();
        this.oaF.odS.dWk();
        return this.oeE;
    }

    protected void dWw() {
        if (this.oez != null) {
            this.oez.release();
        }
        this.oez = null;
    }

    public void release() {
        dWw();
    }

    public a c(DanmakuContext danmakuContext) {
        if (this.oaF != null && this.oaF != danmakuContext) {
            this.oeE = null;
        }
        this.oaF = danmakuContext;
        return this;
    }
}
