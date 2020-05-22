package com.kascend.chushou.player;
/* loaded from: classes5.dex */
public class c {
    private static c mJN = null;
    private tv.chushou.common.player.a mHN;
    private tv.chushou.common.player.a mJM;

    public c() {
        this.mJM = null;
        this.mHN = null;
        this.mJM = ((tv.chushou.basis.d.a.a.b) tv.chushou.basis.d.b.dRm().S(tv.chushou.basis.d.a.a.b.class)).createPlayer();
        this.mHN = ((tv.chushou.basis.d.a.a.b) tv.chushou.basis.d.b.dRm().S(tv.chushou.basis.d.a.a.b.class)).createPlayer();
    }

    public tv.chushou.common.player.a dER() {
        return this.mJM;
    }

    public tv.chushou.common.player.a dES() {
        return this.mHN;
    }

    public void c() {
        if (this.mJM != null) {
            this.mJM.release();
            this.mJM = null;
        }
        if (this.mHN != null) {
            this.mHN.release();
            this.mHN = null;
        }
    }
}
