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
        m.a m105a = m.m105a(fVar);
        if (m105a == null || TextUtils.isEmpty(m105a.a) || TextUtils.isEmpty(m105a.b)) {
            return null;
        }
        return (AbstractPushManager) com.xiaomi.push.at.a(m105a.a, m105a.b, context);
    }
}
