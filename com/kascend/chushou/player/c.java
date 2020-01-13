package com.kascend.chushou.player;
/* loaded from: classes4.dex */
public class c {
    private static c mQx = null;
    private tv.chushou.common.player.a mOy;
    private tv.chushou.common.player.a mQw;

    public c() {
        this.mQw = null;
        this.mOy = null;
        this.mQw = ((tv.chushou.basis.d.a.a.b) tv.chushou.basis.d.b.dOE().T(tv.chushou.basis.d.a.a.b.class)).createPlayer();
        this.mOy = ((tv.chushou.basis.d.a.a.b) tv.chushou.basis.d.b.dOE().T(tv.chushou.basis.d.a.a.b.class)).createPlayer();
    }

    public tv.chushou.common.player.a dBy() {
        return this.mQw;
    }

    public tv.chushou.common.player.a dBz() {
        return this.mOy;
    }

    public void c() {
        if (this.mQw != null) {
            this.mQw.release();
            this.mQw = null;
        }
        if (this.mOy != null) {
            this.mOy.release();
            this.mOy = null;
        }
    }
}
