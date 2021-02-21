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
        k.a m141a = k.m141a(dVar);
        if (m141a == null || TextUtils.isEmpty(m141a.f13833a) || TextUtils.isEmpty(m141a.f13834b)) {
            return null;
        }
        return (AbstractPushManager) ba.a(m141a.f13833a, m141a.f13834b, context);
    }
}
