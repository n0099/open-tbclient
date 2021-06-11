package com.qq.e.comm.managers.devtool;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes7.dex */
public class DevTools {

    /* renamed from: a  reason: collision with root package name */
    public String f39100a;

    public String getDemoGameUrl() {
        String str = this.f39100a;
        this.f39100a = null;
        return str;
    }

    public void testDemoGame(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context.getPackageName().equals("com.qq.e.union.demo.union")) {
            this.f39100a = str;
        }
    }
}
