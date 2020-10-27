package com.kascend.chushou.player;
/* loaded from: classes6.dex */
public class c {
    private static c paw = null;
    private tv.chushou.common.player.a oYy;
    private tv.chushou.common.player.a pav;

    public c() {
        this.pav = null;
        this.oYy = null;
        this.pav = ((tv.chushou.basis.d.a.a.b) tv.chushou.basis.d.b.eDB().S(tv.chushou.basis.d.a.a.b.class)).createPlayer();
        this.oYy = ((tv.chushou.basis.d.a.a.b) tv.chushou.basis.d.b.eDB().S(tv.chushou.basis.d.a.a.b.class)).createPlayer();
    }

    public tv.chushou.common.player.a eqZ() {
        return this.pav;
    }

    public tv.chushou.common.player.a era() {
        return this.oYy;
    }

    public void c() {
        if (this.pav != null) {
            this.pav.release();
            this.pav = null;
        }
        if (this.oYy != null) {
            this.oYy.release();
            this.oYy = null;
        }
    }
}
