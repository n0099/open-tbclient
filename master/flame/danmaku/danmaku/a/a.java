package master.flame.danmaku.danmaku.a;

import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.f;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes6.dex */
public abstract class a {
    protected DanmakuContext oEE;
    protected f oFn;
    private l oIA;
    protected m oIB;
    protected InterfaceC0973a oIC;
    protected b<?> oIv;
    protected int oIw;
    protected int oIx;
    protected float oIy;
    protected float oIz;

    /* renamed from: master.flame.danmaku.danmaku.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0973a {
    }

    protected abstract l emH();

    public a c(m mVar) {
        this.oIB = mVar;
        this.oIw = mVar.getWidth();
        this.oIx = mVar.getHeight();
        this.oIy = mVar.getDensity();
        this.oIz = mVar.ema();
        this.oEE.oHO.j(this.oIw, this.oIx, emE());
        this.oEE.oHO.emu();
        return this;
    }

    public a a(InterfaceC0973a interfaceC0973a) {
        this.oIC = interfaceC0973a;
        return this;
    }

    protected float emE() {
        return 1.0f / (this.oIy - 0.6f);
    }

    public a d(f fVar) {
        this.oFn = fVar;
        return this;
    }

    public l emF() {
        if (this.oIA != null) {
            return this.oIA;
        }
        this.oEE.oHO.emt();
        this.oIA = emH();
        emG();
        this.oEE.oHO.emu();
        return this.oIA;
    }

    protected void emG() {
        if (this.oIv != null) {
            this.oIv.release();
        }
        this.oIv = null;
    }

    public void release() {
        emG();
    }

    public a c(DanmakuContext danmakuContext) {
        if (this.oEE != null && this.oEE != danmakuContext) {
            this.oIA = null;
        }
        this.oEE = danmakuContext;
        return this;
    }
}
