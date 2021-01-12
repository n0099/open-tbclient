package com.qq.e.comm.plugin.h.a;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.qq.e.comm.plugin.util.o;
import com.qq.e.comm.util.Md5Util;
/* loaded from: classes3.dex */
public class f extends b {
    @Override // com.qq.e.comm.plugin.h.a
    public String a(Context context) {
        String b2 = b(context);
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        return Md5Util.encode(b2.toLowerCase());
    }

    @Override // com.qq.e.comm.plugin.h.a.b
    protected boolean a() {
        return o.n();
    }

    @Override // com.qq.e.comm.plugin.h.a.b
    protected String c(Context context) {
        String str;
        if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            str = telephonyManager != null ? telephonyManager.getDeviceId() : null;
        } catch (Exception e) {
            str = null;
        }
        return str;
    }
}
