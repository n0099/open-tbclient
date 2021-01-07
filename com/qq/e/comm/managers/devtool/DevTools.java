package com.qq.e.comm.managers.devtool;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes4.dex */
public class DevTools {

    /* renamed from: a  reason: collision with root package name */
    private String f11847a;

    public String getDemoGameUrl() {
        String str = this.f11847a;
        this.f11847a = null;
        return str;
    }

    public void testDemoGame(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context.getPackageName().equals("com.qq.e.union.demo.union")) {
            this.f11847a = str;
        }
    }
}
