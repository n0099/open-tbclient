package com.kascend.chushou.player;
/* loaded from: classes5.dex */
public class c {
    private static c mpR = null;
    private tv.chushou.common.player.a mnR;
    private tv.chushou.common.player.a mpQ;

    public c() {
        this.mpQ = null;
        this.mnR = null;
        this.mpQ = ((tv.chushou.basis.d.a.a.b) tv.chushou.basis.d.b.dJr().S(tv.chushou.basis.d.a.a.b.class)).createPlayer();
        this.mnR = ((tv.chushou.basis.d.a.a.b) tv.chushou.basis.d.b.dJr().S(tv.chushou.basis.d.a.a.b.class)).createPlayer();
    }

    public tv.chushou.common.player.a dxy() {
        return this.mpQ;
    }

    public tv.chushou.common.player.a dxz() {
        return this.mnR;
    }

    public void c() {
        if (this.mpQ != null) {
            this.mpQ.release();
            this.mpQ = null;
        }
        if (this.mnR != null) {
            this.mnR.release();
            this.mnR = null;
        }
    }
}
