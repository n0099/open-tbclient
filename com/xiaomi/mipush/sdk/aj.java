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
        l.a m115a = l.m115a(eVar);
        if (m115a == null || TextUtils.isEmpty(m115a.f40199a) || TextUtils.isEmpty(m115a.f40200b)) {
            return null;
        }
        return (AbstractPushManager) bh.a(m115a.f40199a, m115a.f40200b, context);
    }
}
