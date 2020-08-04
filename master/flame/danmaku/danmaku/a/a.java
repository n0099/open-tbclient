package master.flame.danmaku.danmaku.a;

import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.f;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes6.dex */
public abstract class a {
    protected DanmakuContext oaH;
    protected f obr;
    protected b<?> oeB;
    protected int oeC;
    protected int oeD;
    protected float oeE;
    protected float oeF;
    private l oeG;
    protected m oeH;
    protected InterfaceC0918a oeI;

    /* renamed from: master.flame.danmaku.danmaku.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0918a {
    }

    protected abstract l dWy();

    public a c(m mVar) {
        this.oeH = mVar;
        this.oeC = mVar.getWidth();
        this.oeD = mVar.getHeight();
        this.oeE = mVar.getDensity();
        this.oeF = mVar.dVR();
        this.oaH.odU.j(this.oeC, this.oeD, dWv());
        this.oaH.odU.dWl();
        return this;
    }

    public a a(InterfaceC0918a interfaceC0918a) {
        this.oeI = interfaceC0918a;
        return this;
    }

    protected float dWv() {
        return 1.0f / (this.oeE - 0.6f);
    }

    public a d(f fVar) {
        this.obr = fVar;
        return this;
    }

    public l dWw() {
        if (this.oeG != null) {
            return this.oeG;
        }
        this.oaH.odU.dWk();
        this.oeG = dWy();
        dWx();
        this.oaH.odU.dWl();
        return this.oeG;
    }

    protected void dWx() {
        if (this.oeB != null) {
            this.oeB.release();
        }
        this.oeB = null;
    }

    public void release() {
        dWx();
    }

    public a c(DanmakuContext danmakuContext) {
        if (this.oaH != null && this.oaH != danmakuContext) {
            this.oeG = null;
        }
        this.oaH = danmakuContext;
        return this;
    }
}
