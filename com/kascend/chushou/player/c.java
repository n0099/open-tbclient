package com.kascend.chushou.player;
/* loaded from: classes6.dex */
public class c {
    private static c pjT = null;
    private tv.chushou.common.player.a phT;
    private tv.chushou.common.player.a pjS;

    public c() {
        this.pjS = null;
        this.phT = null;
        this.pjS = ((tv.chushou.basis.d.a.a.b) tv.chushou.basis.d.b.eHq().S(tv.chushou.basis.d.a.a.b.class)).createPlayer();
        this.phT = ((tv.chushou.basis.d.a.a.b) tv.chushou.basis.d.b.eHq().S(tv.chushou.basis.d.a.a.b.class)).createPlayer();
    }

    public tv.chushou.common.player.a euO() {
        return this.pjS;
    }

    public tv.chushou.common.player.a euP() {
        return this.phT;
    }

    public void c() {
        if (this.pjS != null) {
            this.pjS.release();
            this.pjS = null;
        }
        if (this.phT != null) {
            this.phT.release();
            this.phT = null;
        }
    }
}
