package com.kascend.chushou.toolkit.c;

import android.app.Application;
import kotlin.jvm.internal.q;
/* loaded from: classes4.dex */
public final class e implements tv.chushou.basis.d.a.b.e {
    @Override // tv.chushou.basis.d.a.b.e
    public String fn(String str, String str2) {
        String encrypt = tv.chushou.a.a.d.b.encrypt(q.I(str, str2));
        q.i(encrypt, "MD5Utils.encrypt(secret + text)");
        return encrypt;
    }

    @Override // tv.chushou.basis.d.a
    public void init(Application application) {
    }
}
