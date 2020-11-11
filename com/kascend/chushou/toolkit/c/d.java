package com.kascend.chushou.toolkit.c;

import android.app.Application;
import com.kascend.cstvsdk.interfaces.ThirdParty;
/* loaded from: classes6.dex */
public class d implements tv.chushou.basis.d.a.a.b {
    @Override // tv.chushou.basis.d.a
    public void init(Application application) {
    }

    @Override // tv.chushou.basis.d.a.a.b
    public tv.chushou.common.player.a createPlayer() {
        return ((ThirdParty) tv.chushou.basis.d.b.eHq().S(ThirdParty.class)).createPlayer();
    }
}
