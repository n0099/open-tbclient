package com.kascend.chushou.player;
/* loaded from: classes5.dex */
public class c {
    private static c ngZ = null;
    private tv.chushou.common.player.a nfc;
    private tv.chushou.common.player.a ngY;

    public c() {
        this.ngY = null;
        this.nfc = null;
        this.ngY = ((tv.chushou.basis.d.a.a.b) tv.chushou.basis.d.b.dWk().S(tv.chushou.basis.d.a.a.b.class)).createPlayer();
        this.nfc = ((tv.chushou.basis.d.a.a.b) tv.chushou.basis.d.b.dWk().S(tv.chushou.basis.d.a.a.b.class)).createPlayer();
    }

    public tv.chushou.common.player.a dJL() {
        return this.ngY;
    }

    public tv.chushou.common.player.a dJM() {
        return this.nfc;
    }

    public void c() {
        if (this.ngY != null) {
            this.ngY.release();
            this.ngY = null;
        }
        if (this.nfc != null) {
            this.nfc.release();
            this.nfc = null;
        }
    }
}
