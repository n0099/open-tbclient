package com.kascend.chushou.player;
/* loaded from: classes5.dex */
public class c {
    private static c mKX = null;
    private tv.chushou.common.player.a mJb;
    private tv.chushou.common.player.a mKW;

    public c() {
        this.mKW = null;
        this.mJb = null;
        this.mKW = ((tv.chushou.basis.d.a.a.b) tv.chushou.basis.d.b.dRA().S(tv.chushou.basis.d.a.a.b.class)).createPlayer();
        this.mJb = ((tv.chushou.basis.d.a.a.b) tv.chushou.basis.d.b.dRA().S(tv.chushou.basis.d.a.a.b.class)).createPlayer();
    }

    public tv.chushou.common.player.a dFf() {
        return this.mKW;
    }

    public tv.chushou.common.player.a dFg() {
        return this.mJb;
    }

    public void c() {
        if (this.mKW != null) {
            this.mKW.release();
            this.mKW = null;
        }
        if (this.mJb != null) {
            this.mJb.release();
            this.mJb = null;
        }
    }
}
