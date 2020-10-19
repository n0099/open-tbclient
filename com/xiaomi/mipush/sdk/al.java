package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.k;
import com.xiaomi.push.ba;
/* loaded from: classes12.dex */
public class al {
    public static AbstractPushManager a(Context context, d dVar) {
        return b(context, dVar);
    }

    private static AbstractPushManager b(Context context, d dVar) {
        k.a m117a = k.m117a(dVar);
        if (m117a == null || TextUtils.isEmpty(m117a.f4772a) || TextUtils.isEmpty(m117a.b)) {
            return null;
        }
        return (AbstractPushManager) ba.a(m117a.f4772a, m117a.b, context);
    }
}
