package com.kascend.chushou.player;
/* loaded from: classes6.dex */
public class c {
    private static c plx = null;
    private tv.chushou.common.player.a pjz;
    private tv.chushou.common.player.a plw;

    public c() {
        this.plw = null;
        this.pjz = null;
        this.plw = ((tv.chushou.basis.d.a.a.b) tv.chushou.basis.d.b.eHr().S(tv.chushou.basis.d.a.a.b.class)).createPlayer();
        this.pjz = ((tv.chushou.basis.d.a.a.b) tv.chushou.basis.d.b.eHr().S(tv.chushou.basis.d.a.a.b.class)).createPlayer();
    }

    public tv.chushou.common.player.a euO() {
        return this.plw;
    }

    public tv.chushou.common.player.a euP() {
        return this.pjz;
    }

    public void c() {
        if (this.plw != null) {
            this.plw.release();
            this.plw = null;
        }
        if (this.pjz != null) {
            this.pjz.release();
            this.pjz = null;
        }
    }
}
