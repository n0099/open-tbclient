package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.k;
import com.xiaomi.push.ba;
/* loaded from: classes12.dex */
public class al {
    public static AbstractPushManager a(Context context, d dVar) {
        return b(context, dVar);
    }

    private static AbstractPushManager b(Context context, d dVar) {
        k.a m116a = k.m116a(dVar);
        if (m116a == null || TextUtils.isEmpty(m116a.f4770a) || TextUtils.isEmpty(m116a.b)) {
            return null;
        }
        return (AbstractPushManager) ba.a(m116a.f4770a, m116a.b, context);
    }
}
