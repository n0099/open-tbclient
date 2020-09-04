package master.flame.danmaku.danmaku.a;

import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.f;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes6.dex */
public abstract class a {
    protected DanmakuContext ouY;
    protected f ovH;
    protected b<?> oyQ;
    protected int oyR;
    protected int oyS;
    protected float oyT;
    protected float oyU;
    private l oyV;
    protected m oyW;
    protected InterfaceC0976a oyX;

    /* renamed from: master.flame.danmaku.danmaku.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0976a {
    }

    protected abstract l eiK();

    public a c(m mVar) {
        this.oyW = mVar;
        this.oyR = mVar.getWidth();
        this.oyS = mVar.getHeight();
        this.oyT = mVar.getDensity();
        this.oyU = mVar.eid();
        this.ouY.oyj.j(this.oyR, this.oyS, eiH());
        this.ouY.oyj.eix();
        return this;
    }

    public a a(InterfaceC0976a interfaceC0976a) {
        this.oyX = interfaceC0976a;
        return this;
    }

    protected float eiH() {
        return 1.0f / (this.oyT - 0.6f);
    }

    public a d(f fVar) {
        this.ovH = fVar;
        return this;
    }

    public l eiI() {
        if (this.oyV != null) {
            return this.oyV;
        }
        this.ouY.oyj.eiw();
        this.oyV = eiK();
        eiJ();
        this.ouY.oyj.eix();
        return this.oyV;
    }

    protected void eiJ() {
        if (this.oyQ != null) {
            this.oyQ.release();
        }
        this.oyQ = null;
    }

    public void release() {
        eiJ();
    }

    public a c(DanmakuContext danmakuContext) {
        if (this.ouY != null && this.ouY != danmakuContext) {
            this.oyV = null;
        }
        this.ouY = danmakuContext;
        return this;
    }
}
