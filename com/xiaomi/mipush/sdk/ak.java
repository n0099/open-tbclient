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
        l.a m167a = l.m167a(eVar);
        if (m167a == null || TextUtils.isEmpty(m167a.a) || TextUtils.isEmpty(m167a.b)) {
            return null;
        }
        return (AbstractPushManager) bj.a(m167a.a, m167a.b, context);
    }
}
