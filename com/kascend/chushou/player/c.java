package com.kascend.chushou.player;
/* loaded from: classes5.dex */
public class c {
    private static c mRg = null;
    private tv.chushou.common.player.a mPf;
    private tv.chushou.common.player.a mRf;

    public c() {
        this.mRf = null;
        this.mPf = null;
        this.mRf = ((tv.chushou.basis.d.a.a.b) tv.chushou.basis.d.b.dPT().S(tv.chushou.basis.d.a.a.b.class)).createPlayer();
        this.mPf = ((tv.chushou.basis.d.a.a.b) tv.chushou.basis.d.b.dPT().S(tv.chushou.basis.d.a.a.b.class)).createPlayer();
    }

    public tv.chushou.common.player.a dCG() {
        return this.mRf;
    }

    public tv.chushou.common.player.a dCH() {
        return this.mPf;
    }

    public void c() {
        if (this.mRf != null) {
            this.mRf.release();
            this.mRf = null;
        }
        if (this.mPf != null) {
            this.mPf.release();
            this.mPf = null;
        }
    }
}
