package com.kascend.chushou.toolkit.c;

import android.app.Application;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes6.dex */
public final class e implements tv.chushou.basis.d.a.b.e {
    @Override // tv.chushou.basis.d.a.b.e
    public String fY(String str, String str2) {
        String encrypt = tv.chushou.a.a.d.b.encrypt(q.P(str, str2));
        q.l((Object) encrypt, "MD5Utils.encrypt(secret + text)");
        return encrypt;
    }

    @Override // tv.chushou.basis.d.a
    public void init(Application application) {
    }
}
