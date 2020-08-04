package com.kascend.chushou.player;
/* loaded from: classes6.dex */
public class c {
    private static c npN = null;
    private tv.chushou.common.player.a nnN;
    private tv.chushou.common.player.a npM;

    public c() {
        this.npM = null;
        this.nnN = null;
        this.npM = ((tv.chushou.basis.d.a.a.b) tv.chushou.basis.d.b.dZH().S(tv.chushou.basis.d.a.a.b.class)).createPlayer();
        this.nnN = ((tv.chushou.basis.d.a.a.b) tv.chushou.basis.d.b.dZH().S(tv.chushou.basis.d.a.a.b.class)).createPlayer();
    }

    public tv.chushou.common.player.a dNh() {
        return this.npM;
    }

    public tv.chushou.common.player.a dNi() {
        return this.nnN;
    }

    public void c() {
        if (this.npM != null) {
            this.npM.release();
            this.npM = null;
        }
        if (this.nnN != null) {
            this.nnN.release();
            this.nnN = null;
        }
    }
}
