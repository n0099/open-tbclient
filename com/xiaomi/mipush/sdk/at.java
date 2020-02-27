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
        m.a m107a = m.m107a(fVar);
        if (m107a == null || TextUtils.isEmpty(m107a.a) || TextUtils.isEmpty(m107a.b)) {
            return null;
        }
        return (AbstractPushManager) com.xiaomi.push.at.a(m107a.a, m107a.b, context);
    }
}
