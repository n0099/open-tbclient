package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.k;
import com.xiaomi.push.ba;
/* loaded from: classes6.dex */
public class al {
    public static AbstractPushManager a(Context context, d dVar) {
        return b(context, dVar);
    }

    private static AbstractPushManager b(Context context, d dVar) {
        k.a m135a = k.m135a(dVar);
        if (m135a == null || TextUtils.isEmpty(m135a.f14130a) || TextUtils.isEmpty(m135a.f14131b)) {
            return null;
        }
        return (AbstractPushManager) ba.a(m135a.f14130a, m135a.f14131b, context);
    }
}
