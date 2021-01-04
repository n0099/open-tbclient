package com.qq.e.comm.plugin.gdtnativead;

import android.content.Context;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.mediation.interfaces.BaseNativeExpressAd;
/* loaded from: classes3.dex */
class a {
    public static BaseNativeExpressAd a(String str, ADSize aDSize, Context context, String str2, String str3) throws Exception {
        return (BaseNativeExpressAd) Class.forName(str).asSubclass(BaseNativeExpressAd.class).getDeclaredConstructor(Context.class, ADSize.class, String.class, String.class).newInstance(context, aDSize, str2, str3);
    }
}
