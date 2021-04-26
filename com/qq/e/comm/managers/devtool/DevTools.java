package com.qq.e.comm.managers.devtool;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes6.dex */
public class DevTools {

    /* renamed from: a  reason: collision with root package name */
    public String f36247a;

    public String getDemoGameUrl() {
        String str = this.f36247a;
        this.f36247a = null;
        return str;
    }

    public void testDemoGame(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context.getPackageName().equals("com.qq.e.union.demo.union")) {
            this.f36247a = str;
        }
    }
}
