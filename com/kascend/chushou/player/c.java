package com.kascend.chushou.player;
/* loaded from: classes6.dex */
public class c {
    private static c nJT = null;
    private tv.chushou.common.player.a nHW;
    private tv.chushou.common.player.a nJS;

    public c() {
        this.nJS = null;
        this.nHW = null;
        this.nJS = ((tv.chushou.basis.d.a.a.b) tv.chushou.basis.d.b.elU().S(tv.chushou.basis.d.a.a.b.class)).createPlayer();
        this.nHW = ((tv.chushou.basis.d.a.a.b) tv.chushou.basis.d.b.elU().S(tv.chushou.basis.d.a.a.b.class)).createPlayer();
    }

    public tv.chushou.common.player.a dZq() {
        return this.nJS;
    }

    public tv.chushou.common.player.a dZr() {
        return this.nHW;
    }

    public void c() {
        if (this.nJS != null) {
            this.nJS.release();
            this.nJS = null;
        }
        if (this.nHW != null) {
            this.nHW.release();
            this.nHW = null;
        }
    }
}
