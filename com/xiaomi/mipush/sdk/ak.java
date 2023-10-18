package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.l;
import com.xiaomi.push.bj;
/* loaded from: classes10.dex */
public class ak {
    public static AbstractPushManager a(Context context, e eVar) {
        return b(context, eVar);
    }

    public static AbstractPushManager b(Context context, e eVar) {
        l.a m252a = l.m252a(eVar);
        if (m252a == null || TextUtils.isEmpty(m252a.a) || TextUtils.isEmpty(m252a.b)) {
            return null;
        }
        return (AbstractPushManager) bj.a(m252a.a, m252a.b, context);
    }
}
