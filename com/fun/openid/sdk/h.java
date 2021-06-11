package com.fun.openid.sdk;

import android.content.Context;
import android.util.Log;
import com.fun.openid.sdk.e;
import com.fun.openid.sdk.f;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class h implements f {
    @Override // com.fun.openid.sdk.f
    public void a(Context context, f.a aVar) {
        String str = null;
        if (!((m.f30818b == null || m.f30817a == null) ? false : true)) {
            if (FunOpenIDSdk.isLogEnabled()) {
                Log.e(FunOpenIDSdk.TAG, "当前设备不支持获取OAID");
            }
            ((e.a) aVar).a(false, null);
            return;
        }
        Method method = m.f30819c;
        Object obj = m.f30817a;
        if (obj != null && method != null) {
            try {
                Object invoke = method.invoke(obj, context);
                if (invoke != null) {
                    str = (String) invoke;
                }
            } catch (Exception e2) {
                Log.e("IdentifierManager", "invoke exception!", e2);
            }
        }
        ((e.a) aVar).a(true, str);
    }
}
