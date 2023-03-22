package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.l;
import com.xiaomi.push.bj;
/* loaded from: classes8.dex */
public class ak {
    public static AbstractPushManager a(Context context, e eVar) {
        return b(context, eVar);
    }

    public static AbstractPushManager b(Context context, e eVar) {
        l.a m169a = l.m169a(eVar);
        if (m169a == null || TextUtils.isEmpty(m169a.a) || TextUtils.isEmpty(m169a.b)) {
            return null;
        }
        return (AbstractPushManager) bj.a(m169a.a, m169a.b, context);
    }
}
