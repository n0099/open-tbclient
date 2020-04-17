package com.kascend.chushou.player;
/* loaded from: classes5.dex */
public class c {
    private static c mpM = null;
    private tv.chushou.common.player.a mnM;
    private tv.chushou.common.player.a mpL;

    public c() {
        this.mpL = null;
        this.mnM = null;
        this.mpL = ((tv.chushou.basis.d.a.a.b) tv.chushou.basis.d.b.dJv().S(tv.chushou.basis.d.a.a.b.class)).createPlayer();
        this.mnM = ((tv.chushou.basis.d.a.a.b) tv.chushou.basis.d.b.dJv().S(tv.chushou.basis.d.a.a.b.class)).createPlayer();
    }

    public tv.chushou.common.player.a dxC() {
        return this.mpL;
    }

    public tv.chushou.common.player.a dxD() {
        return this.mnM;
    }

    public void c() {
        if (this.mpL != null) {
            this.mpL.release();
            this.mpL = null;
        }
        if (this.mnM != null) {
            this.mnM.release();
            this.mnM = null;
        }
    }
}
