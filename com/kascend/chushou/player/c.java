package com.kascend.chushou.player;
/* loaded from: classes6.dex */
public class c {
    private static c nTO = null;
    private tv.chushou.common.player.a nRR;
    private tv.chushou.common.player.a nTN;

    public c() {
        this.nTN = null;
        this.nRR = null;
        this.nTN = ((tv.chushou.basis.d.a.a.b) tv.chushou.basis.d.b.epS().S(tv.chushou.basis.d.a.a.b.class)).createPlayer();
        this.nRR = ((tv.chushou.basis.d.a.a.b) tv.chushou.basis.d.b.epS().S(tv.chushou.basis.d.a.a.b.class)).createPlayer();
    }

    public tv.chushou.common.player.a edo() {
        return this.nTN;
    }

    public tv.chushou.common.player.a edp() {
        return this.nRR;
    }

    public void c() {
        if (this.nTN != null) {
            this.nTN.release();
            this.nTN = null;
        }
        if (this.nRR != null) {
            this.nRR.release();
            this.nRR = null;
        }
    }
}
