package master.flame.danmaku.danmaku.a;

import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.f;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes6.dex */
public abstract class a {
    protected DanmakuContext ouG;
    protected f ovp;
    protected int oyA;
    protected float oyB;
    protected float oyC;
    private l oyD;
    protected m oyE;
    protected InterfaceC0976a oyF;
    protected b<?> oyy;
    protected int oyz;

    /* renamed from: master.flame.danmaku.danmaku.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0976a {
    }

    protected abstract l eiB();

    public a c(m mVar) {
        this.oyE = mVar;
        this.oyz = mVar.getWidth();
        this.oyA = mVar.getHeight();
        this.oyB = mVar.getDensity();
        this.oyC = mVar.ehU();
        this.ouG.oxR.j(this.oyz, this.oyA, eiy());
        this.ouG.oxR.eio();
        return this;
    }

    public a a(InterfaceC0976a interfaceC0976a) {
        this.oyF = interfaceC0976a;
        return this;
    }

    protected float eiy() {
        return 1.0f / (this.oyB - 0.6f);
    }

    public a d(f fVar) {
        this.ovp = fVar;
        return this;
    }

    public l eiz() {
        if (this.oyD != null) {
            return this.oyD;
        }
        this.ouG.oxR.ein();
        this.oyD = eiB();
        eiA();
        this.ouG.oxR.eio();
        return this.oyD;
    }

    protected void eiA() {
        if (this.oyy != null) {
            this.oyy.release();
        }
        this.oyy = null;
    }

    public void release() {
        eiA();
    }

    public a c(DanmakuContext danmakuContext) {
        if (this.ouG != null && this.ouG != danmakuContext) {
            this.oyD = null;
        }
        this.ouG = danmakuContext;
        return this;
    }
}
