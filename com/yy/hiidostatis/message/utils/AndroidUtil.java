package com.yy.hiidostatis.message.utils;

import android.app.Application;
import android.content.Context;
/* loaded from: classes7.dex */
public class AndroidUtil {
    public static Context applicationContext(Context context) {
        return context instanceof Application ? context : context.getApplicationContext();
    }
}
