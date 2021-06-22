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
        l.a m120a = l.m120a(eVar);
        if (m120a == null || TextUtils.isEmpty(m120a.f41055a) || TextUtils.isEmpty(m120a.f41056b)) {
            return null;
        }
        return (AbstractPushManager) bh.a(m120a.f41055a, m120a.f41056b, context);
    }
}
