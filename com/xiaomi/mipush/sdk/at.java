package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.m;
/* loaded from: classes5.dex */
public class at {
    public static AbstractPushManager a(Context context, f fVar) {
        return b(context, fVar);
    }

    private static AbstractPushManager b(Context context, f fVar) {
        m.a m93a = m.m93a(fVar);
        if (m93a == null || TextUtils.isEmpty(m93a.a) || TextUtils.isEmpty(m93a.b)) {
            return null;
        }
        return (AbstractPushManager) com.xiaomi.push.at.a(m93a.a, m93a.b, context);
    }
}
