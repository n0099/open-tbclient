package com.kascend.chushou.player;
/* loaded from: classes5.dex */
public class c {
    private static c mRt = null;
    private tv.chushou.common.player.a mPu;
    private tv.chushou.common.player.a mRs;

    public c() {
        this.mRs = null;
        this.mPu = null;
        this.mRs = ((tv.chushou.basis.d.a.a.b) tv.chushou.basis.d.b.dPW().S(tv.chushou.basis.d.a.a.b.class)).createPlayer();
        this.mPu = ((tv.chushou.basis.d.a.a.b) tv.chushou.basis.d.b.dPW().S(tv.chushou.basis.d.a.a.b.class)).createPlayer();
    }

    public tv.chushou.common.player.a dCJ() {
        return this.mRs;
    }

    public tv.chushou.common.player.a dCK() {
        return this.mPu;
    }

    public void c() {
        if (this.mRs != null) {
            this.mRs.release();
            this.mRs = null;
        }
        if (this.mPu != null) {
            this.mPu.release();
            this.mPu = null;
        }
    }
}
