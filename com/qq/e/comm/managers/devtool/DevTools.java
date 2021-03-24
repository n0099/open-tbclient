package com.qq.e.comm.managers.devtool;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes6.dex */
public class DevTools {

    /* renamed from: a  reason: collision with root package name */
    public String f38286a;

    public String getDemoGameUrl() {
        String str = this.f38286a;
        this.f38286a = null;
        return str;
    }

    public void testDemoGame(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context.getPackageName().equals("com.qq.e.union.demo.union")) {
            this.f38286a = str;
        }
    }
}
