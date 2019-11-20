package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.m;
/* loaded from: classes3.dex */
public class at {
    public static AbstractPushManager a(Context context, f fVar) {
        return b(context, fVar);
    }

    private static AbstractPushManager b(Context context, f fVar) {
        m.a m90a = m.m90a(fVar);
        if (m90a == null || TextUtils.isEmpty(m90a.a) || TextUtils.isEmpty(m90a.b)) {
            return null;
        }
        return (AbstractPushManager) com.xiaomi.push.at.a(m90a.a, m90a.b, context);
    }
}
