package com.qq.e.comm.managers.devtool;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes7.dex */
public class DevTools {

    /* renamed from: a  reason: collision with root package name */
    public String f35421a;

    public String getDemoGameUrl() {
        String str = this.f35421a;
        this.f35421a = null;
        return str;
    }

    public void testDemoGame(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context.getPackageName().equals("com.qq.e.union.demo.union")) {
            this.f35421a = str;
        }
    }
}
