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
        l.a m248a = l.m248a(eVar);
        if (m248a == null || TextUtils.isEmpty(m248a.a) || TextUtils.isEmpty(m248a.b)) {
            return null;
        }
        return (AbstractPushManager) bj.a(m248a.a, m248a.b, context);
    }
}
