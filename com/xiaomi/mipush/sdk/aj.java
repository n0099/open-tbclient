package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.l;
import com.xiaomi.push.bh;
/* loaded from: classes7.dex */
public class aj {
    public static AbstractPushManager a(Context context, e eVar) {
        return b(context, eVar);
    }

    public static AbstractPushManager b(Context context, e eVar) {
        l.a m121a = l.m121a(eVar);
        if (m121a == null || TextUtils.isEmpty(m121a.f37344a) || TextUtils.isEmpty(m121a.f37345b)) {
            return null;
        }
        return (AbstractPushManager) bh.a(m121a.f37344a, m121a.f37345b, context);
    }
}
