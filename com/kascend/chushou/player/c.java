package com.kascend.chushou.player;
/* loaded from: classes6.dex */
public class c {
    private static c ojg = null;
    private tv.chushou.common.player.a ohj;
    private tv.chushou.common.player.a ojf;

    public c() {
        this.ojf = null;
        this.ohj = null;
        this.ojf = ((tv.chushou.basis.d.a.a.b) tv.chushou.basis.d.b.etD().S(tv.chushou.basis.d.a.a.b.class)).createPlayer();
        this.ohj = ((tv.chushou.basis.d.a.a.b) tv.chushou.basis.d.b.etD().S(tv.chushou.basis.d.a.a.b.class)).createPlayer();
    }

    public tv.chushou.common.player.a egZ() {
        return this.ojf;
    }

    public tv.chushou.common.player.a eha() {
        return this.ohj;
    }

    public void c() {
        if (this.ojf != null) {
            this.ojf.release();
            this.ojf = null;
        }
        if (this.ohj != null) {
            this.ohj.release();
            this.ohj = null;
        }
    }
}
