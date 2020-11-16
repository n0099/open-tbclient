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
        k.a m119a = k.m119a(dVar);
        if (m119a == null || TextUtils.isEmpty(m119a.f4772a) || TextUtils.isEmpty(m119a.b)) {
            return null;
        }
        return (AbstractPushManager) ba.a(m119a.f4772a, m119a.b, context);
    }
}
