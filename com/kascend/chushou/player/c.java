package com.kascend.chushou.player;
/* loaded from: classes5.dex */
public class c {
    private static c mRi = null;
    private tv.chushou.common.player.a mPh;
    private tv.chushou.common.player.a mRh;

    public c() {
        this.mRh = null;
        this.mPh = null;
        this.mRh = ((tv.chushou.basis.d.a.a.b) tv.chushou.basis.d.b.dPV().S(tv.chushou.basis.d.a.a.b.class)).createPlayer();
        this.mPh = ((tv.chushou.basis.d.a.a.b) tv.chushou.basis.d.b.dPV().S(tv.chushou.basis.d.a.a.b.class)).createPlayer();
    }

    public tv.chushou.common.player.a dCI() {
        return this.mRh;
    }

    public tv.chushou.common.player.a dCJ() {
        return this.mPh;
    }

    public void c() {
        if (this.mRh != null) {
            this.mRh.release();
            this.mRh = null;
        }
        if (this.mPh != null) {
            this.mPh.release();
            this.mPh = null;
        }
    }
}
