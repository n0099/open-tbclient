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
        l.a m253a = l.m253a(eVar);
        if (m253a == null || TextUtils.isEmpty(m253a.a) || TextUtils.isEmpty(m253a.b)) {
            return null;
        }
        return (AbstractPushManager) bj.a(m253a.a, m253a.b, context);
    }
}
