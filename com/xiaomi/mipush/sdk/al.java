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
        k.a m114a = k.m114a(dVar);
        if (m114a == null || TextUtils.isEmpty(m114a.a) || TextUtils.isEmpty(m114a.b)) {
            return null;
        }
        return (AbstractPushManager) ba.a(m114a.a, m114a.b, context);
    }
}
