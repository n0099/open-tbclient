package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.m;
/* loaded from: classes6.dex */
public class at {
    public static AbstractPushManager a(Context context, f fVar) {
        return b(context, fVar);
    }

    private static AbstractPushManager b(Context context, f fVar) {
        m.a m102a = m.m102a(fVar);
        if (m102a == null || TextUtils.isEmpty(m102a.a) || TextUtils.isEmpty(m102a.b)) {
            return null;
        }
        return (AbstractPushManager) com.xiaomi.push.at.a(m102a.a, m102a.b, context);
    }
}
