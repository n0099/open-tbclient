package com.qq.e.comm.managers.devtool;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes6.dex */
public class DevTools {

    /* renamed from: a  reason: collision with root package name */
    public String f38671a;

    public String getDemoGameUrl() {
        String str = this.f38671a;
        this.f38671a = null;
        return str;
    }

    public void testDemoGame(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context.getPackageName().equals("com.qq.e.union.demo.union")) {
            this.f38671a = str;
        }
    }
}
