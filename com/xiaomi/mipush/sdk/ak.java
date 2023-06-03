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
        l.a m245a = l.m245a(eVar);
        if (m245a == null || TextUtils.isEmpty(m245a.a) || TextUtils.isEmpty(m245a.b)) {
            return null;
        }
        return (AbstractPushManager) bj.a(m245a.a, m245a.b, context);
    }
}
