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
        l.a m190a = l.m190a(eVar);
        if (m190a == null || TextUtils.isEmpty(m190a.a) || TextUtils.isEmpty(m190a.b)) {
            return null;
        }
        return (AbstractPushManager) bj.a(m190a.a, m190a.b, context);
    }
}
