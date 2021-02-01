package com.qq.e.comm.plugin.splash;

import android.content.Context;
import com.qq.e.mediation.interfaces.BaseSplashAd;
import java.lang.reflect.Constructor;
/* loaded from: classes15.dex */
class a {
    public static BaseSplashAd a(String str, Context context, String str2, String str3) throws Exception {
        Constructor declaredConstructor = Class.forName(str).asSubclass(BaseSplashAd.class).getDeclaredConstructor(Context.class, String.class, String.class);
        declaredConstructor.setAccessible(true);
        return (BaseSplashAd) declaredConstructor.newInstance(context, str2, str3);
    }
}
