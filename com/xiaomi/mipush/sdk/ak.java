package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.l;
import com.xiaomi.push.bj;
/* loaded from: classes10.dex */
public class ak {
    public static AbstractPushManager a(Context context, e eVar) {
        return b(context, eVar);
    }

    public static AbstractPushManager b(Context context, e eVar) {
        l.a m260a = l.m260a(eVar);
        if (m260a == null || TextUtils.isEmpty(m260a.a) || TextUtils.isEmpty(m260a.b)) {
            return null;
        }
        return (AbstractPushManager) bj.a(m260a.a, m260a.b, context);
    }
}
