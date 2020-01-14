package com.kascend.chushou.player;
/* loaded from: classes4.dex */
public class c {
    private static c mQC = null;
    private tv.chushou.common.player.a mOD;
    private tv.chushou.common.player.a mQB;

    public c() {
        this.mQB = null;
        this.mOD = null;
        this.mQB = ((tv.chushou.basis.d.a.a.b) tv.chushou.basis.d.b.dOG().T(tv.chushou.basis.d.a.a.b.class)).createPlayer();
        this.mOD = ((tv.chushou.basis.d.a.a.b) tv.chushou.basis.d.b.dOG().T(tv.chushou.basis.d.a.a.b.class)).createPlayer();
    }

    public tv.chushou.common.player.a dBA() {
        return this.mQB;
    }

    public tv.chushou.common.player.a dBB() {
        return this.mOD;
    }

    public void c() {
        if (this.mQB != null) {
            this.mQB.release();
            this.mQB = null;
        }
        if (this.mOD != null) {
            this.mOD.release();
            this.mOD = null;
        }
    }
}
