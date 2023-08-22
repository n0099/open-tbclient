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
        l.a m250a = l.m250a(eVar);
        if (m250a == null || TextUtils.isEmpty(m250a.a) || TextUtils.isEmpty(m250a.b)) {
            return null;
        }
        return (AbstractPushManager) bj.a(m250a.a, m250a.b, context);
    }
}
