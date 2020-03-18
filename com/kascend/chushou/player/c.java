package com.kascend.chushou.player;
/* loaded from: classes5.dex */
public class c {
    private static c mTd = null;
    private tv.chushou.common.player.a mRa;
    private tv.chushou.common.player.a mTc;

    public c() {
        this.mTc = null;
        this.mRa = null;
        this.mTc = ((tv.chushou.basis.d.a.a.b) tv.chushou.basis.d.b.dQw().S(tv.chushou.basis.d.a.a.b.class)).createPlayer();
        this.mRa = ((tv.chushou.basis.d.a.a.b) tv.chushou.basis.d.b.dQw().S(tv.chushou.basis.d.a.a.b.class)).createPlayer();
    }

    public tv.chushou.common.player.a dDh() {
        return this.mTc;
    }

    public tv.chushou.common.player.a dDi() {
        return this.mRa;
    }

    public void c() {
        if (this.mTc != null) {
            this.mTc.release();
            this.mTc = null;
        }
        if (this.mRa != null) {
            this.mRa.release();
            this.mRa = null;
        }
    }
}
