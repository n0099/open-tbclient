package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.k;
import com.xiaomi.push.ba;
/* loaded from: classes8.dex */
public class al {
    public static AbstractPushManager a(Context context, d dVar) {
        return b(context, dVar);
    }

    private static AbstractPushManager b(Context context, d dVar) {
        k.a m113a = k.m113a(dVar);
        if (m113a == null || TextUtils.isEmpty(m113a.a) || TextUtils.isEmpty(m113a.b)) {
            return null;
        }
        return (AbstractPushManager) ba.a(m113a.a, m113a.b, context);
    }
}
