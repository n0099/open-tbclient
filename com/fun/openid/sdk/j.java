package com.fun.openid.sdk;

import android.content.Context;
import android.util.Log;
import com.fun.openid.sdk.g;
import com.fun.openid.sdk.h;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class j implements h {
    @Override // com.fun.openid.sdk.h
    public void a(Context context, h.a aVar) {
        String str;
        Object invoke;
        if (!((o.b == null || o.f5248a == null) ? false : true)) {
            if (b.isLogEnabled()) {
                Log.e("FunOpenIDSdk", "当前设备不支持获取OAID");
            }
            ((g.a) aVar).a(false, null);
            return;
        }
        Method method = o.c;
        Object obj = o.f5248a;
        if (obj != null && method != null) {
            try {
                invoke = method.invoke(obj, context);
            } catch (Exception e) {
                Log.e("IdentifierManager", "invoke exception!", e);
            }
            if (invoke != null) {
                str = (String) invoke;
                ((g.a) aVar).a(true, str);
            }
        }
        str = null;
        ((g.a) aVar).a(true, str);
    }
}
