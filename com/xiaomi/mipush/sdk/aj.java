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
        l.a m119a = l.m119a(eVar);
        if (m119a == null || TextUtils.isEmpty(m119a.f40489a) || TextUtils.isEmpty(m119a.f40490b)) {
            return null;
        }
        return (AbstractPushManager) bh.a(m119a.f40489a, m119a.f40490b, context);
    }
}
