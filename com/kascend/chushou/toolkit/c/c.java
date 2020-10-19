package com.kascend.chushou.toolkit.c;

import android.app.Application;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
/* loaded from: classes6.dex */
public class c implements tv.chushou.basis.d.a.a.a {
    private final tv.chushou.basis.c.a owx = new tv.chushou.basis.c.b();

    @Override // tv.chushou.basis.d.a
    public void init(Application application) {
    }

    @Override // tv.chushou.basis.d.a.a.a
    public Object remove(String str) {
        return this.owx.remove(str);
    }

    @Override // tv.chushou.basis.d.a.a.a
    public void putString(@NonNull String str, String str2) {
        this.owx.putString(str, str2);
    }

    @Override // tv.chushou.basis.d.a.a.a
    @Nullable
    public String getString(@NonNull String str, String str2) {
        return this.owx.getString(str, str2);
    }
}
