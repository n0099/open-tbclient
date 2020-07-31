package com.kascend.chushou.player;
/* loaded from: classes6.dex */
public class c {
    private static c npL = null;
    private tv.chushou.common.player.a nnL;
    private tv.chushou.common.player.a npK;

    public c() {
        this.npK = null;
        this.nnL = null;
        this.npK = ((tv.chushou.basis.d.a.a.b) tv.chushou.basis.d.b.dZG().S(tv.chushou.basis.d.a.a.b.class)).createPlayer();
        this.nnL = ((tv.chushou.basis.d.a.a.b) tv.chushou.basis.d.b.dZG().S(tv.chushou.basis.d.a.a.b.class)).createPlayer();
    }

    public tv.chushou.common.player.a dNg() {
        return this.npK;
    }

    public tv.chushou.common.player.a dNh() {
        return this.nnL;
    }

    public void c() {
        if (this.npK != null) {
            this.npK.release();
            this.npK = null;
        }
        if (this.nnL != null) {
            this.nnL.release();
            this.nnL = null;
        }
    }
}
