package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.m;
/* loaded from: classes8.dex */
public class at {
    public static AbstractPushManager a(Context context, f fVar) {
        return b(context, fVar);
    }

    private static AbstractPushManager b(Context context, f fVar) {
        m.a m110a = m.m110a(fVar);
        if (m110a == null || TextUtils.isEmpty(m110a.a) || TextUtils.isEmpty(m110a.b)) {
            return null;
        }
        return (AbstractPushManager) com.xiaomi.push.at.a(m110a.a, m110a.b, context);
    }
}
