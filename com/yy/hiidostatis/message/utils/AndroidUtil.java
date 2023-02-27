package com.yy.hiidostatis.message.utils;

import android.app.Application;
import android.content.Context;
/* loaded from: classes8.dex */
public class AndroidUtil {
    public static Context applicationContext(Context context) {
        if (!(context instanceof Application)) {
            return context.getApplicationContext();
        }
        return context;
    }
}
