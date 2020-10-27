package com.qiniu.android.utils;

import android.app.Application;
import android.content.Context;
/* loaded from: classes6.dex */
public final class ContextGetter {
    public static Context euo() {
        try {
            return eup().getApplicationContext();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Application eup() throws Exception {
        return (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null);
    }
}
