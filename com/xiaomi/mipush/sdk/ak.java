package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.l;
import com.xiaomi.push.bj;
/* loaded from: classes8.dex */
public class ak {
    public static AbstractPushManager a(Context context, e eVar) {
        return b(context, eVar);
    }

    public static AbstractPushManager b(Context context, e eVar) {
        l.a m171a = l.m171a(eVar);
        if (m171a == null || TextUtils.isEmpty(m171a.a) || TextUtils.isEmpty(m171a.b)) {
            return null;
        }
        return (AbstractPushManager) bj.a(m171a.a, m171a.b, context);
    }
}
