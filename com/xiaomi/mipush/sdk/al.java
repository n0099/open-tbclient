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
        k.a m112a = k.m112a(dVar);
        if (m112a == null || TextUtils.isEmpty(m112a.a) || TextUtils.isEmpty(m112a.b)) {
            return null;
        }
        return (AbstractPushManager) ba.a(m112a.a, m112a.b, context);
    }
}
