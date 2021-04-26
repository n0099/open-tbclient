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
        l.a m122a = l.m122a(eVar);
        if (m122a == null || TextUtils.isEmpty(m122a.f38099a) || TextUtils.isEmpty(m122a.f38100b)) {
            return null;
        }
        return (AbstractPushManager) bh.a(m122a.f38099a, m122a.f38100b, context);
    }
}
