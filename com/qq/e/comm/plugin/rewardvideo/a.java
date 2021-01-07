package com.qq.e.comm.plugin.rewardvideo;

import android.content.Context;
import com.qq.e.mediation.interfaces.BaseRewardAd;
import java.lang.reflect.Constructor;
/* loaded from: classes4.dex */
class a {
    public static BaseRewardAd a(String str, Context context, String str2, String str3) throws Exception {
        Constructor declaredConstructor = Class.forName(str).asSubclass(BaseRewardAd.class).getDeclaredConstructor(Context.class, String.class, String.class);
        declaredConstructor.setAccessible(true);
        return (BaseRewardAd) declaredConstructor.newInstance(context, str2, str3);
    }
}
