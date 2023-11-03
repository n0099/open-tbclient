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
        l.a m256a = l.m256a(eVar);
        if (m256a == null || TextUtils.isEmpty(m256a.a) || TextUtils.isEmpty(m256a.b)) {
            return null;
        }
        return (AbstractPushManager) bj.a(m256a.a, m256a.b, context);
    }
}
