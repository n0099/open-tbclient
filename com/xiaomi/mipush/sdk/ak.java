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
        l.a m251a = l.m251a(eVar);
        if (m251a == null || TextUtils.isEmpty(m251a.a) || TextUtils.isEmpty(m251a.b)) {
            return null;
        }
        return (AbstractPushManager) bj.a(m251a.a, m251a.b, context);
    }
}
