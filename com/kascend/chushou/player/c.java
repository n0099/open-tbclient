package com.kascend.chushou.player;
/* loaded from: classes6.dex */
public class c {
    private static c nJB = null;
    private tv.chushou.common.player.a nHE;
    private tv.chushou.common.player.a nJA;

    public c() {
        this.nJA = null;
        this.nHE = null;
        this.nJA = ((tv.chushou.basis.d.a.a.b) tv.chushou.basis.d.b.elL().S(tv.chushou.basis.d.a.a.b.class)).createPlayer();
        this.nHE = ((tv.chushou.basis.d.a.a.b) tv.chushou.basis.d.b.elL().S(tv.chushou.basis.d.a.a.b.class)).createPlayer();
    }

    public tv.chushou.common.player.a dZh() {
        return this.nJA;
    }

    public tv.chushou.common.player.a dZi() {
        return this.nHE;
    }

    public void c() {
        if (this.nJA != null) {
            this.nJA.release();
            this.nJA = null;
        }
        if (this.nHE != null) {
            this.nHE.release();
            this.nHE = null;
        }
    }
}
