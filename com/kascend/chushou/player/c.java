package com.kascend.chushou.player;
/* loaded from: classes5.dex */
public class c {
    private static c ngW = null;
    private tv.chushou.common.player.a neZ;
    private tv.chushou.common.player.a ngV;

    public c() {
        this.ngV = null;
        this.neZ = null;
        this.ngV = ((tv.chushou.basis.d.a.a.b) tv.chushou.basis.d.b.dWg().S(tv.chushou.basis.d.a.a.b.class)).createPlayer();
        this.neZ = ((tv.chushou.basis.d.a.a.b) tv.chushou.basis.d.b.dWg().S(tv.chushou.basis.d.a.a.b.class)).createPlayer();
    }

    public tv.chushou.common.player.a dJH() {
        return this.ngV;
    }

    public tv.chushou.common.player.a dJI() {
        return this.neZ;
    }

    public void c() {
        if (this.ngV != null) {
            this.ngV.release();
            this.ngV = null;
        }
        if (this.neZ != null) {
            this.neZ.release();
            this.neZ = null;
        }
    }
}
