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
        l.a m247a = l.m247a(eVar);
        if (m247a == null || TextUtils.isEmpty(m247a.a) || TextUtils.isEmpty(m247a.b)) {
            return null;
        }
        return (AbstractPushManager) bj.a(m247a.a, m247a.b, context);
    }
}
