package master.flame.danmaku.danmaku.a;

import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.f;
import master.flame.danmaku.danmaku.model.l;
import master.flame.danmaku.danmaku.model.m;
/* loaded from: classes6.dex */
public abstract class a {
    protected f pWV;
    protected DanmakuContext pWm;
    protected b<?> qac;
    protected int qad;
    protected int qae;
    protected float qaf;
    protected float qag;
    private l qah;
    protected m qai;
    protected InterfaceC1086a qaj;

    /* renamed from: master.flame.danmaku.danmaku.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1086a {
    }

    protected abstract l eEi();

    public a c(m mVar) {
        this.qai = mVar;
        this.qad = mVar.getWidth();
        this.qae = mVar.getHeight();
        this.qaf = mVar.getDensity();
        this.qag = mVar.eDB();
        this.pWm.pZw.l(this.qad, this.qae, eEf());
        this.pWm.pZw.eDV();
        return this;
    }

    public a a(InterfaceC1086a interfaceC1086a) {
        this.qaj = interfaceC1086a;
        return this;
    }

    protected float eEf() {
        return 1.0f / (this.qaf - 0.6f);
    }

    public a d(f fVar) {
        this.pWV = fVar;
        return this;
    }

    public l eEg() {
        if (this.qah != null) {
            return this.qah;
        }
        this.pWm.pZw.eDU();
        this.qah = eEi();
        eEh();
        this.pWm.pZw.eDV();
        return this.qah;
    }

    protected void eEh() {
        if (this.qac != null) {
            this.qac.release();
        }
        this.qac = null;
    }

    public void release() {
        eEh();
    }

    public a c(DanmakuContext danmakuContext) {
        if (this.pWm != null && this.pWm != danmakuContext) {
            this.qah = null;
        }
        this.pWm = danmakuContext;
        return this;
    }
}
