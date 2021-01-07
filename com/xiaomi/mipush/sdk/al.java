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
        k.a m146a = k.m146a(dVar);
        if (m146a == null || TextUtils.isEmpty(m146a.f14131a) || TextUtils.isEmpty(m146a.f14132b)) {
            return null;
        }
        return (AbstractPushManager) ba.a(m146a.f14131a, m146a.f14132b, context);
    }
}
