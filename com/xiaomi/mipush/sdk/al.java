package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.k;
import com.xiaomi.push.ba;
/* loaded from: classes18.dex */
public class al {
    public static AbstractPushManager a(Context context, d dVar) {
        return b(context, dVar);
    }

    private static AbstractPushManager b(Context context, d dVar) {
        k.a m109a = k.m109a(dVar);
        if (m109a == null || TextUtils.isEmpty(m109a.f4542a) || TextUtils.isEmpty(m109a.b)) {
            return null;
        }
        return (AbstractPushManager) ba.a(m109a.f4542a, m109a.b, context);
    }
}
